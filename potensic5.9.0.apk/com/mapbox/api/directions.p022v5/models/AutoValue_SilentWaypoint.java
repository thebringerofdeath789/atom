package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.SilentWaypoint;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_SilentWaypoint extends C$AutoValue_SilentWaypoint {
    AutoValue_SilentWaypoint(final Map<String, SerializableJsonElement> map, final int i, final double d, final int i2) {
        new SilentWaypoint(map, i, d, i2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_SilentWaypoint
            private final double distanceFromStart;
            private final int geometryIndex;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final int waypointIndex;

            {
                this.unrecognized = map;
                this.waypointIndex = i;
                this.distanceFromStart = d;
                this.geometryIndex = i2;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.SilentWaypoint
            @SerializedName("waypoint_index")
            public int waypointIndex() {
                return this.waypointIndex;
            }

            @Override // com.mapbox.api.directions.p022v5.models.SilentWaypoint
            @SerializedName("distance_from_start")
            public double distanceFromStart() {
                return this.distanceFromStart;
            }

            @Override // com.mapbox.api.directions.p022v5.models.SilentWaypoint
            @SerializedName("geometry_index")
            public int geometryIndex() {
                return this.geometryIndex;
            }

            public String toString() {
                return "SilentWaypoint{unrecognized=" + this.unrecognized + ", waypointIndex=" + this.waypointIndex + ", distanceFromStart=" + this.distanceFromStart + ", geometryIndex=" + this.geometryIndex + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof SilentWaypoint)) {
                    return false;
                }
                SilentWaypoint silentWaypoint = (SilentWaypoint) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(silentWaypoint.unrecognized()) : silentWaypoint.unrecognized() == null) {
                    if (this.waypointIndex == silentWaypoint.waypointIndex() && Double.doubleToLongBits(this.distanceFromStart) == Double.doubleToLongBits(silentWaypoint.distanceFromStart()) && this.geometryIndex == silentWaypoint.geometryIndex()) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                return (((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.waypointIndex) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.distanceFromStart) >>> 32) ^ Double.doubleToLongBits(this.distanceFromStart)))) * 1000003) ^ this.geometryIndex;
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_SilentWaypoint$Builder */
            static class Builder extends SilentWaypoint.Builder {
                private Double distanceFromStart;
                private Integer geometryIndex;
                private Map<String, SerializableJsonElement> unrecognized;
                private Integer waypointIndex;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ SilentWaypoint.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                SilentWaypoint.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.SilentWaypoint.Builder
                public SilentWaypoint.Builder waypointIndex(int i) {
                    this.waypointIndex = Integer.valueOf(i);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.SilentWaypoint.Builder
                public SilentWaypoint.Builder distanceFromStart(double d) {
                    this.distanceFromStart = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.SilentWaypoint.Builder
                public SilentWaypoint.Builder geometryIndex(int i) {
                    this.geometryIndex = Integer.valueOf(i);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.SilentWaypoint.Builder
                public SilentWaypoint build() {
                    String str = this.waypointIndex == null ? " waypointIndex" : "";
                    if (this.distanceFromStart == null) {
                        str = str + " distanceFromStart";
                    }
                    if (this.geometryIndex == null) {
                        str = str + " geometryIndex";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_SilentWaypoint(this.unrecognized, this.waypointIndex.intValue(), this.distanceFromStart.doubleValue(), this.geometryIndex.intValue());
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<SilentWaypoint> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> int__adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, SilentWaypoint silentWaypoint) throws IOException {
            if (silentWaypoint == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (silentWaypoint.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : silentWaypoint.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("waypoint_index");
            TypeAdapter<Integer> typeAdapter = this.int__adapter;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getAdapter(Integer.class);
                this.int__adapter = typeAdapter;
            }
            typeAdapter.write(jsonWriter, Integer.valueOf(silentWaypoint.waypointIndex()));
            jsonWriter.name("distance_from_start");
            TypeAdapter<Double> typeAdapter2 = this.double__adapter;
            if (typeAdapter2 == null) {
                typeAdapter2 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter2;
            }
            typeAdapter2.write(jsonWriter, Double.valueOf(silentWaypoint.distanceFromStart()));
            jsonWriter.name("geometry_index");
            TypeAdapter<Integer> typeAdapter3 = this.int__adapter;
            if (typeAdapter3 == null) {
                typeAdapter3 = this.gson.getAdapter(Integer.class);
                this.int__adapter = typeAdapter3;
            }
            typeAdapter3.write(jsonWriter, Integer.valueOf(silentWaypoint.geometryIndex()));
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public SilentWaypoint read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            SilentWaypoint.Builder builder = SilentWaypoint.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "distance_from_start":
                            TypeAdapter<Double> typeAdapter = this.double__adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter;
                            }
                            builder.distanceFromStart(typeAdapter.read(jsonReader).doubleValue());
                            break;
                        case "waypoint_index":
                            TypeAdapter<Integer> typeAdapter2 = this.int__adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(Integer.class);
                                this.int__adapter = typeAdapter2;
                            }
                            builder.waypointIndex(typeAdapter2.read(jsonReader).intValue());
                            break;
                        case "geometry_index":
                            TypeAdapter<Integer> typeAdapter3 = this.int__adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(Integer.class);
                                this.int__adapter = typeAdapter3;
                            }
                            builder.geometryIndex(typeAdapter3.read(jsonReader).intValue());
                            break;
                        default:
                            if (linkedHashMap == null) {
                                linkedHashMap = new LinkedHashMap();
                                builder.unrecognized(linkedHashMap);
                            }
                            linkedHashMap.put(nextName, new SerializableJsonElement((JsonElement) this.gson.fromJson(jsonReader, JsonElement.class)));
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(SilentWaypoint)";
        }
    }
}