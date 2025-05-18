package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.StepIntersection;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_StepIntersection extends C$AutoValue_StepIntersection {
    AutoValue_StepIntersection(final Map<String, SerializableJsonElement> map, final double[] dArr, final List<Integer> list, final List<String> list2, final List<Boolean> list3, final Integer num, final Integer num2, final List<IntersectionLanes> list4, final Integer num3, final Boolean bool, final Integer num4, final RestStop restStop, final TollCollection tollCollection, final MapboxStreetsV8 mapboxStreetsV8, final String str, final Boolean bool2, final Boolean bool3, final Boolean bool4, final Boolean bool5) {
        new StepIntersection(map, dArr, list, list2, list3, num, num2, list4, num3, bool, num4, restStop, tollCollection, mapboxStreetsV8, str, bool2, bool3, bool4, bool5) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_StepIntersection
            private final Integer adminIndex;
            private final List<Integer> bearings;
            private final List<String> classes;
            private final List<Boolean> entry;
            private final Integer geometryIndex;

            /* renamed from: in */
            private final Integer f2689in;
            private final Boolean isUrban;
            private final List<IntersectionLanes> lanes;
            private final MapboxStreetsV8 mapboxStreetsV8;
            private final Integer out;
            private final Boolean railwayCrossing;
            private final double[] rawLocation;
            private final RestStop restStop;
            private final Boolean stopSign;
            private final TollCollection tollCollection;
            private final Boolean trafficSignal;
            private final String tunnelName;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final Boolean yieldSign;

            {
                this.unrecognized = map;
                Objects.requireNonNull(dArr, "Null rawLocation");
                this.rawLocation = dArr;
                this.bearings = list;
                this.classes = list2;
                this.entry = list3;
                this.f2689in = num;
                this.out = num2;
                this.lanes = list4;
                this.geometryIndex = num3;
                this.isUrban = bool;
                this.adminIndex = num4;
                this.restStop = restStop;
                this.tollCollection = tollCollection;
                this.mapboxStreetsV8 = mapboxStreetsV8;
                this.tunnelName = str;
                this.railwayCrossing = bool2;
                this.trafficSignal = bool3;
                this.stopSign = bool4;
                this.yieldSign = bool5;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("location")
            protected double[] rawLocation() {
                return this.rawLocation;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            public List<Integer> bearings() {
                return this.bearings;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            public List<String> classes() {
                return this.classes;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            public List<Boolean> entry() {
                return this.entry;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            /* renamed from: in */
            public Integer mo1744in() {
                return this.f2689in;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            public Integer out() {
                return this.out;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            public List<IntersectionLanes> lanes() {
                return this.lanes;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("geometry_index")
            public Integer geometryIndex() {
                return this.geometryIndex;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("is_urban")
            public Boolean isUrban() {
                return this.isUrban;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("admin_index")
            public Integer adminIndex() {
                return this.adminIndex;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("rest_stop")
            public RestStop restStop() {
                return this.restStop;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("toll_collection")
            public TollCollection tollCollection() {
                return this.tollCollection;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("mapbox_streets_v8")
            public MapboxStreetsV8 mapboxStreetsV8() {
                return this.mapboxStreetsV8;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("tunnel_name")
            public String tunnelName() {
                return this.tunnelName;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("railway_crossing")
            public Boolean railwayCrossing() {
                return this.railwayCrossing;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("traffic_signal")
            public Boolean trafficSignal() {
                return this.trafficSignal;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("stop_sign")
            public Boolean stopSign() {
                return this.stopSign;
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            @SerializedName("yield_sign")
            public Boolean yieldSign() {
                return this.yieldSign;
            }

            public String toString() {
                return "StepIntersection{unrecognized=" + this.unrecognized + ", rawLocation=" + Arrays.toString(this.rawLocation) + ", bearings=" + this.bearings + ", classes=" + this.classes + ", entry=" + this.entry + ", in=" + this.f2689in + ", out=" + this.out + ", lanes=" + this.lanes + ", geometryIndex=" + this.geometryIndex + ", isUrban=" + this.isUrban + ", adminIndex=" + this.adminIndex + ", restStop=" + this.restStop + ", tollCollection=" + this.tollCollection + ", mapboxStreetsV8=" + this.mapboxStreetsV8 + ", tunnelName=" + this.tunnelName + ", railwayCrossing=" + this.railwayCrossing + ", trafficSignal=" + this.trafficSignal + ", stopSign=" + this.stopSign + ", yieldSign=" + this.yieldSign + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                List<Integer> list5;
                List<String> list6;
                List<Boolean> list7;
                Integer num5;
                Integer num6;
                List<IntersectionLanes> list8;
                Integer num7;
                Boolean bool6;
                Integer num8;
                RestStop restStop2;
                TollCollection tollCollection2;
                MapboxStreetsV8 mapboxStreetsV82;
                String str2;
                Boolean bool7;
                Boolean bool8;
                Boolean bool9;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof StepIntersection)) {
                    return false;
                }
                StepIntersection stepIntersection = (StepIntersection) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(stepIntersection.unrecognized()) : stepIntersection.unrecognized() == null) {
                    if (Arrays.equals(this.rawLocation, stepIntersection instanceof C$AutoValue_StepIntersection ? ((C$AutoValue_StepIntersection) stepIntersection).rawLocation : stepIntersection.rawLocation()) && ((list5 = this.bearings) != null ? list5.equals(stepIntersection.bearings()) : stepIntersection.bearings() == null) && ((list6 = this.classes) != null ? list6.equals(stepIntersection.classes()) : stepIntersection.classes() == null) && ((list7 = this.entry) != null ? list7.equals(stepIntersection.entry()) : stepIntersection.entry() == null) && ((num5 = this.f2689in) != null ? num5.equals(stepIntersection.mo1744in()) : stepIntersection.mo1744in() == null) && ((num6 = this.out) != null ? num6.equals(stepIntersection.out()) : stepIntersection.out() == null) && ((list8 = this.lanes) != null ? list8.equals(stepIntersection.lanes()) : stepIntersection.lanes() == null) && ((num7 = this.geometryIndex) != null ? num7.equals(stepIntersection.geometryIndex()) : stepIntersection.geometryIndex() == null) && ((bool6 = this.isUrban) != null ? bool6.equals(stepIntersection.isUrban()) : stepIntersection.isUrban() == null) && ((num8 = this.adminIndex) != null ? num8.equals(stepIntersection.adminIndex()) : stepIntersection.adminIndex() == null) && ((restStop2 = this.restStop) != null ? restStop2.equals(stepIntersection.restStop()) : stepIntersection.restStop() == null) && ((tollCollection2 = this.tollCollection) != null ? tollCollection2.equals(stepIntersection.tollCollection()) : stepIntersection.tollCollection() == null) && ((mapboxStreetsV82 = this.mapboxStreetsV8) != null ? mapboxStreetsV82.equals(stepIntersection.mapboxStreetsV8()) : stepIntersection.mapboxStreetsV8() == null) && ((str2 = this.tunnelName) != null ? str2.equals(stepIntersection.tunnelName()) : stepIntersection.tunnelName() == null) && ((bool7 = this.railwayCrossing) != null ? bool7.equals(stepIntersection.railwayCrossing()) : stepIntersection.railwayCrossing() == null) && ((bool8 = this.trafficSignal) != null ? bool8.equals(stepIntersection.trafficSignal()) : stepIntersection.trafficSignal() == null) && ((bool9 = this.stopSign) != null ? bool9.equals(stepIntersection.stopSign()) : stepIntersection.stopSign() == null)) {
                        Boolean bool10 = this.yieldSign;
                        if (bool10 == null) {
                            if (stepIntersection.yieldSign() == null) {
                                return true;
                            }
                        } else if (bool10.equals(stepIntersection.yieldSign())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ Arrays.hashCode(this.rawLocation)) * 1000003;
                List<Integer> list5 = this.bearings;
                int hashCode2 = (hashCode ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
                List<String> list6 = this.classes;
                int hashCode3 = (hashCode2 ^ (list6 == null ? 0 : list6.hashCode())) * 1000003;
                List<Boolean> list7 = this.entry;
                int hashCode4 = (hashCode3 ^ (list7 == null ? 0 : list7.hashCode())) * 1000003;
                Integer num5 = this.f2689in;
                int hashCode5 = (hashCode4 ^ (num5 == null ? 0 : num5.hashCode())) * 1000003;
                Integer num6 = this.out;
                int hashCode6 = (hashCode5 ^ (num6 == null ? 0 : num6.hashCode())) * 1000003;
                List<IntersectionLanes> list8 = this.lanes;
                int hashCode7 = (hashCode6 ^ (list8 == null ? 0 : list8.hashCode())) * 1000003;
                Integer num7 = this.geometryIndex;
                int hashCode8 = (hashCode7 ^ (num7 == null ? 0 : num7.hashCode())) * 1000003;
                Boolean bool6 = this.isUrban;
                int hashCode9 = (hashCode8 ^ (bool6 == null ? 0 : bool6.hashCode())) * 1000003;
                Integer num8 = this.adminIndex;
                int hashCode10 = (hashCode9 ^ (num8 == null ? 0 : num8.hashCode())) * 1000003;
                RestStop restStop2 = this.restStop;
                int hashCode11 = (hashCode10 ^ (restStop2 == null ? 0 : restStop2.hashCode())) * 1000003;
                TollCollection tollCollection2 = this.tollCollection;
                int hashCode12 = (hashCode11 ^ (tollCollection2 == null ? 0 : tollCollection2.hashCode())) * 1000003;
                MapboxStreetsV8 mapboxStreetsV82 = this.mapboxStreetsV8;
                int hashCode13 = (hashCode12 ^ (mapboxStreetsV82 == null ? 0 : mapboxStreetsV82.hashCode())) * 1000003;
                String str2 = this.tunnelName;
                int hashCode14 = (hashCode13 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
                Boolean bool7 = this.railwayCrossing;
                int hashCode15 = (hashCode14 ^ (bool7 == null ? 0 : bool7.hashCode())) * 1000003;
                Boolean bool8 = this.trafficSignal;
                int hashCode16 = (hashCode15 ^ (bool8 == null ? 0 : bool8.hashCode())) * 1000003;
                Boolean bool9 = this.stopSign;
                int hashCode17 = (hashCode16 ^ (bool9 == null ? 0 : bool9.hashCode())) * 1000003;
                Boolean bool10 = this.yieldSign;
                return hashCode17 ^ (bool10 != null ? bool10.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.StepIntersection
            public StepIntersection.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_StepIntersection$Builder */
            static class Builder extends StepIntersection.Builder {
                private Integer adminIndex;
                private List<Integer> bearings;
                private List<String> classes;
                private List<Boolean> entry;
                private Integer geometryIndex;

                /* renamed from: in */
                private Integer f2690in;
                private Boolean isUrban;
                private List<IntersectionLanes> lanes;
                private MapboxStreetsV8 mapboxStreetsV8;
                private Integer out;
                private Boolean railwayCrossing;
                private double[] rawLocation;
                private RestStop restStop;
                private Boolean stopSign;
                private TollCollection tollCollection;
                private Boolean trafficSignal;
                private String tunnelName;
                private Map<String, SerializableJsonElement> unrecognized;
                private Boolean yieldSign;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ StepIntersection.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(StepIntersection stepIntersection) {
                    this.unrecognized = stepIntersection.unrecognized();
                    this.rawLocation = stepIntersection.rawLocation();
                    this.bearings = stepIntersection.bearings();
                    this.classes = stepIntersection.classes();
                    this.entry = stepIntersection.entry();
                    this.f2690in = stepIntersection.mo1744in();
                    this.out = stepIntersection.out();
                    this.lanes = stepIntersection.lanes();
                    this.geometryIndex = stepIntersection.geometryIndex();
                    this.isUrban = stepIntersection.isUrban();
                    this.adminIndex = stepIntersection.adminIndex();
                    this.restStop = stepIntersection.restStop();
                    this.tollCollection = stepIntersection.tollCollection();
                    this.mapboxStreetsV8 = stepIntersection.mapboxStreetsV8();
                    this.tunnelName = stepIntersection.tunnelName();
                    this.railwayCrossing = stepIntersection.railwayCrossing();
                    this.trafficSignal = stepIntersection.trafficSignal();
                    this.stopSign = stepIntersection.stopSign();
                    this.yieldSign = stepIntersection.yieldSign();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                StepIntersection.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder rawLocation(double[] dArr) {
                    Objects.requireNonNull(dArr, "Null rawLocation");
                    this.rawLocation = dArr;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder bearings(List<Integer> list) {
                    this.bearings = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder classes(List<String> list) {
                    this.classes = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder entry(List<Boolean> list) {
                    this.entry = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                /* renamed from: in */
                public StepIntersection.Builder mo1745in(Integer num) {
                    this.f2690in = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder out(Integer num) {
                    this.out = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder lanes(List<IntersectionLanes> list) {
                    this.lanes = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder geometryIndex(Integer num) {
                    this.geometryIndex = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder isUrban(Boolean bool) {
                    this.isUrban = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder adminIndex(Integer num) {
                    this.adminIndex = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder restStop(RestStop restStop) {
                    this.restStop = restStop;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder tollCollection(TollCollection tollCollection) {
                    this.tollCollection = tollCollection;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder mapboxStreetsV8(MapboxStreetsV8 mapboxStreetsV8) {
                    this.mapboxStreetsV8 = mapboxStreetsV8;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder tunnelName(String str) {
                    this.tunnelName = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder railwayCrossing(Boolean bool) {
                    this.railwayCrossing = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder trafficSignal(Boolean bool) {
                    this.trafficSignal = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder stopSign(Boolean bool) {
                    this.stopSign = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection.Builder yieldSign(Boolean bool) {
                    this.yieldSign = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.StepIntersection.Builder
                public StepIntersection build() {
                    String str = this.rawLocation == null ? " rawLocation" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_StepIntersection(this.unrecognized, this.rawLocation, this.bearings, this.classes, this.entry, this.f2690in, this.out, this.lanes, this.geometryIndex, this.isUrban, this.adminIndex, this.restStop, this.tollCollection, this.mapboxStreetsV8, this.tunnelName, this.railwayCrossing, this.trafficSignal, this.stopSign, this.yieldSign);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<StepIntersection> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<Boolean>> list__boolean_adapter;
        private volatile TypeAdapter<List<Integer>> list__integer_adapter;
        private volatile TypeAdapter<List<IntersectionLanes>> list__intersectionLanes_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<MapboxStreetsV8> mapboxStreetsV8_adapter;
        private volatile TypeAdapter<RestStop> restStop_adapter;
        private volatile TypeAdapter<String> string_adapter;
        private volatile TypeAdapter<TollCollection> tollCollection_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, StepIntersection stepIntersection) throws IOException {
            if (stepIntersection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (stepIntersection.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : stepIntersection.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("location");
            if (stepIntersection.rawLocation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> typeAdapter = this.array__double_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, stepIntersection.rawLocation());
            }
            jsonWriter.name("bearings");
            if (stepIntersection.bearings() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Integer>> typeAdapter2 = this.list__integer_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                    this.list__integer_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, stepIntersection.bearings());
            }
            jsonWriter.name("classes");
            if (stepIntersection.classes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter3 = this.list__string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, stepIntersection.classes());
            }
            jsonWriter.name("entry");
            if (stepIntersection.entry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Boolean>> typeAdapter4 = this.list__boolean_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Boolean.class));
                    this.list__boolean_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, stepIntersection.entry());
            }
            jsonWriter.name("in");
            if (stepIntersection.mo1744in() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter5 = this.integer_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, stepIntersection.mo1744in());
            }
            jsonWriter.name("out");
            if (stepIntersection.out() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter6 = this.integer_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, stepIntersection.out());
            }
            jsonWriter.name("lanes");
            if (stepIntersection.lanes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<IntersectionLanes>> typeAdapter7 = this.list__intersectionLanes_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(TypeToken.getParameterized(List.class, IntersectionLanes.class));
                    this.list__intersectionLanes_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, stepIntersection.lanes());
            }
            jsonWriter.name("geometry_index");
            if (stepIntersection.geometryIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter8 = this.integer_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, stepIntersection.geometryIndex());
            }
            jsonWriter.name("is_urban");
            if (stepIntersection.isUrban() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter9 = this.boolean__adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, stepIntersection.isUrban());
            }
            jsonWriter.name("admin_index");
            if (stepIntersection.adminIndex() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter10 = this.integer_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, stepIntersection.adminIndex());
            }
            jsonWriter.name("rest_stop");
            if (stepIntersection.restStop() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<RestStop> typeAdapter11 = this.restStop_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(RestStop.class);
                    this.restStop_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, stepIntersection.restStop());
            }
            jsonWriter.name("toll_collection");
            if (stepIntersection.tollCollection() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<TollCollection> typeAdapter12 = this.tollCollection_adapter;
                if (typeAdapter12 == null) {
                    typeAdapter12 = this.gson.getAdapter(TollCollection.class);
                    this.tollCollection_adapter = typeAdapter12;
                }
                typeAdapter12.write(jsonWriter, stepIntersection.tollCollection());
            }
            jsonWriter.name("mapbox_streets_v8");
            if (stepIntersection.mapboxStreetsV8() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<MapboxStreetsV8> typeAdapter13 = this.mapboxStreetsV8_adapter;
                if (typeAdapter13 == null) {
                    typeAdapter13 = this.gson.getAdapter(MapboxStreetsV8.class);
                    this.mapboxStreetsV8_adapter = typeAdapter13;
                }
                typeAdapter13.write(jsonWriter, stepIntersection.mapboxStreetsV8());
            }
            jsonWriter.name("tunnel_name");
            if (stepIntersection.tunnelName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter14 = this.string_adapter;
                if (typeAdapter14 == null) {
                    typeAdapter14 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter14;
                }
                typeAdapter14.write(jsonWriter, stepIntersection.tunnelName());
            }
            jsonWriter.name("railway_crossing");
            if (stepIntersection.railwayCrossing() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter15 = this.boolean__adapter;
                if (typeAdapter15 == null) {
                    typeAdapter15 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter15;
                }
                typeAdapter15.write(jsonWriter, stepIntersection.railwayCrossing());
            }
            jsonWriter.name("traffic_signal");
            if (stepIntersection.trafficSignal() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter16 = this.boolean__adapter;
                if (typeAdapter16 == null) {
                    typeAdapter16 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter16;
                }
                typeAdapter16.write(jsonWriter, stepIntersection.trafficSignal());
            }
            jsonWriter.name("stop_sign");
            if (stepIntersection.stopSign() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter17 = this.boolean__adapter;
                if (typeAdapter17 == null) {
                    typeAdapter17 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter17;
                }
                typeAdapter17.write(jsonWriter, stepIntersection.stopSign());
            }
            jsonWriter.name("yield_sign");
            if (stepIntersection.yieldSign() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter18 = this.boolean__adapter;
                if (typeAdapter18 == null) {
                    typeAdapter18 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter18;
                }
                typeAdapter18.write(jsonWriter, stepIntersection.yieldSign());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public StepIntersection read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            StepIntersection.Builder builder = StepIntersection.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "traffic_signal":
                            TypeAdapter<Boolean> typeAdapter = this.boolean__adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter;
                            }
                            builder.trafficSignal(typeAdapter.read(jsonReader));
                            break;
                        case "rest_stop":
                            TypeAdapter<RestStop> typeAdapter2 = this.restStop_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(RestStop.class);
                                this.restStop_adapter = typeAdapter2;
                            }
                            builder.restStop(typeAdapter2.read(jsonReader));
                            break;
                        case "mapbox_streets_v8":
                            TypeAdapter<MapboxStreetsV8> typeAdapter3 = this.mapboxStreetsV8_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(MapboxStreetsV8.class);
                                this.mapboxStreetsV8_adapter = typeAdapter3;
                            }
                            builder.mapboxStreetsV8(typeAdapter3.read(jsonReader));
                            break;
                        case "railway_crossing":
                            TypeAdapter<Boolean> typeAdapter4 = this.boolean__adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter4;
                            }
                            builder.railwayCrossing(typeAdapter4.read(jsonReader));
                            break;
                        case "admin_index":
                            TypeAdapter<Integer> typeAdapter5 = this.integer_adapter;
                            if (typeAdapter5 == null) {
                                typeAdapter5 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter5;
                            }
                            builder.adminIndex(typeAdapter5.read(jsonReader));
                            break;
                        case "is_urban":
                            TypeAdapter<Boolean> typeAdapter6 = this.boolean__adapter;
                            if (typeAdapter6 == null) {
                                typeAdapter6 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter6;
                            }
                            builder.isUrban(typeAdapter6.read(jsonReader));
                            break;
                        case "tunnel_name":
                            TypeAdapter<String> typeAdapter7 = this.string_adapter;
                            if (typeAdapter7 == null) {
                                typeAdapter7 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter7;
                            }
                            builder.tunnelName(typeAdapter7.read(jsonReader));
                            break;
                        case "geometry_index":
                            TypeAdapter<Integer> typeAdapter8 = this.integer_adapter;
                            if (typeAdapter8 == null) {
                                typeAdapter8 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter8;
                            }
                            builder.geometryIndex(typeAdapter8.read(jsonReader));
                            break;
                        case "yield_sign":
                            TypeAdapter<Boolean> typeAdapter9 = this.boolean__adapter;
                            if (typeAdapter9 == null) {
                                typeAdapter9 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter9;
                            }
                            builder.yieldSign(typeAdapter9.read(jsonReader));
                            break;
                        case "toll_collection":
                            TypeAdapter<TollCollection> typeAdapter10 = this.tollCollection_adapter;
                            if (typeAdapter10 == null) {
                                typeAdapter10 = this.gson.getAdapter(TollCollection.class);
                                this.tollCollection_adapter = typeAdapter10;
                            }
                            builder.tollCollection(typeAdapter10.read(jsonReader));
                            break;
                        case "stop_sign":
                            TypeAdapter<Boolean> typeAdapter11 = this.boolean__adapter;
                            if (typeAdapter11 == null) {
                                typeAdapter11 = this.gson.getAdapter(Boolean.class);
                                this.boolean__adapter = typeAdapter11;
                            }
                            builder.stopSign(typeAdapter11.read(jsonReader));
                            break;
                        case "location":
                            TypeAdapter<double[]> typeAdapter12 = this.array__double_adapter;
                            if (typeAdapter12 == null) {
                                typeAdapter12 = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = typeAdapter12;
                            }
                            builder.rawLocation(typeAdapter12.read(jsonReader));
                            break;
                        default:
                            if ("bearings".equals(nextName)) {
                                TypeAdapter<List<Integer>> typeAdapter13 = this.list__integer_adapter;
                                if (typeAdapter13 == null) {
                                    typeAdapter13 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                                    this.list__integer_adapter = typeAdapter13;
                                }
                                builder.bearings(typeAdapter13.read(jsonReader));
                                break;
                            } else if ("classes".equals(nextName)) {
                                TypeAdapter<List<String>> typeAdapter14 = this.list__string_adapter;
                                if (typeAdapter14 == null) {
                                    typeAdapter14 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                                    this.list__string_adapter = typeAdapter14;
                                }
                                builder.classes(typeAdapter14.read(jsonReader));
                                break;
                            } else if ("entry".equals(nextName)) {
                                TypeAdapter<List<Boolean>> typeAdapter15 = this.list__boolean_adapter;
                                if (typeAdapter15 == null) {
                                    typeAdapter15 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Boolean.class));
                                    this.list__boolean_adapter = typeAdapter15;
                                }
                                builder.entry(typeAdapter15.read(jsonReader));
                                break;
                            } else if ("in".equals(nextName)) {
                                TypeAdapter<Integer> typeAdapter16 = this.integer_adapter;
                                if (typeAdapter16 == null) {
                                    typeAdapter16 = this.gson.getAdapter(Integer.class);
                                    this.integer_adapter = typeAdapter16;
                                }
                                builder.mo1745in(typeAdapter16.read(jsonReader));
                                break;
                            } else if ("out".equals(nextName)) {
                                TypeAdapter<Integer> typeAdapter17 = this.integer_adapter;
                                if (typeAdapter17 == null) {
                                    typeAdapter17 = this.gson.getAdapter(Integer.class);
                                    this.integer_adapter = typeAdapter17;
                                }
                                builder.out(typeAdapter17.read(jsonReader));
                                break;
                            } else if ("lanes".equals(nextName)) {
                                TypeAdapter<List<IntersectionLanes>> typeAdapter18 = this.list__intersectionLanes_adapter;
                                if (typeAdapter18 == null) {
                                    typeAdapter18 = this.gson.getAdapter(TypeToken.getParameterized(List.class, IntersectionLanes.class));
                                    this.list__intersectionLanes_adapter = typeAdapter18;
                                }
                                builder.lanes(typeAdapter18.read(jsonReader));
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
            return "TypeAdapter(StepIntersection)";
        }
    }
}