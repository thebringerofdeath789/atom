package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.DirectionsCriteria;
import com.mapbox.api.directions.p022v5.models.LegAnnotation;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_LegAnnotation extends C$AutoValue_LegAnnotation {
    AutoValue_LegAnnotation(final Map<String, SerializableJsonElement> map, final List<Double> list, final List<Double> list2, final List<Double> list3, final List<MaxSpeed> list4, final List<String> list5, final List<Integer> list6, final List<Integer> list7) {
        new LegAnnotation(map, list, list2, list3, list4, list5, list6, list7) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_LegAnnotation
            private final List<String> congestion;
            private final List<Integer> congestionNumeric;
            private final List<Double> distance;
            private final List<Double> duration;
            private final List<MaxSpeed> maxspeed;
            private final List<Double> speed;
            private final List<Integer> trafficTendency;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.distance = list;
                this.duration = list2;
                this.speed = list3;
                this.maxspeed = list4;
                this.congestion = list5;
                this.congestionNumeric = list6;
                this.trafficTendency = list7;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            public List<Double> distance() {
                return this.distance;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            public List<Double> duration() {
                return this.duration;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            public List<Double> speed() {
                return this.speed;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            public List<MaxSpeed> maxspeed() {
                return this.maxspeed;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            public List<String> congestion() {
                return this.congestion;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            @SerializedName(DirectionsCriteria.ANNOTATION_CONGESTION_NUMERIC)
            public List<Integer> congestionNumeric() {
                return this.congestionNumeric;
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            @SerializedName(DirectionsCriteria.ANNOTATION_TRAFFIC_TENDENCY)
            public List<Integer> trafficTendency() {
                return this.trafficTendency;
            }

            public String toString() {
                return "LegAnnotation{unrecognized=" + this.unrecognized + ", distance=" + this.distance + ", duration=" + this.duration + ", speed=" + this.speed + ", maxspeed=" + this.maxspeed + ", congestion=" + this.congestion + ", congestionNumeric=" + this.congestionNumeric + ", trafficTendency=" + this.trafficTendency + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LegAnnotation)) {
                    return false;
                }
                LegAnnotation legAnnotation = (LegAnnotation) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(legAnnotation.unrecognized()) : legAnnotation.unrecognized() == null) {
                    List<Double> list8 = this.distance;
                    if (list8 != null ? list8.equals(legAnnotation.distance()) : legAnnotation.distance() == null) {
                        List<Double> list9 = this.duration;
                        if (list9 != null ? list9.equals(legAnnotation.duration()) : legAnnotation.duration() == null) {
                            List<Double> list10 = this.speed;
                            if (list10 != null ? list10.equals(legAnnotation.speed()) : legAnnotation.speed() == null) {
                                List<MaxSpeed> list11 = this.maxspeed;
                                if (list11 != null ? list11.equals(legAnnotation.maxspeed()) : legAnnotation.maxspeed() == null) {
                                    List<String> list12 = this.congestion;
                                    if (list12 != null ? list12.equals(legAnnotation.congestion()) : legAnnotation.congestion() == null) {
                                        List<Integer> list13 = this.congestionNumeric;
                                        if (list13 != null ? list13.equals(legAnnotation.congestionNumeric()) : legAnnotation.congestionNumeric() == null) {
                                            List<Integer> list14 = this.trafficTendency;
                                            if (list14 == null) {
                                                if (legAnnotation.trafficTendency() == null) {
                                                    return true;
                                                }
                                            } else if (list14.equals(legAnnotation.trafficTendency())) {
                                                return true;
                                            }
                                        }
                                    }
                                }
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                List<Double> list8 = this.distance;
                int hashCode2 = (hashCode ^ (list8 == null ? 0 : list8.hashCode())) * 1000003;
                List<Double> list9 = this.duration;
                int hashCode3 = (hashCode2 ^ (list9 == null ? 0 : list9.hashCode())) * 1000003;
                List<Double> list10 = this.speed;
                int hashCode4 = (hashCode3 ^ (list10 == null ? 0 : list10.hashCode())) * 1000003;
                List<MaxSpeed> list11 = this.maxspeed;
                int hashCode5 = (hashCode4 ^ (list11 == null ? 0 : list11.hashCode())) * 1000003;
                List<String> list12 = this.congestion;
                int hashCode6 = (hashCode5 ^ (list12 == null ? 0 : list12.hashCode())) * 1000003;
                List<Integer> list13 = this.congestionNumeric;
                int hashCode7 = (hashCode6 ^ (list13 == null ? 0 : list13.hashCode())) * 1000003;
                List<Integer> list14 = this.trafficTendency;
                return hashCode7 ^ (list14 != null ? list14.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.LegAnnotation
            public LegAnnotation.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_LegAnnotation$Builder */
            static class Builder extends LegAnnotation.Builder {
                private List<String> congestion;
                private List<Integer> congestionNumeric;
                private List<Double> distance;
                private List<Double> duration;
                private List<MaxSpeed> maxspeed;
                private List<Double> speed;
                private List<Integer> trafficTendency;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ LegAnnotation.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(LegAnnotation legAnnotation) {
                    this.unrecognized = legAnnotation.unrecognized();
                    this.distance = legAnnotation.distance();
                    this.duration = legAnnotation.duration();
                    this.speed = legAnnotation.speed();
                    this.maxspeed = legAnnotation.maxspeed();
                    this.congestion = legAnnotation.congestion();
                    this.congestionNumeric = legAnnotation.congestionNumeric();
                    this.trafficTendency = legAnnotation.trafficTendency();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                LegAnnotation.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder distance(List<Double> list) {
                    this.distance = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder duration(List<Double> list) {
                    this.duration = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder speed(List<Double> list) {
                    this.speed = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder maxspeed(List<MaxSpeed> list) {
                    this.maxspeed = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder congestion(List<String> list) {
                    this.congestion = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder congestionNumeric(List<Integer> list) {
                    this.congestionNumeric = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation.Builder trafficTendency(List<Integer> list) {
                    this.trafficTendency = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegAnnotation.Builder
                public LegAnnotation build() {
                    return new AutoValue_LegAnnotation(this.unrecognized, this.distance, this.duration, this.speed, this.maxspeed, this.congestion, this.congestionNumeric, this.trafficTendency);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<LegAnnotation> {
        private final Gson gson;
        private volatile TypeAdapter<List<Double>> list__double_adapter;
        private volatile TypeAdapter<List<Integer>> list__integer_adapter;
        private volatile TypeAdapter<List<MaxSpeed>> list__maxSpeed_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, LegAnnotation legAnnotation) throws IOException {
            if (legAnnotation == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (legAnnotation.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : legAnnotation.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("distance");
            if (legAnnotation.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> typeAdapter = this.list__double_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, legAnnotation.distance());
            }
            jsonWriter.name("duration");
            if (legAnnotation.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> typeAdapter2 = this.list__double_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, legAnnotation.duration());
            }
            jsonWriter.name("speed");
            if (legAnnotation.speed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> typeAdapter3 = this.list__double_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, legAnnotation.speed());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_MAXSPEED);
            if (legAnnotation.maxspeed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<MaxSpeed>> typeAdapter4 = this.list__maxSpeed_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MaxSpeed.class));
                    this.list__maxSpeed_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, legAnnotation.maxspeed());
            }
            jsonWriter.name("congestion");
            if (legAnnotation.congestion() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter5 = this.list__string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, legAnnotation.congestion());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_CONGESTION_NUMERIC);
            if (legAnnotation.congestionNumeric() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Integer>> typeAdapter6 = this.list__integer_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                    this.list__integer_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, legAnnotation.congestionNumeric());
            }
            jsonWriter.name(DirectionsCriteria.ANNOTATION_TRAFFIC_TENDENCY);
            if (legAnnotation.trafficTendency() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Integer>> typeAdapter7 = this.list__integer_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                    this.list__integer_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, legAnnotation.trafficTendency());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public LegAnnotation read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            LegAnnotation.Builder builder = LegAnnotation.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals(DirectionsCriteria.ANNOTATION_CONGESTION_NUMERIC)) {
                        TypeAdapter<List<Integer>> typeAdapter = this.list__integer_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                            this.list__integer_adapter = typeAdapter;
                        }
                        builder.congestionNumeric(typeAdapter.read(jsonReader));
                    } else if (nextName.equals(DirectionsCriteria.ANNOTATION_TRAFFIC_TENDENCY)) {
                        TypeAdapter<List<Integer>> typeAdapter2 = this.list__integer_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                            this.list__integer_adapter = typeAdapter2;
                        }
                        builder.trafficTendency(typeAdapter2.read(jsonReader));
                    } else if ("distance".equals(nextName)) {
                        TypeAdapter<List<Double>> typeAdapter3 = this.list__double_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = typeAdapter3;
                        }
                        builder.distance(typeAdapter3.read(jsonReader));
                    } else if ("duration".equals(nextName)) {
                        TypeAdapter<List<Double>> typeAdapter4 = this.list__double_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = typeAdapter4;
                        }
                        builder.duration(typeAdapter4.read(jsonReader));
                    } else if ("speed".equals(nextName)) {
                        TypeAdapter<List<Double>> typeAdapter5 = this.list__double_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = typeAdapter5;
                        }
                        builder.speed(typeAdapter5.read(jsonReader));
                    } else if (DirectionsCriteria.ANNOTATION_MAXSPEED.equals(nextName)) {
                        TypeAdapter<List<MaxSpeed>> typeAdapter6 = this.list__maxSpeed_adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, MaxSpeed.class));
                            this.list__maxSpeed_adapter = typeAdapter6;
                        }
                        builder.maxspeed(typeAdapter6.read(jsonReader));
                    } else if ("congestion".equals(nextName)) {
                        TypeAdapter<List<String>> typeAdapter7 = this.list__string_adapter;
                        if (typeAdapter7 == null) {
                            typeAdapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = typeAdapter7;
                        }
                        builder.congestion(typeAdapter7.read(jsonReader));
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
            return "TypeAdapter(LegAnnotation)";
        }
    }
}