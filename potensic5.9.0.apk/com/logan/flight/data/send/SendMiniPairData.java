package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendMiniPairData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 24;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 0;
    }
}