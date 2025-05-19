package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailablePredicate<T, E extends Throwable> {
    public static final FailablePredicate FALSE = new FailablePredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailablePredicate$4f_rnAH9HA6L7Lxg1EfVpMF9Q4A
        @Override // org.apache.commons.lang3.function.FailablePredicate
        public final boolean test(Object obj) {
            return FailablePredicate.lambda$static$0(obj);
        }
    };
    public static final FailablePredicate TRUE = new FailablePredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailablePredicate$s-tDvinuI7sI-i2eJG3rp2AlTIg
        @Override // org.apache.commons.lang3.function.FailablePredicate
        public final boolean test(Object obj) {
            return FailablePredicate.lambda$static$1(obj);
        }
    };

    static /* synthetic */ boolean lambda$static$0(Object obj) throws Throwable {
        return false;
    }

    static /* synthetic */ boolean lambda$static$1(Object obj) throws Throwable {
        return true;
    }

    boolean test(T t) throws Throwable;

    static <T, E extends Throwable> FailablePredicate<T, E> falsePredicate() {
        return FALSE;
    }

    static <T, E extends Throwable> FailablePredicate<T, E> truePredicate() {
        return TRUE;
    }

    default FailablePredicate<T, E> and(final FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return new FailablePredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailablePredicate$UISSVRtSfVVtuWXd_rvfMQVbuqg
            @Override // org.apache.commons.lang3.function.FailablePredicate
            public final boolean test(Object obj) {
                return FailablePredicate.lambda$and$2(FailablePredicate.this, failablePredicate, obj);
            }
        };
    }

    static /* synthetic */ boolean lambda$and$2(FailablePredicate _this, FailablePredicate failablePredicate, Object obj) throws Throwable {
        return _this.test(obj) && failablePredicate.test(obj);
    }

    static /* synthetic */ boolean lambda$negate$3(FailablePredicate _this, Object obj) throws Throwable {
        return !_this.test(obj);
    }

    default FailablePredicate<T, E> negate() {
        return new FailablePredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailablePredicate$fRWIzrhH4W1K4lpYswOxhUKmox8
            @Override // org.apache.commons.lang3.function.FailablePredicate
            public final boolean test(Object obj) {
                return FailablePredicate.lambda$negate$3(FailablePredicate.this, obj);
            }
        };
    }

    default FailablePredicate<T, E> or(final FailablePredicate<? super T, E> failablePredicate) {
        Objects.requireNonNull(failablePredicate);
        return new FailablePredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailablePredicate$M_MBQnzyKtg4GEh4wFaAWch3BWQ
            @Override // org.apache.commons.lang3.function.FailablePredicate
            public final boolean test(Object obj) {
                return FailablePredicate.lambda$or$4(FailablePredicate.this, failablePredicate, obj);
            }
        };
    }

    static /* synthetic */ boolean lambda$or$4(FailablePredicate _this, FailablePredicate failablePredicate, Object obj) throws Throwable {
        return _this.test(obj) || failablePredicate.test(obj);
    }
}
