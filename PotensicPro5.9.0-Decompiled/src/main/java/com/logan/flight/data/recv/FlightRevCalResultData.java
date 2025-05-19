package com.logan.flight.data.recv;

/* loaded from: classes.dex */
public class FlightRevCalResultData extends BaseFlightRevData {
    private byte[] param_id = new byte[17];
    private int param_result;
    private int param_type;

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] bArr, int i) {
        byte[] bArr2 = this.param_id;
        System.arraycopy(bArr, i, bArr2, 0, bArr2.length);
        this.param_type = bArr[i + 17];
        this.param_result = bArr[i + 18];
    }

    public byte[] getParam_id() {
        return this.param_id;
    }

    public int getParam_type() {
        return this.param_type;
    }

    public boolean isSuccess() {
        return this.param_result == 0;
    }

    public String toString() {
        return "FlightRevCalResultData{param_id='" + new String(this.param_id) + "', param_type=" + this.param_type + ", param_result=" + this.param_result + '}';
    }
}
