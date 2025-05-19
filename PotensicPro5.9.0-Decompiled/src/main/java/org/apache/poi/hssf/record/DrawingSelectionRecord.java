package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DrawingSelectionRecord extends StandardRecord {
    public static final short sid = 237;
    private int _cpsp;
    private int _dgslk;
    private OfficeArtRecordHeader _header;
    private int[] _shapeIds;
    private int _spidFocus;

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return this;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private static final class OfficeArtRecordHeader {
        public static final int ENCODED_SIZE = 8;
        private final int _length;
        private final int _type;
        private final int _verAndInstance;

        public OfficeArtRecordHeader(LittleEndianInput littleEndianInput) {
            this._verAndInstance = littleEndianInput.readUShort();
            this._type = littleEndianInput.readUShort();
            this._length = littleEndianInput.readInt();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._verAndInstance);
            littleEndianOutput.writeShort(this._type);
            littleEndianOutput.writeInt(this._length);
        }

        public String debugFormatAsString() {
            StringBuffer stringBuffer = new StringBuffer(32);
            stringBuffer.append("ver+inst=").append(HexDump.shortToHex(this._verAndInstance));
            stringBuffer.append(" type=").append(HexDump.shortToHex(this._type));
            stringBuffer.append(" len=").append(HexDump.intToHex(this._length));
            return stringBuffer.toString();
        }
    }

    public DrawingSelectionRecord(RecordInputStream recordInputStream) {
        this._header = new OfficeArtRecordHeader(recordInputStream);
        this._cpsp = recordInputStream.readInt();
        this._dgslk = recordInputStream.readInt();
        this._spidFocus = recordInputStream.readInt();
        int available = recordInputStream.available() / 4;
        int[] iArr = new int[available];
        for (int i = 0; i < available; i++) {
            iArr[i] = recordInputStream.readInt();
        }
        this._shapeIds = iArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._shapeIds.length * 4) + 20;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        this._header.serialize(littleEndianOutput);
        littleEndianOutput.writeInt(this._cpsp);
        littleEndianOutput.writeInt(this._dgslk);
        littleEndianOutput.writeInt(this._spidFocus);
        int i = 0;
        while (true) {
            int[] iArr = this._shapeIds;
            if (i >= iArr.length) {
                return;
            }
            littleEndianOutput.writeInt(iArr[i]);
            i++;
        }
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[MSODRAWINGSELECTION]\n");
        stringBuffer.append("    .rh       =(").append(this._header.debugFormatAsString()).append(")\n");
        stringBuffer.append("    .cpsp     =").append(HexDump.intToHex(this._cpsp)).append('\n');
        stringBuffer.append("    .dgslk    =").append(HexDump.intToHex(this._dgslk)).append('\n');
        stringBuffer.append("    .spidFocus=").append(HexDump.intToHex(this._spidFocus)).append('\n');
        stringBuffer.append("    .shapeIds =(");
        for (int i = 0; i < this._shapeIds.length; i++) {
            if (i > 0) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(HexDump.intToHex(this._shapeIds[i]));
        }
        stringBuffer.append(")\n");
        stringBuffer.append("[/MSODRAWINGSELECTION]\n");
        return stringBuffer.toString();
    }
}
