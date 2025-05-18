package com.ipotensic.baselib.views.recyclerview;

import android.content.Context;
import android.view.ViewGroup;
import androidx.viewbinding.ViewBinding;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvCommonAdapter.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0004B\u001b\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00028\u00000\b\u00a2\u0006\u0002\u0010\tJ%\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00028\u00012\u0006\u0010\u0012\u001a\u00028\u00002\u0006\u0010\u0013\u001a\u00020\u0014H$\u00a2\u0006\u0002\u0010\u0015J\u0015\u0010\u0016\u001a\u00028\u00012\u0006\u0010\u0017\u001a\u00020\u0018H$\u00a2\u0006\u0002\u0010\u0019R\u001a\u0010\n\u001a\u00020\u0006X\u0084\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/ipotensic/baselib/views/recyclerview/RvCommonAdapter;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/ipotensic/baselib/views/recyclerview/RvMultiItemTypeAdapter;", "context", "Landroid/content/Context;", "datas", "", "(Landroid/content/Context;Ljava/util/List;)V", "mContext", "getMContext", "()Landroid/content/Context;", "setMContext", "(Landroid/content/Context;)V", "convert", "", "holder", "data", "position", "", "(Landroidx/viewbinding/ViewBinding;Ljava/lang/Object;I)V", "initView", "parent", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)Landroidx/viewbinding/ViewBinding;", "BaseLib_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public abstract class RvCommonAdapter<T, VB extends ViewBinding> extends RvMultiItemTypeAdapter<T, VB> {
    private Context mContext;

    protected abstract void convert(VB holder, T data, int position);

    protected abstract VB initView(ViewGroup parent);

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public RvCommonAdapter(Context context, List<T> datas) {
        super(context, datas);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        this.mContext = context;
        addItemViewDelegate((RvItemViewDelegate) new RvItemViewDelegate<T, VB>() { // from class: com.ipotensic.baselib.views.recyclerview.RvCommonAdapter.1
            @Override // com.ipotensic.baselib.views.recyclerview.RvItemViewDelegate
            public boolean isForViewType(T item, int position) {
                return true;
            }

            @Override // com.ipotensic.baselib.views.recyclerview.RvItemViewDelegate
            public VB initView(ViewGroup parent) {
                Intrinsics.checkParameterIsNotNull(parent, "parent");
                return (VB) RvCommonAdapter.this.initView(parent);
            }

            @Override // com.ipotensic.baselib.views.recyclerview.RvItemViewDelegate
            public void convert(RvViewHolder<VB> holder, T data, int position) {
                Intrinsics.checkParameterIsNotNull(holder, "holder");
                RvCommonAdapter.this.convert(holder.getMViewBind(), data, position);
            }
        });
    }

    protected final Context getMContext() {
        return this.mContext;
    }

    protected final void setMContext(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "<set-?>");
        this.mContext = context;
    }
}