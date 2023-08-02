package com.cs.languageplugin.psi.impl

import com.cs.languageplugin.psi.LuaFunction
import com.cs.languageplugin.psi.LuaTypes

object LuaPsiImplUtil {

    @JvmStatic
    fun getFunction(element: LuaFunction): String? {
        val keyNode = element.node.findChildByType(LuaTypes.FUNCTION) ?: return null

        println("getFunction: ${keyNode.text}")
        return keyNode.text
    }
}