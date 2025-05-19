package com.mapbox.geojson;

import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonToken;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.exception.GeoJsonException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class ListOfPointCoordinatesTypeAdapter extends BaseCoordinatesTypeAdapter<List<Point>> {
    ListOfPointCoordinatesTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, List<Point> list) throws IOException {
        if (list == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        Iterator<Point> it = list.iterator();
        while (it.hasNext()) {
            writePoint(jsonWriter, it.next());
        }
        jsonWriter.endArray();
    }

    @Override // com.google.gson.TypeAdapter
    /* renamed from: read */
    public List<Point> read2(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            throw null;
        }
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            ArrayList arrayList = new ArrayList();
            jsonReader.beginArray();
            while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                arrayList.add(readPoint(jsonReader));
            }
            jsonReader.endArray();
            return arrayList;
        }
        throw new GeoJsonException("coordinates should be non-null array of array of double");
    }
}
