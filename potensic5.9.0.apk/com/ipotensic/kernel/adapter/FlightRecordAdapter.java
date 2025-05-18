package com.ipotensic.kernel.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.FlightRecordBean;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: classes2.dex */
public class FlightRecordAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private Context context;
    private OnItemClickListener listener;
    private List<FlightRecordBean> recordList;
    private final int HEAD_TYPE = 0;
    private final int BODY_TYPE = 1;

    public interface OnItemClickListener {
        void isEmpty(boolean z);

        void onItemClick(int i);
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemViewType(int i) {
        return i == 0 ? 0 : 1;
    }

    public FlightRecordAdapter(Context context) {
        this.context = context;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (i == 0) {
            return new HeadViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1965R.layout.view_item_flight_record_head, viewGroup, false));
        }
        if (i == 1) {
            return new BodyViewHolder(LayoutInflater.from(viewGroup.getContext()).inflate(C1965R.layout.view_item_flight_record_body, viewGroup, false));
        }
        return null;
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, final int i) {
        if (viewHolder instanceof BodyViewHolder) {
            BodyViewHolder bodyViewHolder = (BodyViewHolder) viewHolder;
            if (i % 2 == 0) {
                bodyViewHolder.linearLayout.setBackgroundResource(C1965R.color.color_flight_point_record_bg);
            } else {
                bodyViewHolder.linearLayout.setBackgroundResource(C1965R.color.color_bg_upgrade_dialog);
            }
            bodyViewHolder.tvFlightRecord.setText(this.recordList.get(i - 1).getDate());
            bodyViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.kernel.adapter.FlightRecordAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    FlightRecordAdapter.this.listener.onItemClick(i - 1);
                }
            });
        }
    }

    @Override // androidx.recyclerview.widget.RecyclerView.Adapter
    public int getItemCount() {
        return this.recordList.size() + 1;
    }

    class BodyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private LinearLayout linearLayout;
        private TextView tvFlightRecord;

        public BodyViewHolder(View view) {
            super(view);
            this.tvFlightRecord = (TextView) view.findViewById(C1965R.id.tv_item);
            this.linearLayout = (LinearLayout) view.findViewById(C1965R.id.item_ll);
            view.findViewById(C1965R.id.delete).setOnClickListener(this);
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() == C1965R.id.delete) {
                int adapterPosition = getAdapterPosition() - 1;
                LitePal.delete(FlightRecordBean.class, ((FlightRecordBean) FlightRecordAdapter.this.recordList.get(adapterPosition)).getId());
                FlightRecordAdapter.this.recordList.remove(adapterPosition);
                FlightRecordAdapter.this.notifyDataSetChanged();
                if (FlightRecordAdapter.this.recordList.size() == 0) {
                    FlightRecordAdapter.this.listener.isEmpty(true);
                }
            }
        }
    }

    class HeadViewHolder extends RecyclerView.ViewHolder {
        private TextView tvTitle;

        public HeadViewHolder(View view) {
            super(view);
            this.tvTitle = (TextView) view.findViewById(C1965R.id.tv_code_title);
        }
    }

    public void setData(List<FlightRecordBean> list) {
        this.recordList = list;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.listener = onItemClickListener;
    }
}