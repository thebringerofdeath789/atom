package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class SingletonIterator implements Iterator, ResettableIterator {
    private boolean beforeFirst;
    private Object object;
    private final boolean removeAllowed;
    private boolean removed;

    public SingletonIterator(Object obj) {
        this(obj, true);
    }

    public SingletonIterator(Object obj, boolean z) {
        this.beforeFirst = true;
        this.removed = false;
        this.object = obj;
        this.removeAllowed = z;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.beforeFirst && !this.removed;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.beforeFirst || this.removed) {
            throw new NoSuchElementException();
        }
        this.beforeFirst = false;
        return this.object;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.removeAllowed) {
            if (this.removed || this.beforeFirst) {
                throw new IllegalStateException();
            }
            this.object = null;
            this.removed = true;
            return;
        }
        throw new UnsupportedOperationException();
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.beforeFirst = true;
    }
}
