package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevRemoterCalibrationData extends BaseFlightRevData implements Cloneable {
    private int LeftTrackWheelCalValue;
    private int calResult;
    private int leftBottomCalValue;
    private int leftLeftCalValue;
    private int leftRightCalValue;
    private int leftTopCalValue;
    private int rightBottomCalValue;
    private int rightLeftCalValue;
    private int rightRightCalValue;
    private int rightTopCalValue;
    private int rightTrackWheelCalValue;
    private int step;
    private boolean isLeftLeftCalSuccess = false;
    private boolean isLeftRightCalSuccess = false;
    private boolean isLeftTopCalSuccess = false;
    private boolean isLeftBottomCalSuccess = false;
    private boolean isRightLeftCalSuccess = false;
    private boolean isRightRightCalSuccess = false;
    private boolean isRightTopCalSuccess = false;
    private boolean isRightBottomCalSuccess = false;
    private boolean isLeftTrackWheelCalSuccess = false;
    private boolean isRightTrackWheelCalSuccess = false;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.step = bArr[i];
        this.calResult = bArr[i + 1];
        byte b = bArr[i + 2];
        this.isLeftLeftCalSuccess = ParseUtil.getBit(b, 0) == 1;
        this.isLeftRightCalSuccess = ParseUtil.getBit(b, 1) == 1;
        this.isLeftTopCalSuccess = ParseUtil.getBit(b, 2) == 1;
        this.isLeftBottomCalSuccess = ParseUtil.getBit(b, 3) == 1;
        this.isRightLeftCalSuccess = ParseUtil.getBit(b, 4) == 1;
        this.isRightRightCalSuccess = ParseUtil.getBit(b, 5) == 1;
        this.isRightTopCalSuccess = ParseUtil.getBit(b, 6) == 1;
        this.isRightBottomCalSuccess = ParseUtil.getBit(b, 7) == 1;
        byte b2 = bArr[i + 3];
        this.isLeftTrackWheelCalSuccess = ParseUtil.getBit(b2, 0) == 1;
        this.isRightTrackWheelCalSuccess = ParseUtil.getBit(b2, 1) == 1;
        int i2 = i + 4;
        int i3 = i2 + 1;
        this.leftLeftCalValue = bArr[i2];
        int i4 = i3 + 1;
        this.leftRightCalValue = bArr[i3];
        int i5 = i4 + 1;
        this.leftTopCalValue = bArr[i4];
        int i6 = i5 + 1;
        this.leftBottomCalValue = bArr[i5];
        int i7 = i6 + 1;
        this.rightLeftCalValue = bArr[i6];
        int i8 = i7 + 1;
        this.rightRightCalValue = bArr[i7];
        this.rightTopCalValue = bArr[i8];
        this.rightBottomCalValue = bArr[i8 + 1];
    }

    public boolean isStep1() {
        return this.step == 1;
    }

    public boolean isStep2() {
        return this.step == 2;
    }

    public boolean isStep0() {
        return this.step == 0;
    }

    public boolean isCalibrating() {
        return this.calResult == 0;
    }

    public boolean isCalSuccess() {
        return this.calResult == 1;
    }

    public boolean isCalFailed() {
        return this.calResult == 2;
    }

    public boolean isLeftLeftCalSuccess() {
        return this.isLeftLeftCalSuccess;
    }

    public boolean isLeftRightCalSuccess() {
        return this.isLeftRightCalSuccess;
    }

    public boolean isLeftTopCalSuccess() {
        return this.isLeftTopCalSuccess;
    }

    public boolean isLeftBottomCalSuccess() {
        return this.isLeftBottomCalSuccess;
    }

    public boolean isRightLeftCalSuccess() {
        return this.isRightLeftCalSuccess;
    }

    public boolean isRightRightCalSuccess() {
        return this.isRightRightCalSuccess;
    }

    public boolean isRightTopCalSuccess() {
        return this.isRightTopCalSuccess;
    }

    public boolean isRightBottomCalSuccess() {
        return this.isRightBottomCalSuccess;
    }

    public boolean isLeftTrackWheelCalSuccess() {
        return this.isLeftTrackWheelCalSuccess;
    }

    public boolean isRightTrackWheelCalSuccess() {
        return this.isRightTrackWheelCalSuccess;
    }

    public int getLeftLeftCalValue() {
        return this.leftLeftCalValue;
    }

    public int getLeftRightCalValue() {
        return this.leftRightCalValue;
    }

    public int getLeftTopCalValue() {
        return this.leftTopCalValue;
    }

    public int getLeftBottomCalValue() {
        return this.leftBottomCalValue;
    }

    public int getRightLeftCalValue() {
        return this.rightLeftCalValue;
    }

    public int getRightRightCalValue() {
        return this.rightRightCalValue;
    }

    public int getRightTopCalValue() {
        return this.rightTopCalValue;
    }

    public int getRightBottomCalValue() {
        return this.rightBottomCalValue;
    }

    public int getLeftTrackWheelCalValue() {
        return this.LeftTrackWheelCalValue;
    }

    public int getRightTrackWheelCalValue() {
        return this.rightTrackWheelCalValue;
    }

    public boolean isRockerMove() {
        return (this.leftLeftCalValue == 0 && this.leftRightCalValue == 0 && this.leftTopCalValue == 0 && this.leftBottomCalValue == 0 && this.rightLeftCalValue == 0 && this.rightRightCalValue == 0 && this.rightTopCalValue == 0 && this.rightBottomCalValue == 0 && this.LeftTrackWheelCalValue == 0 && this.rightTrackWheelCalValue == 0 && !this.isLeftTrackWheelCalSuccess && !this.isRightTrackWheelCalSuccess) ? false : true;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public FlightRevRemoterCalibrationData m2624clone() throws CloneNotSupportedException {
        return (FlightRevRemoterCalibrationData) super.clone();
    }

    public String toString() {
        return "遥控器校准{步骤=" + this.step + ", 校准结果=" + this.calResult + ", 左左校准结果=" + this.isLeftLeftCalSuccess + ", 左右校准结果=" + this.isLeftRightCalSuccess + ", 左上校准结果=" + this.isLeftTopCalSuccess + ", 左下校准结果=" + this.isLeftBottomCalSuccess + ", 右左校准结果=" + this.isRightLeftCalSuccess + ", 右右校准结果=" + this.isRightRightCalSuccess + ", 右上校准结果=" + this.isRightTopCalSuccess + ", 右下校准结果=" + this.isRightBottomCalSuccess + ", 左轮校准结果=" + this.isLeftTrackWheelCalSuccess + ", 右轮校准结果=" + this.isRightTrackWheelCalSuccess + ", 左左值=" + this.leftLeftCalValue + ", 左右值=" + this.leftRightCalValue + ", 左上值=" + this.leftTopCalValue + ", 左下值=" + this.leftBottomCalValue + ", 右左值=" + this.rightLeftCalValue + ", 右右值=" + this.rightRightCalValue + ", 右上值=" + this.rightTopCalValue + ", 右下值=" + this.rightBottomCalValue + ", 左轮值=" + this.LeftTrackWheelCalValue + ", 右轮值=" + this.rightTrackWheelCalValue + '}';
    }
}