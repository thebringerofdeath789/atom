package me.yokeyword.indexablerv;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import me.yokeyword.indexablerv.IndexableEntity;
import me.yokeyword.indexablerv.database.DataObservable;
import me.yokeyword.indexablerv.database.DataObserver;

/* loaded from: classes4.dex */
public abstract class IndexableAdapter<T extends IndexableEntity> {
    static final int TYPE_ALL = 0;
    static final int TYPE_CLICK_CONTENT = 2;
    static final int TYPE_CLICK_TITLE = 1;
    static final int TYPE_LONG_CLICK_CONTENT = 4;
    static final int TYPE_LONG_CLICK_TITLE = 3;
    private IndexCallback<T> mCallback;
    private OnItemContentClickListener mContentClickListener;
    private OnItemContentLongClickListener mContentLongClickListener;
    private final DataObservable mDataSetObservable = new DataObservable();
    private List<T> mDatas;
    private OnItemTitleClickListener mTitleClickListener;
    private OnItemTitleLongClickListener mTitleLongClickListener;

    public interface IndexCallback<T> {
        void onFinished(List<EntityWrapper<T>> list);
    }

    public interface OnItemContentClickListener<T> {
        void onItemClick(View view, int i, int i2, T t);
    }

    public interface OnItemContentLongClickListener<T> {
        boolean onItemLongClick(View view, int i, int i2, T t);
    }

    public interface OnItemTitleClickListener {
        void onItemClick(View view, int i, String str);
    }

    public interface OnItemTitleLongClickListener {
        boolean onItemLongClick(View view, int i, String str);
    }

    public abstract void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, T t);

    public abstract void onBindTitleViewHolder(RecyclerView.ViewHolder viewHolder, String str);

    public abstract RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup);

    public abstract RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup viewGroup);

    public void setDatas(List<T> list) {
        setDatas(list, null);
    }

    public void setDatas(List<T> list, IndexCallback<T> indexCallback) {
        this.mCallback = indexCallback;
        this.mDatas = list;
        notifyInited();
    }

    public void setOnItemTitleClickListener(OnItemTitleClickListener onItemTitleClickListener) {
        this.mTitleClickListener = onItemTitleClickListener;
        notifySetListener(1);
    }

    public void setOnItemContentClickListener(OnItemContentClickListener<T> onItemContentClickListener) {
        this.mContentClickListener = onItemContentClickListener;
        notifySetListener(2);
    }

    public void setOnItemTitleLongClickListener(OnItemTitleLongClickListener onItemTitleLongClickListener) {
        this.mTitleLongClickListener = onItemTitleLongClickListener;
        notifySetListener(3);
    }

    public void setOnItemContentLongClickListener(OnItemContentLongClickListener<T> onItemContentLongClickListener) {
        this.mContentLongClickListener = onItemContentLongClickListener;
        notifySetListener(4);
    }

    public void notifyDataSetChanged() {
        this.mDataSetObservable.notifyInited();
    }

    private void notifyInited() {
        this.mDataSetObservable.notifyInited();
    }

    private void notifySetListener(int i) {
        this.mDataSetObservable.notifySetListener(i);
    }

    public List<T> getItems() {
        return this.mDatas;
    }

    IndexCallback<T> getIndexCallback() {
        return this.mCallback;
    }

    OnItemTitleClickListener getOnItemTitleClickListener() {
        return this.mTitleClickListener;
    }

    OnItemTitleLongClickListener getOnItemTitleLongClickListener() {
        return this.mTitleLongClickListener;
    }

    OnItemContentClickListener getOnItemContentClickListener() {
        return this.mContentClickListener;
    }

    OnItemContentLongClickListener getOnItemContentLongClickListener() {
        return this.mContentLongClickListener;
    }

    void registerDataSetObserver(DataObserver dataObserver) {
        this.mDataSetObservable.registerObserver(dataObserver);
    }

    void unregisterDataSetObserver(DataObserver dataObserver) {
        this.mDataSetObservable.unregisterObserver(dataObserver);
    }
}
