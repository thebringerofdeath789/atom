package org.apache.commons.collections;

import java.util.Iterator;

/* loaded from: classes4.dex */
public interface OrderedIterator extends Iterator {
    boolean hasPrevious();

    Object previous();
}
