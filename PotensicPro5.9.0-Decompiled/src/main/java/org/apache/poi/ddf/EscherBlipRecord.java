package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public class EscherBlipRecord extends EscherRecord {
    private static final int HEADER_SIZE = 8;
    public static final String RECORD_DESCRIPTION = "msofbtBlip";
    public static final short RECORD_ID_END = -3817;
    public static final short RECORD_ID_START = -4072;
    protected byte[] field_pictureData;

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Blip";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        byte[] bArr2 = new byte[readHeader];
        this.field_pictureData = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, readHeader);
        return readHeader + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        byte[] bArr2 = this.field_pictureData;
        int i2 = i + 4;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        escherSerializationListener.afterRecordSerialize(i2 + this.field_pictureData.length, getRecordId(), this.field_pictureData.length + 4, this);
        return this.field_pictureData.length + 4;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.field_pictureData.length + 8;
    }

    public byte[] getPicturedata() {
        return this.field_pictureData;
    }

    public void setPictureData(byte[] bArr) {
        this.field_pictureData = bArr;
    }

    public String toString() {
        return getClass().getName() + ":\n  RecordId: 0x" + HexDump.toHex(getRecordId()) + "\n  Version: 0x" + HexDump.toHex(getVersion()) + "\n  Instance: 0x" + HexDump.toHex(getInstance()) + "\n  Extra Data:\n" + HexDump.toHex(this.field_pictureData, 32);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        String hex = HexDump.toHex(this.field_pictureData, 32);
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<ExtraData>").append(hex).append("</ExtraData>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }
}
