package org.apache.poi.ss.formula.ptg;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.poi.ss.formula.SheetNameFormatter;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class NameXPxg extends OperandPtg implements Pxg {
    private int externalWorkbookNumber;
    private String nameName;
    private String sheetName;

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public byte getDefaultOperandClass() {
        return (byte) 32;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public int getSize() {
        return 1;
    }

    public NameXPxg(int i, String str, String str2) {
        this.externalWorkbookNumber = -1;
        this.externalWorkbookNumber = i;
        this.sheetName = str;
        this.nameName = str2;
    }

    public NameXPxg(String str, String str2) {
        this(-1, str, str2);
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
        stringBuffer.append("name=");
        stringBuffer.append(this.nameName);
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

    public String getNameName() {
        return this.nameName;
    }

    @Override // org.apache.poi.ss.formula.ptg.Pxg
    public void setSheetName(String str) {
        this.sheetName = str;
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public String toFormulaString() {
        boolean z;
        StringBuffer stringBuffer = new StringBuffer();
        boolean z2 = true;
        if (this.externalWorkbookNumber >= 0) {
            stringBuffer.append(PropertyUtils.INDEXED_DELIM);
            stringBuffer.append(this.externalWorkbookNumber);
            stringBuffer.append(PropertyUtils.INDEXED_DELIM2);
            z = true;
        } else {
            z = false;
        }
        String str = this.sheetName;
        if (str != null) {
            SheetNameFormatter.appendFormat(stringBuffer, str);
        } else {
            z2 = z;
        }
        if (z2) {
            stringBuffer.append('!');
        }
        stringBuffer.append(this.nameName);
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.ptg.Ptg
    public void write(LittleEndianOutput littleEndianOutput) {
        throw new IllegalStateException("XSSF-only Ptg, should not be serialised");
    }
}
