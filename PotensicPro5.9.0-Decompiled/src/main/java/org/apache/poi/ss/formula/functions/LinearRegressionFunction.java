package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.LookupUtils;

/* loaded from: classes5.dex */
public final class LinearRegressionFunction extends Fixed2ArgFunction {
    public FUNCTION function;

    public enum FUNCTION {
        INTERCEPT,
        SLOPE
    }

    private static abstract class ValueArray implements LookupUtils.ValueVector {
        private final int _size;

        protected abstract ValueEval getItemInternal(int i);

        protected ValueArray(int i) {
            this._size = i;
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public ValueEval getItem(int i) {
            if (i < 0 || i > this._size) {
                throw new IllegalArgumentException("Specified index " + i + " is outside range (0.." + (this._size - 1) + ")");
            }
            return getItemInternal(i);
        }

        @Override // org.apache.poi.ss.formula.functions.LookupUtils.ValueVector
        public final int getSize() {
            return this._size;
        }
    }

    private static final class SingleCellValueArray extends ValueArray {
        private final ValueEval _value;

        public SingleCellValueArray(ValueEval valueEval) {
            super(1);
            this._value = valueEval;
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        protected ValueEval getItemInternal(int i) {
            return this._value;
        }
    }

    private static final class RefValueArray extends ValueArray {
        private final RefEval _ref;
        private final int _width;

        public RefValueArray(RefEval refEval) {
            super(refEval.getNumberOfSheets());
            this._ref = refEval;
            this._width = refEval.getNumberOfSheets();
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        protected ValueEval getItemInternal(int i) {
            return this._ref.getInnerValueEval((i % this._width) + this._ref.getFirstSheetIndex());
        }
    }

    private static final class AreaValueArray extends ValueArray {
        private final TwoDEval _ae;
        private final int _width;

        public AreaValueArray(TwoDEval twoDEval) {
            super(twoDEval.getWidth() * twoDEval.getHeight());
            this._ae = twoDEval;
            this._width = twoDEval.getWidth();
        }

        @Override // org.apache.poi.ss.formula.functions.LinearRegressionFunction.ValueArray
        protected ValueEval getItemInternal(int i) {
            int i2 = this._width;
            return this._ae.getValue(i / i2, i % i2);
        }
    }

    public LinearRegressionFunction(FUNCTION function) {
        this.function = function;
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            LookupUtils.ValueVector createValueVector = createValueVector(valueEval);
            LookupUtils.ValueVector createValueVector2 = createValueVector(valueEval2);
            int size = createValueVector2.getSize();
            if (size != 0 && createValueVector.getSize() == size) {
                double evaluateInternal = evaluateInternal(createValueVector2, createValueVector, size);
                if (Double.isNaN(evaluateInternal) || Double.isInfinite(evaluateInternal)) {
                    return ErrorEval.NUM_ERROR;
                }
                return new NumberEval(evaluateInternal);
            }
            return ErrorEval.NA;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private double evaluateInternal(LookupUtils.ValueVector valueVector, LookupUtils.ValueVector valueVector2, int i) throws EvaluationException {
        LookupUtils.ValueVector valueVector3 = valueVector;
        LookupUtils.ValueVector valueVector4 = valueVector2;
        ErrorEval errorEval = null;
        double d = 0.0d;
        ErrorEval errorEval2 = null;
        double d2 = 0.0d;
        double d3 = 0.0d;
        boolean z = false;
        for (int i2 = 0; i2 < i; i2++) {
            ValueEval item = valueVector3.getItem(i2);
            ValueEval item2 = valueVector4.getItem(i2);
            if ((item instanceof ErrorEval) && errorEval == null) {
                errorEval = (ErrorEval) item;
            } else if ((item2 instanceof ErrorEval) && errorEval2 == null) {
                errorEval2 = (ErrorEval) item2;
            } else if ((item instanceof NumberEval) && (item2 instanceof NumberEval)) {
                d2 += ((NumberEval) item).getNumberValue();
                d3 += ((NumberEval) item2).getNumberValue();
                z = true;
            }
        }
        double d4 = i;
        double d5 = d2 / d4;
        double d6 = d3 / d4;
        ErrorEval errorEval3 = errorEval2;
        int i3 = 0;
        double d7 = 0.0d;
        while (i3 < i) {
            ValueEval item3 = valueVector3.getItem(i3);
            ValueEval item4 = valueVector4.getItem(i3);
            if ((item3 instanceof ErrorEval) && errorEval == null) {
                errorEval = (ErrorEval) item3;
            } else if ((item4 instanceof ErrorEval) && errorEval3 == null) {
                errorEval3 = (ErrorEval) item4;
            } else if ((item3 instanceof NumberEval) && (item4 instanceof NumberEval)) {
                NumberEval numberEval = (NumberEval) item3;
                d7 += (numberEval.getNumberValue() - d5) * (numberEval.getNumberValue() - d5);
                d += (numberEval.getNumberValue() - d5) * (((NumberEval) item4).getNumberValue() - d6);
            }
            i3++;
            valueVector3 = valueVector;
            valueVector4 = valueVector2;
        }
        double d8 = d / d7;
        double d9 = d6 - (d5 * d8);
        if (errorEval != null) {
            throw new EvaluationException(errorEval);
        }
        if (errorEval3 != null) {
            throw new EvaluationException(errorEval3);
        }
        if (z) {
            return this.function == FUNCTION.INTERCEPT ? d9 : d8;
        }
        throw new EvaluationException(ErrorEval.DIV_ZERO);
    }

    private static LookupUtils.ValueVector createValueVector(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof ErrorEval) {
            throw new EvaluationException((ErrorEval) valueEval);
        }
        if (valueEval instanceof TwoDEval) {
            return new AreaValueArray((TwoDEval) valueEval);
        }
        if (valueEval instanceof RefEval) {
            return new RefValueArray((RefEval) valueEval);
        }
        return new SingleCellValueArray(valueEval);
    }
}
