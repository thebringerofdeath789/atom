package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class BookboolRecord extends WritableRecordData {
    private byte[] data;
    private boolean externalLink;

    public BookboolRecord(boolean z) {
        super(Type.BOOKBOOL);
        this.externalLink = z;
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
