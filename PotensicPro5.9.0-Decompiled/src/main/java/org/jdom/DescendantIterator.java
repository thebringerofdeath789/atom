package org.jdom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes5.dex */
class DescendantIterator implements Iterator {
    private static final String CVS_ID = "@(#) $RCSfile: DescendantIterator.java,v $ $Revision: 1.5 $ $Date: 2004/02/27 11:32:57 $ $Name: jdom_1_0 $";
    private Iterator iterator;
    private Iterator nextIterator;
    private List stack = new ArrayList();

    DescendantIterator(Parent parent) {
        if (parent == null) {
            throw new IllegalArgumentException("parent parameter was null");
        }
        this.iterator = parent.getContent().iterator();
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        Iterator it = this.iterator;
        if (it != null && it.hasNext()) {
            return true;
        }
        Iterator it2 = this.nextIterator;
        return (it2 != null && it2.hasNext()) || stackHasAnyNext();
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        if (this.nextIterator != null) {
            push(this.iterator);
            this.iterator = this.nextIterator;
            this.nextIterator = null;
        }
        while (!this.iterator.hasNext()) {
            if (this.stack.size() > 0) {
                this.iterator = pop();
            } else {
                throw new NoSuchElementException("Somehow we lost our iterator");
            }
        }
        Content content = (Content) this.iterator.next();
        if (content instanceof Element) {
            this.nextIterator = ((Element) content).getContent().iterator();
        }
        return content;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }

    private Iterator pop() {
        int size = this.stack.size();
        if (size == 0) {
            throw new NoSuchElementException("empty stack");
        }
        return (Iterator) this.stack.remove(size - 1);
    }

    private void push(Iterator it) {
        this.stack.add(it);
    }

    private boolean stackHasAnyNext() {
        int size = this.stack.size();
        for (int i = 0; i < size; i++) {
            if (((Iterator) this.stack.get(i)).hasNext()) {
                return true;
            }
        }
        return false;
    }
}
