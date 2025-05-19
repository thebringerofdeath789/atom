package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_Closure;
import com.mapbox.api.directions.v5.models.C$AutoValue_Closure;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class Closure extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Closure build();

        public abstract Builder geometryIndexEnd(Integer num);

        public abstract Builder geometryIndexStart(Integer num);
    }

    @SerializedName("geometry_index_end")
    public abstract Integer geometryIndexEnd();

    @SerializedName("geometry_index_start")
    public abstract Integer geometryIndexStart();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_Closure.Builder();
    }

    public static TypeAdapter<Closure> typeAdapter(Gson gson) {
        return new AutoValue_Closure.GsonTypeAdapter(gson);
    }

    public static Closure fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (Closure) gsonBuilder.create().fromJson(str, Closure.class);
    }
}
