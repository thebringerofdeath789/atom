package org.apache.poi.hssf.record;

import java.util.Iterator;
import java.util.List;
import org.apache.poi.ddf.EscherRecord;
import org.apache.poi.ddf.NullEscherSerializationListener;
import org.apache.poi.util.LittleEndian;

/* loaded from: classes5.dex */
public final class DrawingGroupRecord extends AbstractEscherHolderRecord {
    private static final int MAX_DATA_SIZE = 8224;
    static final int MAX_RECORD_SIZE = 8228;
    public static final short sid = 235;

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord
    protected String getRecordName() {
        return "MSODRAWINGGROUP";
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.Record
    public short getSid() {
        return sid;
    }

    public DrawingGroupRecord() {
    }

    public DrawingGroupRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        byte[] rawData = getRawData();
        if (getEscherRecords().size() == 0 && rawData != null) {
            return writeData(i, bArr, rawData);
        }
        byte[] bArr2 = new byte[getRawDataSize()];
        int i2 = 0;
        Iterator<EscherRecord> it = getEscherRecords().iterator();
        while (it.hasNext()) {
            i2 += it.next().serialize(i2, bArr2, new NullEscherSerializationListener());
        }
        return writeData(i, bArr, bArr2);
    }

    public void processChildRecords() {
        convertRawBytesToEscherRecords();
    }

    @Override // org.apache.poi.hssf.record.AbstractEscherHolderRecord, org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        return grossSizeFromDataSize(getRawDataSize());
    }

    private int getRawDataSize() {
        List<EscherRecord> escherRecords = getEscherRecords();
        byte[] rawData = getRawData();
        if (escherRecords.size() == 0 && rawData != null) {
            return rawData.length;
        }
        int i = 0;
        Iterator<EscherRecord> it = escherRecords.iterator();
        while (it.hasNext()) {
            i += it.next().getRecordSize();
        }
        return i;
    }

    static int grossSizeFromDataSize(int i) {
        return i + ((((i - 1) / MAX_DATA_SIZE) + 1) * 4);
    }

    private int writeData(int i, byte[] bArr, byte[] bArr2) {
        int i2 = 0;
        int i3 = 0;
        while (i2 < bArr2.length) {
            int min = Math.min(bArr2.length - i2, MAX_DATA_SIZE);
            if (i2 / MAX_DATA_SIZE >= 2) {
                writeContinueHeader(bArr, i, min);
            } else {
                writeHeader(bArr, i, min);
            }
            int i4 = i + 4;
            System.arraycopy(bArr2, i2, bArr, i4, min);
            i = i4 + min;
            i2 += min;
            i3 = i3 + 4 + min;
        }
        return i3;
    }

    private void writeHeader(byte[] bArr, int i, int i2) {
        LittleEndian.putShort(bArr, i + 0, getSid());
        LittleEndian.putShort(bArr, i + 2, (short) i2);
    }

    private void writeContinueHeader(byte[] bArr, int i, int i2) {
        LittleEndian.putShort(bArr, i + 0, (short) 60);
        LittleEndian.putShort(bArr, i + 2, (short) i2);
    }
}
