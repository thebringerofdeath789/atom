package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class InterfaceEndRecord extends StandardRecord {
    public static final InterfaceEndRecord instance = new InterfaceEndRecord();
    public static final short sid = 226;

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

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        return "[INTERFACEEND/]\n";
    }

    private InterfaceEndRecord() {
    }

    public static Record create(RecordInputStream recordInputStream) {
        int remaining = recordInputStream.remaining();
        if (remaining == 0) {
            return instance;
        }
        if (remaining == 2) {
            return new InterfaceHdrRecord(recordInputStream);
        }
        throw new RecordFormatException("Invalid record data size: " + recordInputStream.remaining());
    }
}
