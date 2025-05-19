package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Offset implements Function {
    private static final int LAST_VALID_COLUMN_INDEX = 255;
    private static final int LAST_VALID_ROW_INDEX = 65535;

    static final class LinearOffsetRange {
        private final int _length;
        private final int _offset;

        public LinearOffsetRange(int i, int i2) {
            if (i2 == 0) {
                throw new RuntimeException("length may not be zero");
            }
            this._offset = i;
            this._length = i2;
        }

        public short getFirstIndex() {
            return (short) this._offset;
        }

        public short getLastIndex() {
            return (short) ((this._offset + this._length) - 1);
        }

        public LinearOffsetRange normaliseAndTranslate(int i) {
            if (this._length > 0) {
                return i == 0 ? this : new LinearOffsetRange(i + this._offset, this._length);
            }
            int i2 = i + this._offset;
            int i3 = this._length;
            return new LinearOffsetRange(i2 + i3 + 1, -i3);
        }

        public boolean isOutOfBounds(int i, int i2) {
            return this._offset < i || getLastIndex() > i2;
        }

        public String toString() {
            StringBuffer stringBuffer = new StringBuffer(64);
            stringBuffer.append(getClass().getName()).append(" [");
            stringBuffer.append(this._offset).append("...").append((int) getLastIndex());
            stringBuffer.append("]");
            return stringBuffer.toString();
        }
    }

    private static final class BaseRef {
        private final AreaEval _areaEval;
        private final int _firstColumnIndex;
        private final int _firstRowIndex;
        private final int _height;
        private final RefEval _refEval;
        private final int _width;

        public BaseRef(RefEval refEval) {
            this._refEval = refEval;
            this._areaEval = null;
            this._firstRowIndex = refEval.getRow();
            this._firstColumnIndex = refEval.getColumn();
            this._height = 1;
            this._width = 1;
        }

        public BaseRef(AreaEval areaEval) {
            this._refEval = null;
            this._areaEval = areaEval;
            this._firstRowIndex = areaEval.getFirstRow();
            this._firstColumnIndex = areaEval.getFirstColumn();
            this._height = (areaEval.getLastRow() - areaEval.getFirstRow()) + 1;
            this._width = (areaEval.getLastColumn() - areaEval.getFirstColumn()) + 1;
        }

        public int getWidth() {
            return this._width;
        }

        public int getHeight() {
            return this._height;
        }

        public int getFirstRowIndex() {
            return this._firstRowIndex;
        }

        public int getFirstColumnIndex() {
            return this._firstColumnIndex;
        }

        public AreaEval offset(int i, int i2, int i3, int i4) {
            RefEval refEval = this._refEval;
            if (refEval == null) {
                return this._areaEval.offset(i, i2, i3, i4);
            }
            return refEval.offset(i, i2, i3, i4);
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 3 || valueEvalArr.length > 5) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            BaseRef evaluateBaseRef = evaluateBaseRef(valueEvalArr[0]);
            int evaluateIntArg = evaluateIntArg(valueEvalArr[1], i, i2);
            int evaluateIntArg2 = evaluateIntArg(valueEvalArr[2], i, i2);
            int height = evaluateBaseRef.getHeight();
            int width = evaluateBaseRef.getWidth();
            int length = valueEvalArr.length;
            if (length != 4) {
                if (length == 5) {
                    width = evaluateIntArg(valueEvalArr[4], i, i2);
                } else {
                    if (height != 0 && width != 0) {
                        return createOffset(evaluateBaseRef, new LinearOffsetRange(evaluateIntArg, height), new LinearOffsetRange(evaluateIntArg2, width));
                    }
                    return ErrorEval.REF_INVALID;
                }
            }
            height = evaluateIntArg(valueEvalArr[3], i, i2);
            if (height != 0) {
                return createOffset(evaluateBaseRef, new LinearOffsetRange(evaluateIntArg, height), new LinearOffsetRange(evaluateIntArg2, width));
            }
            return ErrorEval.REF_INVALID;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static AreaEval createOffset(BaseRef baseRef, LinearOffsetRange linearOffsetRange, LinearOffsetRange linearOffsetRange2) throws EvaluationException {
        LinearOffsetRange normaliseAndTranslate = linearOffsetRange.normaliseAndTranslate(baseRef.getFirstRowIndex());
        LinearOffsetRange normaliseAndTranslate2 = linearOffsetRange2.normaliseAndTranslate(baseRef.getFirstColumnIndex());
        if (normaliseAndTranslate.isOutOfBounds(0, 65535)) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        if (normaliseAndTranslate2.isOutOfBounds(0, 255)) {
            throw new EvaluationException(ErrorEval.REF_INVALID);
        }
        return baseRef.offset(linearOffsetRange.getFirstIndex(), linearOffsetRange.getLastIndex(), linearOffsetRange2.getFirstIndex(), linearOffsetRange2.getLastIndex());
    }

    private static BaseRef evaluateBaseRef(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof RefEval) {
            return new BaseRef((RefEval) valueEval);
        }
        if (valueEval instanceof AreaEval) {
            return new BaseRef((AreaEval) valueEval);
        }
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }

    static int evaluateIntArg(ValueEval valueEval, int i, int i2) throws EvaluationException {
        return OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval, i, i2));
    }
}
