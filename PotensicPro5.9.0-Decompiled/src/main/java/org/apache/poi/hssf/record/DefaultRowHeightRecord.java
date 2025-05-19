package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DefaultRowHeightRecord extends StandardRecord {
    public static final short DEFAULT_ROW_HEIGHT = 255;
    public static final short sid = 549;
    private short field_1_option_flags;
    private short field_2_row_height;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 4;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DefaultRowHeightRecord() {
        this.field_1_option_flags = (short) 0;
        this.field_2_row_height = (short) 255;
    }

    public DefaultRowHeightRecord(RecordInputStream recordInputStream) {
        this.field_1_option_flags = recordInputStream.readShort();
        this.field_2_row_height = recordInputStream.readShort();
    }

    public void setOptionFlags(short s) {
        this.field_1_option_flags = s;
    }

    public void setRowHeight(short s) {
        this.field_2_row_height = s;
    }

    public short getOptionFlags() {
        return this.field_1_option_flags;
    }

    public short getRowHeight() {
        return this.field_2_row_height;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DEFAULTROWHEIGHT]\n");
        stringBuffer.append("    .optionflags    = ").append(Integer.toHexString(getOptionFlags())).append("\n");
        stringBuffer.append("    .rowheight      = ").append(Integer.toHexString(getRowHeight())).append("\n");
        stringBuffer.append("[/DEFAULTROWHEIGHT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getOptionFlags());
        littleEndianOutput.writeShort(getRowHeight());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        DefaultRowHeightRecord defaultRowHeightRecord = new DefaultRowHeightRecord();
        defaultRowHeightRecord.field_1_option_flags = this.field_1_option_flags;
        defaultRowHeightRecord.field_2_row_height = this.field_2_row_height;
        return defaultRowHeightRecord;
    }
}
