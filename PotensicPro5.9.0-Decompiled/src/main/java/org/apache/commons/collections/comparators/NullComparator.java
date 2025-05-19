package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;
import java.util.Objects;

/* loaded from: classes4.dex */
public class NullComparator implements Comparator, Serializable {
    private static final long serialVersionUID = -5820772575483504339L;
    private Comparator nonNullComparator;
    private boolean nullsAreHigh;

    public NullComparator() {
        this(ComparableComparator.getInstance(), true);
    }

    public NullComparator(Comparator comparator) {
        this(comparator, true);
    }

    public NullComparator(boolean z) {
        this(ComparableComparator.getInstance(), z);
    }

    public NullComparator(Comparator comparator, boolean z) {
        this.nonNullComparator = comparator;
        this.nullsAreHigh = z;
        Objects.requireNonNull(comparator, "null nonNullComparator");
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        if (obj == obj2) {
            return 0;
        }
        if (obj == null) {
            return this.nullsAreHigh ? 1 : -1;
        }
        if (obj2 == null) {
            return this.nullsAreHigh ? -1 : 1;
        }
        return this.nonNullComparator.compare(obj, obj2);
    }

    public int hashCode() {
        return (this.nullsAreHigh ? -1 : 1) * this.nonNullComparator.hashCode();
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!obj.getClass().equals(getClass())) {
            return false;
        }
        NullComparator nullComparator = (NullComparator) obj;
        return this.nullsAreHigh == nullComparator.nullsAreHigh && this.nonNullComparator.equals(nullComparator.nonNullComparator);
    }
}
