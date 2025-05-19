package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class DimensionRecord extends WritableRecordData {
    private byte[] data;
    private int numCols;
    private int numRows;

    public DimensionRecord(int i, int i2) {
        super(Type.DIMENSION);
        this.numRows = i;
        this.numCols = i2;
        byte[] bArr = new byte[14];
        this.data = bArr;
        IntegerHelper.getFourBytes(i, bArr, 4);
        IntegerHelper.getTwoBytes(this.numCols, this.data, 10);
    }

    @Override // jxl.biff.WritableRecordData
    protected byte[] getData() {
        return this.data;
    }
}
