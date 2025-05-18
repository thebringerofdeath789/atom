package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.Metadata;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Metadata extends C$AutoValue_Metadata {
    AutoValue_Metadata(final Map<String, SerializableJsonElement> map, final Map<String, String> map2) {
        new Metadata(map, map2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_Metadata
            private final Map<String, String> infoMap;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.infoMap = map2;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.Metadata
            @SerializedName("map")
            public Map<String, String> infoMap() {
                return this.infoMap;
            }

            public String toString() {
                return "Metadata{unrecognized=" + this.unrecognized + ", infoMap=" + this.infoMap + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Metadata)) {
                    return false;
                }
                Metadata metadata = (Metadata) obj;
                Map<String, SerializableJsonElement> map3 = this.unrecognized;
                if (map3 != null ? map3.equals(metadata.unrecognized()) : metadata.unrecognized() == null) {
                    Map<String, String> map4 = this.infoMap;
                    if (map4 == null) {
                        if (metadata.infoMap() == null) {
                            return true;
                        }
                    } else if (map4.equals(metadata.infoMap())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map3 = this.unrecognized;
                int hashCode = ((map3 == null ? 0 : map3.hashCode()) ^ 1000003) * 1000003;
                Map<String, String> map4 = this.infoMap;
                return hashCode ^ (map4 != null ? map4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.Metadata
            public Metadata.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_Metadata$Builder */
            static class Builder extends Metadata.Builder {
                private Map<String, String> infoMap;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ Metadata.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(Metadata metadata) {
                    this.unrecognized = metadata.unrecognized();
                    this.infoMap = metadata.infoMap();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                Metadata.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Metadata.Builder
                public Metadata.Builder infoMap(Map<String, String> map) {
                    this.infoMap = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Metadata.Builder
                public Metadata build() {
                    return new AutoValue_Metadata(this.unrecognized, this.infoMap);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<Metadata> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<Map<String, String>> map__string_string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Metadata metadata) throws IOException {
            if (metadata == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (metadata.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : metadata.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("map");
            if (metadata.infoMap() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Map<String, String>> typeAdapter = this.map__string_string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(Map.class, String.class, String.class));
                    this.map__string_string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, metadata.infoMap());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public Metadata read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Metadata.Builder builder = Metadata.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("map")) {
                        TypeAdapter<Map<String, String>> typeAdapter = this.map__string_string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(Map.class, String.class, String.class));
                            this.map__string_string_adapter = typeAdapter;
                        }
                        builder.infoMap(typeAdapter.read(jsonReader));
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
            return "TypeAdapter(Metadata)";
        }
    }
}