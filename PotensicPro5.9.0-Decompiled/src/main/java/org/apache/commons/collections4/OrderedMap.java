package org.apache.commons.collections4;

/* loaded from: classes4.dex */
public interface OrderedMap<K, V> extends IterableMap<K, V> {
    K firstKey();

    K lastKey();

    @Override // org.apache.commons.collections4.IterableGet
    OrderedMapIterator<K, V> mapIterator();

    K nextKey(K k);

    K previousKey(K k);
}
