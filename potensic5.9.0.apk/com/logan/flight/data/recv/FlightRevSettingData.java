package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevSettingData extends BaseFlightRevData {
    public static final int DISTANCE_NO_LIMIT = 65535;
    private boolean isAmericaRockerMode;
    private boolean isClockwise;
    private boolean isNewerModeOpen;
    private double lastLatitude;
    private double lastLongitude;
    private int limitDistance;
    private int limitHeight;
    private int returnHeight;
    private int surroundRadius;
    private int surroundSpeed;
    private int speedMode = -1;
    private boolean isNewFC = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        boolean z = bArr.length >= 28;
        this.isNewFC = z;
        if (z) {
            this.limitHeight = ParseUtil.getUnsignedShortFromByteArr(bArr, i);
            i++;
        } else {
            this.limitHeight = ParseUtil.byteToDecimalInt(bArr[i]);
        }
        int i2 = i + 1;
        this.limitDistance = ParseUtil.getUnsignedShortFromByteArr(bArr, i2);
        if (this.isNewFC) {
            this.returnHeight = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 3);
            i = i2;
        } else {
            this.returnHeight = ParseUtil.byteToDecimalInt(bArr[i + 3]);
        }
        this.isNewerModeOpen = bArr[i + 4] == -1;
        this.isAmericaRockerMode = bArr[i + 5] == 0;
        this.surroundRadius = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 6);
        this.lastLongitude = ParseUtil.getIntFromByteArr(bArr, i + 8) / 1.0E7d;
        this.lastLatitude = ParseUtil.getIntFromByteArr(bArr, i + 12) / 1.0E7d;
        int i3 = i + 16;
        if (bArr.length >= i3) {
            this.isClockwise = bArr[i3] == 1;
        }
        int i4 = i + 17;
        if (bArr.length > i4) {
            this.surroundSpeed = bArr[i4];
        }
        int i5 = i + 18;
        if (bArr.length > i5) {
            this.speedMode = bArr[i5];
        }
    }

    public boolean isNewFC() {
        return this.isNewFC;
    }

    public int getLimitHeight() {
        return this.limitHeight;
    }

    public int getLimitDistance() {
        return this.limitDistance;
    }

    public int getReturnHeight() {
        return this.returnHeight;
    }

    public boolean isNewerModeOpen() {
        return this.isNewerModeOpen;
    }

    public boolean isAmericaRockerMode() {
        return this.isAmericaRockerMode;
    }

    public int getSurroundRadius() {
        return this.surroundRadius;
    }

    public double getLastLatitude() {
        return this.lastLatitude;
    }

    public double getLastLongitude() {
        return this.lastLongitude;
    }

    public boolean isClockwise() {
        return this.isClockwise;
    }

    public int getSurroundSpeed() {
        return this.surroundSpeed;
    }

    public int getSpeedMode() {
        return this.speedMode;
    }

    public boolean isDistanceNoLimit() {
        return this.limitDistance == 65535;
    }

    public String toString() {
        return "设置:FlightRevSettingData{高度限制=" + this.limitHeight + ", 距离限制=" + this.limitDistance + ", 返航高度=" + this.returnHeight + ", 是否新手模式=" + this.isNewerModeOpen + ", 是否美国手=" + this.isAmericaRockerMode + ", 环绕半径=" + this.surroundRadius + ", 最后一次纬度=" + this.lastLatitude + ", 最后一次经度=" + this.lastLongitude + ", 是否顺时针环绕=" + this.isClockwise + ", 环绕速度=" + this.surroundSpeed + ", 速度挡=" + this.speedMode + '}';
    }
}