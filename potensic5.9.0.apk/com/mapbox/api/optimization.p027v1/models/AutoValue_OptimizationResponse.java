package com.mapbox.api.optimization.p027v1.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.DirectionsRoute;
import com.mapbox.api.optimization.p027v1.models.OptimizationResponse;
import java.io.IOException;
import java.util.List;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_OptimizationResponse extends C$AutoValue_OptimizationResponse {
    AutoValue_OptimizationResponse(final String str, final List<OptimizationWaypoint> list, final List<DirectionsRoute> list2) {
        new OptimizationResponse(str, list, list2) { // from class: com.mapbox.api.optimization.v1.models.$AutoValue_OptimizationResponse
            private final String code;
            private final List<DirectionsRoute> trips;
            private final List<OptimizationWaypoint> waypoints;

            {
                this.code = str;
                this.waypoints = list;
                this.trips = list2;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationResponse
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationResponse
            public List<OptimizationWaypoint> waypoints() {
                return this.waypoints;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationResponse
            public List<DirectionsRoute> trips() {
                return this.trips;
            }

            public String toString() {
                return "OptimizationResponse{code=" + this.code + ", waypoints=" + this.waypoints + ", trips=" + this.trips + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof OptimizationResponse)) {
                    return false;
                }
                OptimizationResponse optimizationResponse = (OptimizationResponse) obj;
                String str2 = this.code;
                if (str2 != null ? str2.equals(optimizationResponse.code()) : optimizationResponse.code() == null) {
                    List<OptimizationWaypoint> list3 = this.waypoints;
                    if (list3 != null ? list3.equals(optimizationResponse.waypoints()) : optimizationResponse.waypoints() == null) {
                        List<DirectionsRoute> list4 = this.trips;
                        if (list4 == null) {
                            if (optimizationResponse.trips() == null) {
                                return true;
                            }
                        } else if (list4.equals(optimizationResponse.trips())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                String str2 = this.code;
                int hashCode = ((str2 == null ? 0 : str2.hashCode()) ^ 1000003) * 1000003;
                List<OptimizationWaypoint> list3 = this.waypoints;
                int hashCode2 = (hashCode ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                List<DirectionsRoute> list4 = this.trips;
                return hashCode2 ^ (list4 != null ? list4.hashCode() : 0);
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationResponse
            public OptimizationResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.optimization.v1.models.$AutoValue_OptimizationResponse$Builder */
            static class Builder extends OptimizationResponse.Builder {
                private String code;
                private List<DirectionsRoute> trips;
                private List<OptimizationWaypoint> waypoints;

                Builder() {
                }

                private Builder(OptimizationResponse optimizationResponse) {
                    this.code = optimizationResponse.code();
                    this.waypoints = optimizationResponse.waypoints();
                    this.trips = optimizationResponse.trips();
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationResponse.Builder
                public OptimizationResponse.Builder code(String str) {
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationResponse.Builder
                public OptimizationResponse.Builder waypoints(List<OptimizationWaypoint> list) {
                    this.waypoints = list;
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationResponse.Builder
                public OptimizationResponse.Builder trips(List<DirectionsRoute> list) {
                    this.trips = list;
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationResponse.Builder
                public OptimizationResponse build() {
                    return new AutoValue_OptimizationResponse(this.code, this.waypoints, this.trips);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<OptimizationResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<DirectionsRoute>> list__directionsRoute_adapter;
        private volatile TypeAdapter<List<OptimizationWaypoint>> list__optimizationWaypoint_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, OptimizationResponse optimizationResponse) throws IOException {
            if (optimizationResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("code");
            if (optimizationResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, optimizationResponse.code());
            }
            jsonWriter.name("waypoints");
            if (optimizationResponse.waypoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<OptimizationWaypoint>> typeAdapter2 = this.list__optimizationWaypoint_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, OptimizationWaypoint.class));
                    this.list__optimizationWaypoint_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, optimizationResponse.waypoints());
            }
            jsonWriter.name("trips");
            if (optimizationResponse.trips() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsRoute>> typeAdapter3 = this.list__directionsRoute_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                    this.list__directionsRoute_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, optimizationResponse.trips());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public OptimizationResponse read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            OptimizationResponse.Builder builder = OptimizationResponse.builder();
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
                    } else if ("waypoints".equals(nextName)) {
                        TypeAdapter<List<OptimizationWaypoint>> typeAdapter2 = this.list__optimizationWaypoint_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, OptimizationWaypoint.class));
                            this.list__optimizationWaypoint_adapter = typeAdapter2;
                        }
                        builder.waypoints(typeAdapter2.read(jsonReader));
                    } else if ("trips".equals(nextName)) {
                        TypeAdapter<List<DirectionsRoute>> typeAdapter3 = this.list__directionsRoute_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                            this.list__directionsRoute_adapter = typeAdapter3;
                        }
                        builder.trips(typeAdapter3.read(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(OptimizationResponse)";
        }
    }
}