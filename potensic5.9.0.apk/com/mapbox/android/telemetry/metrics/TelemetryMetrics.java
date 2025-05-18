package com.mapbox.android.telemetry.metrics;

import com.mapbox.android.core.metrics.AbstractCompositeMetrics;
import com.mapbox.android.core.metrics.Metrics;
import com.mapbox.android.core.metrics.MetricsImpl;

/* loaded from: classes3.dex */
public class TelemetryMetrics extends AbstractCompositeMetrics {
    public static final String EVENTS_FAILED = "eventCountFailed";
    public static final String EVENTS_TOTAL = "eventCountTotal";
    static final String MOBILE_BYTES_RX = "cellDataReceived";
    static final String MOBILE_BYTES_TX = "cellDataSent";
    static final String WIFI_BYTES_RX = "wifiDataReceived";
    static final String WIFI_BYTES_TX = "wifiDataSent";

    private static boolean isValidNetworkType(int i) {
        return i >= 0 && i <= 17;
    }

    public TelemetryMetrics(long j) {
        super(j);
    }

    public void addRxBytesForType(int i, long j) {
        if (isValidNetworkType(i)) {
            add(i == 1 ? WIFI_BYTES_RX : MOBILE_BYTES_RX, j);
        }
    }

    public void addTxBytesForType(int i, long j) {
        if (isValidNetworkType(i)) {
            add(i == 1 ? WIFI_BYTES_TX : MOBILE_BYTES_TX, j);
        }
    }

    @Override // com.mapbox.android.core.metrics.AbstractCompositeMetrics
    protected Metrics nextMetrics(long j, long j2) {
        return new MetricsImpl(j, j2);
    }
}