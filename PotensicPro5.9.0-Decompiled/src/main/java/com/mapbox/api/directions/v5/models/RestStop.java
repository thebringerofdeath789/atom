package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_RestStop;
import com.mapbox.api.directions.v5.models.C$AutoValue_RestStop;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class RestStop extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder amenities(List<Amenity> list);

        public abstract RestStop build();

        public abstract Builder guideMap(String str);

        public abstract Builder name(String str);

        public abstract Builder type(String str);
    }

    public abstract List<Amenity> amenities();

    @SerializedName("guidemap")
    public abstract String guideMap();

    public abstract String name();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_RestStop.Builder();
    }

    public static TypeAdapter<RestStop> typeAdapter(Gson gson) {
        return new AutoValue_RestStop.GsonTypeAdapter(gson);
    }

    public static RestStop fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (RestStop) gsonBuilder.create().fromJson(str, RestStop.class);
    }
}
