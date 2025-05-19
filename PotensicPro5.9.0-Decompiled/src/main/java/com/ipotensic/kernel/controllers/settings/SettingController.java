package com.ipotensic.kernel.controllers.settings;

import android.content.Context;
import android.os.Build;
import android.view.View;
import android.view.ViewStub;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.controllers.BaseController;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class SettingController extends BaseController implements View.OnClickListener {
    private SettingAdapter adapter;
    private BaseController[] baseControllers;
    private boolean disableClick;
    private boolean isGuideDismiss;
    private LinearLayout layoutIndicator;
    private SettingControllerListener listener;
    private Setting1Controller setting1Controller;
    private Setting2Controller setting2Controller;
    private Setting3Controller setting3Controller;
    private Setting4Controller setting4Controller;
    private Setting5Controller setting5Controller;
    private ImageButton settingBtn1;
    private ImageButton settingBtn2;
    private ImageButton settingBtn3;
    private ImageButton settingBtn4;
    private ImageButton settingBtn5;
    private View view;
    private View viewBlank;

    public interface SettingControllerListener {
        void onSettingDismissed();
    }

    public SettingController(AppCompatActivity appCompatActivity, ViewStub viewStub) {
        super(appCompatActivity, viewStub);
        this.disableClick = false;
        this.isGuideDismiss = false;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.view = view;
        View findViewById = view.findViewById(R.id.view_left_blank);
        this.viewBlank = findViewById;
        findViewById.setOnClickListener(this);
        this.settingBtn1 = (ImageButton) view.findViewById(R.id.btn_indicator_1);
        this.settingBtn2 = (ImageButton) view.findViewById(R.id.btn_indicator_2);
        this.settingBtn3 = (ImageButton) view.findViewById(R.id.btn_indicator_3);
        this.settingBtn4 = (ImageButton) view.findViewById(R.id.btn_indicator_4);
        this.settingBtn5 = (ImageButton) view.findViewById(R.id.btn_indicator_5);
        this.layoutIndicator = (LinearLayout) view.findViewById(R.id.layout_indicator);
        this.setting1Controller = new Setting1Controller(getContext(), (ViewStub) view.findViewById(R.id.stub_setting_1));
        this.setting2Controller = new Setting2Controller(getContext(), (ViewStub) view.findViewById(R.id.stub_setting_2));
        this.setting3Controller = new Setting3Controller(getContext(), (ViewStub) view.findViewById(R.id.stub_setting_3));
        this.setting4Controller = new Setting4Controller(getContext(), (ViewStub) view.findViewById(R.id.stub_setting_4));
        this.setting5Controller = new Setting5Controller(getContext(), (ViewStub) view.findViewById(R.id.stub_setting_5));
        SettingAdapter controller = new SettingAdapter().setIndicators(R.id.btn_indicator_1, R.id.btn_indicator_2, R.id.btn_indicator_3, R.id.btn_indicator_4, R.id.btn_indicator_5).setController(this.setting1Controller, this.setting2Controller, this.setting3Controller, this.setting4Controller, this.setting5Controller);
        this.adapter = controller;
        controller.setCurPosition(0);
        if ("OnePlus".equals(Build.BRAND)) {
            view.setFitsSystemWindows(true);
        }
    }

    public boolean isGuideDismiss() {
        return this.isGuideDismiss;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startSettingGuide() {
        DDLog.e("开始设置指引");
        if (SPHelper.getInstance().getMainSetting()) {
            this.isGuideDismiss = true;
            SPHelper.getInstance().setMainSetting(false);
            NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.layoutIndicator, new RelativeGuide(R.layout.guide_setting, 3)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setBackgroundColor(getContext().getResources().getColor(R.color.color_guide_bg))).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.controllers.settings.SettingController.1
                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onShowed(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller) {
                    SettingController.this.isGuideDismiss = false;
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                    SettingController.this.isGuideDismiss = false;
                }
            }).show();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.view_left_blank) {
            if (FlightConfig.isSettingCalibration) {
                ToastUtil.showImageTop(getContext(), getContext().getString(R.string.toast_calibration_close), R.mipmap.icon_gyroscope_galibration);
            } else {
                setVisibility(8);
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0 || getBaseView() != null) {
            if (i == 0) {
                transInRight(getBaseView());
                updateSetting();
                if (this.setting1Controller != null) {
                    FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
                    if (flightRevStateData.getSpeedMode() != -1) {
                        this.setting1Controller.setSpeedUI(flightRevStateData.getSpeedMode());
                        return;
                    }
                    return;
                }
                return;
            }
            Setting2Controller setting2Controller = this.setting2Controller;
            if (setting2Controller != null) {
                setting2Controller.setAnimationStop();
            }
            Setting1Controller setting1Controller = this.setting1Controller;
            if (setting1Controller != null) {
                setting1Controller.dismiss();
            }
            Setting3Controller setting3Controller = this.setting3Controller;
            if (setting3Controller != null) {
                setting3Controller.dismiss();
            }
            this.viewBlank.setVisibility(4);
            transOutRight(getBaseView());
        }
    }

    private void transInRight(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_in_right);
        loadAnimation.setDuration(350L);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.controllers.settings.SettingController.2
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(0);
                SettingController.this.viewBlank.setVisibility(0);
                SettingController.this.disableClick = true;
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
                SettingController.this.disableClick = false;
                SettingController.this.startSettingGuide();
            }
        });
    }

    private void transOutRight(final View view) {
        Animation loadAnimation = AnimationUtils.loadAnimation(view.getContext(), R.anim.trans_out_right);
        loadAnimation.setDuration(350L);
        view.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.ipotensic.kernel.controllers.settings.SettingController.3
            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationEnd(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationRepeat(Animation animation) {
            }

            @Override // android.view.animation.Animation.AnimationListener
            public void onAnimationStart(Animation animation) {
                view.setVisibility(8);
                SettingController.this.viewBlank.setVisibility(4);
                if (SettingController.this.listener != null) {
                    SettingController.this.listener.onSettingDismissed();
                }
            }
        });
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (eventID != EventID.EVENT_UI_HIDE_FLIGHT_SETTING || this.disableClick || this.isGuideDismiss) {
            return;
        }
        setVisibility(8);
    }

    public class SettingAdapter implements View.OnClickListener {
        private int curId;
        private View[] indicatorViews;
        private int length;

        public SettingAdapter() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public SettingAdapter setIndicators(int... iArr) {
            int length = iArr.length;
            this.length = length;
            this.indicatorViews = new View[length];
            for (int i = 0; i < this.length; i++) {
                View findViewById = SettingController.this.getBaseView().findViewById(iArr[i]);
                findViewById.setOnClickListener(this);
                this.indicatorViews[i] = findViewById;
            }
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public <T extends BaseController> SettingAdapter setController(T... tArr) {
            SettingController.this.baseControllers = tArr;
            return this;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void setCurPosition(int i) {
            this.indicatorViews[i].callOnClick();
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            if (this.curId == id) {
                return;
            }
            if (!FlightConfig.isSettingCalibration) {
                SettingController.this.settingBtn1.setImageResource(id == R.id.btn_indicator_1 ? R.mipmap.icon_bg_setting_controller_selected : R.mipmap.icon_bg_setting_controller);
                SettingController.this.settingBtn2.setImageResource(id == R.id.btn_indicator_2 ? R.mipmap.img_btn_setting_calibration_selected : R.mipmap.img_btn_setting_calibration);
                SettingController.this.settingBtn3.setImageResource(id == R.id.btn_indicator_3 ? R.mipmap.icon_bg_setting_remote_selected : R.mipmap.icon_bg_setting_remote);
                SettingController.this.settingBtn4.setImageResource(id == R.id.btn_indicator_4 ? R.mipmap.icon_bg_setting_battery_selected : R.mipmap.icon_bg_setting_battery);
                SettingController.this.settingBtn5.setImageResource(id == R.id.btn_indicator_5 ? R.mipmap.icon_bg_setting_selected : R.mipmap.icon_bg_setting);
                SettingController.this.settingBtn1.setBackgroundResource(id == R.id.btn_indicator_1 ? R.drawable.bg_setting_main_btn_selected : R.drawable.bg_setting_main_btn_unchecked);
                SettingController.this.settingBtn2.setBackgroundResource(id == R.id.btn_indicator_2 ? R.drawable.bg_setting_main_btn_selected : R.drawable.bg_setting_main_btn_unchecked);
                SettingController.this.settingBtn3.setBackgroundResource(id == R.id.btn_indicator_3 ? R.drawable.bg_setting_main_btn_selected : R.drawable.bg_setting_main_btn_unchecked);
                SettingController.this.settingBtn4.setBackgroundResource(id == R.id.btn_indicator_4 ? R.drawable.bg_setting_main_btn_selected : R.drawable.bg_setting_main_btn_unchecked);
                SettingController.this.settingBtn5.setBackgroundResource(id == R.id.btn_indicator_5 ? R.drawable.bg_setting_main_btn_selected : R.drawable.bg_setting_main_btn_unchecked);
                for (int i = 0; i < this.length; i++) {
                    BaseController baseController = SettingController.this.baseControllers[i];
                    if (id == this.indicatorViews[i].getId()) {
                        baseController.setVisibility(0);
                    } else {
                        baseController.setVisibility(8);
                    }
                }
                this.curId = id;
                SettingController.this.setSetting3Value();
                return;
            }
            ToastUtil.showImageTop(SettingController.this.getContext(), SettingController.this.getContext().getString(R.string.toast_calibration_close), R.mipmap.icon_gyroscope_galibration);
        }
    }

    public void setSettingControllerListener(SettingControllerListener settingControllerListener) {
        this.listener = settingControllerListener;
    }

    public void updateSetting() {
        setSetting1Value();
        setSetting3Value();
        setSetting4Value();
        setSetting5Value();
    }

    public void setSetting1Value() {
        if (this.setting1Controller == null || !FlightConfig.isConnectFlight()) {
            return;
        }
        this.setting1Controller.updateData();
    }

    public void setSetting2Value() {
        if (this.setting2Controller == null || !FlightConfig.isConnectFlight()) {
            return;
        }
        this.setting2Controller.updateData();
    }

    public void setSetting2HexahedralCalibration(Context context) {
        if (this.setting2Controller == null || !FlightConfig.isConnectFlight()) {
            return;
        }
        this.setting2Controller.updateHexahedralCalibration(context);
    }

    public void setSetting3Value() {
        if (this.setting3Controller == null || !FlightConfig.isConnectFlight()) {
            return;
        }
        this.setting3Controller.updateData();
    }

    public void setSetting4Value() {
        Setting4Controller setting4Controller = this.setting4Controller;
        if (setting4Controller != null) {
            setting4Controller.updateData();
        }
    }

    public void setSetting5Value() {
        Setting5Controller setting5Controller = this.setting5Controller;
        if (setting5Controller != null) {
            setting5Controller.updateData();
        }
    }

    public void onDisconnected(boolean z) {
        Setting1Controller setting1Controller = this.setting1Controller;
        if (setting1Controller != null && z) {
            setting1Controller.dismiss();
        }
        Setting2Controller setting2Controller = this.setting2Controller;
        if (setting2Controller != null && z) {
            setting2Controller.setAnimationStop();
        }
        Setting3Controller setting3Controller = this.setting3Controller;
        if (setting3Controller != null) {
            setting3Controller.setMiniPairVisible();
        }
        Setting4Controller setting4Controller = this.setting4Controller;
        if (setting4Controller != null) {
            setting4Controller.updateData();
        }
        Setting5Controller setting5Controller = this.setting5Controller;
        if (setting5Controller == null || !z) {
            return;
        }
        setting5Controller.disConnected();
    }

    public void onReturnOrLanding() {
        Setting1Controller setting1Controller = this.setting1Controller;
        if (setting1Controller != null) {
            setting1Controller.hideReturnHeightVideoDialog();
        }
    }

    public void refreshFwUpgradeConditionDialogShow() {
        Setting5Controller setting5Controller = this.setting5Controller;
        if (setting5Controller != null) {
            setting5Controller.refreshFwUpgradeConditionDialogShow();
        }
    }
}
