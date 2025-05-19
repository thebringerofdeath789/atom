package org.apache.poi.hssf.eventmodel;

import java.io.InputStream;
import java.util.Arrays;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;
import org.apache.poi.hssf.record.RecordFormatException;
import org.apache.poi.hssf.record.RecordInputStream;

/* loaded from: classes4.dex */
public final class EventRecordFactory {
    private final ERFListener _listener;
    private final short[] _sids;

    public EventRecordFactory(ERFListener eRFListener, short[] sArr) {
        this._listener = eRFListener;
        if (sArr == null) {
            this._sids = null;
            return;
        }
        short[] sArr2 = (short[]) sArr.clone();
        this._sids = sArr2;
        Arrays.sort(sArr2);
    }

    private boolean isSidIncluded(short s) {
        short[] sArr = this._sids;
        return sArr == null || Arrays.binarySearch(sArr, s) >= 0;
    }

    private boolean processRecord(Record record) {
        if (isSidIncluded(record.getSid())) {
            return this._listener.processRecord(record);
        }
        return true;
    }

    public void processRecords(InputStream inputStream) throws RecordFormatException {
        RecordInputStream recordInputStream = new RecordInputStream(inputStream);
        Record record = null;
        while (recordInputStream.hasNextRecord()) {
            recordInputStream.nextRecord();
            Record[] createRecord = RecordFactory.createRecord(recordInputStream);
            if (createRecord.length > 1) {
                for (int i = 0; i < createRecord.length; i++) {
                    if (record != null && !processRecord(record)) {
                        return;
                    }
                    record = createRecord[i];
                }
            } else {
                Record record2 = createRecord[0];
                if (record2 == null) {
                    continue;
                } else if (record != null && !processRecord(record)) {
                    return;
                } else {
                    record = record2;
                }
            }
        }
        if (record != null) {
            processRecord(record);
        }
    }
}
