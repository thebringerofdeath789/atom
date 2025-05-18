package com.ipotensic.baselib.views.recyclerview;

import android.view.ViewGroup;
import androidx.collection.SparseArrayCompat;
import androidx.viewbinding.ViewBinding;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvItemViewDelegateManager.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u00020\u0004B\u0005\u00a2\u0006\u0002\u0010\u0005J(\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\bJ.\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bJ)\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00010\u00172\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u001aJ\u001b\u0010\u001b\u001a\u00028\u00012\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u0013\u001a\u00020\u000e\u00a2\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b2\u0006\u0010\u0013\u001a\u00020\u000eJ\u001b\u0010 \u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u0019\u001a\u00020\u000e\u00a2\u0006\u0002\u0010!J\u001a\u0010 \u001a\u00020\u000e2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bJ&\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\bJ\u001a\u0010#\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010$\u001a\u00020\u000eR,\u0010\u0006\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\b0\u0007X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e8F\u00a2\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010\u00a8\u0006%"}, d2 = {"Lcom/ipotensic/baselib/views/recyclerview/RvItemViewDelegateManager;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "", "()V", "delegates", "Landroidx/collection/SparseArrayCompat;", "Lcom/ipotensic/baselib/views/recyclerview/RvItemViewDelegate;", "getDelegates", "()Landroidx/collection/SparseArrayCompat;", "setDelegates", "(Landroidx/collection/SparseArrayCompat;)V", "itemViewDelegateCount", "", "getItemViewDelegateCount", "()I", "addDelegate", "delegate", "viewType", "convert", "", "holder", "Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;", "item", "position", "(Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;Ljava/lang/Object;I)V", "getItemViewBinding", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;I)Landroidx/viewbinding/ViewBinding;", "getItemViewDelegate", "getItemViewType", "(Ljava/lang/Object;I)I", "itemViewDelegate", "removeDelegate", "itemType", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class RvItemViewDelegateManager<T, VB extends ViewBinding> {
    private SparseArrayCompat<RvItemViewDelegate<T, VB>> delegates = new SparseArrayCompat<>();

    public final SparseArrayCompat<RvItemViewDelegate<T, VB>> getDelegates() {
        return this.delegates;
    }

    public final void setDelegates(SparseArrayCompat<RvItemViewDelegate<T, VB>> sparseArrayCompat) {
        Intrinsics.checkParameterIsNotNull(sparseArrayCompat, "<set-?>");
        this.delegates = sparseArrayCompat;
    }

    public final int getItemViewDelegateCount() {
        return this.delegates.size();
    }

    public final RvItemViewDelegateManager<T, VB> addDelegate(RvItemViewDelegate<T, VB> delegate) {
        int size = this.delegates.size();
        if (delegate != null) {
            this.delegates.put(size, delegate);
        }
        return this;
    }

    public final RvItemViewDelegateManager<T, VB> addDelegate(int viewType, RvItemViewDelegate<T, VB> delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        if (!(this.delegates.get(viewType) == null)) {
            throw new IllegalArgumentException(("An ItemViewDelegate is already registered for the viewType = " + viewType + ". Already registered ItemViewDelegate is " + this.delegates.get(viewType)).toString());
        }
        this.delegates.put(viewType, delegate);
        return this;
    }

    public final RvItemViewDelegateManager<T, VB> removeDelegate(RvItemViewDelegate<T, VB> delegate) {
        Intrinsics.checkParameterIsNotNull(delegate, "delegate");
        int indexOfValue = this.delegates.indexOfValue(delegate);
        if (indexOfValue >= 0) {
            this.delegates.removeAt(indexOfValue);
        }
        return this;
    }

    public final RvItemViewDelegateManager<T, VB> removeDelegate(int itemType) {
        int indexOfKey = this.delegates.indexOfKey(itemType);
        if (indexOfKey >= 0) {
            this.delegates.removeAt(indexOfKey);
        }
        return this;
    }

    public final int getItemViewType(T item, int position) {
        for (int size = this.delegates.size() - 1; size >= 0; size--) {
            RvItemViewDelegate<T, VB> valueAt = this.delegates.valueAt(size);
            if (valueAt == null) {
                Intrinsics.throwNpe();
            }
            if (valueAt.isForViewType(item, position)) {
                return this.delegates.keyAt(size);
            }
        }
        throw new IllegalArgumentException("No ItemViewDelegate added that matches position=" + position + " in data source");
    }

    public final void convert(RvViewHolder<VB> holder, T item, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        int size = this.delegates.size();
        for (int i = 0; i < size; i++) {
            RvItemViewDelegate<T, VB> valueAt = this.delegates.valueAt(i);
            if (valueAt == null) {
                Intrinsics.throwNpe();
            }
            if (valueAt.isForViewType(item, position)) {
                valueAt.convert(holder, item, position);
                return;
            }
        }
        throw new IllegalArgumentException("No RvItemViewDelegateManager added that matches position=" + position + " in data source");
    }

    public final RvItemViewDelegate<T, VB> getItemViewDelegate(int viewType) {
        RvItemViewDelegate<T, VB> rvItemViewDelegate = this.delegates.get(viewType);
        if (rvItemViewDelegate == null) {
            Intrinsics.throwNpe();
        }
        return rvItemViewDelegate;
    }

    public final VB getItemViewBinding(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        return getItemViewDelegate(viewType).initView(parent);
    }

    public final int getItemViewType(RvItemViewDelegate<T, VB> itemViewDelegate) {
        Intrinsics.checkParameterIsNotNull(itemViewDelegate, "itemViewDelegate");
        return this.delegates.indexOfValue(itemViewDelegate);
    }
}