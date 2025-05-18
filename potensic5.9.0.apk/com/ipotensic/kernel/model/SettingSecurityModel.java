package com.ipotensic.kernel.model;

import android.view.View;
import android.widget.SeekBar;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.listener.SimpleResultListener;
import com.ipotensic.baselib.livedata.DataChangedLiveData;
import com.ipotensic.baselib.livedata.SingleLiveData;
import com.ipotensic.baselib.utils.CommonUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.enums.CountryCode;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevBatteryData;
import com.logan.flight.data.recv.FlightRevSettingData;
import com.logan.flight.data.recv.FlightRevStateData;
import com.logan.flight.enums.CtrlType;

/* loaded from: classes2.dex */
public class SettingSecurityModel {
    private static final String TAG = "SettingSecurityModel";
    public boolean isFromUser;
    private OnSecurityListener securityListener;
    private CtrlType tempLostAction;
    private final long CLICK_VALID_TIME = 300;
    public final int COLOR_SELECT = C1965R.color.color_default_value_blue;
    public final int COLOR_UNSELECT = -1;
    public ObservableBoolean FlightIsConnect = new ObservableBoolean(false);
    public ObservableBoolean beginnerMode = new ObservableBoolean(true);
    public ObservableBoolean speedModeIsShow = new ObservableBoolean(false);
    public ObservableBoolean unitIsFt = new ObservableBoolean(false);
    public ObservableBoolean showBatteryInfo = new ObservableBoolean(false);
    public ObservableInt limitDistanceMaxNoUnit = new ObservableInt(FlightConfig.getMaxDistance());
    public ObservableInt inputReturnHeight = new ObservableInt(30);
    public ObservableInt inputLimitHeight = new ObservableInt(30);
    public ObservableInt warnMaxHeight = new ObservableInt(120);
    public ObservableInt maxHeight = new ObservableInt(FlightConfig.getMaxHeight());
    public ObservableInt inputLimitDistance = new ObservableInt(30);
    public ObservableInt batteryProgressValue = new ObservableInt(-1);
    public ObservableString unitTips = new ObservableString("m");
    public ObservableString tempValue = new ObservableString("N/A");
    public ObservableString currentValue = new ObservableString("N/A");
    public ObservableString voltageValue = new ObservableString("N/A");
    public ObservableString batteryTypeValue = new ObservableString("N/A");
    public ObservableString cycleTimeValue = new ObservableString("N/A");
    public ObservableBoolean isReturningOrLanding = new ObservableBoolean(false);
    private int tempSpeed = -1;
    public MutableLiveData<CtrlType> lostAction = new MutableLiveData<>(CtrlType.TYPE_LOST_RETURN_TO_120M);
    public MutableLiveData<Integer> speedMode = new MutableLiveData<>(0);
    public SingleLiveData<Void> playReturnHeightVideo = new SingleLiveData<>();
    public MutableLiveData<Boolean> isNoLimit = new MutableLiveData<>();
    public SingleLiveData<Void> showHighSpeedTips = new SingleLiveData<>();
    public DataChangedLiveData<Boolean> enableEmergencyStop = new DataChangedLiveData<>();
    private long lastClickTime = 0;
    public final SeekBar.OnSeekBarChangeListener returnHeightSeekbarListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.4
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SettingSecurityModel.this.inputReturnHeight.set(((CustomSeekbar) seekBar).getValue());
                DDLog.m1683d(SettingSecurityModel.TAG, "onProgressChanged returnHeight=" + SettingSecurityModel.this.inputReturnHeight.get());
                if (SettingSecurityModel.this.inputReturnHeight.get() > SettingSecurityModel.this.inputLimitHeight.get()) {
                    SettingSecurityModel.this.inputLimitHeight.set(SettingSecurityModel.this.inputReturnHeight.get());
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
            SettingSecurityModel.this.showReturnHeightGuide();
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SettingSecurityModel.this.sendSettings();
        }
    };
    public final SeekBar.OnSeekBarChangeListener limitHeightSeekbarListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.5
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SettingSecurityModel.this.inputLimitHeight.set(((CustomSeekbar) seekBar).getValue());
                DDLog.m1683d(SettingSecurityModel.TAG, "onProgressChanged limitHeight=" + SettingSecurityModel.this.inputLimitHeight.get());
                if (SettingSecurityModel.this.inputLimitHeight.get() < SettingSecurityModel.this.inputReturnHeight.get()) {
                    SettingSecurityModel.this.inputReturnHeight.set(SettingSecurityModel.this.inputLimitHeight.get());
                    if (z) {
                        SettingSecurityModel.this.showReturnHeightGuide();
                    }
                }
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SettingSecurityModel.this.checkSetHeightLimitOver120(((CustomSeekbar) seekBar).getValue());
        }
    };
    public final SeekBar.OnSeekBarChangeListener limitDistanceSeekbarListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.6
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SettingSecurityModel.this.inputLimitDistance.set(((CustomSeekbar) seekBar).getValue());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SettingSecurityModel.this.sendSettings();
        }
    };
    public final CursorEditText.OnInputFinishListener returnHeightInputListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.7
        @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
        public void onResult(View view, int i) {
            SettingSecurityModel.this.inputReturnHeight.set(i);
            if (SettingSecurityModel.this.inputReturnHeight.get() > SettingSecurityModel.this.inputLimitHeight.get()) {
                SettingSecurityModel.this.inputLimitHeight.set(SettingSecurityModel.this.inputReturnHeight.get());
            }
            SettingSecurityModel.this.sendSettings();
        }
    };
    public final CursorEditText.OnInputFinishListener limitHeightInputListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.8
        @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
        public void onResult(View view, int i) {
            SettingSecurityModel.this.inputLimitHeight.set(i);
            if (SettingSecurityModel.this.inputReturnHeight.get() > SettingSecurityModel.this.inputLimitHeight.get()) {
                SettingSecurityModel.this.inputReturnHeight.set(SettingSecurityModel.this.inputLimitHeight.get());
                SettingSecurityModel.this.showReturnHeightGuide();
            }
            SettingSecurityModel.this.checkSetHeightLimitOver120(i);
        }
    };
    public final CursorEditText.OnInputFinishListener limitDistanceInputListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.9
        @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
        public void onResult(View view, int i) {
            SettingSecurityModel.this.inputLimitDistance.set(i);
            SettingSecurityModel.this.sendSettings();
        }
    };

    public interface OnSecurityListener {
        void onToast(int i);

        void showOver120Dialog(SimpleResultListener<Boolean> simpleResultListener);
    }

    public SettingSecurityModel(OnSecurityListener onSecurityListener) {
        this.securityListener = onSecurityListener;
        this.unitIsFt.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                SettingSecurityModel.this.unitTips.set(SettingSecurityModel.this.unitIsFt.get() ? "ft" : "m");
                SettingSecurityModel.this.limitDistanceMaxNoUnit.notifyChange();
                SettingSecurityModel.this.inputReturnHeight.notifyChange();
                SettingSecurityModel.this.inputLimitHeight.notifyChange();
            }
        });
        this.inputReturnHeight.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.2
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                FlightSendData.get().getSendFlightSetData().setReturnHeight(SettingSecurityModel.this.inputReturnHeight.get());
            }
        });
        this.inputLimitHeight.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.3
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                FlightSendData.get().getSendFlightSetData().setHeightLimit(SettingSecurityModel.this.inputLimitHeight.get());
            }
        });
        this.unitIsFt.set(SPHelper.getInstance().isFt());
    }

    public boolean isNoLimit() {
        return this.isNoLimit.getValue() != null && this.isNoLimit.getValue().booleanValue();
    }

    public void setNoLimit(boolean z) {
        if (isNoLimit() != z) {
            this.isNoLimit.setValue(Boolean.valueOf(z));
        }
    }

    public boolean isDistanceEnable(boolean z) {
        return z ? (this.beginnerMode.get() || isNoLimit() || this.unitIsFt.get()) ? false : true : (this.beginnerMode.get() || isNoLimit()) ? false : true;
    }

    public void onBeginnerModeChange() {
        FlightSendData.get().getSendFlightSetData().setNewerMode(this.beginnerMode.get());
        this.speedModeIsShow.set(isSpeedViewEnable());
        if (this.beginnerMode.get()) {
            if (this.isFromUser) {
                btnLowSpeedClick(null);
            } else {
                this.speedMode.setValue(0);
            }
            this.inputReturnHeight.set(30);
            this.inputLimitHeight.set(30);
            this.inputLimitDistance.set(30);
        } else if (!this.isFromUser) {
            FlightRevSettingData flightRevSettingData = FlightRevData.get().getFlightRevSettingData();
            if (flightRevSettingData.isInit()) {
                this.inputReturnHeight.set(flightRevSettingData.getReturnHeight());
                this.inputLimitHeight.set(flightRevSettingData.getLimitHeight());
                if (!flightRevSettingData.isDistanceNoLimit()) {
                    this.inputLimitDistance.set(flightRevSettingData.getLimitDistance());
                }
            }
        } else {
            setLimitData();
        }
        if (this.isFromUser) {
            this.isFromUser = false;
            sendSettings();
        }
    }

    public void sendSettings() {
        if (FlightConfig.isConnectFlight() && FlightSendData.get().getSendFlightSetData().isSettingChanged()) {
            DataManager.getInstance().startSendSetting();
        }
    }

    public void setLimitData() {
        this.inputReturnHeight.set(60);
        this.inputLimitHeight.set(60);
        this.inputLimitDistance.set(500);
    }

    private boolean isSpeedViewEnable() {
        if (this.beginnerMode.get()) {
            return false;
        }
        FlightRevStateData flightRevStateData = FlightRevData.get().getFlightRevStateData();
        return CommonUtil.hasNewVersion("1.0.9", FlightRevData.get().getFlightRevVersionData().getFlightControlVersion()) ? flightRevStateData.isOutdoor() || flightRevStateData.getMode() != 1 : flightRevStateData.getMode() != 1;
    }

    private boolean checkSpeedStateIsReady() {
        if (!FlightRevData.get().getFlightRevStateData().isReturning()) {
            if (System.currentTimeMillis() - this.lastClickTime < 300) {
                return false;
            }
            this.lastClickTime = System.currentTimeMillis();
            return true;
        }
        OnSecurityListener onSecurityListener = this.securityListener;
        if (onSecurityListener != null) {
            onSecurityListener.onToast(C1965R.string.returning_switch_mode_unavailable);
        }
        EventDispatcher.get().sendEvent(EventID.AUDIO_RETURNING_NOT_AVAILABLE);
        return false;
    }

    public void update() {
        this.FlightIsConnect.set(FlightConfig.isConnectFlight());
        if (FlightConfig.isConnectFlight()) {
            return;
        }
        reset();
    }

    public void updateFlightType() {
        this.limitDistanceMaxNoUnit.set(FlightConfig.getMaxDistance());
    }

    public void update(FlightRevSettingData flightRevSettingData) {
        this.beginnerMode.set(flightRevSettingData.isNewerModeOpen());
        this.beginnerMode.notifyChange();
        this.inputReturnHeight.set(flightRevSettingData.getReturnHeight());
        this.inputLimitHeight.set(flightRevSettingData.getLimitHeight());
        this.isNoLimit.setValue(Boolean.valueOf(flightRevSettingData.isDistanceNoLimit()));
        if (flightRevSettingData.isDistanceNoLimit()) {
            return;
        }
        this.inputLimitDistance.set(flightRevSettingData.getLimitDistance());
    }

    public void update(FlightRevStateData flightRevStateData) {
        if (this.tempSpeed != flightRevStateData.getSpeedMode()) {
            this.speedMode.setValue(Integer.valueOf(flightRevStateData.getSpeedMode()));
            this.tempSpeed = flightRevStateData.getSpeedMode();
        }
        this.isReturningOrLanding.set(flightRevStateData.isReturning() || flightRevStateData.isLanding());
        this.speedModeIsShow.set(isSpeedViewEnable());
        this.enableEmergencyStop.setValue(Boolean.valueOf(flightRevStateData.canEmergencyStop()));
        update(flightRevStateData.getCtrlType());
    }

    private void update(CtrlType ctrlType) {
        if (ctrlType == null || this.tempLostAction == ctrlType || ctrlType.command != 13) {
            return;
        }
        this.lostAction.setValue(ctrlType);
        this.tempLostAction = ctrlType;
    }

    public void updateLostAction(CtrlType ctrlType) {
        if (ctrlType == null || ctrlType.command != 13) {
            return;
        }
        this.lostAction.setValue(ctrlType);
    }

    public void update(FlightRevBatteryData flightRevBatteryData) {
        float double2Float = UnitUtil.double2Float(flightRevBatteryData.getFirstVoltage() + flightRevBatteryData.getSecondVoltage() + flightRevBatteryData.getThirdVoltage() + flightRevBatteryData.getFourthVoltage());
        this.tempValue.set(String.format("%d%s", Integer.valueOf(flightRevBatteryData.getTemperature()), " °C"));
        this.currentValue.set(String.format("%d%s", Integer.valueOf(flightRevBatteryData.getCurCur()), " mA"));
        this.batteryTypeValue.set(flightRevBatteryData.getBatteryType() + "s");
        this.cycleTimeValue.set(String.format("%d", Integer.valueOf(flightRevBatteryData.getLoopNum())));
        this.voltageValue.set(double2Float + " V");
        this.batteryProgressValue.set(FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery());
    }

    public void reset() {
        this.tempValue.set("N/A");
        this.currentValue.set("N/A");
        this.batteryTypeValue.set("N/A");
        this.cycleTimeValue.set("N/A");
        this.voltageValue.set("N/A");
        this.beginnerMode.set(true);
        this.FlightIsConnect.set(false);
        this.speedModeIsShow.set(false);
        this.isReturningOrLanding.set(false);
        this.inputReturnHeight.set(30);
        this.inputLimitHeight.set(30);
        this.inputLimitDistance.set(30);
        this.tempSpeed = -1;
        this.batteryProgressValue.set(-1);
        this.enableEmergencyStop.setValue(false);
    }

    public void btnMetricClick(View view) {
        SPHelper.getInstance().putBoolean(SPHelper.KEY_UNITS_KM, false);
        if (this.unitIsFt.get()) {
            SPHelper.getInstance().setFt(false);
            PhoneConfig.isFt = false;
            this.unitIsFt.set(false);
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_UNIT_CHANGED);
    }

    public void btnKmClick(View view) {
        SPHelper.getInstance().putBoolean(SPHelper.KEY_UNITS_KM, true);
        if (this.unitIsFt.get()) {
            SPHelper.getInstance().setFt(false);
            PhoneConfig.isFt = false;
            this.unitIsFt.set(false);
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_UNIT_CHANGED);
    }

    public void btnFtClick(View view) {
        if (this.unitIsFt.get()) {
            return;
        }
        SPHelper.getInstance().putBoolean(SPHelper.KEY_UNITS_KM, false);
        SPHelper.getInstance().setFt(true);
        PhoneConfig.isFt = true;
        this.unitIsFt.set(true);
        EventDispatcher.get().sendEvent(EventID.EVENT_UNIT_CHANGED);
    }

    public void btnLowSpeedClick(View view) {
        if (checkSpeedStateIsReady()) {
            this.speedMode.setValue(0);
            FlightSendData.get().getSendFlightSetData().setSpeedMode(0);
            if (view != null) {
                sendSettings();
            }
        }
    }

    public void btnNormalSpeedClick(View view) {
        if (checkSpeedStateIsReady()) {
            this.speedMode.setValue(1);
            FlightSendData.get().getSendFlightSetData().setSpeedMode(1);
            sendSettings();
        }
    }

    public void btnHighSpeedClick(View view) {
        if (checkSpeedStateIsReady()) {
            if (FlightRevData.get().getFlightRevBatteryData().getTemperature() <= 20) {
                OnSecurityListener onSecurityListener = this.securityListener;
                if (onSecurityListener != null) {
                    onSecurityListener.onToast(C1965R.string.f2138xd1edc812);
                    return;
                }
                return;
            }
            if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevFlightInfoData().getVerticalDistance() <= 8.0d) {
                OnSecurityListener onSecurityListener2 = this.securityListener;
                if (onSecurityListener2 != null) {
                    onSecurityListener2.onToast(C1965R.string.switch_sport_mode_tip);
                    return;
                }
                return;
            }
            if (FlightConfig.isConnectFlight() && FlightRevData.get().getFlightRevFlightInfoData().getRemainedBattery() <= 30) {
                OnSecurityListener onSecurityListener3 = this.securityListener;
                if (onSecurityListener3 != null) {
                    onSecurityListener3.onToast(C1965R.string.low_power_quit_sport_mode);
                    return;
                }
                return;
            }
            this.speedMode.setValue(2);
            this.showHighSpeedTips.setValue(null);
            FlightSendData.get().getSendFlightSetData().setSpeedMode(2);
            sendSettings();
        }
    }

    public void btnReturnClick(View view) {
        if (this.lostAction.getValue() == CtrlType.TYPE_LOST_RETURN || this.lostAction.getValue() == CtrlType.TYPE_LOST_RETURN_TO_120M) {
            return;
        }
        DataManager.getInstance().sendCtrlData(CtrlType.TYPE_LOST_RETURN_TO_120M);
    }

    public void btnLandClick(View view) {
        DataManager.getInstance().sendCtrlData(CtrlType.TYPE_LOST_LAND);
    }

    public void btnHoverClick(View view) {
        DataManager.getInstance().sendCtrlData(CtrlType.TYPE_LOST_HOVER);
    }

    public void btnLostToReturnClick(View view) {
        if (this.lostAction.getValue() == CtrlType.TYPE_LOST_RETURN_TO_120M) {
            DataManager.getInstance().sendCtrlData(CtrlType.TYPE_LOST_RETURN);
        } else {
            DataManager.getInstance().sendCtrlData(CtrlType.TYPE_LOST_RETURN_TO_120M);
        }
    }

    public void btnBatteryInfoClick(View view) {
        this.showBatteryInfo.set(!r2.get());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showReturnHeightGuide() {
        if (SPHelper.getInstance().isRthGuideVideoShown()) {
            return;
        }
        this.playReturnHeightVideo.setValue(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkSetHeightLimitOver120(int i) {
        final int limitHeight = FlightRevData.get().getFlightRevSettingData().getLimitHeight();
        if (CountryCode.JP.getCode().equals(SPHelper.getInstance().getCountryCode()) || CountryCode.KR.getCode().equals(SPHelper.getInstance().getCountryCode())) {
            this.warnMaxHeight.set(150);
        }
        if (limitHeight <= this.warnMaxHeight.get() && i > this.warnMaxHeight.get()) {
            this.securityListener.showOver120Dialog(new SimpleResultListener<Boolean>() { // from class: com.ipotensic.kernel.model.SettingSecurityModel.10
                @Override // com.ipotensic.baselib.listener.SimpleResultListener
                public void onResult(Boolean bool) {
                    if (bool.booleanValue()) {
                        SettingSecurityModel.this.sendSettings();
                    } else {
                        SettingSecurityModel.this.inputLimitHeight.set(limitHeight);
                    }
                }
            });
        } else {
            sendSettings();
        }
    }
}