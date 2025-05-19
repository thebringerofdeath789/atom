package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public final class UnaryMinusPtg extends ValueOperatorPtg {
    private static final String MINUS = "-";
    public static final ValueOperatorPtg instance = new UnaryMinusPtg();
    public static final byte sid = 19;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 19;
    }

    private UnaryMinusPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(MINUS);
        stringBuffer.append(strArr[0]);
        return stringBuffer.toString();
    }
}
