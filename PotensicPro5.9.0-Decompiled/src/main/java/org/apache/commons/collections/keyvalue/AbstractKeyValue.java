package org.apache.commons.collections.keyvalue;

import org.apache.commons.collections.KeyValue;

/* loaded from: classes4.dex */
public abstract class AbstractKeyValue implements KeyValue {
    protected Object key;
    protected Object value;

    protected AbstractKeyValue(Object obj, Object obj2) {
        this.key = obj;
        this.value = obj2;
    }

    @Override // org.apache.commons.collections.KeyValue
    public Object getKey() {
        return this.key;
    }

    @Override // org.apache.commons.collections.KeyValue
    public Object getValue() {
        return this.value;
    }

    public String toString() {
        return new StringBuffer().append(getKey()).append('=').append(getValue()).toString();
    }
}
