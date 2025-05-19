package com.mapbox.api.directions.v5;

import com.google.gson.GsonBuilder;
import com.mapbox.api.directions.v5.AutoValue_MapboxDirections;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.api.directions.v5.models.RouteOptions;
import com.mapbox.core.MapboxService;
import com.mapbox.core.utils.ApiCallHelper;
import java.io.IOException;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes3.dex */
public abstract class MapboxDirections extends MapboxService<DirectionsResponse, DirectionsService> {

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        public abstract MapboxDirections build();

        public abstract Builder clientAppName(String str);

        public abstract Builder eventListener(EventListener eventListener);

        public abstract Builder interceptor(Interceptor interceptor);

        public abstract Builder networkInterceptor(Interceptor interceptor);

        public abstract Builder routeOptions(RouteOptions routeOptions);

        public abstract Builder usePostMethod(Boolean bool);
    }

    abstract String accessToken();

    abstract String clientAppName();

    abstract EventListener eventListener();

    abstract Interceptor interceptor();

    abstract Interceptor networkInterceptor();

    abstract RouteOptions routeOptions();

    public abstract Builder toBuilder();

    abstract Boolean usePostMethod();

    protected MapboxDirections() {
        super(DirectionsService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected String baseUrl() {
        return routeOptions().baseUrl();
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<DirectionsResponse> initializeCall() {
        if (usePostMethod() == null) {
            return callForUrlLength();
        }
        if (usePostMethod().booleanValue()) {
            return post();
        }
        return get();
    }

    private Call<DirectionsResponse> callForUrlLength() {
        Call<DirectionsResponse> call = get();
        return call.request().url().getUrl().length() < 8192 ? call : post();
    }

    private Call<DirectionsResponse> get() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), routeOptions().user(), routeOptions().profile(), routeOptions().coordinates(), accessToken(), routeOptions().alternatives(), routeOptions().geometries(), routeOptions().overview(), routeOptions().radiuses(), routeOptions().steps(), routeOptions().bearings(), routeOptions().avoidManeuverRadius(), routeOptions().layers(), routeOptions().continueStraight(), routeOptions().annotations(), routeOptions().language(), routeOptions().roundaboutExits(), routeOptions().voiceInstructions(), routeOptions().bannerInstructions(), routeOptions().voiceUnits(), routeOptions().exclude(), routeOptions().include(), routeOptions().approaches(), routeOptions().waypointIndices(), routeOptions().waypointNames(), routeOptions().waypointTargets(), routeOptions().enableRefresh(), routeOptions().walkingSpeed(), routeOptions().walkwayBias(), routeOptions().alleyBias(), routeOptions().snappingIncludeClosures(), routeOptions().snappingIncludeStaticClosures(), routeOptions().arriveBy(), routeOptions().departAt(), routeOptions().maxHeight(), routeOptions().maxWidth(), routeOptions().maxWeight(), routeOptions().computeTollCost(), routeOptions().metadata());
    }

    private Call<DirectionsResponse> post() {
        return getService().postCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), routeOptions().user(), routeOptions().profile(), routeOptions().coordinates(), accessToken(), routeOptions().alternatives(), routeOptions().geometries(), routeOptions().overview(), routeOptions().radiuses(), routeOptions().steps(), routeOptions().bearings(), routeOptions().avoidManeuverRadius(), routeOptions().layers(), routeOptions().continueStraight(), routeOptions().annotations(), routeOptions().language(), routeOptions().roundaboutExits(), routeOptions().voiceInstructions(), routeOptions().bannerInstructions(), routeOptions().voiceUnits(), routeOptions().exclude(), routeOptions().include(), routeOptions().approaches(), routeOptions().waypointIndices(), routeOptions().waypointNames(), routeOptions().waypointTargets(), routeOptions().enableRefresh(), routeOptions().walkingSpeed(), routeOptions().walkwayBias(), routeOptions().alleyBias(), routeOptions().snappingIncludeClosures(), routeOptions().snappingIncludeStaticClosures(), routeOptions().arriveBy(), routeOptions().departAt(), routeOptions().maxHeight(), routeOptions().maxWidth(), routeOptions().maxWeight(), routeOptions().computeTollCost(), routeOptions().metadata());
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return super.getGsonBuilder().registerTypeAdapterFactory(DirectionsAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    public Response<DirectionsResponse> executeCall() throws IOException {
        return DirectionsResponseFactory.generate(routeOptions(), super.executeCall());
    }

    @Override // com.mapbox.core.MapboxService
    public void enqueueCall(final Callback<DirectionsResponse> callback) {
        getCall().enqueue(new Callback<DirectionsResponse>() { // from class: com.mapbox.api.directions.v5.MapboxDirections.1
            @Override // retrofit2.Callback
            public void onResponse(Call<DirectionsResponse> call, Response<DirectionsResponse> response) {
                callback.onResponse(call, DirectionsResponseFactory.generate(MapboxDirections.this.routeOptions(), response));
            }

            @Override // retrofit2.Callback
            public void onFailure(Call<DirectionsResponse> call, Throwable th) {
                callback.onFailure(call, th);
            }
        });
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
            Interceptor networkInterceptor = networkInterceptor();
            if (networkInterceptor != null) {
                builder.addNetworkInterceptor(networkInterceptor);
            }
            EventListener eventListener = eventListener();
            if (eventListener != null) {
                builder.eventListener(eventListener);
            }
            this.okHttpClient = builder.build();
        }
        return this.okHttpClient;
    }

    public static Builder builder() {
        return new AutoValue_MapboxDirections.Builder();
    }
}
