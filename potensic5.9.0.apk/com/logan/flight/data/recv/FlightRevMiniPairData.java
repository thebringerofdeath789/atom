package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevMiniPairData extends BaseFlightRevData {
    private boolean isSuccess = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.isSuccess = ParseUtil.getBit(bArr[i], 0) == 0;
    }

    public boolean isPairSuccess() {
        return this.isSuccess;
    }

    public String toString() {
        return "FlightRevMiniPairData{对频是否成功=" + this.isSuccess + '}';
    }
}