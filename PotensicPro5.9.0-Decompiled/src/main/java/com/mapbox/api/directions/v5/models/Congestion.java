package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_Congestion;
import com.mapbox.api.directions.v5.models.C$AutoValue_Congestion;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class Congestion extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Congestion build();

        public abstract Builder value(int i);
    }

    public abstract Builder toBuilder();

    public abstract int value();

    public static Builder builder() {
        return new C$AutoValue_Congestion.Builder();
    }

    public static TypeAdapter<Congestion> typeAdapter(Gson gson) {
        return new AutoValue_Congestion.GsonTypeAdapter(gson);
    }

    public static Congestion fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (Congestion) gsonBuilder.create().fromJson(str, Congestion.class);
    }
}
