package org.apache.commons.collections;

import org.apache.commons.collections.bag.PredicatedBag;
import org.apache.commons.collections.bag.PredicatedSortedBag;
import org.apache.commons.collections.bag.SynchronizedBag;
import org.apache.commons.collections.bag.SynchronizedSortedBag;
import org.apache.commons.collections.bag.TransformedBag;
import org.apache.commons.collections.bag.TransformedSortedBag;
import org.apache.commons.collections.bag.TypedBag;
import org.apache.commons.collections.bag.TypedSortedBag;
import org.apache.commons.collections.bag.UnmodifiableBag;
import org.apache.commons.collections.bag.UnmodifiableSortedBag;

/* loaded from: classes4.dex */
public class BagUtils {
    public static final Bag EMPTY_BAG = UnmodifiableBag.decorate(new org.apache.commons.collections.bag.HashBag());
    public static final Bag EMPTY_SORTED_BAG = UnmodifiableSortedBag.decorate(new org.apache.commons.collections.bag.TreeBag());

    public static Bag synchronizedBag(Bag bag) {
        return SynchronizedBag.decorate(bag);
    }

    public static Bag unmodifiableBag(Bag bag) {
        return UnmodifiableBag.decorate(bag);
    }

    public static Bag predicatedBag(Bag bag, Predicate predicate) {
        return PredicatedBag.decorate(bag, predicate);
    }

    public static Bag typedBag(Bag bag, Class cls) {
        return TypedBag.decorate(bag, cls);
    }

    public static Bag transformedBag(Bag bag, Transformer transformer) {
        return TransformedBag.decorate(bag, transformer);
    }

    public static SortedBag synchronizedSortedBag(SortedBag sortedBag) {
        return SynchronizedSortedBag.decorate(sortedBag);
    }

    public static SortedBag unmodifiableSortedBag(SortedBag sortedBag) {
        return UnmodifiableSortedBag.decorate(sortedBag);
    }

    public static SortedBag predicatedSortedBag(SortedBag sortedBag, Predicate predicate) {
        return PredicatedSortedBag.decorate(sortedBag, predicate);
    }

    public static SortedBag typedSortedBag(SortedBag sortedBag, Class cls) {
        return TypedSortedBag.decorate(sortedBag, cls);
    }

    public static SortedBag transformedSortedBag(SortedBag sortedBag, Transformer transformer) {
        return TransformedSortedBag.decorate(sortedBag, transformer);
    }
}
