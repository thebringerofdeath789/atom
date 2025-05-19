package jxl.write.biff;

import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class GridSetRecord extends WritableRecordData {
    private byte[] data;
    private boolean gridSet;

    public GridSetRecord(boolean z) {
        super(Type.GRIDSET);
        this.gridSet = z;
        byte[] bArr = new byte[2];
        this.data = bArr;
        if (z) {
            bArr[0] = 1;
        }
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
