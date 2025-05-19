package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class CalcModeRecord extends StandardRecord {
    public static final short AUTOMATIC = 1;
    public static final short AUTOMATIC_EXCEPT_TABLES = -1;
    public static final short MANUAL = 0;
    public static final short sid = 13;
    private short field_1_calcmode;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 13;
    }

    public CalcModeRecord() {
    }

    public CalcModeRecord(RecordInputStream recordInputStream) {
        this.field_1_calcmode = recordInputStream.readShort();
    }

    public void setCalcMode(short s) {
        this.field_1_calcmode = s;
    }

    public short getCalcMode() {
        return this.field_1_calcmode;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[CALCMODE]\n");
        stringBuffer.append("    .calcmode       = ").append(Integer.toHexString(getCalcMode())).append("\n");
        stringBuffer.append("[/CALCMODE]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(getCalcMode());
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        CalcModeRecord calcModeRecord = new CalcModeRecord();
        calcModeRecord.field_1_calcmode = this.field_1_calcmode;
        return calcModeRecord;
    }
}
