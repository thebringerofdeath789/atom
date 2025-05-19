package jxl.biff.drawing;

import jxl.biff.IntegerHelper;

/* loaded from: classes4.dex */
class Dg extends EscherAtom {
    private byte[] data;
    private int drawingId;
    private int seed;
    private int shapeCount;

    public Dg(EscherRecordData escherRecordData) {
        super(escherRecordData);
        this.drawingId = getInstance();
        byte[] bytes = getBytes();
        this.shapeCount = IntegerHelper.getInt(bytes[0], bytes[1], bytes[2], bytes[3]);
        this.seed = IntegerHelper.getInt(bytes[4], bytes[5], bytes[6], bytes[7]);
    }

    public Dg(int i) {
        super(EscherRecordType.DG);
        this.drawingId = 1;
        int i2 = i + 1;
        this.shapeCount = i2;
        this.seed = i2 + 1024 + 1;
        setInstance(1);
    }

    public int getDrawingId() {
        return this.drawingId;
    }

    @Override // jxl.biff.drawing.EscherAtom, jxl.biff.drawing.EscherRecord
    byte[] getData() {
        byte[] bArr = new byte[8];
        this.data = bArr;
        IntegerHelper.getFourBytes(this.shapeCount, bArr, 0);
        IntegerHelper.getFourBytes(this.seed, this.data, 4);
        return setHeaderData(this.data);
    }
}
