package org.apache.poi.hssf.record;

/* loaded from: classes5.dex */
public interface CellValueRecordInterface {
    short getColumn();

    int getRow();

    short getXFIndex();

    void setColumn(short s);

    void setRow(int i);

    void setXFIndex(short s);
}
