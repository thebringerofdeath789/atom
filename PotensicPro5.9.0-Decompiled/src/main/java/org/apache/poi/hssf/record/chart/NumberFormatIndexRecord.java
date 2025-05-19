package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class NumberFormatIndexRecord extends StandardRecord {
    public static final short sid = 4174;
    private short field_1_formatIndex;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public NumberFormatIndexRecord() {
    }

    public NumberFormatIndexRecord(RecordInputStream recordInputStream) {
        this.field_1_formatIndex = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[IFMT]\n");
        stringBuffer.append("    .formatIndex          = ").append("0x").append(HexDump.toHex(getFormatIndex())).append(" (").append((int) getFormatIndex()).append(" )");
        stringBuffer.append(System.getProperty("line.separator"));
        stringBuffer.append("[/IFMT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_formatIndex);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        NumberFormatIndexRecord numberFormatIndexRecord = new NumberFormatIndexRecord();
        numberFormatIndexRecord.field_1_formatIndex = this.field_1_formatIndex;
        return numberFormatIndexRecord;
    }

    public short getFormatIndex() {
        return this.field_1_formatIndex;
    }

    public void setFormatIndex(short s) {
        this.field_1_formatIndex = s;
    }
}
