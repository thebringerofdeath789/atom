package org.apache.poi.ss.formula.ptg;

import net.lingala.zip4j.util.InternalZipConstants;

/* loaded from: classes5.dex */
public final class DividePtg extends ValueOperatorPtg {
    public static final ValueOperatorPtg instance = new DividePtg();
    public static final byte sid = 6;

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public int getNumberOfOperands() {
        return 2;
    }

    @Override // org.apache.poi.ss.formula.ptg.ValueOperatorPtg
    protected byte getSid() {
        return (byte) 6;
    }

    private DividePtg() {
    }

    @Override // org.apache.poi.ss.formula.ptg.OperationPtg
    public String toFormulaString(String[] strArr) {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(strArr[0]);
        stringBuffer.append(InternalZipConstants.ZIP_FILE_SEPARATOR);
        stringBuffer.append(strArr[1]);
        return stringBuffer.toString();
    }
}
