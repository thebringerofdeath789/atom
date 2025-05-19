package org.apache.commons.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;
import org.apache.commons.collections.set.ListOrderedSet;
import org.apache.commons.collections.set.PredicatedSet;
import org.apache.commons.collections.set.PredicatedSortedSet;
import org.apache.commons.collections.set.SynchronizedSet;
import org.apache.commons.collections.set.SynchronizedSortedSet;
import org.apache.commons.collections.set.TransformedSet;
import org.apache.commons.collections.set.TransformedSortedSet;
import org.apache.commons.collections.set.TypedSet;
import org.apache.commons.collections.set.TypedSortedSet;
import org.apache.commons.collections.set.UnmodifiableSet;
import org.apache.commons.collections.set.UnmodifiableSortedSet;

/* loaded from: classes4.dex */
public class SetUtils {
    public static final Set EMPTY_SET = Collections.EMPTY_SET;
    public static final SortedSet EMPTY_SORTED_SET = UnmodifiableSortedSet.decorate(new TreeSet());

    public static boolean isEqualSet(Collection collection, Collection collection2) {
        if (collection == collection2) {
            return true;
        }
        if (collection == null || collection2 == null || collection.size() != collection2.size()) {
            return false;
        }
        return collection.containsAll(collection2);
    }

    public static int hashCodeForSet(Collection collection) {
        int i = 0;
        if (collection == null) {
            return 0;
        }
        for (Object obj : collection) {
            if (obj != null) {
                i += obj.hashCode();
            }
        }
        return i;
    }

    public static Set synchronizedSet(Set set) {
        return SynchronizedSet.decorate(set);
    }

    public static Set unmodifiableSet(Set set) {
        return UnmodifiableSet.decorate(set);
    }

    public static Set predicatedSet(Set set, Predicate predicate) {
        return PredicatedSet.decorate(set, predicate);
    }

    public static Set typedSet(Set set, Class cls) {
        return TypedSet.decorate(set, cls);
    }

    public static Set transformedSet(Set set, Transformer transformer) {
        return TransformedSet.decorate(set, transformer);
    }

    public static Set orderedSet(Set set) {
        return ListOrderedSet.decorate(set);
    }

    public static SortedSet synchronizedSortedSet(SortedSet sortedSet) {
        return SynchronizedSortedSet.decorate(sortedSet);
    }

    public static SortedSet unmodifiableSortedSet(SortedSet sortedSet) {
        return UnmodifiableSortedSet.decorate(sortedSet);
    }

    public static SortedSet predicatedSortedSet(SortedSet sortedSet, Predicate predicate) {
        return PredicatedSortedSet.decorate(sortedSet, predicate);
    }

    public static SortedSet typedSortedSet(SortedSet sortedSet, Class cls) {
        return TypedSortedSet.decorate(sortedSet, cls);
    }

    public static SortedSet transformedSortedSet(SortedSet sortedSet, Transformer transformer) {
        return TransformedSortedSet.decorate(sortedSet, transformer);
    }
}
