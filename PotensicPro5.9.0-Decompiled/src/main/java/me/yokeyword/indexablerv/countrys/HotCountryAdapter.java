package me.yokeyword.indexablerv.countrys;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import me.yokeyword.indexablerecyclerview.R;

/* loaded from: classes4.dex */
public class HotCountryAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private List<CityEntity> data;
    private OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(CityEntity cityEntity);
    }

    public HotCountryAdapter(Context context, List<CityEntity> list) {
        this.data = list;
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        return new VH(LayoutInflater.from(this.context).inflate(R.layout.adapter_head_country_item, (ViewGroup) null));
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        VH vh = (VH) viewHolder;
        vh.f8tv.setText(this.data.get(i).getName());
        vh.f8tv.setOnClickListener(new View.OnClickListener() { // from class: me.yokeyword.indexablerv.countrys.HotCountryAdapter.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (HotCountryAdapter.this.listener != null) {
                    HotCountryAdapter.this.listener.onItemClick((CityEntity) HotCountryAdapter.this.data.get(i));
                }
            }
        });
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.data.size();
    }

    class VH extends RecyclerView.ViewHolder {

        /* renamed from: tv, reason: collision with root package name */
        TextView f8tv;

        public VH(View view) {
            super(view);
            this.f8tv = (TextView) view.findViewById(R.id.f5tv);
        }
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}
