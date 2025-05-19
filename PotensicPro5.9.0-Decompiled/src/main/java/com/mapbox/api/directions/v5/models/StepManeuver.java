package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_StepManeuver;
import com.mapbox.api.directions.v5.models.C$AutoValue_StepManeuver;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import com.mapbox.geojson.Point;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/* loaded from: classes3.dex */
public abstract class StepManeuver extends DirectionsJsonObject {
    public static final String ARRIVE = "arrive";
    public static final String CONTINUE = "continue";
    public static final String DEPART = "depart";
    public static final String END_OF_ROAD = "end of road";
    public static final String EXIT_ROTARY = "exit rotary";
    public static final String EXIT_ROUNDABOUT = "exit roundabout";
    public static final String FORK = "fork";
    public static final String MERGE = "merge";
    public static final String NEW_NAME = "new name";
    public static final String NOTIFICATION = "notification";
    public static final String OFF_RAMP = "off ramp";
    public static final String ON_RAMP = "on ramp";
    public static final String ROTARY = "rotary";
    public static final String ROUNDABOUT = "roundabout";
    public static final String ROUNDABOUT_TURN = "roundabout turn";
    public static final String TURN = "turn";

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder bearingAfter(Double d);

        public abstract Builder bearingBefore(Double d);

        public abstract StepManeuver build();

        public abstract Builder exit(Integer num);

        public abstract Builder instruction(String str);

        public abstract Builder modifier(String str);

        public abstract Builder rawLocation(double[] dArr);

        public abstract Builder type(String str);
    }

    @Retention(RetentionPolicy.CLASS)
    public @interface StepManeuverType {
    }

    @SerializedName("bearing_after")
    public abstract Double bearingAfter();

    @SerializedName("bearing_before")
    public abstract Double bearingBefore();

    public abstract Integer exit();

    public abstract String instruction();

    public abstract String modifier();

    @SerializedName("location")
    protected abstract double[] rawLocation();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_StepManeuver.Builder();
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }

    public static TypeAdapter<StepManeuver> typeAdapter(Gson gson) {
        return new AutoValue_StepManeuver.GsonTypeAdapter(gson);
    }

    public static StepManeuver fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (StepManeuver) gsonBuilder.create().fromJson(str, StepManeuver.class);
    }
}
