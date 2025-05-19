package com.ipotensic.baselib.enums;

/* loaded from: classes2.dex */
public enum VisionError {
    ERROR_TARGET_LOSE(1),
    ERROR_HEIGHT_TOO_LOW(2),
    ERROR_GIMBAL_ANGLE_TOO_BIG(3),
    ERROR_TARGET_TOO_CLOSE(4),
    ERROR_CAMERA_ERROR(5),
    ERROR_GIMBAL_TOO_SMOOTH(6),
    ERROR_EXIT(7),
    ERROR_CAMERA_UNKNOWN(-1);

    public int value;

    VisionError(int i) {
        this.value = i;
    }

    public static VisionError getError(int i) {
        for (VisionError visionError : values()) {
            if (visionError.value == i) {
                return visionError;
            }
        }
        return null;
    }
}
