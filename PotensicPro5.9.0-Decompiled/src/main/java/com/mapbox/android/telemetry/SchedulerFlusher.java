package com.mapbox.android.telemetry;

/* loaded from: classes3.dex */
interface SchedulerFlusher {
    void register();

    void schedule(long j);

    void unregister();
}
