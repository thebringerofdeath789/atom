package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.BannerComponents;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_BannerComponents extends C$AutoValue_BannerComponents {
    AutoValue_BannerComponents(final Map<String, SerializableJsonElement> map, final String str, final String str2, final String str3, final String str4, final Integer num, final String str5, final MapboxShield mapboxShield, final String str6, final List<String> list, final Boolean bool, final String str7) {
        new BannerComponents(map, str, str2, str3, str4, num, str5, mapboxShield, str6, list, bool, str7) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_BannerComponents
            private final String abbreviation;
            private final Integer abbreviationPriority;
            private final Boolean active;
            private final String activeDirection;
            private final List<String> directions;
            private final String imageBaseUrl;
            private final String imageUrl;
            private final MapboxShield mapboxShield;
            private final String subType;
            private final String text;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null text");
                this.text = str;
                Objects.requireNonNull(str2, "Null type");
                this.type = str2;
                this.subType = str3;
                this.abbreviation = str4;
                this.abbreviationPriority = num;
                this.imageBaseUrl = str5;
                this.mapboxShield = mapboxShield;
                this.imageUrl = str6;
                this.directions = list;
                this.active = bool;
                this.activeDirection = str7;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            public String text() {
                return this.text;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            public String subType() {
                return this.subType;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            @SerializedName("abbr")
            public String abbreviation() {
                return this.abbreviation;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            @SerializedName("abbr_priority")
            public Integer abbreviationPriority() {
                return this.abbreviationPriority;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            @SerializedName("imageBaseURL")
            public String imageBaseUrl() {
                return this.imageBaseUrl;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            @SerializedName("mapbox_shield")
            public MapboxShield mapboxShield() {
                return this.mapboxShield;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            @SerializedName("imageURL")
            public String imageUrl() {
                return this.imageUrl;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            public List<String> directions() {
                return this.directions;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            public Boolean active() {
                return this.active;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            @SerializedName("active_direction")
            public String activeDirection() {
                return this.activeDirection;
            }

            public String toString() {
                return "BannerComponents{unrecognized=" + this.unrecognized + ", text=" + this.text + ", type=" + this.type + ", subType=" + this.subType + ", abbreviation=" + this.abbreviation + ", abbreviationPriority=" + this.abbreviationPriority + ", imageBaseUrl=" + this.imageBaseUrl + ", mapboxShield=" + this.mapboxShield + ", imageUrl=" + this.imageUrl + ", directions=" + this.directions + ", active=" + this.active + ", activeDirection=" + this.activeDirection + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str8;
                String str9;
                Integer num2;
                String str10;
                MapboxShield mapboxShield2;
                String str11;
                List<String> list2;
                Boolean bool2;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerComponents)) {
                    return false;
                }
                BannerComponents bannerComponents = (BannerComponents) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(bannerComponents.unrecognized()) : bannerComponents.unrecognized() == null) {
                    if (this.text.equals(bannerComponents.text()) && this.type.equals(bannerComponents.type()) && ((str8 = this.subType) != null ? str8.equals(bannerComponents.subType()) : bannerComponents.subType() == null) && ((str9 = this.abbreviation) != null ? str9.equals(bannerComponents.abbreviation()) : bannerComponents.abbreviation() == null) && ((num2 = this.abbreviationPriority) != null ? num2.equals(bannerComponents.abbreviationPriority()) : bannerComponents.abbreviationPriority() == null) && ((str10 = this.imageBaseUrl) != null ? str10.equals(bannerComponents.imageBaseUrl()) : bannerComponents.imageBaseUrl() == null) && ((mapboxShield2 = this.mapboxShield) != null ? mapboxShield2.equals(bannerComponents.mapboxShield()) : bannerComponents.mapboxShield() == null) && ((str11 = this.imageUrl) != null ? str11.equals(bannerComponents.imageUrl()) : bannerComponents.imageUrl() == null) && ((list2 = this.directions) != null ? list2.equals(bannerComponents.directions()) : bannerComponents.directions() == null) && ((bool2 = this.active) != null ? bool2.equals(bannerComponents.active()) : bannerComponents.active() == null)) {
                        String str12 = this.activeDirection;
                        if (str12 == null) {
                            if (bannerComponents.activeDirection() == null) {
                                return true;
                            }
                        } else if (str12.equals(bannerComponents.activeDirection())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003) ^ this.type.hashCode()) * 1000003;
                String str8 = this.subType;
                int hashCode2 = (hashCode ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                String str9 = this.abbreviation;
                int hashCode3 = (hashCode2 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
                Integer num2 = this.abbreviationPriority;
                int hashCode4 = (hashCode3 ^ (num2 == null ? 0 : num2.hashCode())) * 1000003;
                String str10 = this.imageBaseUrl;
                int hashCode5 = (hashCode4 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
                MapboxShield mapboxShield2 = this.mapboxShield;
                int hashCode6 = (hashCode5 ^ (mapboxShield2 == null ? 0 : mapboxShield2.hashCode())) * 1000003;
                String str11 = this.imageUrl;
                int hashCode7 = (hashCode6 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
                List<String> list2 = this.directions;
                int hashCode8 = (hashCode7 ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
                Boolean bool2 = this.active;
                int hashCode9 = (hashCode8 ^ (bool2 == null ? 0 : bool2.hashCode())) * 1000003;
                String str12 = this.activeDirection;
                return hashCode9 ^ (str12 != null ? str12.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerComponents
            public BannerComponents.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_BannerComponents$Builder */
            static class Builder extends BannerComponents.Builder {
                private String abbreviation;
                private Integer abbreviationPriority;
                private Boolean active;
                private String activeDirection;
                private List<String> directions;
                private String imageBaseUrl;
                private String imageUrl;
                private MapboxShield mapboxShield;
                private String subType;
                private String text;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ BannerComponents.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(BannerComponents bannerComponents) {
                    this.unrecognized = bannerComponents.unrecognized();
                    this.text = bannerComponents.text();
                    this.type = bannerComponents.type();
                    this.subType = bannerComponents.subType();
                    this.abbreviation = bannerComponents.abbreviation();
                    this.abbreviationPriority = bannerComponents.abbreviationPriority();
                    this.imageBaseUrl = bannerComponents.imageBaseUrl();
                    this.mapboxShield = bannerComponents.mapboxShield();
                    this.imageUrl = bannerComponents.imageUrl();
                    this.directions = bannerComponents.directions();
                    this.active = bannerComponents.active();
                    this.activeDirection = bannerComponents.activeDirection();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                BannerComponents.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder text(String str) {
                    Objects.requireNonNull(str, "Null text");
                    this.text = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder type(String str) {
                    Objects.requireNonNull(str, "Null type");
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder subType(String str) {
                    this.subType = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder abbreviation(String str) {
                    this.abbreviation = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder abbreviationPriority(Integer num) {
                    this.abbreviationPriority = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder imageBaseUrl(String str) {
                    this.imageBaseUrl = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder mapboxShield(MapboxShield mapboxShield) {
                    this.mapboxShield = mapboxShield;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder imageUrl(String str) {
                    this.imageUrl = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder directions(List<String> list) {
                    this.directions = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder active(Boolean bool) {
                    this.active = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents.Builder activeDirection(String str) {
                    this.activeDirection = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerComponents.Builder
                public BannerComponents build() {
                    String str = this.text == null ? " text" : "";
                    if (this.type == null) {
                        str = str + " type";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_BannerComponents(this.unrecognized, this.text, this.type, this.subType, this.abbreviation, this.abbreviationPriority, this.imageBaseUrl, this.mapboxShield, this.imageUrl, this.directions, this.active, this.activeDirection);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerComponents> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<MapboxShield> mapboxShield_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerComponents bannerComponents) throws IOException {
            if (bannerComponents == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (bannerComponents.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : bannerComponents.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("text");
            if (bannerComponents.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, bannerComponents.text());
            }
            jsonWriter.name("type");
            if (bannerComponents.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, bannerComponents.type());
            }
            jsonWriter.name("subType");
            if (bannerComponents.subType() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, bannerComponents.subType());
            }
            jsonWriter.name("abbr");
            if (bannerComponents.abbreviation() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, bannerComponents.abbreviation());
            }
            jsonWriter.name("abbr_priority");
            if (bannerComponents.abbreviationPriority() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter5 = this.integer_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, bannerComponents.abbreviationPriority());
            }
            jsonWriter.name("imageBaseURL");
            if (bannerComponents.imageBaseUrl() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, bannerComponents.imageBaseUrl());
            }
            jsonWriter.name("mapbox_shield");
            if (bannerComponents.mapboxShield() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<MapboxShield> typeAdapter7 = this.mapboxShield_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(MapboxShield.class);
                    this.mapboxShield_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, bannerComponents.mapboxShield());
            }
            jsonWriter.name("imageURL");
            if (bannerComponents.imageUrl() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, bannerComponents.imageUrl());
            }
            jsonWriter.name("directions");
            if (bannerComponents.directions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter9 = this.list__string_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, bannerComponents.directions());
            }
            jsonWriter.name("active");
            if (bannerComponents.active() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter10 = this.boolean__adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, bannerComponents.active());
            }
            jsonWriter.name("active_direction");
            if (bannerComponents.activeDirection() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter11 = this.string_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, bannerComponents.activeDirection());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public BannerComponents read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerComponents.Builder builder = BannerComponents.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "mapbox_shield":
                            TypeAdapter<MapboxShield> typeAdapter = this.mapboxShield_adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(MapboxShield.class);
                                this.mapboxShield_adapter = typeAdapter;
                            }
                            builder.mapboxShield(typeAdapter.read(jsonReader));
                            break;
                        case "imageURL":
                            TypeAdapter<String> typeAdapter2 = this.string_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter2;
                            }
                            builder.imageUrl(typeAdapter2.read(jsonReader));
                            break;
                        case "abbr_priority":
                            TypeAdapter<Integer> typeAdapter3 = this.integer_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(Integer.class);
                                this.integer_adapter = typeAdapter3;
                            }
                            builder.abbreviationPriority(typeAdapter3.read(jsonReader));
                            break;
                        case "abbr":
                            TypeAdapter<String> typeAdapter4 = this.string_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter4;
                            }
                            builder.abbreviation(typeAdapter4.read(jsonReader));
                            break;
                        case "imageBaseURL":
                            TypeAdapter<String> typeAdapter5 = this.string_adapter;
                            if (typeAdapter5 == null) {
                                typeAdapter5 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter5;
                            }
                            builder.imageBaseUrl(typeAdapter5.read(jsonReader));
                            break;
                        case "active_direction":
                            TypeAdapter<String> typeAdapter6 = this.string_adapter;
                            if (typeAdapter6 == null) {
                                typeAdapter6 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter6;
                            }
                            builder.activeDirection(typeAdapter6.read(jsonReader));
                            break;
                        default:
                            if ("text".equals(nextName)) {
                                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                                if (typeAdapter7 == null) {
                                    typeAdapter7 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter7;
                                }
                                builder.text(typeAdapter7.read(jsonReader));
                                break;
                            } else if ("type".equals(nextName)) {
                                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                                if (typeAdapter8 == null) {
                                    typeAdapter8 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter8;
                                }
                                builder.type(typeAdapter8.read(jsonReader));
                                break;
                            } else if ("subType".equals(nextName)) {
                                TypeAdapter<String> typeAdapter9 = this.string_adapter;
                                if (typeAdapter9 == null) {
                                    typeAdapter9 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter9;
                                }
                                builder.subType(typeAdapter9.read(jsonReader));
                                break;
                            } else if ("directions".equals(nextName)) {
                                TypeAdapter<List<String>> typeAdapter10 = this.list__string_adapter;
                                if (typeAdapter10 == null) {
                                    typeAdapter10 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                                    this.list__string_adapter = typeAdapter10;
                                }
                                builder.directions(typeAdapter10.read(jsonReader));
                                break;
                            } else if ("active".equals(nextName)) {
                                TypeAdapter<Boolean> typeAdapter11 = this.boolean__adapter;
                                if (typeAdapter11 == null) {
                                    typeAdapter11 = this.gson.getAdapter(Boolean.class);
                                    this.boolean__adapter = typeAdapter11;
                                }
                                builder.active(typeAdapter11.read(jsonReader));
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
            return "TypeAdapter(BannerComponents)";
        }
    }
}