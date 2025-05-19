package com.logan.flight.data.send;

import com.ipotensic.baselib.netty.ParseUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SendMagCalibrationResult.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H\u0016J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n¨\u0006\u000b"}, d2 = {"Lcom/logan/flight/data/send/SendMagCalibrationResult;", "Lcom/logan/flight/data/send/BaseSendData;", "()V", "getFunctionCode", "", "getPayloadLen", "", "init", "", "params", "", "Protocols_release"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes.dex */
public final class SendMagCalibrationResult extends BaseSendData {
    @Override // com.logan.flight.data.send.BaseSendData
    public short getFunctionCode() {
        return (short) 28;
    }

    @Override // com.logan.flight.data.send.BaseSendData
    public int getPayloadLen() {
        return 48;
    }

    public final void init(float[] params) {
        Intrinsics.checkParameterIsNotNull(params, "params");
        if (params.length >= 12) {
            for (int i = 0; i < 12; i++) {
                System.arraycopy(ParseUtil.float2byte(params[i]), 0, this.payload, i * 4, 4);
            }
        }
    }
}
