package org.apache.poi.ss.formula;

/* loaded from: classes5.dex */
public interface EvaluationCell {
    boolean getBooleanCellValue();

    int getCachedFormulaResultType();

    int getCellType();

    int getColumnIndex();

    int getErrorCellValue();

    Object getIdentityKey();

    double getNumericCellValue();

    int getRowIndex();

    EvaluationSheet getSheet();

    String getStringCellValue();
}
