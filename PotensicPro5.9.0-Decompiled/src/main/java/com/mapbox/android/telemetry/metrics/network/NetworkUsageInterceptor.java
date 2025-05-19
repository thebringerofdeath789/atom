package com.mapbox.android.telemetry.metrics.network;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class NetworkUsageInterceptor implements Interceptor {
    private final NetworkUsageMetricsCollector metricsCollector;

    public NetworkUsageInterceptor(NetworkUsageMetricsCollector networkUsageMetricsCollector) {
        this.metricsCollector = networkUsageMetricsCollector;
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        RequestBody body = request.body();
        if (body == null) {
            return chain.proceed(request);
        }
        try {
            Response proceed = chain.proceed(request);
            this.metricsCollector.addTxBytes(body.contentLength());
            ResponseBody body2 = proceed.body();
            if (body2 == null) {
                return proceed;
            }
            this.metricsCollector.addRxBytes(body2.getContentLength());
            return proceed;
        } catch (IOException e) {
            throw e;
        }
    }
}
