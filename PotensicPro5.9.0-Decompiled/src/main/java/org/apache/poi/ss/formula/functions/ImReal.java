package org.apache.poi.ss.formula.functions;

import java.util.regex.Matcher;
import org.apache.poi.ss.formula.OperationEvaluationContext;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class ImReal extends Fixed1ArgFunction implements FreeRefFunction {
    public static final FreeRefFunction instance = new ImReal();

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            Matcher matcher = Imaginary.COMPLEX_NUMBER_PATTERN.matcher(OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2)));
            if (matcher.matches()) {
                String group = matcher.group(2);
                boolean z = group.length() != 0;
                if (group.length() == 0) {
                    return new StringEval(String.valueOf(0));
                }
                String str = "";
                if (z) {
                    String group2 = matcher.group(1);
                    if (group2.length() != 0 && !group2.equals("+")) {
                        str = group2;
                    }
                    String group3 = matcher.group(2);
                    if (group3.length() != 0) {
                        str = str + group3;
                    } else {
                        str = str + "1";
                    }
                }
                return new StringEval(str);
            }
            return ErrorEval.NUM_ERROR;
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }

    @Override // org.apache.poi.ss.formula.functions.FreeRefFunction
    public ValueEval evaluate(ValueEval[] valueEvalArr, OperationEvaluationContext operationEvaluationContext) {
        if (valueEvalArr.length != 1) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(operationEvaluationContext.getRowIndex(), operationEvaluationContext.getColumnIndex(), valueEvalArr[0]);
    }
}
