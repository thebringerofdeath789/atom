package org.apache.commons.collections;

/* loaded from: classes4.dex */
public interface OrderedMapIterator extends MapIterator, OrderedIterator {
    @Override // org.apache.commons.collections.OrderedIterator
    boolean hasPrevious();

    @Override // org.apache.commons.collections.OrderedIterator
    Object previous();
}
