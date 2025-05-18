package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.MapboxShield;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapboxShield extends C$AutoValue_MapboxShield {
    AutoValue_MapboxShield(final Map<String, SerializableJsonElement> map, final String str, final String str2, final String str3, final String str4) {
        new MapboxShield(map, str, str2, str3, str4) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_MapboxShield
            private final String baseUrl;
            private final String displayRef;
            private final String name;
            private final String textColor;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null baseUrl");
                this.baseUrl = str;
                Objects.requireNonNull(str2, "Null name");
                this.name = str2;
                Objects.requireNonNull(str3, "Null textColor");
                this.textColor = str3;
                Objects.requireNonNull(str4, "Null displayRef");
                this.displayRef = str4;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxShield
            @SerializedName("base_url")
            public String baseUrl() {
                return this.baseUrl;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxShield
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxShield
            @SerializedName("text_color")
            public String textColor() {
                return this.textColor;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxShield
            @SerializedName("display_ref")
            public String displayRef() {
                return this.displayRef;
            }

            public String toString() {
                return "MapboxShield{unrecognized=" + this.unrecognized + ", baseUrl=" + this.baseUrl + ", name=" + this.name + ", textColor=" + this.textColor + ", displayRef=" + this.displayRef + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MapboxShield)) {
                    return false;
                }
                MapboxShield mapboxShield = (MapboxShield) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(mapboxShield.unrecognized()) : mapboxShield.unrecognized() == null) {
                    if (this.baseUrl.equals(mapboxShield.baseUrl()) && this.name.equals(mapboxShield.name()) && this.textColor.equals(mapboxShield.textColor()) && this.displayRef.equals(mapboxShield.displayRef())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.baseUrl.hashCode()) * 1000003) ^ this.name.hashCode()) * 1000003) ^ this.textColor.hashCode()) * 1000003) ^ this.displayRef.hashCode();
            }

            @Override // com.mapbox.api.directions.p022v5.models.MapboxShield
            public MapboxShield.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_MapboxShield$Builder */
            static class Builder extends MapboxShield.Builder {
                private String baseUrl;
                private String displayRef;
                private String name;
                private String textColor;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ MapboxShield.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(MapboxShield mapboxShield) {
                    this.unrecognized = mapboxShield.unrecognized();
                    this.baseUrl = mapboxShield.baseUrl();
                    this.name = mapboxShield.name();
                    this.textColor = mapboxShield.textColor();
                    this.displayRef = mapboxShield.displayRef();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                MapboxShield.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxShield.Builder
                public MapboxShield.Builder baseUrl(String str) {
                    Objects.requireNonNull(str, "Null baseUrl");
                    this.baseUrl = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxShield.Builder
                public MapboxShield.Builder name(String str) {
                    Objects.requireNonNull(str, "Null name");
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxShield.Builder
                public MapboxShield.Builder textColor(String str) {
                    Objects.requireNonNull(str, "Null textColor");
                    this.textColor = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxShield.Builder
                public MapboxShield.Builder displayRef(String str) {
                    Objects.requireNonNull(str, "Null displayRef");
                    this.displayRef = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MapboxShield.Builder
                public MapboxShield build() {
                    String str = this.baseUrl == null ? " baseUrl" : "";
                    if (this.name == null) {
                        str = str + " name";
                    }
                    if (this.textColor == null) {
                        str = str + " textColor";
                    }
                    if (this.displayRef == null) {
                        str = str + " displayRef";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_MapboxShield(this.unrecognized, this.baseUrl, this.name, this.textColor, this.displayRef);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MapboxShield> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MapboxShield mapboxShield) throws IOException {
            if (mapboxShield == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (mapboxShield.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : mapboxShield.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("base_url");
            if (mapboxShield.baseUrl() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mapboxShield.baseUrl());
            }
            jsonWriter.name("name");
            if (mapboxShield.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, mapboxShield.name());
            }
            jsonWriter.name("text_color");
            if (mapboxShield.textColor() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, mapboxShield.textColor());
            }
            jsonWriter.name("display_ref");
            if (mapboxShield.displayRef() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, mapboxShield.displayRef());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public MapboxShield read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MapboxShield.Builder builder = MapboxShield.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "text_color":
                            TypeAdapter<String> typeAdapter = this.string_adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter;
                            }
                            builder.textColor(typeAdapter.read(jsonReader));
                            break;
                        case "base_url":
                            TypeAdapter<String> typeAdapter2 = this.string_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter2;
                            }
                            builder.baseUrl(typeAdapter2.read(jsonReader));
                            break;
                        case "display_ref":
                            TypeAdapter<String> typeAdapter3 = this.string_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter3;
                            }
                            builder.displayRef(typeAdapter3.read(jsonReader));
                            break;
                        default:
                            if ("name".equals(nextName)) {
                                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                                if (typeAdapter4 == null) {
                                    typeAdapter4 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter4;
                                }
                                builder.name(typeAdapter4.read(jsonReader));
                                break;
                            } else {
                                if (linkedHashMap == null) {
                                    linkedHashMap = new LinkedHashMap();
                                    builder.unrecognized(linkedHashMap);
                                }
                                linkedHashMap.put(nextName, new SerializableJsonElement((JsonElement) this.gson.fromJson(jsonReader, JsonElement.class)));
                                break;
                            }
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(MapboxShield)";
        }
    }
}