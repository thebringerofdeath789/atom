package com.ipotensic.kernel.controllers;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.animation.Animation;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.Conditions;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class IntelligentModeController extends BaseController implements CompoundButton.OnCheckedChangeListener, View.OnClickListener {
    private CheckBox cbDirectional;
    private CheckBox cbGps;
    private CheckBox cbLock;
    private CheckBox cbRemote;
    private boolean isDisable;
    private KernelViewModel kernelViewModel;
    private IntelligentControllerListener listener;
    private LinearLayout llRemoteView;
    private Resources res;
    private TextView tvFlight;
    private TextView tvFollowMe;
    private TextView tvHotCircle;
    private TextView tvMode;
    private TextView tvOthers;
    private TextView tvWaypoint;
    private View viewBg;
    private View viewBlank;
    private View viewMode;

    public interface IntelligentControllerListener {
        void onDirectionClicked();

        void onFlightFlyClicked();

        void onFollowMeClicked();

        void onGpsClicked();

        void onHotCircleClicked();

        void onRemoteControlClicked();

        void onUnLockClicked();
    }

    public IntelligentModeController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.isDisable = false;
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(appCompatActivity).get(KernelViewModel.class);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.res = getContext().getResources();
        this.viewMode = view.findViewById(R.id.view_mode);
        this.viewBg = view.findViewById(R.id.view_bg);
        View findViewById = view.findViewById(R.id.view_blank);
        this.viewBlank = findViewById;
        findViewById.setOnClickListener(this);
        this.cbDirectional = (CheckBox) view.findViewById(R.id.cb_directional);
        this.cbLock = (CheckBox) view.findViewById(R.id.cb_lock);
        this.cbGps = (CheckBox) view.findViewById(R.id.cb_gps);
        this.cbRemote = (CheckBox) view.findViewById(R.id.cb_remote);
        this.cbDirectional.setOnCheckedChangeListener(this);
        this.cbLock.setOnCheckedChangeListener(this);
        this.cbGps.setOnCheckedChangeListener(this);
        this.cbRemote.setOnCheckedChangeListener(this);
        this.tvHotCircle = (TextView) view.findViewById(R.id.tv_hot_circle);
        this.tvWaypoint = (TextView) view.findViewById(R.id.tv_waypoint_flight);
        this.tvFollowMe = (TextView) view.findViewById(R.id.tv_follow_me);
        this.tvHotCircle.setOnClickListener(this);
        this.tvWaypoint.setOnClickListener(this);
        this.tvFollowMe.setOnClickListener(this);
        this.tvMode = (TextView) view.findViewById(R.id.tv_mode);
        this.tvFlight = (TextView) view.findViewById(R.id.tv_flight);
        this.tvOthers = (TextView) view.findViewById(R.id.tv_others);
        this.llRemoteView = (LinearLayout) view.findViewById(R.id.ll_remote);
        if (FlightConfig.isOldProduct()) {
            this.cbGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_gps_mode), (Drawable) null, (Drawable) null);
            this.cbGps.setText(this.res.getString(R.string.tab_gps_mode));
        } else {
            this.cbGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_atti_turnoff), (Drawable) null, (Drawable) null);
            this.cbGps.setText(this.res.getString(R.string.atti_mode_turn_off));
        }
    }

    @Override // android.widget.CompoundButton.OnCheckedChangeListener
    public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
        if (this.isDisable) {
            return;
        }
        int id = compoundButton.getId();
        if (compoundButton instanceof CheckBox) {
            if (id == R.id.cb_directional) {
                if (SPHelper.getInstance().getHeadMode()) {
                    SPHelper.getInstance().setHeadMode(false);
                    NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvMode).addHighLight(this.cbDirectional, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.1
                        @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                        public void onLayoutInflated(View view, Controller controller) {
                            ((TextView) view.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_head));
                        }
                    }).setEverywhereCancelable(true).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                    return;
                } else {
                    this.listener.onDirectionClicked();
                    return;
                }
            }
            if (id == R.id.cb_lock) {
                if (SPHelper.getInstance().getLockMode()) {
                    SPHelper.getInstance().setLockMode(false);
                    NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvMode).addHighLight(this.cbLock, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.2
                        @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                        public void onLayoutInflated(View view, Controller controller) {
                            ((TextView) view.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_lock));
                        }
                    }).setEverywhereCancelable(true).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                    return;
                } else {
                    if (!FlightRevData.get().getFlightRevStateData().isUnLock() && Conditions.isShowBatteryInstallSafetyDialog()) {
                        KernelViewModel kernelViewModel = this.kernelViewModel;
                        if (kernelViewModel != null) {
                            kernelViewModel.getIsShowBatterySafetyDialog().set(true);
                            return;
                        }
                        return;
                    }
                    this.listener.onUnLockClicked();
                    return;
                }
            }
            if (id == R.id.cb_gps) {
                if (SPHelper.getInstance().getGpsMode()) {
                    SPHelper.getInstance().setGpsMode(false);
                    NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvMode).addHighLight(this.cbGps, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.3
                        @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                        public void onLayoutInflated(View view, Controller controller) {
                            ((TextView) view.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_gps));
                        }
                    }).setEverywhereCancelable(true).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                    return;
                } else {
                    this.listener.onGpsClicked();
                    return;
                }
            }
            if (id == R.id.cb_remote) {
                if (SPHelper.getInstance().getRemoteControlMode()) {
                    SPHelper.getInstance().setRemoteControlMode(false);
                    NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvOthers).addHighLight(this.cbRemote, new RelativeGuide(R.layout.guide_follow_me, 5, 0, 0, 80, 0, 0)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.4
                        @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                        public void onLayoutInflated(View view, Controller controller) {
                            ((TextView) view.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_control));
                        }
                    }).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                } else {
                    this.listener.onRemoteControlClicked();
                }
            }
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (this.isDisable) {
            return;
        }
        int id = view.getId();
        if (id == R.id.tv_hot_circle) {
            if (SPHelper.getInstance().getHotCircleMode()) {
                SPHelper.getInstance().setHotCircleMode(false);
                NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvFlight).addHighLight(this.tvHotCircle, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.5
                    @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                    public void onLayoutInflated(View view2, Controller controller) {
                        ((TextView) view2.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_interest));
                    }
                }).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                return;
            } else {
                this.listener.onHotCircleClicked();
                return;
            }
        }
        if (id == R.id.tv_waypoint_flight) {
            if (SPHelper.getInstance().getWaypointMode()) {
                SPHelper.getInstance().setWaypointMode(false);
                NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvFlight).addHighLight(this.tvWaypoint, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.6
                    @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                    public void onLayoutInflated(View view2, Controller controller) {
                        ((TextView) view2.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_waypoint));
                    }
                }).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                return;
            } else {
                this.listener.onFlightFlyClicked();
                return;
            }
        }
        if (id == R.id.tv_follow_me) {
            if (SPHelper.getInstance().getFollowMeMode()) {
                SPHelper.getInstance().setFollowMeMode(false);
                NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvFlight).addHighLight(this.tvFollowMe, new RelativeGuide(R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.7
                    @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                    public void onLayoutInflated(View view2, Controller controller) {
                        ((TextView) view2.findViewById(R.id.tv_view)).setText(IntelligentModeController.this.res.getString(R.string.guide_intelligent_follow));
                    }
                }).setBackgroundColor(this.res.getColor(R.color.color_guide_bg))).show();
                return;
            } else {
                this.listener.onFollowMeClicked();
                return;
            }
        }
        if (id == R.id.view_blank) {
            this.isDisable = true;
            AnimationUtil.transOutLeft(this.viewMode);
            this.viewBg.setVisibility(8);
            this.viewBlank.setVisibility(8);
            this.viewMode.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.8
                @Override // java.lang.Runnable
                public void run() {
                    IntelligentModeController.this.isDisable = false;
                }
            }, 500L);
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        Resources resources;
        int i2;
        super.setVisibility(i);
        if (i == 0) {
            this.isDisable = true;
            this.viewBg.setVisibility(0);
            this.viewBlank.setVisibility(0);
            View view = this.viewBg;
            if (FlightConfig.isConnectFlight()) {
                resources = this.res;
                i2 = R.color.color_intelligent_mode_blank;
            } else {
                resources = this.res;
                i2 = R.color.colorTransparent;
            }
            view.setBackgroundColor(resources.getColor(i2));
            AnimationUtil.transSpringBack(this.viewMode, new Animation.AnimationListener() { // from class: com.ipotensic.kernel.controllers.IntelligentModeController.9
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    IntelligentModeController.this.viewMode.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    IntelligentModeController.this.isDisable = false;
                }
            });
        }
    }

    public void setCbBackGround(FlightRevStateData flightRevStateData) {
        Resources resources;
        int i;
        Resources resources2;
        int i2;
        Resources resources3;
        int i3;
        Resources resources4;
        int i4;
        Resources resources5;
        int i5;
        Resources resources6;
        int i6;
        Resources resources7;
        int i7;
        Resources resources8;
        int i8;
        Resources resources9;
        int i9;
        Resources resources10;
        int i10;
        Resources resources11;
        int i11;
        Resources resources12;
        int i12;
        Resources resources13;
        int i13;
        Resources resources14;
        int i14;
        Resources resources15;
        int i15;
        boolean z = FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() <= 20;
        if (flightRevStateData != null) {
            CheckBox checkBox = this.cbLock;
            if (flightRevStateData.isUnLock()) {
                resources = this.res;
                i = R.string.tab_unlock;
            } else {
                resources = this.res;
                i = R.string.tab_lock;
            }
            checkBox.setText(resources.getString(i));
            CheckBox checkBox2 = this.cbLock;
            if (flightRevStateData.isUnLock()) {
                resources2 = this.res;
                i2 = R.mipmap.icon_lock;
            } else {
                resources2 = this.res;
                i2 = R.mipmap.icon_lock_check;
            }
            checkBox2.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources2.getDrawable(i2), (Drawable) null, (Drawable) null);
            if (flightRevStateData.getMode() == 2) {
                CheckBox checkBox3 = this.cbDirectional;
                if (flightRevStateData.isNoHeadMode()) {
                    resources13 = this.res;
                    i13 = R.string.tab_headless_mode;
                } else {
                    resources13 = this.res;
                    i13 = R.string.tab_headed_mode;
                }
                checkBox3.setText(resources13.getString(i13));
                this.cbGps.setText(this.res.getString(R.string.atti_mode_turn_off));
                if (flightRevStateData.isFlight()) {
                    this.cbDirectional.setTextColor(-1);
                    CheckBox checkBox4 = this.cbDirectional;
                    if (flightRevStateData.isNoHeadMode()) {
                        resources15 = this.res;
                        i15 = R.mipmap.icon_headless_mode;
                    } else {
                        resources15 = this.res;
                        i15 = R.mipmap.icon_head_mode;
                    }
                    checkBox4.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources15.getDrawable(i15), (Drawable) null, (Drawable) null);
                } else {
                    this.cbDirectional.setTextColor(this.res.getColor(R.color.color_gray));
                    CheckBox checkBox5 = this.cbDirectional;
                    if (flightRevStateData.isNoHeadMode()) {
                        resources14 = this.res;
                        i14 = R.mipmap.icon_headless_mode_gray;
                    } else {
                        resources14 = this.res;
                        i14 = R.mipmap.icon_head_mode_gray;
                    }
                    checkBox5.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources14.getDrawable(i14), (Drawable) null, (Drawable) null);
                }
                if (z || !flightRevStateData.isFlight()) {
                    this.cbGps.setTextColor(this.res.getColor(R.color.color_gray));
                    this.cbGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_atti_disable), (Drawable) null, (Drawable) null);
                    this.tvHotCircle.setTextColor(this.res.getColor(R.color.color_gray));
                    this.tvWaypoint.setTextColor(this.res.getColor(R.color.color_gray));
                    this.tvFollowMe.setTextColor(this.res.getColor(R.color.color_gray));
                    this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_hot_circle_gray), (Drawable) null, (Drawable) null);
                    this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_waypoint_flight_gray), (Drawable) null, (Drawable) null);
                    this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_follow_me_gray), (Drawable) null, (Drawable) null);
                } else {
                    this.cbGps.setTextColor(-1);
                    this.cbGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_atti_turnoff), (Drawable) null, (Drawable) null);
                    this.tvHotCircle.setTextColor(-1);
                    this.tvWaypoint.setTextColor(-1);
                    this.tvFollowMe.setTextColor(-1);
                    this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_hot_circle), (Drawable) null, (Drawable) null);
                    this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_waypoint_flight), (Drawable) null, (Drawable) null);
                    this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_follow_me), (Drawable) null, (Drawable) null);
                }
            } else {
                if (FlightConfig.isOldProduct()) {
                    this.cbDirectional.setTextColor(this.res.getColor(R.color.color_gray));
                    CheckBox checkBox6 = this.cbDirectional;
                    if (flightRevStateData.isNoHeadMode()) {
                        resources10 = this.res;
                        i10 = R.string.tab_headless_mode;
                    } else {
                        resources10 = this.res;
                        i10 = R.string.tab_headed_mode;
                    }
                    checkBox6.setText(resources10.getString(i10));
                    CheckBox checkBox7 = this.cbDirectional;
                    if (flightRevStateData.isNoHeadMode()) {
                        resources11 = this.res;
                        i11 = R.mipmap.icon_headless_mode_gray;
                    } else {
                        resources11 = this.res;
                        i11 = R.mipmap.icon_head_mode_gray;
                    }
                    checkBox7.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources11.getDrawable(i11), (Drawable) null, (Drawable) null);
                    this.cbGps.setTextColor(flightRevStateData.isFlight() ? -1 : this.res.getColor(R.color.color_gray));
                    CheckBox checkBox8 = this.cbGps;
                    if (flightRevStateData.isFlight()) {
                        resources12 = this.res;
                        i12 = R.mipmap.icon_atti_mode;
                    } else {
                        resources12 = this.res;
                        i12 = R.mipmap.icon_atti_mode_gray;
                    }
                    checkBox8.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources12.getDrawable(i12), (Drawable) null, (Drawable) null);
                    this.cbGps.setText(this.res.getString(R.string.tab_attitude));
                } else {
                    if (flightRevStateData.getMode() == 0) {
                        CheckBox checkBox9 = this.cbGps;
                        if (z || !flightRevStateData.isFlight()) {
                            resources8 = this.res;
                            i8 = R.color.color_gray;
                        } else {
                            resources8 = this.res;
                            i8 = R.color.color_atti_turn_on;
                        }
                        checkBox9.setTextColor(resources8.getColor(i8));
                        CheckBox checkBox10 = this.cbGps;
                        if (z || !flightRevStateData.isFlight()) {
                            resources9 = this.res;
                            i9 = R.mipmap.icon_atti_disable;
                        } else {
                            resources9 = this.res;
                            i9 = R.mipmap.icon_atti_turnon;
                        }
                        checkBox10.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources9.getDrawable(i9), (Drawable) null, (Drawable) null);
                    } else {
                        CheckBox checkBox11 = this.cbGps;
                        if (z || !flightRevStateData.isFlight()) {
                            resources3 = this.res;
                            i3 = R.color.color_gray;
                        } else {
                            resources3 = this.res;
                            i3 = R.color.white;
                        }
                        checkBox11.setTextColor(resources3.getColor(i3));
                        CheckBox checkBox12 = this.cbGps;
                        if (z || !flightRevStateData.isFlight()) {
                            resources4 = this.res;
                            i4 = R.mipmap.icon_atti_disable;
                        } else {
                            resources4 = this.res;
                            i4 = R.mipmap.icon_atti_turnoff;
                        }
                        checkBox12.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources4.getDrawable(i4), (Drawable) null, (Drawable) null);
                    }
                    CheckBox checkBox13 = this.cbGps;
                    if (flightRevStateData.getMode() == 0) {
                        resources5 = this.res;
                        i5 = R.string.atti_mode_turn_on;
                    } else {
                        resources5 = this.res;
                        i5 = R.string.atti_mode_turn_off;
                    }
                    checkBox13.setText(resources5.getString(i5));
                    this.cbDirectional.setTextColor(this.res.getColor(R.color.color_gray));
                    CheckBox checkBox14 = this.cbDirectional;
                    if (flightRevStateData.isNoHeadMode()) {
                        resources6 = this.res;
                        i6 = R.string.tab_headless_mode;
                    } else {
                        resources6 = this.res;
                        i6 = R.string.tab_headed_mode;
                    }
                    checkBox14.setText(resources6.getString(i6));
                    CheckBox checkBox15 = this.cbDirectional;
                    if (flightRevStateData.isNoHeadMode()) {
                        resources7 = this.res;
                        i7 = R.mipmap.icon_headless_mode_gray;
                    } else {
                        resources7 = this.res;
                        i7 = R.mipmap.icon_head_mode_gray;
                    }
                    checkBox15.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, resources7.getDrawable(i7), (Drawable) null, (Drawable) null);
                }
                this.tvHotCircle.setTextColor(this.res.getColor(R.color.color_gray));
                this.tvWaypoint.setTextColor(this.res.getColor(R.color.color_gray));
                this.tvFollowMe.setTextColor(this.res.getColor(R.color.color_gray));
                this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_hot_circle_gray), (Drawable) null, (Drawable) null);
                this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_waypoint_flight_gray), (Drawable) null, (Drawable) null);
                this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_follow_me_gray), (Drawable) null, (Drawable) null);
            }
            if (UsbConfig.isUsbConnected) {
                return;
            }
            if (this.tvOthers.getVisibility() != 0) {
                this.tvOthers.setVisibility(0);
                this.llRemoteView.setVisibility(0);
            }
            if (flightRevStateData.isRemoterConnected()) {
                this.cbRemote.setText(this.res.getString(R.string.tab_remote_control_off));
                this.cbRemote.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_remote_control_mode), (Drawable) null, (Drawable) null);
                return;
            } else if (FlightConfig.isShowRemoteControllerButton) {
                this.cbRemote.setText(this.res.getString(R.string.tab_remote_control_on));
                this.cbRemote.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_remote_control_mode_check), (Drawable) null, (Drawable) null);
                return;
            } else {
                this.cbRemote.setText(this.res.getString(R.string.tab_remote_control_off));
                this.cbRemote.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_remote_control_mode), (Drawable) null, (Drawable) null);
                return;
            }
        }
        this.cbDirectional.setText(this.res.getString(R.string.tab_directional));
        this.cbDirectional.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_head_mode), (Drawable) null, (Drawable) null);
        this.cbLock.setText(this.res.getString(R.string.tab_lock_mode));
        this.cbLock.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_lock), (Drawable) null, (Drawable) null);
        this.cbRemote.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_remote_control_mode), (Drawable) null, (Drawable) null);
        this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_hot_circle), (Drawable) null, (Drawable) null);
        this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_waypoint_flight), (Drawable) null, (Drawable) null);
        this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_follow_me), (Drawable) null, (Drawable) null);
        if (FlightConfig.isOldProduct()) {
            this.cbGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_gps_mode), (Drawable) null, (Drawable) null);
            this.cbGps.setText(this.res.getString(R.string.tab_gps_mode));
        } else {
            this.cbGps.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, this.res.getDrawable(R.mipmap.icon_atti_turnoff), (Drawable) null, (Drawable) null);
            this.cbGps.setText(this.res.getString(R.string.atti_mode_turn_off));
        }
        this.cbDirectional.setTextColor(-1);
        this.cbLock.setTextColor(-1);
        this.cbRemote.setTextColor(-1);
        this.cbGps.setTextColor(-1);
        this.tvHotCircle.setTextColor(-1);
        this.tvWaypoint.setTextColor(-1);
        this.tvFollowMe.setTextColor(-1);
        this.tvOthers.setVisibility(8);
        this.llRemoteView.setVisibility(8);
    }

    public void setIntelligentControllerListener(IntelligentControllerListener intelligentControllerListener) {
        this.listener = intelligentControllerListener;
    }
}