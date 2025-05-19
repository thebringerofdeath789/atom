package org.apache.commons.collections4.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Map;

/* loaded from: classes4.dex */
public class CaseInsensitiveMap<K, V> extends AbstractHashedMap<K, V> implements Serializable, Cloneable {
    private static final long serialVersionUID = -7074655917369299456L;

    public CaseInsensitiveMap() {
        super(16, 0.75f, 12);
    }

    public CaseInsensitiveMap(int i) {
        super(i);
    }

    public CaseInsensitiveMap(int i, float f) {
        super(i, f);
    }

    public CaseInsensitiveMap(Map<? extends K, ? extends V> map) {
        super(map);
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap
    protected Object convertKey(Object obj) {
        if (obj != null) {
            char[] charArray = obj.toString().toCharArray();
            for (int length = charArray.length - 1; length >= 0; length--) {
                charArray[length] = Character.toLowerCase(Character.toUpperCase(charArray[length]));
            }
            return new String(charArray);
        }
        return AbstractHashedMap.NULL;
    }

    @Override // org.apache.commons.collections4.map.AbstractHashedMap, java.util.AbstractMap
    public CaseInsensitiveMap<K, V> clone() {
        return (CaseInsensitiveMap) super.clone();
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
