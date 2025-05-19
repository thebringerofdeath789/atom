package com.mapbox.android.telemetry.metrics.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.mapbox.android.telemetry.metrics.TelemetryMetrics;

/* loaded from: classes3.dex */
public class NetworkUsageMetricsCollector {
    private static final int TYPE_NONE = -1;
    private final ConnectivityManager connectivityManager;
    private final TelemetryMetrics metrics;

    public NetworkUsageMetricsCollector(Context context, TelemetryMetrics telemetryMetrics) {
        this.connectivityManager = (ConnectivityManager) context.getSystemService("connectivity");
        this.metrics = telemetryMetrics;
    }

    void addRxBytes(long j) {
        this.metrics.addRxBytesForType(getActiveNetworkType(), j);
    }

    void addTxBytes(long j) {
        this.metrics.addTxBytesForType(getActiveNetworkType(), j);
    }

    private int getActiveNetworkType() {
        NetworkInfo activeNetworkInfo = this.connectivityManager.getActiveNetworkInfo();
        if (activeNetworkInfo == null) {
            return -1;
        }
        return activeNetworkInfo.getType();
    }
}
