package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableDoubleFunction<R, E extends Throwable> {
    public static final FailableDoubleFunction NOP = new FailableDoubleFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleFunction$rZKYPYhRPZjWWHkaPZpt96DhEx8
        @Override // org.apache.commons.lang3.function.FailableDoubleFunction
        public final Object apply(double d) {
            return FailableDoubleFunction.lambda$static$0(d);
        }
    };

    static /* synthetic */ Object lambda$static$0(double d) throws Throwable {
        return null;
    }

    R apply(double d) throws Throwable;

    static <R, E extends Throwable> FailableDoubleFunction<R, E> nop() {
        return NOP;
    }
}
