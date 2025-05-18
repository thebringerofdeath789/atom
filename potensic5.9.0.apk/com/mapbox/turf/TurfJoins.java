package com.mapbox.turf;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.MultiPolygon;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.Polygon;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public final class TurfJoins {
    private TurfJoins() {
    }

    public static boolean inside(Point point, Polygon polygon) {
        List<List<Point>> coordinates = polygon.coordinates();
        ArrayList arrayList = new ArrayList();
        arrayList.add(coordinates);
        return inside(point, MultiPolygon.fromLngLats(arrayList));
    }

    public static boolean inside(Point point, MultiPolygon multiPolygon) {
        List<List<List<Point>>> coordinates = multiPolygon.coordinates();
        boolean z = false;
        for (int i = 0; i < coordinates.size() && !z; i++) {
            if (inRing(point, coordinates.get(i).get(0))) {
                boolean z2 = false;
                for (int i2 = 1; i2 < coordinates.get(i).size() && !z2; i2++) {
                    if (inRing(point, coordinates.get(i).get(i2))) {
                        z2 = true;
                    }
                }
                if (!z2) {
                    z = true;
                }
            }
        }
        return z;
    }

    public static FeatureCollection pointsWithinPolygon(FeatureCollection featureCollection, FeatureCollection featureCollection2) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < featureCollection2.features().size(); i++) {
            for (int i2 = 0; i2 < featureCollection.features().size(); i2++) {
                Point point = (Point) featureCollection.features().get(i2).geometry();
                if (inside(point, (Polygon) featureCollection2.features().get(i).geometry())) {
                    arrayList.add(Feature.fromGeometry(point));
                }
            }
        }
        return FeatureCollection.fromFeatures(arrayList);
    }

    private static boolean inRing(Point point, List<Point> list) {
        int size = list.size() - 1;
        boolean z = false;
        for (int i = 0; i < list.size(); i++) {
            double longitude = list.get(i).longitude();
            double latitude = list.get(i).latitude();
            double longitude2 = list.get(size).longitude();
            double latitude2 = list.get(size).latitude();
            if (((latitude > point.latitude() ? 1 : (latitude == point.latitude() ? 0 : -1)) > 0) != ((latitude2 > point.latitude() ? 1 : (latitude2 == point.latitude() ? 0 : -1)) > 0) && point.longitude() < (((longitude2 - longitude) * (point.latitude() - latitude)) / (latitude2 - latitude)) + longitude) {
                z = !z;
            }
            size = i;
        }
        return z;
    }
}