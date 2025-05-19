package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.Bag;
import org.apache.commons.collections.SortedBag;

/* loaded from: classes4.dex */
public class SynchronizedSortedBag extends SynchronizedBag implements SortedBag {
    private static final long serialVersionUID = 722374056718497858L;

    public static SortedBag decorate(SortedBag sortedBag) {
        return new SynchronizedSortedBag(sortedBag);
    }

    protected SynchronizedSortedBag(SortedBag sortedBag) {
        super(sortedBag);
    }

    protected SynchronizedSortedBag(Bag bag, Object obj) {
        super(bag, obj);
    }

    protected SortedBag getSortedBag() {
        return (SortedBag) this.collection;
    }

    @Override // org.apache.commons.collections.SortedBag
    public synchronized Object first() {
        Object first;
        synchronized (this.lock) {
            first = getSortedBag().first();
        }
        return first;
    }

    @Override // org.apache.commons.collections.SortedBag
    public synchronized Object last() {
        Object last;
        synchronized (this.lock) {
            last = getSortedBag().last();
        }
        return last;
    }

    @Override // org.apache.commons.collections.SortedBag
    public synchronized Comparator comparator() {
        Comparator comparator;
        synchronized (this.lock) {
            comparator = getSortedBag().comparator();
        }
        return comparator;
    }
}
