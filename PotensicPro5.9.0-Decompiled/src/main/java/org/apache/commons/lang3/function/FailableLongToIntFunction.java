package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableLongToIntFunction<E extends Throwable> {
    public static final FailableLongToIntFunction NOP = new FailableLongToIntFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableLongToIntFunction$BP-vUI3CEsVj0nfJDaz5IxCraqU
        @Override // org.apache.commons.lang3.function.FailableLongToIntFunction
        public final int applyAsInt(long j) {
            return FailableLongToIntFunction.lambda$static$0(j);
        }
    };

    static /* synthetic */ int lambda$static$0(long j) throws Throwable {
        return 0;
    }

    int applyAsInt(long j) throws Throwable;

    static <E extends Throwable> FailableLongToIntFunction<E> nop() {
        return NOP;
    }
}
