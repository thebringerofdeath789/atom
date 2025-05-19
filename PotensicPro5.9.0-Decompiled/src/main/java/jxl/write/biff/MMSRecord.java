package jxl.write.biff;

import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class MMSRecord extends WritableRecordData {
    private byte[] data;
    private byte numMenuItemsAdded;
    private byte numMenuItemsDeleted;

    public MMSRecord(int i, int i2) {
        super(Type.MMS);
        byte b = (byte) i;
        this.numMenuItemsAdded = b;
        byte b2 = (byte) i2;
        this.numMenuItemsDeleted = b2;
        this.data = new byte[]{b, b2};
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
