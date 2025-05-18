package com.mapbox.api.matrix.p026v1.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.DirectionsWaypoint;
import com.mapbox.api.matrix.p026v1.models.MatrixResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MatrixResponse extends C$AutoValue_MatrixResponse {
    AutoValue_MatrixResponse(final String str, final List<DirectionsWaypoint> list, final List<DirectionsWaypoint> list2, final List<Double[]> list3, final List<Double[]> list4) {
        new MatrixResponse(str, list, list2, list3, list4) { // from class: com.mapbox.api.matrix.v1.models.$AutoValue_MatrixResponse
            private final String code;
            private final List<DirectionsWaypoint> destinations;
            private final List<Double[]> distances;
            private final List<Double[]> durations;
            private final List<DirectionsWaypoint> sources;

            {
                Objects.requireNonNull(str, "Null code");
                this.code = str;
                this.destinations = list;
                this.sources = list2;
                this.durations = list3;
                this.distances = list4;
            }

            @Override // com.mapbox.api.matrix.p026v1.models.MatrixResponse
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.matrix.p026v1.models.MatrixResponse
            public List<DirectionsWaypoint> destinations() {
                return this.destinations;
            }

            @Override // com.mapbox.api.matrix.p026v1.models.MatrixResponse
            public List<DirectionsWaypoint> sources() {
                return this.sources;
            }

            @Override // com.mapbox.api.matrix.p026v1.models.MatrixResponse
            public List<Double[]> durations() {
                return this.durations;
            }

            @Override // com.mapbox.api.matrix.p026v1.models.MatrixResponse
            public List<Double[]> distances() {
                return this.distances;
            }

            public String toString() {
                return "MatrixResponse{code=" + this.code + ", destinations=" + this.destinations + ", sources=" + this.sources + ", durations=" + this.durations + ", distances=" + this.distances + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                List<DirectionsWaypoint> list5;
                List<DirectionsWaypoint> list6;
                List<Double[]> list7;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MatrixResponse)) {
                    return false;
                }
                MatrixResponse matrixResponse = (MatrixResponse) obj;
                if (this.code.equals(matrixResponse.code()) && ((list5 = this.destinations) != null ? list5.equals(matrixResponse.destinations()) : matrixResponse.destinations() == null) && ((list6 = this.sources) != null ? list6.equals(matrixResponse.sources()) : matrixResponse.sources() == null) && ((list7 = this.durations) != null ? list7.equals(matrixResponse.durations()) : matrixResponse.durations() == null)) {
                    List<Double[]> list8 = this.distances;
                    if (list8 == null) {
                        if (matrixResponse.distances() == null) {
                            return true;
                        }
                    } else if (list8.equals(matrixResponse.distances())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int hashCode = (this.code.hashCode() ^ 1000003) * 1000003;
                List<DirectionsWaypoint> list5 = this.destinations;
                int hashCode2 = (hashCode ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
                List<DirectionsWaypoint> list6 = this.sources;
                int hashCode3 = (hashCode2 ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
                List<Double[]> list7 = this.durations;
                int hashCode4 = (hashCode3 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
                List<Double[]> list8 = this.distances;
                return hashCode4 ^ (list8 != null ? list8.hashCode() : 0);
            }

            @Override // com.mapbox.api.matrix.p026v1.models.MatrixResponse
            public MatrixResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.matrix.v1.models.$AutoValue_MatrixResponse$Builder */
            static class Builder extends MatrixResponse.Builder {
                private String code;
                private List<DirectionsWaypoint> destinations;
                private List<Double[]> distances;
                private List<Double[]> durations;
                private List<DirectionsWaypoint> sources;

                Builder() {
                }

                private Builder(MatrixResponse matrixResponse) {
                    this.code = matrixResponse.code();
                    this.destinations = matrixResponse.destinations();
                    this.sources = matrixResponse.sources();
                    this.durations = matrixResponse.durations();
                    this.distances = matrixResponse.distances();
                }

                @Override // com.mapbox.api.matrix.v1.models.MatrixResponse.Builder
                public MatrixResponse.Builder code(String str) {
                    Objects.requireNonNull(str, "Null code");
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.matrix.v1.models.MatrixResponse.Builder
                public MatrixResponse.Builder destinations(List<DirectionsWaypoint> list) {
                    this.destinations = list;
                    return this;
                }

                @Override // com.mapbox.api.matrix.v1.models.MatrixResponse.Builder
                public MatrixResponse.Builder sources(List<DirectionsWaypoint> list) {
                    this.sources = list;
                    return this;
                }

                @Override // com.mapbox.api.matrix.v1.models.MatrixResponse.Builder
                public MatrixResponse.Builder durations(List<Double[]> list) {
                    this.durations = list;
                    return this;
                }

                @Override // com.mapbox.api.matrix.v1.models.MatrixResponse.Builder
                public MatrixResponse.Builder distances(List<Double[]> list) {
                    this.distances = list;
                    return this;
                }

                @Override // com.mapbox.api.matrix.v1.models.MatrixResponse.Builder
                public MatrixResponse build() {
                    String str = this.code == null ? " code" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_MatrixResponse(this.code, this.destinations, this.sources, this.durations, this.distances);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MatrixResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<Double[]>> list__array__double_adapter;
        private volatile TypeAdapter<List<DirectionsWaypoint>> list__directionsWaypoint_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MatrixResponse matrixResponse) throws IOException {
            if (matrixResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("code");
            if (matrixResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, matrixResponse.code());
            }
            jsonWriter.name("destinations");
            if (matrixResponse.destinations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsWaypoint>> typeAdapter2 = this.list__directionsWaypoint_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                    this.list__directionsWaypoint_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, matrixResponse.destinations());
            }
            jsonWriter.name("sources");
            if (matrixResponse.sources() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsWaypoint>> typeAdapter3 = this.list__directionsWaypoint_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                    this.list__directionsWaypoint_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, matrixResponse.sources());
            }
            jsonWriter.name("durations");
            if (matrixResponse.durations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double[]>> typeAdapter4 = this.list__array__double_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                    this.list__array__double_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, matrixResponse.durations());
            }
            jsonWriter.name("distances");
            if (matrixResponse.distances() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double[]>> typeAdapter5 = this.list__array__double_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                    this.list__array__double_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, matrixResponse.distances());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public MatrixResponse read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MatrixResponse.Builder builder = MatrixResponse.builder();
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
                    } else if ("destinations".equals(nextName)) {
                        TypeAdapter<List<DirectionsWaypoint>> typeAdapter2 = this.list__directionsWaypoint_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                            this.list__directionsWaypoint_adapter = typeAdapter2;
                        }
                        builder.destinations(typeAdapter2.read(jsonReader));
                    } else if ("sources".equals(nextName)) {
                        TypeAdapter<List<DirectionsWaypoint>> typeAdapter3 = this.list__directionsWaypoint_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                            this.list__directionsWaypoint_adapter = typeAdapter3;
                        }
                        builder.sources(typeAdapter3.read(jsonReader));
                    } else if ("durations".equals(nextName)) {
                        TypeAdapter<List<Double[]>> typeAdapter4 = this.list__array__double_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                            this.list__array__double_adapter = typeAdapter4;
                        }
                        builder.durations(typeAdapter4.read(jsonReader));
                    } else if ("distances".equals(nextName)) {
                        TypeAdapter<List<Double[]>> typeAdapter5 = this.list__array__double_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double[].class));
                            this.list__array__double_adapter = typeAdapter5;
                        }
                        builder.distances(typeAdapter5.read(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(MatrixResponse)";
        }
    }
}