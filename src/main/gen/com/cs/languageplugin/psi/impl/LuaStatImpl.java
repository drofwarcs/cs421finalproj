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

public class LuaStatImpl extends ASTWrapperPsiElement implements LuaStat {

  public LuaStatImpl(@NotNull ASTNode node) {
    super(node);
  }

  public void accept(@NotNull LuaVisitor visitor) {
    visitor.visitStat(this);
  }

  @Override
  public void accept(@NotNull PsiElementVisitor visitor) {
    if (visitor instanceof LuaVisitor) accept((LuaVisitor)visitor);
    else super.accept(visitor);
  }

  @Override
  @Nullable
  public LuaChunk getChunk() {
    return findChildByClass(LuaChunk.class);
  }

  @Override
  @Nullable
  public LuaExp getExp() {
    return findChildByClass(LuaExp.class);
  }

  @Override
  @Nullable
  public LuaExplist getExplist() {
    return findChildByClass(LuaExplist.class);
  }

  @Override
  @Nullable
  public LuaFuncbody getFuncbody() {
    return findChildByClass(LuaFuncbody.class);
  }

  @Override
  @Nullable
  public LuaFuncname getFuncname() {
    return findChildByClass(LuaFuncname.class);
  }

  @Override
  @Nullable
  public LuaFunctioncall getFunctioncall() {
    return findChildByClass(LuaFunctioncall.class);
  }

  @Override
  @Nullable
  public LuaNamelist getNamelist() {
    return findChildByClass(LuaNamelist.class);
  }

  @Override
  @Nullable
  public LuaVarlist getVarlist() {
    return findChildByClass(LuaVarlist.class);
  }

  @Override
  @Nullable
  public PsiElement getIdentifier() {
    return findChildByType(IDENTIFIER);
  }

}
