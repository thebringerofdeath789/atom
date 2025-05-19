package jxl.write.biff;

import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class PLSRecord extends WritableRecordData {
    private byte[] data;

    public PLSRecord(jxl.read.biff.PLSRecord pLSRecord) {
        super(Type.PLS);
        this.data = pLSRecord.getData();
    }

    public PLSRecord(PLSRecord pLSRecord) {
        super(Type.PLS);
        byte[] bArr = new byte[pLSRecord.data.length];
        this.data = bArr;
        System.arraycopy(pLSRecord.data, 0, bArr, 0, bArr.length);
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
