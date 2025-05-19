package com.mapbox.api.matching.v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.api.directions.v5.models.RouteLeg;
import com.mapbox.api.directions.v5.models.RouteOptions;
import com.mapbox.api.matching.v5.models.AutoValue_MapMatchingMatching;
import com.mapbox.api.matching.v5.models.C$AutoValue_MapMatchingMatching;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class MapMatchingMatching implements Serializable {

    public static abstract class Builder {
        public abstract MapMatchingMatching build();

        public abstract Builder confidence(double d);

        public abstract Builder distance(double d);

        public abstract Builder duration(double d);

        public abstract Builder geometry(String str);

        public abstract Builder legs(List<RouteLeg> list);

        public abstract Builder requestUuid(String str);

        public abstract Builder routeIndex(String str);

        public abstract Builder routeOptions(RouteOptions routeOptions);

        public abstract Builder voiceLanguage(String str);

        public abstract Builder weight(double d);

        public abstract Builder weightName(String str);
    }

    public abstract double confidence();

    public abstract double distance();

    public abstract double duration();

    public abstract String geometry();

    public abstract List<RouteLeg> legs();

    public abstract String requestUuid();

    public abstract String routeIndex();

    public abstract RouteOptions routeOptions();

    public abstract Builder toBuilder();

    @SerializedName("voiceLocale")
    public abstract String voiceLanguage();

    public abstract double weight();

    @SerializedName("weight_name")
    public abstract String weightName();

    public static Builder builder() {
        return new C$AutoValue_MapMatchingMatching.Builder();
    }

    public DirectionsRoute toDirectionRoute() {
        return DirectionsRoute.builder().legs(legs()).geometry(geometry()).weightName(weightName()).weight(Double.valueOf(weight())).duration(Double.valueOf(duration())).distance(Double.valueOf(distance())).routeOptions(routeOptions()).voiceLanguage(voiceLanguage()).requestUuid(requestUuid()).routeIndex(routeIndex()).build();
    }

    public static TypeAdapter<MapMatchingMatching> typeAdapter(Gson gson) {
        return new AutoValue_MapMatchingMatching.GsonTypeAdapter(gson);
    }
}
