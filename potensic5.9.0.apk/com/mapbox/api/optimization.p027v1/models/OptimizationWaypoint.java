package com.mapbox.api.optimization.p027v1.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.optimization.p027v1.models.AutoValue_OptimizationWaypoint;
import com.mapbox.api.optimization.p027v1.models.C$AutoValue_OptimizationWaypoint;
import com.mapbox.geojson.Point;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class OptimizationWaypoint implements Serializable {

    public static abstract class Builder {
        public abstract OptimizationWaypoint build();

        public abstract Builder name(String str);

        public abstract Builder rawLocation(double[] dArr);

        public abstract Builder tripsIndex(int i);

        public abstract Builder waypointIndex(int i);
    }

    public abstract String name();

    @SerializedName("location")
    abstract double[] rawLocation();

    public abstract Builder toBuilder();

    @SerializedName("trips_index")
    public abstract int tripsIndex();

    @SerializedName("waypoint_index")
    public abstract int waypointIndex();

    public static Builder builder() {
        return new C$AutoValue_OptimizationWaypoint.Builder();
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }

    public static TypeAdapter<OptimizationWaypoint> typeAdapter(Gson gson) {
        return new AutoValue_OptimizationWaypoint.GsonTypeAdapter(gson);
    }
}