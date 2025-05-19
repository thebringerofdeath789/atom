package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.BoolEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
final class ParityFunction implements FreeRefFunction {
    public static final FreeRefFunction IS_EVEN = new ParityFunction(0);
    public static final FreeRefFunction IS_ODD = new ParityFunction(1);
    private final int _desiredParity;

    private ParityFunction(int i) {
        this._desiredParity = i;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            return BoolEval.valueOf(evaluateArgParity(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()) == this._desiredParity);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static int evaluateArgParity(ValueEval valueEval, int i, int i2) throws EvaluationException {
        double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, (short) i2));
        if (coerceValueToDouble < 0.0d) {
            coerceValueToDouble = -coerceValueToDouble;
        }
        return (int) (((long) Math.floor(coerceValueToDouble)) & 1);
    }
}
