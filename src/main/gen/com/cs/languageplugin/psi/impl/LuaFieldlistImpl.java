// This is a generated file. Not intended for manual editing.
package com.cs.languageplugin.psi.impl;

import java.util.List;
import org.jetbrains.annotations.*;
import com.intellij.lang.ASTNode;
import com.intellij.psi.PsiElement;
import com.intellij.psi.PsiElementVisitor;
import com.intellij.psi.util.PsiTreeUtil;
import static com.cs.languageplugin.psi.LuaTypes.*;
import com.intellij.extapi.psi.ASTWrapperPsiElement;
import com.cs.languageplugin.psi.*;

public class LuaFieldlistImpl extends ASTWrapperPsiElement implements LuaFieldlist {

  public LuaFieldlistImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuaVisitor visitor) {
    visitor.visitFieldlist(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuaVisitor) accept((LuaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LuaField> getFieldList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaField.class);
  }

  @Override
  @NotNull
  public List<LuaFieldsep> getFieldsepList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaFieldsep.class);
  }

}
