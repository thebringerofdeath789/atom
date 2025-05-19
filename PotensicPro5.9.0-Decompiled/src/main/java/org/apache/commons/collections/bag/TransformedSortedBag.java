package org.apache.commons.collections.bag;

import java.util.Comparator;
import org.apache.commons.collections.SortedBag;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class TransformedSortedBag extends TransformedBag implements SortedBag {
    private static final long serialVersionUID = -251737742649401930L;

    public static SortedBag decorate(SortedBag sortedBag, Transformer transformer) {
        return new TransformedSortedBag(sortedBag, transformer);
    }

    protected TransformedSortedBag(SortedBag sortedBag, Transformer transformer) {
        super(sortedBag, transformer);
    }

    protected SortedBag getSortedBag() {
        return (SortedBag) this.collection;
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
