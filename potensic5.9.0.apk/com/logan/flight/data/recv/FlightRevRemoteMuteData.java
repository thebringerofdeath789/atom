package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevRemoteMuteData extends BaseFlightRevData {
    private boolean remoterMuteOpened = false;
    private boolean remoterMuteClosed = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.remoterMuteOpened = ParseUtil.getBit(bArr[i], 0) == 1;
        this.remoterMuteClosed = ParseUtil.getBit(bArr[i], 0) == 0;
    }

    public boolean isRemoterMuteOpened() {
        return this.remoterMuteOpened;
    }

    public boolean isRemoterMuteClosed() {
        return this.remoterMuteClosed;
    }

    public String toString() {
        return "FlightRevRemoteMuteData{isRemoterMuteOpened = " + this.remoterMuteOpened + ", isRemoterMuteClosed = " + this.remoterMuteClosed + '}';
    }
}