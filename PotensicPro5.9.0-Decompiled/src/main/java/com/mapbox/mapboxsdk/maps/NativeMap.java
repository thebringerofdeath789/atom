package com.mapbox.mapboxsdk.maps;

import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Geometry;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.Polygon;
import com.mapbox.mapboxsdk.annotations.Polyline;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.geometry.LatLngBoundsZoom;
import com.mapbox.mapboxsdk.geometry.ProjectedMeters;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import com.mapbox.mapboxsdk.style.layers.Layer;
import com.mapbox.mapboxsdk.style.layers.TransitionOptions;
import com.mapbox.mapboxsdk.style.light.Light;
import com.mapbox.mapboxsdk.style.sources.Source;
import java.util.List;

/* loaded from: classes3.dex */
interface NativeMap {
    void addAnnotationIcon(String str, int i, int i2, float f, byte[] bArr);

    void addImages(Image[] imageArr);

    void addLayer(Layer layer);

    void addLayerAbove(Layer layer, String str);

    void addLayerAt(Layer layer, int i);

    void addLayerBelow(Layer layer, String str);

    long addMarker(Marker marker);

    long[] addMarkers(List<Marker> list);

    long addPolygon(Polygon polygon);

    long[] addPolygons(List<Polygon> list);

    long addPolyline(Polyline polyline);

    long[] addPolylines(List<Polyline> list);

    void addSnapshotCallback(MapboxMap.SnapshotReadyCallback snapshotReadyCallback);

    void addSource(Source source);

    void cancelTransitions();

    void destroy();

    void easeTo(LatLng latLng, double d, double d2, double d3, double[] dArr, long j, boolean z);

    void flyTo(LatLng latLng, double d, double d2, double d3, double[] dArr, long j);

    double getBearing();

    CameraPosition getCameraForGeometry(Geometry geometry, int[] iArr, double d, double d2);

    CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, int[] iArr, double d, double d2);

    CameraPosition getCameraPosition();

    double[] getContentPadding();

    boolean getDebug();

    RectF getDensityDependantRectangle(RectF rectF);

    Bitmap getImage(String str);

    LatLng getLatLng();

    LatLngBoundsZoom getLatLngBoundsZoomFromCamera(CameraPosition cameraPosition);

    Layer getLayer(String str);

    List<Layer> getLayers();

    Light getLight();

    double getMaxPitch();

    double getMaxZoom();

    double getMetersPerPixelAtLatitude(double d);

    double getMinPitch();

    double getMinZoom();

    long getNativePtr();

    double getPitch();

    float getPixelRatio();

    boolean getPrefetchTiles();

    int getPrefetchZoomDelta();

    Source getSource(String str);

    List<Source> getSources();

    String getStyleJson();

    String getStyleUri();

    double getTopOffsetPixelsForAnnotationSymbol(String str);

    TransitionOptions getTransitionOptions();

    void getVisibleCoordinateBounds(double[] dArr);

    double getZoom();

    boolean isDestroyed();

    boolean isFullyLoaded();

    boolean isUserAnimationInProgress();

    void jumpTo(LatLng latLng, double d, double d2, double d3, double[] dArr);

    LatLng latLngForPixel(PointF pointF);

    LatLng latLngForProjectedMeters(ProjectedMeters projectedMeters);

    void latLngsForPixels(double[] dArr, double[] dArr2);

    void moveBy(double d, double d2, long j);

    void onLowMemory();

    PointF pixelForLatLng(LatLng latLng);

    void pixelsForLatLngs(double[] dArr, double[] dArr2);

    ProjectedMeters projectedMetersForLatLng(LatLng latLng);

    long[] queryPointAnnotations(RectF rectF);

    List<Feature> queryRenderedFeatures(PointF pointF, String[] strArr, Expression expression);

    List<Feature> queryRenderedFeatures(RectF rectF, String[] strArr, Expression expression);

    long[] queryShapeAnnotations(RectF rectF);

    void removeAnnotation(long j);

    void removeAnnotationIcon(String str);

    void removeAnnotations(long[] jArr);

    void removeImage(String str);

    boolean removeLayer(Layer layer);

    boolean removeLayer(String str);

    boolean removeLayerAt(int i);

    boolean removeSource(Source source);

    boolean removeSource(String str);

    void resetNorth();

    void resetPosition();

    void resetZoom();

    void resizeView(int i, int i2);

    void rotateBy(double d, double d2, double d3, double d4, long j);

    void setApiBaseUrl(String str);

    void setBearing(double d, double d2, double d3, long j);

    void setBearing(double d, long j);

    void setContentPadding(double[] dArr);

    void setDebug(boolean z);

    void setGestureInProgress(boolean z);

    void setLatLng(LatLng latLng, long j);

    void setLatLngBounds(LatLngBounds latLngBounds);

    void setMaxPitch(double d);

    void setMaxZoom(double d);

    void setMinPitch(double d);

    void setMinZoom(double d);

    void setOnFpsChangedListener(MapboxMap.OnFpsChangedListener onFpsChangedListener);

    void setPitch(double d, long j);

    void setPrefetchTiles(boolean z);

    void setPrefetchZoomDelta(int i);

    void setReachability(boolean z);

    void setStyleJson(String str);

    void setStyleUri(String str);

    void setTransitionOptions(TransitionOptions transitionOptions);

    void setUserAnimationInProgress(boolean z);

    void setVisibleCoordinateBounds(LatLng[] latLngArr, RectF rectF, double d, long j);

    void setZoom(double d, PointF pointF, long j);

    void subscribe(Observer observer, List<String> list);

    void triggerRepaint();

    void unsubscribe(Observer observer);

    void unsubscribe(Observer observer, List<String> list);

    void updateMarker(Marker marker);

    void updatePolygon(Polygon polygon);

    void updatePolyline(Polyline polyline);
}
