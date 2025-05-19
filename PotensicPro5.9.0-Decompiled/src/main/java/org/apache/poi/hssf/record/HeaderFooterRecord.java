package org.apache.poi.hssf.record;

import java.util.Arrays;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class HeaderFooterRecord extends StandardRecord {
    private static final byte[] BLANK_GUID = new byte[16];
    public static final short sid = 2204;
    private byte[] _rawData;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public HeaderFooterRecord(byte[] bArr) {
        this._rawData = bArr;
    }

    public HeaderFooterRecord(RecordInputStream recordInputStream) {
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
        System.arraycopy(this._rawData, 12, bArr, 0, 16);
        return bArr;
    }

    public boolean isCurrentSheet() {
        return Arrays.equals(getGuid(), BLANK_GUID);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[").append("HEADERFOOTER").append("] (0x");
        stringBuffer.append(Integer.toHexString(UnknownRecord.HEADER_FOOTER_089C).toUpperCase() + ")\n");
        stringBuffer.append("  rawData=").append(HexDump.toHex(this._rawData)).append("\n");
        stringBuffer.append("[/").append("HEADERFOOTER").append("]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return cloneViaReserialise();
    }
}
