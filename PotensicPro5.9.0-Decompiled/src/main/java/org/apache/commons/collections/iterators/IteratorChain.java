package org.apache.commons.collections.iterators;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.collections.list.UnmodifiableList;

/* loaded from: classes4.dex */
public class IteratorChain implements Iterator {
    protected final List iteratorChain = new ArrayList();
    protected int currentIteratorIndex = 0;
    protected Iterator currentIterator = null;
    protected Iterator lastUsedIterator = null;
    protected boolean isLocked = false;

    public IteratorChain() {
    }

    public IteratorChain(Iterator it) {
        addIterator(it);
    }

    public IteratorChain(Iterator it, Iterator it2) {
        addIterator(it);
        addIterator(it2);
    }

    public IteratorChain(Iterator[] itArr) {
        for (Iterator it : itArr) {
            addIterator(it);
        }
    }

    public IteratorChain(Collection collection) {
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addIterator((Iterator) it.next());
        }
    }

    public void addIterator(Iterator it) {
        checkLocked();
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iteratorChain.add(it);
    }

    public void setIterator(int i, Iterator it) throws IndexOutOfBoundsException {
        checkLocked();
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iteratorChain.set(i, it);
    }

    public List getIterators() {
        return UnmodifiableList.decorate(this.iteratorChain);
    }

    public int size() {
        return this.iteratorChain.size();
    }

    public boolean isLocked() {
        return this.isLocked;
    }

    private void checkLocked() {
        if (this.isLocked) {
            throw new UnsupportedOperationException("IteratorChain cannot be changed after the first use of a method from the Iterator interface");
        }
    }

    private void lockChain() {
        if (this.isLocked) {
            return;
        }
        this.isLocked = true;
    }

    protected void updateCurrentIterator() {
        if (this.currentIterator == null) {
            if (this.iteratorChain.isEmpty()) {
                this.currentIterator = EmptyIterator.INSTANCE;
            } else {
                this.currentIterator = (Iterator) this.iteratorChain.get(0);
            }
            this.lastUsedIterator = this.currentIterator;
        }
        while (!this.currentIterator.hasNext() && this.currentIteratorIndex < this.iteratorChain.size() - 1) {
            int i = this.currentIteratorIndex + 1;
            this.currentIteratorIndex = i;
            this.currentIterator = (Iterator) this.iteratorChain.get(i);
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        lockChain();
        updateCurrentIterator();
        Iterator it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.hasNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        lockChain();
        updateCurrentIterator();
        Iterator it = this.currentIterator;
        this.lastUsedIterator = it;
        return it.next();
    }

    @Override // java.util.Iterator
    public void remove() {
        lockChain();
        if (this.currentIterator == null) {
            updateCurrentIterator();
        }
        this.lastUsedIterator.remove();
    }
}
