package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_TollCollection;
import com.mapbox.api.directions.v5.models.C$AutoValue_TollCollection;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class TollCollection extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract TollCollection build();

        public abstract Builder name(String str);

        public abstract Builder type(String str);
    }

    public abstract String name();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_TollCollection.Builder();
    }

    public static TypeAdapter<TollCollection> typeAdapter(Gson gson) {
        return new AutoValue_TollCollection.GsonTypeAdapter(gson);
    }

    public static TollCollection fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (TollCollection) gsonBuilder.create().fromJson(str, TollCollection.class);
    }
}
