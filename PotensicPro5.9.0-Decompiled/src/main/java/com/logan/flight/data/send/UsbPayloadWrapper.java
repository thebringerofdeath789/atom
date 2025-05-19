package com.logan.flight.data.send;

import com.ipotensic.baselib.configs.UsbConfig;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class UsbPayloadWrapper {
    public static byte[] wrap(short s, byte[] bArr) {
        int payloadIndex = UsbConfig.getPayloadIndex(0);
        int length = bArr.length + payloadIndex + 1;
        byte[] bArr2 = new byte[length];
        bArr2[0] = UsbConfig.SEND_HEAD[0];
        bArr2[1] = UsbConfig.SEND_HEAD[1];
        ParseUtil.short2ByteArr((short) ((payloadIndex - 3) + bArr.length), bArr2, 2);
        if (UsbConfig.isNewFC) {
            ParseUtil.short2ByteArr(s, bArr2, 4);
        } else {
            bArr2[4] = (byte) s;
        }
        System.arraycopy(bArr, 0, bArr2, payloadIndex, bArr.length);
        bArr2[length - 1] = ParseUtil.getCheckCode(bArr2, 2, length - 2);
        if (s == 126) {
            bArr2[1] = -2;
        }
        return bArr2;
    }
}
