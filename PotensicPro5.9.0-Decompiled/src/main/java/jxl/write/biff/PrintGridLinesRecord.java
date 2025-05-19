package jxl.write.biff;

import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class PrintGridLinesRecord extends WritableRecordData {
    private byte[] data;
    private boolean printGridLines;

    public PrintGridLinesRecord(boolean z) {
        super(Type.PRINTGRIDLINES);
        this.printGridLines = z;
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
