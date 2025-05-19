package com.mapbox.android.core.metrics;

import android.os.SystemClock;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/* loaded from: classes3.dex */
public abstract class AbstractCompositeMetrics {
    private final long maxLength;
    private final Map<String, Deque<Metrics>> metricsMap = new ConcurrentHashMap();

    protected abstract Metrics nextMetrics(long j, long j2);

    public AbstractCompositeMetrics(long j) {
        this.maxLength = j;
    }

    public void add(String str, long j) {
        Metrics last;
        long uptimeMillis = SystemClock.uptimeMillis();
        synchronized (this) {
            Deque<Metrics> orCreateMetrics = getOrCreateMetrics(str.trim());
            if (uptimeMillis >= orCreateMetrics.getLast().getEnd()) {
                orCreateMetrics.add(nextMetrics(uptimeMillis, this.maxLength + uptimeMillis));
            }
            last = orCreateMetrics.getLast();
        }
        last.add(j);
    }

    public Metrics getMetrics(String str) {
        Metrics pop;
        Deque<Metrics> deque = this.metricsMap.get(str.trim());
        synchronized (this) {
            if (deque != null) {
                try {
                    pop = deque.isEmpty() ? null : deque.pop();
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        return pop;
    }

    private Deque<Metrics> getOrCreateMetrics(String str) {
        Deque<Metrics> deque = this.metricsMap.get(str);
        if (deque == null) {
            deque = new ArrayDeque<>();
            this.metricsMap.put(str, deque);
        }
        if (deque.isEmpty()) {
            long uptimeMillis = SystemClock.uptimeMillis();
            deque.add(nextMetrics(uptimeMillis, this.maxLength + uptimeMillis));
        }
        return deque;
    }
}
