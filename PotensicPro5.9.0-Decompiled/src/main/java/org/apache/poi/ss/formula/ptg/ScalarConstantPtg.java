package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public abstract class ScalarConstantPtg extends Ptg {
    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append(toFormulaString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
