package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class GridsetRecord extends StandardRecord {
    public static final short sid = 130;
    public short field_1_gridset_flag;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 130;
    }

    public GridsetRecord() {
    }

    public GridsetRecord(RecordInputStream recordInputStream) {
        this.field_1_gridset_flag = recordInputStream.readShort();
    }

    public void setGridset(boolean z) {
        if (z) {
            this.field_1_gridset_flag = (short) 1;
        } else {
            this.field_1_gridset_flag = (short) 0;
        }
    }

    public boolean getGridset() {
        return this.field_1_gridset_flag == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[GRIDSET]\n");
        stringBuffer.append("    .gridset        = ").append(getGridset()).append("\n");
        stringBuffer.append("[/GRIDSET]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_gridset_flag);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        GridsetRecord gridsetRecord = new GridsetRecord();
        gridsetRecord.field_1_gridset_flag = this.field_1_gridset_flag;
        return gridsetRecord;
    }
}
