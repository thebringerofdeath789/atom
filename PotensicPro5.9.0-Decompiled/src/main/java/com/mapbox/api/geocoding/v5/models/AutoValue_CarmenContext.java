package com.mapbox.api.geocoding.v5.models;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.geocoding.v5.models.CarmenContext;
import java.io.IOException;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_CarmenContext extends C$AutoValue_CarmenContext {
    AutoValue_CarmenContext(String str, String str2, String str3, String str4, String str5, String str6) {
        new CarmenContext(str, str2, str3, str4, str5, str6) { // from class: com.mapbox.api.geocoding.v5.models.$AutoValue_CarmenContext
            private final String category;
            private final String id;
            private final String maki;
            private final String shortCode;
            private final String text;
            private final String wikidata;

            {
                this.id = str;
                this.text = str2;
                this.shortCode = str3;
                this.wikidata = str4;
                this.category = str5;
                this.maki = str6;
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            public String id() {
                return this.id;
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            public String text() {
                return this.text;
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            @SerializedName("short_code")
            public String shortCode() {
                return this.shortCode;
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            public String wikidata() {
                return this.wikidata;
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            public String category() {
                return this.category;
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            public String maki() {
                return this.maki;
            }

            public String toString() {
                return "CarmenContext{id=" + this.id + ", text=" + this.text + ", shortCode=" + this.shortCode + ", wikidata=" + this.wikidata + ", category=" + this.category + ", maki=" + this.maki + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof CarmenContext)) {
                    return false;
                }
                CarmenContext carmenContext = (CarmenContext) obj;
                String str7 = this.id;
                if (str7 != null ? str7.equals(carmenContext.id()) : carmenContext.id() == null) {
                    String str8 = this.text;
                    if (str8 != null ? str8.equals(carmenContext.text()) : carmenContext.text() == null) {
                        String str9 = this.shortCode;
                        if (str9 != null ? str9.equals(carmenContext.shortCode()) : carmenContext.shortCode() == null) {
                            String str10 = this.wikidata;
                            if (str10 != null ? str10.equals(carmenContext.wikidata()) : carmenContext.wikidata() == null) {
                                String str11 = this.category;
                                if (str11 != null ? str11.equals(carmenContext.category()) : carmenContext.category() == null) {
                                    String str12 = this.maki;
                                    if (str12 == null) {
                                        if (carmenContext.maki() == null) {
                                            return true;
                                        }
                                    } else if (str12.equals(carmenContext.maki())) {
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
                String str7 = this.id;
                int hashCode = ((str7 == null ? 0 : str7.hashCode()) ^ 1000003) * 1000003;
                String str8 = this.text;
                int hashCode2 = (hashCode ^ (str8 == null ? 0 : str8.hashCode())) * 1000003;
                String str9 = this.shortCode;
                int hashCode3 = (hashCode2 ^ (str9 == null ? 0 : str9.hashCode())) * 1000003;
                String str10 = this.wikidata;
                int hashCode4 = (hashCode3 ^ (str10 == null ? 0 : str10.hashCode())) * 1000003;
                String str11 = this.category;
                int hashCode5 = (hashCode4 ^ (str11 == null ? 0 : str11.hashCode())) * 1000003;
                String str12 = this.maki;
                return hashCode5 ^ (str12 != null ? str12.hashCode() : 0);
            }

            @Override // com.mapbox.api.geocoding.v5.models.CarmenContext
            public CarmenContext.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.geocoding.v5.models.$AutoValue_CarmenContext$Builder */
            static class Builder extends CarmenContext.Builder {
                private String category;
                private String id;
                private String maki;
                private String shortCode;
                private String text;
                private String wikidata;

                Builder() {
                }

                private Builder(CarmenContext carmenContext) {
                    this.id = carmenContext.id();
                    this.text = carmenContext.text();
                    this.shortCode = carmenContext.shortCode();
                    this.wikidata = carmenContext.wikidata();
                    this.category = carmenContext.category();
                    this.maki = carmenContext.maki();
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext.Builder id(String str) {
                    this.id = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext.Builder text(String str) {
                    this.text = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext.Builder shortCode(String str) {
                    this.shortCode = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext.Builder wikidata(String str) {
                    this.wikidata = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext.Builder category(String str) {
                    this.category = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext.Builder maki(String str) {
                    this.maki = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.CarmenContext.Builder
                public CarmenContext build() {
                    return new AutoValue_CarmenContext(this.id, this.text, this.shortCode, this.wikidata, this.category, this.maki);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<CarmenContext> {
        private final Gson gson;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, CarmenContext carmenContext) throws IOException {
            if (carmenContext == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name(TtmlNode.ATTR_ID);
            if (carmenContext.id() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, carmenContext.id());
            }
            jsonWriter.name("text");
            if (carmenContext.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, carmenContext.text());
            }
            jsonWriter.name("short_code");
            if (carmenContext.shortCode() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, carmenContext.shortCode());
            }
            jsonWriter.name("wikidata");
            if (carmenContext.wikidata() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, carmenContext.wikidata());
            }
            jsonWriter.name("category");
            if (carmenContext.category() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, carmenContext.category());
            }
            jsonWriter.name("maki");
            if (carmenContext.maki() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter6 = this.string_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, carmenContext.maki());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public CarmenContext read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            CarmenContext.Builder builder = CarmenContext.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("short_code")) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.shortCode(typeAdapter.read2(jsonReader));
                    } else if (TtmlNode.ATTR_ID.equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.id(typeAdapter2.read2(jsonReader));
                    } else if ("text".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.string_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter3;
                        }
                        builder.text(typeAdapter3.read2(jsonReader));
                    } else if ("wikidata".equals(nextName)) {
                        TypeAdapter<String> typeAdapter4 = this.string_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter4;
                        }
                        builder.wikidata(typeAdapter4.read2(jsonReader));
                    } else if ("category".equals(nextName)) {
                        TypeAdapter<String> typeAdapter5 = this.string_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter5;
                        }
                        builder.category(typeAdapter5.read2(jsonReader));
                    } else if ("maki".equals(nextName)) {
                        TypeAdapter<String> typeAdapter6 = this.string_adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter6;
                        }
                        builder.maki(typeAdapter6.read2(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(CarmenContext)";
        }
    }
}
