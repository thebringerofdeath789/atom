package org.apache.commons.collections;

import java.util.Iterator;

/* loaded from: classes4.dex */
public interface MapIterator extends Iterator {
    Object getKey();

    Object getValue();

    @Override // java.util.Iterator
    boolean hasNext();

    @Override // java.util.Iterator
    Object next();

    @Override // java.util.Iterator
    void remove();

    Object setValue(Object obj);
}
