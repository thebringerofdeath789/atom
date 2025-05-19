package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Dec2Bin extends Var1or2ArgFunction implements FreeRefFunction {
    private static final int DEFAULT_PLACES_VALUE = 10;
    private static final long MAX_VALUE = 511;
    private static final long MIN_VALUE = -512;
    public static final FreeRefFunction instance = new Dec2Bin();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        int i3;
        try {
            Double parseDouble = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (parseDouble == null) {
                return ErrorEval.VALUE_INVALID;
            }
            if (parseDouble.longValue() < MIN_VALUE || parseDouble.longValue() > MAX_VALUE) {
                return ErrorEval.NUM_ERROR;
            }
            if (parseDouble.doubleValue() < 0.0d || valueEval2 == null) {
                i3 = 10;
            } else {
                try {
                    Double parseDouble2 = OperandResolver.parseDouble(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval2, i, i2)));
                    if (parseDouble2 == null) {
                        return ErrorEval.VALUE_INVALID;
                    }
                    i3 = parseDouble2.intValue();
                    if (i3 < 0 || i3 == 0) {
                        return ErrorEval.NUM_ERROR;
                    }
                } catch (EvaluationException e) {
                    return e.getErrorEval();
                }
            }
            String binaryString = Integer.toBinaryString(parseDouble.intValue());
            if (binaryString.length() > 10) {
                binaryString = binaryString.substring(binaryString.length() - 10, binaryString.length());
            }
            if (binaryString.length() > i3) {
                return ErrorEval.NUM_ERROR;
            }
            return new StringEval(binaryString);
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
