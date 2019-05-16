grammar Pivot;
program : decls EOF;

decls : defs=define* (vars=declVar | devVars=declDevice)* inFunc=init? (funcDecl | event)*;

define : DEFINEKW (signal | device) SEMCOL;

signal: SIGNAL ID COL (range | enumerations);

    enumerations : enumeration (LISTSEP enumeration)*;
    enumeration  : ID EQUALS enumVal=litVal;

    // Signal values
    range : lowerBound RANGESEP upperBound;

    lowerBound : INTEGER #intlwRange
               | FLOAT   #floatlwRange
               ;
    upperBound : INTEGER #intupRange
               | FLOAT   #floatupRange
               ;

device: DEVICE ID (inputs? outputs? | outputs? inputs?); // The order of output and input can be switched around. That doesn't matter.

    // Inputs and outputs
    inputs : INPUT COL input=ID (LISTSEP input=ID)*;

    outputs: OUTPUT COL output=ID (LISTSEP output=ID)*;

declDevice: devType=ID varID=ID EQUALS val=STRING SEMCOL;

init : INITFUNCKW PARANBEG PARANEND block;

funcDecl : (varType | VOID) id=ID PARANBEG params=fParams PARANEND block; // Function declaration

    fParams : (param (LISTSEP param)*)?;
    param   : varType localID=ID;

event: (atomEvent | repeatEvent);

atomEvent : WHEN deviceID=ID signalID=ID (enumID=ID | (EXCEEDS | DECEEDS) number) block     #inputWhenEvent
          | WHEN timeAndDate block                                                          #timeWhenEvent
          // when 18:00 21d03m2019y // when 14:00 // when 21d03m2019y
          ;

number : INTEGER
       | FLOAT
       ;

repeatEvent : EVERY INTEGER timeFrame block
            | EVERY INTEGER timeFrame STARTING timeAndDate block
            ;

timeAndDate : TIME (DATEnoYEARnoMonth | DATEnoYEAR | DATE)
            | TIME
            | (DATEnoYEARnoMonth | DATEnoYEAR | DATE)
            ;

timeFrame: (MONTHS | WEEKS | DAYS | HOURS | MINUTES | SECONDS | MS);

block: BLCKBEG stmts BLCKEND;

// The SEMCOL after the funcCall has to be there in the stmts, since it will not be needed if the funcCall is used in a variable decl.
stmts: (waitStmt | assignment | ifstmt | whilestmt | funcCall SEMCOL | printStmt | declVar | rtn)*;

printStmt: PRINT expr SEMCOL;

waitStmt: WAIT expr timeFrame SEMCOL;

assignment : varID=ID EQUALS expr SEMCOL;

ifstmt: IF PARANBEG logical_expr PARANEND blck=block (ELSE elseblck=block)?;

whilestmt: WHILE PARANBEG logical_expr PARANEND block;

funcCall: id=ID PARANBEG arguments PARANEND                         #funCall
        //exprVal can also be an IDNode of a signal literal. This is done, since expr with ID Atom and regular ID cannot be distinguished.
        | SET deviceID=ID signalID=ID exprVal=expr                  #setFun
        | GET (INPUT | OUTPUT)? deviceID=ID signalID=ID             #getFun
        ;

    arguments: expr? (LISTSEP expr)*;

declVar: varType ID EQUALS expr SEMCOL;

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
            ;

comparison_expr : left=comparison_operand op=comp_operator right=comparison_operand  #comparisonExpressionWithOperator
                | PARANBEG comparison_expr PARANEND                                  #comparisonExpressionParens
                ;

comparison_operand : TIME                                       #compOperandTime
                   | (DATE | DATEnoYEAR | DATEnoYEARnoMonth)    #comOperandDate
                   | expr                                       #comOperandExpr
                   ;

comp_operator : GT // Greater than
              | GE // Greater than or equal to
              | ST // Smaller than
              | SE // Smaller than or equal to
              | EQ // Equal to
              | NE // Not equal
              ;

atom : litVal
     | varID=ID
     | NOW
     ;

varType: (STRINGKW | INTEGERKW | FLOATKW );

/*
 * Lexer Rules
 */

WhiteSpace : (' '|'\t') -> skip; // Skip whitespaces
NewLine : NEWLINE -> skip; // Skip newlines
LINE_COMMENT : '//' ~[\r\n]* -> skip; // Skip comments

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
DATEnoYEARnoMonth: DIGIT DIGIT 'd';
FLOAT: '-'? DIGIT+ '.' DIGIT+;
TIME: DIGIT DIGIT COL DIGIT DIGIT;
INTEGER: '-'? DIGIT+;
STRING: '"' (LOWERCASE | UPPERCASE | SIGN | DIGIT )* '"';
ID: (LOWERCASE | UPPERCASE) (LOWERCASE| UPPERCASE| DIGIT)*;
SIGN: ('_' | '-' | '!' | ' ' | '.' | ':' | '+' | '/' | '=');