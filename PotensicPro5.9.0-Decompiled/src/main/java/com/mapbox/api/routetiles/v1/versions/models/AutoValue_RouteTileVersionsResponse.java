package com.mapbox.api.routetiles.v1.versions.models;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_RouteTileVersionsResponse extends C$AutoValue_RouteTileVersionsResponse {
    AutoValue_RouteTileVersionsResponse(final List<String> list) {
        new RouteTileVersionsResponse(list) { // from class: com.mapbox.api.routetiles.v1.versions.models.$AutoValue_RouteTileVersionsResponse
            private final List<String> availableVersions;

            {
                Objects.requireNonNull(list, "Null availableVersions");
                this.availableVersions = list;
            }

            @Override // com.mapbox.api.routetiles.v1.versions.models.RouteTileVersionsResponse
            public List<String> availableVersions() {
                return this.availableVersions;
            }

            public String toString() {
                return "RouteTileVersionsResponse{availableVersions=" + this.availableVersions + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (obj instanceof RouteTileVersionsResponse) {
                    return this.availableVersions.equals(((RouteTileVersionsResponse) obj).availableVersions());
                }
                return false;
            }

            public int hashCode() {
                return this.availableVersions.hashCode() ^ 1000003;
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<RouteTileVersionsResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<String>> list__string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, RouteTileVersionsResponse routeTileVersionsResponse) throws IOException {
            if (routeTileVersionsResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("availableVersions");
            if (routeTileVersionsResponse.availableVersions() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<String>> typeAdapter = this.list__string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                    this.list__string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, routeTileVersionsResponse.availableVersions());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public RouteTileVersionsResponse read2(JsonReader jsonReader) throws IOException {
            List<String> list = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("availableVersions".equals(nextName)) {
                        TypeAdapter<List<String>> typeAdapter = this.list__string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(TypeToken.getParameterized(List.class, String.class));
                            this.list__string_adapter = typeAdapter;
                        }
                        list = typeAdapter.read2(jsonReader);
                    } else {
                        jsonReader.skipValue();
                    }
                }
            }
            jsonReader.endObject();
            return new AutoValue_RouteTileVersionsResponse(list);
        }

        public String toString() {
            return "TypeAdapter(RouteTileVersionsResponse)";
        }
    }
}
