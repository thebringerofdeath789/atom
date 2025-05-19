package org.apache.commons.collections.set;

import java.util.SortedSet;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* loaded from: classes4.dex */
public class TypedSortedSet {
    public static SortedSet decorate(SortedSet sortedSet, Class cls) {
        return new PredicatedSortedSet(sortedSet, InstanceofPredicate.getInstance(cls));
    }

    protected TypedSortedSet() {
    }
}
