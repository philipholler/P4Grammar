grammar Pivot;
program : decls;

decls : define* inst* init (func | event)*;

    define : DEFINEKW (signal | device) SEMCOL;

    signal: SIGNALKW signalID ':' (range | togglevalues) ;

        signalID: ID;

    device: DEVICE deviceID ((inputs? ('&' outputs?)?) | (outputs? ('&' inputs?)?)); // The order of output and input can be switched around. That doesn't matter.

    inst : deviceID varID EQUALS ip SEMCOL;

    init : initReturnValue INITFUNCKW PARANBEG PARANEND block; // Placeholder init main method

    func : (STRINGKW | INTEGERKW | FLOATKW | VOID) ID PARANBEG param? (LISTSEP param)* PARANEND block; // Placeholder functions

    param : (STRINGKW | INTEGERKW | FLOATKW | VOID) ID;

    event: (atomEvent | repeatEvent); // Placeholder events

atomEvent : WHEN ID ID ':' toggleID block;

repeatEvent : EVERY ID ID ':' toggleID block;

initReturnValue : VOID ;

inputs: INPUTKW ':' input (LISTSEP input)*;

    input: ID;

outputs: OUTPUTKW ':' output (LISTSEP output)*;

    output: ID;

deviceID : ID;

ip : IP;

varID : ID;

block: BLCKBEG stmts BLCKEND;

ifstmt: IF PARANBEG logical_expr PARANEND block;

stmts: (wait | assignment | ifstmt | whilestmt | everystmt)* ; // Not finished

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
    ;


logical_expr
 : logical_expr AND logical_expr # LogicalExpressionAnd
 | logical_expr OR logical_expr  # LogicalExpressionOr
 | comparison_expr               # ComparisonExpression
 | PARANBEG logical_expr PARANEND   # LogicalExpressionInParen
 | (TRUE | FALSE)                  # LogicalLiterals
 ;

comparison_expr : comparison_operand comp_operator comparison_operand  #ComparisonExpressionWithOperator
                | PARANBEG comparison_expr PARANEND                        #ComparisonExpressionParens
                ;

comparison_operand : expr
                   ;

comp_operator : GT
              | GE
              | LT
              | LE
              | EQ
              ;

atom : (ID | INTEGER);

/*
 * Signal values
 */
range : lowerBound RANGESEP upperBound;
lowerBound : INTEGER;
upperBound : INTEGER;

togglevalues : togglevalue (LISTSEP togglevalue)*;
togglevalue : toggleID EQUALS toggleVal;
toggleID : ID;
toggleVal : ( STRING | INTEGER);



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

INTEGER: DIGIT+;
ID: (LOWERCASE | UPPERCASE) (LOWERCASE| UPPERCASE| DIGIT)*;
IP:  ((DIGIT)+ '.' DIGIT+)+ ':' DIGIT+; // Had to make it a bit wonky, otherwise is was equivalent to the REANGESEP.