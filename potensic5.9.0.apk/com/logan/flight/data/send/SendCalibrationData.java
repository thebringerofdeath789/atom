package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendCalibrationData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 18;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 4;
    }

    public SendCalibrationData() {
        this.payload[0] = 1;
        this.payload[1] = 1;
    }
}