package org.apache.commons.collections4.bag;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.Iterator;
import org.apache.commons.collections4.Bag;

/* loaded from: classes4.dex */
public final class CollectionBag<E> extends AbstractBagDecorator<E> {
    private static final long serialVersionUID = -2560033712679053143L;

    public static <E> Bag<E> collectionBag(Bag<E> bag) {
        return new CollectionBag(bag);
    }

    public CollectionBag(Bag<E> bag) {
        super(bag);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.defaultWriteObject();
        objectOutputStream.writeObject(decorated());
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        objectInputStream.defaultReadObject();
        setCollection((Collection) objectInputStream.readObject());
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean containsAll(Collection<?> collection) {
        Iterator<?> it = collection.iterator();
        while (it.hasNext()) {
            if (!contains(it.next())) {
                return false;
            }
        }
        return true;
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean add(E e) {
        return add(e, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection
    public boolean addAll(Collection<? extends E> collection) {
        Iterator<? extends E> it = collection.iterator();
        while (true) {
            boolean z = false;
            while (it.hasNext()) {
                boolean add = add(it.next(), 1);
                if (z || add) {
                    z = true;
                }
            }
            return z;
        }
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean remove(Object obj) {
        return remove(obj, 1);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean removeAll(Collection<?> collection) {
        boolean z;
        if (collection != null) {
            while (true) {
                for (Object obj : collection) {
                    z = z || remove(obj, getCount(obj));
                }
                return z;
            }
        }
        return decorated().removeAll(null);
    }

    @Override // org.apache.commons.collections4.collection.AbstractCollectionDecorator, java.util.Collection, org.apache.commons.collections4.Bag
    public boolean retainAll(Collection<?> collection) {
        if (collection != null) {
            boolean z = false;
            Iterator<E> it = iterator();
            while (it.hasNext()) {
                if (!collection.contains(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }
        return decorated().retainAll(null);
    }

    @Override // org.apache.commons.collections4.bag.AbstractBagDecorator, org.apache.commons.collections4.Bag
    public boolean add(E e, int i) {
        decorated().add(e, i);
        return true;
    }
}
