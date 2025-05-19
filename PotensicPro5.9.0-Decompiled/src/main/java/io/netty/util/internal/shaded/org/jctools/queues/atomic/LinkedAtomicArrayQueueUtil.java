package io.netty.util.internal.shaded.org.jctools.queues.atomic;

import java.util.concurrent.atomic.AtomicReferenceArray;

/* loaded from: classes4.dex */
final class LinkedAtomicArrayQueueUtil {
    static int calcElementOffset(long j, long j2) {
        return (int) (j & j2);
    }

    static int modifiedCalcElementOffset(long j, long j2) {
        return ((int) (j & j2)) >> 1;
    }

    private LinkedAtomicArrayQueueUtil() {
    }

    public static <E> E lvElement(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return (E) AtomicReferenceArrayQueue.lvElement(atomicReferenceArray, i);
    }

    public static <E> E lpElement(AtomicReferenceArray<E> atomicReferenceArray, int i) {
        return (E) AtomicReferenceArrayQueue.lpElement(atomicReferenceArray, i);
    }

    public static <E> void spElement(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        AtomicReferenceArrayQueue.spElement(atomicReferenceArray, i, e);
    }

    public static <E> void svElement(AtomicReferenceArray<E> atomicReferenceArray, int i, E e) {
        AtomicReferenceArrayQueue.svElement(atomicReferenceArray, i, e);
    }

    static <E> void soElement(AtomicReferenceArray atomicReferenceArray, int i, Object obj) {
        atomicReferenceArray.lazySet(i, obj);
    }

    static <E> AtomicReferenceArray<E> allocate(int i) {
        return new AtomicReferenceArray<>(i);
    }

    static int length(AtomicReferenceArray<?> atomicReferenceArray) {
        return atomicReferenceArray.length();
    }

    static int nextArrayOffset(AtomicReferenceArray<?> atomicReferenceArray) {
        return length(atomicReferenceArray) - 1;
    }
}
