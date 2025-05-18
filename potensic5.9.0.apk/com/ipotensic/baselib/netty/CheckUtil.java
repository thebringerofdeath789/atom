package com.ipotensic.baselib.netty;

/* loaded from: classes2.dex */
public class CheckUtil {
    public static int getCheckCode(String str) {
        int i = 0;
        int i2 = 0;
        while (i < str.length()) {
            int i3 = i + 2;
            i2 ^= Integer.parseInt(str.substring(i, i3), 16);
            i = i3;
        }
        return i2;
    }

    public static byte getCheckCode(byte[] bArr) {
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            b = (byte) (b ^ bArr[i]);
        }
        return b;
    }
}