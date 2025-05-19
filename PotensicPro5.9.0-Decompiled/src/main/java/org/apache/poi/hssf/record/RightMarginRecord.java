package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class RightMarginRecord extends StandardRecord implements Margin {
    public static final short sid = 39;
    private double field_1_margin;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 39;
    }

    public RightMarginRecord() {
    }

    public RightMarginRecord(RecordInputStream recordInputStream) {
        this.field_1_margin = recordInputStream.readDouble();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[RightMargin]\n");
        stringBuffer.append("    .margin               = ").append(" (").append(getMargin()).append(" )\n");
        stringBuffer.append("[/RightMargin]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeDouble(this.field_1_margin);
    }

    @Override // org.apache.poi.hssf.record.Margin
    public double getMargin() {
        return this.field_1_margin;
    }

    @Override // org.apache.poi.hssf.record.Margin
    public void setMargin(double d) {
        this.field_1_margin = d;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        RightMarginRecord rightMarginRecord = new RightMarginRecord();
        rightMarginRecord.field_1_margin = this.field_1_margin;
        return rightMarginRecord;
    }
}
