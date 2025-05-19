package org.apache.poi.ss.formula.ptg;

import io.netty.handler.codec.http.websocketx.WebSocketServerHandshaker;

/* loaded from: classes5.dex */
public final class MultiplyPtg extends ValueOperatorPtg {
    public static final ValueOperatorPtg instance = new MultiplyPtg();
    public static final byte sid = 5;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 5;
    }

    private MultiplyPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append(WebSocketServerHandshaker.SUB_PROTOCOL_WILDCARD);
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
