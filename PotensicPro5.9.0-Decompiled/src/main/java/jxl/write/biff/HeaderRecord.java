package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class HeaderRecord extends WritableRecordData {
    private byte[] data;
    private String header;

    public HeaderRecord(String str) {
        super(Type.HEADER);
        this.header = str;
    }

    public HeaderRecord(HeaderRecord headerRecord) {
        super(Type.HEADER);
        this.header = headerRecord.header;
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        String str = this.header;
        if (str == null || str.length() == 0) {
            byte[] bArr = new byte[0];
            this.data = bArr;
            return bArr;
        }
        this.data = new byte[(this.header.length() * 2) + 3];
        IntegerHelper.getTwoBytes(this.header.length(), this.data, 0);
        byte[] bArr2 = this.data;
        bArr2[2] = 1;
        StringHelper.getUnicodeBytes(this.header, bArr2, 3);
        return this.data;
    }
}
