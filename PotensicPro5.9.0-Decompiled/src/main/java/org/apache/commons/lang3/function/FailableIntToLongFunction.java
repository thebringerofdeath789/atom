package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableIntToLongFunction<E extends Throwable> {
    public static final FailableIntToLongFunction NOP = new FailableIntToLongFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableIntToLongFunction$6_kUfgOP8rXgtg5fgRX_FhmIhxs
        @Override // org.apache.commons.lang3.function.FailableIntToLongFunction
        public final long applyAsLong(int i) {
            return FailableIntToLongFunction.lambda$static$0(i);
        }
    };

    static /* synthetic */ long lambda$static$0(int i) throws Throwable {
        return 0L;
    }

    long applyAsLong(int i) throws Throwable;

    static <E extends Throwable> FailableIntToLongFunction<E> nop() {
        return NOP;
    }
}
