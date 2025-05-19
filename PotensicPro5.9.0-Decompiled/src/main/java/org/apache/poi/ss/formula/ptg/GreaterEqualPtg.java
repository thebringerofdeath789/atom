package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public final class GreaterEqualPtg extends ValueOperatorPtg {
    public static final int SIZE = 1;
    public static final ValueOperatorPtg instance = new GreaterEqualPtg();
    public static final byte sid = 12;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 12;
    }

    private GreaterEqualPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append(">=");
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
