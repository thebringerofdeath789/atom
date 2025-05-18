package com.ipotensic.kernel.controllers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.collection.ArraySet;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.ipotensic.baselib.base.BaseActivity;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.observer.LifeCycleNotifyBoolean;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.baselib.views.ShadowLayout;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.SoundTip;
import com.ipotensic.kernel.manager.BigPackageFirmwareDownload;
import com.ipotensic.kernel.manager.TipManager;
import com.logan.camera.data.HardwareStateUploadData;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevNoFlyZone;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class WarnController extends BaseController implements View.OnClickListener {
    private ImageButton btnWarn;
    private int errorState;
    private final MutableLiveData heightRestrictedTip;
    private final LifeCycleNotifyBoolean isAbnormalBatteryTemperature;
    private final LifeCycleNotifyBoolean isBatteryAbnormal;
    private final LifeCycleNotifyBoolean isBatteryAbnormalToLimitSpeed;
    private final LifeCycleNotifyBoolean isBatteryCurrentAbnormal;
    private final LifeCycleNotifyBoolean isBatteryHighPress;
    private final LifeCycleNotifyBoolean isCMOSError;
    private final LifeCycleNotifyBoolean isCamOpticalFlowError;
    private final LifeCycleNotifyBoolean isEscCheckPaddledIntact;
    private final LifeCycleNotifyBoolean isEscFault;
    private final LifeCycleNotifyBoolean isEscHighTemp;
    private final LifeCycleNotifyBoolean isFlightInNoFlyZone;
    private final LifeCycleNotifyBoolean isForbidTakeoff;
    private final LifeCycleNotifyBoolean isGeomagneticFault;
    private final LifeCycleNotifyBoolean isGimbalAngleTooBig;
    private final LifeCycleNotifyBoolean isGimbalError;
    private final LifeCycleNotifyBoolean isGimbalNeedCalibration;
    private final LifeCycleNotifyBoolean isGimbalNotReady;
    private final LifeCycleNotifyBoolean isGimbalOverload;
    private final LifeCycleNotifyBoolean isGimbalStuck;
    private final LifeCycleNotifyBoolean isGimbalTempTooHigh;
    private final LifeCycleNotifyBoolean isGpsConnectError;
    private final LifeCycleNotifyBoolean isGpsWeak;
    private final LifeCycleNotifyBoolean isImuPreparing;
    private final LifeCycleNotifyBoolean isLanding;
    private final LifeCycleNotifyBoolean isMaxRestrictedHeight;
    private final LifeCycleNotifyBoolean isMotorFullPower;
    private final LifeCycleNotifyBoolean isMotorOverCurrent;
    private final LifeCycleNotifyBoolean isMotorStuck;
    private final LifeCycleNotifyBoolean isMpuError;
    private final LifeCycleNotifyBoolean isNearLocatedNoFlyZone;
    private final MutableLiveData isNearRestrictedZone;
    private final LifeCycleNotifyBoolean isNetWorkFault;
    private final LifeCycleNotifyBoolean isOPTIAllowHighest;
    private final LifeCycleNotifyBoolean isOpticalFlow;
    private final LifeCycleNotifyBoolean isOpticalFlowErrorInAtom;
    private final LifeCycleNotifyBoolean isPTZAttitudeAbnormal;
    private final LifeCycleNotifyBoolean isPTZFlashError;
    private final LifeCycleNotifyBoolean isPTZGyroscopeFault;
    private final LifeCycleNotifyBoolean isPTZMotorAbnormal;
    private final LifeCycleNotifyBoolean isPlaneExceedLimitDistance;
    private final LifeCycleNotifyBoolean isPlaneExceedLimitHigh;
    private final LifeCycleNotifyBoolean isPressureError;
    private final MutableLiveData isRestrictedZone;
    private final LifeCycleNotifyBoolean isTakeoff;
    private final LifeCycleNotifyBoolean isTofFault;
    private ArraySet<String> list;
    private RecyclerView recyclerView;
    private ShadowLayout shadowLayout;
    private RelativeLayout topView;
    private WarnAdapter warnAdapter;

    public WarnController(final AppCompatActivity appCompatActivity, View view, final TipManager tipManager) {
        super(appCompatActivity, view);
        this.list = new ArraySet<>();
        this.errorState = -1;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean = new LifeCycleNotifyBoolean(false);
        this.isGimbalError = lifeCycleNotifyBoolean;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean2 = new LifeCycleNotifyBoolean(false);
        this.isGimbalNeedCalibration = lifeCycleNotifyBoolean2;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean3 = new LifeCycleNotifyBoolean(false);
        this.isGimbalStuck = lifeCycleNotifyBoolean3;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean4 = new LifeCycleNotifyBoolean(false);
        this.isGimbalOverload = lifeCycleNotifyBoolean4;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean5 = new LifeCycleNotifyBoolean(false);
        this.isGimbalAngleTooBig = lifeCycleNotifyBoolean5;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean6 = new LifeCycleNotifyBoolean(false);
        this.isMpuError = lifeCycleNotifyBoolean6;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean7 = new LifeCycleNotifyBoolean(false);
        this.isGpsWeak = lifeCycleNotifyBoolean7;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean8 = new LifeCycleNotifyBoolean(false);
        this.isPressureError = lifeCycleNotifyBoolean8;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean9 = new LifeCycleNotifyBoolean(false);
        this.isGpsConnectError = lifeCycleNotifyBoolean9;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean10 = new LifeCycleNotifyBoolean(false);
        this.isBatteryAbnormal = lifeCycleNotifyBoolean10;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean11 = new LifeCycleNotifyBoolean(false);
        this.isBatteryCurrentAbnormal = lifeCycleNotifyBoolean11;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean12 = new LifeCycleNotifyBoolean(false);
        this.isGimbalNotReady = lifeCycleNotifyBoolean12;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean13 = new LifeCycleNotifyBoolean(false);
        this.isFlightInNoFlyZone = lifeCycleNotifyBoolean13;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean14 = new LifeCycleNotifyBoolean(false);
        this.isImuPreparing = lifeCycleNotifyBoolean14;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean15 = new LifeCycleNotifyBoolean(false);
        this.isGeomagneticFault = lifeCycleNotifyBoolean15;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean16 = new LifeCycleNotifyBoolean(false);
        this.isNetWorkFault = lifeCycleNotifyBoolean16;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean17 = new LifeCycleNotifyBoolean(false);
        this.isPlaneExceedLimitDistance = lifeCycleNotifyBoolean17;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean18 = new LifeCycleNotifyBoolean(false);
        this.isPlaneExceedLimitHigh = lifeCycleNotifyBoolean18;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean19 = new LifeCycleNotifyBoolean(false);
        this.isTofFault = lifeCycleNotifyBoolean19;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean20 = new LifeCycleNotifyBoolean(false);
        this.isOpticalFlow = lifeCycleNotifyBoolean20;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean21 = new LifeCycleNotifyBoolean(false);
        this.isOpticalFlowErrorInAtom = lifeCycleNotifyBoolean21;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean22 = new LifeCycleNotifyBoolean(false);
        this.isCamOpticalFlowError = lifeCycleNotifyBoolean22;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean23 = new LifeCycleNotifyBoolean(false);
        this.isBatteryHighPress = lifeCycleNotifyBoolean23;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean24 = new LifeCycleNotifyBoolean(false);
        this.isPTZMotorAbnormal = lifeCycleNotifyBoolean24;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean25 = new LifeCycleNotifyBoolean(false);
        this.isPTZGyroscopeFault = lifeCycleNotifyBoolean25;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean26 = new LifeCycleNotifyBoolean(false);
        this.isAbnormalBatteryTemperature = lifeCycleNotifyBoolean26;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean27 = new LifeCycleNotifyBoolean(false);
        this.isPTZFlashError = lifeCycleNotifyBoolean27;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean28 = new LifeCycleNotifyBoolean(false);
        this.isOPTIAllowHighest = lifeCycleNotifyBoolean28;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean29 = new LifeCycleNotifyBoolean(false);
        this.isPTZAttitudeAbnormal = lifeCycleNotifyBoolean29;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean30 = new LifeCycleNotifyBoolean(false);
        this.isMotorFullPower = lifeCycleNotifyBoolean30;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean31 = new LifeCycleNotifyBoolean(false);
        this.isMotorStuck = lifeCycleNotifyBoolean31;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean32 = new LifeCycleNotifyBoolean(false);
        this.isMotorOverCurrent = lifeCycleNotifyBoolean32;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean33 = new LifeCycleNotifyBoolean(false);
        this.isEscFault = lifeCycleNotifyBoolean33;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean34 = new LifeCycleNotifyBoolean(false);
        this.isEscHighTemp = lifeCycleNotifyBoolean34;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean35 = new LifeCycleNotifyBoolean(false);
        this.isEscCheckPaddledIntact = lifeCycleNotifyBoolean35;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean36 = new LifeCycleNotifyBoolean(false);
        this.isGimbalTempTooHigh = lifeCycleNotifyBoolean36;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean37 = new LifeCycleNotifyBoolean(false);
        this.isCMOSError = lifeCycleNotifyBoolean37;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean38 = new LifeCycleNotifyBoolean(false);
        this.isForbidTakeoff = lifeCycleNotifyBoolean38;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean39 = new LifeCycleNotifyBoolean(false);
        this.isNearLocatedNoFlyZone = lifeCycleNotifyBoolean39;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean40 = new LifeCycleNotifyBoolean(false);
        this.isBatteryAbnormalToLimitSpeed = lifeCycleNotifyBoolean40;
        MutableLiveData mutableLiveData = new MutableLiveData(false);
        this.isRestrictedZone = mutableLiveData;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean41 = new LifeCycleNotifyBoolean(false);
        this.isMaxRestrictedHeight = lifeCycleNotifyBoolean41;
        MutableLiveData mutableLiveData2 = new MutableLiveData(false);
        this.isNearRestrictedZone = mutableLiveData2;
        this.heightRestrictedTip = new MutableLiveData("");
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean42 = new LifeCycleNotifyBoolean(false);
        this.isTakeoff = lifeCycleNotifyBoolean42;
        LifeCycleNotifyBoolean lifeCycleNotifyBoolean43 = new LifeCycleNotifyBoolean(false);
        this.isLanding = lifeCycleNotifyBoolean43;
        lifeCycleNotifyBoolean.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.1
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.txt_error_gimbal_error));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.txt_error_gimbal_error));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.txt_error_gimbal_error));
                    tipManager.stopAndRemove(new SoundTip(-1, R.string.txt_error_gimbal_error));
                }
            }
        });
        lifeCycleNotifyBoolean2.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.2
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.txt_error_gimbal_need_calibration));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.txt_error_gimbal_need_calibration));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.txt_error_gimbal_need_calibration));
                    tipManager.stopAndRemove(new SoundTip(-1, R.string.txt_error_gimbal_need_calibration));
                }
            }
        });
        lifeCycleNotifyBoolean3.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.3
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warning_flight_interface_the_gimbal_is_stuck_detailed_tips));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warning_flight_interface_the_gimbal_is_stuck_detailed_tips));
                    BigPackageFirmwareDownload.getInstance().dismissDialog();
                    return;
                }
                WarnController warnController2 = WarnController.this;
                warnController2.delete(warnController2.getContext().getString(R.string.warning_flight_interface_the_gimbal_is_stuck_detailed_tips));
                tipManager.stopAndRemove(new SoundTip(-1, R.string.warning_flight_interface_the_gimbal_is_stuck_detailed_tips));
                BigPackageFirmwareDownload.getInstance().checkDownloadFW((BaseActivity) appCompatActivity, null);
            }
        });
        lifeCycleNotifyBoolean4.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.4
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips));
                    BigPackageFirmwareDownload.getInstance().dismissDialog();
                    return;
                }
                WarnController warnController2 = WarnController.this;
                warnController2.delete(warnController2.getContext().getString(R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips));
                tipManager.stopAndRemove(new SoundTip(-1, R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips));
                BigPackageFirmwareDownload.getInstance().checkDownloadFW((BaseActivity) appCompatActivity, null);
            }
        });
        lifeCycleNotifyBoolean5.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.5
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                        WarnController warnController = WarnController.this;
                        warnController.add(warnController.getContext().getString(R.string.txt_error_gimbal_angle_too_big_shake));
                        WarnController warnController2 = WarnController.this;
                        warnController2.delete(warnController2.getContext().getString(R.string.txt_error_gimbal_angle_too_big));
                        tipManager.addOnlyOnce(new SoundTip(-1, R.string.txt_error_gimbal_angle_too_big_shake));
                        tipManager.stopAndRemove(new SoundTip(-1, R.string.txt_error_gimbal_angle_too_big));
                        return;
                    }
                    WarnController warnController3 = WarnController.this;
                    warnController3.add(warnController3.getContext().getString(R.string.txt_error_gimbal_angle_too_big));
                    WarnController warnController4 = WarnController.this;
                    warnController4.delete(warnController4.getContext().getString(R.string.txt_error_gimbal_angle_too_big_shake));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.txt_error_gimbal_angle_too_big));
                    tipManager.stopAndRemove(new SoundTip(-1, R.string.txt_error_gimbal_angle_too_big_shake));
                    return;
                }
                WarnController warnController5 = WarnController.this;
                warnController5.delete(warnController5.getContext().getString(R.string.txt_error_gimbal_angle_too_big_shake));
                WarnController warnController6 = WarnController.this;
                warnController6.delete(warnController6.getContext().getString(R.string.txt_error_gimbal_angle_too_big));
                tipManager.stopAndRemove(new SoundTip(-1, R.string.txt_error_gimbal_angle_too_big_shake));
                tipManager.stopAndRemove(new SoundTip(-1, R.string.txt_error_gimbal_angle_too_big));
            }
        });
        lifeCycleNotifyBoolean36.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.6
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    BigPackageFirmwareDownload.getInstance().dismissDialog();
                } else {
                    BigPackageFirmwareDownload.getInstance().checkDownloadFW((BaseActivity) appCompatActivity, null);
                }
            }
        });
        lifeCycleNotifyBoolean6.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.7
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_mpu));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_warn_mpu_sensor_error, R.string.error_mpu));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_mpu));
                }
            }
        });
        lifeCycleNotifyBoolean7.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.8
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_gps_weak));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_warn_gps_weak, R.string.error_gps_weak));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_gps_weak));
                }
            }
        });
        lifeCycleNotifyBoolean8.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.9
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_barometer));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_warn_barometer_error, R.string.error_barometer));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_barometer));
                }
            }
        });
        lifeCycleNotifyBoolean9.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.10
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_gps_error));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_warn_gps_error, R.string.error_gps_error));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_gps_error));
                }
            }
        });
        lifeCycleNotifyBoolean10.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.11
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_smart_battery));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_error_smart_battery, R.string.error_smart_battery));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_smart_battery));
                }
            }
        });
        lifeCycleNotifyBoolean11.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$WarnController$Y0Hqc7q3JZp26qZfhG0MxxdckNg
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public final void onNotifyChanged(boolean z) {
                WarnController.this.lambda$new$0$WarnController(z);
            }
        });
        lifeCycleNotifyBoolean12.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.12
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.ptz_preparation));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.ptz_preparation));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.ptz_preparation));
                }
            }
        });
        lifeCycleNotifyBoolean13.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.13
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.txt_flight_in_no_fly_zone));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.txt_flight_in_no_fly_zone));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.txt_flight_in_no_fly_zone));
                }
            }
        });
        lifeCycleNotifyBoolean14.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.14
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.txt_imu_preparing));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.txt_imu_preparing));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.txt_imu_preparing));
                }
            }
        });
        lifeCycleNotifyBoolean15.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.15
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_geo_fault));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_error_geo_fault, R.string.error_geo_fault));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_geo_fault));
                }
            }
        });
        lifeCycleNotifyBoolean16.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.16
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_network_fault));
                    tipManager.addOnlyOnce(new SoundTip(R.raw.audio_gps_fault, R.string.error_network_fault));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_network_fault));
                }
            }
        });
        lifeCycleNotifyBoolean17.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.17
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    boolean isNewerModeOpen = FlightRevData.get().getFlightRevSettingData().isNewerModeOpen();
                    WarnController warnController = WarnController.this;
                    warnController.delete(isNewerModeOpen ? warnController.getContext().getString(R.string.error_limit_distance) : warnController.getContext().getString(R.string.error_new_limit_distance));
                    WarnController warnController2 = WarnController.this;
                    warnController2.add(isNewerModeOpen ? warnController2.getContext().getString(R.string.error_new_limit_distance) : warnController2.getContext().getString(R.string.error_limit_distance));
                    tipManager.addOnlyOnce(isNewerModeOpen ? new SoundTip(R.raw.audio_error_limit_distance, R.string.error_new_limit_distance) : new SoundTip(R.raw.audio_error_limit_distance, R.string.error_limit_distance));
                    return;
                }
                WarnController warnController3 = WarnController.this;
                warnController3.delete(warnController3.getContext().getString(R.string.error_limit_distance));
                WarnController warnController4 = WarnController.this;
                warnController4.delete(warnController4.getContext().getString(R.string.error_new_limit_distance));
            }
        });
        lifeCycleNotifyBoolean18.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.18
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    boolean isNewerModeOpen = FlightRevData.get().getFlightRevSettingData().isNewerModeOpen();
                    WarnController warnController = WarnController.this;
                    warnController.delete(isNewerModeOpen ? warnController.getContext().getString(R.string.error_limit_high) : warnController.getContext().getString(R.string.error_new_limit_high));
                    WarnController warnController2 = WarnController.this;
                    warnController2.add(isNewerModeOpen ? warnController2.getContext().getString(R.string.error_new_limit_high) : warnController2.getContext().getString(R.string.error_limit_high));
                    tipManager.addOnlyOnce(FlightRevData.get().getFlightRevSettingData().isNewerModeOpen() ? new SoundTip(R.raw.audio_error_limit_high, R.string.error_new_limit_high) : new SoundTip(R.raw.audio_error_limit_high, R.string.error_limit_high));
                    return;
                }
                WarnController warnController3 = WarnController.this;
                warnController3.delete(warnController3.getContext().getString(R.string.error_new_limit_high));
                WarnController warnController4 = WarnController.this;
                warnController4.delete(warnController4.getContext().getString(R.string.error_limit_high));
            }
        });
        lifeCycleNotifyBoolean19.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.19
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (FlightConfig.isAtomLT()) {
                    return;
                }
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_tof_fault));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.error_tof_fault));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_tof_fault));
                }
            }
        });
        lifeCycleNotifyBoolean20.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.20
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_optical_flow_fault));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.error_optical_flow_fault));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_optical_flow_fault));
                }
            }
        });
        lifeCycleNotifyBoolean21.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.21
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (FlightConfig.isAtomLT()) {
                    return;
                }
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.optical_flow_error_in_atom));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.optical_flow_error_in_atom));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.optical_flow_error_in_atom));
                }
            }
        });
        lifeCycleNotifyBoolean23.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.22
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    boolean isFlight = FlightRevData.get().getFlightRevStateData().isFlight();
                    WarnController warnController = WarnController.this;
                    warnController.delete(warnController.getContext().getString(isFlight ? R.string.error_battery_no_takeoff_fault : R.string.error_battery_flight_fault));
                    WarnController warnController2 = WarnController.this;
                    warnController2.add(warnController2.getContext().getString(isFlight ? R.string.error_battery_flight_fault : R.string.error_battery_no_takeoff_fault));
                    tipManager.stopAndRemove(isFlight ? new SoundTip(-1, R.string.error_battery_no_takeoff_fault) : new SoundTip(R.raw.audio_battery_pressure_too_large, R.string.error_battery_flight_fault, true));
                    tipManager.addOnlyOnce(isFlight ? new SoundTip(R.raw.audio_battery_pressure_too_large, R.string.error_battery_flight_fault, true) : new SoundTip(-1, R.string.error_battery_no_takeoff_fault));
                    return;
                }
                WarnController warnController3 = WarnController.this;
                warnController3.delete(warnController3.getContext().getString(R.string.error_battery_no_takeoff_fault));
                WarnController warnController4 = WarnController.this;
                warnController4.delete(warnController4.getContext().getString(R.string.error_battery_flight_fault));
                tipManager.stopAndRemove(new SoundTip(R.raw.audio_battery_pressure_too_large, R.string.error_battery_flight_fault, true));
            }
        });
        lifeCycleNotifyBoolean24.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.23
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_ptz_motor_abnormal));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.error_ptz_motor_abnormal));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_ptz_motor_abnormal));
                }
            }
        });
        lifeCycleNotifyBoolean25.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.24
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_ptz_gyroscope_fault));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.error_ptz_gyroscope_fault));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_ptz_gyroscope_fault));
                }
            }
        });
        lifeCycleNotifyBoolean26.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.25
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_battery_temperature));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.error_battery_temperature));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_battery_temperature));
                }
            }
        });
        lifeCycleNotifyBoolean27.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.26
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.error_ptz_flash_error));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.error_ptz_flash_error));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.error_ptz_flash_error));
                }
            }
        });
        lifeCycleNotifyBoolean28.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.27
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (FlightConfig.isAtomLT()) {
                    return;
                }
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.opti_allow_highest));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.opti_allow_highest, false));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.opti_allow_highest));
                }
            }
        });
        lifeCycleNotifyBoolean29.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.28
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.ptz_preparation));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.ptz_preparation));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.ptz_preparation));
                }
            }
        });
        lifeCycleNotifyBoolean30.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.29
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warn_motor_full_power));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warn_motor_full_power));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.warn_motor_full_power));
                }
            }
        });
        lifeCycleNotifyBoolean31.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.30
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                boolean isFlight = FlightRevData.get().getFlightRevStateData().isFlight();
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(isFlight ? warnController.getContext().getString(R.string.warn_motor_stuck) : warnController.getContext().getString(R.string.warn_motor_around_no_object));
                    tipManager.addOnlyOnce(new SoundTip(-1, isFlight ? R.string.warn_motor_stuck : R.string.warn_motor_around_no_object));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(isFlight ? warnController2.getContext().getString(R.string.warn_motor_stuck) : warnController2.getContext().getString(R.string.warn_motor_around_no_object));
                }
            }
        });
        lifeCycleNotifyBoolean32.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.31
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warn_motor_over_current));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warn_motor_over_current));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.warn_motor_over_current));
                }
            }
        });
        lifeCycleNotifyBoolean33.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.32
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warn_esc_fault));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warn_esc_fault));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.warn_esc_fault));
                }
            }
        });
        lifeCycleNotifyBoolean34.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.33
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warn_esc_high_temp));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warn_esc_high_temp));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.warn_esc_high_temp));
                }
            }
        });
        lifeCycleNotifyBoolean35.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.34
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.warn_esc_check_paddles_intact));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.warn_esc_check_paddles_intact));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.warn_esc_check_paddles_intact));
                }
            }
        });
        lifeCycleNotifyBoolean37.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$WarnController$W9aR6XT1Qh347Wokvi-NEJGf79w
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public final void onNotifyChanged(boolean z) {
                WarnController.this.lambda$new$1$WarnController(z);
            }
        });
        lifeCycleNotifyBoolean22.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.-$$Lambda$WarnController$aKtIyKvGMG6kJGWdxFZRcEh7zW4
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public final void onNotifyChanged(boolean z) {
                WarnController.this.lambda$new$2$WarnController(tipManager, z);
            }
        });
        lifeCycleNotifyBoolean38.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.35
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.waring_tips_no_fly_zone));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.waring_tips_no_fly_zone));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.waring_tips_no_fly_zone));
                }
            }
        });
        lifeCycleNotifyBoolean39.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.36
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    if (FlightRevData.get().getFlightRevStateData().isFlight() || FlightRevData.get().getFlightRevStateData().isTakeOff()) {
                        WarnController warnController = WarnController.this;
                        warnController.add(warnController.getContext().getString(R.string.waring_tips_approaching_no_fly_zone));
                        tipManager.addOnlyOnce(new SoundTip(-1, R.string.waring_tips_approaching_no_fly_zone));
                        return;
                    }
                    return;
                }
                WarnController warnController2 = WarnController.this;
                warnController2.delete(warnController2.getContext().getString(R.string.waring_tips_approaching_no_fly_zone));
            }
        });
        mutableLiveData.observe(appCompatActivity, new Observer<Boolean>() { // from class: com.ipotensic.kernel.controllers.WarnController.37
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (bool.booleanValue() && FlightRevData.get().getFlightRevStateData().isFlight()) {
                    String string = WarnController.this.getContext().getString(R.string.waring_tips_altitude_restricted_area_altitude_limit_xxx, new Object[]{FlightConfig.getValueWithUnit(FlightRevData.get().getNoFlyZoneData().getStatus_2())});
                    WarnController.this.heightRestrictedTip.setValue(string);
                    WarnController.this.add(string);
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.waring_tips_altitude_restricted_area_altitude_limit_xxx, string));
                } else {
                    WarnController warnController = WarnController.this;
                    warnController.delete(warnController.heightRestrictedTip.getValue().toString());
                }
                if (bool.booleanValue() && FlightRevData.get().getFlightRevStateData().isReturning()) {
                    ToastUtil.toast(appCompatActivity, WarnController.this.getContext().getString(R.string.toast_the_return_path_passes_through_the_altitude_restricted_area));
                }
            }
        });
        lifeCycleNotifyBoolean41.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.38
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z && FlightRevData.get().getFlightRevStateData().isFlight() && FlightConfig.isUnableRiseFurther(FlightRevData.get().getNoFlyZoneData().getStatus_2())) {
                    WarnController warnController = WarnController.this;
                    warnController.add(warnController.getContext().getString(R.string.waring_tips_maximum_altitude_limit_reached_in_the_altitude_restricted_area));
                    tipManager.addOnlyOnce(new SoundTip(-1, R.string.waring_tips_maximum_altitude_limit_reached_in_the_altitude_restricted_area));
                } else {
                    WarnController warnController2 = WarnController.this;
                    warnController2.delete(warnController2.getContext().getString(R.string.waring_tips_maximum_altitude_limit_reached_in_the_altitude_restricted_area));
                }
            }
        });
        mutableLiveData2.observe(appCompatActivity, new Observer<Boolean>() { // from class: com.ipotensic.kernel.controllers.WarnController.39
            @Override // androidx.lifecycle.Observer
            public void onChanged(Boolean bool) {
                if (!bool.booleanValue() || FlightRevData.get().getNoFlyZoneData().getStatus_2() >= FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance()) {
                    return;
                }
                if (FlightRevData.get().getFlightRevStateData().isReturning()) {
                    ToastUtil.toast(appCompatActivity, WarnController.this.getContext().getString(R.string.toast_the_altitude_limit_of_the_restricted_area_is_xxx_the_drone_has_exited_rth, new Object[]{FlightConfig.getValueWithUnit(FlightRevData.get().getNoFlyZoneData().getStatus_2())}));
                } else if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                    ToastUtil.toast(appCompatActivity, WarnController.this.getContext().getString(R.string.toast_the_altitude_limit_of_the_restricted_area_is_xxx_cannot_enter_the_altitude_restricted_area, new Object[]{FlightConfig.getValueWithUnit(FlightRevData.get().getNoFlyZoneData().getStatus_2())}));
                }
            }
        });
        lifeCycleNotifyBoolean42.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.40
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (FlightRevData.get().getNoFlyZoneData().getIsNearLocatedNoFlyZone()) {
                    if (z) {
                        WarnController warnController = WarnController.this;
                        warnController.add(warnController.getContext().getString(R.string.waring_tips_approaching_no_fly_zone));
                        tipManager.addOnlyOnce(new SoundTip(-1, R.string.waring_tips_approaching_no_fly_zone));
                    } else {
                        if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                            return;
                        }
                        WarnController warnController2 = WarnController.this;
                        warnController2.delete(warnController2.getContext().getString(R.string.waring_tips_approaching_no_fly_zone));
                    }
                }
            }
        });
        lifeCycleNotifyBoolean43.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.41
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (FlightRevData.get().getNoFlyZoneData().getIsNearLocatedNoFlyZone() && z) {
                    WarnController warnController = WarnController.this;
                    warnController.delete(warnController.getContext().getString(R.string.waring_tips_approaching_no_fly_zone));
                }
            }
        });
        lifeCycleNotifyBoolean40.addNotifyListener(appCompatActivity.getLifecycle(), new LifeCycleNotifyBoolean.OnNotifyListener() { // from class: com.ipotensic.kernel.controllers.WarnController.42
            @Override // com.ipotensic.baselib.observer.LifeCycleNotifyBoolean.OnNotifyListener
            public void onNotifyChanged(boolean z) {
                if (z) {
                    if (FlightRevData.get().getFlightRevStateData().isFlight()) {
                        WarnController warnController = WarnController.this;
                        warnController.add(warnController.getContext().getString(R.string.warning_tip_the_flight_speed_has_been_restricted));
                        tipManager.addOnlyOnce(new SoundTip(-1, R.string.warning_tip_the_flight_speed_has_been_restricted));
                        return;
                    }
                    return;
                }
                WarnController warnController2 = WarnController.this;
                warnController2.delete(warnController2.getContext().getString(R.string.warning_tip_the_flight_speed_has_been_restricted));
            }
        });
    }

    public /* synthetic */ void lambda$new$0$WarnController(boolean z) {
        if (z) {
            add(getContext().getString(R.string.flight_interface_warning_bar_tips_abnormal_battery_current));
        } else {
            delete(getContext().getString(R.string.flight_interface_warning_bar_tips_abnormal_battery_current));
        }
    }

    public /* synthetic */ void lambda$new$1$WarnController(boolean z) {
        if (z) {
            add(getContext().getString(R.string.warning_flight_interface_cmos_error_tips));
        } else {
            delete(getContext().getString(R.string.warning_flight_interface_cmos_error_tips));
        }
    }

    public /* synthetic */ void lambda$new$2$WarnController(TipManager tipManager, boolean z) {
        if (z) {
            add(getContext().getString(R.string.optical_flow_error_in_atom));
            tipManager.addOnlyOnce(new SoundTip(-1, R.string.optical_flow_error_in_atom));
        } else {
            delete(getContext().getString(R.string.optical_flow_error_in_atom));
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void initView(View view) {
        this.btnWarn = (ImageButton) view.findViewById(R.id.btn_warn_view);
        this.recyclerView = (RecyclerView) view.findViewById(R.id.rv_warn_list);
        this.btnWarn.setOnClickListener(this);
        this.topView = (RelativeLayout) view.findViewById(R.id.ll_top_view);
        this.shadowLayout = (ShadowLayout) view.findViewById(R.id.shadow_layout);
        view.findViewById(R.id.btn_warn_close).setOnClickListener(this);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void add(String str) {
        this.list.add(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void delete(String str) {
        this.list.remove(str);
    }

    /* renamed from: com.ipotensic.kernel.controllers.WarnController$43, reason: invalid class name */
    static /* synthetic */ class AnonymousClass43 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;

        static {
            int[] iArr = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr;
            try {
                iArr[EventID.FLIGHT_RECEIVE_GIMBAL_STATE_DATA.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_HARDWARE_STATE_UPLOAD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_NO_FLY_ZONE_DATA.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController, com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        super.onEvent(eventID, event);
        int i = AnonymousClass43.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()];
        if (i == 1) {
            FlightRevGimbalStateData gimbalStateData = FlightRevData.get().getGimbalStateData();
            if (!FlightRevData.get().getFlightRevStateData().isInit() || this.errorState == gimbalStateData.getError_status()) {
                return;
            }
            this.isGimbalError.set(gimbalStateData.isGimbalError());
            this.isGimbalNeedCalibration.set(gimbalStateData.isGimbalNeedCalibration());
            this.isGimbalStuck.set(gimbalStateData.isGimbalStuck());
            this.isGimbalOverload.set(gimbalStateData.isGimbalOverload());
            this.isGimbalAngleTooBig.set(gimbalStateData.isGimbalAngleTooBig());
            this.isGimbalTempTooHigh.set(gimbalStateData.isGimbalTempTooHigh());
            return;
        }
        if (i == 2) {
            HardwareStateUploadData hardwareStateUploadData = (HardwareStateUploadData) event.obj;
            this.isCMOSError.set(hardwareStateUploadData.isCMOSError());
            this.isCamOpticalFlowError.set(hardwareStateUploadData.isOpticalFlowAbnormal);
            return;
        }
        if (i == 3) {
            FlightRevNoFlyZone flightRevNoFlyZone = (FlightRevNoFlyZone) event.obj;
            this.isForbidTakeoff.set(flightRevNoFlyZone.getIsLocatedNoFlyZone());
            this.isNearLocatedNoFlyZone.set(flightRevNoFlyZone.getIsNearLocatedNoFlyZone());
            this.isRestrictedZone.setValue(Boolean.valueOf(flightRevNoFlyZone.getIsRestrictedZone()));
            this.isMaxRestrictedHeight.set(flightRevNoFlyZone.getIsRestrictedZone());
            this.isNearRestrictedZone.setValue(Boolean.valueOf(flightRevNoFlyZone.getIsNearRestrictedZone()));
            return;
        }
        if (i == 4 && !((Boolean) event.obj).booleanValue()) {
            this.errorState = -1;
            this.isGimbalError.set(false);
            this.isGimbalNeedCalibration.set(false);
            this.isGimbalStuck.set(false);
            this.isGimbalOverload.set(false);
            this.isGimbalAngleTooBig.set(false);
            this.isGimbalTempTooHigh.set(false);
            this.isMpuError.set(false);
            this.isGpsWeak.set(false);
            this.isPressureError.set(false);
            this.isGpsConnectError.set(false);
            this.isBatteryAbnormal.set(false);
            this.isBatteryCurrentAbnormal.set(false);
            this.isGimbalNotReady.set(false);
            this.isFlightInNoFlyZone.set(false);
            this.isImuPreparing.set(false);
            this.isGeomagneticFault.set(false);
            this.isNetWorkFault.set(false);
            this.isPlaneExceedLimitDistance.set(false);
            this.isPlaneExceedLimitHigh.set(false);
            this.isTofFault.set(false);
            this.isOpticalFlow.set(false);
            this.isOpticalFlowErrorInAtom.set(false);
            this.isBatteryHighPress.set(false);
            this.isPTZMotorAbnormal.set(false);
            this.isPTZGyroscopeFault.set(false);
            this.isAbnormalBatteryTemperature.set(false);
            this.isPTZFlashError.set(false);
            this.isOPTIAllowHighest.set(false);
            this.isPTZAttitudeAbnormal.set(false);
            this.isMotorFullPower.set(false);
            this.isMotorStuck.set(false);
            this.isMotorOverCurrent.set(false);
            this.isEscFault.set(false);
            this.isEscHighTemp.set(false);
            this.isEscCheckPaddledIntact.set(false);
            this.isCMOSError.set(false);
            this.isCamOpticalFlowError.set(false);
            this.isForbidTakeoff.set(false);
            this.isNearLocatedNoFlyZone.set(false);
            this.isRestrictedZone.setValue(false);
            this.isMaxRestrictedHeight.set(false);
            this.isNearRestrictedZone.setValue(false);
            this.isTakeoff.set(false);
            this.isLanding.set(false);
            this.isBatteryAbnormalToLimitSpeed.set(false);
        }
    }

    public void upgradeData(FlightRevStateData flightRevStateData) {
        this.isMpuError.set(flightRevStateData.isMpuError());
        this.isGpsWeak.set(FlightRevData.get().getFlightRevFlightInfoData().isGpsWeak() && flightRevStateData.isTooWeakGps());
        this.isPressureError.set(flightRevStateData.isPressureError());
        this.isGpsConnectError.set(flightRevStateData.isGpsConnectError());
        this.isBatteryAbnormal.set(flightRevStateData.isSmartBatteryAbnormal());
        this.isBatteryCurrentAbnormal.set(flightRevStateData.isBatterySettingAbnormal());
        this.isGimbalNotReady.set(flightRevStateData.isGimbalNotReady());
        this.isFlightInNoFlyZone.set(flightRevStateData.isFlightInNoFlyZone());
        this.isImuPreparing.set(flightRevStateData.isImuPreparing());
        this.isGeomagneticFault.set(flightRevStateData.isGeomagneticFault());
        this.isNetWorkFault.set(flightRevStateData.isNetWorkFault());
        FlightRevData.get().getFlightRevSettingData().isNewerModeOpen();
        this.isPlaneExceedLimitDistance.set(flightRevStateData.isPlaneExceedLimitDistance());
        this.isPlaneExceedLimitHigh.set(flightRevStateData.isPlaneExceedLimitHigh());
        this.isTofFault.set(flightRevStateData.isTofFault());
        this.isOpticalFlow.set(flightRevStateData.isOpticalFlow());
        this.isOpticalFlowErrorInAtom.set(flightRevStateData.isOpticalFlowErrorInAtom());
        this.isBatteryHighPress.set((!flightRevStateData.isBatteryHighPress() || flightRevStateData.isNewBattery() || FlightConfig.isP1ProBattery()) ? false : true);
        this.isPTZMotorAbnormal.set(flightRevStateData.isPTZMotorAbnormal());
        this.isPTZGyroscopeFault.set(flightRevStateData.isPTZGyroscopeFault());
        this.isPTZFlashError.set(flightRevStateData.isPTZFlashError());
        this.isAbnormalBatteryTemperature.set(flightRevStateData.isAbnormalBatteryTemperature());
        this.isOPTIAllowHighest.set(flightRevStateData.isOPTIAllowHighest());
        this.isPTZAttitudeAbnormal.set(flightRevStateData.isPTZAttitudeAbnormal());
        this.isTakeoff.set(flightRevStateData.isTakeOff());
        this.isLanding.set(flightRevStateData.isLanding());
        this.isBatteryAbnormalToLimitSpeed.set(flightRevStateData.isPowerLimit());
        showEscWarn(flightRevStateData);
        if (this.list.size() > 0 && this.btnWarn.getVisibility() != 0) {
            setVisibility(0);
        } else if (this.list.size() == 0 && this.btnWarn.getVisibility() == 0) {
            setVisibility(8);
        }
        WarnAdapter warnAdapter = this.warnAdapter;
        if (warnAdapter != null) {
            warnAdapter.notifyDataSetChanged();
        }
    }

    @Override // com.ipotensic.kernel.controllers.BaseController
    public void setVisibility(int i) {
        super.setVisibility(i);
        if (i == 0) {
            getBaseView().setVisibility(0);
            this.btnWarn.setVisibility(0);
            return;
        }
        this.list.clear();
        WarnAdapter warnAdapter = this.warnAdapter;
        if (warnAdapter != null) {
            warnAdapter.notifyDataSetChanged();
        }
        this.btnWarn.setVisibility(4);
        this.shadowLayout.setVisibility(4);
        getBaseView().setVisibility(8);
        this.recyclerView.setVisibility(8);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        if (view.getId() == R.id.btn_warn_view) {
            if (this.list.size() > 0) {
                this.recyclerView.setLayoutManager(new MyLinearLayoutManager(getContext(), 1, false));
                if (this.warnAdapter == null) {
                    this.warnAdapter = new WarnAdapter();
                }
                this.recyclerView.setAdapter(this.warnAdapter);
                this.recyclerView.setVisibility(0);
                this.shadowLayout.setVisibility(0);
                this.btnWarn.setVisibility(4);
                return;
            }
            return;
        }
        if (view.getId() == R.id.btn_warn_close) {
            this.btnWarn.setVisibility(0);
            this.recyclerView.setVisibility(8);
            this.shadowLayout.setVisibility(4);
        }
    }

    public class WarnAdapter extends RecyclerView.Adapter<VH> {
        public WarnAdapter() {
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new VH(LayoutInflater.from(WarnController.this.getContext()).inflate(R.layout.view_adapter_warn_item_body, viewGroup, false));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public void onBindViewHolder(VH vh, int i) {
            if (i >= WarnController.this.list.size()) {
                return;
            }
            vh.tvContent.setText(String.format("%d%s%s", Integer.valueOf(i + 1), ".", (String) WarnController.this.list.toArray()[i]));
        }

        @Override // androidx.recyclerview.widget.RecyclerView.Adapter
        public int getItemCount() {
            if (WarnController.this.list.size() == 0 && WarnController.this.shadowLayout.getVisibility() == 0) {
                WarnController.this.btnWarn.setVisibility(4);
                WarnController.this.shadowLayout.setVisibility(4);
                WarnController.this.getBaseView().setVisibility(8);
            }
            return WarnController.this.list.size();
        }

        class VH extends RecyclerView.ViewHolder {
            TextView tvContent;

            public VH(View view) {
                super(view);
                this.tvContent = (TextView) view.findViewById(R.id.tv_content);
            }
        }
    }

    public class MyLinearLayoutManager extends LinearLayoutManager {
        public MyLinearLayoutManager(Context context, int i, boolean z) {
            super(context, i, z);
        }

        @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onLayoutChildren(RecyclerView.Recycler recycler, RecyclerView.State state) {
            try {
                super.onLayoutChildren(recycler, state);
            } catch (IndexOutOfBoundsException e) {
                e.printStackTrace();
            }
        }

        @Override // androidx.recyclerview.widget.RecyclerView.LayoutManager
        public void onMeasure(RecyclerView.Recycler recycler, RecyclerView.State state, int i, int i2) {
            super.onMeasure(recycler, state, i, i2);
            if (WarnController.this.recyclerView.getChildCount() >= 6) {
                int i3 = 0;
                for (int i4 = 0; i4 < 6; i4++) {
                    View childAt = WarnController.this.recyclerView.getChildAt(i4);
                    if (childAt == null) {
                        break;
                    }
                    i3 += childAt.getHeight();
                }
                FrameLayout.LayoutParams layoutParams = (FrameLayout.LayoutParams) WarnController.this.recyclerView.getLayoutParams();
                layoutParams.height = i3;
                WarnController.this.recyclerView.setLayoutParams(layoutParams);
            }
        }
    }

    private void showEscWarn(FlightRevStateData flightRevStateData) {
        if (flightRevStateData == null || !CommonUtil.hasNewVersion("1.9.2", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion())) {
            return;
        }
        this.isMotorFullPower.set(flightRevStateData.isMotorFullPower());
        this.isMotorStuck.set(flightRevStateData.isMotorStuck());
        this.isMotorOverCurrent.set(flightRevStateData.isMotorOverCurrent());
        this.isEscFault.set(flightRevStateData.isEscFault());
        this.isEscHighTemp.set(flightRevStateData.isEscHighTemp());
        this.isEscCheckPaddledIntact.set(flightRevStateData.isEscCheckPaddledIntact());
    }
}