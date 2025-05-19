package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.SortedMap;

/* loaded from: classes4.dex */
public abstract class AbstractSortedMapDecorator extends AbstractMapDecorator implements SortedMap {
    protected AbstractSortedMapDecorator() {
    }

    public AbstractSortedMapDecorator(SortedMap sortedMap) {
        super(sortedMap);
    }

    protected SortedMap getSortedMap() {
        return (SortedMap) this.map;
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    public SortedMap headMap(Object obj) {
        return getSortedMap().headMap(obj);
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return getSortedMap().subMap(obj, obj2);
    }

    public SortedMap tailMap(Object obj) {
        return getSortedMap().tailMap(obj);
    }
}
