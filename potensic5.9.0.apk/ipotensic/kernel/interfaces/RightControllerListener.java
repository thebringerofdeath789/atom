package com.ipotensic.kernel.interfaces;

import com.logan.camera.enums.CaptureMode;

/* loaded from: classes2.dex */
public interface RightControllerListener {
    void onCameraSetClicked();

    void onGalleryClicked();

    void onSwitchAutoOrManualModeClicked();

    void onSwitchModeClicked(CaptureMode captureMode);
}