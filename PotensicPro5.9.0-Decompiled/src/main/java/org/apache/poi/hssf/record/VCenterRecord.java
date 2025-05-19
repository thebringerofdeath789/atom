package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class VCenterRecord extends StandardRecord {
    public static final short sid = 132;
    private int field_1_vcenter;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 132;
    }

    public VCenterRecord() {
    }

    public VCenterRecord(RecordInputStream recordInputStream) {
        this.field_1_vcenter = recordInputStream.readShort();
    }

    public void setVCenter(boolean z) {
        this.field_1_vcenter = z ? 1 : 0;
    }

    public boolean getVCenter() {
        return this.field_1_vcenter == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[VCENTER]\n");
        stringBuffer.append("    .vcenter        = ").append(getVCenter()).append("\n");
        stringBuffer.append("[/VCENTER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_vcenter);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        VCenterRecord vCenterRecord = new VCenterRecord();
        vCenterRecord.field_1_vcenter = this.field_1_vcenter;
        return vCenterRecord;
    }
}
