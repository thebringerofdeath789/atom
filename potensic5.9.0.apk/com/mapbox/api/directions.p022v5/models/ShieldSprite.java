package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.models.AutoValue_ShieldSprite;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_ShieldSprite;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.io.Serializable;

/* loaded from: classes3.dex */
public abstract class ShieldSprite extends DirectionsJsonObject implements Serializable {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract ShieldSprite build();

        public abstract Builder spriteAttributes(ShieldSpriteAttribute shieldSpriteAttribute);

        public abstract Builder spriteName(String str);
    }

    public abstract ShieldSpriteAttribute spriteAttributes();

    public abstract String spriteName();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_ShieldSprite.Builder();
    }

    public static TypeAdapter<ShieldSprite> typeAdapter(Gson gson) {
        return new AutoValue_ShieldSprite.GsonTypeAdapter(gson);
    }
}