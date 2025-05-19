package org.apache.xmlbeans.impl.jam;

import java.util.Iterator;

/* loaded from: classes5.dex */
public class JamClassIterator implements Iterator {
    private String[] mClassNames;
    private int mIndex = 0;
    private JamClassLoader mLoader;

    public JamClassIterator(JamClassLoader jamClassLoader, String[] strArr) {
        if (jamClassLoader == null) {
            throw new IllegalArgumentException("null loader");
        }
        if (strArr == null) {
            throw new IllegalArgumentException("null classes");
        }
        this.mLoader = jamClassLoader;
        this.mClassNames = strArr;
    }

    public JClass nextClass() {
        if (!hasNext()) {
            throw new IndexOutOfBoundsException();
        }
        int i = this.mIndex + 1;
        this.mIndex = i;
        return this.mLoader.loadClass(this.mClassNames[i - 1]);
    }

    @Override // java.util.Iterator
    public boolean hasNext() {
        return this.mIndex < this.mClassNames.length;
    }

    @Override // java.util.Iterator
    public Object next() {
        return nextClass();
    }

    public int getSize() {
        return this.mClassNames.length;
    }

    @Override // java.util.Iterator
    public void remove() {
        throw new UnsupportedOperationException();
    }
}
