package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.Predicate;
import org.apache.commons.collections.SortedBag;

/* loaded from: classes4.dex */
public class PredicatedSortedBag extends PredicatedBag implements SortedBag {
    private static final long serialVersionUID = 3448581314086406616L;

    public static SortedBag decorate(SortedBag sortedBag, Predicate predicate) {
        return new PredicatedSortedBag(sortedBag, predicate);
    }

    protected PredicatedSortedBag(SortedBag sortedBag, Predicate predicate) {
        super(sortedBag, predicate);
    }

    protected SortedBag getSortedBag() {
        return (SortedBag) getCollection();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object first() {
        return getSortedBag().first();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return getSortedBag().last();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Comparator comparator() {
        return getSortedBag().comparator();
    }
}
