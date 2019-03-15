grammar Pivot;
program : decls;

decls : define* (inst | declVar)* init? (func | event)* EOF;

    define : DEFINEKW (signal | device) SEMCOL;

    signal: SIGNALKW signalID COL (range | togglevalues) ;

        signalID: ID;

    device: DEVICE deviceID ((inputs? ('&' outputs)?) | (outputs? ('&' inputs)?)); // The order of output and input can be switched around. That doesn't matter.

    inst : deviceID varID EQUALS ip SEMCOL;

    init : initReturnValue INITFUNCKW PARANBEG PARANEND block; // Placeholder init main method

    func : (STRINGKW | INTEGERKW | FLOATKW | VOID) ID PARANBEG fParams PARANEND block; // Placeholder functions

    fParams : (param (LISTSEP param)*)?;

    param : (STRINGKW | INTEGERKW | FLOATKW | VOID) ID;

    event: (atomEvent | repeatEvent); // Placeholder events

atomEvent : WHEN deviceID signalID COL (toggleID | EXCEEDS INTEGER| DECEEDS INTEGER) block;

repeatEvent : EVERY timeVal (DAYS | HOURS | MINUTES | SECONDS) block;

initReturnValue : VOID ;

inputs: INPUTKW COL input (LISTSEP input)*;

    input: ID;

outputs: OUTPUTKW COL output (LISTSEP output)*;

    output: ID;

deviceID : ID;

ip : IP;

varID : ID;

block: BLCKBEG stmts BLCKEND;

ifstmt: IF PARANBEG logical_expr PARANEND block;

stmts: (wait | assignment | ifstmt | whilestmt | everystmt | funcCall SEMCOL | declVar)* ; // Not finished

declVar: type ID EQUALS ((FLOAT |ID | INTEGER ) | expr) SEMCOL;

funcCall: ID PARANBEG inputParam PARANEND
        | SET deviceID signalID COL toggleID
        | GET deviceID signalID
        ;

inputParam: (ID | INTEGER)? (LISTSEP (ID | INTEGER))*;

wait: WAIT timeVal (DAYS | HOURS | MINUTES | SECONDS) SEMCOL;

everystmt: EVERY timeVal (DAYS | HOURS | MINUTES | SECONDS) block;

timeVal: INTEGER;

whilestmt: WHILE PARANBEG logical_expr PARANEND block;

assignment : ID EQUALS expr SEMCOL;

expr
    : expr (DIV | MULT) expr          #multiexpr // Div & mult precendences before plus & minus
    | expr (PLUS | MINUS) expr        #addexpr
    | PARANBEG expr PARANEND          #paranexpr
    | atom                            #atomexpr
    | funcCall                        #funcexpr
    ;


logical_expr
 : logical_expr AND logical_expr # logicalExpressionAnd
 | logical_expr OR logical_expr  # logicalExpressionOr
 | comparison_expr               # comparisonExpression
 | PARANBEG logical_expr PARANEND   # logicalExpressionInParen
 | (TRUE | FALSE)                  # logicalLiterals
 ;

comparison_expr : comparison_operand comp_operator comparison_operand  #ComparisonExpressionWithOperator
                | PARANBEG comparison_expr PARANEND                        #ComparisonExpressionParens
                ;

comparison_operand : time
                   | expr
                   ;

time : TIME;

comp_operator : GT
              | GE
              | LT
              | LE
              | EQ
              | NE
              ;

atom :INTEGER #intAtom
    | FLOAT   #floatAtom
    | STRING #stringAtom
    | ID     #varidAtom
    | NOW    #nowAtom
    ;

type: (STRINGKW | INTEGERKW | FLOATKW | VOID);

/*
 * Signal values
 */
range : lowerBound RANGESEP upperBound;
lowerBound : INTEGER;
upperBound : INTEGER;

togglevalues : togglevalue (LISTSEP togglevalue)*;
togglevalue : toggleID EQUALS toggleVal;
toggleID : ID;
toggleVal : STRING  #stringVal
          | INTEGER #integerVal
          | FLOAT   #floatVal
          ;



/*
 * Lexer Rules
 */

WhiteSpace : (' '|'\t') -> skip; // Skip whitespaces
NewLine : NEWLINE -> skip; // Skip newlines
LINE_COMMENT : '//' ~[\r\n]* -> skip ; // Skip comments

fragment NEWLINE:  ('\r'?'\n'|'\r');
fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;
fragment DIGIT     : [0-9] ;

/*
 * Terminal tokens
 */

TRUE : 'true';
FALSE : 'false';
AND : '&&';
OR : '||';
GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
EQ : '==' ;
NE : '!=' ;

// Keywords
SIGNALKW : 'Signal';
INPUTKW : 'input';
OUTPUTKW : 'output';
DEVICE : 'Device';
DEFINEKW : '#define';
IF : 'if';
WHILE : 'while';
INITFUNCKW : 'init';
VOID : 'void';
WHEN : 'when';
EVERY : 'every';
SECONDS : 'seconds';
MINUTES : 'minutes';
HOURS : 'hours';
DAYS : 'days';
WAIT : 'wait';
STRINGKW : 'string';
INTEGERKW : 'int';
FLOATKW : 'float';
SET : 'set';
GET : 'get';
EXCEEDS : 'exceeds';
DECEEDS : 'deceeds';
NOW : 'now';

// Signs
PARANBEG : '(';
PARANEND : ')';
BLCKBEG : '{';
BLCKEND : '}';
EQUALS : '=';
PLUS : '+';
MINUS : '-';
DIV : '/';
MULT : '*';
RANGESEP: '..';
SEMCOL : ';';
LISTSEP : ',';
QUOT : '"';
COL: ':';

FLOAT: DIGIT+ '.' DIGIT+;
TIME: DIGIT DIGIT COL DIGIT DIGIT;
IP: DIGIT+ ('.' DIGIT+)+ ':' DIGIT+; // Had to make it a bit wonky, otherwise is was equivalent to the REANGESEP.
INTEGER: DIGIT+;
STRING: '"' ID '"';
ID: (LOWERCASE | UPPERCASE) (LOWERCASE| UPPERCASE| DIGIT)*;
