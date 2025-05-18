package com.mapbox.api.directionsrefresh.p023v1.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.Closure;
import com.mapbox.api.directions.p022v5.models.Incident;
import com.mapbox.api.directions.p022v5.models.LegAnnotation;
import com.mapbox.api.directionsrefresh.p023v1.models.RouteLegRefresh;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;
import org.apache.xmlbeans.impl.jam.xml.JamXmlElements;

/* loaded from: classes3.dex */
final class AutoValue_RouteLegRefresh extends C$AutoValue_RouteLegRefresh {
    AutoValue_RouteLegRefresh(final Map<String, SerializableJsonElement> map, final List<Incident> list, final LegAnnotation legAnnotation, final List<Closure> list2) {
        new RouteLegRefresh(map, list, legAnnotation, list2) { // from class: com.mapbox.api.directionsrefresh.v1.models.$AutoValue_RouteLegRefresh
            private final LegAnnotation annotation;
            private final List<Closure> closures;
            private final List<Incident> incidents;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.incidents = list;
                this.annotation = legAnnotation;
                this.closures = list2;
            }

            @Override // com.mapbox.api.directionsrefresh.p023v1.models.DirectionsRefreshJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directionsrefresh.p023v1.models.RouteLegRefresh
            public List<Incident> incidents() {
                return this.incidents;
            }

            @Override // com.mapbox.api.directionsrefresh.p023v1.models.RouteLegRefresh
            public LegAnnotation annotation() {
                return this.annotation;
            }

            @Override // com.mapbox.api.directionsrefresh.p023v1.models.RouteLegRefresh
            public List<Closure> closures() {
                return this.closures;
            }

            public String toString() {
                return "RouteLegRefresh{unrecognized=" + this.unrecognized + ", incidents=" + this.incidents + ", annotation=" + this.annotation + ", closures=" + this.closures + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof RouteLegRefresh)) {
                    return false;
                }
                RouteLegRefresh routeLegRefresh = (RouteLegRefresh) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(routeLegRefresh.unrecognized()) : routeLegRefresh.unrecognized() == null) {
                    List<Incident> list3 = this.incidents;
                    if (list3 != null ? list3.equals(routeLegRefresh.incidents()) : routeLegRefresh.incidents() == null) {
                        LegAnnotation legAnnotation2 = this.annotation;
                        if (legAnnotation2 != null ? legAnnotation2.equals(routeLegRefresh.annotation()) : routeLegRefresh.annotation() == null) {
                            List<Closure> list4 = this.closures;
                            if (list4 == null) {
                                if (routeLegRefresh.closures() == null) {
                                    return true;
                                }
                            } else if (list4.equals(routeLegRefresh.closures())) {
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
                List<Incident> list3 = this.incidents;
                int hashCode2 = (hashCode ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                LegAnnotation legAnnotation2 = this.annotation;
                int hashCode3 = (hashCode2 ^ (legAnnotation2 == null ? 0 : legAnnotation2.hashCode())) * 1000003;
                List<Closure> list4 = this.closures;
                return hashCode3 ^ (list4 != null ? list4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directionsrefresh.p023v1.models.RouteLegRefresh
            public RouteLegRefresh.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directionsrefresh.v1.models.$AutoValue_RouteLegRefresh$Builder */
            static class Builder extends RouteLegRefresh.Builder {
                private LegAnnotation annotation;
                private List<Closure> closures;
                private List<Incident> incidents;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject.Builder
                /* bridge */ /* synthetic */ RouteLegRefresh.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(RouteLegRefresh routeLegRefresh) {
                    this.unrecognized = routeLegRefresh.unrecognized();
                    this.incidents = routeLegRefresh.incidents();
                    this.annotation = routeLegRefresh.annotation();
                    this.closures = routeLegRefresh.closures();
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                RouteLegRefresh.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.RouteLegRefresh.Builder
                public RouteLegRefresh.Builder incidents(List<Incident> list) {
                    this.incidents = list;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.RouteLegRefresh.Builder
                public RouteLegRefresh.Builder annotation(LegAnnotation legAnnotation) {
                    this.annotation = legAnnotation;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.RouteLegRefresh.Builder
                public RouteLegRefresh.Builder closures(List<Closure> list) {
                    this.closures = list;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.RouteLegRefresh.Builder
                public RouteLegRefresh build() {
                    return new AutoValue_RouteLegRefresh(this.unrecognized, this.incidents, this.annotation, this.closures);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteLegRefresh> {
        private final Gson gson;
        private volatile TypeAdapter<LegAnnotation> legAnnotation_adapter;
        private volatile TypeAdapter<List<Closure>> list__closure_adapter;
        private volatile TypeAdapter<List<Incident>> list__incident_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteLegRefresh routeLegRefresh) throws IOException {
            if (routeLegRefresh == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (routeLegRefresh.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : routeLegRefresh.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("incidents");
            if (routeLegRefresh.incidents() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Incident>> typeAdapter = this.list__incident_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Incident.class));
                    this.list__incident_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, routeLegRefresh.incidents());
            }
            jsonWriter.name(JamXmlElements.ANNOTATION);
            if (routeLegRefresh.annotation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<LegAnnotation> typeAdapter2 = this.legAnnotation_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(LegAnnotation.class);
                    this.legAnnotation_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, routeLegRefresh.annotation());
            }
            jsonWriter.name("closures");
            if (routeLegRefresh.closures() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Closure>> typeAdapter3 = this.list__closure_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Closure.class));
                    this.list__closure_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, routeLegRefresh.closures());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public RouteLegRefresh read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            RouteLegRefresh.Builder builder = RouteLegRefresh.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("incidents".equals(nextName)) {
                        TypeAdapter<List<Incident>> typeAdapter = this.list__incident_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, Incident.class));
                            this.list__incident_adapter = typeAdapter;
                        }
                        builder.incidents(typeAdapter.read(jsonReader));
                    } else if (JamXmlElements.ANNOTATION.equals(nextName)) {
                        TypeAdapter<LegAnnotation> typeAdapter2 = this.legAnnotation_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(LegAnnotation.class);
                            this.legAnnotation_adapter = typeAdapter2;
                        }
                        builder.annotation(typeAdapter2.read(jsonReader));
                    } else if ("closures".equals(nextName)) {
                        TypeAdapter<List<Closure>> typeAdapter3 = this.list__closure_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Closure.class));
                            this.list__closure_adapter = typeAdapter3;
                        }
                        builder.closures(typeAdapter3.read(jsonReader));
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
            return "TypeAdapter(RouteLegRefresh)";
        }
    }
}