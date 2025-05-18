package com.logan.flight.data.recv;

/* loaded from: classes.dex */
public class FlightRevPTZFeedbackData extends BaseFlightRevData {
    private byte calibrationValue;
    private byte funCode;
    private byte length;
    private byte trimValue;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        byte b = bArr[i];
        this.funCode = b;
        this.length = bArr[i + 1];
        if (b == 1) {
            this.trimValue = bArr[i + 2];
        } else if (b == 2) {
            this.calibrationValue = bArr[i + 2];
        }
    }

    public byte getFunCode() {
        return this.funCode;
    }

    public byte getLength() {
        return this.length;
    }

    public byte getTrimValue() {
        return this.trimValue;
    }

    public byte getCalibrationValue() {
        return this.calibrationValue;
    }

    public String toString() {
        return "云台信息反馈{功能码=" + ((int) this.funCode) + ", 长度=" + ((int) this.length) + ", 微调值=" + ((int) this.trimValue) + '}';
    }
}