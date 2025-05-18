package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevForceTakeoff extends BaseFlightRevData {
    private boolean isForceTakeoff;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.isForceTakeoff = ParseUtil.getBit(bArr[i], 0) == 1;
    }

    public boolean isForceTakeoff() {
        return this.isForceTakeoff;
    }
}