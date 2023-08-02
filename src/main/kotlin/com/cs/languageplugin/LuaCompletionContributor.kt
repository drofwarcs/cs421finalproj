package com.cs.languageplugin

import com.cs.languageplugin.psi.LuaTypes
import com.intellij.codeInsight.completion.*
import com.intellij.codeInsight.lookup.LookupElementBuilder
import com.intellij.patterns.PlatformPatterns
import com.intellij.util.ProcessingContext

class LuaCompletionContributor: CompletionContributor() {


    val provider = object : CompletionProvider<CompletionParameters>() {
        override fun addCompletions(
            parameters: CompletionParameters,
            context: ProcessingContext,
            result: CompletionResultSet
        ) {
            result.addElement(LookupElementBuilder.create("todo"))
        }

    }

    init {
        extend(
            CompletionType.BASIC,
            PlatformPatterns.psiElement(LuaTypes.IDENTIFIER),
            provider
        )
    }

}