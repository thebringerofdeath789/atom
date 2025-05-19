package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class DGet implements IDStarAlgorithm {
    private ValueEval result;

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public void reset() {
        this.result = null;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public boolean processMatch(ValueEval valueEval) {
        if (this.result == null) {
            this.result = valueEval;
            return true;
        }
        this.result = ErrorEval.NUM_ERROR;
        return false;
    }

    @Override // org.apache.poi.ss.formula.functions.IDStarAlgorithm
    public ValueEval getResult() {
        ValueEval valueEval = this.result;
        return valueEval == null ? ErrorEval.VALUE_INVALID : valueEval;
    }
}
