package com.mapbox.geojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public final class GeometryCollection implements Geometry {
    private static final String TYPE = "GeometryCollection";
    private final BoundingBox bbox;
    private final List<Geometry> geometries;
    private final String type;

    public static GeometryCollection fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(GeometryAdapterFactory.create());
        return (GeometryCollection) gsonBuilder.create().fromJson(str, GeometryCollection.class);
    }

    public static GeometryCollection fromGeometries(List<Geometry> list) {
        return new GeometryCollection(TYPE, null, list);
    }

    public static GeometryCollection fromGeometries(List<Geometry> list, BoundingBox boundingBox) {
        return new GeometryCollection(TYPE, boundingBox, list);
    }

    public static GeometryCollection fromGeometry(Geometry geometry) {
        return new GeometryCollection(TYPE, null, Arrays.asList(geometry));
    }

    public static GeometryCollection fromGeometry(Geometry geometry, BoundingBox boundingBox) {
        return new GeometryCollection(TYPE, boundingBox, Arrays.asList(geometry));
    }

    GeometryCollection(String str, BoundingBox boundingBox, List<Geometry> list) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        this.bbox = boundingBox;
        Objects.requireNonNull(list, "Null geometries");
        this.geometries = list;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String type() {
        return this.type;
    }

    @Override // com.mapbox.geojson.GeoJson
    public BoundingBox bbox() {
        return this.bbox;
    }

    public List<Geometry> geometries() {
        return this.geometries;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        gsonBuilder.registerTypeAdapterFactory(GeometryAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public static TypeAdapter<GeometryCollection> typeAdapter(Gson gson) {
        return new GsonTypeAdapter(gson);
    }

    public String toString() {
        return "GeometryCollection{type=" + this.type + ", bbox=" + this.bbox + ", geometries=" + this.geometries + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        BoundingBox boundingBox;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof GeometryCollection)) {
            return false;
        }
        GeometryCollection geometryCollection = (GeometryCollection) obj;
        return this.type.equals(geometryCollection.type()) && ((boundingBox = this.bbox) != null ? boundingBox.equals(geometryCollection.bbox()) : geometryCollection.bbox() == null) && this.geometries.equals(geometryCollection.geometries());
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        BoundingBox boundingBox = this.bbox;
        return ((hashCode ^ (boundingBox == null ? 0 : boundingBox.hashCode())) * 1000003) ^ this.geometries.hashCode();
    }

    static final class GsonTypeAdapter extends TypeAdapter<GeometryCollection> {
        private volatile TypeAdapter<BoundingBox> boundingBoxTypeAdapter;
        private final Gson gson;
        private volatile TypeAdapter<List<Geometry>> listGeometryAdapter;
        private volatile TypeAdapter<String> stringTypeAdapter;

        GsonTypeAdapter(Gson gson) {
            this.gson = gson;
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, GeometryCollection geometryCollection) throws IOException {
            if (geometryCollection == null) {
                jsonWriter.nullValue();
                return;
            }
            jsonWriter.beginObject();
            jsonWriter.name("type");
            if (geometryCollection.type() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<String> typeAdapter = this.stringTypeAdapter;
                if (typeAdapter == null) {
                    typeAdapter = this.gson.getAdapter(String.class);
                    this.stringTypeAdapter = typeAdapter;
                }
                typeAdapter.write(jsonWriter, geometryCollection.type());
            }
            jsonWriter.name("bbox");
            if (geometryCollection.bbox() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<BoundingBox> typeAdapter2 = this.boundingBoxTypeAdapter;
                if (typeAdapter2 == null) {
                    typeAdapter2 = this.gson.getAdapter(BoundingBox.class);
                    this.boundingBoxTypeAdapter = typeAdapter2;
                }
                typeAdapter2.write(jsonWriter, geometryCollection.bbox());
            }
            jsonWriter.name("geometries");
            if (geometryCollection.geometries() == null) {
                jsonWriter.nullValue();
            } else {
                TypeAdapter<List<Geometry>> typeAdapter3 = this.listGeometryAdapter;
                if (typeAdapter3 == null) {
                    typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Geometry.class));
                    this.listGeometryAdapter = typeAdapter3;
                }
                typeAdapter3.write(jsonWriter, geometryCollection.geometries());
            }
            jsonWriter.endObject();
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public GeometryCollection read2(JsonReader jsonReader) throws IOException {
            String str = null;
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
                return null;
            }
            jsonReader.beginObject();
            BoundingBox boundingBox = null;
            List<Geometry> list = null;
            while (jsonReader.hasNext()) {
                String nextName = jsonReader.nextName();
                if (jsonReader.peek() == JsonToken.NULL) {
                    jsonReader.nextNull();
                } else {
                    nextName.hashCode();
                    switch (nextName) {
                        case "bbox":
                            TypeAdapter<BoundingBox> typeAdapter = this.boundingBoxTypeAdapter;
                            if (typeAdapter == null) {
                                typeAdapter = this.gson.getAdapter(BoundingBox.class);
                                this.boundingBoxTypeAdapter = typeAdapter;
                            }
                            boundingBox = typeAdapter.read2(jsonReader);
                            break;
                        case "type":
                            TypeAdapter<String> typeAdapter2 = this.stringTypeAdapter;
                            if (typeAdapter2 == null) {
                                typeAdapter2 = this.gson.getAdapter(String.class);
                                this.stringTypeAdapter = typeAdapter2;
                            }
                            str = typeAdapter2.read2(jsonReader);
                            break;
                        case "geometries":
                            TypeAdapter<List<Geometry>> typeAdapter3 = this.listGeometryAdapter;
                            if (typeAdapter3 == null) {
                                typeAdapter3 = this.gson.getAdapter(TypeToken.getParameterized(List.class, Geometry.class));
                                this.listGeometryAdapter = typeAdapter3;
                            }
                            list = typeAdapter3.read2(jsonReader);
                            break;
                        default:
                            jsonReader.skipValue();
                            break;
                    }
                }
            }
            jsonReader.endObject();
            if (str == null) {
                str = GeometryCollection.TYPE;
            }
            return new GeometryCollection(str, boundingBox, list);
        }
    }
}
