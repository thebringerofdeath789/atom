package com.logan.flight.data.recv;

/* loaded from: classes.dex */
public class FlightReturnAltitudeTestData extends BaseFlightRevData {
    private boolean turnOpen = false;
    private boolean isNoConditionUnlock = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        if (bArr.length >= i + 3) {
            if (bArr[i] == 1) {
                this.turnOpen = bArr[i + 2] == -96;
            } else if (bArr[i] == 2) {
                this.isNoConditionUnlock = bArr[i + 2] == -96;
            }
        }
    }

    public boolean isTurnOpen() {
        return this.turnOpen;
    }

    public boolean isNoConditionUnlock() {
        return this.isNoConditionUnlock;
    }
}