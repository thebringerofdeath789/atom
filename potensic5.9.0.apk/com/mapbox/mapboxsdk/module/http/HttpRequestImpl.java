package com.mapbox.mapboxsdk.module.http;

import android.os.Build;
import android.text.TextUtils;
import com.mapbox.mapboxsdk.BuildConfig;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.http.HttpIdentifier;
import com.mapbox.mapboxsdk.http.HttpLogger;
import com.mapbox.mapboxsdk.http.HttpRequest;
import com.mapbox.mapboxsdk.http.HttpRequestUrl;
import com.mapbox.mapboxsdk.http.HttpResponder;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.NoRouteToHostException;
import java.net.ProtocolException;
import java.net.SocketException;
import java.net.UnknownHostException;
import javax.net.ssl.SSLException;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Dispatcher;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.ResponseBody;

/* loaded from: classes3.dex */
public class HttpRequestImpl implements HttpRequest {
    static final OkHttpClient DEFAULT_CLIENT;
    static OkHttpClient client;
    private static final String userAgentString = HttpRequestUtil.toHumanReadableAscii(String.format("%s %s (%s) Android/%s (%s)", HttpIdentifier.getIdentifier(), BuildConfig.MAPBOX_VERSION_STRING, BuildConfig.GIT_REVISION_SHORT, Integer.valueOf(Build.VERSION.SDK_INT), Build.CPU_ABI));
    private Call call;

    static {
        OkHttpClient build = new OkHttpClient.Builder().dispatcher(getDispatcher()).build();
        DEFAULT_CLIENT = build;
        client = build;
    }

    @Override // com.mapbox.mapboxsdk.http.HttpRequest
    public void executeRequest(HttpResponder httpResponder, long j, String str, String str2, String str3, boolean z) {
        OkHttpCallback okHttpCallback = new OkHttpCallback(httpResponder);
        try {
            HttpUrl parse = HttpUrl.parse(str);
            if (parse == null) {
                HttpLogger.log(6, String.format("[HTTP] Unable to parse resourceUrl %s", str));
                return;
            }
            String buildResourceUrl = HttpRequestUrl.buildResourceUrl(parse.host().toLowerCase(MapboxConstants.MAPBOX_LOCALE), str, parse.querySize(), z);
            Request.Builder addHeader = new Request.Builder().url(buildResourceUrl).tag(buildResourceUrl.toLowerCase(MapboxConstants.MAPBOX_LOCALE)).addHeader("User-Agent", userAgentString);
            if (str2.length() > 0) {
                addHeader.addHeader("If-None-Match", str2);
            } else if (str3.length() > 0) {
                addHeader.addHeader("If-Modified-Since", str3);
            }
            Call newCall = client.newCall(addHeader.build());
            this.call = newCall;
            newCall.enqueue(okHttpCallback);
        } catch (Exception e) {
            okHttpCallback.handleFailure(this.call, e);
        }
    }

    @Override // com.mapbox.mapboxsdk.http.HttpRequest
    public void cancelRequest() {
        Call call = this.call;
        if (call != null) {
            HttpLogger.log(3, String.format("[HTTP] This request was cancelled (%s). This is expected for tiles that were being prefetched but are no longer needed for the map to render.", call.request().url()));
            this.call.cancel();
        }
    }

    public static void enablePrintRequestUrlOnFailure(boolean z) {
        HttpLogger.logRequestUrl = z;
    }

    public static void enableLog(boolean z) {
        HttpLogger.logEnabled = z;
    }

    public static void setOkHttpClient(OkHttpClient okHttpClient) {
        if (okHttpClient != null) {
            client = okHttpClient;
        } else {
            client = DEFAULT_CLIENT;
        }
    }

    private static class OkHttpCallback implements Callback {
        private HttpResponder httpRequest;

        OkHttpCallback(HttpResponder httpResponder) {
            this.httpRequest = httpResponder;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            handleFailure(call, iOException);
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) {
            if (response.isSuccessful()) {
                HttpLogger.log(2, String.format("[HTTP] Request was successful (code = %s).", Integer.valueOf(response.code())));
            } else {
                HttpLogger.log(3, String.format("[HTTP] Request with response = %s: %s", Integer.valueOf(response.code()), !TextUtils.isEmpty(response.message()) ? response.message() : "No additional information"));
            }
            ResponseBody body = response.body();
            try {
                if (body == null) {
                    HttpLogger.log(6, "[HTTP] Received empty response body");
                    return;
                }
                try {
                    byte[] bytes = body.bytes();
                    response.close();
                    this.httpRequest.onResponse(response.code(), response.header("ETag"), response.header("Last-Modified"), response.header("Cache-Control"), response.header("Expires"), response.header("Retry-After"), response.header("x-rate-limit-reset"), bytes);
                } catch (IOException e) {
                    onFailure(call, e);
                    response.close();
                }
            } catch (Throwable th) {
                response.close();
                throw th;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public void handleFailure(Call call, Exception exc) {
            String message = exc.getMessage() != null ? exc.getMessage() : "Error processing the request";
            int failureType = getFailureType(exc);
            if (HttpLogger.logEnabled && call != null && call.request() != null) {
                HttpLogger.logFailure(failureType, message, call.request().url().getUrl());
            }
            this.httpRequest.handleFailure(failureType, message);
        }

        private int getFailureType(Exception exc) {
            if ((exc instanceof NoRouteToHostException) || (exc instanceof UnknownHostException) || (exc instanceof SocketException) || (exc instanceof ProtocolException) || (exc instanceof SSLException)) {
                return 0;
            }
            return exc instanceof InterruptedIOException ? 1 : 2;
        }
    }

    private static Dispatcher getDispatcher() {
        Dispatcher dispatcher = new Dispatcher();
        if (Build.VERSION.SDK_INT >= 21) {
            dispatcher.setMaxRequestsPerHost(20);
        } else {
            dispatcher.setMaxRequestsPerHost(10);
        }
        return dispatcher;
    }
}