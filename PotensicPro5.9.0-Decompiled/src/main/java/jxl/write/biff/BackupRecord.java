package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class BackupRecord extends WritableRecordData {
    private boolean backup;
    private byte[] data;

    public BackupRecord(boolean z) {
        super(Type.BACKUP);
        this.backup = z;
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
