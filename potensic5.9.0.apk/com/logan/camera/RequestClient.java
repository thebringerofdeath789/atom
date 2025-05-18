package com.logan.camera;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.okhttp.CallBackString;
import com.ipotensic.baselib.okhttp.OkHttpUtil;
import com.ipotensic.baselib.utils.FormatUtil;
import com.logan.camera.data.BaseData;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.enums.CameraModel;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.listeners.ICheckUpgradeCallback;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.camera.listeners.IStartUpgradeCallback;

/* loaded from: classes2.dex */
public class RequestClient implements IRequestClient {
    private CallBackString<BaseData> callback = new CallBackString<BaseData>() { // from class: com.logan.camera.RequestClient.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public BaseData onParseResponse(int i, String str) throws Exception {
            switch (i) {
                case 100:
                case 101:
                case 102:
                case 105:
                case 108:
                case 113:
                case 114:
                case 124:
                case 125:
                case 134:
                    DDLog.m1684e("录像分段设置：" + str.toString());
                    break;
                case 103:
                    return JsonParser.parseCameraInfo(str);
                case 104:
                    break;
                case 106:
                    return JsonParser.parseDeviceInfo(str);
                case 107:
                    return JsonParser.parseCameraTime(str);
                case 109:
                case 110:
                case 132:
                    return JsonParser.parseSize(str);
                case 111:
                case 112:
                case 117:
                case 126:
                case 133:
                    return JsonParser.parseValue(str);
                case 115:
                case 135:
                    return JsonParser.parseFormatSdCard(str);
                case 116:
                    return JsonParser.parseFileNum(str);
                case 118:
                case 119:
                case 120:
                case 121:
                case 122:
                case 128:
                default:
                    return null;
                case 123:
                    return JsonParser.parseConfigMenu(str);
                case 127:
                    return JsonParser.parseFileList(str);
                case 129:
                    return JsonParser.parseCheckUpgrade(str);
                case 130:
                    return JsonParser.parseStartUpgrade(str);
                case 131:
                    return JsonParser.parseMediaInfo(str);
                case 136:
                    return JsonParser.parseWifi(str);
            }
            return JsonParser.parseStatusData(str);
        }

        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public void onResponse(int i, BaseData baseData) {
            RequestClient.this.responseListener.onRequestSuccess(i, baseData);
        }

        @Override // com.ipotensic.baselib.okhttp.CallBackString
        public void onFailure(int i, Exception exc) {
            RequestClient.this.responseListener.onRequestFailed(i, exc);
        }
    };
    private OnResponseListener responseListener;

    @Override // com.logan.camera.IRequestClient
    public void executeShortVideo(VisionExecuteType visionExecuteType, int i, int i2) {
    }

    @Override // com.logan.camera.IRequestClient
    public void getManualExposureValue() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getManualModeInfo() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoFormat() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoOSD() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoRecordGps() {
    }

    @Override // com.logan.camera.IRequestClient
    public void getRemainCaptureSize() {
    }

    @Override // com.logan.camera.IRequestClient
    public void selectTarget(TrackTarget.Box box) {
    }

    @Override // com.logan.camera.IRequestClient
    public void setDebugCmd(byte b, byte[] bArr) {
    }

    @Override // com.logan.camera.IRequestClient
    public void setManualModelInfo(ManualModeInfo manualModeInfo) {
    }

    @Override // com.logan.camera.IRequestClient
    public void setPhotoOSD(boolean z) {
    }

    @Override // com.logan.camera.IRequestClient
    public void setPhotoRecordGps(boolean z) {
    }

    @Override // com.logan.camera.IRequestClient
    public void setRaw(boolean z) {
    }

    @Override // com.logan.camera.IRequestClient
    public void setTrackTarget(boolean z) {
    }

    public RequestClient(OnResponseListener onResponseListener) {
        this.responseListener = onResponseListener;
    }

    @Override // com.logan.camera.IRequestClient
    public void startRecord() {
        get(100, "http://192.168.29.1/cgi-bin/hisnet/workmodecmd.cgi?&-act=set&-cmd=start");
    }

    @Override // com.logan.camera.IRequestClient
    public void stopRecord() {
        get(101, CameraConstants.URL_STOP_RECORD);
    }

    @Override // com.logan.camera.IRequestClient
    public void takePhoto() {
        get(102, CameraConfig.get().getCameraModel() == CameraModel.MODEL_56 ? CameraConstants.URL_TAKE_PHOTO_56 : "http://192.168.29.1/cgi-bin/hisnet/workmodecmd.cgi?&-act=set&-cmd=start");
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraStatus() {
        get(103, CameraConstants.URL_GET_CAMERA_STATUS);
    }

    @Override // com.logan.camera.IRequestClient
    public void setCameraMode(CaptureMode captureMode) {
        get(104, String.format(CameraConstants.URL_SET_CAMERA_MODE, captureMode.getValue()));
    }

    @Override // com.logan.camera.IRequestClient
    public void resetCamera() {
        get(105, CameraConstants.URL_RESET_CAMERA);
    }

    @Override // com.logan.camera.IRequestClient
    public void getDeviceInfo() {
        get(106, CameraConstants.URL_GET_DEVICE_INFO);
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraTime() {
        get(107, CameraConstants.URL_GET_CAMERA_TIME);
    }

    @Override // com.logan.camera.IRequestClient
    public void setCameraTime() {
        get(108, String.format(CameraConstants.URL_SET_CAMERA_TIME, FormatUtil.getCurTime()));
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordSupportSize() {
        get(109, "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=NORM_REC&-type=MEDIAMODE");
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoSupportSize() {
        get(110, "http://192.168.29.1/cgi-bin/hisnet/getworkmodeparamcapability.cgi?&-workmode=SING_PHOTO&-type=MEDIAMODE");
    }

    @Override // com.logan.camera.IRequestClient
    public void getCurRecordSize() {
        get(111, CameraConstants.URL_GET_CUR_RECORD_SIZE);
    }

    @Override // com.logan.camera.IRequestClient
    public void getCurTakePhotoSize() {
        get(112, CameraConstants.URL_GET_CUR_TAKE_PHOTO_SIZE);
    }

    @Override // com.logan.camera.IRequestClient
    public void setRecordSize(String str, int i) {
        get(113, String.format(CameraConstants.URL_SET_RECORD_SIZE, str));
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoSize(String str, int i) {
        get(114, String.format(CameraConstants.URL_SET_TAKE_PHOTO_SIZE, str));
    }

    @Override // com.logan.camera.IRequestClient
    public void formatSdCard() {
        get(115, CameraConstants.URL_FORMAT_SD_CARD);
    }

    @Override // com.logan.camera.IRequestClient
    public void getConfigMenu() {
        get(123, CameraConstants.URL_GET_CONFIG_MENU);
    }

    @Override // com.logan.camera.IRequestClient
    public void setRecordEv(double d) {
        String evString = getEvString(CameraConstants.URL_SET_RECORD_EV, d);
        if (evString != null) {
            get(124, evString);
        }
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoEv(double d) {
        String evString = getEvString(CameraConstants.URL_SET_TAKE_PHOTO_EV, d);
        if (evString != null) {
            get(125, evString);
        }
    }

    private String getEvString(String str, double d) {
        if (d == -2.0d || d == -1.0d) {
            return String.format(str, "" + ((int) d));
        }
        if (d == 0.0d) {
            return String.format(str, SessionDescription.SUPPORTED_SDP_VERSION);
        }
        if (d == 0.5d || d == 1.5d) {
            return String.format(str, "+" + d);
        }
        if (d == 1.0d || d == 2.0d) {
            return String.format(str, "+" + ((int) d));
        }
        if (d == -0.5d || d == -1.5d) {
            return String.format(str, Double.valueOf(d));
        }
        return null;
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordEv() {
        get(126, CameraConstants.URL_GET_RECORD_EV);
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoEv() {
        get(117, CameraConstants.URL_GET_TAKE_PHOTO_EV);
    }

    @Override // com.logan.camera.IRequestClient
    public void checkUpgrade(long j, String str, ICheckUpgradeCallback iCheckUpgradeCallback) {
        get(129, String.format(CameraConstants.URL_UPGRADE_CHECK, "" + j, str));
    }

    @Override // com.logan.camera.IRequestClient
    public void startUpgrade(String str, String str2, IStartUpgradeCallback iStartUpgradeCallback) {
        get(130, String.format(CameraConstants.URL_START_UPGRADE, str, str2));
    }

    @Override // com.logan.camera.IRequestClient
    public void getMediaInfo(String str, IMediaInfoCallback iMediaInfoCallback) {
        get(131, String.format(CameraConstants.URL_GET_MEDIA_INFO, str));
    }

    @Override // com.logan.camera.IRequestClient
    public void setVideoSegment(String str, int i) {
        String format = String.format(CameraConstants.URL_SET_VIDEO_SEGMENT, str);
        get(134, format);
        DDLog.m1684e("录像分段设置 url=：" + format);
    }

    @Override // com.logan.camera.IRequestClient
    public void getSdCardStatus() {
        get(135, CameraConstants.URL_GET_SD_STATUS);
    }

    @Override // com.logan.camera.IRequestClient
    public void getWifiSignal() {
        get(136, CameraConstants.URL_GET_WIFI_SIGNAL);
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordingSdSpace() {
        getSdCardStatus();
    }

    private void get(int i, String str) {
        DDLog.m1691w("通知11111：" + str);
        OkHttpUtil.getInstance().get(i, str, this.callback);
    }
}