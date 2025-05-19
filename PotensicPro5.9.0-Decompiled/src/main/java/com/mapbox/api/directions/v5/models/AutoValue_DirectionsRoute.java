package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.DirectionsRoute;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_DirectionsRoute extends C$AutoValue_DirectionsRoute {
    AutoValue_DirectionsRoute(Map<String, SerializableJsonElement> map, String str, Double d, Double d2, Double d3, String str2, Double d4, String str3, List<RouteLeg> list, RouteOptions routeOptions, String str4, String str5, List<TollCost> list2) {
        new DirectionsRoute(map, str, d, d2, d3, str2, d4, str3, list, routeOptions, str4, str5, list2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsRoute
            private final Double distance;
            private final Double duration;
            private final Double durationTypical;
            private final String geometry;
            private final List<RouteLeg> legs;
            private final String requestUuid;
            private final String routeIndex;
            private final RouteOptions routeOptions;
            private final List<TollCost> tollCosts;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final String voiceLanguage;
            private final Double weight;
            private final String weightName;

            {
                this.unrecognized = map;
                this.routeIndex = str;
                Objects.requireNonNull(d, "Null distance");
                this.distance = d;
                Objects.requireNonNull(d2, "Null duration");
                this.duration = d2;
                this.durationTypical = d3;
                this.geometry = str2;
                this.weight = d4;
                this.weightName = str3;
                this.legs = list;
                this.routeOptions = routeOptions;
                this.voiceLanguage = str4;
                this.requestUuid = str5;
                this.tollCosts = list2;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public String routeIndex() {
                return this.routeIndex;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public Double distance() {
                return this.distance;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public Double duration() {
                return this.duration;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            @SerializedName("duration_typical")
            public Double durationTypical() {
                return this.durationTypical;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public String geometry() {
                return this.geometry;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public Double weight() {
                return this.weight;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            @SerializedName("weight_name")
            public String weightName() {
                return this.weightName;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public List<RouteLeg> legs() {
                return this.legs;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public RouteOptions routeOptions() {
                return this.routeOptions;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            @SerializedName("voiceLocale")
            public String voiceLanguage() {
                return this.voiceLanguage;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public String requestUuid() {
                return this.requestUuid;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            @SerializedName("toll_costs")
            public List<TollCost> tollCosts() {
                return this.tollCosts;
            }

            public String toString() {
                return "DirectionsRoute{unrecognized=" + this.unrecognized + ", routeIndex=" + this.routeIndex + ", distance=" + this.distance + ", duration=" + this.duration + ", durationTypical=" + this.durationTypical + ", geometry=" + this.geometry + ", weight=" + this.weight + ", weightName=" + this.weightName + ", legs=" + this.legs + ", routeOptions=" + this.routeOptions + ", voiceLanguage=" + this.voiceLanguage + ", requestUuid=" + this.requestUuid + ", tollCosts=" + this.tollCosts + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                Double d5;
                String str6;
                Double d6;
                String str7;
                List<RouteLeg> list3;
                RouteOptions routeOptions2;
                String str8;
                String str9;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsRoute)) {
                    return false;
                }
                DirectionsRoute directionsRoute = (DirectionsRoute) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(directionsRoute.unrecognized()) : directionsRoute.unrecognized() == null) {
                    String str10 = this.routeIndex;
                    if (str10 != null ? str10.equals(directionsRoute.routeIndex()) : directionsRoute.routeIndex() == null) {
                        if (this.distance.equals(directionsRoute.distance()) && this.duration.equals(directionsRoute.duration()) && ((d5 = this.durationTypical) != null ? d5.equals(directionsRoute.durationTypical()) : directionsRoute.durationTypical() == null) && ((str6 = this.geometry) != null ? str6.equals(directionsRoute.geometry()) : directionsRoute.geometry() == null) && ((d6 = this.weight) != null ? d6.equals(directionsRoute.weight()) : directionsRoute.weight() == null) && ((str7 = this.weightName) != null ? str7.equals(directionsRoute.weightName()) : directionsRoute.weightName() == null) && ((list3 = this.legs) != null ? list3.equals(directionsRoute.legs()) : directionsRoute.legs() == null) && ((routeOptions2 = this.routeOptions) != null ? routeOptions2.equals(directionsRoute.routeOptions()) : directionsRoute.routeOptions() == null) && ((str8 = this.voiceLanguage) != null ? str8.equals(directionsRoute.voiceLanguage()) : directionsRoute.voiceLanguage() == null) && ((str9 = this.requestUuid) != null ? str9.equals(directionsRoute.requestUuid()) : directionsRoute.requestUuid() == null)) {
                            List<TollCost> list4 = this.tollCosts;
                            if (list4 == null) {
                                if (directionsRoute.tollCosts() == null) {
                                    return true;
                                }
                            } else if (list4.equals(directionsRoute.tollCosts())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                String str6 = this.routeIndex;
                int hashCode2 = (((((hashCode ^ (str6 == null ? 0 : str6.hashCode())) * 1000003) ^ this.distance.hashCode()) * 1000003) ^ this.duration.hashCode()) * 1000003;
                Double d5 = this.durationTypical;
                int hashCode3 = (hashCode2 ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
                String str7 = this.geometry;
                int hashCode4 = (hashCode3 ^ (str7 == null ? 0 : str7.hashCode())) * 1000003;
                Double d6 = this.weight;
                int hashCode5 = (hashCode4 ^ (d6 == null ? 0 : d6.hashCode())) * 1000003;
                String str8 = this.weightName;
                int hashCode6 = (hashCode5 ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                List<RouteLeg> list3 = this.legs;
                int hashCode7 = (hashCode6 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                RouteOptions routeOptions2 = this.routeOptions;
                int hashCode8 = (hashCode7 ^ (routeOptions2 == null ? 0 : routeOptions2.hashCode())) * 1000003;
                String str9 = this.voiceLanguage;
                int hashCode9 = (hashCode8 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
                String str10 = this.requestUuid;
                int hashCode10 = (hashCode9 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
                List<TollCost> list4 = this.tollCosts;
                return hashCode10 ^ (list4 != null ? list4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsRoute
            public DirectionsRoute.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsRoute$Builder */
            static class Builder extends DirectionsRoute.Builder {
                private Double distance;
                private Double duration;
                private Double durationTypical;
                private String geometry;
                private List<RouteLeg> legs;
                private String requestUuid;
                private String routeIndex;
                private RouteOptions routeOptions;
                private List<TollCost> tollCosts;
                private Map<String, SerializableJsonElement> unrecognized;
                private String voiceLanguage;
                private Double weight;
                private String weightName;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ DirectionsRoute.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(DirectionsRoute directionsRoute) {
                    this.unrecognized = directionsRoute.unrecognized();
                    this.routeIndex = directionsRoute.routeIndex();
                    this.distance = directionsRoute.distance();
                    this.duration = directionsRoute.duration();
                    this.durationTypical = directionsRoute.durationTypical();
                    this.geometry = directionsRoute.geometry();
                    this.weight = directionsRoute.weight();
                    this.weightName = directionsRoute.weightName();
                    this.legs = directionsRoute.legs();
                    this.routeOptions = directionsRoute.routeOptions();
                    this.voiceLanguage = directionsRoute.voiceLanguage();
                    this.requestUuid = directionsRoute.requestUuid();
                    this.tollCosts = directionsRoute.tollCosts();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                DirectionsRoute.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder routeIndex(String str) {
                    this.routeIndex = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder distance(Double d) {
                    Objects.requireNonNull(d, "Null distance");
                    this.distance = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder duration(Double d) {
                    Objects.requireNonNull(d, "Null duration");
                    this.duration = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder durationTypical(Double d) {
                    this.durationTypical = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder geometry(String str) {
                    this.geometry = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder weight(Double d) {
                    this.weight = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder weightName(String str) {
                    this.weightName = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder legs(List<RouteLeg> list) {
                    this.legs = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder routeOptions(RouteOptions routeOptions) {
                    this.routeOptions = routeOptions;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder voiceLanguage(String str) {
                    this.voiceLanguage = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder requestUuid(String str) {
                    this.requestUuid = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute.Builder tollCosts(List<TollCost> list) {
                    this.tollCosts = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsRoute.Builder
                public DirectionsRoute build() {
                    String str = this.distance == null ? " distance" : "";
                    if (this.duration == null) {
                        str = str + " duration";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_DirectionsRoute(this.unrecognized, this.routeIndex, this.distance, this.duration, this.durationTypical, this.geometry, this.weight, this.weightName, this.legs, this.routeOptions, this.voiceLanguage, this.requestUuid, this.tollCosts);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsRoute> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<RouteLeg>> list__routeLeg_adapter;
        private volatile TypeAdapter<List<TollCost>> list__tollCost_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<RouteOptions> routeOptions_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsRoute directionsRoute) throws IOException {
            if (directionsRoute == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (directionsRoute.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : directionsRoute.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("routeIndex");
            if (directionsRoute.routeIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, directionsRoute.routeIndex());
            }
            jsonWriter.name("distance");
            if (directionsRoute.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, directionsRoute.distance());
            }
            jsonWriter.name("duration");
            if (directionsRoute.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, directionsRoute.duration());
            }
            jsonWriter.name("duration_typical");
            if (directionsRoute.durationTypical() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter4 = this.double__adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, directionsRoute.durationTypical());
            }
            jsonWriter.name("geometry");
            if (directionsRoute.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, directionsRoute.geometry());
            }
            jsonWriter.name("weight");
            if (directionsRoute.weight() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter6 = this.double__adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, directionsRoute.weight());
            }
            jsonWriter.name("weight_name");
            if (directionsRoute.weightName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, directionsRoute.weightName());
            }
            jsonWriter.name("legs");
            if (directionsRoute.legs() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<RouteLeg>> typeAdapter8 = this.list__routeLeg_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLeg.class));
                    this.list__routeLeg_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, directionsRoute.legs());
            }
            jsonWriter.name("routeOptions");
            if (directionsRoute.routeOptions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<RouteOptions> typeAdapter9 = this.routeOptions_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(RouteOptions.class);
                    this.routeOptions_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, directionsRoute.routeOptions());
            }
            jsonWriter.name("voiceLocale");
            if (directionsRoute.voiceLanguage() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter10 = this.string_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, directionsRoute.voiceLanguage());
            }
            jsonWriter.name("requestUuid");
            if (directionsRoute.requestUuid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter11 = this.string_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, directionsRoute.requestUuid());
            }
            jsonWriter.name("toll_costs");
            if (directionsRoute.tollCosts() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<TollCost>> typeAdapter12 = this.list__tollCost_adapter;
                if (typeAdapter12 == null) {
                    typeAdapter12 = this.gson.getAdapter(TypeToken.getParameterized(List.class, TollCost.class));
                    this.list__tollCost_adapter = typeAdapter12;
                }
                typeAdapter12.write(jsonWriter, directionsRoute.tollCosts());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public DirectionsRoute read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsRoute.Builder builder = DirectionsRoute.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "duration_typical":
                            TypeAdapter<Double> typeAdapter = this.double__adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter;
                            }
                            builder.durationTypical(typeAdapter.read2(jsonReader));
                            break;
                        case "toll_costs":
                            TypeAdapter<List<TollCost>> typeAdapter2 = this.list__tollCost_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, TollCost.class));
                                this.list__tollCost_adapter = typeAdapter2;
                            }
                            builder.tollCosts(typeAdapter2.read2(jsonReader));
                            break;
                        case "voiceLocale":
                            TypeAdapter<String> typeAdapter3 = this.string_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter3;
                            }
                            builder.voiceLanguage(typeAdapter3.read2(jsonReader));
                            break;
                        case "weight_name":
                            TypeAdapter<String> typeAdapter4 = this.string_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter4;
                            }
                            builder.weightName(typeAdapter4.read2(jsonReader));
                            break;
                        default:
                            if ("routeIndex".equals(nextName)) {
                                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                                if (typeAdapter5 == null) {
                                    typeAdapter5 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter5;
                                }
                                builder.routeIndex(typeAdapter5.read2(jsonReader));
                                break;
                            } else if ("distance".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter6 = this.double__adapter;
                                if (typeAdapter6 == null) {
                                    typeAdapter6 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter6;
                                }
                                builder.distance(typeAdapter6.read2(jsonReader));
                                break;
                            } else if ("duration".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter7 = this.double__adapter;
                                if (typeAdapter7 == null) {
                                    typeAdapter7 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter7;
                                }
                                builder.duration(typeAdapter7.read2(jsonReader));
                                break;
                            } else if ("geometry".equals(nextName)) {
                                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                                if (typeAdapter8 == null) {
                                    typeAdapter8 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter8;
                                }
                                builder.geometry(typeAdapter8.read2(jsonReader));
                                break;
                            } else if ("weight".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter9 = this.double__adapter;
                                if (typeAdapter9 == null) {
                                    typeAdapter9 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter9;
                                }
                                builder.weight(typeAdapter9.read2(jsonReader));
                                break;
                            } else if ("legs".equals(nextName)) {
                                TypeAdapter<List<RouteLeg>> typeAdapter10 = this.list__routeLeg_adapter;
                                if (typeAdapter10 == null) {
                                    typeAdapter10 = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLeg.class));
                                    this.list__routeLeg_adapter = typeAdapter10;
                                }
                                builder.legs(typeAdapter10.read2(jsonReader));
                                break;
                            } else if ("routeOptions".equals(nextName)) {
                                TypeAdapter<RouteOptions> typeAdapter11 = this.routeOptions_adapter;
                                if (typeAdapter11 == null) {
                                    typeAdapter11 = this.gson.getAdapter(RouteOptions.class);
                                    this.routeOptions_adapter = typeAdapter11;
                                }
                                builder.routeOptions(typeAdapter11.read2(jsonReader));
                                break;
                            } else if ("requestUuid".equals(nextName)) {
                                TypeAdapter<String> typeAdapter12 = this.string_adapter;
                                if (typeAdapter12 == null) {
                                    typeAdapter12 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter12;
                                }
                                builder.requestUuid(typeAdapter12.read2(jsonReader));
                                break;
                            } else {
                                if (linkedHashMap == null) {
                                    linkedHashMap = new LinkedHashMap();
                                    builder.unrecognized(linkedHashMap);
                                }
                                linkedHashMap.put(nextName, new SerializableJsonElement((JsonElement) this.gson.fromJson(jsonReader, JsonElement.class)));
                                break;
                            }
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(DirectionsRoute)";
        }
    }
}
