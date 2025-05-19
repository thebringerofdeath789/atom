package com.mapbox.android.telemetry.metrics;

import android.content.Context;
import java.util.concurrent.TimeUnit;

/* loaded from: classes3.dex */
public class TelemetryMetricsClient {
    private static final String TELEMETRY_METRICS_USER_AGENT = "mapbox-android-metrics";
    private static final Object lock = new Object();
    private static TelemetryMetricsClient telemetryMetricsClient;
    private final TelemetryMetrics telemetryMetrics;

    TelemetryMetricsClient(TelemetryMetrics telemetryMetrics) {
        this.telemetryMetrics = telemetryMetrics;
    }

    public static TelemetryMetricsClient install(Context context) {
        if (context.getApplicationContext() != null) {
            context.getApplicationContext();
        }
        TelemetryMetrics telemetryMetrics = new TelemetryMetrics(TimeUnit.HOURS.toMillis(24L));
        synchronized (lock) {
            if (telemetryMetricsClient == null) {
                telemetryMetricsClient = new TelemetryMetricsClient(telemetryMetrics);
            }
        }
        return telemetryMetricsClient;
    }

    public static TelemetryMetricsClient getInstance() {
        TelemetryMetricsClient telemetryMetricsClient2;
        synchronized (lock) {
            telemetryMetricsClient2 = telemetryMetricsClient;
            if (telemetryMetricsClient2 == null) {
                throw new IllegalStateException("TelemetryMetricsClient is not installed.");
            }
        }
        return telemetryMetricsClient2;
    }

    public TelemetryMetrics getMetrics() {
        return this.telemetryMetrics;
    }
}
