package com.logan.upgrade.local.flight.recv;

/* loaded from: classes3.dex */
public class UpgradeRevFwRunData extends BaseUpgradeRevData {
    public static final byte REV_REQUEST_CODE = -7;
    private boolean hasRightFwToRun = true;

    @Override // com.logan.upgrade.local.flight.recv.BaseUpgradeRevData
    public void parse(byte[] bArr, int i) {
        this.hasRightFwToRun = bArr[i + 6] == 1;
    }

    public boolean isHasRightFwToRun() {
        return this.hasRightFwToRun;
    }
}
