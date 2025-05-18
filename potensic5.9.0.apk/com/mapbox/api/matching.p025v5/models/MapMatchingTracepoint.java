package com.mapbox.api.matching.p025v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.matching.p025v5.models.AutoValue_MapMatchingTracepoint;
import com.mapbox.api.matching.p025v5.models.C$AutoValue_MapMatchingTracepoint;
import com.mapbox.geojson.Point;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class MapMatchingTracepoint implements Serializable {

    public static abstract class Builder {
        public abstract Builder alternativesCount(Integer num);

        public abstract MapMatchingTracepoint build();

        public abstract Builder matchingsIndex(Integer num);

        public abstract Builder name(String str);

        public abstract Builder rawLocation(double[] dArr);

        public abstract Builder waypointIndex(Integer num);
    }

    @SerializedName("alternatives_count")
    public abstract Integer alternativesCount();

    @SerializedName("matchings_index")
    public abstract Integer matchingsIndex();

    public abstract String name();

    @SerializedName("location")
    abstract double[] rawLocation();

    public abstract Builder toBuilder();

    @SerializedName("waypoint_index")
    public abstract Integer waypointIndex();

    public static Builder builder() {
        return new C$AutoValue_MapMatchingTracepoint.Builder();
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }

    public static TypeAdapter<MapMatchingTracepoint> typeAdapter(Gson gson) {
        return new AutoValue_MapMatchingTracepoint.GsonTypeAdapter(gson);
    }
}