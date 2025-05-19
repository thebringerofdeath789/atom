package com.logan.flight.data.recv;

/* loaded from: classes.dex */
public class FlightRevUpgradeData extends BaseFlightRevData {
    private boolean isUpgradeMode;
    private byte upgradeType;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.upgradeType = bArr[i];
        if (bArr[i + 1] == 2) {
            this.isUpgradeMode = true;
        }
    }

    public boolean isUpgradeMode() {
        return this.isUpgradeMode;
    }

    public byte getUpgradeType() {
        return this.upgradeType;
    }
}
