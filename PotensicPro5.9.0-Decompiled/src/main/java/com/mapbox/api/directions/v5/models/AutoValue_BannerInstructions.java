package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.BannerInstructions;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_BannerInstructions extends C$AutoValue_BannerInstructions {
    AutoValue_BannerInstructions(Map<String, SerializableJsonElement> map, double d, BannerText bannerText, BannerText bannerText2, BannerText bannerText3, BannerView bannerView) {
        new BannerInstructions(map, d, bannerText, bannerText2, bannerText3, bannerView) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_BannerInstructions
            private final double distanceAlongGeometry;
            private final BannerText primary;
            private final BannerText secondary;
            private final BannerText sub;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final BannerView view;

            {
                this.unrecognized = map;
                this.distanceAlongGeometry = d;
                Objects.requireNonNull(bannerText, "Null primary");
                this.primary = bannerText;
                this.secondary = bannerText2;
                this.sub = bannerText3;
                this.view = bannerView;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.BannerInstructions
            public double distanceAlongGeometry() {
                return this.distanceAlongGeometry;
            }

            @Override // com.mapbox.api.directions.v5.models.BannerInstructions
            public BannerText primary() {
                return this.primary;
            }

            @Override // com.mapbox.api.directions.v5.models.BannerInstructions
            public BannerText secondary() {
                return this.secondary;
            }

            @Override // com.mapbox.api.directions.v5.models.BannerInstructions
            public BannerText sub() {
                return this.sub;
            }

            @Override // com.mapbox.api.directions.v5.models.BannerInstructions
            public BannerView view() {
                return this.view;
            }

            public String toString() {
                return "BannerInstructions{unrecognized=" + this.unrecognized + ", distanceAlongGeometry=" + this.distanceAlongGeometry + ", primary=" + this.primary + ", secondary=" + this.secondary + ", sub=" + this.sub + ", view=" + this.view + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                BannerText bannerText4;
                BannerText bannerText5;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerInstructions)) {
                    return false;
                }
                BannerInstructions bannerInstructions = (BannerInstructions) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(bannerInstructions.unrecognized()) : bannerInstructions.unrecognized() == null) {
                    if (Double.doubleToLongBits(this.distanceAlongGeometry) == Double.doubleToLongBits(bannerInstructions.distanceAlongGeometry()) && this.primary.equals(bannerInstructions.primary()) && ((bannerText4 = this.secondary) != null ? bannerText4.equals(bannerInstructions.secondary()) : bannerInstructions.secondary() == null) && ((bannerText5 = this.sub) != null ? bannerText5.equals(bannerInstructions.sub()) : bannerInstructions.sub() == null)) {
                        BannerView bannerView2 = this.view;
                        if (bannerView2 == null) {
                            if (bannerInstructions.view() == null) {
                                return true;
                            }
                        } else if (bannerView2.equals(bannerInstructions.view())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ ((int) ((Double.doubleToLongBits(this.distanceAlongGeometry) >>> 32) ^ Double.doubleToLongBits(this.distanceAlongGeometry)))) * 1000003) ^ this.primary.hashCode()) * 1000003;
                BannerText bannerText4 = this.secondary;
                int hashCode2 = (hashCode ^ (bannerText4 == null ? 0 : bannerText4.hashCode())) * 1000003;
                BannerText bannerText5 = this.sub;
                int hashCode3 = (hashCode2 ^ (bannerText5 == null ? 0 : bannerText5.hashCode())) * 1000003;
                BannerView bannerView2 = this.view;
                return hashCode3 ^ (bannerView2 != null ? bannerView2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.BannerInstructions
            public BannerInstructions.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_BannerInstructions$Builder */
            static class Builder extends BannerInstructions.Builder {
                private Double distanceAlongGeometry;
                private BannerText primary;
                private BannerText secondary;
                private BannerText sub;
                private Map<String, SerializableJsonElement> unrecognized;
                private BannerView view;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ BannerInstructions.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(BannerInstructions bannerInstructions) {
                    this.unrecognized = bannerInstructions.unrecognized();
                    this.distanceAlongGeometry = Double.valueOf(bannerInstructions.distanceAlongGeometry());
                    this.primary = bannerInstructions.primary();
                    this.secondary = bannerInstructions.secondary();
                    this.sub = bannerInstructions.sub();
                    this.view = bannerInstructions.view();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                BannerInstructions.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerInstructions.Builder
                public BannerInstructions.Builder distanceAlongGeometry(double d) {
                    this.distanceAlongGeometry = Double.valueOf(d);
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerInstructions.Builder
                public BannerInstructions.Builder primary(BannerText bannerText) {
                    Objects.requireNonNull(bannerText, "Null primary");
                    this.primary = bannerText;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerInstructions.Builder
                public BannerInstructions.Builder secondary(BannerText bannerText) {
                    this.secondary = bannerText;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerInstructions.Builder
                public BannerInstructions.Builder sub(BannerText bannerText) {
                    this.sub = bannerText;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerInstructions.Builder
                public BannerInstructions.Builder view(BannerView bannerView) {
                    this.view = bannerView;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerInstructions.Builder
                public BannerInstructions build() {
                    String str = this.distanceAlongGeometry == null ? " distanceAlongGeometry" : "";
                    if (this.primary == null) {
                        str = str + " primary";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_BannerInstructions(this.unrecognized, this.distanceAlongGeometry.doubleValue(), this.primary, this.secondary, this.sub, this.view);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerInstructions> {
        private volatile TypeAdapter<BannerText> bannerText_adapter;
        private volatile TypeAdapter<BannerView> bannerView_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerInstructions bannerInstructions) throws IOException {
            if (bannerInstructions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (bannerInstructions.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : bannerInstructions.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("distanceAlongGeometry");
            TypeAdapter<Double> typeAdapter = this.double__adapter;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getAdapter(Double.class);
                this.double__adapter = typeAdapter;
            }
            typeAdapter.write(jsonWriter, Double.valueOf(bannerInstructions.distanceAlongGeometry()));
            jsonWriter.name("primary");
            if (bannerInstructions.primary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BannerText> typeAdapter2 = this.bannerText_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(BannerText.class);
                    this.bannerText_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, bannerInstructions.primary());
            }
            jsonWriter.name("secondary");
            if (bannerInstructions.secondary() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BannerText> typeAdapter3 = this.bannerText_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(BannerText.class);
                    this.bannerText_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, bannerInstructions.secondary());
            }
            jsonWriter.name("sub");
            if (bannerInstructions.sub() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BannerText> typeAdapter4 = this.bannerText_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(BannerText.class);
                    this.bannerText_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, bannerInstructions.sub());
            }
            jsonWriter.name("view");
            if (bannerInstructions.view() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BannerView> typeAdapter5 = this.bannerView_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(BannerView.class);
                    this.bannerView_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, bannerInstructions.view());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public BannerInstructions read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerInstructions.Builder builder = BannerInstructions.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("distanceAlongGeometry".equals(nextName)) {
                        TypeAdapter<Double> typeAdapter = this.double__adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Double.class);
                            this.double__adapter = typeAdapter;
                        }
                        builder.distanceAlongGeometry(typeAdapter.read2(jsonReader).doubleValue());
                    } else if ("primary".equals(nextName)) {
                        TypeAdapter<BannerText> typeAdapter2 = this.bannerText_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(BannerText.class);
                            this.bannerText_adapter = typeAdapter2;
                        }
                        builder.primary(typeAdapter2.read2(jsonReader));
                    } else if ("secondary".equals(nextName)) {
                        TypeAdapter<BannerText> typeAdapter3 = this.bannerText_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(BannerText.class);
                            this.bannerText_adapter = typeAdapter3;
                        }
                        builder.secondary(typeAdapter3.read2(jsonReader));
                    } else if ("sub".equals(nextName)) {
                        TypeAdapter<BannerText> typeAdapter4 = this.bannerText_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(BannerText.class);
                            this.bannerText_adapter = typeAdapter4;
                        }
                        builder.sub(typeAdapter4.read2(jsonReader));
                    } else if ("view".equals(nextName)) {
                        TypeAdapter<BannerView> typeAdapter5 = this.bannerView_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(BannerView.class);
                            this.bannerView_adapter = typeAdapter5;
                        }
                        builder.view(typeAdapter5.read2(jsonReader));
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
            return "TypeAdapter(BannerInstructions)";
        }
    }
}
