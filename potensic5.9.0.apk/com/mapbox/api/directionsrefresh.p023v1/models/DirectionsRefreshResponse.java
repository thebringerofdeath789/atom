package com.mapbox.api.directionsrefresh.p023v1.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directionsrefresh.p023v1.DirectionsRefreshAdapterFactory;
import com.mapbox.api.directionsrefresh.p023v1.models.AutoValue_DirectionsRefreshResponse;
import com.mapbox.api.directionsrefresh.p023v1.models.C$AutoValue_DirectionsRefreshResponse;
import com.mapbox.api.directionsrefresh.p023v1.models.DirectionsRefreshJsonObject;

/* loaded from: classes3.dex */
public abstract class DirectionsRefreshResponse extends DirectionsRefreshJsonObject {

    public static abstract class Builder extends DirectionsRefreshJsonObject.Builder<Builder> {
        public abstract DirectionsRefreshResponse build();

        public abstract Builder code(String str);

        public abstract Builder message(String str);

        public abstract Builder route(DirectionsRouteRefresh directionsRouteRefresh);
    }

    public abstract String code();

    public abstract String message();

    public abstract DirectionsRouteRefresh route();

    public static Builder builder() {
        return new C$AutoValue_DirectionsRefreshResponse.Builder();
    }

    public static TypeAdapter<DirectionsRefreshResponse> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsRefreshResponse.GsonTypeAdapter(gson);
    }

    public static DirectionsRefreshResponse fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsRefreshAdapterFactory.create()).registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (DirectionsRefreshResponse) gsonBuilder.create().fromJson(str, DirectionsRefreshResponse.class);
    }
}