// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuaStat extends PsiElement {

  @Nullable
  LuaChunk getChunk();

  @Nullable
  LuaExp getExp();

  @Nullable
  LuaExplist getExplist();

  @Nullable
  LuaFuncbody getFuncbody();

  @Nullable
  LuaFuncname getFuncname();

  @Nullable
  LuaFunctioncall getFunctioncall();

  @Nullable
  LuaNamelist getNamelist();

  @Nullable
  LuaVarlist getVarlist();

  @Nullable
  PsiElement getIdentifier();

}
