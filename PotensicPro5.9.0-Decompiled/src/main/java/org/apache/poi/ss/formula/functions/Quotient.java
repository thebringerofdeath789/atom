package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Quotient extends Fixed2ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new Quotient();

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            double coerceValueToDouble = OperandResolver.coerceValueToDouble(valueEval);
            try {
                if (OperandResolver.coerceValueToDouble(valueEval2) == 0.0d) {
                    return ErrorEval.DIV_ZERO;
                }
                return new NumberEval((int) (coerceValueToDouble / r5));
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException unused2) {
            return ErrorEval.VALUE_INVALID;
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0], valueEvalArr[1]);
    }
}
