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
class ListOfListOfPointCoordinatesTypeAdapter extends BaseCoordinatesTypeAdapter<List<List<Point>>> {
    ListOfListOfPointCoordinatesTypeAdapter() {
    }

    @Override // com.google.gson.TypeAdapter
    public void write(JsonWriter jsonWriter, List<List<Point>> list) throws IOException {
        if (list == null) {
            jsonWriter.nullValue();
            return;
        }
        jsonWriter.beginArray();
        for (List<Point> list2 : list) {
            jsonWriter.beginArray();
            Iterator<Point> it = list2.iterator();
            while (it.hasNext()) {
                writePoint(jsonWriter, it.next());
            }
            jsonWriter.endArray();
        }
        jsonWriter.endArray();
    }

    @Override // com.google.gson.TypeAdapter
    public List<List<Point>> read(JsonReader jsonReader) throws IOException {
        if (jsonReader.peek() == JsonToken.NULL) {
            throw null;
        }
        if (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
            jsonReader.beginArray();
            ArrayList arrayList = new ArrayList();
            while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                jsonReader.beginArray();
                ArrayList arrayList2 = new ArrayList();
                while (jsonReader.peek() == JsonToken.BEGIN_ARRAY) {
                    arrayList2.add(readPoint(jsonReader));
                }
                jsonReader.endArray();
                arrayList.add(arrayList2);
            }
            jsonReader.endArray();
            return arrayList;
        }
        throw new GeoJsonException("coordinates should be array of array of array of double");
    }
}