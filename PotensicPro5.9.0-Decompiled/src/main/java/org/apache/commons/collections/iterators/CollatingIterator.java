package org.apache.commons.collections.iterators;

import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Objects;
import org.apache.commons.collections.list.UnmodifiableList;

/* loaded from: classes4.dex */
public class CollatingIterator implements Iterator {
    private Comparator comparator;
    private ArrayList iterators;
    private int lastReturned;
    private BitSet valueSet;
    private ArrayList values;

    public CollatingIterator() {
        this((Comparator) null, 2);
    }

    public CollatingIterator(Comparator comparator) {
        this(comparator, 2);
    }

    public CollatingIterator(Comparator comparator, int i) {
        this.comparator = null;
        this.iterators = null;
        this.values = null;
        this.valueSet = null;
        this.lastReturned = -1;
        this.iterators = new ArrayList(i);
        setComparator(comparator);
    }

    public CollatingIterator(Comparator comparator, Iterator it, Iterator it2) {
        this(comparator, 2);
        addIterator(it);
        addIterator(it2);
    }

    public CollatingIterator(Comparator comparator, Iterator[] itArr) {
        this(comparator, itArr.length);
        for (Iterator it : itArr) {
            addIterator(it);
        }
    }

    public CollatingIterator(Comparator comparator, Collection collection) {
        this(comparator, collection.size());
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            addIterator((Iterator) it.next());
        }
    }

    public void addIterator(Iterator it) {
        checkNotStarted();
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterators.add(it);
    }

    public void setIterator(int i, Iterator it) {
        checkNotStarted();
        Objects.requireNonNull(it, "Iterator must not be null");
        this.iterators.set(i, it);
    }

    public List getIterators() {
        return UnmodifiableList.decorate(this.iterators);
    }

    public Comparator getComparator() {
        return this.comparator;
    }

    public void setComparator(Comparator comparator) {
        checkNotStarted();
        this.comparator = comparator;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        start();
        return anyValueSet(this.valueSet) || anyHasNext(this.iterators);
    }

    @Override // java.util.Iterator
    public Object next() throws NoSuchElementException {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int least = least();
        if (least == -1) {
            throw new NoSuchElementException();
        }
        Object obj = this.values.get(least);
        clear(least);
        this.lastReturned = least;
        return obj;
    }

    @Override // java.util.Iterator
    public void remove() {
        int i = this.lastReturned;
        if (i == -1) {
            throw new IllegalStateException("No value can be removed at present");
        }
        ((Iterator) this.iterators.get(i)).remove();
    }

    private void start() {
        if (this.values == null) {
            this.values = new ArrayList(this.iterators.size());
            this.valueSet = new BitSet(this.iterators.size());
            for (int i = 0; i < this.iterators.size(); i++) {
                this.values.add(null);
                this.valueSet.clear(i);
            }
        }
    }

    private boolean set(int i) {
        Iterator it = (Iterator) this.iterators.get(i);
        if (it.hasNext()) {
            this.values.set(i, it.next());
            this.valueSet.set(i);
            return true;
        }
        this.values.set(i, null);
        this.valueSet.clear(i);
        return false;
    }

    private void clear(int i) {
        this.values.set(i, null);
        this.valueSet.clear(i);
    }

    private void checkNotStarted() throws IllegalStateException {
        if (this.values != null) {
            throw new IllegalStateException("Can't do that after next or hasNext has been called.");
        }
    }

    private int least() {
        Object obj = null;
        int i = -1;
        for (int i2 = 0; i2 < this.values.size(); i2++) {
            if (!this.valueSet.get(i2)) {
                set(i2);
            }
            if (this.valueSet.get(i2)) {
                if (i == -1) {
                    obj = this.values.get(i2);
                    i = i2;
                } else {
                    Object obj2 = this.values.get(i2);
                    if (this.comparator.compare(obj2, obj) < 0) {
                        i = i2;
                        obj = obj2;
                    }
                }
            }
        }
        return i;
    }

    private boolean anyValueSet(BitSet bitSet) {
        for (int i = 0; i < bitSet.size(); i++) {
            if (bitSet.get(i)) {
                return true;
            }
        }
        return false;
    }

    private boolean anyHasNext(ArrayList arrayList) {
        for (int i = 0; i < arrayList.size(); i++) {
            if (((Iterator) arrayList.get(i)).hasNext()) {
                return true;
            }
        }
        return false;
    }
}
