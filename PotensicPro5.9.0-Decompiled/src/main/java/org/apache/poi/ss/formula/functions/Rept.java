package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.StringEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class Rept extends Fixed2ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        try {
            String coerceValueToString = OperandResolver.coerceValueToString(OperandResolver.getSingleValue(valueEval, i, i2));
            try {
                int intValue = new Double(OperandResolver.coerceValueToDouble(valueEval2)).intValue();
                StringBuffer stringBuffer = new StringBuffer(coerceValueToString.length() * intValue);
                for (int i3 = 0; i3 < intValue; i3++) {
                    stringBuffer.append(coerceValueToString);
                }
                if (stringBuffer.toString().length() > 32767) {
                    return ErrorEval.VALUE_INVALID;
                }
                return new StringEval(stringBuffer.toString());
            } catch (EvaluationException unused) {
                return ErrorEval.VALUE_INVALID;
            }
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
