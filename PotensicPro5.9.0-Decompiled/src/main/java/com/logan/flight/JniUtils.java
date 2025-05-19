package com.logan.flight;

import com.logan.flight.utils.MagCalibrationResult;

/* loaded from: classes.dex */
public class JniUtils {
    public static native short getCheckCode(byte[] bArr, int i, int i2);

    public static native int getFileCheckCode();

    public static native int getFileLength();

    public static native int getOctantUpgradeFwFileCrc(String str);

    public static native MagCalibrationResult magCalibration(float f, float f2, float f3, float f4, float f5, float f6, float f7, boolean z, float f8);

    public static native boolean openFile(String str);

    public static native int readBinFile(byte[] bArr, int i);

    public static native void startCalibration(double d, double d2);

    static {
        System.loadLibrary("native-lib");
    }
}
