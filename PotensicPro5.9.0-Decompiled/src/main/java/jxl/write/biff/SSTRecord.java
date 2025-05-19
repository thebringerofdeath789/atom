package jxl.write.biff;

import java.util.ArrayList;
import java.util.Iterator;
import jxl.biff.IntegerHelper;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class SSTRecord extends WritableRecordData {
    private static int maxBytes = 8216;
    private int byteCount;
    private byte[] data;
    private int numReferences;
    private int numStrings;
    private ArrayList stringLengths;
    private ArrayList strings;

    public SSTRecord(int i, int i2) {
        super(Type.SST);
        this.numReferences = i;
        this.numStrings = i2;
        this.byteCount = 0;
        this.strings = new ArrayList(50);
        this.stringLengths = new ArrayList(50);
    }

    public int add(String str) {
        int length = (str.length() * 2) + 3;
        if (this.byteCount >= maxBytes - 5) {
            if (str.length() > 0) {
                return str.length();
            }
            return -1;
        }
        this.stringLengths.add(new Integer(str.length()));
        int i = this.byteCount;
        int i2 = length + i;
        int i3 = maxBytes;
        if (i2 < i3) {
            this.strings.add(str);
            this.byteCount += length;
            return 0;
        }
        int i4 = (i3 - 3) - i;
        if (i4 % 2 != 0) {
            i4--;
        }
        int i5 = i4 / 2;
        this.strings.add(str.substring(0, i5));
        this.byteCount += (i5 * 2) + 3;
        return str.length() - i5;
    }

    public int getOffset() {
        return this.byteCount + 8;
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        int i = 8;
        byte[] bArr = new byte[this.byteCount + 8];
        this.data = bArr;
        int i2 = 0;
        IntegerHelper.getFourBytes(this.numReferences, bArr, 0);
        IntegerHelper.getFourBytes(this.numStrings, this.data, 4);
        Iterator it = this.strings.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            IntegerHelper.getTwoBytes(((Integer) this.stringLengths.get(i2)).intValue(), this.data, i);
            byte[] bArr2 = this.data;
            bArr2[i + 2] = 1;
            StringHelper.getUnicodeBytes(str, bArr2, i + 3);
            i += (str.length() * 2) + 3;
            i2++;
        }
        return this.data;
    }
}
