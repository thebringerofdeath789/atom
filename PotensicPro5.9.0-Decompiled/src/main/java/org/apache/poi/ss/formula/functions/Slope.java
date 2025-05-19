package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.eval.ValueEval;
import org.apache.poi.ss.formula.functions.LinearRegressionFunction;

/* loaded from: classes5.dex */
public final class Slope extends Fixed2ArgFunction {
    private final LinearRegressionFunction func = new LinearRegressionFunction(LinearRegressionFunction.FUNCTION.SLOPE);

    @Override // org.apache.poi.ss.formula.functions.Function2Arg
    public ValueEval evaluate(int i, int i2, ValueEval valueEval, ValueEval valueEval2) {
        return this.func.evaluate(i, i2, valueEval, valueEval2);
    }
}
