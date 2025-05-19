package org.apache.commons.collections.buffer;

import java.io.Serializable;
import java.util.AbstractCollection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.Buffer;
import org.apache.commons.collections.BufferUnderflowException;

/* loaded from: classes4.dex */
public class PriorityBuffer extends AbstractCollection implements Buffer, Serializable {
    private static final int DEFAULT_CAPACITY = 13;
    private static final long serialVersionUID = 6891186490470027896L;
    protected boolean ascendingOrder;
    protected Comparator comparator;
    protected Object[] elements;
    protected int size;

    public PriorityBuffer() {
        this(13, true, null);
    }

    public PriorityBuffer(Comparator comparator) {
        this(13, true, comparator);
    }

    public PriorityBuffer(boolean z) {
        this(13, z, null);
    }

    public PriorityBuffer(boolean z, Comparator comparator) {
        this(13, z, comparator);
    }

    public PriorityBuffer(int i) {
        this(i, true, null);
    }

    public PriorityBuffer(int i, Comparator comparator) {
        this(i, true, comparator);
    }

    public PriorityBuffer(int i, boolean z) {
        this(i, z, null);
    }

    public PriorityBuffer(int i, boolean z, Comparator comparator) {
        if (i <= 0) {
            throw new IllegalArgumentException("invalid capacity");
        }
        this.ascendingOrder = z;
        this.elements = new Object[i + 1];
        this.comparator = comparator;
    }

    public boolean isAscendingOrder() {
        return this.ascendingOrder;
    }

    public Comparator comparator() {
        return this.comparator;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public int size() {
        return this.size;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public void clear() {
        this.elements = new Object[this.elements.length];
        this.size = 0;
    }

    @Override // java.util.AbstractCollection, java.util.Collection
    public boolean add(Object obj) {
        if (isAtCapacity()) {
            grow();
        }
        if (this.ascendingOrder) {
            percolateUpMinHeap(obj);
            return true;
        }
        percolateUpMaxHeap(obj);
        return true;
    }

    @Override // org.apache.commons.collections.Buffer
    public Object get() {
        if (isEmpty()) {
            throw new BufferUnderflowException();
        }
        return this.elements[1];
    }

    @Override // org.apache.commons.collections.Buffer
    public Object remove() {
        Object obj = get();
        Object[] objArr = this.elements;
        int i = this.size;
        int i2 = i - 1;
        this.size = i2;
        objArr[1] = objArr[i];
        objArr[i2 + 1] = null;
        if (i2 != 0) {
            if (this.ascendingOrder) {
                percolateDownMinHeap(1);
            } else {
                percolateDownMaxHeap(1);
            }
        }
        return obj;
    }

    protected boolean isAtCapacity() {
        return this.elements.length == this.size + 1;
    }

    protected void percolateDownMinHeap(int i) {
        Object obj = this.elements[i];
        while (true) {
            int i2 = i * 2;
            int i3 = this.size;
            if (i2 > i3) {
                break;
            }
            if (i2 != i3) {
                Object[] objArr = this.elements;
                int i4 = i2 + 1;
                if (compare(objArr[i4], objArr[i2]) < 0) {
                    i2 = i4;
                }
            }
            if (compare(this.elements[i2], obj) >= 0) {
                break;
            }
            Object[] objArr2 = this.elements;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        this.elements[i] = obj;
    }

    protected void percolateDownMaxHeap(int i) {
        Object obj = this.elements[i];
        while (true) {
            int i2 = i * 2;
            int i3 = this.size;
            if (i2 > i3) {
                break;
            }
            if (i2 != i3) {
                Object[] objArr = this.elements;
                int i4 = i2 + 1;
                if (compare(objArr[i4], objArr[i2]) > 0) {
                    i2 = i4;
                }
            }
            if (compare(this.elements[i2], obj) <= 0) {
                break;
            }
            Object[] objArr2 = this.elements;
            objArr2[i] = objArr2[i2];
            i = i2;
        }
        this.elements[i] = obj;
    }

    protected void percolateUpMinHeap(int i) {
        Object obj = this.elements[i];
        while (i > 1) {
            int i2 = i / 2;
            if (compare(obj, this.elements[i2]) >= 0) {
                break;
            }
            Object[] objArr = this.elements;
            objArr[i] = objArr[i2];
            i = i2;
        }
        this.elements[i] = obj;
    }

    protected void percolateUpMinHeap(Object obj) {
        Object[] objArr = this.elements;
        int i = this.size + 1;
        this.size = i;
        objArr[i] = obj;
        percolateUpMinHeap(i);
    }

    protected void percolateUpMaxHeap(int i) {
        Object obj = this.elements[i];
        while (i > 1) {
            int i2 = i / 2;
            if (compare(obj, this.elements[i2]) <= 0) {
                break;
            }
            Object[] objArr = this.elements;
            objArr[i] = objArr[i2];
            i = i2;
        }
        this.elements[i] = obj;
    }

    protected void percolateUpMaxHeap(Object obj) {
        Object[] objArr = this.elements;
        int i = this.size + 1;
        this.size = i;
        objArr[i] = obj;
        percolateUpMaxHeap(i);
    }

    protected int compare(Object obj, Object obj2) {
        Comparator comparator = this.comparator;
        if (comparator != null) {
            return comparator.compare(obj, obj2);
        }
        return ((Comparable) obj).compareTo(obj2);
    }

    protected void grow() {
        Object[] objArr = this.elements;
        Object[] objArr2 = new Object[objArr.length * 2];
        System.arraycopy(objArr, 0, objArr2, 0, objArr.length);
        this.elements = objArr2;
    }

    @Override // java.util.AbstractCollection, java.util.Collection, java.lang.Iterable
    public Iterator iterator() {
        return new Iterator() { // from class: org.apache.commons.collections.buffer.PriorityBuffer.1
            private int index = 1;
            private int lastReturnedIndex = -1;

            @Override // java.util.Iterator
            public boolean hasNext() {
                return this.index <= PriorityBuffer.this.size;
            }

            @Override // java.util.Iterator
            public Object next() {
                if (!hasNext()) {
                    throw new NoSuchElementException();
                }
                int i = this.index;
                this.lastReturnedIndex = i;
                this.index = i + 1;
                return PriorityBuffer.this.elements[this.lastReturnedIndex];
            }

            @Override // java.util.Iterator
            public void remove() {
                if (this.lastReturnedIndex == -1) {
                    throw new IllegalStateException();
                }
                PriorityBuffer.this.elements[this.lastReturnedIndex] = PriorityBuffer.this.elements[PriorityBuffer.this.size];
                PriorityBuffer.this.elements[PriorityBuffer.this.size] = null;
                PriorityBuffer.this.size--;
                if (PriorityBuffer.this.size != 0 && this.lastReturnedIndex <= PriorityBuffer.this.size) {
                    int i = 0;
                    if (this.lastReturnedIndex > 1) {
                        PriorityBuffer priorityBuffer = PriorityBuffer.this;
                        i = priorityBuffer.compare(priorityBuffer.elements[this.lastReturnedIndex], PriorityBuffer.this.elements[this.lastReturnedIndex / 2]);
                    }
                    if (PriorityBuffer.this.ascendingOrder) {
                        int i2 = this.lastReturnedIndex;
                        if (i2 > 1 && i < 0) {
                            PriorityBuffer.this.percolateUpMinHeap(i2);
                        } else {
                            PriorityBuffer.this.percolateDownMinHeap(i2);
                        }
                    } else {
                        int i3 = this.lastReturnedIndex;
                        if (i3 > 1 && i > 0) {
                            PriorityBuffer.this.percolateUpMaxHeap(i3);
                        } else {
                            PriorityBuffer.this.percolateDownMaxHeap(i3);
                        }
                    }
                }
                this.index--;
                this.lastReturnedIndex = -1;
            }
        };
    }

    @Override // java.util.AbstractCollection
    public String toString() {
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("[ ");
        for (int i = 1; i < this.size + 1; i++) {
            if (i != 1) {
                stringBuffer.append(", ");
            }
            stringBuffer.append(this.elements[i]);
        }
        stringBuffer.append(" ]");
        return stringBuffer.toString();
    }
}
