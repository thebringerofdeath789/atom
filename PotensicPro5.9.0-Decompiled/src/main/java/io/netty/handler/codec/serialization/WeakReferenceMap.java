package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.WeakReference;
import java.util.Map;

/* loaded from: classes3.dex */
final class WeakReferenceMap<K, V> extends ReferenceMap<K, V> {
    WeakReferenceMap(Map<K, Reference<V>> map) {
        super(map);
    }

    @Override // io.netty.handler.codec.serialization.ReferenceMap
    Reference<V> fold(V v) {
        return new WeakReference(v);
    }
}
