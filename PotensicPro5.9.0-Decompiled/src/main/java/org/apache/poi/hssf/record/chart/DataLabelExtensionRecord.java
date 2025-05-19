package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DataLabelExtensionRecord extends StandardRecord {
    public static final short sid = 2154;
    private int grbitFrt;
    private int rt;
    private byte[] unused = new byte[8];

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DataLabelExtensionRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        recordInputStream.readFully(this.unused);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.write(this.unused);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DATALABEXT]\n");
        stringBuffer.append("    .rt      =").append(HexDump.shortToHex(this.rt)).append('\n');
        stringBuffer.append("    .grbitFrt=").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
        stringBuffer.append("    .unused  =").append(HexDump.toHex(this.unused)).append('\n');
        stringBuffer.append("[/DATALABEXT]\n");
        return stringBuffer.toString();
    }
}
