package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.functions.XYNumericFunction;

/* loaded from: classes5.dex */
public final class Sumx2my2 extends XYNumericFunction {
    private static final XYNumericFunction.Accumulator XSquaredMinusYSquaredAccumulator = new XYNumericFunction.Accumulator() { // from class: org.apache.poi.ss.formula.functions.Sumx2my2.1
        @Override // org.apache.poi.ss.formula.functions.XYNumericFunction.Accumulator
        public double accumulate(double d, double d2) {
            return (d * d) - (d2 * d2);
        }
    };

    @Override // org.apache.poi.ss.formula.functions.XYNumericFunction
    protected XYNumericFunction.Accumulator createAccumulator() {
        return XSquaredMinusYSquaredAccumulator;
    }
}
