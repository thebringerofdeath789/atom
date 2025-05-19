package com.google.common.collect;

import java.util.Map;
import java.util.Set;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public interface BiMap<K, V> extends Map<K, V> {
    @NullableDecl
    V forcePut(@NullableDecl K k, @NullableDecl V v);

    BiMap<V, K> inverse();

    @NullableDecl
    V put(@NullableDecl K k, @NullableDecl V v);

    void putAll(Map<? extends K, ? extends V> map);

    @Override // java.util.Map
    Set<V> values();
}
