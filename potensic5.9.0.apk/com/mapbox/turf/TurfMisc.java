package com.mapbox.turf;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.LineString;
import com.mapbox.geojson.Point;
import com.mapbox.turf.models.LineIntersectsResult;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/* loaded from: classes3.dex */
public final class TurfMisc {
    private static final String INDEX_KEY = "index";

    private TurfMisc() {
        throw new AssertionError("No Instances.");
    }

    public static LineString lineSlice(Point point, Point point2, Feature feature) {
        Objects.requireNonNull(feature.geometry(), "Feature.geometry() == null");
        if (!feature.geometry().type().equals("LineString")) {
            throw new TurfException("input must be a LineString Feature or Geometry");
        }
        return lineSlice(point, point2, (LineString) feature.geometry());
    }

    public static LineString lineSlice(Point point, Point point2, LineString lineString) {
        List<Point> coordinates = lineString.coordinates();
        if (coordinates.size() < 2) {
            throw new TurfException("Turf lineSlice requires a LineString made up of at least 2 coordinates.");
        }
        if (point.equals(point2)) {
            throw new TurfException("Start and stop points in Turf lineSlice cannot equal each other.");
        }
        Feature nearestPointOnLine = nearestPointOnLine(point, coordinates);
        Feature nearestPointOnLine2 = nearestPointOnLine(point2, coordinates);
        ArrayList arrayList = new ArrayList();
        if (((Integer) nearestPointOnLine.getNumberProperty(INDEX_KEY)).intValue() <= ((Integer) nearestPointOnLine2.getNumberProperty(INDEX_KEY)).intValue()) {
            arrayList.add(nearestPointOnLine);
            arrayList.add(nearestPointOnLine2);
        } else {
            arrayList.add(nearestPointOnLine2);
            arrayList.add(nearestPointOnLine);
        }
        ArrayList arrayList2 = new ArrayList();
        arrayList2.add((Point) ((Feature) arrayList.get(0)).geometry());
        for (int intValue = ((Integer) ((Feature) arrayList.get(0)).getNumberProperty(INDEX_KEY)).intValue() + 1; intValue < ((Integer) ((Feature) arrayList.get(1)).getNumberProperty(INDEX_KEY)).intValue() + 1; intValue++) {
            arrayList2.add(coordinates.get(intValue));
        }
        arrayList2.add((Point) ((Feature) arrayList.get(1)).geometry());
        return LineString.fromLngLats(arrayList2);
    }

    public static LineString lineSliceAlong(Feature feature, double d, double d2, String str) {
        Objects.requireNonNull(feature.geometry(), "Feature.geometry() == null");
        if (!feature.geometry().type().equals("LineString")) {
            throw new TurfException("input must be a LineString Feature or Geometry");
        }
        return lineSliceAlong((LineString) feature.geometry(), d, d2, str);
    }

    public static LineString lineSliceAlong(LineString lineString, double d, double d2, String str) {
        List<Point> coordinates = lineString.coordinates();
        if (coordinates.size() < 2) {
            throw new TurfException("Turf lineSlice requires a LineString Geometry made up of at least 2 coordinates. The LineString passed in only contains " + coordinates.size() + ".");
        }
        if (d == d2) {
            throw new TurfException("Start and stop distance in Turf lineSliceAlong cannot equal each other.");
        }
        ArrayList arrayList = new ArrayList(2);
        int i = 0;
        double d3 = 0.0d;
        while (i < coordinates.size() && (d < d3 || i != coordinates.size() - 1)) {
            if (d3 > d && arrayList.size() == 0) {
                double d4 = d - d3;
                if (d4 == 0.0d) {
                    arrayList.add(coordinates.get(i));
                    return LineString.fromLngLats(arrayList);
                }
                arrayList.add(TurfMeasurement.destination(coordinates.get(i), d4, TurfMeasurement.bearing(coordinates.get(i), coordinates.get(i - 1)) - 180.0d, str));
            }
            if (d3 >= d2) {
                double d5 = d2 - d3;
                if (d5 == 0.0d) {
                    arrayList.add(coordinates.get(i));
                    return LineString.fromLngLats(arrayList);
                }
                arrayList.add(TurfMeasurement.destination(coordinates.get(i), d5, TurfMeasurement.bearing(coordinates.get(i), coordinates.get(i - 1)) - 180.0d, str));
                return LineString.fromLngLats(arrayList);
            }
            if (d3 >= d) {
                arrayList.add(coordinates.get(i));
            }
            if (i == coordinates.size() - 1) {
                return LineString.fromLngLats(arrayList);
            }
            Point point = coordinates.get(i);
            i++;
            d3 += TurfMeasurement.distance(point, coordinates.get(i), str);
        }
        if (d3 < d) {
            throw new TurfException("Start position is beyond line");
        }
        return LineString.fromLngLats(arrayList);
    }

    public static Feature nearestPointOnLine(Point point, List<Point> list) {
        return nearestPointOnLine(point, list, null);
    }

    public static Feature nearestPointOnLine(Point point, List<Point> list, String str) {
        if (list.size() < 2) {
            throw new TurfException("Turf nearestPointOnLine requires a List of Points made up of at least 2 coordinates.");
        }
        String str2 = str == null ? "kilometers" : str;
        Feature fromGeometry = Feature.fromGeometry(Point.fromLngLat(Double.POSITIVE_INFINITY, Double.POSITIVE_INFINITY));
        fromGeometry.addNumberProperty("dist", Double.valueOf(Double.POSITIVE_INFINITY));
        int i = 0;
        Feature feature = fromGeometry;
        while (i < list.size() - 1) {
            Feature fromGeometry2 = Feature.fromGeometry(list.get(i));
            int i2 = i + 1;
            Feature fromGeometry3 = Feature.fromGeometry(list.get(i2));
            fromGeometry2.addNumberProperty("dist", Double.valueOf(TurfMeasurement.distance(point, (Point) fromGeometry2.geometry(), str2)));
            fromGeometry3.addNumberProperty("dist", Double.valueOf(TurfMeasurement.distance(point, (Point) fromGeometry3.geometry(), str2)));
            double max = Math.max(fromGeometry2.properties().get("dist").getAsDouble(), fromGeometry3.properties().get("dist").getAsDouble());
            double bearing = TurfMeasurement.bearing((Point) fromGeometry2.geometry(), (Point) fromGeometry3.geometry());
            String str3 = str2;
            Feature fromGeometry4 = Feature.fromGeometry(TurfMeasurement.destination(point, max, bearing + 90.0d, str3));
            Feature fromGeometry5 = Feature.fromGeometry(TurfMeasurement.destination(point, max, bearing - 90.0d, str3));
            LineIntersectsResult lineIntersects = lineIntersects(((Point) fromGeometry4.geometry()).longitude(), ((Point) fromGeometry4.geometry()).latitude(), ((Point) fromGeometry5.geometry()).longitude(), ((Point) fromGeometry5.geometry()).latitude(), ((Point) fromGeometry2.geometry()).longitude(), ((Point) fromGeometry2.geometry()).latitude(), ((Point) fromGeometry3.geometry()).longitude(), ((Point) fromGeometry3.geometry()).latitude());
            Feature feature2 = null;
            if (lineIntersects != null) {
                feature2 = Feature.fromGeometry(Point.fromLngLat(lineIntersects.horizontalIntersection().doubleValue(), lineIntersects.verticalIntersection().doubleValue()));
                feature2.addNumberProperty("dist", Double.valueOf(TurfMeasurement.distance(point, (Point) feature2.geometry(), str2)));
            }
            if (((Double) fromGeometry2.getNumberProperty("dist")).doubleValue() < ((Double) feature.getNumberProperty("dist")).doubleValue()) {
                fromGeometry2.addNumberProperty(INDEX_KEY, Integer.valueOf(i));
                feature = fromGeometry2;
            }
            if (((Double) fromGeometry3.getNumberProperty("dist")).doubleValue() < ((Double) feature.getNumberProperty("dist")).doubleValue()) {
                fromGeometry3.addNumberProperty(INDEX_KEY, Integer.valueOf(i));
            } else {
                fromGeometry3 = feature;
            }
            if (feature2 == null || ((Double) feature2.getNumberProperty("dist")).doubleValue() >= ((Double) fromGeometry3.getNumberProperty("dist")).doubleValue()) {
                feature = fromGeometry3;
            } else {
                feature2.addNumberProperty(INDEX_KEY, Integer.valueOf(i));
                feature = feature2;
            }
            i = i2;
        }
        return feature;
    }

    private static LineIntersectsResult lineIntersects(double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8) {
        LineIntersectsResult build = LineIntersectsResult.builder().onLine1(false).onLine2(false).build();
        double d9 = d8 - d6;
        double d10 = d3 - d;
        double d11 = d7 - d5;
        double d12 = d4 - d2;
        double d13 = (d9 * d10) - (d11 * d12);
        if (d13 == 0.0d) {
            if (build.horizontalIntersection() == null || build.verticalIntersection() == null) {
                return null;
            }
            return build;
        }
        double d14 = d2 - d6;
        double d15 = d - d5;
        double d16 = ((d11 * d14) - (d9 * d15)) / d13;
        double d17 = ((d14 * d10) - (d15 * d12)) / d13;
        LineIntersectsResult build2 = build.toBuilder().horizontalIntersection(Double.valueOf(d + (d10 * d16))).build().toBuilder().verticalIntersection(Double.valueOf(d2 + (d12 * d16))).build();
        if (d16 > 0.0d && d16 < 1.0d) {
            build2 = build2.toBuilder().onLine1(true).build();
        }
        if (d17 > 0.0d && d17 < 1.0d) {
            build2 = build2.toBuilder().onLine2(true).build();
        }
        if (build2.onLine1() && build2.onLine2()) {
            return build2;
        }
        return null;
    }
}