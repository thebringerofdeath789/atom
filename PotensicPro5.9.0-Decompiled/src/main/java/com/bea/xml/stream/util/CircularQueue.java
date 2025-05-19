package com.bea.xml.stream.util;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public final class CircularQueue extends AbstractCollection {
    private static final int DEFAULT_CAPACITY = 256;
    private static final int MAX_CAPACITY = 1073741824;
    private int bitmask;
    private int capacity;
    private int consumerIndex;
    private int maxCapacity;
    private int producerIndex;
    private Object[] q;
    private int size;

    public CircularQueue() {
        this(256);
    }

    public CircularQueue(int i) {
        this(i, 1073741824);
    }

    public CircularQueue(int i, int i2) {
        this.size = 0;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        if (i > i2) {
            throw new IllegalArgumentException("Capacity greater than maximum");
        }
        if (i2 > 1073741824) {
            throw new IllegalArgumentException("Maximum capacity greater than allowed");
        }
        this.capacity = 1;
        while (true) {
            int i3 = this.capacity;
            if (i3 >= i) {
                break;
            } else {
                this.capacity = i3 << 1;
            }
        }
        this.maxCapacity = 1;
        while (true) {
            int i4 = this.maxCapacity;
            if (i4 >= i2) {
                int i5 = this.capacity;
                this.bitmask = i5 - 1;
                this.q = new Object[i5];
                return;
            }
            this.maxCapacity = i4 << 1;
        }
    }

    private CircularQueue(CircularQueue circularQueue) {
        this.size = 0;
        this.producerIndex = 0;
        this.consumerIndex = 0;
        this.size = circularQueue.size;
        this.producerIndex = circularQueue.producerIndex;
        this.consumerIndex = circularQueue.consumerIndex;
        this.capacity = circularQueue.capacity;
        this.maxCapacity = circularQueue.maxCapacity;
        this.bitmask = circularQueue.bitmask;
        Object[] objArr = new Object[circularQueue.q.length];
        this.q = objArr;
        System.arraycopy(circularQueue.q, 0, objArr, 0, objArr.length);
    }

    private boolean expandQueue() {
        int i = this.capacity;
        if (i == this.maxCapacity) {
            return false;
        }
        Object[] objArr = this.q;
        int i2 = i + i;
        this.capacity = i2;
        this.bitmask = i2 - 1;
        Object[] objArr2 = new Object[i2];
        this.q = objArr2;
        int i3 = this.consumerIndex;
        System.arraycopy(objArr, i3, objArr2, 0, i - i3);
        int i4 = this.consumerIndex;
        if (i4 != 0) {
            System.arraycopy(objArr, 0, this.q, i - i4, i4);
        }
        this.consumerIndex = 0;
        this.producerIndex = this.size;
        return true;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (this.size == this.capacity && !expandQueue()) {
            return false;
        }
        this.size++;
        Object[] objArr = this.q;
        int i = this.producerIndex;
        objArr[i] = obj;
        this.producerIndex = this.bitmask & (i + 1);
        return true;
    }

    public Object remove() {
        int i = this.size;
        if (i == 0) {
            return null;
        }
        this.size = i - 1;
        Object[] objArr = this.q;
        int i2 = this.consumerIndex;
        Object obj = objArr[i2];
        objArr[i2] = null;
        this.consumerIndex = this.bitmask & (i2 + 1);
        return obj;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    public int capacity() {
        return this.capacity;
    }

    public Object peek() {
        if (this.size == 0) {
            return null;
        }
        return this.q[this.consumerIndex];
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        Arrays.fill(this.q, (Object) null);
        this.size = 0;
        this.producerIndex = 0;
        this.consumerIndex = 0;
    }

    public Object clone() {
        return new CircularQueue(this);
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer(new StringBuffer().append(super.toString()).append(" - capacity: '").append(capacity()).append("' size: '").append(size()).append("'").toString());
        if (this.size > 0) {
            stringBuffer.append(" elements:");
            for (int i = 0; i < this.size; i++) {
                stringBuffer.append('\n');
                stringBuffer.append('\t');
                stringBuffer.append(this.q[(this.consumerIndex + i) & this.bitmask].toString());
            }
        }
        return stringBuffer.toString();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: com.bea.xml.stream.util.CircularQueue.1
            private final int ci;
            private int i;
            private final int pi;
            private int s;

            @Override // java.util.Iterator
            public boolean hasNext() {
                checkForModification();
                return this.s > 0;
            }

            @Override // java.util.Iterator
            public Object next() {
                checkForModification();
                int i = this.s;
                if (i == 0) {
                    throw new NoSuchElementException();
                }
                this.s = i - 1;
                Object[] objArr = CircularQueue.this.q;
                int i2 = this.i;
                Object obj = objArr[i2];
                this.i = (i2 + 1) & CircularQueue.this.bitmask;
                return obj;
            }

            @Override // java.util.Iterator
            public void remove() {
                throw new UnsupportedOperationException();
            }

            {
                int i = CircularQueue.this.consumerIndex;
                this.ci = i;
                this.pi = CircularQueue.this.producerIndex;
                this.s = CircularQueue.this.size;
                this.i = i;
            }

            private void checkForModification() {
                if (this.ci == CircularQueue.this.consumerIndex) {
                    if (this.pi != CircularQueue.this.producerIndex) {
                        throw new ConcurrentModificationException();
                    }
                    return;
                }
                throw new ConcurrentModificationException();
            }
        };
    }
}
