package com.cs.languageplugin

import com.cs.languageplugin.psi.LuaFunction
import com.intellij.openapi.project.Project
import com.intellij.openapi.vfs.VirtualFile
import com.intellij.psi.PsiManager
import com.intellij.psi.search.FileTypeIndex
import com.intellij.psi.search.GlobalSearchScope
import com.intellij.psi.util.PsiTreeUtil
import kotlin.streams.toList

object LuaUtil {

    @JvmStatic
    fun findFunctions(project: Project, function: String): List<LuaFunction>{
        val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(LuaFileType.INSTANCE, GlobalSearchScope.allScope(project))
        val allFunctions = virtualFiles.stream()
            .map { PsiManager.getInstance(project).findFile(it) as LuaFile }
            .filter { it != null }
            .map { PsiTreeUtil.getChildrenOfType(it, LuaFunction::class.java) }
            .filter { it != null}
            .toList()
            .flatMap { it.toList() }
            .filter { function == it.text}
        return allFunctions
    }

    @JvmStatic
    fun findFunctions(project: Project): List<LuaFunction>{
        val virtualFiles: Collection<VirtualFile> = FileTypeIndex.getFiles(LuaFileType.INSTANCE, GlobalSearchScope.allScope(project))
        val allFunctions = virtualFiles.stream()
            .map { PsiManager.getInstance(project).findFile(it) as LuaFile }
            .filter { it != null }
            .map {
                PsiTreeUtil.getChildrenOfType(it, LuaFunction::class.java)
            }
            .filter { it != null}
            .toList()
            .flatMap {
                it.toList()
            }
        return allFunctions
    }
}