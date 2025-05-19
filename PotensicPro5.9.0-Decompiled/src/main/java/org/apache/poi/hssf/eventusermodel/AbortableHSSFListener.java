package org.apache.poi.hssf.eventusermodel;

import org.apache.poi.hssf.record.Record;

/* loaded from: classes4.dex */
public abstract class AbortableHSSFListener implements HSSFListener {
    public abstract short abortableProcessRecord(Record record) throws HSSFUserException;

    @Override // org.apache.poi.hssf.eventusermodel.HSSFListener
    public void processRecord(Record record) {
    }
}
