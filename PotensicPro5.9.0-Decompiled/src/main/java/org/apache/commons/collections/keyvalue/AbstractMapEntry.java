package org.apache.commons.collections.keyvalue;

import java.util.Map;

/* loaded from: classes4.dex */
public abstract class AbstractMapEntry extends AbstractKeyValue implements Map.Entry {
    protected AbstractMapEntry(Object obj, Object obj2) {
        super(obj, obj2);
    }

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
}
