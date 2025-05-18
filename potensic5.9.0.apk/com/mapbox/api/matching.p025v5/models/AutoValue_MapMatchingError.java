package com.mapbox.api.matching.p025v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.matching.p025v5.models.MapMatchingError;
import java.io.IOException;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapMatchingError extends C$AutoValue_MapMatchingError {
    AutoValue_MapMatchingError(final String str, final String str2) {
        new MapMatchingError(str, str2) { // from class: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingError
            private final String code;
            private final String message;

            {
                this.code = str;
                this.message = str2;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingError
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingError
            public String message() {
                return this.message;
            }

            public String toString() {
                return "MapMatchingError{code=" + this.code + ", message=" + this.message + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MapMatchingError)) {
                    return false;
                }
                MapMatchingError mapMatchingError = (MapMatchingError) obj;
                String str3 = this.code;
                if (str3 != null ? str3.equals(mapMatchingError.code()) : mapMatchingError.code() == null) {
                    String str4 = this.message;
                    if (str4 == null) {
                        if (mapMatchingError.message() == null) {
                            return true;
                        }
                    } else if (str4.equals(mapMatchingError.message())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                String str3 = this.code;
                int hashCode = ((str3 == null ? 0 : str3.hashCode()) ^ 1000003) * 1000003;
                String str4 = this.message;
                return hashCode ^ (str4 != null ? str4.hashCode() : 0);
            }

            /* renamed from: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingError$Builder */
            static class Builder extends MapMatchingError.Builder {
                private String code;
                private String message;

                Builder() {
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingError.Builder
                public MapMatchingError.Builder code(String str) {
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingError.Builder
                public MapMatchingError.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingError.Builder
                public MapMatchingError build() {
                    return new AutoValue_MapMatchingError(this.code, this.message);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MapMatchingError> {
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MapMatchingError mapMatchingError) throws IOException {
            if (mapMatchingError == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("code");
            if (mapMatchingError.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mapMatchingError.code());
            }
            jsonWriter.name("message");
            if (mapMatchingError.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, mapMatchingError.message());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public MapMatchingError read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MapMatchingError.Builder builder = MapMatchingError.builder();
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
                        builder.code(typeAdapter.read(jsonReader));
                    } else if ("message".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.message(typeAdapter2.read(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(MapMatchingError)";
        }
    }
}