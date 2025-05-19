package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class WindowProtectRecord extends WritableRecordData {
    private byte[] data;
    private boolean protection;

    public WindowProtectRecord(boolean z) {
        super(Type.WINDOWPROTECT);
        this.protection = z;
        byte[] bArr = new byte[2];
        this.data = bArr;
        if (z) {
            IntegerHelper.getTwoBytes(1, bArr, 0);
        }
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
