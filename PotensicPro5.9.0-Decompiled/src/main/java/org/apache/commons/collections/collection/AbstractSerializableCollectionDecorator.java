package org.apache.commons.collections.collection;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;

/* loaded from: classes4.dex */
public abstract class AbstractSerializableCollectionDecorator extends AbstractCollectionDecorator implements Serializable {
    private static final long serialVersionUID = 6249888059822088500L;

    protected AbstractSerializableCollectionDecorator(Collection collection) {
        super(collection);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(this.collection);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        this.collection = (Collection) objectInputStream.readObject();
    }
}
