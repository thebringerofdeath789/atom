package jxl.write.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class FunctionGroupCountRecord extends WritableRecordData {
    private byte[] data;
    private int numFunctionGroups;

    public FunctionGroupCountRecord() {
        super(Type.FNGROUPCOUNT);
        this.numFunctionGroups = 14;
        byte[] bArr = new byte[2];
        this.data = bArr;
        IntegerHelper.getTwoBytes(14, bArr, 0);
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
