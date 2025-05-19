package org.apache.commons.collections.iterators;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections.ResettableIterator;

/* loaded from: classes4.dex */
public class ArrayIterator implements ResettableIterator {
    protected Object array;
    protected int endIndex;
    protected int index;
    protected int startIndex;

    public ArrayIterator() {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
    }

    public ArrayIterator(Object obj) {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        setArray(obj);
    }

    public ArrayIterator(Object obj, int i) {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        setArray(obj);
        checkBound(i, TtmlNode.START);
        this.startIndex = i;
        this.index = i;
    }

    public ArrayIterator(Object obj, int i, int i2) {
        this.startIndex = 0;
        this.endIndex = 0;
        this.index = 0;
        setArray(obj);
        checkBound(i, TtmlNode.START);
        checkBound(i2, TtmlNode.END);
        if (i2 < i) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
        this.startIndex = i;
        this.endIndex = i2;
        this.index = i;
    }

    protected void checkBound(int i, String str) {
        if (i > this.endIndex) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Attempt to make an ArrayIterator that ").append(str).append("s beyond the end of the array. ").toString());
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException(new StringBuffer().append("Attempt to make an ArrayIterator that ").append(str).append("s before the start of the array. ").toString());
        }
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
        Object obj = this.array;
        int i = this.index;
        this.index = i + 1;
        return Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    public Object getArray() {
        return this.array;
    }

    public void setArray(Object obj) {
        this.endIndex = Array.getLength(obj);
        this.startIndex = 0;
        this.array = obj;
        this.index = 0;
    }

    @Override // org.apache.commons.collections.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }
}
