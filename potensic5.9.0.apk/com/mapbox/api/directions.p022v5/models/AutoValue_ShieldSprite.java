package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.ShieldSprite;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_ShieldSprite extends C$AutoValue_ShieldSprite {
    AutoValue_ShieldSprite(final Map<String, SerializableJsonElement> map, final String str, final ShieldSpriteAttribute shieldSpriteAttribute) {
        new ShieldSprite(map, str, shieldSpriteAttribute) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSprite
            private final ShieldSpriteAttribute spriteAttributes;
            private final String spriteName;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null spriteName");
                this.spriteName = str;
                Objects.requireNonNull(shieldSpriteAttribute, "Null spriteAttributes");
                this.spriteAttributes = shieldSpriteAttribute;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.ShieldSprite
            public String spriteName() {
                return this.spriteName;
            }

            @Override // com.mapbox.api.directions.p022v5.models.ShieldSprite
            public ShieldSpriteAttribute spriteAttributes() {
                return this.spriteAttributes;
            }

            public String toString() {
                return "ShieldSprite{unrecognized=" + this.unrecognized + ", spriteName=" + this.spriteName + ", spriteAttributes=" + this.spriteAttributes + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ShieldSprite)) {
                    return false;
                }
                ShieldSprite shieldSprite = (ShieldSprite) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(shieldSprite.unrecognized()) : shieldSprite.unrecognized() == null) {
                    if (this.spriteName.equals(shieldSprite.spriteName()) && this.spriteAttributes.equals(shieldSprite.spriteAttributes())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.spriteName.hashCode()) * 1000003) ^ this.spriteAttributes.hashCode();
            }

            @Override // com.mapbox.api.directions.p022v5.models.ShieldSprite
            public ShieldSprite.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSprite$Builder */
            static class Builder extends ShieldSprite.Builder {
                private ShieldSpriteAttribute spriteAttributes;
                private String spriteName;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ ShieldSprite.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(ShieldSprite shieldSprite) {
                    this.unrecognized = shieldSprite.unrecognized();
                    this.spriteName = shieldSprite.spriteName();
                    this.spriteAttributes = shieldSprite.spriteAttributes();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                ShieldSprite.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSprite.Builder
                public ShieldSprite.Builder spriteName(String str) {
                    Objects.requireNonNull(str, "Null spriteName");
                    this.spriteName = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSprite.Builder
                public ShieldSprite.Builder spriteAttributes(ShieldSpriteAttribute shieldSpriteAttribute) {
                    Objects.requireNonNull(shieldSpriteAttribute, "Null spriteAttributes");
                    this.spriteAttributes = shieldSpriteAttribute;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSprite.Builder
                public ShieldSprite build() {
                    String str = this.spriteName == null ? " spriteName" : "";
                    if (this.spriteAttributes == null) {
                        str = str + " spriteAttributes";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_ShieldSprite(this.unrecognized, this.spriteName, this.spriteAttributes);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<ShieldSprite> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<ShieldSpriteAttribute> shieldSpriteAttribute_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, ShieldSprite shieldSprite) throws IOException {
            if (shieldSprite == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (shieldSprite.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : shieldSprite.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("spriteName");
            if (shieldSprite.spriteName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, shieldSprite.spriteName());
            }
            jsonWriter.name("spriteAttributes");
            if (shieldSprite.spriteAttributes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<ShieldSpriteAttribute> typeAdapter2 = this.shieldSpriteAttribute_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(ShieldSpriteAttribute.class);
                    this.shieldSpriteAttribute_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, shieldSprite.spriteAttributes());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public ShieldSprite read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            ShieldSprite.Builder builder = ShieldSprite.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("spriteName".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.spriteName(typeAdapter.read(jsonReader));
                    } else if ("spriteAttributes".equals(nextName)) {
                        TypeAdapter<ShieldSpriteAttribute> typeAdapter2 = this.shieldSpriteAttribute_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(ShieldSpriteAttribute.class);
                            this.shieldSpriteAttribute_adapter = typeAdapter2;
                        }
                        builder.spriteAttributes(typeAdapter2.read(jsonReader));
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
            return "TypeAdapter(ShieldSprite)";
        }
    }
}