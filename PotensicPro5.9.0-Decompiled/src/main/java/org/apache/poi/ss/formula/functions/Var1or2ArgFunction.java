package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
abstract class Var1or2ArgFunction implements Function1Arg, Function2Arg {
    Var1or2ArgFunction() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function
    public final ValueEval evaluate(ValueEval[] valueEvalArr, int i, int i2) {
        int length = valueEvalArr.length;
        if (length == 1) {
            return evaluate(i, i2, valueEvalArr[0]);
        }
        if (length == 2) {
            return evaluate(i, i2, valueEvalArr[0], valueEvalArr[1]);
        }
        return ErrorEval.VALUE_INVALID;
    }
}
