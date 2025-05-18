package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.DirectionsWaypoint;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_DirectionsWaypoint extends C$AutoValue_DirectionsWaypoint {
    AutoValue_DirectionsWaypoint(final Map<String, SerializableJsonElement> map, final String str, final double[] dArr, final Double d) {
        new DirectionsWaypoint(map, str, dArr, d) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsWaypoint
            private final Double distance;
            private final String name;
            private final double[] rawLocation;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null name");
                this.name = str;
                Objects.requireNonNull(dArr, "Null rawLocation");
                this.rawLocation = dArr;
                this.distance = d;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsWaypoint
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsWaypoint
            @SerializedName("location")
            double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsWaypoint
            public Double distance() {
                return this.distance;
            }

            public String toString() {
                return "DirectionsWaypoint{unrecognized=" + this.unrecognized + ", name=" + this.name + ", rawLocation=" + Arrays.toString(this.rawLocation) + ", distance=" + this.distance + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsWaypoint)) {
                    return false;
                }
                DirectionsWaypoint directionsWaypoint = (DirectionsWaypoint) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(directionsWaypoint.unrecognized()) : directionsWaypoint.unrecognized() == null) {
                    if (this.name.equals(directionsWaypoint.name())) {
                        if (Arrays.equals(this.rawLocation, directionsWaypoint instanceof C$AutoValue_DirectionsWaypoint ? ((C$AutoValue_DirectionsWaypoint) directionsWaypoint).rawLocation : directionsWaypoint.rawLocation())) {
                            Double d2 = this.distance;
                            if (d2 == null) {
                                if (directionsWaypoint.distance() == null) {
                                    return true;
                                }
                            } else if (d2.equals(directionsWaypoint.distance())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.name.hashCode()) * 1000003) ^ Arrays.hashCode(this.rawLocation)) * 1000003;
                Double d2 = this.distance;
                return hashCode ^ (d2 != null ? d2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsWaypoint
            public DirectionsWaypoint.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsWaypoint$Builder */
            static class Builder extends DirectionsWaypoint.Builder {
                private Double distance;
                private String name;
                private double[] rawLocation;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ DirectionsWaypoint.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(DirectionsWaypoint directionsWaypoint) {
                    this.unrecognized = directionsWaypoint.unrecognized();
                    this.name = directionsWaypoint.name();
                    this.rawLocation = directionsWaypoint.rawLocation();
                    this.distance = directionsWaypoint.distance();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                DirectionsWaypoint.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder name(String str) {
                    Objects.requireNonNull(str, "Null name");
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder rawLocation(double[] dArr) {
                    Objects.requireNonNull(dArr, "Null rawLocation");
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint.Builder distance(Double d) {
                    this.distance = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsWaypoint.Builder
                public DirectionsWaypoint build() {
                    String str = this.name == null ? " name" : "";
                    if (this.rawLocation == null) {
                        str = str + " rawLocation";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_DirectionsWaypoint(this.unrecognized, this.name, this.rawLocation, this.distance);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsWaypoint> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsWaypoint directionsWaypoint) throws IOException {
            if (directionsWaypoint == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (directionsWaypoint.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : directionsWaypoint.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("name");
            if (directionsWaypoint.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, directionsWaypoint.name());
            }
            jsonWriter.name("location");
            if (directionsWaypoint.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> typeAdapter2 = this.array__double_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, directionsWaypoint.rawLocation());
            }
            jsonWriter.name("distance");
            if (directionsWaypoint.distance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, directionsWaypoint.distance());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public DirectionsWaypoint read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsWaypoint.Builder builder = DirectionsWaypoint.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("location")) {
                        TypeAdapter<double[]> typeAdapter = this.array__double_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(double[].class);
                            this.array__double_adapter = typeAdapter;
                        }
                        builder.rawLocation(typeAdapter.read(jsonReader));
                    } else if ("name".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.name(typeAdapter2.read(jsonReader));
                    } else if ("distance".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter3;
                        }
                        builder.distance(typeAdapter3.read(jsonReader));
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
            return "TypeAdapter(DirectionsWaypoint)";
        }
    }
}