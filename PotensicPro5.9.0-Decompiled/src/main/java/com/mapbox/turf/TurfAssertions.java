package com.mapbox.turf;

import com.mapbox.geojson.Feature;
import com.mapbox.geojson.FeatureCollection;
import com.mapbox.geojson.GeoJson;
import com.mapbox.geojson.Point;

/* loaded from: classes3.dex */
public final class TurfAssertions {
    private TurfAssertions() {
    }

    @Deprecated
    public static Point getCoord(Feature feature) {
        return TurfMeta.getCoord(feature);
    }

    public static void geojsonType(GeoJson geoJson, String str, String str2) {
        if (str == null || str.length() == 0 || str2 == null || str2.length() == 0) {
            throw new TurfException("Type and name required");
        }
        if (geoJson == null || !geoJson.type().equals(str)) {
            throw new TurfException("Invalid input to " + str2 + ": must be a " + str + ", given " + (geoJson != null ? geoJson.type() : " null"));
        }
    }

    public static void featureOf(Feature feature, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            throw new TurfException(".featureOf() requires a name");
        }
        if (feature == null || !feature.type().equals("Feature") || feature.geometry() == null) {
            throw new TurfException(String.format("Invalid input to %s, Feature with geometry required", str2));
        }
        if (feature.geometry() == null || !feature.geometry().type().equals(str)) {
            throw new TurfException(String.format("Invalid input to %s: must be a %s, given %s", str2, str, feature.geometry().type()));
        }
    }

    public static void collectionOf(FeatureCollection featureCollection, String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            throw new TurfException("collectionOf() requires a name");
        }
        if (featureCollection == null || !featureCollection.type().equals("FeatureCollection") || featureCollection.features() == null) {
            throw new TurfException(String.format("Invalid input to %s, FeatureCollection required", str2));
        }
        for (Feature feature : featureCollection.features()) {
            if (feature == null || !feature.type().equals("Feature") || feature.geometry() == null) {
                throw new TurfException(String.format("Invalid input to %s, Feature with geometry required", str2));
            }
            if (feature.geometry() == null || !feature.geometry().type().equals(str)) {
                throw new TurfException(String.format("Invalid input to %s: must be a %s, given %s", str2, str, feature.geometry().type()));
            }
        }
    }
}
