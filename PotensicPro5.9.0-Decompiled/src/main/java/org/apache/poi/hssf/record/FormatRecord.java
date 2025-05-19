package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class FormatRecord extends StandardRecord {
    public static final short sid = 1054;
    private final int field_1_index_code;
    private final boolean field_3_hasMultibyte;
    private final String field_4_formatstring;

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public FormatRecord(int i, String str) {
        this.field_1_index_code = i;
        this.field_4_formatstring = str;
        this.field_3_hasMultibyte = StringUtil.hasMultibyte(str);
    }

    public FormatRecord(RecordInputStream recordInputStream) {
        this.field_1_index_code = recordInputStream.readShort();
        int readUShort = recordInputStream.readUShort();
        boolean z = (recordInputStream.readByte() & 1) != 0;
        this.field_3_hasMultibyte = z;
        if (z) {
            this.field_4_formatstring = recordInputStream.readUnicodeLEString(readUShort);
        } else {
            this.field_4_formatstring = recordInputStream.readCompressedUnicode(readUShort);
        }
    }

    public int getIndexCode() {
        return this.field_1_index_code;
    }

    public String getFormatString() {
        return this.field_4_formatstring;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[FORMAT]\n");
        stringBuffer.append("    .indexcode       = ").append(HexDump.shortToHex(getIndexCode())).append("\n");
        stringBuffer.append("    .isUnicode       = ").append(this.field_3_hasMultibyte).append("\n");
        stringBuffer.append("    .formatstring    = ").append(getFormatString()).append("\n");
        stringBuffer.append("[/FORMAT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        String formatString = getFormatString();
        littleEndianOutput.writeShort(getIndexCode());
        littleEndianOutput.writeShort(formatString.length());
        littleEndianOutput.writeByte(this.field_3_hasMultibyte ? 1 : 0);
        if (this.field_3_hasMultibyte) {
            StringUtil.putUnicodeLE(formatString, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(formatString, littleEndianOutput);
        }
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (getFormatString().length() * (this.field_3_hasMultibyte ? 2 : 1)) + 5;
    }
}
