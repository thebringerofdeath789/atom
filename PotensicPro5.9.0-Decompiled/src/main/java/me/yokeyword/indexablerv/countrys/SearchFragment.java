package me.yokeyword.indexablerv.countrys;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.indexablerecyclerview.R;

/* loaded from: classes4.dex */
public class SearchFragment extends Fragment {
    private Activity context;
    private SearchAdapter mAdapter;
    private List<CityEntity> mDatas;
    private String mQueryText;
    private RecyclerView mRecyclerView;

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_search_city, viewGroup, false);
        this.mRecyclerView = (RecyclerView) inflate.findViewById(R.id.recy);
        return inflate;
    }

    public void bindDatas(List<CityEntity> list, Activity activity) {
        this.mDatas = list;
        this.context = activity;
        this.mAdapter = new SearchAdapter();
        this.mRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        this.mRecyclerView.setHasFixedSize(true);
        this.mRecyclerView.setAdapter(this.mAdapter);
        if (this.mQueryText != null) {
            this.mAdapter.getFilter().filter(this.mQueryText);
        }
    }

    public void bindQueryText(String str) {
        if (this.mDatas == null) {
            this.mQueryText = str.toLowerCase();
        } else {
            if (TextUtils.isEmpty(str)) {
                return;
            }
            this.mAdapter.getFilter().filter(str.toLowerCase());
        }
    }

    private class SearchAdapter extends RecyclerView.Adapter<VH> implements Filterable {
        private List<CityEntity> items;

        public SearchAdapter() {
            ArrayList arrayList = new ArrayList();
            this.items = arrayList;
            arrayList.clear();
            this.items.addAll(SearchFragment.this.mDatas);
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            final VH vh = new VH(LayoutInflater.from(SearchFragment.this.getActivity()).inflate(R.layout.item_city, viewGroup, false));
            vh.itemView.setOnClickListener(new View.OnClickListener() { // from class: me.yokeyword.indexablerv.countrys.SearchFragment.SearchAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int adapterPosition = vh.getAdapterPosition();
                    if (adapterPosition >= 0) {
                        Intent intent = new Intent();
                        intent.putExtra("country_code", ((CityEntity) SearchAdapter.this.items.get(adapterPosition)).getCode());
                        intent.putExtra("country_name", ((CityEntity) SearchAdapter.this.items.get(adapterPosition)).getName());
                        SearchFragment.this.context.setResult(-1, intent);
                        SearchFragment.this.context.finish();
                    }
                }
            });
            return vh;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return this.items.size();
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i) {
            vh.tvName.setText(this.items.get(i).getName());
        }

        @Override // android.widget.Filterable
        public Filter getFilter() {
            return new Filter() { // from class: me.yokeyword.indexablerv.countrys.SearchFragment.SearchAdapter.2
                @Override // android.widget.Filter
                protected Filter.FilterResults performFiltering(CharSequence charSequence) {
                    ArrayList arrayList = new ArrayList();
                    for (CityEntity cityEntity : SearchFragment.this.mDatas) {
                        if (cityEntity.getPinyin().startsWith(charSequence.toString()) || cityEntity.getName().contains(charSequence)) {
                            arrayList.add(cityEntity);
                        }
                    }
                    Filter.FilterResults filterResults = new Filter.FilterResults();
                    filterResults.count = arrayList.size();
                    filterResults.values = arrayList;
                    return filterResults;
                }

                @Override // android.widget.Filter
                protected void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
                    ArrayList arrayList = (ArrayList) filterResults.values;
                    SearchAdapter.this.items.clear();
                    SearchAdapter.this.items.addAll(arrayList);
                    SearchAdapter.this.notifyDataSetChanged();
                }
            };
        }

        class VH extends RecyclerView.ViewHolder {
            private TextView tvName;

            public VH(View view) {
                super(view);
                this.tvName = (TextView) view.findViewById(R.id.tv_name);
            }
        }
    }
}
