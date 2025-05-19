package com.mapbox.mapboxsdk.maps;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.PointF;
import android.graphics.RectF;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import com.mapbox.android.gestures.AndroidGesturesManager;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.android.gestures.RotateGestureDetector;
import com.mapbox.android.gestures.ShoveGestureDetector;
import com.mapbox.android.gestures.StandardScaleGestureDetector;
import com.mapbox.geojson.Feature;
import com.mapbox.geojson.Geometry;
import com.mapbox.mapboxsdk.MapStrictMode;
import com.mapbox.mapboxsdk.annotations.Annotation;
import com.mapbox.mapboxsdk.annotations.BaseMarkerOptions;
import com.mapbox.mapboxsdk.annotations.Marker;
import com.mapbox.mapboxsdk.annotations.MarkerOptions;
import com.mapbox.mapboxsdk.annotations.Polygon;
import com.mapbox.mapboxsdk.annotations.PolygonOptions;
import com.mapbox.mapboxsdk.annotations.Polyline;
import com.mapbox.mapboxsdk.annotations.PolylineOptions;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.constants.MapboxConstants;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.geometry.LatLngBounds;
import com.mapbox.mapboxsdk.geometry.LatLngBoundsZoom;
import com.mapbox.mapboxsdk.location.LocationComponent;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.Style;
import com.mapbox.mapboxsdk.offline.OfflineRegionDefinition;
import com.mapbox.mapboxsdk.style.expressions.Expression;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes3.dex */
public final class MapboxMap {
    private static final String TAG = "Mbgl-MapboxMap";
    private AnnotationManager annotationManager;
    private final List<Style.OnStyleLoaded> awaitingStyleGetters = new ArrayList();
    private final CameraChangeDispatcher cameraChangeDispatcher;
    private boolean debugActive;
    private final List<OnDeveloperAnimationListener> developerAnimationStartedListeners;
    private LocationComponent locationComponent;
    private final NativeMap nativeMapView;
    private OnFpsChangedListener onFpsChangedListener;
    private final OnGesturesManagerInteractionListener onGesturesManagerInteractionListener;
    private final Projection projection;
    private boolean started;
    private Style style;
    private Style.OnStyleLoaded styleLoadedCallback;
    private final Transform transform;
    private final UiSettings uiSettings;

    public interface CancelableCallback {
        void onCancel();

        void onFinish();
    }

    @Deprecated
    public interface InfoWindowAdapter {
        View getInfoWindow(Marker marker);
    }

    public interface OnCameraIdleListener {
        void onCameraIdle();
    }

    public interface OnCameraMoveCanceledListener {
        void onCameraMoveCanceled();
    }

    public interface OnCameraMoveListener {
        void onCameraMove();
    }

    public interface OnCameraMoveStartedListener {
        public static final int REASON_API_ANIMATION = 3;
        public static final int REASON_API_GESTURE = 1;
        public static final int REASON_DEVELOPER_ANIMATION = 2;

        void onCameraMoveStarted(int i);
    }

    public interface OnCompassAnimationListener {
        void onCompassAnimation();

        void onCompassAnimationFinished();
    }

    public interface OnDeveloperAnimationListener {
        void onDeveloperAnimationStarted();
    }

    public interface OnFlingListener {
        void onFling();
    }

    public interface OnFpsChangedListener {
        void onFpsChanged(double d);
    }

    interface OnGesturesManagerInteractionListener {
        void cancelAllVelocityAnimations();

        AndroidGesturesManager getGesturesManager();

        void onAddFlingListener(OnFlingListener onFlingListener);

        void onAddMapClickListener(OnMapClickListener onMapClickListener);

        void onAddMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

        void onAddMoveListener(OnMoveListener onMoveListener);

        void onAddRotateListener(OnRotateListener onRotateListener);

        void onAddScaleListener(OnScaleListener onScaleListener);

        void onAddShoveListener(OnShoveListener onShoveListener);

        void onRemoveFlingListener(OnFlingListener onFlingListener);

        void onRemoveMapClickListener(OnMapClickListener onMapClickListener);

        void onRemoveMapLongClickListener(OnMapLongClickListener onMapLongClickListener);

        void onRemoveMoveListener(OnMoveListener onMoveListener);

        void onRemoveRotateListener(OnRotateListener onRotateListener);

        void onRemoveScaleListener(OnScaleListener onScaleListener);

        void onRemoveShoveListener(OnShoveListener onShoveListener);

        void setGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z, boolean z2);
    }

    public interface OnInfoWindowClickListener {
        boolean onInfoWindowClick(Marker marker);
    }

    public interface OnInfoWindowCloseListener {
        void onInfoWindowClose(Marker marker);
    }

    public interface OnInfoWindowLongClickListener {
        void onInfoWindowLongClick(Marker marker);
    }

    public interface OnMapClickListener {
        boolean onMapClick(LatLng latLng);
    }

    public interface OnMapLongClickListener {
        boolean onMapLongClick(LatLng latLng);
    }

    @Deprecated
    public interface OnMarkerClickListener {
        boolean onMarkerClick(Marker marker);
    }

    public interface OnMoveListener {
        void onMove(MoveGestureDetector moveGestureDetector);

        void onMoveBegin(MoveGestureDetector moveGestureDetector);

        void onMoveEnd(MoveGestureDetector moveGestureDetector);
    }

    @Deprecated
    public interface OnPolygonClickListener {
        void onPolygonClick(Polygon polygon);
    }

    @Deprecated
    public interface OnPolylineClickListener {
        void onPolylineClick(Polyline polyline);
    }

    public interface OnRotateListener {
        void onRotate(RotateGestureDetector rotateGestureDetector);

        void onRotateBegin(RotateGestureDetector rotateGestureDetector);

        void onRotateEnd(RotateGestureDetector rotateGestureDetector);
    }

    public interface OnScaleListener {
        void onScale(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector);
    }

    public interface OnShoveListener {
        void onShove(ShoveGestureDetector shoveGestureDetector);

        void onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector);
    }

    public interface SnapshotReadyCallback {
        void onSnapshotReady(Bitmap bitmap);
    }

    MapboxMap(NativeMap nativeMap, Transform transform, UiSettings uiSettings, Projection projection, OnGesturesManagerInteractionListener onGesturesManagerInteractionListener, CameraChangeDispatcher cameraChangeDispatcher, List<OnDeveloperAnimationListener> list) {
        this.nativeMapView = nativeMap;
        this.uiSettings = uiSettings;
        this.projection = projection;
        this.transform = transform;
        this.onGesturesManagerInteractionListener = onGesturesManagerInteractionListener;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
        this.developerAnimationStartedListeners = list;
    }

    public void triggerRepaint() {
        this.nativeMapView.triggerRepaint();
    }

    void initialise(Context context, MapboxMapOptions mapboxMapOptions) {
        this.transform.initialise(this, mapboxMapOptions);
        this.uiSettings.initialise(context, mapboxMapOptions);
        setDebugActive(mapboxMapOptions.getDebugActive());
        setApiBaseUrl(mapboxMapOptions);
        setPrefetchesTiles(mapboxMapOptions);
    }

    public void getStyle(Style.OnStyleLoaded onStyleLoaded) {
        Style style = this.style;
        if (style != null && style.isFullyLoaded()) {
            onStyleLoaded.onStyleLoaded(this.style);
        } else {
            this.awaitingStyleGetters.add(onStyleLoaded);
        }
    }

    public Style getStyle() {
        Style style = this.style;
        if (style == null || !style.isFullyLoaded()) {
            return null;
        }
        return this.style;
    }

    void onStart() {
        this.started = true;
        this.locationComponent.onStart();
    }

    void onStop() {
        this.started = false;
        this.locationComponent.onStop();
    }

    void onSaveInstanceState(Bundle bundle) {
        bundle.putParcelable(MapboxConstants.STATE_CAMERA_POSITION, this.transform.getCameraPosition());
        bundle.putBoolean(MapboxConstants.STATE_DEBUG_ACTIVE, isDebugActive());
        this.uiSettings.onSaveInstanceState(bundle);
    }

    void onRestoreInstanceState(Bundle bundle) {
        CameraPosition cameraPosition = (CameraPosition) bundle.getParcelable(MapboxConstants.STATE_CAMERA_POSITION);
        this.uiSettings.onRestoreInstanceState(bundle);
        if (cameraPosition != null) {
            moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder(cameraPosition).build()));
        }
        this.nativeMapView.setDebug(bundle.getBoolean(MapboxConstants.STATE_DEBUG_ACTIVE));
    }

    void onDestroy() {
        this.locationComponent.onDestroy();
        Style style = this.style;
        if (style != null) {
            style.clear();
        }
        this.cameraChangeDispatcher.onDestroy();
    }

    void onPreMapReady() {
        this.transform.invalidateCameraPosition();
        this.annotationManager.reloadMarkers();
        this.annotationManager.adjustTopOffsetPixels(this);
    }

    void onPostMapReady() {
        this.transform.invalidateCameraPosition();
    }

    void onFinishLoadingStyle() {
        notifyStyleLoaded();
    }

    void onFailLoadingStyle() {
        this.styleLoadedCallback = null;
    }

    void onUpdateRegionChange() {
        this.annotationManager.update();
    }

    void onUpdateFullyRendered() {
        CameraPosition invalidateCameraPosition = this.transform.invalidateCameraPosition();
        if (invalidateCameraPosition != null) {
            this.uiSettings.update(invalidateCameraPosition);
        }
    }

    long getNativeMapPtr() {
        return this.nativeMapView.getNativePtr();
    }

    private void setPrefetchesTiles(MapboxMapOptions mapboxMapOptions) {
        if (!mapboxMapOptions.getPrefetchesTiles()) {
            setPrefetchZoomDelta(0);
        } else {
            setPrefetchZoomDelta(mapboxMapOptions.getPrefetchZoomDelta());
        }
    }

    @Deprecated
    public void setPrefetchesTiles(boolean z) {
        this.nativeMapView.setPrefetchTiles(z);
    }

    @Deprecated
    public boolean getPrefetchesTiles() {
        return this.nativeMapView.getPrefetchTiles();
    }

    public void setPrefetchZoomDelta(int i) {
        this.nativeMapView.setPrefetchZoomDelta(i);
    }

    public int getPrefetchZoomDelta() {
        return this.nativeMapView.getPrefetchZoomDelta();
    }

    public void setMinZoomPreference(double d) {
        this.transform.setMinZoom(d);
    }

    public double getMinZoomLevel() {
        return this.transform.getMinZoom();
    }

    public void setMaxZoomPreference(double d) {
        this.transform.setMaxZoom(d);
    }

    public double getMaxZoomLevel() {
        return this.transform.getMaxZoom();
    }

    public void setMinPitchPreference(double d) {
        this.transform.setMinPitch(d);
    }

    public double getMinPitch() {
        return this.transform.getMinPitch();
    }

    public void setMaxPitchPreference(double d) {
        this.transform.setMaxPitch(d);
    }

    public double getMaxPitch() {
        return this.transform.getMaxPitch();
    }

    public UiSettings getUiSettings() {
        return this.uiSettings;
    }

    public Projection getProjection() {
        return this.projection;
    }

    public void cancelTransitions() {
        this.transform.cancelTransitions();
    }

    public final CameraPosition getCameraPosition() {
        return this.transform.getCameraPosition();
    }

    public void setCameraPosition(CameraPosition cameraPosition) {
        moveCamera(CameraUpdateFactory.newCameraPosition(cameraPosition), null);
    }

    public final void moveCamera(CameraUpdate cameraUpdate) {
        moveCamera(cameraUpdate, null);
    }

    public final void moveCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        notifyDeveloperAnimationListeners();
        this.transform.moveCamera(this, cameraUpdate, cancelableCallback);
    }

    public final void easeCamera(CameraUpdate cameraUpdate) {
        easeCamera(cameraUpdate, 300);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        easeCamera(cameraUpdate, 300, cancelableCallback);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i) {
        easeCamera(cameraUpdate, i, (CancelableCallback) null);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        easeCamera(cameraUpdate, i, true, cancelableCallback);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i, boolean z) {
        easeCamera(cameraUpdate, i, z, null);
    }

    public final void easeCamera(CameraUpdate cameraUpdate, int i, boolean z, CancelableCallback cancelableCallback) {
        if (i <= 0) {
            throw new IllegalArgumentException("Null duration passed into easeCamera");
        }
        notifyDeveloperAnimationListeners();
        this.transform.easeCamera(this, cameraUpdate, i, z, cancelableCallback);
    }

    public final void animateCamera(CameraUpdate cameraUpdate) {
        animateCamera(cameraUpdate, 300, null);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, CancelableCallback cancelableCallback) {
        animateCamera(cameraUpdate, 300, cancelableCallback);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i) {
        animateCamera(cameraUpdate, i, null);
    }

    public final void animateCamera(CameraUpdate cameraUpdate, int i, CancelableCallback cancelableCallback) {
        if (i <= 0) {
            throw new IllegalArgumentException("Null duration passed into animateCamera");
        }
        notifyDeveloperAnimationListeners();
        this.transform.animateCamera(this, cameraUpdate, i, cancelableCallback);
    }

    public void scrollBy(float f, float f2) {
        scrollBy(f, f2, 0L);
    }

    public void scrollBy(float f, float f2, long j) {
        notifyDeveloperAnimationListeners();
        this.nativeMapView.moveBy(f, f2, j);
    }

    public void resetNorth() {
        notifyDeveloperAnimationListeners();
        this.transform.resetNorth();
    }

    public void setFocalBearing(double d, float f, float f2, long j) {
        notifyDeveloperAnimationListeners();
        this.transform.setBearing(d, f, f2, j);
    }

    public float getHeight() {
        return this.projection.getHeight();
    }

    public float getWidth() {
        return this.projection.getWidth();
    }

    public void setOfflineRegionDefinition(OfflineRegionDefinition offlineRegionDefinition) {
        setOfflineRegionDefinition(offlineRegionDefinition, null);
    }

    public void setOfflineRegionDefinition(OfflineRegionDefinition offlineRegionDefinition, Style.OnStyleLoaded onStyleLoaded) {
        double minZoom = offlineRegionDefinition.getMinZoom();
        double maxZoom = offlineRegionDefinition.getMaxZoom();
        moveCamera(CameraUpdateFactory.newCameraPosition(new CameraPosition.Builder().target(offlineRegionDefinition.getBounds().getCenter()).zoom(minZoom).build()));
        setMinZoomPreference(minZoom);
        setMaxZoomPreference(maxZoom);
        setStyle(new Style.Builder().fromUri(offlineRegionDefinition.getStyleURL()), onStyleLoaded);
    }

    public boolean isDebugActive() {
        return this.debugActive;
    }

    public void setDebugActive(boolean z) {
        this.debugActive = z;
        this.nativeMapView.setDebug(z);
    }

    @Deprecated
    public void cycleDebugOptions() {
        boolean z = !this.nativeMapView.getDebug();
        this.debugActive = z;
        this.nativeMapView.setDebug(z);
    }

    private void setApiBaseUrl(MapboxMapOptions mapboxMapOptions) {
        String apiBaseUrl = mapboxMapOptions.getApiBaseUrl();
        if (TextUtils.isEmpty(apiBaseUrl)) {
            return;
        }
        this.nativeMapView.setApiBaseUrl(apiBaseUrl);
    }

    public void setStyle(String str) {
        setStyle(str, (Style.OnStyleLoaded) null);
    }

    public void setStyle(String str, Style.OnStyleLoaded onStyleLoaded) {
        setStyle(new Style.Builder().fromUri(str), onStyleLoaded);
    }

    public void setStyle(Style.Builder builder) {
        setStyle(builder, (Style.OnStyleLoaded) null);
    }

    public void setStyle(Style.Builder builder, Style.OnStyleLoaded onStyleLoaded) {
        this.styleLoadedCallback = onStyleLoaded;
        this.locationComponent.onStartLoadingMap();
        Style style = this.style;
        if (style != null) {
            style.clear();
        }
        this.style = builder.build(this.nativeMapView);
        if (!TextUtils.isEmpty(builder.getUri())) {
            this.nativeMapView.setStyleUri(builder.getUri());
        } else if (!TextUtils.isEmpty(builder.getJson())) {
            this.nativeMapView.setStyleJson(builder.getJson());
        } else {
            this.nativeMapView.setStyleJson("{\"version\": 8,\"sources\": {},\"layers\": []}");
        }
    }

    void notifyStyleLoaded() {
        if (this.nativeMapView.isDestroyed()) {
            return;
        }
        Style style = this.style;
        if (style != null) {
            style.onDidFinishLoadingStyle();
            this.locationComponent.onFinishLoadingStyle();
            Style.OnStyleLoaded onStyleLoaded = this.styleLoadedCallback;
            if (onStyleLoaded != null) {
                onStyleLoaded.onStyleLoaded(this.style);
            }
            Iterator<Style.OnStyleLoaded> it = this.awaitingStyleGetters.iterator();
            while (it.hasNext()) {
                it.next().onStyleLoaded(this.style);
            }
        } else {
            MapStrictMode.strictModeViolation("No style to provide.");
        }
        this.styleLoadedCallback = null;
        this.awaitingStyleGetters.clear();
    }

    @Deprecated
    public Marker addMarker(MarkerOptions markerOptions) {
        return this.annotationManager.addMarker(markerOptions, this);
    }

    @Deprecated
    public Marker addMarker(BaseMarkerOptions baseMarkerOptions) {
        return this.annotationManager.addMarker(baseMarkerOptions, this);
    }

    @Deprecated
    public List<Marker> addMarkers(List<? extends BaseMarkerOptions> list) {
        return this.annotationManager.addMarkers(list, this);
    }

    @Deprecated
    public void updateMarker(Marker marker) {
        this.annotationManager.updateMarker(marker, this);
    }

    @Deprecated
    public Polyline addPolyline(PolylineOptions polylineOptions) {
        return this.annotationManager.addPolyline(polylineOptions, this);
    }

    @Deprecated
    public List<Polyline> addPolylines(List<PolylineOptions> list) {
        return this.annotationManager.addPolylines(list, this);
    }

    @Deprecated
    public void updatePolyline(Polyline polyline) {
        this.annotationManager.updatePolyline(polyline);
    }

    @Deprecated
    public Polygon addPolygon(PolygonOptions polygonOptions) {
        return this.annotationManager.addPolygon(polygonOptions, this);
    }

    @Deprecated
    public List<Polygon> addPolygons(List<PolygonOptions> list) {
        return this.annotationManager.addPolygons(list, this);
    }

    @Deprecated
    public void updatePolygon(Polygon polygon) {
        this.annotationManager.updatePolygon(polygon);
    }

    @Deprecated
    public void removeMarker(Marker marker) {
        this.annotationManager.removeAnnotation(marker);
    }

    @Deprecated
    public void removePolyline(Polyline polyline) {
        this.annotationManager.removeAnnotation(polyline);
    }

    @Deprecated
    public void removePolygon(Polygon polygon) {
        this.annotationManager.removeAnnotation(polygon);
    }

    @Deprecated
    public void removeAnnotation(Annotation annotation) {
        this.annotationManager.removeAnnotation(annotation);
    }

    @Deprecated
    public void removeAnnotation(long j) {
        this.annotationManager.removeAnnotation(j);
    }

    @Deprecated
    public void removeAnnotations(List<? extends Annotation> list) {
        this.annotationManager.removeAnnotations(list);
    }

    @Deprecated
    public void removeAnnotations() {
        this.annotationManager.removeAnnotations();
    }

    @Deprecated
    public void clear() {
        this.annotationManager.removeAnnotations();
    }

    @Deprecated
    public Annotation getAnnotation(long j) {
        return this.annotationManager.getAnnotation(j);
    }

    @Deprecated
    public List<Annotation> getAnnotations() {
        return this.annotationManager.getAnnotations();
    }

    @Deprecated
    public List<Marker> getMarkers() {
        return this.annotationManager.getMarkers();
    }

    @Deprecated
    public List<Polygon> getPolygons() {
        return this.annotationManager.getPolygons();
    }

    @Deprecated
    public List<Polyline> getPolylines() {
        return this.annotationManager.getPolylines();
    }

    @Deprecated
    public void setOnMarkerClickListener(OnMarkerClickListener onMarkerClickListener) {
        this.annotationManager.setOnMarkerClickListener(onMarkerClickListener);
    }

    @Deprecated
    public void setOnPolygonClickListener(OnPolygonClickListener onPolygonClickListener) {
        this.annotationManager.setOnPolygonClickListener(onPolygonClickListener);
    }

    @Deprecated
    public void setOnPolylineClickListener(OnPolylineClickListener onPolylineClickListener) {
        this.annotationManager.setOnPolylineClickListener(onPolylineClickListener);
    }

    @Deprecated
    public void selectMarker(Marker marker) {
        if (marker == null) {
            Logger.w(TAG, "marker was null, so just returning");
        } else {
            this.annotationManager.selectMarker(marker);
        }
    }

    @Deprecated
    public void deselectMarkers() {
        this.annotationManager.deselectMarkers();
    }

    @Deprecated
    public void deselectMarker(Marker marker) {
        this.annotationManager.deselectMarker(marker);
    }

    @Deprecated
    public List<Marker> getSelectedMarkers() {
        return this.annotationManager.getSelectedMarkers();
    }

    @Deprecated
    public void setInfoWindowAdapter(InfoWindowAdapter infoWindowAdapter) {
        this.annotationManager.getInfoWindowManager().setInfoWindowAdapter(infoWindowAdapter);
    }

    @Deprecated
    public InfoWindowAdapter getInfoWindowAdapter() {
        return this.annotationManager.getInfoWindowManager().getInfoWindowAdapter();
    }

    @Deprecated
    public void setAllowConcurrentMultipleOpenInfoWindows(boolean z) {
        this.annotationManager.getInfoWindowManager().setAllowConcurrentMultipleOpenInfoWindows(z);
    }

    @Deprecated
    public boolean isAllowConcurrentMultipleOpenInfoWindows() {
        return this.annotationManager.getInfoWindowManager().isAllowConcurrentMultipleOpenInfoWindows();
    }

    public LatLngBoundsZoom getLatLngBoundsZoomFromCamera(CameraPosition cameraPosition) {
        return this.nativeMapView.getLatLngBoundsZoomFromCamera(cameraPosition);
    }

    public void setLatLngBoundsForCameraTarget(LatLngBounds latLngBounds) {
        this.nativeMapView.setLatLngBounds(latLngBounds);
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds) {
        return getCameraForLatLngBounds(latLngBounds, new int[]{0, 0, 0, 0});
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, int[] iArr) {
        return getCameraForLatLngBounds(latLngBounds, iArr, this.transform.getRawBearing(), this.transform.getTilt());
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, double d, double d2) {
        return getCameraForLatLngBounds(latLngBounds, new int[]{0, 0, 0, 0}, d, d2);
    }

    public CameraPosition getCameraForLatLngBounds(LatLngBounds latLngBounds, int[] iArr, double d, double d2) {
        return this.nativeMapView.getCameraForLatLngBounds(latLngBounds, iArr, d, d2);
    }

    public CameraPosition getCameraForGeometry(Geometry geometry) {
        return getCameraForGeometry(geometry, new int[]{0, 0, 0, 0});
    }

    public CameraPosition getCameraForGeometry(Geometry geometry, int[] iArr) {
        return getCameraForGeometry(geometry, iArr, this.transform.getBearing(), this.transform.getTilt());
    }

    public CameraPosition getCameraForGeometry(Geometry geometry, double d, double d2) {
        return getCameraForGeometry(geometry, new int[]{0, 0, 0, 0}, d, d2);
    }

    public CameraPosition getCameraForGeometry(Geometry geometry, int[] iArr, double d, double d2) {
        return this.nativeMapView.getCameraForGeometry(geometry, iArr, d, d2);
    }

    @Deprecated
    public void setPadding(int i, int i2, int i3, int i4) {
        this.projection.setContentPadding(new int[]{i, i2, i3, i4});
        this.uiSettings.invalidate();
    }

    @Deprecated
    public int[] getPadding() {
        return this.projection.getContentPadding();
    }

    public void addOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        this.cameraChangeDispatcher.addOnCameraIdleListener(onCameraIdleListener);
    }

    public void removeOnCameraIdleListener(OnCameraIdleListener onCameraIdleListener) {
        this.cameraChangeDispatcher.removeOnCameraIdleListener(onCameraIdleListener);
    }

    public void addOnCameraMoveCancelListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.cameraChangeDispatcher.addOnCameraMoveCancelListener(onCameraMoveCanceledListener);
    }

    public void removeOnCameraMoveCancelListener(OnCameraMoveCanceledListener onCameraMoveCanceledListener) {
        this.cameraChangeDispatcher.removeOnCameraMoveCancelListener(onCameraMoveCanceledListener);
    }

    public void addOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.cameraChangeDispatcher.addOnCameraMoveStartedListener(onCameraMoveStartedListener);
    }

    public void removeOnCameraMoveStartedListener(OnCameraMoveStartedListener onCameraMoveStartedListener) {
        this.cameraChangeDispatcher.removeOnCameraMoveStartedListener(onCameraMoveStartedListener);
    }

    public void addOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        this.cameraChangeDispatcher.addOnCameraMoveListener(onCameraMoveListener);
    }

    public void removeOnCameraMoveListener(OnCameraMoveListener onCameraMoveListener) {
        this.cameraChangeDispatcher.removeOnCameraMoveListener(onCameraMoveListener);
    }

    public void setOnFpsChangedListener(OnFpsChangedListener onFpsChangedListener) {
        this.onFpsChangedListener = onFpsChangedListener;
        this.nativeMapView.setOnFpsChangedListener(onFpsChangedListener);
    }

    OnFpsChangedListener getOnFpsChangedListener() {
        return this.onFpsChangedListener;
    }

    public void addOnFlingListener(OnFlingListener onFlingListener) {
        this.onGesturesManagerInteractionListener.onAddFlingListener(onFlingListener);
    }

    public void removeOnFlingListener(OnFlingListener onFlingListener) {
        this.onGesturesManagerInteractionListener.onRemoveFlingListener(onFlingListener);
    }

    public void addOnMoveListener(OnMoveListener onMoveListener) {
        this.onGesturesManagerInteractionListener.onAddMoveListener(onMoveListener);
    }

    public void removeOnMoveListener(OnMoveListener onMoveListener) {
        this.onGesturesManagerInteractionListener.onRemoveMoveListener(onMoveListener);
    }

    public void addOnRotateListener(OnRotateListener onRotateListener) {
        this.onGesturesManagerInteractionListener.onAddRotateListener(onRotateListener);
    }

    public void removeOnRotateListener(OnRotateListener onRotateListener) {
        this.onGesturesManagerInteractionListener.onRemoveRotateListener(onRotateListener);
    }

    public void addOnScaleListener(OnScaleListener onScaleListener) {
        this.onGesturesManagerInteractionListener.onAddScaleListener(onScaleListener);
    }

    public void removeOnScaleListener(OnScaleListener onScaleListener) {
        this.onGesturesManagerInteractionListener.onRemoveScaleListener(onScaleListener);
    }

    public void addOnShoveListener(OnShoveListener onShoveListener) {
        this.onGesturesManagerInteractionListener.onAddShoveListener(onShoveListener);
    }

    public void removeOnShoveListener(OnShoveListener onShoveListener) {
        this.onGesturesManagerInteractionListener.onRemoveShoveListener(onShoveListener);
    }

    public void setGesturesManager(AndroidGesturesManager androidGesturesManager, boolean z, boolean z2) {
        this.onGesturesManagerInteractionListener.setGesturesManager(androidGesturesManager, z, z2);
    }

    public AndroidGesturesManager getGesturesManager() {
        return this.onGesturesManagerInteractionListener.getGesturesManager();
    }

    public void cancelAllVelocityAnimations() {
        this.onGesturesManagerInteractionListener.cancelAllVelocityAnimations();
    }

    public void addOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.onGesturesManagerInteractionListener.onAddMapClickListener(onMapClickListener);
    }

    public void removeOnMapClickListener(OnMapClickListener onMapClickListener) {
        this.onGesturesManagerInteractionListener.onRemoveMapClickListener(onMapClickListener);
    }

    public void addOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.onGesturesManagerInteractionListener.onAddMapLongClickListener(onMapLongClickListener);
    }

    public void removeOnMapLongClickListener(OnMapLongClickListener onMapLongClickListener) {
        this.onGesturesManagerInteractionListener.onRemoveMapLongClickListener(onMapLongClickListener);
    }

    public void setOnInfoWindowClickListener(OnInfoWindowClickListener onInfoWindowClickListener) {
        this.annotationManager.getInfoWindowManager().setOnInfoWindowClickListener(onInfoWindowClickListener);
    }

    public OnInfoWindowClickListener getOnInfoWindowClickListener() {
        return this.annotationManager.getInfoWindowManager().getOnInfoWindowClickListener();
    }

    public void setOnInfoWindowLongClickListener(OnInfoWindowLongClickListener onInfoWindowLongClickListener) {
        this.annotationManager.getInfoWindowManager().setOnInfoWindowLongClickListener(onInfoWindowLongClickListener);
    }

    public OnInfoWindowLongClickListener getOnInfoWindowLongClickListener() {
        return this.annotationManager.getInfoWindowManager().getOnInfoWindowLongClickListener();
    }

    public void setOnInfoWindowCloseListener(OnInfoWindowCloseListener onInfoWindowCloseListener) {
        this.annotationManager.getInfoWindowManager().setOnInfoWindowCloseListener(onInfoWindowCloseListener);
    }

    public OnInfoWindowCloseListener getOnInfoWindowCloseListener() {
        return this.annotationManager.getInfoWindowManager().getOnInfoWindowCloseListener();
    }

    public void snapshot(SnapshotReadyCallback snapshotReadyCallback) {
        if (this.started) {
            this.nativeMapView.addSnapshotCallback(snapshotReadyCallback);
        }
    }

    public List<Feature> queryRenderedFeatures(PointF pointF, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(pointF, strArr, (Expression) null);
    }

    public List<Feature> queryRenderedFeatures(PointF pointF, Expression expression, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(pointF, strArr, expression);
    }

    public List<Feature> queryRenderedFeatures(RectF rectF, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(rectF, strArr, (Expression) null);
    }

    public List<Feature> queryRenderedFeatures(RectF rectF, Expression expression, String... strArr) {
        return this.nativeMapView.queryRenderedFeatures(rectF, strArr, expression);
    }

    void injectLocationComponent(LocationComponent locationComponent) {
        this.locationComponent = locationComponent;
    }

    void injectAnnotationManager(AnnotationManager annotationManager) {
        this.annotationManager = annotationManager.bind(this);
    }

    public LocationComponent getLocationComponent() {
        return this.locationComponent;
    }

    public void setUserAnimationInProgress(boolean z) {
        this.nativeMapView.setUserAnimationInProgress(z);
    }

    public boolean isUserAnimationInProgress() {
        return this.nativeMapView.isUserAnimationInProgress();
    }

    public void subscribe(Observer observer, List<String> list) {
        this.nativeMapView.subscribe(observer, list);
    }

    public void unsubscribe(Observer observer, List<String> list) {
        this.nativeMapView.unsubscribe(observer, list);
    }

    public void unsubscribe(Observer observer) {
        this.nativeMapView.unsubscribe(observer);
    }

    Transform getTransform() {
        return this.transform;
    }

    private void notifyDeveloperAnimationListeners() {
        Iterator<OnDeveloperAnimationListener> it = this.developerAnimationStartedListeners.iterator();
        while (it.hasNext()) {
            it.next().onDeveloperAnimationStarted();
        }
    }
}
