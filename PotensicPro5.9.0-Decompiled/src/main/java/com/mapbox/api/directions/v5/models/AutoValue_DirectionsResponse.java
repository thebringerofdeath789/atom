package com.mapbox.api.directions.v5.models;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.DirectionsResponse;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_DirectionsResponse extends C$AutoValue_DirectionsResponse {
    AutoValue_DirectionsResponse(Map<String, SerializableJsonElement> map, String str, String str2, List<DirectionsWaypoint> list, List<DirectionsRoute> list2, String str3, Metadata metadata) {
        new DirectionsResponse(map, str, str2, list, list2, str3, metadata) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsResponse
            private final String code;
            private final String message;
            private final Metadata metadata;
            private final List<DirectionsRoute> routes;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final String uuid;
            private final List<DirectionsWaypoint> waypoints;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null code");
                this.code = str;
                this.message = str2;
                this.waypoints = list;
                Objects.requireNonNull(list2, "Null routes");
                this.routes = list2;
                this.uuid = str3;
                this.metadata = metadata;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public String code() {
                return this.code;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public String message() {
                return this.message;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public List<DirectionsWaypoint> waypoints() {
                return this.waypoints;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public List<DirectionsRoute> routes() {
                return this.routes;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public String uuid() {
                return this.uuid;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public Metadata metadata() {
                return this.metadata;
            }

            public String toString() {
                return "DirectionsResponse{unrecognized=" + this.unrecognized + ", code=" + this.code + ", message=" + this.message + ", waypoints=" + this.waypoints + ", routes=" + this.routes + ", uuid=" + this.uuid + ", metadata=" + this.metadata + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str4;
                List<DirectionsWaypoint> list3;
                String str5;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof DirectionsResponse)) {
                    return false;
                }
                DirectionsResponse directionsResponse = (DirectionsResponse) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(directionsResponse.unrecognized()) : directionsResponse.unrecognized() == null) {
                    if (this.code.equals(directionsResponse.code()) && ((str4 = this.message) != null ? str4.equals(directionsResponse.message()) : directionsResponse.message() == null) && ((list3 = this.waypoints) != null ? list3.equals(directionsResponse.waypoints()) : directionsResponse.waypoints() == null) && this.routes.equals(directionsResponse.routes()) && ((str5 = this.uuid) != null ? str5.equals(directionsResponse.uuid()) : directionsResponse.uuid() == null)) {
                        Metadata metadata2 = this.metadata;
                        if (metadata2 == null) {
                            if (directionsResponse.metadata() == null) {
                                return true;
                            }
                        } else if (metadata2.equals(directionsResponse.metadata())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.code.hashCode()) * 1000003;
                String str4 = this.message;
                int hashCode2 = (hashCode ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                List<DirectionsWaypoint> list3 = this.waypoints;
                int hashCode3 = (((hashCode2 ^ (list3 == null ? 0 : list3.hashCode())) * 1000003) ^ this.routes.hashCode()) * 1000003;
                String str5 = this.uuid;
                int hashCode4 = (hashCode3 ^ (str5 == null ? 0 : str5.hashCode())) * 1000003;
                Metadata metadata2 = this.metadata;
                return hashCode4 ^ (metadata2 != null ? metadata2.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsResponse
            public DirectionsResponse.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_DirectionsResponse$Builder */
            static class Builder extends DirectionsResponse.Builder {
                private String code;
                private String message;
                private Metadata metadata;
                private List<DirectionsRoute> routes;
                private Map<String, SerializableJsonElement> unrecognized;
                private String uuid;
                private List<DirectionsWaypoint> waypoints;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ DirectionsResponse.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(DirectionsResponse directionsResponse) {
                    this.unrecognized = directionsResponse.unrecognized();
                    this.code = directionsResponse.code();
                    this.message = directionsResponse.message();
                    this.waypoints = directionsResponse.waypoints();
                    this.routes = directionsResponse.routes();
                    this.uuid = directionsResponse.uuid();
                    this.metadata = directionsResponse.metadata();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                DirectionsResponse.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder code(String str) {
                    Objects.requireNonNull(str, "Null code");
                    this.code = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder message(String str) {
                    this.message = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder waypoints(List<DirectionsWaypoint> list) {
                    this.waypoints = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder routes(List<DirectionsRoute> list) {
                    Objects.requireNonNull(list, "Null routes");
                    this.routes = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                List<DirectionsRoute> routes() {
                    List<DirectionsRoute> list = this.routes;
                    if (list != null) {
                        return list;
                    }
                    throw new IllegalStateException("Property \"routes\" has not been set");
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder uuid(String str) {
                    this.uuid = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                String uuid() {
                    return this.uuid;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                public DirectionsResponse.Builder metadata(Metadata metadata) {
                    this.metadata = metadata;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsResponse.Builder
                DirectionsResponse autoBuild() {
                    String str = this.code == null ? " code" : "";
                    if (this.routes == null) {
                        str = str + " routes";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_DirectionsResponse(this.unrecognized, this.code, this.message, this.waypoints, this.routes, this.uuid, this.metadata);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<DirectionsResponse> {
        private final Gson gson;
        private volatile TypeAdapter<List<DirectionsRoute>> list__directionsRoute_adapter;
        private volatile TypeAdapter<List<DirectionsWaypoint>> list__directionsWaypoint_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<Metadata> metadata_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, DirectionsResponse directionsResponse) throws IOException {
            if (directionsResponse == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (directionsResponse.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : directionsResponse.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("code");
            if (directionsResponse.code() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, directionsResponse.code());
            }
            jsonWriter.name("message");
            if (directionsResponse.message() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, directionsResponse.message());
            }
            jsonWriter.name("waypoints");
            if (directionsResponse.waypoints() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsWaypoint>> typeAdapter3 = this.list__directionsWaypoint_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                    this.list__directionsWaypoint_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, directionsResponse.waypoints());
            }
            jsonWriter.name("routes");
            if (directionsResponse.routes() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<DirectionsRoute>> typeAdapter4 = this.list__directionsRoute_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                    this.list__directionsRoute_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, directionsResponse.routes());
            }
            jsonWriter.name("uuid");
            if (directionsResponse.uuid() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter5 = this.string_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, directionsResponse.uuid());
            }
            jsonWriter.name(TtmlNode.TAG_METADATA);
            if (directionsResponse.metadata() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Metadata> typeAdapter6 = this.metadata_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(Metadata.class);
                    this.metadata_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, directionsResponse.metadata());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public DirectionsResponse read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            DirectionsResponse.Builder builder = DirectionsResponse.builder();
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
                    } else if ("waypoints".equals(nextName)) {
                        TypeAdapter<List<DirectionsWaypoint>> typeAdapter3 = this.list__directionsWaypoint_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsWaypoint.class));
                            this.list__directionsWaypoint_adapter = typeAdapter3;
                        }
                        builder.waypoints(typeAdapter3.read2(jsonReader));
                    } else if ("routes".equals(nextName)) {
                        TypeAdapter<List<DirectionsRoute>> typeAdapter4 = this.list__directionsRoute_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(TypeToken.getParameterized(List.class, DirectionsRoute.class));
                            this.list__directionsRoute_adapter = typeAdapter4;
                        }
                        builder.routes(typeAdapter4.read2(jsonReader));
                    } else if ("uuid".equals(nextName)) {
                        TypeAdapter<String> typeAdapter5 = this.string_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter5;
                        }
                        builder.uuid(typeAdapter5.read2(jsonReader));
                    } else if (TtmlNode.TAG_METADATA.equals(nextName)) {
                        TypeAdapter<Metadata> typeAdapter6 = this.metadata_adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(Metadata.class);
                            this.metadata_adapter = typeAdapter6;
                        }
                        builder.metadata(typeAdapter6.read2(jsonReader));
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
            return "TypeAdapter(DirectionsResponse)";
        }
    }
}
