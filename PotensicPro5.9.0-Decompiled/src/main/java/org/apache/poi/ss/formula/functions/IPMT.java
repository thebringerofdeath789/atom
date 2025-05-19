package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public class IPMT extends NumericFunction {
    @Override // org.apache.poi.ss.formula.functions.NumericFunction
    public double eval(ValueEval[] valueEvalArr, int i, int i2) throws EvaluationException {
        if (valueEvalArr.length != 4) {
            throw new EvaluationException(ErrorEval.VALUE_INVALID);
        }
        double ipmt = Finance.ipmt(OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[0], i, i2)), OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[1], i, i2)), OperandResolver.coerceValueToInt(OperandResolver.getSingleValue(valueEvalArr[2], i, i2)), OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEvalArr[3], i, i2)));
        checkValue(ipmt);
        return ipmt;
    }
}
