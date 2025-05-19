package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class EOFRecord extends StandardRecord {
    public static final int ENCODED_SIZE = 4;
    public static final EOFRecord instance = new EOFRecord();
    public static final short sid = 10;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 0;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 10;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
    }

    private EOFRecord() {
    }

    public EOFRecord(RecordInputStream recordInputStream) {
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[EOF]\n");
        stringBuffer.append("[/EOF]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return instance;
    }
}
