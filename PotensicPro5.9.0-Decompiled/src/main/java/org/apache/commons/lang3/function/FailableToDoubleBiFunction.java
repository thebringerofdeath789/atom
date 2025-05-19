package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableToDoubleBiFunction<T, U, E extends Throwable> {
    public static final FailableToDoubleBiFunction NOP = new FailableToDoubleBiFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableToDoubleBiFunction$B5CFAczk6Ne_JZunsN7BC7xzDkQ
        @Override // org.apache.commons.lang3.function.FailableToDoubleBiFunction
        public final double applyAsDouble(Object obj, Object obj2) {
            return FailableToDoubleBiFunction.lambda$static$0(obj, obj2);
        }
    };

    static /* synthetic */ double lambda$static$0(Object obj, Object obj2) throws Throwable {
        return 0.0d;
    }

    double applyAsDouble(T t, U u) throws Throwable;

    static <T, U, E extends Throwable> FailableToDoubleBiFunction<T, U, E> nop() {
        return NOP;
    }
}
