package org.apache.commons.collections;

import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

/* loaded from: classes4.dex */
public class TreeBag extends DefaultMapBag implements SortedBag {
    public TreeBag() {
        super(new TreeMap());
    }

    public TreeBag(Comparator comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection collection) {
        this();
        addAll(collection);
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object first() {
        return ((SortedMap) getMap()).firstKey();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return ((SortedMap) getMap()).lastKey();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Comparator comparator() {
        return ((SortedMap) getMap()).comparator();
    }
}
