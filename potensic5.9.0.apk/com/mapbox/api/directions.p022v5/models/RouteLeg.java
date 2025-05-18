package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_RouteLeg;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_RouteLeg;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class RouteLeg extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder admins(List<Admin> list);

        public abstract Builder annotation(LegAnnotation legAnnotation);

        public abstract RouteLeg build();

        public abstract Builder closures(List<Closure> list);

        public abstract Builder distance(Double d);

        public abstract Builder duration(Double d);

        public abstract Builder durationTypical(Double d);

        public abstract Builder incidents(List<Incident> list);

        public abstract Builder steps(List<LegStep> list);

        public abstract Builder summary(String str);

        public abstract Builder viaWaypoints(List<SilentWaypoint> list);
    }

    public abstract List<Admin> admins();

    public abstract LegAnnotation annotation();

    public abstract List<Closure> closures();

    public abstract Double distance();

    public abstract Double duration();

    @SerializedName("duration_typical")
    public abstract Double durationTypical();

    public abstract List<Incident> incidents();

    public abstract List<LegStep> steps();

    public abstract String summary();

    public abstract Builder toBuilder();

    @SerializedName("via_waypoints")
    public abstract List<SilentWaypoint> viaWaypoints();

    public static Builder builder() {
        return new C$AutoValue_RouteLeg.Builder();
    }

    public static TypeAdapter<RouteLeg> typeAdapter(Gson gson) {
        return new AutoValue_RouteLeg.GsonTypeAdapter(gson);
    }

    public static RouteLeg fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (RouteLeg) gsonBuilder.create().fromJson(str, RouteLeg.class);
    }
}