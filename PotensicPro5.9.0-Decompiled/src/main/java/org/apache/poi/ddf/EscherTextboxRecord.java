package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.RecordFormatException;

/* loaded from: classes4.dex */
public class EscherTextboxRecord extends EscherRecord {
    private static final byte[] NO_BYTES = new byte[0];
    public static final String RECORD_DESCRIPTION = "msofbtClientTextbox";
    public static final short RECORD_ID = -4083;
    private byte[] thedata = NO_BYTES;

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "ClientTextbox";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        int readHeader = readHeader(bArr, i);
        byte[] bArr2 = new byte[readHeader];
        this.thedata = bArr2;
        System.arraycopy(bArr, i + 8, bArr2, 0, readHeader);
        return readHeader + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, this.thedata.length);
        byte[] bArr2 = this.thedata;
        int i2 = i + 8;
        System.arraycopy(bArr2, 0, bArr, i2, bArr2.length);
        int length = i2 + this.thedata.length;
        int i3 = length - i;
        escherSerializationListener.afterRecordSerialize(length, getRecordId(), i3, this);
        if (i3 == getRecordSize()) {
            return i3;
        }
        throw new RecordFormatException(i3 + " bytes written but getRecordSize() reports " + getRecordSize());
    }

    public byte[] getData() {
        return this.thedata;
    }

    public void setData(byte[] bArr, int i, int i2) {
        byte[] bArr2 = new byte[i2];
        this.thedata = bArr2;
        System.arraycopy(bArr, i, bArr2, 0, i2);
    }

    public void setData(byte[] bArr) {
        setData(bArr, 0, bArr.length);
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return this.thedata.length + 8;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public Object clone() {
        return super.clone();
    }

    public String toString() {
        String str;
        String property = System.getProperty("line.separator");
        try {
            if (this.thedata.length != 0) {
                str = ("  Extra Data:" + property) + HexDump.dump(this.thedata, 0L, 0);
            } else {
                str = "";
            }
        } catch (Exception unused) {
            str = "Error!!";
        }
        return getClass().getName() + ":" + property + "  isContainer: " + isContainerRecord() + property + "  version: 0x" + HexDump.toHex(getVersion()) + property + "  instance: 0x" + HexDump.toHex(getInstance()) + property + "  recordId: 0x" + HexDump.toHex(getRecordId()) + property + "  numchildren: " + getChildRecords().size() + property + str;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        String str2;
        try {
            str2 = "";
            if (this.thedata.length != 0) {
                str2 = "" + HexDump.dump(this.thedata, 0L, 0);
            }
        } catch (Exception unused) {
            str2 = "Error!!";
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<ExtraData>").append(str2).append("</ExtraData>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }
}
