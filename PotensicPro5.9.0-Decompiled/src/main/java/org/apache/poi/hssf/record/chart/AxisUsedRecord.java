package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class AxisUsedRecord extends StandardRecord {
    public static final short sid = 4166;
    private short field_1_numAxis;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AxisUsedRecord() {
    }

    public AxisUsedRecord(RecordInputStream recordInputStream) {
        this.field_1_numAxis = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[AXISUSED]\n");
        stringBuffer.append("    .numAxis              = ").append("0x").append(HexDump.toHex(getNumAxis())).append(" (").append((int) getNumAxis()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/AXISUSED]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_numAxis);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        AxisUsedRecord axisUsedRecord = new AxisUsedRecord();
        axisUsedRecord.field_1_numAxis = this.field_1_numAxis;
        return axisUsedRecord;
    }

    public short getNumAxis() {
        return this.field_1_numAxis;
    }

    public void setNumAxis(short s) {
        this.field_1_numAxis = s;
    }
}
