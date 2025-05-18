package com.ipotensic.baselib.views.recyclerview;

import android.view.View;
import com.ipotensic.baselib.views.recyclerview.RvMultiItemTypeAdapter;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvMultiItemTypeAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002\"\b\b\u0001\u0010\u0003*\u00020\u00042\u000e\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006H\n\u00a2\u0006\u0002\b\b"}, d2 = {"<anonymous>", "", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "v", "Landroid/view/View;", "kotlin.jvm.PlatformType", "onLongClick"}, k = 3, mv = {1, 1, 15})
/* loaded from: classes2.dex */
final class RvMultiItemTypeAdapter$setListener$2 implements View.OnLongClickListener {
    final /* synthetic */ RvViewHolder $rvViewHolder;

    RvMultiItemTypeAdapter$setListener$2(RvViewHolder rvViewHolder) {
        rvViewHolder = rvViewHolder;
    }

    @Override // android.view.View.OnLongClickListener
    public final boolean onLongClick(View v) {
        RvMultiItemTypeAdapter.OnItemClickListener onItemClickListener;
        RvMultiItemTypeAdapter.OnItemClickListener onItemClickListener2;
        onItemClickListener = RvMultiItemTypeAdapter.this.mOnItemClickListener;
        if (onItemClickListener == null) {
            return false;
        }
        int adapterPosition = rvViewHolder.getAdapterPosition();
        onItemClickListener2 = RvMultiItemTypeAdapter.this.mOnItemClickListener;
        if (onItemClickListener2 == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(v, "v");
        return onItemClickListener2.onItemLongClick(v, rvViewHolder, adapterPosition);
    }
}