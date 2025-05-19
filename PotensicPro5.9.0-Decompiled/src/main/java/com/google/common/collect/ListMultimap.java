package com.google.common.collect;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

/* loaded from: classes2.dex */
public interface ListMultimap<K, V> extends Multimap<K, V> {
    Map<K, Collection<V>> asMap();

    boolean equals(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    List<V> get(@NullableDecl K k);

    @Override // com.google.common.collect.Multimap
    List<V> removeAll(@NullableDecl Object obj);

    @Override // com.google.common.collect.Multimap
    List<V> replaceValues(K k, Iterable<? extends V> iterable);
}
