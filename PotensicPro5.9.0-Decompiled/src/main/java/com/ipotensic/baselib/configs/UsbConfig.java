package com.ipotensic.baselib.configs;

import com.ipotensic.baselib.enums.FlightCmdID2021;
import com.ipotensic.baselib.enums.FlightCmdID2022;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes2.dex */
public class UsbConfig {
    public static final byte REV_BATTERY_CODE = 1;
    public static final byte REV_CALIBRATION_FEEDBACK_CODE = 18;
    public static final byte REV_CALIBRATION_RESULT = 17;
    public static final byte REV_CTRL_DATA_CODE = 20;
    public static final byte REV_FLIGHT_CONNECT_STATE = 21;
    public static final byte REV_FLIGHT_CTRL_LOG = 12;
    public static final byte REV_FLIGHT_CTRL_TO_APP_NORMAL = 27;
    public static final byte REV_FLIGHT_GENERAL_CODE = 13;
    public static final byte REV_FLIGHT_INFO = 0;
    public static final byte REV_FLIGHT_SETTING = 3;
    public static final byte REV_FLIGHT_STATE = 2;
    public static final byte REV_FLIGHT_VERSION = 6;
    public static final byte REV_FPV_CONNECT_STATE_CODE = 21;
    public static final byte REV_FPV_INFO = 10;
    public static final byte REV_GEO_TEST_DATA = 8;
    public static final byte REV_GIMBAL_SETTING = 26;
    public static final byte REV_GIMBAL_STATE = 23;
    public static final byte REV_GPS_TEST_DATA = 11;
    public static final byte REV_HOME_CODE = 5;
    public static final byte REV_MAG_CALIBRATION_RESULT = 28;
    public static final byte REV_MINI_PAIR_DATA = 24;
    public static final byte REV_PTZ_FEEDBACK_CODE = 19;
    public static final byte REV_REMOTER_BATTERY_CODE = 49;
    public static final byte REV_REMOTER_CALIBRATION_CODE = 50;
    public static final byte REV_REMOTER_MUTE_CODE = 52;
    public static final byte REV_REMOTER_STATE = 51;
    public static final byte REV_REMOTE_CTRL_INFO_CODE = 48;
    public static final byte REV_RETURN_ALTITUDE_CODE = 22;
    public static final byte REV_RETURN_HOVER_CODE = 4;
    public static final byte REV_TEST_DATA = 4;
    public static final byte SEND_FUNCTION_CODE_FLIGHT_CONTROL = 31;
    public static final byte SEND_FUNCTION_CODE_REMOTE_CONTROL = 126;
    public static final byte SEND_MSG_ID_CALIBRATION = 18;
    public static final byte SEND_MSG_ID_CALIBRATION_FEEDBACK = 23;
    public static final byte SEND_MSG_ID_CALIBRATION_RESULT = 17;
    public static final byte SEND_MSG_ID_CTRL = 20;
    public static final byte SEND_MSG_ID_ENTER_QUIT_CALIBRATION = 24;
    public static final byte SEND_MSG_ID_FOUR_AXIS = 1;
    public static final byte SEND_MSG_ID_GENERAL = 27;
    public static final byte SEND_MSG_ID_GIMBAL_SETTING = 26;
    public static final byte SEND_MSG_ID_GPS = 0;
    public static final byte SEND_MSG_ID_HOME_REV = 5;
    public static final byte SEND_MSG_ID_MAG_CALIBRATION_RESULT = 28;
    public static final byte SEND_MSG_ID_MINI_REPAIR = 24;
    public static final byte SEND_MSG_ID_PTZ = 19;
    public static final byte SEND_MSG_ID_REPLY_TAKE_OFF = 21;
    public static final byte SEND_MSG_ID_RETURN_ALTITUDE = 22;
    public static final byte SEND_MSG_ID_RETURN_HOVER = 4;
    public static final byte UPGRADE_CMD = 9;
    public static final byte UPGRADE_FROM_DEVICE_ANDROID = 3;
    public static final byte UPGRADE_FROM_DEVICE_IOS = 2;
    public static final byte UPGRADE_TO_BATTERY = 23;
    public static final byte UPGRADE_TO_FLIGHT_CTRL = 16;
    public static final byte UPGRADE_TO_GIMBAL = 20;
    public static final byte UPGRADE_TO_REMOTER = 17;
    public static final byte USB_FPV_LOG_END = 13;
    public static final byte USB_FPV_LOG_RECEIVE = 23;
    public static final byte USB_FPV_LOG_REQUEST = 22;
    public static byte USB_TYPE_APP_TO_CAMERA = 17;
    public static byte USB_TYPE_APP_TO_FLIGHT = 16;
    public static byte USB_TYPE_APP_TO_FPV = 18;
    public static byte USB_TYPE_APP_TO_REMOTER = 19;
    public static byte USB_TYPE_CAMERA_TO_APP = 2;
    public static byte USB_TYPE_FLIGHT_TO_APP = 32;
    public static byte USB_TYPE_FPV_TO_APP = 48;
    public static byte USB_TYPE_LIVE_VIEW = 1;
    public static byte USB_TYPE_LIVE_VIEW_NEW = 4;
    public static byte USB_TYPE_REMOTER_TO_APP = 64;
    public static boolean isInit = false;
    public static boolean isNewFC = false;
    public static boolean isUsbConnected = false;
    public static final byte[] SEND_HEAD = {-1, -3};
    public static final byte[] REV_HEAD = {-1, -2};

    public static short getMsgId(byte[] bArr, int i) {
        return isNewFC ? ParseUtil.getSignedShortFromByteArr(bArr, i + 4) : bArr[r2];
    }

    public static int getPayloadIndex(int i) {
        return isNewFC ? i + 6 : i + 5;
    }

    public static void initCmdID(byte b) {
        boolean z;
        FlightCmdID2021[] values = FlightCmdID2021.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                z = false;
                break;
            } else {
                if (values[i].value == b) {
                    z = true;
                    break;
                }
                i++;
            }
        }
        if (z) {
            isNewFC = false;
            USB_TYPE_LIVE_VIEW = FlightCmdID2021.USB_TYPE_LIVE_VIEW.value;
            USB_TYPE_CAMERA_TO_APP = FlightCmdID2021.USB_TYPE_CAMERA_TO_APP.value;
            USB_TYPE_LIVE_VIEW_NEW = FlightCmdID2021.USB_TYPE_LIVE_VIEW_NEW.value;
            USB_TYPE_APP_TO_FLIGHT = FlightCmdID2021.USB_TYPE_APP_TO_FLIGHT.value;
            USB_TYPE_APP_TO_CAMERA = FlightCmdID2021.USB_TYPE_APP_TO_CAMERA.value;
            USB_TYPE_APP_TO_FPV = FlightCmdID2021.USB_TYPE_APP_TO_FPV.value;
            USB_TYPE_APP_TO_REMOTER = FlightCmdID2021.USB_TYPE_APP_TO_REMOTER.value;
            USB_TYPE_FLIGHT_TO_APP = FlightCmdID2021.USB_TYPE_FLIGHT_TO_APP.value;
            USB_TYPE_FPV_TO_APP = FlightCmdID2021.USB_TYPE_FPV_TO_APP.value;
            USB_TYPE_REMOTER_TO_APP = FlightCmdID2021.USB_TYPE_REMOTER_TO_APP.value;
        } else {
            isNewFC = true;
            USB_TYPE_CAMERA_TO_APP = FlightCmdID2022.USB_TYPE_CAMERA_TO_APP.value;
            USB_TYPE_LIVE_VIEW_NEW = FlightCmdID2022.USB_TYPE_LIVE_VIEW_NEW.value;
            USB_TYPE_APP_TO_FLIGHT = FlightCmdID2022.USB_TYPE_APP_TO_FLIGHT.value;
            USB_TYPE_APP_TO_CAMERA = FlightCmdID2022.USB_TYPE_APP_TO_CAMERA.value;
            USB_TYPE_APP_TO_FPV = FlightCmdID2022.USB_TYPE_APP_TO_FPV.value;
            USB_TYPE_APP_TO_REMOTER = FlightCmdID2022.USB_TYPE_APP_TO_REMOTER.value;
            USB_TYPE_FLIGHT_TO_APP = FlightCmdID2022.USB_TYPE_FLIGHT_TO_APP.value;
            USB_TYPE_FPV_TO_APP = FlightCmdID2022.USB_TYPE_FPV_TO_APP.value;
            USB_TYPE_REMOTER_TO_APP = FlightCmdID2022.USB_TYPE_REMOTER_TO_APP.value;
        }
        isInit = true;
    }
}
