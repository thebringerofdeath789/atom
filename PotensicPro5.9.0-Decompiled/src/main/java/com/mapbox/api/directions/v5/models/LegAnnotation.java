package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.DirectionsCriteria;
import com.mapbox.api.directions.v5.models.AutoValue_LegAnnotation;
import com.mapbox.api.directions.v5.models.C$AutoValue_LegAnnotation;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class LegAnnotation extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract LegAnnotation build();

        public abstract Builder congestion(List<String> list);

        public abstract Builder congestionNumeric(List<Integer> list);

        public abstract Builder distance(List<Double> list);

        public abstract Builder duration(List<Double> list);

        public abstract Builder maxspeed(List<MaxSpeed> list);

        public abstract Builder speed(List<Double> list);

        public abstract Builder trafficTendency(List<Integer> list);
    }

    public abstract List<String> congestion();

    @SerializedName(DirectionsCriteria.ANNOTATION_CONGESTION_NUMERIC)
    public abstract List<Integer> congestionNumeric();

    public abstract List<Double> distance();

    public abstract List<Double> duration();

    public abstract List<MaxSpeed> maxspeed();

    public abstract List<Double> speed();

    public abstract Builder toBuilder();

    @SerializedName(DirectionsCriteria.ANNOTATION_TRAFFIC_TENDENCY)
    public abstract List<Integer> trafficTendency();

    public static Builder builder() {
        return new C$AutoValue_LegAnnotation.Builder();
    }

    public static TypeAdapter<LegAnnotation> typeAdapter(Gson gson) {
        return new AutoValue_LegAnnotation.GsonTypeAdapter(gson);
    }

    public static LegAnnotation fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (LegAnnotation) gsonBuilder.create().fromJson(str, LegAnnotation.class);
    }
}
