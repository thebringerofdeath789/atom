package com.ipotensic.kernel.controllers;

import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.core.view.GravityCompat;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.guide.listener.OnPageChangedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.guide.SettingRelativeGuide;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.view.CircleBatteryView;
import com.ipotensic.kernel.view.UpDownSlideView;
import com.ipotensic.kernel.view.attitude.AttitudeBallView;
import com.logan.flight.FlightConfig;

/* loaded from: classes2.dex */
public class GuideController extends BaseController {
    private AttitudeBallView attitudeBallView;
    private View bottom;
    private ImageView directViewIndicator;
    private ImageView ivGps;
    private ImageView ivHaveHead;
    private ImageView ivLogo;
    private ImageView ivSignalHd;
    private ImageView ivSystemSet;
    private CircleBatteryView layoutBattery;
    private RelativeLayout layoutConnectState;
    private View map;
    private View right;
    private UpDownSlideView slideView;
    private View top;
    private StrokeTextView tvGps;
    private StrokeTextView tvRemainFlightTime;
    private StrokeTextView tvUavStatus;

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
    }

    public GuideController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
    }

    public void setView(View... viewArr) {
        this.top = viewArr[0];
        this.bottom = viewArr[1];
        this.right = viewArr[2];
        this.map = viewArr[3];
        init();
    }

    public void setView(ImageView imageView, AttitudeBallView attitudeBallView) {
        this.directViewIndicator = imageView;
        this.attitudeBallView = attitudeBallView;
    }

    private void init() {
        this.ivLogo = (ImageView) this.top.findViewById(R.id.iv_logo);
        this.layoutConnectState = (RelativeLayout) this.top.findViewById(R.id.layout_connect_state);
        this.ivSignalHd = (ImageView) this.top.findViewById(R.id.iv_signal_hd);
        this.tvUavStatus = (StrokeTextView) this.top.findViewById(R.id.tv_uav_status);
        this.ivHaveHead = (ImageView) this.top.findViewById(R.id.iv_have_direction_mode);
        this.ivGps = (ImageView) this.top.findViewById(R.id.iv_gps);
        this.tvGps = (StrokeTextView) this.top.findViewById(R.id.tv_gps);
        this.layoutBattery = (CircleBatteryView) this.top.findViewById(R.id.view_battery_percentage);
        this.tvRemainFlightTime = (StrokeTextView) this.top.findViewById(R.id.tv_remain_flight_time);
        this.ivSystemSet = (ImageView) this.top.findViewById(R.id.tv_new_setting);
        this.slideView = (UpDownSlideView) this.right.findViewById(R.id.view_slide);
        this.ivGps.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$GuideController$j4ql2xaOSd5HupHkAF8Ra7xhS3w
            @Override // java.lang.Runnable
            public final void run() {
                GuideController.this.addGuideView();
            }
        }, 500L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addGuideView() {
        NewbieGuide.with(getContext()).addGuidePage(getDefaultGuidePage(true).addHighLight(this.ivLogo, new SettingRelativeGuide(R.layout.guide_view_top_new, 80, 0, UnitUtil.dp2px(6), 0, 0, 0, Integer.valueOf(R.string.guide_top_return))).addHighLight(this.layoutConnectState, new SettingRelativeGuide(R.layout.guide_view_top_new, 80, 0, UnitUtil.dp2px(15), 0, 0, 0, Integer.valueOf(R.string.guide_top_device_status))).addHighLight(this.ivGps, new SettingRelativeGuide(R.layout.guide_view_top_new, 80, 0, 0, 0, 0, 0, Integer.valueOf(R.string.guide_top_gps_signal))).addHighLight(this.layoutBattery, new SettingRelativeGuide(R.layout.guide_view_top_new, 80, UnitUtil.dp2px(5), 0, 0, 0, 0, Integer.valueOf(R.string.guide_top_electric))).addHighLight(this.bottom, new RelativeGuide(R.layout.guide_view_bottom2, 5, 0, 0, UnitUtil.dp2px(10), 0, 0))).addGuidePage(getDefaultGuidePage(true).addHighLight(this.tvUavStatus, new SettingRelativeGuide(R.layout.guide_view_top_right, GravityCompat.END, 0, 0, 0, 0, 0, Integer.valueOf(R.string.guide_top_mode))).addHighLight(this.ivSignalHd, new SettingRelativeGuide(R.layout.guide_view_top_right, GravityCompat.END, 0, 0, 0, 0, 0, Integer.valueOf(R.string.guide_top_signal))).addHighLight(this.ivSystemSet, new SettingRelativeGuide(R.layout.guide_view_top_right, GravityCompat.END, 0, 0, 0, 0, 0, Integer.valueOf(R.string.guide_top_setting))).addHighLight(this.map, new RelativeGuide(R.layout.guide_view_map, 5, 0, 0, 0, 0, 0))).addGuidePage(getDefaultGuidePage(false, ContextCompat.getColor(getContext(), R.color.colorFiftyPercent)).addHighLight(this.directViewIndicator, new SettingRelativeGuide(R.layout.guide_view_attitude_ball_indicator, 5, 0, 0, 0, 0, 0))).setOnPageChangedListener(new OnPageChangedListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$GuideController$cpMM5hoY6r7gYOUp9x9krgjgcNY
            @Override // com.ipotensic.baselib.guide.listener.OnPageChangedListener
            public final void onPageChanged(int i) {
                GuideController.this.lambda$addGuideView$0$GuideController(i);
            }
        }).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.controllers.GuideController.1
            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onShowed(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                GuideController.this.directViewIndicator.performClick();
                GuideController.this.showAttitudeBallGuide();
            }
        }).show();
    }

    public /* synthetic */ void lambda$addGuideView$0$GuideController(int i) {
        if (i == 0) {
            if (!FlightConfig.isConnectFlight()) {
                this.ivGps.setImageResource(R.mipmap.icon_gps_enable);
                this.layoutBattery.setAlpha(1.0f);
                this.tvRemainFlightTime.setTextColor(getContext().getColor(R.color.colorWhite));
                this.tvGps.setTextColor(getContext().getColor(R.color.colorWhite));
            }
        } else if (i == 1 && !FlightConfig.isConnectFlight()) {
            this.ivGps.setImageResource(R.mipmap.icon_gps_disable);
            this.layoutBattery.setAlpha(0.4f);
            this.tvRemainFlightTime.setTextColor(getContext().getColor(R.color.color_white_fifty_percent));
            this.tvGps.setTextColor(getContext().getColor(R.color.color_white_fifty_percent));
            this.ivSignalHd.setImageLevel(4);
            this.ivHaveHead.setImageResource(R.mipmap.icon_top_head_mode);
            this.ivHaveHead.setImageResource(R.mipmap.icon_top_head_mode);
            this.tvUavStatus.setTextColor(getContext().getColor(R.color.colorWhite));
        }
        if (i == 2) {
            this.directViewIndicator.startAnimation(AnimationUtil.getTwinkleAnimation());
            if (FlightConfig.isConnectFlight()) {
                return;
            }
            this.ivSignalHd.setImageLevel(0);
            this.ivHaveHead.setImageResource(R.mipmap.icon_top_head_mode_disable);
            this.tvUavStatus.setTextColor(getContext().getColor(R.color.color_white_fifty_percent));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showAttitudeBallGuide() {
        NewbieGuide.with(getContext()).addGuidePage(getDefaultGuidePage(true).addHighLight(this.attitudeBallView, new SettingRelativeGuide(R.layout.guide_view_attitude_ball, 5, 0, 0, 0, 0, 0))).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.controllers.GuideController.2
            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onShowed(Controller controller) {
            }

            @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
            public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                SPHelper.getInstance().setAppFirstEnterMain(false);
            }
        }).show();
    }

    private GuidePage getDefaultGuidePage(boolean z) {
        return getDefaultGuidePage(z, 0);
    }

    private GuidePage getDefaultGuidePage(boolean z, int i) {
        return GuidePage.newInstance().setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setEverywhereCancelable(z).setBackgroundColor(i);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0 || getBaseView() != null) {
            if (i == 0) {
                getBaseView().setVisibility(0);
            } else {
                getBaseView().setVisibility(8);
            }
        }
    }
}