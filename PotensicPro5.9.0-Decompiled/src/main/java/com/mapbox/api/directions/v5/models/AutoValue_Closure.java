package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.Closure;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Closure extends C$AutoValue_Closure {
    AutoValue_Closure(Map<String, SerializableJsonElement> map, Integer num, Integer num2) {
        new Closure(map, num, num2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_Closure
            private final Integer geometryIndexEnd;
            private final Integer geometryIndexStart;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(num, "Null geometryIndexStart");
                this.geometryIndexStart = num;
                Objects.requireNonNull(num2, "Null geometryIndexEnd");
                this.geometryIndexEnd = num2;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.Closure
            @SerializedName("geometry_index_start")
            public Integer geometryIndexStart() {
                return this.geometryIndexStart;
            }

            @Override // com.mapbox.api.directions.v5.models.Closure
            @SerializedName("geometry_index_end")
            public Integer geometryIndexEnd() {
                return this.geometryIndexEnd;
            }

            public String toString() {
                return "Closure{unrecognized=" + this.unrecognized + ", geometryIndexStart=" + this.geometryIndexStart + ", geometryIndexEnd=" + this.geometryIndexEnd + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Closure)) {
                    return false;
                }
                Closure closure = (Closure) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(closure.unrecognized()) : closure.unrecognized() == null) {
                    if (this.geometryIndexStart.equals(closure.geometryIndexStart()) && this.geometryIndexEnd.equals(closure.geometryIndexEnd())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.geometryIndexStart.hashCode()) * 1000003) ^ this.geometryIndexEnd.hashCode();
            }

            @Override // com.mapbox.api.directions.v5.models.Closure
            public Closure.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_Closure$Builder */
            static class Builder extends Closure.Builder {
                private Integer geometryIndexEnd;
                private Integer geometryIndexStart;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ Closure.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(Closure closure) {
                    this.unrecognized = closure.unrecognized();
                    this.geometryIndexStart = closure.geometryIndexStart();
                    this.geometryIndexEnd = closure.geometryIndexEnd();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                Closure.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Closure.Builder
                public Closure.Builder geometryIndexStart(Integer num) {
                    Objects.requireNonNull(num, "Null geometryIndexStart");
                    this.geometryIndexStart = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Closure.Builder
                public Closure.Builder geometryIndexEnd(Integer num) {
                    Objects.requireNonNull(num, "Null geometryIndexEnd");
                    this.geometryIndexEnd = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Closure.Builder
                public Closure build() {
                    String str = this.geometryIndexStart == null ? " geometryIndexStart" : "";
                    if (this.geometryIndexEnd == null) {
                        str = str + " geometryIndexEnd";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_Closure(this.unrecognized, this.geometryIndexStart, this.geometryIndexEnd);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<Closure> {
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Closure closure) throws IOException {
            if (closure == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (closure.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : closure.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("geometry_index_start");
            if (closure.geometryIndexStart() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, closure.geometryIndexStart());
            }
            jsonWriter.name("geometry_index_end");
            if (closure.geometryIndexEnd() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter2 = this.integer_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, closure.geometryIndexEnd());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Closure read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Closure.Builder builder = Closure.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("geometry_index_start")) {
                        TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter;
                        }
                        builder.geometryIndexStart(typeAdapter.read2(jsonReader));
                    } else if (nextName.equals("geometry_index_end")) {
                        TypeAdapter<Integer> typeAdapter2 = this.integer_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter2;
                        }
                        builder.geometryIndexEnd(typeAdapter2.read2(jsonReader));
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
            return "TypeAdapter(Closure)";
        }
    }
}
