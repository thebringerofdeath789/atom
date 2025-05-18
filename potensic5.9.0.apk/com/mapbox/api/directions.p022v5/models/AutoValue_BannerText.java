package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.BannerText;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import com.mapbox.turf.TurfConstants;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_BannerText extends C$AutoValue_BannerText {
    AutoValue_BannerText(final Map<String, SerializableJsonElement> map, final String str, final List<BannerComponents> list, final String str2, final String str3, final Double d, final String str4) {
        new BannerText(map, str, list, str2, str3, d, str4) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_BannerText
            private final List<BannerComponents> components;
            private final Double degrees;
            private final String drivingSide;
            private final String modifier;
            private final String text;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null text");
                this.text = str;
                this.components = list;
                this.type = str2;
                this.modifier = str3;
                this.degrees = d;
                this.drivingSide = str4;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            public String text() {
                return this.text;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            public List<BannerComponents> components() {
                return this.components;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            public String modifier() {
                return this.modifier;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            public Double degrees() {
                return this.degrees;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            @SerializedName("driving_side")
            public String drivingSide() {
                return this.drivingSide;
            }

            public String toString() {
                return "BannerText{unrecognized=" + this.unrecognized + ", text=" + this.text + ", components=" + this.components + ", type=" + this.type + ", modifier=" + this.modifier + ", degrees=" + this.degrees + ", drivingSide=" + this.drivingSide + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                List<BannerComponents> list2;
                String str5;
                String str6;
                Double d2;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerText)) {
                    return false;
                }
                BannerText bannerText = (BannerText) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(bannerText.unrecognized()) : bannerText.unrecognized() == null) {
                    if (this.text.equals(bannerText.text()) && ((list2 = this.components) != null ? list2.equals(bannerText.components()) : bannerText.components() == null) && ((str5 = this.type) != null ? str5.equals(bannerText.type()) : bannerText.type() == null) && ((str6 = this.modifier) != null ? str6.equals(bannerText.modifier()) : bannerText.modifier() == null) && ((d2 = this.degrees) != null ? d2.equals(bannerText.degrees()) : bannerText.degrees() == null)) {
                        String str7 = this.drivingSide;
                        if (str7 == null) {
                            if (bannerText.drivingSide() == null) {
                                return true;
                            }
                        } else if (str7.equals(bannerText.drivingSide())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003;
                List<BannerComponents> list2 = this.components;
                int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
                String str5 = this.type;
                int hashCode3 = (hashCode2 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                String str6 = this.modifier;
                int hashCode4 = (hashCode3 ^ (str6 == null ? 0 : str6.hashCode())) * 1000003;
                Double d2 = this.degrees;
                int hashCode5 = (hashCode4 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
                String str7 = this.drivingSide;
                return hashCode5 ^ (str7 != null ? str7.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerText
            public BannerText.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_BannerText$Builder */
            static class Builder extends BannerText.Builder {
                private List<BannerComponents> components;
                private Double degrees;
                private String drivingSide;
                private String modifier;
                private String text;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ BannerText.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(BannerText bannerText) {
                    this.unrecognized = bannerText.unrecognized();
                    this.text = bannerText.text();
                    this.components = bannerText.components();
                    this.type = bannerText.type();
                    this.modifier = bannerText.modifier();
                    this.degrees = bannerText.degrees();
                    this.drivingSide = bannerText.drivingSide();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                BannerText.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText.Builder text(String str) {
                    Objects.requireNonNull(str, "Null text");
                    this.text = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText.Builder components(List<BannerComponents> list) {
                    this.components = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText.Builder modifier(String str) {
                    this.modifier = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText.Builder degrees(Double d) {
                    this.degrees = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText.Builder drivingSide(String str) {
                    this.drivingSide = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerText.Builder
                public BannerText build() {
                    String str = this.text == null ? " text" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_BannerText(this.unrecognized, this.text, this.components, this.type, this.modifier, this.degrees, this.drivingSide);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerText> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<List<BannerComponents>> list__bannerComponents_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerText bannerText) throws IOException {
            if (bannerText == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (bannerText.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : bannerText.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("text");
            if (bannerText.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, bannerText.text());
            }
            jsonWriter.name("components");
            if (bannerText.components() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<BannerComponents>> typeAdapter2 = this.list__bannerComponents_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerComponents.class));
                    this.list__bannerComponents_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, bannerText.components());
            }
            jsonWriter.name("type");
            if (bannerText.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, bannerText.type());
            }
            jsonWriter.name("modifier");
            if (bannerText.modifier() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, bannerText.modifier());
            }
            jsonWriter.name(TurfConstants.UNIT_DEGREES);
            if (bannerText.degrees() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter5 = this.double__adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, bannerText.degrees());
            }
            jsonWriter.name("driving_side");
            if (bannerText.drivingSide() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, bannerText.drivingSide());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public BannerText read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerText.Builder builder = BannerText.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("driving_side")) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.drivingSide(typeAdapter.read(jsonReader));
                    } else if ("text".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.text(typeAdapter2.read(jsonReader));
                    } else if ("components".equals(nextName)) {
                        TypeAdapter<List<BannerComponents>> typeAdapter3 = this.list__bannerComponents_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerComponents.class));
                            this.list__bannerComponents_adapter = typeAdapter3;
                        }
                        builder.components(typeAdapter3.read(jsonReader));
                    } else if ("type".equals(nextName)) {
                        TypeAdapter<String> typeAdapter4 = this.string_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter4;
                        }
                        builder.type(typeAdapter4.read(jsonReader));
                    } else if ("modifier".equals(nextName)) {
                        TypeAdapter<String> typeAdapter5 = this.string_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter5;
                        }
                        builder.modifier(typeAdapter5.read(jsonReader));
                    } else if (TurfConstants.UNIT_DEGREES.equals(nextName)) {
                        TypeAdapter<Double> typeAdapter6 = this.double__adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter6;
                        }
                        builder.degrees(typeAdapter6.read(jsonReader));
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
            return "TypeAdapter(BannerText)";
        }
    }
}