package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableBiConsumer<T, U, E extends Throwable> {
    public static final FailableBiConsumer NOP = new FailableBiConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiConsumer$WhrHRpi6aghODAxvscv0eU71atM
        @Override // org.apache.commons.lang3.function.FailableBiConsumer
        public final void accept(Object obj, Object obj2) {
            FailableBiConsumer.lambda$static$0(obj, obj2);
        }
    };

    static /* synthetic */ void lambda$static$0(Object obj, Object obj2) throws Throwable {
    }

    void accept(T t, U u) throws Throwable;

    static <T, U, E extends Throwable> FailableBiConsumer<T, U, E> nop() {
        return NOP;
    }

    default FailableBiConsumer<T, U, E> andThen(final FailableBiConsumer<? super T, ? super U, E> failableBiConsumer) {
        Objects.requireNonNull(failableBiConsumer);
        return new FailableBiConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiConsumer$xjeusUiI3vQlvTYaheSocu47I2s
            @Override // org.apache.commons.lang3.function.FailableBiConsumer
            public final void accept(Object obj, Object obj2) {
                FailableBiConsumer.lambda$andThen$1(FailableBiConsumer.this, failableBiConsumer, obj, obj2);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$1(FailableBiConsumer _this, FailableBiConsumer failableBiConsumer, Object obj, Object obj2) throws Throwable {
        _this.accept(obj, obj2);
        failableBiConsumer.accept(obj, obj2);
    }
}
