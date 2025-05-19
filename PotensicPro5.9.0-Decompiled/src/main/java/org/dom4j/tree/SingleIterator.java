package org.dom4j.tree;

import java.util.Iterator;

/* loaded from: classes5.dex */
public class SingleIterator implements Iterator {
    private boolean first = true;
    private Object object;

    public SingleIterator(Object obj) {
        this.object = obj;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.first;
    }

    @Override // java.util.Iterator
    public Object next() {
        Object obj = this.object;
        this.object = null;
        this.first = false;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() is not supported by this iterator");
    }
}
