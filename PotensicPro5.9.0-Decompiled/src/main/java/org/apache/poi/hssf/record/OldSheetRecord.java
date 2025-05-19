package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;

/* loaded from: classes5.dex */
public final class OldSheetRecord {
    public static final short sid = 133;
    private CodepageRecord codepage;
    private int field_1_position_of_BOF;
    private int field_2_visibility;
    private int field_3_type;
    private byte[] field_5_sheetname;

    public short getSid() {
        return (short) 133;
    }

    public OldSheetRecord(RecordInputStream recordInputStream) {
        this.field_1_position_of_BOF = recordInputStream.readInt();
        this.field_2_visibility = recordInputStream.readUByte();
        this.field_3_type = recordInputStream.readUByte();
        int readUByte = recordInputStream.readUByte();
        byte[] bArr = new byte[readUByte];
        this.field_5_sheetname = bArr;
        recordInputStream.read(bArr, 0, readUByte);
    }

    public void setCodePage(CodepageRecord codepageRecord) {
        this.codepage = codepageRecord;
    }

    public int getPositionOfBof() {
        return this.field_1_position_of_BOF;
    }

    public String getSheetname() {
        return OldStringRecord.getString(this.field_5_sheetname, this.codepage);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[BOUNDSHEET]\n");
        stringBuffer.append("    .bof        = ").append(HexDump.intToHex(getPositionOfBof())).append("\n");
        stringBuffer.append("    .visibility = ").append(HexDump.shortToHex(this.field_2_visibility)).append("\n");
        stringBuffer.append("    .type       = ").append(HexDump.byteToHex(this.field_3_type)).append("\n");
        stringBuffer.append("    .sheetname  = ").append(getSheetname()).append("\n");
        stringBuffer.append("[/BOUNDSHEET]\n");
        return stringBuffer.toString();
    }
}
