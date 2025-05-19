package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class ReverseComparator implements Comparator, Serializable {
    private static final long serialVersionUID = 2858887242028539265L;
    private Comparator comparator;

    public ReverseComparator() {
        this(null);
    }

    public ReverseComparator(Comparator comparator) {
        if (comparator != null) {
            this.comparator = comparator;
        } else {
            this.comparator = ComparableComparator.getInstance();
        }
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return this.comparator.compare(obj2, obj);
    }

    public int hashCode() {
        return this.comparator.hashCode() ^ 175311160;
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && obj.getClass().equals(getClass())) {
            return this.comparator.equals(((ReverseComparator) obj).comparator);
        }
        return false;
    }
}
