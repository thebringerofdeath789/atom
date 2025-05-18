package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevBatteryData extends BaseFlightRevData {
    private int batteryType;
    private int curCur;
    private float firstVoltage;
    private float fourthVoltage;
    private int loopNum;
    private int remainCapacity;
    private int remainFlightTime;
    private float secondVoltage;
    private float thirdVoltage;
    private byte[] voltageBytes = new byte[8];
    private int temperature = -1;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.batteryType = bArr[i];
        this.firstVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, r0) / 100.0f;
        this.secondVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 3) / 100.0f;
        this.thirdVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 5) / 100.0f;
        this.fourthVoltage = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 7) / 100.0f;
        byte[] bArr2 = this.voltageBytes;
        System.arraycopy(bArr, i + 1, bArr2, 0, bArr2.length);
        this.temperature = ParseUtil.getSignedShortFromByteArr(bArr, i + 9);
        this.loopNum = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 11);
        short signedShortFromByteArr = ParseUtil.getSignedShortFromByteArr(bArr, i + 13);
        this.curCur = signedShortFromByteArr;
        this.curCur = Math.abs((int) signedShortFromByteArr);
        this.remainFlightTime = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 15);
        this.remainCapacity = ParseUtil.getUnsignedShortFromByteArr(bArr, i + 17);
    }

    public int getBatteryType() {
        return this.batteryType;
    }

    public float getFirstVoltage() {
        return this.firstVoltage;
    }

    public float getSecondVoltage() {
        return this.secondVoltage;
    }

    public float getThirdVoltage() {
        return this.thirdVoltage;
    }

    public float getFourthVoltage() {
        return this.fourthVoltage;
    }

    public byte[] getVoltageBytes() {
        return this.voltageBytes;
    }

    public int getTemperature() {
        return this.temperature;
    }

    public int getLoopNum() {
        return this.loopNum;
    }

    public int getCurCur() {
        return this.curCur;
    }

    public int getRemainFlightTime() {
        return this.remainFlightTime;
    }

    public int getRemainCapacity() {
        return this.remainCapacity;
    }

    public String toString() {
        return "FlightRevBatteryData{电池类型=" + this.batteryType + ", 第一节电池电压=" + this.firstVoltage + ", 第二节电池电压=" + this.secondVoltage + ", 第三节电池电压=" + this.thirdVoltage + ", 第四节电池电压=" + this.fourthVoltage + ", 温度=" + this.temperature + ", 已循环次数=" + this.loopNum + ", 当前电流=" + this.curCur + ", 剩余飞行时间=" + this.remainFlightTime + ", 剩余容量=" + this.remainCapacity + '}';
    }
}