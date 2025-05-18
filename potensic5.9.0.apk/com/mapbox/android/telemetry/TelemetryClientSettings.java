package com.mapbox.android.telemetry;

import android.content.Context;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.X509TrustManager;
import okhttp3.ConnectionSpec;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;

/* loaded from: classes3.dex */
class TelemetryClientSettings {
    private static final Map<Environment, String> HOSTS = new HashMap<Environment, String>() { // from class: com.mapbox.android.telemetry.TelemetryClientSettings.1
        {
            put(Environment.STAGING, MapboxTelemetryConstants.DEFAULT_STAGING_EVENTS_HOST);
            put(Environment.COM, MapboxTelemetryConstants.DEFAULT_COM_EVENTS_HOST);
            put(Environment.CHINA, MapboxTelemetryConstants.DEFAULT_CHINA_EVENTS_HOST);
        }
    };
    private static final String HTTPS_SCHEME = "https";
    private final HttpUrl baseUrl;
    private final OkHttpClient client;
    private final Context context;
    private boolean debugLoggingEnabled;
    private Environment environment;
    private final HostnameVerifier hostnameVerifier;
    private final SSLSocketFactory sslSocketFactory;
    private final X509TrustManager x509TrustManager;

    private boolean isSocketFactoryUnset(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
        return (sSLSocketFactory == null || x509TrustManager == null) ? false : true;
    }

    TelemetryClientSettings(Builder builder) {
        this.context = builder.context;
        this.environment = builder.environment;
        this.client = builder.client;
        this.baseUrl = builder.baseUrl;
        this.sslSocketFactory = builder.sslSocketFactory;
        this.x509TrustManager = builder.x509TrustManager;
        this.hostnameVerifier = builder.hostnameVerifier;
        this.debugLoggingEnabled = builder.debugLoggingEnabled;
    }

    Environment getEnvironment() {
        return this.environment;
    }

    OkHttpClient getClient(CertificateBlacklist certificateBlacklist, int i) {
        return configureHttpClient(certificateBlacklist, new Interceptor[]{new GzipRequestInterceptor()});
    }

    OkHttpClient getAttachmentClient(CertificateBlacklist certificateBlacklist) {
        return configureHttpClient(certificateBlacklist, null);
    }

    HttpUrl getBaseUrl() {
        return this.baseUrl;
    }

    boolean isDebugLoggingEnabled() {
        return this.debugLoggingEnabled;
    }

    Builder toBuilder() {
        return new Builder(this.context).environment(this.environment).client(this.client).baseUrl(this.baseUrl).sslSocketFactory(this.sslSocketFactory).x509TrustManager(this.x509TrustManager).hostnameVerifier(this.hostnameVerifier).debugLoggingEnabled(this.debugLoggingEnabled);
    }

    static HttpUrl configureUrlHostname(String str) {
        HttpUrl.Builder scheme = new HttpUrl.Builder().scheme(HTTPS_SCHEME);
        scheme.host(str);
        return scheme.build();
    }

    static final class Builder {
        Context context;
        Environment environment = Environment.COM;
        OkHttpClient client = new OkHttpClient();
        HttpUrl baseUrl = null;
        SSLSocketFactory sslSocketFactory = null;
        X509TrustManager x509TrustManager = null;
        HostnameVerifier hostnameVerifier = null;
        boolean debugLoggingEnabled = false;

        Builder(Context context) {
            this.context = context;
        }

        Builder environment(Environment environment) {
            this.environment = environment;
            return this;
        }

        Builder client(OkHttpClient okHttpClient) {
            if (okHttpClient != null) {
                this.client = okHttpClient;
            }
            return this;
        }

        Builder baseUrl(HttpUrl httpUrl) {
            if (httpUrl != null) {
                this.baseUrl = httpUrl;
            }
            return this;
        }

        Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            this.sslSocketFactory = sSLSocketFactory;
            return this;
        }

        Builder x509TrustManager(X509TrustManager x509TrustManager) {
            this.x509TrustManager = x509TrustManager;
            return this;
        }

        Builder hostnameVerifier(HostnameVerifier hostnameVerifier) {
            this.hostnameVerifier = hostnameVerifier;
            return this;
        }

        Builder debugLoggingEnabled(boolean z) {
            this.debugLoggingEnabled = z;
            return this;
        }

        TelemetryClientSettings build() {
            if (this.baseUrl == null) {
                this.baseUrl = TelemetryClientSettings.configureUrlHostname((String) TelemetryClientSettings.HOSTS.get(this.environment));
            }
            return new TelemetryClientSettings(this);
        }
    }

    private OkHttpClient configureHttpClient(CertificateBlacklist certificateBlacklist, Interceptor[] interceptorArr) {
        OkHttpClient.Builder connectionSpecs = this.client.newBuilder().retryOnConnectionFailure(true).certificatePinner(new CertificatePinnerFactory().provideCertificatePinnerFor(this.environment, certificateBlacklist)).connectionSpecs(Arrays.asList(ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS));
        if (interceptorArr != null) {
            for (Interceptor interceptor : interceptorArr) {
                connectionSpecs.addInterceptor(interceptor);
            }
        }
        if (isSocketFactoryUnset(this.sslSocketFactory, this.x509TrustManager)) {
            connectionSpecs.sslSocketFactory(this.sslSocketFactory, this.x509TrustManager);
            connectionSpecs.hostnameVerifier(this.hostnameVerifier);
        }
        return connectionSpecs.build();
    }
}