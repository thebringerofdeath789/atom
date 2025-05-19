package com.logan.flight.calibration;

import com.logan.flight.data.recv.FlightRevCalResultData;
import com.logan.flight.data.recv.FlightRevFlightCtrlToAppNormal;
import com.logan.flight.data.recv.FlightRevGeoTestData;
import com.logan.flight.data.recv.FlightRevMagCalibrationResultData;

/* loaded from: classes.dex */
public interface IMagCalibrationHelper {
    void calibration(FlightRevGeoTestData flightRevGeoTestData);

    boolean isStart();

    void release();

    void revData(FlightRevCalResultData flightRevCalResultData);

    void revData(FlightRevFlightCtrlToAppNormal flightRevFlightCtrlToAppNormal);

    void revData(FlightRevMagCalibrationResultData flightRevMagCalibrationResultData);

    void setCalibrationResultListener(OnCalibrationResultListener onCalibrationResultListener);

    void start();
}
