package com.logan.flight.utils;

import java.util.List;

/* loaded from: classes.dex */
public class ByteUtil {
    public static void listAddArray(List<Byte> list, byte[] bArr) {
        for (byte b : bArr) {
            list.add(Byte.valueOf(b));
        }
    }

    public static byte[] byteListToByteArray(List<Byte> list) {
        byte[] bArr = new byte[list.size()];
        for (int i = 0; i < list.size(); i++) {
            bArr[i] = list.get(i).byteValue();
        }
        return bArr;
    }
}
