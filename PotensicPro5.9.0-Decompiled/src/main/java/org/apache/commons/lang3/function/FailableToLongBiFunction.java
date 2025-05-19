package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableToLongBiFunction<T, U, E extends Throwable> {
    public static final FailableToLongBiFunction NOP = new FailableToLongBiFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableToLongBiFunction$3lxNpx4RcSeOGr_2o9WzixQPnO4
        @Override // org.apache.commons.lang3.function.FailableToLongBiFunction
        public final long applyAsLong(Object obj, Object obj2) {
            return FailableToLongBiFunction.lambda$static$0(obj, obj2);
        }
    };

    static /* synthetic */ long lambda$static$0(Object obj, Object obj2) throws Throwable {
        return 0L;
    }

    long applyAsLong(T t, U u) throws Throwable;

    static <T, U, E extends Throwable> FailableToLongBiFunction<T, U, E> nop() {
        return NOP;
    }
}
