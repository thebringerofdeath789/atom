package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_DirectionsWaypoint;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_DirectionsWaypoint;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import com.mapbox.geojson.Point;

/* loaded from: classes3.dex */
public abstract class DirectionsWaypoint extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract DirectionsWaypoint build();

        public abstract Builder distance(Double d);

        public abstract Builder name(String str);

        public abstract Builder rawLocation(double[] dArr);
    }

    public abstract Double distance();

    public abstract String name();

    @SerializedName("location")
    abstract double[] rawLocation();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_DirectionsWaypoint.Builder();
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }

    public static TypeAdapter<DirectionsWaypoint> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsWaypoint.GsonTypeAdapter(gson);
    }

    public static DirectionsWaypoint fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (DirectionsWaypoint) gsonBuilder.create().fromJson(str, DirectionsWaypoint.class);
    }
}