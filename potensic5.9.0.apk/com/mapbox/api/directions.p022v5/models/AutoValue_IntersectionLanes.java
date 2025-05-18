package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.IntersectionLanes;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_IntersectionLanes extends C$AutoValue_IntersectionLanes {
    AutoValue_IntersectionLanes(final Map<String, SerializableJsonElement> map, final Boolean bool, final Boolean bool2, final String str, final List<String> list) {
        new IntersectionLanes(map, bool, bool2, str, list) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_IntersectionLanes
            private final Boolean active;
            private final List<String> indications;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final Boolean valid;
            private final String validIndication;

            {
                this.unrecognized = map;
                this.valid = bool;
                this.active = bool2;
                this.validIndication = str;
                this.indications = list;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.IntersectionLanes
            public Boolean valid() {
                return this.valid;
            }

            @Override // com.mapbox.api.directions.p022v5.models.IntersectionLanes
            public Boolean active() {
                return this.active;
            }

            @Override // com.mapbox.api.directions.p022v5.models.IntersectionLanes
            @SerializedName("valid_indication")
            public String validIndication() {
                return this.validIndication;
            }

            @Override // com.mapbox.api.directions.p022v5.models.IntersectionLanes
            public List<String> indications() {
                return this.indications;
            }

            public String toString() {
                return "IntersectionLanes{unrecognized=" + this.unrecognized + ", valid=" + this.valid + ", active=" + this.active + ", validIndication=" + this.validIndication + ", indications=" + this.indications + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof IntersectionLanes)) {
                    return false;
                }
                IntersectionLanes intersectionLanes = (IntersectionLanes) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(intersectionLanes.unrecognized()) : intersectionLanes.unrecognized() == null) {
                    Boolean bool3 = this.valid;
                    if (bool3 != null ? bool3.equals(intersectionLanes.valid()) : intersectionLanes.valid() == null) {
                        Boolean bool4 = this.active;
                        if (bool4 != null ? bool4.equals(intersectionLanes.active()) : intersectionLanes.active() == null) {
                            String str2 = this.validIndication;
                            if (str2 != null ? str2.equals(intersectionLanes.validIndication()) : intersectionLanes.validIndication() == null) {
                                List<String> list2 = this.indications;
                                if (list2 == null) {
                                    if (intersectionLanes.indications() == null) {
                                        return true;
                                    }
                                } else if (list2.equals(intersectionLanes.indications())) {
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
                Boolean bool3 = this.valid;
                int hashCode2 = (hashCode ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
                Boolean bool4 = this.active;
                int hashCode3 = (hashCode2 ^ (bool4 == null ? 0 : bool4.hashCode())) * 1000003;
                String str2 = this.validIndication;
                int hashCode4 = (hashCode3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                List<String> list2 = this.indications;
                return hashCode4 ^ (list2 != null ? list2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.IntersectionLanes
            public IntersectionLanes.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_IntersectionLanes$Builder */
            static class Builder extends IntersectionLanes.Builder {
                private Boolean active;
                private List<String> indications;
                private Map<String, SerializableJsonElement> unrecognized;
                private Boolean valid;
                private String validIndication;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ IntersectionLanes.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(IntersectionLanes intersectionLanes) {
                    this.unrecognized = intersectionLanes.unrecognized();
                    this.valid = intersectionLanes.valid();
                    this.active = intersectionLanes.active();
                    this.validIndication = intersectionLanes.validIndication();
                    this.indications = intersectionLanes.indications();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                IntersectionLanes.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.IntersectionLanes.Builder
                public IntersectionLanes.Builder valid(Boolean bool) {
                    this.valid = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.IntersectionLanes.Builder
                public IntersectionLanes.Builder active(Boolean bool) {
                    this.active = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.IntersectionLanes.Builder
                public IntersectionLanes.Builder validIndication(String str) {
                    this.validIndication = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.IntersectionLanes.Builder
                public IntersectionLanes.Builder indications(List<String> list) {
                    this.indications = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.IntersectionLanes.Builder
                public IntersectionLanes build() {
                    return new AutoValue_IntersectionLanes(this.unrecognized, this.valid, this.active, this.validIndication, this.indications);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<IntersectionLanes> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, IntersectionLanes intersectionLanes) throws IOException {
            if (intersectionLanes == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (intersectionLanes.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : intersectionLanes.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("valid");
            if (intersectionLanes.valid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter = this.boolean__adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, intersectionLanes.valid());
            }
            jsonWriter.name("active");
            if (intersectionLanes.active() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter2 = this.boolean__adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, intersectionLanes.active());
            }
            jsonWriter.name("valid_indication");
            if (intersectionLanes.validIndication() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, intersectionLanes.validIndication());
            }
            jsonWriter.name("indications");
            if (intersectionLanes.indications() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter4 = this.list__string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, intersectionLanes.indications());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public IntersectionLanes read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            IntersectionLanes.Builder builder = IntersectionLanes.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("valid_indication")) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.validIndication(typeAdapter.read(jsonReader));
                    } else if ("valid".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter2 = this.boolean__adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = typeAdapter2;
                        }
                        builder.valid(typeAdapter2.read(jsonReader));
                    } else if ("active".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter3 = this.boolean__adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = typeAdapter3;
                        }
                        builder.active(typeAdapter3.read(jsonReader));
                    } else if ("indications".equals(nextName)) {
                        TypeAdapter<List<String>> typeAdapter4 = this.list__string_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = typeAdapter4;
                        }
                        builder.indications(typeAdapter4.read(jsonReader));
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
            return "TypeAdapter(IntersectionLanes)";
        }
    }
}