package com.logan.upgrade.local.flight.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes3.dex */
public class UpgradeRevFwFileData extends BaseUpgradeRevData {
    public static final byte REV_REQUEST_CODE = -9;
    private short packageIndex;
    private boolean isSaveSuccess = true;
    private boolean isNotSave = false;

    @Override // com.logan.upgrade.local.flight.recv.BaseUpgradeRevData
    public void parse(byte[] bArr, int i) {
        this.packageIndex = ParseUtil.byteArr2short(new byte[]{bArr[i + 6], bArr[i + 7]});
        int i2 = i + 8;
        this.isSaveSuccess = bArr[i2] == 0;
        this.isNotSave = bArr[i2] == 2;
    }

    public short getPackageIndex() {
        return this.packageIndex;
    }

    public boolean isSaveSuccess() {
        return this.isSaveSuccess;
    }

    public boolean isNotSave() {
        return this.isNotSave;
    }
}