package me.yokeyword.indexablerv;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import me.yokeyword.indexablerv.database.HeaderFooterDataObservable;
import me.yokeyword.indexablerv.database.HeaderFooterDataObserver;
import me.yokeyword.indexablerv.database.IndexBarDataObservable;
import me.yokeyword.indexablerv.database.IndexBarDataObserver;

/* loaded from: classes4.dex */
abstract class AbstractHeaderFooterAdapter<T> {
    private String mIndex;
    private String mIndexTitle;
    protected OnItemClickListener<T> mListener;
    protected OnItemLongClickListener<T> mLongListener;
    private final HeaderFooterDataObservable mDataSetObservable = new HeaderFooterDataObservable();
    private final IndexBarDataObservable mIndexBarDataSetObservable = new IndexBarDataObservable();
    ArrayList<EntityWrapper<T>> mEntityWrapperList = new ArrayList<>();

    interface OnItemClickListener<T> {
        void onItemClick(View view, int i, T t);
    }

    interface OnItemLongClickListener<T> {
        boolean onItemLongClick(View view, int i, T t);
    }

    int getHeaderFooterType() {
        return 1;
    }

    public abstract int getItemViewType();

    public abstract void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, T t);

    public abstract RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup);

    public AbstractHeaderFooterAdapter(String str, String str2, List<T> list) {
        this.mIndex = str;
        this.mIndexTitle = str2;
        if (str2 != null) {
            wrapEntity().setItemType(2147483646);
        }
        for (int i = 0; i < list.size(); i++) {
            wrapEntity().setData(list.get(i));
        }
    }

    private EntityWrapper<T> wrapEntity() {
        EntityWrapper<T> entityWrapper = new EntityWrapper<>();
        entityWrapper.setIndex(this.mIndex);
        entityWrapper.setIndexTitle(this.mIndexTitle);
        entityWrapper.setHeaderFooterType(getHeaderFooterType());
        this.mEntityWrapperList.add(entityWrapper);
        return entityWrapper;
    }

    private EntityWrapper<T> wrapEntity(int i) {
        EntityWrapper<T> entityWrapper = new EntityWrapper<>();
        entityWrapper.setIndex(this.mIndex);
        entityWrapper.setIndexTitle(this.mIndexTitle);
        entityWrapper.setHeaderFooterType(getHeaderFooterType());
        this.mEntityWrapperList.add(i, entityWrapper);
        return entityWrapper;
    }

    public void notifyDataSetChanged() {
        this.mDataSetObservable.notifyChanged();
    }

    public void addData(T t) {
        int size = this.mEntityWrapperList.size();
        EntityWrapper<T> wrapEntity = wrapEntity();
        wrapEntity.setItemType(getItemViewType());
        wrapEntity.setData(t);
        if (size > 0) {
            this.mDataSetObservable.notifyAdd(getHeaderFooterType() == 1, this.mEntityWrapperList.get(size - 1), wrapEntity);
            this.mIndexBarDataSetObservable.notifyChanged();
        }
    }

    public void removeData(T t) {
        Iterator<EntityWrapper<T>> it = this.mEntityWrapperList.iterator();
        while (it.hasNext()) {
            EntityWrapper<T> next = it.next();
            if (next.getData() == t) {
                this.mEntityWrapperList.remove(next);
                this.mDataSetObservable.notifyRemove(getHeaderFooterType() == 1, next);
                this.mIndexBarDataSetObservable.notifyChanged();
                return;
            }
        }
    }

    public void addData(int i, T t) {
        int size = this.mEntityWrapperList.size();
        if (i >= size) {
            return;
        }
        EntityWrapper<T> wrapEntity = wrapEntity(i + 1);
        wrapEntity.setItemType(getItemViewType());
        wrapEntity.setData(t);
        if (size > 0) {
            this.mDataSetObservable.notifyAdd(getHeaderFooterType() == 1, this.mEntityWrapperList.get(i), wrapEntity);
            this.mIndexBarDataSetObservable.notifyChanged();
        }
    }

    public void addDatas(List<T> list) {
        for (int i = 0; i < list.size(); i++) {
            addData(list.get(i));
        }
    }

    public void addDatas(int i, List<T> list) {
        if (i >= this.mEntityWrapperList.size()) {
            return;
        }
        for (int size = list.size() - 1; size >= 0; size--) {
            addData(i, list.get(size));
        }
    }

    OnItemClickListener<T> getOnItemClickListener() {
        return this.mListener;
    }

    OnItemLongClickListener getOnItemLongClickListener() {
        return this.mLongListener;
    }

    ArrayList<EntityWrapper<T>> getDatas() {
        Iterator<EntityWrapper<T>> it = this.mEntityWrapperList.iterator();
        while (it.hasNext()) {
            EntityWrapper<T> next = it.next();
            if (next.getItemType() == Integer.MAX_VALUE) {
                next.setItemType(getItemViewType());
            }
        }
        return this.mEntityWrapperList;
    }

    void registerDataSetObserver(HeaderFooterDataObserver headerFooterDataObserver) {
        this.mDataSetObservable.registerObserver(headerFooterDataObserver);
    }

    void unregisterDataSetObserver(HeaderFooterDataObserver headerFooterDataObserver) {
        this.mDataSetObservable.unregisterObserver(headerFooterDataObserver);
    }

    void registerIndexBarDataSetObserver(IndexBarDataObserver indexBarDataObserver) {
        this.mIndexBarDataSetObservable.registerObserver(indexBarDataObserver);
    }

    void unregisterIndexBarDataSetObserver(IndexBarDataObserver indexBarDataObserver) {
        this.mIndexBarDataSetObservable.unregisterObserver(indexBarDataObserver);
    }
}
