package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.listeners.IGpsController;

/* loaded from: classes.dex */
public class SendGpsData extends BaseSendData implements IGpsController {
    public static final byte[] FOLLOWING_DATA = {-1, -1};
    public static final byte[] FOLLOW_DATA = {0, 0};

    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 0;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 16;
    }

    @Override // com.logan.flight.listeners.IGpsController
    public void setGpsInfo(double d, double d2, short s, short s2, short s3) {
        ParseUtil.intSmallByteArr((int) (d * 1.0E7d), this.payload, 0);
        ParseUtil.intSmallByteArr((int) (d2 * 1.0E7d), this.payload, 4);
        ParseUtil.short2ByteArr(s, this.payload, 8);
        ParseUtil.short2ByteArr(s2, this.payload, 10);
        ParseUtil.short2ByteArr(s3, this.payload, 12);
    }

    @Override // com.logan.flight.listeners.IGpsController
    public void setFollow() {
        byte b = this.payload[14];
        byte[] bArr = FOLLOWING_DATA;
        if (b == bArr[0] && this.payload[15] == bArr[1]) {
            System.arraycopy(FOLLOW_DATA, 0, this.payload, 14, 2);
        } else {
            System.arraycopy(bArr, 0, this.payload, 14, 2);
        }
    }
}