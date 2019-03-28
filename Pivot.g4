grammar Pivot;
program : decls;

decls : defs=define* (vars=declVar | devVars=declDevice)* inFunc=init? (funcDecl | event)* EOF;

define : DEFINEKW (signal | device) SEMCOL;

signal: SIGNAL ID COL (range | enumerations);

    enumerations : enumeration (LISTSEP enumeration)*;
    enumeration  : ID EQUALS enumVal=litVal;

    // Signal values
    range : lowerBound RANGESEP upperBound;

    lowerBound : INTEGER    #intLB
               | FLOAT      #floatLB
               ;
    upperBound : INTEGER    #intUP
               | FLOAT      #floatUP
               ;

device: DEVICE ID ((inputs? (AMP outputs)?) | (outputs? (AMP inputs)?)); // The order of output and input can be switched around. That doesn't matter.

    // Inputs and outputs
    inputs : INPUT COL input=ID (LISTSEP input=ID)*;

    outputs: OUTPUT COL output=ID (LISTSEP output=ID)*;

declDevice: devType=ID varID=ID EQUALS val=STRING SEMCOL;

init : INITFUNCKW PARANBEG PARANEND block;

funcDecl : (varType | VOID) ID PARANBEG fParams PARANEND block; // Function declaration

    fParams : (param (LISTSEP param)*)?;
    param   : varType localID=ID;

event: (atomEvent | repeatEvent);

atomEvent : WHEN deviceID=ID signalID=ID COL (enumID=ID | EXCEEDS INTEGER| DECEEDS INTEGER) block
          | WHEN DATE AT TIME block
          | WHEN TIME block
          ;

repeatEvent : EVERY INTEGER timeFrame block
            | EVERY INTEGER timeFrame AT TIME (STARTING DATE)? block
            ;

timeFrame: (MONTHS | WEEKS | DAYS | HOURS | MINUTES | SECONDS | MS);

block: BLCKBEG stmts BLCKEND;

stmts: (waitStmt | assignment | ifstmt | whilestmt | funcCall SEMCOL | declVar | brk | rtn)*; // Not finished

waitStmt: WAIT INTEGER timeFrame SEMCOL
        | WAIT varID=ID timeFrame SEMCOL
        ;

assignment : varID=ID EQUALS expr SEMCOL;

ifstmt: IF PARANBEG logical_expr PARANEND block (ELSE block)?;

whilestmt: WHILE PARANBEG logical_expr PARANEND block;

funcCall: ID PARANBEG inputParam PARANEND
        | SET deviceID=ID signalID=ID COL (enumID=ID | litVal)
        | GET deviceID=ID signalID=ID
        ;

    inputParam: (ID | litVal)? (LISTSEP (varID=ID | litVal))*;

declVar: varType varID=ID EQUALS (litVal | expr) SEMCOL;

brk: BREAK SEMCOL;

rtn : (RETURN (varID=ID | litVal)? SEMCOL);

litVal: INTEGER #intVal
      | FLOAT   #floatVal
      | STRING  #stringVal
      ;

// Expressions
expr
    : expr (DIV | MULT) expr          #multiexpr // Div & mult precendences before plus & minus
    | expr (PLUS | MINUS) expr        #addexpr
    | PARANBEG expr PARANEND          #paranexpr
    | atom                            #atomexpr
    | funcCall                        #funcexpr
    ;

logical_expr
            : logical_expr AND logical_expr     # logicalExpressionAnd
            | logical_expr OR logical_expr      # logicalExpressionOr
            | comparison_expr                   # comparisonExpression
            | PARANBEG logical_expr PARANEND    # logicalExpressionInParen
            | (TRUE | FALSE)                    # logicalLiterals
            ;

comparison_expr : comparison_operand comp_operator comparison_operand  #comparisonExpressionWithOperator
                | PARANBEG comparison_expr PARANEND                    #comparisonExpressionParens
                ;

comparison_operand : TIME                #timeOp
                   | (DATE | DATEnoYEAR) #dateOp
                   | expr                #exprOP
                   ;

comp_operator : GT // Greater than
              | GE // Greater than or equal to
              | ST // Smaller than
              | SE // Smaller than or equal to
              | EQ // Equal to
              | NE // Not equal
              ;

atom :litVal       #litValue
     | varID=ID     #varidAtom
     | NOW          #nowAtom
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
AT : 'at';
STARTING: 'starting';

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
ID: (LOWERCASE | UPPERCASE) (LOWERCASE| UPPERCASE| DIGIT)*;
SIGN: ('_' | '-' | '!' | ' ' | '.' | ':');