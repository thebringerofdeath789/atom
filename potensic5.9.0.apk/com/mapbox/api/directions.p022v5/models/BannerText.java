package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_BannerText;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_BannerText;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BannerText extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract BannerText build();

        public abstract Builder components(List<BannerComponents> list);

        public abstract Builder degrees(Double d);

        public abstract Builder drivingSide(String str);

        public abstract Builder modifier(String str);

        public abstract Builder text(String str);

        public abstract Builder type(String str);
    }

    public abstract List<BannerComponents> components();

    public abstract Double degrees();

    @SerializedName("driving_side")
    public abstract String drivingSide();

    public abstract String modifier();

    public abstract String text();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_BannerText.Builder();
    }

    public static TypeAdapter<BannerText> typeAdapter(Gson gson) {
        return new AutoValue_BannerText.GsonTypeAdapter(gson);
    }

    public static BannerText fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (BannerText) gsonBuilder.create().fromJson(str, BannerText.class);
    }
}