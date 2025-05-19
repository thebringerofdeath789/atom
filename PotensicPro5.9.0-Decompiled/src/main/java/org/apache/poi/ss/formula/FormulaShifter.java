package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.ptg.Area2DPtgBase;
import org.apache.poi.ss.formula.ptg.Area3DPtg;
import org.apache.poi.ss.formula.ptg.Area3DPxg;
import org.apache.poi.ss.formula.ptg.AreaErrPtg;
import org.apache.poi.ss.formula.ptg.AreaPtg;
import org.apache.poi.ss.formula.ptg.AreaPtgBase;
import org.apache.poi.ss.formula.ptg.Deleted3DPxg;
import org.apache.poi.ss.formula.ptg.DeletedArea3DPtg;
import org.apache.poi.ss.formula.ptg.DeletedRef3DPtg;
import org.apache.poi.ss.formula.ptg.Ptg;
import org.apache.poi.ss.formula.ptg.Ref3DPtg;
import org.apache.poi.ss.formula.ptg.Ref3DPxg;
import org.apache.poi.ss.formula.ptg.RefErrorPtg;
import org.apache.poi.ss.formula.ptg.RefPtg;
import org.apache.poi.ss.formula.ptg.RefPtgBase;

/* loaded from: classes5.dex */
public final class FormulaShifter {
    private final int _amountToMove;
    private final int _dstSheetIndex;
    private final int _externSheetIndex;
    private final int _firstMovedIndex;
    private final int _lastMovedIndex;
    private final ShiftMode _mode;
    private final String _sheetName;
    private final int _srcSheetIndex;

    enum ShiftMode {
        Row,
        Sheet
    }

    private FormulaShifter(int i, String str, int i2, int i3, int i4) {
        if (i4 == 0) {
            throw new IllegalArgumentException("amountToMove must not be zero");
        }
        if (i2 > i3) {
            throw new IllegalArgumentException("firstMovedIndex, lastMovedIndex out of order");
        }
        this._externSheetIndex = i;
        this._sheetName = str;
        this._firstMovedIndex = i2;
        this._lastMovedIndex = i3;
        this._amountToMove = i4;
        this._mode = ShiftMode.Row;
        this._dstSheetIndex = -1;
        this._srcSheetIndex = -1;
    }

    private FormulaShifter(int i, int i2) {
        this._amountToMove = -1;
        this._lastMovedIndex = -1;
        this._firstMovedIndex = -1;
        this._externSheetIndex = -1;
        this._sheetName = null;
        this._srcSheetIndex = i;
        this._dstSheetIndex = i2;
        this._mode = ShiftMode.Sheet;
    }

    public static FormulaShifter createForRowShift(int i, String str, int i2, int i3, int i4) {
        return new FormulaShifter(i, str, i2, i3, i4);
    }

    public static FormulaShifter createForSheetShift(int i, int i2) {
        return new FormulaShifter(i, i2);
    }

    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(getClass().getName());
        stringBuffer.append(" [");
        stringBuffer.append(this._firstMovedIndex);
        stringBuffer.append(this._lastMovedIndex);
        stringBuffer.append(this._amountToMove);
        return stringBuffer.toString();
    }

    public boolean adjustFormula(Ptg[] ptgArr, int i) {
        boolean z = false;
        for (int i2 = 0; i2 < ptgArr.length; i2++) {
            Ptg adjustPtg = adjustPtg(ptgArr[i2], i);
            if (adjustPtg != null) {
                ptgArr[i2] = adjustPtg;
                z = true;
            }
        }
        return z;
    }

    /* renamed from: org.apache.poi.ss.formula.FormulaShifter$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode;

        static {
            int[] iArr = new int[ShiftMode.values().length];
            $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode = iArr;
            try {
                iArr[ShiftMode.Row.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[ShiftMode.Sheet.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    private Ptg adjustPtg(Ptg ptg, int i) {
        int i2 = AnonymousClass1.$SwitchMap$org$apache$poi$ss$formula$FormulaShifter$ShiftMode[this._mode.ordinal()];
        if (i2 == 1) {
            return adjustPtgDueToRowMove(ptg, i);
        }
        if (i2 == 2) {
            return adjustPtgDueToShiftMove(ptg);
        }
        throw new IllegalStateException("Unsupported shift mode: " + this._mode);
    }

    private Ptg adjustPtgDueToRowMove(Ptg ptg, int i) {
        if (ptg instanceof RefPtg) {
            if (i != this._externSheetIndex) {
                return null;
            }
            return rowMoveRefPtg((RefPtg) ptg);
        }
        if (ptg instanceof Ref3DPtg) {
            Ref3DPtg ref3DPtg = (Ref3DPtg) ptg;
            if (this._externSheetIndex != ref3DPtg.getExternSheetIndex()) {
                return null;
            }
            return rowMoveRefPtg(ref3DPtg);
        }
        if (ptg instanceof Ref3DPxg) {
            Ref3DPxg ref3DPxg = (Ref3DPxg) ptg;
            if (ref3DPxg.getExternalWorkbookNumber() > 0 || !this._sheetName.equals(ref3DPxg.getSheetName())) {
                return null;
            }
            return rowMoveRefPtg(ref3DPxg);
        }
        if (ptg instanceof Area2DPtgBase) {
            return i != this._externSheetIndex ? ptg : rowMoveAreaPtg((Area2DPtgBase) ptg);
        }
        if (ptg instanceof Area3DPtg) {
            Area3DPtg area3DPtg = (Area3DPtg) ptg;
            if (this._externSheetIndex != area3DPtg.getExternSheetIndex()) {
                return null;
            }
            return rowMoveAreaPtg(area3DPtg);
        }
        if (ptg instanceof Area3DPxg) {
            Area3DPxg area3DPxg = (Area3DPxg) ptg;
            if (area3DPxg.getExternalWorkbookNumber() <= 0 && this._sheetName.equals(area3DPxg.getSheetName())) {
                return rowMoveAreaPtg(area3DPxg);
            }
        }
        return null;
    }

    private Ptg adjustPtgDueToShiftMove(Ptg ptg) {
        if (ptg instanceof Ref3DPtg) {
            Ref3DPtg ref3DPtg = (Ref3DPtg) ptg;
            if (ref3DPtg.getExternSheetIndex() == this._srcSheetIndex) {
                ref3DPtg.setExternSheetIndex(this._dstSheetIndex);
                return ref3DPtg;
            }
            if (ref3DPtg.getExternSheetIndex() == this._dstSheetIndex) {
                ref3DPtg.setExternSheetIndex(this._srcSheetIndex);
                return ref3DPtg;
            }
        }
        return null;
    }

    private Ptg rowMoveRefPtg(RefPtgBase refPtgBase) {
        int row = refPtgBase.getRow();
        int i = this._firstMovedIndex;
        if (i <= row && row <= this._lastMovedIndex) {
            refPtgBase.setRow(row + this._amountToMove);
            return refPtgBase;
        }
        int i2 = this._amountToMove;
        int i3 = i + i2;
        int i4 = this._lastMovedIndex + i2;
        if (i4 < row || row < i3) {
            return null;
        }
        if (i3 <= row && row <= i4) {
            return createDeletedRef(refPtgBase);
        }
        throw new IllegalStateException("Situation not covered: (" + this._firstMovedIndex + ", " + this._lastMovedIndex + ", " + this._amountToMove + ", " + row + ", " + row + ")");
    }

    private Ptg rowMoveAreaPtg(AreaPtgBase areaPtgBase) {
        int firstRow = areaPtgBase.getFirstRow();
        int lastRow = areaPtgBase.getLastRow();
        int i = this._firstMovedIndex;
        if (i <= firstRow && lastRow <= this._lastMovedIndex) {
            areaPtgBase.setFirstRow(firstRow + this._amountToMove);
            areaPtgBase.setLastRow(lastRow + this._amountToMove);
            return areaPtgBase;
        }
        int i2 = this._amountToMove;
        int i3 = i + i2;
        int i4 = this._lastMovedIndex;
        int i5 = i4 + i2;
        if (firstRow < i && i4 < lastRow) {
            if (i3 < firstRow && firstRow <= i5) {
                areaPtgBase.setFirstRow(i5 + 1);
                return areaPtgBase;
            }
            if (i3 > lastRow || lastRow >= i5) {
                return null;
            }
            areaPtgBase.setLastRow(i3 - 1);
            return areaPtgBase;
        }
        if (i <= firstRow && firstRow <= i4) {
            if (i2 < 0) {
                areaPtgBase.setFirstRow(firstRow + i2);
                return areaPtgBase;
            }
            if (i3 > lastRow) {
                return null;
            }
            int i6 = firstRow + i2;
            if (i5 < lastRow) {
                areaPtgBase.setFirstRow(i6);
                return areaPtgBase;
            }
            int i7 = i4 + 1;
            if (i3 > i7) {
                i6 = i7;
            }
            areaPtgBase.setFirstRow(i6);
            areaPtgBase.setLastRow(Math.max(lastRow, i5));
            return areaPtgBase;
        }
        if (i <= lastRow && lastRow <= i4) {
            if (i2 > 0) {
                areaPtgBase.setLastRow(lastRow + i2);
                return areaPtgBase;
            }
            if (i5 < firstRow) {
                return null;
            }
            int i8 = lastRow + i2;
            if (i3 > firstRow) {
                areaPtgBase.setLastRow(i8);
                return areaPtgBase;
            }
            int i9 = i - 1;
            if (i5 < i9) {
                i8 = i9;
            }
            areaPtgBase.setFirstRow(Math.min(firstRow, i3));
            areaPtgBase.setLastRow(i8);
            return areaPtgBase;
        }
        if (i5 < firstRow || lastRow < i3) {
            return null;
        }
        if (i3 <= firstRow && lastRow <= i5) {
            return createDeletedRef(areaPtgBase);
        }
        if (firstRow <= i3 && i5 <= lastRow) {
            return null;
        }
        if (i3 < firstRow && firstRow <= i5) {
            areaPtgBase.setFirstRow(i5 + 1);
            return areaPtgBase;
        }
        if (i3 <= lastRow && lastRow < i5) {
            areaPtgBase.setLastRow(i3 - 1);
            return areaPtgBase;
        }
        throw new IllegalStateException("Situation not covered: (" + this._firstMovedIndex + ", " + this._lastMovedIndex + ", " + this._amountToMove + ", " + firstRow + ", " + lastRow + ")");
    }

    private static Ptg createDeletedRef(Ptg ptg) {
        if (ptg instanceof RefPtg) {
            return new RefErrorPtg();
        }
        if (ptg instanceof Ref3DPtg) {
            return new DeletedRef3DPtg(((Ref3DPtg) ptg).getExternSheetIndex());
        }
        if (ptg instanceof AreaPtg) {
            return new AreaErrPtg();
        }
        if (ptg instanceof Area3DPtg) {
            return new DeletedArea3DPtg(((Area3DPtg) ptg).getExternSheetIndex());
        }
        if (ptg instanceof Ref3DPxg) {
            Ref3DPxg ref3DPxg = (Ref3DPxg) ptg;
            return new Deleted3DPxg(ref3DPxg.getExternalWorkbookNumber(), ref3DPxg.getSheetName());
        }
        if (ptg instanceof Area3DPxg) {
            Area3DPxg area3DPxg = (Area3DPxg) ptg;
            return new Deleted3DPxg(area3DPxg.getExternalWorkbookNumber(), area3DPxg.getSheetName());
        }
        throw new IllegalArgumentException("Unexpected ref ptg class (" + ptg.getClass().getName() + ")");
    }
}
