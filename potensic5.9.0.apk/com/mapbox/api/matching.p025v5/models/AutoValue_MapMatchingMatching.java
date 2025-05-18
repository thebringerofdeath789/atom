package com.mapbox.api.matching.p025v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.RouteLeg;
import com.mapbox.api.directions.p022v5.models.RouteOptions;
import com.mapbox.api.matching.p025v5.models.MapMatchingMatching;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_MapMatchingMatching extends C$AutoValue_MapMatchingMatching {
    AutoValue_MapMatchingMatching(final String str, final double d, final double d2, final String str2, final double d3, final String str3, final List<RouteLeg> list, final double d4, final RouteOptions routeOptions, final String str4, final String str5) {
        new MapMatchingMatching(str, d, d2, str2, d3, str3, list, d4, routeOptions, str4, str5) { // from class: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingMatching
            private final double confidence;
            private final double distance;
            private final double duration;
            private final String geometry;
            private final List<RouteLeg> legs;
            private final String requestUuid;
            private final String routeIndex;
            private final RouteOptions routeOptions;
            private final String voiceLanguage;
            private final double weight;
            private final String weightName;

            {
                this.routeIndex = str;
                this.distance = d;
                this.duration = d2;
                this.geometry = str2;
                this.weight = d3;
                Objects.requireNonNull(str3, "Null weightName");
                this.weightName = str3;
                Objects.requireNonNull(list, "Null legs");
                this.legs = list;
                this.confidence = d4;
                this.routeOptions = routeOptions;
                this.voiceLanguage = str4;
                this.requestUuid = str5;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public String routeIndex() {
                return this.routeIndex;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public double distance() {
                return this.distance;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public double duration() {
                return this.duration;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public String geometry() {
                return this.geometry;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public double weight() {
                return this.weight;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            @SerializedName("weight_name")
            public String weightName() {
                return this.weightName;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public List<RouteLeg> legs() {
                return this.legs;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public double confidence() {
                return this.confidence;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public RouteOptions routeOptions() {
                return this.routeOptions;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            @SerializedName("voiceLocale")
            public String voiceLanguage() {
                return this.voiceLanguage;
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public String requestUuid() {
                return this.requestUuid;
            }

            public String toString() {
                return "MapMatchingMatching{routeIndex=" + this.routeIndex + ", distance=" + this.distance + ", duration=" + this.duration + ", geometry=" + this.geometry + ", weight=" + this.weight + ", weightName=" + this.weightName + ", legs=" + this.legs + ", confidence=" + this.confidence + ", routeOptions=" + this.routeOptions + ", voiceLanguage=" + this.voiceLanguage + ", requestUuid=" + this.requestUuid + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str6;
                RouteOptions routeOptions2;
                String str7;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof MapMatchingMatching)) {
                    return false;
                }
                MapMatchingMatching mapMatchingMatching = (MapMatchingMatching) obj;
                String str8 = this.routeIndex;
                if (str8 != null ? str8.equals(mapMatchingMatching.routeIndex()) : mapMatchingMatching.routeIndex() == null) {
                    if (Double.doubleToLongBits(this.distance) == Double.doubleToLongBits(mapMatchingMatching.distance()) && Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(mapMatchingMatching.duration()) && ((str6 = this.geometry) != null ? str6.equals(mapMatchingMatching.geometry()) : mapMatchingMatching.geometry() == null) && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(mapMatchingMatching.weight()) && this.weightName.equals(mapMatchingMatching.weightName()) && this.legs.equals(mapMatchingMatching.legs()) && Double.doubleToLongBits(this.confidence) == Double.doubleToLongBits(mapMatchingMatching.confidence()) && ((routeOptions2 = this.routeOptions) != null ? routeOptions2.equals(mapMatchingMatching.routeOptions()) : mapMatchingMatching.routeOptions() == null) && ((str7 = this.voiceLanguage) != null ? str7.equals(mapMatchingMatching.voiceLanguage()) : mapMatchingMatching.voiceLanguage() == null)) {
                        String str9 = this.requestUuid;
                        if (str9 == null) {
                            if (mapMatchingMatching.requestUuid() == null) {
                                return true;
                            }
                        } else if (str9.equals(mapMatchingMatching.requestUuid())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                String str6 = this.routeIndex;
                int hashCode = ((((((str6 == null ? 0 : str6.hashCode()) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.distance) >>> 32) ^ Double.doubleToLongBits(this.distance)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.duration) >>> 32) ^ Double.doubleToLongBits(this.duration)))) * 1000003;
                String str7 = this.geometry;
                int hashCode2 = (((((((((hashCode ^ (str7 == null ? 0 : str7.hashCode())) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.weight) >>> 32) ^ Double.doubleToLongBits(this.weight)))) * 1000003) ^ this.weightName.hashCode()) * 1000003) ^ this.legs.hashCode()) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.confidence) >>> 32) ^ Double.doubleToLongBits(this.confidence)))) * 1000003;
                RouteOptions routeOptions2 = this.routeOptions;
                int hashCode3 = (hashCode2 ^ (routeOptions2 == null ? 0 : routeOptions2.hashCode())) * 1000003;
                String str8 = this.voiceLanguage;
                int hashCode4 = (hashCode3 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                String str9 = this.requestUuid;
                return hashCode4 ^ (str9 != null ? str9.hashCode() : 0);
            }

            @Override // com.mapbox.api.matching.p025v5.models.MapMatchingMatching
            public MapMatchingMatching.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.matching.v5.models.$AutoValue_MapMatchingMatching$Builder */
            static class Builder extends MapMatchingMatching.Builder {
                private Double confidence;
                private Double distance;
                private Double duration;
                private String geometry;
                private List<RouteLeg> legs;
                private String requestUuid;
                private String routeIndex;
                private RouteOptions routeOptions;
                private String voiceLanguage;
                private Double weight;
                private String weightName;

                Builder() {
                }

                private Builder(MapMatchingMatching mapMatchingMatching) {
                    this.routeIndex = mapMatchingMatching.routeIndex();
                    this.distance = Double.valueOf(mapMatchingMatching.distance());
                    this.duration = Double.valueOf(mapMatchingMatching.duration());
                    this.geometry = mapMatchingMatching.geometry();
                    this.weight = Double.valueOf(mapMatchingMatching.weight());
                    this.weightName = mapMatchingMatching.weightName();
                    this.legs = mapMatchingMatching.legs();
                    this.confidence = Double.valueOf(mapMatchingMatching.confidence());
                    this.routeOptions = mapMatchingMatching.routeOptions();
                    this.voiceLanguage = mapMatchingMatching.voiceLanguage();
                    this.requestUuid = mapMatchingMatching.requestUuid();
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder routeIndex(String str) {
                    this.routeIndex = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder distance(double d) {
                    this.distance = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder duration(double d) {
                    this.duration = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder geometry(String str) {
                    this.geometry = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder weight(double d) {
                    this.weight = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder weightName(String str) {
                    Objects.requireNonNull(str, "Null weightName");
                    this.weightName = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder legs(List<RouteLeg> list) {
                    Objects.requireNonNull(list, "Null legs");
                    this.legs = list;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder confidence(double d) {
                    this.confidence = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder routeOptions(RouteOptions routeOptions) {
                    this.routeOptions = routeOptions;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder voiceLanguage(String str) {
                    this.voiceLanguage = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching.Builder requestUuid(String str) {
                    this.requestUuid = str;
                    return this;
                }

                @Override // com.mapbox.api.matching.v5.models.MapMatchingMatching.Builder
                public MapMatchingMatching build() {
                    String str = this.distance == null ? " distance" : "";
                    if (this.duration == null) {
                        str = str + " duration";
                    }
                    if (this.weight == null) {
                        str = str + " weight";
                    }
                    if (this.weightName == null) {
                        str = str + " weightName";
                    }
                    if (this.legs == null) {
                        str = str + " legs";
                    }
                    if (this.confidence == null) {
                        str = str + " confidence";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_MapMatchingMatching(this.routeIndex, this.distance.doubleValue(), this.duration.doubleValue(), this.geometry, this.weight.doubleValue(), this.weightName, this.legs, this.confidence.doubleValue(), this.routeOptions, this.voiceLanguage, this.requestUuid);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<MapMatchingMatching> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<RouteLeg>> list__routeLeg_adapter;
        private volatile TypeAdapter<RouteOptions> routeOptions_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MapMatchingMatching mapMatchingMatching) throws IOException {
            if (mapMatchingMatching == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("routeIndex");
            if (mapMatchingMatching.routeIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, mapMatchingMatching.routeIndex());
            }
            jsonWriter.name("distance");
            TypeAdapter<Double> typeAdapter2 = this.double__adapter;
            if (typeAdapter2 == null) {
                typeAdapter2 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter2;
            }
            typeAdapter2.write(jsonWriter, Double.valueOf(mapMatchingMatching.distance()));
            jsonWriter.name("duration");
            TypeAdapter<Double> typeAdapter3 = this.double__adapter;
            if (typeAdapter3 == null) {
                typeAdapter3 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter3;
            }
            typeAdapter3.write(jsonWriter, Double.valueOf(mapMatchingMatching.duration()));
            jsonWriter.name("geometry");
            if (mapMatchingMatching.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, mapMatchingMatching.geometry());
            }
            jsonWriter.name("weight");
            TypeAdapter<Double> typeAdapter5 = this.double__adapter;
            if (typeAdapter5 == null) {
                typeAdapter5 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter5;
            }
            typeAdapter5.write(jsonWriter, Double.valueOf(mapMatchingMatching.weight()));
            jsonWriter.name("weight_name");
            if (mapMatchingMatching.weightName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, mapMatchingMatching.weightName());
            }
            jsonWriter.name("legs");
            if (mapMatchingMatching.legs() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<RouteLeg>> typeAdapter7 = this.list__routeLeg_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLeg.class));
                    this.list__routeLeg_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, mapMatchingMatching.legs());
            }
            jsonWriter.name("confidence");
            TypeAdapter<Double> typeAdapter8 = this.double__adapter;
            if (typeAdapter8 == null) {
                typeAdapter8 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter8;
            }
            typeAdapter8.write(jsonWriter, Double.valueOf(mapMatchingMatching.confidence()));
            jsonWriter.name("routeOptions");
            if (mapMatchingMatching.routeOptions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<RouteOptions> typeAdapter9 = this.routeOptions_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(RouteOptions.class);
                    this.routeOptions_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, mapMatchingMatching.routeOptions());
            }
            jsonWriter.name("voiceLocale");
            if (mapMatchingMatching.voiceLanguage() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter10 = this.string_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, mapMatchingMatching.voiceLanguage());
            }
            jsonWriter.name("requestUuid");
            if (mapMatchingMatching.requestUuid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter11 = this.string_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, mapMatchingMatching.requestUuid());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public MapMatchingMatching read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            MapMatchingMatching.Builder builder = MapMatchingMatching.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("voiceLocale")) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.voiceLanguage(typeAdapter.read(jsonReader));
                    } else if (nextName.equals("weight_name")) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.weightName(typeAdapter2.read(jsonReader));
                    } else if ("routeIndex".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.string_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter3;
                        }
                        builder.routeIndex(typeAdapter3.read(jsonReader));
                    } else if ("distance".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter4 = this.double__adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter4;
                        }
                        builder.distance(typeAdapter4.read(jsonReader).doubleValue());
                    } else if ("duration".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter5 = this.double__adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter5;
                        }
                        builder.duration(typeAdapter5.read(jsonReader).doubleValue());
                    } else if ("geometry".equals(nextName)) {
                        TypeAdapter<String> typeAdapter6 = this.string_adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter6;
                        }
                        builder.geometry(typeAdapter6.read(jsonReader));
                    } else if ("weight".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter7 = this.double__adapter;
                        if (typeAdapter7 == null) {
                            typeAdapter7 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter7;
                        }
                        builder.weight(typeAdapter7.read(jsonReader).doubleValue());
                    } else if ("legs".equals(nextName)) {
                        TypeAdapter<List<RouteLeg>> typeAdapter8 = this.list__routeLeg_adapter;
                        if (typeAdapter8 == null) {
                            typeAdapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLeg.class));
                            this.list__routeLeg_adapter = typeAdapter8;
                        }
                        builder.legs(typeAdapter8.read(jsonReader));
                    } else if ("confidence".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter9 = this.double__adapter;
                        if (typeAdapter9 == null) {
                            typeAdapter9 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter9;
                        }
                        builder.confidence(typeAdapter9.read(jsonReader).doubleValue());
                    } else if ("routeOptions".equals(nextName)) {
                        TypeAdapter<RouteOptions> typeAdapter10 = this.routeOptions_adapter;
                        if (typeAdapter10 == null) {
                            typeAdapter10 = this.gson.getAdapter(RouteOptions.class);
                            this.routeOptions_adapter = typeAdapter10;
                        }
                        builder.routeOptions(typeAdapter10.read(jsonReader));
                    } else if ("requestUuid".equals(nextName)) {
                        TypeAdapter<String> typeAdapter11 = this.string_adapter;
                        if (typeAdapter11 == null) {
                            typeAdapter11 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter11;
                        }
                        builder.requestUuid(typeAdapter11.read(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(MapMatchingMatching)";
        }
    }
}