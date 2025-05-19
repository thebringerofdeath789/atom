package com.ipotensic.potensicpro.activities;

import android.content.Intent;
import android.view.View;
import android.view.ViewStub;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.LocalFileManager;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.kernel.activitys.KernelActivity;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.services.LocationService;
import com.ipotensic.potensicpro.R;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.listeners.OnCloseListener;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class DeviceMethodController extends BaseController implements View.OnClickListener {
    private ImageButton btnClose;
    private GuideItem curItem;
    private String flightType;
    private boolean isConnect;
    private ArrayList<GuideItem> items;
    private ImageView ivGif;
    private ImageView ivStep;
    private DeviceMethodListener listener;
    private TextView tvExplain;
    private TextView tvNext;
    private TextView tvTitle;

    public interface DeviceMethodListener {
        void methodListener();
    }

    public DeviceMethodController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.flightType = null;
        this.items = new ArrayList<>();
        this.isConnect = false;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        initData();
        ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_back);
        this.btnClose = (ImageButton) view.findViewById(R.id.btn_close);
        this.tvNext = (TextView) view.findViewById(R.id.tv_next);
        this.tvTitle = (TextView) view.findViewById(R.id.tv_code_title);
        this.ivGif = (ImageView) view.findViewById(R.id.iv_gif);
        this.ivStep = (ImageView) view.findViewById(R.id.iv_step);
        this.tvExplain = (TextView) view.findViewById(R.id.tv_explain);
        this.ivGif.setOnClickListener(this);
        imageButton.setOnClickListener(this);
        this.btnClose.setOnClickListener(this);
        if (this.items.size() > 0) {
            GuideItem guideItem = this.items.get(0);
            this.curItem = guideItem;
            showItem(guideItem);
        }
        setOnClickListener();
        setMiniCurShowItem();
    }

    private void setOnClickListener() {
        this.tvNext.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.potensicpro.activities.DeviceMethodController.1
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view) {
                if (DeviceMethodController.this.curItem == null) {
                    return;
                }
                if ("P3-SE".equalsIgnoreCase(DeviceMethodController.this.flightType) || "P3SE_V0".equalsIgnoreCase(DeviceMethodController.this.flightType) || "P5-2.7K".equalsIgnoreCase(DeviceMethodController.this.flightType)) {
                    if (DeviceMethodController.this.curItem.order != 2) {
                        DeviceMethodController.this.showNextItem();
                        return;
                    } else {
                        DeviceMethodController.this.startEnterActivity();
                        return;
                    }
                }
                if (DeviceMethodController.this.curItem.order != 3) {
                    DeviceMethodController.this.showNextItem();
                } else {
                    DeviceMethodController.this.startEnterActivity();
                }
            }
        });
    }

    private void showItem(GuideItem guideItem) {
        if (guideItem == null) {
            return;
        }
        this.curItem = guideItem;
        this.tvTitle.setText(guideItem.title);
        this.ivStep.setImageResource(this.curItem.topResId);
        this.tvExplain.setText(this.curItem.explain);
        boolean equalsIgnoreCase = "P3-SE".equalsIgnoreCase(this.flightType);
        int i = R.mipmap.img_btn_tell_us_normal;
        if (equalsIgnoreCase || "P3SE_V0".equalsIgnoreCase(this.flightType) || "P5-2.7K".equalsIgnoreCase(this.flightType)) {
            if (this.curItem.order == 2) {
                TextView textView = this.tvNext;
                if (FlightConfig.isConnectFlight()) {
                    i = R.mipmap.img_btn_tell_us_selected;
                }
                textView.setBackgroundResource(i);
                this.tvNext.setText(getContext().getString(R.string.connect_enter_device));
            } else {
                this.tvNext.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
                this.tvNext.setText(getContext().getString(R.string.next));
            }
        } else if (this.curItem.order == 3) {
            TextView textView2 = this.tvNext;
            if (FlightConfig.isConnectFlight() || UsbConfig.isUsbConnected) {
                i = R.mipmap.img_btn_tell_us_selected;
            }
            textView2.setBackgroundResource(i);
            this.tvNext.setText(getContext().getString(R.string.connect_enter_device));
        } else {
            this.tvNext.setBackgroundResource(R.mipmap.img_btn_tell_us_selected);
            this.tvNext.setText(getContext().getString(R.string.next));
        }
        if ("P5-2.7K".equalsIgnoreCase(this.flightType)) {
            Glide.with((FragmentActivity) getContext()).load(Integer.valueOf(this.curItem.gifId)).into(this.ivGif);
        } else {
            Glide.with((FragmentActivity) getContext()).load(Integer.valueOf(this.curItem.gifId)).asGif().into(this.ivGif);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showNextItem() {
        try {
            if (!"P3-SE".equalsIgnoreCase(this.flightType) && !"P3SE_V0".equalsIgnoreCase(this.flightType) && !"P5-2.7K".equalsIgnoreCase(this.flightType)) {
                if (this.curItem.order < 3) {
                    this.curItem = this.items.get(this.curItem.order + 1);
                }
                showItem(this.curItem);
            }
            if (this.curItem.order < 2) {
                this.curItem = this.items.get(this.curItem.order + 1);
            }
            showItem(this.curItem);
        } catch (Exception e) {
            DDLog.e("DeviceMethodController showNextItem exception is " + e.getMessage());
        }
    }

    private void showBeforeItem() {
        if (this.curItem.order > 0) {
            this.curItem = this.items.get(this.curItem.order - 1);
        }
        showItem(this.curItem);
    }

    public void setMiniCurShowItem() {
        String lastFlightModel = FlightConfig.getLastFlightModel();
        if (lastFlightModel != null && (lastFlightModel.equalsIgnoreCase("MiniSE") || lastFlightModel.equalsIgnoreCase("Mini") || lastFlightModel.equalsIgnoreCase(FlightConfig.MODEL_ATOM_LT))) {
            this.btnClose.setVisibility(4);
            this.tvNext.setVisibility(4);
            this.ivStep.setVisibility(4);
            if (FlightConfig.isConnectFlight()) {
                EventDispatcher.get().sendEvent(EventID.EVENT_MINI_CONNECTED);
                return;
            } else {
                if (FlightRevData.get().getFlightRevRemoteCtrlInfoData().getRemoteCtrlVersion() != null) {
                    showItem(this.items.get(1));
                    return;
                }
                return;
            }
        }
        this.btnClose.setVisibility(0);
        this.tvNext.setVisibility(0);
        this.ivStep.setVisibility(0);
    }

    public void onConnectStateChanged(boolean z) {
        if (this.isConnect == z) {
            return;
        }
        this.isConnect = z;
        setMiniCurShowItem();
        showItem(this.curItem);
    }

    public void onReceiveFlightType() {
        if (this.flightType == null || getContext() == null) {
            return;
        }
        if (!this.flightType.equalsIgnoreCase(FlightConfig.getLastFlightModel())) {
            initData();
            this.curItem = this.items.get(0);
        }
        showItem(this.curItem);
    }

    private void initData() {
        if (getContext() == null) {
            return;
        }
        this.flightType = FlightConfig.getLastFlightModel();
        this.items.clear();
        String str = this.flightType;
        if (str == null || str.equalsIgnoreCase(FlightConfig.MODEL_P1PRO) || this.flightType.equalsIgnoreCase("P1B")) {
            GuideItem guideItem = new GuideItem(0, getContext().getString(R.string.title_check_the_gimbal), R.drawable.img_gif_check_ptz, getContext().getString(R.string.content_check_the_gimbal), R.mipmap.img_connect_step1);
            GuideItem guideItem2 = new GuideItem(1, getContext().getString(R.string.title_install_the_blades), R.drawable.img_gif_install_blades, getContext().getString(R.string.content_install_blades), R.mipmap.img_connect_step2);
            GuideItem guideItem3 = new GuideItem(2, getContext().getString(R.string.title_turn_on_the_aircraft), R.drawable.img_gif_install_battery, getContext().getString(R.string.content_turn_on_aircraft), R.mipmap.img_connect_step3);
            GuideItem guideItem4 = new GuideItem(3, getContext().getString(R.string.title_turn_on_remote_control), R.drawable.img_gif_pro_install_remote_controler, "\n1." + getContext().getString(R.string.content_remote_control_long_press) + "\n\n2." + getContext().getString(R.string.content_remote_control_install) + "\n\n3." + getContext().getString(R.string.content_remote_control_connect) + "\n\n4." + getContext().getString(R.string.content_remote_control_phone) + "\n\n5." + getContext().getString(R.string.content_remote_control_adapter), R.mipmap.img_connect_step4);
            this.items.add(guideItem);
            this.items.add(guideItem2);
            this.items.add(guideItem3);
            this.items.add(guideItem4);
            return;
        }
        if (this.flightType.equalsIgnoreCase(FlightConfig.MODEL_P1SELF) || this.flightType.equalsIgnoreCase("P1A") || this.flightType.equalsIgnoreCase("P1-4K")) {
            GuideItem guideItem5 = new GuideItem(0, getContext().getString(R.string.title_install_the_blades), R.drawable.img_gif_install_blades, getContext().getString(R.string.content_install_blades), R.mipmap.img_connect_step1);
            GuideItem guideItem6 = new GuideItem(1, getContext().getString(R.string.title_turn_on_the_aircraft), R.drawable.img_gif_install_battery, getContext().getString(R.string.content_turn_on_aircraft), R.mipmap.img_connect_step2);
            GuideItem guideItem7 = new GuideItem(2, getContext().getString(R.string.title_turn_on_remote_control), R.drawable.img_gif_self_install_remote_controler, "\n1." + getContext().getString(R.string.content_remote_control_install) + "\n\n2." + getContext().getString(R.string.content_remote_control_phone) + "\n\n3." + getContext().getString(R.string.content_remote_control_long_press), R.mipmap.img_connect_step3);
            GuideItem guideItem8 = new GuideItem(3, getContext().getString(R.string.connect_wifi), R.drawable.img_step4_wifi, getContext().getString(R.string.content_wifi_connection), R.mipmap.img_connect_step4);
            this.items.add(guideItem5);
            this.items.add(guideItem6);
            this.items.add(guideItem7);
            this.items.add(guideItem8);
            return;
        }
        if (this.flightType.equalsIgnoreCase("P3-SE") || this.flightType.equalsIgnoreCase("P3SE_V0")) {
            return;
        }
        if (this.flightType.equalsIgnoreCase("MiniSE")) {
            GuideItem guideItem9 = new GuideItem(0, getContext().getString(R.string.guide_title_remoter_teach), R.drawable.img_gif_step1_mini, getContext().getString(R.string.guide_mini_open_remote_controller), R.mipmap.img_step1_mini);
            GuideItem guideItem10 = new GuideItem(1, getContext().getString(R.string.guide_title_install_teach), R.drawable.img_gif_step2_mini_se, getContext().getString(R.string.guide_mini_open_the_drone), R.mipmap.img_step2_mini);
            this.items.add(guideItem9);
            this.items.add(guideItem10);
            return;
        }
        if (this.flightType.equalsIgnoreCase(FlightConfig.MODEL_ATOM_LT)) {
            GuideItem guideItem11 = new GuideItem(0, getContext().getString(R.string.guide_title_remoter_teach), R.drawable.img_gif_step1_atomlt, getContext().getString(R.string.guide_mini_open_remote_controller), R.mipmap.img_step1_mini);
            GuideItem guideItem12 = new GuideItem(1, getContext().getString(R.string.guide_title_install_teach), R.drawable.img_gif_step2_atomlt, getContext().getString(R.string.guide_mini_open_the_drone), R.mipmap.img_step2_mini);
            this.items.add(guideItem11);
            this.items.add(guideItem12);
            return;
        }
        if (this.flightType.equalsIgnoreCase("Mini")) {
            GuideItem guideItem13 = new GuideItem(0, getContext().getString(R.string.guide_title_remoter_teach), R.drawable.img_gif_step1_mini, getContext().getString(R.string.guide_mini_open_remote_controller), R.mipmap.img_step1_mini);
            GuideItem guideItem14 = new GuideItem(1, getContext().getString(R.string.guide_title_install_teach), R.drawable.img_gif_step2_mini, getContext().getString(R.string.guide_mini_open_the_drone), R.mipmap.img_step2_mini);
            this.items.add(guideItem13);
            this.items.add(guideItem14);
            return;
        }
        if (this.flightType.equalsIgnoreCase("P5-2.7K")) {
            GuideItem guideItem15 = new GuideItem(0, getContext().getString(R.string.guide_title_install_teach), R.mipmap.img_guide_step1_p5, getContext().getString(R.string.guide_p5_step_1), R.mipmap.img_step1_p3);
            GuideItem guideItem16 = new GuideItem(1, getContext().getString(R.string.guide_title_remoter_teach), R.drawable.img_gif_remoter_teach_p5, getContext().getString(R.string.guide_p3_content_remoter_teach), R.mipmap.img_step2_p3);
            GuideItem guideItem17 = new GuideItem(2, getContext().getString(R.string.connect_wifi), R.drawable.img_step4_wifi_p5, getContext().getString(R.string.content_wifi_connection_p5), R.mipmap.img_step3_p3);
            this.items.add(guideItem15);
            this.items.add(guideItem16);
            this.items.add(guideItem17);
            return;
        }
        GuideItem guideItem18 = new GuideItem(0, getContext().getString(R.string.title_check_the_gimbal), R.drawable.img_gif_check_ptz, getContext().getString(R.string.content_check_the_gimbal), R.mipmap.img_connect_step1);
        GuideItem guideItem19 = new GuideItem(1, getContext().getString(R.string.title_install_the_blades), R.drawable.img_gif_install_blades, getContext().getString(R.string.content_install_blades), R.mipmap.img_connect_step2);
        GuideItem guideItem20 = new GuideItem(2, getContext().getString(R.string.title_turn_on_the_aircraft), R.drawable.img_gif_install_battery, getContext().getString(R.string.content_turn_on_aircraft), R.mipmap.img_connect_step3);
        GuideItem guideItem21 = new GuideItem(3, getContext().getString(R.string.title_turn_on_remote_control), R.drawable.img_gif_pro_install_remote_controler, "\n1." + getContext().getString(R.string.content_remote_control_long_press) + "\n\n2." + getContext().getString(R.string.content_remote_control_install) + "\n\n3." + getContext().getString(R.string.content_remote_control_connect) + "\n\n4." + getContext().getString(R.string.content_remote_control_phone) + "\n\n5." + getContext().getString(R.string.content_remote_control_adapter), R.mipmap.img_connect_step4);
        this.items.add(guideItem18);
        this.items.add(guideItem19);
        this.items.add(guideItem20);
        this.items.add(guideItem21);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i != 0 || this.ivGif == null || getContext() == null) {
            return;
        }
        showItem(this.curItem);
    }

    /* renamed from: com.ipotensic.potensicpro.activities.DeviceMethodController$2, reason: invalid class name */
    class AnonymousClass2 implements PermissionUtil.OnPermissionListener {
        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDenied() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onDeniedWithNeverAsk(String... strArr) {
        }

        AnonymousClass2() {
        }

        @Override // com.ipotensic.baselib.permission.PermissionUtil.OnPermissionListener
        public void onGrant() {
            LocalFileManager.getInstance().initExternalDir();
            LocalFileManager.getInstance().initMediaDir();
            LocationService.getInstance().init();
            if (FlightConfig.isConnectFlight() || UsbConfig.isUsbConnected) {
                DataManager.getInstance().close(new OnCloseListener() { // from class: com.ipotensic.potensicpro.activities.DeviceMethodController.2.1
                    @Override // com.logan.flight.listeners.OnCloseListener
                    public void onClosed() {
                        ActivityHelper.getInstance().makeActivityOnlyOne(KernelActivity.class, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.DeviceMethodController.2.1.1
                            @Override // com.ipotensic.baselib.listener.SimpleResultListener
                            public void onResult(Boolean bool) {
                                DeviceMethodController.this.getContext().startActivity(new Intent(DeviceMethodController.this.getContext(), (Class<?>) KernelActivity.class));
                                DeviceMethodController.this.getContext().finish();
                            }
                        });
                    }
                });
            } else {
                ActivityHelper.getInstance().makeActivityOnlyOne(KernelActivity.class, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.potensicpro.activities.DeviceMethodController.2.2
                    @Override // com.ipotensic.baselib.listener.SimpleResultListener
                    public void onResult(Boolean bool) {
                        DeviceMethodController.this.getContext().startActivity(new Intent(DeviceMethodController.this.getContext(), (Class<?>) KernelActivity.class));
                        DeviceMethodController.this.getContext().finish();
                    }
                });
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startEnterActivity() {
        PermissionUtil.requestAllPermissionWithDialog(getContext(), new AnonymousClass2());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        int id = view.getId();
        if (id != R.id.btn_back) {
            if (id == R.id.btn_close) {
                getContext().finish();
                return;
            }
            return;
        }
        String str = this.flightType;
        if (str != null && (str.equalsIgnoreCase("MiniSE") || this.flightType.equalsIgnoreCase("Mini") || this.flightType.equalsIgnoreCase(FlightConfig.MODEL_ATOM_LT))) {
            this.listener.methodListener();
            return;
        }
        GuideItem guideItem = this.curItem;
        if (guideItem == null) {
            this.listener.methodListener();
        } else if (guideItem.order == 0) {
            this.listener.methodListener();
        } else {
            showBeforeItem();
        }
    }

    public void setMethodListener(DeviceMethodListener deviceMethodListener) {
        this.listener = deviceMethodListener;
    }

    private class GuideItem {
        private String explain;
        private int gifId;
        private int order;
        private String title;
        private int topResId;

        public GuideItem(int i, String str, int i2, String str2, int i3) {
            this.order = i;
            this.title = str;
            this.gifId = i2;
            this.explain = str2;
            this.topResId = i3;
        }
    }
}
