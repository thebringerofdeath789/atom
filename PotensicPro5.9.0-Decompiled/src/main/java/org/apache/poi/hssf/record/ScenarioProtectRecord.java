package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ScenarioProtectRecord extends StandardRecord {
    public static final short sid = 221;
    private short field_1_protect;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ScenarioProtectRecord() {
    }

    public ScenarioProtectRecord(RecordInputStream recordInputStream) {
        this.field_1_protect = recordInputStream.readShort();
    }

    public void setProtect(boolean z) {
        if (z) {
            this.field_1_protect = (short) 1;
        } else {
            this.field_1_protect = (short) 0;
        }
    }

    public boolean getProtect() {
        return this.field_1_protect == 1;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SCENARIOPROTECT]\n");
        stringBuffer.append("    .protect         = ").append(getProtect()).append("\n");
        stringBuffer.append("[/SCENARIOPROTECT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.field_1_protect);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        ScenarioProtectRecord scenarioProtectRecord = new ScenarioProtectRecord();
        scenarioProtectRecord.field_1_protect = this.field_1_protect;
        return scenarioProtectRecord;
    }
}
