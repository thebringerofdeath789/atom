package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendEnterQuitCalibrationData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 24;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 1;
    }

    public void set(boolean z) {
        this.payload[0] = (byte) (z ? 1 : 2);
    }
}