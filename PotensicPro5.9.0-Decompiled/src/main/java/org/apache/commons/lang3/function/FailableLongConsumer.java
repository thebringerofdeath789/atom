package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableLongConsumer<E extends Throwable> {
    public static final FailableLongConsumer NOP = new FailableLongConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableLongConsumer$cApBadKmZvcpvm1-G9G_V42V7Hs
        @Override // org.apache.commons.lang3.function.FailableLongConsumer
        public final void accept(long j) {
            FailableLongConsumer.lambda$static$0(j);
        }
    };

    static /* synthetic */ void lambda$static$0(long j) throws Throwable {
    }

    void accept(long j) throws Throwable;

    static <E extends Throwable> FailableLongConsumer<E> nop() {
        return NOP;
    }

    default FailableLongConsumer<E> andThen(final FailableLongConsumer<E> failableLongConsumer) {
        Objects.requireNonNull(failableLongConsumer);
        return new FailableLongConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableLongConsumer$-1ze5CtwGVysJSYhzF0IiSTKlDY
            @Override // org.apache.commons.lang3.function.FailableLongConsumer
            public final void accept(long j) {
                FailableLongConsumer.lambda$andThen$1(FailableLongConsumer.this, failableLongConsumer, j);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$1(FailableLongConsumer _this, FailableLongConsumer failableLongConsumer, long j) throws Throwable {
        _this.accept(j);
        failableLongConsumer.accept(j);
    }
}
