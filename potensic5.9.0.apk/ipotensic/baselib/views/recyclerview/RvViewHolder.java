package com.ipotensic.baselib.views.recyclerview;

import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvViewHolder.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u00a2\u0006\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u00028\u0000X\u0086\u000e\u00a2\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005\u00a8\u0006\u000b"}, d2 = {"Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "mBind", "(Landroidx/viewbinding/ViewBinding;)V", "mViewBind", "getMViewBind", "()Landroidx/viewbinding/ViewBinding;", "setMViewBind", "Landroidx/viewbinding/ViewBinding;", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class RvViewHolder<VB extends ViewBinding> extends RecyclerView.ViewHolder {
    private VB mViewBind;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RvViewHolder(VB mBind) {
        super(mBind.getRoot());
        Intrinsics.checkParameterIsNotNull(mBind, "mBind");
        this.mViewBind = mBind;
    }

    public final VB getMViewBind() {
        return this.mViewBind;
    }

    public final void setMViewBind(VB vb) {
        Intrinsics.checkParameterIsNotNull(vb, "<set-?>");
        this.mViewBind = vb;
    }
}