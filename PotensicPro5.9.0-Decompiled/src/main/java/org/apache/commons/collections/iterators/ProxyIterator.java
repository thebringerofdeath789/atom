package org.apache.commons.collections.iterators;

import java.util.Iterator;

/* loaded from: classes4.dex */
public class ProxyIterator implements Iterator {
    private Iterator iterator;

    public ProxyIterator() {
    }

    public ProxyIterator(Iterator it) {
        this.iterator = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return getIterator().hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        return getIterator().next();
    }

    @Override // java.util.Iterator
    public void remove() {
        getIterator().remove();
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
    }
}
