package com.logan.flight.data.recv;

import com.ipotensic.baselib.netty.ParseUtil;

/* loaded from: classes.dex */
public class FlightRevCalibrationFeedbackData extends BaseFlightRevData {
    private byte calibrationProcedure;
    private byte calibrationResults;
    private boolean isBack;
    private byte isCalibrationResult;
    private Boolean isCalibrationSuccess = null;
    private boolean isLeft;
    private boolean isLevel;
    private boolean isNoseDown;
    private boolean isNoseUp;
    private boolean isRight;
    private boolean isSixFacesCalibration;
    private boolean isSixFacesCalibrationStart;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        this.isSixFacesCalibration = bArr[i] == 1;
        this.isSixFacesCalibrationStart = ParseUtil.getBit(bArr[i + 1], 0) == 1;
        this.calibrationProcedure = bArr[i + 2];
        byte b = bArr[i + 3];
        this.calibrationResults = b;
        this.isLevel = ParseUtil.getBit(b, 0) == 1;
        this.isNoseDown = ParseUtil.getBit(this.calibrationResults, 1) == 1;
        this.isNoseUp = ParseUtil.getBit(this.calibrationResults, 2) == 1;
        this.isLeft = ParseUtil.getBit(this.calibrationResults, 3) == 1;
        this.isRight = ParseUtil.getBit(this.calibrationResults, 4) == 1;
        this.isBack = ParseUtil.getBit(this.calibrationResults, 5) == 1;
        this.isCalibrationResult = bArr[i + 4];
    }

    public boolean isSixFacesCalibration() {
        return this.isSixFacesCalibration;
    }

    public boolean isSixFacesCalibrationStart() {
        return this.isSixFacesCalibrationStart;
    }

    public byte getCalibrationProcedure() {
        return this.calibrationProcedure;
    }

    public byte getCalibrationResults() {
        return this.calibrationResults;
    }

    public Boolean isCalibrationSuccess() {
        byte b = this.isCalibrationResult;
        if (b == 0) {
            return null;
        }
        return Boolean.valueOf(b == 1);
    }

    public boolean isLevel() {
        return this.isLevel;
    }

    public boolean isNoseDown() {
        return this.isNoseDown;
    }

    public boolean isNoseUp() {
        return this.isNoseUp;
    }

    public boolean isLeft() {
        return this.isLeft;
    }

    public boolean isRight() {
        return this.isRight;
    }

    public boolean isBack() {
        return this.isBack;
    }

    public String toString() {
        return "校准信息反馈{六面校准=" + this.isSixFacesCalibration + ", 六面校准启动=" + this.isSixFacesCalibrationStart + ", 校准步骤反馈=" + ((int) this.calibrationProcedure) + ", 校准结果=" + ((int) this.calibrationResults) + ", isLevel=" + this.isLevel + ", isNoseDown=" + this.isNoseDown + ", isNoseUp=" + this.isNoseUp + ", isLeft=" + this.isLeft + ", isRight=" + this.isRight + ", isBack=" + this.isBack + ", 校准成功=" + this.isCalibrationSuccess + '}';
    }
}
