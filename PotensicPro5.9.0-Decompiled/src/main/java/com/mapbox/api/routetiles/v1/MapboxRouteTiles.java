package com.mapbox.api.routetiles.v1;

import com.mapbox.api.routetiles.v1.AutoValue_MapboxRouteTiles;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.ApiCallHelper;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.geojson.BoundingBox;
import java.util.Locale;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;

/* loaded from: classes3.dex */
public abstract class MapboxRouteTiles extends MapboxService<ResponseBody, RouteTilesService> {
    abstract String accessToken();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract BoundingBox boundingBox();

    abstract String clientAppName();

    abstract Interceptor interceptor();

    abstract Interceptor networkInterceptor();

    public abstract Builder toBuilder();

    abstract String version();

    protected MapboxRouteTiles() {
        super(RouteTilesService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<ResponseBody> initializeCall() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), formatBoundingBox(boundingBox()), version(), accessToken());
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
            this.okHttpClient = builder.build();
        }
        return this.okHttpClient;
    }

    public static Builder builder() {
        return new AutoValue_MapboxRouteTiles.Builder().baseUrl("https://api.mapbox.com");
    }

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        abstract MapboxRouteTiles autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder boundingBox(BoundingBox boundingBox);

        public abstract Builder clientAppName(String str);

        public abstract Builder interceptor(Interceptor interceptor);

        public abstract Builder networkInterceptor(Interceptor interceptor);

        public abstract Builder version(String str);

        public MapboxRouteTiles build() {
            MapboxRouteTiles autoBuild = autoBuild();
            if (MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                return autoBuild;
            }
            throw new ServicesException("Using Mapbox Services requires setting a valid access token.");
        }
    }

    private String formatBoundingBox(BoundingBox boundingBox) {
        return String.format(Locale.US, "%f,%f;%f,%f", Double.valueOf(boundingBox.west()), Double.valueOf(boundingBox.south()), Double.valueOf(boundingBox.east()), Double.valueOf(boundingBox.north()));
    }
}
