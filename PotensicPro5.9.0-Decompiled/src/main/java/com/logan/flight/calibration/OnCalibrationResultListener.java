package com.logan.flight.calibration;

import com.logan.flight.utils.MagCalibrationResult;

/* loaded from: classes.dex */
public interface OnCalibrationResultListener {
    void onHorizontalCalibration();

    void onRelease();

    void onRequestTimeout();

    void onResultFailed(MagCalibrationResult magCalibrationResult);

    void onResultSuccess(MagCalibrationResult magCalibrationResult);

    void onResultTimeout(MagCalibrationResult magCalibrationResult);

    void onVerticalCalibration();
}
