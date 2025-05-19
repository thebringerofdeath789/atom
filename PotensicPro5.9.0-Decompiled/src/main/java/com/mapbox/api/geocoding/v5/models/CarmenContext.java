package com.mapbox.api.geocoding.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.geocoding.v5.models.AutoValue_CarmenContext;
import com.mapbox.api.geocoding.v5.models.C$AutoValue_CarmenContext;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class CarmenContext implements Serializable {

    public static abstract class Builder {
        public abstract CarmenContext build();

        public abstract Builder category(String str);

        public abstract Builder id(String str);

        public abstract Builder maki(String str);

        public abstract Builder shortCode(String str);

        public abstract Builder text(String str);

        public abstract Builder wikidata(String str);
    }

    public abstract String category();

    public abstract String id();

    public abstract String maki();

    @SerializedName("short_code")
    public abstract String shortCode();

    public abstract String text();

    public abstract Builder toBuilder();

    public abstract String wikidata();

    public static Builder builder() {
        return new C$AutoValue_CarmenContext.Builder();
    }

    public static CarmenContext fromJson(String str) {
        return (CarmenContext) new GsonBuilder().registerTypeAdapterFactory(GeocodingAdapterFactory.create()).create().fromJson(str, CarmenContext.class);
    }

    public static TypeAdapter<CarmenContext> typeAdapter(Gson gson) {
        return new AutoValue_CarmenContext.GsonTypeAdapter(gson);
    }

    public String toJson() {
        return new GsonBuilder().registerTypeAdapterFactory(GeocodingAdapterFactory.create()).create().toJson(this);
    }
}
