package com.camera.util;

/* loaded from: classes.dex */
public class AngleUtil {
    public static int getSensorAngle(float f, float f2) {
        if (Math.abs(f) <= Math.abs(f2)) {
            return (f2 <= 7.0f && f2 < -7.0f) ? 180 : 0;
        }
        if (f > 4.0f) {
            return 270;
        }
        return f < -4.0f ? 90 : 0;
    }
}