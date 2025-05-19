package org.jdom;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.jdom.filter.Filter;

/* loaded from: classes5.dex */
class FilterIterator implements Iterator {
    private static final String CVS_ID = "@(#) $RCSfile: FilterIterator.java,v $ $Revision: 1.5 $ $Date: 2004/08/31 19:36:12 $ $Name: jdom_1_0 $";
    private Filter filter;
    private Iterator iterator;
    private Object nextObject;

    public FilterIterator(Iterator it, Filter filter) {
        if (it == null || filter == null) {
            throw new IllegalArgumentException("null parameter");
        }
        this.iterator = it;
        this.filter = filter;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        if (this.nextObject != null) {
            return true;
        }
        while (this.iterator.hasNext()) {
            Object next = this.iterator.next();
            if (this.filter.matches(next)) {
                this.nextObject = next;
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.nextObject;
        this.nextObject = null;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        this.iterator.remove();
    }
}
