package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableToLongFunction<T, E extends Throwable> {
    public static final FailableToLongFunction NOP = new FailableToLongFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableToLongFunction$pui4_bkTWCSKLEisUzNJIJYTaQE
        @Override // org.apache.commons.lang3.function.FailableToLongFunction
        public final long applyAsLong(Object obj) {
            return FailableToLongFunction.lambda$static$0(obj);
        }
    };

    static /* synthetic */ long lambda$static$0(Object obj) throws Throwable {
        return 0L;
    }

    long applyAsLong(T t) throws Throwable;

    static <T, E extends Throwable> FailableToLongFunction<T, E> nop() {
        return NOP;
    }
}
