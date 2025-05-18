package com.mapbox.api.geocoding.p024v5.models;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.geocoding.p024v5.GeocodingCriteria;
import com.mapbox.api.geocoding.p024v5.models.CarmenFeature;
import com.mapbox.geojson.BoundingBox;
import com.mapbox.geojson.Geometry;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookupFactory;
import tv.danmaku.ijk.media.player.IjkMediaMeta;

/* loaded from: classes3.dex */
final class AutoValue_CarmenFeature extends C$AutoValue_CarmenFeature {
    AutoValue_CarmenFeature(final String str, final BoundingBox boundingBox, final String str2, final Geometry geometry, final JsonObject jsonObject, final String str3, final String str4, final List<String> list, final String str5, final double[] dArr, final List<CarmenContext> list2, final Double d, final String str6, final String str7, final String str8) {
        new CarmenFeature(str, boundingBox, str2, geometry, jsonObject, str3, str4, list, str5, dArr, list2, d, str6, str7, str8) { // from class: com.mapbox.api.geocoding.v5.models.$AutoValue_CarmenFeature
            private final String address;
            private final BoundingBox bbox;
            private final List<CarmenContext> context;
            private final Geometry geometry;

            /* renamed from: id */
            private final String f2693id;
            private final String language;
            private final String matchingPlaceName;
            private final String matchingText;
            private final String placeName;
            private final List<String> placeType;
            private final JsonObject properties;
            private final double[] rawCenter;
            private final Double relevance;
            private final String text;
            private final String type;

            {
                Objects.requireNonNull(str, "Null type");
                this.type = str;
                this.bbox = boundingBox;
                this.f2693id = str2;
                this.geometry = geometry;
                this.properties = jsonObject;
                this.text = str3;
                this.placeName = str4;
                this.placeType = list;
                this.address = str5;
                this.rawCenter = dArr;
                this.context = list2;
                this.relevance = d;
                this.matchingText = str6;
                this.matchingPlaceName = str7;
                this.language = str8;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature, com.mapbox.geojson.GeoJson
            @SerializedName("type")
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature, com.mapbox.geojson.GeoJson
            public BoundingBox bbox() {
                return this.bbox;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            /* renamed from: id */
            public String mo1748id() {
                return this.f2693id;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public Geometry geometry() {
                return this.geometry;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public JsonObject properties() {
                return this.properties;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public String text() {
                return this.text;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            @SerializedName("place_name")
            public String placeName() {
                return this.placeName;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            @SerializedName("place_type")
            public List<String> placeType() {
                return this.placeType;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public String address() {
                return this.address;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            @SerializedName("center")
            double[] rawCenter() {
                return this.rawCenter;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public List<CarmenContext> context() {
                return this.context;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public Double relevance() {
                return this.relevance;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            @SerializedName("matching_text")
            public String matchingText() {
                return this.matchingText;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            @SerializedName("matching_place_name")
            public String matchingPlaceName() {
                return this.matchingPlaceName;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public String language() {
                return this.language;
            }

            public String toString() {
                return "CarmenFeature{type=" + this.type + ", bbox=" + this.bbox + ", id=" + this.f2693id + ", geometry=" + this.geometry + ", properties=" + this.properties + ", text=" + this.text + ", placeName=" + this.placeName + ", placeType=" + this.placeType + ", address=" + this.address + ", rawCenter=" + Arrays.toString(this.rawCenter) + ", context=" + this.context + ", relevance=" + this.relevance + ", matchingText=" + this.matchingText + ", matchingPlaceName=" + this.matchingPlaceName + ", language=" + this.language + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                BoundingBox boundingBox2;
                String str9;
                Geometry geometry2;
                JsonObject jsonObject2;
                String str10;
                String str11;
                List<String> list3;
                String str12;
                List<CarmenContext> list4;
                Double d2;
                String str13;
                String str14;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof CarmenFeature)) {
                    return false;
                }
                CarmenFeature carmenFeature = (CarmenFeature) obj;
                if (this.type.equals(carmenFeature.type()) && ((boundingBox2 = this.bbox) != null ? boundingBox2.equals(carmenFeature.bbox()) : carmenFeature.bbox() == null) && ((str9 = this.f2693id) != null ? str9.equals(carmenFeature.mo1748id()) : carmenFeature.mo1748id() == null) && ((geometry2 = this.geometry) != null ? geometry2.equals(carmenFeature.geometry()) : carmenFeature.geometry() == null) && ((jsonObject2 = this.properties) != null ? jsonObject2.equals(carmenFeature.properties()) : carmenFeature.properties() == null) && ((str10 = this.text) != null ? str10.equals(carmenFeature.text()) : carmenFeature.text() == null) && ((str11 = this.placeName) != null ? str11.equals(carmenFeature.placeName()) : carmenFeature.placeName() == null) && ((list3 = this.placeType) != null ? list3.equals(carmenFeature.placeType()) : carmenFeature.placeType() == null) && ((str12 = this.address) != null ? str12.equals(carmenFeature.address()) : carmenFeature.address() == null)) {
                    if (Arrays.equals(this.rawCenter, carmenFeature instanceof C$AutoValue_CarmenFeature ? ((C$AutoValue_CarmenFeature) carmenFeature).rawCenter : carmenFeature.rawCenter()) && ((list4 = this.context) != null ? list4.equals(carmenFeature.context()) : carmenFeature.context() == null) && ((d2 = this.relevance) != null ? d2.equals(carmenFeature.relevance()) : carmenFeature.relevance() == null) && ((str13 = this.matchingText) != null ? str13.equals(carmenFeature.matchingText()) : carmenFeature.matchingText() == null) && ((str14 = this.matchingPlaceName) != null ? str14.equals(carmenFeature.matchingPlaceName()) : carmenFeature.matchingPlaceName() == null)) {
                        String str15 = this.language;
                        if (str15 == null) {
                            if (carmenFeature.language() == null) {
                                return true;
                            }
                        } else if (str15.equals(carmenFeature.language())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
                BoundingBox boundingBox2 = this.bbox;
                int hashCode2 = (hashCode ^ (boundingBox2 == null ? 0 : boundingBox2.hashCode())) * 1000003;
                String str9 = this.f2693id;
                int hashCode3 = (hashCode2 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
                Geometry geometry2 = this.geometry;
                int hashCode4 = (hashCode3 ^ (geometry2 == null ? 0 : geometry2.hashCode())) * 1000003;
                JsonObject jsonObject2 = this.properties;
                int hashCode5 = (hashCode4 ^ (jsonObject2 == null ? 0 : jsonObject2.hashCode())) * 1000003;
                String str10 = this.text;
                int hashCode6 = (hashCode5 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
                String str11 = this.placeName;
                int hashCode7 = (hashCode6 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
                List<String> list3 = this.placeType;
                int hashCode8 = (hashCode7 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003;
                String str12 = this.address;
                int hashCode9 = (((hashCode8 ^ (str12 == null ? 0 : str12.hashCode())) * 1000003) ^ Arrays.hashCode(this.rawCenter)) * 1000003;
                List<CarmenContext> list4 = this.context;
                int hashCode10 = (hashCode9 ^ (list4 == null ? 0 : list4.hashCode())) * 1000003;
                Double d2 = this.relevance;
                int hashCode11 = (hashCode10 ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
                String str13 = this.matchingText;
                int hashCode12 = (hashCode11 ^ (str13 == null ? 0 : str13.hashCode())) * 1000003;
                String str14 = this.matchingPlaceName;
                int hashCode13 = (hashCode12 ^ (str14 == null ? 0 : str14.hashCode())) * 1000003;
                String str15 = this.language;
                return hashCode13 ^ (str15 != null ? str15.hashCode() : 0);
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.CarmenFeature
            public CarmenFeature.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.geocoding.v5.models.$AutoValue_CarmenFeature$Builder */
            static class Builder extends CarmenFeature.Builder {
                private String address;
                private BoundingBox bbox;
                private List<CarmenContext> context;
                private Geometry geometry;

                /* renamed from: id */
                private String f2694id;
                private String language;
                private String matchingPlaceName;
                private String matchingText;
                private String placeName;
                private List<String> placeType;
                private JsonObject properties;
                private double[] rawCenter;
                private Double relevance;
                private String text;
                private String type;

                Builder() {
                }

                private Builder(CarmenFeature carmenFeature) {
                    this.type = carmenFeature.type();
                    this.bbox = carmenFeature.bbox();
                    this.f2694id = carmenFeature.mo1748id();
                    this.geometry = carmenFeature.geometry();
                    this.properties = carmenFeature.properties();
                    this.text = carmenFeature.text();
                    this.placeName = carmenFeature.placeName();
                    this.placeType = carmenFeature.placeType();
                    this.address = carmenFeature.address();
                    this.rawCenter = carmenFeature.rawCenter();
                    this.context = carmenFeature.context();
                    this.relevance = carmenFeature.relevance();
                    this.matchingText = carmenFeature.matchingText();
                    this.matchingPlaceName = carmenFeature.matchingPlaceName();
                    this.language = carmenFeature.language();
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                CarmenFeature.Builder type(String str) {
                    Objects.requireNonNull(str, "Null type");
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder bbox(BoundingBox boundingBox) {
                    this.bbox = boundingBox;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                /* renamed from: id */
                public CarmenFeature.Builder mo1749id(String str) {
                    this.f2694id = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder geometry(Geometry geometry) {
                    this.geometry = geometry;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder properties(JsonObject jsonObject) {
                    this.properties = jsonObject;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder text(String str) {
                    this.text = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder placeName(String str) {
                    this.placeName = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder placeType(List<String> list) {
                    this.placeType = list;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder address(String str) {
                    this.address = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder rawCenter(double[] dArr) {
                    this.rawCenter = dArr;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder context(List<CarmenContext> list) {
                    this.context = list;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder relevance(Double d) {
                    this.relevance = d;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder matchingText(String str) {
                    this.matchingText = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder matchingPlaceName(String str) {
                    this.matchingPlaceName = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature.Builder language(String str) {
                    this.language = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenFeature.Builder
                public CarmenFeature build() {
                    String str = this.type == null ? " type" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_CarmenFeature(this.type, this.bbox, this.f2694id, this.geometry, this.properties, this.text, this.placeName, this.placeType, this.address, this.rawCenter, this.context, this.relevance, this.matchingText, this.matchingPlaceName, this.language);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<CarmenFeature> {
        private volatile TypeAdapter<double[]> array__double_adapter;
        private volatile TypeAdapter<BoundingBox> boundingBox_adapter;
        private volatile TypeAdapter<Double> double__adapter;
        private volatile TypeAdapter<Geometry> geometry_adapter;
        private final Gson gson;
        private volatile TypeAdapter<JsonObject> jsonObject_adapter;
        private volatile TypeAdapter<List<CarmenContext>> list__carmenContext_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, CarmenFeature carmenFeature) throws IOException {
            if (carmenFeature == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("type");
            if (carmenFeature.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, carmenFeature.type());
            }
            jsonWriter.name("bbox");
            if (carmenFeature.bbox() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BoundingBox> typeAdapter2 = this.boundingBox_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(BoundingBox.class);
                    this.boundingBox_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, carmenFeature.bbox());
            }
            jsonWriter.name(TtmlNode.ATTR_ID);
            if (carmenFeature.mo1748id() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, carmenFeature.mo1748id());
            }
            jsonWriter.name("geometry");
            if (carmenFeature.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Geometry> typeAdapter4 = this.geometry_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Geometry.class);
                    this.geometry_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, carmenFeature.geometry());
            }
            jsonWriter.name(StringLookupFactory.KEY_PROPERTIES);
            if (carmenFeature.properties() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<JsonObject> typeAdapter5 = this.jsonObject_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(JsonObject.class);
                    this.jsonObject_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, carmenFeature.properties());
            }
            jsonWriter.name("text");
            if (carmenFeature.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, carmenFeature.text());
            }
            jsonWriter.name("place_name");
            if (carmenFeature.placeName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter7 = this.string_adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, carmenFeature.placeName());
            }
            jsonWriter.name("place_type");
            if (carmenFeature.placeType() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter8 = this.list__string_adapter;
                if (typeAdapter8 == null) {
                    typeAdapter8 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter8;
                }
                typeAdapter8.write(jsonWriter, carmenFeature.placeType());
            }
            jsonWriter.name(GeocodingCriteria.TYPE_ADDRESS);
            if (carmenFeature.address() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter9 = this.string_adapter;
                if (typeAdapter9 == null) {
                    typeAdapter9 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter9;
                }
                typeAdapter9.write(jsonWriter, carmenFeature.address());
            }
            jsonWriter.name("center");
            if (carmenFeature.rawCenter() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<double[]> typeAdapter10 = this.array__double_adapter;
                if (typeAdapter10 == null) {
                    typeAdapter10 = this.gson.getAdapter(double[].class);
                    this.array__double_adapter = typeAdapter10;
                }
                typeAdapter10.write(jsonWriter, carmenFeature.rawCenter());
            }
            jsonWriter.name("context");
            if (carmenFeature.context() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<CarmenContext>> typeAdapter11 = this.list__carmenContext_adapter;
                if (typeAdapter11 == null) {
                    typeAdapter11 = this.gson.getAdapter(TypeToken.getParameterized(List.class, CarmenContext.class));
                    this.list__carmenContext_adapter = typeAdapter11;
                }
                typeAdapter11.write(jsonWriter, carmenFeature.context());
            }
            jsonWriter.name("relevance");
            if (carmenFeature.relevance() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter12 = this.double__adapter;
                if (typeAdapter12 == null) {
                    typeAdapter12 = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter12;
                }
                typeAdapter12.write(jsonWriter, carmenFeature.relevance());
            }
            jsonWriter.name("matching_text");
            if (carmenFeature.matchingText() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter13 = this.string_adapter;
                if (typeAdapter13 == null) {
                    typeAdapter13 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter13;
                }
                typeAdapter13.write(jsonWriter, carmenFeature.matchingText());
            }
            jsonWriter.name("matching_place_name");
            if (carmenFeature.matchingPlaceName() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter14 = this.string_adapter;
                if (typeAdapter14 == null) {
                    typeAdapter14 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter14;
                }
                typeAdapter14.write(jsonWriter, carmenFeature.matchingPlaceName());
            }
            jsonWriter.name(IjkMediaMeta.IJKM_KEY_LANGUAGE);
            if (carmenFeature.language() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter15 = this.string_adapter;
                if (typeAdapter15 == null) {
                    typeAdapter15 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter15;
                }
                typeAdapter15.write(jsonWriter, carmenFeature.language());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public CarmenFeature read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            CarmenFeature.Builder builder = CarmenFeature.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "center":
                            TypeAdapter<double[]> typeAdapter = this.array__double_adapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(double[].class);
                                this.array__double_adapter = typeAdapter;
                            }
                            builder.rawCenter(typeAdapter.read(jsonReader));
                            break;
                        case "matching_text":
                            TypeAdapter<String> typeAdapter2 = this.string_adapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter2;
                            }
                            builder.matchingText(typeAdapter2.read(jsonReader));
                            break;
                        case "matching_place_name":
                            TypeAdapter<String> typeAdapter3 = this.string_adapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter3;
                            }
                            builder.matchingPlaceName(typeAdapter3.read(jsonReader));
                            break;
                        case "place_name":
                            TypeAdapter<String> typeAdapter4 = this.string_adapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter4;
                            }
                            builder.placeName(typeAdapter4.read(jsonReader));
                            break;
                        case "place_type":
                            TypeAdapter<List<String>> typeAdapter5 = this.list__string_adapter;
                            if (typeAdapter5 == null) {
                                typeAdapter5 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                                this.list__string_adapter = typeAdapter5;
                            }
                            builder.placeType(typeAdapter5.read(jsonReader));
                            break;
                        case "type":
                            TypeAdapter<String> typeAdapter6 = this.string_adapter;
                            if (typeAdapter6 == null) {
                                typeAdapter6 = this.gson.getAdapter(String.class);
                                this.string_adapter = typeAdapter6;
                            }
                            builder.type(typeAdapter6.read(jsonReader));
                            break;
                        default:
                            if ("bbox".equals(nextName)) {
                                TypeAdapter<BoundingBox> typeAdapter7 = this.boundingBox_adapter;
                                if (typeAdapter7 == null) {
                                    typeAdapter7 = this.gson.getAdapter(BoundingBox.class);
                                    this.boundingBox_adapter = typeAdapter7;
                                }
                                builder.bbox(typeAdapter7.read(jsonReader));
                                break;
                            } else if (TtmlNode.ATTR_ID.equals(nextName)) {
                                TypeAdapter<String> typeAdapter8 = this.string_adapter;
                                if (typeAdapter8 == null) {
                                    typeAdapter8 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter8;
                                }
                                builder.mo1749id(typeAdapter8.read(jsonReader));
                                break;
                            } else if ("geometry".equals(nextName)) {
                                TypeAdapter<Geometry> typeAdapter9 = this.geometry_adapter;
                                if (typeAdapter9 == null) {
                                    typeAdapter9 = this.gson.getAdapter(Geometry.class);
                                    this.geometry_adapter = typeAdapter9;
                                }
                                builder.geometry(typeAdapter9.read(jsonReader));
                                break;
                            } else if (StringLookupFactory.KEY_PROPERTIES.equals(nextName)) {
                                TypeAdapter<JsonObject> typeAdapter10 = this.jsonObject_adapter;
                                if (typeAdapter10 == null) {
                                    typeAdapter10 = this.gson.getAdapter(JsonObject.class);
                                    this.jsonObject_adapter = typeAdapter10;
                                }
                                builder.properties(typeAdapter10.read(jsonReader));
                                break;
                            } else if ("text".equals(nextName)) {
                                TypeAdapter<String> typeAdapter11 = this.string_adapter;
                                if (typeAdapter11 == null) {
                                    typeAdapter11 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter11;
                                }
                                builder.text(typeAdapter11.read(jsonReader));
                                break;
                            } else if (GeocodingCriteria.TYPE_ADDRESS.equals(nextName)) {
                                TypeAdapter<String> typeAdapter12 = this.string_adapter;
                                if (typeAdapter12 == null) {
                                    typeAdapter12 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter12;
                                }
                                builder.address(typeAdapter12.read(jsonReader));
                                break;
                            } else if ("context".equals(nextName)) {
                                TypeAdapter<List<CarmenContext>> typeAdapter13 = this.list__carmenContext_adapter;
                                if (typeAdapter13 == null) {
                                    typeAdapter13 = this.gson.getAdapter(TypeToken.getParameterized(List.class, CarmenContext.class));
                                    this.list__carmenContext_adapter = typeAdapter13;
                                }
                                builder.context(typeAdapter13.read(jsonReader));
                                break;
                            } else if ("relevance".equals(nextName)) {
                                TypeAdapter<Double> typeAdapter14 = this.double__adapter;
                                if (typeAdapter14 == null) {
                                    typeAdapter14 = this.gson.getAdapter(Double.class);
                                    this.double__adapter = typeAdapter14;
                                }
                                builder.relevance(typeAdapter14.read(jsonReader));
                                break;
                            } else if (IjkMediaMeta.IJKM_KEY_LANGUAGE.equals(nextName)) {
                                TypeAdapter<String> typeAdapter15 = this.string_adapter;
                                if (typeAdapter15 == null) {
                                    typeAdapter15 = this.gson.getAdapter(String.class);
                                    this.string_adapter = typeAdapter15;
                                }
                                builder.language(typeAdapter15.read(jsonReader));
                                break;
                            } else {
                                jsonReader.skipValue();
                                break;
                            }
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(CarmenFeature)";
        }
    }
}