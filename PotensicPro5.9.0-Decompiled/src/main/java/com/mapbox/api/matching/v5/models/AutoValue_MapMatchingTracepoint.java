package com.mapbox.api.matching.v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.matching.v5.models.MapMatchingTracepoint;
import java.io.IOException;
import java.util.Arrays;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapMatchingTracepoint extends C$AutoValue_MapMatchingTracepoint {
    AutoValue_MapMatchingTracepoint(Integer num, Integer num2, Integer num3, String str, double[] dArr) {
        new MapMatchingTracepoint(num, num2, num3, str, dArr) { // from class: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingTracepoint
            private final Integer alternativesCount;
            private final Integer matchingsIndex;
            private final String name;
            private final double[] rawLocation;
            private final Integer waypointIndex;

            {
                this.matchingsIndex = num;
                this.alternativesCount = num2;
                this.waypointIndex = num3;
                this.name = str;
                this.rawLocation = dArr;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint
            @SerializedName("matchings_index")
            public Integer matchingsIndex() {
                return this.matchingsIndex;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint
            @SerializedName("alternatives_count")
            public Integer alternativesCount() {
                return this.alternativesCount;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint
            @SerializedName("waypoint_index")
            public Integer waypointIndex() {
                return this.waypointIndex;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint
            @SerializedName("location")
            double[] rawLocation() {
                return this.rawLocation;
            }

            public String toString() {
                return "MapMatchingTracepoint{matchingsIndex=" + this.matchingsIndex + ", alternativesCount=" + this.alternativesCount + ", waypointIndex=" + this.waypointIndex + ", name=" + this.name + ", rawLocation=" + Arrays.toString(this.rawLocation) + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MapMatchingTracepoint)) {
                    return false;
                }
                MapMatchingTracepoint mapMatchingTracepoint = (MapMatchingTracepoint) obj;
                Integer num4 = this.matchingsIndex;
                if (num4 != null ? num4.equals(mapMatchingTracepoint.matchingsIndex()) : mapMatchingTracepoint.matchingsIndex() == null) {
                    Integer num5 = this.alternativesCount;
                    if (num5 != null ? num5.equals(mapMatchingTracepoint.alternativesCount()) : mapMatchingTracepoint.alternativesCount() == null) {
                        Integer num6 = this.waypointIndex;
                        if (num6 != null ? num6.equals(mapMatchingTracepoint.waypointIndex()) : mapMatchingTracepoint.waypointIndex() == null) {
                            String str2 = this.name;
                            if (str2 != null ? str2.equals(mapMatchingTracepoint.name()) : mapMatchingTracepoint.name() == null) {
                                if (Arrays.equals(this.rawLocation, mapMatchingTracepoint instanceof C$AutoValue_MapMatchingTracepoint ? ((C$AutoValue_MapMatchingTracepoint) mapMatchingTracepoint).rawLocation : mapMatchingTracepoint.rawLocation())) {
                                    return true;
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Integer num4 = this.matchingsIndex;
                int hashCode = ((num4 == null ? 0 : num4.hashCode()) ^ 1000003) * 1000003;
                Integer num5 = this.alternativesCount;
                int hashCode2 = (hashCode ^ (num5 == null ? 0 : num5.hashCode())) * 1000003;
                Integer num6 = this.waypointIndex;
                int hashCode3 = (hashCode2 ^ (num6 == null ? 0 : num6.hashCode())) * 1000003;
                String str2 = this.name;
                return ((hashCode3 ^ (str2 != null ? str2.hashCode() : 0)) * 1000003) ^ Arrays.hashCode(this.rawLocation);
            }

            @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint
            public MapMatchingTracepoint.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingTracepoint$Builder */
            static class Builder extends MapMatchingTracepoint.Builder {
                private Integer alternativesCount;
                private Integer matchingsIndex;
                private String name;
                private double[] rawLocation;
                private Integer waypointIndex;

                Builder() {
                }

                private Builder(MapMatchingTracepoint mapMatchingTracepoint) {
                    this.matchingsIndex = mapMatchingTracepoint.matchingsIndex();
                    this.alternativesCount = mapMatchingTracepoint.alternativesCount();
                    this.waypointIndex = mapMatchingTracepoint.waypointIndex();
                    this.name = mapMatchingTracepoint.name();
                    this.rawLocation = mapMatchingTracepoint.rawLocation();
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint.Builder
                public MapMatchingTracepoint.Builder matchingsIndex(Integer num) {
                    this.matchingsIndex = num;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint.Builder
                public MapMatchingTracepoint.Builder alternativesCount(Integer num) {
                    this.alternativesCount = num;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint.Builder
                public MapMatchingTracepoint.Builder waypointIndex(Integer num) {
                    this.waypointIndex = num;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint.Builder
                public MapMatchingTracepoint.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint.Builder
                public MapMatchingTracepoint.Builder rawLocation(double[] dArr) {
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingTracepoint.Builder
                public MapMatchingTracepoint build() {
                    return new AutoValue_MapMatchingTracepoint(this.matchingsIndex, this.alternativesCount, this.waypointIndex, this.name, this.rawLocation);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MapMatchingTracepoint> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MapMatchingTracepoint mapMatchingTracepoint) throws IOException {
            if (mapMatchingTracepoint == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("matchings_index");
            if (mapMatchingTracepoint.matchingsIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mapMatchingTracepoint.matchingsIndex());
            }
            jsonWriter.name("alternatives_count");
            if (mapMatchingTracepoint.alternativesCount() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter2 = this.integer_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, mapMatchingTracepoint.alternativesCount());
            }
            jsonWriter.name("waypoint_index");
            if (mapMatchingTracepoint.waypointIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter3 = this.integer_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, mapMatchingTracepoint.waypointIndex());
            }
            jsonWriter.name("name");
            if (mapMatchingTracepoint.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, mapMatchingTracepoint.name());
            }
            jsonWriter.name("location");
            if (mapMatchingTracepoint.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> typeAdapter5 = this.array__double_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, mapMatchingTracepoint.rawLocation());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public MapMatchingTracepoint read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MapMatchingTracepoint.Builder builder = MapMatchingTracepoint.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "matchings_index":
                            TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter;
                            }
                            builder.matchingsIndex(typeAdapter.read2(jsonReader));
                            break;
                        case "alternatives_count":
                            TypeAdapter<Integer> typeAdapter2 = this.integer_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter2;
                            }
                            builder.alternativesCount(typeAdapter2.read2(jsonReader));
                            break;
                        case "waypoint_index":
                            TypeAdapter<Integer> typeAdapter3 = this.integer_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter3;
                            }
                            builder.waypointIndex(typeAdapter3.read2(jsonReader));
                            break;
                        case "location":
                            TypeAdapter<double[]> typeAdapter4 = this.array__double_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = typeAdapter4;
                            }
                            builder.rawLocation(typeAdapter4.read2(jsonReader));
                            break;
                        default:
                            if ("name".equals(nextName)) {
                                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                                if (typeAdapter5 == null) {
                                    typeAdapter5 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter5;
                                }
                                builder.name(typeAdapter5.read2(jsonReader));
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
            return "TypeAdapter(MapMatchingTracepoint)";
        }
    }
}
