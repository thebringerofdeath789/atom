package com.mapbox.mapboxsdk.plugins.annotation;

import android.graphics.PointF;
import com.google.gson.JsonNull;
import com.google.gson.JsonObject;
import com.mapbox.android.gestures.MoveDistancesObject;
import com.mapbox.geojson.Geometry;
import com.mapbox.geojson.Point;
import com.mapbox.geojson.Polygon;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.maps.Projection;
import com.mapbox.mapboxsdk.utils.ColorUtils;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes3.dex */
public class Fill extends Annotation<Polygon> {
    private final AnnotationManager<?, Fill, ?, ?, ?, ?> annotationManager;

    @Override // com.mapbox.mapboxsdk.plugins.annotation.Annotation
    String getName() {
        return "Fill";
    }

    Fill(long j, AnnotationManager<?, Fill, ?, ?, ?, ?> annotationManager, JsonObject jsonObject, Polygon polygon) {
        super(j, jsonObject, polygon);
        this.annotationManager = annotationManager;
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.Annotation
    void setUsedDataDrivenProperties() {
        if (!(this.jsonObject.get("fill-opacity") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("fill-opacity");
        }
        if (!(this.jsonObject.get("fill-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("fill-color");
        }
        if (!(this.jsonObject.get("fill-outline-color") instanceof JsonNull)) {
            this.annotationManager.enableDataDrivenProperty("fill-outline-color");
        }
        if (this.jsonObject.get("fill-pattern") instanceof JsonNull) {
            return;
        }
        this.annotationManager.enableDataDrivenProperty("fill-pattern");
    }

    public void setLatLngs(List<List<LatLng>> list) {
        ArrayList arrayList = new ArrayList();
        for (List<LatLng> list2 : list) {
            ArrayList arrayList2 = new ArrayList();
            for (LatLng latLng : list2) {
                arrayList2.add(Point.fromLngLat(latLng.getLongitude(), latLng.getLatitude()));
            }
            arrayList.add(arrayList2);
        }
        this.geometry = Polygon.fromLngLats(arrayList);
    }

    public List<List<LatLng>> getLatLngs() {
        Polygon polygon = (Polygon) this.geometry;
        ArrayList arrayList = new ArrayList();
        List<List<Point>> coordinates = polygon.coordinates();
        if (coordinates != null) {
            for (List<Point> list : coordinates) {
                ArrayList arrayList2 = new ArrayList();
                for (Point point : list) {
                    arrayList2.add(new LatLng(point.latitude(), point.longitude()));
                }
                arrayList.add(arrayList2);
            }
        }
        return arrayList;
    }

    public Float getFillOpacity() {
        return Float.valueOf(this.jsonObject.get("fill-opacity").getAsFloat());
    }

    public void setFillOpacity(Float f) {
        this.jsonObject.addProperty("fill-opacity", f);
    }

    public int getFillColorAsInt() {
        return ColorUtils.rgbaToColor(this.jsonObject.get("fill-color").getAsString());
    }

    public String getFillColor() {
        return this.jsonObject.get("fill-color").getAsString();
    }

    public void setFillColor(int i) {
        this.jsonObject.addProperty("fill-color", ColorUtils.colorToRgbaString(i));
    }

    public void setFillColor(String str) {
        this.jsonObject.addProperty("fill-color", str);
    }

    public int getFillOutlineColorAsInt() {
        return ColorUtils.rgbaToColor(this.jsonObject.get("fill-outline-color").getAsString());
    }

    public String getFillOutlineColor() {
        return this.jsonObject.get("fill-outline-color").getAsString();
    }

    public void setFillOutlineColor(int i) {
        this.jsonObject.addProperty("fill-outline-color", ColorUtils.colorToRgbaString(i));
    }

    public void setFillOutlineColor(String str) {
        this.jsonObject.addProperty("fill-outline-color", str);
    }

    public String getFillPattern() {
        return this.jsonObject.get("fill-pattern").getAsString();
    }

    public void setFillPattern(String str) {
        this.jsonObject.addProperty("fill-pattern", str);
    }

    @Override // com.mapbox.mapboxsdk.plugins.annotation.Annotation
    Geometry getOffsetGeometry(Projection projection, MoveDistancesObject moveDistancesObject, float f, float f2) {
        List<List<Point>> coordinates = ((Polygon) this.geometry).coordinates();
        if (coordinates == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(coordinates.size());
        for (List<Point> list : coordinates) {
            ArrayList arrayList2 = new ArrayList();
            for (Point point : list) {
                PointF screenLocation = projection.toScreenLocation(new LatLng(point.latitude(), point.longitude()));
                screenLocation.x -= moveDistancesObject.getDistanceXSinceLast();
                screenLocation.y -= moveDistancesObject.getDistanceYSinceLast();
                LatLng fromScreenLocation = projection.fromScreenLocation(screenLocation);
                if (fromScreenLocation.getLatitude() > 85.05112877980659d || fromScreenLocation.getLatitude() < -85.05112877980659d) {
                    return null;
                }
                arrayList2.add(Point.fromLngLat(fromScreenLocation.getLongitude(), fromScreenLocation.getLatitude()));
            }
            arrayList.add(arrayList2);
        }
        return Polygon.fromLngLats(arrayList);
    }
}