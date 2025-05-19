package com.logan.camera.data;

import com.logan.camera.enums.CaptureMode;

/* loaded from: classes2.dex */
public class CameraInfoData extends BaseData {
    private CaptureMode captureMode;
    private boolean isRunning;
    private int recordTime;

    public CameraInfoData() {
    }

    public CameraInfoData(String str, boolean z, int i) {
        if (equals(str, CaptureMode.MODE_REC.getValue())) {
            this.captureMode = CaptureMode.MODE_REC;
        } else if (equals(str, CaptureMode.MODE_PHOTO.getValue())) {
            this.captureMode = CaptureMode.MODE_PHOTO;
        }
        this.isRunning = z;
        this.recordTime = i;
    }

    public void setCaptureMode(CaptureMode captureMode) {
        this.captureMode = captureMode;
    }

    public void setRunning(boolean z) {
        this.isRunning = z;
    }

    public void setRecordTime(int i) {
        this.recordTime = i;
    }

    public CaptureMode getCaptureMode() {
        return this.captureMode;
    }

    public boolean isRunning() {
        return this.isRunning;
    }

    public int getRecordTime() {
        return this.recordTime;
    }

    public String toString() {
        return "CameraInfoData{captureMode=" + this.captureMode + ", isRunning=" + this.isRunning + ", recordTime=" + this.recordTime + '}';
    }
}
