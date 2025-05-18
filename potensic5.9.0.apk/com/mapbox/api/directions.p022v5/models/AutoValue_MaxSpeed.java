package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.MaxSpeed;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MaxSpeed extends C$AutoValue_MaxSpeed {
    AutoValue_MaxSpeed(final Map<String, SerializableJsonElement> map, final Integer num, final String str, final Boolean bool, final Boolean bool2) {
        new MaxSpeed(map, num, str, bool, bool2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_MaxSpeed
            private final Boolean none;
            private final Integer speed;
            private final String unit;
            private final Boolean unknown;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.speed = num;
                this.unit = str;
                this.unknown = bool;
                this.none = bool2;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MaxSpeed
            public Integer speed() {
                return this.speed;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MaxSpeed
            public String unit() {
                return this.unit;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MaxSpeed
            public Boolean unknown() {
                return this.unknown;
            }

            @Override // com.mapbox.api.directions.p022v5.models.MaxSpeed
            public Boolean none() {
                return this.none;
            }

            public String toString() {
                return "MaxSpeed{unrecognized=" + this.unrecognized + ", speed=" + this.speed + ", unit=" + this.unit + ", unknown=" + this.unknown + ", none=" + this.none + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MaxSpeed)) {
                    return false;
                }
                MaxSpeed maxSpeed = (MaxSpeed) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(maxSpeed.unrecognized()) : maxSpeed.unrecognized() == null) {
                    Integer num2 = this.speed;
                    if (num2 != null ? num2.equals(maxSpeed.speed()) : maxSpeed.speed() == null) {
                        String str2 = this.unit;
                        if (str2 != null ? str2.equals(maxSpeed.unit()) : maxSpeed.unit() == null) {
                            Boolean bool3 = this.unknown;
                            if (bool3 != null ? bool3.equals(maxSpeed.unknown()) : maxSpeed.unknown() == null) {
                                Boolean bool4 = this.none;
                                if (bool4 == null) {
                                    if (maxSpeed.none() == null) {
                                        return true;
                                    }
                                } else if (bool4.equals(maxSpeed.none())) {
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
                Integer num2 = this.speed;
                int hashCode2 = (hashCode ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
                String str2 = this.unit;
                int hashCode3 = (hashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                Boolean bool3 = this.unknown;
                int hashCode4 = (hashCode3 ^ (bool3 == null ? 0 : bool3.hashCode())) * 1000003;
                Boolean bool4 = this.none;
                return hashCode4 ^ (bool4 != null ? bool4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.MaxSpeed
            public MaxSpeed.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_MaxSpeed$Builder */
            static class Builder extends MaxSpeed.Builder {
                private Boolean none;
                private Integer speed;
                private String unit;
                private Boolean unknown;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ MaxSpeed.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(MaxSpeed maxSpeed) {
                    this.unrecognized = maxSpeed.unrecognized();
                    this.speed = maxSpeed.speed();
                    this.unit = maxSpeed.unit();
                    this.unknown = maxSpeed.unknown();
                    this.none = maxSpeed.none();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                MaxSpeed.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MaxSpeed.Builder
                public MaxSpeed.Builder speed(Integer num) {
                    this.speed = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MaxSpeed.Builder
                public MaxSpeed.Builder unit(String str) {
                    this.unit = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MaxSpeed.Builder
                public MaxSpeed.Builder unknown(Boolean bool) {
                    this.unknown = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MaxSpeed.Builder
                public MaxSpeed.Builder none(Boolean bool) {
                    this.none = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.MaxSpeed.Builder
                public MaxSpeed build() {
                    return new AutoValue_MaxSpeed(this.unrecognized, this.speed, this.unit, this.unknown, this.none);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MaxSpeed> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MaxSpeed maxSpeed) throws IOException {
            if (maxSpeed == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (maxSpeed.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : maxSpeed.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("speed");
            if (maxSpeed.speed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, maxSpeed.speed());
            }
            jsonWriter.name("unit");
            if (maxSpeed.unit() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, maxSpeed.unit());
            }
            jsonWriter.name("unknown");
            if (maxSpeed.unknown() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter3 = this.boolean__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, maxSpeed.unknown());
            }
            jsonWriter.name("none");
            if (maxSpeed.none() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter4 = this.boolean__adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, maxSpeed.none());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public MaxSpeed read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MaxSpeed.Builder builder = MaxSpeed.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("speed".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter;
                        }
                        builder.speed(typeAdapter.read(jsonReader));
                    } else if ("unit".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.unit(typeAdapter2.read(jsonReader));
                    } else if ("unknown".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter3 = this.boolean__adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = typeAdapter3;
                        }
                        builder.unknown(typeAdapter3.read(jsonReader));
                    } else if ("none".equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter4 = this.boolean__adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = typeAdapter4;
                        }
                        builder.none(typeAdapter4.read(jsonReader));
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
            return "TypeAdapter(MaxSpeed)";
        }
    }
}