package org.apache.commons.collections4;

import java.util.Comparator;

/* loaded from: classes4.dex */
public interface SortedBag<E> extends Bag<E> {
    Comparator<? super E> comparator();

    E first();

    E last();
}
