package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.MissingArgEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public abstract class BooleanFunction implements Function {
    public static final Function AND = new BooleanFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.1
        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        protected boolean getInitialResultValue() {
            return true;
        }

        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        protected boolean partialEvaluate(boolean z, boolean z2) {
            return z && z2;
        }
    };
    public static final Function OR = new BooleanFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.2
        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        protected boolean getInitialResultValue() {
            return false;
        }

        @Override // org.apache.poi.ss.formula.functions.BooleanFunction
        protected boolean partialEvaluate(boolean z, boolean z2) {
            return z || z2;
        }
    };
    public static final Function FALSE = new Fixed0ArgFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.3
        @Override // org.apache.poi.ss.formula.functions.Function0Arg
        public ValueEval evaluate(int i, int i2) {
            return BoolEval.FALSE;
        }
    };
    public static final Function TRUE = new Fixed0ArgFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.4
        @Override // org.apache.poi.ss.formula.functions.Function0Arg
        public ValueEval evaluate(int i, int i2) {
            return BoolEval.TRUE;
        }
    };
    public static final Function NOT = new Fixed1ArgFunction() { // from class: org.apache.poi.ss.formula.functions.BooleanFunction.5
        @Override // org.apache.poi.ss.formula.functions.Function1Arg
        public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
            try {
                ValueEval singleValue = OperandResolver.getSingleValue(valueEval, i, i2);
                boolean z = false;
                Boolean coerceValueToBoolean = OperandResolver.coerceValueToBoolean(singleValue, false);
                if (coerceValueToBoolean != null) {
                    z = coerceValueToBoolean.booleanValue();
                }
                return BoolEval.valueOf(!z);
            } catch (EvaluationException e) {
                return e.getErrorEval();
            }
        }
    };

    protected abstract boolean getInitialResultValue();

    protected abstract boolean partialEvaluate(boolean z, boolean z2);

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            return BoolEval.valueOf(calculate(valueEvalArr));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private boolean calculate(ValueEval[] valueEvalArr) throws EvaluationException {
        boolean initialResultValue = getInitialResultValue();
        int length = valueEvalArr.length;
        boolean z = false;
        for (int i = 0; i < length; i++) {
            ValueEval valueEval = valueEvalArr[i];
            if (valueEval instanceof TwoDEval) {
                TwoDEval twoDEval = (TwoDEval) valueEval;
                int height = twoDEval.getHeight();
                int width = twoDEval.getWidth();
                for (int i2 = 0; i2 < height; i2++) {
                    for (int i3 = 0; i3 < width; i3++) {
                        Boolean coerceValueToBoolean = OperandResolver.coerceValueToBoolean(twoDEval.getValue(i2, i3), true);
                        if (coerceValueToBoolean != null) {
                            initialResultValue = partialEvaluate(initialResultValue, coerceValueToBoolean.booleanValue());
                            z = true;
                        }
                    }
                }
            } else if (valueEval instanceof RefEval) {
                RefEval refEval = (RefEval) valueEval;
                for (int firstSheetIndex = refEval.getFirstSheetIndex(); firstSheetIndex <= refEval.getLastSheetIndex(); firstSheetIndex++) {
                    Boolean coerceValueToBoolean2 = OperandResolver.coerceValueToBoolean(refEval.getInnerValueEval(firstSheetIndex), true);
                    if (coerceValueToBoolean2 != null) {
                        initialResultValue = partialEvaluate(initialResultValue, coerceValueToBoolean2.booleanValue());
                        z = true;
                    }
                }
            } else {
                Boolean coerceValueToBoolean3 = valueEval == MissingArgEval.instance ? null : OperandResolver.coerceValueToBoolean(valueEval, false);
                if (coerceValueToBoolean3 != null) {
                    initialResultValue = partialEvaluate(initialResultValue, coerceValueToBoolean3.booleanValue());
                    z = true;
                }
            }
        }
        if (z) {
            return initialResultValue;
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
