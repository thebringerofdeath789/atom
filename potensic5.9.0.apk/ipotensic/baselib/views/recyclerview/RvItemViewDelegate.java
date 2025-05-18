package com.ipotensic.baselib.views.recyclerview;

import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;

/* compiled from: RvItemViewDelegate.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004J+\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\t\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH&\u00a2\u0006\u0002\u0010\fJ\u0015\u0010\r\u001a\u00028\u00012\u0006\u0010\u000e\u001a\u00020\u000fH&\u00a2\u0006\u0002\u0010\u0010J\u001d\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00028\u00002\u0006\u0010\n\u001a\u00020\u000bH&\u00a2\u0006\u0002\u0010\u0014\u00a8\u0006\u0015"}, d2 = {"Lcom/ipotensic/baselib/views/recyclerview/RvItemViewDelegate;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "", "convert", "", "holder", "Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;", "data", "position", "", "(Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;Ljava/lang/Object;I)V", "initView", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "isForViewType", "", "item", "(Ljava/lang/Object;I)Z", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public interface RvItemViewDelegate<T, VB extends ViewBinding> {
    void convert(RvViewHolder<VB> holder, T data, int position);

    VB initView(ViewGroup parent);

    boolean isForViewType(T item, int position);
}