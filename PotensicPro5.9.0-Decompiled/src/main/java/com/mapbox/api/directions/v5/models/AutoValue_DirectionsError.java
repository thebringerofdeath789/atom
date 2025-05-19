package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.DirectionsError;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_DirectionsError extends C$AutoValue_DirectionsError {
    AutoValue_DirectionsError(final Map<String, SerializableJsonElement> map, final String str, final String str2) {
        new DirectionsError(map, str, str2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsError
            private final String code;
            private final String message;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.code = str;
                this.message = str2;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsError
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsError
            public String message() {
                return this.message;
            }

            public String toString() {
                return "DirectionsError{unrecognized=" + this.unrecognized + ", code=" + this.code + ", message=" + this.message + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsError)) {
                    return false;
                }
                DirectionsError directionsError = (DirectionsError) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(directionsError.unrecognized()) : directionsError.unrecognized() == null) {
                    String str3 = this.code;
                    if (str3 != null ? str3.equals(directionsError.code()) : directionsError.code() == null) {
                        String str4 = this.message;
                        if (str4 == null) {
                            if (directionsError.message() == null) {
                                return true;
                            }
                        } else if (str4.equals(directionsError.message())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                String str3 = this.code;
                int hashCode2 = (hashCode ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                String str4 = this.message;
                return hashCode2 ^ (str4 != null ? str4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsError
            public DirectionsError.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsError$Builder */
            static class Builder extends DirectionsError.Builder {
                private String code;
                private String message;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ DirectionsError.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(DirectionsError directionsError) {
                    this.unrecognized = directionsError.unrecognized();
                    this.code = directionsError.code();
                    this.message = directionsError.message();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                DirectionsError.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsError.Builder
                public DirectionsError.Builder code(String str) {
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsError.Builder
                public DirectionsError.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsError.Builder
                public DirectionsError build() {
                    return new AutoValue_DirectionsError(this.unrecognized, this.code, this.message);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsError> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsError directionsError) throws IOException {
            if (directionsError == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (directionsError.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : directionsError.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("code");
            if (directionsError.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, directionsError.code());
            }
            jsonWriter.name("message");
            if (directionsError.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, directionsError.message());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public DirectionsError read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsError.Builder builder = DirectionsError.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("code".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.code(typeAdapter.read2(jsonReader));
                    } else if ("message".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.message(typeAdapter2.read2(jsonReader));
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
            return "TypeAdapter(DirectionsError)";
        }
    }
}
