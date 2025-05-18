package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevGpsTestData extends BaseFlightRevData implements Cloneable {
    public static final byte REV_GPS_TEST = 11;
    private boolean isInit = false;
    private long timeStamp = 0;
    private boolean isGpsReady = false;
    private int gpsNum = 0;
    private float gps_sacc = 0.0f;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    public void parseData(byte[] bArr, int i) {
        this.isInit = true;
        this.timeStamp = ParseUtil.getIntFromByteArr(bArr, i);
        this.isGpsReady = bArr[i + 4] == 1;
        this.gpsNum = bArr[i + 5];
        this.gps_sacc = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 6) / 1000.0f;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    public boolean isInit() {
        return this.isInit;
    }

    public long getTimeStamp() {
        return this.timeStamp;
    }

    public boolean isGpsReady() {
        return this.isGpsReady;
    }

    public int getGpsNum() {
        return this.gpsNum;
    }

    public float getGps_sacc() {
        return this.gps_sacc;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevGpsTestData m2619clone() throws CloneNotSupportedException {
        return (FlightRevGpsTestData) super.clone();
    }

    public String toString() {
        return "FlightRevGpsTestData{时间戳 =" + this.timeStamp + ", gps是否准备好 =" + this.isGpsReady + ", gps星数=" + this.gpsNum + ", gps速度精度=" + this.gps_sacc + '}';
    }
}