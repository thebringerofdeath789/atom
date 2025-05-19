package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class PrintHeadersRecord extends StandardRecord {
    public static final short sid = 42;
    private short field_1_print_headers;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 42;
    }

    public PrintHeadersRecord() {
    }

    public PrintHeadersRecord(RecordInputStream recordInputStream) {
        this.field_1_print_headers = recordInputStream.readShort();
    }

    public void setPrintHeaders(boolean z) {
        if (z) {
            this.field_1_print_headers = (short) 1;
        } else {
            this.field_1_print_headers = (short) 0;
        }
    }

    public boolean getPrintHeaders() {
        return this.field_1_print_headers == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[PRINTHEADERS]\n");
        stringBuffer.append("    .printheaders   = ").append(getPrintHeaders()).append("\n");
        stringBuffer.append("[/PRINTHEADERS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_print_headers);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        PrintHeadersRecord printHeadersRecord = new PrintHeadersRecord();
        printHeadersRecord.field_1_print_headers = this.field_1_print_headers;
        return printHeadersRecord;
    }
}
