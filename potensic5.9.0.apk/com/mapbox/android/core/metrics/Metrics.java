package com.mapbox.android.core.metrics;

/* loaded from: classes3.dex */
public interface Metrics {
    void add(long j);

    long getEnd();

    long getStart();

    long getValue();
}