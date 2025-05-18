package com.logan.flight.data.recv;

import com.ipotensic.baselib.interfaces.IPoint;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevHomePointData extends BaseFlightRevData implements IPoint {
    private double homeLat;
    private double homeLng;
    private Boolean isSyncHome = null;
    private boolean isInitThisFly = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        int intFromByteArr = ParseUtil.getIntFromByteArr(bArr, i);
        this.homeLat = ParseUtil.getIntFromByteArr(bArr, i + 4) / 1.0E7d;
        this.homeLng = intFromByteArr / 1.0E7d;
        if (bArr.length > i + 9) {
            this.isSyncHome = Boolean.valueOf(ParseUtil.getBit(bArr[i + 8], 0) == 1);
        }
    }

    public boolean isInitThisFly() {
        return this.isInitThisFly;
    }

    public void setInitThisFly(boolean z) {
        this.isInitThisFly = z;
    }

    public Boolean isSyncHome() {
        return this.isSyncHome;
    }

    @Override // com.ipotensic.baselib.interfaces.IPoint
    public double getLat() {
        return this.homeLat;
    }

    @Override // com.ipotensic.baselib.interfaces.IPoint
    public double getLng() {
        return this.homeLng;
    }

    public String toString() {
        return "FlightRevHomePointData{homeLat=" + this.homeLat + ", homeLng=" + this.homeLng + ", isSyncHome=" + this.isSyncHome + '}';
    }
}