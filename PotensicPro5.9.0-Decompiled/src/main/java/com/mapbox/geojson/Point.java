package com.mapbox.geojson;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.TypeAdapter;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;
import com.mapbox.geojson.gson.GeoJsonAdapterFactory;
import com.mapbox.geojson.shifter.CoordinateShifterManager;
import java.io.IOException;
import java.util.List;
import java.util.Objects;
import org.apache.commons.text.StringSubstitutor;

/* loaded from: classes3.dex */
public final class Point implements CoordinateContainer<List<Double>> {
    private static final String TYPE = "Point";
    private final BoundingBox bbox;
    private final List<Double> coordinates;
    private final String type;

    public static Point fromJson(String str) {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        return (Point) gsonBuilder.create().fromJson(str, Point.class);
    }

    public static Point fromLngLat(double d, double d2) {
        return new Point(TYPE, null, CoordinateShifterManager.getCoordinateShifter().shiftLonLat(d, d2));
    }

    public static Point fromLngLat(double d, double d2, BoundingBox boundingBox) {
        return new Point(TYPE, boundingBox, CoordinateShifterManager.getCoordinateShifter().shiftLonLat(d, d2));
    }

    public static Point fromLngLat(double d, double d2, double d3) {
        return new Point(TYPE, null, CoordinateShifterManager.getCoordinateShifter().shiftLonLatAlt(d, d2, d3));
    }

    public static Point fromLngLat(double d, double d2, double d3, BoundingBox boundingBox) {
        return new Point(TYPE, boundingBox, CoordinateShifterManager.getCoordinateShifter().shiftLonLatAlt(d, d2, d3));
    }

    static Point fromLngLat(double[] dArr) {
        if (dArr.length == 2) {
            return fromLngLat(dArr[0], dArr[1]);
        }
        if (dArr.length > 2) {
            return fromLngLat(dArr[0], dArr[1], dArr[2]);
        }
        return null;
    }

    Point(String str, BoundingBox boundingBox, List<Double> list) {
        Objects.requireNonNull(str, "Null type");
        this.type = str;
        this.bbox = boundingBox;
        if (list == null || list.size() == 0) {
            throw new NullPointerException("Null coordinates");
        }
        this.coordinates = list;
    }

    public double longitude() {
        return coordinates().get(0).doubleValue();
    }

    public double latitude() {
        return coordinates().get(1).doubleValue();
    }

    public double altitude() {
        if (coordinates().size() < 3) {
            return Double.NaN;
        }
        return coordinates().get(2).doubleValue();
    }

    public boolean hasAltitude() {
        return !Double.isNaN(altitude());
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
    public List<Double> coordinates() {
        return this.coordinates;
    }

    @Override // com.mapbox.geojson.GeoJson
    public String toJson() {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapterFactory(GeoJsonAdapterFactory.create());
        return gsonBuilder.create().toJson(this);
    }

    public static TypeAdapter<Point> typeAdapter(Gson gson) {
        return new GsonTypeAdapter(gson);
    }

    public String toString() {
        return "Point{type=" + this.type + ", bbox=" + this.bbox + ", coordinates=" + this.coordinates + StringSubstitutor.DEFAULT_VAR_END;
    }

    public boolean equals(Object obj) {
        BoundingBox boundingBox;
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Point)) {
            return false;
        }
        Point point = (Point) obj;
        return this.type.equals(point.type()) && ((boundingBox = this.bbox) != null ? boundingBox.equals(point.bbox()) : point.bbox() == null) && this.coordinates.equals(point.coordinates());
    }

    public int hashCode() {
        int hashCode = (this.type.hashCode() ^ 1000003) * 1000003;
        BoundingBox boundingBox = this.bbox;
        return ((hashCode ^ (boundingBox == null ? 0 : boundingBox.hashCode())) * 1000003) ^ this.coordinates.hashCode();
    }

    static final class GsonTypeAdapter extends BaseGeometryTypeAdapter<Point, List<Double>> {
        GsonTypeAdapter(Gson gson) {
            super(gson, new ListOfDoublesCoordinatesTypeAdapter());
        }

        @Override // com.google.gson.TypeAdapter
        public void write(JsonWriter jsonWriter, Point point) throws IOException {
            writeCoordinateContainer(jsonWriter, point);
        }

        @Override // com.google.gson.TypeAdapter
        /* renamed from: read */
        public Point read2(JsonReader jsonReader) throws IOException {
            return (Point) readCoordinateContainer(jsonReader);
        }

        /* JADX INFO: Access modifiers changed from: package-private */
        @Override // com.mapbox.geojson.BaseGeometryTypeAdapter
        public CoordinateContainer<List<Double>> createCoordinateContainer(String str, BoundingBox boundingBox, List<Double> list) {
            if (str == null) {
                str = Point.TYPE;
            }
            return new Point(str, boundingBox, list);
        }
    }
}
