package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public final class PowerPtg extends ValueOperatorPtg {
    public static final ValueOperatorPtg instance = new PowerPtg();
    public static final byte sid = 7;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 7;
    }

    private PowerPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append("^");
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
