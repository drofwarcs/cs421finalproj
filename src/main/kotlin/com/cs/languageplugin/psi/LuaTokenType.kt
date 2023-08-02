package com.cs.languageplugin.psi

import com.cs.languageplugin.LuaLanguage
import com.intellij.psi.tree.IElementType

class LuaTokenType(private val debugName: String) : IElementType(debugName, LuaLanguage) {

    override fun toString(): String {
        return "LuaTokenType.${super.toString()}"
    }
}