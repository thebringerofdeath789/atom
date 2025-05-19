package org.apache.commons.lang3.function;

import java.lang.Throwable;
import java.util.Objects;

@FunctionalInterface
/* loaded from: classes4.dex */
public interface FailableBiPredicate<T, U, E extends Throwable> {
    public static final FailableBiPredicate FALSE = new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiPredicate$qml196xBfsJjNNAkUtuTR9NMZAw
        @Override // org.apache.commons.lang3.function.FailableBiPredicate
        public final boolean test(Object obj, Object obj2) {
            return FailableBiPredicate.lambda$static$0(obj, obj2);
        }
    };
    public static final FailableBiPredicate TRUE = new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiPredicate$YbuRf08fcv2hZ64bSJcBtOKnvj4
        @Override // org.apache.commons.lang3.function.FailableBiPredicate
        public final boolean test(Object obj, Object obj2) {
            return FailableBiPredicate.lambda$static$1(obj, obj2);
        }
    };

    static /* synthetic */ boolean lambda$static$0(Object obj, Object obj2) throws Throwable {
        return false;
    }

    static /* synthetic */ boolean lambda$static$1(Object obj, Object obj2) throws Throwable {
        return true;
    }

    boolean test(T t, U u) throws Throwable;

    static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> falsePredicate() {
        return FALSE;
    }

    static <T, U, E extends Throwable> FailableBiPredicate<T, U, E> truePredicate() {
        return TRUE;
    }

    default FailableBiPredicate<T, U, E> and(final FailableBiPredicate<? super T, ? super U, E> failableBiPredicate) {
        Objects.requireNonNull(failableBiPredicate);
        return new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiPredicate$SXg6-akzSTi88NiJn5C67aozBSs
            @Override // org.apache.commons.lang3.function.FailableBiPredicate
            public final boolean test(Object obj, Object obj2) {
                return FailableBiPredicate.lambda$and$2(FailableBiPredicate.this, failableBiPredicate, obj, obj2);
            }
        };
    }

    static /* synthetic */ boolean lambda$and$2(FailableBiPredicate _this, FailableBiPredicate failableBiPredicate, Object obj, Object obj2) throws Throwable {
        return _this.test(obj, obj2) && failableBiPredicate.test(obj, obj2);
    }

    static /* synthetic */ boolean lambda$negate$3(FailableBiPredicate _this, Object obj, Object obj2) throws Throwable {
        return !_this.test(obj, obj2);
    }

    default FailableBiPredicate<T, U, E> negate() {
        return new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiPredicate$Mr_UhGUSsjt5pPi_nk6T3Vq4VWc
            @Override // org.apache.commons.lang3.function.FailableBiPredicate
            public final boolean test(Object obj, Object obj2) {
                return FailableBiPredicate.lambda$negate$3(FailableBiPredicate.this, obj, obj2);
            }
        };
    }

    default FailableBiPredicate<T, U, E> or(final FailableBiPredicate<? super T, ? super U, E> failableBiPredicate) {
        Objects.requireNonNull(failableBiPredicate);
        return new FailableBiPredicate() { // from class: org.apache.commons.lang3.function.-$$Lambda$FailableBiPredicate$skwBXolMbtdDPLyodxkmU4cK-3E
            @Override // org.apache.commons.lang3.function.FailableBiPredicate
            public final boolean test(Object obj, Object obj2) {
                return FailableBiPredicate.lambda$or$4(FailableBiPredicate.this, failableBiPredicate, obj, obj2);
            }
        };
    }

    static /* synthetic */ boolean lambda$or$4(FailableBiPredicate _this, FailableBiPredicate failableBiPredicate, Object obj, Object obj2) throws Throwable {
        return _this.test(obj, obj2) || failableBiPredicate.test(obj, obj2);
    }
}
