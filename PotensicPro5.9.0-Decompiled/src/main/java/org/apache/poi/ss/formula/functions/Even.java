package org.apache.poi.ss.formula.functions;

import org.apache.poi.ss.formula.functions.NumericFunction;

/* loaded from: classes5.dex */
public final class Even extends NumericFunction.OneArg {
    private static final long PARITY_MASK = -2;

    private static long calcEven(double d) {
        long j = ((long) d) & PARITY_MASK;
        return ((double) j) == d ? j : j + 2;
    }

    @Override // org.apache.poi.ss.formula.functions.NumericFunction.OneArg
    protected double evaluate(double d) {
        long j;
        if (d == 0.0d) {
            return 0.0d;
        }
        if (d > 0.0d) {
            j = calcEven(d);
        } else {
            j = -calcEven(-d);
        }
        return j;
    }
}
