package com.logan.usb;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.Event;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.VisionError;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.netty.ParseUtil;
import com.ipotensic.baselib.utils.FormatUtil;
import com.ipotensic.baselib.utils.SPHelper;
import com.ipotensic.baselib.utils.UnitUtil;
import com.logan.camera.CameraConfig;
import com.logan.camera.CameraLogRecorder;
import com.logan.camera.IRequestClient;
import com.logan.camera.JsonParser;
import com.logan.camera.data.CameraInfoData;
import com.logan.camera.data.CameraLogData;
import com.logan.camera.data.HardwareStateUploadData;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.TimedPhotoUploadData;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.listeners.ICheckUpgradeCallback;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.camera.listeners.IStartUpgradeCallback;
import com.logan.flight.data.send.UsbPayloadWrapper;
import com.logan.upgrade.big.BigPackageHelper;
import com.logan.usb.gallery.UsbGalleryManager;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class UsbCameraHandler implements IRequestClient {
    public static final byte CARD_STATE_LOW_SPEED = 6;
    public static final byte CARD_STATE_NEED_FORMAT = 4;
    public static final byte CARD_STATE_NOT_ENOUGH = 5;
    public static final byte CARD_STATE_NOT_FIND_SD_CARD = 2;
    public static final byte CARD_STATE_NO_CARD = 0;
    public static final byte CARD_STATE_OK = 1;
    public static final byte CARD_STATE_ONLY_READ_SD_CARD = 3;
    public static final byte CARD_STATE_SPEED_NOT_STABLE = 8;
    public static final byte CARD_STATE_SYSTEM_ERROR = 7;
    private static final byte EV_MINUS_0 = 4;
    private static final byte EV_MINUS_0_5 = 3;
    private static final byte EV_MINUS_1_0 = 2;
    private static final byte EV_MINUS_1_5 = 1;
    private static final byte EV_MINUS_2_0 = 0;
    private static final byte EV_POSITIVE_0_5 = 5;
    private static final byte EV_POSITIVE_1_0 = 6;
    private static final byte EV_POSITIVE_1_5 = 7;
    private static final byte EV_POSITIVE_2_0 = 8;
    public static final byte FUNC_CODE_FROM_CAMERA_CHECK_MD5 = 36;
    public static final byte FUNC_CODE_FROM_CAMERA_NORMAL = 32;
    public static final byte FUNC_CODE_FROM_CAMERA_QUERY_VERSION = 33;
    public static final byte FUNC_CODE_FROM_CAMERA_REQUEST_UPGRADE = 34;
    public static final byte FUNC_CODE_FROM_CAMERA_UPGRADE_PROGRESS = 37;
    public static final byte FUNC_CODE_FROM_CAMERA_UPLOAD_FILE = 35;
    public static final byte FUN_CODE_FROM_CAMERA_UPGRADE_SUCCESS = 38;
    private static final byte MODE_RECORD = 0;
    private static final byte MODE_TAKE_PHOTO = 1;
    private static final byte MSG_ID_CAMERA_LOG = 57;
    public static final byte MSG_ID_CAM_HIGH_TEMP = 35;
    private static final byte MSG_ID_CARD_STATE = 22;
    public static final byte MSG_ID_DELETE_FILE = 29;
    public static final byte MSG_ID_DOWNLOAD_FILE = 27;
    public static final byte MSG_ID_ENTER_GALLERY = 33;
    public static final byte MSG_ID_EXECUTE_SHORT_VIDEO = 46;
    private static final byte MSG_ID_FORMAT_SD_CARD = 4;
    private static final byte MSG_ID_GET_ALL_PARAMS = 17;
    private static final byte MSG_ID_GET_CAMERA_STATE = 2;
    private static final byte MSG_ID_GET_CURRENT_RECORD_RESOLUTION = 10;
    private static final byte MSG_ID_GET_CURRENT_TAKE_PHOTO_RESOLUTION = 12;
    private static final byte MSG_ID_GET_DEVICE_INFO = 5;
    private static final byte MSG_ID_GET_EV = 16;
    private static final byte MSG_ID_GET_EXPOSURE_INFO = 54;
    public static final byte MSG_ID_GET_FILES_LENGTH = 32;
    public static final byte MSG_ID_GET_FILE_DETAIL = 26;
    public static final byte MSG_ID_GET_FILE_LIST = 25;
    public static final byte MSG_ID_GET_FILE_NUM = 24;
    public static final byte MSG_ID_GET_FILE_THUMBNAIL = 28;
    private static final byte MSG_ID_GET_MANUAL_MODE_INFO = 52;
    public static final byte MSG_ID_GET_OSD_STATE = 39;
    public static final byte MSG_ID_GET_PHOTO_FORMAT = 37;
    private static final byte MSG_ID_GET_PHOTO_GPS = 60;
    private static final byte MSG_ID_GET_PHOTO_MODE = 64;
    public static final byte MSG_ID_GET_REMAIN_CAPTURE_SIZE = 40;
    private static final byte MSG_ID_GET_SUPPORT_EV_PARAMS = 14;
    private static final byte MSG_ID_GET_SUPPORT_RECORD_RESOLUTIONS = 8;
    private static final byte MSG_ID_GET_SUPPORT_TAKE_PHOTO_RESOLUTIONS = 9;
    private static final byte MSG_ID_GET_ZOOM_RATIO = 63;
    public static final byte MSG_ID_INTERRUPT_DOWNLOAD = 30;
    public static final byte MSG_ID_INTERRUPT_GET_THUMBNAIL = 31;
    private static final byte MSG_ID_PHOTO_MODE_UPLOAD = 65;
    public static final byte MSG_ID_QUIT_GALLERY = 34;
    public static final byte MSG_ID_RECEIVE_VERSION_BIG_PACKAGE = 50;
    private static final byte MSG_ID_RECORD = 0;
    private static final byte MSG_ID_SD_INFO = 23;
    private static final byte MSG_ID_SET_CAMERA_MODE = 3;
    private static final byte MSG_ID_SET_CAMERA_TIME = 7;
    private static final byte MSG_ID_SET_DEBUG_CMD = -15;
    private static final byte MSG_ID_SET_EV = 15;
    private static final byte MSG_ID_SET_MANUAL_MODE_INFO = 53;
    public static final byte MSG_ID_SET_OSD_STATE = 38;
    public static final byte MSG_ID_SET_PHOTO_FORMAT = 36;
    private static final byte MSG_ID_SET_PHOTO_GPS = 59;
    private static final byte MSG_ID_SET_PHOTO_MODE = 61;
    private static final byte MSG_ID_SET_RECORD_RESOLUTION = 11;
    private static final byte MSG_ID_SET_SEGMENT = 19;
    private static final byte MSG_ID_SET_TAKE_PHOTO_RESOLUTION = 13;
    public static final byte MSG_ID_SET_TARGET = 45;
    public static final byte MSG_ID_SET_TRACK_TARGET = 43;
    private static final byte MSG_ID_SET_ZOOM_RATIO = 62;
    private static final byte MSG_ID_SHOW_DEBUG_MSG = -16;
    private static final byte MSG_ID_STATUS_UPLOAD = -14;
    private static final byte MSG_ID_SWITCH_CAPTURE_MODE_PRE_NOTIFY = 58;
    private static final byte MSG_ID_TAKE_PHOTO = 1;
    public static final byte MSG_ID_TAKE_PHOTO_END = 42;
    public static final byte MSG_ID_TRACK_TARGET_RESULT = 44;
    public static final byte MSG_ID_UPGRADE_BIG_PACKAGE = 49;
    public static final byte MSG_ID_UPGRADE_HANDSHAKE_STATE = 68;
    public static final byte MSG_ID_UPLOAD_BIG_PACKAGE = 48;
    public static final byte MSG_ID_VISION_ERROR = 47;
    private static final byte RECORD_1080P60 = 3;
    private static final byte RECORD_2K30 = 2;
    private static final byte RECORD_2_7K30 = 1;
    private static final byte RECORD_4K30 = 0;
    private static final byte RECORD_720P120 = 4;
    private static final byte RECORD_START = 1;
    private static final byte RECORD_STOP = 0;
    private static final byte RESULT_CODE_CAMERA_UPGRADING = 22;
    private static final byte RESULT_CODE_CHECK_SUM_ERROR = 13;
    public static final byte RESULT_CODE_CURRENT_MODE_NOT_ALLOWED = 8;
    public static final byte RESULT_CODE_DEVICE_BUSY = 3;
    public static final byte RESULT_CODE_FILE_MD5_ERROR = 24;
    public static final byte RESULT_CODE_FILE_OFFSET_ERROR = 23;
    public static final byte RESULT_CODE_FILE_SYSTEM_ERROR = 12;
    private static final byte RESULT_CODE_FIRMWARE_MISMATCH = 14;
    public static final byte RESULT_CODE_ID_NOT_SUPPORT = 1;
    public static final byte RESULT_CODE_INVALID_OPTION = 7;
    public static final byte RESULT_CODE_NEED_SYNC_STATE_ERROR = 37;
    public static final byte RESULT_CODE_NOT_ENOUGH_MEMORY = 11;
    public static final byte RESULT_CODE_NO_SD_CARD = 5;
    public static final byte RESULT_CODE_PARAMS_INVALID = 2;
    public static final byte RESULT_CODE_RECORD_ALREADY_START = 9;
    public static final byte RESULT_CODE_SD_CARD_NOT_ENOUGH = 6;
    private static final byte RESULT_CODE_SD_LOW_SPEED = 15;
    public static final byte RESULT_CODE_SD_NEED_FORMAT = 10;
    private static final byte RESULT_CODE_SD_OPERATION_TIMEOUT = 18;
    private static final byte RESULT_CODE_SD_READ_ONLY = 17;
    private static final byte RESULT_CODE_SD_UNRECOGNIZED = 16;
    public static final byte RESULT_CODE_SUCCESS = 0;
    public static final byte RESULT_CODE_UNKNOWN_ERROR = 4;
    private static final byte STATE_FREE_TIME = 0;
    private static final byte STATE_RECORDING = 1;
    private static final String TAG = "UsbCameraHandler";
    private static final byte TAKE_PHOTO_12M = 1;
    private static final byte TAKE_PHOTO_16M = 0;
    private static final byte TAKE_PHOTO_8M = 2;
    private static volatile UsbCameraHandler instance;
    private boolean isSetRaw = false;
    private boolean isSpeedNotStable = false;

    private byte getEvByteFromSetValue(double d) {
        return (byte) ((d * 2.0d) + 4.0d);
    }

    @Override // com.logan.camera.IRequestClient
    public void checkUpgrade(long j, String str, ICheckUpgradeCallback iCheckUpgradeCallback) {
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraTime() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getMediaInfo(String str, IMediaInfoCallback iMediaInfoCallback) {
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoFormat() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoOSD() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getWifiSignal() {
    }

    @Override // com.logan.camera.IRequestClient
    public void resetCamera() {
    }

    @Override // com.logan.camera.IRequestClient
    public void startUpgrade(String str, String str2, IStartUpgradeCallback iStartUpgradeCallback) {
    }

    private UsbCameraHandler() {
    }

    public static UsbCameraHandler getInstance() {
        if (instance == null) {
            synchronized (UsbCameraHandler.class) {
                if (instance == null) {
                    UsbCameraHandler usbCameraHandler = new UsbCameraHandler();
                    instance = usbCameraHandler;
                    return usbCameraHandler;
                }
            }
        }
        return instance;
    }

    @Override // com.logan.camera.IRequestClient
    public void startRecord() {
        send(new byte[]{0, 1});
    }

    @Override // com.logan.camera.IRequestClient
    public void stopRecord() {
        send(new byte[]{0, 0});
    }

    @Override // com.logan.camera.IRequestClient
    public void takePhoto() {
        send(new byte[]{1});
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraStatus() {
        send(new byte[]{2});
    }

    @Override // com.logan.camera.IRequestClient
    public void setCameraMode(CaptureMode captureMode) {
        DDLog.m1684e("发送 切换模式:" + captureMode);
        byte[] bArr = new byte[2];
        bArr[0] = 3;
        bArr[1] = (byte) (captureMode != CaptureMode.MODE_REC ? 1 : 0);
        send(bArr);
    }

    @Override // com.logan.camera.IRequestClient
    public void formatSdCard() {
        send(new byte[]{4});
    }

    @Override // com.logan.camera.IRequestClient
    public void getConfigMenu() {
        DDLog.m1684e("发送getConfigMenu");
        send(new byte[]{17});
    }

    @Override // com.logan.camera.IRequestClient
    public void setRecordEv(double d) {
        send(new byte[]{15, 0, getEvByteFromSetValue(d)});
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoEv(double d) {
        send(new byte[]{15, 1, getEvByteFromSetValue(d)});
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraEv(int i) {
        DDLog.m1684e("发送EV mode:" + i);
        send(new byte[]{16, (byte) i});
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordEv() {
        send(new byte[]{14, 0});
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoEv() {
        send(new byte[]{14, 1});
    }

    @Override // com.logan.camera.IRequestClient
    public void getSdCardStatus() {
        send(new byte[]{23});
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordingSdSpace() {
        send(new byte[]{23});
    }

    @Override // com.logan.camera.IRequestClient
    public void setRaw(boolean z) {
        this.isSetRaw = z;
        DDLog.m1684e("设置raw：" + z);
        send(new byte[]{36, z ? (byte) 1 : (byte) 0});
    }

    @Override // com.logan.camera.IRequestClient
    public void setPhotoOSD(boolean z) {
        DDLog.m1684e("设置OSD：" + z);
        send(new byte[]{38, 2, z ? (byte) 1 : (byte) 0});
    }

    @Override // com.logan.camera.IRequestClient
    public void getRemainCaptureSize() {
        DDLog.m1684e("获取剩余拍照张数/录像时长...");
        send(new byte[]{MSG_ID_GET_REMAIN_CAPTURE_SIZE});
    }

    @Override // com.logan.camera.IRequestClient
    public void setTrackTarget(boolean z) {
        DDLog.m1684e("发送一键短片跟踪指令 isTrack:" + z);
        send(new byte[]{43, z ? (byte) 1 : (byte) 0});
    }

    @Override // com.logan.camera.IRequestClient
    public void selectTarget(TrackTarget.Box box) {
        byte[] bytes = box.toJson().getBytes();
        DDLog.m1684e("设置目标选择：" + box.toJson());
        send(ParseUtil.concatAll(new byte[]{MSG_ID_SET_TARGET}, bytes));
    }

    @Override // com.logan.camera.IRequestClient
    public void executeShortVideo(VisionExecuteType visionExecuteType, int i, int i2) {
        byte[] bArr = {MSG_ID_EXECUTE_SHORT_VIDEO, (byte) visionExecuteType.value, (byte) i, (byte) i2};
        DDLog.m1684e("发送执行或退出 一键短片指令:" + ParseUtil.byteToHexString(bArr));
        send(bArr);
    }

    @Override // com.logan.camera.IRequestClient
    public void getDeviceInfo() {
        send(new byte[]{5});
    }

    @Override // com.logan.camera.IRequestClient
    public void setCameraTime() {
        FormatUtil.DateTime curTime3 = FormatUtil.getCurTime3();
        byte[] bArr = {7, (byte) (curTime3.year - 2000), (byte) curTime3.month, (byte) curTime3.day, (byte) curTime3.hour, (byte) curTime3.min, (byte) curTime3.second};
        DDLog.m1684e("设置相机时间:" + ParseUtil.byteToHexString(bArr));
        send(bArr);
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordSupportSize() {
        send(new byte[]{8});
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoSupportSize() {
        send(new byte[]{9});
    }

    @Override // com.logan.camera.IRequestClient
    public void getCurRecordSize() {
        send(new byte[]{10});
    }

    @Override // com.logan.camera.IRequestClient
    public void getCurTakePhotoSize() {
        send(new byte[]{12});
    }

    @Override // com.logan.camera.IRequestClient
    public void setRecordSize(String str, int i) {
        DDLog.m1684e("设置录像分辨率 index=" + i);
        send(new byte[]{11, (byte) i});
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoSize(String str, int i) {
        send(new byte[]{13, (byte) i});
    }

    @Override // com.logan.camera.IRequestClient
    public void setVideoSegment(String str, int i) {
        send(new byte[]{19, (byte) i});
    }

    @Override // com.logan.camera.IRequestClient
    public void getManualModeInfo() {
        send((byte) 52);
    }

    @Override // com.logan.camera.IRequestClient
    public void getManualExposureValue() {
        send(MSG_ID_GET_EXPOSURE_INFO);
    }

    @Override // com.logan.camera.IRequestClient
    public void setManualModelInfo(ManualModeInfo manualModeInfo) {
        byte b = manualModeInfo.isManualMode ? (byte) 1 : (byte) 0;
        byte[] short2ByteArrSmall = ParseUtil.short2ByteArrSmall((short) manualModeInfo.ssUp);
        byte[] short2ByteArrSmall2 = ParseUtil.short2ByteArrSmall((short) manualModeInfo.ssDown);
        byte[] short2ByteArrSmall3 = ParseUtil.short2ByteArrSmall((short) manualModeInfo.isoValue);
        byte b2 = manualModeInfo.isMwbMode ? (byte) 1 : (byte) 0;
        byte[] short2ByteArrSmall4 = ParseUtil.short2ByteArrSmall((short) manualModeInfo.wbValue);
        ArrayList arrayList = new ArrayList();
        arrayList.add(Byte.valueOf(MSG_ID_SET_MANUAL_MODE_INFO));
        arrayList.add(Byte.valueOf(b));
        listAddArray(arrayList, short2ByteArrSmall);
        listAddArray(arrayList, short2ByteArrSmall2);
        listAddArray(arrayList, short2ByteArrSmall3);
        arrayList.add(Byte.valueOf(b2));
        listAddArray(arrayList, short2ByteArrSmall4);
        listAddArray(arrayList, new byte[21]);
        send(byteListToByteArray(arrayList));
    }

    @Override // com.logan.camera.IRequestClient
    public void setPhotoRecordGps(boolean z) {
        DDLog.m1684e("设置拍照gps：" + z);
        send(new byte[]{59, z ? (byte) 1 : (byte) 0});
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoRecordGps() {
        DDLog.m1684e("获取拍照gps");
        send(new byte[]{60});
    }

    @Override // com.logan.camera.IRequestClient
    public void setDebugCmd(byte b, byte[] bArr) {
        send(ParseUtil.concatAll(new byte[]{-15, b}, bArr));
    }

    @Override // com.logan.camera.IRequestClient
    public void setZoomRatio(float f) {
        int round = UnitUtil.round(f * 100.0f);
        byte[] bArr = new byte[5];
        bArr[0] = MSG_ID_SET_ZOOM_RATIO;
        ParseUtil.intSmallByteArr(round, bArr, 1);
        DDLog.m1684e("设置数码变焦倍数：" + round);
        send(bArr);
    }

    @Override // com.logan.camera.IRequestClient
    public void getZoomRatio() {
        DDLog.m1684e("获取数码变焦倍数");
        send(new byte[]{63});
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoMode(PhotoChildMode photoChildMode) {
        if (photoChildMode != null) {
            byte b = (byte) photoChildMode.childMode;
            byte[] short2ByteArrSmall = ParseUtil.short2ByteArrSmall((short) (photoChildMode.intervalTime * 1000));
            byte[] short2ByteArrSmall2 = ParseUtil.short2ByteArrSmall((short) photoChildMode.photoCount);
            byte[] bArr = new byte[16];
            bArr[0] = 61;
            bArr[1] = b;
            bArr[2] = short2ByteArrSmall[0];
            bArr[3] = short2ByteArrSmall[1];
            bArr[4] = short2ByteArrSmall2[0];
            bArr[5] = short2ByteArrSmall2[1];
            send(bArr);
            DDLog.m1684e("设置拍照子模式：" + photoChildMode.toString());
        }
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoMode() {
        DDLog.m1684e("获取拍照子模式");
        send(new byte[]{64});
    }

    private void listAddArray(List<Byte> list, byte[] bArr) {
        for (byte b : bArr) {
            list.add(Byte.valueOf(b));
        }
    }

    private byte[] byteListToByteArray(List<Byte> list) {
        byte[] bArr = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = list.get(i).byteValue();
        }
        return bArr;
    }

    public void onReceiveFromCamera(byte[] bArr, int i) {
        boolean z;
        int i2 = i + 2;
        if (bArr.length > i2) {
            if (UsbConfig.getMsgId(bArr, 0) == 32) {
                if (bArr[i] == 57) {
                    try {
                        CameraLogData cameraLogData = new CameraLogData(bArr, i);
                        CameraLogRecorder.get().writeLog(cameraLogData);
                        DDLog.m1684e("收到相机log:" + cameraLogData.toString());
                        return;
                    } catch (Exception e) {
                        DDLog.m1684e("接收相机log错误 ：" + e);
                        return;
                    }
                }
                int i3 = i + 1;
                try {
                } catch (Exception e2) {
                    DDLog.m1684e("解析出错:" + e2);
                }
                if (bArr[i3] != 0) {
                    DDLog.m1684e("相机数据 发生错误 ：" + ParseUtil.byteToHexString(bArr, 20));
                    parseResultError(bArr[i], bArr[i3], i, bArr);
                    return;
                }
                byte b = bArr[i];
                if (b == -16) {
                    int i4 = i + 3;
                    int i5 = bArr[i4];
                    if (bArr.length > i4 + i5) {
                        byte[] bArr2 = new byte[i5];
                        System.arraycopy(bArr, i + 4, bArr2, 0, i5);
                        String str = FormatUtil.getCurTime4() + " : " + new String(bArr2) + "\n";
                        DDLog.m1684e("相机调试信息:" + str);
                        EventDispatcher.get().sendEvent(EventID.EVENT_SHOW_CAMERA_DEBUG_INFO, str);
                        return;
                    }
                    return;
                }
                if (b == -14) {
                    HardwareStateUploadData hardwareStateUploadData = new HardwareStateUploadData();
                    hardwareStateUploadData.parseData(bArr, i);
                    if (hardwareStateUploadData.code != 0) {
                        DDLog.m1684e("相机硬件状态上报 " + hardwareStateUploadData);
                    }
                    EventDispatcher.get().sendEvent(EventID.EVENT_HARDWARE_STATE_UPLOAD, hardwareStateUploadData);
                    return;
                }
                if (b == 7) {
                    DDLog.m1684e("相机时间设置成功");
                    return;
                }
                if (b == 11) {
                    byte b2 = bArr[i2];
                    DDLog.m1684e("设置录像分辨率成功 index=" + ((int) b2));
                    CameraConfig.get().supportVideoSizes.setCurrentValueForUsb(b2);
                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_RECORD_SIZE_SUCCESS);
                    return;
                }
                if (b == 13) {
                    CameraConfig.get().supportPhotoSizes.setCurrentValueForUsb(bArr[i2]);
                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_TAKE_PHOTO_SIZE_SUCCESS);
                    return;
                }
                if (b == 19) {
                    byte b3 = bArr[i2];
                    DDLog.m1684e("设置录像分段成功 index:" + ((int) b3));
                    CameraConfig.get().supportSplitSizes.setCurrentValueForUsb(b3);
                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_VIDEO_SEGMENT_SUCCESS);
                    return;
                }
                if (b == 38) {
                    DDLog.m1684e("设置OSD：成功");
                    z = bArr[i2] == 1;
                    if (bArr[i + 3] == 1) {
                        CameraConfig.get().setPhotoOsdShow(z);
                        CameraConfig.get().setVideoOsdShow(z);
                    } else {
                        CameraConfig.get().setPhotoOsdShow(z);
                        CameraConfig.get().setVideoOsdShow(z);
                    }
                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_OSD_SUCCESS);
                    return;
                }
                if (b == 40) {
                    DDLog.m1684e("获取剩余拍照张数/录像时长：成功");
                    parseRemainCapture(ParseUtil.interceptBytes(bArr, i2, 3));
                    return;
                }
                if (b == 68) {
                    DDLog.m1684e("收到报告大包升级握手状态：" + ParseUtil.byteToHexString(bArr));
                    DDLog.m1684e("大包升级握手状态 data length：" + bArr.length + ", index：" + i);
                    int i6 = i + 3;
                    if (bArr.length > i6) {
                        String trim = new String(bArr, i2, bArr.length - i6, StandardCharsets.US_ASCII).trim();
                        DDLog.m1684e("大包升级握手状态 json: " + trim);
                        JsonParser.parseUpgradeHandshakeState(trim);
                        return;
                    }
                    return;
                }
                if (b == 0) {
                    if (bArr[i2] == 1) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_START_RECORD);
                        return;
                    } else {
                        if (bArr[i2] == 0) {
                            DDLog.m1684e("通知停止录像");
                            EventDispatcher.get().sendEvent(EventID.EVENT_STOP_RECORD);
                            return;
                        }
                        return;
                    }
                }
                if (b == 1) {
                    DDLog.m1684e("拍照成功");
                    EventDispatcher.get().sendEvent(EventID.EVENT_TAKE_PHOTO_SUCCESS);
                    return;
                }
                if (b == 2) {
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_CAMERA_STATE_SUCCESS, parseCameraState(bArr, i2));
                    return;
                }
                if (b == 3) {
                    CaptureMode captureMode = bArr[i2] == 0 ? CaptureMode.MODE_REC : CaptureMode.MODE_PHOTO;
                    CameraConfig.get().setCaptureMode(captureMode);
                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_CAPTURE_MODE_SUCCESS, captureMode);
                    return;
                }
                if (b == 4) {
                    parseCardState(bArr[i2], true);
                    return;
                }
                switch (b) {
                    case 15:
                        byte b4 = bArr[i + 3];
                        byte b5 = bArr[i2];
                        if (b4 == 0) {
                            CameraConfig.get().setCurRecordEvValueForUSB(b5);
                            EventDispatcher.get().sendEvent(EventID.EVENT_SET_RECORD_EV_SUCCESS);
                        } else if (b4 == 1) {
                            CameraConfig.get().setCurTakePhotoEvValueForUSB(b5);
                            EventDispatcher.get().sendEvent(EventID.EVENT_SET_TAKE_PHOTO_EV_SUCCESS);
                        }
                        DDLog.m1684e("设置EV成功 mode:" + ((int) b4));
                        return;
                    case 16:
                        byte b6 = bArr[i2];
                        if (CameraConfig.get().isPhotoMode()) {
                            CameraConfig.get().setCurTakePhotoEvValueForUSB(b6);
                        } else {
                            CameraConfig.get().setCurRecordEvValueForUSB(b6);
                        }
                        Event event = new Event(EventID.EVENT_GET_EV_SUCCESS);
                        event.arg1 = b6;
                        EventDispatcher.get().sendEvent(event);
                        DDLog.m1684e("获取EV成功 ev:" + ((int) b6));
                        return;
                    case 17:
                        ParseUtil.getUnsignedShortFromByteArr(bArr, 2);
                        CameraConfig.get().isGetConfigMenu = true;
                        parseAllParams(bArr, i);
                        EventDispatcher.get().sendEvent(EventID.EVENT_GET_CONFIG_MENU_SUCCESS);
                        DDLog.m1684e("config menu:" + CameraConfig.get().toString());
                        return;
                    default:
                        switch (b) {
                            case 22:
                                if (bArr[i2] == 0) {
                                    DDLog.m1684e("sd卡拔出");
                                    EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_PULL_OUT);
                                } else if (bArr[i2] == 1) {
                                    DDLog.m1684e("sd卡插入");
                                    EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_INSERT);
                                } else {
                                    byte b7 = bArr[i2];
                                }
                                parseCardState(bArr[i + 3], false);
                                return;
                            case 23:
                                int i7 = i + 8;
                                if (bArr.length > i7) {
                                    parseCardState(bArr[i2], false);
                                    byte[] bArr3 = {bArr[i + 3], bArr[i + 4], bArr[i + 5], 0};
                                    CameraConfig.get().setSdFreeSpace(ParseUtil.getIntFromByteArr(bArr3, 0));
                                    bArr3[0] = bArr[i + 6];
                                    bArr3[1] = bArr[i + 7];
                                    bArr3[2] = bArr[i7];
                                    bArr3[3] = 0;
                                    CameraConfig.get().setSdTotalSpace(ParseUtil.getIntFromByteArr(bArr3, 0));
                                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_SD_CARD_STATE_SUCCESS);
                                    return;
                                }
                                return;
                            case 24:
                            case 25:
                            case 26:
                            case 27:
                            case 28:
                            case 29:
                            case 30:
                            case 31:
                            case 32:
                            case 33:
                            case 34:
                                UsbGalleryManager.getInstance().onReceived(bArr);
                                return;
                            case 35:
                                int i8 = i + 4;
                                if (bArr.length >= i8) {
                                    int byteToDecimalInt = ParseUtil.byteToDecimalInt(bArr[i + 3]) - 127;
                                    Event event2 = new Event(EventID.EVENT_CAMERA_HIGH_TEMP);
                                    event2.arg1 = bArr[i2];
                                    event2.arg2 = byteToDecimalInt;
                                    if (bArr.length >= i + 5) {
                                        CameraConfig.get().setAllowCaptureInHighTemp(bArr[i8] == 0);
                                    }
                                    DDLog.m1684e("收到相机高温数据:" + ParseUtil.byteToHexString(bArr));
                                    EventDispatcher.get().sendEvent(event2);
                                    return;
                                }
                                return;
                            case 36:
                                DDLog.m1684e("设置raw：成功");
                                EventDispatcher.get().sendEvent(EventID.EVENT_SET_PHOTO_FORMAT_SUCCESS);
                                CameraConfig.get().setRaw(this.isSetRaw);
                                return;
                            default:
                                switch (b) {
                                    case 42:
                                        DDLog.m1684e("拍照结束");
                                        EventDispatcher.get().sendEvent(EventID.EVENT_TAKE_PHOTO_END);
                                        return;
                                    case 43:
                                        z = bArr[i2] == 1;
                                        DDLog.m1684e("视觉目标追踪:" + z);
                                        EventDispatcher.get().sendEvent(z ? EventID.EVENT_VISUAL_TARGET_TRACK_OPEN : EventID.EVENT_VISUAL_TARGET_TRACK_CLOSE);
                                        return;
                                    case 44:
                                        try {
                                            TrackTarget parseTargetTrack = JsonParser.parseTargetTrack(new String(bArr, i + 4, ParseUtil.getUnsignedShortFromByteArr(bArr, i2), StandardCharsets.US_ASCII));
                                            if (parseTargetTrack != null) {
                                                DDLog.m1684e("收到视觉数据:" + parseTargetTrack.isSelected());
                                                EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_TRACK_RESULT, parseTargetTrack);
                                                return;
                                            }
                                            return;
                                        } catch (Exception e3) {
                                            DDLog.m1684e("视觉目标截取报错:" + e3.getMessage());
                                            return;
                                        }
                                    case 45:
                                        DDLog.m1684e("收到视觉数据 是否跟踪到目标:" + (bArr[i2] == 1) + " ,  " + ParseUtil.byteToHexString(bArr));
                                        EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_TRACKING);
                                        return;
                                    case 46:
                                        DDLog.m1684e("收到视觉数据 是否执行一键短片:" + ParseUtil.byteToHexString(bArr));
                                        byte b8 = bArr[i3];
                                        if (bArr[i2] == 0) {
                                            DDLog.m1684e("收到视觉数据 是否执行一键短片:退出");
                                            EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_EXIT);
                                            return;
                                        } else {
                                            DDLog.m1684e("收到视觉数据 是否执行一键短片:执行");
                                            EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_EXECUTE);
                                            return;
                                        }
                                    default:
                                        switch (b) {
                                            case 48:
                                                DDLog.m1684e("大包上传文件");
                                                BigPackageHelper.get().onReceivedUploadFile(bArr, i);
                                                break;
                                            case 49:
                                                DDLog.m1684e("大包升级进度");
                                                BigPackageHelper.get().onReceivedUpgradeProgress(bArr, i);
                                                break;
                                            case 50:
                                                DDLog.m1684e("大包版本号：" + ParseUtil.byteToHexString(bArr));
                                                DDLog.m1684e("大包 index：" + i);
                                                int i9 = i + 27;
                                                if (bArr.length > i9) {
                                                    byte[] bArr4 = new byte[10];
                                                    System.arraycopy(bArr, i2, bArr4, 0, 10);
                                                    String trim2 = new String(bArr4, StandardCharsets.US_ASCII).trim();
                                                    SPHelper.getInstance().setBigPackageFlight(trim2);
                                                    byte[] bArr5 = new byte[15];
                                                    System.arraycopy(bArr, i + 12, bArr5, 0, 15);
                                                    String trim3 = new String(bArr5, StandardCharsets.US_ASCII).trim();
                                                    int byteToDecimalInt2 = ParseUtil.byteToDecimalInt(bArr[i9]);
                                                    Event event3 = new Event(EventID.MSG_BIG_PACKAGE_VERSION_INFO);
                                                    event3.obj = trim3;
                                                    event3.arg1 = byteToDecimalInt2;
                                                    DDLog.m1684e("大包 版本号product: " + trim2 + ", version: " + trim3 + ", 升级介质：" + byteToDecimalInt2);
                                                    EventDispatcher.get().sendEvent(event3);
                                                    break;
                                                }
                                                break;
                                            default:
                                                switch (b) {
                                                    case 52:
                                                        ManualModeInfo manualModeInfo = new ManualModeInfo(bArr, i);
                                                        DDLog.m1685e(TAG, manualModeInfo.toString());
                                                        CameraConfig.get().setManualModeInfo(manualModeInfo);
                                                        EventDispatcher.get().sendEvent(EventID.FLIGHT_RECEIVE_MANUAL_SETTING_INFO);
                                                        break;
                                                    case 53:
                                                        byte b9 = bArr[i3];
                                                        DDLog.m1684e("设置手动模式数据：" + ((int) b9));
                                                        EventDispatcher.get().sendEvent(EventID.FLIGHT_RECEIVE_MANUAL_SETTING_ACK, Boolean.valueOf(b9 == 0));
                                                        break;
                                                    case 54:
                                                        byte b10 = bArr[i2];
                                                        int unsignedShortFromByteArr = (ParseUtil.getUnsignedShortFromByteArr(bArr, i + 3) / 100) * 100;
                                                        if (!CameraConfig.get().getManualModeInfo().isMwbMode) {
                                                            CameraConfig.get().getManualModeInfo().wbValue = unsignedShortFromByteArr;
                                                        }
                                                        DDLog.m1685e(TAG, "自动模式曝光程度: " + ((int) b10) + " 色温值：" + unsignedShortFromByteArr);
                                                        Event event4 = new Event(EventID.FLIGHT_RECEIVE_MANUAL_SETTING_EXPOSURE);
                                                        event4.arg1 = b10;
                                                        EventDispatcher.get().sendEvent(event4);
                                                        break;
                                                    default:
                                                        switch (b) {
                                                            case 58:
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_CAMERA_SWITCH_MODE_NOTIFY);
                                                                break;
                                                            case 59:
                                                                DDLog.m1684e("设置拍照gps：成功");
                                                                CameraConfig.get().setPhotoGpsShow(bArr[i2] == 1);
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_SET_PHOTO_GPS_SUCCESS);
                                                                break;
                                                            case 60:
                                                                DDLog.m1684e("获取拍照gps：成功");
                                                                CameraConfig.get().setPhotoGpsShow(bArr[i2] == 1);
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_GET_PHOTO_GPS_SUCCESS);
                                                                break;
                                                            case 61:
                                                                PhotoChildMode photoChildMode = new PhotoChildMode();
                                                                photoChildMode.parseData(bArr, i, false);
                                                                DDLog.m1684e("设置拍照子模式：成功 " + photoChildMode.toString());
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_SET_PHOTO_MODE_SUCCESS, photoChildMode);
                                                                break;
                                                            case 62:
                                                                float intFromByteArr = ParseUtil.getIntFromByteArr(new byte[]{bArr[i2], bArr[i + 3], bArr[i + 4], bArr[i + 5]}, 0) / 100.0f;
                                                                if (intFromByteArr >= 1.0f) {
                                                                    CameraConfig.get().setZoom(intFromByteArr);
                                                                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_ZOOM_RADIO_SUCCESS);
                                                                }
                                                                DDLog.m1684e("设置数码变焦：成功,变焦倍数：" + intFromByteArr);
                                                                break;
                                                            case 63:
                                                                float intFromByteArr2 = ParseUtil.getIntFromByteArr(new byte[]{bArr[i2], bArr[i + 3], bArr[i + 4], bArr[i + 5]}, 0) / 100.0f;
                                                                CameraConfig.get().setZoom(intFromByteArr2);
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_GET_ZOOM_RADIO_SUCCESS);
                                                                DDLog.m1684e("获取数码变焦：成功，变焦倍数：" + intFromByteArr2);
                                                                break;
                                                            case 64:
                                                                PhotoChildMode photoChildMode2 = new PhotoChildMode();
                                                                photoChildMode2.parseData(bArr, i, true);
                                                                DDLog.m1684e("获取拍照子模式：成功 " + photoChildMode2.toString());
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_GET_PHOTO_MODE_SUCCESS, photoChildMode2);
                                                                break;
                                                            case 65:
                                                                TimedPhotoUploadData timedPhotoUploadData = new TimedPhotoUploadData();
                                                                timedPhotoUploadData.parseData(bArr, i);
                                                                DDLog.m1684e("拍照子模式上报 " + timedPhotoUploadData.toString());
                                                                EventDispatcher.get().sendEvent(EventID.EVENT_TIMED_PHOTO_UPLOAD, timedPhotoUploadData);
                                                                break;
                                                        }
                                                }
                                        }
                                        return;
                                }
                        }
                }
                DDLog.m1684e("解析出错:" + e2);
            }
        }
    }

    private void parseResultError(byte b, byte b2, int i, byte[] bArr) {
        if (b == 0 || b == 1) {
            EventDispatcher.get().sendEvent(EventID.EVENT_CAMERA_ABNORMAL_NOTIFY);
        } else if (b == 3) {
            EventDispatcher.get().sendEvent(EventID.EVENT_SET_CAPTURE_MODE_FAILED, "");
        } else if (b == 4) {
            EventDispatcher.get().sendEvent(EventID.EVENT_SET_FORMAT_SD_CARD_FAILED);
        } else if (b == 11) {
            DDLog.m1684e("设置录像分辨率失败");
            EventDispatcher.get().sendEvent(EventID.EVENT_SET_RECORD_SIZE_FAILED, "");
        } else if (b == 13) {
            EventDispatcher.get().sendEvent(EventID.EVENT_SET_TAKE_PHOTO_SIZE_FAILED, "");
        } else if (b == 15) {
            DDLog.m1684e("设置EV失败");
        } else if (b != 19) {
            if (b != 24) {
                if (b == 58) {
                    EventDispatcher.get().sendEvent(EventID.EVENT_CAMERA_SWITCH_MODE_NOTIFY);
                } else if (b == 64) {
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_PHOTO_MODE_FAIL, "");
                } else if (b != 28 && b != 29) {
                    switch (b) {
                        case 44:
                        case 46:
                            DDLog.m1684e("收到视觉数据 错误1:" + ParseUtil.byteToHexString(bArr));
                            return;
                        case 45:
                            DDLog.m1684e("收到视觉错误1:" + ParseUtil.byteToHexString(bArr));
                            EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_ERROR, VisionError.ERROR_CAMERA_UNKNOWN);
                            break;
                        case 47:
                            DDLog.m1684e("收到视觉数据 错误:" + ParseUtil.byteToHexString(bArr));
                            VisionError error = VisionError.getError(bArr[i + 1]);
                            if (error != null) {
                                if (error == VisionError.ERROR_EXIT) {
                                    EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_TRACK_CLOSE);
                                    return;
                                } else {
                                    EventDispatcher.get().sendEvent(EventID.EVENT_VISUAL_TARGET_ERROR, error);
                                    return;
                                }
                            }
                            return;
                        case 48:
                            DDLog.m1684e("大包升级错误信息");
                            BigPackageHelper.get().onReceivedError(b2, i, bArr);
                            break;
                    }
                }
            }
            UsbGalleryManager.getInstance().onReceived(bArr);
        } else {
            DDLog.m1684e("设置录像分段失败");
            EventDispatcher.get().sendEvent(EventID.EVENT_SET_VIDEO_SEGMENT_FAILED, "");
        }
        if (b2 == 15) {
            EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_LOW_SPEED);
            return;
        }
        if (b2 == 16) {
            EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_DIST);
            EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_DIST_TIP);
            return;
        }
        if (b2 != 22) {
            if (b2 != 37) {
                if (b2 != 53) {
                    switch (b2) {
                        case 1:
                            DDLog.m1684e("命令不支持:" + ParseUtil.byteToHexString(bArr));
                            EventDispatcher.get().sendEvent(EventID.EVENT_CMD_NOT_SUPPORT);
                            break;
                        case 2:
                            DDLog.m1684e("参数无效:" + ParseUtil.byteToHexString(bArr));
                            EventDispatcher.get().sendEvent(EventID.EVENT_ARGUMENT_INVALID);
                            break;
                        case 3:
                            EventDispatcher.get().sendEvent(EventID.EVENT_DEVICE_BUSY);
                            break;
                        case 4:
                            DDLog.m1684e("未知错误:" + ParseUtil.byteToHexString(bArr));
                            EventDispatcher.get().sendEvent(EventID.EVENT_UNKNOWN_ERROR);
                            break;
                        case 5:
                            EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD);
                            EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD_TIP);
                            break;
                        case 6:
                            DDLog.m1684e("相机 sd卡已满 ：" + ParseUtil.byteToHexString(bArr));
                            EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_FULL);
                            EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_FULL_TIP);
                            break;
                        case 7:
                            EventDispatcher.get().sendEvent(EventID.EVENT_OPTION_INVALID);
                            break;
                        case 8:
                            DDLog.m1684e("当前模式不允许:" + ParseUtil.byteToHexString(bArr));
                            break;
                        case 10:
                            EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD);
                            EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD_TIP);
                            break;
                    }
                    return;
                }
                DDLog.m1684e("设置手动模式数据失败");
                EventDispatcher.get().sendEvent(EventID.FLIGHT_RECEIVE_MANUAL_SETTING_ACK, false);
                return;
            }
            EventDispatcher.get().sendEvent(EventID.EVENT_RECORD_ALREADY_START);
            getCameraStatus();
            return;
        }
        DDLog.m1684e("操作不允许: 相机正在升级");
        EventDispatcher.get().sendEvent(EventID.EVENT_CAMERA_UPGRADING);
    }

    private CameraInfoData parseCameraState(byte[] bArr, int i) {
        CameraInfoData cameraInfoData = new CameraInfoData();
        if (bArr[i] == 0) {
            cameraInfoData.setCaptureMode(CaptureMode.MODE_REC);
        } else if (bArr[i] == 1) {
            cameraInfoData.setCaptureMode(CaptureMode.MODE_PHOTO);
        }
        CameraConfig.get().setCaptureMode(cameraInfoData.getCaptureMode());
        EventDispatcher.get().sendEvent(EventID.EVENT_GET_CAPTURE_MODE_SUCCESS, cameraInfoData.getCaptureMode());
        if (bArr[i] == 0 && bArr[i + 1] == 1) {
            cameraInfoData.setRunning(true);
            cameraInfoData.setRecordTime(ParseUtil.getUnsignedShortFromByteArr(bArr, i + 2));
        }
        DDLog.m1684e("录像/拍照信息:" + cameraInfoData.toString());
        return cameraInfoData;
    }

    private void parseCardState(byte b, boolean z) {
        DDLog.m1684e("相机 sd card state：" + ((int) b));
        CameraConfig.get().setSdState(b);
        DDLog.m1691w("相机sd卡状态是否正常：" + CameraConfig.get().sdCardState);
        if (b != 8) {
            this.isSpeedNotStable = false;
        }
        switch (b) {
            case 0:
                DDLog.m1684e("未检测到SD卡 11111111111");
                break;
            case 1:
                if (z) {
                    EventDispatcher.get().sendEvent(EventID.EVENT_SET_FORMAT_SD_CARD_SUCCESS);
                    break;
                }
                break;
            case 2:
            case 7:
                EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_DIST);
                EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_DIST_TIP);
                break;
            case 4:
                EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD);
                EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD_TIP);
                break;
            case 5:
                DDLog.m1684e("相机 sd卡已满1 ：" + ParseUtil.byteToHexString(new byte[]{b}));
                EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_FULL);
                EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_FULL_TIP);
                break;
            case 6:
                EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_LOW_SPEED);
                break;
            case 8:
                if (!this.isSpeedNotStable) {
                    this.isSpeedNotStable = true;
                    EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_SPEED_NOT_STABLE);
                    break;
                }
                break;
        }
    }

    private void parseCameraInfo(byte[] bArr) {
        String trim = new String(bArr, StandardCharsets.US_ASCII).trim();
        DDLog.m1684e("相机信息:" + trim);
        DDLog.m1684e("相机信息:" + ParseUtil.byteToHexString(bArr));
        String upperCase = trim.toUpperCase();
        if (upperCase.contains("V")) {
            int lastIndexOf = upperCase.lastIndexOf("V");
            String substring = trim.substring(lastIndexOf);
            CameraConfig.get().setSoftVersion(substring);
            DDLog.m1684e("相机版本：" + substring);
            DDLog.m1684e("相机型号：" + trim.substring(0, lastIndexOf));
            CameraConfig.get().setModelForUsb(trim.substring(0, lastIndexOf));
        } else {
            CameraConfig.get().setModelForUsb(trim);
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_GET_CAPTURE_MODE_SUCCESS, CameraConfig.get().getCaptureMode());
    }

    private void parseAllParams(byte[] bArr, int i) {
        DDLog.m1684e("收到config menu 数据:" + ParseUtil.byteToHexString(bArr));
        CameraInfoData parseCameraState = parseCameraState(bArr, i + 2);
        int i2 = i + 6;
        int i3 = bArr[i2];
        byte[] bArr2 = new byte[i3];
        System.arraycopy(bArr, i + 7, bArr2, 0, i3);
        parseCameraInfo(bArr2);
        int i4 = i2 + i3 + 1;
        parseCardState(bArr[i4], false);
        EventDispatcher.get().sendEvent(EventID.EVENT_GET_CAMERA_STATE_SUCCESS, parseCameraState);
        int i5 = i4 + 1;
        int i6 = i5 + 1;
        int i7 = i6 + 1;
        byte[] bArr3 = {bArr[i5], bArr[i6], bArr[i7], 0};
        CameraConfig.get().setSdFreeSpace(ParseUtil.getIntFromByteArr(bArr3, 0));
        DDLog.m1684e("获取相机卡可用大小：" + CameraConfig.get().getSdFreeSpace());
        int i8 = i7 + 1;
        bArr3[0] = bArr[i8];
        int i9 = i8 + 1;
        bArr3[1] = bArr[i9];
        int i10 = i9 + 1;
        bArr3[2] = bArr[i10];
        bArr3[3] = 0;
        CameraConfig.get().setSdTotalSpace(ParseUtil.getIntFromByteArr(bArr3, 0));
        DDLog.m1684e("获取相机卡总共大小：" + CameraConfig.get().getSdTotalSpace());
        int i11 = i10 + 1;
        byte b = bArr[i11 + 1];
        CameraConfig.get().supportVideoSizes.setSupportListForUSB(parseArr(bArr, i11, b));
        CameraConfig.get().supportVideoSizes.setCurrentValueForUsb(bArr[i11]);
        int i12 = i11 + b + 1 + 1;
        byte b2 = bArr[i12 + 1];
        CameraConfig.get().supportPhotoSizes.setSupportListForUSB(parseArr(bArr, i12, b2));
        CameraConfig.get().supportPhotoSizes.setCurrentValueForUsb(bArr[i12]);
        int i13 = i12 + b2 + 1 + 1;
        byte b3 = bArr[i13 + 1];
        CameraConfig.supportRecordEvValues = parseArr(bArr, i13, b3);
        CameraConfig.get().setCurRecordEvValueForUSB(bArr[i13]);
        int i14 = i13 + b3 + 1 + 1;
        byte b4 = bArr[i14 + 1];
        CameraConfig.supportTakePhotoEvValues = parseArr(bArr, i14, b4);
        CameraConfig.get().setCurTakePhotoEvValueForUSB(bArr[i14]);
        for (int i15 = 0; i15 < CameraConfig.supportRecordEvValues.length; i15++) {
            DDLog.m1684e("录制ev list:" + i15 + " , " + CameraConfig.supportRecordEvValues[i15]);
        }
        for (int i16 = 0; i16 < CameraConfig.supportTakePhotoEvValues.length; i16++) {
            DDLog.m1684e("拍照ev list:" + i16 + " , " + CameraConfig.supportTakePhotoEvValues[i16]);
        }
        DDLog.m1684e("录像 拍照ev:" + CameraConfig.get().getRecordEV());
        DDLog.m1684e("录像 拍照ev:" + CameraConfig.get().getPhotoEV());
        int i17 = i14 + b4 + 1 + 1;
        byte b5 = bArr[i17 + 1];
        CameraConfig.get().supportSplitSizes.setSupportListForUSB(parseArr(bArr, i17, b5));
        CameraConfig.get().supportSplitSizes.setCurrentValueForUsb(bArr[i17]);
        if (bArr.length >= i17 + b5 + 1 + 6 + 1) {
            int i18 = i17 + b5 + 1 + 1;
            CameraConfig.get().setRaw(bArr[i18] == 1);
            int i19 = i18 + 1;
            CameraConfig.get().setVideoOsdShow(bArr[i19] == 1);
            int i20 = i19 + 1;
            CameraConfig.get().setPhotoOsdShow(bArr[i20] == 1);
            DDLog.m1684e("configmenu 拍照格式:" + CameraConfig.get().isRaw());
            DDLog.m1684e("configmenu 录像水印:" + CameraConfig.get().isVideoOsdShow());
            DDLog.m1684e("configmenu 拍照水印:" + CameraConfig.get().isPhotoOsdShow());
            int i21 = i20 + 1;
            parseRemainCapture(ParseUtil.interceptBytes(bArr, i21, 3));
            i17 = i21 + 3;
        }
        DDLog.m1685e(TAG, "parseAllParams length: " + bArr.length + ",nextIndex: " + i17);
        int i22 = i17 + 1;
        if (bArr.length > i22 + 2) {
            int i23 = bArr[i17] * 2;
            CameraConfig.get().supportVideoSizes.parseMaxZoomData(bArr, i22, i23);
            int i24 = i22 + i23;
            if (bArr.length < i24) {
                return;
            }
            int i25 = i24 + 1;
            int i26 = bArr[i24] * 2;
            CameraConfig.get().supportPhotoSizes.parseMaxZoomData(bArr, i25, i26);
            int i27 = i25 + i26;
            if (bArr.length > i27 + 1) {
                CameraConfig.get().setSupportTimerPhoto(ParseUtil.getBit(bArr[i27], 0) == 1);
                CameraConfig.get().setSupportAEBPhoto(ParseUtil.getBit(bArr[i27], 1) == 1);
                CameraConfig.get().setSupportNoFlyZone(ParseUtil.getBit(bArr[i27], 2) == 1);
                if (SPHelper.getInstance().isSupportNoFlyZone() != CameraConfig.get().isSupportNoFlyZone()) {
                    SPHelper.getInstance().setSupportNoFlyZone(CameraConfig.get().isSupportNoFlyZone());
                }
                DDLog.m1685e(TAG, "isSupportNoFlyZone: " + SPHelper.getInstance().isSupportNoFlyZone());
            }
        } else if (bArr.length > i17) {
            CameraConfig.get().setSupportNoFlyZone(false);
            if (SPHelper.getInstance().isSupportNoFlyZone()) {
                SPHelper.getInstance().setSupportNoFlyZone(false);
            }
            DDLog.m1685e(TAG, "setSupportNoFlyZone false");
        }
        DDLog.m1684e("getConfigMenu callback:");
        EventDispatcher.get().sendEvent(EventID.EVENT_GET_SD_CARD_STATE_SUCCESS);
    }

    private void parseRemainCapture(byte[] bArr) {
        if (bArr.length < 4) {
            bArr = ParseUtil.concatAll(bArr, new byte[4 - bArr.length]);
        }
        int intFromByteArr = ParseUtil.getIntFromByteArr(bArr, 0);
        if (CameraConfig.get().getCaptureMode() == CaptureMode.MODE_PHOTO) {
            CameraConfig.get().setPhotoRemain(intFromByteArr);
        } else {
            CameraConfig.get().setRecordRemain(intFromByteArr);
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_REMAIN_CAPTURE_SIZE_CHANGED);
        DDLog.m1684e("configmenu 剩余拍照张数/录像时间:" + intFromByteArr);
    }

    private int[] parseArr(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        int i3 = i + 2;
        if (bArr.length < i3 + i2) {
            return new int[0];
        }
        System.arraycopy(bArr, i3, bArr2, 0, i2);
        int[] iArr = new int[i2];
        for (int i4 = 0; i4 < i2; i4++) {
            iArr[i4] = bArr2[i4];
        }
        return iArr;
    }

    public void send(byte b) {
        send(new byte[]{b});
    }

    public void send(byte[] bArr) {
        AOAEngine.getInstance().send(UsbPayloadWrapper.wrap((short) 32, bArr), UsbConfig.USB_TYPE_APP_TO_CAMERA);
    }

    public void sendGalleryData(byte[] bArr) {
        byte[] wrap = UsbPayloadWrapper.wrap((short) 32, bArr);
        DDLog.m1691w("发送图库数据:" + ParseUtil.byteToHexString(wrap));
        AOAEngine.getInstance().send(wrap, UsbConfig.USB_TYPE_APP_TO_CAMERA);
    }

    public void send(byte b, byte[] bArr, byte b2) {
        AOAEngine.getInstance().send(UsbPayloadWrapper.wrap(b, bArr), b2);
    }
}