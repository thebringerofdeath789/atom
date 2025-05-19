package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class DSFRecord extends StandardRecord {
    private static final BitField biff5BookStreamFlag = BitFieldFactory.getInstance(1);
    public static final short sid = 353;
    private int _options;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private DSFRecord(int i) {
        this._options = i;
    }

    public DSFRecord(boolean z) {
        this(0);
        this._options = biff5BookStreamFlag.setBoolean(0, z);
    }

    public DSFRecord(RecordInputStream recordInputStream) {
        this(recordInputStream.readShort());
    }

    public boolean isBiff5BookStreamPresent() {
        return biff5BookStreamFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[DSF]\n");
        stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
        stringBuffer.append("[/DSF]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
    }
}
