package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class PlotAreaRecord extends StandardRecord {
    public static final short sid = 4149;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
    }

    public PlotAreaRecord() {
    }

    public PlotAreaRecord(RecordInputStream recordInputStream) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[PLOTAREA]\n");
        stringBuffer.append("[/PLOTAREA]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new PlotAreaRecord();
    }
}
