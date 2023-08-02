package com.cs.languageplugin

import com.cs.languageplugin.psi.LuaTypes
import com.intellij.lexer.Lexer
import com.intellij.openapi.editor.DefaultLanguageHighlighterColors
import com.intellij.openapi.editor.HighlighterColors
import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.editor.colors.TextAttributesKey.createTextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighterBase
import com.intellij.psi.tree.IElementType


class LuaSyntaxHighlighter: SyntaxHighlighterBase() {
    override fun getHighlightingLexer(): Lexer {
        return LuaLexerAdapter()
    }

    override fun getTokenHighlights(tokenType: IElementType?): Array<TextAttributesKey> {

        println("tokentype = $tokenType")

        return if (tokenType == null){
            EMPTY_KEYS
        } else {
            when(tokenType){
                LuaTypes.LPAREN, LuaTypes.RPAREN -> PARENTHESES_KEYS
                LuaTypes.LOCAL, LuaTypes.END, LuaTypes.IF, LuaTypes.ELSEIF, LuaTypes.FOR, LuaTypes.DO, LuaTypes.RETURN -> KEYWORD_KEYS
                LuaTypes.FUNCTION, LuaTypes.FUNCTIONDECL -> FUNCDECL_KEYS
                LuaTypes.IDENTIFIER -> ID_KEYS
                LuaTypes.PARLIST -> PARAMETER_KEYS
                LuaTypes.FUNCTIONCALL -> FUNCCALL_KEYS
                else -> EMPTY_KEYS
            }
        }

    }

    companion object {


        val PARENS: TextAttributesKey = createTextAttributesKey("LUA_PARENTHESES", DefaultLanguageHighlighterColors.PARENTHESES)
        val KEYWORDS: TextAttributesKey = createTextAttributesKey("LUA_KEYWORDS", DefaultLanguageHighlighterColors.KEYWORD)
        val FUNCDECL: TextAttributesKey = createTextAttributesKey("LUA_FUNCDECL", DefaultLanguageHighlighterColors.FUNCTION_DECLARATION)
        val ID: TextAttributesKey = createTextAttributesKey("LUA_ID", DefaultLanguageHighlighterColors.IDENTIFIER)
        val FUNCALL: TextAttributesKey = createTextAttributesKey("LUA_FUNCALL", DefaultLanguageHighlighterColors.FUNCTION_CALL)

        val PARAMETER: TextAttributesKey = createTextAttributesKey("LUA_PARAMETER", DefaultLanguageHighlighterColors.PARAMETER)


        private val PARENTHESES_KEYS = arrayOf(PARENS)
        private val KEYWORD_KEYS = arrayOf(KEYWORDS)
        private val FUNCDECL_KEYS = arrayOf(FUNCDECL)
        private val ID_KEYS = arrayOf(ID)
        private val PARAMETER_KEYS = arrayOf(PARAMETER)
        private val FUNCCALL_KEYS = arrayOf(FUNCALL)
        private val EMPTY_KEYS = arrayOf<TextAttributesKey>()
    }
}