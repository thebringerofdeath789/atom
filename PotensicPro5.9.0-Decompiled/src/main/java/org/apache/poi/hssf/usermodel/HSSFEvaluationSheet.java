package org.apache.poi.hssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;

/* loaded from: classes5.dex */
final class HSSFEvaluationSheet implements EvaluationSheet {
    private final HSSFSheet _hs;

    public HSSFEvaluationSheet(HSSFSheet hSSFSheet) {
        this._hs = hSSFSheet;
    }

    public HSSFSheet getHSSFSheet() {
        return this._hs;
    }

    @Override // org.apache.poi.ss.formula.EvaluationSheet
    public EvaluationCell getCell(int i, int i2) {
        HSSFCell cell;
        HSSFRow row = this._hs.getRow(i);
        if (row == null || (cell = row.getCell(i2)) == null) {
            return null;
        }
        return new HSSFEvaluationCell(cell, this);
    }
}
