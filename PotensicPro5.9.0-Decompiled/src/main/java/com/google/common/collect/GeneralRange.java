package com.google.common.collect;

import com.google.common.base.Objects;
import com.google.common.base.Preconditions;
import java.io.Serializable;
import java.util.Comparator;
import org.apache.commons.beanutils.PropertyUtils;
import org.checkerframework.checker.nullness.compatqual.MonotonicNonNullDecl;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
final class GeneralRange<T> implements Serializable {
    private final Comparator<? super T> comparator;
    private final boolean hasLowerBound;
    private final boolean hasUpperBound;
    private final BoundType lowerBoundType;

    @NullableDecl
    private final T lowerEndpoint;

    @MonotonicNonNullDecl
    private transient GeneralRange<T> reverse;
    private final BoundType upperBoundType;

    @NullableDecl
    private final T upperEndpoint;

    static <T extends Comparable> GeneralRange<T> from(Range<T> range) {
        return new GeneralRange<>(Ordering.natural(), range.hasLowerBound(), range.hasLowerBound() ? range.lowerEndpoint() : null, range.hasLowerBound() ? range.lowerBoundType() : BoundType.OPEN, range.hasUpperBound(), range.hasUpperBound() ? range.upperEndpoint() : null, range.hasUpperBound() ? range.upperBoundType() : BoundType.OPEN);
    }

    static <T> GeneralRange<T> all(Comparator<? super T> comparator) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> downTo(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType) {
        return new GeneralRange<>(comparator, true, t, boundType, false, null, BoundType.OPEN);
    }

    static <T> GeneralRange<T> upTo(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType) {
        return new GeneralRange<>(comparator, false, null, BoundType.OPEN, true, t, boundType);
    }

    static <T> GeneralRange<T> range(Comparator<? super T> comparator, @NullableDecl T t, BoundType boundType, @NullableDecl T t2, BoundType boundType2) {
        return new GeneralRange<>(comparator, true, t, boundType, true, t2, boundType2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    private GeneralRange(Comparator<? super T> comparator, boolean z, @NullableDecl T t, BoundType boundType, boolean z2, @NullableDecl T t2, BoundType boundType2) {
        this.comparator = (Comparator) Preconditions.checkNotNull(comparator);
        this.hasLowerBound = z;
        this.hasUpperBound = z2;
        this.lowerEndpoint = t;
        this.lowerBoundType = (BoundType) Preconditions.checkNotNull(boundType);
        this.upperEndpoint = t2;
        this.upperBoundType = (BoundType) Preconditions.checkNotNull(boundType2);
        if (z) {
            comparator.compare(t, t);
        }
        if (z2) {
            comparator.compare(t2, t2);
        }
        if (z && z2) {
            int compare = comparator.compare(t, t2);
            Preconditions.checkArgument(compare <= 0, "lowerEndpoint (%s) > upperEndpoint (%s)", t, t2);
            if (compare == 0) {
                Preconditions.checkArgument((boundType != BoundType.OPEN) | (boundType2 != BoundType.OPEN));
            }
        }
    }

    Comparator<? super T> comparator() {
        return this.comparator;
    }

    boolean hasLowerBound() {
        return this.hasLowerBound;
    }

    boolean hasUpperBound() {
        return this.hasUpperBound;
    }

    boolean isEmpty() {
        return (hasUpperBound() && tooLow(getUpperEndpoint())) || (hasLowerBound() && tooHigh(getLowerEndpoint()));
    }

    boolean tooLow(@NullableDecl T t) {
        if (!hasLowerBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getLowerEndpoint());
        return ((compare == 0) & (getLowerBoundType() == BoundType.OPEN)) | (compare < 0);
    }

    boolean tooHigh(@NullableDecl T t) {
        if (!hasUpperBound()) {
            return false;
        }
        int compare = this.comparator.compare(t, getUpperEndpoint());
        return ((compare == 0) & (getUpperBoundType() == BoundType.OPEN)) | (compare > 0);
    }

    boolean contains(@NullableDecl T t) {
        return (tooLow(t) || tooHigh(t)) ? false : true;
    }

    GeneralRange<T> intersect(GeneralRange<T> generalRange) {
        int compare;
        int compare2;
        T t;
        BoundType boundType;
        BoundType boundType2;
        int compare3;
        Preconditions.checkNotNull(generalRange);
        Preconditions.checkArgument(this.comparator.equals(generalRange.comparator));
        boolean z = this.hasLowerBound;
        T lowerEndpoint = getLowerEndpoint();
        BoundType lowerBoundType = getLowerBoundType();
        if (!hasLowerBound()) {
            z = generalRange.hasLowerBound;
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        } else if (generalRange.hasLowerBound() && ((compare = this.comparator.compare(getLowerEndpoint(), generalRange.getLowerEndpoint())) < 0 || (compare == 0 && generalRange.getLowerBoundType() == BoundType.OPEN))) {
            lowerEndpoint = generalRange.getLowerEndpoint();
            lowerBoundType = generalRange.getLowerBoundType();
        }
        boolean z2 = z;
        boolean z3 = this.hasUpperBound;
        T upperEndpoint = getUpperEndpoint();
        BoundType upperBoundType = getUpperBoundType();
        if (!hasUpperBound()) {
            z3 = generalRange.hasUpperBound;
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        } else if (generalRange.hasUpperBound() && ((compare2 = this.comparator.compare(getUpperEndpoint(), generalRange.getUpperEndpoint())) > 0 || (compare2 == 0 && generalRange.getUpperBoundType() == BoundType.OPEN))) {
            upperEndpoint = generalRange.getUpperEndpoint();
            upperBoundType = generalRange.getUpperBoundType();
        }
        boolean z4 = z3;
        T t2 = upperEndpoint;
        if (z2 && z4 && ((compare3 = this.comparator.compare(lowerEndpoint, t2)) > 0 || (compare3 == 0 && lowerBoundType == BoundType.OPEN && upperBoundType == BoundType.OPEN))) {
            boundType = BoundType.OPEN;
            boundType2 = BoundType.CLOSED;
            t = t2;
        } else {
            t = lowerEndpoint;
            boundType = lowerBoundType;
            boundType2 = upperBoundType;
        }
        return new GeneralRange<>(this.comparator, z2, t, boundType, z4, t2, boundType2);
    }

    public boolean equals(@NullableDecl Object obj) {
        if (!(obj instanceof GeneralRange)) {
            return false;
        }
        GeneralRange generalRange = (GeneralRange) obj;
        return this.comparator.equals(generalRange.comparator) && this.hasLowerBound == generalRange.hasLowerBound && this.hasUpperBound == generalRange.hasUpperBound && getLowerBoundType().equals(generalRange.getLowerBoundType()) && getUpperBoundType().equals(generalRange.getUpperBoundType()) && Objects.equal(getLowerEndpoint(), generalRange.getLowerEndpoint()) && Objects.equal(getUpperEndpoint(), generalRange.getUpperEndpoint());
    }

    public int hashCode() {
        return Objects.hashCode(this.comparator, getLowerEndpoint(), getLowerBoundType(), getUpperEndpoint(), getUpperBoundType());
    }

    GeneralRange<T> reverse() {
        GeneralRange<T> generalRange = this.reverse;
        if (generalRange != null) {
            return generalRange;
        }
        GeneralRange<T> generalRange2 = new GeneralRange<>(Ordering.from(this.comparator).reverse(), this.hasUpperBound, getUpperEndpoint(), getUpperBoundType(), this.hasLowerBound, getLowerEndpoint(), getLowerBoundType());
        generalRange2.reverse = this;
        this.reverse = generalRange2;
        return generalRange2;
    }

    public String toString() {
        return this.comparator + ":" + (this.lowerBoundType == BoundType.CLOSED ? PropertyUtils.INDEXED_DELIM : PropertyUtils.MAPPED_DELIM) + (this.hasLowerBound ? this.lowerEndpoint : "-∞") + ',' + (this.hasUpperBound ? this.upperEndpoint : "∞") + (this.upperBoundType == BoundType.CLOSED ? PropertyUtils.INDEXED_DELIM2 : PropertyUtils.MAPPED_DELIM2);
    }

    T getLowerEndpoint() {
        return this.lowerEndpoint;
    }

    BoundType getLowerBoundType() {
        return this.lowerBoundType;
    }

    T getUpperEndpoint() {
        return this.upperEndpoint;
    }

    BoundType getUpperBoundType() {
        return this.upperBoundType;
    }
}
