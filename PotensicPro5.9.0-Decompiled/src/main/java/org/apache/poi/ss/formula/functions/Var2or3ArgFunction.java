package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
abstract class Var2or3ArgFunction implements Function2Arg, Function3Arg {
    Var2or3ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 2) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1]);
        }
        if (length == 3) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1], valueEvalArr[2]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
