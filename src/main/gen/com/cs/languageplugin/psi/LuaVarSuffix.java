// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuaVarSuffix extends PsiElement {

  @Nullable
  LuaExp getExp();

  @NotNull
  List<LuaNameandargs> getNameandargsList();

  @Nullable
  PsiElement getIdentifier();

}
