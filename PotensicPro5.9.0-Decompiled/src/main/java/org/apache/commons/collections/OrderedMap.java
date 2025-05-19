package org.apache.commons.collections;

/* loaded from: classes4.dex */
public interface OrderedMap extends IterableMap {
    Object firstKey();

    Object lastKey();

    Object nextKey(Object obj);

    OrderedMapIterator orderedMapIterator();

    Object previousKey(Object obj);
}
