package com.mapbox.geojson;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.exception.GeoJsonException;
import com.mapbox.geojson.gson.BoundingBoxTypeAdapter;
import java.io.IOException;

/* loaded from: classes3.dex */
abstract class BaseGeometryTypeAdapter<G, T> extends TypeAdapter<G> {
    private volatile TypeAdapter<BoundingBox> boundingBoxAdapter = new BoundingBoxTypeAdapter();
    private volatile TypeAdapter<T> coordinatesAdapter;
    private final Gson gson;
    private volatile TypeAdapter<String> stringAdapter;

    abstract CoordinateContainer<T> createCoordinateContainer(String str, BoundingBox boundingBox, T t);

    BaseGeometryTypeAdapter(Gson gson, TypeAdapter<T> typeAdapter) {
        this.gson = gson;
        this.coordinatesAdapter = typeAdapter;
    }

    public void writeCoordinateContainer(JsonWriter jsonWriter, CoordinateContainer<T> coordinateContainer) throws IOException {
        if (coordinateContainer == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginObject();
        jsonWriter.name("type");
        if (coordinateContainer.type() == null) {
            jsonWriter.nullValue();
        } else {
            TypeAdapter<String> typeAdapter = this.stringAdapter;
            if (typeAdapter == null) {
                typeAdapter = this.gson.getAdapter(String.class);
                this.stringAdapter = typeAdapter;
            }
            typeAdapter.write(jsonWriter, coordinateContainer.type());
        }
        jsonWriter.name("bbox");
        if (coordinateContainer.bbox() == null) {
            jsonWriter.nullValue();
        } else {
            TypeAdapter<BoundingBox> typeAdapter2 = this.boundingBoxAdapter;
            if (typeAdapter2 == null) {
                typeAdapter2 = this.gson.getAdapter(BoundingBox.class);
                this.boundingBoxAdapter = typeAdapter2;
            }
            typeAdapter2.write(jsonWriter, coordinateContainer.bbox());
        }
        jsonWriter.name("coordinates");
        if (coordinateContainer.coordinates() == null) {
            jsonWriter.nullValue();
        } else {
            TypeAdapter<T> typeAdapter3 = this.coordinatesAdapter;
            if (typeAdapter3 == null) {
                throw new GeoJsonException("Coordinates type adapter is null");
            }
            typeAdapter3.write(jsonWriter, coordinateContainer.coordinates());
        }
        jsonWriter.endObject();
    }

    public CoordinateContainer<T> readCoordinateContainer(JsonReader jsonReader) throws IOException {
        String str = null;
        if (jsonReader.peek() == JsonToken.NULL) {
            jsonReader.nextNull();
            return null;
        }
        jsonReader.beginObject();
        BoundingBox boundingBox = null;
        T t = null;
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            if (jsonReader.peek() == JsonToken.NULL) {
                jsonReader.nextNull();
            } else {
                nextName.hashCode();
                switch (nextName) {
                    case "bbox":
                        TypeAdapter<BoundingBox> typeAdapter = this.boundingBoxAdapter;
                        if (typeAdapter == null) {
                            typeAdapter = this.gson.getAdapter(BoundingBox.class);
                            this.boundingBoxAdapter = typeAdapter;
                        }
                        boundingBox = typeAdapter.read2(jsonReader);
                        break;
                    case "type":
                        TypeAdapter<String> typeAdapter2 = this.stringAdapter;
                        if (typeAdapter2 == null) {
                            typeAdapter2 = this.gson.getAdapter(String.class);
                            this.stringAdapter = typeAdapter2;
                        }
                        str = typeAdapter2.read2(jsonReader);
                        break;
                    case "coordinates":
                        TypeAdapter<T> typeAdapter3 = this.coordinatesAdapter;
                        if (typeAdapter3 == null) {
                            throw new GeoJsonException("Coordinates type adapter is null");
                        }
                        t = typeAdapter3.read2(jsonReader);
                        break;
                    default:
                        jsonReader.skipValue();
                        break;
                }
            }
        }
        jsonReader.endObject();
        return createCoordinateContainer(str, boundingBox, t);
    }
}
