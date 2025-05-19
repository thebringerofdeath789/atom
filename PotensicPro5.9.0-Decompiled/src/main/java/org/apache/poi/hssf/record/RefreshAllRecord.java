package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class RefreshAllRecord extends StandardRecord {
    private static final BitField refreshFlag = BitFieldFactory.getInstance(1);
    public static final short sid = 439;
    private int _options;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private RefreshAllRecord(int i) {
        this._options = i;
    }

    public RefreshAllRecord(RecordInputStream recordInputStream) {
        this(recordInputStream.readUShort());
    }

    public RefreshAllRecord(boolean z) {
        this(0);
        setRefreshAll(z);
    }

    public void setRefreshAll(boolean z) {
        this._options = refreshFlag.setBoolean(this._options, z);
    }

    public boolean getRefreshAll() {
        return refreshFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[REFRESHALL]\n");
        stringBuffer.append("    .options      = ").append(HexDump.shortToHex(this._options)).append("\n");
        stringBuffer.append("[/REFRESHALL]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new RefreshAllRecord(this._options);
    }
}
