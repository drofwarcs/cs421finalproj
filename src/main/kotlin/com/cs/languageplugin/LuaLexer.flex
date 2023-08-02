package com.cs.languageplugin;

import com.intellij.lexer.FlexLexer;
import com.intellij.psi.tree.IElementType;

import static com.intellij.psi.TokenType.BAD_CHARACTER;
import static com.intellij.psi.TokenType.WHITE_SPACE;
import static com.cs.languageplugin.psi.LuaTypes.*;

%%

%{
  public _LuaLexer() {
    this((java.io.Reader)null);
  }
%}

%public
%class _LuaLexer
%implements FlexLexer
%function advance
%type IElementType
%unicode

EOL=\R
WHITE_SPACE=\s+

IDENTIFIER=[A-Za-z_][A-Za-z0-9_]*
NUMBER=[0-9]+(\.[0-9]*)?
STRING=('([^'\\]|\\.)*'|\"([^\"\\]|\\.)*\")

%%
<YYINITIAL> {
  {WHITE_SPACE}          { return WHITE_SPACE; }

  "and"                  { return AND; }
  "break"                { return BREAK; }
  "do"                   { return DO; }
  "else"                 { return ELSE; }
  "elseif"               { return ELSEIF; }
  "end"                  { return END; }
  "false"                { return FALSE; }
  "for"                  { return FOR; }
  "if"                   { return IF; }
  "in"                   { return IN; }
  "local"                { return LOCAL; }
  "nil"                  { return NIL; }
  "not"                  { return NOT; }
  "or"                   { return OR; }
  "repeat"               { return REPEAT; }
  "return"               { return RETURN; }
  "then"                 { return THEN; }
  "true"                 { return TRUE; }
  "until"                { return UNTIL; }
  "while"                { return WHILE; }
  "REGION"               { return REGION; }
  "ENDREGION"            { return ENDREGION; }
  "#!"                   { return SHEBANG; }
  "SHEBANG_CONTENT"      { return SHEBANG_CONTENT; }
  "function"             { return FUNCTIONDECL;}
  "..."                  { return ELLIPSIS; }
  ".."                   { return CONCAT; }
  "=="                   { return EQ; }
  ">="                   { return GE; }
  "<="                   { return LE; }
  "~="                   { return NE; }
  "-"                    { return MINUS; }
  "+"                    { return PLUS; }
  "*"                    { return MULT; }
  "%"                    { return MOD; }
  "/"                    { return DIV; }
  "="                    { return ASSIGN; }
  ">"                    { return GT; }
  "<"                    { return LT; }
  "("                    { return LPAREN; }
  ")"                    { return RPAREN; }
  "["                    { return LBRACK; }
  "]"                    { return RBRACK; }
  "{"                    { return LCURLY; }
  "}"                    { return RCURLY; }
  "#"                    { return GETN; }
  ","                    { return COMMA; }
  ";"                    { return SEMI; }
  ":"                    { return COLON; }
  "."                    { return DOT; }
  "^"                    { return EXPPO; }
  "SHORT_COMMENT"        { return SHORT_COMMENT; }
  "DOC_COMMENT"          { return DOC_COMMENT; }
  "BLOCK_COMMENT"        { return BLOCK_COMMENT; }

  {IDENTIFIER}           { return IDENTIFIER; }
  {NUMBER}               { return NUMBER; }
  {STRING}               { return STRING; }

}

[^] { return BAD_CHARACTER; }