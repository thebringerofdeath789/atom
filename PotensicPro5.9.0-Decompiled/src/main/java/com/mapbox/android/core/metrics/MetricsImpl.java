package com.mapbox.android.core.metrics;

import java.util.concurrent.atomic.AtomicLong;

/* loaded from: classes3.dex */
public class MetricsImpl implements Metrics {
    private final long end;
    private final long start;
    private final AtomicLong value;

    MetricsImpl(long j, long j2, long j3) {
        if (j > j2) {
            this.start = j2;
            this.end = j;
        } else {
            this.start = j;
            this.end = j2;
        }
        this.value = new AtomicLong(j3);
    }

    public MetricsImpl(long j, long j2) {
        this(j, j2, 0L);
    }

    @Override // com.mapbox.android.core.metrics.Metrics
    public void add(long j) {
        this.value.addAndGet(j);
    }

    @Override // com.mapbox.android.core.metrics.Metrics
    public long getValue() {
        return this.value.get();
    }

    @Override // com.mapbox.android.core.metrics.Metrics
    public long getStart() {
        return this.start;
    }

    @Override // com.mapbox.android.core.metrics.Metrics
    public long getEnd() {
        return this.end;
    }
}
