package com.logan.camera;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.configs.PhoneConfig;
import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.enums.VisionExecuteType;
import com.ipotensic.baselib.exceptions.NoNetworkException;
import com.ipotensic.baselib.utils.CancelRunnable;
import com.logan.camera.data.BaseData;
import com.logan.camera.data.CameraInfoData;
import com.logan.camera.data.CheckUpgradeData;
import com.logan.camera.data.FormatSdCardData;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.data.MediaInfoData;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.SizeData;
import com.logan.camera.data.StartUpgradeData;
import com.logan.camera.data.StatusData;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.data.ValueData;
import com.logan.camera.data.WifiSignalData;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.enums.FormatEnum;
import com.logan.camera.enums.SdCardState;
import com.logan.camera.enums.StatusEnum;
import com.logan.camera.listeners.ICheckUpgradeCallback;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.camera.listeners.IStartUpgradeCallback;
import com.logan.flight.FlightConfig;
import com.logan.usb.UsbCameraHandler;
import java.util.concurrent.TimeUnit;

/* loaded from: classes2.dex */
public class CameraCtrlPresenter implements IRequestClient {
    private static final String TAG = "CameraCtrlPresenter";
    private static volatile CameraCtrlPresenter instance;
    private static IRequestClient requestClient;
    private ICheckUpgradeCallback checkUpgradeCallback;
    private ManualModeInfo manualModeInfo;
    private IMediaInfoCallback mediaInfoCallback;
    private CaptureMode requestCaptureMode;
    private double requestRecordEv;
    private String requestRecordSize;
    private double requestTakePhotoEv;
    private String requestTakePhotoSize;
    private String requestVideoSegment;
    private IStartUpgradeCallback startUpgradeCallback;
    private CancelRunnable wifiSignalTimer = null;
    private CancelRunnable sdSpaceTimer = null;
    private OnResponseListener dataReceiver = new OnResponseListener<BaseData>() { // from class: com.logan.camera.CameraCtrlPresenter.3
        @Override // com.logan.camera.OnResponseListener
        public void onRequestSuccess(int i, BaseData baseData) {
            CheckUpgradeData checkUpgradeData;
            StartUpgradeData startUpgradeData;
            switch (i) {
                case 100:
                    int i2 = C29144.$SwitchMap$com$logan$camera$enums$StatusEnum[CameraCtrlPresenter.this.getStatus(baseData).ordinal()];
                    if (i2 == 1) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_START_RECORD);
                        break;
                    } else if (i2 == 2) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_READY);
                        break;
                    } else if (i2 == 3) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_FULL);
                        break;
                    } else if (i2 == 4) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_LOW_SPEED);
                        break;
                    }
                    break;
                case 101:
                    if (CameraCtrlPresenter.this.isSuccess(baseData)) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_STOP_RECORD);
                        break;
                    }
                    break;
                case 102:
                    int i3 = C29144.$SwitchMap$com$logan$camera$enums$StatusEnum[CameraCtrlPresenter.this.getStatus(baseData).ordinal()];
                    if (i3 == 1) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_TAKE_PHOTO_SUCCESS);
                        break;
                    } else if (i3 == 2) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_READY);
                        break;
                    } else if (i3 == 3) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_FULL);
                        break;
                    } else if (i3 == 4) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_LOW_SPEED);
                        break;
                    }
                    break;
                case 103:
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_CAMERA_STATE_SUCCESS, (CameraInfoData) baseData);
                    break;
                case 104:
                    if (CameraCtrlPresenter.this.isSuccess(baseData)) {
                        CameraConfig.get().setCaptureMode(CameraCtrlPresenter.this.requestCaptureMode);
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_CAPTURE_MODE_SUCCESS, CameraCtrlPresenter.this.requestCaptureMode);
                        break;
                    } else {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_CAPTURE_MODE_FAILED, "");
                        break;
                    }
                case 109:
                    CameraConfig.get().supportVideoSizes.setSupportListForWIFI((SizeData) baseData);
                    break;
                case 110:
                    CameraConfig.get().supportPhotoSizes.setSupportListForWIFI((SizeData) baseData);
                    break;
                case 113:
                    if (((StatusData) baseData).getStatus() == StatusEnum.STATUS_SUCCESS) {
                        CameraConfig.get().supportVideoSizes.setCurrentValue(CameraCtrlPresenter.this.requestRecordSize);
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_RECORD_SIZE_SUCCESS);
                        break;
                    } else {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_RECORD_SIZE_FAILED, "");
                        break;
                    }
                case 114:
                    if (((StatusData) baseData).getStatus() == StatusEnum.STATUS_SUCCESS) {
                        CameraConfig.get().supportPhotoSizes.setCurrentValue(CameraCtrlPresenter.this.requestTakePhotoSize);
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_TAKE_PHOTO_SIZE_SUCCESS);
                        break;
                    } else {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_TAKE_PHOTO_SIZE_FAILED, "");
                        break;
                    }
                case 115:
                    if (((FormatSdCardData) baseData).getSdStatus() == FormatEnum.FORMAT_SUCCESS.getValue()) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_FORMAT_SD_CARD_SUCCESS);
                        break;
                    }
                    break;
                case 117:
                    CameraConfig.get().setPhotoEV(Double.valueOf(((ValueData) baseData).getValue()).doubleValue());
                    break;
                case 123:
                    CaptureMode captureMode = CameraConfig.get().getCaptureMode();
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_CAPTURE_MODE_SUCCESS, captureMode);
                    if (captureMode == CaptureMode.MODE_REC) {
                        CameraCtrlPresenter.this.getCameraStatus();
                    }
                    if (CameraConfig.get().sdCardState == SdCardState.SD_CARD_NEED_FORMAT) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD);
                        EventDispatcher.get().sendEvent(EventID.EVENT_NEED_FORMAT_SD_CARD_TIP);
                    }
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_CONFIG_MENU_SUCCESS);
                    if (CameraConfig.get().getSdStateRes() == 0) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_NO_SD_CARD);
                    }
                    if (CameraConfig.get().getSdStateRes() == 5) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_LOW_SPEED);
                    }
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_SD_CARD_STATE_SUCCESS);
                    break;
                case 124:
                    if (((StatusData) baseData).getStatus() == StatusEnum.STATUS_SUCCESS) {
                        CameraConfig.get().setRecordEV(CameraCtrlPresenter.this.requestRecordEv);
                        break;
                    }
                    break;
                case 125:
                    if (((StatusData) baseData).getStatus() == StatusEnum.STATUS_SUCCESS) {
                        CameraConfig.get().setPhotoEV(CameraCtrlPresenter.this.requestTakePhotoEv);
                        break;
                    }
                    break;
                case 126:
                    CameraConfig.get().setRecordEV(Double.valueOf(((ValueData) baseData).getValue()).doubleValue());
                    break;
                case 129:
                    if (CameraCtrlPresenter.this.checkUpgradeCallback != null && (checkUpgradeData = (CheckUpgradeData) baseData) != null) {
                        if (checkUpgradeData.getResult() == 0) {
                            CameraCtrlPresenter.this.checkUpgradeCallback.canUpgrade();
                            break;
                        } else {
                            CameraCtrlPresenter.this.checkUpgradeCallback.notUpgrade(checkUpgradeData.getResult());
                            break;
                        }
                    }
                    break;
                case 130:
                    if (CameraCtrlPresenter.this.startUpgradeCallback != null && (startUpgradeData = (StartUpgradeData) baseData) != null) {
                        if (startUpgradeData.getResult() == 0) {
                            CameraCtrlPresenter.this.startUpgradeCallback.upgradeSuccess();
                            break;
                        } else {
                            DDLog.m1685e("ftp", "startUpgradeData.getResult(): " + startUpgradeData.getResult());
                            CameraCtrlPresenter.this.startUpgradeCallback.upgradeFailed(startUpgradeData.getResult());
                            break;
                        }
                    }
                    break;
                case 131:
                    MediaInfoData mediaInfoData = (MediaInfoData) baseData;
                    if (mediaInfoData != null && CameraCtrlPresenter.this.mediaInfoCallback != null) {
                        CameraCtrlPresenter.this.mediaInfoCallback.onCallback(mediaInfoData);
                        break;
                    }
                    break;
                case 134:
                    StatusData statusData = (StatusData) baseData;
                    DDLog.m1684e("录像分段设置成功：" + statusData.toString());
                    if (statusData.getStatus() == StatusEnum.STATUS_SUCCESS) {
                        CameraConfig.get().supportSplitSizes.setCurrentValue(CameraCtrlPresenter.this.requestVideoSegment);
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_VIDEO_SEGMENT_SUCCESS);
                        break;
                    } else {
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_VIDEO_SEGMENT_FAILED, "");
                        break;
                    }
                case 135:
                    FormatSdCardData formatSdCardData = (FormatSdCardData) baseData;
                    CameraConfig.get().setSdFreeSpace(formatSdCardData.getSdFreeSpace());
                    CameraConfig.get().setSdTotalSpace(formatSdCardData.getSdTotalSpace());
                    CameraConfig.get().setSdState(formatSdCardData.getSdStatus());
                    EventDispatcher.get().sendEvent(EventID.EVENT_GET_SD_CARD_STATE_SUCCESS);
                    break;
                case 136:
                    WifiSignalData wifiSignalData = (WifiSignalData) baseData;
                    if (wifiSignalData != null) {
                        EventDispatcher.get().sendEvent(EventID.EVENT_GET_WIFI_SIGNAL_SUCCESS, wifiSignalData);
                        break;
                    }
                    break;
            }
        }

        @Override // com.logan.camera.OnResponseListener
        public void onRequestFailed(int i, Exception exc) {
            if (exc instanceof NoNetworkException) {
                EventDispatcher.get().sendEvent(EventID.EVENT_NEED_CONNECT_FLIGHT);
            }
            if (i == 100 || i == 102) {
                EventDispatcher.get().sendEvent(EventID.EVENT_SD_CARD_NOT_READY);
                return;
            }
            if (i != 104) {
                switch (i) {
                    case 113:
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_RECORD_SIZE_FAILED, exc.getMessage());
                        break;
                    case 114:
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_TAKE_PHOTO_SIZE_FAILED, exc.getMessage());
                        break;
                    case 115:
                        EventDispatcher.get().sendEvent(EventID.EVENT_SET_FORMAT_SD_CARD_FAILED);
                        break;
                }
                return;
            }
            EventDispatcher.get().sendEvent(EventID.EVENT_SET_CAPTURE_MODE_FAILED, exc.getMessage());
        }
    };

    private CameraCtrlPresenter() {
        if (UsbConfig.isUsbConnected) {
            requestClient = UsbCameraHandler.getInstance();
        } else {
            requestClient = new RequestClient(this.dataReceiver);
        }
    }

    public static CameraCtrlPresenter getInstance() {
        if (UsbConfig.isUsbConnected) {
            if (!(requestClient instanceof UsbCameraHandler)) {
                CameraCtrlPresenter cameraCtrlPresenter = new CameraCtrlPresenter();
                instance = cameraCtrlPresenter;
                return cameraCtrlPresenter;
            }
        } else if (PhoneConfig.isConnectFlightWifi() && FlightConfig.isConnectFlight() && !(requestClient instanceof RequestClient)) {
            CameraCtrlPresenter cameraCtrlPresenter2 = new CameraCtrlPresenter();
            instance = cameraCtrlPresenter2;
            return cameraCtrlPresenter2;
        }
        if (instance == null) {
            synchronized (CameraCtrlPresenter.class) {
                if (instance == null) {
                    CameraCtrlPresenter cameraCtrlPresenter3 = new CameraCtrlPresenter();
                    instance = cameraCtrlPresenter3;
                    return cameraCtrlPresenter3;
                }
            }
        }
        return instance;
    }

    public void release() {
        instance = null;
    }

    @Override // com.logan.camera.IRequestClient
    public void startRecord() {
        DDLog.m1691w("开始录制");
        requestClient.startRecord();
    }

    @Override // com.logan.camera.IRequestClient
    public void stopRecord() {
        DDLog.m1691w("停止录制");
        requestClient.stopRecord();
    }

    @Override // com.logan.camera.IRequestClient
    public void takePhoto() {
        DDLog.m1691w("拍照");
        requestClient.takePhoto();
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraStatus() {
        requestClient.getCameraStatus();
    }

    @Override // com.logan.camera.IRequestClient
    public void setCameraMode(CaptureMode captureMode) {
        this.requestCaptureMode = captureMode;
        requestClient.setCameraMode(captureMode);
    }

    @Override // com.logan.camera.IRequestClient
    public void resetCamera() {
        requestClient.resetCamera();
    }

    @Override // com.logan.camera.IRequestClient
    public void getDeviceInfo() {
        requestClient.getDeviceInfo();
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraTime() {
        requestClient.getCameraTime();
    }

    @Override // com.logan.camera.IRequestClient
    public void setCameraTime() {
        DDLog.m1684e("setcameratime0");
        requestClient.setCameraTime();
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordSupportSize() {
        requestClient.getRecordSupportSize();
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoSupportSize() {
        requestClient.getTakePhotoSupportSize();
    }

    @Override // com.logan.camera.IRequestClient
    public void getCurRecordSize() {
        requestClient.getCurRecordSize();
    }

    @Override // com.logan.camera.IRequestClient
    public void getCurTakePhotoSize() {
        requestClient.getCurTakePhotoSize();
    }

    @Override // com.logan.camera.IRequestClient
    public void setRecordSize(String str, int i) {
        this.requestRecordSize = str;
        requestClient.setRecordSize(str, i);
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoSize(String str, int i) {
        this.requestTakePhotoSize = str;
        requestClient.setTakePhotoSize(str, i);
    }

    @Override // com.logan.camera.IRequestClient
    public void formatSdCard() {
        requestClient.formatSdCard();
    }

    @Override // com.logan.camera.IRequestClient
    public void getConfigMenu() {
        requestClient.getConfigMenu();
    }

    @Override // com.logan.camera.IRequestClient
    public void setRecordEv(double d) {
        this.requestRecordEv = d;
        requestClient.setRecordEv(d);
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoEv(double d) {
        this.requestTakePhotoEv = d;
        requestClient.setTakePhotoEv(d);
    }

    @Override // com.logan.camera.IRequestClient
    public void getCameraEv(int i) {
        requestClient.getCameraEv(i);
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordEv() {
        requestClient.getRecordEv();
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoEv() {
        requestClient.getTakePhotoEv();
    }

    @Override // com.logan.camera.IRequestClient
    public void checkUpgrade(long j, String str, ICheckUpgradeCallback iCheckUpgradeCallback) {
        this.checkUpgradeCallback = iCheckUpgradeCallback;
        requestClient.checkUpgrade(j, str, iCheckUpgradeCallback);
    }

    @Override // com.logan.camera.IRequestClient
    public void startUpgrade(String str, String str2, IStartUpgradeCallback iStartUpgradeCallback) {
        this.startUpgradeCallback = iStartUpgradeCallback;
        requestClient.startUpgrade(str, str2, iStartUpgradeCallback);
    }

    @Override // com.logan.camera.IRequestClient
    public void getMediaInfo(String str, IMediaInfoCallback iMediaInfoCallback) {
        this.mediaInfoCallback = iMediaInfoCallback;
        requestClient.getMediaInfo(str, iMediaInfoCallback);
    }

    @Override // com.logan.camera.IRequestClient
    public void setVideoSegment(String str, int i) {
        DDLog.m1684e("设置分段：" + str + ",index :" + i);
        this.requestVideoSegment = str;
        requestClient.setVideoSegment(str, i);
    }

    public void startGetWifiSignal() {
        if (this.wifiSignalTimer == null) {
            CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.logan.camera.CameraCtrlPresenter.1
                @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
                public void run() {
                    if (PhoneConfig.isConnectFlightWifi()) {
                        CameraCtrlPresenter.this.getWifiSignal();
                    }
                }
            };
            this.wifiSignalTimer = cancelRunnable;
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.wifiSignalTimer, 0L, 1000L, TimeUnit.MILLISECONDS));
        }
    }

    public void stopGetWifiSignal() {
        CancelRunnable cancelRunnable = this.wifiSignalTimer;
        if (cancelRunnable == null || cancelRunnable.getFuture() == null) {
            return;
        }
        this.wifiSignalTimer.getFuture().cancel(true);
        this.wifiSignalTimer = null;
    }

    @Override // com.logan.camera.IRequestClient
    public void getSdCardStatus() {
        requestClient.getSdCardStatus();
        if (CameraConfig.get().isATOMSECamera() || CameraConfig.get().isATOMLTCamera()) {
            getInstance().getRemainCaptureSize();
        }
    }

    @Override // com.logan.camera.IRequestClient
    public void getWifiSignal() {
        requestClient.getWifiSignal();
    }

    @Override // com.logan.camera.IRequestClient
    public void getRecordingSdSpace() {
        requestClient.getRecordingSdSpace();
    }

    @Override // com.logan.camera.IRequestClient
    public void setRaw(boolean z) {
        requestClient.setRaw(z);
        requestClient.getSdCardStatus();
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoFormat() {
        requestClient.getPhotoFormat();
    }

    @Override // com.logan.camera.IRequestClient
    public void setPhotoOSD(boolean z) {
        requestClient.setPhotoOSD(z);
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoOSD() {
        requestClient.getPhotoOSD();
    }

    @Override // com.logan.camera.IRequestClient
    public void getRemainCaptureSize() {
        requestClient.getRemainCaptureSize();
    }

    @Override // com.logan.camera.IRequestClient
    public void setTrackTarget(boolean z) {
        requestClient.setTrackTarget(z);
    }

    @Override // com.logan.camera.IRequestClient
    public void selectTarget(TrackTarget.Box box) {
        requestClient.selectTarget(box);
    }

    @Override // com.logan.camera.IRequestClient
    public void executeShortVideo(VisionExecuteType visionExecuteType, int i, int i2) {
        requestClient.executeShortVideo(visionExecuteType, i, i2);
    }

    @Override // com.logan.camera.IRequestClient
    public void getManualModeInfo() {
        requestClient.getManualModeInfo();
    }

    @Override // com.logan.camera.IRequestClient
    public void getManualExposureValue() {
        requestClient.getManualExposureValue();
    }

    @Override // com.logan.camera.IRequestClient
    public void setManualModelInfo(ManualModeInfo manualModeInfo) {
        DDLog.m1685e(TAG, "发送手动模式数据" + manualModeInfo);
        requestClient.setManualModelInfo(manualModeInfo);
    }

    @Override // com.logan.camera.IRequestClient
    public void setPhotoRecordGps(boolean z) {
        requestClient.setPhotoRecordGps(z);
    }

    @Override // com.logan.camera.IRequestClient
    public void getPhotoRecordGps() {
        requestClient.getPhotoRecordGps();
    }

    @Override // com.logan.camera.IRequestClient
    public void setDebugCmd(byte b, byte[] bArr) {
        requestClient.setDebugCmd(b, bArr);
    }

    @Override // com.logan.camera.IRequestClient
    public void setZoomRatio(float f) {
        requestClient.setZoomRatio(f);
    }

    @Override // com.logan.camera.IRequestClient
    public void getZoomRatio() {
        requestClient.getZoomRatio();
    }

    @Override // com.logan.camera.IRequestClient
    public void setTakePhotoMode(PhotoChildMode photoChildMode) {
        requestClient.setTakePhotoMode(photoChildMode);
    }

    @Override // com.logan.camera.IRequestClient
    public void getTakePhotoMode() {
        requestClient.getTakePhotoMode();
    }

    public void setAutoMode() {
        if (manualInfoAvailable()) {
            this.manualModeInfo.isManualMode = false;
            setManualModelInfo(this.manualModeInfo);
        }
    }

    public void setManualMode() {
        if (manualInfoAvailable()) {
            this.manualModeInfo.isManualMode = true;
            setManualModelInfo(this.manualModeInfo);
        }
    }

    public void setManualWhiteBalanceMode(boolean z) {
        if (manualInfoAvailable()) {
            this.manualModeInfo.isMwbMode = !z;
            setManualModelInfo(this.manualModeInfo);
        }
    }

    public void setManualWhiteBalanceValue(int i) {
        if (manualInfoAvailable()) {
            this.manualModeInfo.wbValue = i;
            setManualModelInfo(this.manualModeInfo);
        }
    }

    public void setManualIsoValue(int i) {
        if (!manualInfoAvailable() || this.manualModeInfo.isoValue == i) {
            return;
        }
        this.manualModeInfo.isoValue = i;
        setManualModelInfo(this.manualModeInfo);
    }

    public void setManualSsValue(int i) {
        if (!manualInfoAvailable() || this.manualModeInfo.ssDown == i) {
            return;
        }
        this.manualModeInfo.ssDown = i;
        this.manualModeInfo.ssUp = 1;
        setManualModelInfo(this.manualModeInfo);
    }

    private boolean manualInfoAvailable() {
        ManualModeInfo manualModeInfo = CameraConfig.get().getManualModeInfo();
        this.manualModeInfo = manualModeInfo;
        return manualModeInfo != null;
    }

    public void startRequestSDSpace() {
        if (this.sdSpaceTimer == null) {
            CancelRunnable cancelRunnable = new CancelRunnable() { // from class: com.logan.camera.CameraCtrlPresenter.2
                @Override // com.ipotensic.baselib.utils.CancelRunnable, java.lang.Runnable
                public void run() {
                    CameraCtrlPresenter.this.getRecordingSdSpace();
                    if (CameraConfig.get().isATOMSECamera() || CameraConfig.get().isATOMLTCamera()) {
                        CameraCtrlPresenter.this.getRemainCaptureSize();
                    }
                }
            };
            this.sdSpaceTimer = cancelRunnable;
            cancelRunnable.setFuture(PhoneConfig.schedule.scheduleWithFixedDelay(this.sdSpaceTimer, 0L, 1000L, TimeUnit.MILLISECONDS));
        }
    }

    public void stopRequestSDSpace() {
        CancelRunnable cancelRunnable = this.sdSpaceTimer;
        if (cancelRunnable == null || cancelRunnable.getFuture() == null) {
            return;
        }
        this.sdSpaceTimer.getFuture().cancel(true);
        this.sdSpaceTimer = null;
    }

    /* renamed from: com.logan.camera.CameraCtrlPresenter$4 */
    static /* synthetic */ class C29144 {
        static final /* synthetic */ int[] $SwitchMap$com$logan$camera$enums$StatusEnum;

        static {
            int[] iArr = new int[StatusEnum.values().length];
            $SwitchMap$com$logan$camera$enums$StatusEnum = iArr;
            try {
                iArr[StatusEnum.STATUS_SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$logan$camera$enums$StatusEnum[StatusEnum.STATUS_NO_SD_CARD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$logan$camera$enums$StatusEnum[StatusEnum.STATUS_SD_CARD_FULL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$logan$camera$enums$StatusEnum[StatusEnum.STATUS_SD_SPEED_LOW.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public StatusEnum getStatus(BaseData baseData) {
        return ((StatusData) baseData).getStatus();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isSuccess(BaseData baseData) {
        return getStatus(baseData) == StatusEnum.STATUS_SUCCESS;
    }
}