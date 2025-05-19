package org.apache.poi.hssf.util;

import org.apache.poi.hssf.record.RecordInputStream;

/* loaded from: classes5.dex */
public class CellRangeAddress extends org.apache.poi.ss.util.CellRangeAddress {
    public CellRangeAddress(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public CellRangeAddress(RecordInputStream recordInputStream) {
        super(recordInputStream);
    }
}
