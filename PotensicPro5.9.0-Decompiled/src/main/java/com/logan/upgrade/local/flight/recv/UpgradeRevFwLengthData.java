package com.logan.upgrade.local.flight.recv;

/* loaded from: classes3.dex */
public class UpgradeRevFwLengthData extends BaseUpgradeRevData {
    public static final byte REV_REQUEST_CODE = -11;
    private boolean isLengthAccept = true;

    @Override // com.logan.upgrade.local.flight.recv.BaseUpgradeRevData
    public void parse(byte[] bArr, int i) {
        this.isLengthAccept = bArr[i + 6] == 0;
    }

    public boolean isLengthAccept() {
        return this.isLengthAccept;
    }
}
