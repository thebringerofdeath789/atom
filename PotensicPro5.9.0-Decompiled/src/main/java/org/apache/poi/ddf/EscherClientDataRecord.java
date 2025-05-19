package org.apache.poi.ddf;

import java.io.ByteArrayOutputStream;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import tv.danmaku.ijk.media.player.IjkMediaPlayer;

/* loaded from: classes4.dex */
public class EscherClientDataRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtClientData";
    public static final short RECORD_ID = -4079;
    private byte[] remainingData;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "ClientData";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        byte[] bArr2 = new byte[readHeader];
        this.remainingData = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, readHeader);
        return readHeader + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        if (this.remainingData == null) {
            this.remainingData = new byte[0];
        }
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, this.remainingData.length);
        byte[] bArr2 = this.remainingData;
        int i2 = i + 8;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        int length = i2 + this.remainingData.length;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        return i3;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        byte[] bArr = this.remainingData;
        return (bArr == null ? 0 : bArr.length) + 8;
    }

    public String toString() {
        String str;
        String property = System.getProperty("line.separator");
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HexDump.dump(this.remainingData, 0L, byteArrayOutputStream, 0);
            str = byteArrayOutputStream.toString();
        } catch (Exception unused) {
            str = "error\n";
        }
        return getClass().getName() + ":" + property + "  RecordId: 0x" + HexDump.toHex(RECORD_ID) + property + "  Version: 0x" + HexDump.toHex(getVersion()) + property + "  Instance: 0x" + HexDump.toHex(getInstance()) + property + "  Extra Data:" + property + str;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        String str2;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            HexDump.dump(this.remainingData, 0L, byteArrayOutputStream, 0);
            str2 = byteArrayOutputStream.toString();
        } catch (Exception unused) {
            str2 = IjkMediaPlayer.OnNativeInvokeListener.ARG_ERROR;
        }
        if (str2.contains("No Data")) {
            str2 = "No Data";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<ExtraData>").append(str2).append("</ExtraData>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }

    public byte[] getRemainingData() {
        return this.remainingData;
    }

    public void setRemainingData(byte[] bArr) {
        this.remainingData = bArr;
    }
}
