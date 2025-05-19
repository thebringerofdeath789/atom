package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_DirectionsRoute;
import com.mapbox.api.directions.v5.models.C$AutoValue_DirectionsRoute;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.PointAsCoordinatesTypeAdapter;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class DirectionsRoute extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract DirectionsRoute build();

        public abstract Builder distance(Double d);

        public abstract Builder duration(Double d);

        public abstract Builder durationTypical(Double d);

        public abstract Builder geometry(String str);

        public abstract Builder legs(List<RouteLeg> list);

        public abstract Builder requestUuid(String str);

        public abstract Builder routeIndex(String str);

        public abstract Builder routeOptions(RouteOptions routeOptions);

        public abstract Builder tollCosts(List<TollCost> list);

        public abstract Builder voiceLanguage(String str);

        public abstract Builder weight(Double d);

        public abstract Builder weightName(String str);
    }

    public abstract Double distance();

    public abstract Double duration();

    @SerializedName("duration_typical")
    public abstract Double durationTypical();

    public abstract String geometry();

    public abstract List<RouteLeg> legs();

    public abstract String requestUuid();

    public abstract String routeIndex();

    public abstract RouteOptions routeOptions();

    public abstract Builder toBuilder();

    @SerializedName("toll_costs")
    public abstract List<TollCost> tollCosts();

    @SerializedName("voiceLocale")
    public abstract String voiceLanguage();

    public abstract Double weight();

    @SerializedName("weight_name")
    public abstract String weightName();

    public static Builder builder() {
        return new C$AutoValue_DirectionsRoute.Builder();
    }

    public static TypeAdapter<DirectionsRoute> typeAdapter(Gson gson) {
        return new AutoValue_DirectionsRoute.GsonTypeAdapter(gson);
    }

    public static DirectionsRoute fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        JsonObject jsonObject = (JsonObject) gsonBuilder.create().fromJson(str, JsonObject.class);
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        gsonBuilder.registerTypeAdapter(Point.class, new PointAsCoordinatesTypeAdapter());
        return (DirectionsRoute) gsonBuilder.create().fromJson((JsonElement) jsonObject, DirectionsRoute.class);
    }

    public static DirectionsRoute fromJson(String str, RouteOptions routeOptions, String str2) {
        return fromJson(str).toBuilder().routeOptions(routeOptions).requestUuid(str2).build();
    }
}
