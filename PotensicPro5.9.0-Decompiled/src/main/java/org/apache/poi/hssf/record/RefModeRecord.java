package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class RefModeRecord extends StandardRecord {
    public static final short USE_A1_MODE = 1;
    public static final short USE_R1C1_MODE = 0;
    public static final short sid = 15;
    private short field_1_mode;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 15;
    }

    public RefModeRecord() {
    }

    public RefModeRecord(RecordInputStream recordInputStream) {
        this.field_1_mode = recordInputStream.readShort();
    }

    public void setMode(short s) {
        this.field_1_mode = s;
    }

    public short getMode() {
        return this.field_1_mode;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[REFMODE]\n");
        stringBuffer.append("    .mode           = ").append(Integer.toHexString(getMode())).append("\n");
        stringBuffer.append("[/REFMODE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getMode());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        RefModeRecord refModeRecord = new RefModeRecord();
        refModeRecord.field_1_mode = this.field_1_mode;
        return refModeRecord;
    }
}
