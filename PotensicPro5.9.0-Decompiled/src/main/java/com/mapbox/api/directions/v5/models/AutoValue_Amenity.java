package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.Amenity;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Amenity extends C$AutoValue_Amenity {
    AutoValue_Amenity(Map<String, SerializableJsonElement> map, String str, String str2, String str3) {
        new Amenity(map, str, str2, str3) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_Amenity
            private final String brand;
            private final String name;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null type");
                this.type = str;
                this.name = str2;
                this.brand = str3;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.Amenity
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.v5.models.Amenity
            public String name() {
                return this.name;
            }

            @Override // com.mapbox.api.directions.v5.models.Amenity
            public String brand() {
                return this.brand;
            }

            public String toString() {
                return "Amenity{unrecognized=" + this.unrecognized + ", type=" + this.type + ", name=" + this.name + ", brand=" + this.brand + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                String str4;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Amenity)) {
                    return false;
                }
                Amenity amenity = (Amenity) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(amenity.unrecognized()) : amenity.unrecognized() == null) {
                    if (this.type.equals(amenity.type()) && ((str4 = this.name) != null ? str4.equals(amenity.name()) : amenity.name() == null)) {
                        String str5 = this.brand;
                        if (str5 == null) {
                            if (amenity.brand() == null) {
                                return true;
                            }
                        } else if (str5.equals(amenity.brand())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.type.hashCode()) * 1000003;
                String str4 = this.name;
                int hashCode2 = (hashCode ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                String str5 = this.brand;
                return hashCode2 ^ (str5 != null ? str5.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.Amenity
            public Amenity.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_Amenity$Builder */
            static class Builder extends Amenity.Builder {
                private String brand;
                private String name;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ Amenity.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(Amenity amenity) {
                    this.unrecognized = amenity.unrecognized();
                    this.type = amenity.type();
                    this.name = amenity.name();
                    this.brand = amenity.brand();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                Amenity.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Amenity.Builder
                public Amenity.Builder type(String str) {
                    Objects.requireNonNull(str, "Null type");
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Amenity.Builder
                public Amenity.Builder name(String str) {
                    this.name = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Amenity.Builder
                public Amenity.Builder brand(String str) {
                    this.brand = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Amenity.Builder
                public Amenity build() {
                    String str = this.type == null ? " type" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_Amenity(this.unrecognized, this.type, this.name, this.brand);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<Amenity> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Amenity amenity) throws IOException {
            if (amenity == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (amenity.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : amenity.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("type");
            if (amenity.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, amenity.type());
            }
            jsonWriter.name("name");
            if (amenity.name() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, amenity.name());
            }
            jsonWriter.name("brand");
            if (amenity.brand() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, amenity.brand());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Amenity read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Amenity.Builder builder = Amenity.builder();
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
                        builder.type(typeAdapter.read2(jsonReader));
                    } else if ("name".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.name(typeAdapter2.read2(jsonReader));
                    } else if ("brand".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.string_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter3;
                        }
                        builder.brand(typeAdapter3.read2(jsonReader));
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
            return "TypeAdapter(Amenity)";
        }
    }
}
