package org.apache.poi.ss.formula.eval.forked;

import org.apache.poi.ss.formula.EvaluationCell;
import org.apache.poi.ss.formula.EvaluationSheet;
import org.apache.poi.ss.formula.eval.BlankEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.usermodel.Cell;

/* loaded from: classes5.dex */
final class ForkedEvaluationCell implements EvaluationCell {
    private boolean _booleanValue;
    private int _cellType;
    private int _errorValue;
    private final EvaluationCell _masterCell;
    private double _numberValue;
    private final EvaluationSheet _sheet;
    private String _stringValue;

    public ForkedEvaluationCell(ForkedEvaluationSheet forkedEvaluationSheet, EvaluationCell evaluationCell) {
        this._sheet = forkedEvaluationSheet;
        this._masterCell = evaluationCell;
        setValue(BlankEval.instance);
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public Object getIdentityKey() {
        return this._masterCell.getIdentityKey();
    }

    public void setValue(ValueEval valueEval) {
        Class<?> cls = valueEval.getClass();
        if (cls == NumberEval.class) {
            this._cellType = 0;
            this._numberValue = ((NumberEval) valueEval).getNumberValue();
            return;
        }
        if (cls == StringEval.class) {
            this._cellType = 1;
            this._stringValue = ((StringEval) valueEval).getStringValue();
            return;
        }
        if (cls == BoolEval.class) {
            this._cellType = 4;
            this._booleanValue = ((BoolEval) valueEval).getBooleanValue();
        } else if (cls == ErrorEval.class) {
            this._cellType = 5;
            this._errorValue = ((ErrorEval) valueEval).getErrorCode();
        } else {
            if (cls == BlankEval.class) {
                this._cellType = 3;
                return;
            }
            throw new IllegalArgumentException("Unexpected value class (" + cls.getName() + ")");
        }
    }

    public void copyValue(Cell cell) {
        int i = this._cellType;
        if (i == 0) {
            cell.setCellValue(this._numberValue);
            return;
        }
        if (i == 1) {
            cell.setCellValue(this._stringValue);
            return;
        }
        if (i == 3) {
            cell.setCellType(3);
        } else if (i == 4) {
            cell.setCellValue(this._booleanValue);
        } else {
            if (i == 5) {
                cell.setCellErrorValue((byte) this._errorValue);
                return;
            }
            throw new IllegalStateException("Unexpected data type (" + this._cellType + ")");
        }
    }

    private void checkCellType(int i) {
        if (this._cellType != i) {
            throw new RuntimeException("Wrong data type (" + this._cellType + ")");
        }
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCellType() {
        return this._cellType;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public boolean getBooleanCellValue() {
        checkCellType(4);
        return this._booleanValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getErrorCellValue() {
        checkCellType(5);
        return this._errorValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public double getNumericCellValue() {
        checkCellType(0);
        return this._numberValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public String getStringCellValue() {
        checkCellType(1);
        return this._stringValue;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public EvaluationSheet getSheet() {
        return this._sheet;
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getRowIndex() {
        return this._masterCell.getRowIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getColumnIndex() {
        return this._masterCell.getColumnIndex();
    }

    @Override // org.apache.poi.ss.formula.EvaluationCell
    public int getCachedFormulaResultType() {
        return this._masterCell.getCachedFormulaResultType();
    }
}
