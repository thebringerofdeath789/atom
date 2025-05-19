package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class SeriesListRecord extends StandardRecord {
    public static final short sid = 4118;
    private short[] field_1_seriesNumbers;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public SeriesListRecord(short[] sArr) {
        this.field_1_seriesNumbers = sArr;
    }

    public SeriesListRecord(RecordInputStream recordInputStream) {
        int readUShort = recordInputStream.readUShort();
        short[] sArr = new short[readUShort];
        for (int i = 0; i < readUShort; i++) {
            sArr[i] = recordInputStream.readShort();
        }
        this.field_1_seriesNumbers = sArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SERIESLIST]\n");
        stringBuffer.append("    .seriesNumbers= ").append(" (").append(getSeriesNumbers()).append(" )");
        stringBuffer.append("\n");
        stringBuffer.append("[/SERIESLIST]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_1_seriesNumbers.length;
        littleEndianOutput.writeShort(length);
        for (int i = 0; i < length; i++) {
            littleEndianOutput.writeShort(this.field_1_seriesNumbers[i]);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.field_1_seriesNumbers.length * 2) + 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new SeriesListRecord((short[]) this.field_1_seriesNumbers.clone());
    }

    public short[] getSeriesNumbers() {
        return this.field_1_seriesNumbers;
    }
}
