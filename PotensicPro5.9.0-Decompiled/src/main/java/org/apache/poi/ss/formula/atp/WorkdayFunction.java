package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;
import org.apache.poi.ss.usermodel.DateUtil;

/* loaded from: classes5.dex */
final class WorkdayFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new WorkdayFunction(ArgumentsEvaluator.instance);
    private ArgumentsEvaluator evaluator;

    private WorkdayFunction(ArgumentsEvaluator argumentsEvaluator) {
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
            return new NumberEval(DateUtil.getExcelDate(WorkdayCalculator.instance.calculateWorkdays(this.evaluator.evaluateDateArg(valueEvalArr[0], rowIndex, columnIndex), (int) Math.floor(this.evaluator.evaluateNumberArg(valueEvalArr[1], rowIndex, columnIndex)), this.evaluator.evaluateDatesArg(valueEvalArr.length == 3 ? valueEvalArr[2] : null, rowIndex, columnIndex))));
        } catch (EvaluationException unused) {
            return ErrorEval.VALUE_INVALID;
        }
    }
}
