package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.AreaEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;
import org.apache.xmlbeans.impl.common.NameUtil;

/* loaded from: classes5.dex */
final class LazyAreaEval extends AreaEvalBase {
    private final SheetRangeEvaluator _evaluator;

    LazyAreaEval(AreaI areaI, SheetRangeEvaluator sheetRangeEvaluator) {
        super(areaI, sheetRangeEvaluator);
        this._evaluator = sheetRangeEvaluator;
    }

    public LazyAreaEval(int i, int i2, int i3, int i4, SheetRangeEvaluator sheetRangeEvaluator) {
        super(sheetRangeEvaluator, i, i2, i3, i4);
        this._evaluator = sheetRangeEvaluator;
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.eval.AreaEval
    public ValueEval getRelativeValue(int i, int i2) {
        return getRelativeValue(getFirstSheetIndex(), i, i2);
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase
    public ValueEval getRelativeValue(int i, int i2, int i3) {
        return this._evaluator.getEvalForCell(i, i2 + getFirstRow(), i3 + getFirstColumn());
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEval
    public AreaEval offset(int i, int i2, int i3, int i4) {
        return new LazyAreaEval(new AreaI.OffsetArea(getFirstRow(), getFirstColumn(), i, i2, i3, i4), this._evaluator);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getRow(int i) {
        if (i >= getHeight()) {
            throw new IllegalArgumentException("Invalid rowIndex " + i + ".  Allowable range is (0.." + getHeight() + ").");
        }
        int firstRow = getFirstRow() + i;
        return new LazyAreaEval(firstRow, getFirstColumn(), firstRow, getLastColumn(), this._evaluator);
    }

    @Override // org.apache.poi.ss.formula.TwoDEval
    public LazyAreaEval getColumn(int i) {
        if (i >= getWidth()) {
            throw new IllegalArgumentException("Invalid columnIndex " + i + ".  Allowable range is (0.." + getWidth() + ").");
        }
        int firstColumn = getFirstColumn() + i;
        return new LazyAreaEval(getFirstRow(), firstColumn, getLastRow(), firstColumn, this._evaluator);
    }

    public String toString() {
        CellReference cellReference = new CellReference(getFirstRow(), getFirstColumn());
        CellReference cellReference2 = new CellReference(getLastRow(), getLastColumn());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName()).append("[");
        stringBuffer.append(this._evaluator.getSheetNameRange());
        stringBuffer.append('!');
        stringBuffer.append(cellReference.formatAsString());
        stringBuffer.append(NameUtil.COLON);
        stringBuffer.append(cellReference2.formatAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    @Override // org.apache.poi.ss.formula.eval.AreaEvalBase, org.apache.poi.ss.formula.TwoDEval
    public boolean isSubTotal(int i, int i2) {
        SheetRangeEvaluator sheetRangeEvaluator = this._evaluator;
        return sheetRangeEvaluator.getSheetEvaluator(sheetRangeEvaluator.getFirstSheetIndex()).isSubTotal(getFirstRow() + i, getFirstColumn() + i2);
    }
}
