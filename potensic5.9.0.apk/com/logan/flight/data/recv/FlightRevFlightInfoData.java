package com.logan.flight.data.recv;

import com.ipotensic.baselib.interfaces.IPoint;
import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevFlightInfoData extends BaseFlightRevData implements IPoint {
    private int altitude;
    private double angleOfPitch;
    private double angleOfRoll;
    private int directToNorth;
    private int flightVoltage;
    private long gpsUtcTime;
    private double horizontalDistance;
    private double horizontalSpeed;
    private double lat;
    private double lng;
    private int remainedFlyTime;
    private int remoterVoltage;
    private int satellitesNum;
    private int tofHeight;
    private double verticalDistance;
    private double verticalSpeed;
    private double windDirection;
    private double windSpeed;
    private byte satellitesNumByte = 0;
    private int remainedBattery = -1;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        boolean z = bArr.length >= 52;
        this.flightVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, i) / 100;
        int i2 = i + 2;
        this.remoterVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, i2) / 100;
        this.lng = ParseUtil.getIntFromByteArr(bArr, i + 4) / 1.0E7d;
        this.lat = ParseUtil.getIntFromByteArr(bArr, i + 8) / 1.0E7d;
        int i3 = i + 12;
        this.satellitesNum = ParseUtil.byteToDecimalInt(bArr[i3]);
        this.satellitesNumByte = bArr[i3];
        this.directToNorth = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 13);
        if (z) {
            this.horizontalDistance = ParseUtil.getIntFromByteArr(bArr, i + 15) / 10.0d;
            i = i2;
        } else if (bArr.length >= i + 32 && bArr[i + 29] == 1) {
            this.horizontalDistance = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 15);
        } else {
            this.horizontalDistance = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 15) / 10.0d;
        }
        this.verticalDistance = ParseUtil.getSignedShortFromByteArr(bArr, i + 17) / 10.0d;
        this.horizontalSpeed = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 19) / 10.0d;
        this.verticalSpeed = ParseUtil.getSignedShortFromByteArr(bArr, i + 21) / 10.0d;
        this.remainedBattery = ParseUtil.byteToDecimalInt(bArr[i + 23]);
        this.remainedFlyTime = ParseUtil.byteToDecimalInt(bArr[i + 24]);
        this.angleOfPitch = ParseUtil.getSignedShortFromByteArr(bArr, i + 25);
        this.angleOfRoll = ParseUtil.getSignedShortFromByteArr(bArr, i + 27);
        if (bArr.length > i + 33) {
            this.windSpeed = ParseUtil.getSignedShortFromByteArr(bArr, i + 31) / 100.0d;
            this.windDirection = ParseUtil.getSignedShortFromByteArr(bArr, r1) / 100.0d;
        }
        if (bArr.length > i + 45) {
            this.gpsUtcTime = ParseUtil.byteArrayToLong(bArr, i + 35);
            int i4 = i + 43;
            this.altitude = ParseUtil.getIntFromByteArr(bArr, i4) / 1000;
            System.out.println(ParseUtil.byteToHexString(bArr, i4, 4));
        }
        if (bArr.length > i + 46) {
            this.tofHeight = bArr[i + 47];
        }
    }

    public double getWindSpeed() {
        return this.windSpeed;
    }

    public double getWindDirection() {
        return this.windDirection;
    }

    public int getFlightVoltage() {
        return this.flightVoltage;
    }

    public int getRemoterVoltage() {
        return this.remoterVoltage;
    }

    @Override // com.ipotensic.baselib.interfaces.IPoint
    public double getLat() {
        return this.lat;
    }

    @Override // com.ipotensic.baselib.interfaces.IPoint
    public double getLng() {
        return this.lng;
    }

    public int getSatellitesNum() {
        return this.satellitesNum;
    }

    public byte getSatellitesNumByte() {
        return this.satellitesNumByte;
    }

    public boolean isGpsWeak() {
        return this.satellitesNum < 6;
    }

    public int getDirectToNorth() {
        return this.directToNorth;
    }

    public double getHorizontalDistance() {
        return this.horizontalDistance;
    }

    public double getVerticalDistance() {
        return this.verticalDistance;
    }

    public double getHorizontalSpeed() {
        return this.horizontalSpeed;
    }

    public double getVerticalSpeed() {
        return this.verticalSpeed;
    }

    public int getRemainedBattery() {
        return this.remainedBattery;
    }

    public int getRemainedFlyTime() {
        return this.remainedFlyTime;
    }

    public double getAngleOfPitch() {
        return this.angleOfPitch;
    }

    public double getAngleOfRoll() {
        return this.angleOfRoll;
    }

    public long getGpsUtcTime() {
        return this.gpsUtcTime;
    }

    public int getAltitude() {
        return this.altitude;
    }

    public int getTofHeight() {
        return this.tofHeight;
    }

    public String toString() {
        return "FlightRevFlightInfoData{飞机电压=" + this.flightVoltage + ", 遥{控}器电压=" + this.remoterVoltage + ",\n 纬度=" + this.lat + ", 经度=" + this.lng + ",\n 卫星数量=" + this.satellitesNum + ", 指北角度=" + this.directToNorth + ",\n 水平距离=" + this.horizontalDistance + ", 垂直距离=" + this.verticalDistance + ",\n 水平速度=" + this.horizontalSpeed + ", 垂直速度=" + this.verticalSpeed + ",\n 剩余电量=" + this.remainedBattery + ", 剩余飞行时间=" + this.remainedFlyTime + ",\n 俯仰角=" + this.angleOfPitch + ", 翻滚角=" + this.angleOfRoll + ",\n 风速= " + this.windSpeed + ", 风向= " + this.windDirection + ",\n gps utc= " + this.gpsUtcTime + ", 海拔高= " + this.altitude + ", 对地高= " + this.tofHeight + '}';
    }
}