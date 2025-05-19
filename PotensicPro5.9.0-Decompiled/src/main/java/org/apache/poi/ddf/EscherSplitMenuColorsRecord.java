package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* loaded from: classes4.dex */
public class EscherSplitMenuColorsRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtSplitMenuColors";
    public static final short RECORD_ID = -3810;
    private int field_1_color1;
    private int field_2_color2;
    private int field_3_color3;
    private int field_4_color4;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "SplitMenuColors";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 24;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_color1 = LittleEndian.getInt(bArr, i2 + 0);
        this.field_2_color2 = LittleEndian.getInt(bArr, i2 + 4);
        this.field_3_color3 = LittleEndian.getInt(bArr, i2 + 8);
        this.field_4_color4 = LittleEndian.getInt(bArr, i2 + 12);
        int i3 = readHeader - 16;
        if (i3 == 0) {
            return 24 + i3;
        }
        throw new RecordFormatException("Expecting no remaining data but got " + i3 + " byte(s).");
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        int i2 = i + 2;
        LittleEndian.putShort(bArr, i2, getRecordId());
        int i3 = i2 + 2;
        LittleEndian.putInt(bArr, i3, getRecordSize() - 8);
        int i4 = i3 + 4;
        LittleEndian.putInt(bArr, i4, this.field_1_color1);
        int i5 = i4 + 4;
        LittleEndian.putInt(bArr, i5, this.field_2_color2);
        int i6 = i5 + 4;
        LittleEndian.putInt(bArr, i6, this.field_3_color3);
        int i7 = i6 + 4;
        LittleEndian.putInt(bArr, i7, this.field_4_color4);
        int i8 = i7 + 4;
        escherSerializationListener.afterRecordSerialize(i8, getRecordId(), i8 - i, this);
        return getRecordSize();
    }

    public String toString() {
        return getClass().getName() + ":\n  RecordId: 0x" + HexDump.toHex(RECORD_ID) + "\n  Version: 0x" + HexDump.toHex(getVersion()) + "\n  Instance: 0x" + HexDump.toHex(getInstance()) + "\n  Color1: 0x" + HexDump.toHex(this.field_1_color1) + "\n  Color2: 0x" + HexDump.toHex(this.field_2_color2) + "\n  Color3: 0x" + HexDump.toHex(this.field_3_color3) + "\n  Color4: 0x" + HexDump.toHex(this.field_4_color4) + "\n";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<Color1>0x").append(HexDump.toHex(this.field_1_color1)).append("</Color1>\n").append(str).append("\t").append("<Color2>0x").append(HexDump.toHex(this.field_2_color2)).append("</Color2>\n").append(str).append("\t").append("<Color3>0x").append(HexDump.toHex(this.field_3_color3)).append("</Color3>\n").append(str).append("\t").append("<Color4>0x").append(HexDump.toHex(this.field_4_color4)).append("</Color4>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }

    public int getColor1() {
        return this.field_1_color1;
    }

    public void setColor1(int i) {
        this.field_1_color1 = i;
    }

    public int getColor2() {
        return this.field_2_color2;
    }

    public void setColor2(int i) {
        this.field_2_color2 = i;
    }

    public int getColor3() {
        return this.field_3_color3;
    }

    public void setColor3(int i) {
        this.field_3_color3 = i;
    }

    public int getColor4() {
        return this.field_4_color4;
    }

    public void setColor4(int i) {
        this.field_4_color4 = i;
    }
}
