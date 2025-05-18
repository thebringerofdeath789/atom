package com.logan.flight.data.send;

/* loaded from: classes.dex */
public class SendReturnAltitudeData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 22;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 3;
    }

    public void setReturnHigh(boolean z) {
        this.payload[0] = 1;
        this.payload[1] = 1;
        this.payload[2] = (byte) (z ? 160 : 240);
    }

    public void setNoConditionUnlock(boolean z) {
        this.payload[0] = 2;
        this.payload[1] = 1;
        this.payload[2] = (byte) (z ? 160 : 240);
    }
}