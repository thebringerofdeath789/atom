package org.apache.poi.hssf.eventusermodel.dummyrecord;

/* loaded from: classes4.dex */
public final class MissingRowDummyRecord extends DummyRecordBase {
    private int rowNumber;

    @Override // org.apache.poi.hssf.eventusermodel.dummyrecord.DummyRecordBase, org.apache.poi.hssf.record.RecordBase
    public /* bridge */ /* synthetic */ int serialize(int i, byte[] bArr) {
        return super.serialize(i, bArr);
    }

    public MissingRowDummyRecord(int i) {
        this.rowNumber = i;
    }

    public int getRowNumber() {
        return this.rowNumber;
    }
}
