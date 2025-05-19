package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public abstract class Fixed3ArgFunction implements Function3Arg {
    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        if (valueEvalArr.length != 3) {
            return ErrorEval.VALUE_INVALID;
        }
        return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
    }
}
