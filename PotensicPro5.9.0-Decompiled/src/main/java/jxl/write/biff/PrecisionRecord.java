package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class PrecisionRecord extends WritableRecordData {
    private boolean asDisplayed;
    private byte[] data;

    public PrecisionRecord(boolean z) {
        super(Type.PRECISION);
        this.asDisplayed = z;
        byte[] bArr = new byte[2];
        this.data = bArr;
        if (z) {
            return;
        }
        IntegerHelper.getTwoBytes(1, bArr, 0);
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
