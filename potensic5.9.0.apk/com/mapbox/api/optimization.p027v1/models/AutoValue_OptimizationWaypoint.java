package com.mapbox.api.optimization.p027v1.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_OptimizationWaypoint extends C$AutoValue_OptimizationWaypoint {
    AutoValue_OptimizationWaypoint(final int i, final int i2, final String str, final double[] dArr) {
        new OptimizationWaypoint(i, i2, str, dArr) { // from class: com.mapbox.api.optimization.v1.models.$AutoValue_OptimizationWaypoint
            private final String name;
            private final double[] rawLocation;
            private final int tripsIndex;
            private final int waypointIndex;

            {
                this.waypointIndex = i;
                this.tripsIndex = i2;
                this.name = str;
                this.rawLocation = dArr;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint
            @SerializedName("waypoint_index")
            public int waypointIndex() {
                return this.waypointIndex;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint
            @SerializedName("trips_index")
            public int tripsIndex() {
                return this.tripsIndex;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint
            @SerializedName("location")
            double[] rawLocation() {
                return this.rawLocation;
            }

            public String toString() {
                return "OptimizationWaypoint{waypointIndex=" + this.waypointIndex + ", tripsIndex=" + this.tripsIndex + ", name=" + this.name + ", rawLocation=" + Arrays.toString(this.rawLocation) + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str2;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof OptimizationWaypoint)) {
                    return false;
                }
                OptimizationWaypoint optimizationWaypoint = (OptimizationWaypoint) obj;
                if (this.waypointIndex == optimizationWaypoint.waypointIndex() && this.tripsIndex == optimizationWaypoint.tripsIndex() && ((str2 = this.name) != null ? str2.equals(optimizationWaypoint.name()) : optimizationWaypoint.name() == null)) {
                    if (Arrays.equals(this.rawLocation, optimizationWaypoint instanceof C$AutoValue_OptimizationWaypoint ? ((C$AutoValue_OptimizationWaypoint) optimizationWaypoint).rawLocation : optimizationWaypoint.rawLocation())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                int i3 = (((this.waypointIndex ^ 1000003) * 1000003) ^ this.tripsIndex) * 1000003;
                String str2 = this.name;
                return ((i3 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003) ^ Arrays.hashCode(this.rawLocation);
            }

            @Override // com.mapbox.api.optimization.p027v1.models.OptimizationWaypoint
            public OptimizationWaypoint.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.optimization.v1.models.$AutoValue_OptimizationWaypoint$Builder */
            static class Builder extends OptimizationWaypoint.Builder {
                private String name;
                private double[] rawLocation;
                private Integer tripsIndex;
                private Integer waypointIndex;

                Builder() {
                }

                private Builder(OptimizationWaypoint optimizationWaypoint) {
                    this.waypointIndex = Integer.valueOf(optimizationWaypoint.waypointIndex());
                    this.tripsIndex = Integer.valueOf(optimizationWaypoint.tripsIndex());
                    this.name = optimizationWaypoint.name();
                    this.rawLocation = optimizationWaypoint.rawLocation();
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationWaypoint.Builder
                public OptimizationWaypoint.Builder waypointIndex(int i) {
                    this.waypointIndex = Integer.valueOf(i);
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationWaypoint.Builder
                public OptimizationWaypoint.Builder tripsIndex(int i) {
                    this.tripsIndex = Integer.valueOf(i);
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationWaypoint.Builder
                public OptimizationWaypoint.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationWaypoint.Builder
                public OptimizationWaypoint.Builder rawLocation(double[] dArr) {
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mapbox.api.optimization.v1.models.OptimizationWaypoint.Builder
                public OptimizationWaypoint build() {
                    String str = this.waypointIndex == null ? " waypointIndex" : "";
                    if (this.tripsIndex == null) {
                        str = str + " tripsIndex";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_OptimizationWaypoint(this.waypointIndex.intValue(), this.tripsIndex.intValue(), this.name, this.rawLocation);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<OptimizationWaypoint> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> int__adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, OptimizationWaypoint optimizationWaypoint) throws IOException {
            if (optimizationWaypoint == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("waypoint_index");
            TypeAdapter<Integer> typeAdapter = this.int__adapter;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getAdapter(Integer.class);
                this.int__adapter = typeAdapter;
            }
            typeAdapter.write(jsonWriter, Integer.valueOf(optimizationWaypoint.waypointIndex()));
            jsonWriter.name("trips_index");
            TypeAdapter<Integer> typeAdapter2 = this.int__adapter;
            if (typeAdapter2 == null) {
                typeAdapter2 = this.gson.getAdapter(Integer.class);
                this.int__adapter = typeAdapter2;
            }
            typeAdapter2.write(jsonWriter, Integer.valueOf(optimizationWaypoint.tripsIndex()));
            jsonWriter.name("name");
            if (optimizationWaypoint.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, optimizationWaypoint.name());
            }
            jsonWriter.name("location");
            if (optimizationWaypoint.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> typeAdapter4 = this.array__double_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, optimizationWaypoint.rawLocation());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public OptimizationWaypoint read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            OptimizationWaypoint.Builder builder = OptimizationWaypoint.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "trips_index":
                            TypeAdapter<Integer> typeAdapter = this.int__adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Integer.class);
                                this.int__adapter = typeAdapter;
                            }
                            builder.tripsIndex(typeAdapter.read(jsonReader).intValue());
                            break;
                        case "waypoint_index":
                            TypeAdapter<Integer> typeAdapter2 = this.int__adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(Integer.class);
                                this.int__adapter = typeAdapter2;
                            }
                            builder.waypointIndex(typeAdapter2.read(jsonReader).intValue());
                            break;
                        case "location":
                            TypeAdapter<double[]> typeAdapter3 = this.array__double_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = typeAdapter3;
                            }
                            builder.rawLocation(typeAdapter3.read(jsonReader));
                            break;
                        default:
                            if ("name".equals(nextName)) {
                                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                                if (typeAdapter4 == null) {
                                    typeAdapter4 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter4;
                                }
                                builder.name(typeAdapter4.read(jsonReader));
                                break;
                            } else {
                                jsonReader.skipValue();
                                break;
                            }
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(OptimizationWaypoint)";
        }
    }
}