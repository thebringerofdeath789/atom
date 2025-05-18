package com.ipotensic.kernel.controllers;

import android.graphics.drawable.Drawable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.SeekBar;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.guide.NewbieGuide;
import com.ipotensic.baselib.guide.core.Controller;
import com.ipotensic.baselib.guide.listener.OnGuideChangedListener;
import com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener;
import com.ipotensic.baselib.guide.model.GuidePage;
import com.ipotensic.baselib.guide.model.RelativeGuide;
import com.ipotensic.baselib.guide.util.ViewUtils;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.controllers.IntelligentModeController;
import com.ipotensic.kernel.model.KernelViewModel;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.mapbox.api.directions.p022v5.models.SpeedLimit;

/* loaded from: classes2.dex */
public class AtomLTIntelligentModeController extends BaseController implements View.OnClickListener {
    private static final String TAG = "AtomLTIntelligentModeController";
    private final String CHAR_FORMAT;
    private View atomLTIntelligentModeRight;
    private CursorEditText edtRadius;
    private CursorEditText edtSpeed;
    private boolean isDisable;
    private KernelViewModel kernelViewModel;
    private ImageButton leftCircleDirection;
    private IntelligentModeController.IntelligentControllerListener listener;
    private CustomSeekbar radiusSeekBar;
    private ImageButton rightCircleDirection;
    private CustomSeekbar speedSeekBar;
    private Button startCircleFlight;
    private TextView tvCircleFlightSetting;
    private TextView tvCircleRadiusUnit;
    private TextView tvCircleSpeedUnit;
    private TextView tvDirectionTips;
    private TextView tvFollowMe;
    private TextView tvHotCircle;
    private TextView tvRadiusTips;
    private TextView tvSpeedTips;
    private TextView tvUnitCircleRadius;
    private TextView tvUnitCircleSpeed;
    private TextView tvWaypoint;
    private View viewBg;
    private View viewBlank;
    private View viewMode;

    public AtomLTIntelligentModeController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.isDisable = false;
        this.CHAR_FORMAT = " (%d~%d%s)";
        this.kernelViewModel = (KernelViewModel) new ViewModelProvider(appCompatActivity).get(KernelViewModel.class);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvHotCircle = (TextView) view.findViewById(C1965R.id.atomLT_tv_hot_circle);
        this.tvWaypoint = (TextView) view.findViewById(C1965R.id.atomLT_tv_waypoint_flight);
        this.tvFollowMe = (TextView) view.findViewById(C1965R.id.atomLT_tv_follow_me);
        this.tvHotCircle.setOnClickListener(this);
        this.tvWaypoint.setOnClickListener(this);
        this.tvFollowMe.setOnClickListener(this);
        this.viewBlank = view.findViewById(C1965R.id.atomLT_intelligent_view_blank);
        this.viewBg = view.findViewById(C1965R.id.atomLT_intelligent_view_bg);
        View findViewById = view.findViewById(C1965R.id.atomLT_intelligent_view_mode);
        this.viewMode = findViewById;
        findViewById.setOnClickListener(this);
        this.viewBlank.setOnClickListener(this);
        this.tvCircleFlightSetting = (TextView) view.findViewById(C1965R.id.tvCircleFlightSetting);
        this.tvRadiusTips = (TextView) view.findViewById(C1965R.id.tv_radius_tips);
        this.tvUnitCircleRadius = (TextView) view.findViewById(C1965R.id.atomLT_tv_unit_circle_radius);
        this.tvSpeedTips = (TextView) view.findViewById(C1965R.id.tv_speed_tips);
        this.tvUnitCircleSpeed = (TextView) view.findViewById(C1965R.id.atomLT_tv_unit_circle_speed);
        this.tvDirectionTips = (TextView) view.findViewById(C1965R.id.tv_direction_tips);
        this.leftCircleDirection = (ImageButton) view.findViewById(C1965R.id.atomLT_iv_left);
        this.rightCircleDirection = (ImageButton) view.findViewById(C1965R.id.atomLT_iv_right);
        this.startCircleFlight = (Button) view.findViewById(C1965R.id.start_circle_flight);
        this.leftCircleDirection.setOnClickListener(this);
        this.rightCircleDirection.setOnClickListener(this);
        this.startCircleFlight.setOnClickListener(this);
        this.atomLTIntelligentModeRight = view.findViewById(C1965R.id.atomLT_intelligent_mode_right);
        this.radiusSeekBar = (CustomSeekbar) view.findViewById(C1965R.id.atomLT_seekBar_radius);
        this.speedSeekBar = (CustomSeekbar) view.findViewById(C1965R.id.atomLT_seekBar_speed);
        this.edtRadius = (CursorEditText) view.findViewById(C1965R.id.atomLT_edt_radius);
        this.edtSpeed = (CursorEditText) view.findViewById(C1965R.id.atomLT_edt_speed);
        this.tvCircleRadiusUnit = (TextView) view.findViewById(C1965R.id.atomLT_tv_unit_circle_radius);
        this.tvCircleSpeedUnit = (TextView) view.findViewById(C1965R.id.atomLT_tv_unit_circle_speed);
        initCircleLimitUI();
        setUpdateView(FlightConfig.isConnectFlight());
    }

    private void onHotCircleClicked() {
        if (SPHelper.getInstance().getHotCircleMode()) {
            SPHelper.getInstance().setHotCircleMode(false);
            NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvHotCircle, new RelativeGuide(C1965R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$AtomLTIntelligentModeController$AiU0ZzxSCrnlur7TH-bbJ0lWp_U
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    AtomLTIntelligentModeController.this.lambda$onHotCircleClicked$0$AtomLTIntelligentModeController(view, controller);
                }
            }).setBackgroundColor(getContext().getResources().getColor(C1965R.color.color_guide_bg))).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.1
                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onShowed(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                    AtomLTIntelligentModeController.this.onIntelligentIconClick();
                }
            }).show();
            this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_waypoint_flight_disconnect_atomlt), (Drawable) null, (Drawable) null);
            this.tvWaypoint.setAlpha(0.5f);
            this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_follow_me_disconnect_atomlt), (Drawable) null, (Drawable) null);
            this.tvFollowMe.setAlpha(0.5f);
            return;
        }
        onIntelligentIconClick();
    }

    public /* synthetic */ void lambda$onHotCircleClicked$0$AtomLTIntelligentModeController(View view, Controller controller) {
        ((TextView) view.findViewById(C1965R.id.tv_view)).setText(getContext().getResources().getString(C1965R.string.guide_intelligent_interest));
        this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_circle_flight_click_atomlt), (Drawable) null, (Drawable) null);
        this.tvHotCircle.setAlpha(1.0f);
    }

    private void onWaypointFlyClicked() {
        if (SPHelper.getInstance().getWaypointMode()) {
            SPHelper.getInstance().setWaypointMode(false);
            NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvWaypoint, new RelativeGuide(C1965R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$AtomLTIntelligentModeController$AWsY962iCUWkwWnaIeFp1lo2Qew
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    AtomLTIntelligentModeController.this.lambda$onWaypointFlyClicked$1$AtomLTIntelligentModeController(view, controller);
                }
            }).setBackgroundColor(getContext().getResources().getColor(C1965R.color.color_guide_bg))).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.2
                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onShowed(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                    AtomLTIntelligentModeController.this.onIntelligentIconClick();
                }
            }).show();
            this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_circle_flight_atomlt), (Drawable) null, (Drawable) null);
            this.tvHotCircle.setAlpha(0.5f);
            this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_follow_me_disconnect_atomlt), (Drawable) null, (Drawable) null);
            this.tvFollowMe.setAlpha(0.5f);
            return;
        }
        onIntelligentIconClick();
        this.listener.onFlightFlyClicked();
    }

    public /* synthetic */ void lambda$onWaypointFlyClicked$1$AtomLTIntelligentModeController(View view, Controller controller) {
        ((TextView) view.findViewById(C1965R.id.tv_view)).setText(getContext().getResources().getString(C1965R.string.guide_intelligent_waypoint));
        this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_waypoint_flight_click_atomlt), (Drawable) null, (Drawable) null);
        this.tvWaypoint.setAlpha(1.0f);
    }

    private void onFollowMeClicked() {
        if (SPHelper.getInstance().getFollowMeMode()) {
            SPHelper.getInstance().setFollowMeMode(false);
            NewbieGuide.with(getContext()).addGuidePage(GuidePage.newInstance().addHighLight(this.tvFollowMe, new RelativeGuide(C1965R.layout.guide_follow_me, 5)).setEnterAnimation(AnimationUtil.enterAnimation()).setExitAnimation(AnimationUtil.exitAnimation()).setOnLayoutInflatedListener(new OnLayoutInflatedListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$AtomLTIntelligentModeController$Jtnd2qrWhRTsNNiaP4zUPnf7aUU
                @Override // com.ipotensic.baselib.guide.listener.OnLayoutInflatedListener
                public final void onLayoutInflated(View view, Controller controller) {
                    AtomLTIntelligentModeController.this.lambda$onFollowMeClicked$2$AtomLTIntelligentModeController(view, controller);
                }
            }).setBackgroundColor(getContext().getResources().getColor(C1965R.color.color_guide_bg))).setOnGuideChangedListener(new OnGuideChangedListener() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.3
                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onShowed(Controller controller) {
                }

                @Override // com.ipotensic.baselib.guide.listener.OnGuideChangedListener
                public void onRemoved(Controller controller, boolean z, boolean z2, boolean z3, boolean z4) {
                    AtomLTIntelligentModeController.this.onIntelligentIconClick();
                }
            }).show();
            this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_circle_flight_atomlt), (Drawable) null, (Drawable) null);
            this.tvHotCircle.setAlpha(0.5f);
            this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_waypoint_flight_disconnect_atomlt), (Drawable) null, (Drawable) null);
            this.tvWaypoint.setAlpha(0.5f);
            return;
        }
        onIntelligentIconClick();
        this.listener.onFollowMeClicked();
    }

    public /* synthetic */ void lambda$onFollowMeClicked$2$AtomLTIntelligentModeController(View view, Controller controller) {
        ((TextView) view.findViewById(C1965R.id.tv_view)).setText(getContext().getResources().getString(C1965R.string.guide_intelligent_follow));
        this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(C1965R.mipmap.icon_follow_me_click_atomlt), (Drawable) null, (Drawable) null);
        this.tvFollowMe.setAlpha(1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onIntelligentIconClick() {
        this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(FlightConfig.isConnectFlight() ? C1965R.mipmap.icon_circle_flight_click_atomlt : C1965R.mipmap.icon_circle_flight_atomlt), (Drawable) null, (Drawable) null);
        this.tvHotCircle.setAlpha(FlightConfig.isConnectFlight() ? 1.0f : 0.5f);
        this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(FlightConfig.isConnectFlight() ? C1965R.mipmap.icon_waypoint_flight_click_atomlt : C1965R.mipmap.icon_waypoint_flight_disconnect_atomlt), (Drawable) null, (Drawable) null);
        this.tvWaypoint.setAlpha(FlightConfig.isConnectFlight() ? 1.0f : 0.5f);
        this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(FlightConfig.isConnectFlight() ? C1965R.mipmap.icon_follow_me_click_atomlt : C1965R.mipmap.icon_follow_me_disconnect_atomlt), (Drawable) null, (Drawable) null);
        this.tvFollowMe.setAlpha(FlightConfig.isConnectFlight() ? 1.0f : 0.5f);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        String str = TAG;
        DDLog.m1685e(str, "onClick");
        if (this.isDisable) {
            return;
        }
        int id = view.getId();
        if (id == C1965R.id.atomLT_tv_hot_circle) {
            onHotCircleClicked();
            return;
        }
        if (id == C1965R.id.atomLT_tv_waypoint_flight) {
            onWaypointFlyClicked();
            return;
        }
        if (id == C1965R.id.atomLT_tv_follow_me) {
            onFollowMeClicked();
            return;
        }
        if (id == C1965R.id.atomLT_intelligent_view_blank) {
            DDLog.m1685e(str, "onClick atomLT_intelligent_view_blank");
            this.isDisable = true;
            AnimationUtil.transOutLeft(this.viewMode);
            this.viewBg.setVisibility(8);
            this.viewBlank.setVisibility(8);
            this.viewMode.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.4
                @Override // java.lang.Runnable
                public void run() {
                    AtomLTIntelligentModeController.this.isDisable = false;
                }
            }, 500L);
            return;
        }
        if (id == C1965R.id.atomLT_iv_left) {
            DDLog.m1685e(str, "onClick atomLT_iv_left");
            if (FlightRevData.get().getFlightRevSettingData().isClockwise()) {
                FlightSendData.get().getSendFlightSetData().setClockwise(false);
                DataManager.getInstance().startSendSetting();
            }
            this.leftCircleDirection.setImageResource(C1965R.mipmap.icon_circle_direction_left_click_atomlt);
            this.rightCircleDirection.setImageResource(C1965R.mipmap.icon_circle_direction_right_atomlt);
            return;
        }
        if (id == C1965R.id.atomLT_iv_right) {
            DDLog.m1685e(str, "onClick atomLT_iv_right");
            if (FlightConfig.isConnectFlight()) {
                if (!FlightRevData.get().getFlightRevSettingData().isClockwise()) {
                    FlightSendData.get().getSendFlightSetData().setClockwise(true);
                    DataManager.getInstance().startSendSetting();
                }
                this.leftCircleDirection.setImageResource(C1965R.mipmap.icon_circle_direction_left_atomlt);
                this.rightCircleDirection.setImageResource(C1965R.mipmap.icon_circle_direction_right_click_atomlt);
                return;
            }
            return;
        }
        if (id == C1965R.id.start_circle_flight) {
            this.listener.onHotCircleClicked();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            this.isDisable = true;
            this.viewBg.setVisibility(0);
            this.viewBlank.setVisibility(0);
            this.viewBg.setBackgroundColor(FlightConfig.isConnectFlight() ? getContext().getResources().getColor(C1965R.color.color_intelligent_mode_blank) : getContext().getResources().getColor(C1965R.color.colorEightyPercent));
            this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(FlightConfig.isConnectFlight() ? C1965R.mipmap.icon_circle_flight_click_atomlt : C1965R.mipmap.icon_circle_flight_atomlt), (Drawable) null, (Drawable) null);
            this.tvHotCircle.setAlpha(FlightConfig.isConnectFlight() ? 1.0f : 0.5f);
            this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(FlightConfig.isConnectFlight() ? C1965R.mipmap.icon_waypoint_flight_click_atomlt : C1965R.mipmap.icon_waypoint_flight_disconnect_atomlt), (Drawable) null, (Drawable) null);
            this.tvWaypoint.setAlpha(FlightConfig.isConnectFlight() ? 1.0f : 0.5f);
            this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(FlightConfig.isConnectFlight() ? C1965R.mipmap.icon_follow_me_click_atomlt : C1965R.mipmap.icon_follow_me_disconnect_atomlt), (Drawable) null, (Drawable) null);
            this.tvFollowMe.setAlpha(FlightConfig.isConnectFlight() ? 1.0f : 0.5f);
            AnimationUtil.transSpringBack(this.viewMode, new Animation.AnimationListener() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.5
                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationRepeat(Animation animation) {
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationStart(Animation animation) {
                    AtomLTIntelligentModeController.this.viewMode.setVisibility(0);
                }

                @Override // android.view.animation.Animation.AnimationListener
                public void onAnimationEnd(Animation animation) {
                    AtomLTIntelligentModeController.this.isDisable = false;
                }
            });
        }
    }

    private void setUpdateView(boolean z) {
        boolean isHotCircle = FlightRevData.get().getFlightRevStateData().isHotCircle();
        this.tvHotCircle.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(z ? C1965R.mipmap.icon_circle_flight_click_atomlt : C1965R.mipmap.icon_circle_flight_atomlt), (Drawable) null, (Drawable) null);
        this.tvHotCircle.setAlpha(z ? 1.0f : 0.5f);
        this.tvCircleFlightSetting.setAlpha(z ? 1.0f : 0.5f);
        this.tvWaypoint.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(z ? C1965R.mipmap.icon_waypoint_flight_click_atomlt : C1965R.mipmap.icon_waypoint_flight_disconnect_atomlt), (Drawable) null, (Drawable) null);
        this.tvWaypoint.setAlpha(z ? 1.0f : 0.5f);
        this.tvFollowMe.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, getContext().getDrawable(z ? C1965R.mipmap.icon_follow_me_click_atomlt : C1965R.mipmap.icon_follow_me_disconnect_atomlt), (Drawable) null, (Drawable) null);
        this.tvFollowMe.setAlpha(z ? 1.0f : 0.5f);
        this.tvRadiusTips.setAlpha(z ? 1.0f : 0.5f);
        this.edtRadius.setAlpha(z ? 1.0f : 0.5f);
        this.tvUnitCircleRadius.setAlpha(z ? 1.0f : 0.5f);
        this.tvSpeedTips.setAlpha(z ? 1.0f : 0.5f);
        this.edtSpeed.setAlpha(z ? 1.0f : 0.5f);
        this.tvUnitCircleSpeed.setAlpha(z ? 1.0f : 0.5f);
        this.tvDirectionTips.setAlpha(z ? 1.0f : 0.5f);
        this.leftCircleDirection.setAlpha(z ? 1.0f : 0.5f);
        this.rightCircleDirection.setAlpha(z ? 1.0f : 0.5f);
        this.startCircleFlight.setBackgroundColor(getContext().getColor(z ? C1965R.color.colorSettingSelectBg : C1965R.color.colorSettingUnSelectBg));
        this.startCircleFlight.setTextColor(getContext().getColor(z ? C1965R.color.colorWhite : C1965R.color.color_white_fifty_percent));
        this.atomLTIntelligentModeRight.setBackgroundColor(getContext().getColor(C1965R.color.colorEightyPercent));
        boolean z2 = false;
        if (!z || FlightRevData.get().getFlightRevSettingData().isNewerModeOpen()) {
            CustomSeekbar customSeekbar = this.radiusSeekBar;
            customSeekbar.setValue(customSeekbar.getDefaultValue());
            CustomSeekbar customSeekbar2 = this.speedSeekBar;
            customSeekbar2.setValue(customSeekbar2.getDefaultValue());
            this.edtRadius.setText(String.valueOf(FlightConfig.get_value(this.radiusSeekBar.getDefaultValue())));
            this.edtSpeed.setText(String.valueOf(FlightConfig.get_speed_value(this.speedSeekBar.getDefaultValue())));
            ViewUtils.setViewEnableWithAlpha(this.radiusSeekBar, false);
            ViewUtils.setViewEnableWithAlpha(this.speedSeekBar, false);
            ViewUtils.setViewEnableWithAlpha(this.leftCircleDirection, false);
            ViewUtils.setViewEnableWithAlpha(this.rightCircleDirection, false);
            return;
        }
        ViewUtils.setViewEnableWithAlpha(this.radiusSeekBar, z && !isHotCircle);
        ViewUtils.setViewEnableWithAlpha(this.speedSeekBar, z && !isHotCircle);
        ViewUtils.setViewEnableWithAlpha(this.leftCircleDirection, z && !isHotCircle);
        ImageButton imageButton = this.rightCircleDirection;
        if (z && !isHotCircle) {
            z2 = true;
        }
        ViewUtils.setViewEnableWithAlpha(imageButton, z2);
    }

    private void initCircleLimitUI() {
        this.edtRadius.setLimit(FlightConfig.get_value(50), FlightConfig.get_value(10), FlightConfig.get_value(10));
        this.edtSpeed.setLimit(FlightConfig.get_speed_value(5), FlightConfig.get_speed_value(3), FlightConfig.get_speed_value(1));
        this.radiusSeekBar.setLimit(50, 10, 10);
        this.speedSeekBar.setLimit(5, 3, 1);
        this.edtRadius.setText(String.valueOf(FlightConfig.get_value(this.radiusSeekBar.getValue())));
        this.edtSpeed.setText(String.valueOf(FlightConfig.get_speed_value(this.speedSeekBar.getValue())));
        FlightSendData.get().getSendFlightSetData().setSurroundRadius((short) this.radiusSeekBar.getValue());
        FlightSendData.get().getSendFlightSetData().setSurroundSpeed((short) this.speedSeekBar.getValue());
        DataManager.getInstance().startSendSetting();
        this.tvCircleRadiusUnit.setText(PhoneConfig.isFt ? "ft" : "m");
        TextView textView = this.tvCircleSpeedUnit;
        boolean z = PhoneConfig.isFt;
        String str = SpeedLimit.MPH;
        textView.setText(z ? SpeedLimit.MPH : "m/s");
        Object[] objArr = new Object[3];
        objArr[0] = Integer.valueOf(this.edtRadius.getMin());
        objArr[1] = Integer.valueOf(this.edtRadius.getMax());
        objArr[2] = PhoneConfig.isFt ? "ft" : "m";
        SpannableString spannableString = new SpannableString(String.format(" (%d~%d%s)", objArr));
        spannableString.setSpan(new ForegroundColorSpan(getContext().getColor(C1965R.color.color_gray)), 0, spannableString.length(), 17);
        this.tvRadiusTips.setText(getContext().getString(C1965R.string.atom_lt_circling_flight_setting_circling_radius_title));
        this.tvRadiusTips.append(spannableString);
        Object[] objArr2 = new Object[3];
        objArr2[0] = Integer.valueOf(this.edtSpeed.getMin());
        objArr2[1] = Integer.valueOf(this.edtSpeed.getMax());
        if (!PhoneConfig.isFt) {
            str = "m/s";
        }
        objArr2[2] = str;
        SpannableString spannableString2 = new SpannableString(String.format(" (%d~%d%s)", objArr2));
        spannableString2.setSpan(new ForegroundColorSpan(getContext().getColor(C1965R.color.color_gray)), 0, spannableString2.length(), 17);
        this.tvSpeedTips.setText(getContext().getString(C1965R.string.sys_basic_speed));
        this.tvSpeedTips.append(spannableString2);
        this.radiusSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.6
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
                if (z2) {
                    int value = AtomLTIntelligentModeController.this.radiusSeekBar.getValue();
                    DDLog.m1685e(AtomLTIntelligentModeController.TAG, "radiusSeekBar onProgressChanged value = " + value);
                    AtomLTIntelligentModeController.this.edtRadius.setText(FlightConfig.get_value(value) + "");
                    FlightSendData.get().getSendFlightSetData().setSurroundRadius((short) value);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DataManager.getInstance().startSendSetting();
            }
        });
        this.speedSeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z2) {
                if (z2) {
                    int value = AtomLTIntelligentModeController.this.speedSeekBar.getValue();
                    DDLog.m1685e(AtomLTIntelligentModeController.TAG, "speedSeekBar onProgressChanged value = " + value);
                    AtomLTIntelligentModeController.this.edtSpeed.setText(FlightConfig.get_speed_value(value) + "");
                    FlightSendData.get().getSendFlightSetData().setSurroundSpeed((short) value);
                }
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
                DataManager.getInstance().startSendSetting();
            }
        });
        this.leftCircleDirection.setImageResource(FlightRevData.get().getFlightRevSettingData().isClockwise() ? C1965R.mipmap.icon_circle_direction_left_atomlt : C1965R.mipmap.icon_circle_direction_left_click_atomlt);
        this.rightCircleDirection.setImageResource(FlightRevData.get().getFlightRevSettingData().isClockwise() ? C1965R.mipmap.icon_circle_direction_right_click_atomlt : C1965R.mipmap.icon_circle_direction_right_atomlt);
    }

    private void updateCircleFlightData() {
        FlightRevSettingData flightRevSettingData = FlightRevData.get().getFlightRevSettingData();
        if (flightRevSettingData == null || getBaseView() == null) {
            return;
        }
        int surroundRadius = flightRevSettingData.getSurroundRadius();
        if (surroundRadius < this.radiusSeekBar.getLimitMin()) {
            surroundRadius = this.radiusSeekBar.getLimitMin();
        }
        int surroundSpeed = flightRevSettingData.getSurroundSpeed();
        if (surroundSpeed < this.speedSeekBar.getLimitMin()) {
            surroundSpeed = this.speedSeekBar.getLimitMin();
        }
        boolean z = false;
        if (flightRevSettingData.isNewerModeOpen()) {
            CustomSeekbar customSeekbar = this.radiusSeekBar;
            customSeekbar.setValue(customSeekbar.getDefaultValue());
            CustomSeekbar customSeekbar2 = this.speedSeekBar;
            customSeekbar2.setValue(customSeekbar2.getDefaultValue());
            this.edtRadius.setText(String.valueOf(FlightConfig.get_value(this.radiusSeekBar.getDefaultValue())));
            this.edtSpeed.setText(String.valueOf(FlightConfig.get_speed_value(this.speedSeekBar.getDefaultValue())));
            ViewUtils.setViewEnableWithAlpha(this.radiusSeekBar, false);
            ViewUtils.setViewEnableWithAlpha(this.speedSeekBar, false);
            ViewUtils.setViewEnableWithAlpha(this.leftCircleDirection, false);
            ViewUtils.setViewEnableWithAlpha(this.rightCircleDirection, false);
            if (surroundRadius != this.radiusSeekBar.getValue()) {
                FlightSendData.get().getSendFlightSetData().setSurroundRadius((short) this.radiusSeekBar.getValue());
            }
            if (surroundSpeed != this.speedSeekBar.getValue()) {
                FlightSendData.get().getSendFlightSetData().setSurroundSpeed((short) this.speedSeekBar.getValue());
            }
            if (surroundRadius == this.radiusSeekBar.getValue() && surroundSpeed == this.speedSeekBar.getValue()) {
                return;
            }
            DataManager.getInstance().startSendSetting();
            return;
        }
        this.radiusSeekBar.setValue(surroundRadius);
        this.speedSeekBar.setValue(surroundSpeed);
        this.edtRadius.setText(FlightConfig.get_value(surroundRadius) + "");
        this.edtSpeed.setText(FlightConfig.get_speed_value(surroundSpeed) + "");
        ViewUtils.setViewEnableWithAlpha(this.radiusSeekBar, FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isHotCircle());
        ViewUtils.setViewEnableWithAlpha(this.speedSeekBar, FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isHotCircle());
        ViewUtils.setViewEnableWithAlpha(this.leftCircleDirection, FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isHotCircle());
        ImageButton imageButton = this.rightCircleDirection;
        if (FlightConfig.isConnectFlight() && !FlightRevData.get().getFlightRevStateData().isHotCircle()) {
            z = true;
        }
        ViewUtils.setViewEnableWithAlpha(imageButton, z);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (FlightConfig.isAtomLT() || FlightConfig.is_Atom_SE_Series()) {
            int i = C20988.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
            if (i != 1) {
                if (i != 2) {
                    return;
                }
                initCircleLimitUI();
            } else if (((FlightRevSettingData) event.obj) != null) {
                updateCircleFlightData();
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.AtomLTIntelligentModeController$8 */
    static /* synthetic */ class C20988 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_SETTING_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_UNIT_CHANGED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public void onConnect(boolean z) {
        setUpdateView(z);
    }

    public void setIntelligentControllerListener(IntelligentModeController.IntelligentControllerListener intelligentControllerListener) {
        this.listener = intelligentControllerListener;
    }
}