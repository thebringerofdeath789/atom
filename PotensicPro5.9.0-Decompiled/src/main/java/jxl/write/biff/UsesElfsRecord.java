package jxl.write.biff;

import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class UsesElfsRecord extends WritableRecordData {
    private byte[] data;
    private boolean usesElfs;

    public UsesElfsRecord() {
        super(Type.USESELFS);
        this.usesElfs = true;
        this.data = new byte[]{1, 0};
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
