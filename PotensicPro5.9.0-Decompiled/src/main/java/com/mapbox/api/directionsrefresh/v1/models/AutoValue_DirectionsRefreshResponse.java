package com.mapbox.api.directionsrefresh.v1.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_DirectionsRefreshResponse extends C$AutoValue_DirectionsRefreshResponse {
    AutoValue_DirectionsRefreshResponse(Map<String, SerializableJsonElement> map, String str, String str2, DirectionsRouteRefresh directionsRouteRefresh) {
        new DirectionsRefreshResponse(map, str, str2, directionsRouteRefresh) { // from class: com.mapbox.api.directionsrefresh.v1.models.$AutoValue_DirectionsRefreshResponse
            private final String code;
            private final String message;
            private final DirectionsRouteRefresh route;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null code");
                this.code = str;
                this.message = str2;
                this.route = directionsRouteRefresh;
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse
            public String message() {
                return this.message;
            }

            @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse
            public DirectionsRouteRefresh route() {
                return this.route;
            }

            public String toString() {
                return "DirectionsRefreshResponse{unrecognized=" + this.unrecognized + ", code=" + this.code + ", message=" + this.message + ", route=" + this.route + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str3;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsRefreshResponse)) {
                    return false;
                }
                DirectionsRefreshResponse directionsRefreshResponse = (DirectionsRefreshResponse) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(directionsRefreshResponse.unrecognized()) : directionsRefreshResponse.unrecognized() == null) {
                    if (this.code.equals(directionsRefreshResponse.code()) && ((str3 = this.message) != null ? str3.equals(directionsRefreshResponse.message()) : directionsRefreshResponse.message() == null)) {
                        DirectionsRouteRefresh directionsRouteRefresh2 = this.route;
                        if (directionsRouteRefresh2 == null) {
                            if (directionsRefreshResponse.route() == null) {
                                return true;
                            }
                        } else if (directionsRouteRefresh2.equals(directionsRefreshResponse.route())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.code.hashCode()) * 1000003;
                String str3 = this.message;
                int hashCode2 = (hashCode ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                DirectionsRouteRefresh directionsRouteRefresh2 = this.route;
                return hashCode2 ^ (directionsRouteRefresh2 != null ? directionsRouteRefresh2.hashCode() : 0);
            }

            /* renamed from: com.mapbox.api.directionsrefresh.v1.models.$AutoValue_DirectionsRefreshResponse$Builder */
            static class Builder extends DirectionsRefreshResponse.Builder {
                private String code;
                private String message;
                private DirectionsRouteRefresh route;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject.Builder
                /* bridge */ /* synthetic */ DirectionsRefreshResponse.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                DirectionsRefreshResponse.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse.Builder code(String str) {
                    Objects.requireNonNull(str, "Null code");
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse.Builder route(DirectionsRouteRefresh directionsRouteRefresh) {
                    this.route = directionsRouteRefresh;
                    return this;
                }

                @Override // com.mapbox.api.directionsrefresh.v1.models.DirectionsRefreshResponse.Builder
                public DirectionsRefreshResponse build() {
                    String str = this.code == null ? " code" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_DirectionsRefreshResponse(this.unrecognized, this.code, this.message, this.route);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsRefreshResponse> {
        private volatile TypeAdapter<DirectionsRouteRefresh> directionsRouteRefresh_adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsRefreshResponse directionsRefreshResponse) throws IOException {
            if (directionsRefreshResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (directionsRefreshResponse.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : directionsRefreshResponse.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("code");
            if (directionsRefreshResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, directionsRefreshResponse.code());
            }
            jsonWriter.name("message");
            if (directionsRefreshResponse.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, directionsRefreshResponse.message());
            }
            jsonWriter.name("route");
            if (directionsRefreshResponse.route() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<DirectionsRouteRefresh> typeAdapter3 = this.directionsRouteRefresh_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(DirectionsRouteRefresh.class);
                    this.directionsRouteRefresh_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, directionsRefreshResponse.route());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public DirectionsRefreshResponse read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsRefreshResponse.Builder builder = DirectionsRefreshResponse.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("code".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.code(typeAdapter.read2(jsonReader));
                    } else if ("message".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.message(typeAdapter2.read2(jsonReader));
                    } else if ("route".equals(nextName)) {
                        TypeAdapter<DirectionsRouteRefresh> typeAdapter3 = this.directionsRouteRefresh_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(DirectionsRouteRefresh.class);
                            this.directionsRouteRefresh_adapter = typeAdapter3;
                        }
                        builder.route(typeAdapter3.read2(jsonReader));
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
            return "TypeAdapter(DirectionsRefreshResponse)";
        }
    }
}
