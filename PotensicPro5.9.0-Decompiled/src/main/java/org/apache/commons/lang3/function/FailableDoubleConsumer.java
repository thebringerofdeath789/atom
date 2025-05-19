package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableDoubleConsumer<E extends Throwable> {
    public static final FailableDoubleConsumer NOP = new FailableDoubleConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleConsumer$CyHYuVONnzGYWgq3GLL2hicGZk0
        @Override // org.apache.commons.lang3.function.FailableDoubleConsumer
        public final void accept(double d) {
            FailableDoubleConsumer.lambda$static$0(d);
        }
    };

    static /* synthetic */ void lambda$static$0(double d) throws Throwable {
    }

    void accept(double d) throws Throwable;

    static <E extends Throwable> FailableDoubleConsumer<E> nop() {
        return NOP;
    }

    default FailableDoubleConsumer<E> andThen(final FailableDoubleConsumer<E> failableDoubleConsumer) {
        Objects.requireNonNull(failableDoubleConsumer);
        return new FailableDoubleConsumer() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleConsumer$uteKWghr9vOsRm1upjAmY13TCNE
            @Override // org.apache.commons.lang3.function.FailableDoubleConsumer
            public final void accept(double d) {
                FailableDoubleConsumer.lambda$andThen$1(FailableDoubleConsumer.this, failableDoubleConsumer, d);
            }
        };
    }

    static /* synthetic */ void lambda$andThen$1(FailableDoubleConsumer _this, FailableDoubleConsumer failableDoubleConsumer, double d) throws Throwable {
        _this.accept(d);
        failableDoubleConsumer.accept(d);
    }
}
