package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

/* loaded from: classes4.dex */
public abstract class AbstractMapEntryDecorator implements Map.Entry, KeyValue {
    protected final Map.Entry entry;

    public AbstractMapEntryDecorator(Map.Entry entry) {
        if (entry == null) {
            throw new IllegalArgumentException("Map Entry must not be null");
        }
        this.entry = entry;
    }

    protected Map.Entry getMapEntry() {
        return this.entry;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
    public Object getKey() {
        return this.entry.getKey();
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
    public Object getValue() {
        return this.entry.getValue();
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        return this.entry.setValue(obj);
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
