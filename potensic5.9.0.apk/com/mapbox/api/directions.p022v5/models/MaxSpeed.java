package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_MaxSpeed;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_MaxSpeed;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class MaxSpeed extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract MaxSpeed build();

        public abstract Builder none(Boolean bool);

        public abstract Builder speed(Integer num);

        public abstract Builder unit(String str);

        public abstract Builder unknown(Boolean bool);
    }

    public abstract Boolean none();

    public abstract Integer speed();

    public abstract Builder toBuilder();

    public abstract String unit();

    public abstract Boolean unknown();

    public static Builder builder() {
        return new C$AutoValue_MaxSpeed.Builder();
    }

    public static TypeAdapter<MaxSpeed> typeAdapter(Gson gson) {
        return new AutoValue_MaxSpeed.GsonTypeAdapter(gson);
    }

    public static MaxSpeed fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (MaxSpeed) gsonBuilder.create().fromJson(str, MaxSpeed.class);
    }
}