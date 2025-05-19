package org.apache.poi.ss.formula.functions;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Locale;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Fixed implements Function1Arg, Function2Arg, Function3Arg {
    @Override // org.apache.poi.ss.formula.functions.Function3Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3) {
        return fixed(valueEval, valueEval2, valueEval3, i, i2);
    }

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        return fixed(valueEval, valueEval2, BoolEval.FALSE, i, i2);
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        return fixed(valueEval, new NumberEval(2.0d), BoolEval.FALSE, i, i2);
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 1) {
            return fixed(valueEvalArr[0], new NumberEval(2.0d), BoolEval.FALSE, i, i2);
        }
        if (length == 2) {
            return fixed(valueEvalArr[0], valueEvalArr[1], BoolEval.FALSE, i, i2);
        }
        if (length == 3) {
            return fixed(valueEvalArr[0], valueEvalArr[1], valueEvalArr[2], i, i2);
        }
        return ErrorEval.VALUE_INVALID;
    }

    private ValueEval fixed(ValueEval valueEval, ValueEval valueEval2, ValueEval valueEval3, int i, int i2) {
        try {
            BigDecimal bigDecimal = new BigDecimal(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2)));
            int coerceValueToInt = OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEval2, i, i2));
            Boolean coerceValueToBoolean = OperandResolver.coerceValueToBoolean(OperandResolver.getSingleValue(valueEval3, i, i2), false);
            BigDecimal scale = bigDecimal.setScale(coerceValueToInt, RoundingMode.HALF_UP);
            DecimalFormat decimalFormat = (DecimalFormat) NumberFormat.getNumberInstance(Locale.US);
            decimalFormat.setGroupingUsed(!coerceValueToBoolean.booleanValue());
            decimalFormat.setMinimumFractionDigits(coerceValueToInt >= 0 ? coerceValueToInt : 0);
            if (coerceValueToInt < 0) {
                coerceValueToInt = 0;
            }
            decimalFormat.setMaximumFractionDigits(coerceValueToInt);
            return new StringEval(decimalFormat.format(scale.doubleValue()));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
