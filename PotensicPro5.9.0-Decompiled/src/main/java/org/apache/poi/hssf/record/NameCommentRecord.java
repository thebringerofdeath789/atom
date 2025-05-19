package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class NameCommentRecord extends StandardRecord {
    public static final short sid = 2196;
    private final short field_1_record_type;
    private final short field_2_frt_cell_ref_flag;
    private final long field_3_reserved;
    private String field_6_name_text;
    private String field_7_comment_text;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public NameCommentRecord(String str, String str2) {
        this.field_1_record_type = (short) 0;
        this.field_2_frt_cell_ref_flag = (short) 0;
        this.field_3_reserved = 0L;
        this.field_6_name_text = str;
        this.field_7_comment_text = str2;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int length = this.field_6_name_text.length();
        int length2 = this.field_7_comment_text.length();
        littleEndianOutput.writeShort(this.field_1_record_type);
        littleEndianOutput.writeShort(this.field_2_frt_cell_ref_flag);
        littleEndianOutput.writeLong(this.field_3_reserved);
        littleEndianOutput.writeShort(length);
        littleEndianOutput.writeShort(length2);
        littleEndianOutput.writeByte(0);
        StringUtil.putCompressedUnicode(this.field_6_name_text, littleEndianOutput);
        littleEndianOutput.writeByte(0);
        StringUtil.putCompressedUnicode(this.field_7_comment_text, littleEndianOutput);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this.field_6_name_text.length() + 18 + this.field_7_comment_text.length();
    }

    public NameCommentRecord(RecordInputStream recordInputStream) {
        this.field_1_record_type = recordInputStream.readShort();
        this.field_2_frt_cell_ref_flag = recordInputStream.readShort();
        this.field_3_reserved = recordInputStream.readLong();
        short readShort = recordInputStream.readShort();
        short readShort2 = recordInputStream.readShort();
        recordInputStream.readByte();
        this.field_6_name_text = StringUtil.readCompressedUnicode(recordInputStream, readShort);
        recordInputStream.readByte();
        this.field_7_comment_text = StringUtil.readCompressedUnicode(recordInputStream, readShort2);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[NAMECMT]\n");
        stringBuffer.append("    .record type            = ").append(HexDump.shortToHex(this.field_1_record_type)).append("\n");
        stringBuffer.append("    .frt cell ref flag      = ").append(HexDump.byteToHex(this.field_2_frt_cell_ref_flag)).append("\n");
        stringBuffer.append("    .reserved               = ").append(this.field_3_reserved).append("\n");
        stringBuffer.append("    .name length            = ").append(this.field_6_name_text.length()).append("\n");
        stringBuffer.append("    .comment length         = ").append(this.field_7_comment_text.length()).append("\n");
        stringBuffer.append("    .name                   = ").append(this.field_6_name_text).append("\n");
        stringBuffer.append("    .comment                = ").append(this.field_7_comment_text).append("\n");
        stringBuffer.append("[/NAMECMT]\n");
        return stringBuffer.toString();
    }

    public String getNameText() {
        return this.field_6_name_text;
    }

    public void setNameText(String str) {
        this.field_6_name_text = str;
    }

    public String getCommentText() {
        return this.field_7_comment_text;
    }

    public void setCommentText(String str) {
        this.field_7_comment_text = str;
    }

    public short getRecordType() {
        return this.field_1_record_type;
    }
}
