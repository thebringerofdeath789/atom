package org.apache.poi.ss.formula.ptg;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.ss.usermodel.ErrorConstants;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class Deleted3DPxg extends OperandPtg implements Pxg {
    private int externalWorkbookNumber;
    private String sheetName;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    public Deleted3DPxg(int i, String str) {
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = i;
        this.sheetName = str;
    }

    public Deleted3DPxg(String str) {
        this(-1, str);
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        if (this.externalWorkbookNumber >= 0) {
            stringBuffer.append(" [");
            stringBuffer.append("workbook=").append(getExternalWorkbookNumber());
            stringBuffer.append("] ");
        }
        stringBuffer.append("sheet=").append(getSheetName());
        stringBuffer.append(" ! ");
        stringBuffer.append(ErrorConstants.getText(23));
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public int getExternalWorkbookNumber() {
        return this.externalWorkbookNumber;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public String getSheetName() {
        return this.sheetName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public void setSheetName(String str) {
        this.sheetName = str;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        StringBuffer stringBuffer = new StringBuffer();
        if (this.externalWorkbookNumber >= 0) {
            stringBuffer.append(PropertyUtils.INDEXED_DELIM);
            stringBuffer.append(this.externalWorkbookNumber);
            stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
        }
        String str = this.sheetName;
        if (str != null) {
            SheetNameFormatter.appendFormat(stringBuffer, str);
        }
        stringBuffer.append('!');
        stringBuffer.append(ErrorConstants.getText(23));
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }
}
