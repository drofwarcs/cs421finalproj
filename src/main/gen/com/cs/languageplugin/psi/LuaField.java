// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.psi;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.psi.PsiElement;

public interface LuaField extends PsiElement {

  @NotNull
  List<LuaExp> getExpList();

  @Nullable
  PsiElement getIdentifier();

}