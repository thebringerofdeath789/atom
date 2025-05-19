package org.apache.commons.collections.iterators;

import java.util.ListIterator;

/* loaded from: classes4.dex */
public class ProxyListIterator implements ListIterator {
    private ListIterator iterator;

    public ProxyListIterator() {
    }

    public ProxyListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }

    @Override // java.util.ListIterator
    public void add(Object obj) {
        getListIterator().add(obj);
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public boolean hasNext() {
        return getListIterator().hasNext();
    }

    @Override // java.util.ListIterator
    public boolean hasPrevious() {
        return getListIterator().hasPrevious();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public Object next() {
        return getListIterator().next();
    }

    @Override // java.util.ListIterator
    public int nextIndex() {
        return getListIterator().nextIndex();
    }

    @Override // java.util.ListIterator
    public Object previous() {
        return getListIterator().previous();
    }

    @Override // java.util.ListIterator
    public int previousIndex() {
        return getListIterator().previousIndex();
    }

    @Override // java.util.ListIterator, java.util.Iterator
    public void remove() {
        getListIterator().remove();
    }

    @Override // java.util.ListIterator
    public void set(Object obj) {
        getListIterator().set(obj);
    }

    public ListIterator getListIterator() {
        return this.iterator;
    }

    public void setListIterator(ListIterator listIterator) {
        this.iterator = listIterator;
    }
}
