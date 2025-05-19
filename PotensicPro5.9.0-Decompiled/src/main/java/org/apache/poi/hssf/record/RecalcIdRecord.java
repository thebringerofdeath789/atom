package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class RecalcIdRecord extends StandardRecord {
    public static final short sid = 449;
    private int _engineId;
    private final int _reserved0;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 8;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 449;
    }

    public boolean isNeeded() {
        return true;
    }

    public RecalcIdRecord() {
        this._reserved0 = 0;
        this._engineId = 0;
    }

    public RecalcIdRecord(RecordInputStream recordInputStream) {
        recordInputStream.readUShort();
        this._reserved0 = recordInputStream.readUShort();
        this._engineId = recordInputStream.readInt();
    }

    public void setEngineId(int i) {
        this._engineId = i;
    }

    public int getEngineId() {
        return this._engineId;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[RECALCID]\n");
        stringBuffer.append("    .reserved = ").append(HexDump.shortToHex(this._reserved0)).append("\n");
        stringBuffer.append("    .engineId = ").append(HexDump.intToHex(this._engineId)).append("\n");
        stringBuffer.append("[/RECALCID]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(449);
        littleEndianOutput.writeShort(this._reserved0);
        littleEndianOutput.writeInt(this._engineId);
    }
}
