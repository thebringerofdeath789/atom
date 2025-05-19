package org.apache.poi.xssf.usermodel;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;

/* loaded from: classes5.dex */
final class XSSFEvaluationCell implements EvaluationCell {
    private final XSSFCell _cell;
    private final EvaluationSheet _evalSheet;

    public XSSFEvaluationCell(XSSFCell xSSFCell, XSSFEvaluationSheet xSSFEvaluationSheet) {
        this._cell = xSSFCell;
        this._evalSheet = xSSFEvaluationSheet;
    }

    public XSSFEvaluationCell(XSSFCell xSSFCell) {
        this(xSSFCell, new XSSFEvaluationSheet(xSSFCell.getSheet()));
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public Object getIdentityKey() {
        return this._cell;
    }

    public XSSFCell getXSSFCell() {
        return this._cell;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public boolean getBooleanCellValue() {
        return this._cell.getBooleanCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCellType() {
        return this._cell.getCellType();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getColumnIndex() {
        return this._cell.getColumnIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getErrorCellValue() {
        return this._cell.getErrorCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public double getNumericCellValue() {
        return this._cell.getNumericCellValue();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getRowIndex() {
        return this._cell.getRowIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public EvaluationSheet getSheet() {
        return this._evalSheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public String getStringCellValue() {
        return this._cell.getRichStringCellValue().getString();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCachedFormulaResultType() {
        return this._cell.getCachedFormulaResultType();
    }
}
