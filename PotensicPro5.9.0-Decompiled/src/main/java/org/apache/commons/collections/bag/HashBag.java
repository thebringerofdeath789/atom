package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.HashMap;
import org.apache.commons.collections.Bag;

/* loaded from: classes4.dex */
public class HashBag extends AbstractMapBag implements Bag, Serializable {
    private static final long serialVersionUID = -6561115435802554013L;

    public HashBag() {
        super(new HashMap());
    }

    public HashBag(Collection collection) {
        this();
        addAll(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        super.doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new HashMap(), objectInputStream);
    }
}
