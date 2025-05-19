package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.Set;
import java.util.SortedSet;

/* loaded from: classes4.dex */
public abstract class AbstractSortedSetDecorator extends AbstractSetDecorator implements SortedSet {
    protected AbstractSortedSetDecorator() {
    }

    protected AbstractSortedSetDecorator(Set set) {
        super(set);
    }

    protected SortedSet getSortedSet() {
        return (SortedSet) getCollection();
    }

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return getSortedSet().subSet(obj, obj2);
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return getSortedSet().headSet(obj);
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return getSortedSet().tailSet(obj);
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
