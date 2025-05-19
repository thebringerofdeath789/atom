package com.logan.flight.data.recv;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FlightRevMagCalibrationResultData.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u000e"}, d2 = {"Lcom/logan/flight/data/recv/FlightRevMagCalibrationResultData;", "Lcom/logan/flight/data/recv/BaseFlightRevData;", "()V", "result", "", "getResult", "()[B", "setResult", "([B)V", "parseData", "", "data", "payloadIndex", "", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class FlightRevMagCalibrationResultData extends BaseFlightRevData {
    private byte[] result = new byte[48];

    public final byte[] getResult() {
        return this.result;
    }

    public final void setResult(byte[] bArr) {
        Intrinsics.checkParameterIsNotNull(bArr, "<set-?>");
        this.result = bArr;
    }

    @Override // com.logan.flight.data.recv.BaseFlightRevData
    protected void parseData(byte[] data, int payloadIndex) {
        Intrinsics.checkParameterIsNotNull(data, "data");
        if (data.length >= 54) {
            byte[] bArr = this.result;
            System.arraycopy(data, payloadIndex, bArr, 0, bArr.length);
        }
    }
}
