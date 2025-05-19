package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableObjDoubleConsumer<T, E extends Throwable> {
    public static final FailableObjDoubleConsumer NOP = new FailableObjDoubleConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableObjDoubleConsumer$tf1naiBZgVe1FGEOrRVAaZh2mPA
        @Override // org.apache.commons.lang3.function.FailableObjDoubleConsumer
        public final void accept(Object obj, double d) {
            FailableObjDoubleConsumer.lambda$static$0(obj, d);
        }
    };

    static /* synthetic */ void lambda$static$0(Object obj, double d) throws Throwable {
    }

    void accept(T t, double d) throws Throwable;

    static <T, E extends Throwable> FailableObjDoubleConsumer<T, E> nop() {
        return NOP;
    }
}
