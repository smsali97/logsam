grammar Logsam;
r : statement+;
statement : let | mvmt | clear | loop ;
let : Variable '=' expr ;
loop : Loop ( bool_expr );
bool_expr : bool_compare

                | bool_compare Logops bool_compare;
bool_compare :  (Int | Variable) Relops (Int | Variable)
                | '(' bool_compare ')';
mvmt : (Fwd | Bwd | Right | Left) expr;
clear : Clear;
expr : expr op=('*'|'/') expr #MulDiv
        | expr op=('+'|'-') expr #AddSub
        | Int  #Int
        | Variable #Var
        | '(' expr ')' #Paran
        ;


WS : [ \n\t\r]+ -> skip;
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

