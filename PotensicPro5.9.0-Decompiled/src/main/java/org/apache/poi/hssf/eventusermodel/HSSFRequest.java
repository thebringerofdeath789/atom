package org.apache.poi.hssf.eventusermodel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.hssf.record.Record;
import org.apache.poi.hssf.record.RecordFactory;

/* loaded from: classes4.dex */
public class HSSFRequest {
    private final Map<Short, List<HSSFListener>> _records = new HashMap(50);

    public void addListener(HSSFListener hSSFListener, short s) {
        List<HSSFListener> list = this._records.get(Short.valueOf(s));
        if (list == null) {
            list = new ArrayList<>(1);
            this._records.put(Short.valueOf(s), list);
        }
        list.add(hSSFListener);
    }

    public void addListenerForAllRecords(HSSFListener hSSFListener) {
        for (short s : RecordFactory.getAllKnownRecordSIDs()) {
            addListener(hSSFListener, s);
        }
    }

    protected short processRecord(Record record) throws HSSFUserException {
        List<HSSFListener> list = this._records.get(Short.valueOf(record.getSid()));
        if (list == null) {
            return (short) 0;
        }
        short s = 0;
        for (int i = 0; i < list.size(); i++) {
            HSSFListener hSSFListener = list.get(i);
            if (hSSFListener instanceof AbortableHSSFListener) {
                s = ((AbortableHSSFListener) hSSFListener).abortableProcessRecord(record);
                if (s != 0) {
                    break;
                }
            } else {
                hSSFListener.processRecord(record);
            }
        }
        return s;
    }
}
