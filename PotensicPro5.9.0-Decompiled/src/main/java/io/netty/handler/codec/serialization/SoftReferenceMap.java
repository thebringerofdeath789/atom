package io.netty.handler.codec.serialization;

import java.lang.ref.Reference;
import java.lang.ref.SoftReference;
import java.util.Map;

/* loaded from: classes3.dex */
final class SoftReferenceMap<K, V> extends ReferenceMap<K, V> {
    SoftReferenceMap(Map<K, Reference<V>> map) {
        super(map);
    }

    @Override // io.netty.handler.codec.serialization.ReferenceMap
    Reference<V> fold(V v) {
        return new SoftReference(v);
    }
}
