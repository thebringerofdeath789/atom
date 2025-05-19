package com.mapbox.android.telemetry;

import java.io.IOException;
import okhttp3.Interceptor;
import okhttp3.MediaType;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okio.BufferedSink;
import okio.GzipSink;
import okio.Okio;

/* loaded from: classes3.dex */
final class GzipRequestInterceptor implements Interceptor {
    private static final int THREAD_ID = 10000;

    GzipRequestInterceptor() {
    }

    @Override // okhttp3.Interceptor
    public Response intercept(Interceptor.Chain chain) throws IOException {
        Request request = chain.request();
        if (request.body() == null || request.header("Content-Encoding") != null) {
            return chain.proceed(request);
        }
        return chain.proceed(request.newBuilder().header("Content-Encoding", "gzip").method(request.method(), gzip(request.body())).build());
    }

    private RequestBody gzip(final RequestBody requestBody) {
        return new RequestBody() { // from class: com.mapbox.android.telemetry.GzipRequestInterceptor.1
            @Override // okhttp3.RequestBody
            public long contentLength() {
                return -1L;
            }

            @Override // okhttp3.RequestBody
            /* renamed from: contentType */
            public MediaType getContentType() {
                return requestBody.getContentType();
            }

            @Override // okhttp3.RequestBody
            public void writeTo(BufferedSink bufferedSink) throws IOException {
                BufferedSink buffer = Okio.buffer(new GzipSink(bufferedSink));
                requestBody.writeTo(buffer);
                buffer.close();
            }
        };
    }
}
