package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.StepManeuver;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_StepManeuver extends C$AutoValue_StepManeuver {
    AutoValue_StepManeuver(final Map<String, SerializableJsonElement> map, final double[] dArr, final Double d, final Double d2, final String str, final String str2, final String str3, final Integer num) {
        new StepManeuver(map, dArr, d, d2, str, str2, str3, num) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_StepManeuver
            private final Double bearingAfter;
            private final Double bearingBefore;
            private final Integer exit;
            private final String instruction;
            private final String modifier;
            private final double[] rawLocation;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(dArr, "Null rawLocation");
                this.rawLocation = dArr;
                this.bearingBefore = d;
                this.bearingAfter = d2;
                this.instruction = str;
                this.type = str2;
                this.modifier = str3;
                this.exit = num;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            @SerializedName("location")
            protected double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            @SerializedName("bearing_before")
            public Double bearingBefore() {
                return this.bearingBefore;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            @SerializedName("bearing_after")
            public Double bearingAfter() {
                return this.bearingAfter;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            public String instruction() {
                return this.instruction;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            public String modifier() {
                return this.modifier;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            public Integer exit() {
                return this.exit;
            }

            public String toString() {
                return "StepManeuver{unrecognized=" + this.unrecognized + ", rawLocation=" + Arrays.toString(this.rawLocation) + ", bearingBefore=" + this.bearingBefore + ", bearingAfter=" + this.bearingAfter + ", instruction=" + this.instruction + ", type=" + this.type + ", modifier=" + this.modifier + ", exit=" + this.exit + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                Double d3;
                Double d4;
                String str4;
                String str5;
                String str6;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof StepManeuver)) {
                    return false;
                }
                StepManeuver stepManeuver = (StepManeuver) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(stepManeuver.unrecognized()) : stepManeuver.unrecognized() == null) {
                    if (Arrays.equals(this.rawLocation, stepManeuver instanceof C$AutoValue_StepManeuver ? ((C$AutoValue_StepManeuver) stepManeuver).rawLocation : stepManeuver.rawLocation()) && ((d3 = this.bearingBefore) != null ? d3.equals(stepManeuver.bearingBefore()) : stepManeuver.bearingBefore() == null) && ((d4 = this.bearingAfter) != null ? d4.equals(stepManeuver.bearingAfter()) : stepManeuver.bearingAfter() == null) && ((str4 = this.instruction) != null ? str4.equals(stepManeuver.instruction()) : stepManeuver.instruction() == null) && ((str5 = this.type) != null ? str5.equals(stepManeuver.type()) : stepManeuver.type() == null) && ((str6 = this.modifier) != null ? str6.equals(stepManeuver.modifier()) : stepManeuver.modifier() == null)) {
                        Integer num2 = this.exit;
                        if (num2 == null) {
                            if (stepManeuver.exit() == null) {
                                return true;
                            }
                        } else if (num2.equals(stepManeuver.exit())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.rawLocation)) * 1000003;
                Double d3 = this.bearingBefore;
                int hashCode2 = (hashCode ^ (d3 == null ? 0 : d3.hashCode())) * 1000003;
                Double d4 = this.bearingAfter;
                int hashCode3 = (hashCode2 ^ (d4 == null ? 0 : d4.hashCode())) * 1000003;
                String str4 = this.instruction;
                int hashCode4 = (hashCode3 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                String str5 = this.type;
                int hashCode5 = (hashCode4 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                String str6 = this.modifier;
                int hashCode6 = (hashCode5 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                Integer num2 = this.exit;
                return hashCode6 ^ (num2 != null ? num2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepManeuver
            public StepManeuver.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_StepManeuver$Builder */
            static class Builder extends StepManeuver.Builder {
                private Double bearingAfter;
                private Double bearingBefore;
                private Integer exit;
                private String instruction;
                private String modifier;
                private double[] rawLocation;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ StepManeuver.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(StepManeuver stepManeuver) {
                    this.unrecognized = stepManeuver.unrecognized();
                    this.rawLocation = stepManeuver.rawLocation();
                    this.bearingBefore = stepManeuver.bearingBefore();
                    this.bearingAfter = stepManeuver.bearingAfter();
                    this.instruction = stepManeuver.instruction();
                    this.type = stepManeuver.type();
                    this.modifier = stepManeuver.modifier();
                    this.exit = stepManeuver.exit();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                StepManeuver.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder rawLocation(double[] dArr) {
                    Objects.requireNonNull(dArr, "Null rawLocation");
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder bearingBefore(Double d) {
                    this.bearingBefore = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder bearingAfter(Double d) {
                    this.bearingAfter = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder instruction(String str) {
                    this.instruction = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder modifier(String str) {
                    this.modifier = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver.Builder exit(Integer num) {
                    this.exit = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepManeuver.Builder
                public StepManeuver build() {
                    String str = this.rawLocation == null ? " rawLocation" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_StepManeuver(this.unrecognized, this.rawLocation, this.bearingBefore, this.bearingAfter, this.instruction, this.type, this.modifier, this.exit);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StepManeuver> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StepManeuver stepManeuver) throws IOException {
            if (stepManeuver == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (stepManeuver.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : stepManeuver.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("location");
            if (stepManeuver.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> typeAdapter = this.array__double_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, stepManeuver.rawLocation());
            }
            jsonWriter.name("bearing_before");
            if (stepManeuver.bearingBefore() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, stepManeuver.bearingBefore());
            }
            jsonWriter.name("bearing_after");
            if (stepManeuver.bearingAfter() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter3 = this.double__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, stepManeuver.bearingAfter());
            }
            jsonWriter.name("instruction");
            if (stepManeuver.instruction() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, stepManeuver.instruction());
            }
            jsonWriter.name("type");
            if (stepManeuver.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, stepManeuver.type());
            }
            jsonWriter.name("modifier");
            if (stepManeuver.modifier() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, stepManeuver.modifier());
            }
            jsonWriter.name("exit");
            if (stepManeuver.exit() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter7 = this.integer_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, stepManeuver.exit());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public StepManeuver read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            StepManeuver.Builder builder = StepManeuver.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "bearing_before":
                            TypeAdapter<Double> typeAdapter = this.double__adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter;
                            }
                            builder.bearingBefore(typeAdapter.read(jsonReader));
                            break;
                        case "bearing_after":
                            TypeAdapter<Double> typeAdapter2 = this.double__adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(Double.class);
                                this.double__adapter = typeAdapter2;
                            }
                            builder.bearingAfter(typeAdapter2.read(jsonReader));
                            break;
                        case "location":
                            TypeAdapter<double[]> typeAdapter3 = this.array__double_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = typeAdapter3;
                            }
                            builder.rawLocation(typeAdapter3.read(jsonReader));
                            break;
                        default:
                            if ("instruction".equals(nextName)) {
                                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                                if (typeAdapter4 == null) {
                                    typeAdapter4 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter4;
                                }
                                builder.instruction(typeAdapter4.read(jsonReader));
                                break;
                            } else if ("type".equals(nextName)) {
                                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                                if (typeAdapter5 == null) {
                                    typeAdapter5 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter5;
                                }
                                builder.type(typeAdapter5.read(jsonReader));
                                break;
                            } else if ("modifier".equals(nextName)) {
                                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                                if (typeAdapter6 == null) {
                                    typeAdapter6 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter6;
                                }
                                builder.modifier(typeAdapter6.read(jsonReader));
                                break;
                            } else if ("exit".equals(nextName)) {
                                TypeAdapter<Integer> typeAdapter7 = this.integer_adapter;
                                if (typeAdapter7 == null) {
                                    typeAdapter7 = this.gson.getAdapter(Integer.class);
                                    this.integer_adapter = typeAdapter7;
                                }
                                builder.exit(typeAdapter7.read(jsonReader));
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
            return "TypeAdapter(StepManeuver)";
        }
    }
}