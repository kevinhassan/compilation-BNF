grammar grammaire;

prog: 'var' param*
    |   func*
    |   instructions ;


expr:   uop expr       // precedence 4
    |   expr bop expr
    |   (CALL | F) '(' expr* ')'
    |   CONST                 // primary (precedence 2)
    |   F
    |   ID
    ;


func : F '(' param* ')' (':' TYPES)?
    |  'var' param*
    |  instructions ;

instructions: IF expr THEN instructions (ELSE instructions)?
    |   F AFFECT expr
    |   ID AFFECT expr
    |   WHILE expr DO instructions
    |   'skip'
    |   instructions ';' instructions
    |   (CALL '(') expr* ')' ;


uop : '-'
    | 'not'
    ;



bop : '+'
    | '-'
    | 'x'
    | '/'
    | 'and'
    | 'or'
    | '<'
    | '<='
    | '='
    | '!='
    | '>='
    | '>'
    ;

param: ID ':' TYPES ;


CONST : INT | BOOLEAN ;
CALL : 'read' | 'write' ;
TYPES: 'integer' | 'boolean' ;
AFFECT : ':=' ;
INT :   [0-9]+ ;
BOOLEAN : 'true' | 'false' ;
WS  :   [ \t\n\r]+ -> skip ;
F : 'f';
IF : 'if';
THEN : 'then';
ELSE : 'else';
WHILE : 'while';
DO : 'do';
ID  :   [a-zA-Z]+ ;
