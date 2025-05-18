package com.mapbox.api.geocoding.p024v5.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.geocoding.p024v5.models.GeocodingResponse;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_GeocodingResponse extends C$AutoValue_GeocodingResponse {
    AutoValue_GeocodingResponse(final String str, final List<String> list, final List<CarmenFeature> list2, final String str2) {
        new GeocodingResponse(str, list, list2, str2) { // from class: com.mapbox.api.geocoding.v5.models.$AutoValue_GeocodingResponse
            private final String attribution;
            private final List<CarmenFeature> features;
            private final List<String> query;
            private final String type;

            {
                Objects.requireNonNull(str, "Null type");
                this.type = str;
                Objects.requireNonNull(list, "Null query");
                this.query = list;
                Objects.requireNonNull(list2, "Null features");
                this.features = list2;
                Objects.requireNonNull(str2, "Null attribution");
                this.attribution = str2;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.GeocodingResponse
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.GeocodingResponse
            public List<String> query() {
                return this.query;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.GeocodingResponse
            public List<CarmenFeature> features() {
                return this.features;
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.GeocodingResponse
            public String attribution() {
                return this.attribution;
            }

            public String toString() {
                return "GeocodingResponse{type=" + this.type + ", query=" + this.query + ", features=" + this.features + ", attribution=" + this.attribution + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof GeocodingResponse)) {
                    return false;
                }
                GeocodingResponse geocodingResponse = (GeocodingResponse) obj;
                return this.type.equals(geocodingResponse.type()) && this.query.equals(geocodingResponse.query()) && this.features.equals(geocodingResponse.features()) && this.attribution.equals(geocodingResponse.attribution());
            }

            public int hashCode() {
                return ((((((this.type.hashCode() ^ 1000003) * 1000003) ^ this.query.hashCode()) * 1000003) ^ this.features.hashCode()) * 1000003) ^ this.attribution.hashCode();
            }

            @Override // com.mapbox.api.geocoding.p024v5.models.GeocodingResponse
            public GeocodingResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.geocoding.v5.models.$AutoValue_GeocodingResponse$Builder */
            static class Builder extends GeocodingResponse.Builder {
                private String attribution;
                private List<CarmenFeature> features;
                private List<String> query;
                private String type;

                Builder() {
                }

                private Builder(GeocodingResponse geocodingResponse) {
                    this.type = geocodingResponse.type();
                    this.query = geocodingResponse.query();
                    this.features = geocodingResponse.features();
                    this.attribution = geocodingResponse.attribution();
                }

                @Override // com.mapbox.api.geocoding.v5.models.GeocodingResponse.Builder
                GeocodingResponse.Builder type(String str) {
                    Objects.requireNonNull(str, "Null type");
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.GeocodingResponse.Builder
                public GeocodingResponse.Builder query(List<String> list) {
                    Objects.requireNonNull(list, "Null query");
                    this.query = list;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.GeocodingResponse.Builder
                public GeocodingResponse.Builder features(List<CarmenFeature> list) {
                    Objects.requireNonNull(list, "Null features");
                    this.features = list;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.GeocodingResponse.Builder
                public GeocodingResponse.Builder attribution(String str) {
                    Objects.requireNonNull(str, "Null attribution");
                    this.attribution = str;
                    return this;
                }

                @Override // com.mapbox.api.geocoding.v5.models.GeocodingResponse.Builder
                public GeocodingResponse build() {
                    String str = this.type == null ? " type" : "";
                    if (this.query == null) {
                        str = str + " query";
                    }
                    if (this.features == null) {
                        str = str + " features";
                    }
                    if (this.attribution == null) {
                        str = str + " attribution";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_GeocodingResponse(this.type, this.query, this.features, this.attribution);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<GeocodingResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<CarmenFeature>> list__carmenFeature_adapter;
        private volatile TypeAdapter<List<String>> list__string_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, GeocodingResponse geocodingResponse) throws IOException {
            if (geocodingResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("type");
            if (geocodingResponse.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, geocodingResponse.type());
            }
            jsonWriter.name("query");
            if (geocodingResponse.query() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter2 = this.list__string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, geocodingResponse.query());
            }
            jsonWriter.name("features");
            if (geocodingResponse.features() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<CarmenFeature>> typeAdapter3 = this.list__carmenFeature_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, CarmenFeature.class));
                    this.list__carmenFeature_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, geocodingResponse.features());
            }
            jsonWriter.name("attribution");
            if (geocodingResponse.attribution() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, geocodingResponse.attribution());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public GeocodingResponse read(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            GeocodingResponse.Builder builder = GeocodingResponse.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("type".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.type(typeAdapter.read(jsonReader));
                    } else if ("query".equals(nextName)) {
                        TypeAdapter<List<String>> typeAdapter2 = this.list__string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = typeAdapter2;
                        }
                        builder.query(typeAdapter2.read(jsonReader));
                    } else if ("features".equals(nextName)) {
                        TypeAdapter<List<CarmenFeature>> typeAdapter3 = this.list__carmenFeature_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, CarmenFeature.class));
                            this.list__carmenFeature_adapter = typeAdapter3;
                        }
                        builder.features(typeAdapter3.read(jsonReader));
                    } else if ("attribution".equals(nextName)) {
                        TypeAdapter<String> typeAdapter4 = this.string_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter4;
                        }
                        builder.attribution(typeAdapter4.read(jsonReader));
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return builder.build();
        }

        public String toString() {
            return "TypeAdapter(GeocodingResponse)";
        }
    }
}