package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.RefEvalBase;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.ptg.AreaI;
import org.apache.poi.ss.util.CellReference;

/* loaded from: classes5.dex */
final class LazyRefEval extends RefEvalBase {
    private final SheetRangeEvaluator _evaluator;

    public LazyRefEval(int i, int i2, SheetRangeEvaluator sheetRangeEvaluator) {
        super(sheetRangeEvaluator, i, i2);
        this._evaluator = sheetRangeEvaluator;
    }

    @Deprecated
    public ValueEval getInnerValueEval() {
        return getInnerValueEval(this._evaluator.getFirstSheetIndex());
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public ValueEval getInnerValueEval(int i) {
        return this._evaluator.getEvalForCell(i, getRow(), getColumn());
    }

    @Override // org.apache.poi.ss.formula.eval.RefEval
    public AreaEval offset(int i, int i2, int i3, int i4) {
        return new LazyAreaEval(new AreaI.OffsetArea(getRow(), getColumn(), i, i2, i3, i4), this._evaluator);
    }

    public String toString() {
        CellReference cellReference = new CellReference(getRow(), getColumn());
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName()).append("[");
        stringBuffer.append(this._evaluator.getSheetNameRange());
        stringBuffer.append('!');
        stringBuffer.append(cellReference.formatAsString());
        stringBuffer.append("]");
        return stringBuffer.toString();
    }
}
