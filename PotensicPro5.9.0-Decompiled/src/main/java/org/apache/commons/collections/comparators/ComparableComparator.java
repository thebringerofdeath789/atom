package org.apache.commons.collections.comparators;

import java.io.Serializable;
import java.util.Comparator;

/* loaded from: classes4.dex */
public class ComparableComparator implements Comparator, Serializable {
    private static final ComparableComparator instance = new ComparableComparator();
    private static final long serialVersionUID = -291439688585137865L;

    public int hashCode() {
        return 1769708912;
    }

    public static ComparableComparator getInstance() {
        return instance;
    }

    @Override // java.util.Comparator
    public int compare(Object obj, Object obj2) {
        return ((Comparable) obj).compareTo(obj2);
    }

    @Override // java.util.Comparator
    public boolean equals(Object obj) {
        return this == obj || (obj != null && obj.getClass().equals(getClass()));
    }
}
