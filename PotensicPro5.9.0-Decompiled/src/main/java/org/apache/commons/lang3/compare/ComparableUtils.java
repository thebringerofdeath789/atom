package org.apache.commons.lang3.compare;

import java.util.function.Predicate;

/* loaded from: classes4.dex */
public class ComparableUtils {

    public static class ComparableCheckBuilder<A extends Comparable<A>> {
        private final A a;

        private ComparableCheckBuilder(A a) {
            this.a = a;
        }

        public boolean between(A a, A a2) {
            return betweenOrdered(a, a2) || betweenOrdered(a2, a);
        }

        public boolean betweenExclusive(A a, A a2) {
            return betweenOrderedExclusive(a, a2) || betweenOrderedExclusive(a2, a);
        }

        private boolean betweenOrdered(A a, A a2) {
            return greaterThanOrEqualTo(a) && lessThanOrEqualTo(a2);
        }

        private boolean betweenOrderedExclusive(A a, A a2) {
            return greaterThan(a) && lessThan(a2);
        }

        public boolean equalTo(A a) {
            return this.a.compareTo(a) == 0;
        }

        public boolean greaterThan(A a) {
            return this.a.compareTo(a) > 0;
        }

        public boolean greaterThanOrEqualTo(A a) {
            return this.a.compareTo(a) >= 0;
        }

        public boolean lessThan(A a) {
            return this.a.compareTo(a) < 0;
        }

        public boolean lessThanOrEqualTo(A a) {
            return this.a.compareTo(a) <= 0;
        }
    }

    public static <A extends Comparable<A>> Predicate<A> between(final A a, final A a2) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.-$$Lambda$ComparableUtils$4SkNfXlrUzLFEgtklQCSsxaBnD0
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean between;
                between = ComparableUtils.is((Comparable) obj).between(a, a2);
                return between;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> betweenExclusive(final A a, final A a2) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.-$$Lambda$ComparableUtils$rh3rAe1sBb2ZsiPHBTjojK55rxU
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean betweenExclusive;
                betweenExclusive = ComparableUtils.is((Comparable) obj).betweenExclusive(a, a2);
                return betweenExclusive;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> ge(final A a) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.-$$Lambda$ComparableUtils$wG-LlekwSjrW4Inf7Uo1CkfArVQ
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean greaterThanOrEqualTo;
                greaterThanOrEqualTo = ComparableUtils.is((Comparable) obj).greaterThanOrEqualTo(a);
                return greaterThanOrEqualTo;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> gt(final A a) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.-$$Lambda$ComparableUtils$bx_thELo9D_5VwMnHhJl7ihjGJg
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean greaterThan;
                greaterThan = ComparableUtils.is((Comparable) obj).greaterThan(a);
                return greaterThan;
            }
        };
    }

    public static <A extends Comparable<A>> ComparableCheckBuilder<A> is(A a) {
        return new ComparableCheckBuilder<>(a);
    }

    public static <A extends Comparable<A>> Predicate<A> le(final A a) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.-$$Lambda$ComparableUtils$u0CibO7JWPhDh6TOIy8W05eDdjE
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lessThanOrEqualTo;
                lessThanOrEqualTo = ComparableUtils.is((Comparable) obj).lessThanOrEqualTo(a);
                return lessThanOrEqualTo;
            }
        };
    }

    public static <A extends Comparable<A>> Predicate<A> lt(final A a) {
        return new Predicate() { // from class: org.apache.commons.lang3.compare.-$$Lambda$ComparableUtils$Rfm22mjTTU0YxDFy74assP7Phj4
            @Override // java.util.function.Predicate
            public final boolean test(Object obj) {
                boolean lessThan;
                lessThan = ComparableUtils.is((Comparable) obj).lessThan(a);
                return lessThan;
            }
        };
    }

    private ComparableUtils() {
    }
}
