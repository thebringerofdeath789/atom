package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.TwoDEval;
import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.RefEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Columns extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        int i3;
        if (valueEval instanceof TwoDEval) {
            i3 = ((TwoDEval) valueEval).getWidth();
        } else {
            if (!(valueEval instanceof RefEval)) {
                return ErrorEval.VALUE_INVALID;
            }
            i3 = 1;
        }
        return new NumberEval(i3);
    }
}
