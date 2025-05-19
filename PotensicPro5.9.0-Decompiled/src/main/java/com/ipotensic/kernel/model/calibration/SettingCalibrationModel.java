package com.ipotensic.kernel.model.calibration;

import androidx.fragment.app.FragmentActivity;

/* loaded from: classes2.dex */
public class SettingCalibrationModel {
    private FragmentActivity activity;
    private OnCalibrationListener calibrationListener;

    public interface OnCalibrationListener {
        void onPairClick();
    }

    public SettingCalibrationModel(FragmentActivity fragmentActivity, OnCalibrationListener onCalibrationListener) {
        this.calibrationListener = onCalibrationListener;
        this.activity = fragmentActivity;
    }
}
