package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

/* loaded from: classes4.dex */
public interface FailableDoubleUnaryOperator<E extends Throwable> {
    public static final FailableDoubleUnaryOperator NOP = new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleUnaryOperator$U3jaFb3f5DXro0gQs6eKB8uso3s
        @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
        public final double applyAsDouble(double d) {
            return FailableDoubleUnaryOperator.lambda$static$0(d);
        }
    };

    static /* synthetic */ double lambda$identity$1(double d) throws Throwable {
        return d;
    }

    static /* synthetic */ double lambda$static$0(double d) throws Throwable {
        return 0.0d;
    }

    double applyAsDouble(double d) throws Throwable;

    static <E extends Throwable> FailableDoubleUnaryOperator<E> identity() {
        return new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleUnaryOperator$Z3FlOo1H6QemGckC7zOF86JxyiE
            @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
            public final double applyAsDouble(double d) {
                return FailableDoubleUnaryOperator.lambda$identity$1(d);
            }
        };
    }

    static <E extends Throwable> FailableDoubleUnaryOperator<E> nop() {
        return NOP;
    }

    default FailableDoubleUnaryOperator<E> andThen(final FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleUnaryOperator$8jebZH690mTBFTL2Dc0A7tasA10
            @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
            public final double applyAsDouble(double d) {
                double applyAsDouble;
                applyAsDouble = failableDoubleUnaryOperator.applyAsDouble(FailableDoubleUnaryOperator.this.applyAsDouble(d));
                return applyAsDouble;
            }
        };
    }

    default FailableDoubleUnaryOperator<E> compose(final FailableDoubleUnaryOperator<E> failableDoubleUnaryOperator) {
        Objects.requireNonNull(failableDoubleUnaryOperator);
        return new FailableDoubleUnaryOperator() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableDoubleUnaryOperator$TmcB97UgmT_0rzCXq3tdvr486QQ
            @Override // org.apache.commons.lang3.function.FailableDoubleUnaryOperator
            public final double applyAsDouble(double d) {
                double applyAsDouble;
                applyAsDouble = FailableDoubleUnaryOperator.this.applyAsDouble(failableDoubleUnaryOperator.applyAsDouble(d));
                return applyAsDouble;
            }
        };
    }
}
