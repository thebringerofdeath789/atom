package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ErrorEval;
import org.apache.poi.ss.formula.eval.ValueEval;

/* loaded from: classes5.dex */
public final class Na extends Fixed0ArgFunction {
    @Override // org.apache.poi.ss.formula.functions.Function0Arg
    public ValueEval evaluate(int i, int i2) {
        return ErrorEval.NA;
    }
}
