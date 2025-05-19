package org.apache.poi.hssf.record;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.List;
import org.apache.poi.util.HexDump;
import org.apache.poi.util.LittleEndian;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;
import org.apache.poi.util.LittleEndianInputStream;

/* loaded from: classes5.dex */
public final class ObjRecord extends Record {
    private static int MAX_PAD_ALIGNMENT = 4;
    private static final int NORMAL_PAD_ALIGNMENT = 2;
    public static final short sid = 93;
    private boolean _isPaddedToQuadByteMultiple;
    private final byte[] _uninterpretedData;
    private List<SubRecord> subrecords;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 93;
    }

    public ObjRecord() {
        this.subrecords = new ArrayList(2);
        this._uninterpretedData = null;
    }

    public ObjRecord(RecordInputStream recordInputStream) {
        SubRecord createSubRecord;
        byte[] readRemainder = recordInputStream.readRemainder();
        if (LittleEndian.getUShort(readRemainder, 0) != 21) {
            this._uninterpretedData = readRemainder;
            this.subrecords = null;
            return;
        }
        this.subrecords = new ArrayList();
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(readRemainder);
        LittleEndianInputStream littleEndianInputStream = new LittleEndianInputStream(byteArrayInputStream);
        CommonObjectDataSubRecord commonObjectDataSubRecord = (CommonObjectDataSubRecord) SubRecord.createSubRecord(littleEndianInputStream, 0);
        this.subrecords.add(commonObjectDataSubRecord);
        do {
            createSubRecord = SubRecord.createSubRecord(littleEndianInputStream, commonObjectDataSubRecord.getObjectType());
            this.subrecords.add(createSubRecord);
        } while (!createSubRecord.isTerminating());
        int available = byteArrayInputStream.available();
        if (available > 0) {
            int length = readRemainder.length;
            int i = MAX_PAD_ALIGNMENT;
            boolean z = length % i == 0;
            this._isPaddedToQuadByteMultiple = z;
            if (available >= (z ? i : 2)) {
                if (!canPaddingBeDiscarded(readRemainder, available)) {
                    throw new RecordFormatException("Leftover " + available + " bytes in subrecord data " + HexDump.toHex(readRemainder));
                }
                this._isPaddedToQuadByteMultiple = false;
            }
        } else {
            this._isPaddedToQuadByteMultiple = false;
        }
        this._uninterpretedData = null;
    }

    private static boolean canPaddingBeDiscarded(byte[] bArr, int i) {
        for (int length = bArr.length - i; length < bArr.length; length++) {
            if (bArr[length] != 0) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[OBJ]\n");
        if (this.subrecords != null) {
            for (int i = 0; i < this.subrecords.size(); i++) {
                stringBuffer.append("SUBRECORD: ").append(this.subrecords.get(i).toString());
            }
        }
        stringBuffer.append("[/OBJ]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int getRecordSize() {
        byte[] bArr = this._uninterpretedData;
        if (bArr != null) {
            return bArr.length + 4;
        }
        int i = 0;
        for (int size = this.subrecords.size() - 1; size >= 0; size--) {
            i += this.subrecords.get(size).getDataSize() + 4;
        }
        if (this._isPaddedToQuadByteMultiple) {
            while (i % MAX_PAD_ALIGNMENT != 0) {
                i++;
            }
        } else {
            while (i % 2 != 0) {
                i++;
            }
        }
        return i + 4;
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public int serialize(int i, byte[] bArr) {
        int recordSize = getRecordSize();
        int i2 = recordSize - 4;
        LittleEndianByteArrayOutputStream littleEndianByteArrayOutputStream = new LittleEndianByteArrayOutputStream(bArr, i, recordSize);
        littleEndianByteArrayOutputStream.writeShort(93);
        littleEndianByteArrayOutputStream.writeShort(i2);
        byte[] bArr2 = this._uninterpretedData;
        if (bArr2 == null) {
            for (int i3 = 0; i3 < this.subrecords.size(); i3++) {
                this.subrecords.get(i3).serialize(littleEndianByteArrayOutputStream);
            }
            int i4 = i + i2;
            while (littleEndianByteArrayOutputStream.getWriteIndex() < i4) {
                littleEndianByteArrayOutputStream.writeByte(0);
            }
        } else {
            littleEndianByteArrayOutputStream.write(bArr2);
        }
        return recordSize;
    }

    public List<SubRecord> getSubRecords() {
        return this.subrecords;
    }

    public void clearSubRecords() {
        this.subrecords.clear();
    }

    public void addSubRecord(int i, SubRecord subRecord) {
        this.subrecords.add(i, subRecord);
    }

    public boolean addSubRecord(SubRecord subRecord) {
        return this.subrecords.add(subRecord);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        ObjRecord objRecord = new ObjRecord();
        for (int i = 0; i < this.subrecords.size(); i++) {
            objRecord.addSubRecord((SubRecord) this.subrecords.get(i).clone());
        }
        return objRecord;
    }
}
