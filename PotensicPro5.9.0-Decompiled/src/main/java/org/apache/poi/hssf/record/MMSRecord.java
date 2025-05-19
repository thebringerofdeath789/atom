package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class MMSRecord extends StandardRecord {
    public static final short sid = 193;
    private byte field_1_addMenuCount;
    private byte field_2_delMenuCount;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 193;
    }

    public MMSRecord() {
    }

    public MMSRecord(RecordInputStream recordInputStream) {
        if (recordInputStream.remaining() == 0) {
            return;
        }
        this.field_1_addMenuCount = recordInputStream.readByte();
        this.field_2_delMenuCount = recordInputStream.readByte();
    }

    public void setAddMenuCount(byte b) {
        this.field_1_addMenuCount = b;
    }

    public void setDelMenuCount(byte b) {
        this.field_2_delMenuCount = b;
    }

    public byte getAddMenuCount() {
        return this.field_1_addMenuCount;
    }

    public byte getDelMenuCount() {
        return this.field_2_delMenuCount;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[MMS]\n");
        stringBuffer.append("    .addMenu        = ").append(Integer.toHexString(getAddMenuCount())).append("\n");
        stringBuffer.append("    .delMenu        = ").append(Integer.toHexString(getDelMenuCount())).append("\n");
        stringBuffer.append("[/MMS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeByte(getAddMenuCount());
        littleEndianOutput.writeByte(getDelMenuCount());
    }
}
