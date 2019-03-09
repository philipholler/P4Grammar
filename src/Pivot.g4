grammar Pivot;
program : decls;

decls : define* inst* init* func*;

    define : DEFINEKW (signal | device) END;

    signal: SIGNALKW signalID ':' (range | togglevalues) ;

        signalID: ID;

    device: DEVICE deviceID ((inputs? ('&' outputs?)?) | (outputs? ('&' inputs?)?)); // The order of output and input can be switched around. That doesn't matter.

    inst : deviceID varID EQUALS ip END;

    init : 'init' END; // Placeholder init main method

    func : 'func' END; // Placeholder functions


inputs: INPUTKW ':' input (LISTSEP input)*;

    input: ID;

outputs: OUTPUTKW ':' output (LISTSEP output)*;

    output: ID;

deviceID : ID;

ip : IP;

varID : ID;



/*
 * Signal values
 */
range : lowerBound RANGESEP upperBound;
lowerBound : SINTEGER;
upperBound : SINTEGER;

togglevalues : togglevalue (LISTSEP togglevalue)*;
togglevalue : toggleID EQUALS toggleVal;
toggleID : ID;
toggleVal : (STRING | SINTEGER);



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

SIGNALKW : 'Signal';
INPUTKW : 'input';
OUTPUTKW : 'output';
DEVICE : 'Device';
DEFINEKW : '#define';
SINTEGER: '-'? NUMBER+;
RANGESEP: '..';
ID: (LOWERCASE | UPPERCASE) STRING;
STRING : (LOWERCASE | UPPERCASE | NUMBER)+ ;
END : ';';
LISTSEP : ',';
EQUALS : '=';
IP:  ((NUMBER)+ '.' NUMBER+)+ ':' NUMBER+; // Had to make it a bit wonky, otherwise is was equivalent to the REANGESEP.