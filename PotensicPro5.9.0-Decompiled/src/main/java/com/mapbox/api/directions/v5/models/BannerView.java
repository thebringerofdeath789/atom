package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.v5.models.AutoValue_BannerView;
import com.mapbox.api.directions.v5.models.C$AutoValue_BannerView;
import com.mapbox.api.directions.v5.models.DirectionsJsonObject;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class BannerView extends DirectionsJsonObject {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract BannerView build();

        public abstract Builder components(List<BannerComponents> list);

        public abstract Builder modifier(String str);

        public abstract Builder text(String str);

        public abstract Builder type(String str);
    }

    public abstract List<BannerComponents> components();

    public abstract String modifier();

    public abstract String text();

    public abstract Builder toBuilder();

    public abstract String type();

    public static Builder builder() {
        return new C$AutoValue_BannerView.Builder();
    }

    public static TypeAdapter<BannerView> typeAdapter(Gson gson) {
        return new AutoValue_BannerView.GsonTypeAdapter(gson);
    }

    public static BannerView fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (BannerView) gsonBuilder.create().fromJson(str, BannerView.class);
    }
}
