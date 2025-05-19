package org.apache.poi.ss.formula.ptg;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class UnionPtg extends OperationPtg {
    public static final OperationPtg instance = new UnionPtg();
    public static final byte sid = 16;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public final boolean isBaseToken() {
        return true;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        return ",";
    }

    private UnionPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 16);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append(",");
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
