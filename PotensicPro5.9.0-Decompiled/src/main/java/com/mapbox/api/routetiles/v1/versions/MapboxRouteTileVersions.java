package com.mapbox.api.routetiles.v1.versions;

import com.google.gson.GsonBuilder;
import com.mapbox.api.routetiles.v1.versions.AutoValue_MapboxRouteTileVersions;
import com.mapbox.api.routetiles.v1.versions.models.RouteTileVersionsAdapterFactory;
import com.mapbox.api.routetiles.v1.versions.models.RouteTileVersionsResponse;
import com.mapbox.core.MapboxService;
import com.mapbox.core.exceptions.ServicesException;
import com.mapbox.core.utils.ApiCallHelper;
import com.mapbox.core.utils.MapboxUtils;
import retrofit2.Call;

/* loaded from: classes3.dex */
public abstract class MapboxRouteTileVersions extends MapboxService<RouteTileVersionsResponse, RouteTileVersionsService> {
    abstract String accessToken();

    @Override // com.mapbox.core.MapboxService
    protected abstract String baseUrl();

    abstract String clientAppName();

    public abstract Builder toBuilder();

    protected MapboxRouteTileVersions() {
        super(RouteTileVersionsService.class);
    }

    @Override // com.mapbox.core.MapboxService
    protected GsonBuilder getGsonBuilder() {
        return new GsonBuilder().registerTypeAdapterFactory(RouteTileVersionsAdapterFactory.create());
    }

    @Override // com.mapbox.core.MapboxService
    protected Call<RouteTileVersionsResponse> initializeCall() {
        return getService().getCall(ApiCallHelper.getHeaderUserAgent(clientAppName()), accessToken());
    }

    public static Builder builder() {
        return new AutoValue_MapboxRouteTileVersions.Builder().baseUrl("https://api.mapbox.com");
    }

    public static abstract class Builder {
        public abstract Builder accessToken(String str);

        abstract MapboxRouteTileVersions autoBuild();

        public abstract Builder baseUrl(String str);

        public abstract Builder clientAppName(String str);

        public MapboxRouteTileVersions build() {
            MapboxRouteTileVersions autoBuild = autoBuild();
            if (MapboxUtils.isAccessTokenValid(autoBuild.accessToken())) {
                return autoBuild;
            }
            throw new ServicesException("Using Mapbox Services requires setting a valid access token.");
        }
    }
}
