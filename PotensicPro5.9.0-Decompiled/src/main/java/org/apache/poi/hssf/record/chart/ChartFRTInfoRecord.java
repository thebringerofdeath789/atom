package org.apache.poi.hssf.record.chart;

import org.apache.poi.hssf.record.RecordInputStream;
import org.apache.poi.hssf.record.StandardRecord;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ChartFRTInfoRecord extends StandardRecord {
    public static final short sid = 2128;
    private short grbitFrt;
    private CFRTID[] rgCFRTID;
    private short rt;
    private byte verOriginator;
    private byte verWriter;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private static final class CFRTID {
        public static final int ENCODED_SIZE = 4;
        private int rtFirst;
        private int rtLast;

        public CFRTID(LittleEndianInput littleEndianInput) {
            this.rtFirst = littleEndianInput.readShort();
            this.rtLast = littleEndianInput.readShort();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this.rtFirst);
            littleEndianOutput.writeShort(this.rtLast);
        }
    }

    public ChartFRTInfoRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readShort();
        this.grbitFrt = recordInputStream.readShort();
        this.verOriginator = recordInputStream.readByte();
        this.verWriter = recordInputStream.readByte();
        int readShort = recordInputStream.readShort();
        this.rgCFRTID = new CFRTID[readShort];
        for (int i = 0; i < readShort; i++) {
            this.rgCFRTID[i] = new CFRTID(recordInputStream);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.rgCFRTID.length * 4) + 8;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.writeByte(this.verOriginator);
        littleEndianOutput.writeByte(this.verWriter);
        int length = this.rgCFRTID.length;
        littleEndianOutput.writeShort(length);
        for (int i = 0; i < length; i++) {
            this.rgCFRTID[i].serialize(littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[CHARTFRTINFO]\n");
        stringBuffer.append("    .rt           =").append(HexDump.shortToHex(this.rt)).append('\n');
        stringBuffer.append("    .grbitFrt     =").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
        stringBuffer.append("    .verOriginator=").append(HexDump.byteToHex(this.verOriginator)).append('\n');
        stringBuffer.append("    .verWriter    =").append(HexDump.byteToHex(this.verOriginator)).append('\n');
        stringBuffer.append("    .nCFRTIDs     =").append(HexDump.shortToHex(this.rgCFRTID.length)).append('\n');
        stringBuffer.append("[/CHARTFRTINFO]\n");
        return stringBuffer.toString();
    }
}
