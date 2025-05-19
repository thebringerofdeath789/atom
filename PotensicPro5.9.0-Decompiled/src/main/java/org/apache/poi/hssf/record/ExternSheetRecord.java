package org.apache.poi.hssf.record;

import java.util.ArrayList;
import java.util.List;
import org.apache.poi.util.LittleEndianOutput;

/* loaded from: classes5.dex */
public class ExternSheetRecord extends StandardRecord {
    public static final short sid = 23;
    private List<RefSubRecord> _list = new ArrayList();

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 23;
    }

    private static final class RefSubRecord {
        public static final int ENCODED_SIZE = 6;
        private int _extBookIndex;
        private int _firstSheetIndex;
        private int _lastSheetIndex;

        public void adjustIndex(int i) {
            this._firstSheetIndex += i;
            this._lastSheetIndex += i;
        }

        public RefSubRecord(int i, int i2, int i3) {
            this._extBookIndex = i;
            this._firstSheetIndex = i2;
            this._lastSheetIndex = i3;
        }

        public RefSubRecord(RecordInputStream recordInputStream) {
            this(recordInputStream.readShort(), recordInputStream.readShort(), recordInputStream.readShort());
        }

        public int getExtBookIndex() {
            return this._extBookIndex;
        }

        public int getFirstSheetIndex() {
            return this._firstSheetIndex;
        }

        public int getLastSheetIndex() {
            return this._lastSheetIndex;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("extBook=").append(this._extBookIndex);
            stringBuffer.append(" firstSheet=").append(this._firstSheetIndex);
            stringBuffer.append(" lastSheet=").append(this._lastSheetIndex);
            return stringBuffer.toString();
        }

        public void serialize(LittleEndianOutput littleEndianOutput) {
            littleEndianOutput.writeShort(this._extBookIndex);
            littleEndianOutput.writeShort(this._firstSheetIndex);
            littleEndianOutput.writeShort(this._lastSheetIndex);
        }
    }

    public ExternSheetRecord() {
    }

    public ExternSheetRecord(RecordInputStream recordInputStream) {
        short readShort = recordInputStream.readShort();
        for (int i = 0; i < readShort; i++) {
            this._list.add(new RefSubRecord(recordInputStream));
        }
    }

    public int getNumOfRefs() {
        return this._list.size();
    }

    public void addREFRecord(RefSubRecord refSubRecord) {
        this._list.add(refSubRecord);
    }

    public int getNumOfREFRecords() {
        return this._list.size();
    }

    @Override // org.apache.poi.hssf.record.Record
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        int size = this._list.size();
        stringBuffer.append("[EXTERNSHEET]\n");
        stringBuffer.append("   numOfRefs     = ").append(size).append("\n");
        for (int i = 0; i < size; i++) {
            stringBuffer.append("refrec         #").append(i).append(": ");
            stringBuffer.append(getRef(i).toString());
            stringBuffer.append('\n');
        }
        stringBuffer.append("[/EXTERNSHEET]\n");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    protected int getDataSize() {
        return (this._list.size() * 6) + 2;
    }

    @Override // org.apache.poi.hssf.record.StandardRecord
    public void serialize(LittleEndianOutput littleEndianOutput) {
        int size = this._list.size();
        littleEndianOutput.writeShort(size);
        for (int i = 0; i < size; i++) {
            getRef(i).serialize(littleEndianOutput);
        }
    }

    private RefSubRecord getRef(int i) {
        return this._list.get(i);
    }

    @Deprecated
    public void adjustIndex(int i, int i2) {
        getRef(i).adjustIndex(i2);
    }

    public void removeSheet(int i) {
        int size = this._list.size();
        int i2 = -1;
        for (int i3 = 0; i3 < size; i3++) {
            RefSubRecord refSubRecord = this._list.get(i3);
            if (refSubRecord.getFirstSheetIndex() == i && refSubRecord.getLastSheetIndex() == i) {
                i2 = i3;
            } else if (refSubRecord.getFirstSheetIndex() > i && refSubRecord.getLastSheetIndex() > i) {
                this._list.set(i3, new RefSubRecord(refSubRecord.getExtBookIndex(), refSubRecord.getFirstSheetIndex() - 1, refSubRecord.getLastSheetIndex() - 1));
            }
        }
        if (i2 != -1) {
            this._list.remove(i2);
        }
    }

    public int getExtbookIndexFromRefIndex(int i) {
        return getRef(i).getExtBookIndex();
    }

    public int findRefIndexFromExtBookIndex(int i) {
        int size = this._list.size();
        for (int i2 = 0; i2 < size; i2++) {
            if (getRef(i2).getExtBookIndex() == i) {
                return i2;
            }
        }
        return -1;
    }

    public int getFirstSheetIndexFromRefIndex(int i) {
        return getRef(i).getFirstSheetIndex();
    }

    public int getLastSheetIndexFromRefIndex(int i) {
        return getRef(i).getLastSheetIndex();
    }

    public int addRef(int i, int i2, int i3) {
        this._list.add(new RefSubRecord(i, i2, i3));
        return this._list.size() - 1;
    }

    public int getRefIxForSheet(int i, int i2, int i3) {
        int size = this._list.size();
        for (int i4 = 0; i4 < size; i4++) {
            RefSubRecord ref = getRef(i4);
            if (ref.getExtBookIndex() == i && ref.getFirstSheetIndex() == i2 && ref.getLastSheetIndex() == i3) {
                return i4;
            }
        }
        return -1;
    }

    public static ExternSheetRecord combine(ExternSheetRecord[] externSheetRecordArr) {
        ExternSheetRecord externSheetRecord = new ExternSheetRecord();
        for (ExternSheetRecord externSheetRecord2 : externSheetRecordArr) {
            int numOfREFRecords = externSheetRecord2.getNumOfREFRecords();
            for (int i = 0; i < numOfREFRecords; i++) {
                externSheetRecord.addREFRecord(externSheetRecord2.getRef(i));
            }
        }
        return externSheetRecord;
    }
}
