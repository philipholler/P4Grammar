grammar Pivot;
program : decls;

decls : define* declVar* init? (func | event)* EOF;

    define : DEFINEKW (signal | device) SEMCOL;

    signal: SIGNALKW signalID COL (range | togglevalues) ;

        signalID: ID;

    device: DEVICE deviceID ((inputs? (AMP outputs)?) | (outputs? (AMP inputs)?)); // The order of output and input can be switched around. That doesn't matter.

    init : INITFUNCKW PARANBEG PARANEND block; // Placeholder init main method

    func : (type | VOID) ID PARANBEG fParams PARANEND block; // Placeholder functions

    fParams : (param (LISTSEP param)*)?;

    param : type ID;

    event: (atomEvent | repeatEvent); // Placeholder events

atomEvent : WHEN deviceID signalID COL (toggleID | EXCEEDS INTEGER| DECEEDS INTEGER) block
          | WHEN DATE AT TIME block
          | WHEN TIME block
          ;

repeatEvent : EVERY timeVal (MONTHS | WEEKS | DAYS | HOURS | MINUTES | SECONDS) block
            | EVERY timeVal (MONTHS | WEEKS | DAYS | HOURS | MINUTES | SECONDS) AT time (STARTING DATE)? block
            ;

inputs: INPUTKW COL input (LISTSEP input)*;

    input: inputID;

    inputID: ID;

outputs: OUTPUTKW COL output (LISTSEP output)*;

    output: outputID;

    outputID: ID;

deviceID : ID;

ip : STRING;

varID : ID;

block: BLCKBEG stmts BLCKEND;

rtn : (RETURN (varID | litVal)? SEMCOL);

ifstmt: IF PARANBEG logical_expr PARANEND block (ELSE block)?;

stmts: (wait | assignment | ifstmt | whilestmt | funcCall SEMCOL | declVar | rtn | brk)*; // Not finished

brk: BREAK SEMCOL;

declVar: (type varID EQUALS (litVal | expr) | deviceID varID EQUALS ip) SEMCOL;

funcCall: ID PARANBEG inputParam PARANEND
        | SET deviceID signalID COL (toggleID | litVal)
        | GET deviceID signalID
        ;

inputParam: (ID | litVal)? (LISTSEP (ID | litVal))*;

litVal: INTEGER #intLitVal
      | FLOAT #floatLitVal
      | STRING #stringLitVal
      ;

wait: WAIT timeVal (DAYS | HOURS | MINUTES | SECONDS | MS) SEMCOL
    | WAIT varID (DAYS | HOURS | MINUTES | SECONDS | MS) SEMCOL
    ;

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
                   | date
                   | expr
                   ;

time : TIME;
date : DATE
     | DATEnoYEAR
     ;

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

type: (STRINGKW | INTEGERKW | FLOATKW );

/*
 * Signal values
 */
range : lowerBound RANGESEP upperBound;
lowerBound : INTEGER  #intLB
           | FLOAT  #floatLB
           ;
upperBound : INTEGER #intUP
           | FLOAT #floatUP
           ;

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

AND : '&&';
OR : '||';
GT : '>' ;
GE : '>=' ;
LT : '<' ;
LE : '<=' ;
EQ : '==' ;
NE : '!=' ;

// Keywords
TRUE : 'true';
FALSE : 'false';
SIGNALKW : 'Signal';
INPUTKW : 'input';
OUTPUTKW : 'output';
DEVICE : 'Device';
DEFINEKW : 'define';
IF : 'if';
WHILE : 'while';
INITFUNCKW : 'init';
VOID : 'void';
WHEN : 'when';
EVERY : 'every';
MS : 'ms';
SECONDS : 'seconds';
MINUTES : 'minutes';
HOURS : 'hours';
DAYS : 'days';
WEEKS : 'weeks';
MONTHS : 'months';
WAIT : 'wait';
STRINGKW : 'string';
INTEGERKW : 'int';
FLOATKW : 'float';
SET : 'set';
GET : 'get';
EXCEEDS : 'exceeds';
DECEEDS : 'deceeds';
NOW : 'now';
ELSE : 'else';
RETURN : 'return';
BREAK : 'break';
AT : 'at';

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
AMP : '&';
STARTING: 'starting';

DATE: DIGIT DIGIT 'd' DIGIT DIGIT 'm' DIGIT DIGIT DIGIT DIGIT 'y';
DATEnoYEAR: DIGIT DIGIT 'd' DIGIT DIGIT 'm';
FLOAT: '-'? DIGIT+ '.' DIGIT+;
TIME: DIGIT DIGIT COL DIGIT DIGIT;
IP: DIGIT+ ('.' DIGIT+)+ ':' DIGIT+; // Had to make it a bit wonky, otherwise is was equivalent to the REANGESEP.
INTEGER: '-'? DIGIT+;
STRING: '"' (LOWERCASE | UPPERCASE | SIGN | DIGIT)+ '"';
ID: (LOWERCASE | UPPERCASE) (LOWERCASE| UPPERCASE| DIGIT)*;
SIGN: ('_' | '-' | '!' | ' ' | '.' | ':');