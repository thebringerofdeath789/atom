package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class HideObjRecord extends StandardRecord {
    public static final short HIDE_ALL = 2;
    public static final short SHOW_ALL = 0;
    public static final short SHOW_PLACEHOLDERS = 1;
    public static final short sid = 141;
    private short field_1_hide_obj;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 141;
    }

    public HideObjRecord() {
    }

    public HideObjRecord(RecordInputStream recordInputStream) {
        this.field_1_hide_obj = recordInputStream.readShort();
    }

    public void setHideObj(short s) {
        this.field_1_hide_obj = s;
    }

    public short getHideObj() {
        return this.field_1_hide_obj;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[HIDEOBJ]\n");
        stringBuffer.append("    .hideobj         = ").append(Integer.toHexString(getHideObj())).append("\n");
        stringBuffer.append("[/HIDEOBJ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getHideObj());
    }
}
