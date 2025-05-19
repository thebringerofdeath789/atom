package org.dom4j.tree;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
public abstract class FilterIterator implements Iterator {
    private boolean first = true;
    private Object next;
    protected Iterator proxy;

    protected abstract boolean matches(Object obj);

    public FilterIterator(Iterator it) {
        this.proxy = it;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.first) {
            this.next = findNext();
            this.first = false;
        }
        return this.next != null;
    }

    @Override // java.util.Iterator
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.next;
        this.next = findNext();
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }

    protected Object findNext() {
        if (this.proxy != null) {
            while (this.proxy.hasNext()) {
                Object next = this.proxy.next();
                if (next != null && matches(next)) {
                    return next;
                }
            }
            this.proxy = null;
        }
        return null;
    }
}
