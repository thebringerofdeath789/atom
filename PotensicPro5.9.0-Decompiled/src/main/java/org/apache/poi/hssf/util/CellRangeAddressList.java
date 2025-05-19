package org.apache.poi.hssf.util;

import org.apache.poi.hssf.record.RecordInputStream;

/* loaded from: classes5.dex */
public class CellRangeAddressList extends org.apache.poi.ss.util.CellRangeAddressList {
    public CellRangeAddressList(int i, int i2, int i3, int i4) {
        super(i, i2, i3, i4);
    }

    public CellRangeAddressList() {
    }

    public CellRangeAddressList(RecordInputStream recordInputStream) {
        int readUShort = recordInputStream.readUShort();
        for (int i = 0; i < readUShort; i++) {
            this._list.add(new CellRangeAddress(recordInputStream));
        }
    }
}
