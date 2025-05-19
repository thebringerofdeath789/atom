package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.adapter.MyLinearLayoutManager;
import com.ipotensic.kernel.bean.FlightNotes;
import com.ipotensic.kernel.view.deleteview.SwipeItemLayout;
import com.ipotensic.potensicpro.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.litepal.LitePal;

/* loaded from: classes2.dex */
public class FlightRecordActivity extends BaseActivity implements View.OnClickListener {
    private ImageView ivEmpty;
    private List<FlightNotes> recordList;
    private RecyclerView recyclerView;
    private Toolbar toolbar;
    private TextView tvEmpty;

    @Override // com.ipotensic.baselib.base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStateBarShow(true);
        setContentView(R.layout.activity_flight_record);
        initData();
        initView();
        setToolBar();
    }

    private void setToolBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        this.toolbar = toolbar;
        toolbar.findViewById(R.id.iv_back).setOnClickListener(this);
        ((TextView) this.toolbar.findViewById(R.id.tv_code_title)).setText(getResources().getString(R.string.main_flight_record));
        setSupportActionBar(this.toolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setDisplayShowTitleEnabled(false);
        supportActionBar.setHomeButtonEnabled(false);
        supportActionBar.setDisplayHomeAsUpEnabled(false);
    }

    private void initData() {
        if (this.recordList == null) {
            this.recordList = new ArrayList();
        }
        this.recordList.clear();
        List<FlightNotes> findAll = LitePal.findAll(FlightNotes.class, new long[0]);
        this.recordList = findAll;
        Collections.sort(findAll);
    }

    private void initView() {
        this.ivEmpty = (ImageView) findViewById(R.id.iv_empty);
        this.tvEmpty = (TextView) findViewById(R.id.tv_empty);
        this.recyclerView = (RecyclerView) findViewById(R.id.rv_view);
        this.recyclerView.setLayoutManager(new MyLinearLayoutManager(this, 1, false));
        this.recyclerView.addOnItemTouchListener(new SwipeItemLayout.OnSwipeItemTouchListener(this));
        this.recyclerView.setAdapter(new FlightRecordAdapter());
        this.recyclerView.addItemDecoration(new DividerLineaItemDecoration());
        if (this.recordList.size() == 0) {
            this.recyclerView.setVisibility(8);
            this.tvEmpty.setVisibility(0);
            this.ivEmpty.setVisibility(0);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.iv_back) {
            setResult(-1, new Intent());
            finish();
        }
    }

    private class FlightRecordAdapter extends RecyclerView.Adapter<ViewHolder> {
        private FlightRecordAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new ViewHolder(LayoutInflater.from(FlightRecordActivity.this).inflate(R.layout.view_adapter_flight_record, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(ViewHolder viewHolder, int i) {
            FlightNotes flightNotes = (FlightNotes) FlightRecordActivity.this.recordList.get(i);
            String formatCreateTime2 = FormatUtil.formatCreateTime2(flightNotes.getStartTime());
            String formatDuration1 = FormatUtil.formatDuration1(flightNotes.getDuration());
            TextView textView = viewHolder.tvDate;
            if (TextUtils.isEmpty(formatCreateTime2)) {
                formatCreateTime2 = "";
            }
            textView.setText(formatCreateTime2);
            TextView textView2 = viewHolder.tvDuration;
            if (TextUtils.isEmpty(formatDuration1)) {
                formatDuration1 = "";
            }
            textView2.setText(formatDuration1);
            if (SPHelper.getInstance().isFt()) {
                viewHolder.tvDistance.setText(String.format(FlightRecordActivity.this.getString(R.string.units_ft), Double.valueOf(flightNotes.getDistance() * 3.28083989501d)));
                viewHolder.tvSpeed.setText(String.format(FlightRecordActivity.this.getString(R.string.units_mph), Double.valueOf(flightNotes.getSpeed() * 2.23693632d)));
                viewHolder.tvHeight.setText(String.format(FlightRecordActivity.this.getString(R.string.units_ft), Double.valueOf(flightNotes.getHeight() * 3.28083989501d)));
            } else {
                viewHolder.tvDistance.setText(String.format(FlightRecordActivity.this.getString(R.string.units_m), Double.valueOf(flightNotes.getDistance())));
                viewHolder.tvSpeed.setText(String.format(FlightRecordActivity.this.getString(R.string.units_ms), Double.valueOf(flightNotes.getSpeed())));
                viewHolder.tvHeight.setText(String.format(FlightRecordActivity.this.getString(R.string.units_m), Double.valueOf(flightNotes.getHeight())));
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            return FlightRecordActivity.this.recordList.size();
        }

        private class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
            private TextView tvDate;
            private TextView tvDistance;
            private TextView tvDuration;
            private TextView tvHeight;
            private TextView tvSpeed;

            private ViewHolder(View view) {
                super(view);
                this.tvDate = (TextView) view.findViewById(R.id.tv_date);
                this.tvDuration = (TextView) view.findViewById(R.id.tv_duration);
                this.tvDistance = (TextView) view.findViewById(R.id.tv_distance);
                this.tvSpeed = (TextView) view.findViewById(R.id.edt_speed);
                this.tvHeight = (TextView) view.findViewById(R.id.tv_height);
                view.findViewById(R.id.delete).setOnClickListener(this);
            }

            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                if (view.getId() == R.id.delete) {
                    int adapterPosition = getAdapterPosition();
                    if (adapterPosition >= 0) {
                        LitePal.delete(FlightNotes.class, ((FlightNotes) FlightRecordActivity.this.recordList.get(adapterPosition)).getId());
                        FlightRecordActivity.this.recordList.remove(adapterPosition);
                        FlightRecordAdapter.this.notifyItemRemoved(adapterPosition);
                    }
                    if (FlightRecordActivity.this.recordList.size() == 0) {
                        FlightRecordActivity.this.recyclerView.setVisibility(8);
                        FlightRecordActivity.this.tvEmpty.setVisibility(0);
                        FlightRecordActivity.this.ivEmpty.setVisibility(0);
                    }
                }
            }
        }
    }

    private class DividerLineaItemDecoration extends RecyclerView.ItemDecoration {
        private DividerLineaItemDecoration() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void onDraw(Canvas canvas, RecyclerView recyclerView, RecyclerView.State state) {
            super.onDraw(canvas, recyclerView, state);
            Paint paint = new Paint();
            paint.setColor(-1);
            int childCount = recyclerView.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = recyclerView.getChildAt(i);
                canvas.drawRect(childAt.getLeft(), childAt.getTop(), childAt.getRight(), childAt.getBottom(), paint);
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.ItemDecoration
        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            rect.set(0, 0, 0, 20);
        }
    }
}
