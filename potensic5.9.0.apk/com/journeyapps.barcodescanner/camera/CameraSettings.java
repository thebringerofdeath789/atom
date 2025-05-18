package com.journeyapps.barcodescanner.camera;

/* loaded from: classes2.dex */
public class CameraSettings {
    private int requestedCameraId = -1;
    private boolean scanInverted = false;
    private boolean barcodeSceneModeEnabled = false;
    private boolean meteringEnabled = false;
    private boolean autoFocusEnabled = true;
    private boolean continuousFocusEnabled = false;
    private boolean exposureEnabled = false;
    private boolean autoTorchEnabled = false;
    private FocusMode focusMode = FocusMode.AUTO;

    public enum FocusMode {
        AUTO,
        CONTINUOUS,
        INFINITY,
        MACRO
    }

    public int getRequestedCameraId() {
        return this.requestedCameraId;
    }

    public void setRequestedCameraId(int i) {
        this.requestedCameraId = i;
    }

    public boolean isScanInverted() {
        return this.scanInverted;
    }

    public void setScanInverted(boolean z) {
        this.scanInverted = z;
    }

    public boolean isBarcodeSceneModeEnabled() {
        return this.barcodeSceneModeEnabled;
    }

    public void setBarcodeSceneModeEnabled(boolean z) {
        this.barcodeSceneModeEnabled = z;
    }

    public boolean isExposureEnabled() {
        return this.exposureEnabled;
    }

    public void setExposureEnabled(boolean z) {
        this.exposureEnabled = z;
    }

    public boolean isMeteringEnabled() {
        return this.meteringEnabled;
    }

    public void setMeteringEnabled(boolean z) {
        this.meteringEnabled = z;
    }

    public boolean isAutoFocusEnabled() {
        return this.autoFocusEnabled;
    }

    public void setAutoFocusEnabled(boolean z) {
        this.autoFocusEnabled = z;
        if (z && this.continuousFocusEnabled) {
            this.focusMode = FocusMode.CONTINUOUS;
        } else if (z) {
            this.focusMode = FocusMode.AUTO;
        } else {
            this.focusMode = null;
        }
    }

    public boolean isContinuousFocusEnabled() {
        return this.continuousFocusEnabled;
    }

    public void setContinuousFocusEnabled(boolean z) {
        this.continuousFocusEnabled = z;
        if (z) {
            this.focusMode = FocusMode.CONTINUOUS;
        } else if (this.autoFocusEnabled) {
            this.focusMode = FocusMode.AUTO;
        } else {
            this.focusMode = null;
        }
    }

    public FocusMode getFocusMode() {
        return this.focusMode;
    }

    public void setFocusMode(FocusMode focusMode) {
        this.focusMode = focusMode;
    }

    public boolean isAutoTorchEnabled() {
        return this.autoTorchEnabled;
    }

    public void setAutoTorchEnabled(boolean z) {
        this.autoTorchEnabled = z;
    }
}