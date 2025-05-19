package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class BlankRecord extends StandardRecord implements CellValueRecordInterface {
    public static final short sid = 513;
    private int field_1_row;
    private short field_2_col;
    private short field_3_xf;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 513;
    }

    public BlankRecord() {
    }

    public BlankRecord(RecordInputStream recordInputStream) {
        this.field_1_row = recordInputStream.readUShort();
        this.field_2_col = recordInputStream.readShort();
        this.field_3_xf = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setRow(int i) {
        this.field_1_row = i;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public int getRow() {
        return this.field_1_row;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getColumn() {
        return this.field_2_col;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setXFIndex(short s) {
        this.field_3_xf = s;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public short getXFIndex() {
        return this.field_3_xf;
    }

    @Override // org.apache.poi.hssf.record.CellValueRecordInterface
    public void setColumn(short s) {
        this.field_2_col = s;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[BLANK]\n");
        stringBuffer.append("    row= ").append(HexDump.shortToHex(getRow())).append("\n");
        stringBuffer.append("    col= ").append(HexDump.shortToHex(getColumn())).append("\n");
        stringBuffer.append("    xf = ").append(HexDump.shortToHex(getXFIndex())).append("\n");
        stringBuffer.append("[/BLANK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getRow());
        littleEndianOutput.writeShort(getColumn());
        littleEndianOutput.writeShort(getXFIndex());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        BlankRecord blankRecord = new BlankRecord();
        blankRecord.field_1_row = this.field_1_row;
        blankRecord.field_2_col = this.field_2_col;
        blankRecord.field_3_xf = this.field_3_xf;
        return blankRecord;
    }
}
