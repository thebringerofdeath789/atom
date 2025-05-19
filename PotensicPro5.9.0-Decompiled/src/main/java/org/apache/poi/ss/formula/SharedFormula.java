package org.apache.poi.ss.formula;

import org.apache.poi.ss.SpreadsheetVersion;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.OperandPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;

/* loaded from: classes5.dex */
public class SharedFormula {
    private final int _columnWrappingMask;
    private final int _rowWrappingMask;

    public SharedFormula(SpreadsheetVersion spreadsheetVersion) {
        this._columnWrappingMask = spreadsheetVersion.getLastColumnIndex();
        this._rowWrappingMask = spreadsheetVersion.getLastRowIndex();
    }

    public Ptg[] convertSharedFormulas(Ptg[] ptgArr, int i, int i2) {
        SharedFormula sharedFormula = this;
        Ptg[] ptgArr2 = new Ptg[ptgArr.length];
        int i3 = 0;
        while (i3 < ptgArr.length) {
            Ptg ptg = ptgArr[i3];
            byte ptgClass = ptg.isBaseToken() ? (byte) -1 : ptg.getPtgClass();
            if (ptg instanceof RefPtgBase) {
                RefPtgBase refPtgBase = (RefPtgBase) ptg;
                RefPtg refPtg = new RefPtg(sharedFormula.fixupRelativeRow(i, refPtgBase.getRow(), refPtgBase.isRowRelative()), sharedFormula.fixupRelativeColumn(i2, refPtgBase.getColumn(), refPtgBase.isColRelative()), refPtgBase.isRowRelative(), refPtgBase.isColRelative());
                refPtg.setClass(ptgClass);
                ptg = refPtg;
            } else if (ptg instanceof AreaPtgBase) {
                AreaPtgBase areaPtgBase = (AreaPtgBase) ptg;
                AreaPtg areaPtg = new AreaPtg(sharedFormula.fixupRelativeRow(i, areaPtgBase.getFirstRow(), areaPtgBase.isFirstRowRelative()), sharedFormula.fixupRelativeRow(i, areaPtgBase.getLastRow(), areaPtgBase.isLastRowRelative()), sharedFormula.fixupRelativeColumn(i2, areaPtgBase.getFirstColumn(), areaPtgBase.isFirstColRelative()), sharedFormula.fixupRelativeColumn(i2, areaPtgBase.getLastColumn(), areaPtgBase.isLastColRelative()), areaPtgBase.isFirstRowRelative(), areaPtgBase.isLastRowRelative(), areaPtgBase.isFirstColRelative(), areaPtgBase.isLastColRelative());
                areaPtg.setClass(ptgClass);
                ptg = areaPtg;
            } else if (ptg instanceof OperandPtg) {
                ptg = ((OperandPtg) ptg).copy();
            }
            ptgArr2[i3] = ptg;
            i3++;
            sharedFormula = this;
        }
        return ptgArr2;
    }

    private int fixupRelativeColumn(int i, int i2, boolean z) {
        if (!z) {
            return i2;
        }
        return this._columnWrappingMask & (i2 + i);
    }

    private int fixupRelativeRow(int i, int i2, boolean z) {
        if (!z) {
            return i2;
        }
        return this._rowWrappingMask & (i2 + i);
    }
}
