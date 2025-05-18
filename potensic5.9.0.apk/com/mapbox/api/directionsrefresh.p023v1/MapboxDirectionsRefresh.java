package com.mapbox.api.directionsrefresh.p023v1;

import com.google.gson.GsonBuilder;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directionsrefresh.p023v1.AutoValue_MapboxDirectionsRefresh;
import com.mapbox.api.directionsrefresh.p023v1.models.DirectionsRefreshResponse;
import com.mapbox.core.MapboxService;
import com.mapbox.core.utils.ApiCallHelper;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;

/* loaded from: classes3.dex */
public abstract class MapboxDirectionsRefresh extends MapboxService<DirectionsRefreshResponse, DirectionsRefreshService> {
    private static final int ZERO = 0;

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        public abstract Builder baseUrl(String str);

        public abstract MapboxDirectionsRefresh build();

        public abstract Builder clientAppName(String str);

        public abstract Builder interceptor(Interceptor interceptor);

        public abstract Builder legIndex(int i);

        public abstract Builder requestId(String str);

        public abstract Builder routeIndex(int i);
    }

    abstract String accessToken();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String clientAppName();

    abstract Interceptor interceptor();

    abstract int legIndex();

    abstract String requestId();

    abstract int routeIndex();

    public abstract Builder toBuilder();

    protected MapboxDirectionsRefresh() {
        super(DirectionsRefreshService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<DirectionsRefreshResponse> initializeCall() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), requestId(), routeIndex(), legIndex(), accessToken());
    }

    @Override // com.mapbox.core.MapboxService
    protected synchronized OkHttpClient getOkHttpClient() {
        if (this.okHttpClient == null) {
            OkHttpClient.Builder builder = new OkHttpClient.Builder();
            if (isEnableDebug()) {
                HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
                httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);
                builder.addInterceptor(httpLoggingInterceptor);
            }
            Interceptor interceptor = interceptor();
            if (interceptor != null) {
                builder.addInterceptor(interceptor);
            }
            this.okHttpClient = builder.build();
        }
        return this.okHttpClient;
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return super.getGsonBuilder().registerTypeAdapterFactory(DirectionsRefreshAdapterFactory.create()).registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    public static Builder builder() {
        return new AutoValue_MapboxDirectionsRefresh.Builder().baseUrl("https://api.mapbox.com").routeIndex(0).legIndex(0);
    }
}