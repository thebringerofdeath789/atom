package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class GutsRecord extends StandardRecord {
    public static final short sid = 128;
    private short field_1_left_row_gutter;
    private short field_2_top_col_gutter;
    private short field_3_row_level_max;
    private short field_4_col_level_max;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 128;
    }

    public GutsRecord() {
    }

    public GutsRecord(RecordInputStream recordInputStream) {
        this.field_1_left_row_gutter = recordInputStream.readShort();
        this.field_2_top_col_gutter = recordInputStream.readShort();
        this.field_3_row_level_max = recordInputStream.readShort();
        this.field_4_col_level_max = recordInputStream.readShort();
    }

    public void setLeftRowGutter(short s) {
        this.field_1_left_row_gutter = s;
    }

    public void setTopColGutter(short s) {
        this.field_2_top_col_gutter = s;
    }

    public void setRowLevelMax(short s) {
        this.field_3_row_level_max = s;
    }

    public void setColLevelMax(short s) {
        this.field_4_col_level_max = s;
    }

    public short getLeftRowGutter() {
        return this.field_1_left_row_gutter;
    }

    public short getTopColGutter() {
        return this.field_2_top_col_gutter;
    }

    public short getRowLevelMax() {
        return this.field_3_row_level_max;
    }

    public short getColLevelMax() {
        return this.field_4_col_level_max;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[GUTS]\n");
        stringBuffer.append("    .leftgutter     = ").append(Integer.toHexString(getLeftRowGutter())).append("\n");
        stringBuffer.append("    .topgutter      = ").append(Integer.toHexString(getTopColGutter())).append("\n");
        stringBuffer.append("    .rowlevelmax    = ").append(Integer.toHexString(getRowLevelMax())).append("\n");
        stringBuffer.append("    .collevelmax    = ").append(Integer.toHexString(getColLevelMax())).append("\n");
        stringBuffer.append("[/GUTS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getLeftRowGutter());
        littleEndianOutput.writeShort(getTopColGutter());
        littleEndianOutput.writeShort(getRowLevelMax());
        littleEndianOutput.writeShort(getColLevelMax());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        GutsRecord gutsRecord = new GutsRecord();
        gutsRecord.field_1_left_row_gutter = this.field_1_left_row_gutter;
        gutsRecord.field_2_top_col_gutter = this.field_2_top_col_gutter;
        gutsRecord.field_3_row_level_max = this.field_3_row_level_max;
        gutsRecord.field_4_col_level_max = this.field_4_col_level_max;
        return gutsRecord;
    }
}
