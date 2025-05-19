package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class PrintGridlinesRecord extends StandardRecord {
    public static final short sid = 43;
    private short field_1_print_gridlines;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 43;
    }

    public PrintGridlinesRecord() {
    }

    public PrintGridlinesRecord(RecordInputStream recordInputStream) {
        this.field_1_print_gridlines = recordInputStream.readShort();
    }

    public void setPrintGridlines(boolean z) {
        if (z) {
            this.field_1_print_gridlines = (short) 1;
        } else {
            this.field_1_print_gridlines = (short) 0;
        }
    }

    public boolean getPrintGridlines() {
        return this.field_1_print_gridlines == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[PRINTGRIDLINES]\n");
        stringBuffer.append("    .printgridlines = ").append(getPrintGridlines()).append("\n");
        stringBuffer.append("[/PRINTGRIDLINES]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_print_gridlines);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        PrintGridlinesRecord printGridlinesRecord = new PrintGridlinesRecord();
        printGridlinesRecord.field_1_print_gridlines = this.field_1_print_gridlines;
        return printGridlinesRecord;
    }
}
