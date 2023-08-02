package com.cs.languageplugin.psi

import com.cs.languageplugin.LuaLanguage
import com.intellij.psi.tree.IElementType

class LuaElementType(private val debugName: String): IElementType(debugName, LuaLanguage) {

}