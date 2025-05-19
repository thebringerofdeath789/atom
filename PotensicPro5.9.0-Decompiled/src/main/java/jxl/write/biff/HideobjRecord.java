package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class HideobjRecord extends WritableRecordData {
    private byte[] data;
    private boolean hideAll;

    public HideobjRecord(boolean z) {
        super(Type.HIDEOBJ);
        this.hideAll = z;
        byte[] bArr = new byte[2];
        this.data = bArr;
        if (z) {
            IntegerHelper.getTwoBytes(2, bArr, 0);
        }
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
