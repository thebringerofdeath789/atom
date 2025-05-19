package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes4.dex */
public class HashedMap<K, V> extends AbstractHashedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -1788199231038721040L;

    public HashedMap() {
        super(16, 0.75f, 12);
    }

    public HashedMap(int i) {
        super(i);
    }

    public HashedMap(int i, float f) {
        super(i, f);
    }

    public HashedMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public HashedMap<K, V> clone() {
        return (HashedMap) super.clone();
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
