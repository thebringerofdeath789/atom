package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;

/* loaded from: classes5.dex */
final class XSSFEvaluationSheet implements EvaluationSheet {
    private final XSSFSheet _xs;

    public XSSFEvaluationSheet(XSSFSheet xSSFSheet) {
        this._xs = xSSFSheet;
    }

    public XSSFSheet getXSSFSheet() {
        return this._xs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int i, int i2) {
        XSSFCell cell;
        XSSFRow row = this._xs.getRow(i);
        if (row == null || (cell = row.getCell(i2)) == null) {
            return null;
        }
        return new XSSFEvaluationCell(cell, this);
    }
}
