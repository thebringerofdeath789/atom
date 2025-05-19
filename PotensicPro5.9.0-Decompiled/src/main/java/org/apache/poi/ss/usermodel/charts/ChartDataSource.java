package org.apache.poi.ss.usermodel.charts;

/* loaded from: classes5.dex */
public interface ChartDataSource<T> {
    String getFormulaString();

    T getPointAt(int i);

    int getPointCount();

    boolean isNumeric();

    boolean isReference();
}
