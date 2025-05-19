package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class FtPioGrbitSubRecord extends SubRecord {
    public static final int AUTO_LOAD_BIT = 512;
    public static final int AUTO_PICT_BIT = 1;
    public static final int CAMERA_BIT = 128;
    public static final int CTL_BIT = 16;
    public static final int DDE_BIT = 2;
    public static final int DEFAULT_SIZE_BIT = 256;
    public static final int ICON_BIT = 8;
    public static final int PRINT_CALC_BIT = 4;
    public static final int PRSTM_BIT = 32;
    public static final short length = 2;
    public static final short sid = 8;
    private short flags;

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return 2;
    }

    public short getSid() {
        return (short) 8;
    }

    public FtPioGrbitSubRecord() {
        this.flags = (short) 0;
    }

    public FtPioGrbitSubRecord(LittleEndianInput littleEndianInput, int i) {
        this.flags = (short) 0;
        if (i != 2) {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
        this.flags = littleEndianInput.readShort();
    }

    public void setFlagByBit(int i, boolean z) {
        if (z) {
            this.flags = (short) (i | this.flags);
        } else {
            this.flags = (short) ((i ^ 65535) & this.flags);
        }
    }

    public boolean getFlagByBit(int i) {
        return (i & this.flags) != 0;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FtPioGrbit ]\n");
        stringBuffer.append("  size     = ").append(2).append("\n");
        stringBuffer.append("  flags    = ").append(HexDump.toHex(this.flags)).append("\n");
        stringBuffer.append("[/FtPioGrbit ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(8);
        littleEndianOutput.writeShort(2);
        littleEndianOutput.writeShort(this.flags);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public Object clone() {
        FtPioGrbitSubRecord ftPioGrbitSubRecord = new FtPioGrbitSubRecord();
        ftPioGrbitSubRecord.flags = this.flags;
        return ftPioGrbitSubRecord;
    }

    public short getFlags() {
        return this.flags;
    }

    public void setFlags(short s) {
        this.flags = s;
    }
}
