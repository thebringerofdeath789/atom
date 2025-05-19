package org.apache.commons.collections;

import java.util.AbstractCollection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

/* loaded from: classes4.dex */
public class UnboundedFifoBuffer extends AbstractCollection implements Buffer {
    protected Object[] m_buffer;
    protected int m_head;
    protected int m_tail;

    public UnboundedFifoBuffer() {
        this(32);
    }

    public UnboundedFifoBuffer(int i) {
        if (i <= 0) {
            throw new IllegalArgumentException("The size must be greater than 0");
        }
        this.m_buffer = new Object[i + 1];
        this.m_head = 0;
        this.m_tail = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        int i = this.m_tail;
        int i2 = this.m_head;
        return i < i2 ? (this.m_buffer.length - i2) + i : i - i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean isEmpty() {
        return size() == 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        Objects.requireNonNull(obj, "Attempted to add null object to buffer");
        int size = size() + 1;
        Object[] objArr = this.m_buffer;
        if (size >= objArr.length) {
            Object[] objArr2 = new Object[((objArr.length - 1) * 2) + 1];
            int i = this.m_head;
            int i2 = 0;
            while (i != this.m_tail) {
                Object[] objArr3 = this.m_buffer;
                objArr2[i2] = objArr3[i];
                objArr3[i] = null;
                i2++;
                i++;
                if (i == objArr3.length) {
                    i = 0;
                }
            }
            this.m_buffer = objArr2;
            this.m_head = 0;
            this.m_tail = i2;
        }
        Object[] objArr4 = this.m_buffer;
        int i3 = this.m_tail;
        objArr4[i3] = obj;
        int i4 = i3 + 1;
        this.m_tail = i4;
        if (i4 >= objArr4.length) {
            this.m_tail = 0;
        }
        return true;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        return this.m_buffer[this.m_head];
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        if (isEmpty()) {
            throw new BufferUnderflowException("The buffer is already empty");
        }
        Object[] objArr = this.m_buffer;
        int i = this.m_head;
        Object obj = objArr[i];
        if (obj != null) {
            objArr[i] = null;
            int i2 = i + 1;
            this.m_head = i2;
            if (i2 >= objArr.length) {
                this.m_head = 0;
            }
        }
        return obj;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int increment(int i) {
        int i2 = i + 1;
        if (i2 >= this.m_buffer.length) {
            return 0;
        }
        return i2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int decrement(int i) {
        int i2 = i - 1;
        return i2 < 0 ? this.m_buffer.length - 1 : i2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.commons.collections.UnboundedFifoBuffer.1
            private int index;
            private int lastReturnedIndex = -1;

            {
                this.index = UnboundedFifoBuffer.this.m_head;
            }

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index != UnboundedFifoBuffer.this.m_tail;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = UnboundedFifoBuffer.this.increment(i);
                return UnboundedFifoBuffer.this.m_buffer[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                int i = this.lastReturnedIndex;
                if (i == -1) {
                    throw new IllegalStateException();
                }
                if (i != UnboundedFifoBuffer.this.m_head) {
                    int increment = UnboundedFifoBuffer.this.increment(this.lastReturnedIndex);
                    while (increment != UnboundedFifoBuffer.this.m_tail) {
                        UnboundedFifoBuffer.this.m_buffer[UnboundedFifoBuffer.this.decrement(increment)] = UnboundedFifoBuffer.this.m_buffer[increment];
                        increment = UnboundedFifoBuffer.this.increment(increment);
                    }
                    this.lastReturnedIndex = -1;
                    UnboundedFifoBuffer unboundedFifoBuffer = UnboundedFifoBuffer.this;
                    unboundedFifoBuffer.m_tail = unboundedFifoBuffer.decrement(unboundedFifoBuffer.m_tail);
                    UnboundedFifoBuffer.this.m_buffer[UnboundedFifoBuffer.this.m_tail] = null;
                    this.index = UnboundedFifoBuffer.this.decrement(this.index);
                    return;
                }
                UnboundedFifoBuffer.this.remove();
                this.lastReturnedIndex = -1;
            }
        };
    }
}
