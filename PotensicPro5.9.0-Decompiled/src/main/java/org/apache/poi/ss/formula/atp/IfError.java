package org.apache.poi.ss.formula.atp;

import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.WorkbookEvaluator;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
final class IfError implements FreeRefFunction {
    public static final FreeRefFunction instance = new IfError();

    private IfError() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 2) {
            return ErrorEval.VALUE_INVALID;
        }
        try {
            return evaluateInternal(valueEvalArr[0], valueEvalArr[1], operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex());
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    private static ValueEval evaluateInternal(ValueEval valueEval, ValueEval valueEval2, int i, int i2) throws EvaluationException {
        ValueEval dereferenceResult = WorkbookEvaluator.dereferenceResult(valueEval, i, i2);
        return dereferenceResult instanceof ErrorEval ? valueEval2 : dereferenceResult;
    }
}
