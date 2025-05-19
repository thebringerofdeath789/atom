package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ViewSourceRecord extends StandardRecord {
    public static final short sid = 227;
    private int vs;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ViewSourceRecord(RecordInputStream recordInputStream) {
        this.vs = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.vs);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SXVS]\n");
        stringBuffer.append("    .vs      =").append(HexDump.shortToHex(this.vs)).append('\n');
        stringBuffer.append("[/SXVS]\n");
        return stringBuffer.toString();
    }
}
