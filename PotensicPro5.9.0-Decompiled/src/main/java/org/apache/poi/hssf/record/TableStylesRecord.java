package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class TableStylesRecord extends StandardRecord {
    public static final short sid = 2190;
    private int cts;
    private int grbitFrt;
    private String rgchDefListStyle;
    private String rgchDefPivotStyle;
    private int rt;
    private byte[] unused = new byte[8];

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public TableStylesRecord(RecordInputStream recordInputStream) {
        this.rt = recordInputStream.readUShort();
        this.grbitFrt = recordInputStream.readUShort();
        recordInputStream.readFully(this.unused);
        this.cts = recordInputStream.readInt();
        int readUShort = recordInputStream.readUShort();
        int readUShort2 = recordInputStream.readUShort();
        this.rgchDefListStyle = recordInputStream.readUnicodeLEString(readUShort);
        this.rgchDefPivotStyle = recordInputStream.readUnicodeLEString(readUShort2);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this.rt);
        littleEndianOutput.writeShort(this.grbitFrt);
        littleEndianOutput.write(this.unused);
        littleEndianOutput.writeInt(this.cts);
        littleEndianOutput.writeShort(this.rgchDefListStyle.length());
        littleEndianOutput.writeShort(this.rgchDefPivotStyle.length());
        StringUtil.putUnicodeLE(this.rgchDefListStyle, littleEndianOutput);
        StringUtil.putUnicodeLE(this.rgchDefPivotStyle, littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.rgchDefListStyle.length() * 2) + 20 + (this.rgchDefPivotStyle.length() * 2);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[TABLESTYLES]\n");
        stringBuffer.append("    .rt      =").append(HexDump.shortToHex(this.rt)).append('\n');
        stringBuffer.append("    .grbitFrt=").append(HexDump.shortToHex(this.grbitFrt)).append('\n');
        stringBuffer.append("    .unused  =").append(HexDump.toHex(this.unused)).append('\n');
        stringBuffer.append("    .cts=").append(HexDump.intToHex(this.cts)).append('\n');
        stringBuffer.append("    .rgchDefListStyle=").append(this.rgchDefListStyle).append('\n');
        stringBuffer.append("    .rgchDefPivotStyle=").append(this.rgchDefPivotStyle).append('\n');
        stringBuffer.append("[/TABLESTYLES]\n");
        return stringBuffer.toString();
    }
}
