package com.mapbox.mapboxsdk.maps;

import android.graphics.PointF;
import android.os.Handler;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.MapView;
import com.mapbox.mapboxsdk.maps.MapboxMap;

/* loaded from: classes3.dex */
public final class Transform implements MapView.OnCameraDidChangeListener {
    private static final String TAG = "Mbgl-Transform";
    private MapboxMap.CancelableCallback cameraCancelableCallback;
    private CameraChangeDispatcher cameraChangeDispatcher;
    private CameraPosition cameraPosition;
    private final MapView mapView;
    private final NativeMap nativeMap;
    private final Handler handler = new Handler();
    private final MapView.OnCameraDidChangeListener moveByChangeListener = new MapView.OnCameraDidChangeListener() { // from class: com.mapbox.mapboxsdk.maps.Transform.1
        @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraDidChangeListener
        public void onCameraDidChange(boolean z) {
            if (z) {
                Transform.this.cameraChangeDispatcher.onCameraIdle();
                Transform.this.mapView.removeOnCameraDidChangeListener(this);
            }
        }
    };

    Transform(MapView mapView, NativeMap nativeMap, CameraChangeDispatcher cameraChangeDispatcher) {
        this.mapView = mapView;
        this.nativeMap = nativeMap;
        this.cameraChangeDispatcher = cameraChangeDispatcher;
    }

    void initialise(MapboxMap mapboxMap, MapboxMapOptions mapboxMapOptions) {
        CameraPosition camera = mapboxMapOptions.getCamera();
        if (camera != null && !camera.equals(CameraPosition.DEFAULT)) {
            moveCamera(mapboxMap, CameraUpdateFactory.newCameraPosition(camera), null);
        }
        setMinZoom(mapboxMapOptions.getMinZoomPreference());
        setMaxZoom(mapboxMapOptions.getMaxZoomPreference());
        setMinPitch(mapboxMapOptions.getMinPitchPreference());
        setMaxPitch(mapboxMapOptions.getMaxPitchPreference());
    }

    public final CameraPosition getCameraPosition() {
        if (this.cameraPosition == null) {
            this.cameraPosition = invalidateCameraPosition();
        }
        return this.cameraPosition;
    }

    @Override // com.mapbox.mapboxsdk.maps.MapView.OnCameraDidChangeListener
    public void onCameraDidChange(boolean z) {
        if (z) {
            invalidateCameraPosition();
            final MapboxMap.CancelableCallback cancelableCallback = this.cameraCancelableCallback;
            if (cancelableCallback != null) {
                this.cameraCancelableCallback = null;
                this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.maps.Transform.2
                    @Override // java.lang.Runnable
                    public void run() {
                        cancelableCallback.onFinish();
                    }
                });
            }
            this.cameraChangeDispatcher.onCameraIdle();
            this.mapView.removeOnCameraDidChangeListener(this);
        }
    }

    public final void moveCamera(MapboxMap mapboxMap, CameraUpdate cameraUpdate, final MapboxMap.CancelableCallback cancelableCallback) {
        CameraPosition cameraPosition = cameraUpdate.getCameraPosition(mapboxMap);
        if (!isValidCameraPosition(cameraPosition)) {
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
            }
        } else {
            cancelTransitions();
            this.cameraChangeDispatcher.onCameraMoveStarted(3);
            this.nativeMap.jumpTo(cameraPosition.target, cameraPosition.zoom, cameraPosition.tilt, cameraPosition.bearing, cameraPosition.padding);
            invalidateCameraPosition();
            this.cameraChangeDispatcher.onCameraIdle();
            this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.maps.Transform.3
                @Override // java.lang.Runnable
                public void run() {
                    MapboxMap.CancelableCallback cancelableCallback2 = cancelableCallback;
                    if (cancelableCallback2 != null) {
                        cancelableCallback2.onFinish();
                    }
                }
            });
        }
    }

    final void easeCamera(MapboxMap mapboxMap, CameraUpdate cameraUpdate, int i, boolean z, MapboxMap.CancelableCallback cancelableCallback) {
        CameraPosition cameraPosition = cameraUpdate.getCameraPosition(mapboxMap);
        if (!isValidCameraPosition(cameraPosition)) {
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
            }
        } else {
            cancelTransitions();
            this.cameraChangeDispatcher.onCameraMoveStarted(3);
            if (cancelableCallback != null) {
                this.cameraCancelableCallback = cancelableCallback;
            }
            this.mapView.addOnCameraDidChangeListener(this);
            this.nativeMap.easeTo(cameraPosition.target, cameraPosition.zoom, cameraPosition.bearing, cameraPosition.tilt, cameraPosition.padding, i, z);
        }
    }

    public final void animateCamera(MapboxMap mapboxMap, CameraUpdate cameraUpdate, int i, MapboxMap.CancelableCallback cancelableCallback) {
        CameraPosition cameraPosition = cameraUpdate.getCameraPosition(mapboxMap);
        if (!isValidCameraPosition(cameraPosition)) {
            if (cancelableCallback != null) {
                cancelableCallback.onFinish();
            }
        } else {
            cancelTransitions();
            this.cameraChangeDispatcher.onCameraMoveStarted(3);
            if (cancelableCallback != null) {
                this.cameraCancelableCallback = cancelableCallback;
            }
            this.mapView.addOnCameraDidChangeListener(this);
            this.nativeMap.flyTo(cameraPosition.target, cameraPosition.zoom, cameraPosition.bearing, cameraPosition.tilt, cameraPosition.padding, i);
        }
    }

    private boolean isValidCameraPosition(CameraPosition cameraPosition) {
        return (cameraPosition == null || cameraPosition.equals(this.cameraPosition)) ? false : true;
    }

    CameraPosition invalidateCameraPosition() {
        NativeMap nativeMap = this.nativeMap;
        if (nativeMap != null) {
            CameraPosition cameraPosition = nativeMap.getCameraPosition();
            CameraPosition cameraPosition2 = this.cameraPosition;
            if (cameraPosition2 != null && !cameraPosition2.equals(cameraPosition)) {
                this.cameraChangeDispatcher.onCameraMove();
            }
            this.cameraPosition = cameraPosition;
        }
        return this.cameraPosition;
    }

    void cancelTransitions() {
        this.cameraChangeDispatcher.onCameraMoveCanceled();
        final MapboxMap.CancelableCallback cancelableCallback = this.cameraCancelableCallback;
        if (cancelableCallback != null) {
            this.cameraChangeDispatcher.onCameraIdle();
            this.cameraCancelableCallback = null;
            this.handler.post(new Runnable() { // from class: com.mapbox.mapboxsdk.maps.Transform.4
                @Override // java.lang.Runnable
                public void run() {
                    cancelableCallback.onCancel();
                }
            });
        }
        this.nativeMap.cancelTransitions();
        this.cameraChangeDispatcher.onCameraIdle();
    }

    void resetNorth() {
        cancelTransitions();
        this.nativeMap.resetNorth();
    }

    double getRawZoom() {
        return this.nativeMap.getZoom();
    }

    void zoomBy(double d, PointF pointF) {
        setZoom(this.nativeMap.getZoom() + d, pointF);
    }

    void setZoom(double d, PointF pointF) {
        this.nativeMap.setZoom(d, pointF, 0L);
    }

    double getBearing() {
        double d = -this.nativeMap.getBearing();
        while (d > 360.0d) {
            d -= 360.0d;
        }
        while (d < 0.0d) {
            d += 360.0d;
        }
        return d;
    }

    double getRawBearing() {
        return this.nativeMap.getBearing();
    }

    void setBearing(double d) {
        this.nativeMap.setBearing(d, 0L);
    }

    void setBearing(double d, float f, float f2) {
        this.nativeMap.setBearing(d, f, f2, 0L);
    }

    void setBearing(double d, float f, float f2, long j) {
        this.nativeMap.setBearing(d, f, f2, j);
    }

    LatLng getLatLng() {
        return this.nativeMap.getLatLng();
    }

    double getTilt() {
        return this.nativeMap.getPitch();
    }

    void setTilt(Double d) {
        this.nativeMap.setPitch(d.doubleValue(), 0L);
    }

    LatLng getCenterCoordinate() {
        return this.nativeMap.getLatLng();
    }

    void setCenterCoordinate(LatLng latLng) {
        this.nativeMap.setLatLng(latLng, 0L);
    }

    void setGestureInProgress(boolean z) {
        this.nativeMap.setGestureInProgress(z);
        if (z) {
            return;
        }
        invalidateCameraPosition();
    }

    void moveBy(double d, double d2, long j) {
        if (j > 0) {
            this.mapView.addOnCameraDidChangeListener(this.moveByChangeListener);
        }
        this.nativeMap.moveBy(d, d2, j);
    }

    void setMinZoom(double d) {
        if (d < 0.0d || d > 25.5d) {
            Logger.m1756e(TAG, String.format("Not setting minZoomPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMinZoom(d);
        }
    }

    double getMinZoom() {
        return this.nativeMap.getMinZoom();
    }

    void setMaxZoom(double d) {
        if (d < 0.0d || d > 25.5d) {
            Logger.m1756e(TAG, String.format("Not setting maxZoomPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMaxZoom(d);
        }
    }

    double getMaxZoom() {
        return this.nativeMap.getMaxZoom();
    }

    void setMinPitch(double d) {
        if (d < 0.0d || d > 60.0d) {
            Logger.m1756e(TAG, String.format("Not setting minPitchPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMinPitch(d);
        }
    }

    double getMinPitch() {
        return this.nativeMap.getMinPitch();
    }

    void setMaxPitch(double d) {
        if (d < 0.0d || d > 60.0d) {
            Logger.m1756e(TAG, String.format("Not setting maxPitchPreference, value is in unsupported range: %s", Double.valueOf(d)));
        } else {
            this.nativeMap.setMaxPitch(d);
        }
    }

    double getMaxPitch() {
        return this.nativeMap.getMaxPitch();
    }
}