package me.yokeyword.indexablerv.countrys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import me.yokeyword.indexablerecyclerview.R;
import me.yokeyword.indexablerv.IndexableAdapter;

/* loaded from: classes4.dex */
public class CityAdapter extends IndexableAdapter<CityEntity> {
    private LayoutInflater mInflater;

    public CityAdapter(Context context) {
        this.mInflater = LayoutInflater.from(context);
    }

    @Override // me.yokeyword.indexablerv.IndexableAdapter
    public RecyclerView.ViewHolder onCreateTitleViewHolder(ViewGroup viewGroup) {
        return new IndexVH(this.mInflater.inflate(R.layout.item_index_city, viewGroup, false));
    }

    @Override // me.yokeyword.indexablerv.IndexableAdapter
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
        return new ContentVH(this.mInflater.inflate(R.layout.item_city, viewGroup, false));
    }

    @Override // me.yokeyword.indexablerv.IndexableAdapter
    public void onBindTitleViewHolder(RecyclerView.ViewHolder viewHolder, String str) {
        ((IndexVH) viewHolder).f7tv.setText(str);
    }

    @Override // me.yokeyword.indexablerv.IndexableAdapter
    public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, CityEntity cityEntity) {
        ((ContentVH) viewHolder).f6tv.setText(cityEntity.getName());
    }

    private class IndexVH extends RecyclerView.ViewHolder {

        /* renamed from: tv, reason: collision with root package name */
        TextView f7tv;

        public IndexVH(View view) {
            super(view);
            this.f7tv = (TextView) view.findViewById(R.id.tv_index);
        }
    }

    private class ContentVH extends RecyclerView.ViewHolder {

        /* renamed from: tv, reason: collision with root package name */
        TextView f6tv;

        public ContentVH(View view) {
            super(view);
            this.f6tv = (TextView) view.findViewById(R.id.tv_name);
        }
    }
}
