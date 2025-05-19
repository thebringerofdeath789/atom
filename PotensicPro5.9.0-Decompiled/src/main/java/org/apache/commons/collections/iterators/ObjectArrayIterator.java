package org.apache.commons.collections.iterators;

import java.util.Iterator;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class ObjectArrayIterator implements Iterator, ResettableIterator {
    protected Object[] array;
    protected int endIndex;
    protected int index;
    protected int startIndex;

    public ObjectArrayIterator() {
        this.array = null;
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
    }

    public ObjectArrayIterator(Object[] objArr) {
        this(objArr, 0, objArr.length);
    }

    public ObjectArrayIterator(Object[] objArr, int i) {
        this(objArr, i, objArr.length);
    }

    public ObjectArrayIterator(Object[] objArr, int i, int i2) {
        this.array = null;
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be less than zero");
        }
        if (i2 > objArr.length) {
            throw new ArrayIndexOutOfBoundsException("End index must not be greater than the array length");
        }
        if (i > objArr.length) {
            throw new ArrayIndexOutOfBoundsException("Start index must not be greater than the array length");
        }
        if (i2 < i) {
            throw new IllegalArgumentException("End index must not be less than start index");
        }
        this.array = objArr;
        this.startIndex = i;
        this.endIndex = i2;
        this.index = i;
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object[] objArr = this.array;
        int i = this.index;
        this.index = i + 1;
        return objArr[i];
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported for an ObjectArrayIterator");
    }

    public Object[] getArray() {
        return this.array;
    }

    public void setArray(Object[] objArr) {
        if (this.array != null) {
            throw new IllegalStateException("The array to iterate over has already been set");
        }
        this.array = objArr;
        this.startIndex = 0;
        this.endIndex = objArr.length;
        this.index = 0;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }
}
