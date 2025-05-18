package com.mapbox.api.tilequery;

import com.google.gson.GsonBuilder;
import com.mapbox.api.tilequery.AutoValue_MapboxTilequery;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.MapboxUtils;
import com.mapbox.core.utils.TextUtils;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.GeometryAdapterFactory;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/* loaded from: classes3.dex */
public abstract class MapboxTilequery extends MapboxService<FeatureCollection, TilequeryService> {
    private Call<List<FeatureCollection>> batchCall;

    abstract String accessToken();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract Boolean dedupe();

    abstract String geometry();

    abstract String layers();

    abstract Integer limit();

    abstract String query();

    abstract Integer radius();

    abstract String tilesetIds();

    protected MapboxTilequery() {
        super(TilequeryService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(GeoJsonAdapterFactory.create()).registerTypeAdapterFactory(GeometryAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<FeatureCollection> initializeCall() {
        return getService().getCall(tilesetIds(), query(), accessToken(), radius(), limit(), dedupe(), geometry(), layers());
    }

    private Call<List<FeatureCollection>> getBatchCall() {
        Call<List<FeatureCollection>> call = this.batchCall;
        if (call != null) {
            return call;
        }
        Call<List<FeatureCollection>> batchCall = getService().getBatchCall(tilesetIds(), query(), accessToken(), radius(), limit(), dedupe(), geometry(), layers());
        this.batchCall = batchCall;
        return batchCall;
    }

    public Response<List<FeatureCollection>> executeBatchCall() throws IOException {
        return getBatchCall().execute();
    }

    public void enqueueBatchCall(Callback<List<FeatureCollection>> callback) {
        getBatchCall().enqueue(callback);
    }

    public void cancelBatchCall() {
        getBatchCall().cancel();
    }

    public Call<List<FeatureCollection>> cloneBatchCall() {
        return getBatchCall().mo4154clone();
    }

    public static Builder builder() {
        return new AutoValue_MapboxTilequery.Builder().baseUrl("https://api.mapbox.com");
    }

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        abstract MapboxTilequery autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder dedupe(Boolean bool);

        public abstract Builder geometry(String str);

        public abstract Builder layers(String str);

        public abstract Builder limit(Integer num);

        public abstract Builder query(String str);

        public abstract Builder radius(Integer num);

        public abstract Builder tilesetIds(String str);

        public Builder query(Point point) {
            query(String.format(Locale.US, "%s,%s", TextUtils.formatCoordinate(point.longitude()), TextUtils.formatCoordinate(point.latitude())));
            String.format(Locale.US, "%s,%s", TextUtils.formatCoordinate(point.longitude()), TextUtils.formatCoordinate(point.latitude()));
            return this;
        }

        public MapboxTilequery build() {
            MapboxTilequery autoBuild = autoBuild();
            if (!MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                throw new ServicesException("Using Mapbox Services requires setting a valid access token.");
            }
            if (autoBuild.query().isEmpty()) {
                throw new ServicesException("A query with latitude and longitude values is required.");
            }
            return autoBuild;
        }
    }
}