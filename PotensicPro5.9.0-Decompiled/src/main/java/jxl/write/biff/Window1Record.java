package jxl.write.biff;

import jxl.biff.Type;
import jxl.biff.WritableRecordData;

/* loaded from: classes4.dex */
class Window1Record extends WritableRecordData {
    private byte[] data;

    public Window1Record() {
        super(Type.WINDOW1);
        this.data = new byte[]{104, 1, 14, 1, 92, 58, -66, 35, org.apache.poi.hssf.record.PaletteRecord.STANDARD_PALETTE_SIZE, 0, 0, 0, 0, 0, 1, 0, 88, 2};
    }

    @Override // jxl.biff.WritableRecordData
    public byte[] getData() {
        return this.data;
    }
}
