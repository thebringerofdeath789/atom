package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ChartEndObjectRecord extends StandardRecord {
    public static final short sid = 2133;
    private short grbitFrt;
    private short iObjectKind;
    private byte[] reserved = new byte[6];
    private short rt;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ChartEndObjectRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.iObjectKind = recordInputStream.readShort();
        if (recordInputStream.available() == 0) {
            return;
        }
        recordInputStream.readFully(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeShort(this.iObjectKind);
        littleEndianOutput.write(this.reserved);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ENDOBJECT]\n");
        stringBuffer.append("    .rt         =").append(HexDump.shortToHex(this.rt)).append('\n');
        stringBuffer.append("    .grbitFrt   =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
        stringBuffer.append("    .iObjectKind=").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
        stringBuffer.append("    .reserved   =").append(HexDump.toHex(this.reserved)).append('\n');
        stringBuffer.append("[/ENDOBJECT]\n");
        return stringBuffer.toString();
    }
}
