package com.cs.languageplugin

import com.cs.languageplugin.parser.LuaParser
import com.cs.languageplugin.psi.LuaTypes
import com.intellij.lang.ASTNode
import com.intellij.lang.ParserDefinition
import com.intellij.lang.PsiParser
import com.intellij.lexer.Lexer
import com.intellij.openapi.project.Project
import com.intellij.psi.FileViewProvider
import com.intellij.psi.PsiElement
import com.intellij.psi.PsiFile
import com.intellij.psi.tree.IFileElementType
import com.intellij.psi.tree.TokenSet

class LuaParserDefinition : ParserDefinition {
    override fun createLexer(project: Project?): Lexer {
        return LuaLexerAdapter()
    }

    override fun createParser(project: Project?): PsiParser {
        return LuaParser()
    }

    override fun getFileNodeType(): IFileElementType {
        return FILE
    }

    override fun getCommentTokens(): TokenSet {
        return TokenSet.EMPTY //TODO update this to support comments
    }

    override fun getStringLiteralElements(): TokenSet {
        return TokenSet.EMPTY //TODO: update this to support string literals
    }

    override fun createElement(node: ASTNode?): PsiElement {
        return LuaTypes.Factory.createElement(node)
    }

    override fun createFile(viewProvider: FileViewProvider): PsiFile {
        return LuaFile(viewProvider)
    }

    companion object {
        @JvmStatic
        val FILE: IFileElementType = IFileElementType(LuaLanguage)
    }
}