package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_ShieldSvg;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_ShieldSvg;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class ShieldSvg extends DirectionsJsonObject implements Serializable {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract ShieldSvg build();

        public abstract Builder svg(String str);
    }

    public abstract String svg();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_ShieldSvg.Builder();
    }

    public static ShieldSvg fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (ShieldSvg) gsonBuilder.create().fromJson(str, ShieldSvg.class);
    }

    @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public static TypeAdapter<ShieldSvg> typeAdapter(Gson gson) {
        return new AutoValue_ShieldSvg.GsonTypeAdapter(gson);
    }
}