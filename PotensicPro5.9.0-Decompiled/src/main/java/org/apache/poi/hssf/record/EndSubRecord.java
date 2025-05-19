package org.apache.poi.hssf.record;

import org.apache.poi.util.LittleEndianInput;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public final class EndSubRecord extends SubRecord {
    private static final int ENCODED_SIZE = 0;
    public static final short sid = 0;

    @Override // org.apache.poi.hssf.record.SubRecord
    protected int getDataSize() {
        return 0;
    }

    public short getSid() {
        return (short) 0;
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public boolean isTerminating() {
        return true;
    }

    public EndSubRecord() {
    }

    public EndSubRecord(LittleEndianInput littleEndianInput, int i) {
        if ((i & 255) != 0) {
            throw new RecordFormatException("Unexpected size (" + i + ")");
        }
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ftEnd]\n");
        stringBuffer.append("[/ftEnd]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        littleEndianOutput.writeShort(0);
        littleEndianOutput.writeShort(0);
    }

    @Override // org.apache.poi.hssf.record.SubRecord
    public Object clone() {
        return new EndSubRecord();
    }
}
