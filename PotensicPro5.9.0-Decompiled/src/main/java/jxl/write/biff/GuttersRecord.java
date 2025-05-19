package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class GuttersRecord extends WritableRecordData {
    private int colGutter;
    private byte[] data;
    private int maxColOutline;
    private int maxRowOutline;
    private int rowGutter;

    public GuttersRecord() {
        super(Type.GUTS);
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        byte[] bArr = new byte[8];
        this.data = bArr;
        IntegerHelper.getTwoBytes(this.rowGutter, bArr, 0);
        IntegerHelper.getTwoBytes(this.colGutter, this.data, 2);
        IntegerHelper.getTwoBytes(this.maxRowOutline, this.data, 4);
        IntegerHelper.getTwoBytes(this.maxColOutline, this.data, 6);
        return this.data;
    }
}
