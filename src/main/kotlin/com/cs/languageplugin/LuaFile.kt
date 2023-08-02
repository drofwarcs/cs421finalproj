package com.cs.languageplugin

import com.intellij.extapi.psi.PsiFileBase
import com.intellij.openapi.fileTypes.FileType
import com.intellij.psi.FileViewProvider

class LuaFile(viewProvider: FileViewProvider): PsiFileBase(viewProvider, LuaLanguage) {

    override fun getFileType(): FileType = LuaFileType.INSTANCE

    override fun toString(): String = "Lua File"

}