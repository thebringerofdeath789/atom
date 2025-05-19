package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevGeoTestData extends BaseFlightRevData {
    private byte[] compassData = new byte[12];
    private float compassX;
    private float compassY;
    private float compassZ;
    private int level;
    private byte[] payload;
    private float tofHeight;
    private float tofPrecision;
    private short tofTemperature;
    private float xGyro;
    private float yGyro;
    private float zGyro;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.compassX = ParseUtil.getFloatFromBytesBig(bArr, i);
        this.compassY = ParseUtil.getFloatFromBytesBig(bArr, i + 4);
        int i2 = i + 8;
        this.compassZ = ParseUtil.getFloatFromBytesBig(bArr, i2);
        this.level = bArr[i + 12];
        byte[] bArr2 = new byte[i2];
        this.payload = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        byte[] bArr3 = this.compassData;
        System.arraycopy(bArr, i, bArr3, 0, bArr3.length);
        if (bArr.length > i + 25) {
            this.xGyro = ParseUtil.getSignedShortFromByteArr(bArr, i + 19) * 1.0f;
            this.yGyro = ParseUtil.getSignedShortFromByteArr(bArr, i + 21) * 1.0f;
            this.zGyro = ParseUtil.getSignedShortFromByteArr(bArr, i + 23) * 1.0f;
        }
        int i3 = i + 35;
        if (bArr.length > i3) {
            this.tofHeight = ParseUtil.getFloatFromBytesBig(bArr, i + 29);
            this.tofPrecision = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 33) * 1.0f;
        }
        if (bArr.length > i + 37) {
            this.tofTemperature = ParseUtil.getSignedShortFromByteArr(bArr, i3);
        }
    }

    public float getCompassX() {
        return this.compassX;
    }

    public float getCompassY() {
        return this.compassY;
    }

    public float getCompassZ() {
        return this.compassZ;
    }

    public float getXGyro() {
        return this.xGyro;
    }

    public float getYGyro() {
        return this.yGyro;
    }

    public float getZGyro() {
        return this.zGyro;
    }

    public int getLevel() {
        return this.level;
    }

    public byte[] getPayload() {
        return this.payload;
    }

    public byte[] getCompassData() {
        return this.compassData;
    }

    public float getTofHeight() {
        return this.tofHeight;
    }

    public float getTofPrecision() {
        return this.tofPrecision;
    }

    public short getTofTemperature() {
        return this.tofTemperature;
    }

    public String toString() {
        return "FlightRevGeoTestData{compassX=" + this.compassX + ", compassY=" + this.compassY + ", compassZ=" + this.compassZ + ", level=" + this.level + ", xGyro=" + this.xGyro + ", yGyro=" + this.yGyro + ", zGyro=" + this.zGyro + ", tofHeight = " + this.tofHeight + ", tofPrecision = " + this.tofPrecision + ", tofTemperature = " + ((int) this.tofTemperature) + '}';
    }
}
