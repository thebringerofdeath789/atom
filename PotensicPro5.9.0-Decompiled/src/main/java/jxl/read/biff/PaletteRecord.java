package jxl.read.biff;

import jxl.biff.RecordData;

/* loaded from: classes4.dex */
public class PaletteRecord extends RecordData {
    PaletteRecord(Record record) {
        super(record);
    }

    public byte[] getData() {
        return getRecord().getData();
    }
}
