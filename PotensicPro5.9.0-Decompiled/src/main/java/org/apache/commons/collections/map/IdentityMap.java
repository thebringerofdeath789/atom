package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;
import org.apache.commons.collections.map.AbstractHashedMap;

/* loaded from: classes4.dex */
public class IdentityMap extends AbstractHashedMap implements Serializable, Cloneable {
    private static final long serialVersionUID = 2028493495224302329L;

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected boolean isEqualKey(Object obj, Object obj2) {
        return obj == obj2;
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public IdentityMap() {
        super(16, 0.75f, 12);
    }

    public IdentityMap(int i) {
        super(i);
    }

    public IdentityMap(int i, float f) {
        super(i, f);
    }

    public IdentityMap(Map map) {
        super(map);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected AbstractHashedMap.HashEntry createEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
        return new IdentityEntry(hashEntry, i, obj, obj2);
    }

    protected static class IdentityEntry extends AbstractHashedMap.HashEntry {
        protected IdentityEntry(AbstractHashedMap.HashEntry hashEntry, int i, Object obj, Object obj2) {
            super(hashEntry, i, obj, obj2);
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof Map.Entry)) {
                return false;
            }
            Map.Entry entry = (Map.Entry) obj;
            return getKey() == entry.getKey() && getValue() == entry.getValue();
        }

        @Override // org.apache.commons.collections.map.AbstractHashedMap.HashEntry, java.util.Map.Entry
        public int hashCode() {
            return System.identityHashCode(getKey()) ^ System.identityHashCode(getValue());
        }
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap, java.util.AbstractMap
    public Object clone() {
        return super.clone();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        doReadObject(objectInputStream);
    }
}
