package com.ipotensic.baselib.views.recyclerview;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewbinding.ViewBinding;
import com.ipotensic.baselib.views.recyclerview.RvMultiItemTypeAdapter;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: RvMultiItemTypeAdapter.kt */
@Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u0001*\b\b\u0001\u0010\u0002*\u00020\u00032\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00020\u00050\u0004:\u0001,B\u001b\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\t¢\u0006\u0002\u0010\nJ&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015J.\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u00002\u0006\u0010\u0016\u001a\u00020\u00172\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0015J#\u0010\u0018\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u001b\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0017H\u0016J\u0010\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u0010\u0010 \u001a\u00020!2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u001e\u0010\"\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u001f\u001a\u00020\u0017H\u0016J\u001e\u0010#\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010$\u001a\u00020%2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010&\u001a\u00020\u00192\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00028\u00010\u0005H\u0002J(\u0010'\u001a\u00020\u00192\b\u0010$\u001a\u0004\u0018\u00010%2\f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0017H\u0004J\u000e\u0010)\u001a\u00020\u00192\u0006\u0010*\u001a\u00020\u0010J\b\u0010+\u001a\u00020!H\u0002R \u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00000\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, m2338d2 = {"Lcom/ipotensic/baselib/views/recyclerview/RvMultiItemTypeAdapter;", "T", "VB", "Landroidx/viewbinding/ViewBinding;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;", "mContext", "Landroid/content/Context;", "datas", "", "(Landroid/content/Context;Ljava/util/List;)V", "getDatas", "()Ljava/util/List;", "setDatas", "(Ljava/util/List;)V", "mOnItemClickListener", "Lcom/ipotensic/baselib/views/recyclerview/RvMultiItemTypeAdapter$OnItemClickListener;", "mRvItemViewDelegateManager", "Lcom/ipotensic/baselib/views/recyclerview/RvItemViewDelegateManager;", "addItemViewDelegate", "itemViewDelegate", "Lcom/ipotensic/baselib/views/recyclerview/RvItemViewDelegate;", "viewType", "", "convert", "", "holder", "data", "(Lcom/ipotensic/baselib/views/recyclerview/RvViewHolder;Ljava/lang/Object;)V", "getItemCount", "getItemViewType", "position", "isEnabled", "", "onBindViewHolder", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "onViewHolderCreated", "setListener", "rvViewHolder", "setOnItemClickListener", "onItemClickListener", "useItemViewDelegateManager", "OnItemClickListener", "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
/* loaded from: classes2.dex */
public class RvMultiItemTypeAdapter<T, VB extends ViewBinding> extends RecyclerView.Adapter<RvViewHolder<VB>> {
    private List<T> datas;
    private Context mContext;
    private OnItemClickListener mOnItemClickListener;
    private RvItemViewDelegateManager<T, VB> mRvItemViewDelegateManager;

    /* compiled from: RvMultiItemTypeAdapter.kt */
    @Metadata(m2336bv = {1, 0, 3}, m2337d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J \u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&¨\u0006\f"}, m2338d2 = {"Lcom/ipotensic/baselib/views/recyclerview/RvMultiItemTypeAdapter$OnItemClickListener;", "", "onItemClick", "", "view", "Landroid/view/View;", "holder", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "position", "", "onItemLongClick", "", "BaseLib_release"}, m2339k = 1, m2340mv = {1, 1, 15})
    public interface OnItemClickListener {
        void onItemClick(View view, RecyclerView.ViewHolder holder, int position);

        boolean onItemLongClick(View view, RecyclerView.ViewHolder holder, int position);
    }

    private final boolean isEnabled(int viewType) {
        return true;
    }

    private final void onViewHolderCreated(RvViewHolder<VB> holder) {
    }

    public final List<T> getDatas() {
        return this.datas;
    }

    public final void setDatas(List<T> list) {
        Intrinsics.checkParameterIsNotNull(list, "<set-?>");
        this.datas = list;
    }

    public RvMultiItemTypeAdapter(Context mContext, List<T> datas) {
        Intrinsics.checkParameterIsNotNull(mContext, "mContext");
        Intrinsics.checkParameterIsNotNull(datas, "datas");
        this.mContext = mContext;
        this.datas = datas;
        this.mRvItemViewDelegateManager = new RvItemViewDelegateManager<>();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int position) {
        return !useItemViewDelegateManager() ? super.getItemViewType(position) : this.mRvItemViewDelegateManager.getItemViewType(this.datas.get(position), position);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RvViewHolder<VB> onCreateViewHolder(ViewGroup parent, int viewType) {
        Intrinsics.checkParameterIsNotNull(parent, "parent");
        RvViewHolder<VB> rvViewHolder = new RvViewHolder<>(this.mRvItemViewDelegateManager.getItemViewDelegate(viewType).initView(parent));
        onViewHolderCreated(rvViewHolder);
        setListener(parent, rvViewHolder, viewType);
        return rvViewHolder;
    }

    private final void convert(RvViewHolder<VB> holder, T data) {
        this.mRvItemViewDelegateManager.convert(holder, data, holder.getAdapterPosition());
    }

    protected final void setListener(ViewGroup parent, final RvViewHolder<VB> rvViewHolder, int viewType) {
        Intrinsics.checkParameterIsNotNull(rvViewHolder, "rvViewHolder");
        if (isEnabled(viewType)) {
            rvViewHolder.getMViewBind().getRoot().setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.baselib.views.recyclerview.RvMultiItemTypeAdapter$setListener$1
                @Override // android.view.View.OnClickListener
                public final void onClick(View v) {
                    RvMultiItemTypeAdapter.OnItemClickListener onItemClickListener;
                    RvMultiItemTypeAdapter.OnItemClickListener onItemClickListener2;
                    onItemClickListener = RvMultiItemTypeAdapter.this.mOnItemClickListener;
                    if (onItemClickListener != null) {
                        int adapterPosition = rvViewHolder.getAdapterPosition();
                        onItemClickListener2 = RvMultiItemTypeAdapter.this.mOnItemClickListener;
                        if (onItemClickListener2 == null) {
                            Intrinsics.throwNpe();
                        }
                        Intrinsics.checkExpressionValueIsNotNull(v, "v");
                        onItemClickListener2.onItemClick(v, rvViewHolder, adapterPosition);
                    }
                }
            });
            rvViewHolder.getMViewBind().getRoot().setOnLongClickListener(new View.OnLongClickListener() { // from class: com.ipotensic.baselib.views.recyclerview.RvMultiItemTypeAdapter$setListener$2
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
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RvViewHolder<VB> holder, int position) {
        Intrinsics.checkParameterIsNotNull(holder, "holder");
        convert(holder, this.datas.get(position));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.datas.size();
    }

    public final RvMultiItemTypeAdapter<T, VB> addItemViewDelegate(RvItemViewDelegate<T, VB> itemViewDelegate) {
        Intrinsics.checkParameterIsNotNull(itemViewDelegate, "itemViewDelegate");
        this.mRvItemViewDelegateManager.addDelegate(itemViewDelegate);
        return this;
    }

    public final RvMultiItemTypeAdapter<T, VB> addItemViewDelegate(int viewType, RvItemViewDelegate<T, VB> itemViewDelegate) {
        Intrinsics.checkParameterIsNotNull(itemViewDelegate, "itemViewDelegate");
        this.mRvItemViewDelegateManager.addDelegate(viewType, itemViewDelegate);
        return this;
    }

    private final boolean useItemViewDelegateManager() {
        return this.mRvItemViewDelegateManager.getItemViewDelegateCount() > 0;
    }

    public final void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        Intrinsics.checkParameterIsNotNull(onItemClickListener, "onItemClickListener");
        this.mOnItemClickListener = onItemClickListener;
    }
}