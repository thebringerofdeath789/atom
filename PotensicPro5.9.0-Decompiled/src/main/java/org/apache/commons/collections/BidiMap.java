package org.apache.commons.collections;

/* loaded from: classes4.dex */
public interface BidiMap extends IterableMap {
    Object getKey(Object obj);

    BidiMap inverseBidiMap();

    @Override // org.apache.commons.collections.IterableMap
    MapIterator mapIterator();

    @Override // java.util.Map
    Object put(Object obj, Object obj2);

    Object removeValue(Object obj);
}
