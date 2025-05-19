package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.Map;
import org.apache.commons.collections.MapIterator;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class EntrySetMapIterator implements MapIterator, ResettableIterator {
    private boolean canRemove = false;
    private Iterator iterator;
    private Map.Entry last;
    private final Map map;

    public EntrySetMapIterator(Map map) {
        this.map = map;
        this.iterator = map.entrySet().iterator();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public boolean hasNext() {
        return this.iterator.hasNext();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public Object next() {
        Map.Entry entry = (Map.Entry) this.iterator.next();
        this.last = entry;
        this.canRemove = true;
        return entry.getKey();
    }

    @Override // org.apache.commons.collections.MapIterator, java.util.Iterator
    public void remove() {
        if (!this.canRemove) {
            throw new IllegalStateException("Iterator remove() can only be called once after next()");
        }
        this.iterator.remove();
        this.last = null;
        this.canRemove = false;
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getKey() {
        Map.Entry entry = this.last;
        if (entry == null) {
            throw new IllegalStateException("Iterator getKey() can only be called after next() and before remove()");
        }
        return entry.getKey();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object getValue() {
        Map.Entry entry = this.last;
        if (entry == null) {
            throw new IllegalStateException("Iterator getValue() can only be called after next() and before remove()");
        }
        return entry.getValue();
    }

    @Override // org.apache.commons.collections.MapIterator
    public Object setValue(Object obj) {
        Map.Entry entry = this.last;
        if (entry == null) {
            throw new IllegalStateException("Iterator setValue() can only be called after next() and before remove()");
        }
        return entry.setValue(obj);
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.iterator = this.map.entrySet().iterator();
        this.last = null;
        this.canRemove = false;
    }

    public String toString() {
        return this.last != null ? new StringBuffer().append("MapIterator[").append(getKey()).append("=").append(getValue()).append("]").toString() : "MapIterator[]";
    }
}
