package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.RouteLeg;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;
import org.bouncycastle.i18n.ErrorBundle;

/* loaded from: classes3.dex */
final class AutoValue_RouteLeg extends C$AutoValue_RouteLeg {
    AutoValue_RouteLeg(final Map<String, SerializableJsonElement> map, final List<SilentWaypoint> list, final Double d, final Double d2, final Double d3, final String str, final List<Admin> list2, final List<LegStep> list3, final List<Incident> list4, final LegAnnotation legAnnotation, final List<Closure> list5) {
        new RouteLeg(map, list, d, d2, d3, str, list2, list3, list4, legAnnotation, list5) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_RouteLeg
            private final List<Admin> admins;
            private final LegAnnotation annotation;
            private final List<Closure> closures;
            private final Double distance;
            private final Double duration;
            private final Double durationTypical;
            private final List<Incident> incidents;
            private final List<LegStep> steps;
            private final String summary;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final List<SilentWaypoint> viaWaypoints;

            {
                this.unrecognized = map;
                this.viaWaypoints = list;
                this.distance = d;
                this.duration = d2;
                this.durationTypical = d3;
                this.summary = str;
                this.admins = list2;
                this.steps = list3;
                this.incidents = list4;
                this.annotation = legAnnotation;
                this.closures = list5;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            @SerializedName("via_waypoints")
            public List<SilentWaypoint> viaWaypoints() {
                return this.viaWaypoints;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public Double distance() {
                return this.distance;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public Double duration() {
                return this.duration;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            @SerializedName("duration_typical")
            public Double durationTypical() {
                return this.durationTypical;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public String summary() {
                return this.summary;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public List<Admin> admins() {
                return this.admins;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public List<LegStep> steps() {
                return this.steps;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public List<Incident> incidents() {
                return this.incidents;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public LegAnnotation annotation() {
                return this.annotation;
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public List<Closure> closures() {
                return this.closures;
            }

            public String toString() {
                return "RouteLeg{unrecognized=" + this.unrecognized + ", viaWaypoints=" + this.viaWaypoints + ", distance=" + this.distance + ", duration=" + this.duration + ", durationTypical=" + this.durationTypical + ", summary=" + this.summary + ", admins=" + this.admins + ", steps=" + this.steps + ", incidents=" + this.incidents + ", annotation=" + this.annotation + ", closures=" + this.closures + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RouteLeg)) {
                    return false;
                }
                RouteLeg routeLeg = (RouteLeg) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(routeLeg.unrecognized()) : routeLeg.unrecognized() == null) {
                    List<SilentWaypoint> list6 = this.viaWaypoints;
                    if (list6 != null ? list6.equals(routeLeg.viaWaypoints()) : routeLeg.viaWaypoints() == null) {
                        Double d4 = this.distance;
                        if (d4 != null ? d4.equals(routeLeg.distance()) : routeLeg.distance() == null) {
                            Double d5 = this.duration;
                            if (d5 != null ? d5.equals(routeLeg.duration()) : routeLeg.duration() == null) {
                                Double d6 = this.durationTypical;
                                if (d6 != null ? d6.equals(routeLeg.durationTypical()) : routeLeg.durationTypical() == null) {
                                    String str2 = this.summary;
                                    if (str2 != null ? str2.equals(routeLeg.summary()) : routeLeg.summary() == null) {
                                        List<Admin> list7 = this.admins;
                                        if (list7 != null ? list7.equals(routeLeg.admins()) : routeLeg.admins() == null) {
                                            List<LegStep> list8 = this.steps;
                                            if (list8 != null ? list8.equals(routeLeg.steps()) : routeLeg.steps() == null) {
                                                List<Incident> list9 = this.incidents;
                                                if (list9 != null ? list9.equals(routeLeg.incidents()) : routeLeg.incidents() == null) {
                                                    LegAnnotation legAnnotation2 = this.annotation;
                                                    if (legAnnotation2 != null ? legAnnotation2.equals(routeLeg.annotation()) : routeLeg.annotation() == null) {
                                                        List<Closure> list10 = this.closures;
                                                        if (list10 == null) {
                                                            if (routeLeg.closures() == null) {
                                                                return true;
                                                            }
                                                        } else if (list10.equals(routeLeg.closures())) {
                                                            return true;
                                                        }
                                                    }
                                                }
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
                List<SilentWaypoint> list6 = this.viaWaypoints;
                int hashCode2 = (hashCode ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
                Double d4 = this.distance;
                int hashCode3 = (hashCode2 ^ (d4 == null ? 0 : d4.hashCode())) * 1000003;
                Double d5 = this.duration;
                int hashCode4 = (hashCode3 ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
                Double d6 = this.durationTypical;
                int hashCode5 = (hashCode4 ^ (d6 == null ? 0 : d6.hashCode())) * 1000003;
                String str2 = this.summary;
                int hashCode6 = (hashCode5 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                List<Admin> list7 = this.admins;
                int hashCode7 = (hashCode6 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
                List<LegStep> list8 = this.steps;
                int hashCode8 = (hashCode7 ^ (list8 == null ? 0 : list8.hashCode())) * 1000003;
                List<Incident> list9 = this.incidents;
                int hashCode9 = (hashCode8 ^ (list9 == null ? 0 : list9.hashCode())) * 1000003;
                LegAnnotation legAnnotation2 = this.annotation;
                int hashCode10 = (hashCode9 ^ (legAnnotation2 == null ? 0 : legAnnotation2.hashCode())) * 1000003;
                List<Closure> list10 = this.closures;
                return hashCode10 ^ (list10 != null ? list10.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.RouteLeg
            public RouteLeg.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_RouteLeg$Builder */
            static class Builder extends RouteLeg.Builder {
                private List<Admin> admins;
                private LegAnnotation annotation;
                private List<Closure> closures;
                private Double distance;
                private Double duration;
                private Double durationTypical;
                private List<Incident> incidents;
                private List<LegStep> steps;
                private String summary;
                private Map<String, SerializableJsonElement> unrecognized;
                private List<SilentWaypoint> viaWaypoints;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ RouteLeg.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(RouteLeg routeLeg) {
                    this.unrecognized = routeLeg.unrecognized();
                    this.viaWaypoints = routeLeg.viaWaypoints();
                    this.distance = routeLeg.distance();
                    this.duration = routeLeg.duration();
                    this.durationTypical = routeLeg.durationTypical();
                    this.summary = routeLeg.summary();
                    this.admins = routeLeg.admins();
                    this.steps = routeLeg.steps();
                    this.incidents = routeLeg.incidents();
                    this.annotation = routeLeg.annotation();
                    this.closures = routeLeg.closures();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                RouteLeg.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder viaWaypoints(List<SilentWaypoint> list) {
                    this.viaWaypoints = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder distance(Double d) {
                    this.distance = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder duration(Double d) {
                    this.duration = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder durationTypical(Double d) {
                    this.durationTypical = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder summary(String str) {
                    this.summary = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder admins(List<Admin> list) {
                    this.admins = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder steps(List<LegStep> list) {
                    this.steps = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder incidents(List<Incident> list) {
                    this.incidents = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder annotation(LegAnnotation legAnnotation) {
                    this.annotation = legAnnotation;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg.Builder closures(List<Closure> list) {
                    this.closures = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.RouteLeg.Builder
                public RouteLeg build() {
                    return new AutoValue_RouteLeg(this.unrecognized, this.viaWaypoints, this.distance, this.duration, this.durationTypical, this.summary, this.admins, this.steps, this.incidents, this.annotation, this.closures);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteLeg> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<LegAnnotation> legAnnotation_adapter;
        private volatile TypeAdapter<List<Admin>> list__admin_adapter;
        private volatile TypeAdapter<List<Closure>> list__closure_adapter;
        private volatile TypeAdapter<List<Incident>> list__incident_adapter;
        private volatile TypeAdapter<List<LegStep>> list__legStep_adapter;
        private volatile TypeAdapter<List<SilentWaypoint>> list__silentWaypoint_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteLeg routeLeg) throws IOException {
            if (routeLeg == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (routeLeg.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : routeLeg.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("via_waypoints");
            if (routeLeg.viaWaypoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<SilentWaypoint>> typeAdapter = this.list__silentWaypoint_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, SilentWaypoint.class));
                    this.list__silentWaypoint_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, routeLeg.viaWaypoints());
            }
            jsonWriter.name("distance");
            if (routeLeg.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, routeLeg.distance());
            }
            jsonWriter.name("duration");
            if (routeLeg.duration() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, routeLeg.duration());
            }
            jsonWriter.name("duration_typical");
            if (routeLeg.durationTypical() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter4 = this.double__adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, routeLeg.durationTypical());
            }
            jsonWriter.name(ErrorBundle.SUMMARY_ENTRY);
            if (routeLeg.summary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, routeLeg.summary());
            }
            jsonWriter.name("admins");
            if (routeLeg.admins() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Admin>> typeAdapter6 = this.list__admin_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Admin.class));
                    this.list__admin_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, routeLeg.admins());
            }
            jsonWriter.name("steps");
            if (routeLeg.steps() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<LegStep>> typeAdapter7 = this.list__legStep_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, LegStep.class));
                    this.list__legStep_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, routeLeg.steps());
            }
            jsonWriter.name("incidents");
            if (routeLeg.incidents() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Incident>> typeAdapter8 = this.list__incident_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Incident.class));
                    this.list__incident_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, routeLeg.incidents());
            }
            jsonWriter.name(JamXmlElements.ANNOTATION);
            if (routeLeg.annotation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<LegAnnotation> typeAdapter9 = this.legAnnotation_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(LegAnnotation.class);
                    this.legAnnotation_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, routeLeg.annotation());
            }
            jsonWriter.name("closures");
            if (routeLeg.closures() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Closure>> typeAdapter10 = this.list__closure_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Closure.class));
                    this.list__closure_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, routeLeg.closures());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public RouteLeg read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RouteLeg.Builder builder = RouteLeg.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("duration_typical")) {
                        TypeAdapter<Double> typeAdapter = this.double__adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter;
                        }
                        builder.durationTypical(typeAdapter.read(jsonReader));
                    } else if (nextName.equals("via_waypoints")) {
                        TypeAdapter<List<SilentWaypoint>> typeAdapter2 = this.list__silentWaypoint_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, SilentWaypoint.class));
                            this.list__silentWaypoint_adapter = typeAdapter2;
                        }
                        builder.viaWaypoints(typeAdapter2.read(jsonReader));
                    } else if ("distance".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter3;
                        }
                        builder.distance(typeAdapter3.read(jsonReader));
                    } else if ("duration".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter4 = this.double__adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter4;
                        }
                        builder.duration(typeAdapter4.read(jsonReader));
                    } else if (ErrorBundle.SUMMARY_ENTRY.equals(nextName)) {
                        TypeAdapter<String> typeAdapter5 = this.string_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter5;
                        }
                        builder.summary(typeAdapter5.read(jsonReader));
                    } else if ("admins".equals(nextName)) {
                        TypeAdapter<List<Admin>> typeAdapter6 = this.list__admin_adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Admin.class));
                            this.list__admin_adapter = typeAdapter6;
                        }
                        builder.admins(typeAdapter6.read(jsonReader));
                    } else if ("steps".equals(nextName)) {
                        TypeAdapter<List<LegStep>> typeAdapter7 = this.list__legStep_adapter;
                        if (typeAdapter7 == null) {
                            typeAdapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, LegStep.class));
                            this.list__legStep_adapter = typeAdapter7;
                        }
                        builder.steps(typeAdapter7.read(jsonReader));
                    } else if ("incidents".equals(nextName)) {
                        TypeAdapter<List<Incident>> typeAdapter8 = this.list__incident_adapter;
                        if (typeAdapter8 == null) {
                            typeAdapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Incident.class));
                            this.list__incident_adapter = typeAdapter8;
                        }
                        builder.incidents(typeAdapter8.read(jsonReader));
                    } else if (JamXmlElements.ANNOTATION.equals(nextName)) {
                        TypeAdapter<LegAnnotation> typeAdapter9 = this.legAnnotation_adapter;
                        if (typeAdapter9 == null) {
                            typeAdapter9 = this.gson.getAdapter(LegAnnotation.class);
                            this.legAnnotation_adapter = typeAdapter9;
                        }
                        builder.annotation(typeAdapter9.read(jsonReader));
                    } else if ("closures".equals(nextName)) {
                        TypeAdapter<List<Closure>> typeAdapter10 = this.list__closure_adapter;
                        if (typeAdapter10 == null) {
                            typeAdapter10 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Closure.class));
                            this.list__closure_adapter = typeAdapter10;
                        }
                        builder.closures(typeAdapter10.read(jsonReader));
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
            return "TypeAdapter(RouteLeg)";
        }
    }
}