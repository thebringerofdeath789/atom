package io.netty.util.internal;

import java.util.Queue;

/* loaded from: classes4.dex */
public interface PriorityQueue<T> extends Queue<T> {
    void clearIgnoringIndexes();

    boolean containsTyped(T t);

    void priorityChanged(T t);

    boolean removeTyped(T t);
}
