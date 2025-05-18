package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendHomeRevData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 5;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 1;
    }

    public SendHomeRevData() {
        this.payload[0] = 1;
    }
}