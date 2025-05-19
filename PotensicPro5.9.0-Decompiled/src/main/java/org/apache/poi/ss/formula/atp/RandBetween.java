package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
final class RandBetween implements FreeRefFunction {
    public static final FreeRefFunction instance = new RandBetween();

    private RandBetween() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            double coerceValueToDouble2 = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex()));
            if (coerceValueToDouble > coerceValueToDouble2) {
                return ErrorEval.NUM_ERROR;
            }
            double ceil = Math.ceil(coerceValueToDouble);
            double floor = Math.floor(coerceValueToDouble2);
            if (ceil > floor) {
                floor = ceil;
            }
            return new NumberEval(ceil + ((int) (Math.random() * ((floor - ceil) + 1.0d))));
        } catch (EvaluationException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }
}
