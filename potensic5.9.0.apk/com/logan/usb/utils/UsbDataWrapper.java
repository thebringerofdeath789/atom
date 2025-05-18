package com.logan.usb.utils;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes3.dex */
public class UsbDataWrapper {
    public static final byte[] USB_HEAD = {-2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};

    public static synchronized byte[] wrap(byte[] bArr, byte b) {
        byte[] bArr2;
        synchronized (UsbDataWrapper.class) {
            byte[] bArr3 = USB_HEAD;
            bArr3[7] = b;
            ParseUtil.intBigByteArr(bArr.length, bArr3, 12);
            if (bArr3[15] != bArr.length) {
                System.out.println("数据对不上:\n");
            }
            bArr2 = new byte[bArr3.length + bArr.length];
            System.arraycopy(bArr3, 0, bArr2, 0, bArr3.length);
            System.arraycopy(bArr, 0, bArr2, 16, bArr.length);
        }
        return bArr2;
    }
}