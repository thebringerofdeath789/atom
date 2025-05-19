package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableIntFunction<R, E extends Throwable> {
    public static final FailableIntFunction NOP = new FailableIntFunction() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableIntFunction$IfMz57qNWZ2ozHTiTtutUIScuj0
        @Override // org.apache.commons.lang3.function.FailableIntFunction
        public final Object apply(int i) {
            return FailableIntFunction.lambda$static$0(i);
        }
    };

    static /* synthetic */ Object lambda$static$0(int i) throws Throwable {
        return null;
    }

    R apply(int i) throws Throwable;

    static <R, E extends Throwable> FailableIntFunction<R, E> nop() {
        return NOP;
    }
}
