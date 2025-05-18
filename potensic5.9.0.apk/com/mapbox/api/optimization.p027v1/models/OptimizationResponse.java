package com.mapbox.api.optimization.p027v1.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.models.DirectionsRoute;
import com.mapbox.api.optimization.p027v1.models.AutoValue_OptimizationResponse;
import com.mapbox.api.optimization.p027v1.models.C$AutoValue_OptimizationResponse;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class OptimizationResponse implements Serializable {

    public static abstract class Builder {
        public abstract OptimizationResponse build();

        public abstract Builder code(String str);

        public abstract Builder trips(List<DirectionsRoute> list);

        public abstract Builder waypoints(List<OptimizationWaypoint> list);
    }

    public abstract String code();

    public abstract Builder toBuilder();

    public abstract List<DirectionsRoute> trips();

    public abstract List<OptimizationWaypoint> waypoints();

    public static Builder builder() {
        return new C$AutoValue_OptimizationResponse.Builder();
    }

    public static TypeAdapter<OptimizationResponse> typeAdapter(Gson gson) {
        return new AutoValue_OptimizationResponse.GsonTypeAdapter(gson);
    }
}