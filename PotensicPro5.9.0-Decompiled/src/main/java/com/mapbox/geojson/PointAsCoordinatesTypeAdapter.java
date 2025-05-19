package com.mapbox.geojson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;

/* loaded from: classes3.dex */
public class PointAsCoordinatesTypeAdapter extends BaseCoordinatesTypeAdapter<Point> {
    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, Point point) throws IOException {
        writePoint(jsonWriter, point);
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public Point read2(JsonReader jsonReader) throws IOException {
        return readPoint(jsonReader);
    }
}
