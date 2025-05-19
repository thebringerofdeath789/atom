package org.apache.commons.collections.set;

import java.util.Comparator;
import java.util.SortedSet;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class TransformedSortedSet extends TransformedSet implements SortedSet {
    private static final long serialVersionUID = -1675486811351124386L;

    public static SortedSet decorate(SortedSet sortedSet, Transformer transformer) {
        return new TransformedSortedSet(sortedSet, transformer);
    }

    protected TransformedSortedSet(SortedSet sortedSet, Transformer transformer) {
        super(sortedSet, transformer);
    }

    protected SortedSet getSortedSet() {
        return (SortedSet) this.collection;
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

    @Override // java.util.SortedSet
    public SortedSet subSet(Object obj, Object obj2) {
        return new TransformedSortedSet(getSortedSet().subSet(obj, obj2), this.transformer);
    }

    @Override // java.util.SortedSet
    public SortedSet headSet(Object obj) {
        return new TransformedSortedSet(getSortedSet().headSet(obj), this.transformer);
    }

    @Override // java.util.SortedSet
    public SortedSet tailSet(Object obj) {
        return new TransformedSortedSet(getSortedSet().tailSet(obj), this.transformer);
    }
}
