grammar Logsam;
r : statement+;
statement : let | mvmt | clear | whileloop | forloop | ifstmt | switchcolor | clear;
let : Variable '=' expr ;
ifstmt : 'if' bool_expr 'then' statement+ 'endif';
whileloop : Loop ( bool_expr );
forloop : 'for' Int '..' Int statement* 'endfor';
bool_expr : bool_compare logop=Logops bool_compare;
bool_compare :  bool_compare relop=Relops bool_compare
                        | Int
                        | Variable;
mvmt : (Fwd | Bwd | Right | Left) expr;
clear : Clear;
switchcolor : 'switch' color=('RED'|'WHITE'|'BLUE'|'PURPLE'|'GREEN'|'YELLOW'|'TRANSPARENT');
expr : expr op=('*'|'/') expr #MulDiv
        | expr op=('+'|'-') expr #AddSub
        | Int  #Int
        | Variable #Var
        | '(' expr ')' #Paran
        ;

WS : [ \n\t\r]+ -> skip;
COMMENT: '//' .*? '\n' -> skip;
Fwd : 'fd' | 'FORWARD' ;
Bwd : 'bk' | 'BACK' ;
Right : 'rt' | 'RIGHT' ;
Left :  'lt' | 'LEFT' ;
Clean : 'Clean' ;
Clear : 'cs' | 'CLEARSCREEN' ;
Int : [0-9]+ ;
Shape : 'circle' | 'square' | 'eqtriangle' ;
Loop : 'while' ;
Relops : '<' | '>' | '<=' | '>=' | '==' | '!=';
Logops : 'AND' | 'OR' | 'NOT' ;
Con_if : 'if' ;
Con_elseif : 'elsif' ;
Con_else : 'else' ;
Round_brack : '(' | ')' ;
Curly_brack : '{' | '}' ;
Variable : [a-zA-Z_]+[0-9]* ;
MUL : '*' ;
DIV : '/' ;
ADD : '+' ;
SUB : '-' ;
Assig : '=' ;

