package org.apache.poi.hssf.record;

import org.apache.commons.net.ftp.FTPReply;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class UserSViewBegin extends StandardRecord {
    public static final short sid = 426;
    private byte[] _rawData;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public UserSViewBegin(byte[] bArr) {
        this._rawData = bArr;
    }

    public UserSViewBegin(RecordInputStream recordInputStream) {
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

    public byte[] getGuid() {
        byte[] bArr = new byte[16];
        System.arraycopy(this._rawData, 0, bArr, 0, 16);
        return bArr;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[").append("USERSVIEWBEGIN").append("] (0x");
        stringBuffer.append(Integer.toHexString(FTPReply.TRANSFER_ABORTED).toUpperCase() + ")\n");
        stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
        stringBuffer.append("[/").append("USERSVIEWBEGIN").append("]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }
}
