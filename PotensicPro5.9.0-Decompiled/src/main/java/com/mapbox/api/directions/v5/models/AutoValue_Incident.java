package com.mapbox.api.directions.v5.models;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.Incident;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Incident extends C$AutoValue_Incident {
    AutoValue_Incident(Map<String, SerializableJsonElement> map, String str, String str2, Boolean bool, Congestion congestion, String str3, String str4, String str5, String str6, String str7, List<Integer> list, Integer num, Integer num2, String str8, String str9, String str10, String str11, String str12, List<String> list2, Integer num3, List<String> list3) {
        new Incident(map, str, str2, bool, congestion, str3, str4, str5, str6, str7, list, num, num2, str8, str9, str10, str11, str12, list2, num3, list3) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_Incident
            private final List<String> affectedRoadNames;
            private final List<Integer> alertcCodes;
            private final Boolean closed;
            private final Congestion congestion;
            private final String countryCodeAlpha2;
            private final String countryCodeAlpha3;
            private final String creationTime;
            private final String description;
            private final String endTime;
            private final Integer geometryIndexEnd;
            private final Integer geometryIndexStart;
            private final String id;
            private final String impact;
            private final List<String> lanesBlocked;
            private final String longDescription;
            private final Integer numLanesBlocked;
            private final String startTime;
            private final String subType;
            private final String subTypeDescription;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null id");
                this.id = str;
                this.type = str2;
                this.closed = bool;
                this.congestion = congestion;
                this.description = str3;
                this.longDescription = str4;
                this.impact = str5;
                this.subType = str6;
                this.subTypeDescription = str7;
                this.alertcCodes = list;
                this.geometryIndexStart = num;
                this.geometryIndexEnd = num2;
                this.creationTime = str8;
                this.startTime = str9;
                this.endTime = str10;
                this.countryCodeAlpha2 = str11;
                this.countryCodeAlpha3 = str12;
                this.lanesBlocked = list2;
                this.numLanesBlocked = num3;
                this.affectedRoadNames = list3;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public String id() {
                return this.id;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public Boolean closed() {
                return this.closed;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public Congestion congestion() {
                return this.congestion;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public String description() {
                return this.description;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("long_description")
            public String longDescription() {
                return this.longDescription;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public String impact() {
                return this.impact;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("sub_type")
            public String subType() {
                return this.subType;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("sub_type_description")
            public String subTypeDescription() {
                return this.subTypeDescription;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("alertc_codes")
            public List<Integer> alertcCodes() {
                return this.alertcCodes;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("geometry_index_start")
            public Integer geometryIndexStart() {
                return this.geometryIndexStart;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("geometry_index_end")
            public Integer geometryIndexEnd() {
                return this.geometryIndexEnd;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("creation_time")
            public String creationTime() {
                return this.creationTime;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("start_time")
            public String startTime() {
                return this.startTime;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("end_time")
            public String endTime() {
                return this.endTime;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("iso_3166_1_alpha2")
            public String countryCodeAlpha2() {
                return this.countryCodeAlpha2;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("iso_3166_1_alpha3")
            public String countryCodeAlpha3() {
                return this.countryCodeAlpha3;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("lanes_blocked")
            public List<String> lanesBlocked() {
                return this.lanesBlocked;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("num_lanes_blocked")
            public Integer numLanesBlocked() {
                return this.numLanesBlocked;
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            @SerializedName("affected_road_names")
            public List<String> affectedRoadNames() {
                return this.affectedRoadNames;
            }

            public String toString() {
                return "Incident{unrecognized=" + this.unrecognized + ", id=" + this.id + ", type=" + this.type + ", closed=" + this.closed + ", congestion=" + this.congestion + ", description=" + this.description + ", longDescription=" + this.longDescription + ", impact=" + this.impact + ", subType=" + this.subType + ", subTypeDescription=" + this.subTypeDescription + ", alertcCodes=" + this.alertcCodes + ", geometryIndexStart=" + this.geometryIndexStart + ", geometryIndexEnd=" + this.geometryIndexEnd + ", creationTime=" + this.creationTime + ", startTime=" + this.startTime + ", endTime=" + this.endTime + ", countryCodeAlpha2=" + this.countryCodeAlpha2 + ", countryCodeAlpha3=" + this.countryCodeAlpha3 + ", lanesBlocked=" + this.lanesBlocked + ", numLanesBlocked=" + this.numLanesBlocked + ", affectedRoadNames=" + this.affectedRoadNames + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str13;
                Boolean bool2;
                Congestion congestion2;
                String str14;
                String str15;
                String str16;
                String str17;
                String str18;
                List<Integer> list4;
                Integer num4;
                Integer num5;
                String str19;
                String str20;
                String str21;
                String str22;
                String str23;
                List<String> list5;
                Integer num6;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Incident)) {
                    return false;
                }
                Incident incident = (Incident) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(incident.unrecognized()) : incident.unrecognized() == null) {
                    if (this.id.equals(incident.id()) && ((str13 = this.type) != null ? str13.equals(incident.type()) : incident.type() == null) && ((bool2 = this.closed) != null ? bool2.equals(incident.closed()) : incident.closed() == null) && ((congestion2 = this.congestion) != null ? congestion2.equals(incident.congestion()) : incident.congestion() == null) && ((str14 = this.description) != null ? str14.equals(incident.description()) : incident.description() == null) && ((str15 = this.longDescription) != null ? str15.equals(incident.longDescription()) : incident.longDescription() == null) && ((str16 = this.impact) != null ? str16.equals(incident.impact()) : incident.impact() == null) && ((str17 = this.subType) != null ? str17.equals(incident.subType()) : incident.subType() == null) && ((str18 = this.subTypeDescription) != null ? str18.equals(incident.subTypeDescription()) : incident.subTypeDescription() == null) && ((list4 = this.alertcCodes) != null ? list4.equals(incident.alertcCodes()) : incident.alertcCodes() == null) && ((num4 = this.geometryIndexStart) != null ? num4.equals(incident.geometryIndexStart()) : incident.geometryIndexStart() == null) && ((num5 = this.geometryIndexEnd) != null ? num5.equals(incident.geometryIndexEnd()) : incident.geometryIndexEnd() == null) && ((str19 = this.creationTime) != null ? str19.equals(incident.creationTime()) : incident.creationTime() == null) && ((str20 = this.startTime) != null ? str20.equals(incident.startTime()) : incident.startTime() == null) && ((str21 = this.endTime) != null ? str21.equals(incident.endTime()) : incident.endTime() == null) && ((str22 = this.countryCodeAlpha2) != null ? str22.equals(incident.countryCodeAlpha2()) : incident.countryCodeAlpha2() == null) && ((str23 = this.countryCodeAlpha3) != null ? str23.equals(incident.countryCodeAlpha3()) : incident.countryCodeAlpha3() == null) && ((list5 = this.lanesBlocked) != null ? list5.equals(incident.lanesBlocked()) : incident.lanesBlocked() == null) && ((num6 = this.numLanesBlocked) != null ? num6.equals(incident.numLanesBlocked()) : incident.numLanesBlocked() == null)) {
                        List<String> list6 = this.affectedRoadNames;
                        if (list6 == null) {
                            if (incident.affectedRoadNames() == null) {
                                return true;
                            }
                        } else if (list6.equals(incident.affectedRoadNames())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.id.hashCode()) * 1000003;
                String str13 = this.type;
                int hashCode2 = (hashCode ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
                Boolean bool2 = this.closed;
                int hashCode3 = (hashCode2 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
                Congestion congestion2 = this.congestion;
                int hashCode4 = (hashCode3 ^ (congestion2 == null ? 0 : congestion2.hashCode())) * 1000003;
                String str14 = this.description;
                int hashCode5 = (hashCode4 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
                String str15 = this.longDescription;
                int hashCode6 = (hashCode5 ^ (str15 == null ? 0 : str15.hashCode())) * 1000003;
                String str16 = this.impact;
                int hashCode7 = (hashCode6 ^ (str16 == null ? 0 : str16.hashCode())) * 1000003;
                String str17 = this.subType;
                int hashCode8 = (hashCode7 ^ (str17 == null ? 0 : str17.hashCode())) * 1000003;
                String str18 = this.subTypeDescription;
                int hashCode9 = (hashCode8 ^ (str18 == null ? 0 : str18.hashCode())) * 1000003;
                List<Integer> list4 = this.alertcCodes;
                int hashCode10 = (hashCode9 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
                Integer num4 = this.geometryIndexStart;
                int hashCode11 = (hashCode10 ^ (num4 == null ? 0 : num4.hashCode())) * 1000003;
                Integer num5 = this.geometryIndexEnd;
                int hashCode12 = (hashCode11 ^ (num5 == null ? 0 : num5.hashCode())) * 1000003;
                String str19 = this.creationTime;
                int hashCode13 = (hashCode12 ^ (str19 == null ? 0 : str19.hashCode())) * 1000003;
                String str20 = this.startTime;
                int hashCode14 = (hashCode13 ^ (str20 == null ? 0 : str20.hashCode())) * 1000003;
                String str21 = this.endTime;
                int hashCode15 = (hashCode14 ^ (str21 == null ? 0 : str21.hashCode())) * 1000003;
                String str22 = this.countryCodeAlpha2;
                int hashCode16 = (hashCode15 ^ (str22 == null ? 0 : str22.hashCode())) * 1000003;
                String str23 = this.countryCodeAlpha3;
                int hashCode17 = (hashCode16 ^ (str23 == null ? 0 : str23.hashCode())) * 1000003;
                List<String> list5 = this.lanesBlocked;
                int hashCode18 = (hashCode17 ^ (list5 == null ? 0 : list5.hashCode())) * 1000003;
                Integer num6 = this.numLanesBlocked;
                int hashCode19 = (hashCode18 ^ (num6 == null ? 0 : num6.hashCode())) * 1000003;
                List<String> list6 = this.affectedRoadNames;
                return hashCode19 ^ (list6 != null ? list6.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.Incident
            public Incident.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_Incident$Builder */
            static class Builder extends Incident.Builder {
                private List<String> affectedRoadNames;
                private List<Integer> alertcCodes;
                private Boolean closed;
                private Congestion congestion;
                private String countryCodeAlpha2;
                private String countryCodeAlpha3;
                private String creationTime;
                private String description;
                private String endTime;
                private Integer geometryIndexEnd;
                private Integer geometryIndexStart;
                private String id;
                private String impact;
                private List<String> lanesBlocked;
                private String longDescription;
                private Integer numLanesBlocked;
                private String startTime;
                private String subType;
                private String subTypeDescription;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ Incident.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(Incident incident) {
                    this.unrecognized = incident.unrecognized();
                    this.id = incident.id();
                    this.type = incident.type();
                    this.closed = incident.closed();
                    this.congestion = incident.congestion();
                    this.description = incident.description();
                    this.longDescription = incident.longDescription();
                    this.impact = incident.impact();
                    this.subType = incident.subType();
                    this.subTypeDescription = incident.subTypeDescription();
                    this.alertcCodes = incident.alertcCodes();
                    this.geometryIndexStart = incident.geometryIndexStart();
                    this.geometryIndexEnd = incident.geometryIndexEnd();
                    this.creationTime = incident.creationTime();
                    this.startTime = incident.startTime();
                    this.endTime = incident.endTime();
                    this.countryCodeAlpha2 = incident.countryCodeAlpha2();
                    this.countryCodeAlpha3 = incident.countryCodeAlpha3();
                    this.lanesBlocked = incident.lanesBlocked();
                    this.numLanesBlocked = incident.numLanesBlocked();
                    this.affectedRoadNames = incident.affectedRoadNames();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                Incident.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder id(String str) {
                    Objects.requireNonNull(str, "Null id");
                    this.id = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder closed(Boolean bool) {
                    this.closed = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder congestion(Congestion congestion) {
                    this.congestion = congestion;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder description(String str) {
                    this.description = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder longDescription(String str) {
                    this.longDescription = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder impact(String str) {
                    this.impact = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder subType(String str) {
                    this.subType = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder subTypeDescription(String str) {
                    this.subTypeDescription = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder alertcCodes(List<Integer> list) {
                    this.alertcCodes = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder geometryIndexStart(Integer num) {
                    this.geometryIndexStart = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder geometryIndexEnd(Integer num) {
                    this.geometryIndexEnd = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder creationTime(String str) {
                    this.creationTime = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder startTime(String str) {
                    this.startTime = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder endTime(String str) {
                    this.endTime = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder countryCodeAlpha2(String str) {
                    this.countryCodeAlpha2 = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder countryCodeAlpha3(String str) {
                    this.countryCodeAlpha3 = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder lanesBlocked(List<String> list) {
                    this.lanesBlocked = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder numLanesBlocked(Integer num) {
                    this.numLanesBlocked = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident.Builder affectedRoadNames(List<String> list) {
                    this.affectedRoadNames = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Incident.Builder
                public Incident build() {
                    String str = this.id == null ? " id" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_Incident(this.unrecognized, this.id, this.type, this.closed, this.congestion, this.description, this.longDescription, this.impact, this.subType, this.subTypeDescription, this.alertcCodes, this.geometryIndexStart, this.geometryIndexEnd, this.creationTime, this.startTime, this.endTime, this.countryCodeAlpha2, this.countryCodeAlpha3, this.lanesBlocked, this.numLanesBlocked, this.affectedRoadNames);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<Incident> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private volatile TypeAdapter<Congestion> congestion_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<Integer>> list__integer_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Incident incident) throws IOException {
            if (incident == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (incident.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : incident.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name(TtmlNode.ATTR_ID);
            if (incident.id() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, incident.id());
            }
            jsonWriter.name("type");
            if (incident.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, incident.type());
            }
            jsonWriter.name("closed");
            if (incident.closed() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter3 = this.boolean__adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, incident.closed());
            }
            jsonWriter.name("congestion");
            if (incident.congestion() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Congestion> typeAdapter4 = this.congestion_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Congestion.class);
                    this.congestion_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, incident.congestion());
            }
            jsonWriter.name("description");
            if (incident.description() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, incident.description());
            }
            jsonWriter.name("long_description");
            if (incident.longDescription() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, incident.longDescription());
            }
            jsonWriter.name("impact");
            if (incident.impact() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, incident.impact());
            }
            jsonWriter.name("sub_type");
            if (incident.subType() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, incident.subType());
            }
            jsonWriter.name("sub_type_description");
            if (incident.subTypeDescription() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter9 = this.string_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, incident.subTypeDescription());
            }
            jsonWriter.name("alertc_codes");
            if (incident.alertcCodes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Integer>> typeAdapter10 = this.list__integer_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                    this.list__integer_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, incident.alertcCodes());
            }
            jsonWriter.name("geometry_index_start");
            if (incident.geometryIndexStart() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter11 = this.integer_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, incident.geometryIndexStart());
            }
            jsonWriter.name("geometry_index_end");
            if (incident.geometryIndexEnd() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter12 = this.integer_adapter;
                if (typeAdapter12 == null) {
                    typeAdapter12 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter12;
                }
                typeAdapter12.write(jsonWriter, incident.geometryIndexEnd());
            }
            jsonWriter.name("creation_time");
            if (incident.creationTime() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter13 = this.string_adapter;
                if (typeAdapter13 == null) {
                    typeAdapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter13;
                }
                typeAdapter13.write(jsonWriter, incident.creationTime());
            }
            jsonWriter.name("start_time");
            if (incident.startTime() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter14 = this.string_adapter;
                if (typeAdapter14 == null) {
                    typeAdapter14 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter14;
                }
                typeAdapter14.write(jsonWriter, incident.startTime());
            }
            jsonWriter.name("end_time");
            if (incident.endTime() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter15 = this.string_adapter;
                if (typeAdapter15 == null) {
                    typeAdapter15 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter15;
                }
                typeAdapter15.write(jsonWriter, incident.endTime());
            }
            jsonWriter.name("iso_3166_1_alpha2");
            if (incident.countryCodeAlpha2() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter16 = this.string_adapter;
                if (typeAdapter16 == null) {
                    typeAdapter16 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter16;
                }
                typeAdapter16.write(jsonWriter, incident.countryCodeAlpha2());
            }
            jsonWriter.name("iso_3166_1_alpha3");
            if (incident.countryCodeAlpha3() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter17 = this.string_adapter;
                if (typeAdapter17 == null) {
                    typeAdapter17 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter17;
                }
                typeAdapter17.write(jsonWriter, incident.countryCodeAlpha3());
            }
            jsonWriter.name("lanes_blocked");
            if (incident.lanesBlocked() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter18 = this.list__string_adapter;
                if (typeAdapter18 == null) {
                    typeAdapter18 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter18;
                }
                typeAdapter18.write(jsonWriter, incident.lanesBlocked());
            }
            jsonWriter.name("num_lanes_blocked");
            if (incident.numLanesBlocked() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter19 = this.integer_adapter;
                if (typeAdapter19 == null) {
                    typeAdapter19 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter19;
                }
                typeAdapter19.write(jsonWriter, incident.numLanesBlocked());
            }
            jsonWriter.name("affected_road_names");
            if (incident.affectedRoadNames() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter20 = this.list__string_adapter;
                if (typeAdapter20 == null) {
                    typeAdapter20 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter20;
                }
                typeAdapter20.write(jsonWriter, incident.affectedRoadNames());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Incident read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Incident.Builder builder = Incident.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "sub_type":
                            TypeAdapter<String> typeAdapter = this.string_adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter;
                            }
                            builder.subType(typeAdapter.read2(jsonReader));
                            break;
                        case "affected_road_names":
                            TypeAdapter<List<String>> typeAdapter2 = this.list__string_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                                this.list__string_adapter = typeAdapter2;
                            }
                            builder.affectedRoadNames(typeAdapter2.read2(jsonReader));
                            break;
                        case "long_description":
                            TypeAdapter<String> typeAdapter3 = this.string_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter3;
                            }
                            builder.longDescription(typeAdapter3.read2(jsonReader));
                            break;
                        case "start_time":
                            TypeAdapter<String> typeAdapter4 = this.string_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter4;
                            }
                            builder.startTime(typeAdapter4.read2(jsonReader));
                            break;
                        case "num_lanes_blocked":
                            TypeAdapter<Integer> typeAdapter5 = this.integer_adapter;
                            if (typeAdapter5 == null) {
                                typeAdapter5 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter5;
                            }
                            builder.numLanesBlocked(typeAdapter5.read2(jsonReader));
                            break;
                        case "lanes_blocked":
                            TypeAdapter<List<String>> typeAdapter6 = this.list__string_adapter;
                            if (typeAdapter6 == null) {
                                typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                                this.list__string_adapter = typeAdapter6;
                            }
                            builder.lanesBlocked(typeAdapter6.read2(jsonReader));
                            break;
                        case "geometry_index_start":
                            TypeAdapter<Integer> typeAdapter7 = this.integer_adapter;
                            if (typeAdapter7 == null) {
                                typeAdapter7 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter7;
                            }
                            builder.geometryIndexStart(typeAdapter7.read2(jsonReader));
                            break;
                        case "sub_type_description":
                            TypeAdapter<String> typeAdapter8 = this.string_adapter;
                            if (typeAdapter8 == null) {
                                typeAdapter8 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter8;
                            }
                            builder.subTypeDescription(typeAdapter8.read2(jsonReader));
                            break;
                        case "alertc_codes":
                            TypeAdapter<List<Integer>> typeAdapter9 = this.list__integer_adapter;
                            if (typeAdapter9 == null) {
                                typeAdapter9 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Integer.class));
                                this.list__integer_adapter = typeAdapter9;
                            }
                            builder.alertcCodes(typeAdapter9.read2(jsonReader));
                            break;
                        case "iso_3166_1_alpha2":
                            TypeAdapter<String> typeAdapter10 = this.string_adapter;
                            if (typeAdapter10 == null) {
                                typeAdapter10 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter10;
                            }
                            builder.countryCodeAlpha2(typeAdapter10.read2(jsonReader));
                            break;
                        case "iso_3166_1_alpha3":
                            TypeAdapter<String> typeAdapter11 = this.string_adapter;
                            if (typeAdapter11 == null) {
                                typeAdapter11 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter11;
                            }
                            builder.countryCodeAlpha3(typeAdapter11.read2(jsonReader));
                            break;
                        case "end_time":
                            TypeAdapter<String> typeAdapter12 = this.string_adapter;
                            if (typeAdapter12 == null) {
                                typeAdapter12 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter12;
                            }
                            builder.endTime(typeAdapter12.read2(jsonReader));
                            break;
                        case "geometry_index_end":
                            TypeAdapter<Integer> typeAdapter13 = this.integer_adapter;
                            if (typeAdapter13 == null) {
                                typeAdapter13 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter13;
                            }
                            builder.geometryIndexEnd(typeAdapter13.read2(jsonReader));
                            break;
                        case "creation_time":
                            TypeAdapter<String> typeAdapter14 = this.string_adapter;
                            if (typeAdapter14 == null) {
                                typeAdapter14 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter14;
                            }
                            builder.creationTime(typeAdapter14.read2(jsonReader));
                            break;
                        default:
                            if (TtmlNode.ATTR_ID.equals(nextName)) {
                                TypeAdapter<String> typeAdapter15 = this.string_adapter;
                                if (typeAdapter15 == null) {
                                    typeAdapter15 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter15;
                                }
                                builder.id(typeAdapter15.read2(jsonReader));
                                break;
                            } else if ("type".equals(nextName)) {
                                TypeAdapter<String> typeAdapter16 = this.string_adapter;
                                if (typeAdapter16 == null) {
                                    typeAdapter16 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter16;
                                }
                                builder.type(typeAdapter16.read2(jsonReader));
                                break;
                            } else if ("closed".equals(nextName)) {
                                TypeAdapter<Boolean> typeAdapter17 = this.boolean__adapter;
                                if (typeAdapter17 == null) {
                                    typeAdapter17 = this.gson.getAdapter(Boolean.class);
                                    this.boolean__adapter = typeAdapter17;
                                }
                                builder.closed(typeAdapter17.read2(jsonReader));
                                break;
                            } else if ("congestion".equals(nextName)) {
                                TypeAdapter<Congestion> typeAdapter18 = this.congestion_adapter;
                                if (typeAdapter18 == null) {
                                    typeAdapter18 = this.gson.getAdapter(Congestion.class);
                                    this.congestion_adapter = typeAdapter18;
                                }
                                builder.congestion(typeAdapter18.read2(jsonReader));
                                break;
                            } else if ("description".equals(nextName)) {
                                TypeAdapter<String> typeAdapter19 = this.string_adapter;
                                if (typeAdapter19 == null) {
                                    typeAdapter19 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter19;
                                }
                                builder.description(typeAdapter19.read2(jsonReader));
                                break;
                            } else if ("impact".equals(nextName)) {
                                TypeAdapter<String> typeAdapter20 = this.string_adapter;
                                if (typeAdapter20 == null) {
                                    typeAdapter20 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter20;
                                }
                                builder.impact(typeAdapter20.read2(jsonReader));
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
            return "TypeAdapter(Incident)";
        }
    }
}
