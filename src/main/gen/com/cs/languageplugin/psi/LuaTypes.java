// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.psi;

import com.intellij.psi.tree.IElementType;
import com.intellij.psi.PsiElement;
import com.intellij.lang.ASTNode;
import com.cs.languageplugin.psi.impl.*;

public interface LuaTypes {

  IElementType ARGS = new LuaElementType("ARGS");
  IElementType BINOP = new LuaElementType("BINOP");
  IElementType CHUNK = new LuaElementType("CHUNK");
  IElementType EXP = new LuaElementType("EXP");
  IElementType EXPLIST = new LuaElementType("EXPLIST");
  IElementType FIELD = new LuaElementType("FIELD");
  IElementType FIELDLIST = new LuaElementType("FIELDLIST");
  IElementType FIELDSEP = new LuaElementType("FIELDSEP");
  IElementType FUNCBODY = new LuaElementType("FUNCBODY");
  IElementType FUNCNAME = new LuaElementType("FUNCNAME");
  IElementType FUNCTION = new LuaElementType("FUNCTION");
  IElementType FUNCTIONCALL = new LuaElementType("FUNCTIONCALL");
  IElementType LASTSTAT = new LuaElementType("LASTSTAT");
  IElementType NAMEANDARGS = new LuaElementType("NAMEANDARGS");
  IElementType NAMELIST = new LuaElementType("NAMELIST");
  IElementType PARLIST = new LuaElementType("PARLIST");
  IElementType PREFIXEXP = new LuaElementType("PREFIXEXP");
  IElementType SPACE = new LuaElementType("SPACE");
  IElementType STAT = new LuaElementType("STAT");
  IElementType TABLECONSTRUCTOR = new LuaElementType("TABLECONSTRUCTOR");
  IElementType UNOP = new LuaElementType("UNOP");
  IElementType VAR = new LuaElementType("VAR");
  IElementType VARLIST = new LuaElementType("VARLIST");
  IElementType VAROREXP = new LuaElementType("VAROREXP");
  IElementType VAR_SUFFIX = new LuaElementType("VAR_SUFFIX");

  IElementType AND = new LuaTokenType("and");
  IElementType ASSIGN = new LuaTokenType("=");
  IElementType BLOCK_COMMENT = new LuaTokenType("BLOCK_COMMENT");
  IElementType BREAK = new LuaTokenType("break");
  IElementType COLON = new LuaTokenType(":");
  IElementType COMMA = new LuaTokenType(",");
  IElementType CONCAT = new LuaTokenType("..");
  IElementType DIV = new LuaTokenType("/");
  IElementType DO = new LuaTokenType("do");
  IElementType DOC_COMMENT = new LuaTokenType("DOC_COMMENT");
  IElementType DOT = new LuaTokenType(".");
  IElementType ELLIPSIS = new LuaTokenType("...");
  IElementType ELSE = new LuaTokenType("else");
  IElementType ELSEIF = new LuaTokenType("elseif");
  IElementType END = new LuaTokenType("end");
  IElementType ENDREGION = new LuaTokenType("ENDREGION");
  IElementType EQ = new LuaTokenType("==");
  IElementType EXPPO = new LuaTokenType("^");
  IElementType FALSE = new LuaTokenType("false");
  IElementType FOR = new LuaTokenType("for");
  IElementType FUNCTIONDECL = new LuaTokenType("function");
  IElementType GE = new LuaTokenType(">=");
  IElementType GETN = new LuaTokenType("#");
  IElementType GT = new LuaTokenType(">");
  IElementType IDENTIFIER = new LuaTokenType("IDENTIFIER");
  IElementType IF = new LuaTokenType("if");
  IElementType IN = new LuaTokenType("in");
  IElementType LBRACK = new LuaTokenType("[");
  IElementType LCURLY = new LuaTokenType("{");
  IElementType LE = new LuaTokenType("<=");
  IElementType LOCAL = new LuaTokenType("local");
  IElementType LPAREN = new LuaTokenType("(");
  IElementType LT = new LuaTokenType("<");
  IElementType MINUS = new LuaTokenType("-");
  IElementType MOD = new LuaTokenType("%");
  IElementType MULT = new LuaTokenType("*");
  IElementType NE = new LuaTokenType("~=");
  IElementType NIL = new LuaTokenType("nil");
  IElementType NOT = new LuaTokenType("not");
  IElementType NUMBER = new LuaTokenType("Number");
  IElementType OR = new LuaTokenType("or");
  IElementType PLUS = new LuaTokenType("+");
  IElementType RBRACK = new LuaTokenType("]");
  IElementType RCURLY = new LuaTokenType("}");
  IElementType REGION = new LuaTokenType("REGION");
  IElementType REPEAT = new LuaTokenType("repeat");
  IElementType RETURN = new LuaTokenType("return");
  IElementType RPAREN = new LuaTokenType(")");
  IElementType SEMI = new LuaTokenType(";");
  IElementType SHEBANG = new LuaTokenType("#!");
  IElementType SHEBANG_CONTENT = new LuaTokenType("SHEBANG_CONTENT");
  IElementType SHORT_COMMENT = new LuaTokenType("SHORT_COMMENT");
  IElementType STRING = new LuaTokenType("String");
  IElementType THEN = new LuaTokenType("then");
  IElementType TRUE = new LuaTokenType("true");
  IElementType UNTIL = new LuaTokenType("until");
  IElementType WHILE = new LuaTokenType("while");

  class Factory {
    public static PsiElement createElement(ASTNode node) {
      IElementType type = node.getElementType();
      if (type == ARGS) {
        return new LuaArgsImpl(node);
      }
      else if (type == BINOP) {
        return new LuaBinopImpl(node);
      }
      else if (type == CHUNK) {
        return new LuaChunkImpl(node);
      }
      else if (type == EXP) {
        return new LuaExpImpl(node);
      }
      else if (type == EXPLIST) {
        return new LuaExplistImpl(node);
      }
      else if (type == FIELD) {
        return new LuaFieldImpl(node);
      }
      else if (type == FIELDLIST) {
        return new LuaFieldlistImpl(node);
      }
      else if (type == FIELDSEP) {
        return new LuaFieldsepImpl(node);
      }
      else if (type == FUNCBODY) {
        return new LuaFuncbodyImpl(node);
      }
      else if (type == FUNCNAME) {
        return new LuaFuncnameImpl(node);
      }
      else if (type == FUNCTION) {
        return new LuaFunctionImpl(node);
      }
      else if (type == FUNCTIONCALL) {
        return new LuaFunctioncallImpl(node);
      }
      else if (type == LASTSTAT) {
        return new LuaLaststatImpl(node);
      }
      else if (type == NAMEANDARGS) {
        return new LuaNameandargsImpl(node);
      }
      else if (type == NAMELIST) {
        return new LuaNamelistImpl(node);
      }
      else if (type == PARLIST) {
        return new LuaParlistImpl(node);
      }
      else if (type == PREFIXEXP) {
        return new LuaPrefixexpImpl(node);
      }
      else if (type == SPACE) {
        return new LuaSpaceImpl(node);
      }
      else if (type == STAT) {
        return new LuaStatImpl(node);
      }
      else if (type == TABLECONSTRUCTOR) {
        return new LuaTableconstructorImpl(node);
      }
      else if (type == UNOP) {
        return new LuaUnopImpl(node);
      }
      else if (type == VAR) {
        return new LuaVarImpl(node);
      }
      else if (type == VARLIST) {
        return new LuaVarlistImpl(node);
      }
      else if (type == VAROREXP) {
        return new LuaVarorexpImpl(node);
      }
      else if (type == VAR_SUFFIX) {
        return new LuaVarSuffixImpl(node);
      }
      throw new AssertionError("Unknown element type: " + type);
    }
  }
}
