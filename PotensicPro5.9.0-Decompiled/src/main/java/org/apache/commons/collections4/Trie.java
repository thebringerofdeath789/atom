package org.apache.commons.collections4;

import java.util.SortedMap;

/* loaded from: classes4.dex */
public interface Trie<K, V> extends IterableSortedMap<K, V> {
    SortedMap<K, V> prefixMap(K k);
}
