package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class ContinueRecord extends StandardRecord {
    public static final short sid = 60;
    private byte[] _data;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 60;
    }

    public ContinueRecord(byte[] bArr) {
        this._data = bArr;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this._data.length;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this._data);
    }

    public byte[] getData() {
        return this._data;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[CONTINUE RECORD]\n");
        stringBuffer.append("    .data = ").append(HexDump.toHex(this._data)).append("\n");
        stringBuffer.append("[/CONTINUE RECORD]\n");
        return stringBuffer.toString();
    }

    public ContinueRecord(RecordInputStream recordInputStream) {
        this._data = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new ContinueRecord(this._data);
    }
}
