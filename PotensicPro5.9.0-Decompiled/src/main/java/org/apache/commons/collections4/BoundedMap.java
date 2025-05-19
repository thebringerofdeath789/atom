package org.apache.commons.collections4;

/* loaded from: classes4.dex */
public interface BoundedMap<K, V> extends IterableMap<K, V> {
    boolean isFull();

    int maxSize();
}
