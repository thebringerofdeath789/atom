package org.apache.commons.collections.list;

import java.util.Collection;
import java.util.List;
import java.util.ListIterator;
import org.apache.commons.collections.collection.AbstractCollectionDecorator;

/* loaded from: classes4.dex */
public abstract class AbstractListDecorator extends AbstractCollectionDecorator implements List {
    protected AbstractListDecorator() {
    }

    protected AbstractListDecorator(List list) {
        super(list);
    }

    protected List getList() {
        return (List) getCollection();
    }

    @Override // java.util.List
    public void add(int i, Object obj) {
        getList().add(i, obj);
    }

    @Override // java.util.List
    public boolean addAll(int i, Collection collection) {
        return getList().addAll(i, collection);
    }

    @Override // java.util.List
    public Object get(int i) {
        return getList().get(i);
    }

    @Override // java.util.List
    public int indexOf(Object obj) {
        return getList().indexOf(obj);
    }

    @Override // java.util.List
    public int lastIndexOf(Object obj) {
        return getList().lastIndexOf(obj);
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
        return getList().remove(i);
    }

    @Override // java.util.List
    public Object set(int i, Object obj) {
        return getList().set(i, obj);
    }

    @Override // java.util.List
    public List subList(int i, int i2) {
        return getList().subList(i, i2);
    }
}
