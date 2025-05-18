package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendReplyTakeoff extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 21;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 6;
    }
}