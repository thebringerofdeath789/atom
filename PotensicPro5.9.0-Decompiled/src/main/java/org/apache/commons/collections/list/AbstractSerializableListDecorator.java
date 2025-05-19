package org.apache.commons.collections.list;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;

/* loaded from: classes4.dex */
public abstract class AbstractSerializableListDecorator extends AbstractListDecorator implements Serializable {
    private static final long serialVersionUID = 2684959196747496299L;

    protected AbstractSerializableListDecorator(List list) {
        super(list);
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
