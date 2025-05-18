package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevRemoterBatteryData extends BaseFlightRevData {
    private int remoterBatteryVoltage;
    private int remoterBatteryCap = 5;
    private boolean isInit = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        if (bArr.length > i + 3) {
            this.isInit = true;
            this.remoterBatteryVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, i);
            this.remoterBatteryCap = bArr[i + 2];
        }
    }

    public int getRemoterBatteryVoltage() {
        return this.remoterBatteryVoltage;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    public boolean isInit() {
        return this.isInit;
    }

    public boolean isRemoterLowPower() {
        int i = this.remoterBatteryCap;
        return i != -1 && i < 3;
    }

    public String toString() {
        return "FlightRevRemoterBatteryData{遥控器电压=" + this.remoterBatteryVoltage + ", 遥控器电池电量=" + this.remoterBatteryCap + '}';
    }
}