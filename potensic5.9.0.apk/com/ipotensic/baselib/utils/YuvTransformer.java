package com.ipotensic.baselib.utils;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: classes2.dex */
public class YuvTransformer {
    public static void nv12ToYuv420(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            if (i7 % 2 == 0) {
                bArr3[i6] = bArr[i3 + i7];
                i6++;
            } else {
                bArr4[i5] = bArr[i3 + i7];
                i5++;
            }
        }
    }

    public static void nv21ToYuv420(byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 2;
        System.arraycopy(bArr, 0, bArr2, 0, i3);
        int i5 = 0;
        int i6 = 0;
        for (int i7 = 0; i7 < i4; i7++) {
            if (i7 % 2 == 0) {
                bArr4[i6] = bArr[i3 + i7];
                i6++;
            } else {
                bArr3[i5] = bArr[i3 + i7];
                i5++;
            }
        }
    }

    public static byte[] getNv21(byte[] bArr, byte[] bArr2, byte[] bArr3, int i, int i2) {
        int i3 = i * i2;
        int i4 = i3 / 4;
        byte[] bArr4 = new byte[i3 + i4 + i4];
        System.arraycopy(bArr, 0, bArr4, 0, i3);
        for (int i5 = 0; i5 < i4; i5++) {
            int i6 = (i5 * 2) + i3;
            bArr4[i6] = bArr3[i5];
            bArr4[i6 + 1] = bArr2[i5];
        }
        return bArr4;
    }

    public static Bitmap nv21ToBitmap(byte[] bArr, int i, int i2) {
        ByteArrayOutputStream byteArrayOutputStream;
        ByteArrayOutputStream byteArrayOutputStream2 = null;
        try {
            YuvImage yuvImage = new YuvImage(bArr, 17, i, i2, null);
            byteArrayOutputStream = new ByteArrayOutputStream();
            try {
                yuvImage.compressToJpeg(new Rect(0, 0, i, i2), 80, byteArrayOutputStream);
                Bitmap decodeByteArray = BitmapFactory.decodeByteArray(byteArrayOutputStream.toByteArray(), 0, byteArrayOutputStream.size());
                try {
                    byteArrayOutputStream.close();
                } catch (Exception unused) {
                }
                return decodeByteArray;
            } catch (Exception unused2) {
                if (byteArrayOutputStream != null) {
                    try {
                        byteArrayOutputStream.close();
                    } catch (Exception unused3) {
                    }
                }
                return null;
            } catch (Throwable th) {
                th = th;
                byteArrayOutputStream2 = byteArrayOutputStream;
                if (byteArrayOutputStream2 != null) {
                    try {
                        byteArrayOutputStream2.close();
                    } catch (Exception unused4) {
                    }
                }
                throw th;
            }
        } catch (Exception unused5) {
            byteArrayOutputStream = null;
        } catch (Throwable th2) {
            th = th2;
        }
    }
}