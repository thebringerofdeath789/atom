package com.logan.upgrade.local.flight.recv;

import com.logan.flight.FlightConfig;

/* loaded from: classes3.dex */
public class UpgradeRevShakeHandData extends BaseUpgradeRevData {
    public static final byte REV_REQUEST_CODE = -15;
    private int maxSupportLength;
    private byte supportLength;
    private byte typeByte;

    @Override // com.logan.upgrade.local.flight.recv.BaseUpgradeRevData
    public void parse(byte[] bArr, int i) {
        byte b = bArr[i + 6];
        this.supportLength = b;
        this.maxSupportLength = b * 256;
        byte b2 = bArr[i + 7];
        this.typeByte = b2;
        FlightConfig.setFlightType(b2);
    }

    public int getMaxSupportLength() {
        return this.maxSupportLength;
    }

    public byte getSupportLength() {
        return this.supportLength;
    }

    public byte getTypeByte() {
        return this.typeByte;
    }
}