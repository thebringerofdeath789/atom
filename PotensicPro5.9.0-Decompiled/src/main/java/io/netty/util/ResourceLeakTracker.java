package io.netty.util;

/* loaded from: classes4.dex */
public interface ResourceLeakTracker<T> {
    boolean close(T t);

    void record();

    void record(Object obj);
}
