package org.apache.poi.ss.formula.ptg;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class IntersectionPtg extends OperationPtg {
    public static final OperationPtg instance = new IntersectionPtg();
    public static final byte sid = 15;

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
        return StringUtils.SPACE;
    }

    private IntersectionPtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getPtgClass() + 15);
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append(StringUtils.SPACE);
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
