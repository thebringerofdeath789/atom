package com.mapbox.api.directions.p022v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.p022v5.models.BannerView;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_BannerView extends C$AutoValue_BannerView {
    AutoValue_BannerView(final Map<String, SerializableJsonElement> map, final String str, final List<BannerComponents> list, final String str2, final String str3) {
        new BannerView(map, str, list, str2, str3) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_BannerView
            private final List<BannerComponents> components;
            private final String modifier;
            private final String text;
            private final String type;
            private final Map<String, SerializableJsonElement> unrecognized;

            {
                this.unrecognized = map;
                Objects.requireNonNull(str, "Null text");
                this.text = str;
                this.components = list;
                this.type = str2;
                this.modifier = str3;
            }

            @Override // com.mapbox.api.directions.p022v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerView
            public String text() {
                return this.text;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerView
            public List<BannerComponents> components() {
                return this.components;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerView
            public String type() {
                return this.type;
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerView
            public String modifier() {
                return this.modifier;
            }

            public String toString() {
                return "BannerView{unrecognized=" + this.unrecognized + ", text=" + this.text + ", components=" + this.components + ", type=" + this.type + ", modifier=" + this.modifier + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                List<BannerComponents> list2;
                String str4;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof BannerView)) {
                    return false;
                }
                BannerView bannerView = (BannerView) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(bannerView.unrecognized()) : bannerView.unrecognized() == null) {
                    if (this.text.equals(bannerView.text()) && ((list2 = this.components) != null ? list2.equals(bannerView.components()) : bannerView.components() == null) && ((str4 = this.type) != null ? str4.equals(bannerView.type()) : bannerView.type() == null)) {
                        String str5 = this.modifier;
                        if (str5 == null) {
                            if (bannerView.modifier() == null) {
                                return true;
                            }
                        } else if (str5.equals(bannerView.modifier())) {
                            return true;
                        }
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.text.hashCode()) * 1000003;
                List<BannerComponents> list2 = this.components;
                int hashCode2 = (hashCode ^ (list2 == null ? 0 : list2.hashCode())) * 1000003;
                String str4 = this.type;
                int hashCode3 = (hashCode2 ^ (str4 == null ? 0 : str4.hashCode())) * 1000003;
                String str5 = this.modifier;
                return hashCode3 ^ (str5 != null ? str5.hashCode() : 0);
            }

            @Override // com.mapbox.api.directions.p022v5.models.BannerView
            public BannerView.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_BannerView$Builder */
            static class Builder extends BannerView.Builder {
                private List<BannerComponents> components;
                private String modifier;
                private String text;
                private String type;
                private Map<String, SerializableJsonElement> unrecognized;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ BannerView.Builder unrecognized(Map map) {
                    return unrecognized((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(BannerView bannerView) {
                    this.unrecognized = bannerView.unrecognized();
                    this.text = bannerView.text();
                    this.components = bannerView.components();
                    this.type = bannerView.type();
                    this.modifier = bannerView.modifier();
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                BannerView.Builder unrecognized(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerView.Builder
                public BannerView.Builder text(String str) {
                    Objects.requireNonNull(str, "Null text");
                    this.text = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerView.Builder
                public BannerView.Builder components(List<BannerComponents> list) {
                    this.components = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerView.Builder
                public BannerView.Builder type(String str) {
                    this.type = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerView.Builder
                public BannerView.Builder modifier(String str) {
                    this.modifier = str;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.BannerView.Builder
                public BannerView build() {
                    String str = this.text == null ? " text" : "";
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_BannerView(this.unrecognized, this.text, this.components, this.type, this.modifier);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<BannerView> {
        private final Gson gson;
        private volatile TypeAdapter<List<BannerComponents>> list__bannerComponents_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;
        private volatile TypeAdapter<String> string_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, BannerView bannerView) throws IOException {
            if (bannerView == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (bannerView.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : bannerView.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("text");
            if (bannerView.text() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.string_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, bannerView.text());
            }
            jsonWriter.name("components");
            if (bannerView.components() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<BannerComponents>> typeAdapter2 = this.list__bannerComponents_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerComponents.class));
                    this.list__bannerComponents_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, bannerView.components());
            }
            jsonWriter.name("type");
            if (bannerView.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.string_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, bannerView.type());
            }
            jsonWriter.name("modifier");
            if (bannerView.modifier() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter4 = this.string_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(String.class);
                    this.string_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, bannerView.modifier());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        public BannerView read(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BannerView.Builder builder = BannerView.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("text".equals(nextName)) {
                        TypeAdapter<String> typeAdapter = this.string_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter;
                        }
                        builder.text(typeAdapter.read(jsonReader));
                    } else if ("components".equals(nextName)) {
                        TypeAdapter<List<BannerComponents>> typeAdapter2 = this.list__bannerComponents_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(TypeToken.getParameterized(List.class, BannerComponents.class));
                            this.list__bannerComponents_adapter = typeAdapter2;
                        }
                        builder.components(typeAdapter2.read(jsonReader));
                    } else if ("type".equals(nextName)) {
                        TypeAdapter<String> typeAdapter3 = this.string_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter3;
                        }
                        builder.type(typeAdapter3.read(jsonReader));
                    } else if ("modifier".equals(nextName)) {
                        TypeAdapter<String> typeAdapter4 = this.string_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(String.class);
                            this.string_adapter = typeAdapter4;
                        }
                        builder.modifier(typeAdapter4.read(jsonReader));
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
            return "TypeAdapter(BannerView)";
        }
    }
}