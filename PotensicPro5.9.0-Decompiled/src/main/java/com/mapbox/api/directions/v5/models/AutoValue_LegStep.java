package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.LegStep;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_LegStep extends C$AutoValue_LegStep {
    AutoValue_LegStep(Map<String, SerializableJsonElement> map, double d, double d2, Double d3, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, String str9, String str10, StepManeuver stepManeuver, List<VoiceInstructions> list, List<BannerInstructions> list2, String str11, double d4, List<StepIntersection> list3, String str12) {
        new LegStep(map, d, d2, d3, str, str2, str3, str4, str5, str6, str7, str8, str9, str10, stepManeuver, list, list2, str11, d4, list3, str12) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_LegStep
            private final List<BannerInstructions> bannerInstructions;
            private final String destinations;
            private final double distance;
            private final String drivingSide;
            private final double duration;
            private final Double durationTypical;
            private final String exits;
            private final String geometry;
            private final List<StepIntersection> intersections;
            private final StepManeuver maneuver;
            private final String mode;
            private final String name;
            private final String pronunciation;
            private final String ref;
            private final String rotaryName;
            private final String rotaryPronunciation;
            private final String speedLimitSign;
            private final String speedLimitUnit;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final List<VoiceInstructions> voiceInstructions;
            private final double weight;

            {
                this.unrecognized = map;
                this.distance = d;
                this.duration = d2;
                this.durationTypical = d3;
                this.speedLimitUnit = str;
                this.speedLimitSign = str2;
                this.geometry = str3;
                this.name = str4;
                this.ref = str5;
                this.destinations = str6;
                Objects.requireNonNull(str7, "Null mode");
                this.mode = str7;
                this.pronunciation = str8;
                this.rotaryName = str9;
                this.rotaryPronunciation = str10;
                Objects.requireNonNull(stepManeuver, "Null maneuver");
                this.maneuver = stepManeuver;
                this.voiceInstructions = list;
                this.bannerInstructions = list2;
                this.drivingSide = str11;
                this.weight = d4;
                this.intersections = list3;
                this.exits = str12;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public double distance() {
                return this.distance;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public double duration() {
                return this.duration;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            @SerializedName("duration_typical")
            public Double durationTypical() {
                return this.durationTypical;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String speedLimitUnit() {
                return this.speedLimitUnit;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String speedLimitSign() {
                return this.speedLimitSign;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String geometry() {
                return this.geometry;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String ref() {
                return this.ref;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String destinations() {
                return this.destinations;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String mode() {
                return this.mode;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String pronunciation() {
                return this.pronunciation;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            @SerializedName("rotary_name")
            public String rotaryName() {
                return this.rotaryName;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            @SerializedName("rotary_pronunciation")
            public String rotaryPronunciation() {
                return this.rotaryPronunciation;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public StepManeuver maneuver() {
                return this.maneuver;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public List<VoiceInstructions> voiceInstructions() {
                return this.voiceInstructions;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public List<BannerInstructions> bannerInstructions() {
                return this.bannerInstructions;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            @SerializedName("driving_side")
            public String drivingSide() {
                return this.drivingSide;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public double weight() {
                return this.weight;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public List<StepIntersection> intersections() {
                return this.intersections;
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public String exits() {
                return this.exits;
            }

            public String toString() {
                return "LegStep{unrecognized=" + this.unrecognized + ", distance=" + this.distance + ", duration=" + this.duration + ", durationTypical=" + this.durationTypical + ", speedLimitUnit=" + this.speedLimitUnit + ", speedLimitSign=" + this.speedLimitSign + ", geometry=" + this.geometry + ", name=" + this.name + ", ref=" + this.ref + ", destinations=" + this.destinations + ", mode=" + this.mode + ", pronunciation=" + this.pronunciation + ", rotaryName=" + this.rotaryName + ", rotaryPronunciation=" + this.rotaryPronunciation + ", maneuver=" + this.maneuver + ", voiceInstructions=" + this.voiceInstructions + ", bannerInstructions=" + this.bannerInstructions + ", drivingSide=" + this.drivingSide + ", weight=" + this.weight + ", intersections=" + this.intersections + ", exits=" + this.exits + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                Double d5;
                String str13;
                String str14;
                String str15;
                String str16;
                String str17;
                String str18;
                String str19;
                String str20;
                String str21;
                List<VoiceInstructions> list4;
                List<BannerInstructions> list5;
                String str22;
                List<StepIntersection> list6;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof LegStep)) {
                    return false;
                }
                LegStep legStep = (LegStep) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(legStep.unrecognized()) : legStep.unrecognized() == null) {
                    if (Double.doubleToLongBits(this.distance) == Double.doubleToLongBits(legStep.distance()) && Double.doubleToLongBits(this.duration) == Double.doubleToLongBits(legStep.duration()) && ((d5 = this.durationTypical) != null ? d5.equals(legStep.durationTypical()) : legStep.durationTypical() == null) && ((str13 = this.speedLimitUnit) != null ? str13.equals(legStep.speedLimitUnit()) : legStep.speedLimitUnit() == null) && ((str14 = this.speedLimitSign) != null ? str14.equals(legStep.speedLimitSign()) : legStep.speedLimitSign() == null) && ((str15 = this.geometry) != null ? str15.equals(legStep.geometry()) : legStep.geometry() == null) && ((str16 = this.name) != null ? str16.equals(legStep.name()) : legStep.name() == null) && ((str17 = this.ref) != null ? str17.equals(legStep.ref()) : legStep.ref() == null) && ((str18 = this.destinations) != null ? str18.equals(legStep.destinations()) : legStep.destinations() == null) && this.mode.equals(legStep.mode()) && ((str19 = this.pronunciation) != null ? str19.equals(legStep.pronunciation()) : legStep.pronunciation() == null) && ((str20 = this.rotaryName) != null ? str20.equals(legStep.rotaryName()) : legStep.rotaryName() == null) && ((str21 = this.rotaryPronunciation) != null ? str21.equals(legStep.rotaryPronunciation()) : legStep.rotaryPronunciation() == null) && this.maneuver.equals(legStep.maneuver()) && ((list4 = this.voiceInstructions) != null ? list4.equals(legStep.voiceInstructions()) : legStep.voiceInstructions() == null) && ((list5 = this.bannerInstructions) != null ? list5.equals(legStep.bannerInstructions()) : legStep.bannerInstructions() == null) && ((str22 = this.drivingSide) != null ? str22.equals(legStep.drivingSide()) : legStep.drivingSide() == null) && Double.doubleToLongBits(this.weight) == Double.doubleToLongBits(legStep.weight()) && ((list6 = this.intersections) != null ? list6.equals(legStep.intersections()) : legStep.intersections() == null)) {
                        String str23 = this.exits;
                        if (str23 == null) {
                            if (legStep.exits() == null) {
                                return true;
                            }
                        } else if (str23.equals(legStep.exits())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.distance) >>> 32) ^ Double.doubleToLongBits(this.distance)))) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.duration) >>> 32) ^ Double.doubleToLongBits(this.duration)))) * 1000003;
                Double d5 = this.durationTypical;
                int hashCode2 = (hashCode ^ (d5 == null ? 0 : d5.hashCode())) * 1000003;
                String str13 = this.speedLimitUnit;
                int hashCode3 = (hashCode2 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
                String str14 = this.speedLimitSign;
                int hashCode4 = (hashCode3 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
                String str15 = this.geometry;
                int hashCode5 = (hashCode4 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
                String str16 = this.name;
                int hashCode6 = (hashCode5 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
                String str17 = this.ref;
                int hashCode7 = (hashCode6 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
                String str18 = this.destinations;
                int hashCode8 = (((hashCode7 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003) ^ this.mode.hashCode()) * 1000003;
                String str19 = this.pronunciation;
                int hashCode9 = (hashCode8 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
                String str20 = this.rotaryName;
                int hashCode10 = (hashCode9 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
                String str21 = this.rotaryPronunciation;
                int hashCode11 = (((hashCode10 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003) ^ this.maneuver.hashCode()) * 1000003;
                List<VoiceInstructions> list4 = this.voiceInstructions;
                int hashCode12 = (hashCode11 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
                List<BannerInstructions> list5 = this.bannerInstructions;
                int hashCode13 = (hashCode12 ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
                String str22 = this.drivingSide;
                int hashCode14 = (((hashCode13 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.weight) >>> 32) ^ Double.doubleToLongBits(this.weight)))) * 1000003;
                List<StepIntersection> list6 = this.intersections;
                int hashCode15 = (hashCode14 ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
                String str23 = this.exits;
                return hashCode15 ^ (str23 != null ? str23.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.LegStep
            public LegStep.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_LegStep$Builder */
            static class Builder extends LegStep.Builder {
                private List<BannerInstructions> bannerInstructions;
                private String destinations;
                private Double distance;
                private String drivingSide;
                private Double duration;
                private Double durationTypical;
                private String exits;
                private String geometry;
                private List<StepIntersection> intersections;
                private StepManeuver maneuver;
                private String mode;
                private String name;
                private String pronunciation;
                private String ref;
                private String rotaryName;
                private String rotaryPronunciation;
                private String speedLimitSign;
                private String speedLimitUnit;
                private Map<String, SerializableJsonElement> unrecognized;
                private List<VoiceInstructions> voiceInstructions;
                private Double weight;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ LegStep.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(LegStep legStep) {
                    this.unrecognized = legStep.unrecognized();
                    this.distance = Double.valueOf(legStep.distance());
                    this.duration = Double.valueOf(legStep.duration());
                    this.durationTypical = legStep.durationTypical();
                    this.speedLimitUnit = legStep.speedLimitUnit();
                    this.speedLimitSign = legStep.speedLimitSign();
                    this.geometry = legStep.geometry();
                    this.name = legStep.name();
                    this.ref = legStep.ref();
                    this.destinations = legStep.destinations();
                    this.mode = legStep.mode();
                    this.pronunciation = legStep.pronunciation();
                    this.rotaryName = legStep.rotaryName();
                    this.rotaryPronunciation = legStep.rotaryPronunciation();
                    this.maneuver = legStep.maneuver();
                    this.voiceInstructions = legStep.voiceInstructions();
                    this.bannerInstructions = legStep.bannerInstructions();
                    this.drivingSide = legStep.drivingSide();
                    this.weight = Double.valueOf(legStep.weight());
                    this.intersections = legStep.intersections();
                    this.exits = legStep.exits();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                LegStep.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder distance(double d) {
                    this.distance = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder duration(double d) {
                    this.duration = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder durationTypical(Double d) {
                    this.durationTypical = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder speedLimitUnit(String str) {
                    this.speedLimitUnit = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder speedLimitSign(String str) {
                    this.speedLimitSign = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder geometry(String str) {
                    this.geometry = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder ref(String str) {
                    this.ref = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder destinations(String str) {
                    this.destinations = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder mode(String str) {
                    Objects.requireNonNull(str, "Null mode");
                    this.mode = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder pronunciation(String str) {
                    this.pronunciation = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder rotaryName(String str) {
                    this.rotaryName = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder rotaryPronunciation(String str) {
                    this.rotaryPronunciation = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder maneuver(StepManeuver stepManeuver) {
                    Objects.requireNonNull(stepManeuver, "Null maneuver");
                    this.maneuver = stepManeuver;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder voiceInstructions(List<VoiceInstructions> list) {
                    this.voiceInstructions = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder bannerInstructions(List<BannerInstructions> list) {
                    this.bannerInstructions = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder drivingSide(String str) {
                    this.drivingSide = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder weight(double d) {
                    this.weight = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder intersections(List<StepIntersection> list) {
                    this.intersections = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep.Builder exits(String str) {
                    this.exits = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.LegStep.Builder
                public LegStep build() {
                    String str = this.distance == null ? " distance" : "";
                    if (this.duration == null) {
                        str = str + " duration";
                    }
                    if (this.mode == null) {
                        str = str + " mode";
                    }
                    if (this.maneuver == null) {
                        str = str + " maneuver";
                    }
                    if (this.weight == null) {
                        str = str + " weight";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_LegStep(this.unrecognized, this.distance.doubleValue(), this.duration.doubleValue(), this.durationTypical, this.speedLimitUnit, this.speedLimitSign, this.geometry, this.name, this.ref, this.destinations, this.mode, this.pronunciation, this.rotaryName, this.rotaryPronunciation, this.maneuver, this.voiceInstructions, this.bannerInstructions, this.drivingSide, this.weight.doubleValue(), this.intersections, this.exits);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<LegStep> {
        private volatile TypeAdapter<Double> double___adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<BannerInstructions>> list__bannerInstructions_adapter;
        private volatile TypeAdapter<List<StepIntersection>> list__stepIntersection_adapter;
        private volatile TypeAdapter<List<VoiceInstructions>> list__voiceInstructions_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<StepManeuver> stepManeuver_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, LegStep legStep) throws IOException {
            if (legStep == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (legStep.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : legStep.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("distance");
            TypeAdapter<Double> typeAdapter = this.double__adapter;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter;
            }
            typeAdapter.write(jsonWriter, Double.valueOf(legStep.distance()));
            jsonWriter.name("duration");
            TypeAdapter<Double> typeAdapter2 = this.double__adapter;
            if (typeAdapter2 == null) {
                typeAdapter2 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter2;
            }
            typeAdapter2.write(jsonWriter, Double.valueOf(legStep.duration()));
            jsonWriter.name("duration_typical");
            if (legStep.durationTypical() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter3 = this.double___adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Double.class);
                    this.double___adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, legStep.durationTypical());
            }
            jsonWriter.name("speedLimitUnit");
            if (legStep.speedLimitUnit() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, legStep.speedLimitUnit());
            }
            jsonWriter.name("speedLimitSign");
            if (legStep.speedLimitSign() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, legStep.speedLimitSign());
            }
            jsonWriter.name("geometry");
            if (legStep.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, legStep.geometry());
            }
            jsonWriter.name("name");
            if (legStep.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, legStep.name());
            }
            jsonWriter.name("ref");
            if (legStep.ref() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, legStep.ref());
            }
            jsonWriter.name("destinations");
            if (legStep.destinations() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter9 = this.string_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, legStep.destinations());
            }
            jsonWriter.name(RtspHeaders.Values.MODE);
            if (legStep.mode() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter10 = this.string_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, legStep.mode());
            }
            jsonWriter.name("pronunciation");
            if (legStep.pronunciation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter11 = this.string_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, legStep.pronunciation());
            }
            jsonWriter.name("rotary_name");
            if (legStep.rotaryName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter12 = this.string_adapter;
                if (typeAdapter12 == null) {
                    typeAdapter12 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter12;
                }
                typeAdapter12.write(jsonWriter, legStep.rotaryName());
            }
            jsonWriter.name("rotary_pronunciation");
            if (legStep.rotaryPronunciation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter13 = this.string_adapter;
                if (typeAdapter13 == null) {
                    typeAdapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter13;
                }
                typeAdapter13.write(jsonWriter, legStep.rotaryPronunciation());
            }
            jsonWriter.name("maneuver");
            if (legStep.maneuver() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<StepManeuver> typeAdapter14 = this.stepManeuver_adapter;
                if (typeAdapter14 == null) {
                    typeAdapter14 = this.gson.getAdapter(StepManeuver.class);
                    this.stepManeuver_adapter = typeAdapter14;
                }
                typeAdapter14.write(jsonWriter, legStep.maneuver());
            }
            jsonWriter.name("voiceInstructions");
            if (legStep.voiceInstructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<VoiceInstructions>> typeAdapter15 = this.list__voiceInstructions_adapter;
                if (typeAdapter15 == null) {
                    typeAdapter15 = this.gson.getAdapter(TypeToken.getParameterized(List.class, VoiceInstructions.class));
                    this.list__voiceInstructions_adapter = typeAdapter15;
                }
                typeAdapter15.write(jsonWriter, legStep.voiceInstructions());
            }
            jsonWriter.name("bannerInstructions");
            if (legStep.bannerInstructions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<BannerInstructions>> typeAdapter16 = this.list__bannerInstructions_adapter;
                if (typeAdapter16 == null) {
                    typeAdapter16 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerInstructions.class));
                    this.list__bannerInstructions_adapter = typeAdapter16;
                }
                typeAdapter16.write(jsonWriter, legStep.bannerInstructions());
            }
            jsonWriter.name("driving_side");
            if (legStep.drivingSide() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter17 = this.string_adapter;
                if (typeAdapter17 == null) {
                    typeAdapter17 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter17;
                }
                typeAdapter17.write(jsonWriter, legStep.drivingSide());
            }
            jsonWriter.name("weight");
            TypeAdapter<Double> typeAdapter18 = this.double__adapter;
            if (typeAdapter18 == null) {
                typeAdapter18 = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter18;
            }
            typeAdapter18.write(jsonWriter, Double.valueOf(legStep.weight()));
            jsonWriter.name("intersections");
            if (legStep.intersections() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<StepIntersection>> typeAdapter19 = this.list__stepIntersection_adapter;
                if (typeAdapter19 == null) {
                    typeAdapter19 = this.gson.getAdapter(TypeToken.getParameterized(List.class, StepIntersection.class));
                    this.list__stepIntersection_adapter = typeAdapter19;
                }
                typeAdapter19.write(jsonWriter, legStep.intersections());
            }
            jsonWriter.name("exits");
            if (legStep.exits() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter20 = this.string_adapter;
                if (typeAdapter20 == null) {
                    typeAdapter20 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter20;
                }
                typeAdapter20.write(jsonWriter, legStep.exits());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public LegStep read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            LegStep.Builder builder = LegStep.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "rotary_pronunciation":
                            TypeAdapter<String> typeAdapter = this.string_adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter;
                            }
                            builder.rotaryPronunciation(typeAdapter.read2(jsonReader));
                            break;
                        case "duration_typical":
                            TypeAdapter<Double> typeAdapter2 = this.double___adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(Double.class);
                                this.double___adapter = typeAdapter2;
                            }
                            builder.durationTypical(typeAdapter2.read2(jsonReader));
                            break;
                        case "driving_side":
                            TypeAdapter<String> typeAdapter3 = this.string_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter3;
                            }
                            builder.drivingSide(typeAdapter3.read2(jsonReader));
                            break;
                        case "rotary_name":
                            TypeAdapter<String> typeAdapter4 = this.string_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter4;
                            }
                            builder.rotaryName(typeAdapter4.read2(jsonReader));
                            break;
                        default:
                            if ("distance".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter5 = this.double__adapter;
                                if (typeAdapter5 == null) {
                                    typeAdapter5 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter5;
                                }
                                builder.distance(typeAdapter5.read2(jsonReader).doubleValue());
                                break;
                            } else if ("duration".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter6 = this.double__adapter;
                                if (typeAdapter6 == null) {
                                    typeAdapter6 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter6;
                                }
                                builder.duration(typeAdapter6.read2(jsonReader).doubleValue());
                                break;
                            } else if ("speedLimitUnit".equals(nextName)) {
                                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                                if (typeAdapter7 == null) {
                                    typeAdapter7 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter7;
                                }
                                builder.speedLimitUnit(typeAdapter7.read2(jsonReader));
                                break;
                            } else if ("speedLimitSign".equals(nextName)) {
                                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                                if (typeAdapter8 == null) {
                                    typeAdapter8 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter8;
                                }
                                builder.speedLimitSign(typeAdapter8.read2(jsonReader));
                                break;
                            } else if ("geometry".equals(nextName)) {
                                TypeAdapter<String> typeAdapter9 = this.string_adapter;
                                if (typeAdapter9 == null) {
                                    typeAdapter9 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter9;
                                }
                                builder.geometry(typeAdapter9.read2(jsonReader));
                                break;
                            } else if ("name".equals(nextName)) {
                                TypeAdapter<String> typeAdapter10 = this.string_adapter;
                                if (typeAdapter10 == null) {
                                    typeAdapter10 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter10;
                                }
                                builder.name(typeAdapter10.read2(jsonReader));
                                break;
                            } else if ("ref".equals(nextName)) {
                                TypeAdapter<String> typeAdapter11 = this.string_adapter;
                                if (typeAdapter11 == null) {
                                    typeAdapter11 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter11;
                                }
                                builder.ref(typeAdapter11.read2(jsonReader));
                                break;
                            } else if ("destinations".equals(nextName)) {
                                TypeAdapter<String> typeAdapter12 = this.string_adapter;
                                if (typeAdapter12 == null) {
                                    typeAdapter12 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter12;
                                }
                                builder.destinations(typeAdapter12.read2(jsonReader));
                                break;
                            } else if (RtspHeaders.Values.MODE.equals(nextName)) {
                                TypeAdapter<String> typeAdapter13 = this.string_adapter;
                                if (typeAdapter13 == null) {
                                    typeAdapter13 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter13;
                                }
                                builder.mode(typeAdapter13.read2(jsonReader));
                                break;
                            } else if ("pronunciation".equals(nextName)) {
                                TypeAdapter<String> typeAdapter14 = this.string_adapter;
                                if (typeAdapter14 == null) {
                                    typeAdapter14 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter14;
                                }
                                builder.pronunciation(typeAdapter14.read2(jsonReader));
                                break;
                            } else if ("maneuver".equals(nextName)) {
                                TypeAdapter<StepManeuver> typeAdapter15 = this.stepManeuver_adapter;
                                if (typeAdapter15 == null) {
                                    typeAdapter15 = this.gson.getAdapter(StepManeuver.class);
                                    this.stepManeuver_adapter = typeAdapter15;
                                }
                                builder.maneuver(typeAdapter15.read2(jsonReader));
                                break;
                            } else if ("voiceInstructions".equals(nextName)) {
                                TypeAdapter<List<VoiceInstructions>> typeAdapter16 = this.list__voiceInstructions_adapter;
                                if (typeAdapter16 == null) {
                                    typeAdapter16 = this.gson.getAdapter(TypeToken.getParameterized(List.class, VoiceInstructions.class));
                                    this.list__voiceInstructions_adapter = typeAdapter16;
                                }
                                builder.voiceInstructions(typeAdapter16.read2(jsonReader));
                                break;
                            } else if ("bannerInstructions".equals(nextName)) {
                                TypeAdapter<List<BannerInstructions>> typeAdapter17 = this.list__bannerInstructions_adapter;
                                if (typeAdapter17 == null) {
                                    typeAdapter17 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerInstructions.class));
                                    this.list__bannerInstructions_adapter = typeAdapter17;
                                }
                                builder.bannerInstructions(typeAdapter17.read2(jsonReader));
                                break;
                            } else if ("weight".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter18 = this.double__adapter;
                                if (typeAdapter18 == null) {
                                    typeAdapter18 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter18;
                                }
                                builder.weight(typeAdapter18.read2(jsonReader).doubleValue());
                                break;
                            } else if ("intersections".equals(nextName)) {
                                TypeAdapter<List<StepIntersection>> typeAdapter19 = this.list__stepIntersection_adapter;
                                if (typeAdapter19 == null) {
                                    typeAdapter19 = this.gson.getAdapter(TypeToken.getParameterized(List.class, StepIntersection.class));
                                    this.list__stepIntersection_adapter = typeAdapter19;
                                }
                                builder.intersections(typeAdapter19.read2(jsonReader));
                                break;
                            } else if ("exits".equals(nextName)) {
                                TypeAdapter<String> typeAdapter20 = this.string_adapter;
                                if (typeAdapter20 == null) {
                                    typeAdapter20 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter20;
                                }
                                builder.exits(typeAdapter20.read2(jsonReader));
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
            return "TypeAdapter(LegStep)";
        }
    }
}
