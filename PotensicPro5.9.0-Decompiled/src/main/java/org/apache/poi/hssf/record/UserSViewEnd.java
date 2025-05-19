package org.apache.poi.hssf.record;

import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class UserSViewEnd extends StandardRecord {
    public static final short sid = 427;
    private byte[] _rawData;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public UserSViewEnd(byte[] bArr) {
        this._rawData = bArr;
    }

    public UserSViewEnd(RecordInputStream recordInputStream) {
        this._rawData = recordInputStream.readRemainder();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.write(this._rawData);
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return this._rawData.length;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[").append("USERSVIEWEND").append("] (0x");
        stringBuffer.append(Integer.toHexString(427).toUpperCase() + ")\n");
        stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
        stringBuffer.append("[/").append("USERSVIEWEND").append("]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }
}
