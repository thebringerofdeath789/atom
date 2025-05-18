package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.MapboxStreetsV8;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes3.dex */
final class AutoValue_MapboxStreetsV8 extends C$AutoValue_MapboxStreetsV8 {
    AutoValue_MapboxStreetsV8(final Map<String, SerializableJsonElement> map, final String str) {
        new MapboxStreetsV8(map, str) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_MapboxStreetsV8
            private final String roadClass;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.roadClass = str;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxStreetsV8
            @SerializedName(JamXmlElements.CLASS)
            public String roadClass() {
                return this.roadClass;
            }

            public String toString() {
                return "MapboxStreetsV8{unrecognized=" + this.unrecognized + ", roadClass=" + this.roadClass + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MapboxStreetsV8)) {
                    return false;
                }
                MapboxStreetsV8 mapboxStreetsV8 = (MapboxStreetsV8) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(mapboxStreetsV8.unrecognized()) : mapboxStreetsV8.unrecognized() == null) {
                    String str2 = this.roadClass;
                    if (str2 == null) {
                        if (mapboxStreetsV8.roadClass() == null) {
                            return true;
                        }
                    } else if (str2.equals(mapboxStreetsV8.roadClass())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                String str2 = this.roadClass;
                return hashCode ^ (str2 != null ? str2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxStreetsV8
            public MapboxStreetsV8.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_MapboxStreetsV8$Builder */
            static class Builder extends MapboxStreetsV8.Builder {
                private String roadClass;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ MapboxStreetsV8.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(MapboxStreetsV8 mapboxStreetsV8) {
                    this.unrecognized = mapboxStreetsV8.unrecognized();
                    this.roadClass = mapboxStreetsV8.roadClass();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                MapboxStreetsV8.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxStreetsV8.Builder
                public MapboxStreetsV8.Builder roadClass(String str) {
                    this.roadClass = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxStreetsV8.Builder
                public MapboxStreetsV8 build() {
                    return new AutoValue_MapboxStreetsV8(this.unrecognized, this.roadClass);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MapboxStreetsV8> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MapboxStreetsV8 mapboxStreetsV8) throws IOException {
            if (mapboxStreetsV8 == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (mapboxStreetsV8.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : mapboxStreetsV8.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name(JamXmlElements.CLASS);
            if (mapboxStreetsV8.roadClass() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mapboxStreetsV8.roadClass());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public MapboxStreetsV8 read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MapboxStreetsV8.Builder builder = MapboxStreetsV8.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals(JamXmlElements.CLASS)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.roadClass(typeAdapter.read(jsonReader));
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
            return "TypeAdapter(MapboxStreetsV8)";
        }
    }
}