package org.apache.poi.hssf.record;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import org.apache.poi.ss.util.WorkbookUtil;
import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.StringUtil;

/* loaded from: classes5.dex */
public final class BoundSheetRecord extends StandardRecord {
    public static final short sid = 133;
    private int field_1_position_of_BOF;
    private int field_2_option_flags;
    private int field_4_isMultibyteUnicode;
    private String field_5_sheetname;
    private static final BitField hiddenFlag = BitFieldFactory.getInstance(1);
    private static final BitField veryHiddenFlag = BitFieldFactory.getInstance(2);
    private static final Comparator<BoundSheetRecord> BOFComparator = new Comparator<BoundSheetRecord>() { // from class: org.apache.poi.hssf.record.BoundSheetRecord.1
        @Override // java.util.Comparator
        public int compare(BoundSheetRecord boundSheetRecord, BoundSheetRecord boundSheetRecord2) {
            return boundSheetRecord.getPositionOfBof() - boundSheetRecord2.getPositionOfBof();
        }
    };

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 133;
    }

    public BoundSheetRecord(String str) {
        this.field_2_option_flags = 0;
        setSheetname(str);
    }

    public BoundSheetRecord(RecordInputStream recordInputStream) {
        this.field_1_position_of_BOF = recordInputStream.readInt();
        this.field_2_option_flags = recordInputStream.readUShort();
        int readUByte = recordInputStream.readUByte();
        this.field_4_isMultibyteUnicode = recordInputStream.readByte();
        if (isMultibyte()) {
            this.field_5_sheetname = recordInputStream.readUnicodeLEString(readUByte);
        } else {
            this.field_5_sheetname = recordInputStream.readCompressedUnicode(readUByte);
        }
    }

    public void setPositionOfBof(int i) {
        this.field_1_position_of_BOF = i;
    }

    public void setSheetname(String str) {
        WorkbookUtil.validateSheetName(str);
        this.field_5_sheetname = str;
        this.field_4_isMultibyteUnicode = StringUtil.hasMultibyte(str) ? 1 : 0;
    }

    public int getPositionOfBof() {
        return this.field_1_position_of_BOF;
    }

    private boolean isMultibyte() {
        return (this.field_4_isMultibyteUnicode & 1) != 0;
    }

    public String getSheetname() {
        return this.field_5_sheetname;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[BOUNDSHEET]\n");
        stringBuffer.append("    .bof        = ").append(HexDump.intToHex(getPositionOfBof())).append("\n");
        stringBuffer.append("    .options    = ").append(HexDump.shortToHex(this.field_2_option_flags)).append("\n");
        stringBuffer.append("    .unicodeflag= ").append(HexDump.byteToHex(this.field_4_isMultibyteUnicode)).append("\n");
        stringBuffer.append("    .sheetname  = ").append(this.field_5_sheetname).append("\n");
        stringBuffer.append("[/BOUNDSHEET]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this.field_5_sheetname.length() * (isMultibyte() ? 2 : 1)) + 8;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeInt(getPositionOfBof());
        littleEndianOutput.writeShort(this.field_2_option_flags);
        String str = this.field_5_sheetname;
        littleEndianOutput.writeByte(str.length());
        littleEndianOutput.writeByte(this.field_4_isMultibyteUnicode);
        if (isMultibyte()) {
            StringUtil.putUnicodeLE(str, littleEndianOutput);
        } else {
            StringUtil.putCompressedUnicode(str, littleEndianOutput);
        }
    }

    public boolean isHidden() {
        return hiddenFlag.isSet(this.field_2_option_flags);
    }

    public void setHidden(boolean z) {
        this.field_2_option_flags = hiddenFlag.setBoolean(this.field_2_option_flags, z);
    }

    public boolean isVeryHidden() {
        return veryHiddenFlag.isSet(this.field_2_option_flags);
    }

    public void setVeryHidden(boolean z) {
        this.field_2_option_flags = veryHiddenFlag.setBoolean(this.field_2_option_flags, z);
    }

    public static BoundSheetRecord[] orderByBofPosition(List<BoundSheetRecord> list) {
        BoundSheetRecord[] boundSheetRecordArr = new BoundSheetRecord[list.size()];
        list.toArray(boundSheetRecordArr);
        Arrays.sort(boundSheetRecordArr, BOFComparator);
        return boundSheetRecordArr;
    }
}
