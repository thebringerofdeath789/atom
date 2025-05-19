package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Predicate;

/* loaded from: classes4.dex */
public class FilterIterator implements Iterator {
    private Iterator iterator;
    private Object nextObject;
    private boolean nextObjectSet = false;
    private Predicate predicate;

    public FilterIterator() {
    }

    public FilterIterator(Iterator it) {
        this.iterator = it;
    }

    public FilterIterator(Iterator it, Predicate predicate) {
        this.iterator = it;
        this.predicate = predicate;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextObjectSet) {
            return true;
        }
        return setNextObject();
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!this.nextObjectSet && !setNextObject()) {
            throw new NoSuchElementException();
        }
        this.nextObjectSet = false;
        return this.nextObject;
    }

    @Override // java.util.Iterator
    public void remove() {
        if (this.nextObjectSet) {
            throw new IllegalStateException("remove() cannot be called");
        }
        this.iterator.remove();
    }

    public Iterator getIterator() {
        return this.iterator;
    }

    public void setIterator(Iterator it) {
        this.iterator = it;
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    public Predicate getPredicate() {
        return this.predicate;
    }

    public void setPredicate(Predicate predicate) {
        this.predicate = predicate;
        this.nextObject = null;
        this.nextObjectSet = false;
    }

    private boolean setNextObject() {
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            if (this.predicate.evaluate(next)) {
                this.nextObject = next;
                this.nextObjectSet = true;
                return true;
            }
        }
        return false;
    }
}
