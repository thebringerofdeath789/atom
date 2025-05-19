package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.functions.NumericFunction;

/* loaded from: classes5.dex */
public final class Odd extends NumericFunction.OneArg {
    private static final long PARITY_MASK = -2;

    private static long calcOdd(double d) {
        double d2 = d + 1.0d;
        long j = ((long) d2) & PARITY_MASK;
        return ((double) j) == d2 ? j - 1 : j + 1;
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
    protected double evaluate(double d) {
        long j;
        if (d == 0.0d) {
            return 1.0d;
        }
        if (d > 0.0d) {
            j = calcOdd(d);
        } else {
            j = -calcOdd(-d);
        }
        return j;
    }
}
