package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.DirectionsAdapterFactory;
import com.mapbox.api.directions.p022v5.models.AutoValue_ShieldSpriteAttribute;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_ShieldSpriteAttribute;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.io.Serializable;
import java.util.List;

/* loaded from: classes3.dex */
public abstract class ShieldSpriteAttribute extends DirectionsJsonObject implements Serializable {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract ShieldSpriteAttribute build();

        public abstract Builder height(Integer num);

        public abstract Builder pixelRatio(Integer num);

        public abstract Builder placeholder(List<Double> list);

        public abstract Builder visible(Boolean bool);

        public abstract Builder width(Integer num);

        /* renamed from: x */
        public abstract Builder mo1742x(Integer num);

        /* renamed from: y */
        public abstract Builder mo1743y(Integer num);
    }

    public abstract Integer height();

    public abstract Integer pixelRatio();

    public abstract List<Double> placeholder();

    public abstract Builder toBuilder();

    public abstract Boolean visible();

    public abstract Integer width();

    /* renamed from: x */
    public abstract Integer mo1740x();

    /* renamed from: y */
    public abstract Integer mo1741y();

    public static Builder builder() {
        return new C$AutoValue_ShieldSpriteAttribute.Builder();
    }

    public static ShieldSpriteAttribute fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return (ShieldSpriteAttribute) gsonBuilder.create().fromJson(str, ShieldSpriteAttribute.class);
    }

    @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(DirectionsAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public static TypeAdapter<ShieldSpriteAttribute> typeAdapter(Gson gson) {
        return new AutoValue_ShieldSpriteAttribute.GsonTypeAdapter(gson);
    }
}