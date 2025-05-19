package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.ShieldSvg;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_ShieldSvg extends C$AutoValue_ShieldSvg {
    AutoValue_ShieldSvg(Map<String, SerializableJsonElement> map, String str) {
        new ShieldSvg(map, str) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSvg
            private final String svg;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null svg");
                this.svg = str;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSvg
            public String svg() {
                return this.svg;
            }

            public String toString() {
                return "ShieldSvg{unrecognized=" + this.unrecognized + ", svg=" + this.svg + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ShieldSvg)) {
                    return false;
                }
                ShieldSvg shieldSvg = (ShieldSvg) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(shieldSvg.unrecognized()) : shieldSvg.unrecognized() == null) {
                    if (this.svg.equals(shieldSvg.svg())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.svg.hashCode();
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSvg
            public ShieldSvg.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSvg$Builder */
            static class Builder extends ShieldSvg.Builder {
                private String svg;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ ShieldSvg.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(ShieldSvg shieldSvg) {
                    this.unrecognized = shieldSvg.unrecognized();
                    this.svg = shieldSvg.svg();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                ShieldSvg.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSvg.Builder
                public ShieldSvg.Builder svg(String str) {
                    Objects.requireNonNull(str, "Null svg");
                    this.svg = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSvg.Builder
                public ShieldSvg build() {
                    String str = this.svg == null ? " svg" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_ShieldSvg(this.unrecognized, this.svg);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<ShieldSvg> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, ShieldSvg shieldSvg) throws IOException {
            if (shieldSvg == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (shieldSvg.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : shieldSvg.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("svg");
            if (shieldSvg.svg() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, shieldSvg.svg());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public ShieldSvg read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            ShieldSvg.Builder builder = ShieldSvg.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("svg".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.svg(typeAdapter.read2(jsonReader));
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
            return "TypeAdapter(ShieldSvg)";
        }
    }
}
