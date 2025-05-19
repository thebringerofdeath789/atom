package org.apache.poi.ddf;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes4.dex */
public class EscherDgRecord extends EscherRecord {
    public static final String RECORD_DESCRIPTION = "MsofbtDg";
    public static final short RECORD_ID = -4088;
    private int field_1_numShapes;
    private int field_2_lastMSOSPID;

    @Override // org.apache.poi.ddf.EscherRecord
    public short getRecordId() {
        return RECORD_ID;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String getRecordName() {
        return "Dg";
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int getRecordSize() {
        return 16;
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int fillFields(byte[] bArr, int i, EscherRecordFactory escherRecordFactory) {
        readHeader(bArr, i);
        int i2 = i + 8;
        this.field_1_numShapes = LittleEndian.getInt(bArr, i2 + 0);
        this.field_2_lastMSOSPID = LittleEndian.getInt(bArr, i2 + 4);
        return getRecordSize();
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public int serialize(int i, byte[] bArr, EscherSerializationListener escherSerializationListener) {
        escherSerializationListener.beforeRecordSerialize(i, getRecordId(), this);
        LittleEndian.putShort(bArr, i, getOptions());
        LittleEndian.putShort(bArr, i + 2, getRecordId());
        LittleEndian.putInt(bArr, i + 4, 8);
        LittleEndian.putInt(bArr, i + 8, this.field_1_numShapes);
        LittleEndian.putInt(bArr, i + 12, this.field_2_lastMSOSPID);
        escherSerializationListener.afterRecordSerialize(i + 16, getRecordId(), getRecordSize(), this);
        return getRecordSize();
    }

    public String toString() {
        return getClass().getName() + ":\n  RecordId: 0x" + HexDump.toHex(RECORD_ID) + "\n  Version: 0x" + HexDump.toHex(getVersion()) + "\n  Instance: 0x" + HexDump.toHex(getInstance()) + "\n  NumShapes: " + this.field_1_numShapes + "\n  LastMSOSPID: " + this.field_2_lastMSOSPID + '\n';
    }

    @Override // org.apache.poi.ddf.EscherRecord
    public String toXml(String str) {
        StringBuilder sb = new StringBuilder();
        sb.append(str).append(formatXmlRecordHeader(getClass().getSimpleName(), HexDump.toHex(getRecordId()), HexDump.toHex(getVersion()), HexDump.toHex(getInstance()))).append(str).append("\t").append("<NumShapes>").append(this.field_1_numShapes).append("</NumShapes>\n").append(str).append("\t").append("<LastMSOSPID>").append(this.field_2_lastMSOSPID).append("</LastMSOSPID>\n");
        sb.append(str).append("</").append(getClass().getSimpleName()).append(">\n");
        return sb.toString();
    }

    public int getNumShapes() {
        return this.field_1_numShapes;
    }

    public void setNumShapes(int i) {
        this.field_1_numShapes = i;
    }

    public int getLastMSOSPID() {
        return this.field_2_lastMSOSPID;
    }

    public void setLastMSOSPID(int i) {
        this.field_2_lastMSOSPID = i;
    }

    public short getDrawingGroupId() {
        return (short) (getOptions() >> 4);
    }

    public void incrementShapeCount() {
        this.field_1_numShapes++;
    }
}
