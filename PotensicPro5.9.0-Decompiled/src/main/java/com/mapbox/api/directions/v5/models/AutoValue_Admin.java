package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.SerializedName;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.Admin;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_Admin extends C$AutoValue_Admin {
    AutoValue_Admin(Map<String, SerializableJsonElement> map, String str, String str2) {
        new Admin(map, str, str2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_Admin
            private final String countryCode;
            private final String countryCodeAlpha3;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.countryCode = str;
                this.countryCodeAlpha3 = str2;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.Admin
            @SerializedName("iso_3166_1")
            public String countryCode() {
                return this.countryCode;
            }

            @Override // com.mapbox.api.directions.v5.models.Admin
            @SerializedName("iso_3166_1_alpha3")
            public String countryCodeAlpha3() {
                return this.countryCodeAlpha3;
            }

            public String toString() {
                return "Admin{unrecognized=" + this.unrecognized + ", countryCode=" + this.countryCode + ", countryCodeAlpha3=" + this.countryCodeAlpha3 + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof Admin)) {
                    return false;
                }
                Admin admin = (Admin) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(admin.unrecognized()) : admin.unrecognized() == null) {
                    String str3 = this.countryCode;
                    if (str3 != null ? str3.equals(admin.countryCode()) : admin.countryCode() == null) {
                        String str4 = this.countryCodeAlpha3;
                        if (str4 == null) {
                            if (admin.countryCodeAlpha3() == null) {
                                return true;
                            }
                        } else if (str4.equals(admin.countryCodeAlpha3())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                String str3 = this.countryCode;
                int hashCode2 = (hashCode ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                String str4 = this.countryCodeAlpha3;
                return hashCode2 ^ (str4 != null ? str4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.v5.models.Admin
            public Admin.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_Admin$Builder */
            static class Builder extends Admin.Builder {
                private String countryCode;
                private String countryCodeAlpha3;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ Admin.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(Admin admin) {
                    this.unrecognized = admin.unrecognized();
                    this.countryCode = admin.countryCode();
                    this.countryCodeAlpha3 = admin.countryCodeAlpha3();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                Admin.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Admin.Builder
                public Admin.Builder countryCode(String str) {
                    this.countryCode = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Admin.Builder
                public Admin.Builder countryCodeAlpha3(String str) {
                    this.countryCodeAlpha3 = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.Admin.Builder
                public Admin build() {
                    return new AutoValue_Admin(this.unrecognized, this.countryCode, this.countryCodeAlpha3);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<Admin> {
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Admin admin) throws IOException {
            if (admin == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (admin.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : admin.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("iso_3166_1");
            if (admin.countryCode() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, admin.countryCode());
            }
            jsonWriter.name("iso_3166_1_alpha3");
            if (admin.countryCodeAlpha3() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, admin.countryCodeAlpha3());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Admin read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            Admin.Builder builder = Admin.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if (nextName.equals("iso_3166_1")) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.countryCode(typeAdapter.read2(jsonReader));
                    } else if (nextName.equals("iso_3166_1_alpha3")) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.countryCodeAlpha3(typeAdapter2.read2(jsonReader));
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
            return "TypeAdapter(Admin)";
        }
    }
}
