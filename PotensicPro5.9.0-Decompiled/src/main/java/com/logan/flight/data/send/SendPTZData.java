package com.logan.flight.data.send;

import com.logan.flight.FlightConfig;

/* loaded from: classes.dex */
public class SendPTZData extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 19;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 3;
    }

    public void init(int i) {
        this.payload[0] = 1;
        this.payload[1] = 1;
        this.payload[2] = (byte) i;
    }

    public void startPtzCalibration() {
        this.payload[0] = 2;
        this.payload[1] = 1;
        this.payload[2] = FlightConfig.P1_SELF;
    }
}
