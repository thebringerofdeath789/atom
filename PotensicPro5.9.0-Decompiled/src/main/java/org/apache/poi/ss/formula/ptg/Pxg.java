package org.apache.poi.ss.formula.ptg;

/* loaded from: classes5.dex */
public interface Pxg {
    int getExternalWorkbookNumber();

    String getSheetName();

    void setSheetName(String str);

    String toFormulaString();
}
