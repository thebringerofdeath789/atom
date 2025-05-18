package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.TypeAdapter;
import com.mapbox.api.directions.p022v5.models.AutoValue_ShieldSprites;
import com.mapbox.api.directions.p022v5.models.C$AutoValue_ShieldSprites;
import com.mapbox.api.directions.p022v5.models.DirectionsJsonObject;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes3.dex */
public abstract class ShieldSprites extends DirectionsJsonObject implements Serializable {

    public static abstract class Builder extends DirectionsJsonObject.Builder<Builder> {
        public abstract ShieldSprites build();

        public abstract Builder sprites(List<ShieldSprite> list);
    }

    public abstract List<ShieldSprite> sprites();

    public abstract Builder toBuilder();

    public static Builder builder() {
        return new C$AutoValue_ShieldSprites.Builder();
    }

    public static ShieldSprites fromJson(String str) {
        ArrayList arrayList = new ArrayList();
        JsonObject jsonObject = (JsonObject) new GsonBuilder().create().fromJson(str, JsonObject.class);
        Iterator<Map.Entry<String, JsonElement>> it = jsonObject.entrySet().iterator();
        while (it.hasNext()) {
            String key = it.next().getKey();
            arrayList.add(ShieldSprite.builder().spriteName(key).spriteAttributes(ShieldSpriteAttribute.fromJson(jsonObject.get(key).toString())).build());
        }
        return builder().sprites(arrayList).build();
    }

    @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
    public String toJson() {
        JsonParser jsonParser = new JsonParser();
        Gson gson = new Gson();
        JsonObject jsonObject = new JsonObject();
        for (ShieldSprite shieldSprite : sprites()) {
            jsonObject.add(shieldSprite.spriteName(), jsonParser.parse(shieldSprite.spriteAttributes().toJson()));
        }
        return gson.toJson((JsonElement) jsonObject);
    }

    public static TypeAdapter<ShieldSprites> typeAdapter(Gson gson) {
        return new AutoValue_ShieldSprites.GsonTypeAdapter(gson);
    }
}