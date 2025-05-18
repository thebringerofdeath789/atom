package com.mapbox.mapboxsdk.maps;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import androidx.collection.LongSparseArray;
import com.mapbox.mapboxsdk.C3178R;
import com.mapbox.mapboxsdk.Mapbox;
import com.mapbox.mapboxsdk.annotations.Annotation;
import com.mapbox.mapboxsdk.annotations.BaseMarkerOptions;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.Polygon;
import com.mapbox.mapboxsdk.annotations.PolygonOptions;
import com.mapbox.mapboxsdk.annotations.Polyline;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
class AnnotationManager {
    private static final long NO_ANNOTATION_ID = -1;
    private static final String TAG = "Mbgl-AnnotationManager";
    private Annotations annotations;
    private final LongSparseArray<Annotation> annotationsArray;
    private final IconManager iconManager;
    private final MapView mapView;
    private MapboxMap mapboxMap;
    private Markers markers;
    private MapboxMap.OnMarkerClickListener onMarkerClickListener;
    private MapboxMap.OnPolygonClickListener onPolygonClickListener;
    private MapboxMap.OnPolylineClickListener onPolylineClickListener;
    private Polygons polygons;
    private Polylines polylines;
    private ShapeAnnotations shapeAnnotations;
    private final InfoWindowManager infoWindowManager = new InfoWindowManager();
    private final List<Marker> selectedMarkers = new ArrayList();

    AnnotationManager(MapView mapView, LongSparseArray<Annotation> longSparseArray, IconManager iconManager, Annotations annotations, Markers markers, Polygons polygons, Polylines polylines, ShapeAnnotations shapeAnnotations) {
        this.mapView = mapView;
        this.annotationsArray = longSparseArray;
        this.iconManager = iconManager;
        this.annotations = annotations;
        this.markers = markers;
        this.polygons = polygons;
        this.polylines = polylines;
        this.shapeAnnotations = shapeAnnotations;
    }

    AnnotationManager bind(MapboxMap mapboxMap) {
        this.mapboxMap = mapboxMap;
        return this;
    }

    void update() {
        this.infoWindowManager.update();
    }

    Annotation getAnnotation(long j) {
        return this.annotations.obtainBy(j);
    }

    List<Annotation> getAnnotations() {
        return this.annotations.obtainAll();
    }

    void removeAnnotation(long j) {
        this.annotations.removeBy(j);
    }

    void removeAnnotation(Annotation annotation) {
        if (annotation instanceof Marker) {
            Marker marker = (Marker) annotation;
            marker.hideInfoWindow();
            if (this.selectedMarkers.contains(marker)) {
                this.selectedMarkers.remove(marker);
            }
            this.iconManager.iconCleanup(marker.getIcon());
        }
        this.annotations.removeBy(annotation);
    }

    void removeAnnotations(List<? extends Annotation> list) {
        for (Annotation annotation : list) {
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                marker.hideInfoWindow();
                if (this.selectedMarkers.contains(marker)) {
                    this.selectedMarkers.remove(marker);
                }
                this.iconManager.iconCleanup(marker.getIcon());
            }
        }
        this.annotations.removeBy(list);
    }

    void removeAnnotations() {
        int size = this.annotationsArray.size();
        long[] jArr = new long[size];
        this.selectedMarkers.clear();
        for (int i = 0; i < size; i++) {
            jArr[i] = this.annotationsArray.keyAt(i);
            Annotation annotation = this.annotationsArray.get(jArr[i]);
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                marker.hideInfoWindow();
                this.iconManager.iconCleanup(marker.getIcon());
            }
        }
        this.annotations.removeAll();
    }

    Marker addMarker(BaseMarkerOptions baseMarkerOptions, MapboxMap mapboxMap) {
        return this.markers.addBy(baseMarkerOptions, mapboxMap);
    }

    List<Marker> addMarkers(List<? extends BaseMarkerOptions> list, MapboxMap mapboxMap) {
        return this.markers.addBy(list, mapboxMap);
    }

    void updateMarker(Marker marker, MapboxMap mapboxMap) {
        if (!isAddedToMap(marker)) {
            logNonAdded(marker);
        } else {
            this.markers.update(marker, mapboxMap);
        }
    }

    List<Marker> getMarkers() {
        return this.markers.obtainAll();
    }

    List<Marker> getMarkersInRect(RectF rectF) {
        return this.markers.obtainAllIn(rectF);
    }

    void reloadMarkers() {
        this.markers.reload();
    }

    Polygon addPolygon(PolygonOptions polygonOptions, MapboxMap mapboxMap) {
        return this.polygons.addBy(polygonOptions, mapboxMap);
    }

    List<Polygon> addPolygons(List<PolygonOptions> list, MapboxMap mapboxMap) {
        return this.polygons.addBy(list, mapboxMap);
    }

    void updatePolygon(Polygon polygon) {
        if (!isAddedToMap(polygon)) {
            logNonAdded(polygon);
        } else {
            this.polygons.update(polygon);
        }
    }

    List<Polygon> getPolygons() {
        return this.polygons.obtainAll();
    }

    Polyline addPolyline(PolylineOptions polylineOptions, MapboxMap mapboxMap) {
        return this.polylines.addBy(polylineOptions, mapboxMap);
    }

    List<Polyline> addPolylines(List<PolylineOptions> list, MapboxMap mapboxMap) {
        return this.polylines.addBy(list, mapboxMap);
    }

    void updatePolyline(Polyline polyline) {
        if (!isAddedToMap(polyline)) {
            logNonAdded(polyline);
        } else {
            this.polylines.update(polyline);
        }
    }

    List<Polyline> getPolylines() {
        return this.polylines.obtainAll();
    }

    void setOnMarkerClickListener(MapboxMap.OnMarkerClickListener onMarkerClickListener) {
        this.onMarkerClickListener = onMarkerClickListener;
    }

    void setOnPolygonClickListener(MapboxMap.OnPolygonClickListener onPolygonClickListener) {
        this.onPolygonClickListener = onPolygonClickListener;
    }

    void setOnPolylineClickListener(MapboxMap.OnPolylineClickListener onPolylineClickListener) {
        this.onPolylineClickListener = onPolylineClickListener;
    }

    void selectMarker(Marker marker) {
        if (this.selectedMarkers.contains(marker)) {
            return;
        }
        if (!this.infoWindowManager.isAllowConcurrentMultipleOpenInfoWindows()) {
            deselectMarkers();
        }
        if (this.infoWindowManager.isInfoWindowValidForMarker(marker) || this.infoWindowManager.getInfoWindowAdapter() != null) {
            this.infoWindowManager.add(marker.showInfoWindow(this.mapboxMap, this.mapView));
        }
        this.selectedMarkers.add(marker);
    }

    void deselectMarkers() {
        if (this.selectedMarkers.isEmpty()) {
            return;
        }
        for (Marker marker : this.selectedMarkers) {
            if (marker != null && marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
            }
        }
        this.selectedMarkers.clear();
    }

    void deselectMarker(Marker marker) {
        if (this.selectedMarkers.contains(marker)) {
            if (marker.isInfoWindowShown()) {
                marker.hideInfoWindow();
            }
            this.selectedMarkers.remove(marker);
        }
    }

    List<Marker> getSelectedMarkers() {
        return this.selectedMarkers;
    }

    InfoWindowManager getInfoWindowManager() {
        return this.infoWindowManager;
    }

    void adjustTopOffsetPixels(MapboxMap mapboxMap) {
        int size = this.annotationsArray.size();
        for (int i = 0; i < size; i++) {
            Annotation annotation = this.annotationsArray.get(i);
            if (annotation instanceof Marker) {
                Marker marker = (Marker) annotation;
                marker.setTopOffsetPixels(this.iconManager.getTopOffsetPixelsForIcon(marker.getIcon()));
            }
        }
        for (Marker marker2 : this.selectedMarkers) {
            if (marker2.isInfoWindowShown()) {
                marker2.hideInfoWindow();
                marker2.showInfoWindow(mapboxMap, this.mapView);
            }
        }
    }

    private boolean isAddedToMap(Annotation annotation) {
        return (annotation == null || annotation.getId() == -1 || this.annotationsArray.indexOfKey(annotation.getId()) <= -1) ? false : true;
    }

    private void logNonAdded(Annotation annotation) {
        Logger.m1762w(TAG, String.format("Attempting to update non-added %s with value %s", annotation.getClass().getCanonicalName(), annotation));
    }

    boolean onTap(PointF pointF) {
        long execute = new MarkerHitResolver(this.mapboxMap).execute(getMarkerHitFromTouchArea(pointF));
        if (execute != -1 && isClickHandledForMarker(execute)) {
            return true;
        }
        Annotation execute2 = new ShapeAnnotationHitResolver(this.shapeAnnotations).execute(getShapeAnnotationHitFromTap(pointF));
        return execute2 != null && handleClickForShapeAnnotation(execute2);
    }

    private ShapeAnnotationHit getShapeAnnotationHitFromTap(PointF pointF) {
        float dimension = Mapbox.getApplicationContext().getResources().getDimension(C3178R.dimen.mapbox_eight_dp);
        return new ShapeAnnotationHit(new RectF(pointF.x - dimension, pointF.y - dimension, pointF.x + dimension, pointF.y + dimension));
    }

    private boolean handleClickForShapeAnnotation(Annotation annotation) {
        MapboxMap.OnPolylineClickListener onPolylineClickListener;
        MapboxMap.OnPolygonClickListener onPolygonClickListener;
        if ((annotation instanceof Polygon) && (onPolygonClickListener = this.onPolygonClickListener) != null) {
            onPolygonClickListener.onPolygonClick((Polygon) annotation);
            return true;
        }
        if (!(annotation instanceof Polyline) || (onPolylineClickListener = this.onPolylineClickListener) == null) {
            return false;
        }
        onPolylineClickListener.onPolylineClick((Polyline) annotation);
        return true;
    }

    private MarkerHit getMarkerHitFromTouchArea(PointF pointF) {
        float highestIconHeight = (int) (this.iconManager.getHighestIconHeight() * 1.5d);
        float highestIconWidth = (int) (this.iconManager.getHighestIconWidth() * 1.5d);
        RectF rectF = new RectF(pointF.x - highestIconHeight, pointF.y - highestIconWidth, pointF.x + highestIconHeight, pointF.y + highestIconWidth);
        return new MarkerHit(rectF, getMarkersInRect(rectF));
    }

    private boolean isClickHandledForMarker(long j) {
        Marker marker = (Marker) getAnnotation(j);
        if (onClickMarker(marker)) {
            return true;
        }
        toggleMarkerSelectionState(marker);
        return true;
    }

    private boolean onClickMarker(Marker marker) {
        MapboxMap.OnMarkerClickListener onMarkerClickListener = this.onMarkerClickListener;
        return onMarkerClickListener != null && onMarkerClickListener.onMarkerClick(marker);
    }

    private void toggleMarkerSelectionState(Marker marker) {
        if (!this.selectedMarkers.contains(marker)) {
            selectMarker(marker);
        } else {
            deselectMarker(marker);
        }
    }

    private static class ShapeAnnotationHitResolver {
        private ShapeAnnotations shapeAnnotations;

        ShapeAnnotationHitResolver(ShapeAnnotations shapeAnnotations) {
            this.shapeAnnotations = shapeAnnotations;
        }

        public Annotation execute(ShapeAnnotationHit shapeAnnotationHit) {
            List<Annotation> obtainAllIn = this.shapeAnnotations.obtainAllIn(shapeAnnotationHit.tapPoint);
            if (obtainAllIn.size() > 0) {
                return obtainAllIn.get(0);
            }
            return null;
        }
    }

    private static class MarkerHitResolver {
        private Bitmap bitmap;
        private int bitmapHeight;
        private int bitmapWidth;
        private PointF markerLocation;
        private final Projection projection;
        private View view;
        private Rect hitRectView = new Rect();
        private RectF hitRectMarker = new RectF();
        private RectF highestSurfaceIntersection = new RectF();
        private long closestMarkerId = -1;
        private final int minimalTouchSize = (int) (Mapbox.getApplicationContext().getResources().getDisplayMetrics().density * 32.0f);

        MarkerHitResolver(MapboxMap mapboxMap) {
            this.projection = mapboxMap.getProjection();
        }

        public long execute(MarkerHit markerHit) {
            resolveForMarkers(markerHit);
            return this.closestMarkerId;
        }

        private void resolveForMarkers(MarkerHit markerHit) {
            Iterator it = markerHit.markers.iterator();
            while (it.hasNext()) {
                resolveForMarker(markerHit, (Marker) it.next());
            }
        }

        private void resolveForMarker(MarkerHit markerHit, Marker marker) {
            this.markerLocation = this.projection.toScreenLocation(marker.getPosition());
            Bitmap bitmap = marker.getIcon().getBitmap();
            this.bitmap = bitmap;
            int height = bitmap.getHeight();
            this.bitmapHeight = height;
            int i = this.minimalTouchSize;
            if (height < i) {
                this.bitmapHeight = i;
            }
            int width = this.bitmap.getWidth();
            this.bitmapWidth = width;
            int i2 = this.minimalTouchSize;
            if (width < i2) {
                this.bitmapWidth = i2;
            }
            this.hitRectMarker.set(0.0f, 0.0f, this.bitmapWidth, this.bitmapHeight);
            this.hitRectMarker.offsetTo(this.markerLocation.x - (this.bitmapWidth / 2), this.markerLocation.y - (this.bitmapHeight / 2));
            hitTestMarker(markerHit, marker, this.hitRectMarker);
        }

        private void hitTestMarker(MarkerHit markerHit, Marker marker, RectF rectF) {
            if (rectF.contains(markerHit.getTapPointX(), markerHit.getTapPointY())) {
                rectF.intersect(markerHit.tapRect);
                if (isRectangleHighestSurfaceIntersection(rectF)) {
                    this.highestSurfaceIntersection = new RectF(rectF);
                    this.closestMarkerId = marker.getId();
                }
            }
        }

        private boolean isRectangleHighestSurfaceIntersection(RectF rectF) {
            return rectF.width() * rectF.height() > this.highestSurfaceIntersection.width() * this.highestSurfaceIntersection.height();
        }
    }

    private static class ShapeAnnotationHit {
        private final RectF tapPoint;

        ShapeAnnotationHit(RectF rectF) {
            this.tapPoint = rectF;
        }
    }

    private static class MarkerHit {
        private final List<Marker> markers;
        private final RectF tapRect;

        MarkerHit(RectF rectF, List<Marker> list) {
            this.tapRect = rectF;
            this.markers = list;
        }

        float getTapPointX() {
            return this.tapRect.centerX();
        }

        float getTapPointY() {
            return this.tapRect.centerY();
        }
    }
}