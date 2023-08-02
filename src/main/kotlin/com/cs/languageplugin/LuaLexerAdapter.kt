package com.cs.languageplugin

import com.intellij.lexer.FlexAdapter

class LuaLexerAdapter : FlexAdapter(_LuaLexer(null))