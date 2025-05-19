package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.SheetRange;

/* loaded from: classes5.dex */
public interface RefEval extends ValueEval, SheetRange {
    int getColumn();

    @Override // org.apache.poi.ss.formula.SheetRange
    int getFirstSheetIndex();

    ValueEval getInnerValueEval(int i);

    @Override // org.apache.poi.ss.formula.SheetRange
    int getLastSheetIndex();

    int getNumberOfSheets();

    int getRow();

    AreaEval offset(int i, int i2, int i3, int i4);
}
