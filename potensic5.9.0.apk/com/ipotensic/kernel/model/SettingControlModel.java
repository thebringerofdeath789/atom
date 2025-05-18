package com.ipotensic.kernel.model;

import android.view.View;
import android.widget.SeekBar;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.utils.Conditions;
import com.ipotensic.kernel.view.CursorEditText;
import com.ipotensic.kernel.view.CustomSeekbar;
import com.ipotensic.kernel.view.SwitchButton;
import com.ipotensic.kernel.view.dialog.GimbalModeDialog;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;
import com.logan.flight.data.recv.FlightRevGimbalStateData;

/* loaded from: classes2.dex */
public class SettingControlModel {
    private OnSettingControlListener settingControlListener;
    public final int PITCH_ANGEL_0 = 0;
    public final int PITCH_ANGEL_DEFAULT = 10000;
    public final int PITCH_ANGEL_45 = -45;
    public final int PITCH_ANGEL_90 = -90;
    public final int PITCH_SPEED_MAX = 100;
    public final int PITCH_SPEED_DEFAULT = 10;
    public final int PITCH_SPEED_MIN = 1;
    public final int FPV_SMOOTH_MAX = 10;
    public final int FPV_SMOOTH_DEFAULT = 5;
    public final int FPV_SMOOTH_MIN = 0;
    public final int COLOR_SELECT = C1965R.color.color_default_value_blue;
    public final int COLOR_UNSELECT = -1;
    public final float UNSELECT_ALPHA = 0.5f;
    public final float SELECT_ALPHA = 1.0f;
    public ObservableBoolean isConnectFlight = new ObservableBoolean(false);
    public ObservableBoolean isHeadLessClickable = new ObservableBoolean(true);
    public ObservableInt pitchSpeed = new ObservableInt(10);
    public ObservableInt pitchAngel = new ObservableInt(10000);
    public ObservableInt fpvSmooth = new ObservableInt(5);
    public ObservableInt gimbalReset = new ObservableInt(0);
    public ObservableBoolean stableMode = new ObservableBoolean(true);
    public ObservableString currentAngel = new ObservableString("");
    private int lastPitchAngel = 10000;
    public final SeekBar.OnSeekBarChangeListener pitchSpeedSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.model.SettingControlModel.2
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SettingControlModel.this.setPitchSpeed(((CustomSeekbar) seekBar).getValue());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            DDLog.m1684e("云台设置 pitch speed:" + SettingControlModel.this.pitchSpeed.get());
            if (SettingControlModel.this.isConnectFlight.get()) {
                SettingControlModel.this.sendSetting();
            } else {
                SettingControlModel.this.pitchSpeed.set(10);
            }
        }
    };
    public final SeekBar.OnSeekBarChangeListener fpvSmoothSeekBarChangeListener = new SeekBar.OnSeekBarChangeListener() { // from class: com.ipotensic.kernel.model.SettingControlModel.3
        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (z) {
                SettingControlModel.this.setFpvSmooth(((CustomSeekbar) seekBar).getValue());
            }
        }

        @Override // android.widget.SeekBar.OnSeekBarChangeListener
        public void onStopTrackingTouch(SeekBar seekBar) {
            SettingControlModel.this.sendSetting();
        }
    };
    public final CursorEditText.OnInputFinishListener pitchSpeedInputListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.SettingControlModel.4
        @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
        public void onResult(View view, int i) {
            if (SettingControlModel.this.pitchSpeed.get() != i) {
                SettingControlModel.this.setPitchSpeed(i);
                SettingControlModel.this.sendSetting();
            }
        }
    };
    public final CursorEditText.OnInputFinishListener fpvSmoothInputListener = new CursorEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.SettingControlModel.5
        @Override // com.ipotensic.kernel.view.CursorEditText.OnInputFinishListener
        public void onResult(View view, int i) {
            if (SettingControlModel.this.fpvSmooth.get() != i) {
                SettingControlModel.this.setFpvSmooth(i);
                SettingControlModel.this.sendSetting();
            }
        }
    };
    public final SwitchButton.SwitchStateListener switchStateListener = new SwitchButton.SwitchStateListener() { // from class: com.ipotensic.kernel.model.SettingControlModel.6
        @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
        public void onStateChanged(View view, boolean z) {
            FlightSendData.get().setNoHeadMode();
        }

        @Override // com.ipotensic.kernel.view.SwitchButton.SwitchStateListener
        public void onDisableClick() {
            if (SettingControlModel.this.isConnectFlight.get()) {
                return;
            }
            SettingControlModel.this.settingControlListener.onToast(C1965R.string.toast_unconnected_tips);
        }
    };

    public interface OnSettingControlListener {
        void onToast(int i);
    }

    public SettingControlModel(OnSettingControlListener onSettingControlListener) {
        this.settingControlListener = onSettingControlListener;
    }

    public void setPitchAngel(int i) {
        this.pitchAngel.set(i);
        this.lastPitchAngel = i;
    }

    public void setPitchSpeed(int i) {
        this.pitchSpeed.set(i);
    }

    public void setFpvSmooth(int i) {
        this.fpvSmooth.set(i);
    }

    public void setStableMode(boolean z) {
        this.stableMode.set(z);
    }

    public void setGimbalReset(int i) {
        this.gimbalReset.set(i);
    }

    public void setCurrentAngel(String str) {
        this.currentAngel.set(str);
    }

    public void update(FlightRevGimbalSettingData flightRevGimbalSettingData) {
        setPitchSpeed(flightRevGimbalSettingData.getPitchSpeed());
        setStableMode(flightRevGimbalSettingData.isStableMode());
        setFpvSmooth(flightRevGimbalSettingData.getFpvSmooth());
    }

    public void update(final FlightRevGimbalStateData flightRevGimbalStateData) {
        this.isConnectFlight.set(FlightConfig.isConnectFlight());
        if (this.lastPitchAngel != flightRevGimbalStateData.getControl_pitch()) {
            PhoneConfig.mainHandler.post(new Runnable() { // from class: com.ipotensic.kernel.model.SettingControlModel.1
                @Override // java.lang.Runnable
                public void run() {
                    SettingControlModel.this.setPitchAngel(flightRevGimbalStateData.getControl_pitch());
                    SettingControlModel.this.setCurrentAngel("(" + flightRevGimbalStateData.getControl_pitch() + "°)");
                }
            });
        }
    }

    private boolean checkReady() {
        if (!Conditions.isInShortVideo()) {
            return true;
        }
        this.settingControlListener.onToast(C1965R.string.txt_pls_exit_short_video_first);
        return false;
    }

    private boolean checkReady1() {
        if (!Conditions.isTrackTargetOpen()) {
            return true;
        }
        this.settingControlListener.onToast(C1965R.string.txt_pls_exit_short_video_first);
        return false;
    }

    public void btnAngel0Click(View view) {
        if (checkReady()) {
            sendSettingPitchAngel(1);
        }
    }

    public void btnAngel45Click(View view) {
        if (checkReady()) {
            sendSettingPitchAngel(3);
        }
    }

    public void btnAngel90Click(View view) {
        if (checkReady()) {
            sendSettingPitchAngel(2);
        }
    }

    public void btnStableModeClick(View view) {
        if (checkReady1()) {
            setSettingStableMode(true);
        }
    }

    public void btnFpvModeClick(View view) {
        if (checkReady1()) {
            setSettingStableMode(false);
        }
    }

    public void btnResetPitchSpeed(View view) {
        setGimbalReset(1);
        sendSettingReset();
    }

    public void btnResetFpvSmooth(View view) {
        setGimbalReset(2);
        sendSettingReset();
    }

    public void btnModeGuideVideo(View view) {
        new GimbalModeDialog(view.getContext(), this.stableMode.get()).show();
    }

    private void sendSettingPitchAngel(int i) {
        sendSetting(i, (short) this.pitchSpeed.get(), this.stableMode.get(), this.fpvSmooth.get(), 0);
    }

    public void sendSetting() {
        sendSetting(0, (short) this.pitchSpeed.get(), this.stableMode.get(), this.fpvSmooth.get(), 0);
    }

    private void setSettingStableMode(boolean z) {
        sendSetting(0, (short) this.pitchSpeed.get(), z, this.fpvSmooth.get(), 0);
    }

    private void sendSettingReset() {
        sendSetting(0, (short) this.pitchSpeed.get(), this.stableMode.get(), this.fpvSmooth.get(), this.gimbalReset.get());
    }

    private void sendSetting(int i, short s, boolean z, int i2, int i3) {
        if (FlightRevData.get().getGimbalSettingData().isInit()) {
            FlightSendData.get().getSendGimbalSettingData().init(i, s, z, i2, 0, FlightRevData.get().getGimbalSettingData().getTuningRoll(), FlightRevData.get().getGimbalSettingData().getTuningYaw(), i3);
            DataManager.getInstance().sendGimbalSettingData();
        }
    }

    public void reset() {
        this.isConnectFlight.set(false);
        this.isHeadLessClickable.set(true);
        setPitchSpeed(10);
        setPitchAngel(10000);
        setFpvSmooth(5);
        setGimbalReset(0);
        setStableMode(true);
        setCurrentAngel("");
    }
}