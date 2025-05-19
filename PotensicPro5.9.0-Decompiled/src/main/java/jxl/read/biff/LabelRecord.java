package jxl.read.biff;

import jxl.CellType;
import jxl.LabelCell;
import jxl.WorkbookSettings;
import jxl.biff.FormattingRecords;
import jxl.biff.IntegerHelper;
import jxl.biff.StringHelper;

/* loaded from: classes4.dex */
class LabelRecord extends CellValue implements LabelCell {
    public static Biff7 biff7 = new Biff7();
    private int length;
    private String string;

    /* JADX INFO: Access modifiers changed from: private */
    static class Biff7 {
        private Biff7() {
        }
    }

    public LabelRecord(Record record, FormattingRecords formattingRecords, SheetImpl sheetImpl, WorkbookSettings workbookSettings) {
        super(record, formattingRecords, sheetImpl);
        byte[] data = getRecord().getData();
        int i = IntegerHelper.getInt(data[6], data[7]);
        this.length = i;
        if (data[8] == 0) {
            this.string = StringHelper.getString(data, i, 9, workbookSettings);
        } else {
            this.string = StringHelper.getUnicodeString(data, i, 9);
        }
    }

    public LabelRecord(Record record, FormattingRecords formattingRecords, SheetImpl sheetImpl, WorkbookSettings workbookSettings, Biff7 biff72) {
        super(record, formattingRecords, sheetImpl);
        byte[] data = getRecord().getData();
        int i = IntegerHelper.getInt(data[6], data[7]);
        this.length = i;
        this.string = StringHelper.getString(data, i, 8, workbookSettings);
    }

    @Override // jxl.LabelCell
    public String getString() {
        return this.string;
    }

    @Override // jxl.Cell
    public String getContents() {
        return this.string;
    }

    @Override // jxl.Cell
    public CellType getType() {
        return CellType.LABEL;
    }
}
