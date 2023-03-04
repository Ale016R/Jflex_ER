package com.expresiones;

import java.io.*;

%%

%public

%class Lexer

digit = [0-9]
letter = [a-zA-Z]
whitespace = [\t\r]

%type Token

%eofval{
    return new Token(TokenConstant.EOF, null);
%eofval}

%%
{letter}({letter}{digit})* { return new Token(TokenConstant.ID, yytext()); }
{digit}+ { return new Token(TokenConstant.NUM, yytext()); }
[^] { throw new IllegalArgumentException("La cadena que has ingresado no puede ser aceptada: " + yytext()); }
