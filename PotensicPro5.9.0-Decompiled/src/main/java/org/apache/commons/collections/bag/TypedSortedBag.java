package org.apache.commons.collections.bag;

import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.functors.InstanceofPredicate;

/* loaded from: classes4.dex */
public class TypedSortedBag {
    public static SortedBag decorate(SortedBag sortedBag, Class cls) {
        return new PredicatedSortedBag(sortedBag, InstanceofPredicate.getInstance(cls));
    }

    protected TypedSortedBag() {
    }
}
