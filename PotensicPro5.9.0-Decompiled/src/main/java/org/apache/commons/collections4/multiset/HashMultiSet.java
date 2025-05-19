package org.apache.commons.collections4.multiset;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;

/* loaded from: classes4.dex */
public class HashMultiSet<E> extends AbstractMapMultiSet<E> implements Serializable {
    private static final long serialVersionUID = 20150610;

    public HashMultiSet() {
        super(new HashMap());
    }

    public HashMultiSet(Collection<? extends E> collection) {
        this();
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        super.doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setMap(new HashMap());
        super.doReadObject(objectInputStream);
    }
}
