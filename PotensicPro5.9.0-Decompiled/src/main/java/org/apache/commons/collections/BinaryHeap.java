package org.apache.commons.collections;

import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;

/* loaded from: classes4.dex */
public final class BinaryHeap extends AbstractCollection implements PriorityQueue, Buffer {
    private static final int DEFAULT_CAPACITY = 13;
    Comparator m_comparator;
    Object[] m_elements;
    boolean m_isMinHeap;
    int m_size;

    public BinaryHeap() {
        this(13, true);
    }

    public BinaryHeap(Comparator comparator) {
        this();
        this.m_comparator = comparator;
    }

    public BinaryHeap(int i) {
        this(i, true);
    }

    public BinaryHeap(int i, Comparator comparator) {
        this(i);
        this.m_comparator = comparator;
    }

    public BinaryHeap(boolean z) {
        this(13, z);
    }

    public BinaryHeap(boolean z, Comparator comparator) {
        this(z);
        this.m_comparator = comparator;
    }

    public BinaryHeap(int i, boolean z) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.m_isMinHeap = z;
        this.m_elements = new Object[i + 1];
    }

    public BinaryHeap(int i, boolean z, Comparator comparator) {
        this(i, z);
        this.m_comparator = comparator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections.PriorityQueue
    public void clear() {
        this.m_elements = new Object[this.m_elements.length];
        this.m_size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, org.apache.commons.collections.PriorityQueue
    public boolean isEmpty() {
        return this.m_size == 0;
    }

    public boolean isFull() {
        return this.m_elements.length == this.m_size + 1;
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public void insert(Object obj) {
        if (isFull()) {
            grow();
        }
        if (this.m_isMinHeap) {
            percolateUpMinHeap(obj);
        } else {
            percolateUpMaxHeap(obj);
        }
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public Object peek() throws NoSuchElementException {
        if (isEmpty()) {
            throw new NoSuchElementException();
        }
        return this.m_elements[1];
    }

    @Override // org.apache.commons.collections.PriorityQueue
    public Object pop() throws NoSuchElementException {
        Object peek = peek();
        Object[] objArr = this.m_elements;
        int i = this.m_size;
        int i2 = i - 1;
        this.m_size = i2;
        objArr[1] = objArr[i];
        objArr[i2 + 1] = null;
        if (i2 != 0) {
            if (this.m_isMinHeap) {
                percolateDownMinHeap(1);
            } else {
                percolateDownMaxHeap(1);
            }
        }
        return peek;
    }

    protected void percolateDownMinHeap(int i) {
        Object obj = this.m_elements[i];
        while (true) {
            int i2 = i * 2;
            int i3 = this.m_size;
            if (i2 > i3) {
                break;
            }
            if (i2 != i3) {
                Object[] objArr = this.m_elements;
                int i4 = i2 + 1;
                if (compare(objArr[i4], objArr[i2]) < 0) {
                    i2 = i4;
                }
            }
            if (compare(this.m_elements[i2], obj) >= 0) {
                break;
            }
            Object[] objArr2 = this.m_elements;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    protected void percolateDownMaxHeap(int i) {
        Object obj = this.m_elements[i];
        while (true) {
            int i2 = i * 2;
            int i3 = this.m_size;
            if (i2 > i3) {
                break;
            }
            if (i2 != i3) {
                Object[] objArr = this.m_elements;
                int i4 = i2 + 1;
                if (compare(objArr[i4], objArr[i2]) > 0) {
                    i2 = i4;
                }
            }
            if (compare(this.m_elements[i2], obj) <= 0) {
                break;
            }
            Object[] objArr2 = this.m_elements;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    protected void percolateUpMinHeap(int i) {
        Object obj = this.m_elements[i];
        while (i > 1) {
            int i2 = i / 2;
            if (compare(obj, this.m_elements[i2]) >= 0) {
                break;
            }
            Object[] objArr = this.m_elements;
            objArr[i] = objArr[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    protected void percolateUpMinHeap(Object obj) {
        Object[] objArr = this.m_elements;
        int i = this.m_size + 1;
        this.m_size = i;
        objArr[i] = obj;
        percolateUpMinHeap(i);
    }

    protected void percolateUpMaxHeap(int i) {
        Object obj = this.m_elements[i];
        while (i > 1) {
            int i2 = i / 2;
            if (compare(obj, this.m_elements[i2]) <= 0) {
                break;
            }
            Object[] objArr = this.m_elements;
            objArr[i] = objArr[i2];
            i = i2;
        }
        this.m_elements[i] = obj;
    }

    protected void percolateUpMaxHeap(Object obj) {
        Object[] objArr = this.m_elements;
        int i = this.m_size + 1;
        this.m_size = i;
        objArr[i] = obj;
        percolateUpMaxHeap(i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int compare(Object obj, Object obj2) {
        Comparator comparator = this.m_comparator;
        if (comparator != null) {
            return comparator.compare(obj, obj2);
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    protected void grow() {
        Object[] objArr = this.m_elements;
        Object[] objArr2 = new Object[objArr.length * 2];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.m_elements = objArr2;
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");
        for (int i = 1; i < this.m_size + 1; i++) {
            if (i != 1) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.m_elements[i]);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.commons.collections.BinaryHeap.1
            private int index = 1;
            private int lastReturnedIndex = -1;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index <= BinaryHeap.this.m_size;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = i + 1;
                return BinaryHeap.this.m_elements[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.lastReturnedIndex == -1) {
                    throw new IllegalStateException();
                }
                BinaryHeap.this.m_elements[this.lastReturnedIndex] = BinaryHeap.this.m_elements[BinaryHeap.this.m_size];
                BinaryHeap.this.m_elements[BinaryHeap.this.m_size] = null;
                BinaryHeap.this.m_size--;
                if (BinaryHeap.this.m_size != 0 && this.lastReturnedIndex <= BinaryHeap.this.m_size) {
                    int i = 0;
                    if (this.lastReturnedIndex > 1) {
                        BinaryHeap binaryHeap = BinaryHeap.this;
                        i = binaryHeap.compare(binaryHeap.m_elements[this.lastReturnedIndex], BinaryHeap.this.m_elements[this.lastReturnedIndex / 2]);
                    }
                    if (BinaryHeap.this.m_isMinHeap) {
                        int i2 = this.lastReturnedIndex;
                        if (i2 > 1 && i < 0) {
                            BinaryHeap.this.percolateUpMinHeap(i2);
                        } else {
                            BinaryHeap.this.percolateDownMinHeap(i2);
                        }
                    } else {
                        int i3 = this.lastReturnedIndex;
                        if (i3 > 1 && i > 0) {
                            BinaryHeap.this.percolateUpMaxHeap(i3);
                        } else {
                            BinaryHeap.this.percolateDownMaxHeap(i3);
                        }
                    }
                }
                this.index--;
                this.lastReturnedIndex = -1;
            }
        };
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        insert(obj);
        return true;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        try {
            return peek();
        } catch (NoSuchElementException unused) {
            throw new BufferUnderflowException();
        }
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        try {
            return pop();
        } catch (NoSuchElementException unused) {
            throw new BufferUnderflowException();
        }
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.m_size;
    }
}
