package com.logan.camera;

import com.ipotensic.baselib.enums.VisionExecuteType;
import com.logan.camera.data.ManualModeInfo;
import com.logan.camera.data.PhotoChildMode;
import com.logan.camera.data.TrackTarget;
import com.logan.camera.enums.CaptureMode;
import com.logan.camera.listeners.ICheckUpgradeCallback;
import com.logan.camera.listeners.IMediaInfoCallback;
import com.logan.camera.listeners.IStartUpgradeCallback;

/* loaded from: classes2.dex */
public interface IRequestClient {
    void checkUpgrade(long j, String str, ICheckUpgradeCallback iCheckUpgradeCallback);

    void executeShortVideo(VisionExecuteType visionExecuteType, int i, int i2);

    void formatSdCard();

    default void getCameraEv(int i) {
    }

    void getCameraStatus();

    void getCameraTime();

    void getConfigMenu();

    void getCurRecordSize();

    void getCurTakePhotoSize();

    void getDeviceInfo();

    void getManualExposureValue();

    void getManualModeInfo();

    void getMediaInfo(String str, IMediaInfoCallback iMediaInfoCallback);

    void getPhotoFormat();

    void getPhotoOSD();

    void getPhotoRecordGps();

    void getRecordEv();

    void getRecordSupportSize();

    void getRecordingSdSpace();

    void getRemainCaptureSize();

    void getSdCardStatus();

    void getTakePhotoEv();

    default void getTakePhotoMode() {
    }

    void getTakePhotoSupportSize();

    void getWifiSignal();

    default void getZoomRatio() {
    }

    void resetCamera();

    void selectTarget(TrackTarget.Box box);

    void setCameraMode(CaptureMode captureMode);

    void setCameraTime();

    void setDebugCmd(byte b, byte[] bArr);

    void setManualModelInfo(ManualModeInfo manualModeInfo);

    void setPhotoOSD(boolean z);

    void setPhotoRecordGps(boolean z);

    void setRaw(boolean z);

    void setRecordEv(double d);

    void setRecordSize(String str, int i);

    void setTakePhotoEv(double d);

    default void setTakePhotoMode(PhotoChildMode photoChildMode) {
    }

    void setTakePhotoSize(String str, int i);

    void setTrackTarget(boolean z);

    void setVideoSegment(String str, int i);

    default void setZoomRatio(float f) {
    }

    void startRecord();

    void startUpgrade(String str, String str2, IStartUpgradeCallback iStartUpgradeCallback);

    void stopRecord();

    void takePhoto();
}
