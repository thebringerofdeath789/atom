package org.apache.commons.collections.iterators;

import java.util.Collection;
import java.util.Enumeration;
import java.util.Iterator;

/* loaded from: classes4.dex */
public class EnumerationIterator implements Iterator {
    private Collection collection;
    private Enumeration enumeration;
    private Object last;

    public EnumerationIterator() {
        this(null, null);
    }

    public EnumerationIterator(Enumeration enumeration) {
        this(enumeration, null);
    }

    public EnumerationIterator(Enumeration enumeration, Collection collection) {
        this.enumeration = enumeration;
        this.collection = collection;
        this.last = null;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.enumeration.hasMoreElements();
    }

    @Override // java.util.Iterator
    public Object next() {
        Object nextElement = this.enumeration.nextElement();
        this.last = nextElement;
        return nextElement;
    }

    @Override // java.util.Iterator
    public void remove() {
        Collection collection = this.collection;
        if (collection != null) {
            Object obj = this.last;
            if (obj != null) {
                collection.remove(obj);
                return;
            }
            throw new IllegalStateException("next() must have been called for remove() to function");
        }
        throw new UnsupportedOperationException("No Collection associated with this Iterator");
    }

    public Enumeration getEnumeration() {
        return this.enumeration;
    }

    public void setEnumeration(Enumeration enumeration) {
        this.enumeration = enumeration;
    }
}
