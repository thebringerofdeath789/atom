package org.apache.commons.collections;

import java.util.Map;

/* loaded from: classes4.dex */
public class DefaultMapEntry implements Map.Entry, KeyValue {
    private Object key;
    private Object value;

    public DefaultMapEntry() {
    }

    public DefaultMapEntry(Map.Entry entry) {
        this.key = entry.getKey();
        this.value = entry.getValue();
    }

    public DefaultMapEntry(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
    public Object getKey() {
        return this.key;
    }

    public void setKey(Object obj) {
        this.key = obj;
    }

    @Override // java.util.Map.Entry, org.apache.commons.collections.KeyValue
    public Object getValue() {
        return this.value;
    }

    @Override // java.util.Map.Entry
    public Object setValue(Object obj) {
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    @Override // java.util.Map.Entry
    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        if (getKey() != null ? getKey().equals(entry.getKey()) : entry.getKey() == null) {
            if (getValue() == null) {
                if (entry.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(entry.getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }

    public String toString() {
        return new StringBuffer().append("").append(getKey()).append("=").append(getValue()).toString();
    }
}
