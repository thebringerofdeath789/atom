package com.ipotensic.kernel.model;

import android.view.View;
import android.widget.SeekBar;
import androidx.databinding.Observable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.okhttp.OnResultListener;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.SwitchButton;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraCtrlPresenter;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.enums.CaptureMode;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.recv.FlightRevStateData;

/* loaded from: classes2.dex */
public class SettingCameraModel {
    public boolean isTimeTaking;
    private OnSettingCameraListener settingCameraListener;
    public final int WB_MAX = 10000;
    public final int WB_DEFAULT = 2000;
    public final int WB_MIN = 2000;
    public final boolean WB_IS_INPUT_ABLE = false;
    public final int WB_SEEKBAR_MAX = 80;
    public final int WB_SEEKBAR_DEFAULT = 0;
    public final int WB_SEEKBAR_MIN = 0;
    private final long SETTING_TIMEOUT = 1000;
    private final long FORMAT_TIMEOUT = 30000;
    public ObservableBoolean isFlightConnect = new ObservableBoolean(false);
    public ObservableBoolean wbIsMwb = new ObservableBoolean(false);
    public ObservableBoolean waterMarkIsShow = new ObservableBoolean(false);
    public ObservableBoolean photoGpsIsShow = new ObservableBoolean(true);
    public ObservableInt inputWB = new ObservableInt(0);
    public ObservableInt wbSeekbarProgress = new ObservableInt(0);
    public ObservableInt recSeg = new ObservableInt(0);
    public ObservableString remainCapacity = new ObservableString("N/A");
    public ObservableBoolean formatSdIsEnable = new ObservableBoolean(false);
    public ObservableBoolean waterMarkIsClickable = new ObservableBoolean(false);
    public ObservableBoolean gpsLocationIsClickable = new ObservableBoolean(false);
    public MutableLiveData<Boolean> isTrackOpen = new MutableLiveData<>();
    public final SeekBar.OnSeekBarChangeListener wbSeekbarListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.model.SettingCameraModel.3
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SettingCameraModel.this.inputWB.set((seekBar.getProgress() * 100) + 2000);
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            CameraCtrlPresenter.getInstance().setManualWhiteBalanceValue(SettingCameraModel.this.inputWB.get());
        }
    };
    public final SwitchButton.SwitchStateListener waterMarkStateChangedListener = new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.model.SettingCameraModel.4
        @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
        public void onDisableClick() {
            if (SettingCameraModel.this.isFlightConnect.get()) {
                return;
            }
            SettingCameraModel.this.settingCameraListener.onToast(R.string.toast_unconnected_tips);
        }

        @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
        public void onStateChanged(View view, boolean z) {
            if (SettingCameraModel.this.checkReady()) {
                if (CameraConfig.get().isGetConfigMenu) {
                    SettingCameraModel.this.waterMarkIsShow.set(z);
                    SettingCameraModel.this.waterMarkIsClickable.set(false);
                    CameraCtrlPresenter.getInstance().setPhotoOSD(z);
                    PhoneConfig.mainHandler.removeCallbacks(SettingCameraModel.this.waterMarkRunnable);
                    PhoneConfig.mainHandler.postDelayed(SettingCameraModel.this.waterMarkRunnable, 1000L);
                    return;
                }
                return;
            }
            ((SwitchButton) view).setChecked(!z);
        }
    };
    public final SwitchButton.SwitchStateListener gpsLocationStateChangedListener = new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.model.SettingCameraModel.5
        @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
        public void onStateChanged(View view, boolean z) {
            if (SettingCameraModel.this.checkReady()) {
                if (CameraConfig.get().isGetConfigMenu) {
                    SettingCameraModel.this.photoGpsIsShow.set(z);
                    SettingCameraModel.this.gpsLocationIsClickable.set(false);
                    CameraCtrlPresenter.getInstance().setPhotoRecordGps(z);
                    PhoneConfig.mainHandler.removeCallbacks(SettingCameraModel.this.gpsLocationRunnable);
                    PhoneConfig.mainHandler.postDelayed(SettingCameraModel.this.gpsLocationRunnable, 1000L);
                    return;
                }
                return;
            }
            ((SwitchButton) view).setChecked(!z);
        }

        @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
        public void onDisableClick() {
            if (SettingCameraModel.this.isFlightConnect.get()) {
                return;
            }
            SettingCameraModel.this.settingCameraListener.onToast(R.string.toast_unconnected_tips);
        }
    };
    public final CursorEditText.OnInputFinishListener wbInputListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.SettingCameraModel.6
        @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
        public void onResult(View view, int i) {
            SettingCameraModel.this.inputWB.set(i);
            CameraCtrlPresenter.getInstance().setManualWhiteBalanceValue(i);
        }
    };
    private final Runnable formatSdRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.SettingCameraModel.7
        @Override // java.lang.Runnable
        public void run() {
            SettingCameraModel.this.formatSdIsEnable.set(true);
        }
    };
    private final Runnable waterMarkRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.SettingCameraModel.8
        @Override // java.lang.Runnable
        public void run() {
            SettingCameraModel.this.waterMarkIsClickable.set(!SettingCameraModel.this.isTimeTaking);
        }
    };
    private final Runnable gpsLocationRunnable = new Runnable() { // from class: com.ipotensic.kernel.model.SettingCameraModel.9
        @Override // java.lang.Runnable
        public void run() {
            SettingCameraModel.this.gpsLocationIsClickable.set(true);
        }
    };

    public interface OnSettingCameraListener {
        void onFormatSD(OnResultListener<Boolean> onResultListener);

        void onToast(int i);
    }

    public SettingCameraModel(OnSettingCameraListener onSettingCameraListener) {
        boolean z = false;
        this.settingCameraListener = onSettingCameraListener;
        this.inputWB.addOnPropertyChangedCallback(new Observable.OnPropertyChangedCallback() { // from class: com.ipotensic.kernel.model.SettingCameraModel.1
            @Override // androidx.databinding.Observable.OnPropertyChangedCallback
            public void onPropertyChanged(Observable observable, int i) {
                SettingCameraModel.this.wbSeekbarProgress.set((SettingCameraModel.this.inputWB.get() - 2000) / 100);
            }
        });
        ObservableBoolean observableBoolean = this.isFlightConnect;
        if (FlightConfig.isConnectFlight() && CameraConfig.get().isGetConfigMenu) {
            z = true;
        }
        observableBoolean.set(z);
    }

    public void updateManualWhiteBalance() {
        ManualModeInfo manualModeInfo = CameraConfig.get().getManualModeInfo();
        if (manualModeInfo != null) {
            this.wbIsMwb.set(manualModeInfo.isMwbMode);
            this.inputWB.set(manualModeInfo.wbValue);
        }
    }

    public void updateAutoWhiteBalance() {
        ManualModeInfo manualModeInfo = CameraConfig.get().getManualModeInfo();
        if (manualModeInfo != null) {
            this.wbIsMwb.set(manualModeInfo.isMwbMode);
            if (manualModeInfo.isMwbMode) {
                return;
            }
            this.inputWB.set(manualModeInfo.wbValue);
        }
    }

    public void update() {
        if (CameraConfig.get().isGetConfigMenu) {
            this.formatSdIsEnable.set(CameraConfig.get().isSdCardAvailable());
            this.waterMarkIsClickable.set(!this.isTimeTaking);
            this.gpsLocationIsClickable.set(true);
            this.recSeg.set(CameraConfig.get().supportSplitSizes.getCurrentIndexForUsb());
            if (CameraConfig.get().getCaptureMode() == CaptureMode.MODE_PHOTO) {
                this.waterMarkIsShow.set(CameraConfig.get().isPhotoOsdShow());
            } else {
                this.waterMarkIsShow.set(CameraConfig.get().isVideoOsdShow());
            }
            if (CameraConfig.get().isSdCardAvailable()) {
                long sdFreeSpace = CameraConfig.get().getSdFreeSpace();
                long sdTotalSpace = CameraConfig.get().getSdTotalSpace();
                if (sdTotalSpace != 0) {
                    this.remainCapacity.set(FormatUtil.getSdCardSpaceRatio(sdFreeSpace, sdTotalSpace));
                }
            } else {
                this.remainCapacity.set("N/A");
            }
            this.photoGpsIsShow.set(CameraConfig.get().isPhotoGpsShow());
        }
    }

    public void update(FlightRevStateData flightRevStateData) {
        this.isFlightConnect.set(FlightConfig.isConnectFlight() && CameraConfig.get().isGetConfigMenu);
    }

    public void formatSuccess() {
        PhoneConfig.mainHandler.removeCallbacks(this.formatSdRunnable);
        this.formatSdIsEnable.set(true);
    }

    public void reset() {
        this.isFlightConnect.set(false);
        this.wbIsMwb.set(false);
        this.remainCapacity.set("N/A");
        this.formatSdIsEnable.set(false);
        this.recSeg.set(0);
        this.inputWB.set(0);
        this.wbSeekbarProgress.set(0);
        this.waterMarkIsShow.set(false);
        this.photoGpsIsShow.set(true);
        this.waterMarkIsClickable.set(false);
        this.gpsLocationIsClickable.set(false);
        this.isTrackOpen.setValue(false);
        PhoneConfig.mainHandler.removeCallbacks(this.waterMarkRunnable);
        PhoneConfig.mainHandler.removeCallbacks(this.gpsLocationRunnable);
        PhoneConfig.mainHandler.removeCallbacks(this.formatSdRunnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean checkReady() {
        if (Conditions.isInShortVideo()) {
            this.settingCameraListener.onToast(R.string.txt_pls_exit_short_video_first);
            return false;
        }
        if (!Conditions.isRecording()) {
            return true;
        }
        this.settingCameraListener.onToast(R.string.txt_pls_exit_recording_first);
        return false;
    }

    public void btnMwbClick(View view) {
        ManualModeInfo manualModeInfo = CameraConfig.get().getManualModeInfo();
        if (manualModeInfo != null) {
            CameraCtrlPresenter.getInstance().setManualWhiteBalanceMode(manualModeInfo.isMwbMode);
        }
    }

    public void btnFormatSDClick(View view) {
        OnSettingCameraListener onSettingCameraListener;
        if (!checkReady() || (onSettingCameraListener = this.settingCameraListener) == null) {
            return;
        }
        onSettingCameraListener.onFormatSD(new OnResultListener<Boolean>() { // from class: com.ipotensic.kernel.model.SettingCameraModel.2
            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onFailed(Exception exc) {
            }

            @Override // com.ipotensic.baselib.okhttp.OnResultListener
            public void onSuccess(Boolean bool) {
                SettingCameraModel.this.formatSdIsEnable.set(false);
                PhoneConfig.mainHandler.removeCallbacks(SettingCameraModel.this.formatSdRunnable);
                PhoneConfig.mainHandler.postDelayed(SettingCameraModel.this.formatSdRunnable, 30000L);
            }
        });
    }

    public void onDotClick(boolean z) {
        SPHelper.getInstance().setPreviewShowDot(z);
        EventDispatcher.get().sendEvent(EventID.EVENT_GUIDE_LINE_CHANGED);
    }

    public void onCrossClick(boolean z) {
        SPHelper.getInstance().setPreviewShowCross(z);
        EventDispatcher.get().sendEvent(EventID.EVENT_GUIDE_LINE_CHANGED);
    }

    public void onSharpClick(boolean z) {
        SPHelper.getInstance().setPreviewShowLine(z);
        EventDispatcher.get().sendEvent(EventID.EVENT_GUIDE_LINE_CHANGED);
    }

    public void onSegAutoClick(View view) {
        if (checkReady()) {
            this.recSeg.set(0);
            setRecSeg();
        }
    }

    public void onSeg1Click(View view) {
        if (checkReady()) {
            this.recSeg.set(1);
            setRecSeg();
        }
    }

    public void onSeg3Click(View view) {
        if (checkReady()) {
            this.recSeg.set(2);
            setRecSeg();
        }
    }

    public void onSeg5Click(View view) {
        if (checkReady()) {
            this.recSeg.set(3);
            setRecSeg();
        }
    }

    public void setRecSeg() {
        if (CameraConfig.get().isGetConfigMenu) {
            int i = this.recSeg.get();
            CameraCtrlPresenter.getInstance().setVideoSegment(CameraConfig.get().supportSplitSizes.getSupportList().get(i).getRealValueForWifi(), CameraConfig.get().supportSplitSizes.getSupportList().get(i).getRealValueForUsb());
        }
    }
}
