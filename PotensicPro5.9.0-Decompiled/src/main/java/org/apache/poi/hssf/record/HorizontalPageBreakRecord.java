package org.apache.poi.hssf.record;

import java.util.Iterator;
import org.apache.poi.hssf.record.PageBreakRecord;

/* loaded from: classes5.dex */
public final class HorizontalPageBreakRecord extends PageBreakRecord {
    public static final short sid = 27;

    @Override // org.apache.poi.hssf.record.Record
    public short getSid() {
        return (short) 27;
    }

    public HorizontalPageBreakRecord() {
    }

    public HorizontalPageBreakRecord(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }

    @Override // org.apache.poi.hssf.record.Record
    public Object clone() {
        HorizontalPageBreakRecord horizontalPageBreakRecord = new HorizontalPageBreakRecord();
        Iterator<PageBreakRecord.Break> breaksIterator = getBreaksIterator();
        while (breaksIterator.hasNext()) {
            PageBreakRecord.Break next = breaksIterator.next();
            horizontalPageBreakRecord.addBreak(next.main, next.subFrom, next.subTo);
        }
        return horizontalPageBreakRecord;
    }
}
