package org.apache.commons.collections;

import java.util.AbstractCollection;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
public class BoundedFifoBuffer extends AbstractCollection implements Buffer, BoundedCollection {
    private final Object[] m_elements;
    private int m_end;
    private boolean m_full;
    private int m_start;
    private final int maxElements;

    public BoundedFifoBuffer() {
        this(32);
    }

    public BoundedFifoBuffer(int i) {
        this.m_start = 0;
        this.m_end = 0;
        this.m_full = false;
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        Object[] objArr = new Object[i];
        this.m_elements = objArr;
        this.maxElements = objArr.length;
    }

    public BoundedFifoBuffer(Collection collection) {
        this(collection.size());
        addAll(collection);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.m_end;
        int i2 = this.m_start;
        if (i < i2) {
            return (this.maxElements - i2) + i;
        }
        if (i == i2) {
            return this.m_full ? this.maxElements : 0;
        }
        return i - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public boolean isFull() {
        return size() == this.maxElements;
    }

    @Override // org.apache.commons.collections.BoundedCollection
    public int maxSize() {
        return this.maxElements;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.m_full = false;
        this.m_start = 0;
        this.m_end = 0;
        Arrays.fill(this.m_elements, (Object) null);
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        Objects.requireNonNull(obj, "Attempted to add null object to buffer");
        if (this.m_full) {
            throw new BufferOverflowException(new StringBuffer().append("The buffer cannot hold more than ").append(this.maxElements).append(" objects.").toString());
        }
        Object[] objArr = this.m_elements;
        int i = this.m_end;
        int i2 = i + 1;
        this.m_end = i2;
        objArr[i] = obj;
        if (i2 >= this.maxElements) {
            this.m_end = 0;
        }
        if (this.m_end == this.m_start) {
            this.m_full = true;
        }
        return true;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        return this.m_elements[this.m_start];
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        Object[] objArr = this.m_elements;
        int i = this.m_start;
        Object obj = objArr[i];
        if (obj != null) {
            int i2 = i + 1;
            this.m_start = i2;
            objArr[i] = null;
            if (i2 >= this.maxElements) {
                this.m_start = 0;
            }
            this.m_full = false;
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.maxElements) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.maxElements - 1 : i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.commons.collections.BoundedFifoBuffer.1
            private int index;
            private boolean isFirst;
            private int lastReturnedIndex = -1;

            {
                this.index = BoundedFifoBuffer.this.m_start;
                this.isFirst = BoundedFifoBuffer.this.m_full;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.isFirst || this.index != BoundedFifoBuffer.this.m_end;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                this.isFirst = false;
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = BoundedFifoBuffer.this.increment(i);
                return BoundedFifoBuffer.this.m_elements[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i != -1) {
                    if (i == BoundedFifoBuffer.this.m_start) {
                        BoundedFifoBuffer.this.remove();
                        this.lastReturnedIndex = -1;
                        return;
                    }
                    int i2 = this.lastReturnedIndex + 1;
                    while (i2 != BoundedFifoBuffer.this.m_end) {
                        if (i2 >= BoundedFifoBuffer.this.maxElements) {
                            BoundedFifoBuffer.this.m_elements[i2 - 1] = BoundedFifoBuffer.this.m_elements[0];
                            i2 = 0;
                        } else {
                            BoundedFifoBuffer.this.m_elements[i2 - 1] = BoundedFifoBuffer.this.m_elements[i2];
                            i2++;
                        }
                    }
                    this.lastReturnedIndex = -1;
                    BoundedFifoBuffer boundedFifoBuffer = BoundedFifoBuffer.this;
                    boundedFifoBuffer.m_end = boundedFifoBuffer.decrement(boundedFifoBuffer.m_end);
                    BoundedFifoBuffer.this.m_elements[BoundedFifoBuffer.this.m_end] = null;
                    BoundedFifoBuffer.this.m_full = false;
                    this.index = BoundedFifoBuffer.this.decrement(this.index);
                    return;
                }
                throw new IllegalStateException();
            }
        };
    }
}
