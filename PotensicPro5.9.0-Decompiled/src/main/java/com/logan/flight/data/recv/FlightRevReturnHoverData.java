package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevReturnHoverData extends BaseFlightRevData {
    private int id = -1;
    private int revHoverMsg = 0;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.id = ParseUtil.byteToDecimalInt(bArr[i]);
        this.revHoverMsg = ParseUtil.byteToDecimalInt(bArr[i + 2]);
    }

    public int getId() {
        return this.id;
    }

    public int getRevHoverMsg() {
        return this.revHoverMsg;
    }

    public String toString() {
        return "FlightRevReturnHoverData{id=" + this.id + ", revHoverMsg=" + this.revHoverMsg + '}';
    }
}
