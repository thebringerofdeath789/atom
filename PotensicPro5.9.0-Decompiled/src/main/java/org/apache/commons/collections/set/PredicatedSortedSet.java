package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class PredicatedSortedSet extends PredicatedSet implements SortedSet {
    private static final long serialVersionUID = -9110948148132275052L;

    public static SortedSet decorate(SortedSet sortedSet, Predicate predicate) {
        return new PredicatedSortedSet(sortedSet, predicate);
    }

    protected PredicatedSortedSet(SortedSet sortedSet, Predicate predicate) {
        super(sortedSet, predicate);
    }

    private SortedSet getSortedSet() {
        return (SortedSet) getCollection();
    }

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return new PredicatedSortedSet(getSortedSet().subSet(obj, obj2), this.predicate);
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return new PredicatedSortedSet(getSortedSet().headSet(obj), this.predicate);
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return new PredicatedSortedSet(getSortedSet().tailSet(obj), this.predicate);
    }

    @Override // java.util.SortedSet
    public Object first() {
        return getSortedSet().first();
    }

    @Override // java.util.SortedSet
    public Object last() {
        return getSortedSet().last();
    }

    @Override // java.util.SortedSet
    public Comparator comparator() {
        return getSortedSet().comparator();
    }
}
