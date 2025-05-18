package com.logan.camera.enums;

/* loaded from: classes2.dex */
public enum CaptureMode {
    MODE_REC("NORM_REC"),
    MODE_PHOTO("SING_PHOTO");

    private String mode;

    CaptureMode(String str) {
        this.mode = str;
    }

    public String getValue() {
        return this.mode;
    }
}