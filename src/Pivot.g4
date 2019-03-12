grammar Pivot;
program : decls;

decls : define* inst* init (func | event)*;

    define : DEFINEKW (signal | device) END;

    signal: SIGNALKW signalID ':' (range | togglevalues) ;

        signalID: ID;

    device: DEVICE deviceID ((inputs? ('&' outputs?)?) | (outputs? ('&' inputs?)?)); // The order of output and input can be switched around. That doesn't matter.

    inst : deviceID varID EQUALS ip END;

    init : initReturnValue INITFUNCKW PARANBEG PARANEND block; // Placeholder init main method

    func : 'func' END; // Placeholder functions

    event: 'event' END; // Placeholder events

initReturnValue : VOID ;

inputs: INPUTKW ':' input (LISTSEP input)*;

    input: ID;

outputs: OUTPUTKW ':' output (LISTSEP output)*;

    output: ID;

deviceID : ID;

ip : IP;

varID : ID;

block: BLCKBEG stat BLCKEND;

ifstmt: IF PARANBEG logical_expr PARANEND block;

stat: assignment* ifstmt* whilestmt*;

whilestmt: WHILE PARANBEG logical_expr PARANEND block;

assignment : ID EQUALS expr END;

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

atom : (ID | SINTEGER);

/*
 * Signal values
 */
range : lowerBound RANGESEP upperBound;
lowerBound : SINTEGER;
upperBound : SINTEGER;

togglevalues : togglevalue (LISTSEP togglevalue)*;
togglevalue : toggleID EQUALS toggleVal;
toggleID : ID;
toggleVal : ( STRING | SINTEGER);



/*
 * Lexer Rules
 */

WhiteSpace : (' '|'\t') -> skip; // Skip whitespaces
NewLine : NEWLINE -> skip; // Skip newlines
LINE_COMMENT : '//' ~[\r\n]* -> skip ; // Skip comments

fragment NEWLINE:  ('\r'?'\n'|'\r');
fragment LOWERCASE  : [a-z] ;
fragment UPPERCASE  : [A-Z] ;
fragment NUMBER     : [0-9] ;

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
END : ';';
LISTSEP : ',';
QUOT : '"';


SINTEGER: '-'? NUMBER+;
ID: (LOWERCASE | UPPERCASE) STRING*;
STRING : (LOWERCASE | UPPERCASE | NUMBER)+ ;
IP:  ((NUMBER)+ '.' NUMBER+)+ ':' NUMBER+; // Had to make it a bit wonky, otherwise is was equivalent to the REANGESEP.