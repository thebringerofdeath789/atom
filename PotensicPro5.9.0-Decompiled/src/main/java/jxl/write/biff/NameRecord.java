package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;
import jxl.read.biff.NameRecord;

/* loaded from: classes4.dex */
class NameRecord extends WritableRecordData {
    private static final int areaReference = 59;
    private static final int cellReference = 58;
    private static final int subExpression = 41;
    private static final int union = 16;
    private byte[] data;
    private int index;
    private String name;
    private NameRange[] ranges;
    private int sheetRef;

    class NameRange {
        private int columnFirst;
        private int columnLast;
        private int externalSheet;
        private int rowFirst;
        private int rowLast;

        NameRange(NameRecord.NameRange nameRange) {
            this.columnFirst = nameRange.getFirstColumn();
            this.rowFirst = nameRange.getFirstRow();
            this.columnLast = nameRange.getLastColumn();
            this.rowLast = nameRange.getLastRow();
            this.externalSheet = nameRange.getExternalSheet();
        }

        NameRange(int i, int i2, int i3, int i4, int i5) {
            this.columnFirst = i4;
            this.rowFirst = i2;
            this.columnLast = i5;
            this.rowLast = i3;
            this.externalSheet = i;
        }

        int getFirstColumn() {
            return this.columnFirst;
        }

        int getFirstRow() {
            return this.rowFirst;
        }

        int getLastColumn() {
            return this.columnLast;
        }

        int getLastRow() {
            return this.rowLast;
        }

        int getExternalSheet() {
            return this.externalSheet;
        }

        byte[] getData() {
            byte[] bArr = new byte[10];
            IntegerHelper.getTwoBytes(NameRecord.this.sheetRef, bArr, 0);
            IntegerHelper.getTwoBytes(this.rowFirst, bArr, 2);
            IntegerHelper.getTwoBytes(this.rowLast, bArr, 4);
            IntegerHelper.getTwoBytes(this.columnFirst & 255, bArr, 6);
            IntegerHelper.getTwoBytes(this.columnLast & 255, bArr, 8);
            return bArr;
        }
    }

    public NameRecord(jxl.read.biff.NameRecord nameRecord, int i) {
        super(Type.NAME);
        int i2 = 0;
        this.sheetRef = 0;
        this.data = nameRecord.getData();
        this.name = nameRecord.getName();
        this.sheetRef = nameRecord.getSheetRef();
        this.index = i;
        NameRecord.NameRange[] ranges = nameRecord.getRanges();
        this.ranges = new NameRange[ranges.length];
        while (true) {
            NameRange[] nameRangeArr = this.ranges;
            if (i2 >= nameRangeArr.length) {
                return;
            }
            nameRangeArr[i2] = new NameRange(ranges[i2]);
            i2++;
        }
    }

    NameRecord(String str, int i, int i2, int i3, int i4, int i5, int i6) {
        super(Type.NAME);
        this.sheetRef = 0;
        this.name = str;
        this.index = i;
        this.sheetRef = 0;
        this.ranges = new NameRange[]{new NameRange(i2, i3, i4, i5, i6)};
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] bArr = this.data;
        if (bArr != null) {
            return bArr;
        }
        byte[] bArr2 = new byte[this.name.length() + 15 + 11];
        this.data = bArr2;
        IntegerHelper.getTwoBytes(0, bArr2, 0);
        byte[] bArr3 = this.data;
        bArr3[2] = 0;
        bArr3[3] = (byte) this.name.length();
        IntegerHelper.getTwoBytes(11, this.data, 4);
        IntegerHelper.getTwoBytes(this.ranges[0].externalSheet, this.data, 6);
        IntegerHelper.getTwoBytes(this.ranges[0].externalSheet, this.data, 8);
        StringHelper.getBytes(this.name, this.data, 15);
        int length = this.name.length() + 15;
        this.data[length] = 59;
        byte[] data = this.ranges[0].getData();
        System.arraycopy(data, 0, this.data, length + 1, data.length);
        return this.data;
    }

    public String getName() {
        return this.name;
    }

    public int getIndex() {
        return this.index;
    }

    public int getSheetRef() {
        return this.sheetRef;
    }

    public void setSheetRef(int i) {
        this.sheetRef = i;
        IntegerHelper.getTwoBytes(i, this.data, 8);
    }

    public NameRange[] getRanges() {
        return this.ranges;
    }
}
