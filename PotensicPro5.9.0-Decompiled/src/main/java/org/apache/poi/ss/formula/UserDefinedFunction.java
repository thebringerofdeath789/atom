package org.apache.poi.ss.formula;

import org.apache.poi.ss.formula.eval.FunctionNameEval;
import org.apache.poi.ss.formula.eval.NotImplementedFunctionException;
import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.FreeRefFunction;

/* loaded from: classes5.dex */
final class UserDefinedFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new UserDefinedFunction();

    private UserDefinedFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        int length = valueEvalArr.length;
        if (length < 1) {
            throw new RuntimeException("function name argument missing");
        }
        ValueEval valueEval = valueEvalArr[0];
        if (valueEval instanceof FunctionNameEval) {
            String functionName = ((FunctionNameEval) valueEval).getFunctionName();
            FreeRefFunction findUserDefinedFunction = operationEvaluationContext.findUserDefinedFunction(functionName);
            if (findUserDefinedFunction == null) {
                throw new NotImplementedFunctionException(functionName);
            }
            int i = length - 1;
            ValueEval[] valueEvalArr2 = new ValueEval[i];
            System.arraycopy(valueEvalArr, 1, valueEvalArr2, 0, i);
            return findUserDefinedFunction.evaluate(valueEvalArr2, operationEvaluationContext);
        }
        throw new RuntimeException("First argument should be a NameEval, but got (" + valueEval.getClass().getName() + ")");
    }
}
