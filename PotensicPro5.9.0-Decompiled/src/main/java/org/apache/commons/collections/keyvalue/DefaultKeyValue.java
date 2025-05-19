package org.apache.commons.collections.keyvalue;

import java.util.Map;
import org.apache.commons.collections.KeyValue;

/* loaded from: classes4.dex */
public class DefaultKeyValue extends AbstractKeyValue {
    public DefaultKeyValue() {
        super(null, null);
    }

    public DefaultKeyValue(Object obj, Object obj2) {
        super(obj, obj2);
    }

    public DefaultKeyValue(KeyValue keyValue) {
        super(keyValue.getKey(), keyValue.getValue());
    }

    public DefaultKeyValue(Map.Entry entry) {
        super(entry.getKey(), entry.getValue());
    }

    public Object setKey(Object obj) {
        if (obj == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a key.");
        }
        Object obj2 = this.key;
        this.key = obj;
        return obj2;
    }

    public Object setValue(Object obj) {
        if (obj == this) {
            throw new IllegalArgumentException("DefaultKeyValue may not contain itself as a value.");
        }
        Object obj2 = this.value;
        this.value = obj;
        return obj2;
    }

    public Map.Entry toMapEntry() {
        return new DefaultMapEntry(this);
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof DefaultKeyValue)) {
            return false;
        }
        DefaultKeyValue defaultKeyValue = (DefaultKeyValue) obj;
        if (getKey() != null ? getKey().equals(defaultKeyValue.getKey()) : defaultKeyValue.getKey() == null) {
            if (getValue() == null) {
                if (defaultKeyValue.getValue() == null) {
                    return true;
                }
            } else if (getValue().equals(defaultKeyValue.getValue())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return (getKey() == null ? 0 : getKey().hashCode()) ^ (getValue() != null ? getValue().hashCode() : 0);
    }
}
