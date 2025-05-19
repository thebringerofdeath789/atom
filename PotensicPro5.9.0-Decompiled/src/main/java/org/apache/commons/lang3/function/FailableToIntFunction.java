package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableToIntFunction<T, E extends Throwable> {
    public static final FailableToIntFunction NOP = new FailableToIntFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableToIntFunction$gUTO07nuWrYsQMQsi5uVMPP7I2c
        @Override // org.apache.commons.lang3.function.FailableToIntFunction
        public final int applyAsInt(Object obj) {
            return FailableToIntFunction.lambda$static$0(obj);
        }
    };

    static /* synthetic */ int lambda$static$0(Object obj) throws Throwable {
        return 0;
    }

    int applyAsInt(T t) throws Throwable;

    static <T, E extends Throwable> FailableToIntFunction<T, E> nop() {
        return NOP;
    }
}
