package jxl.read.biff;

import jxl.CellType;
import jxl.ErrorCell;
import jxl.biff.FormattingRecords;

/* loaded from: classes4.dex */
class ErrorRecord extends CellValue implements ErrorCell {
    private int errorCode;

    public ErrorRecord(Record record, FormattingRecords formattingRecords, SheetImpl sheetImpl) {
        super(record, formattingRecords, sheetImpl);
        this.errorCode = getRecord().getData()[6];
    }

    @Override // jxl.ErrorCell
    public int getErrorCode() {
        return this.errorCode;
    }

    @Override // jxl.Cell
    public String getContents() {
        return new StringBuffer().append("ERROR ").append(this.errorCode).toString();
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.ERROR;
    }
}
