package com.mapbox.api.directions.v5.models;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.api.directions.v5.models.ShieldSpriteAttribute;
import com.mapbox.auto.value.gson.SerializableJsonElement;
import com.mapbox.mapboxsdk.style.layers.Property;
import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
final class AutoValue_ShieldSpriteAttribute extends C$AutoValue_ShieldSpriteAttribute {
    AutoValue_ShieldSpriteAttribute(Map<String, SerializableJsonElement> map, Integer num, Integer num2, Integer num3, Integer num4, Integer num5, List<Double> list, Boolean bool) {
        new ShieldSpriteAttribute(map, num, num2, num3, num4, num5, list, bool) { // from class: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSpriteAttribute
            private final Integer height;
            private final Integer pixelRatio;
            private final List<Double> placeholder;
            private final Map<String, SerializableJsonElement> unrecognized;
            private final Boolean visible;
            private final Integer width;
            private final Integer x;
            private final Integer y;

            {
                this.unrecognized = map;
                Objects.requireNonNull(num, "Null width");
                this.width = num;
                Objects.requireNonNull(num2, "Null height");
                this.height = num2;
                Objects.requireNonNull(num3, "Null x");
                this.x = num3;
                Objects.requireNonNull(num4, "Null y");
                this.y = num4;
                Objects.requireNonNull(num5, "Null pixelRatio");
                this.pixelRatio = num5;
                this.placeholder = list;
                Objects.requireNonNull(bool, "Null visible");
                this.visible = bool;
            }

            @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject
            Map<String, SerializableJsonElement> unrecognized() {
                return this.unrecognized;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public Integer width() {
                return this.width;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public Integer height() {
                return this.height;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public Integer x() {
                return this.x;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public Integer y() {
                return this.y;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public Integer pixelRatio() {
                return this.pixelRatio;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public List<Double> placeholder() {
                return this.placeholder;
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public Boolean visible() {
                return this.visible;
            }

            public String toString() {
                return "ShieldSpriteAttribute{unrecognized=" + this.unrecognized + ", width=" + this.width + ", height=" + this.height + ", x=" + this.x + ", y=" + this.y + ", pixelRatio=" + this.pixelRatio + ", placeholder=" + this.placeholder + ", visible=" + this.visible + StringSubstitutor.DEFAULT_VAR_END;
            }

            public boolean equals(Object obj) {
                List<Double> list2;
                if (obj == this) {
                    return true;
                }
                if (!(obj instanceof ShieldSpriteAttribute)) {
                    return false;
                }
                ShieldSpriteAttribute shieldSpriteAttribute = (ShieldSpriteAttribute) obj;
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                if (map2 != null ? map2.equals(shieldSpriteAttribute.unrecognized()) : shieldSpriteAttribute.unrecognized() == null) {
                    if (this.width.equals(shieldSpriteAttribute.width()) && this.height.equals(shieldSpriteAttribute.height()) && this.x.equals(shieldSpriteAttribute.x()) && this.y.equals(shieldSpriteAttribute.y()) && this.pixelRatio.equals(shieldSpriteAttribute.pixelRatio()) && ((list2 = this.placeholder) != null ? list2.equals(shieldSpriteAttribute.placeholder()) : shieldSpriteAttribute.placeholder() == null) && this.visible.equals(shieldSpriteAttribute.visible())) {
                        return true;
                    }
                }
                return false;
            }

            public int hashCode() {
                Map<String, SerializableJsonElement> map2 = this.unrecognized;
                int hashCode = ((((((((((((map2 == null ? 0 : map2.hashCode()) ^ 1000003) * 1000003) ^ this.width.hashCode()) * 1000003) ^ this.height.hashCode()) * 1000003) ^ this.x.hashCode()) * 1000003) ^ this.y.hashCode()) * 1000003) ^ this.pixelRatio.hashCode()) * 1000003;
                List<Double> list2 = this.placeholder;
                return ((hashCode ^ (list2 != null ? list2.hashCode() : 0)) * 1000003) ^ this.visible.hashCode();
            }

            @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute
            public ShieldSpriteAttribute.Builder toBuilder() {
                return new Builder(this);
            }

            /* renamed from: com.mapbox.api.directions.v5.models.$AutoValue_ShieldSpriteAttribute$Builder */
            static class Builder extends ShieldSpriteAttribute.Builder {
                private Integer height;
                private Integer pixelRatio;
                private List<Double> placeholder;
                private Map<String, SerializableJsonElement> unrecognized;
                private Boolean visible;
                private Integer width;
                private Integer x;
                private Integer y;

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* bridge */ /* synthetic */ ShieldSpriteAttribute.Builder unrecognized(Map map) {
                    return unrecognized2((Map<String, SerializableJsonElement>) map);
                }

                Builder() {
                }

                private Builder(ShieldSpriteAttribute shieldSpriteAttribute) {
                    this.unrecognized = shieldSpriteAttribute.unrecognized();
                    this.width = shieldSpriteAttribute.width();
                    this.height = shieldSpriteAttribute.height();
                    this.x = shieldSpriteAttribute.x();
                    this.y = shieldSpriteAttribute.y();
                    this.pixelRatio = shieldSpriteAttribute.pixelRatio();
                    this.placeholder = shieldSpriteAttribute.placeholder();
                    this.visible = shieldSpriteAttribute.visible();
                }

                @Override // com.mapbox.api.directions.v5.models.DirectionsJsonObject.Builder
                /* renamed from: unrecognized, reason: avoid collision after fix types in other method */
                ShieldSpriteAttribute.Builder unrecognized2(Map<String, SerializableJsonElement> map) {
                    this.unrecognized = map;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder width(Integer num) {
                    Objects.requireNonNull(num, "Null width");
                    this.width = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder height(Integer num) {
                    Objects.requireNonNull(num, "Null height");
                    this.height = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder x(Integer num) {
                    Objects.requireNonNull(num, "Null x");
                    this.x = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder y(Integer num) {
                    Objects.requireNonNull(num, "Null y");
                    this.y = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder pixelRatio(Integer num) {
                    Objects.requireNonNull(num, "Null pixelRatio");
                    this.pixelRatio = num;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder placeholder(List<Double> list) {
                    this.placeholder = list;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute.Builder visible(Boolean bool) {
                    Objects.requireNonNull(bool, "Null visible");
                    this.visible = bool;
                    return this;
                }

                @Override // com.mapbox.api.directions.v5.models.ShieldSpriteAttribute.Builder
                public ShieldSpriteAttribute build() {
                    String str = this.width == null ? " width" : "";
                    if (this.height == null) {
                        str = str + " height";
                    }
                    if (this.x == null) {
                        str = str + " x";
                    }
                    if (this.y == null) {
                        str = str + " y";
                    }
                    if (this.pixelRatio == null) {
                        str = str + " pixelRatio";
                    }
                    if (this.visible == null) {
                        str = str + " visible";
                    }
                    if (!str.isEmpty()) {
                        throw new IllegalStateException("Missing required properties:" + str);
                    }
                    return new AutoValue_ShieldSpriteAttribute(this.unrecognized, this.width, this.height, this.x, this.y, this.pixelRatio, this.placeholder, this.visible);
                }
            }
        };
    }

    static final class GsonTypeAdapter extends TypeAdapter<ShieldSpriteAttribute> {
        private volatile TypeAdapter<Boolean> boolean__adapter;
        private final Gson gson;
        private volatile TypeAdapter<Integer> integer_adapter;
        private volatile TypeAdapter<List<Double>> list__double_adapter;
        private volatile TypeAdapter<Map<String, SerializableJsonElement>> map__string_serializableJsonElement_adapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, ShieldSpriteAttribute shieldSpriteAttribute) throws IOException {
            if (shieldSpriteAttribute == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            if (shieldSpriteAttribute.unrecognized() != null) {
                for (Map.Entry<String, SerializableJsonElement> entry : shieldSpriteAttribute.unrecognized().entrySet()) {
                    jsonWriter.name(entry.getKey());
                    JsonElement element = entry.getValue().getElement();
                    this.gson.getAdapter(element.getClass()).write(jsonWriter, element);
                }
            }
            jsonWriter.name("width");
            if (shieldSpriteAttribute.width() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, shieldSpriteAttribute.width());
            }
            jsonWriter.name("height");
            if (shieldSpriteAttribute.height() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter2 = this.integer_adapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, shieldSpriteAttribute.height());
            }
            jsonWriter.name("x");
            if (shieldSpriteAttribute.x() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter3 = this.integer_adapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, shieldSpriteAttribute.x());
            }
            jsonWriter.name("y");
            if (shieldSpriteAttribute.y() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter4 = this.integer_adapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, shieldSpriteAttribute.y());
            }
            jsonWriter.name("pixelRatio");
            if (shieldSpriteAttribute.pixelRatio() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Integer> typeAdapter5 = this.integer_adapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(Integer.class);
                    this.integer_adapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, shieldSpriteAttribute.pixelRatio());
            }
            jsonWriter.name("placeholder");
            if (shieldSpriteAttribute.placeholder() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Double>> typeAdapter6 = this.list__double_adapter;
                if (typeAdapter6 == null) {
                    typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                    this.list__double_adapter = typeAdapter6;
                }
                typeAdapter6.write(jsonWriter, shieldSpriteAttribute.placeholder());
            }
            jsonWriter.name(Property.VISIBLE);
            if (shieldSpriteAttribute.visible() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Boolean> typeAdapter7 = this.boolean__adapter;
                if (typeAdapter7 == null) {
                    typeAdapter7 = this.gson.getAdapter(Boolean.class);
                    this.boolean__adapter = typeAdapter7;
                }
                typeAdapter7.write(jsonWriter, shieldSpriteAttribute.visible());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public ShieldSpriteAttribute read2(JsonReader jsonReader) throws IOException {
            LinkedHashMap linkedHashMap = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            ShieldSpriteAttribute.Builder builder = ShieldSpriteAttribute.builder();
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    if ("width".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter = this.integer_adapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter;
                        }
                        builder.width(typeAdapter.read2(jsonReader));
                    } else if ("height".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter2 = this.integer_adapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter2;
                        }
                        builder.height(typeAdapter2.read2(jsonReader));
                    } else if ("x".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter3 = this.integer_adapter;
                        if (typeAdapter3 == null) {
                            typeAdapter3 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter3;
                        }
                        builder.x(typeAdapter3.read2(jsonReader));
                    } else if ("y".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter4 = this.integer_adapter;
                        if (typeAdapter4 == null) {
                            typeAdapter4 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter4;
                        }
                        builder.y(typeAdapter4.read2(jsonReader));
                    } else if ("pixelRatio".equals(nextName)) {
                        TypeAdapter<Integer> typeAdapter5 = this.integer_adapter;
                        if (typeAdapter5 == null) {
                            typeAdapter5 = this.gson.getAdapter(Integer.class);
                            this.integer_adapter = typeAdapter5;
                        }
                        builder.pixelRatio(typeAdapter5.read2(jsonReader));
                    } else if ("placeholder".equals(nextName)) {
                        TypeAdapter<List<Double>> typeAdapter6 = this.list__double_adapter;
                        if (typeAdapter6 == null) {
                            typeAdapter6 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Double.class));
                            this.list__double_adapter = typeAdapter6;
                        }
                        builder.placeholder(typeAdapter6.read2(jsonReader));
                    } else if (Property.VISIBLE.equals(nextName)) {
                        TypeAdapter<Boolean> typeAdapter7 = this.boolean__adapter;
                        if (typeAdapter7 == null) {
                            typeAdapter7 = this.gson.getAdapter(Boolean.class);
                            this.boolean__adapter = typeAdapter7;
                        }
                        builder.visible(typeAdapter7.read2(jsonReader));
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
            return "TypeAdapter(ShieldSpriteAttribute)";
        }
    }
}
