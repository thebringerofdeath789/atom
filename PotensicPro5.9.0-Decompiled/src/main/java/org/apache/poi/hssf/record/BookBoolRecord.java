package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class BookBoolRecord extends StandardRecord {
    public static final short sid = 218;
    private short field_1_save_link_values;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public BookBoolRecord() {
    }

    public BookBoolRecord(RecordInputStream recordInputStream) {
        this.field_1_save_link_values = recordInputStream.readShort();
    }

    public void setSaveLinkValues(short s) {
        this.field_1_save_link_values = s;
    }

    public short getSaveLinkValues() {
        return this.field_1_save_link_values;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[BOOKBOOL]\n");
        stringBuffer.append("    .savelinkvalues  = ").append(Integer.toHexString(getSaveLinkValues())).append("\n");
        stringBuffer.append("[/BOOKBOOL]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_save_link_values);
    }
}
