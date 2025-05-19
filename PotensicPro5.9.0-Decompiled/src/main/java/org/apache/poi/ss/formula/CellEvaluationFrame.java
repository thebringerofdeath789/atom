package org.apache.poi.ss.formula;

import java.util.HashSet;
import java.util.Set;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
final class CellEvaluationFrame {
    private final FormulaCellCacheEntry _cce;
    private final Set<CellCacheEntry> _sensitiveInputCells = new HashSet();
    private FormulaUsedBlankCellSet _usedBlankCellGroup;

    public CellEvaluationFrame(FormulaCellCacheEntry formulaCellCacheEntry) {
        this._cce = formulaCellCacheEntry;
    }

    public CellCacheEntry getCCE() {
        return this._cce;
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(64);
        stringBuffer.append(getClass().getName()).append(" [");
        stringBuffer.append("]");
        return stringBuffer.toString();
    }

    public void addSensitiveInputCell(CellCacheEntry cellCacheEntry) {
        this._sensitiveInputCells.add(cellCacheEntry);
    }

    private CellCacheEntry[] getSensitiveInputCells() {
        int size = this._sensitiveInputCells.size();
        if (size < 1) {
            return CellCacheEntry.EMPTY_ARRAY;
        }
        CellCacheEntry[] cellCacheEntryArr = new CellCacheEntry[size];
        this._sensitiveInputCells.toArray(cellCacheEntryArr);
        return cellCacheEntryArr;
    }

    public void addUsedBlankCell(int i, int i2, int i3, int i4) {
        if (this._usedBlankCellGroup == null) {
            this._usedBlankCellGroup = new FormulaUsedBlankCellSet();
        }
        this._usedBlankCellGroup.addCell(i, i2, i3, i4);
    }

    public void updateFormulaResult(ValueEval valueEval) {
        this._cce.updateFormulaResult(valueEval, getSensitiveInputCells(), this._usedBlankCellGroup);
    }
}
