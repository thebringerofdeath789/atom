package com.logan.nativeapp;

/* loaded from: classes3.dex */
public class H264HardDecoder {
    public static OnYuvCallback yuvCallback;

    public static native int decode(byte[] bArr, int i);

    public static native int init(byte[] bArr, int i, byte[] bArr2, int i2);

    public static native int release();

    static {
        System.loadLibrary("HardCodec");
    }

    public static void setOnYuvCallback(OnYuvCallback onYuvCallback) {
        yuvCallback = onYuvCallback;
    }

    public static void onYuvCallback(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        if (yuvCallback != null) {
            yuvCallback.callback(new I420(bArr, bArr2, bArr3, i, i2));
        }
    }
}
