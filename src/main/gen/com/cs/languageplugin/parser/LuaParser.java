// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.parser;

import com.intellij.lang.PsiBuilder;
import com.intellij.lang.PsiBuilder.Marker;
import static com.cs.languageplugin.psi.LuaTypes.*;
import static com.intellij.lang.parser.GeneratedParserUtilBase.*;
import com.intellij.psi.tree.IElementType;
import com.intellij.lang.ASTNode;
import com.intellij.psi.tree.TokenSet;
import com.intellij.lang.PsiParser;
import com.intellij.lang.LightPsiParser;

@SuppressWarnings({"SimplifiableIfStatement", "UnusedAssignment"})
public class LuaParser implements PsiParser, LightPsiParser {

  public ASTNode parse(IElementType t, PsiBuilder b) {
    parseLight(t, b);
    return b.getTreeBuilt();
  }

  public void parseLight(IElementType t, PsiBuilder b) {
    boolean r;
    b = adapt_builder_(t, b, this, null);
    Marker m = enter_section_(b, 0, _COLLAPSE_, null);
    r = parse_root_(t, b);
    exit_section_(b, 0, m, t, r, true, TRUE_CONDITION);
  }

  protected boolean parse_root_(IElementType t, PsiBuilder b) {
    return parse_root_(t, b, 0);
  }

  static boolean parse_root_(IElementType t, PsiBuilder b, int l) {
    return block(b, l + 1);
  }

  /* ********************************************************** */
  // '(' explist? ')'
  //     | tableconstructor
  //     | String
  public static boolean args(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, ARGS, "<args>");
    r = args_0(b, l + 1);
    if (!r) r = tableconstructor(b, l + 1);
    if (!r) r = consumeToken(b, STRING);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' explist? ')'
  private static boolean args_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && args_0_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

  // explist?
  private static boolean args_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "args_0_1")) return false;
    explist(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '+' | '-' | '*' | '/' | '^' | '%' | '..' |
  //           '<' | '<=' | '>' | '>=' | '==' | '~=' |
  //           'and' | 'or'
  public static boolean binop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "binop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, BINOP, "<binop>");
    r = consumeToken(b, PLUS);
    if (!r) r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, MULT);
    if (!r) r = consumeToken(b, DIV);
    if (!r) r = consumeToken(b, EXPPO);
    if (!r) r = consumeToken(b, MOD);
    if (!r) r = consumeToken(b, CONCAT);
    if (!r) r = consumeToken(b, LT);
    if (!r) r = consumeToken(b, LE);
    if (!r) r = consumeToken(b, GT);
    if (!r) r = consumeToken(b, GE);
    if (!r) r = consumeToken(b, EQ);
    if (!r) r = consumeToken(b, NE);
    if (!r) r = consumeToken(b, AND);
    if (!r) r = consumeToken(b, OR);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // chunk
  static boolean block(PsiBuilder b, int l) {
    return chunk(b, l + 1);
  }

  /* ********************************************************** */
  // (stat ';'?)* (laststat ';'?)?
  public static boolean chunk(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, CHUNK, "<chunk>");
    r = chunk_0(b, l + 1);
    r = r && chunk_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (stat ';'?)*
  private static boolean chunk_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!chunk_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "chunk_0", c)) break;
    }
    return true;
  }

  // stat ';'?
  private static boolean chunk_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = stat(b, l + 1);
    r = r && chunk_0_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean chunk_0_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_0_0_1")) return false;
    consumeToken(b, SEMI);
    return true;
  }

  // (laststat ';'?)?
  private static boolean chunk_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_1")) return false;
    chunk_1_0(b, l + 1);
    return true;
  }

  // laststat ';'?
  private static boolean chunk_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = laststat(b, l + 1);
    r = r && chunk_1_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ';'?
  private static boolean chunk_1_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "chunk_1_0_1")) return false;
    consumeToken(b, SEMI);
    return true;
  }

  /* ********************************************************** */
  // ('nil' | 'false' | 'true' | Number | String | '...' | function |
  //      prefixexp | tableconstructor |  unop exp) (binop exp)*
  public static boolean exp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _COLLAPSE_, EXP, "<exp>");
    r = exp_0(b, l + 1);
    r = r && exp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'nil' | 'false' | 'true' | Number | String | '...' | function |
  //      prefixexp | tableconstructor |  unop exp
  private static boolean exp_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, NIL);
    if (!r) r = consumeToken(b, FALSE);
    if (!r) r = consumeToken(b, TRUE);
    if (!r) r = consumeToken(b, NUMBER);
    if (!r) r = consumeToken(b, STRING);
    if (!r) r = consumeToken(b, ELLIPSIS);
    if (!r) r = function(b, l + 1);
    if (!r) r = prefixexp(b, l + 1);
    if (!r) r = tableconstructor(b, l + 1);
    if (!r) r = exp_0_9(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // unop exp
  private static boolean exp_0_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp_0_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = unop(b, l + 1);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (binop exp)*
  private static boolean exp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!exp_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "exp_1", c)) break;
    }
    return true;
  }

  // binop exp
  private static boolean exp_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "exp_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = binop(b, l + 1);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // (exp ',')* exp
  public static boolean explist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explist")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, EXPLIST, "<explist>");
    r = explist_0(b, l + 1);
    r = r && exp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (exp ',')*
  private static boolean explist_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explist_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!explist_0_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "explist_0", c)) break;
    }
    return true;
  }

  // exp ','
  private static boolean explist_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "explist_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = exp(b, l + 1);
    r = r && consumeToken(b, COMMA);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '[' exp ']' '=' exp
  //     | IDENTIFIER '=' exp
  //     | exp
  public static boolean field(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELD, "<field>");
    r = field_0(b, l + 1);
    if (!r) r = field_1(b, l + 1);
    if (!r) r = exp(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '[' exp ']' '=' exp
  private static boolean field_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && exp(b, l + 1);
    r = r && consumeTokens(b, 0, RBRACK, ASSIGN);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // IDENTIFIER '=' exp
  private static boolean field_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "field_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, IDENTIFIER, ASSIGN);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // field (fieldsep field)* fieldsep?
  public static boolean fieldlist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldlist")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELDLIST, "<fieldlist>");
    r = field(b, l + 1);
    r = r && fieldlist_1(b, l + 1);
    r = r && fieldlist_2(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (fieldsep field)*
  private static boolean fieldlist_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldlist_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!fieldlist_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "fieldlist_1", c)) break;
    }
    return true;
  }

  // fieldsep field
  private static boolean fieldlist_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldlist_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = fieldsep(b, l + 1);
    r = r && field(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // fieldsep?
  private static boolean fieldlist_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldlist_2")) return false;
    fieldsep(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // ','
  //     | ';'
  public static boolean fieldsep(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "fieldsep")) return false;
    if (!nextTokenIs(b, "<fieldsep>", COMMA, SEMI)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FIELDSEP, "<fieldsep>");
    r = consumeToken(b, COMMA);
    if (!r) r = consumeToken(b, SEMI);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // '(' parlist? ')' block 'end'
  public static boolean funcbody(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcbody")) return false;
    if (!nextTokenIs(b, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && funcbody_1(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, FUNCBODY, r);
    return r;
  }

  // parlist?
  private static boolean funcbody_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcbody_1")) return false;
    parlist(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // IDENTIFIER ('.' IDENTIFIER)* (':' IDENTIFIER)?
  public static boolean funcname(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcname")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && funcname_1(b, l + 1);
    r = r && funcname_2(b, l + 1);
    exit_section_(b, m, FUNCNAME, r);
    return r;
  }

  // ('.' IDENTIFIER)*
  private static boolean funcname_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcname_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!funcname_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "funcname_1", c)) break;
    }
    return true;
  }

  // '.' IDENTIFIER
  private static boolean funcname_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcname_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // (':' IDENTIFIER)?
  private static boolean funcname_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcname_2")) return false;
    funcname_2_0(b, l + 1);
    return true;
  }

  // ':' IDENTIFIER
  private static boolean funcname_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "funcname_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'function' funcbody
  public static boolean function(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "function")) return false;
    if (!nextTokenIs(b, FUNCTIONDECL)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTIONDECL);
    r = r && funcbody(b, l + 1);
    exit_section_(b, m, FUNCTION, r);
    return r;
  }

  /* ********************************************************** */
  // varorexp nameandargs+
  public static boolean functioncall(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functioncall")) return false;
    if (!nextTokenIs(b, "<functioncall>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, FUNCTIONCALL, "<functioncall>");
    r = varorexp(b, l + 1);
    r = r && functioncall_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nameandargs+
  private static boolean functioncall_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "functioncall_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = nameandargs(b, l + 1);
    while (r) {
      int c = current_position_(b);
      if (!nameandargs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "functioncall_1", c)) break;
    }
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // 'return' explist?
  //     | 'break'
  public static boolean laststat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "laststat")) return false;
    if (!nextTokenIs(b, "<laststat>", BREAK, RETURN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, LASTSTAT, "<laststat>");
    r = laststat_0(b, l + 1);
    if (!r) r = consumeToken(b, BREAK);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // 'return' explist?
  private static boolean laststat_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "laststat_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, RETURN);
    r = r && laststat_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // explist?
  private static boolean laststat_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "laststat_0_1")) return false;
    explist(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // (':' IDENTIFIER)? args
  public static boolean nameandargs(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameandargs")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, NAMEANDARGS, "<nameandargs>");
    r = nameandargs_0(b, l + 1);
    r = r && args(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (':' IDENTIFIER)?
  private static boolean nameandargs_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameandargs_0")) return false;
    nameandargs_0_0(b, l + 1);
    return true;
  }

  // ':' IDENTIFIER
  private static boolean nameandargs_0_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "nameandargs_0_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COLON, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // IDENTIFIER (',' IDENTIFIER)*
  public static boolean namelist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namelist")) return false;
    if (!nextTokenIs(b, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    r = r && namelist_1(b, l + 1);
    exit_section_(b, m, NAMELIST, r);
    return r;
  }

  // (',' IDENTIFIER)*
  private static boolean namelist_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namelist_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!namelist_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "namelist_1", c)) break;
    }
    return true;
  }

  // ',' IDENTIFIER
  private static boolean namelist_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "namelist_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // namelist (',' '...')?
  //     | '...'
  public static boolean parlist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parlist")) return false;
    if (!nextTokenIs(b, "<parlist>", ELLIPSIS, IDENTIFIER)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PARLIST, "<parlist>");
    r = parlist_0(b, l + 1);
    if (!r) r = consumeToken(b, ELLIPSIS);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // namelist (',' '...')?
  private static boolean parlist_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parlist_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = namelist(b, l + 1);
    r = r && parlist_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // (',' '...')?
  private static boolean parlist_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parlist_0_1")) return false;
    parlist_0_1_0(b, l + 1);
    return true;
  }

  // ',' '...'
  private static boolean parlist_0_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "parlist_0_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, COMMA, ELLIPSIS);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // varorexp nameandargs*
  public static boolean prefixexp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixexp")) return false;
    if (!nextTokenIs(b, "<prefixexp>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, PREFIXEXP, "<prefixexp>");
    r = varorexp(b, l + 1);
    r = r && prefixexp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nameandargs*
  private static boolean prefixexp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "prefixexp_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nameandargs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "prefixexp_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // ' '*
  public static boolean space(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "space")) return false;
    Marker m = enter_section_(b, l, _NONE_, SPACE, "<space>");
    while (true) {
      int c = current_position_(b);
      if (!consumeToken(b, " ")) break;
      if (!empty_element_parsed_guard_(b, "space", c)) break;
    }
    exit_section_(b, l, m, true, false, null);
    return true;
  }

  /* ********************************************************** */
  // varlist '=' explist
  //     | functioncall
  //     | 'do' block 'end'
  //     | 'while' exp 'do' block 'end'
  //     | 'repeat' block 'until' exp
  //     | 'if' exp 'then' block ('elseif' exp 'then' block)* 'else'? block? 'end'
  //     | 'for' IDENTIFIER '=' exp ',' exp ','? exp 'do' block 'end'
  //     | 'for' namelist 'in' explist 'do' block 'end'
  //     | 'function' funcname funcbody
  //     | 'local' 'function' IDENTIFIER funcbody
  //     | 'local' namelist ('=' explist)?
  public static boolean stat(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, STAT, "<stat>");
    r = stat_0(b, l + 1);
    if (!r) r = functioncall(b, l + 1);
    if (!r) r = stat_2(b, l + 1);
    if (!r) r = stat_3(b, l + 1);
    if (!r) r = stat_4(b, l + 1);
    if (!r) r = stat_5(b, l + 1);
    if (!r) r = stat_6(b, l + 1);
    if (!r) r = stat_7(b, l + 1);
    if (!r) r = stat_8(b, l + 1);
    if (!r) r = stat_9(b, l + 1);
    if (!r) r = stat_10(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // varlist '=' explist
  private static boolean stat_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varlist(b, l + 1);
    r = r && consumeToken(b, ASSIGN);
    r = r && explist(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'do' block 'end'
  private static boolean stat_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_2")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'while' exp 'do' block 'end'
  private static boolean stat_3(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_3")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, WHILE);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'repeat' block 'until' exp
  private static boolean stat_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_4")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, REPEAT);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, UNTIL);
    r = r && exp(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'if' exp 'then' block ('elseif' exp 'then' block)* 'else'? block? 'end'
  private static boolean stat_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_5")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IF);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && block(b, l + 1);
    r = r && stat_5_4(b, l + 1);
    r = r && stat_5_5(b, l + 1);
    r = r && stat_5_6(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('elseif' exp 'then' block)*
  private static boolean stat_5_4(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_5_4")) return false;
    while (true) {
      int c = current_position_(b);
      if (!stat_5_4_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "stat_5_4", c)) break;
    }
    return true;
  }

  // 'elseif' exp 'then' block
  private static boolean stat_5_4_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_5_4_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ELSEIF);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, THEN);
    r = r && block(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'else'?
  private static boolean stat_5_5(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_5_5")) return false;
    consumeToken(b, ELSE);
    return true;
  }

  // block?
  private static boolean stat_5_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_5_6")) return false;
    block(b, l + 1);
    return true;
  }

  // 'for' IDENTIFIER '=' exp ',' exp ','? exp 'do' block 'end'
  private static boolean stat_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_6")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, FOR, IDENTIFIER, ASSIGN);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, COMMA);
    r = r && exp(b, l + 1);
    r = r && stat_6_6(b, l + 1);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // ','?
  private static boolean stat_6_6(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_6_6")) return false;
    consumeToken(b, COMMA);
    return true;
  }

  // 'for' namelist 'in' explist 'do' block 'end'
  private static boolean stat_7(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_7")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FOR);
    r = r && namelist(b, l + 1);
    r = r && consumeToken(b, IN);
    r = r && explist(b, l + 1);
    r = r && consumeToken(b, DO);
    r = r && block(b, l + 1);
    r = r && consumeToken(b, END);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'function' funcname funcbody
  private static boolean stat_8(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_8")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, FUNCTIONDECL);
    r = r && funcname(b, l + 1);
    r = r && funcbody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'local' 'function' IDENTIFIER funcbody
  private static boolean stat_9(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_9")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeTokens(b, 0, LOCAL, FUNCTIONDECL, IDENTIFIER);
    r = r && funcbody(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // 'local' namelist ('=' explist)?
  private static boolean stat_10(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_10")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LOCAL);
    r = r && namelist(b, l + 1);
    r = r && stat_10_2(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // ('=' explist)?
  private static boolean stat_10_2(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_10_2")) return false;
    stat_10_2_0(b, l + 1);
    return true;
  }

  // '=' explist
  private static boolean stat_10_2_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "stat_10_2_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, ASSIGN);
    r = r && explist(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // '{' fieldlist? '}'
  public static boolean tableconstructor(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableconstructor")) return false;
    if (!nextTokenIs(b, LCURLY)) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LCURLY);
    r = r && tableconstructor_1(b, l + 1);
    r = r && consumeToken(b, RCURLY);
    exit_section_(b, m, TABLECONSTRUCTOR, r);
    return r;
  }

  // fieldlist?
  private static boolean tableconstructor_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "tableconstructor_1")) return false;
    fieldlist(b, l + 1);
    return true;
  }

  /* ********************************************************** */
  // '-'
  //     | 'not'
  //     | '#'
  public static boolean unop(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "unop")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, UNOP, "<unop>");
    r = consumeToken(b, MINUS);
    if (!r) r = consumeToken(b, NOT);
    if (!r) r = consumeToken(b, GETN);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  /* ********************************************************** */
  // ( IDENTIFIER | '(' exp ')' varSuffix) varSuffix*
  public static boolean var(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var")) return false;
    if (!nextTokenIs(b, "<var>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR, "<var>");
    r = var_0(b, l + 1);
    r = r && var_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // IDENTIFIER | '(' exp ')' varSuffix
  private static boolean var_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, IDENTIFIER);
    if (!r) r = var_0_1(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // '(' exp ')' varSuffix
  private static boolean var_0_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_0_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    r = r && varSuffix(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  // varSuffix*
  private static boolean var_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "var_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!varSuffix(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "var_1", c)) break;
    }
    return true;
  }

  /* ********************************************************** */
  // nameandargs* ('[' exp ']' | '.' IDENTIFIER)
  public static boolean varSuffix(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varSuffix")) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAR_SUFFIX, "<var suffix>");
    r = varSuffix_0(b, l + 1);
    r = r && varSuffix_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // nameandargs*
  private static boolean varSuffix_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varSuffix_0")) return false;
    while (true) {
      int c = current_position_(b);
      if (!nameandargs(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "varSuffix_0", c)) break;
    }
    return true;
  }

  // '[' exp ']' | '.' IDENTIFIER
  private static boolean varSuffix_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varSuffix_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = varSuffix_1_0(b, l + 1);
    if (!r) r = parseTokens(b, 0, DOT, IDENTIFIER);
    exit_section_(b, m, null, r);
    return r;
  }

  // '[' exp ']'
  private static boolean varSuffix_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varSuffix_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LBRACK);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, RBRACK);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var (',' var)*
  public static boolean varlist(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varlist")) return false;
    if (!nextTokenIs(b, "<varlist>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VARLIST, "<varlist>");
    r = var(b, l + 1);
    r = r && varlist_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // (',' var)*
  private static boolean varlist_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varlist_1")) return false;
    while (true) {
      int c = current_position_(b);
      if (!varlist_1_0(b, l + 1)) break;
      if (!empty_element_parsed_guard_(b, "varlist_1", c)) break;
    }
    return true;
  }

  // ',' var
  private static boolean varlist_1_0(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varlist_1_0")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, COMMA);
    r = r && var(b, l + 1);
    exit_section_(b, m, null, r);
    return r;
  }

  /* ********************************************************** */
  // var | '(' exp ')'
  public static boolean varorexp(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varorexp")) return false;
    if (!nextTokenIs(b, "<varorexp>", IDENTIFIER, LPAREN)) return false;
    boolean r;
    Marker m = enter_section_(b, l, _NONE_, VAROREXP, "<varorexp>");
    r = var(b, l + 1);
    if (!r) r = varorexp_1(b, l + 1);
    exit_section_(b, l, m, r, false, null);
    return r;
  }

  // '(' exp ')'
  private static boolean varorexp_1(PsiBuilder b, int l) {
    if (!recursion_guard_(b, l, "varorexp_1")) return false;
    boolean r;
    Marker m = enter_section_(b);
    r = consumeToken(b, LPAREN);
    r = r && exp(b, l + 1);
    r = r && consumeToken(b, RPAREN);
    exit_section_(b, m, null, r);
    return r;
  }

}
