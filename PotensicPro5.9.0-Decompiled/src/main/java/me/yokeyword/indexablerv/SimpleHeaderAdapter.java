package me.yokeyword.indexablerv;

import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import me.yokeyword.indexablerv.IndexableEntity;

/* loaded from: classes4.dex */
public class SimpleHeaderAdapter<T extends IndexableEntity> extends IndexableHeaderAdapter<T> {
    private IndexableAdapter<T> mAdapter;

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public int getItemViewType() {
        return Integer.MAX_VALUE;
    }

    public SimpleHeaderAdapter(IndexableAdapter<T> indexableAdapter, String str, String str2, List<T> list) {
        super(str, str2, list);
        this.mAdapter = indexableAdapter;
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
        return this.mAdapter.onCreateContentViewHolder(viewGroup);
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, T t) {
        this.mAdapter.onBindContentViewHolder(viewHolder, t);
    }
}
