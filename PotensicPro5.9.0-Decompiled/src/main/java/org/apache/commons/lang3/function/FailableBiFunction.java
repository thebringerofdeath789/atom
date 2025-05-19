package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableBiFunction<T, U, R, E extends Throwable> {
    public static final FailableBiFunction NOP = new FailableBiFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiFunction$3AQmbBO7oy12fFhq8zhsLBkqc0Y
        @Override // org.apache.commons.lang3.function.FailableBiFunction
        public final Object apply(Object obj, Object obj2) {
            return FailableBiFunction.lambda$static$0(obj, obj2);
        }
    };

    static /* synthetic */ Object lambda$static$0(Object obj, Object obj2) throws Throwable {
        return null;
    }

    R apply(T t, U u) throws Throwable;

    static <T, U, R, E extends Throwable> FailableBiFunction<T, U, R, E> nop() {
        return NOP;
    }

    default <V> FailableBiFunction<T, U, V, E> andThen(final FailableFunction<? super R, ? extends V, E> failableFunction) {
        Objects.requireNonNull(failableFunction);
        return new FailableBiFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiFunction$C2NfyN_b8FGwUnaPmOUxrQAowbM
            @Override // org.apache.commons.lang3.function.FailableBiFunction
            public final Object apply(Object obj, Object obj2) {
                Object apply;
                apply = failableFunction.apply(FailableBiFunction.this.apply(obj, obj2));
                return apply;
            }
        };
    }
}
