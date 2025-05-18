package com.ipotensic.kernel.controllers;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.base.BaseSyncDialog;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.permission.PermissionUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.AnimationUtil;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.utils.MapUtil;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevHomePointData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.mapbox.mapboxsdk.geometry.LatLng;

/* loaded from: classes2.dex */
public class TopLeftTipsController extends BaseController {
    private GeneralDialog emergencyStopDialog;
    private boolean isConnectFlight;
    private boolean isEmergencyStop;
    private boolean isGpsAccuracyStatus;
    private TextView tvTopLeftTip;

    public TopLeftTipsController(AppCompatActivity appCompatActivity, View view) {
        super(appCompatActivity, view);
        this.isConnectFlight = false;
        this.isGpsAccuracyStatus = false;
        this.isEmergencyStop = false;
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.tvTopLeftTip = (TextView) view.findViewById(R.id.tv_top_left_tips);
    }

    public boolean checkConnect() {
        if (FlightConfig.isConnectFlight()) {
            return true;
        }
        this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_grey);
        this.tvTopLeftTip.setText(getContext().getString(R.string.toast_unconnected_tips));
        if (getBaseView().getVisibility() == 0) {
            return false;
        }
        AnimationUtil.transInLeft(getBaseView());
        getBaseView().bringToFront();
        getBaseView().postDelayed(new Runnable() { // from class: com.ipotensic.kernel.controllers.TopLeftTipsController.1
            @Override // java.lang.Runnable
            public void run() {
                TopLeftTipsController.this.getBaseView().setVisibility(8);
            }
        }, 3000L);
        return false;
    }

    private boolean isNotAllowTakeOff(FlightRevStateData flightRevStateData) {
        return flightRevStateData.isNeedCalibration() || flightRevStateData.isMagnetometerHorizontalCalibrating() || flightRevStateData.isMagnetometerVerticalCalibrating() || flightRevStateData.isSmartBatteryAbnormal() || flightRevStateData.isGpsConnectError() || flightRevStateData.isMpuError() || flightRevStateData.isPressureError() || flightRevStateData.isGeoTooMuchInterfere();
    }

    private void showTakeOffTip(boolean z) {
        AppCompatActivity context;
        int i;
        AppCompatActivity context2;
        int i2;
        if (FlightRevData.get().getFlightRevStateData().getMode() != 2) {
            if (z && FlightConfig.isAtomLT()) {
                return;
            }
            this.tvTopLeftTip.setBackgroundResource(z ? R.mipmap.img_top_left_orange : R.mipmap.img_top_left_red);
            TextView textView = this.tvTopLeftTip;
            if (z) {
                context2 = getContext();
                i2 = R.string.toast_gps_mode;
            } else {
                context2 = getContext();
                i2 = R.string.toast_take_off_error_tips;
            }
            textView.setText(context2.getString(i2));
        } else {
            this.tvTopLeftTip.setBackgroundResource(z ? R.mipmap.img_top_left_green : R.mipmap.img_top_left_red);
            TextView textView2 = this.tvTopLeftTip;
            if (z) {
                context = getContext();
                i = R.string.toast_take_off_tips;
            } else {
                context = getContext();
                i = R.string.toast_take_off_error_tips;
            }
            textView2.setText(context.getString(i));
        }
        if (getBaseView().getVisibility() != 0) {
            AnimationUtil.transInLeft(getBaseView());
        }
    }

    public void showFlightModeTip(FlightRevStateData flightRevStateData) {
        if (FlightConfig.curFlight == null) {
            return;
        }
        if (FlightConfig.isOldProduct()) {
            if (flightRevStateData.isBatteryAbnormal() || flightRevStateData.isGeoCalibration() || flightRevStateData.isFlightIncline() || flightRevStateData.isLastCalOver50km() || flightRevStateData.isGimbalNotReady() || flightRevStateData.isFlightInclineOver35() || flightRevStateData.isFlightInNoFlyZone() || flightRevStateData.isImuPreparing()) {
                this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_red);
                this.tvTopLeftTip.setText(getContext().getString(R.string.toast_take_off_error_tips));
                if (getBaseView().getVisibility() != 0) {
                    AnimationUtil.transInLeft(getBaseView());
                    return;
                }
                return;
            }
            if (flightRevStateData.isFlight() || flightRevStateData.isTakeOff()) {
                if (getBaseView().getVisibility() == 0) {
                    getBaseView().setVisibility(8);
                    return;
                }
                return;
            } else {
                if (!isNotAllowTakeOff(flightRevStateData) && flightRevStateData.getMode() == 2) {
                    this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_green);
                    this.tvTopLeftTip.setText(getContext().getString(R.string.toast_take_off_tips));
                    if (getBaseView().getVisibility() != 0) {
                        AnimationUtil.transInLeft(getBaseView());
                        return;
                    }
                    return;
                }
                if (getBaseView().getVisibility() == 0) {
                    getBaseView().setVisibility(8);
                    return;
                }
                return;
            }
        }
        int mode = flightRevStateData.getMode();
        boolean z = false;
        if (!flightRevStateData.isFlight() && !flightRevStateData.isTakeOff()) {
            if (!flightRevStateData.isUnLock() && flightRevStateData.isOutdoor() && flightRevStateData.isGeoTooMuchInterfere()) {
                DDLog.e("\u63d0\u793a\u6821\u51c6\u6307\u5357\u9488");
                this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_orange);
                this.tvTopLeftTip.setText(getContext().getString(R.string.need_calibration_compass));
                if (getBaseView().getVisibility() != 0) {
                    AnimationUtil.transInLeft(getBaseView());
                    return;
                }
                return;
            }
            if (Conditions.cannotTakeOff() || flightRevStateData.isBatteryAbnormal() || flightRevStateData.isGeoCalibration() || flightRevStateData.isFlightIncline() || flightRevStateData.isLastCalOver50km() || flightRevStateData.isGimbalNotReady() || flightRevStateData.isFlightInclineOver35() || flightRevStateData.isFlightInNoFlyZone() || flightRevStateData.isImuPreparing()) {
                this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_red);
                this.tvTopLeftTip.setText(getContext().getString(R.string.toast_take_off_error_tips));
                if (getBaseView().getVisibility() != 0) {
                    AnimationUtil.transInLeft(getBaseView());
                    return;
                }
                return;
            }
            boolean z2 = (flightRevStateData.isMpuError() || flightRevStateData.isPressureError()) ? false : true;
            if (mode == 1) {
                if (z2 && !flightRevStateData.isOpticalFlowAbnormal() && !flightRevStateData.isOpticalFlowErrorInAtom()) {
                    z = true;
                }
                showTakeOffTip(z);
                return;
            }
            if (mode == 2) {
                showTakeOffTip(z2);
                return;
            }
            if (mode == 0) {
                if (FlightConfig.isAtomLT() && z2) {
                    this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_red);
                    this.tvTopLeftTip.setText(getContext().getString(R.string.atom_lt_warming_tips_unable_to_take_off_searching_for_gps_outdoors_only));
                    if (getBaseView().getVisibility() != 0) {
                        AnimationUtil.transInLeft(getBaseView());
                        return;
                    }
                    return;
                }
                showTakeOffTip(false);
                return;
            }
            return;
        }
        if (mode == 0) {
            this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_red);
            this.tvTopLeftTip.setText(getContext().getString(R.string.toast_atti_mode));
            if (getBaseView().getVisibility() != 0) {
                DDLog.e("\u7a7a\u4e2d\u5207\u59ff\u6001");
                AnimationUtil.transInLeft(getBaseView());
                return;
            }
            return;
        }
        if (mode == 1) {
            if (FlightConfig.isAtomLT()) {
                return;
            }
            this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_orange);
            this.tvTopLeftTip.setText(getContext().getString(R.string.toast_opti_mode));
            if (getBaseView().getVisibility() != 0) {
                DDLog.e("\u7a7a\u4e2d\u5207\u5149\u6d41");
                AnimationUtil.transInLeft(getBaseView());
                return;
            }
            return;
        }
        if (mode == 2) {
            try {
                int returnHeight = FlightRevData.get().getFlightRevSettingData().getReturnHeight();
                FlightRevHomePointData flightRevHomePointData = FlightRevData.get().getFlightRevHomePointData();
                FlightRevFlightInfoData flightRevFlightInfoData = FlightRevData.get().getFlightRevFlightInfoData();
                double distance = MapUtil.distance(new LatLng(flightRevHomePointData.getLat(), flightRevHomePointData.getLng()), new LatLng(flightRevFlightInfoData.getLat(), flightRevFlightInfoData.getLng()));
                double verticalDistance = flightRevFlightInfoData.getVerticalDistance();
                if (flightRevHomePointData.isInitThisFly() && returnHeight != 0 && distance > 20.0d) {
                    boolean isFt = SPHelper.getInstance().isFt();
                    if (verticalDistance > returnHeight) {
                        returnHeight = (int) verticalDistance;
                    }
                    String str = returnHeight + "m";
                    if (isFt) {
                        str = FlightConfig.get_value(returnHeight) + "ft";
                    }
                    String string = getContext().getString(R.string.txt_return_height, new Object[]{str});
                    this.tvTopLeftTip.setBackgroundResource(R.mipmap.img_top_left_green);
                    this.tvTopLeftTip.setText(string);
                    if (getBaseView().getVisibility() != 0) {
                        DDLog.e("\u663e\u793a\u8fd4\u822a\u9ad8\u5ea6");
                        AnimationUtil.transInLeft(getBaseView());
                        return;
                    }
                    return;
                }
                if (getBaseView().getVisibility() == 0) {
                    getBaseView().setVisibility(8);
                }
            } catch (Exception e) {
                DDLog.e("\u663e\u793a\u51fa\u9519:" + e.getMessage());
            }
        }
    }

    public void showGpsAccuracyStatus(Activity activity) {
        if (this.isGpsAccuracyStatus) {
            return;
        }
        this.isGpsAccuracyStatus = true;
        ToastUtil.showImageLeft(activity, activity.getString(R.string.toast_phone_gps_weak), activity.getString(R.string.toast_phone_gps_weak_describe), R.mipmap.img_toast_followme_gps_weak);
    }

    public void resetGpsAccuracyStatus() {
        this.isGpsAccuracyStatus = false;
    }

    public void showConnectTip(Activity activity) {
        if (this.isConnectFlight) {
            return;
        }
        this.isConnectFlight = true;
        ToastUtil.showImageLeft(activity, activity.getString(R.string.toast_disconnected), activity.getString(R.string.toast_disconnected_describe), R.mipmap.icon_need_connect_flight);
    }

    public void showEmergencyStopTip(Activity activity) {
        if (this.isEmergencyStop) {
            return;
        }
        this.isEmergencyStop = true;
        if (BaseSyncDialog.isShow) {
            return;
        }
        if (this.emergencyStopDialog == null) {
            this.emergencyStopDialog = new GeneralDialog((Context) activity, activity.getString(R.string.dialog_emergency_stop), activity.getString(R.string.dialog_emergency_stop_describe), "", "", false, 1, new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.controllers.TopLeftTipsController.2
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                public void confirm() {
                }
            });
        }
        if (this.emergencyStopDialog.isShowing()) {
            return;
        }
        this.emergencyStopDialog.show();
    }

    public void resetEmergencyStop() {
        this.isEmergencyStop = false;
        GeneralDialog generalDialog = this.emergencyStopDialog;
        if (generalDialog == null || !generalDialog.isShowing()) {
            return;
        }
        this.emergencyStopDialog.dismiss();
    }

    public boolean checkPermissionTip(BaseActivity baseActivity) {
        PermissionUtil.requestLocationPermissionAndGpsEnable(baseActivity, new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.controllers.TopLeftTipsController.3
            @Override // com.ipotensic.baselib.listener.SimpleResultListener
            public void onResult(Boolean bool) {
            }
        });
        return PermissionUtil.hasLocationPermissionAndGpsEnable(baseActivity);
    }

    /* renamed from: com.ipotensic.kernel.controllers.TopLeftTipsController$4, reason: invalid class name */
    static /* synthetic */ class AnonymousClass4 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        if (AnonymousClass4.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()] != 1) {
            return;
        }
        FlightConfig.isConnectFlight();
    }
}