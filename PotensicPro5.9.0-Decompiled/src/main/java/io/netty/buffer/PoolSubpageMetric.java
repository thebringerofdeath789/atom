package io.netty.buffer;

/* loaded from: classes3.dex */
public interface PoolSubpageMetric {
    int elementSize();

    int maxNumElements();

    int numAvailable();

    int pageSize();
}
