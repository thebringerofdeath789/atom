package com.logan.nativeapp;

import android.os.Environment;
import java.io.File;
import java.io.FileOutputStream;

/* loaded from: classes3.dex */
public class SpsParser {
    static boolean isSave;
    public static OnYuvListener yuvListener;

    public interface OnYuvListener {
        void onYuv(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3);
    }

    public static native int decode(byte[] bArr, int i, int i2);

    public native int[] getH265VideoWidthAndHeight(byte[] bArr, int i);

    public native int[] getVideoWidthAndHeight(byte[] bArr, int i);

    static {
        System.loadLibrary("HardCodec");
        isSave = false;
    }

    public static void setYuvListener(OnYuvListener onYuvListener) {
        yuvListener = onYuvListener;
    }

    public static void onYuvCallback(int i, int i2, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        OnYuvListener onYuvListener = yuvListener;
        if (onYuvListener != null) {
            onYuvListener.onYuv(i, i2, bArr, bArr2, bArr3);
            if (isSave) {
                return;
            }
            isSave = true;
            try {
                FileOutputStream fileOutputStream = new FileOutputStream(Environment.getExternalStorageDirectory() + File.separator + "1024x576.yuv");
                fileOutputStream.write(bArr);
                fileOutputStream.close();
            } catch (Exception unused) {
            }
        }
    }
}
