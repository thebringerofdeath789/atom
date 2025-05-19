package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_Admin;
import com.mapbox.api.directions.v5.models.C$AutoValue_Admin;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class Admin extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract Admin build();

        public abstract Builder countryCode(String str);

        public abstract Builder countryCodeAlpha3(String str);
    }

    @SerializedName("iso_3166_1")
    public abstract String countryCode();

    @SerializedName("iso_3166_1_alpha3")
    public abstract String countryCodeAlpha3();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_Admin.Builder();
    }

    public static TypeAdapter<Admin> typeAdapter(Gson gson) {
        return new AutoValue_Admin.GsonTypeAdapter(gson);
    }

    public static Admin fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (Admin) gsonBuilder.create().fromJson(str, Admin.class);
    }
}
