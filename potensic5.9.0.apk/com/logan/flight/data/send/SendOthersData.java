package com.logan.flight.data.send;

import com.logan.flight.FlightConfig;

/* loaded from: classes.dex */
public class SendOthersData {
    public static final byte FUNC_ID_FLIGHT_OUTPUT = 30;
    public static final byte FUNC_ID_REMOTER_CALIBRATION = 113;
    public static final byte FUNC_ID_REMOTER_MUTE_DATA = 115;
    public static final byte FUNC_ID_REMOTER_OUTPUT = 125;
    public static final byte FUNC_ID_REMOTER_ROCKER_DATA = 114;
    public static final byte FUNC_ID_SYNC_FLIGHT_SETTING = 8;
    public static final byte FUNC_ID_SYNC_FPV_SETTING = 10;
    public static final byte FUNC_ID_SYNC_REMOTER_SETTING = 112;
    public static final byte P1_FACTORY_TEST_FUNCTION_CODE = 16;
    public static final byte P1_PRO_TEST_FUNCTION_CODE = 17;
    public static final byte P1_SELF_TEST_RESTORE = 7;

    public static byte[] getSettingInfoBytes() {
        return UsbPayloadWrapper.wrap((short) 8, new byte[]{FlightConfig.P1_PRO_RC_2, FlightConfig.P3_SE_V0});
    }

    public static byte[] getRemoterInfoBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 112, new byte[]{FlightConfig.P1_PRO_RC_2, FlightConfig.P3_SE_V0});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getFpvInfoBytes() {
        return UsbPayloadWrapper.wrap((short) 10, new byte[0]);
    }

    public static byte[] getCloseRemoterOutputBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 125, new byte[]{17, 17});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getOpenRemoterOutputBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 125, new byte[]{34, 34});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getCloseFlightOutputBytes() {
        return UsbPayloadWrapper.wrap((short) 30, new byte[]{17, 17});
    }

    public static byte[] getOpenFlightOutputBytes() {
        return UsbPayloadWrapper.wrap((short) 30, new byte[]{34, 34});
    }

    public static byte[] getOpenRemoterCalibrationBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 113, new byte[]{FlightConfig.P1_SELF});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getCloseRemoterCalibrationBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 113, new byte[]{-16});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getRemoterRockerDataBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 114, new byte[]{0});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getOpenRemoterMuteBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 115, new byte[]{1});
        wrap[1] = -2;
        return wrap;
    }

    public static byte[] getCloseRemoterMuteBytes() {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 115, new byte[]{0});
        wrap[1] = -2;
        return wrap;
    }
}