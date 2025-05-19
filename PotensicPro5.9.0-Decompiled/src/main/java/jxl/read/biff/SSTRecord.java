package jxl.read.biff;

import common.Assert;
import jxl.WorkbookSettings;
import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;
import jxl.biff.StringHelper;

/* loaded from: classes4.dex */
class SSTRecord extends RecordData {
    private int[] continuationBreaks;
    private String[] strings;
    private int totalStrings;
    private int uniqueStrings;

    private static class ByteArrayHolder {
        public byte[] bytes;

        private ByteArrayHolder() {
        }
    }

    private static class BooleanHolder {
        public boolean value;

        private BooleanHolder() {
        }
    }

    public SSTRecord(Record record, Record[] recordArr, WorkbookSettings workbookSettings) {
        super(record);
        int i = 0;
        for (Record record2 : recordArr) {
            i += record2.getLength();
        }
        byte[] bArr = new byte[i + getRecord().getLength()];
        System.arraycopy(getRecord().getData(), 0, bArr, 0, getRecord().getLength());
        int length = getRecord().getLength() + 0;
        this.continuationBreaks = new int[recordArr.length];
        for (int i2 = 0; i2 < recordArr.length; i2++) {
            Record record3 = recordArr[i2];
            System.arraycopy(record3.getData(), 0, bArr, length, record3.getLength());
            this.continuationBreaks[i2] = length;
            length += record3.getLength();
        }
        this.totalStrings = IntegerHelper.getInt(bArr[0], bArr[1], bArr[2], bArr[3]);
        int i3 = IntegerHelper.getInt(bArr[4], bArr[5], bArr[6], bArr[7]);
        this.uniqueStrings = i3;
        this.strings = new String[i3];
        readStrings(bArr, 8, workbookSettings);
    }

    private void readStrings(byte[] bArr, int i, WorkbookSettings workbookSettings) {
        String unicodeString;
        int i2 = i;
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        while (i5 < this.uniqueStrings) {
            int i6 = IntegerHelper.getInt(bArr[i2], bArr[i2 + 1]);
            int i7 = i2 + 2;
            byte b = bArr[i7];
            int i8 = i7 + 1;
            boolean z = (b & 4) != 0;
            boolean z2 = (b & 8) != 0;
            if (z2) {
                i3 = IntegerHelper.getInt(bArr[i8], bArr[i8 + 1]);
                i8 += 2;
            }
            int i9 = i3;
            if (z) {
                i4 = IntegerHelper.getInt(bArr[i8], bArr[i8 + 1], bArr[i8 + 2], bArr[i8 + 3]);
                i8 += 4;
            }
            int i10 = i8;
            int i11 = i4;
            boolean z3 = (b & 1) == 0;
            ByteArrayHolder byteArrayHolder = new ByteArrayHolder();
            BooleanHolder booleanHolder = new BooleanHolder();
            booleanHolder.value = z3;
            int chars = i10 + getChars(bArr, byteArrayHolder, i10, booleanHolder, i6);
            if (booleanHolder.value) {
                unicodeString = StringHelper.getString(byteArrayHolder.bytes, i6, 0, workbookSettings);
            } else {
                unicodeString = StringHelper.getUnicodeString(byteArrayHolder.bytes, i6, 0);
            }
            this.strings[i5] = unicodeString;
            if (z2) {
                chars += i9 * 4;
            }
            if (z) {
                chars += i11;
            }
            i2 = chars;
            if (i2 > bArr.length) {
                Assert.verify(false, "pos exceeds record length");
            }
            i5++;
            i3 = i9;
            i4 = i11;
        }
    }

    private int getChars(byte[] bArr, ByteArrayHolder byteArrayHolder, int i, BooleanHolder booleanHolder, int i2) {
        int[] iArr;
        if (booleanHolder.value) {
            byteArrayHolder.bytes = new byte[i2];
        } else {
            byteArrayHolder.bytes = new byte[i2 * 2];
        }
        boolean z = false;
        int i3 = 0;
        while (true) {
            iArr = this.continuationBreaks;
            if (i3 >= iArr.length || z) {
                break;
            }
            z = i <= iArr[i3] && byteArrayHolder.bytes.length + i > this.continuationBreaks[i3];
            if (!z) {
                i3++;
            }
        }
        if (!z) {
            System.arraycopy(bArr, i, byteArrayHolder.bytes, 0, byteArrayHolder.bytes.length);
            return byteArrayHolder.bytes.length;
        }
        int i4 = iArr[i3] - i;
        System.arraycopy(bArr, i, byteArrayHolder.bytes, 0, i4);
        return i4 + getContinuedString(bArr, byteArrayHolder, i4, i3, booleanHolder, i2 - (booleanHolder.value ? i4 : i4 / 2));
    }

    private int getContinuedString(byte[] bArr, ByteArrayHolder byteArrayHolder, int i, int i2, BooleanHolder booleanHolder, int i3) {
        int i4 = i2;
        int i5 = i3;
        int i6 = this.continuationBreaks[i2];
        int i7 = 0;
        int i8 = i;
        while (i5 > 0) {
            Assert.verify(i4 < this.continuationBreaks.length, "continuation break index");
            if (booleanHolder.value && bArr[i6] == 0) {
                int[] iArr = this.continuationBreaks;
                int min = i4 == iArr.length - 1 ? i5 : Math.min(i5, (iArr[i4 + 1] - i6) - 1);
                System.arraycopy(bArr, i6 + 1, byteArrayHolder.bytes, i8, min);
                i8 += min;
                i7 += min + 1;
                i5 -= min;
                booleanHolder.value = true;
            } else if (!booleanHolder.value && bArr[i6] != 0) {
                int[] iArr2 = this.continuationBreaks;
                int min2 = i4 == iArr2.length - 1 ? i5 * 2 : Math.min(i5 * 2, (iArr2[i4 + 1] - i6) - 1);
                System.arraycopy(bArr, i6 + 1, byteArrayHolder.bytes, i8, min2);
                i8 += min2;
                i7 += min2 + 1;
                i5 -= min2 / 2;
                booleanHolder.value = false;
            } else if (!booleanHolder.value && bArr[i6] == 0) {
                int[] iArr3 = this.continuationBreaks;
                int min3 = i4 == iArr3.length - 1 ? i5 : Math.min(i5, (iArr3[i4 + 1] - i6) - 1);
                for (int i9 = 0; i9 < min3; i9++) {
                    byteArrayHolder.bytes[i8] = bArr[i6 + i9 + 1];
                    i8 += 2;
                }
                i7 += min3 + 1;
                i5 -= min3;
                booleanHolder.value = false;
            } else {
                byte[] bArr2 = byteArrayHolder.bytes;
                int i10 = i8 * 2;
                int i11 = i5 * 2;
                byteArrayHolder.bytes = new byte[i10 + i11];
                for (int i12 = 0; i12 < i8; i12++) {
                    byteArrayHolder.bytes[i12 * 2] = bArr2[i12];
                }
                int[] iArr4 = this.continuationBreaks;
                if (i4 != iArr4.length - 1) {
                    i11 = Math.min(i11, (iArr4[i4 + 1] - i6) - 1);
                }
                System.arraycopy(bArr, i6 + 1, byteArrayHolder.bytes, i10, i11);
                i7 += i11 + 1;
                i5 -= i11 / 2;
                booleanHolder.value = false;
                i8 = i10 + i11;
            }
            i4++;
            int[] iArr5 = this.continuationBreaks;
            if (i4 < iArr5.length) {
                i6 = iArr5[i4];
            }
        }
        return i7;
    }

    public String getString(int i) {
        Assert.verify(i < this.uniqueStrings);
        return this.strings[i];
    }
}
