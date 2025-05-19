package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_IntersectionLanes;
import com.mapbox.api.directions.v5.models.C$AutoValue_IntersectionLanes;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class IntersectionLanes extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder active(Boolean bool);

        public abstract IntersectionLanes build();

        public abstract Builder indications(List<String> list);

        public abstract Builder valid(Boolean bool);

        public abstract Builder validIndication(String str);
    }

    public abstract Boolean active();

    public abstract List<String> indications();

    public abstract Builder toBuilder();

    public abstract Boolean valid();

    @SerializedName("valid_indication")
    public abstract String validIndication();

    public static Builder builder() {
        return new C$AutoValue_IntersectionLanes.Builder();
    }

    public static TypeAdapter<IntersectionLanes> typeAdapter(Gson gson) {
        return new AutoValue_IntersectionLanes.GsonTypeAdapter(gson);
    }

    public static IntersectionLanes fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (IntersectionLanes) gsonBuilder.create().fromJson(str, IntersectionLanes.class);
    }
}
