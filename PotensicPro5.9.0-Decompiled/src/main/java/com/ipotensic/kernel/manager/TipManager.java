package com.ipotensic.kernel.manager;

import android.media.MediaPlayer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.widget.LinearLayout;
import androidx.appcompat.app.AppCompatActivity;
import com.ipotensic.baselib.ActivityHelper;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.State;
import com.ipotensic.baselib.utils.SoundMediaPlayer;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.SoundTip;
import com.ipotensic.kernel.manager.TipManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.recv.FlightRevStateData;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;

/* loaded from: classes2.dex */
public class TipManager implements EventDispatcher.OnEventListener {
    private ErrorTipsManager errorTipsManager;
    private final HandlerThread handlerThread;
    private boolean isPlaneConnected;
    private final Handler mHandler;
    private final String TAG = getClass().getSimpleName();
    private final ConcurrentLinkedQueue<SoundTip> tipsQueue = new ConcurrentLinkedQueue<>();
    private FlightRevStateData data = new FlightRevStateData();
    private boolean isCameraTooHighTemp = false;
    private boolean isCameraStopWork = false;
    private State state = null;

    public TipManager(AppCompatActivity appCompatActivity, LinearLayout linearLayout) {
        this.isPlaneConnected = false;
        if (FlightConfig.isConnectFlight()) {
            this.isPlaneConnected = true;
            setState(State.STATE_USB_CONNECT_FLIGHT);
        } else if (FlightRevData.get().getFlightRevConnectData().isRemoterConnected()) {
            setState(State.STATE_USB_CONNECT_FLIGHT_FAIL);
        }
        EventDispatcher.get().registerEvent(appCompatActivity.getLifecycle(), this);
        this.errorTipsManager = new ErrorTipsManager(appCompatActivity, linearLayout);
        HandlerThread handlerThread = new HandlerThread("ThreadTips");
        this.handlerThread = handlerThread;
        handlerThread.start();
        this.mHandler = new AnonymousClass1(handlerThread.getLooper(), appCompatActivity);
    }

    /* renamed from: com.ipotensic.kernel.manager.TipManager$1, reason: invalid class name */
    class AnonymousClass1 extends Handler {
        final /* synthetic */ AppCompatActivity val$activity;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(Looper looper, AppCompatActivity appCompatActivity) {
            super(looper);
            this.val$activity = appCompatActivity;
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            SoundTip remove;
            if (TipManager.this.tipsQueue.isEmpty() || SoundMediaPlayer.get().isPlaying() || (remove = TipManager.this.remove()) == null) {
                return;
            }
            if (remove.getStrId() != -1 && !TipManager.this.errorTipsManager.isContain(remove.getStrId())) {
                TipManager.this.errorTipsManager.enqueue(remove.getStrId());
            }
            if (remove.getRawId() != -1) {
                if (!ActivityHelper.getInstance().isAppInForeground()) {
                    TipManager.this.mHandler.sendEmptyMessageDelayed(0, 400L);
                } else {
                    SoundMediaPlayer.get().play(this.val$activity, remove.getRawId(), new MediaPlayer.OnCompletionListener() { // from class: com.ipotensic.kernel.manager.-$$Lambda$TipManager$1$GRyg-CpVZ4Wf247KjXhqDbdcSnw
                        @Override // android.media.MediaPlayer.OnCompletionListener
                        public final void onCompletion(MediaPlayer mediaPlayer) {
                            TipManager.AnonymousClass1.this.lambda$handleMessage$0$TipManager$1(mediaPlayer);
                        }
                    });
                }
            }
        }

        public /* synthetic */ void lambda$handleMessage$0$TipManager$1(MediaPlayer mediaPlayer) {
            TipManager.this.mHandler.sendEmptyMessageDelayed(0, 400L);
        }
    }

    public void quit() {
        this.tipsQueue.clear();
        SoundMediaPlayer.get().stop();
        this.mHandler.removeCallbacksAndMessages(null);
        this.handlerThread.quitSafely();
        this.errorTipsManager.stop();
    }

    public void clear() {
        this.isCameraTooHighTemp = false;
        this.isCameraStopWork = false;
        SoundMediaPlayer.get().stop();
        this.errorTipsManager.stop();
    }

    public void addOnlyOnce(SoundTip soundTip) {
        DDLog.e(this.TAG, "音频 = " + soundTip.getRawId() + ", 提示 = " + soundTip.getStrId() + ", size = " + this.tipsQueue.size());
        if (isContain(soundTip.getRawId(), soundTip.getStrId())) {
            return;
        }
        this.tipsQueue.offer(soundTip);
    }

    public boolean isContain(int i, int i2) {
        Iterator<SoundTip> it = this.tipsQueue.iterator();
        while (it.hasNext()) {
            SoundTip next = it.next();
            if (next.getRawId() != -1 && next.getRawId() == i) {
                return true;
            }
            if (next.getStrId() != -1 && next.getStrId() == i2) {
                return true;
            }
        }
        return false;
    }

    public void stopAndRemove(SoundTip soundTip) {
        if (SoundMediaPlayer.get().getPlayingId() == soundTip.getRawId()) {
            SoundMediaPlayer.get().stop();
        }
        remove(soundTip.getRawId(), soundTip.getStrId());
    }

    public SoundTip remove(int i, int i2) {
        Iterator<SoundTip> it = this.tipsQueue.iterator();
        while (it.hasNext()) {
            SoundTip next = it.next();
            if (next.getRawId() != -1 && next.getRawId() == i) {
                this.tipsQueue.remove(next);
                return next;
            }
            if (next.getStrId() != -1 && next.getStrId() == i2) {
                this.tipsQueue.remove(next);
                return next;
            }
        }
        return null;
    }

    public SoundTip remove() {
        if (this.tipsQueue.isEmpty()) {
            return null;
        }
        Iterator<SoundTip> it = this.tipsQueue.iterator();
        while (it.hasNext()) {
            SoundTip next = it.next();
            if (next.isPlayFirst()) {
                this.tipsQueue.remove(next);
                return next;
            }
        }
        return this.tipsQueue.poll();
    }

    @Override // com.ipotensic.baselib.dispatcher.EventDispatcher.OnEventListener
    public void onEvent(EventID eventID, Event event) {
        switch (AnonymousClass2.$SwitchMap$com$ipotensic$baselib$dispatcher$EventID[eventID.ordinal()]) {
            case 1:
                addOnlyOnce(new SoundTip(R.raw.audio_attitude_mode, -1));
                break;
            case 2:
            case 3:
                stopAndRemove(new SoundTip(R.raw.audio_sd_pullout, -1));
                addOnlyOnce(new SoundTip(R.raw.audio_sd_insertion, -1));
                break;
            case 4:
            case 5:
                stopAndRemove(new SoundTip(R.raw.audio_sd_insertion, -1));
                addOnlyOnce(new SoundTip(R.raw.audio_sd_pullout, -1));
                break;
            case 6:
                addOnlyOnce(new SoundTip(R.raw.audio_sd_full, -1));
                break;
            case 7:
            case 8:
                addOnlyOnce(new SoundTip(R.raw.audio_sd_unknown_type, -1));
                break;
            case 9:
                DDLog.e("语音提示未检测到SD卡");
                addOnlyOnce(new SoundTip(R.raw.audio_no_sd_card, -1));
                break;
            case 10:
                int i = event.arg1;
                int i2 = event.arg2;
                if (i == 1) {
                    if (!this.isCameraTooHighTemp) {
                        this.isCameraTooHighTemp = true;
                        DDLog.e("相机二级高温");
                        addOnlyOnce(new SoundTip(R.raw.audio_camera_is_overheated, -1, true));
                        break;
                    }
                } else if (i == 2 && !this.isCameraStopWork) {
                    this.isCameraStopWork = true;
                    DDLog.e("相机三级高温");
                    addOnlyOnce(new SoundTip(R.raw.audio_camera_temperature_has_exceeded_the_limit, -1, true));
                    break;
                }
                break;
            case 11:
                addOnlyOnce(new SoundTip(R.raw.audio_returning_not_available, -1, false));
                break;
            case 12:
                if (!FlightConfig.isOldProduct()) {
                    DDLog.e("返航点已刷新 语音提示");
                    addOnlyOnce(new SoundTip(R.raw.return_point_has_been_refreshed, -1, false));
                    break;
                }
                break;
            case 13:
                FlightRevStateData flightRevStateData = (FlightRevStateData) event.obj;
                if (!UsbConfig.isUsbConnected) {
                    if (flightRevStateData.isRemoterConnected()) {
                        setState(State.STATE_WIFI_CONNECT_REMOTER);
                    } else {
                        setState(State.STATE_WIFI_CONNECT_REMOTER_FAIL);
                    }
                }
                if (flightRevStateData.isFlight() && flightRevStateData.isReturning() && !flightRevStateData.isReturnCountdown() && !flightRevStateData.isBatteryHighPress() && !flightRevStateData.isIs1BatteryDamaged() && !flightRevStateData.isBatteryJump() && this.data.isReturning() != flightRevStateData.isReturning()) {
                    addOnlyOnce(new SoundTip(R.raw.audio_drone_is_returning, -1, true));
                } else {
                    FlightRevStateData flightRevStateData2 = this.data;
                    if (flightRevStateData2 != null && flightRevStateData2.isReturning() != flightRevStateData.isReturning() && !flightRevStateData.isReturnCountdown()) {
                        stopAndRemove(new SoundTip(R.raw.audio_drone_is_returning, -1, true));
                    }
                }
                if (flightRevStateData.isFlight() && flightRevStateData.isReturnCountdown() && flightRevStateData.isReturnCountdown() != this.data.isReturnCountdown()) {
                    addOnlyOnce(new SoundTip(R.raw.audio_low_power_return_soon, -1, true));
                } else if (this.data.isReturnCountdown() != flightRevStateData.isReturnCountdown()) {
                    stopAndRemove(new SoundTip(R.raw.audio_low_power_return_soon, -1, true));
                }
                if (flightRevStateData.isPlaneExceedLimitHigh()) {
                    flightRevStateData.isPlaneExceedLimitHigh();
                    this.data.isPlaneExceedLimitHigh();
                }
                if (flightRevStateData.isNewBattery()) {
                    if (flightRevStateData.isIs1BatteryDamaged() && this.data.isIs1BatteryDamaged() != flightRevStateData.isIs1BatteryDamaged()) {
                        stopAndRemove(flightRevStateData.isFlight() ? new SoundTip(-1, R.string.error_battery_no_takeoff_fault) : new SoundTip(R.raw.audio_battery_pressure_too_large, R.string.error_battery_flight_fault, true));
                        addOnlyOnce(flightRevStateData.isFlight() ? new SoundTip(R.raw.audio_battery_pressure_too_large, R.string.error_battery_flight_fault, true) : new SoundTip(-1, R.string.error_battery_no_takeoff_fault));
                    } else if (this.data.isIs1BatteryDamaged() != flightRevStateData.isIs1BatteryDamaged()) {
                        stopAndRemove(new SoundTip(R.raw.audio_battery_pressure_too_large, R.string.error_battery_flight_fault, true));
                        stopAndRemove(new SoundTip(-1, R.string.error_battery_no_takeoff_fault));
                    }
                    if (flightRevStateData.isFlight() && flightRevStateData.isIs2BatteryDamaged() && flightRevStateData.isIs2BatteryDamaged() != this.data.isIs2BatteryDamaged()) {
                        addOnlyOnce(new SoundTip(R.raw.audio_battery_abnormal_emergency_landing, -1));
                    } else if (this.data.isIs2BatteryDamaged() != flightRevStateData.isIs2BatteryDamaged()) {
                        stopAndRemove(new SoundTip(R.raw.audio_battery_abnormal_emergency_landing, -1));
                    }
                    if (flightRevStateData.isFlight() && flightRevStateData.isBatteryJump() && flightRevStateData.isBatteryJump() != this.data.isBatteryJump()) {
                        addOnlyOnce(new SoundTip(R.raw.audio_battery_jumps_abnormally_trigger_return_home, -1, true));
                    } else if (this.data.isBatteryJump() != flightRevStateData.isBatteryJump()) {
                        stopAndRemove(new SoundTip(R.raw.audio_battery_jumps_abnormally_trigger_return_home, -1, true));
                    }
                    if (flightRevStateData.isFlight() && flightRevStateData.isBatteryDiffPressure() && flightRevStateData.isBatteryDiffPressure() != this.data.isBatteryDiffPressure()) {
                        addOnlyOnce(new SoundTip(R.raw.audio_battery_jumps_abnormally_trigger_return_home, -1, true));
                    } else if (this.data.isBatteryDiffPressure() != flightRevStateData.isBatteryDiffPressure()) {
                        stopAndRemove(new SoundTip(R.raw.audio_battery_jumps_abnormally_trigger_return_home, -1, true));
                    }
                }
                if (flightRevStateData.isGeoCalibrationFailureFlag() && flightRevStateData.isGeoCalibrationFailureFlag() != this.data.isGeoCalibrationFailureFlag()) {
                    addOnlyOnce(new SoundTip(-1, R.string.toast_geo_calibration_fail));
                }
                if (flightRevStateData.isTofInvalid() && flightRevStateData.isTofInvalid() != this.data.isTofInvalid()) {
                    addOnlyOnce(new SoundTip(-1, R.string.tof_invalid));
                }
                try {
                    this.data = flightRevStateData.m29clone();
                    break;
                } catch (CloneNotSupportedException e) {
                    e.printStackTrace();
                    break;
                }
                break;
            case 14:
                boolean booleanValue = ((Boolean) event.obj).booleanValue();
                DDLog.e(this.TAG, "connect state:" + booleanValue);
                if (booleanValue) {
                    if (this.data == null) {
                        this.data = new FlightRevStateData();
                    }
                    this.isPlaneConnected = true;
                    setState(State.STATE_USB_CONNECT_FLIGHT);
                    break;
                } else if (this.isPlaneConnected) {
                    this.isPlaneConnected = false;
                    this.data = new FlightRevStateData();
                    this.isCameraTooHighTemp = false;
                    this.isCameraStopWork = false;
                    setState(State.STATE_USB_CONNECT_FLIGHT_FAIL);
                    break;
                }
                break;
            case 17:
                setState(State.STATE_USB_CONNECT_REMOTER);
                break;
            case 18:
                setState(State.STATE_USB_CONNECT_REMOTER_FAIL);
                break;
            case 19:
                addOnlyOnce(new SoundTip(R.raw.audio_start_horizontal_calibration, -1, false));
                break;
            case 20:
                addOnlyOnce(new SoundTip(R.raw.audio_start_vertical_calibration, -1, false));
                break;
            case 21:
                addOnlyOnce(new SoundTip(R.raw.audio_calibration_success, -1, false));
                break;
            case 22:
                addOnlyOnce(new SoundTip(R.raw.audio_calibration_fail, -1, false));
                break;
        }
        HandlerThread handlerThread = this.handlerThread;
        if (handlerThread == null || !handlerThread.isAlive()) {
            return;
        }
        this.mHandler.sendEmptyMessageDelayed(0, 200L);
    }

    private void setState(State state) {
        DDLog.e(this.TAG, "连接状态state—-》 now " + this.state);
        if (state != this.state) {
            DDLog.e(this.TAG, "连接状态state—-》 before " + this.state);
            this.state = state;
            DDLog.e(this.TAG, "连接状态state—-》 after " + this.state);
            switch (AnonymousClass2.$SwitchMap$com$ipotensic$baselib$enums$State[this.state.ordinal()]) {
                case 1:
                    addOnlyOnce(new SoundTip(R.raw.audio_please_connect_the_drone, -1, true));
                    break;
                case 2:
                case 3:
                case 4:
                    stopAndRemove(new SoundTip(R.raw.audio_please_connect_the_drone, -1, true));
                    addOnlyOnce(new SoundTip(R.raw.audio_remote_control_not_connected, -1, true));
                    break;
                case 5:
                case 6:
                    stopAndRemove(new SoundTip(R.raw.audio_remote_control_not_connected, -1, true));
                    addOnlyOnce(new SoundTip(R.raw.audio_remote_control_connected, -1, true));
                    break;
                case 7:
                case 8:
                    stopAndRemove(new SoundTip(R.raw.audio_remote_control_not_connected, -1, true));
                    addOnlyOnce(new SoundTip(R.raw.audio_plane_connecting, -1, true));
                    break;
            }
        }
    }

    /* renamed from: com.ipotensic.kernel.manager.TipManager$2, reason: invalid class name */
    static /* synthetic */ class AnonymousClass2 {
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$dispatcher$EventID;
        static final /* synthetic */ int[] $SwitchMap$com$ipotensic$baselib$enums$State;

        static {
            int[] iArr = new int[State.values().length];
            $SwitchMap$com$ipotensic$baselib$enums$State = iArr;
            try {
                iArr[State.STATE_USB_CONNECT_FLIGHT_FAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_WIFI_CONNECT_REMOTER_FAIL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_NO_CONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_CONNECT_REMOTER_FAIL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_FLIGHT_BOOTLOADER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_CONNECT_REMOTER.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_WIFI_CONNECT_REMOTER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$enums$State[State.STATE_USB_CONNECT_FLIGHT.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            int[] iArr2 = new int[EventID.values().length];
            $SwitchMap$com$ipotensic$baselib$dispatcher$EventID = iArr2;
            try {
                iArr2[EventID.FLIGHT_SWITCH_ATTITUDE_MODE.ordinal()] = 1;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_INSERT_TIP.ordinal()] = 2;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_INSERT.ordinal()] = 3;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_PULL_OUT_TIP.ordinal()] = 4;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_PULL_OUT.ordinal()] = 5;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_FULL_TIP.ordinal()] = 6;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_NEED_FORMAT_SD_CARD_TIP.ordinal()] = 7;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_SD_CARD_NOT_DIST_TIP.ordinal()] = 8;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_NO_SD_CARD_TIP.ordinal()] = 9;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_CAMERA_HIGH_TEMP.ordinal()] = 10;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.AUDIO_RETURNING_NOT_AVAILABLE.ordinal()] = 11;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_AUDIO_HOME_REFRESH.ordinal()] = 12;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_STATE_DATA.ordinal()] = 13;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_CONNECT_STATE_CHANGED.ordinal()] = 14;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_REMOTER_INFO.ordinal()] = 15;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.FLIGHT_RECEIVE_USB_CONNECT_STATE.ordinal()] = 16;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_AOA_CONNECTED.ordinal()] = 17;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.EVENT_AOA_DISCONNECT.ordinal()] = 18;
            } catch (NoSuchFieldError unused26) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.AUDIO_START_HORIZONTAL_CALIBRATION.ordinal()] = 19;
            } catch (NoSuchFieldError unused27) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.AUDIO_START_VERTICAL_CALIBRATION.ordinal()] = 20;
            } catch (NoSuchFieldError unused28) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.AUDIO_CALIBRATION_SUCCESS.ordinal()] = 21;
            } catch (NoSuchFieldError unused29) {
            }
            try {
                $SwitchMap$com$ipotensic$baselib$dispatcher$EventID[EventID.AUDIO_CALIBRATION_FAIL.ordinal()] = 22;
            } catch (NoSuchFieldError unused30) {
            }
        }
    }
}
