package me.yokeyword.indexablerv;

import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import me.yokeyword.indexablerv.AbstractHeaderFooterAdapter;
import me.yokeyword.indexablerv.IndexableAdapter;
import me.yokeyword.indexablerv.IndexableEntity;

/* loaded from: classes4.dex */
class RealAdapter<T extends IndexableEntity> extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private IndexableAdapter<T> mAdapter;
    private IndexableAdapter.OnItemContentClickListener<T> mContentClickListener;
    private IndexableAdapter.OnItemContentLongClickListener<T> mContentLongClickListener;
    private ArrayList<EntityWrapper<T>> mDatas;
    private IndexableAdapter.OnItemTitleClickListener mTitleClickListener;
    private IndexableAdapter.OnItemTitleLongClickListener mTitleLongClickListener;
    private ArrayList<EntityWrapper<T>> mDatasList = new ArrayList<>();
    private ArrayList<EntityWrapper<T>> mHeaderDatasList = new ArrayList<>();
    private ArrayList<EntityWrapper<T>> mFooterDatasList = new ArrayList<>();
    private SparseArray<IndexableHeaderAdapter> mHeaderAdapterMap = new SparseArray<>();
    private SparseArray<IndexableFooterAdapter> mFooterAdapterMap = new SparseArray<>();

    RealAdapter() {
    }

    void setIndexableAdapter(IndexableAdapter<T> indexableAdapter) {
        this.mAdapter = indexableAdapter;
    }

    void addIndexableHeaderAdapter(IndexableHeaderAdapter indexableHeaderAdapter) {
        this.mHeaderDatasList.addAll(0, indexableHeaderAdapter.getDatas());
        this.mDatasList.addAll(0, indexableHeaderAdapter.getDatas());
        this.mHeaderAdapterMap.put(indexableHeaderAdapter.getItemViewType(), indexableHeaderAdapter);
        notifyDataSetChanged();
    }

    void removeIndexableHeaderAdapter(IndexableHeaderAdapter indexableHeaderAdapter) {
        this.mHeaderDatasList.removeAll(indexableHeaderAdapter.getDatas());
        if (this.mDatasList.size() > 0) {
            this.mDatasList.removeAll(indexableHeaderAdapter.getDatas());
        }
        this.mHeaderAdapterMap.remove(indexableHeaderAdapter.getItemViewType());
        notifyDataSetChanged();
    }

    void addIndexableFooterAdapter(IndexableFooterAdapter indexableFooterAdapter) {
        this.mFooterDatasList.addAll(indexableFooterAdapter.getDatas());
        this.mDatasList.addAll(indexableFooterAdapter.getDatas());
        this.mFooterAdapterMap.put(indexableFooterAdapter.getItemViewType(), indexableFooterAdapter);
        notifyDataSetChanged();
    }

    void removeIndexableFooterAdapter(IndexableFooterAdapter indexableFooterAdapter) {
        this.mFooterDatasList.removeAll(indexableFooterAdapter.getDatas());
        if (this.mDatasList.size() > 0) {
            this.mDatasList.removeAll(indexableFooterAdapter.getDatas());
        }
        this.mFooterAdapterMap.remove(indexableFooterAdapter.getItemViewType());
        notifyDataSetChanged();
    }

    void setDatas(ArrayList<EntityWrapper<T>> arrayList) {
        if (this.mDatas != null && this.mDatasList.size() > this.mHeaderDatasList.size() + this.mFooterDatasList.size()) {
            this.mDatasList.removeAll(this.mDatas);
        }
        this.mDatas = arrayList;
        this.mDatasList.addAll(this.mHeaderDatasList.size(), arrayList);
        notifyDataSetChanged();
    }

    ArrayList<EntityWrapper<T>> getItems() {
        return this.mDatasList;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return this.mDatasList.get(i).getItemType();
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, final int i) {
        IndexableFooterAdapter indexableFooterAdapter;
        final RecyclerView.ViewHolder onCreateContentViewHolder;
        if (i == 2147483646) {
            onCreateContentViewHolder = this.mAdapter.onCreateTitleViewHolder(viewGroup);
        } else if (i == Integer.MAX_VALUE) {
            onCreateContentViewHolder = this.mAdapter.onCreateContentViewHolder(viewGroup);
        } else {
            if (this.mHeaderAdapterMap.indexOfKey(i) >= 0) {
                indexableFooterAdapter = this.mHeaderAdapterMap.get(i);
            } else {
                indexableFooterAdapter = this.mFooterAdapterMap.get(i);
            }
            onCreateContentViewHolder = indexableFooterAdapter.onCreateContentViewHolder(viewGroup);
        }
        onCreateContentViewHolder.itemView.setOnClickListener(new View.OnClickListener() { // from class: me.yokeyword.indexablerv.RealAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                AbstractHeaderFooterAdapter.OnItemClickListener onItemClickListener;
                int adapterPosition = onCreateContentViewHolder.getAdapterPosition();
                if (adapterPosition == -1) {
                    return;
                }
                EntityWrapper entityWrapper = (EntityWrapper) RealAdapter.this.mDatasList.get(adapterPosition);
                int i2 = i;
                if (i2 == 2147483646) {
                    if (RealAdapter.this.mTitleClickListener != null) {
                        RealAdapter.this.mTitleClickListener.onItemClick(view, adapterPosition, entityWrapper.getIndexTitle());
                    }
                } else if (i2 == Integer.MAX_VALUE) {
                    if (RealAdapter.this.mContentClickListener != null) {
                        RealAdapter.this.mContentClickListener.onItemClick(view, entityWrapper.getOriginalPosition(), adapterPosition, entityWrapper.getData());
                    }
                } else {
                    AbstractHeaderFooterAdapter abstractHeaderFooterAdapter = RealAdapter.this.mHeaderAdapterMap.indexOfKey(i) >= 0 ? (AbstractHeaderFooterAdapter) RealAdapter.this.mHeaderAdapterMap.get(i) : (AbstractHeaderFooterAdapter) RealAdapter.this.mFooterAdapterMap.get(i);
                    if (abstractHeaderFooterAdapter == null || (onItemClickListener = abstractHeaderFooterAdapter.getOnItemClickListener()) == null) {
                        return;
                    }
                    onItemClickListener.onItemClick(view, adapterPosition, entityWrapper.getData());
                }
            }
        });
        onCreateContentViewHolder.itemView.setOnLongClickListener(new View.OnLongClickListener() { // from class: me.yokeyword.indexablerv.RealAdapter.2
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                AbstractHeaderFooterAdapter.OnItemLongClickListener onItemLongClickListener;
                int adapterPosition = onCreateContentViewHolder.getAdapterPosition();
                EntityWrapper entityWrapper = (EntityWrapper) RealAdapter.this.mDatasList.get(adapterPosition);
                int i2 = i;
                if (i2 == 2147483646) {
                    if (RealAdapter.this.mTitleLongClickListener != null) {
                        return RealAdapter.this.mTitleLongClickListener.onItemLongClick(view, adapterPosition, entityWrapper.getIndexTitle());
                    }
                    return true;
                }
                if (i2 == Integer.MAX_VALUE) {
                    if (RealAdapter.this.mContentLongClickListener != null) {
                        return RealAdapter.this.mContentLongClickListener.onItemLongClick(view, entityWrapper.getOriginalPosition(), adapterPosition, entityWrapper.getData());
                    }
                    return true;
                }
                AbstractHeaderFooterAdapter abstractHeaderFooterAdapter = RealAdapter.this.mHeaderAdapterMap.indexOfKey(i) >= 0 ? (AbstractHeaderFooterAdapter) RealAdapter.this.mHeaderAdapterMap.get(i) : (AbstractHeaderFooterAdapter) RealAdapter.this.mFooterAdapterMap.get(i);
                if (abstractHeaderFooterAdapter == null || (onItemLongClickListener = abstractHeaderFooterAdapter.getOnItemLongClickListener()) == null) {
                    return false;
                }
                return onItemLongClickListener.onItemLongClick(view, adapterPosition, entityWrapper.getData());
            }
        });
        return onCreateContentViewHolder;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
        IndexableFooterAdapter indexableFooterAdapter;
        EntityWrapper<T> entityWrapper = this.mDatasList.get(i);
        int itemViewType = getItemViewType(i);
        if (itemViewType == 2147483646) {
            if (4 == viewHolder.itemView.getVisibility()) {
                viewHolder.itemView.setVisibility(0);
            }
            this.mAdapter.onBindTitleViewHolder(viewHolder, entityWrapper.getIndexTitle());
        } else {
            if (itemViewType == Integer.MAX_VALUE) {
                this.mAdapter.onBindContentViewHolder(viewHolder, entityWrapper.getData());
                return;
            }
            if (this.mHeaderAdapterMap.indexOfKey(itemViewType) >= 0) {
                indexableFooterAdapter = this.mHeaderAdapterMap.get(itemViewType);
            } else {
                indexableFooterAdapter = this.mFooterAdapterMap.get(itemViewType);
            }
            indexableFooterAdapter.onBindContentViewHolder(viewHolder, entityWrapper.getData());
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.mDatasList.size();
    }

    void setOnItemTitleClickListener(IndexableAdapter.OnItemTitleClickListener onItemTitleClickListener) {
        this.mTitleClickListener = onItemTitleClickListener;
    }

    void setOnItemContentClickListener(IndexableAdapter.OnItemContentClickListener<T> onItemContentClickListener) {
        this.mContentClickListener = onItemContentClickListener;
    }

    void setOnItemTitleLongClickListener(IndexableAdapter.OnItemTitleLongClickListener onItemTitleLongClickListener) {
        this.mTitleLongClickListener = onItemTitleLongClickListener;
    }

    void setOnItemContentLongClickListener(IndexableAdapter.OnItemContentLongClickListener<T> onItemContentLongClickListener) {
        this.mContentLongClickListener = onItemContentLongClickListener;
    }

    void addHeaderFooterData(boolean z, EntityWrapper entityWrapper, EntityWrapper entityWrapper2) {
        processAddHeaderFooterData(z ? this.mHeaderDatasList : this.mFooterDatasList, entityWrapper, entityWrapper2);
    }

    private void processAddHeaderFooterData(ArrayList<EntityWrapper<T>> arrayList, EntityWrapper entityWrapper, EntityWrapper entityWrapper2) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == entityWrapper) {
                int i2 = i + 1;
                arrayList.add(i2, entityWrapper2);
                this.mDatasList.add(arrayList == this.mFooterDatasList ? (this.mDatasList.size() - this.mFooterDatasList.size()) + 1 + i2 : i2, entityWrapper2);
                notifyItemInserted(i2);
                return;
            }
        }
    }

    void removeHeaderFooterData(boolean z, EntityWrapper entityWrapper) {
        processremoveHeaderFooterData(z ? this.mHeaderDatasList : this.mFooterDatasList, entityWrapper);
    }

    private void processremoveHeaderFooterData(ArrayList<EntityWrapper<T>> arrayList, EntityWrapper entityWrapper) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) == entityWrapper) {
                arrayList.remove(entityWrapper);
                this.mDatasList.remove(entityWrapper);
                notifyItemRemoved(i);
                return;
            }
        }
    }
}
