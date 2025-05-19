package com.mapbox.api.directionsrefresh.v1.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directionsrefresh.v1.models.DirectionsRouteRefresh;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_DirectionsRouteRefresh extends C$AutoValue_DirectionsRouteRefresh {
    AutoValue_DirectionsRouteRefresh(Map<String, SerializableJsonElement> map, List<RouteLegRefresh> list) {
        new DirectionsRouteRefresh(map, list) { // from class: com.mapbox.api.directionsrefresh.v1.models.$AutoValue_DirectionsRouteRefresh
            private final List<RouteLegRefresh> legs;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.legs = list;
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRouteRefresh
            public List<RouteLegRefresh> legs() {
                return this.legs;
            }

            public String toString() {
                return "DirectionsRouteRefresh{unrecognized=" + this.unrecognized + ", legs=" + this.legs + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsRouteRefresh)) {
                    return false;
                }
                DirectionsRouteRefresh directionsRouteRefresh = (DirectionsRouteRefresh) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(directionsRouteRefresh.unrecognized()) : directionsRouteRefresh.unrecognized() == null) {
                    List<RouteLegRefresh> list2 = this.legs;
                    if (list2 == null) {
                        if (directionsRouteRefresh.legs() == null) {
                            return true;
                        }
                    } else if (list2.equals(directionsRouteRefresh.legs())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                List<RouteLegRefresh> list2 = this.legs;
                return hashCode ^ (list2 != null ? list2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRouteRefresh
            public DirectionsRouteRefresh.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directionsrefresh.v1.models.$AutoValue_DirectionsRouteRefresh$Builder */
            static class Builder extends DirectionsRouteRefresh.Builder {
                private List<RouteLegRefresh> legs;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject.Builder
                /* bridge */ /* synthetic */ DirectionsRouteRefresh.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(DirectionsRouteRefresh directionsRouteRefresh) {
                    this.unrecognized = directionsRouteRefresh.unrecognized();
                    this.legs = directionsRouteRefresh.legs();
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                DirectionsRouteRefresh.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRouteRefresh.Builder
                public DirectionsRouteRefresh.Builder legs(List<RouteLegRefresh> list) {
                    this.legs = list;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRouteRefresh.Builder
                public DirectionsRouteRefresh build() {
                    return new AutoValue_DirectionsRouteRefresh(this.unrecognized, this.legs);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsRouteRefresh> {
        private final Gson gson;
        private volatile TypeAdapter<List<RouteLegRefresh>> list__routeLegRefresh_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsRouteRefresh directionsRouteRefresh) throws IOException {
            if (directionsRouteRefresh == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (directionsRouteRefresh.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : directionsRouteRefresh.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("legs");
            if (directionsRouteRefresh.legs() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<RouteLegRefresh>> typeAdapter = this.list__routeLegRefresh_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLegRefresh.class));
                    this.list__routeLegRefresh_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, directionsRouteRefresh.legs());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public DirectionsRouteRefresh read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsRouteRefresh.Builder builder = DirectionsRouteRefresh.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("legs".equals(nextName)) {
                        TypeAdapter<List<RouteLegRefresh>> typeAdapter = this.list__routeLegRefresh_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, RouteLegRefresh.class));
                            this.list__routeLegRefresh_adapter = typeAdapter;
                        }
                        builder.legs(typeAdapter.read2(jsonReader));
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
            return "TypeAdapter(DirectionsRouteRefresh)";
        }
    }
}
