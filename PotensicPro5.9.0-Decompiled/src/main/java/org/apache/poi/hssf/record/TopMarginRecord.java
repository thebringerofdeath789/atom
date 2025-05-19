package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class TopMarginRecord extends StandardRecord implements Margin {
    public static final short sid = 40;
    private double field_1_margin;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 40;
    }

    public TopMarginRecord() {
    }

    public TopMarginRecord(RecordInputStream recordInputStream) {
        this.field_1_margin = recordInputStream.readDouble();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[TopMargin]\n");
        stringBuffer.append("    .margin               = ").append(" (").append(getMargin()).append(" )\n");
        stringBuffer.append("[/TopMargin]\n");
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
        TopMarginRecord topMarginRecord = new TopMarginRecord();
        topMarginRecord.field_1_margin = this.field_1_margin;
        return topMarginRecord;
    }
}
