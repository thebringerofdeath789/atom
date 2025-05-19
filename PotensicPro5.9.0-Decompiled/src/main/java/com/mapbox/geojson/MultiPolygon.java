package com.mapbox.geojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public final class MultiPolygon implements CoordinateContainer<List<List<List<Point>>>> {
    private static final String TYPE = "MultiPolygon";
    private final BoundingBox bbox;
    private final List<List<List<Point>>> coordinates;
    private final String type;

    public static MultiPolygon fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        return (MultiPolygon) gsonBuilder.create().fromJson(str, MultiPolygon.class);
    }

    public static MultiPolygon fromPolygons(List<Polygon> list) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Polygon> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().coordinates());
        }
        return new MultiPolygon(TYPE, null, arrayList);
    }

    public static MultiPolygon fromPolygons(List<Polygon> list, BoundingBox boundingBox) {
        ArrayList arrayList = new ArrayList(list.size());
        Iterator<Polygon> it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(it.next().coordinates());
        }
        return new MultiPolygon(TYPE, boundingBox, arrayList);
    }

    public static MultiPolygon fromPolygon(Polygon polygon) {
        return new MultiPolygon(TYPE, null, Arrays.asList(polygon.coordinates()));
    }

    public static MultiPolygon fromPolygon(Polygon polygon, BoundingBox boundingBox) {
        return new MultiPolygon(TYPE, boundingBox, Arrays.asList(polygon.coordinates()));
    }

    public static MultiPolygon fromLngLats(List<List<List<Point>>> list) {
        return new MultiPolygon(TYPE, null, list);
    }

    public static MultiPolygon fromLngLats(List<List<List<Point>>> list, BoundingBox boundingBox) {
        return new MultiPolygon(TYPE, boundingBox, list);
    }

    static MultiPolygon fromLngLats(double[][][][] dArr) {
        ArrayList arrayList = new ArrayList(dArr.length);
        for (int i = 0; i < dArr.length; i++) {
            ArrayList arrayList2 = new ArrayList(dArr[i].length);
            for (int i2 = 0; i2 < dArr[i].length; i2++) {
                ArrayList arrayList3 = new ArrayList(dArr[i][i2].length);
                for (int i3 = 0; i3 < dArr[i][i2].length; i3++) {
                    arrayList3.add(Point.fromLngLat(dArr[i][i2][i3]));
                }
                arrayList2.add(arrayList3);
            }
            arrayList.add(arrayList2);
        }
        return new MultiPolygon(TYPE, null, arrayList);
    }

    MultiPolygon(String str, BoundingBox boundingBox, List<List<List<Point>>> list) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        this.bbox = boundingBox;
        Objects.requireNonNull(list, "Null coordinates");
        this.coordinates = list;
    }

    public List<Polygon> polygons() {
        List<List<List<Point>>> coordinates = coordinates();
        ArrayList arrayList = new ArrayList(coordinates.size());
        Iterator<List<List<Point>>> it = coordinates.iterator();
        while (it.hasNext()) {
            arrayList.add(Polygon.fromLngLats(it.next()));
        }
        return arrayList;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String type() {
        return this.type;
    }

    @Override // com.mapbox.geojson.GeoJson
    public BoundingBox bbox() {
        return this.bbox;
    }

    @Override // com.mapbox.geojson.CoordinateContainer
    public List<List<List<Point>>> coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public static TypeAdapter<MultiPolygon> typeAdapter(Gson gson) {
        return new GsonTypeAdapter(gson);
    }

    public String toString() {
        return "Polygon{type=" + this.type + ", bbox=" + this.bbox + ", coordinates=" + this.coordinates + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        BoundingBox boundingBox;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof MultiPolygon)) {
            return false;
        }
        MultiPolygon multiPolygon = (MultiPolygon) obj;
        return this.type.equals(multiPolygon.type()) && ((boundingBox = this.bbox) != null ? boundingBox.equals(multiPolygon.bbox()) : multiPolygon.bbox() == null) && this.coordinates.equals(multiPolygon.coordinates());
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        BoundingBox boundingBox = this.bbox;
        return ((hashCode ^ (boundingBox == null ? 0 : boundingBox.hashCode())) * 1000003) ^ this.coordinates.hashCode();
    }

    static final class GsonTypeAdapter extends BaseGeometryTypeAdapter<MultiPolygon, List<List<List<Point>>>> {
        GsonTypeAdapter(Gson gson) {
            super(gson, new ListofListofListOfPointCoordinatesTypeAdapter());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, MultiPolygon multiPolygon) throws IOException {
            writeCoordinateContainer(jsonWriter, multiPolygon);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public MultiPolygon read2(JsonReader jsonReader) throws IOException {
            return (MultiPolygon) readCoordinateContainer(jsonReader);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mapbox.geojson.BaseGeometryTypeAdapter
        public CoordinateContainer<List<List<List<Point>>>> createCoordinateContainer(String str, BoundingBox boundingBox, List<List<List<Point>>> list) {
            if (str == null) {
                str = MultiPolygon.TYPE;
            }
            return new MultiPolygon(str, boundingBox, list);
        }
    }
}
