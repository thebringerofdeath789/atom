package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_MapboxShield;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_MapboxShield;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class MapboxShield extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Builder baseUrl(String str);

        public abstract MapboxShield build();

        public abstract Builder displayRef(String str);

        public abstract Builder name(String str);

        public abstract Builder textColor(String str);
    }

    @SerializedName("base_url")
    public abstract String baseUrl();

    @SerializedName("display_ref")
    public abstract String displayRef();

    public abstract String name();

    @SerializedName("text_color")
    public abstract String textColor();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_MapboxShield.Builder();
    }

    public static TypeAdapter<MapboxShield> typeAdapter(Gson gson) {
        return new AutoValue_MapboxShield.GsonTypeAdapter(gson);
    }

    public static MapboxShield fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (MapboxShield) gsonBuilder.create().fromJson(str, MapboxShield.class);
    }
}