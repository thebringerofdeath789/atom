package org.apache.poi.ss.formula.eval;

import org.apache.poi.ss.formula.functions.Fixed1ArgFunction;
import org.apache.poi.ss.formula.functions.Function;

/* loaded from: classes5.dex */
public final class PercentEval extends Fixed1ArgFunction {
    public static final Function instance = new PercentEval();

    private PercentEval() {
    }

    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            double coerceValueToDouble = OperandResolver.coerceValueToDouble(OperandResolver.getSingleValue(valueEval, i, i2));
            if (coerceValueToDouble == 0.0d) {
                return NumberEval.ZERO;
            }
            return new NumberEval(coerceValueToDouble / 100.0d);
        } catch (EvaluationException e) {
            return e.getErrorEval();
        }
    }
}
