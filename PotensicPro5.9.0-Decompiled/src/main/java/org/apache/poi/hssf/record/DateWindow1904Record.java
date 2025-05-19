package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DateWindow1904Record extends StandardRecord {
    public static final short sid = 34;
    private short field_1_window;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 34;
    }

    public DateWindow1904Record() {
    }

    public DateWindow1904Record(RecordInputStream recordInputStream) {
        this.field_1_window = recordInputStream.readShort();
    }

    public void setWindowing(short s) {
        this.field_1_window = s;
    }

    public short getWindowing() {
        return this.field_1_window;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[1904]\n");
        stringBuffer.append("    .is1904          = ").append(Integer.toHexString(getWindowing())).append("\n");
        stringBuffer.append("[/1904]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getWindowing());
    }
}
