package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableLongFunction<R, E extends Throwable> {
    public static final FailableLongFunction NOP = new FailableLongFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableLongFunction$sklSou-It_I5TmqkcRqHOUPUWgo
        @Override // org.apache.commons.lang3.function.FailableLongFunction
        public final Object apply(long j) {
            return FailableLongFunction.lambda$static$0(j);
        }
    };

    static /* synthetic */ Object lambda$static$0(long j) throws Throwable {
        return null;
    }

    R apply(long j) throws Throwable;

    static <R, E extends Throwable> FailableLongFunction<R, E> nop() {
        return NOP;
    }
}
