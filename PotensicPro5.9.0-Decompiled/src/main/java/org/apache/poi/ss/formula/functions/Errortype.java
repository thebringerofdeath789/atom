package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.EvaluationException;
import org.apache.poi.ss.formula.eval.NumberEval;
import org.apache.poi.ss.formula.eval.OperandResolver;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Errortype extends Fixed1ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function1Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval) {
        try {
            OperandResolver.getSingleValue(valueEval, i, i2);
            return ErrorEval.NA;
        } catch (EvaluationException e) {
            return new NumberEval(translateErrorCodeToErrorTypeValue(e.getErrorEval().getErrorCode()));
        }
    }

    private int translateErrorCodeToErrorTypeValue(int i) {
        if (i == 0) {
            return 1;
        }
        if (i == 7) {
            return 2;
        }
        if (i == 15) {
            return 3;
        }
        if (i == 23) {
            return 4;
        }
        if (i == 29) {
            return 5;
        }
        if (i == 36) {
            return 6;
        }
        if (i == 42) {
            return 7;
        }
        throw new IllegalArgumentException("Invalid error code (" + i + ")");
    }
}
