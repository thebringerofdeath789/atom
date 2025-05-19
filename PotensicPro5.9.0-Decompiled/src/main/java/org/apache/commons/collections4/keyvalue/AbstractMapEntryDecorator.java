package org.apache.commons.collections4.keyvalue;

import java.util.Map;
import java.util.Objects;
import org.apache.commons.collections4.KeyValue;

/* loaded from: classes4.dex */
public abstract class AbstractMapEntryDecorator<K, V> implements Map.Entry<K, V>, KeyValue<K, V> {
    private final Map.Entry<K, V> entry;

    public AbstractMapEntryDecorator(Map.Entry<K, V> entry) {
        Objects.requireNonNull(entry, "Map Entry must not be null.");
        this.entry = entry;
    }

    protected Map.Entry<K, V> getMapEntry() {
        return this.entry;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public K getKey() {
        return this.entry.getKey();
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections4.KeyValue
    public V getValue() {
        return this.entry.getValue();
    }

    @Override // java.util.Map.Entry
    public V setValue(V v) {
        return this.entry.setValue(v);
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        return this.entry.equals(obj);
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return this.entry.hashCode();
    }

    public String toString() {
        return this.entry.toString();
    }
}
