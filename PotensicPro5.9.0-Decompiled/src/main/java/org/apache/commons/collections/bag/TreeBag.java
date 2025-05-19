package org.apache.commons.collections.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import org.apache.commons.collections.SortedBag;

/* loaded from: classes4.dex */
public class TreeBag extends AbstractMapBag implements SortedBag, Serializable {
    private static final long serialVersionUID = -7740146511091606676L;

    public TreeBag() {
        super(new TreeMap());
    }

    public TreeBag(Comparator comparator) {
        super(new TreeMap(comparator));
    }

    public TreeBag(Collection collection) {
        this();
        addAll(collection);
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object first() {
        return ((SortedMap) getMap()).firstKey();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Object last() {
        return ((SortedMap) getMap()).lastKey();
    }

    @Override // org.apache.commons.collections.SortedBag
    public Comparator comparator() {
        return ((SortedMap) getMap()).comparator();
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(comparator());
        super.doWriteObject(objectOutputStream);
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        super.doReadObject(new TreeMap((Comparator) objectInputStream.readObject()), objectInputStream);
    }
}
