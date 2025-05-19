package org.apache.poi.hssf.record;

import java.io.ByteArrayOutputStream;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;
import org.apache.poi.util.LittleEndianOutputStream;

/* loaded from: classes5.dex */
public abstract class SubRecord {
    public abstract Object clone();

    protected abstract int getDataSize();

    public boolean isTerminating() {
        return false;
    }

    public abstract void serialize(LittleEndianOutput littleEndianOutput);

    protected SubRecord() {
    }

    public static SubRecord createSubRecord(LittleEndianInput littleEndianInput, int i) {
        int readUShort = littleEndianInput.readUShort();
        int readUShort2 = littleEndianInput.readUShort();
        if (readUShort == 0) {
            return new EndSubRecord(littleEndianInput, readUShort2);
        }
        if (readUShort == 19) {
            return new LbsDataSubRecord(littleEndianInput, readUShort2, i);
        }
        if (readUShort == 21) {
            return new CommonObjectDataSubRecord(littleEndianInput, readUShort2);
        }
        if (readUShort == 12) {
            return new FtCblsSubRecord(littleEndianInput, readUShort2);
        }
        if (readUShort != 13) {
            switch (readUShort) {
                case 6:
                    return new GroupMarkerSubRecord(littleEndianInput, readUShort2);
                case 7:
                    return new FtCfSubRecord(littleEndianInput, readUShort2);
                case 8:
                    return new FtPioGrbitSubRecord(littleEndianInput, readUShort2);
                case 9:
                    return new EmbeddedObjectRefSubRecord(littleEndianInput, readUShort2);
                default:
                    return new UnknownSubRecord(littleEndianInput, readUShort, readUShort2);
            }
        }
        return new NoteStructureSubRecord(littleEndianInput, readUShort2);
    }

    public byte[] serialize() {
        int dataSize = getDataSize() + 4;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(dataSize);
        serialize(new LittleEndianOutputStream(byteArrayOutputStream));
        if (byteArrayOutputStream.size() != dataSize) {
            throw new RuntimeException("write size mismatch");
        }
        return byteArrayOutputStream.toByteArray();
    }

    private static final class UnknownSubRecord extends SubRecord {
        private final byte[] _data;
        private final int _sid;

        @Override // org.apache.poi.hssf.record.SubRecord
        public Object clone() {
            return this;
        }

        public UnknownSubRecord(LittleEndianInput littleEndianInput, int i, int i2) {
            this._sid = i;
            byte[] bArr = new byte[i2];
            littleEndianInput.readFully(bArr);
            this._data = bArr;
        }

        @Override // org.apache.poi.hssf.record.SubRecord
        protected int getDataSize() {
            return this._data.length;
        }

        @Override // org.apache.poi.hssf.record.SubRecord
        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._sid);
            littleEndianOutput.writeShort(this._data.length);
            littleEndianOutput.write(this._data);
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(getClass().getName()).append(" [");
            stringBuffer.append("sid=").append(HexDump.shortToHex(this._sid));
            stringBuffer.append(" size=").append(this._data.length);
            stringBuffer.append(" : ").append(HexDump.toHex(this._data));
            stringBuffer.append("]\n");
            return stringBuffer.toString();
        }
    }
}
