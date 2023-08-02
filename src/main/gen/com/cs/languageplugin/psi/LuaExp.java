// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuaExp extends PsiElement {

  @NotNull
  List<LuaBinop> getBinopList();

  @NotNull
  List<LuaExp> getExpList();

  @Nullable
  LuaFunction getFunction();

  @Nullable
  LuaPrefixexp getPrefixexp();

  @Nullable
  LuaTableconstructor getTableconstructor();

  @Nullable
  LuaUnop getUnop();

}
