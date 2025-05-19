package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_BannerInstructions;
import com.mapbox.api.directions.v5.models.C$AutoValue_BannerInstructions;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;

/* loaded from: classes3.dex */
public abstract class BannerInstructions extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract BannerInstructions build();

        public abstract Builder distanceAlongGeometry(double d);

        public abstract Builder primary(BannerText bannerText);

        public abstract Builder secondary(BannerText bannerText);

        public abstract Builder sub(BannerText bannerText);

        public abstract Builder view(BannerView bannerView);
    }

    public abstract double distanceAlongGeometry();

    public abstract BannerText primary();

    public abstract BannerText secondary();

    public abstract BannerText sub();

    public abstract Builder toBuilder();

    public abstract BannerView view();

    public static Builder builder() {
        return new C$AutoValue_BannerInstructions.Builder();
    }

    public static TypeAdapter<BannerInstructions> typeAdapter(Gson gson) {
        return new AutoValue_BannerInstructions.GsonTypeAdapter(gson);
    }

    public static BannerInstructions fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (BannerInstructions) gsonBuilder.create().fromJson(str, BannerInstructions.class);
    }
}
