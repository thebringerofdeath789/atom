package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.AreaEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Rank extends Var2or3ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (Double.isNaN(coerceValueToDouble) || Double.isInfinite(coerceValueToDouble)) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
            return eval(i, i2, coerceValueToDouble, convertRangeArg(valueEval2), true);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        boolean z;
        try {
            double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (Double.isNaN(coerceValueToDouble) || Double.isInfinite(coerceValueToDouble)) {
                throw new EvaluationException(ErrorEval.NUM_ERROR);
            }
            AreaEval convertRangeArg = convertRangeArg(valueEval2);
            int coerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval3, i, i2));
            if (coerceValueToInt == 0) {
                z = true;
            } else {
                if (coerceValueToInt != 1) {
                    throw new EvaluationException(ErrorEval.NUM_ERROR);
                }
                z = false;
            }
            return eval(i, i2, coerceValueToDouble, convertRangeArg, z);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static ValueEval eval(int i, int i2, double d, AreaEval areaEval, boolean z) {
        int height = areaEval.getHeight();
        int width = areaEval.getWidth();
        int i3 = 1;
        for (int i4 = 0; i4 < height; i4++) {
            for (int i5 = 0; i5 < width; i5++) {
                Double value = getValue(areaEval, i4, i5);
                if (value != null && ((z && value.doubleValue() > d) || (!z && value.doubleValue() < d))) {
                    i3++;
                }
            }
        }
        return new NumberEval(i3);
    }

    private static Double getValue(AreaEval areaEval, int i, int i2) {
        ValueEval relativeValue = areaEval.getRelativeValue(i, i2);
        if (relativeValue instanceof NumberEval) {
            return Double.valueOf(((NumberEval) relativeValue).getNumberValue());
        }
        return null;
    }

    private static AreaEval convertRangeArg(ValueEval valueEval) throws EvaluationException {
        if (valueEval instanceof AreaEval) {
            return (AreaEval) valueEval;
        }
        if (valueEval instanceof RefEval) {
            return ((RefEval) valueEval).offset(0, 0, 0, 0);
        }
        throw new EvaluationException(ErrorEval.VALUE_INVALID);
    }
}
