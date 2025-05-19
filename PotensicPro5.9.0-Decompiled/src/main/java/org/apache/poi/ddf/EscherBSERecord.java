package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public final class EscherBSERecord extends EscherRecord {
    public static final byte BT_DIB = 7;
    public static final byte BT_EMF = 2;
    public static final byte BT_ERROR = 0;
    public static final byte BT_JPEG = 5;
    public static final byte BT_PICT = 4;
    public static final byte BT_PNG = 6;
    public static final byte BT_UNKNOWN = 1;
    public static final byte BT_WMF = 3;
    public static final String RECORD_DESCRIPTION = "MsofbtBSE";
    public static final short RECORD_ID = -4089;
    private byte[] _remainingData;
    private byte field_10_unused2;
    private byte field_11_unused3;
    private EscherBlipRecord field_12_blipRecord;
    private byte field_1_blipTypeWin32;
    private byte field_2_blipTypeMacOS;
    private byte[] field_3_uid;
    private short field_4_tag;
    private int field_5_size;
    private int field_6_ref;
    private int field_7_offset;
    private byte field_8_usage;
    private byte field_9_name;

    public static String getBlipType(byte b) {
        switch (b) {
            case 0:
                return " ERROR";
            case 1:
                return " UNKNOWN";
            case 2:
                return " EMF";
            case 3:
                return " WMF";
            case 4:
                return " PICT";
            case 5:
                return " JPEG";
            case 6:
                return " PNG";
            case 7:
                return " DIB";
            default:
                return b < 32 ? " NotKnown" : " Client";
        }
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "BSE";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int i2;
        int readHeader = readHeader(bArr, i);
        int i3 = i + 8;
        this.field_1_blipTypeWin32 = bArr[i3];
        this.field_2_blipTypeMacOS = bArr[i3 + 1];
        byte[] bArr2 = new byte[16];
        this.field_3_uid = bArr2;
        System.arraycopy(bArr, i3 + 2, bArr2, 0, 16);
        this.field_4_tag = LittleEndian.getShort(bArr, i3 + 18);
        this.field_5_size = LittleEndian.getInt(bArr, i3 + 20);
        this.field_6_ref = LittleEndian.getInt(bArr, i3 + 24);
        this.field_7_offset = LittleEndian.getInt(bArr, i3 + 28);
        this.field_8_usage = bArr[i3 + 32];
        this.field_9_name = bArr[i3 + 33];
        this.field_10_unused2 = bArr[i3 + 34];
        this.field_11_unused3 = bArr[i3 + 35];
        int i4 = readHeader - 36;
        if (i4 > 0) {
            int i5 = i3 + 36;
            EscherBlipRecord escherBlipRecord = (EscherBlipRecord) escherRecordFactory.createRecord(bArr, i5);
            this.field_12_blipRecord = escherBlipRecord;
            i2 = escherBlipRecord.fillFields(bArr, i5, escherRecordFactory);
        } else {
            i2 = 0;
        }
        int i6 = i3 + i2 + 36;
        int i7 = i4 - i2;
        byte[] bArr3 = new byte[i7];
        this._remainingData = bArr3;
        System.arraycopy(bArr, i6, bArr3, 0, i7);
        int i8 = i7 + 8 + 36;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        return i8 + (escherBlipRecord2 != null ? escherBlipRecord2.getRecordSize() : 0);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        LittleEndian.putInt(bArr, i + 4, this._remainingData.length + 36 + (escherBlipRecord == null ? 0 : escherBlipRecord.getRecordSize()));
        int i2 = i + 8;
        bArr[i2] = this.field_1_blipTypeWin32;
        bArr[i + 9] = this.field_2_blipTypeMacOS;
        for (int i3 = 0; i3 < 16; i3++) {
            bArr[i + 10 + i3] = this.field_3_uid[i3];
        }
        LittleEndian.putShort(bArr, i + 26, this.field_4_tag);
        LittleEndian.putInt(bArr, i + 28, this.field_5_size);
        LittleEndian.putInt(bArr, i + 32, this.field_6_ref);
        LittleEndian.putInt(bArr, i + 36, this.field_7_offset);
        bArr[i + 40] = this.field_8_usage;
        bArr[i + 41] = this.field_9_name;
        bArr[i + 42] = this.field_10_unused2;
        bArr[i + 43] = this.field_11_unused3;
        EscherBlipRecord escherBlipRecord2 = this.field_12_blipRecord;
        int serialize = escherBlipRecord2 != null ? escherBlipRecord2.serialize(i + 44, bArr, new NullEscherSerializationListener()) : 0;
        if (this._remainingData == null) {
            this._remainingData = new byte[0];
        }
        byte[] bArr2 = this._remainingData;
        System.arraycopy(bArr2, 0, bArr, i + 44 + serialize, bArr2.length);
        int length = i2 + 36 + this._remainingData.length + serialize;
        int i4 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i4, this);
        return i4;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        EscherBlipRecord escherBlipRecord = this.field_12_blipRecord;
        int recordSize = escherBlipRecord != null ? escherBlipRecord.getRecordSize() : 0;
        byte[] bArr = this._remainingData;
        return recordSize + 44 + (bArr != null ? bArr.length : 0);
    }

    public byte getBlipTypeWin32() {
        return this.field_1_blipTypeWin32;
    }

    public void setBlipTypeWin32(byte b) {
        this.field_1_blipTypeWin32 = b;
    }

    public byte getBlipTypeMacOS() {
        return this.field_2_blipTypeMacOS;
    }

    public void setBlipTypeMacOS(byte b) {
        this.field_2_blipTypeMacOS = b;
    }

    public byte[] getUid() {
        return this.field_3_uid;
    }

    public void setUid(byte[] bArr) {
        this.field_3_uid = bArr;
    }

    public short getTag() {
        return this.field_4_tag;
    }

    public void setTag(short s) {
        this.field_4_tag = s;
    }

    public int getSize() {
        return this.field_5_size;
    }

    public void setSize(int i) {
        this.field_5_size = i;
    }

    public int getRef() {
        return this.field_6_ref;
    }

    public void setRef(int i) {
        this.field_6_ref = i;
    }

    public int getOffset() {
        return this.field_7_offset;
    }

    public void setOffset(int i) {
        this.field_7_offset = i;
    }

    public byte getUsage() {
        return this.field_8_usage;
    }

    public void setUsage(byte b) {
        this.field_8_usage = b;
    }

    public byte getName() {
        return this.field_9_name;
    }

    public void setName(byte b) {
        this.field_9_name = b;
    }

    public byte getUnused2() {
        return this.field_10_unused2;
    }

    public void setUnused2(byte b) {
        this.field_10_unused2 = b;
    }

    public byte getUnused3() {
        return this.field_11_unused3;
    }

    public void setUnused3(byte b) {
        this.field_11_unused3 = b;
    }

    public EscherBlipRecord getBlipRecord() {
        return this.field_12_blipRecord;
    }

    public void setBlipRecord(EscherBlipRecord escherBlipRecord) {
        this.field_12_blipRecord = escherBlipRecord;
    }

    public byte[] getRemainingData() {
        return this._remainingData;
    }

    public void setRemainingData(byte[] bArr) {
        this._remainingData = bArr;
    }

    public String toString() {
        byte[] bArr = this._remainingData;
        String hex = bArr == null ? null : HexDump.toHex(bArr, 32);
        StringBuilder append = new StringBuilder().append(getClass().getName()).append(":").append('\n').append("  RecordId: 0x").append(HexDump.toHex(RECORD_ID)).append('\n').append("  Version: 0x").append(HexDump.toHex(getVersion())).append('\n').append("  Instance: 0x").append(HexDump.toHex(getInstance())).append('\n').append("  BlipTypeWin32: ").append((int) this.field_1_blipTypeWin32).append('\n').append("  BlipTypeMacOS: ").append((int) this.field_2_blipTypeMacOS).append('\n').append("  SUID: ");
        byte[] bArr2 = this.field_3_uid;
        return append.append(bArr2 == null ? "" : HexDump.toHex(bArr2)).append('\n').append("  Tag: ").append((int) this.field_4_tag).append('\n').append("  Size: ").append(this.field_5_size).append('\n').append("  Ref: ").append(this.field_6_ref).append('\n').append("  Offset: ").append(this.field_7_offset).append('\n').append("  Usage: ").append((int) this.field_8_usage).append('\n').append("  Name: ").append((int) this.field_9_name).append('\n').append("  Unused2: ").append((int) this.field_10_unused2).append('\n').append("  Unused3: ").append((int) this.field_11_unused3).append('\n').append("  blipRecord: ").append(this.field_12_blipRecord).append('\n').append("  Extra Data:").append('\n').append(hex).toString();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        StringBuilder append = sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<BlipTypeWin32>").append((int) this.field_1_blipTypeWin32).append("</BlipTypeWin32>\n").append(str).append("\t").append("<BlipTypeMacOS>").append((int) this.field_2_blipTypeMacOS).append("</BlipTypeMacOS>\n").append(str).append("\t").append("<SUID>");
        byte[] bArr = this.field_3_uid;
        append.append(bArr == null ? "" : HexDump.toHex(bArr)).append("</SUID>\n").append(str).append("\t").append("<Tag>").append((int) this.field_4_tag).append("</Tag>\n").append(str).append("\t").append("<Size>").append(this.field_5_size).append("</Size>\n").append(str).append("\t").append("<Ref>").append(this.field_6_ref).append("</Ref>\n").append(str).append("\t").append("<Offset>").append(this.field_7_offset).append("</Offset>\n").append(str).append("\t").append("<Usage>").append((int) this.field_8_usage).append("</Usage>\n").append(str).append("\t").append("<Name>").append((int) this.field_9_name).append("</Name>\n").append(str).append("\t").append("<Unused2>").append((int) this.field_10_unused2).append("</Unused2>\n").append(str).append("\t").append("<Unused3>").append((int) this.field_11_unused3).append("</Unused3>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }
}
