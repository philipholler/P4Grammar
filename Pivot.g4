grammar Pivot;
program : decls EOF;

decls : defs=define* (vars=declVar | devVars=declDevice)* inFunc=init? (funcDecl | event)*;

define : DEFINEKW (signal | device) SEMCOL;

signal: SIGNAL SIGNAL_ID COL (range | enumerations);

    enumerations : enumeration (LISTSEP enumeration)*;
    enumeration  : SIGNAL_ID EQUALS enumVal=litVal;

    // Signal values
    range : lowerBound RANGESEP upperBound;

    lowerBound : INTEGER #intlwRange
               | FLOAT   #floatlwRange
               ;
    upperBound : INTEGER #intupRange
               | FLOAT   #floatupRange
               ;

device: DEVICE SIGNAL_ID ((inputs? (AMP outputs)?) | (outputs? (AMP inputs)?)); // The order of output and input can be switched around. That doesn't matter.

    // Inputs and outputs
    inputs : INPUT COL input=SIGNAL_ID (LISTSEP input=SIGNAL_ID)*;

    outputs: OUTPUT COL output=SIGNAL_ID (LISTSEP output=SIGNAL_ID)*;

declDevice: devType=SIGNAL_ID varID=SIGNAL_ID EQUALS val=STRING SEMCOL;

init : INITFUNCKW PARANBEG PARANEND block;

funcDecl : (varType | VOID) id=SIGNAL_ID PARANBEG params=fParams PARANEND block; // Function declaration

    fParams : (param (LISTSEP param)*)?;
    param   : varType localID=SIGNAL_ID;

event: (atomEvent | repeatEvent);

atomEvent : WHEN deviceID=SIGNAL_ID signalID=SIGNAL_ID COL (enumID=SIGNAL_ID | EXCEEDS expr| DECEEDS expr) block #inputWhenEvent
          | WHEN timeAndDate block                                                          #timeWhenEvent
          // when 18:00 21d03m2019y // when 14:00 // when 21d03m2019y
          ;

repeatEvent : EVERY expr timeFrame block
            | EVERY expr timeFrame STARTING timeAndDate block
            ;

timeAndDate : TIME (DATE | DATEnoYEAR)
            | TIME
            | (DATE | DATEnoYEAR)
            ;

timeFrame: (MONTHS | WEEKS | DAYS | HOURS | MINUTES | SECONDS | MS);

block: BLCKBEG stmts BLCKEND;

stmts: (waitStmt | assignment | ifstmt | whilestmt | funcCall SEMCOL | printStmt | declVar | brk | rtn)*; // Not finished

printStmt: PRINT expr;

waitStmt: WAIT expr timeFrame SEMCOL;

assignment : varID=SIGNAL_ID EQUALS expr SEMCOL;

ifstmt: IF PARANBEG logical_expr PARANEND blck=block (ELSE elseblck=block)?;

whilestmt: WHILE PARANBEG logical_expr PARANEND block;

funcCall: id=SIGNAL_ID PARANBEG arguments PARANEND                     #funCall
        | SET deviceID=SIGNAL_ID signalID=SIGNAL_ID COL expr                  #setFun
        | GET deviceID=SIGNAL_ID signalID=SIGNAL_ID                           #getFun
        ;

    arguments: expr? (LISTSEP expr)*;

declVar: varType SIGNAL_ID EQUALS expr SEMCOL;

brk: BREAK SEMCOL;

rtn : (RETURN expr? SEMCOL);

litVal: INTEGER #intVal
      | FLOAT   #floatVal
      | STRING  #stringVal
      ;

// Expressions
expr: leftChild=expr op=(DIV | MULT) rightChild=expr     #multiExpr
    | leftChild=expr op=(PLUS | MINUS) rightChild=expr   #plusExpr
    | PARANBEG expr PARANEND                             #paranExpr
    | atom                                               #atomExpr
    | funcCall                                           #funCallExpr
    ;

logical_expr
            : left=logical_expr AND right=logical_expr     #logicalExpressionAnd
            | left=logical_expr OR right=logical_expr      #logicalExpressionOr
            | comparison_expr                              #comparisonExpression
            | PARANBEG logical_expr PARANEND               #logicalExpressionInParen
            | (TRUE | FALSE)                               #logicalLiterals
            ;

comparison_expr : left=comparison_operand op=comp_operator right=comparison_operand  #comparisonExpressionWithOperator
                | PARANBEG comparison_expr PARANEND                                  #comparisonExpressionParens
                ;

comparison_operand : TIME                   #compOperandTime
                   | (DATE | DATEnoYEAR)    #comOperandDate
                   | expr                   #comOperandExpr
                   ;

comp_operator : GT // Greater than
              | GE // Greater than or equal to
              | ST // Smaller than
              | SE // Smaller than or equal to
              | EQ // Equal to
              | NE // Not equal
              ;

atom : litVal
     | varID=SIGNAL_ID
     | NOW
     ;

varType: (STRINGKW | INTEGERKW | FLOATKW );

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
ST : '<' ;
SE : '<=' ;
EQ : '==' ;
NE : '!=' ;

// Keywords
TRUE : 'true';
FALSE : 'false';
SIGNAL : 'Signal';
INPUT : 'input';
OUTPUT : 'output';
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
STARTING: 'starting';
PRINT : 'print';

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

// Primitives
DATE: DIGIT DIGIT 'd' DIGIT DIGIT 'm' DIGIT DIGIT DIGIT DIGIT 'y';
DATEnoYEAR: DIGIT DIGIT 'd' DIGIT DIGIT 'm';
FLOAT: '-'? DIGIT+ '.' DIGIT+;
TIME: DIGIT DIGIT COL DIGIT DIGIT;
INTEGER: '-'? DIGIT+;
STRING: '"' (LOWERCASE | UPPERCASE | SIGN | DIGIT)+ '"';
SIGNAL_ID: (LOWERCASE | UPPERCASE) (LOWERCASE| UPPERCASE| DIGIT)*;
SIGN: ('_' | '-' | '!' | ' ' | '.' | ':');