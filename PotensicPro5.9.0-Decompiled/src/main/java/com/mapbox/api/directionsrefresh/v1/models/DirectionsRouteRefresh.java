package com.mapbox.api.directionsrefresh.v1.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directionsrefresh.v1.DirectionsRefreshAdapterFactory;
import com.mapbox.api.directionsrefresh.v1.models.AutoValue_DirectionsRouteRefresh;
import com.mapbox.api.directionsrefresh.v1.models.C$AutoValue_DirectionsRouteRefresh;
import com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class DirectionsRouteRefresh extends DirectionsRefreshJsonObject {

    public static abstract class Builder extends DirectionsRefreshJsonObject.Builder<Builder> {
        public abstract DirectionsRouteRefresh build();

        public abstract Builder legs(List<RouteLegRefresh> list);
    }

    public abstract List<RouteLegRefresh> legs();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_DirectionsRouteRefresh.Builder();
    }

    public static TypeAdapter<DirectionsRouteRefresh> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsRouteRefresh.GsonTypeAdapter(gson);
    }

    public static DirectionsRouteRefresh fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsRefreshAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (DirectionsRouteRefresh) gsonBuilder.create().fromJson(str, DirectionsRouteRefresh.class);
    }
}
