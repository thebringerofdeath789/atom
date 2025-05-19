package org.apache.commons.collections.map;

import java.util.Comparator;
import java.util.SortedMap;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class PredicatedSortedMap extends PredicatedMap implements SortedMap {
    private static final long serialVersionUID = 3359846175935304332L;

    public static SortedMap decorate(SortedMap sortedMap, Predicate predicate, Predicate predicate2) {
        return new PredicatedSortedMap(sortedMap, predicate, predicate2);
    }

    protected PredicatedSortedMap(SortedMap sortedMap, Predicate predicate, Predicate predicate2) {
        super(sortedMap, predicate, predicate2);
    }

    protected SortedMap getSortedMap() {
        return (SortedMap) this.map;
    }

    @Override // java.util.SortedMap
    public Object firstKey() {
        return getSortedMap().firstKey();
    }

    @Override // java.util.SortedMap
    public Object lastKey() {
        return getSortedMap().lastKey();
    }

    @Override // java.util.SortedMap
    public Comparator comparator() {
        return getSortedMap().comparator();
    }

    @Override // java.util.SortedMap
    public SortedMap subMap(Object obj, Object obj2) {
        return new PredicatedSortedMap(getSortedMap().subMap(obj, obj2), this.keyPredicate, this.valuePredicate);
    }

    @Override // java.util.SortedMap
    public SortedMap headMap(Object obj) {
        return new PredicatedSortedMap(getSortedMap().headMap(obj), this.keyPredicate, this.valuePredicate);
    }

    @Override // java.util.SortedMap
    public SortedMap tailMap(Object obj) {
        return new PredicatedSortedMap(getSortedMap().tailMap(obj), this.keyPredicate, this.valuePredicate);
    }
}
