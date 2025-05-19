package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.CostPerVehicleSize;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_CostPerVehicleSize extends C$AutoValue_CostPerVehicleSize {
    AutoValue_CostPerVehicleSize(Map<String, SerializableJsonElement> map, Double d, Double d2, Double d3, Double d4, Double d5) {
        new CostPerVehicleSize(map, d, d2, d3, d4, d5) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_CostPerVehicleSize
            private final Double jumbo;
            private final Double large;
            private final Double middle;
            private final Double small;
            private final Double standard;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.small = d;
                this.standard = d2;
                this.middle = d3;
                this.large = d4;
                this.jumbo = d5;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize
            public Double small() {
                return this.small;
            }

            @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize
            public Double standard() {
                return this.standard;
            }

            @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize
            public Double middle() {
                return this.middle;
            }

            @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize
            public Double large() {
                return this.large;
            }

            @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize
            public Double jumbo() {
                return this.jumbo;
            }

            public String toString() {
                return "CostPerVehicleSize{unrecognized=" + this.unrecognized + ", small=" + this.small + ", standard=" + this.standard + ", middle=" + this.middle + ", large=" + this.large + ", jumbo=" + this.jumbo + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof CostPerVehicleSize)) {
                    return false;
                }
                CostPerVehicleSize costPerVehicleSize = (CostPerVehicleSize) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(costPerVehicleSize.unrecognized()) : costPerVehicleSize.unrecognized() == null) {
                    Double d6 = this.small;
                    if (d6 != null ? d6.equals(costPerVehicleSize.small()) : costPerVehicleSize.small() == null) {
                        Double d7 = this.standard;
                        if (d7 != null ? d7.equals(costPerVehicleSize.standard()) : costPerVehicleSize.standard() == null) {
                            Double d8 = this.middle;
                            if (d8 != null ? d8.equals(costPerVehicleSize.middle()) : costPerVehicleSize.middle() == null) {
                                Double d9 = this.large;
                                if (d9 != null ? d9.equals(costPerVehicleSize.large()) : costPerVehicleSize.large() == null) {
                                    Double d10 = this.jumbo;
                                    if (d10 == null) {
                                        if (costPerVehicleSize.jumbo() == null) {
                                            return true;
                                        }
                                    } else if (d10.equals(costPerVehicleSize.jumbo())) {
                                        return true;
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
                Double d6 = this.small;
                int hashCode2 = (hashCode ^ (d6 == null ? 0 : d6.hashCode())) * 1000003;
                Double d7 = this.standard;
                int hashCode3 = (hashCode2 ^ (d7 == null ? 0 : d7.hashCode())) * 1000003;
                Double d8 = this.middle;
                int hashCode4 = (hashCode3 ^ (d8 == null ? 0 : d8.hashCode())) * 1000003;
                Double d9 = this.large;
                int hashCode5 = (hashCode4 ^ (d9 == null ? 0 : d9.hashCode())) * 1000003;
                Double d10 = this.jumbo;
                return hashCode5 ^ (d10 != null ? d10.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize
            public CostPerVehicleSize.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_CostPerVehicleSize$Builder */
            static class Builder extends CostPerVehicleSize.Builder {
                private Double jumbo;
                private Double large;
                private Double middle;
                private Double small;
                private Double standard;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ CostPerVehicleSize.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(CostPerVehicleSize costPerVehicleSize) {
                    this.unrecognized = costPerVehicleSize.unrecognized();
                    this.small = costPerVehicleSize.small();
                    this.standard = costPerVehicleSize.standard();
                    this.middle = costPerVehicleSize.middle();
                    this.large = costPerVehicleSize.large();
                    this.jumbo = costPerVehicleSize.jumbo();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                CostPerVehicleSize.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize.Builder
                public CostPerVehicleSize.Builder small(Double d) {
                    this.small = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize.Builder
                public CostPerVehicleSize.Builder standard(Double d) {
                    this.standard = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize.Builder
                public CostPerVehicleSize.Builder middle(Double d) {
                    this.middle = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize.Builder
                public CostPerVehicleSize.Builder large(Double d) {
                    this.large = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize.Builder
                public CostPerVehicleSize.Builder jumbo(Double d) {
                    this.jumbo = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.CostPerVehicleSize.Builder
                public CostPerVehicleSize build() {
                    return new AutoValue_CostPerVehicleSize(this.unrecognized, this.small, this.standard, this.middle, this.large, this.jumbo);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<CostPerVehicleSize> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, CostPerVehicleSize costPerVehicleSize) throws IOException {
            if (costPerVehicleSize == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (costPerVehicleSize.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : costPerVehicleSize.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("small");
            if (costPerVehicleSize.small() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter = this.double__adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, costPerVehicleSize.small());
            }
            jsonWriter.name("standard");
            if (costPerVehicleSize.standard() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, costPerVehicleSize.standard());
            }
            jsonWriter.name("middle");
            if (costPerVehicleSize.middle() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, costPerVehicleSize.middle());
            }
            jsonWriter.name("large");
            if (costPerVehicleSize.large() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter4 = this.double__adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, costPerVehicleSize.large());
            }
            jsonWriter.name("jumbo");
            if (costPerVehicleSize.jumbo() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter5 = this.double__adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, costPerVehicleSize.jumbo());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public CostPerVehicleSize read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            CostPerVehicleSize.Builder builder = CostPerVehicleSize.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("small".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter = this.double__adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter;
                        }
                        builder.small(typeAdapter.read2(jsonReader));
                    } else if ("standard".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter2;
                        }
                        builder.standard(typeAdapter2.read2(jsonReader));
                    } else if ("middle".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter3;
                        }
                        builder.middle(typeAdapter3.read2(jsonReader));
                    } else if ("large".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter4 = this.double__adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter4;
                        }
                        builder.large(typeAdapter4.read2(jsonReader));
                    } else if ("jumbo".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter5 = this.double__adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter5;
                        }
                        builder.jumbo(typeAdapter5.read2(jsonReader));
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
            return "TypeAdapter(CostPerVehicleSize)";
        }
    }
}
