package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_Metadata;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_Metadata;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class Metadata extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Metadata build();

        public abstract Builder infoMap(Map<String, String> map);
    }

    @SerializedName("map")
    public abstract Map<String, String> infoMap();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_Metadata.Builder();
    }

    public static TypeAdapter<Metadata> typeAdapter(Gson gson) {
        return new AutoValue_Metadata.GsonTypeAdapter(gson);
    }

    public static Metadata fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (Metadata) gsonBuilder.create().fromJson(str, Metadata.class);
    }
}