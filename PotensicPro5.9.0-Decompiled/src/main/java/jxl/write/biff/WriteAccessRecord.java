package jxl.write.biff;

import jxl.Workbook;
import jxl.biff.StringHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class WriteAccessRecord extends WritableRecordData {
    private static final String authorString = "Java Excel API";
    private byte[] data;

    public WriteAccessRecord() {
        super(Type.WRITEACCESS);
        this.data = new byte[112];
        String stringBuffer = new StringBuffer().append("Java Excel API v").append(Workbook.getVersion()).toString();
        StringHelper.getBytes(stringBuffer, this.data, 0);
        int length = stringBuffer.length();
        while (true) {
            byte[] bArr = this.data;
            if (length >= bArr.length) {
                return;
            }
            bArr[length] = 32;
            length++;
        }
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
