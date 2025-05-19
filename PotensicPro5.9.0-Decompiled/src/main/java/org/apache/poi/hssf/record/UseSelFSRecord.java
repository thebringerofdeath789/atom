package org.apache.poi.hssf.record;

import org.apache.poi.util.BitField;
import org.apache.poi.util.BitFieldFactory;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class UseSelFSRecord extends StandardRecord {
    public static final short sid = 352;
    private static final BitField useNaturalLanguageFormulasFlag = BitFieldFactory.getInstance(1);
    private int _options;

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return 2;
    }

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    private UseSelFSRecord(int i) {
        this._options = i;
    }

    public UseSelFSRecord(RecordInputStream recordInputStream) {
        this(recordInputStream.readUShort());
    }

    public UseSelFSRecord(boolean z) {
        this(0);
        this._options = useNaturalLanguageFormulasFlag.setBoolean(this._options, z);
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[USESELFS]\n");
        stringBuffer.append("    .options = ").append(HexDump.shortToHex(this._options)).append("\n");
        stringBuffer.append("[/USESELFS]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(this._options);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        return new UseSelFSRecord(this._options);
    }
}
