package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class SendCalResultData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 17;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 24;
    }

    public void set(byte[] bArr, float f) {
        System.arraycopy(bArr, 0, this.payload, 2, bArr.length);
        byte[] float2byte = ParseUtil.float2byte(f);
        System.arraycopy(float2byte, 0, this.payload, 19, float2byte.length);
        this.payload[23] = 1;
    }
}
