package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class UncalcedRecord extends StandardRecord {
    public static final short sid = 94;
    private short _reserved;

    public static int getStaticRecordSize() {
        return 6;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 94;
    }

    public UncalcedRecord() {
        this._reserved = (short) 0;
    }

    public UncalcedRecord(RecordInputStream recordInputStream) {
        this._reserved = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[UNCALCED]\n");
        stringBuffer.append("    _reserved: ").append((int) this._reserved).append('\n');
        stringBuffer.append("[/UNCALCED]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._reserved);
    }
}
