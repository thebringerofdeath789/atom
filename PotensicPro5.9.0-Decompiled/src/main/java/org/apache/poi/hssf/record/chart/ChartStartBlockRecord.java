package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ChartStartBlockRecord extends StandardRecord {
    public static final short sid = 2130;
    private short grbitFrt;
    private short iObjectContext;
    private short iObjectInstance1;
    private short iObjectInstance2;
    private short iObjectKind;
    private short rt;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 12;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public ChartStartBlockRecord() {
    }

    public ChartStartBlockRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.iObjectKind = recordInputStream.readShort();
        this.iObjectContext = recordInputStream.readShort();
        this.iObjectInstance1 = recordInputStream.readShort();
        this.iObjectInstance2 = recordInputStream.readShort();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeShort(this.iObjectKind);
        littleEndianOutput.writeShort(this.iObjectContext);
        littleEndianOutput.writeShort(this.iObjectInstance1);
        littleEndianOutput.writeShort(this.iObjectInstance2);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[STARTBLOCK]\n");
        stringBuffer.append("    .rt              =").append(HexDump.shortToHex(this.rt)).append('\n');
        stringBuffer.append("    .grbitFrt        =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
        stringBuffer.append("    .iObjectKind     =").append(HexDump.shortToHex(this.iObjectKind)).append('\n');
        stringBuffer.append("    .iObjectContext  =").append(HexDump.shortToHex(this.iObjectContext)).append('\n');
        stringBuffer.append("    .iObjectInstance1=").append(HexDump.shortToHex(this.iObjectInstance1)).append('\n');
        stringBuffer.append("    .iObjectInstance2=").append(HexDump.shortToHex(this.iObjectInstance2)).append('\n');
        stringBuffer.append("[/STARTBLOCK]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public ChartStartBlockRecord clone() {
        ChartStartBlockRecord chartStartBlockRecord = new ChartStartBlockRecord();
        chartStartBlockRecord.rt = this.rt;
        chartStartBlockRecord.grbitFrt = this.grbitFrt;
        chartStartBlockRecord.iObjectKind = this.iObjectKind;
        chartStartBlockRecord.iObjectContext = this.iObjectContext;
        chartStartBlockRecord.iObjectInstance1 = this.iObjectInstance1;
        chartStartBlockRecord.iObjectInstance2 = this.iObjectInstance2;
        return chartStartBlockRecord;
    }
}
