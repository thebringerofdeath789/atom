package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public final class UnaryPlusPtg extends ValueOperatorPtg {
    private static final String ADD = "+";
    public static final ValueOperatorPtg instance = new UnaryPlusPtg();
    public static final byte sid = 18;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 18;
    }

    private UnaryPlusPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(ADD);
        stringBuffer.append(strArr[0]);
        return stringBuffer.toString();
    }
}
