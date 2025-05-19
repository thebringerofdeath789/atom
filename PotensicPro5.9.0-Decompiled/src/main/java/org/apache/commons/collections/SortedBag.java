package org.apache.commons.collections;

import java.util.Comparator;

/* loaded from: classes4.dex */
public interface SortedBag extends Bag {
    Comparator comparator();

    Object first();

    Object last();
}
