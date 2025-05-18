package com.ipotensic.kernel.model.calibration;

import android.app.Activity;
import android.view.View;
import androidx.databinding.BaseObservable;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.C1965R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.view.CursorStringEditText;
import com.logan.flight.DataManager;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;

/* loaded from: classes2.dex */
public class SettingGimbalFineTuningModel extends BaseObservable {
    private final Activity activity;
    public final float maxValue = 10.0f;
    public final float minValue = -10.0f;
    public final float defaultValue = 0.0f;
    public ObservableString levelValue = new ObservableString(SessionDescription.SUPPORTED_SDP_VERSION);
    public ObservableString yawValue = new ObservableString(SessionDescription.SUPPORTED_SDP_VERSION);
    public ObservableInt gimbalReset = new ObservableInt(3);
    public ObservableBoolean isLevelBtnEnable = new ObservableBoolean(false);
    public ObservableBoolean isYawBtnEnable = new ObservableBoolean(false);
    private final float factor = 0.1f;
    public final CursorStringEditText.OnInputFinishListener levelValueInputListener = new CursorStringEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.calibration.SettingGimbalFineTuningModel.1
        @Override // com.ipotensic.kernel.view.CursorStringEditText.OnInputFinishListener
        public void onResult(View view, String str) {
            DDLog.m1684e("云台微调输入的level = " + str);
            if (str == null) {
                SettingGimbalFineTuningModel.this.levelValue.set(SettingGimbalFineTuningModel.this.levelValue.get());
                SettingGimbalFineTuningModel.this.notifyChange();
                ToastUtil.toast(SettingGimbalFineTuningModel.this.activity, SettingGimbalFineTuningModel.this.activity.getString(C1965R.string.invalid_value));
            } else if (str.equals("")) {
                SettingGimbalFineTuningModel.this.levelValue.set(SettingGimbalFineTuningModel.this.levelValue.get());
                SettingGimbalFineTuningModel.this.notifyChange();
            } else if (str.contains(".")) {
                SettingGimbalFineTuningModel.this.setLevelValue((float) (Math.floor(Float.parseFloat(str) * 10.0f) / 10.0d), false);
            } else {
                SettingGimbalFineTuningModel.this.setLevelValue(Float.parseFloat(str), false);
            }
        }
    };
    public final CursorStringEditText.OnInputFinishListener yawValueInputListener = new CursorStringEditText.OnInputFinishListener() { // from class: com.ipotensic.kernel.model.calibration.SettingGimbalFineTuningModel.2
        @Override // com.ipotensic.kernel.view.CursorStringEditText.OnInputFinishListener
        public void onResult(View view, String str) {
            DDLog.m1684e("云台微调输入的yaw = " + str);
            if (str == null) {
                SettingGimbalFineTuningModel.this.yawValue.set(SettingGimbalFineTuningModel.this.yawValue.get());
                SettingGimbalFineTuningModel.this.notifyChange();
                ToastUtil.toast(SettingGimbalFineTuningModel.this.activity, SettingGimbalFineTuningModel.this.activity.getString(C1965R.string.invalid_value));
            } else if (str.equals("")) {
                SettingGimbalFineTuningModel.this.yawValue.set(SettingGimbalFineTuningModel.this.yawValue.get());
                SettingGimbalFineTuningModel.this.notifyChange();
            } else if (str.contains(".")) {
                SettingGimbalFineTuningModel.this.setYawValue((float) (Math.floor(Float.parseFloat(str) * 10.0f) / 10.0d), false);
            } else {
                SettingGimbalFineTuningModel.this.setYawValue(Float.parseFloat(str), false);
            }
        }
    };

    public SettingGimbalFineTuningModel(Activity activity) {
        this.activity = activity;
    }

    public void setReduceLevel(View view) {
        if (!checkErrorStatus() && Float.parseFloat(this.levelValue.get()) > -10.0f) {
            setLevelValue(Math.round((Float.parseFloat(this.levelValue.get()) - 0.1f) * 10.0f) / 10.0f, false);
        }
    }

    public void setPlusLevel(View view) {
        if (!checkErrorStatus() && Float.parseFloat(this.levelValue.get()) < 10.0f) {
            setLevelValue(Math.round((Float.parseFloat(this.levelValue.get()) + 0.1f) * 10.0f) / 10.0f, false);
        }
    }

    public void setReduceYaw(View view) {
        if (!checkErrorStatus() && Float.parseFloat(this.yawValue.get()) > -10.0f) {
            setYawValue(Math.round((Float.parseFloat(this.yawValue.get()) - 0.1f) * 10.0f) / 10.0f, false);
        }
    }

    public void setPlusYaw(View view) {
        if (!checkErrorStatus() && Float.parseFloat(this.yawValue.get()) < 10.0f) {
            setYawValue(Math.round((Float.parseFloat(this.yawValue.get()) + 0.1f) * 10.0f) / 10.0f, false);
        }
    }

    public void setLevelValue(float f, boolean z) {
        if (checkErrorStatus()) {
            return;
        }
        DDLog.m1684e("云台微调setLevelValue= " + f);
        if (f > 10.0f) {
            f = 10.0f;
        }
        if (f < -10.0f) {
            f = -10.0f;
        }
        String valueOf = String.valueOf(f);
        if (valueOf.endsWith(".0")) {
            this.levelValue.set(valueOf.substring(0, valueOf.indexOf(".")));
        } else {
            this.levelValue.set(f + "");
        }
        this.isLevelBtnEnable.set(f != 0.0f);
        this.gimbalReset.set(z ? 3 : 0);
        notifyChange();
        sendSetting();
    }

    public void setYawValue(float f, boolean z) {
        if (checkErrorStatus()) {
            return;
        }
        DDLog.m1684e("云台微调setYawValue= " + f);
        if (f > 10.0f) {
            f = 10.0f;
        }
        if (f < -10.0f) {
            f = -10.0f;
        }
        String valueOf = String.valueOf(f);
        if (valueOf.endsWith(".0")) {
            this.yawValue.set(valueOf.substring(0, valueOf.indexOf(".")));
        } else {
            this.yawValue.set(f + "");
        }
        this.isYawBtnEnable.set(f != 0.0f);
        this.gimbalReset.set(z ? 4 : 0);
        notifyChange();
        sendSetting();
    }

    public void setLevelDefaultValueClick(View view) {
        if (checkErrorStatus() || Float.parseFloat(this.levelValue.get()) == 0.0f || Float.parseFloat(this.levelValue.get()) == 0.0d) {
            return;
        }
        setLevelValue(0.0f, true);
    }

    public void setYawDefaultValueClick(View view) {
        if (checkErrorStatus() || Float.parseFloat(this.yawValue.get()) == 0.0f || Float.parseFloat(this.yawValue.get()) == 0.0d) {
            return;
        }
        setYawValue(0.0f, true);
    }

    private boolean checkErrorStatus() {
        short error_status = FlightRevData.get().getGimbalStateData().getError_status();
        if (error_status == 4) {
            Activity activity = this.activity;
            ToastUtil.toast(activity, activity.getString(C1965R.string.warning_the_gimbal_is_stuck_briefly_tips));
            return true;
        }
        if (error_status == 5) {
            Activity activity2 = this.activity;
            ToastUtil.toast(activity2, activity2.getString(C1965R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips));
            return true;
        }
        if (error_status == 3) {
            Activity activity3 = this.activity;
            ToastUtil.toast(activity3, activity3.getString(C1965R.string.txt_error_gimbal_need_calibration));
            return true;
        }
        if (error_status == 6) {
            Activity activity4 = this.activity;
            ToastUtil.toast(activity4, activity4.getString(C1965R.string.txt_error_gimbal_angle_too_big));
            return true;
        }
        if (error_status != 1 && error_status != 2) {
            return false;
        }
        Activity activity5 = this.activity;
        ToastUtil.toast(activity5, activity5.getString(C1965R.string.txt_error_gimbal_error));
        return true;
    }

    public void sendSetting() {
        if (FlightRevData.get().getGimbalSettingData().isInit()) {
            FlightRevGimbalSettingData gimbalSettingData = FlightRevData.get().getGimbalSettingData();
            FlightSendData.get().getSendGimbalSettingData().init(0, (short) gimbalSettingData.getPitchSpeed(), gimbalSettingData.isStableMode(), gimbalSettingData.getFpvSmooth(), 0, (short) (Float.parseFloat(this.levelValue.get()) * 10.0f), (short) (Float.parseFloat(this.yawValue.get()) * 10.0f), this.gimbalReset.get());
            DataManager.getInstance().sendGimbalSettingData();
        }
    }

    public void update(FlightRevGimbalSettingData flightRevGimbalSettingData) {
        if (this.levelValue != null) {
            DDLog.m1684e("云台微调getTuningRoll= " + ((int) flightRevGimbalSettingData.getTuningRoll()) + ", getTuningYaw= " + ((int) flightRevGimbalSettingData.getTuningYaw()));
            float tuningRoll = flightRevGimbalSettingData.getTuningRoll() / 10.0f;
            float tuningYaw = flightRevGimbalSettingData.getTuningYaw() / 10.0f;
            DDLog.m1684e("云台微调，转换之前的值tuningRoll= " + tuningRoll + ", tuningYaw = " + tuningYaw);
            String valueOf = String.valueOf(tuningRoll);
            String valueOf2 = String.valueOf(tuningYaw);
            if (valueOf.endsWith(".0")) {
                this.levelValue.set(valueOf.substring(0, valueOf.indexOf(".")));
            } else {
                this.levelValue.set(tuningRoll + "");
            }
            if (tuningRoll != 0.0f) {
                this.isLevelBtnEnable.set(true);
            }
            if (valueOf2.endsWith(".0")) {
                this.yawValue.set(valueOf2.substring(0, valueOf2.indexOf(".")));
            } else {
                this.yawValue.set(tuningYaw + "");
            }
            if (tuningYaw != 0.0f) {
                this.isYawBtnEnable.set(true);
            }
        }
    }
}