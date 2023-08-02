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

public class LuaExpImpl extends ASTWrapperPsiElement implements LuaExp {

  public LuaExpImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuaVisitor visitor) {
    visitor.visitExp(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuaVisitor) accept((LuaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @NotNull
  public List<LuaBinop> getBinopList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaBinop.class);
  }

  @Override
  @NotNull
  public List<LuaExp> getExpList() {
    return PsiTreeUtil.getChildrenOfTypeAsList(this, LuaExp.class);
  }

  @Override
  @Nullable
  public LuaFunction getFunction() {
    return findChildByClass(LuaFunction.class);
  }

  @Override
  @Nullable
  public LuaPrefixexp getPrefixexp() {
    return findChildByClass(LuaPrefixexp.class);
  }

  @Override
  @Nullable
  public LuaTableconstructor getTableconstructor() {
    return findChildByClass(LuaTableconstructor.class);
  }

  @Override
  @Nullable
  public LuaUnop getUnop() {
    return findChildByClass(LuaUnop.class);
  }

}
