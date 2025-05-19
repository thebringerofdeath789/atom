package org.apache.commons.collections.bidimap;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections.SortedBidiMap;

/* loaded from: classes4.dex */
public abstract class AbstractSortedBidiMapDecorator extends AbstractOrderedBidiMapDecorator implements SortedBidiMap {
    public AbstractSortedBidiMapDecorator(SortedBidiMap sortedBidiMap) {
        super(sortedBidiMap);
    }

    protected SortedBidiMap getSortedBidiMap() {
        return (SortedBidiMap) this.map;
    }

    @Override // org.apache.commons.collections.SortedBidiMap
    public SortedBidiMap inverseSortedBidiMap() {
        return getSortedBidiMap().inverseSortedBidiMap();
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return getSortedBidiMap().comparator();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return getSortedBidiMap().subMap(obj, obj2);
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return getSortedBidiMap().headMap(obj);
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return getSortedBidiMap().tailMap(obj);
    }
}
