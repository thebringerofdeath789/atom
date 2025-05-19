package jxl.read.biff;

import jxl.biff.IntegerHelper;
import jxl.biff.RecordData;
import jxl.biff.Type;

/* loaded from: classes4.dex */
public class ColumnInfoRecord extends RecordData {
    private byte[] data;
    private int endColumn;
    private boolean hidden;
    private int startColumn;
    private int width;
    private int xfIndex;

    ColumnInfoRecord(Record record) {
        super(Type.COLINFO);
        byte[] data = record.getData();
        this.data = data;
        this.startColumn = IntegerHelper.getInt(data[0], data[1]);
        byte[] bArr = this.data;
        this.endColumn = IntegerHelper.getInt(bArr[2], bArr[3]);
        byte[] bArr2 = this.data;
        this.width = IntegerHelper.getInt(bArr2[4], bArr2[5]);
        byte[] bArr3 = this.data;
        this.xfIndex = IntegerHelper.getInt(bArr3[6], bArr3[7]);
        byte[] bArr4 = this.data;
        this.hidden = (IntegerHelper.getInt(bArr4[8], bArr4[9]) & 1) != 0;
    }

    public int getStartColumn() {
        return this.startColumn;
    }

    public int getEndColumn() {
        return this.endColumn;
    }

    public int getXFIndex() {
        return this.xfIndex;
    }

    public int getWidth() {
        return this.width;
    }

    public boolean getHidden() {
        return this.hidden;
    }
}
