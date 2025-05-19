package org.apache.commons.collections;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes4.dex */
public interface Bag extends Collection {
    @Override // java.util.Collection
    boolean add(Object obj);

    boolean add(Object obj, int i);

    @Override // java.util.Collection
    boolean containsAll(Collection collection);

    int getCount(Object obj);

    @Override // java.util.Collection, java.lang.Iterable
    Iterator iterator();

    @Override // java.util.Collection
    boolean remove(Object obj);

    boolean remove(Object obj, int i);

    @Override // java.util.Collection
    boolean removeAll(Collection collection);

    @Override // java.util.Collection
    boolean retainAll(Collection collection);

    @Override // java.util.Collection
    int size();

    Set uniqueSet();
}
