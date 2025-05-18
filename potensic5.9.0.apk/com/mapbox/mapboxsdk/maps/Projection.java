package com.mapbox.mapboxsdk.maps;

import android.graphics.PointF;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.geometry.ProjectedMeters;
import com.mapbox.mapboxsdk.geometry.VisibleRegion;
import java.util.ArrayList;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class Projection {
    private final MapView mapView;
    private final NativeMap nativeMapView;

    static double degreesToRadians(double d) {
        return ((d % 360.0d) * 3.141592653589793d) / 180.0d;
    }

    static double radiansToDegrees(double d) {
        return ((d % 6.283185307179586d) * 180.0d) / 3.141592653589793d;
    }

    @Deprecated
    public void invalidateContentPadding() {
    }

    Projection(NativeMap nativeMap, MapView mapView) {
        this.nativeMapView = nativeMap;
        this.mapView = mapView;
    }

    void setContentPadding(int[] iArr) {
        double[] dArr = new double[iArr.length];
        for (int i = 0; i < iArr.length; i++) {
            dArr[i] = iArr[i];
        }
        this.nativeMapView.setContentPadding(dArr);
    }

    int[] getContentPadding() {
        double[] dArr = this.nativeMapView.getCameraPosition().padding;
        return new int[]{(int) dArr[0], (int) dArr[1], (int) dArr[2], (int) dArr[3]};
    }

    public ProjectedMeters getProjectedMetersForLatLng(LatLng latLng) {
        return this.nativeMapView.projectedMetersForLatLng(latLng);
    }

    public LatLng getLatLngForProjectedMeters(ProjectedMeters projectedMeters) {
        return this.nativeMapView.latLngForProjectedMeters(projectedMeters);
    }

    public double getMetersPerPixelAtLatitude(double d) {
        return this.nativeMapView.getMetersPerPixelAtLatitude(d);
    }

    public LatLng fromScreenLocation(PointF pointF) {
        return this.nativeMapView.latLngForPixel(pointF);
    }

    public void fromScreenLocations(double[] dArr, double[] dArr2) {
        this.nativeMapView.latLngsForPixels(dArr, dArr2);
    }

    public VisibleRegion getVisibleRegion() {
        return getVisibleRegion(true);
    }

    public VisibleRegion getVisibleRegion(boolean z) {
        float f;
        float height;
        float f2;
        Iterator it;
        float f3 = 0.0f;
        if (z) {
            f2 = this.mapView.getWidth();
            height = this.mapView.getHeight();
            f = 0.0f;
        } else {
            int[] contentPadding = getContentPadding();
            float f4 = contentPadding[0];
            float width = this.mapView.getWidth() - contentPadding[2];
            f = contentPadding[1];
            height = this.mapView.getHeight() - contentPadding[3];
            f3 = f4;
            f2 = width;
        }
        LatLng fromScreenLocation = fromScreenLocation(new PointF(((f2 - f3) / 2.0f) + f3, ((height - f) / 2.0f) + f));
        LatLng fromScreenLocation2 = fromScreenLocation(new PointF(f3, f));
        LatLng fromScreenLocation3 = fromScreenLocation(new PointF(f2, f));
        LatLng fromScreenLocation4 = fromScreenLocation(new PointF(f2, height));
        LatLng fromScreenLocation5 = fromScreenLocation(new PointF(f3, height));
        ArrayList arrayList = new ArrayList();
        arrayList.add(fromScreenLocation3);
        arrayList.add(fromScreenLocation4);
        arrayList.add(fromScreenLocation5);
        arrayList.add(fromScreenLocation2);
        Iterator it2 = arrayList.iterator();
        double d = 0.0d;
        double d2 = -90.0d;
        double d3 = 90.0d;
        double d4 = 0.0d;
        double d5 = 0.0d;
        double d6 = 0.0d;
        double d7 = 0.0d;
        while (it2.hasNext()) {
            LatLng latLng = (LatLng) it2.next();
            if (bearing(fromScreenLocation, latLng) >= d) {
                it = it2;
                double longitudeSpan = getLongitudeSpan(latLng.getLongitude(), fromScreenLocation.getLongitude());
                if (longitudeSpan > d5) {
                    d6 = latLng.getLongitude();
                    d5 = longitudeSpan;
                }
            } else {
                it = it2;
                double longitudeSpan2 = getLongitudeSpan(fromScreenLocation.getLongitude(), latLng.getLongitude());
                if (longitudeSpan2 > d4) {
                    d7 = latLng.getLongitude();
                    d4 = longitudeSpan2;
                }
            }
            if (d2 < latLng.getLatitude()) {
                d2 = latLng.getLatitude();
            }
            if (d3 > latLng.getLatitude()) {
                d3 = latLng.getLatitude();
            }
            it2 = it;
            d = 0.0d;
        }
        if (d6 < d7) {
            return new VisibleRegion(fromScreenLocation2, fromScreenLocation3, fromScreenLocation5, fromScreenLocation4, LatLngBounds.from(d2, d6 + 360.0d, d3, d7));
        }
        return new VisibleRegion(fromScreenLocation2, fromScreenLocation3, fromScreenLocation5, fromScreenLocation4, LatLngBounds.from(d2, d6, d3, d7));
    }

    public void getVisibleCoordinateBounds(double[] dArr) {
        this.nativeMapView.getVisibleCoordinateBounds(dArr);
    }

    static double bearing(LatLng latLng, LatLng latLng2) {
        double degreesToRadians = degreesToRadians(latLng.getLongitude());
        double degreesToRadians2 = degreesToRadians(latLng2.getLongitude());
        double degreesToRadians3 = degreesToRadians(latLng.getLatitude());
        double degreesToRadians4 = degreesToRadians(latLng2.getLatitude());
        double d = degreesToRadians2 - degreesToRadians;
        return radiansToDegrees(Math.atan2(Math.sin(d) * Math.cos(degreesToRadians4), (Math.cos(degreesToRadians3) * Math.sin(degreesToRadians4)) - ((Math.sin(degreesToRadians3) * Math.cos(degreesToRadians4)) * Math.cos(d))));
    }

    static double getLongitudeSpan(double d, double d2) {
        double abs = Math.abs(d - d2);
        return d > d2 ? abs : 360.0d - abs;
    }

    public PointF toScreenLocation(LatLng latLng) {
        return this.nativeMapView.pixelForLatLng(latLng);
    }

    public void toScreenLocations(double[] dArr, double[] dArr2) {
        this.nativeMapView.pixelsForLatLngs(dArr, dArr2);
    }

    float getHeight() {
        return this.mapView.getHeight();
    }

    float getWidth() {
        return this.mapView.getWidth();
    }

    public double calculateZoom(float f) {
        return this.nativeMapView.getZoom() + (Math.log(f) / Math.log(2.0d));
    }
}