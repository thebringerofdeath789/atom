package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class DefaultColumnWidth extends WritableRecordData {
    private byte[] data;
    private int width;

    public DefaultColumnWidth(int i) {
        super(Type.DEFCOLWIDTH);
        this.width = i;
        byte[] bArr = new byte[2];
        this.data = bArr;
        IntegerHelper.getTwoBytes(i, bArr, 0);
    }

    @Override // jxl.biff.WritableRecordData
    protected byte[] getData() {
        return this.data;
    }
}
