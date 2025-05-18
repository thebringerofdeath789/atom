package com.logan.camera;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.dispatcher.EventDispatcher;
import com.ipotensic.baselib.dispatcher.EventID;
import com.ipotensic.baselib.utils.SPHelper;
import com.logan.camera.data.BaseData;
import com.logan.camera.data.CameraSupport;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.enums.CameraModel;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.enums.SdCardState;

/* loaded from: classes2.dex */
public class CameraConfig extends BaseData {
    public static final String ATOM_LT = "AtomLT";
    public static final String ATOM_PT_V2 = "AtomV2";
    public static final String ATOM_SE = "MiniSE-CAM";
    public static final String ATOM_SE_GIMBAL = "Mini-CAM";
    public static final String ATOM_SE_V2 = "AtomSE_V2";
    public static final String ATOM_SE_V3 = "AtomSEV3";
    public static final String ATOM_SP = "MiniSP-CAM";
    public static final String ATOM_V2 = "Atom_V2";

    /* renamed from: IP */
    public static final String f2417IP = "192.168.29.1";
    public static final String P1_1080P = "P1-1080P_CAM";
    public static final String P1_4K = "P1-4K30-CAM";
    public static final String P1_4K60 = "P1-4K60-CAM";
    public static final String P1_PRO = "P1-PRO-CAM";
    public static final String P1_SE = "P1-SE-CAM";
    public static final String P1_SELF = "P1-SELF-CAM";
    public static final String P1_SELF_A = "P1-A-CAM";
    public static final String P1_SELF_B = "P1-B-CAM";

    /* renamed from: P3 */
    public static final String f2418P3 = "P3-CAM";
    public static final String P3_SE = "P3-SE-CAM";

    /* renamed from: P5 */
    public static final String f2419P5 = "P5-2.7K-CAM";
    public static final int PORT = 1234;
    private static volatile CameraConfig instance;
    public static int[] supportRecordEvValues;
    public static int[] supportTakePhotoEvValues;
    public String cameraType;
    private CaptureMode captureMode;
    private boolean isPhotoGpsShow;
    private boolean isPhotoOsdShow;
    private boolean isRaw;
    private boolean isSupportAEBPhoto;
    private boolean isSupportNoFlyZone;
    private boolean isSupportTimerPhoto;
    private boolean isVideoOsdShow;
    private ManualModeInfo manualModeInfo;
    private double photoEV;
    private int photoRemain;
    private double recordEV;
    private int recordRemain;
    private long sdFreeSpace;
    private int sdStateRes;
    private long sdTotalSpace;
    private String softVersion;
    private float zoom;
    public CameraSupport supportPhotoSizes = new CameraSupport(CameraSupport.SupportType.TYPE_PHOTO_SIZE);
    public CameraSupport supportVideoSizes = new CameraSupport(CameraSupport.SupportType.TYPE_VIDEO_SIZE);
    public CameraSupport supportSplitSizes = new CameraSupport(CameraSupport.SupportType.TYPE_SPLIT_VIDEO);
    public SdCardState sdCardState = SdCardState.SD_CARD_AVAILABLE;
    private boolean isAllowCaptureInHighTemp = true;
    public boolean isGetConfigMenu = false;
    private CameraModel cameraModel = CameraModel.MODEL_59;

    private double getEvValue(int i) {
        return (i * 0.5d) - 2.0d;
    }

    private CameraConfig() {
    }

    public static CameraConfig get() {
        if (instance == null) {
            synchronized (CameraConfig.class) {
                if (instance == null) {
                    CameraConfig cameraConfig = new CameraConfig();
                    instance = cameraConfig;
                    return cameraConfig;
                }
            }
        }
        return instance;
    }

    public CameraModel getCameraModel() {
        return this.cameraModel;
    }

    public boolean isPhotoGpsShow() {
        return this.isPhotoGpsShow;
    }

    public void setPhotoGpsShow(boolean z) {
        this.isPhotoGpsShow = z;
    }

    public void setZoom(float f) {
        this.zoom = f;
    }

    public float getZoom() {
        return this.zoom;
    }

    public boolean isSupportTimerPhoto() {
        return this.isSupportTimerPhoto;
    }

    public void setSupportTimerPhoto(boolean z) {
        this.isSupportTimerPhoto = z;
    }

    public boolean isSupportAEBPhoto() {
        return this.isSupportAEBPhoto;
    }

    public void setSupportAEBPhoto(boolean z) {
        this.isSupportAEBPhoto = z;
    }

    public boolean isSupportNoFlyZone() {
        return this.isSupportNoFlyZone;
    }

    public void setSupportNoFlyZone(boolean z) {
        this.isSupportNoFlyZone = z;
    }

    public String toString() {
        return "CameraConfig{supportPhotoSizes=" + this.supportPhotoSizes + ", supportVideoSizes=" + this.supportVideoSizes + ", supportSplitSizes=" + this.supportSplitSizes + ", sdCardState=" + this.sdCardState + ", cameraType='" + this.cameraType + "', softVersion='" + this.softVersion + "', captureMode=" + this.captureMode + ", photoEV=" + this.photoEV + ", recordEV=" + this.recordEV + ", sdStateRes=" + this.sdStateRes + ", sdFreeSpace=" + this.sdFreeSpace + ", sdTotalSpace=" + this.sdTotalSpace + ", isRaw=" + this.isRaw + ", isPhotoOsdShow=" + this.isPhotoOsdShow + ", isVideoOsdShow=" + this.isVideoOsdShow + ", isAllowCaptureInHighTemp=" + this.isAllowCaptureInHighTemp + ", recordRemain=" + this.recordRemain + ", photoRemain=" + this.photoRemain + ", isGetConfigMenu=" + this.isGetConfigMenu + ", cameraModel=" + this.cameraModel + ", manualModeInfo=" + this.manualModeInfo + ", zoom=" + this.zoom + ", isSupportTimerPhoto=" + this.isSupportTimerPhoto + ", isSupportAEBPhoto=" + this.isSupportAEBPhoto + ", isSupportNoFlyZone=" + this.isSupportNoFlyZone + '}';
    }

    public void setCameraModel(String str) {
        this.cameraType = str;
        SPHelper.getInstance().setIsBigPackage(false);
        SPHelper.getInstance().setCameraClass(this.cameraType);
        if (str.equals(P1_SELF) || str.equals(f2419P5) || str.equals(P1_SELF_A)) {
            this.cameraModel = CameraModel.MODEL_56;
            return;
        }
        if (str.equals(P1_4K) || str.equals(P1_PRO) || str.equals(P1_4K60) || str.equals(P1_1080P) || str.equals(P1_SE) || str.equals(P3_SE) || str.equals(P1_SELF_B)) {
            this.cameraModel = CameraModel.MODEL_59;
        }
    }

    public boolean isSdCardAvailable() {
        return (this.sdCardState == SdCardState.SD_CARD_NOT_EXIST || this.sdCardState == SdCardState.SD_CARD_UNRECOGNIZED) ? false : true;
    }

    public boolean isNeedFormatSdCard() {
        return this.sdCardState == SdCardState.SD_CARD_NEED_FORMAT;
    }

    public void setModelForUsb(String str) {
        SPHelper.getInstance().setIsBigPackage(false);
        if (str.contains(P1_PRO)) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = P1_PRO;
        } else if (str.contains(P1_SELF_B)) {
            this.cameraModel = CameraModel.MODEL_56;
            this.cameraType = P1_SELF_B;
        } else if (str.contains(f2418P3)) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = f2418P3;
        } else if (str.contains(ATOM_SE)) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = ATOM_SE;
        } else if (str.contains(ATOM_SE_GIMBAL)) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = ATOM_SE_GIMBAL;
        } else if (str.contains(ATOM_SP)) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = ATOM_SP;
        } else if (str.contains("Atom_V2")) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = "Atom_V2";
            SPHelper.getInstance().setIsBigPackage(true);
        } else if (str.contains("AtomSE_V2")) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = "AtomSE_V2";
            SPHelper.getInstance().setIsBigPackage(true);
        } else if (str.contains("AtomSEV3")) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = "AtomSEV3";
            SPHelper.getInstance().setIsBigPackage(true);
        } else if (str.contains("AtomV2")) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = "AtomV2";
            SPHelper.getInstance().setIsBigPackage(true);
        } else if (str.contains(ATOM_LT)) {
            this.cameraModel = CameraModel.MODEL_59;
            this.cameraType = ATOM_LT;
            SPHelper.getInstance().setIsBigPackage(true);
        }
        SPHelper.getInstance().setCameraClass(this.cameraType);
        DDLog.m1684e("收到相机数据 camera model：" + this.cameraModel);
        DDLog.m1684e("收到相机数据 camera model1：" + str);
    }

    public void setCurRecordEvValueForUSB(int i) {
        if (supportRecordEvValues == null) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = supportRecordEvValues;
            if (i3 >= iArr.length) {
                break;
            }
            if (i == iArr[i3]) {
                i2 = iArr[i3];
                break;
            }
            i3++;
        }
        setRecordEV(getEvValue(i2));
    }

    public double getRecordEV() {
        return this.recordEV;
    }

    public void setRecordEV(double d) {
        this.recordEV = d;
    }

    public void setCurTakePhotoEvValueForUSB(int i) {
        if (supportTakePhotoEvValues == null) {
            return;
        }
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int[] iArr = supportTakePhotoEvValues;
            if (i3 >= iArr.length) {
                break;
            }
            if (i == iArr[i3]) {
                i2 = iArr[i3];
                break;
            }
            i3++;
        }
        setPhotoEV(getEvValue(i2));
    }

    public double getPhotoEV() {
        return this.photoEV;
    }

    public void setPhotoEV(double d) {
        this.photoEV = d;
    }

    public String getSoftVersion() {
        return this.softVersion;
    }

    public void setSoftVersion(String str) {
        DDLog.m1684e("获取相机版本：" + str);
        this.softVersion = str;
    }

    public CaptureMode getCaptureMode() {
        return this.captureMode;
    }

    public boolean isRecodeMode() {
        return getCaptureMode() == CaptureMode.MODE_REC;
    }

    public boolean isPhotoMode() {
        return getCaptureMode() == CaptureMode.MODE_PHOTO;
    }

    public void setCaptureMode(String str) {
        if (equals(str, CaptureMode.MODE_REC.getValue())) {
            this.captureMode = CaptureMode.MODE_REC;
        } else if (equals(str, CaptureMode.MODE_PHOTO.getValue())) {
            this.captureMode = CaptureMode.MODE_PHOTO;
        }
    }

    public void setCaptureMode(CaptureMode captureMode) {
        this.captureMode = captureMode;
    }

    public int getSdStateRes() {
        return this.sdStateRes;
    }

    public void setSdState(int i) {
        this.sdStateRes = i;
        if (i == 0) {
            this.sdCardState = SdCardState.SD_CARD_NOT_EXIST;
        } else if (i == 1) {
            this.sdCardState = SdCardState.SD_CARD_AVAILABLE;
        } else if (i == 3 || i == 4) {
            this.sdCardState = SdCardState.SD_CARD_NEED_FORMAT;
        } else if (i == 5) {
            this.sdCardState = SdCardState.SD_CARD_NOT_ENOUGH_SPACE;
        } else if (i == 6) {
            this.sdCardState = SdCardState.SD_CARD_LOW_SPEED;
        } else if (i == 2) {
            this.sdCardState = SdCardState.SD_CARD_UNRECOGNIZED;
        }
        EventDispatcher.get().sendEvent(EventID.EVENT_SDCARD_STATE_CHANGE);
    }

    public long getSdFreeSpace() {
        return this.sdFreeSpace;
    }

    public void setSdFreeSpace(long j) {
        DDLog.m1685e("解析相机数据", "usb sd卡可用空间：" + j);
        this.sdFreeSpace = j;
    }

    public long getSdTotalSpace() {
        return this.sdTotalSpace;
    }

    public void setSdTotalSpace(long j) {
        DDLog.m1685e("解析相机数据", "usb sd卡总空间：" + j);
        this.sdTotalSpace = j;
    }

    public boolean isRaw() {
        return this.isRaw;
    }

    public void setRaw(boolean z) {
        this.isRaw = z;
    }

    public boolean isPhotoOsdShow() {
        return this.isPhotoOsdShow;
    }

    public void setPhotoOsdShow(boolean z) {
        this.isPhotoOsdShow = z;
    }

    public boolean isVideoOsdShow() {
        return this.isVideoOsdShow;
    }

    public void setVideoOsdShow(boolean z) {
        this.isVideoOsdShow = z;
    }

    public int getRecordRemain() {
        return this.recordRemain;
    }

    public void setRecordRemain(int i) {
        this.recordRemain = i;
    }

    public int getPhotoRemain() {
        return this.photoRemain;
    }

    public void setPhotoRemain(int i) {
        this.photoRemain = i;
    }

    public boolean isAllowCaptureInHighTemp() {
        return this.isAllowCaptureInHighTemp;
    }

    public void setAllowCaptureInHighTemp(boolean z) {
        this.isAllowCaptureInHighTemp = z;
    }

    public boolean isATOMSECamera() {
        String str = this.cameraType;
        return str != null && (str.equals(ATOM_SE) || this.cameraType.equals(ATOM_SE_GIMBAL) || this.cameraType.equals(ATOM_SP) || this.cameraType.equals("Atom_V2") || this.cameraType.equals("AtomV2") || this.cameraType.equals("AtomSE_V2") || this.cameraType.equals("AtomSEV3"));
    }

    public boolean isATOMLTCamera() {
        String str = this.cameraType;
        return str != null && str.equals(ATOM_LT);
    }

    public String getCameraType() {
        return this.cameraType;
    }

    public void release() {
        DDLog.m1684e("释放相机资源");
        instance = null;
    }

    public ManualModeInfo getManualModeInfo() {
        return this.manualModeInfo;
    }

    public void setManualModeInfo(ManualModeInfo manualModeInfo) {
        this.manualModeInfo = manualModeInfo;
    }

    public boolean isManualMode() {
        ManualModeInfo manualModeInfo = this.manualModeInfo;
        return manualModeInfo != null && manualModeInfo.isManualMode;
    }

    public int getMaxZoom() {
        if (this.captureMode == CaptureMode.MODE_PHOTO) {
            return this.supportPhotoSizes.getMaxZoom();
        }
        return this.supportVideoSizes.getMaxZoom();
    }
}