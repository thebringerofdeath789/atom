package me.yokeyword.indexablerv.countrys;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;
import me.yokeyword.indexablerecyclerview.R;
import me.yokeyword.indexablerv.IndexableHeaderAdapter;
import me.yokeyword.indexablerv.countrys.HotCountryAdapter;

/* loaded from: classes4.dex */
public class BannerHeaderAdapter extends IndexableHeaderAdapter {
    private static final int TYPE = 1;
    private HotCountryAdapter adapter;
    private Context context;
    private ArrayList<CityEntity> hotCityEntities;

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public int getItemViewType() {
        return 1;
    }

    public BannerHeaderAdapter(Context context, String str, String str2, List<CityEntity> list) {
        super(str, str2, list);
        this.hotCityEntities = new ArrayList<>();
        this.context = context;
        initHotCityData();
    }

    private void initHotCityData() {
        String[] stringArray = this.context.getResources().getStringArray(R.array.hot_country);
        int[] intArray = this.context.getResources().getIntArray(R.array.code_country);
        for (int i = 0; i < stringArray.length; i++) {
            this.hotCityEntities.add(new CityEntity(intArray[i], stringArray[i]));
        }
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public RecyclerView.ViewHolder onCreateContentViewHolder(ViewGroup viewGroup) {
        return new VH(LayoutInflater.from(this.context).inflate(R.layout.item_city_header, viewGroup, false));
    }

    @Override // me.yokeyword.indexablerv.AbstractHeaderFooterAdapter
    public void onBindContentViewHolder(RecyclerView.ViewHolder viewHolder, Object obj) {
        VH vh = (VH) viewHolder;
        if (this.adapter != null) {
            return;
        }
        this.adapter = new HotCountryAdapter(this.context, this.hotCityEntities);
        vh.rv.setLayoutManager(new GridLayoutManager(this.context, 3));
        vh.rv.addItemDecoration(new SpaceItemDecoration(5, 30));
        vh.rv.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new HotCountryAdapter.OnItemClickListener() { // from class: me.yokeyword.indexablerv.countrys.BannerHeaderAdapter.1
            @Override // me.yokeyword.indexablerv.countrys.HotCountryAdapter.OnItemClickListener
            public void onItemClick(CityEntity cityEntity) {
                Intent intent = new Intent();
                intent.putExtra("country_code", cityEntity.getCode());
                intent.putExtra("country_name", cityEntity.getName());
                ((Activity) BannerHeaderAdapter.this.context).setResult(-1, intent);
                ((Activity) BannerHeaderAdapter.this.context).finish();
            }
        });
    }

    private class VH extends RecyclerView.ViewHolder {
        RecyclerView rv;

        public VH(View view) {
            super(view);
            this.rv = (RecyclerView) view.findViewById(R.id.rv);
        }
    }
}
