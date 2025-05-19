package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ArrayStack;
import org.apache.commons.collections.Transformer;

/* loaded from: classes4.dex */
public class ObjectGraphIterator implements Iterator {
    protected Iterator currentIterator;
    protected Object currentValue;
    protected boolean hasNext;
    protected Iterator lastUsedIterator;
    protected Object root;
    protected final ArrayStack stack;
    protected Transformer transformer;

    public ObjectGraphIterator(Object obj, Transformer transformer) {
        this.stack = new ArrayStack(8);
        this.hasNext = false;
        if (obj instanceof Iterator) {
            this.currentIterator = (Iterator) obj;
        } else {
            this.root = obj;
        }
        this.transformer = transformer;
    }

    public ObjectGraphIterator(Iterator it) {
        this.stack = new ArrayStack(8);
        this.hasNext = false;
        this.currentIterator = it;
        this.transformer = null;
    }

    protected void updateCurrentIterator() {
        if (this.hasNext) {
            return;
        }
        Iterator it = this.currentIterator;
        if (it == null) {
            Object obj = this.root;
            if (obj == null) {
                return;
            }
            Transformer transformer = this.transformer;
            if (transformer == null) {
                findNext(obj);
            } else {
                findNext(transformer.transform(obj));
            }
            this.root = null;
            return;
        }
        findNextByIterator(it);
    }

    protected void findNext(Object obj) {
        if (obj instanceof Iterator) {
            findNextByIterator((Iterator) obj);
        } else {
            this.currentValue = obj;
            this.hasNext = true;
        }
    }

    protected void findNextByIterator(Iterator it) {
        Iterator it2 = this.currentIterator;
        if (it != it2) {
            if (it2 != null) {
                this.stack.push(it2);
            }
            this.currentIterator = it;
        }
        while (this.currentIterator.hasNext() && !this.hasNext) {
            Object next = this.currentIterator.next();
            Transformer transformer = this.transformer;
            if (transformer != null) {
                next = transformer.transform(next);
            }
            findNext(next);
        }
        if (this.hasNext || this.stack.isEmpty()) {
            return;
        }
        Iterator it3 = (Iterator) this.stack.pop();
        this.currentIterator = it3;
        findNextByIterator(it3);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        updateCurrentIterator();
        return this.hasNext;
    }

    @Override // java.util.Iterator
    public Object next() {
        updateCurrentIterator();
        if (!this.hasNext) {
            throw new NoSuchElementException("No more elements in the iteration");
        }
        this.lastUsedIterator = this.currentIterator;
        Object obj = this.currentValue;
        this.currentValue = null;
        this.hasNext = false;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        Iterator it = this.lastUsedIterator;
        if (it == null) {
            throw new IllegalStateException("Iterator remove() cannot be called at this time");
        }
        it.remove();
        this.lastUsedIterator = null;
    }
}
