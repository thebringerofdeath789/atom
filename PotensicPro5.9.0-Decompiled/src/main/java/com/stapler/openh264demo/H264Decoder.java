package com.stapler.openh264demo;

import com.ipotensic.baselib.DDLog;

/* loaded from: classes3.dex */
public class H264Decoder {
    private static int fps;
    private static long time1;
    private static OnYuvListener yuvListener;

    public interface OnYuvListener {
        void onYuv(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3);
    }

    public static native int decode(byte[] bArr, int i);

    public static native int destroy();

    public static native int init();

    static {
        System.loadLibrary("h264decoder");
        fps = 0;
        time1 = 0L;
    }

    public static void setYuvListener(OnYuvListener onYuvListener) {
        yuvListener = onYuvListener;
    }

    public static void onYuvCallback(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        fps++;
        if (System.currentTimeMillis() - time1 >= 1000) {
            DDLog.w(" real fps:" + fps);
            fps = 0;
            time1 = System.currentTimeMillis();
        }
        OnYuvListener onYuvListener = yuvListener;
        if (onYuvListener != null) {
            onYuvListener.onYuv(i, i2, bArr, bArr2, bArr3);
        }
    }
}
