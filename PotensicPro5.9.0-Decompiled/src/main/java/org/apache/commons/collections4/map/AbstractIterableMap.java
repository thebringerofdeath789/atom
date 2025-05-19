package org.apache.commons.collections4.map;

import org.apache.commons.collections4.IterableMap;
import org.apache.commons.collections4.MapIterator;

/* loaded from: classes4.dex */
public abstract class AbstractIterableMap<K, V> implements IterableMap<K, V> {
    public MapIterator<K, V> mapIterator() {
        return new EntrySetToMapIteratorAdapter(entrySet());
    }
}
