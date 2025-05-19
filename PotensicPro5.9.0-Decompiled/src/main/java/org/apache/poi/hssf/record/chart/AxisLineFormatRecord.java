package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class AxisLineFormatRecord extends StandardRecord {
    public static final short AXIS_TYPE_AXIS_LINE = 0;
    public static final short AXIS_TYPE_MAJOR_GRID_LINE = 1;
    public static final short AXIS_TYPE_MINOR_GRID_LINE = 2;
    public static final short AXIS_TYPE_WALLS_OR_FLOOR = 3;
    public static final short sid = 4129;
    private short field_1_axisType;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public AxisLineFormatRecord() {
    }

    public AxisLineFormatRecord(RecordInputStream recordInputStream) {
        this.field_1_axisType = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[AXISLINEFORMAT]\n");
        stringBuffer.append("    .axisType             = ").append("0x").append(HexDump.toHex(getAxisType())).append(" (").append((int) getAxisType()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/AXISLINEFORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_axisType);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        AxisLineFormatRecord axisLineFormatRecord = new AxisLineFormatRecord();
        axisLineFormatRecord.field_1_axisType = this.field_1_axisType;
        return axisLineFormatRecord;
    }

    public short getAxisType() {
        return this.field_1_axisType;
    }

    public void setAxisType(short s) {
        this.field_1_axisType = s;
    }
}
