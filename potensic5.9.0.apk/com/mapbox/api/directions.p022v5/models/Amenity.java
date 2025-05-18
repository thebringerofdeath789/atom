package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_Amenity;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_Amenity;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class Amenity extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder brand(String str);

        public abstract Amenity build();

        public abstract Builder name(String str);

        public abstract Builder type(String str);
    }

    public abstract String brand();

    public abstract String name();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_Amenity.Builder();
    }

    public static TypeAdapter<Amenity> typeAdapter(Gson gson) {
        return new AutoValue_Amenity.GsonTypeAdapter(gson);
    }

    public static Amenity fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (Amenity) gsonBuilder.create().fromJson(str, Amenity.class);
    }
}