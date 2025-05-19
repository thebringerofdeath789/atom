package com.mapbox.api.directionsrefresh.v1.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.Closure;
import com.mapbox.api.directions.v5.models.Incident;
import com.mapbox.api.directions.v5.models.LegAnnotation;
import com.mapbox.api.directionsrefresh.v1.DirectionsRefreshAdapterFactory;
import com.mapbox.api.directionsrefresh.v1.models.AutoValue_RouteLegRefresh;
import com.mapbox.api.directionsrefresh.v1.models.C$AutoValue_RouteLegRefresh;
import com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class RouteLegRefresh extends DirectionsRefreshJsonObject {

    public static abstract class Builder extends DirectionsRefreshJsonObject.Builder<Builder> {
        public abstract Builder annotation(LegAnnotation legAnnotation);

        public abstract RouteLegRefresh build();

        public abstract Builder closures(List<Closure> list);

        public abstract Builder incidents(List<Incident> list);
    }

    public abstract LegAnnotation annotation();

    public abstract List<Closure> closures();

    public abstract List<Incident> incidents();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_RouteLegRefresh.Builder();
    }

    public static TypeAdapter<RouteLegRefresh> typeAdapter(Gson gson) {
        return new AutoValue_RouteLegRefresh.GsonTypeAdapter(gson);
    }

    public static RouteLegRefresh fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(DirectionsRefreshAdapterFactory.create());
        return (RouteLegRefresh) gsonBuilder.create().fromJson(str, RouteLegRefresh.class);
    }
}
