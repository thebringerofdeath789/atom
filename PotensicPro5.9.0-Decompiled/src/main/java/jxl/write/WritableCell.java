package jxl.write;

import jxl.Cell;
import jxl.format.CellFormat;

/* loaded from: classes4.dex */
public interface WritableCell extends Cell {
    WritableCell copyTo(int i, int i2);

    WritableCellFeatures getWritableCellFeatures();

    void setCellFeatures(WritableCellFeatures writableCellFeatures);

    void setCellFormat(CellFormat cellFormat);
}
