package org.apache.commons.collections4;

import java.util.Set;

/* loaded from: classes4.dex */
public interface BidiMap<K, V> extends IterableMap<K, V> {
    K getKey(Object obj);

    BidiMap<V, K> inverseBidiMap();

    @Override // java.util.Map, org.apache.commons.collections4.Put
    V put(K k, V v);

    K removeValue(Object obj);

    @Override // java.util.Map, org.apache.commons.collections4.Get
    Set<V> values();
}
