package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Countifs implements FreeRefFunction {
    public static final FreeRefFunction instance = new Countifs();

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length == 0 || valueEvalArr.length % 2 > 0) {
            return ErrorEval.VALUE_INVALID;
        }
        Double d = null;
        int i = 0;
        while (i < valueEvalArr.length) {
            ValueEval valueEval = valueEvalArr[i];
            ValueEval valueEval2 = valueEvalArr[i + 1];
            i += 2;
            NumberEval numberEval = (NumberEval) new Countif().evaluate(new ValueEval[]{valueEval, valueEval2}, operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
            if (d == null) {
                d = Double.valueOf(numberEval.getNumberValue());
            } else if (numberEval.getNumberValue() < d.doubleValue()) {
                d = Double.valueOf(numberEval.getNumberValue());
            }
        }
        return new NumberEval(d == null ? 0.0d : d.doubleValue());
    }
}
