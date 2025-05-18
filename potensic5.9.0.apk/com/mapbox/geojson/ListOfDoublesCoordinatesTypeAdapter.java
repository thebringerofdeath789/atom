package com.mapbox.geojson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import java.io.IOException;
import java.util.List;

/* loaded from: classes3.dex */
class ListOfDoublesCoordinatesTypeAdapter extends BaseCoordinatesTypeAdapter<List<Double>> {
    ListOfDoublesCoordinatesTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, List<Double> list) throws IOException {
        writePointList(jsonWriter, list);
    }

    @Override // com.google.gson.TypeAdapter
    public List<Double> read(JsonReader jsonReader) throws IOException {
        return readPointList(jsonReader);
    }
}