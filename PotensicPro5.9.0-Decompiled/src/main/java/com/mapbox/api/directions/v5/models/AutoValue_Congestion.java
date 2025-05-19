package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.Congestion;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Congestion extends C$AutoValue_Congestion {
    AutoValue_Congestion(Map<String, SerializableJsonElement> map, int i) {
        new Congestion(map, i) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_Congestion
            private final Map<String, SerializableJsonElement> unrecognized;
            private final int value;

            {
                this.unrecognized = map;
                this.value = i;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.Congestion
            public int value() {
                return this.value;
            }

            public String toString() {
                return "Congestion{unrecognized=" + this.unrecognized + ", value=" + this.value + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Congestion)) {
                    return false;
                }
                Congestion congestion = (Congestion) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(congestion.unrecognized()) : congestion.unrecognized() == null) {
                    if (this.value == congestion.value()) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.value;
            }

            @Override // com.mapbox.api.directions.v5.models.Congestion
            public Congestion.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_Congestion$Builder */
            static class Builder extends Congestion.Builder {
                private Map<String, SerializableJsonElement> unrecognized;
                private Integer value;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ Congestion.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(Congestion congestion) {
                    this.unrecognized = congestion.unrecognized();
                    this.value = Integer.valueOf(congestion.value());
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                Congestion.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Congestion.Builder
                public Congestion.Builder value(int i) {
                    this.value = Integer.valueOf(i);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Congestion.Builder
                public Congestion build() {
                    String str = this.value == null ? " value" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_Congestion(this.unrecognized, this.value.intValue());
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<Congestion> {
        private final Gson gson;
        private volatile TypeAdapter<Integer> int__adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Congestion congestion) throws IOException {
            if (congestion == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (congestion.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : congestion.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("value");
            TypeAdapter<Integer> typeAdapter = this.int__adapter;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getAdapter(Integer.class);
                this.int__adapter = typeAdapter;
            }
            typeAdapter.write(jsonWriter, Integer.valueOf(congestion.value()));
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Congestion read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Congestion.Builder builder = Congestion.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("value".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter = this.int__adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Integer.class);
                            this.int__adapter = typeAdapter;
                        }
                        builder.value(typeAdapter.read2(jsonReader).intValue());
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
            return "TypeAdapter(Congestion)";
        }
    }
}
