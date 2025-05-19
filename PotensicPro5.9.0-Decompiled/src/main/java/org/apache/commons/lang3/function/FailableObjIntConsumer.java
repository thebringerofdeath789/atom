package org.apache.commons.lang3.function;

import java.lang.Throwable;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableObjIntConsumer<T, E extends Throwable> {
    public static final FailableObjIntConsumer NOP = new FailableObjIntConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableObjIntConsumer$A3LpaetHN5kg5CB_KXOQs8JOqRU
        @Override // org.apache.commons.lang3.function.FailableObjIntConsumer
        public final void accept(Object obj, int i) {
            FailableObjIntConsumer.lambda$static$0(obj, i);
        }
    };

    static /* synthetic */ void lambda$static$0(Object obj, int i) throws Throwable {
    }

    void accept(T t, int i) throws Throwable;

    static <T, E extends Throwable> FailableObjIntConsumer<T, E> nop() {
        return NOP;
    }
}
