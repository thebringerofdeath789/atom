package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public interface TwoDEval extends ValueEval {
    TwoDEval getColumn(int i);

    int getHeight();

    TwoDEval getRow(int i);

    ValueEval getValue(int i, int i2);

    int getWidth();

    boolean isColumn();

    boolean isRow();

    boolean isSubTotal(int i, int i2);
}
