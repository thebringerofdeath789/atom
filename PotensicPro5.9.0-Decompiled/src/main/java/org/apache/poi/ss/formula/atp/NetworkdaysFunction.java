package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
final class NetworkdaysFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new NetworkdaysFunction(ArgumentsEvaluator.instance);
    private ArgumentsEvaluator evaluator;

    private NetworkdaysFunction(ArgumentsEvaluator argumentsEvaluator) {
        this.evaluator = argumentsEvaluator;
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length < 2 || valueEvalArr.length > 3) {
            return ErrorEval.VALUE_INVALID;
        }
        int rowIndex = operationEvaluationContext.getRowIndex();
        int columnIndex = operationEvaluationContext.getColumnIndex();
        try {
            if (this.evaluator.evaluateDateArg(valueEvalArr[0], rowIndex, columnIndex) > this.evaluator.evaluateDateArg(valueEvalArr[1], rowIndex, columnIndex)) {
                return ErrorEval.NAME_INVALID;
            }
            return new NumberEval(WorkdayCalculator.instance.calculateWorkdays(r6, r8, this.evaluator.evaluateDatesArg(valueEvalArr.length == 3 ? valueEvalArr[2] : null, rowIndex, columnIndex)));
        } catch (EvaluationException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }
}
