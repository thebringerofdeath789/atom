package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Dec2Hex extends Var1or2ArgFunction implements FreeRefFunction {
    private static final int DEFAULT_PLACES_VALUE = 10;
    public static final FreeRefFunction instance = new Dec2Hex();
    private static final long MIN_VALUE = Long.parseLong("-549755813888");
    private static final long MAX_VALUE = Long.parseLong("549755813887");

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        int intValue;
        String hexString;
        try {
            Double parseDouble = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (parseDouble == null) {
                return ErrorEval.VALUE_INVALID;
            }
            if (parseDouble.longValue() < MIN_VALUE || parseDouble.longValue() > MAX_VALUE) {
                return ErrorEval.NUM_ERROR;
            }
            if (parseDouble.doubleValue() < 0.0d) {
                intValue = 10;
            } else if (valueEval2 != null) {
                try {
                    Double parseDouble2 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval2, i, i2)));
                    if (parseDouble2 == null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    intValue = parseDouble2.intValue();
                    if (intValue < 0) {
                        return ErrorEval.NUM_ERROR;
                    }
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            } else {
                intValue = 0;
            }
            if (intValue != 0) {
                hexString = String.format("%0" + intValue + "X", Integer.valueOf(parseDouble.intValue()));
            } else {
                hexString = Integer.toHexString(parseDouble.intValue());
            }
            if (parseDouble.doubleValue() < 0.0d) {
                hexString = "FF" + hexString.substring(2);
            }
            return new StringEval(hexString.toUpperCase());
        } catch (EvaluationException e2) {
            return e2.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        return evaluate(i, i2, valueEval, null);
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 1) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
        }
        if (valueEvalArr.length == 2) {
            return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
