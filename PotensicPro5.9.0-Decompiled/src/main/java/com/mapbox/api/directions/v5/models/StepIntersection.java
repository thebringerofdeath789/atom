package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_StepIntersection;
import com.mapbox.api.directions.v5.models.C$AutoValue_StepIntersection;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import com.mapbox.geojson.Point;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class StepIntersection extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder adminIndex(Integer num);

        public abstract Builder bearings(List<Integer> list);

        public abstract StepIntersection build();

        public abstract Builder classes(List<String> list);

        public abstract Builder entry(List<Boolean> list);

        public abstract Builder geometryIndex(Integer num);

        public abstract Builder in(Integer num);

        public abstract Builder isUrban(Boolean bool);

        public abstract Builder lanes(List<IntersectionLanes> list);

        public abstract Builder mapboxStreetsV8(MapboxStreetsV8 mapboxStreetsV8);

        public abstract Builder out(Integer num);

        public abstract Builder railwayCrossing(Boolean bool);

        public abstract Builder rawLocation(double[] dArr);

        public abstract Builder restStop(RestStop restStop);

        public abstract Builder stopSign(Boolean bool);

        public abstract Builder tollCollection(TollCollection tollCollection);

        public abstract Builder trafficSignal(Boolean bool);

        public abstract Builder tunnelName(String str);

        public abstract Builder yieldSign(Boolean bool);
    }

    @SerializedName("admin_index")
    public abstract Integer adminIndex();

    public abstract List<Integer> bearings();

    public abstract List<String> classes();

    public abstract List<Boolean> entry();

    @SerializedName("geometry_index")
    public abstract Integer geometryIndex();

    public abstract Integer in();

    @SerializedName("is_urban")
    public abstract Boolean isUrban();

    public abstract List<IntersectionLanes> lanes();

    @SerializedName("mapbox_streets_v8")
    public abstract MapboxStreetsV8 mapboxStreetsV8();

    public abstract Integer out();

    @SerializedName("railway_crossing")
    public abstract Boolean railwayCrossing();

    @SerializedName("location")
    protected abstract double[] rawLocation();

    @SerializedName("rest_stop")
    public abstract RestStop restStop();

    @SerializedName("stop_sign")
    public abstract Boolean stopSign();

    public abstract Builder toBuilder();

    @SerializedName("toll_collection")
    public abstract TollCollection tollCollection();

    @SerializedName("traffic_signal")
    public abstract Boolean trafficSignal();

    @SerializedName("tunnel_name")
    public abstract String tunnelName();

    @SerializedName("yield_sign")
    public abstract Boolean yieldSign();

    public static Builder builder() {
        return new C$AutoValue_StepIntersection.Builder();
    }

    public Point location() {
        return Point.fromLngLat(rawLocation()[0], rawLocation()[1]);
    }

    public static TypeAdapter<StepIntersection> typeAdapter(Gson gson) {
        return new AutoValue_StepIntersection.GsonTypeAdapter(gson);
    }

    public static StepIntersection fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (StepIntersection) gsonBuilder.create().fromJson(str, StepIntersection.class);
    }
}
