package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.RestStop;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_RestStop extends C$AutoValue_RestStop {
    AutoValue_RestStop(Map<String, SerializableJsonElement> map, String str, String str2, List<Amenity> list, String str3) {
        new RestStop(map, str, str2, list, str3) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_RestStop
            private final List<Amenity> amenities;
            private final String guideMap;
            private final String name;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.type = str;
                this.name = str2;
                this.amenities = list;
                this.guideMap = str3;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.RestStop
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.v5.models.RestStop
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.directions.v5.models.RestStop
            public List<Amenity> amenities() {
                return this.amenities;
            }

            @Override // com.mapbox.api.directions.v5.models.RestStop
            @SerializedName("guidemap")
            public String guideMap() {
                return this.guideMap;
            }

            public String toString() {
                return "RestStop{unrecognized=" + this.unrecognized + ", type=" + this.type + ", name=" + this.name + ", amenities=" + this.amenities + ", guideMap=" + this.guideMap + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RestStop)) {
                    return false;
                }
                RestStop restStop = (RestStop) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(restStop.unrecognized()) : restStop.unrecognized() == null) {
                    String str4 = this.type;
                    if (str4 != null ? str4.equals(restStop.type()) : restStop.type() == null) {
                        String str5 = this.name;
                        if (str5 != null ? str5.equals(restStop.name()) : restStop.name() == null) {
                            List<Amenity> list2 = this.amenities;
                            if (list2 != null ? list2.equals(restStop.amenities()) : restStop.amenities() == null) {
                                String str6 = this.guideMap;
                                if (str6 == null) {
                                    if (restStop.guideMap() == null) {
                                        return true;
                                    }
                                } else if (str6.equals(restStop.guideMap())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                String str4 = this.type;
                int hashCode2 = (hashCode ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                String str5 = this.name;
                int hashCode3 = (hashCode2 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                List<Amenity> list2 = this.amenities;
                int hashCode4 = (hashCode3 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
                String str6 = this.guideMap;
                return hashCode4 ^ (str6 != null ? str6.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.RestStop
            public RestStop.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_RestStop$Builder */
            static class Builder extends RestStop.Builder {
                private List<Amenity> amenities;
                private String guideMap;
                private String name;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ RestStop.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(RestStop restStop) {
                    this.unrecognized = restStop.unrecognized();
                    this.type = restStop.type();
                    this.name = restStop.name();
                    this.amenities = restStop.amenities();
                    this.guideMap = restStop.guideMap();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                RestStop.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RestStop.Builder
                public RestStop.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RestStop.Builder
                public RestStop.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RestStop.Builder
                public RestStop.Builder amenities(List<Amenity> list) {
                    this.amenities = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RestStop.Builder
                public RestStop.Builder guideMap(String str) {
                    this.guideMap = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RestStop.Builder
                public RestStop build() {
                    return new AutoValue_RestStop(this.unrecognized, this.type, this.name, this.amenities, this.guideMap);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RestStop> {
        private final Gson gson;
        private volatile TypeAdapter<List<Amenity>> list__amenity_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RestStop restStop) throws IOException {
            if (restStop == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (restStop.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : restStop.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("type");
            if (restStop.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, restStop.type());
            }
            jsonWriter.name("name");
            if (restStop.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, restStop.name());
            }
            jsonWriter.name("amenities");
            if (restStop.amenities() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Amenity>> typeAdapter3 = this.list__amenity_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Amenity.class));
                    this.list__amenity_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, restStop.amenities());
            }
            jsonWriter.name("guidemap");
            if (restStop.guideMap() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, restStop.guideMap());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public RestStop read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RestStop.Builder builder = RestStop.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("guidemap")) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.guideMap(typeAdapter.read2(jsonReader));
                    } else if ("type".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.type(typeAdapter2.read2(jsonReader));
                    } else if ("name".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.string_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter3;
                        }
                        builder.name(typeAdapter3.read2(jsonReader));
                    } else if ("amenities".equals(nextName)) {
                        TypeAdapter<List<Amenity>> typeAdapter4 = this.list__amenity_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Amenity.class));
                            this.list__amenity_adapter = typeAdapter4;
                        }
                        builder.amenities(typeAdapter4.read2(jsonReader));
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
            return "TypeAdapter(RestStop)";
        }
    }
}
