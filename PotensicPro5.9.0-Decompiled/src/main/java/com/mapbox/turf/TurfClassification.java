package com.mapbox.turf;

import com.mapbox.geojson.Point;
import java.util.List;

/* loaded from: classes3.dex */
public class TurfClassification {
    private TurfClassification() {
    }

    public static Point nearestPoint(Point point, List<Point> list) {
        if (list.isEmpty()) {
            return point;
        }
        Point point2 = list.get(0);
        double d = Double.POSITIVE_INFINITY;
        for (Point point3 : list) {
            double distance = TurfMeasurement.distance(point, point3);
            if (distance < d) {
                point2 = point3;
                d = distance;
            }
        }
        return point2;
    }
}
