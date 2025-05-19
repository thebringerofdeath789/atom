package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Code extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            String coerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2));
            if (coerceValueToString.length() == 0) {
                return ErrorEval.VALUE_INVALID;
            }
            return new StringEval(String.valueOf((int) coerceValueToString.charAt(0)));
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
