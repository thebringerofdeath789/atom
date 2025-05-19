package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class PasswordRecord extends WritableRecordData {
    private byte[] data;
    private String password;

    private int rotLeft15Bit(int i, int i2) {
        int i3 = i & 32767;
        while (i2 > 0) {
            i3 = (i3 & 16384) != 0 ? ((i3 << 1) & 32767) + 1 : (i3 << 1) & 32767;
            i2--;
        }
        return i3;
    }

    public PasswordRecord(String str) {
        super(Type.PASSWORD);
        this.password = str;
        if (str == null) {
            byte[] bArr = new byte[2];
            this.data = bArr;
            IntegerHelper.getTwoBytes(0, bArr, 0);
            return;
        }
        byte[] bytes = str.getBytes();
        int i = 0;
        int i2 = 0;
        while (i < bytes.length) {
            byte b = bytes[i];
            i++;
            i2 ^= rotLeft15Bit(b, i);
        }
        int length = (bytes.length ^ i2) ^ 52811;
        byte[] bArr2 = new byte[2];
        this.data = bArr2;
        IntegerHelper.getTwoBytes(length, bArr2, 0);
    }

    public PasswordRecord(int i) {
        super(Type.PASSWORD);
        byte[] bArr = new byte[2];
        this.data = bArr;
        IntegerHelper.getTwoBytes(i, bArr, 0);
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
