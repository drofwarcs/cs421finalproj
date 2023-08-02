package com.cs.languageplugin

import com.intellij.openapi.fileTypes.LanguageFileType
import javax.swing.Icon

/**
 * Creates a language file type for the Lua programming language.
 */
class
LuaFileType private constructor(): LanguageFileType(LuaLanguage) {
    /**
     * Returns the name of the file type. The name must be unique among all file types registered in the system.
     */
    override fun getName(): String = "Lua File"

    /**
     * Returns the user-readable description of the file type.
     */
    override fun getDescription(): String = "Lua Language file"

    /**
     * Returns the default extension for files of the type, <em>not</em> including the leading '.'.
     */
    override fun getDefaultExtension(): String = "lua"

    /**
     * Returns the icon used for showing files of the type, or {@code null} if no icon should be shown.
     */
    override fun getIcon(): Icon = LuaIcons.FILE

    companion object{
        /**
         * Singleton access Instance
         */
        @JvmStatic
        val INSTANCE: LuaFileType = LuaFileType()
    }
}