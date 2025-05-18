package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.ShieldSprites;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_ShieldSprites extends C$AutoValue_ShieldSprites {
    AutoValue_ShieldSprites(final Map<String, SerializableJsonElement> map, final List<ShieldSprite> list) {
        new ShieldSprites(map, list) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSprites
            private final List<ShieldSprite> sprites;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(list, "Null sprites");
                this.sprites = list;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.ShieldSprites
            public List<ShieldSprite> sprites() {
                return this.sprites;
            }

            public String toString() {
                return "ShieldSprites{unrecognized=" + this.unrecognized + ", sprites=" + this.sprites + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ShieldSprites)) {
                    return false;
                }
                ShieldSprites shieldSprites = (ShieldSprites) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(shieldSprites.unrecognized()) : shieldSprites.unrecognized() == null) {
                    if (this.sprites.equals(shieldSprites.sprites())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.sprites.hashCode();
            }

            @Override // com.mapbox.api.directions.p022v5.models.ShieldSprites
            public ShieldSprites.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSprites$Builder */
            static class Builder extends ShieldSprites.Builder {
                private List<ShieldSprite> sprites;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ ShieldSprites.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(ShieldSprites shieldSprites) {
                    this.unrecognized = shieldSprites.unrecognized();
                    this.sprites = shieldSprites.sprites();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                ShieldSprites.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSprites.Builder
                public ShieldSprites.Builder sprites(List<ShieldSprite> list) {
                    Objects.requireNonNull(list, "Null sprites");
                    this.sprites = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSprites.Builder
                public ShieldSprites build() {
                    String str = this.sprites == null ? " sprites" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_ShieldSprites(this.unrecognized, this.sprites);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<ShieldSprites> {
        private final Gson gson;
        private volatile TypeAdapter<List<ShieldSprite>> list__shieldSprite_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, ShieldSprites shieldSprites) throws IOException {
            if (shieldSprites == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (shieldSprites.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : shieldSprites.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("sprites");
            if (shieldSprites.sprites() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<ShieldSprite>> typeAdapter = this.list__shieldSprite_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, ShieldSprite.class));
                    this.list__shieldSprite_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, shieldSprites.sprites());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public ShieldSprites read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            ShieldSprites.Builder builder = ShieldSprites.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("sprites".equals(nextName)) {
                        TypeAdapter<List<ShieldSprite>> typeAdapter = this.list__shieldSprite_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, ShieldSprite.class));
                            this.list__shieldSprite_adapter = typeAdapter;
                        }
                        builder.sprites(typeAdapter.read(jsonReader));
                    } else {
                        if (linkedHashMap == null) {
                            linkedHashMap = new LinkedHashMap();
                            builder.unrecognized(linkedHashMap);
                        }
                        linkedHashMap.put(nextName, new SerializableJsonElement((JsonElement) this.gson.fromJson(jsonReader, JsonElement.class)));
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(ShieldSprites)";
        }
    }
}