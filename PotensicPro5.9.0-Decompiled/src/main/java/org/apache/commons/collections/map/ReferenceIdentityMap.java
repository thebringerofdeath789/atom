package org.apache.commons.collections.map;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.lang.ref.Reference;

/* loaded from: classes4.dex */
public class ReferenceIdentityMap extends AbstractReferenceMap implements Serializable {
    private static final long serialVersionUID = -1266190134568365852L;

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected boolean isEqualValue(Object obj, Object obj2) {
        return obj == obj2;
    }

    public ReferenceIdentityMap() {
        super(0, 1, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(int i, int i2) {
        super(i, i2, 16, 0.75f, false);
    }

    public ReferenceIdentityMap(int i, int i2, boolean z) {
        super(i, i2, 16, 0.75f, z);
    }

    public ReferenceIdentityMap(int i, int i2, int i3, float f) {
        super(i, i2, i3, f, false);
    }

    public ReferenceIdentityMap(int i, int i2, int i3, float f, boolean z) {
        super(i, i2, i3, f, z);
    }

    @Override // org.apache.commons.collections.map.AbstractHashedMap
    protected int hash(Object obj) {
        return System.identityHashCode(obj);
    }

    @Override // org.apache.commons.collections.map.AbstractReferenceMap
    protected int hashEntry(Object obj, Object obj2) {
        return System.identityHashCode(obj) ^ System.identityHashCode(obj2);
    }

    @Override // org.apache.commons.collections.map.AbstractReferenceMap, org.apache.commons.collections.map.AbstractHashedMap
    protected boolean isEqualKey(Object obj, Object obj2) {
        if (this.keyType > 0) {
            obj2 = ((Reference) obj2).get();
        }
        return obj == obj2;
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
