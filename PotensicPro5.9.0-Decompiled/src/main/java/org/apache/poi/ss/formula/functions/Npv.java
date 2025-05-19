package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.AggregateFunction;

/* loaded from: classes5.dex */
public final class Npv implements Function {
    @Override // org.apache.poi.ss.formula.functions.Function
    public ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length < 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            double singleOperandEvaluate = NumericFunction.singleOperandEvaluate(valueEvalArr[0], i, i2);
            int length = valueEvalArr.length - 1;
            ValueEval[] valueEvalArr2 = new ValueEval[length];
            System.arraycopy(valueEvalArr, 1, valueEvalArr2, 0, length);
            double npv = FinanceLib.npv(singleOperandEvaluate, AggregateFunction.ValueCollector.collectValues(valueEvalArr2));
            NumericFunction.checkValue(npv);
            return new NumberEval(npv);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
