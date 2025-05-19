package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class EndRecord extends StandardRecord {
    public static final short sid = 4148;

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

    public EndRecord() {
    }

    public EndRecord(RecordInputStream recordInputStream) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[END]\n");
        stringBuffer.append("[/END]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new EndRecord();
    }
}
