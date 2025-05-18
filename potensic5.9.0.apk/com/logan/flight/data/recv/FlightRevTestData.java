package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevTestData extends BaseFlightRevData {
    private boolean isGpsOpen = true;
    private boolean isOptionFlowOpen = true;
    private byte validByte = 0;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        byte b = bArr[i + 1];
        this.validByte = b;
        this.isGpsOpen = ParseUtil.getBit(b, 0) == 0;
        this.isOptionFlowOpen = ParseUtil.getBit(this.validByte, 1) == 0;
    }

    public boolean isGpsOpen() {
        return this.isGpsOpen;
    }

    public boolean isOptionFlowOpen() {
        return this.isOptionFlowOpen;
    }

    public byte getValidByte() {
        return this.validByte;
    }

    public String toString() {
        return "FlightRevTestData{isGpsOpen=" + this.isGpsOpen + ", isOptionFlowOpen=" + this.isOptionFlowOpen + '}';
    }
}