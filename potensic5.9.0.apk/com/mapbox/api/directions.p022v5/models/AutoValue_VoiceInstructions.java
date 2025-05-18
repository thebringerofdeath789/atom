package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.VoiceInstructions;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.Map;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_VoiceInstructions extends C$AutoValue_VoiceInstructions {
    AutoValue_VoiceInstructions(final Map<String, SerializableJsonElement> map, final Double d, final String str, final String str2) {
        new VoiceInstructions(map, d, str, str2) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_VoiceInstructions
            private final String announcement;
            private final Double distanceAlongGeometry;
            private final String ssmlAnnouncement;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                this.distanceAlongGeometry = d;
                this.announcement = str;
                this.ssmlAnnouncement = str2;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.VoiceInstructions
            public Double distanceAlongGeometry() {
                return this.distanceAlongGeometry;
            }

            @Override // com.mapbox.api.directions.p022v5.models.VoiceInstructions
            public String announcement() {
                return this.announcement;
            }

            @Override // com.mapbox.api.directions.p022v5.models.VoiceInstructions
            public String ssmlAnnouncement() {
                return this.ssmlAnnouncement;
            }

            public String toString() {
                return "VoiceInstructions{unrecognized=" + this.unrecognized + ", distanceAlongGeometry=" + this.distanceAlongGeometry + ", announcement=" + this.announcement + ", ssmlAnnouncement=" + this.ssmlAnnouncement + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof VoiceInstructions)) {
                    return false;
                }
                VoiceInstructions voiceInstructions = (VoiceInstructions) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(voiceInstructions.unrecognized()) : voiceInstructions.unrecognized() == null) {
                    Double d2 = this.distanceAlongGeometry;
                    if (d2 != null ? d2.equals(voiceInstructions.distanceAlongGeometry()) : voiceInstructions.distanceAlongGeometry() == null) {
                        String str3 = this.announcement;
                        if (str3 != null ? str3.equals(voiceInstructions.announcement()) : voiceInstructions.announcement() == null) {
                            String str4 = this.ssmlAnnouncement;
                            if (str4 == null) {
                                if (voiceInstructions.ssmlAnnouncement() == null) {
                                    return true;
                                }
                            } else if (str4.equals(voiceInstructions.ssmlAnnouncement())) {
                                return true;
                            }
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003;
                Double d2 = this.distanceAlongGeometry;
                int hashCode2 = (hashCode ^ (d2 == null ? 0 : d2.hashCode())) * 1000003;
                String str3 = this.announcement;
                int hashCode3 = (hashCode2 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
                String str4 = this.ssmlAnnouncement;
                return hashCode3 ^ (str4 != null ? str4.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.VoiceInstructions
            public VoiceInstructions.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_VoiceInstructions$Builder */
            static class Builder extends VoiceInstructions.Builder {
                private String announcement;
                private Double distanceAlongGeometry;
                private String ssmlAnnouncement;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ VoiceInstructions.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(VoiceInstructions voiceInstructions) {
                    this.unrecognized = voiceInstructions.unrecognized();
                    this.distanceAlongGeometry = voiceInstructions.distanceAlongGeometry();
                    this.announcement = voiceInstructions.announcement();
                    this.ssmlAnnouncement = voiceInstructions.ssmlAnnouncement();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                VoiceInstructions.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.VoiceInstructions.Builder
                public VoiceInstructions.Builder distanceAlongGeometry(Double d) {
                    this.distanceAlongGeometry = d;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.VoiceInstructions.Builder
                public VoiceInstructions.Builder announcement(String str) {
                    this.announcement = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.VoiceInstructions.Builder
                public VoiceInstructions.Builder ssmlAnnouncement(String str) {
                    this.ssmlAnnouncement = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.VoiceInstructions.Builder
                public VoiceInstructions build() {
                    return new AutoValue_VoiceInstructions(this.unrecognized, this.distanceAlongGeometry, this.announcement, this.ssmlAnnouncement);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<VoiceInstructions> {
        private volatile TypeAdapter<Double> double__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, VoiceInstructions voiceInstructions) throws IOException {
            if (voiceInstructions == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (voiceInstructions.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : voiceInstructions.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("distanceAlongGeometry");
            if (voiceInstructions.distanceAlongGeometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Double> typeAdapter = this.double__adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Double.class);
                    this.double__adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, voiceInstructions.distanceAlongGeometry());
            }
            jsonWriter.name("announcement");
            if (voiceInstructions.announcement() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter2 = this.string_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, voiceInstructions.announcement());
            }
            jsonWriter.name("ssmlAnnouncement");
            if (voiceInstructions.ssmlAnnouncement() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, voiceInstructions.ssmlAnnouncement());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public VoiceInstructions read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            VoiceInstructions.Builder builder = VoiceInstructions.builder();
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
                        builder.distanceAlongGeometry(typeAdapter.read(jsonReader));
                    } else if ("announcement".equals(nextName)) {
                        TypeAdapter<String> typeAdapter2 = this.string_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter2;
                        }
                        builder.announcement(typeAdapter2.read(jsonReader));
                    } else if ("ssmlAnnouncement".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.string_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter3;
                        }
                        builder.ssmlAnnouncement(typeAdapter3.read(jsonReader));
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
            return "TypeAdapter(VoiceInstructions)";
        }
    }
}