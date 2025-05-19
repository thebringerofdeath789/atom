package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableIntToDoubleFunction<E extends Throwable> {
    public static final FailableIntToDoubleFunction NOP = new FailableIntToDoubleFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableIntToDoubleFunction$VtXx5x8qYBOG_y1Wpe30ny3d51c
        @Override // org.apache.commons.lang3.function.FailableIntToDoubleFunction
        public final double applyAsDouble(int i) {
            return FailableIntToDoubleFunction.lambda$static$0(i);
        }
    };

    static /* synthetic */ double lambda$static$0(int i) throws Throwable {
        return 0.0d;
    }

    double applyAsDouble(int i) throws Throwable;

    static <E extends Throwable> FailableIntToDoubleFunction<E> nop() {
        return NOP;
    }
}
