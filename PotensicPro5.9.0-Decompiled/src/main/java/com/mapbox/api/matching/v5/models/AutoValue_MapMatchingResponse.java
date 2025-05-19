package com.mapbox.api.matching.v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.matching.v5.models.MapMatchingResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapMatchingResponse extends C$AutoValue_MapMatchingResponse {
    AutoValue_MapMatchingResponse(String str, String str2, List<MapMatchingMatching> list, List<MapMatchingTracepoint> list2) {
        new MapMatchingResponse(str, str2, list, list2) { // from class: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingResponse
            private final String code;
            private final List<MapMatchingMatching> matchings;
            private final String message;
            private final List<MapMatchingTracepoint> tracepoints;

            {
                Objects.requireNonNull(str, "Null code");
                this.code = str;
                this.message = str2;
                this.matchings = list;
                this.tracepoints = list2;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse
            public String message() {
                return this.message;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse
            public List<MapMatchingMatching> matchings() {
                return this.matchings;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse
            public List<MapMatchingTracepoint> tracepoints() {
                return this.tracepoints;
            }

            public String toString() {
                return "MapMatchingResponse{code=" + this.code + ", message=" + this.message + ", matchings=" + this.matchings + ", tracepoints=" + this.tracepoints + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str3;
                List<MapMatchingMatching> list3;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MapMatchingResponse)) {
                    return false;
                }
                MapMatchingResponse mapMatchingResponse = (MapMatchingResponse) obj;
                if (this.code.equals(mapMatchingResponse.code()) && ((str3 = this.message) != null ? str3.equals(mapMatchingResponse.message()) : mapMatchingResponse.message() == null) && ((list3 = this.matchings) != null ? list3.equals(mapMatchingResponse.matchings()) : mapMatchingResponse.matchings() == null)) {
                    List<MapMatchingTracepoint> list4 = this.tracepoints;
                    if (list4 == null) {
                        if (mapMatchingResponse.tracepoints() == null) {
                            return true;
                        }
                    } else if (list4.equals(mapMatchingResponse.tracepoints())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int hashCode = (this.code.hashCode() ^ 1000003) * 1000003;
                String str3 = this.message;
                int hashCode2 = (hashCode ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                List<MapMatchingMatching> list3 = this.matchings;
                int hashCode3 = (hashCode2 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                List<MapMatchingTracepoint> list4 = this.tracepoints;
                return hashCode3 ^ (list4 != null ? list4.hashCode() : 0);
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse
            public MapMatchingResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingResponse$Builder */
            static class Builder extends MapMatchingResponse.Builder {
                private String code;
                private List<MapMatchingMatching> matchings;
                private String message;
                private List<MapMatchingTracepoint> tracepoints;

                Builder() {
                }

                private Builder(MapMatchingResponse mapMatchingResponse) {
                    this.code = mapMatchingResponse.code();
                    this.message = mapMatchingResponse.message();
                    this.matchings = mapMatchingResponse.matchings();
                    this.tracepoints = mapMatchingResponse.tracepoints();
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse.Builder
                public MapMatchingResponse.Builder code(String str) {
                    Objects.requireNonNull(str, "Null code");
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse.Builder
                public MapMatchingResponse.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse.Builder
                public MapMatchingResponse.Builder matchings(List<MapMatchingMatching> list) {
                    this.matchings = list;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse.Builder
                public MapMatchingResponse.Builder tracepoints(List<MapMatchingTracepoint> list) {
                    this.tracepoints = list;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingResponse.Builder
                public MapMatchingResponse build() {
                    String str = this.code == null ? " code" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_MapMatchingResponse(this.code, this.message, this.matchings, this.tracepoints);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MapMatchingResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<MapMatchingMatching>> list__mapMatchingMatching_adapter;
        private volatile TypeAdapter<List<MapMatchingTracepoint>> list__mapMatchingTracepoint_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MapMatchingResponse mapMatchingResponse) throws IOException {
            if (mapMatchingResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("code");
            if (mapMatchingResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mapMatchingResponse.code());
            }
            jsonWriter.name("message");
            if (mapMatchingResponse.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, mapMatchingResponse.message());
            }
            jsonWriter.name("matchings");
            if (mapMatchingResponse.matchings() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<MapMatchingMatching>> typeAdapter3 = this.list__mapMatchingMatching_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MapMatchingMatching.class));
                    this.list__mapMatchingMatching_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, mapMatchingResponse.matchings());
            }
            jsonWriter.name("tracepoints");
            if (mapMatchingResponse.tracepoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<MapMatchingTracepoint>> typeAdapter4 = this.list__mapMatchingTracepoint_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MapMatchingTracepoint.class));
                    this.list__mapMatchingTracepoint_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, mapMatchingResponse.tracepoints());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public MapMatchingResponse read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MapMatchingResponse.Builder builder = MapMatchingResponse.builder();
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
                    } else if ("matchings".equals(nextName)) {
                        TypeAdapter<List<MapMatchingMatching>> typeAdapter3 = this.list__mapMatchingMatching_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MapMatchingMatching.class));
                            this.list__mapMatchingMatching_adapter = typeAdapter3;
                        }
                        builder.matchings(typeAdapter3.read2(jsonReader));
                    } else if ("tracepoints".equals(nextName)) {
                        TypeAdapter<List<MapMatchingTracepoint>> typeAdapter4 = this.list__mapMatchingTracepoint_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MapMatchingTracepoint.class));
                            this.list__mapMatchingTracepoint_adapter = typeAdapter4;
                        }
                        builder.tracepoints(typeAdapter4.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(MapMatchingResponse)";
        }
    }
}
