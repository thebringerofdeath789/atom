package com.ipotensic.kernel.controllers;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.ScaleClickListener;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.views.RoundRelativeLayout;
import com.ipotensic.baselib.views.StrokeTextView;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.CircleBatteryView;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevBatteryData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.usb.AOAEngine;

/* loaded from: classes2.dex */
public class TopController extends BaseController implements AOAEngine.IEngineCallback {
    private CircleBatteryView circleBatteryView;
    private Context context;
    private final Handler handler;
    boolean hasTakenOff;
    private boolean isFollowMode;
    private ImageView ivGimbalTips;
    private ImageView ivGps;
    private ImageView ivHaveHead;
    private ImageView ivHighMode;
    private ImageView ivNewSetting;
    private ImageView ivUav;
    private ImageView ivWifi;
    private int lastGimbalPitch;
    private RoundRelativeLayout layoutState;
    private int level;
    private TopControllerListener listener;
    boolean needCountDown;
    private TextView tvDeviceStatus;
    private TextView tvGimbalTips;
    private StrokeTextView tvGps;
    private TextView tvLowPowerTips;
    private StrokeTextView tvRemainFlightTime;
    private StrokeTextView tvUavStatus;

    public interface TopControllerListener {
        void onFactoryTestClicked();

        void onNewSettingClicked();

        void onSettingClicked();
    }

    public TopController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.level = 0;
        this.lastGimbalPitch = 100;
        this.isFollowMode = false;
        this.hasTakenOff = false;
        this.needCountDown = false;
        this.handler = new Handler(Looper.getMainLooper()) { // from class: com.ipotensic.kernel.controllers.TopController.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                TopController.this.needCountDown = false;
            }
        };
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.context = view.getContext();
        this.ivGimbalTips = (ImageView) view.findViewById(C1965R.id.iv_gimbal_tips);
        this.tvGimbalTips = (TextView) view.findViewById(C1965R.id.tv_gimbal_tips);
        this.circleBatteryView = (CircleBatteryView) view.findViewById(C1965R.id.view_battery_percentage);
        this.tvDeviceStatus = (TextView) view.findViewById(C1965R.id.tv_device_status);
        this.tvLowPowerTips = (TextView) view.findViewById(C1965R.id.tv_low_power_tips);
        this.tvUavStatus = (StrokeTextView) view.findViewById(C1965R.id.tv_uav_status);
        this.tvGps = (StrokeTextView) view.findViewById(C1965R.id.tv_gps);
        this.ivGps = (ImageView) view.findViewById(C1965R.id.iv_gps);
        this.ivWifi = (ImageView) view.findViewById(C1965R.id.iv_signal_hd);
        this.ivHighMode = (ImageView) view.findViewById(C1965R.id.iv_speed_mode);
        this.ivHaveHead = (ImageView) view.findViewById(C1965R.id.iv_have_direction_mode);
        this.layoutState = (RoundRelativeLayout) view.findViewById(C1965R.id.layout_state);
        this.ivUav = (ImageView) view.findViewById(C1965R.id.iv_uav);
        this.layoutState.setCornerRadius(21);
        StrokeTextView strokeTextView = (StrokeTextView) view.findViewById(C1965R.id.tv_remain_flight_time);
        this.tvRemainFlightTime = strokeTextView;
        strokeTextView.setVisibility(FlightConfig.isOldProduct() ? 8 : 0);
        this.tvRemainFlightTime.setTypeface(PhoneConfig.sourceHanSansCN);
        this.tvUavStatus.setTypeface(PhoneConfig.sourceHanSansCN);
        this.tvGps.setTypeface(PhoneConfig.sourceHanSansCN);
        checkTopState();
        AOAEngine.getInstance().addConnectListener(this);
        view.findViewById(C1965R.id.iv_logo).setOnClickListener(new ScaleClickListener(1000) { // from class: com.ipotensic.kernel.controllers.TopController.2
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                TopController.this.getContext().finish();
            }
        });
        ImageView imageView = (ImageView) view.findViewById(C1965R.id.tv_new_setting);
        this.ivNewSetting = imageView;
        imageView.setOnClickListener(new ScaleClickListener() { // from class: com.ipotensic.kernel.controllers.TopController.3
            @Override // com.ipotensic.baselib.listener.ScaleClickListener
            public void click(View view2) {
                boolean isAtomPanTilt = FlightConfig.isAtomPanTilt();
                boolean isAtomLT = FlightConfig.isAtomLT();
                boolean is_Atom_SE_Series = FlightConfig.is_Atom_SE_Series();
                if (TopController.this.listener != null) {
                    if (isAtomPanTilt || isAtomLT || is_Atom_SE_Series) {
                        TopController.this.listener.onNewSettingClicked();
                    } else {
                        TopController.this.listener.onSettingClicked();
                    }
                }
            }
        });
        if (FlightConfig.isConnectFlight()) {
            this.ivGimbalTips.setVisibility(FlightConfig.isAtomPanTilt() ? 0 : 8);
            this.tvGimbalTips.setVisibility(FlightConfig.isAtomPanTilt() ? 0 : 8);
        }
        controlNoHeadModeView();
    }

    public void setTopControllerListener(TopControllerListener topControllerListener) {
        this.listener = topControllerListener;
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryConnected() {
        checkTopState();
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryDisconnected() {
        DDLog.m1684e("usb onUsbAccessoryDisconnected");
        checkTopState();
    }

    @Override // com.logan.usb.AOAEngine.IEngineCallback
    public void onUsbAccessoryConnectError() {
        DDLog.m1684e("usb onUsbAccessoryConnectError");
        checkTopState();
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (getVisibility() == i) {
            return;
        }
        if (i == 0) {
            AnimationUtil.transInTop(getBaseView());
        } else {
            getBaseView().setVisibility(8);
        }
    }

    private void setDisconnectStatus() {
        this.circleBatteryView.setRemainBattery(-1);
        this.circleBatteryView.setAlpha(0.4f);
        this.tvGps.setText(this.context.getString(C1965R.string.test_data));
        this.ivGps.setImageResource(C1965R.mipmap.icon_gps_disable);
        this.tvGps.setTextColor(getContext().getColor(C1965R.color.color_white_fifty_percent));
        this.ivWifi.setImageLevel(0);
        this.tvUavStatus.setText(this.context.getString(C1965R.string.test_data));
        this.tvUavStatus.setTextColor(getContext().getColor(C1965R.color.color_white_fifty_percent));
        this.ivHaveHead.setImageResource(C1965R.mipmap.icon_top_head_mode_disable);
        this.ivHighMode.setVisibility(8);
        this.tvRemainFlightTime.setText(this.context.getString(C1965R.string.test_data));
        this.lastGimbalPitch = 100;
        this.tvGimbalTips.setText(this.context.getString(C1965R.string.test_data));
        this.tvGimbalTips.setTextColor(getContext().getColor(C1965R.color.color_white_fifty_percent));
        this.tvRemainFlightTime.setTextColor(getContext().getColor(C1965R.color.color_white_fifty_percent));
        this.ivUav.setImageResource(C1965R.mipmap.icon_uav_disable);
        this.ivGimbalTips.setVisibility(8);
        this.tvGimbalTips.setVisibility(8);
    }

    private void setGpsState(FlightRevFlightInfoData flightRevFlightInfoData) {
        if (FlightConfig.curFlight != null) {
            if (FlightConfig.is_Atom_Series()) {
                FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
                if (flightRevStateData != null && flightRevStateData.getMode() == 2) {
                    this.tvGps.setTextColor(getContext().getColor(C1965R.color.colorWhite));
                    this.ivGps.setImageResource(C1965R.mipmap.icon_gps_enable);
                } else {
                    this.tvGps.setTextColor(getContext().getColor(C1965R.color.colorRemainedBattery));
                    this.ivGps.setImageResource(C1965R.mipmap.icon_gps_mistake);
                }
            } else if (flightRevFlightInfoData.isGpsWeak()) {
                this.tvGps.setTextColor(getContext().getColor(C1965R.color.colorRemainedBattery));
                this.ivGps.setImageResource(C1965R.mipmap.icon_gps_mistake);
            } else {
                this.tvGps.setTextColor(getContext().getColor(C1965R.color.colorWhite));
                this.ivGps.setImageResource(C1965R.mipmap.icon_gps_enable);
            }
            this.tvGps.setText(String.format("%d", Integer.valueOf(flightRevFlightInfoData.getSatellitesNum())));
            this.ivUav.setImageResource(C1965R.mipmap.icon_uav);
            this.circleBatteryView.setRemainBattery(flightRevFlightInfoData.getRemainedBattery());
            this.circleBatteryView.setAlpha(1.0f);
        }
    }

    private void controlNoHeadModeView() {
        this.ivHaveHead.setVisibility(8);
    }

    public void setWifiLevel(int i) {
        this.level = i;
        this.ivWifi.setImageLevel(i);
    }

    public void setTestLevel(int i) {
        this.ivWifi.setImageLevel(i);
    }

    private void setDeviceStatus(FlightRevStateData flightRevStateData) {
        checkTopState();
    }

    private void setUavStatus(FlightRevStateData flightRevStateData) {
        this.tvUavStatus.setTextColor(getContext().getColor(C1965R.color.colorWhite));
        if (flightRevStateData.getMode() == 2) {
            this.tvUavStatus.setText(this.context.getString(C1965R.string.plane_gps));
        } else if (flightRevStateData.getMode() == 0) {
            this.tvUavStatus.setText(this.context.getString(C1965R.string.plane_atti));
        } else if (flightRevStateData.getMode() == 1) {
            this.tvUavStatus.setText(FlightConfig.isAtomLT() ? "" : this.context.getString(C1965R.string.optical_flow_mode));
        }
    }

    private void setViewVisible(FlightRevStateData flightRevStateData) {
        if (FlightRevData.get().getFlightRevVersionData().getFlightControlVersion() != null) {
            if (FlightConfig.isOldProduct()) {
                this.ivHighMode.setImageResource(flightRevStateData.isHighSpeedMode() ? C1965R.mipmap.icon_speed_s : C1965R.mipmap.icon_speed_n);
                this.ivHighMode.setVisibility(flightRevStateData.getMode() != 1 ? 0 : 8);
            } else {
                if (flightRevStateData.getSpeedMode() == 0) {
                    this.ivHighMode.setImageResource(C1965R.mipmap.icon_speed_v);
                } else if (flightRevStateData.getSpeedMode() == 1) {
                    this.ivHighMode.setImageResource(C1965R.mipmap.icon_speed_n);
                } else {
                    this.ivHighMode.setImageResource(C1965R.mipmap.icon_speed_s);
                }
                if (CommonUtil.hasNewVersion("1.0.9", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) {
                    this.ivHighMode.setVisibility((flightRevStateData.getMode() != 1 || flightRevStateData.isOutdoor()) ? 0 : 8);
                } else {
                    this.ivHighMode.setVisibility(flightRevStateData.getMode() != 1 ? 0 : 8);
                }
            }
            this.ivHaveHead.setImageResource(flightRevStateData.isNoHeadMode() ? C1965R.mipmap.icon_top_headless_mode : C1965R.mipmap.icon_top_head_mode);
        }
    }

    private void updateGimbalTips(boolean z) {
        if (z) {
            this.ivGimbalTips.setImageResource(C1965R.mipmap.img_icon_gimbal_tips_red);
            this.tvGimbalTips.setTextColor(ContextCompat.getColor(this.context, C1965R.color.color_battery_warn_for));
        } else {
            this.ivGimbalTips.setImageResource(C1965R.mipmap.img_icon_gimbal_tips);
            this.tvGimbalTips.setTextColor(ContextCompat.getColor(this.context, C1965R.color.colorWhite));
        }
    }

    /* renamed from: com.ipotensic.kernel.controllers.TopController$5 */
    static /* synthetic */ class C22295 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_INFO.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_TYPE_DEFINED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_GIMBAL_STATE_DATA.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_VISUAL_TARGET_IS_FOLLOW_MODE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_BATTERY_DATA.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        switch (C22295.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                if (((Boolean) event.obj).booleanValue()) {
                    this.circleBatteryView.setAlpha(1.0f);
                    checkTopState();
                } else {
                    this.handler.removeMessages(0);
                    this.hasTakenOff = false;
                    this.needCountDown = false;
                    checkTopState();
                    setDisconnectStatus();
                }
                controlNoHeadModeView();
                break;
            case 2:
                FlightRevStateData flightRevStateData = (FlightRevStateData) event.obj;
                if (flightRevStateData != null) {
                    setDeviceStatus(flightRevStateData);
                    setUavStatus(flightRevStateData);
                    setViewVisible(flightRevStateData);
                    if (flightRevStateData.isTakeOff()) {
                        this.hasTakenOff = true;
                    } else if (flightRevStateData.isUnLock()) {
                        this.hasTakenOff = false;
                    }
                    if (flightRevStateData.isFlight()) {
                        if (this.hasTakenOff) {
                            this.hasTakenOff = false;
                            this.needCountDown = true;
                            break;
                        }
                    } else {
                        this.needCountDown = false;
                        break;
                    }
                }
                break;
            case 3:
                FlightRevConnectData flightRevConnectData = (FlightRevConnectData) event.obj;
                if (UsbConfig.isUsbConnected && flightRevConnectData.isRemoterConnected() && !flightRevConnectData.isFlightCtrlConnected() && FlightRevData.get().getFlightRevFpvData().isInit() && FlightRevData.get().getFlightRevFpvData().getFpvVersion() != null) {
                    checkTopState();
                    break;
                }
                break;
            case 4:
                FlightRevFlightInfoData flightRevFlightInfoData = (FlightRevFlightInfoData) event.obj;
                if (flightRevFlightInfoData != null) {
                    setGpsState(flightRevFlightInfoData);
                    break;
                }
                break;
            case 5:
                StrokeTextView strokeTextView = this.tvRemainFlightTime;
                if (strokeTextView != null) {
                    strokeTextView.setVisibility(FlightConfig.isOldProduct() ? 8 : 0);
                }
                this.ivGimbalTips.setVisibility(FlightConfig.isAtomPanTilt() ? 0 : 8);
                this.tvGimbalTips.setVisibility(FlightConfig.isAtomPanTilt() ? 0 : 8);
                break;
            case 6:
                FlightRevGimbalStateData gimbalStateData = FlightRevData.get().getGimbalStateData();
                if (this.lastGimbalPitch != gimbalStateData.getControl_pitch()) {
                    this.lastGimbalPitch = gimbalStateData.getControl_pitch();
                    this.tvGimbalTips.setText(this.lastGimbalPitch + "°");
                    int i = this.lastGimbalPitch;
                    updateGimbalTips((i < -75 || i > -25) && this.isFollowMode);
                    break;
                }
                break;
            case 7:
                this.isFollowMode = ((Boolean) event.obj).booleanValue();
                FlightRevGimbalStateData gimbalStateData2 = FlightRevData.get().getGimbalStateData();
                updateGimbalTips((gimbalStateData2.getControl_pitch() < -75 || gimbalStateData2.getControl_pitch() > -25) && this.isFollowMode);
                break;
            case 8:
                if (!FlightConfig.isOldProduct()) {
                    if (this.tvRemainFlightTime.getVisibility() != 0) {
                        this.tvRemainFlightTime.setVisibility(0);
                    }
                    FlightRevBatteryData flightRevBatteryData = (FlightRevBatteryData) event.obj;
                    if (flightRevBatteryData != null) {
                        int remainFlightTime = flightRevBatteryData.getRemainFlightTime();
                        String format = String.format("%02d'%02d\"", Long.valueOf((remainFlightTime % 3600) / 60), Long.valueOf(remainFlightTime % 60));
                        FlightRevStateData flightRevStateData2 = FlightRevData.get().getFlightRevStateData();
                        if (FlightConfig.is_Atom_Series()) {
                            if (this.needCountDown) {
                                this.tvRemainFlightTime.setText("--'--''");
                                this.handler.sendEmptyMessageDelayed(0, 5000L);
                            } else if (flightRevStateData2.isFlight()) {
                                this.tvRemainFlightTime.setText(format);
                            } else {
                                this.tvRemainFlightTime.setText("--'--''");
                            }
                        } else {
                            this.tvRemainFlightTime.setText(format);
                        }
                        this.tvRemainFlightTime.setTextColor(getContext().getColor(C1965R.color.colorWhite));
                        break;
                    }
                }
                break;
        }
    }

    private void checkTopState() {
        TopState topState;
        TopState topState2 = TopState.STATE_DISCONNECT;
        String str = null;
        if (FlightConfig.isConnectFlight()) {
            topState = TopState.STATE_CONNECTED;
            FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
            if (flightRevStateData.isTakeOff()) {
                topState = TopState.STATE_TAKEOFF;
            } else if (flightRevStateData.isReturning()) {
                topState = TopState.STATE_RETURNING;
            } else if (flightRevStateData.isLanding()) {
                topState = TopState.STATE_LANDING;
            } else if (flightRevStateData.isFlight()) {
                topState = TopState.STATE_FLYING;
                if (flightRevStateData.isHotCircle()) {
                    topState = TopState.STATE_CIRCLE_FLYING;
                } else if (flightRevStateData.isPointFly()) {
                    topState = TopState.STATE_WAYPOINT_FLYING;
                } else if (flightRevStateData.isFollowing()) {
                    topState = TopState.STATE_FOLLOW_ME;
                }
            }
            if (Conditions.isTrackTargetOpen()) {
                topState = TopState.STATE_QUICK_SHOT;
                if (Conditions.isVisionTracking()) {
                    topState = TopState.STATE_VISUAL_TRACKING;
                }
            }
            if (flightRevStateData.isLowPowerMode()) {
                str = getContext().getString(topState.stateTxt);
                topState = TopState.STATE_LOW_POWER;
            }
        } else if (FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
            topState = TopState.STATE_DISCONNECT_FLIGHT;
        } else {
            topState = TopState.STATE_DISCONNECT;
        }
        setTopStateTxt(topState, str);
    }

    private void setTopStateTxt(TopState topState, String str) {
        if (str != null) {
            this.tvDeviceStatus.setPadding(17, 0, 5, 0);
            this.tvLowPowerTips.setVisibility(0);
            if (FlightConfig.isOldProduct()) {
                this.tvLowPowerTips.setText(C1965R.string.low_battery_tips);
            } else {
                int powerMode = FlightRevData.get().getFlightRevStateData().getPowerMode();
                if (powerMode == 1) {
                    this.tvLowPowerTips.setText(C1965R.string.mode_one_low_power);
                } else if (powerMode == 2) {
                    this.tvLowPowerTips.setText(C1965R.string.mode_two_low_power);
                }
            }
            this.tvDeviceStatus.setText(str);
            this.tvDeviceStatus.setBackgroundResource(C1965R.color.colorRed);
            return;
        }
        this.tvDeviceStatus.setPadding(17, 0, 17, 0);
        this.tvLowPowerTips.setVisibility(8);
        this.tvDeviceStatus.setText(topState.stateTxt);
        this.tvDeviceStatus.setBackgroundResource(topState.bgColor);
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.kernel.utils.SimpleLifeCycle
    public void onDestroy() {
        super.onDestroy();
        AOAEngine.getInstance().removeListener(this);
        this.handler.removeCallbacksAndMessages(null);
    }

    private enum TopState {
        STATE_DISCONNECT(C1965R.string.plane_disconnecting, C1965R.color.color_kernel_top_state_gray),
        STATE_DISCONNECT_FLIGHT(C1965R.string.remote_not_connected_to_aircraft, C1965R.color.color_kernel_top_state_gray),
        STATE_CONNECTED(C1965R.string.plane_connecting, C1965R.color.color_kernel_top_state_blue),
        STATE_LANDING(C1965R.string.plane_landing, C1965R.color.color_kernel_top_state_light_blue),
        STATE_RETURNING(C1965R.string.plane_returning, C1965R.color.color_kernel_top_state_orange),
        STATE_FLYING(C1965R.string.plane_flighting, C1965R.color.color_kernel_top_state_green),
        STATE_TAKEOFF(C1965R.string.plane_take_off, C1965R.color.color_kernel_top_state_green),
        STATE_WAYPOINT_FLYING(C1965R.string.plane_waypoint_flight, C1965R.color.color_kernel_top_state_green),
        STATE_CIRCLE_FLYING(C1965R.string.plane_hot_circle, C1965R.color.color_kernel_top_state_green),
        STATE_FOLLOW_ME(C1965R.string.plane_follow_up, C1965R.color.color_kernel_top_state_green),
        STATE_VISUAL_TRACKING(C1965R.string.visual_tracking_flight_interface_navigation_tip_bar_title, C1965R.color.color_kernel_top_state_green),
        STATE_QUICK_SHOT(C1965R.string.quickshots_flight_interface_navigation_tip_bar_title, C1965R.color.color_kernel_top_state_green),
        STATE_LOW_POWER(C1965R.string.low_battery_tips, C1965R.color.color_kernel_top_state_red);

        public int bgColor;
        public int stateTxt;

        TopState(int i, int i2) {
            this.stateTxt = i;
            this.bgColor = i2;
        }
    }
}