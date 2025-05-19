package org.apache.commons.collections4.iterators;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import java.lang.reflect.Array;
import java.util.NoSuchElementException;
import org.apache.commons.collections4.ResettableIterator;

/* loaded from: classes4.dex */
public class ArrayIterator<E> implements ResettableIterator<E> {
    final Object array;
    final int endIndex;
    int index;
    final int startIndex;

    public ArrayIterator(Object obj) {
        this(obj, 0);
    }

    public ArrayIterator(Object obj, int i) {
        this(obj, i, Array.getLength(obj));
    }

    public ArrayIterator(Object obj, int i, int i2) {
        this.index = 0;
        this.array = obj;
        this.startIndex = i;
        this.endIndex = i2;
        this.index = i;
        int length = Array.getLength(obj);
        checkBound(i, length, TtmlNode.START);
        checkBound(i2, length, TtmlNode.END);
        if (i2 < i) {
            throw new IllegalArgumentException("End index must not be less than start index.");
        }
    }

    protected void checkBound(int i, int i2, String str) {
        if (i > i2) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s beyond the end of the array. ");
        }
        if (i < 0) {
            throw new ArrayIndexOutOfBoundsException("Attempt to make an ArrayIterator that " + str + "s before the start of the array. ");
        }
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.index < this.endIndex;
    }

    @Override // java.util.Iterator
    public E next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        Object obj = this.array;
        int i = this.index;
        this.index = i + 1;
        return (E) Array.get(obj, i);
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException("remove() method is not supported");
    }

    public Object getArray() {
        return this.array;
    }

    public int getStartIndex() {
        return this.startIndex;
    }

    public int getEndIndex() {
        return this.endIndex;
    }

    @Override // org.apache.commons.collections4.ResettableIterator
    public void reset() {
        this.index = this.startIndex;
    }
}
