package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class WindowProtectRecord extends StandardRecord {
    private static final BitField settingsProtectedFlag = BitFieldFactory.getInstance(1);
    public static final short sid = 25;
    private int _options;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 25;
    }

    public WindowProtectRecord(int i) {
        this._options = i;
    }

    public WindowProtectRecord(RecordInputStream recordInputStream) {
        this(recordInputStream.readUShort());
    }

    public WindowProtectRecord(boolean z) {
        this(0);
        setProtect(z);
    }

    public void setProtect(boolean z) {
        this._options = settingsProtectedFlag.setBoolean(this._options, z);
    }

    public boolean getProtect() {
        return settingsProtectedFlag.isSet(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[WINDOWPROTECT]\n");
        stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
        stringBuffer.append("[/WINDOWPROTECT]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new WindowProtectRecord(this._options);
    }
}
