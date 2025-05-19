package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class HCenterRecord extends StandardRecord {
    public static final short sid = 131;
    private short field_1_hcenter;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 131;
    }

    public HCenterRecord() {
    }

    public HCenterRecord(RecordInputStream recordInputStream) {
        this.field_1_hcenter = recordInputStream.readShort();
    }

    public void setHCenter(boolean z) {
        if (z) {
            this.field_1_hcenter = (short) 1;
        } else {
            this.field_1_hcenter = (short) 0;
        }
    }

    public boolean getHCenter() {
        return this.field_1_hcenter == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[HCENTER]\n");
        stringBuffer.append("    .hcenter        = ").append(getHCenter()).append("\n");
        stringBuffer.append("[/HCENTER]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_hcenter);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        HCenterRecord hCenterRecord = new HCenterRecord();
        hCenterRecord.field_1_hcenter = this.field_1_hcenter;
        return hCenterRecord;
    }
}
