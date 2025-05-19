package com.logan.flight.data.recv;

import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.netty.ParseUtil;
import com.logan.flight.FlightConfig;

/* loaded from: classes.dex */
public class FlightRevVersionData extends BaseFlightRevData {
    private byte batteryCode;
    private int batteryDeviceId;
    private String batteryVersion;
    private String cameraVersion;
    private int escDeviceIdA;
    private int escDeviceIdB;
    private int escDeviceIdC;
    private int escDeviceIdD;
    private String escVersion;
    private String flightControlVersion;
    private String flightSN;
    private String fpvVersion;
    private int gimbalDeviceId;
    private String gimbalVersion;
    private byte manuFactor;
    private String remoteSN;
    private String remoterVersion;
    private String tofVersion;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        byte b;
        int i2 = i + 1;
        this.manuFactor = bArr[i];
        int i3 = i2 + 1;
        int i4 = i3 + 1;
        int i5 = i4 + 1;
        this.flightControlVersion = ParseUtil.byteToDecimalInt(bArr[i2]) + "." + ParseUtil.byteToDecimalInt(bArr[i3]) + "." + ParseUtil.byteToDecimalInt(bArr[i4]);
        int i6 = i5 + 1;
        int byteToDecimalInt = ParseUtil.byteToDecimalInt(bArr[i5]);
        int i7 = i6 + 1;
        int i8 = i7 + 1;
        this.remoterVersion = byteToDecimalInt + "." + ParseUtil.byteToDecimalInt(bArr[i6]) + "." + ParseUtil.byteToDecimalInt(bArr[i7]);
        int i9 = i8 + 1;
        int byteToDecimalInt2 = ParseUtil.byteToDecimalInt(bArr[i8]);
        int i10 = i9 + 1;
        int i11 = i10 + 1;
        this.gimbalVersion = byteToDecimalInt2 + "." + ParseUtil.byteToDecimalInt(bArr[i9]) + "." + ParseUtil.byteToDecimalInt(bArr[i10]);
        int i12 = i11 + 1;
        int byteToDecimalInt3 = ParseUtil.byteToDecimalInt(bArr[i11]);
        int i13 = i12 + 1;
        int i14 = i13 + 1;
        this.cameraVersion = byteToDecimalInt3 + "." + ParseUtil.byteToDecimalInt(bArr[i12]) + "." + ParseUtil.byteToDecimalInt(bArr[i13]);
        int i15 = i14 + 1;
        int byteToDecimalInt4 = ParseUtil.byteToDecimalInt(bArr[i14]);
        int i16 = i15 + 1;
        int i17 = i16 + 1;
        this.tofVersion = byteToDecimalInt4 + "." + ParseUtil.byteToDecimalInt(bArr[i15]) + "." + ParseUtil.byteToDecimalInt(bArr[i16]);
        int i18 = i17 + 1;
        byte[] interceptBytes = ParseUtil.interceptBytes(bArr, i17, 2);
        if (ParseUtil.getBit(interceptBytes[1], 7) == 1) {
            this.batteryVersion = String.format("%s.%s.%s", Byte.valueOf(ParseUtil.getByteFromBits(interceptBytes[1], 0, 3)), Byte.valueOf(ParseUtil.getByteFromBits(interceptBytes[0], 4, 7)), Byte.valueOf(ParseUtil.getByteFromBits(interceptBytes[0], 0, 3)));
        } else {
            this.batteryVersion = ((ParseUtil.getUnsignedShortFromByteArr(interceptBytes, 0) - 17390) / 10) + ".0";
        }
        if (bArr.length >= i + 40) {
            i18++;
            this.flightSN = ParseUtil.byteToHexString(bArr, i18, 12);
            int i19 = i18 + 12;
            if (!"000000000000000000".equals(ParseUtil.byteToHexString(bArr, i19, 9))) {
                this.flightSN += ParseUtil.byteToHexString(bArr, i19, 9);
            }
        } else if (bArr.length >= i + 31) {
            i18++;
            this.flightSN = ParseUtil.byteToHexString(bArr, i18, 12);
        }
        byte b2 = this.manuFactor;
        if (b2 != -93 && b2 != -88 && bArr.length >= i + 43) {
            this.remoteSN = ParseUtil.byteToHexString(bArr, i18 + 12, 12);
            if (bArr.length >= 75) {
                this.remoteSN = ParseUtil.byteToHexString(bArr, i18 + 21, 12);
            }
        }
        if (bArr.length >= 60 && ((b = this.manuFactor) == -79 || b == -73)) {
            byte b3 = bArr[i + 42];
            byte b4 = bArr[i + 43];
            byte b5 = bArr[i + 44];
            byte b6 = bArr[i + 45];
            byte b7 = bArr[i + 46];
            byte b8 = bArr[i + 47];
            byte b9 = bArr[i + 48];
            byte b10 = bArr[i + 49];
            byte b11 = bArr[i + 50];
            int i20 = i + 51;
            byte b12 = bArr[i20];
            int i21 = i + 52;
            byte b13 = bArr[i21];
            int i22 = i + 53;
            byte b14 = bArr[i22];
            if (bArr.length >= 75) {
                b3 = bArr[i20];
                b4 = bArr[i21];
                b5 = bArr[i22];
                byte b15 = bArr[i + 54];
                byte b16 = bArr[i + 55];
                byte b17 = bArr[i + 56];
                byte b18 = bArr[i + 57];
                byte b19 = bArr[i + 58];
                byte b20 = bArr[i + 59];
                byte b21 = bArr[i + 60];
                byte b22 = bArr[i + 61];
                byte b23 = bArr[i + 62];
            }
            this.escVersion = " v" + ((int) b3) + "." + ((int) b4) + "." + ((int) b5) + "";
        } else if (bArr.length >= 75) {
            this.batteryCode = bArr[56];
            DDLog.e("电池识别码:" + ((int) this.batteryCode));
        } else if (bArr.length >= 49) {
            this.batteryCode = bArr[47];
            DDLog.e("电池识别码:" + ((int) this.batteryCode));
        }
        if (bArr.length >= 75) {
            this.escDeviceIdA = bArr[i + 63];
            this.escDeviceIdB = bArr[i + 64];
            this.escDeviceIdC = bArr[i + 65];
            this.escDeviceIdD = bArr[i + 66];
            this.batteryDeviceId = bArr[i + 67];
            this.gimbalDeviceId = bArr[i + 68];
        } else if (bArr.length >= 66) {
            this.escDeviceIdA = bArr[i + 54];
            this.escDeviceIdB = bArr[i + 55];
            this.escDeviceIdC = bArr[i + 56];
            this.escDeviceIdD = bArr[i + 57];
            this.batteryDeviceId = bArr[i + 58];
            this.gimbalDeviceId = bArr[i + 59];
        }
        DDLog.e("飞控 飞机类型:" + ParseUtil.byteToHexString(new byte[]{this.manuFactor}));
        FlightConfig.setFlightType(this.manuFactor);
    }

    public boolean is_18650_battery() {
        int i = this.batteryDeviceId;
        return i == 112 || i == 114 || i == 116;
    }

    public boolean is_polymer_battery() {
        int i = this.batteryDeviceId;
        return i == 113 || i == 115;
    }

    public int getBatteryDeviceId() {
        return this.batteryDeviceId;
    }

    public byte getBatteryCode() {
        return this.batteryCode;
    }

    public String getTofVersion() {
        return this.tofVersion;
    }

    public String getFlightSN() {
        return this.flightSN;
    }

    public String getRemoteSN() {
        return this.remoteSN;
    }

    public byte getManuFactor() {
        return this.manuFactor;
    }

    public String getFlightControlVersion() {
        return this.flightControlVersion;
    }

    public String getRemoterVersion() {
        return this.remoterVersion;
    }

    public String getGimbalVersion() {
        return this.gimbalVersion;
    }

    public String getCameraVersion() {
        return this.cameraVersion;
    }

    public String getFpvVersion() {
        return this.fpvVersion;
    }

    public String getBatteryVersion() {
        return this.batteryVersion;
    }

    public String getEscVersion() {
        return this.escVersion;
    }

    public String toString() {
        return "FlightRevVersionData{\n 厂家=" + ParseUtil.byteToHexString(new byte[]{this.manuFactor}) + "\n , 飞控版本='" + this.flightControlVersion + "'\n , 遥控版本='" + this.remoterVersion + "'\n , 云台版本='" + this.gimbalVersion + "'\n , 相机版本='" + this.cameraVersion + "'\n , 图传版本='" + this.fpvVersion + "'\n , 智能电池版本='" + this.batteryVersion + "'\n , 电调版本='" + this.escVersion + "'\n , 飞行器SN='" + this.flightSN + "'\n , 遥控器SN='" + this.remoteSN + "'\n , 电调 device id A='" + this.escDeviceIdA + "'\n , 电调 device id B='" + this.escDeviceIdB + "'\n , 电调 device id C='" + this.escDeviceIdC + "'\n , 电调 device id D='" + this.escDeviceIdD + "'\n , 电池 device id='" + this.batteryDeviceId + "'\n , 云台 device id='" + this.gimbalDeviceId + "'}";
    }
}
