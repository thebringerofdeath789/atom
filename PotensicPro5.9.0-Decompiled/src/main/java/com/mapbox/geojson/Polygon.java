package com.mapbox.geojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.exception.GeoJsonException;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public final class Polygon implements CoordinateContainer<List<List<Point>>> {
    private static final String TYPE = "Polygon";
    private final BoundingBox bbox;
    private final List<List<Point>> coordinates;
    private final String type;

    public static Polygon fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        return (Polygon) gsonBuilder.create().fromJson(str, Polygon.class);
    }

    public static Polygon fromLngLats(List<List<Point>> list) {
        return new Polygon(TYPE, null, list);
    }

    public static Polygon fromLngLats(List<List<Point>> list, BoundingBox boundingBox) {
        return new Polygon(TYPE, boundingBox, list);
    }

    static Polygon fromLngLats(double[][][] dArr) {
        ArrayList arrayList = new ArrayList(dArr.length);
        for (double[][] dArr2 : dArr) {
            ArrayList arrayList2 = new ArrayList(dArr2.length);
            for (double[] dArr3 : dArr2) {
                arrayList2.add(Point.fromLngLat(dArr3));
            }
            arrayList.add(arrayList2);
        }
        return new Polygon(TYPE, null, arrayList);
    }

    public static Polygon fromOuterInner(LineString lineString, LineString... lineStringArr) {
        isLinearRing(lineString);
        ArrayList arrayList = new ArrayList();
        arrayList.add(lineString.coordinates());
        if (lineStringArr == null) {
            return new Polygon(TYPE, null, arrayList);
        }
        for (LineString lineString2 : lineStringArr) {
            isLinearRing(lineString2);
            arrayList.add(lineString2.coordinates());
        }
        return new Polygon(TYPE, null, arrayList);
    }

    public static Polygon fromOuterInner(LineString lineString, BoundingBox boundingBox, LineString... lineStringArr) {
        isLinearRing(lineString);
        ArrayList arrayList = new ArrayList();
        arrayList.add(lineString.coordinates());
        if (lineStringArr == null) {
            return new Polygon(TYPE, boundingBox, arrayList);
        }
        for (LineString lineString2 : lineStringArr) {
            isLinearRing(lineString2);
            arrayList.add(lineString2.coordinates());
        }
        return new Polygon(TYPE, boundingBox, arrayList);
    }

    public static Polygon fromOuterInner(LineString lineString, List<LineString> list) {
        isLinearRing(lineString);
        ArrayList arrayList = new ArrayList();
        arrayList.add(lineString.coordinates());
        if (list == null || list.isEmpty()) {
            return new Polygon(TYPE, null, arrayList);
        }
        for (LineString lineString2 : list) {
            isLinearRing(lineString2);
            arrayList.add(lineString2.coordinates());
        }
        return new Polygon(TYPE, null, arrayList);
    }

    public static Polygon fromOuterInner(LineString lineString, BoundingBox boundingBox, List<LineString> list) {
        isLinearRing(lineString);
        ArrayList arrayList = new ArrayList();
        arrayList.add(lineString.coordinates());
        if (list == null) {
            return new Polygon(TYPE, boundingBox, arrayList);
        }
        for (LineString lineString2 : list) {
            isLinearRing(lineString2);
            arrayList.add(lineString2.coordinates());
        }
        return new Polygon(TYPE, boundingBox, arrayList);
    }

    Polygon(String str, BoundingBox boundingBox, List<List<Point>> list) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        this.bbox = boundingBox;
        Objects.requireNonNull(list, "Null coordinates");
        this.coordinates = list;
    }

    public LineString outer() {
        return LineString.fromLngLats(coordinates().get(0));
    }

    public List<LineString> inner() {
        List<List<Point>> coordinates = coordinates();
        if (coordinates.size() <= 1) {
            return new ArrayList(0);
        }
        ArrayList arrayList = new ArrayList(coordinates.size() - 1);
        Iterator<List<Point>> it = coordinates.subList(1, coordinates.size()).iterator();
        while (it.hasNext()) {
            arrayList.add(LineString.fromLngLats(it.next()));
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
    public List<List<Point>> coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public static TypeAdapter<Polygon> typeAdapter(Gson gson) {
        return new GsonTypeAdapter(gson);
    }

    private static boolean isLinearRing(LineString lineString) {
        if (lineString.coordinates().size() < 4) {
            throw new GeoJsonException("LinearRings need to be made up of 4 or more coordinates.");
        }
        if (lineString.coordinates().get(0).equals(lineString.coordinates().get(lineString.coordinates().size() - 1))) {
            return true;
        }
        throw new GeoJsonException("LinearRings require first and last coordinate to be identical.");
    }

    public String toString() {
        return "Polygon{type=" + this.type + ", bbox=" + this.bbox + ", coordinates=" + this.coordinates + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        BoundingBox boundingBox;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Polygon)) {
            return false;
        }
        Polygon polygon = (Polygon) obj;
        return this.type.equals(polygon.type()) && ((boundingBox = this.bbox) != null ? boundingBox.equals(polygon.bbox()) : polygon.bbox() == null) && this.coordinates.equals(polygon.coordinates());
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        BoundingBox boundingBox = this.bbox;
        return ((hashCode ^ (boundingBox == null ? 0 : boundingBox.hashCode())) * 1000003) ^ this.coordinates.hashCode();
    }

    static final class GsonTypeAdapter extends BaseGeometryTypeAdapter<Polygon, List<List<Point>>> {
        GsonTypeAdapter(Gson gson) {
            super(gson, new ListOfListOfPointCoordinatesTypeAdapter());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Polygon polygon) throws IOException {
            writeCoordinateContainer(jsonWriter, polygon);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Polygon read2(JsonReader jsonReader) throws IOException {
            return (Polygon) readCoordinateContainer(jsonReader);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mapbox.geojson.BaseGeometryTypeAdapter
        public CoordinateContainer<List<List<Point>>> createCoordinateContainer(String str, BoundingBox boundingBox, List<List<Point>> list) {
            if (str == null) {
                str = Polygon.TYPE;
            }
            return new Polygon(str, boundingBox, list);
        }
    }
}
