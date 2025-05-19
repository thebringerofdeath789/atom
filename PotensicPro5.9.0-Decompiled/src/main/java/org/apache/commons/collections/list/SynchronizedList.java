package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.collection.SynchronizedCollection;

/* loaded from: classes4.dex */
public class SynchronizedList extends SynchronizedCollection implements List {
    private static final long serialVersionUID = -1403835447328619437L;

    public static List decorate(List list) {
        return new SynchronizedList(list);
    }

    protected SynchronizedList(List list) {
        super(list);
    }

    protected SynchronizedList(List list, Object obj) {
        super(list, obj);
    }

    protected List getList() {
        return (List) this.collection;
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        synchronized (this.lock) {
            getList().add(i, obj);
        }
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        boolean addAll;
        synchronized (this.lock) {
            addAll = getList().addAll(i, collection);
        }
        return addAll;
    }

    @Override // java.util.List
    public Object get(int i) {
        Object obj;
        synchronized (this.lock) {
            obj = getList().get(i);
        }
        return obj;
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        int indexOf;
        synchronized (this.lock) {
            indexOf = getList().indexOf(obj);
        }
        return indexOf;
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        int lastIndexOf;
        synchronized (this.lock) {
            lastIndexOf = getList().lastIndexOf(obj);
        }
        return lastIndexOf;
    }

    @Override // java.util.List
    public ListIterator listIterator() {
        return getList().listIterator();
    }

    @Override // java.util.List
    public ListIterator listIterator(int i) {
        return getList().listIterator(i);
    }

    @Override // java.util.List
    public Object remove(int i) {
        Object remove;
        synchronized (this.lock) {
            remove = getList().remove(i);
        }
        return remove;
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        Object obj2;
        synchronized (this.lock) {
            obj2 = getList().set(i, obj);
        }
        return obj2;
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        SynchronizedList synchronizedList;
        synchronized (this.lock) {
            synchronizedList = new SynchronizedList(getList().subList(i, i2), this.lock);
        }
        return synchronizedList;
    }
}
