package com.mapbox.geojson;

import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.TypeAdapter;
import com.google.gson.annotations.JsonAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.gson.BoundingBoxTypeAdapter;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import java.io.IOException;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;
import org.apache.commons.text.lookup.StringLookupFactory;

/* loaded from: classes3.dex */
public final class Feature implements GeoJson {
    private static final String TYPE = "Feature";

    @JsonAdapter(BoundingBoxTypeAdapter.class)
    private final BoundingBox bbox;
    private final Geometry geometry;
    private final String id;
    private final JsonObject properties;
    private final String type;

    public static Feature fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(GeometryAdapterFactory.create());
        Feature feature = (Feature) gsonBuilder.create().fromJson(str, Feature.class);
        return feature.properties() != null ? feature : new Feature(TYPE, feature.bbox(), feature.id(), feature.geometry(), new JsonObject());
    }

    public static Feature fromGeometry(Geometry geometry) {
        return new Feature(TYPE, null, null, geometry, new JsonObject());
    }

    public static Feature fromGeometry(Geometry geometry, BoundingBox boundingBox) {
        return new Feature(TYPE, boundingBox, null, geometry, new JsonObject());
    }

    public static Feature fromGeometry(Geometry geometry, JsonObject jsonObject) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        return new Feature(TYPE, null, null, geometry, jsonObject);
    }

    public static Feature fromGeometry(Geometry geometry, JsonObject jsonObject, BoundingBox boundingBox) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        return new Feature(TYPE, boundingBox, null, geometry, jsonObject);
    }

    public static Feature fromGeometry(Geometry geometry, JsonObject jsonObject, String str) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        return new Feature(TYPE, null, str, geometry, jsonObject);
    }

    public static Feature fromGeometry(Geometry geometry, JsonObject jsonObject, String str, BoundingBox boundingBox) {
        if (jsonObject == null) {
            jsonObject = new JsonObject();
        }
        return new Feature(TYPE, boundingBox, str, geometry, jsonObject);
    }

    Feature(String str, BoundingBox boundingBox, String str2, Geometry geometry, JsonObject jsonObject) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        this.bbox = boundingBox;
        this.id = str2;
        this.geometry = geometry;
        this.properties = jsonObject;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String type() {
        return this.type;
    }

    @Override // com.mapbox.geojson.GeoJson
    public BoundingBox bbox() {
        return this.bbox;
    }

    public String id() {
        return this.id;
    }

    public Geometry geometry() {
        return this.geometry;
    }

    public JsonObject properties() {
        return this.properties;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String toJson() {
        return new GsonBuilder().registerTypeAdapterFactory(GeoJsonAdapterFactory.create()).registerTypeAdapterFactory(GeometryAdapterFactory.create()).create().toJson(properties().size() == 0 ? new Feature(TYPE, bbox(), id(), geometry(), null) : this);
    }

    public static TypeAdapter<Feature> typeAdapter(Gson gson) {
        return new GsonTypeAdapter(gson);
    }

    public void addStringProperty(String str, String str2) {
        properties().addProperty(str, str2);
    }

    public void addNumberProperty(String str, Number number) {
        properties().addProperty(str, number);
    }

    public void addBooleanProperty(String str, Boolean bool) {
        properties().addProperty(str, bool);
    }

    public void addCharacterProperty(String str, Character ch) {
        properties().addProperty(str, ch);
    }

    public void addProperty(String str, JsonElement jsonElement) {
        properties().add(str, jsonElement);
    }

    public String getStringProperty(String str) {
        JsonElement jsonElement = properties().get(str);
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.getAsString();
    }

    public Number getNumberProperty(String str) {
        JsonElement jsonElement = properties().get(str);
        if (jsonElement == null) {
            return null;
        }
        return jsonElement.getAsNumber();
    }

    public Boolean getBooleanProperty(String str) {
        JsonElement jsonElement = properties().get(str);
        if (jsonElement == null) {
            return null;
        }
        return Boolean.valueOf(jsonElement.getAsBoolean());
    }

    public Character getCharacterProperty(String str) {
        JsonElement jsonElement = properties().get(str);
        if (jsonElement == null) {
            return null;
        }
        return Character.valueOf(jsonElement.getAsCharacter());
    }

    public JsonElement getProperty(String str) {
        return properties().get(str);
    }

    public JsonElement removeProperty(String str) {
        return properties().remove(str);
    }

    public boolean hasProperty(String str) {
        return properties().has(str);
    }

    public boolean hasNonNullValueForProperty(String str) {
        return hasProperty(str) && !getProperty(str).isJsonNull();
    }

    public String toString() {
        return "Feature{type=" + this.type + ", bbox=" + this.bbox + ", id=" + this.id + ", geometry=" + this.geometry + ", properties=" + this.properties + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        BoundingBox boundingBox;
        String str;
        Geometry geometry;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Feature)) {
            return false;
        }
        Feature feature = (Feature) obj;
        if (this.type.equals(feature.type()) && ((boundingBox = this.bbox) != null ? boundingBox.equals(feature.bbox()) : feature.bbox() == null) && ((str = this.id) != null ? str.equals(feature.id()) : feature.id() == null) && ((geometry = this.geometry) != null ? geometry.equals(feature.geometry()) : feature.geometry() == null)) {
            JsonObject jsonObject = this.properties;
            if (jsonObject == null) {
                if (feature.properties() == null) {
                    return true;
                }
            } else if (jsonObject.equals(feature.properties())) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        BoundingBox boundingBox = this.bbox;
        int hashCode2 = (hashCode ^ (boundingBox == null ? 0 : boundingBox.hashCode())) * 1000003;
        String str = this.id;
        int hashCode3 = (hashCode2 ^ (str == null ? 0 : str.hashCode())) * 1000003;
        Geometry geometry = this.geometry;
        int hashCode4 = (hashCode3 ^ (geometry == null ? 0 : geometry.hashCode())) * 1000003;
        JsonObject jsonObject = this.properties;
        return hashCode4 ^ (jsonObject != null ? jsonObject.hashCode() : 0);
    }

    static final class GsonTypeAdapter extends TypeAdapter<Feature> {
        private volatile TypeAdapter<BoundingBox> boundingBoxTypeAdapter;
        private volatile TypeAdapter<Geometry> geometryTypeAdapter;
        private final Gson gson;
        private volatile TypeAdapter<JsonObject> jsonObjectTypeAdapter;
        private volatile TypeAdapter<String> stringTypeAdapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Feature feature) throws IOException {
            if (feature == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("type");
            if (feature.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.stringTypeAdapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.stringTypeAdapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, feature.type());
            }
            jsonWriter.name("bbox");
            if (feature.bbox() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BoundingBox> typeAdapter2 = this.boundingBoxTypeAdapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(BoundingBox.class);
                    this.boundingBoxTypeAdapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, feature.bbox());
            }
            jsonWriter.name(TtmlNode.ATTR_ID);
            if (feature.id() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter3 = this.stringTypeAdapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(String.class);
                    this.stringTypeAdapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, feature.id());
            }
            jsonWriter.name("geometry");
            if (feature.geometry() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<Geometry> typeAdapter4 = this.geometryTypeAdapter;
                if (typeAdapter4 == null) {
                    typeAdapter4 = this.gson.getAdapter(Geometry.class);
                    this.geometryTypeAdapter = typeAdapter4;
                }
                typeAdapter4.write(jsonWriter, feature.geometry());
            }
            jsonWriter.name(StringLookupFactory.KEY_PROPERTIES);
            if (feature.properties() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<JsonObject> typeAdapter5 = this.jsonObjectTypeAdapter;
                if (typeAdapter5 == null) {
                    typeAdapter5 = this.gson.getAdapter(JsonObject.class);
                    this.jsonObjectTypeAdapter = typeAdapter5;
                }
                typeAdapter5.write(jsonWriter, feature.properties());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Feature read2(JsonReader jsonReader) throws IOException {
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            String str = null;
            BoundingBox boundingBox = null;
            String str2 = null;
            Geometry geometry = null;
            JsonObject jsonObject = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "properties":
                            TypeAdapter<JsonObject> typeAdapter = this.jsonObjectTypeAdapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(JsonObject.class);
                                this.jsonObjectTypeAdapter = typeAdapter;
                            }
                            jsonObject = typeAdapter.read2(jsonReader);
                            break;
                        case "id":
                            TypeAdapter<String> typeAdapter2 = this.stringTypeAdapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(String.class);
                                this.stringTypeAdapter = typeAdapter2;
                            }
                            str2 = typeAdapter2.read2(jsonReader);
                            break;
                        case "bbox":
                            TypeAdapter<BoundingBox> typeAdapter3 = this.boundingBoxTypeAdapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(BoundingBox.class);
                                this.boundingBoxTypeAdapter = typeAdapter3;
                            }
                            boundingBox = typeAdapter3.read2(jsonReader);
                            break;
                        case "type":
                            TypeAdapter<String> typeAdapter4 = this.stringTypeAdapter;
                            if (typeAdapter4 == null) {
                                typeAdapter4 = this.gson.getAdapter(String.class);
                                this.stringTypeAdapter = typeAdapter4;
                            }
                            str = typeAdapter4.read2(jsonReader);
                            break;
                        case "geometry":
                            TypeAdapter<Geometry> typeAdapter5 = this.geometryTypeAdapter;
                            if (typeAdapter5 == null) {
                                typeAdapter5 = this.gson.getAdapter(Geometry.class);
                                this.geometryTypeAdapter = typeAdapter5;
                            }
                            geometry = typeAdapter5.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            return new Feature(str, boundingBox, str2, geometry, jsonObject);
        }
    }
}
