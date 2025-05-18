package com.ipotensic.kernel.model.calibration;

import android.view.View;
import androidx.databinding.ObservableBoolean;
import androidx.databinding.ObservableInt;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.MutableLiveData;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.ToastUtil;
import com.ipotensic.kernel.R;
import com.ipotensic.kernel.bean.ObservableString;
import com.ipotensic.kernel.databinding.ViewLayoutGimbalCalibrationBinding;
import com.logan.flight.DataManager;
import com.logan.flight.FlightConfig;
import com.logan.flight.data.FlightRevData;
import com.logan.flight.data.FlightSendData;
import com.logan.flight.data.recv.FlightRevGimbalSettingData;

/* loaded from: classes2.dex */
public class SettingGimbalCalibrationModel {
    private final FragmentActivity activity;
    private final ViewLayoutGimbalCalibrationBinding binding;
    private boolean isStopRevData;
    public ObservableInt calibrationResultResId = new ObservableInt(R.mipmap.img_gimbal_calibration_success);
    public ObservableBoolean stepOneVisible = new ObservableBoolean(true);
    public ObservableBoolean stepTwoVisible = new ObservableBoolean(false);
    public ObservableBoolean stepThreeVisible = new ObservableBoolean(false);
    public ObservableBoolean startBtnVisible = new ObservableBoolean(true);
    public ObservableString titleStr = new ObservableString();
    public ObservableString resultStr = new ObservableString();
    public ObservableString startBtnStr = new ObservableString();
    public MutableLiveData<Integer> calibrateResult = new MutableLiveData<>();

    public SettingGimbalCalibrationModel(FragmentActivity fragmentActivity, ViewLayoutGimbalCalibrationBinding viewLayoutGimbalCalibrationBinding) {
        this.activity = fragmentActivity;
        this.binding = viewLayoutGimbalCalibrationBinding;
    }

    public void startCalibration(View view) {
        DDLog.e("\u53d1\u9001\u4e91\u53f0\u6821\u51c6\u6307\u4ee40");
        if (checkErrorStatus()) {
            return;
        }
        this.isStopRevData = false;
        DDLog.e("\u53d1\u9001\u4e91\u53f0\u6821\u51c6\u6307\u4ee41");
        sendSetting();
    }

    private boolean checkErrorStatus() {
        short error_status = FlightRevData.get().getGimbalStateData().getError_status();
        if (error_status == 4) {
            FragmentActivity fragmentActivity = this.activity;
            ToastUtil.toast(fragmentActivity, fragmentActivity.getString(R.string.warning_the_gimbal_is_stuck_briefly_tips));
            return true;
        }
        if (error_status == 5) {
            FragmentActivity fragmentActivity2 = this.activity;
            ToastUtil.toast(fragmentActivity2, fragmentActivity2.getString(R.string.warning_flight_interface_the_gimbal_motor_is_overloaded_tips));
            return true;
        }
        if (error_status == 1 || error_status == 2) {
            FragmentActivity fragmentActivity3 = this.activity;
            ToastUtil.toast(fragmentActivity3, fragmentActivity3.getString(R.string.txt_error_gimbal_error));
            return true;
        }
        if (error_status == 3 && FlightRevData.get().getFlightRevStateData().isUnLock()) {
            FragmentActivity fragmentActivity4 = this.activity;
            ToastUtil.toast(fragmentActivity4, fragmentActivity4.getString(R.string.txt_error_flighting_unavailable));
            return true;
        }
        if (!FlightRevData.get().getFlightRevStateData().isUnLock()) {
            return false;
        }
        FragmentActivity fragmentActivity5 = this.activity;
        ToastUtil.toast(fragmentActivity5, fragmentActivity5.getString(R.string.txt_error_flighting_unavailable));
        return true;
    }

    public void setCalibrationResultResourceId(int i) {
        if (this.calibrationResultResId.get() != i) {
            this.calibrationResultResId.set(i);
        }
    }

    private void sendSetting() {
        DDLog.e("\u53d1\u9001\u4e91\u53f0\u6821\u51c6\u6307\u4ee42");
        if (FlightRevData.get().getGimbalSettingData().isInit()) {
            FlightRevGimbalSettingData gimbalSettingData = FlightRevData.get().getGimbalSettingData();
            FlightSendData.get().getSendGimbalSettingData().init(gimbalSettingData.getPitchControl(), (short) gimbalSettingData.getPitchSpeed(), gimbalSettingData.isStableMode(), gimbalSettingData.getFpvSmooth(), 1, gimbalSettingData.getTuningRoll(), gimbalSettingData.getTuningYaw(), gimbalSettingData.getGimbalReset());
            DDLog.e("\u53d1\u9001\u4e91\u53f0\u6821\u51c6\u6307\u4ee43");
            DataManager.getInstance().sendGimbalSettingData();
        }
    }

    public void update(FlightRevGimbalSettingData flightRevGimbalSettingData) {
        if (this.isStopRevData) {
            return;
        }
        if (flightRevGimbalSettingData.getGimbalCalibration() == 1) {
            setViewVisible(false, false, true, false);
            return;
        }
        if (flightRevGimbalSettingData.getGimbalCalibration() == 3) {
            setViewVisible(false, false, false, true);
            this.resultStr.set(this.activity.getString(R.string.calibration_successful_wait_reboot));
            setCalibrationResultResourceId(R.mipmap.img_gimbal_calibration_success);
            this.calibrateResult.setValue(1);
            return;
        }
        if (flightRevGimbalSettingData.getGimbalCalibration() == 4) {
            setViewVisible(false, true, false, true);
            this.resultStr.set(this.activity.getString(R.string.calibration_failed));
            setCalibrationResultResourceId(R.mipmap.img_gimbal_calibration_fail);
            this.startBtnStr.set(this.activity.getString(R.string.gimbral_calibration_retry));
            this.calibrateResult.setValue(2);
        }
    }

    public void setViewVisible(boolean z, boolean z2, boolean z3, boolean z4) {
        if (this.stepOneVisible.get() != z) {
            this.stepOneVisible.set(z);
        }
        if (this.stepTwoVisible.get() != z3) {
            this.stepTwoVisible.set(z3);
            if (z3) {
                this.binding.loadingView.showProgress();
                this.binding.btnClose.setClickable(false);
                this.binding.btnClose.setAlpha(0.3f);
                FlightConfig.isSettingCalibration = true;
            }
        }
        if (this.stepThreeVisible.get() != z4) {
            this.stepThreeVisible.set(z4);
            if (z4) {
                this.binding.loadingView.hideProgress();
                this.binding.btnClose.setClickable(true);
                this.binding.btnClose.setAlpha(1.0f);
                FlightConfig.isSettingCalibration = false;
            }
        }
        if (this.startBtnVisible.get() != z2) {
            this.startBtnVisible.set(z2);
        }
    }

    public void resetUI(boolean z) {
        this.isStopRevData = z;
        setViewVisible(true, true, false, false);
        this.titleStr.set(this.activity.getString(R.string.setting_calibration_gimbal));
        this.resultStr.set(this.activity.getString(R.string.calibration_successful_wait_reboot));
        this.startBtnStr.set(this.activity.getString(R.string.compass_start_calibration));
    }
}