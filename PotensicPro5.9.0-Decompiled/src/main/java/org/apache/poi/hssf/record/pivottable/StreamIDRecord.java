package org.apache.poi.hssf.record.pivottable;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class StreamIDRecord extends StandardRecord {
    public static final short sid = 213;
    private int idstm;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public StreamIDRecord(RecordInputStream recordInputStream) {
        this.idstm = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.idstm);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[SXIDSTM]\n");
        stringBuffer.append("    .idstm      =").append(HexDump.shortToHex(this.idstm)).append('\n');
        stringBuffer.append("[/SXIDSTM]\n");
        return stringBuffer.toString();
    }
}
