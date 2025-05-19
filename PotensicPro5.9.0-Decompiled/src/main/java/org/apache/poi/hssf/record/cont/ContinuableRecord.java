package org.apache.poi.hssf.record.cont;

import org.apache.poi.hssf.record.Record;
import org.apache.poi.util.LittleEndianByteArrayOutputStream;

/* loaded from: classes5.dex */
public abstract class ContinuableRecord extends Record {
    protected abstract void serialize(ContinuableRecordOutput continuableRecordOutput);

    protected ContinuableRecord() {
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int getRecordSize() {
        ContinuableRecordOutput createForCountingOnly = ContinuableRecordOutput.createForCountingOnly();
        serialize(createForCountingOnly);
        createForCountingOnly.terminate();
        return createForCountingOnly.getTotalSize();
    }

    @Override // org.apache.poi.hssf.record.RecordBase
    public final int serialize(int i, byte[] bArr) {
        ContinuableRecordOutput continuableRecordOutput = new ContinuableRecordOutput(new LittleEndianByteArrayOutputStream(bArr, i), getSid());
        serialize(continuableRecordOutput);
        continuableRecordOutput.terminate();
        return continuableRecordOutput.getTotalSize();
    }
}
