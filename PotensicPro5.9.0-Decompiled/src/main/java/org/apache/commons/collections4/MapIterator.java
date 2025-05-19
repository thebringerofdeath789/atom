package org.apache.commons.collections4;

import java.util.Iterator;

/* loaded from: classes4.dex */
public interface MapIterator<K, V> extends Iterator<K> {
    K getKey();

    V getValue();

    @Override // java.util.Iterator
    boolean hasNext();

    @Override // java.util.Iterator
    K next();

    @Override // java.util.Iterator
    void remove();

    V setValue(V v);
}
