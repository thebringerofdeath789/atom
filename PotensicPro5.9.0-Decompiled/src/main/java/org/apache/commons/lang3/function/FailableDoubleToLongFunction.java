package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableDoubleToLongFunction<E extends Throwable> {
    public static final FailableDoubleToLongFunction NOP = new FailableDoubleToLongFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleToLongFunction$KzQgjcePCDsV14gJCqcN-uNfF9o
        @Override // org.apache.commons.lang3.function.FailableDoubleToLongFunction
        public final int applyAsLong(double d) {
            return FailableDoubleToLongFunction.lambda$static$0(d);
        }
    };

    static /* synthetic */ int lambda$static$0(double d) throws Throwable {
        return 0;
    }

    int applyAsLong(double d) throws Throwable;

    static <E extends Throwable> FailableDoubleToLongFunction<E> nop() {
        return NOP;
    }
}
