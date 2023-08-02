package com.cs.languageplugin

import com.intellij.openapi.editor.colors.TextAttributesKey
import com.intellij.openapi.fileTypes.SyntaxHighlighter
import com.intellij.openapi.options.colors.AttributesDescriptor
import com.intellij.openapi.options.colors.ColorDescriptor
import com.intellij.openapi.options.colors.ColorSettingsPage
import javax.swing.Icon

class LuaColorSettingsPage: ColorSettingsPage {

    private val DESCRIPTORS: Array<AttributesDescriptor> = arrayOf(
        AttributesDescriptor("Identifier", LuaSyntaxHighlighter.ID),
        AttributesDescriptor("Parameter", LuaSyntaxHighlighter.PARAMETER),
        AttributesDescriptor("Function Declaration", LuaSyntaxHighlighter.FUNCDECL),
        AttributesDescriptor("Keywords", LuaSyntaxHighlighter.KEYWORDS),
        AttributesDescriptor("Parentheses", LuaSyntaxHighlighter.PARENS),
        AttributesDescriptor("Function Call", LuaSyntaxHighlighter.FUNCALL)


    )
    override fun getAttributeDescriptors(): Array<AttributesDescriptor> {
        return DESCRIPTORS
    }

    override fun getColorDescriptors(): Array<ColorDescriptor> {
        return ColorDescriptor.EMPTY_ARRAY
    }

    override fun getDisplayName(): String {
        return "Lua"
    }

    override fun getIcon(): Icon {
        return LuaIcons.FILE
    }

    override fun getHighlighter(): SyntaxHighlighter {
        return LuaSyntaxHighlighter()
    }

    override fun getDemoText(): String {
        return """
            function allwords ()
              local line = io.read()
              local pos = 1
              return function ()
                while line do
                  local s, e = string.find(line, "%w+", pos)
                  if s then
                    pos = e + 1
                    return string.sub(line, s, e)
                  else
                    line = io.read()
                    pos = 1
                    print("hello world")
                  end
                end
                return nil
              end
            end
        """.trimIndent()
    }

    override fun getAdditionalHighlightingTagToDescriptorMap(): MutableMap<String, TextAttributesKey>? {
        return null
    }
}