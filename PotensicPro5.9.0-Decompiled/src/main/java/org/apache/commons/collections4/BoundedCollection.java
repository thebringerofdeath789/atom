package org.apache.commons.collections4;

import java.util.Collection;

/* loaded from: classes4.dex */
public interface BoundedCollection<E> extends Collection<E> {
    boolean isFull();

    int maxSize();
}
