package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ChartEndBlockRecord extends StandardRecord {
    public static final short sid = 2131;
    private short grbitFrt;
    private short iObjectKind;
    private short rt;
    private byte[] unused;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ChartEndBlockRecord() {
    }

    public ChartEndBlockRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.iObjectKind = recordInputStream.readShort();
        if (recordInputStream.available() == 0) {
            this.unused = new byte[0];
            return;
        }
        byte[] bArr = new byte[6];
        this.unused = bArr;
        recordInputStream.readFully(bArr);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this.unused.length + 6;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeShort(this.iObjectKind);
        littleEndianOutput.write(this.unused);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ENDBLOCK]\n");
        stringBuffer.append("    .rt         =").append(HexDump.shortToHex(this.rt)).append('\n');
        stringBuffer.append("    .grbitFrt   =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
        stringBuffer.append("    .iObjectKind=").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
        stringBuffer.append("    .unused     =").append(HexDump.toHex(this.unused)).append('\n');
        stringBuffer.append("[/ENDBLOCK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public ChartEndBlockRecord clone() {
        ChartEndBlockRecord chartEndBlockRecord = new ChartEndBlockRecord();
        chartEndBlockRecord.rt = this.rt;
        chartEndBlockRecord.grbitFrt = this.grbitFrt;
        chartEndBlockRecord.iObjectKind = this.iObjectKind;
        chartEndBlockRecord.unused = (byte[]) this.unused.clone();
        return chartEndBlockRecord;
    }
}
