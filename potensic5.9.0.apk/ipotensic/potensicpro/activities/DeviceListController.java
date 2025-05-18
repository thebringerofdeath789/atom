package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.view.animation.AlphaAnimation;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.potensicpro.R;
import com.ipotensic.potensicpro.view.DividerLineaItemDecoration;
import com.logan.flight.FlightConfig;
import com.logan.flight.type.Flight;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class DeviceListController extends BaseController implements View.OnClickListener {
    private DeviceListAdapter adapter;
    private List<DeviceInfo> list;

    private interface OnItemClickListener {
        void onItemClick(int i);
    }

    public DeviceListController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.list = new ArrayList();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        if (SPHelper.getInstance().getFlight() == null) {
            view.findViewById(R.id.btn_close).setVisibility(4);
        }
        view.findViewById(R.id.btn_close).setOnClickListener(this);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.ry_view);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext());
        this.adapter = new DeviceListAdapter();
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.addItemDecoration(new DividerLineaItemDecoration(1));
        recyclerView.setAdapter(this.adapter);
        this.adapter.setOnItemClickListener(new OnItemClickListener() { // from class: com.ipotensic.potensicpro.activities.DeviceListController.1
            @Override // com.ipotensic.potensicpro.activities.DeviceListController.OnItemClickListener
            public void onItemClick(int i) {
                DeviceListController.this.closeActivity(i);
            }
        });
    }

    public void initData() {
        Flight lastFlight = FlightConfig.getLastFlight();
        int i = R.mipmap.img_bg_mini_se_selected;
        int i2 = R.mipmap.img_bg_mini_lt_selected;
        int i3 = R.mipmap.img_bg_mini_selected;
        if (lastFlight == null) {
            this.list.add(new DeviceInfo("Atom", getContext().getString(R.string.drone_with_gimbal), R.mipmap.img_bg_mini_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_ATOM_LT, getContext().getString(R.string.connect_usb), R.mipmap.img_bg_mini_lt_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_ATOM_SE, getContext().getString(R.string.connect_usb), R.mipmap.img_bg_mini_se_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_DREAMER_P5, getContext().getString(R.string.title_wifi_connection), R.mipmap.img_bg_p5_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_DREAMER_PRO, getContext().getString(R.string.drone_with_gimbal), R.mipmap.img_bg_pro_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_DREAMER_4K, getContext().getString(R.string.title_wifi_connection), R.mipmap.img_bg_self_selected));
        } else {
            List<DeviceInfo> list = this.list;
            String string = getContext().getString(R.string.drone_with_gimbal);
            if (FlightConfig.isAtomPanTilt()) {
                i3 = R.mipmap.img_bg_mini_normal;
            }
            list.add(new DeviceInfo("Atom", string, i3));
            List<DeviceInfo> list2 = this.list;
            String string2 = getContext().getString(R.string.connect_usb);
            if (FlightConfig.isAtomLT()) {
                i2 = R.mipmap.img_bg_mini_lt_normal;
            }
            list2.add(new DeviceInfo(FlightConfig.TYPE_ATOM_LT, string2, i2));
            List<DeviceInfo> list3 = this.list;
            String string3 = getContext().getString(R.string.connect_usb);
            if (FlightConfig.is_Atom_SE_Series()) {
                i = R.mipmap.img_bg_mini_se_normal;
            }
            list3.add(new DeviceInfo(FlightConfig.TYPE_ATOM_SE, string3, i));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_DREAMER_P5, getContext().getString(R.string.title_wifi_connection), FlightConfig.isP5() ? R.mipmap.img_bg_p5_normal : R.mipmap.img_bg_p5_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_DREAMER_PRO, getContext().getString(R.string.drone_with_gimbal), (FlightConfig.isP1Pro() || FlightConfig.isP1SelfB()) ? R.mipmap.img_bg_pro_normal : R.mipmap.img_bg_pro_selected));
            this.list.add(new DeviceInfo(FlightConfig.TYPE_DREAMER_4K, getContext().getString(R.string.title_wifi_connection), FlightConfig.isP1Self() ? R.mipmap.img_bg_self_normal : R.mipmap.img_bg_self_selected));
        }
        DeviceListAdapter deviceListAdapter = this.adapter;
        if (deviceListAdapter != null) {
            deviceListAdapter.notifyDataSetChanged();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_close) {
            AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
            alphaAnimation.setDuration(400L);
            getBaseView().startAnimation(alphaAnimation);
            getContext().finish();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void closeActivity(int i) {
        AlphaAnimation alphaAnimation = new AlphaAnimation(1.0f, 0.0f);
        alphaAnimation.setDuration(400L);
        getBaseView().startAnimation(alphaAnimation);
        Intent intent = new Intent();
        intent.putExtra("device_name", this.list.get(i).text);
        getContext().setResult(-1, intent);
        getContext().finish();
    }

    private class DeviceListAdapter extends RecyclerView.Adapter<DeviceTypeViewHolder> {
        private OnItemClickListener listener;

        private DeviceListAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public DeviceTypeViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new DeviceTypeViewHolder(LayoutInflater.from(DeviceListController.this.getContext()).inflate(R.layout.view_adapter_device_list, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(DeviceTypeViewHolder deviceTypeViewHolder, final int i) {
            if (DeviceListController.this.list == null || DeviceListController.this.list.size() == 0) {
                return;
            }
            DeviceInfo deviceInfo = (DeviceInfo) DeviceListController.this.list.get(i);
            deviceTypeViewHolder.ivBg.setImageResource(deviceInfo.resId);
            deviceTypeViewHolder.tvDeviceType.setText(deviceInfo.text);
            deviceTypeViewHolder.tvDetail.setText(deviceInfo.detail);
            deviceTypeViewHolder.ivBg.setOnClickListener(new View.OnClickListener() { // from class: com.ipotensic.potensicpro.activities.DeviceListController.DeviceListAdapter.1
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    DeviceListAdapter.this.listener.onItemClick(i);
                }
            });
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (DeviceListController.this.list != null) {
                return DeviceListController.this.list.size();
            }
            return 0;
        }

        class DeviceTypeViewHolder extends RecyclerView.ViewHolder {
            private ConstraintLayout clContent;
            private ImageView ivBg;
            private TextView tvDetail;
            private TextView tvDeviceType;

            public DeviceTypeViewHolder(View view) {
                super(view);
                this.ivBg = (ImageView) view.findViewById(R.id.iv_bg);
                this.tvDeviceType = (TextView) view.findViewById(R.id.tv_device_type);
                this.tvDetail = (TextView) view.findViewById(R.id.tv_detail);
                this.clContent = (ConstraintLayout) view.findViewById(R.id.cl_content);
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
            this.listener = onItemClickListener;
        }
    }

    static class DeviceInfo {
        private String detail;
        private int resId;
        private String text;

        public DeviceInfo(String str, String str2, int i) {
            this.text = str;
            this.detail = str2;
            this.resId = i;
        }
    }
}