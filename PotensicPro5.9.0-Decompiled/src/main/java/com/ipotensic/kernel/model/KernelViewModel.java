package com.ipotensic.kernel.model;

import android.content.Context;
import android.os.CountDownTimer;
import android.widget.Button;
import androidx.databinding.ObservableBoolean;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.dialog.GeneralDialog;
import com.logan.camera.data.PhotoChildMode;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevConnectData;
import com.logan.flight.data.recv.FlightRevFlightInfoData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.data.send.SendFlightSetData;
import com.logan.flight.enums.CommonMsgType;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: KernelViewModel.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 l2\u00020\u0001:\u0001lB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010N\u001a\u00020\u0015H\u0002J\b\u0010O\u001a\u00020\u0015H\u0002J\b\u0010P\u001a\u00020\u0015H\u0002J\u0006\u0010Q\u001a\u00020\u0015J\b\u0010R\u001a\u00020SH\u0002J\u0016\u0010T\u001a\u00020S2\u0006\u0010U\u001a\u00020V2\u0006\u0010W\u001a\u00020XJ\u0006\u0010Y\u001a\u00020SJ\u0006\u0010Z\u001a\u00020\u0015J\u0006\u0010[\u001a\u00020\u0015J\u000e\u0010\\\u001a\u00020S2\u0006\u0010]\u001a\u00020\nJ\u0006\u0010^\u001a\u00020\u0015J\u0006\u0010_\u001a\u00020\u0015J\u0006\u0010`\u001a\u00020SJ\u0006\u0010a\u001a\u00020SJ\u000e\u0010b\u001a\u00020S2\u0006\u0010U\u001a\u00020VJ\u0018\u0010c\u001a\u00020S2\u0006\u0010U\u001a\u00020V2\u0006\u0010d\u001a\u00020?H\u0002J\b\u0010e\u001a\u00020SH\u0002J\b\u0010f\u001a\u00020SH\u0002J\u0006\u0010g\u001a\u00020SJ\u0006\u0010h\u001a\u00020SJ\u000e\u0010i\u001a\u00020S2\u0006\u0010j\u001a\u00020kR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR \u0010\r\u001a\b\u0012\u0004\u0012\u00020\n0\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\f\"\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0007R&\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u00150\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0017\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0007R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\fR\u0017\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\fR\u001a\u0010 \u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u0011\u0010%\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b%\u0010'R\u0017\u0010(\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b(\u0010\fR\u0017\u0010)\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b)\u0010\fR\u0011\u0010*\u001a\u00020&¢\u0006\b\n\u0000\u001a\u0004\b*\u0010'R\u001f\u0010+\u001a\u0010\u0012\f\u0012\n ,*\u0004\u0018\u00010\u00150\u00150\t¢\u0006\b\n\u0000\u001a\u0004\b-\u0010\fR\u0017\u0010.\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b/\u0010\fR\u0017\u00100\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\fR\u0017\u00102\u001a\b\u0012\u0004\u0012\u0002030\t¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\fR\u0017\u00105\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\b6\u0010\fR\u0017\u00107\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b8\u0010\u0007R\u0010\u00109\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010;\u001a\u0004\u0018\u00010:X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010<\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0007R\u000e\u0010>\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020?X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010A\u001a\b\u0012\u0004\u0012\u00020\n0\t¢\u0006\b\n\u0000\u001a\u0004\bB\u0010\fR\u0014\u0010C\u001a\b\u0012\u0004\u0012\u00020\u00150\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010D\u001a\u0004\u0018\u00010EX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010F\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010H\u001a\u0004\u0018\u00010GX\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010I\u001a\b\u0012\u0004\u0012\u00020J0\t¢\u0006\b\n\u0000\u001a\u0004\bK\u0010\fR\u0017\u0010L\u001a\b\u0012\u0004\u0012\u00020J0\t¢\u0006\b\n\u0000\u001a\u0004\bM\u0010\f¨\u0006m"}, d2 = {"Lcom/ipotensic/kernel/model/KernelViewModel;", "Landroidx/lifecycle/ViewModel;", "()V", "closeSetting", "Lcom/ipotensic/kernel/model/SingleLiveData;", "Ljava/lang/Void;", "getCloseSetting", "()Lcom/ipotensic/kernel/model/SingleLiveData;", "compassCalibrate", "Landroidx/lifecycle/MutableLiveData;", "", "getCompassCalibrate", "()Landroidx/lifecycle/MutableLiveData;", "findingDrone", "getFindingDrone", "setFindingDrone", "(Landroidx/lifecycle/MutableLiveData;)V", "formatSdcard", "getFormatSdcard", "fpvSignal", "Lkotlin/Pair;", "", "getFpvSignal", "()Lkotlin/Pair;", "setFpvSignal", "(Lkotlin/Pair;)V", "getBigPackageVersion", "getGetBigPackageVersion", "gimbalAdjustment", "getGimbalAdjustment", "gimbalCalibrate", "getGimbalCalibrate", "heightTag", "getHeightTag", "()I", "setHeightTag", "(I)V", "isFlightUnlock", "Landroidx/databinding/ObservableBoolean;", "()Landroidx/databinding/ObservableBoolean;", "isRemoterConnected", "isReturnOrLanding", "isShowBatterySafetyDialog", "maxHeight", "kotlin.jvm.PlatformType", "getMaxHeight", "over120Data", "getOver120Data", "pairDrone", "getPairDrone", "photoChildModeData", "Lcom/logan/camera/data/PhotoChildMode;", "getPhotoChildModeData", "remoterCalibrate", "getRemoterCalibrate", "sdcardPullOut", "getSdcardPullOut", "sendEnterSwoopReturnTimer", "Lcom/ipotensic/baselib/utils/CancelRunnable;", "sendExitSwoopReturnTimer", "setRecordSizeSuccess", "getSetRecordSizeSuccess", "startExitSwoopReturnTime", "", "startSendSwoopReturnTime", "stickMode", "getStickMode", "swoopReturnCountTime", "swoopReturnCountTimer", "Landroid/os/CountDownTimer;", "swoopReturnDialog", "Lcom/ipotensic/kernel/view/dialog/GeneralDialog;", "unLockDialog", "updateFlightSN", "", "getUpdateFlightSN", "updateRemoteSN", "getUpdateRemoteSN", "checkAutoFlying", "checkFlightIsReady", "checkRemoterIsReady", "compassCalibration", "enterSwoopReturn", "", "executeSwoopReturn", "context", "Landroid/content/Context;", "flightRevStateData", "Lcom/logan/flight/data/recv/FlightRevStateData;", "exitSwoopReturn", "gimbalCalibration", "gimbalFineTuning", "onConnect", "isConnect", "pairDroneAgain", "remoteCalibration", "sendSettings", "setSingleMode", "showUnlockDialog", "startSwoopReturnCountTimer", RtspHeaders.Values.TIME, "stopSendEnterSwoopData", "stopSendExitSwoopData", "stopSwoopReturnCountTimer", "update120Data", "updateFpvSignal", "fpvState", "Lcom/logan/flight/data/recv/FlightRevConnectData;", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class KernelViewModel extends ViewModel {
    public static final int NO_ID = -1;
    private int heightTag;
    private CancelRunnable sendEnterSwoopReturnTimer;
    private CancelRunnable sendExitSwoopReturnTimer;
    private long startExitSwoopReturnTime;
    private long startSendSwoopReturnTime;
    private CountDownTimer swoopReturnCountTimer;
    private GeneralDialog swoopReturnDialog;
    private GeneralDialog unLockDialog;
    private final SingleLiveData<Void> closeSetting = new SingleLiveData<>();
    private final MutableLiveData<Boolean> compassCalibrate = new MutableLiveData<>();
    private final MutableLiveData<Boolean> gimbalCalibrate = new MutableLiveData<>();
    private final MutableLiveData<Boolean> gimbalAdjustment = new MutableLiveData<>();
    private final MutableLiveData<Boolean> remoterCalibrate = new MutableLiveData<>();
    private final MutableLiveData<Boolean> pairDrone = new MutableLiveData<>();
    private final MutableLiveData<Boolean> stickMode = new MutableLiveData<>();
    private final SingleLiveData<Void> formatSdcard = new SingleLiveData<>();
    private final SingleLiveData<Void> sdcardPullOut = new SingleLiveData<>();
    private final MutableLiveData<Boolean> isReturnOrLanding = new MutableLiveData<>();
    private final ObservableBoolean isShowBatterySafetyDialog = new ObservableBoolean(false);
    private final ObservableBoolean isFlightUnlock = new ObservableBoolean(true);
    private final MutableLiveData<Boolean> over120Data = new MutableLiveData<>();
    private MutableLiveData<Integer> swoopReturnCountTime = new MutableLiveData<>();
    private final MutableLiveData<PhotoChildMode> photoChildModeData = new MutableLiveData<>();
    private MutableLiveData<Boolean> findingDrone = new MutableLiveData<>(false);
    private final SingleLiveData<Void> setRecordSizeSuccess = new SingleLiveData<>();
    private final MutableLiveData<Boolean> isRemoterConnected = new MutableLiveData<>(false);
    private final MutableLiveData<String> updateFlightSN = new MutableLiveData<>();
    private final MutableLiveData<String> updateRemoteSN = new MutableLiveData<>();
    private final SingleLiveData<Void> getBigPackageVersion = new SingleLiveData<>();
    private Pair<Integer, Integer> fpvSignal = new Pair<>(0, 0);
    private final MutableLiveData<Integer> maxHeight = new MutableLiveData<>(Integer.valueOf(FlightConfig.getMaxHeight()));

    public final SingleLiveData<Void> getCloseSetting() {
        return this.closeSetting;
    }

    public final MutableLiveData<Boolean> getCompassCalibrate() {
        return this.compassCalibrate;
    }

    public final MutableLiveData<Boolean> getGimbalCalibrate() {
        return this.gimbalCalibrate;
    }

    public final MutableLiveData<Boolean> getGimbalAdjustment() {
        return this.gimbalAdjustment;
    }

    public final MutableLiveData<Boolean> getRemoterCalibrate() {
        return this.remoterCalibrate;
    }

    public final MutableLiveData<Boolean> getPairDrone() {
        return this.pairDrone;
    }

    public final MutableLiveData<Boolean> getStickMode() {
        return this.stickMode;
    }

    public final SingleLiveData<Void> getFormatSdcard() {
        return this.formatSdcard;
    }

    public final SingleLiveData<Void> getSdcardPullOut() {
        return this.sdcardPullOut;
    }

    public final MutableLiveData<Boolean> isReturnOrLanding() {
        return this.isReturnOrLanding;
    }

    /* renamed from: isShowBatterySafetyDialog, reason: from getter */
    public final ObservableBoolean getIsShowBatterySafetyDialog() {
        return this.isShowBatterySafetyDialog;
    }

    /* renamed from: isFlightUnlock, reason: from getter */
    public final ObservableBoolean getIsFlightUnlock() {
        return this.isFlightUnlock;
    }

    public final MutableLiveData<Boolean> getOver120Data() {
        return this.over120Data;
    }

    public final int getHeightTag() {
        return this.heightTag;
    }

    public final void setHeightTag(int i) {
        this.heightTag = i;
    }

    public final MutableLiveData<PhotoChildMode> getPhotoChildModeData() {
        return this.photoChildModeData;
    }

    public final MutableLiveData<Boolean> getFindingDrone() {
        return this.findingDrone;
    }

    public final void setFindingDrone(MutableLiveData<Boolean> mutableLiveData) {
        Intrinsics.checkParameterIsNotNull(mutableLiveData, "<set-?>");
        this.findingDrone = mutableLiveData;
    }

    public final SingleLiveData<Void> getSetRecordSizeSuccess() {
        return this.setRecordSizeSuccess;
    }

    public final MutableLiveData<Boolean> isRemoterConnected() {
        return this.isRemoterConnected;
    }

    public final MutableLiveData<String> getUpdateFlightSN() {
        return this.updateFlightSN;
    }

    public final MutableLiveData<String> getUpdateRemoteSN() {
        return this.updateRemoteSN;
    }

    public final SingleLiveData<Void> getGetBigPackageVersion() {
        return this.getBigPackageVersion;
    }

    public final Pair<Integer, Integer> getFpvSignal() {
        return this.fpvSignal;
    }

    public final void setFpvSignal(Pair<Integer, Integer> pair) {
        Intrinsics.checkParameterIsNotNull(pair, "<set-?>");
        this.fpvSignal = pair;
    }

    public final MutableLiveData<Integer> getMaxHeight() {
        return this.maxHeight;
    }

    public final void setSingleMode() {
        PhotoChildMode value = this.photoChildModeData.getValue();
        if (value != null) {
            value.intervalTime = 0;
        }
        PhotoChildMode value2 = this.photoChildModeData.getValue();
        if (value2 != null) {
            value2.childMode = 0;
        }
    }

    public final void updateFpvSignal(FlightRevConnectData fpvState) {
        Intrinsics.checkParameterIsNotNull(fpvState, "fpvState");
        this.fpvSignal = new Pair<>(Integer.valueOf(fpvState.getRssiRange()), this.fpvSignal.getFirst());
    }

    public final int compassCalibration() {
        DDLog.e("指南针校准");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkFlightIsReady = checkFlightIsReady();
        if (checkFlightIsReady != -1) {
            return checkFlightIsReady;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData stateData = flightRevData.getFlightRevStateData();
        if (FlightConfig.is_Atom_Series()) {
            Intrinsics.checkExpressionValueIsNotNull(stateData, "stateData");
            if (!stateData.isOutdoor()) {
                return R.string.settings_calibration_compass_calibration_failed_tips_outside_calibrate;
            }
            if (stateData.isGeomagneticFault()) {
                return R.string.error_geo_fault;
            }
            return (stateData.isUnLock() || stateData.isFlight()) ? R.string.txt_error_flighting_unavailable : checkFlightIsReady;
        }
        DDLog.e("不是atom系列");
        return checkFlightIsReady;
    }

    public final int gimbalCalibration() {
        DDLog.e("云台校准");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkFlightIsReady = checkFlightIsReady();
        if (checkFlightIsReady != -1) {
            return checkFlightIsReady;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevGimbalStateData gimbalStateData = flightRevData.getGimbalStateData();
        Intrinsics.checkExpressionValueIsNotNull(gimbalStateData, "FlightRevData.get().gimbalStateData");
        short error_status = gimbalStateData.getError_status();
        if (error_status == 1 || error_status == 2) {
            return R.string.txt_error_gimbal_error;
        }
        if (error_status == 3) {
            FlightRevData flightRevData2 = FlightRevData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
            FlightRevStateData flightRevStateData = flightRevData2.getFlightRevStateData();
            Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
            if (flightRevStateData.isUnLock()) {
                return R.string.txt_error_flighting_unavailable;
            }
        } else {
            if (error_status == 4) {
                return R.string.warning_the_gimbal_is_stuck_briefly_tips;
            }
            if (error_status == 5) {
                return R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips;
            }
        }
        FlightRevData flightRevData3 = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData3, "FlightRevData.get()");
        FlightRevStateData flightRevStateData2 = flightRevData3.getFlightRevStateData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData2, "FlightRevData.get().flightRevStateData");
        return flightRevStateData2.isUnLock() ? R.string.txt_error_flighting_unavailable : checkFlightIsReady;
    }

    public final int gimbalFineTuning() {
        DDLog.e("云台微调校准");
        if (!FlightConfig.isConnectFlight()) {
            return R.string.toast_unconnected_tips;
        }
        if (Conditions.isTrackTargetOpen()) {
            return R.string.txt_pls_exit_short_video_first;
        }
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevGimbalStateData gimbalStateData = flightRevData.getGimbalStateData();
        Intrinsics.checkExpressionValueIsNotNull(gimbalStateData, "FlightRevData.get().gimbalStateData");
        switch (gimbalStateData.getError_status()) {
            case 1:
            case 2:
                return R.string.txt_error_gimbal_error;
            case 3:
                return R.string.txt_error_gimbal_need_calibration;
            case 4:
                return R.string.warning_the_gimbal_is_stuck_briefly_tips;
            case 5:
                return R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips;
            case 6:
                return R.string.txt_error_gimbal_angle_too_big;
            default:
                return -1;
        }
    }

    public final int remoteCalibration() {
        DDLog.e("遥控器校准");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkRemoterIsReady = checkRemoterIsReady();
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
        return flightRevStateData.isFlight() ? R.string.txt_error_flighting_unavailable : checkRemoterIsReady;
    }

    public final int pairDroneAgain() {
        DDLog.e("对频校准");
        int checkAutoFlying = checkAutoFlying();
        if (checkAutoFlying != -1) {
            return checkAutoFlying;
        }
        int checkRemoterIsReady = checkRemoterIsReady();
        return (checkRemoterIsReady == -1 && FlightConfig.isConnectFlight()) ? R.string.plane_connecting : checkRemoterIsReady;
    }

    private final int checkRemoterIsReady() {
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevConnectData flightRevConnectData = flightRevData.getFlightRevConnectData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevConnectData, "FlightRevData.get().flightRevConnectData");
        if (!flightRevConnectData.isRemoterConnected()) {
            return R.string.txt_pls_connect_remoter;
        }
        if (Conditions.isFlying() && Conditions.isRecording()) {
            return R.string.txt_error_flighting_unavailable;
        }
        return -1;
    }

    private final int checkAutoFlying() {
        if (Conditions.isFlying() || Conditions.isInShortVideo() || Conditions.isPointFly() || Conditions.isTakingOff() || Conditions.isReturning() || Conditions.isLanding()) {
            return R.string.txt_error_flighting_unavailable;
        }
        return -1;
    }

    private final int checkFlightIsReady() {
        if (!FlightConfig.isConnectFlight()) {
            return R.string.toast_unconnected_tips;
        }
        if (Conditions.isFlying() && Conditions.isRecording()) {
            return R.string.txt_error_flighting_unavailable;
        }
        return -1;
    }

    public final void update120Data() {
        FlightRevData flightRevData = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
        FlightRevSettingData settingData = flightRevData.getFlightRevSettingData();
        Intrinsics.checkExpressionValueIsNotNull(settingData, "settingData");
        int limitHeight = settingData.getLimitHeight();
        FlightRevData flightRevData2 = FlightRevData.get();
        Intrinsics.checkExpressionValueIsNotNull(flightRevData2, "FlightRevData.get()");
        FlightRevFlightInfoData flightRevFlightInfoData = flightRevData2.getFlightRevFlightInfoData();
        Intrinsics.checkExpressionValueIsNotNull(flightRevFlightInfoData, "FlightRevData.get().flightRevFlightInfoData");
        double verticalDistance = flightRevFlightInfoData.getVerticalDistance();
        SPHelper sPHelper = SPHelper.getInstance();
        Intrinsics.checkExpressionValueIsNotNull(sPHelper, "SPHelper.getInstance()");
        int i = Intrinsics.areEqual("JP", sPHelper.getCountryCode()) ? 150 : 120;
        if (verticalDistance > i && limitHeight > i) {
            if (this.heightTag < i) {
                this.heightTag = i;
                this.over120Data.setValue(true);
                return;
            }
            return;
        }
        if (verticalDistance > i - 3 || this.heightTag == 0) {
            return;
        }
        this.heightTag = 0;
        this.over120Data.setValue(false);
    }

    public final void executeSwoopReturn(Context context, FlightRevStateData flightRevStateData) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(flightRevStateData, "flightRevStateData");
        if (!Intrinsics.areEqual((Object) this.isReturnOrLanding.getValue(), (Object) true)) {
            return;
        }
        if (flightRevStateData.getSwoopReturnCountDown() > 0) {
            if (this.swoopReturnDialog != null) {
                return;
            }
            final KernelViewModel kernelViewModel = this;
            DDLog.e("俯冲返航swoopReturnDialog show");
            kernelViewModel.startSwoopReturnCountTimer(context, flightRevStateData.getSwoopReturnCountDown());
            GeneralDialog generalDialog = new GeneralDialog(context, context.getString(R.string.enter_descending_return_title), context.getString(R.string.descending_return_tips), context.getString(R.string.dialog_confirm) + "(" + kernelViewModel.swoopReturnCountTime.getValue() + "s)", new GeneralDialog.DialogListener() { // from class: com.ipotensic.kernel.model.KernelViewModel$executeSwoopReturn$1$1
                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void cancel() {
                    DDLog.e("俯冲返航swoopReturnDialog onCancel");
                    if (!FlightConfig.isConnectFlight()) {
                        KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
                    } else {
                        KernelViewModel.this.exitSwoopReturn();
                    }
                    KernelViewModel.this.stopSwoopReturnCountTimer();
                }

                @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.DialogListener
                public void confirm() {
                    DDLog.e("俯冲返航swoopReturnDialog onConfirm");
                    if (FlightConfig.isConnectFlight()) {
                        KernelViewModel.this.enterSwoopReturn();
                    } else {
                        KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
                    }
                    KernelViewModel.this.stopSwoopReturnCountTimer();
                }
            });
            kernelViewModel.swoopReturnDialog = generalDialog;
            if (generalDialog != null) {
                generalDialog.show();
                Unit unit = Unit.INSTANCE;
                return;
            }
            return;
        }
        GeneralDialog generalDialog2 = this.swoopReturnDialog;
        if (generalDialog2 != null) {
            if (generalDialog2.isShowing()) {
                enterSwoopReturn();
                generalDialog2.dismiss();
            }
            this.swoopReturnDialog = (GeneralDialog) null;
        }
    }

    private final void startSwoopReturnCountTimer(final Context context, final long time) {
        if (this.swoopReturnCountTimer != null) {
            return;
        }
        final KernelViewModel kernelViewModel = this;
        DDLog.e("俯冲返航startSwoopReturnCountTime " + time);
        final long j = time * 1000;
        final long j2 = 1000;
        CountDownTimer countDownTimer = new CountDownTimer(j, j2) { // from class: com.ipotensic.kernel.model.KernelViewModel$startSwoopReturnCountTimer$$inlined$run$lambda$1
            @Override // android.os.CountDownTimer
            public void onTick(long j3) {
                MutableLiveData mutableLiveData;
                GeneralDialog generalDialog;
                Button button;
                MutableLiveData mutableLiveData2;
                mutableLiveData = KernelViewModel.this.swoopReturnCountTime;
                mutableLiveData.setValue(Integer.valueOf((int) (j3 / 1000)));
                generalDialog = KernelViewModel.this.swoopReturnDialog;
                if (generalDialog == null || (button = generalDialog.confirmBtn) == null) {
                    return;
                }
                StringBuilder append = new StringBuilder().append(context.getString(R.string.dialog_confirm)).append("(");
                mutableLiveData2 = KernelViewModel.this.swoopReturnCountTime;
                button.setText(append.append((Integer) mutableLiveData2.getValue()).append("s)").toString());
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                MutableLiveData mutableLiveData;
                GeneralDialog generalDialog;
                GeneralDialog generalDialog2;
                Button button;
                MutableLiveData mutableLiveData2;
                DDLog.e("俯冲返航startSwoopReturnCountTimer onFinish");
                mutableLiveData = KernelViewModel.this.swoopReturnCountTime;
                mutableLiveData.setValue(0);
                generalDialog = KernelViewModel.this.swoopReturnDialog;
                if (generalDialog != null && (button = generalDialog.confirmBtn) != null) {
                    StringBuilder append = new StringBuilder().append(context.getString(R.string.dialog_confirm)).append("(");
                    mutableLiveData2 = KernelViewModel.this.swoopReturnCountTime;
                    button.setText(append.append((Integer) mutableLiveData2.getValue()).append("s)").toString());
                }
                if (!FlightConfig.isConnectFlight()) {
                    generalDialog2 = KernelViewModel.this.swoopReturnDialog;
                    if (generalDialog2 != null) {
                        generalDialog2.dismiss();
                    }
                    KernelViewModel.this.swoopReturnDialog = (GeneralDialog) null;
                }
                KernelViewModel.this.swoopReturnCountTimer = (CountDownTimer) null;
            }
        };
        kernelViewModel.swoopReturnCountTimer = countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.start();
        }
    }

    public final void stopSwoopReturnCountTimer() {
        CountDownTimer countDownTimer = this.swoopReturnCountTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
            this.swoopReturnCountTimer = (CountDownTimer) null;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void enterSwoopReturn() {
        if (this.sendEnterSwoopReturnTimer != null) {
            return;
        }
        final KernelViewModel kernelViewModel = this;
        kernelViewModel.startSendSwoopReturnTime = System.currentTimeMillis();
        CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$enterSwoopReturn$1$1
            @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
            public void run() {
                FlightRevData flightRevData = FlightRevData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightRevData, "FlightRevData.get()");
                FlightRevStateData flightRevStateData = flightRevData.getFlightRevStateData();
                Intrinsics.checkExpressionValueIsNotNull(flightRevStateData, "FlightRevData.get().flightRevStateData");
                if (flightRevStateData.isSwoopReturn()) {
                    KernelViewModel.this.stopSendEnterSwoopData();
                    return;
                }
                FlightSendData flightSendData = FlightSendData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                flightSendData.getSendGeneralData().setDataType(CommonMsgType.ENTER_SWOOP_RETURN);
                DataManager.getInstance().sendGeneralData();
            }
        };
        kernelViewModel.sendEnterSwoopReturnTimer = cancelRunnable;
        if (cancelRunnable != null) {
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(kernelViewModel.sendEnterSwoopReturnTimer, 0L, 40L, TimeUnit.MILLISECONDS));
        }
        PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$enterSwoopReturn$1$2
            @Override // java.lang.Runnable
            public final void run() {
                KernelViewModel.this.stopSendEnterSwoopData();
            }
        }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS);
        DDLog.e("俯冲返航 startSendEnterSwoopData");
        Unit unit = Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSendEnterSwoopData() {
        ScheduledFuture future;
        DDLog.e("俯冲返航 stopSendEnterSwoopData");
        CancelRunnable cancelRunnable = this.sendEnterSwoopReturnTimer;
        if (cancelRunnable == null || (future = cancelRunnable.getFuture()) == null) {
            return;
        }
        future.cancel(true);
        this.sendEnterSwoopReturnTimer = (CancelRunnable) null;
    }

    public final void exitSwoopReturn() {
        DDLog.e("退出俯冲返航startSendExitSwoopData");
        if (this.sendExitSwoopReturnTimer != null) {
            return;
        }
        final KernelViewModel kernelViewModel = this;
        kernelViewModel.startExitSwoopReturnTime = System.currentTimeMillis();
        CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$exitSwoopReturn$1$1
            @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
            public void run() {
                FlightSendData flightSendData = FlightSendData.get();
                Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
                flightSendData.getSendGeneralData().setDataType(CommonMsgType.EXIT_SWOOP_RETURN);
                DataManager.getInstance().sendGeneralData();
            }
        };
        kernelViewModel.sendExitSwoopReturnTimer = cancelRunnable;
        if (cancelRunnable != null) {
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(kernelViewModel.sendExitSwoopReturnTimer, 0L, 40L, TimeUnit.MILLISECONDS));
        }
        Boolean.valueOf(PhoneConfig.mainHandler.postDelayed(new Runnable() { // from class: com.ipotensic.kernel.model.KernelViewModel$exitSwoopReturn$1$2
            @Override // java.lang.Runnable
            public final void run() {
                KernelViewModel.this.stopSendExitSwoopData();
            }
        }, SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void stopSendExitSwoopData() {
        ScheduledFuture future;
        DDLog.e("俯冲返航stopSendExitSwoopData");
        CancelRunnable cancelRunnable = this.sendExitSwoopReturnTimer;
        if (cancelRunnable == null || (future = cancelRunnable.getFuture()) == null) {
            return;
        }
        future.cancel(true);
        this.swoopReturnDialog = (GeneralDialog) null;
        this.sendExitSwoopReturnTimer = (CancelRunnable) null;
    }

    public final void showUnlockDialog(Context context) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        if (FlightConfig.isConnectFlight()) {
            if (this.unLockDialog == null) {
                this.unLockDialog = new GeneralDialog(context, true, context.getString(R.string.find_my_drone_fail_to_unlock_title), context.getString(R.string.find_my_drone_fail_to_unlock_tips), context.getString(R.string.i_get_it), (GeneralDialog.ClickConfirmListener) new GeneralDialog.ClickConfirmListener() { // from class: com.ipotensic.kernel.model.KernelViewModel$showUnlockDialog$1
                    @Override // com.ipotensic.kernel.view.dialog.GeneralDialog.ClickConfirmListener
                    public final void confirm() {
                    }
                });
            }
            GeneralDialog generalDialog = this.unLockDialog;
            if (generalDialog != null) {
                generalDialog.show();
            }
        }
    }

    public final void onConnect(boolean isConnect) {
        GeneralDialog generalDialog;
        if (isConnect || (generalDialog = this.unLockDialog) == null || !generalDialog.isShowing()) {
            return;
        }
        generalDialog.dismiss();
        this.unLockDialog = (GeneralDialog) null;
    }

    public final void sendSettings() {
        if (FlightConfig.isConnectFlight()) {
            FlightSendData flightSendData = FlightSendData.get();
            Intrinsics.checkExpressionValueIsNotNull(flightSendData, "FlightSendData.get()");
            SendFlightSetData sendFlightSetData = flightSendData.getSendFlightSetData();
            Intrinsics.checkExpressionValueIsNotNull(sendFlightSetData, "FlightSendData.get().sendFlightSetData");
            if (sendFlightSetData.isSettingChanged()) {
                DataManager.getInstance().startSendSetting();
            }
        }
    }
}
