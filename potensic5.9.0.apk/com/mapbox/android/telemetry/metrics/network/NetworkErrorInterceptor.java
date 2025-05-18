package com.mapbox.android.telemetry.metrics.network;

import com.mapbox.android.telemetry.metrics.TelemetryMetrics;
import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Response;

/* loaded from: classes3.dex */
public class NetworkErrorInterceptor implements Interceptor {
    private final int eventCount;
    private final TelemetryMetrics metrics;

    public NetworkErrorInterceptor(TelemetryMetrics telemetryMetrics, int i) {
        this.metrics = telemetryMetrics;
        this.eventCount = i;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Response proceed = chain.proceed(chain.request());
        this.metrics.add(TelemetryMetrics.EVENTS_TOTAL, this.eventCount);
        if (!proceed.isSuccessful()) {
            this.metrics.add(TelemetryMetrics.EVENTS_FAILED, this.eventCount);
        }
        return proceed;
    }
}