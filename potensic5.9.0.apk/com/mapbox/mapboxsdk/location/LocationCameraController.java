package com.mapbox.mapboxsdk.location;

import android.content.Context;
import android.graphics.RectF;
import android.location.Location;
import android.view.MotionEvent;
import com.mapbox.android.gestures.AndroidGesturesManager;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.android.gestures.RotateGestureDetector;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.camera.CameraUpdate;
import com.mapbox.mapboxsdk.camera.CameraUpdateFactory;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Transform;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
final class LocationCameraController {
    private int cameraMode;
    private final AndroidGesturesManager initialGesturesManager;
    private final OnCameraTrackingChangedListener internalCameraTrackingChangedListener;
    private final AndroidGesturesManager internalGesturesManager;
    private boolean isEnabled;
    private boolean isTransitioning;
    private LatLng lastLocation;
    private final MapboxMap mapboxMap;
    private final MoveGestureDetector moveGestureDetector;
    private final OnCameraMoveInvalidateListener onCameraMoveInvalidateListener;
    private LocationComponentOptions options;
    private final Transform transform;
    private final MapboxAnimator.AnimationsValueChangeListener<LatLng> latLngValueListener = new MapboxAnimator.AnimationsValueChangeListener<LatLng>() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.2
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(LatLng latLng) {
            LocationCameraController.this.setLatLng(latLng);
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> gpsBearingValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.3
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            if (LocationCameraController.this.cameraMode == 36 && LocationCameraController.this.mapboxMap.getCameraPosition().bearing == 0.0d) {
                return;
            }
            LocationCameraController.this.setBearing(f.floatValue());
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> compassBearingValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.4
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            if (LocationCameraController.this.cameraMode == 32 || LocationCameraController.this.cameraMode == 16) {
                LocationCameraController.this.setBearing(f.floatValue());
            }
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> zoomValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.5
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationCameraController.this.setZoom(f.floatValue());
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<double[]> paddingValueListener = new MapboxAnimator.AnimationsValueChangeListener<double[]>() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.6
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(double[] dArr) {
            LocationCameraController.this.setPadding(dArr);
        }
    };
    private final MapboxAnimator.AnimationsValueChangeListener<Float> tiltValueListener = new MapboxAnimator.AnimationsValueChangeListener<Float>() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.7
        @Override // com.mapbox.mapboxsdk.location.MapboxAnimator.AnimationsValueChangeListener
        public void onNewAnimationValue(Float f) {
            LocationCameraController.this.setTilt(f.floatValue());
        }
    };
    private MapboxMap.OnCameraMoveListener onCameraMoveListener = new MapboxMap.OnCameraMoveListener() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.8
        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnCameraMoveListener
        public void onCameraMove() {
            if (LocationCameraController.this.isLocationTracking() && LocationCameraController.this.lastLocation != null && LocationCameraController.this.options.trackingGesturesManagement()) {
                LocationCameraController.this.mapboxMap.getUiSettings().setFocalPoint(LocationCameraController.this.mapboxMap.getProjection().toScreenLocation(LocationCameraController.this.lastLocation));
            }
        }
    };
    MapboxMap.OnMoveListener onMoveListener = new MapboxMap.OnMoveListener() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.9
        private boolean interrupt;

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener
        public void onMoveBegin(MoveGestureDetector moveGestureDetector) {
            if (LocationCameraController.this.options.trackingGesturesManagement() && LocationCameraController.this.isLocationTracking()) {
                if (moveGestureDetector.getPointersCount() > 1) {
                    applyMultiFingerThresholdArea(moveGestureDetector);
                    applyMultiFingerMoveThreshold(moveGestureDetector);
                    return;
                } else {
                    applySingleFingerMoveThreshold(moveGestureDetector);
                    return;
                }
            }
            LocationCameraController.this.setCameraMode(8);
        }

        private void applyMultiFingerThresholdArea(MoveGestureDetector moveGestureDetector) {
            RectF moveThresholdRect = moveGestureDetector.getMoveThresholdRect();
            if (moveThresholdRect == null || moveThresholdRect.equals(LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea())) {
                if (moveThresholdRect != null || LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea() == null) {
                    return;
                }
                moveGestureDetector.setMoveThresholdRect(LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea());
                this.interrupt = true;
                return;
            }
            moveGestureDetector.setMoveThresholdRect(LocationCameraController.this.options.trackingMultiFingerProtectedMoveArea());
            this.interrupt = true;
        }

        private void applyMultiFingerMoveThreshold(MoveGestureDetector moveGestureDetector) {
            if (moveGestureDetector.getMoveThreshold() != LocationCameraController.this.options.trackingMultiFingerMoveThreshold()) {
                moveGestureDetector.setMoveThreshold(LocationCameraController.this.options.trackingMultiFingerMoveThreshold());
                this.interrupt = true;
            }
        }

        private void applySingleFingerMoveThreshold(MoveGestureDetector moveGestureDetector) {
            if (moveGestureDetector.getMoveThreshold() != LocationCameraController.this.options.trackingInitialMoveThreshold()) {
                moveGestureDetector.setMoveThreshold(LocationCameraController.this.options.trackingInitialMoveThreshold());
                this.interrupt = true;
            }
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener
        public void onMove(MoveGestureDetector moveGestureDetector) {
            if (!this.interrupt) {
                if (LocationCameraController.this.isLocationTracking() || LocationCameraController.this.isBearingTracking()) {
                    LocationCameraController.this.setCameraMode(8);
                    moveGestureDetector.interrupt();
                    return;
                }
                return;
            }
            moveGestureDetector.interrupt();
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnMoveListener
        public void onMoveEnd(MoveGestureDetector moveGestureDetector) {
            if (LocationCameraController.this.options.trackingGesturesManagement() && !this.interrupt && LocationCameraController.this.isLocationTracking()) {
                moveGestureDetector.setMoveThreshold(LocationCameraController.this.options.trackingInitialMoveThreshold());
                moveGestureDetector.setMoveThresholdRect(null);
            }
            this.interrupt = false;
        }
    };
    private MapboxMap.OnRotateListener onRotateListener = new MapboxMap.OnRotateListener() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.10
        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnRotateListener
        public void onRotate(RotateGestureDetector rotateGestureDetector) {
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnRotateListener
        public void onRotateEnd(RotateGestureDetector rotateGestureDetector) {
        }

        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnRotateListener
        public void onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            if (LocationCameraController.this.isBearingTracking()) {
                LocationCameraController.this.setCameraMode(8);
            }
        }
    };
    private MapboxMap.OnFlingListener onFlingListener = new MapboxMap.OnFlingListener() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.11
        @Override // com.mapbox.mapboxsdk.maps.MapboxMap.OnFlingListener
        public void onFling() {
            LocationCameraController.this.setCameraMode(8);
        }
    };

    LocationCameraController(Context context, MapboxMap mapboxMap, Transform transform, OnCameraTrackingChangedListener onCameraTrackingChangedListener, LocationComponentOptions locationComponentOptions, OnCameraMoveInvalidateListener onCameraMoveInvalidateListener) {
        this.mapboxMap = mapboxMap;
        this.transform = transform;
        this.initialGesturesManager = mapboxMap.getGesturesManager();
        LocationGesturesManager locationGesturesManager = new LocationGesturesManager(context);
        this.internalGesturesManager = locationGesturesManager;
        this.moveGestureDetector = locationGesturesManager.getMoveGestureDetector();
        mapboxMap.addOnRotateListener(this.onRotateListener);
        mapboxMap.addOnFlingListener(this.onFlingListener);
        mapboxMap.addOnMoveListener(this.onMoveListener);
        mapboxMap.addOnCameraMoveListener(this.onCameraMoveListener);
        this.internalCameraTrackingChangedListener = onCameraTrackingChangedListener;
        this.onCameraMoveInvalidateListener = onCameraMoveInvalidateListener;
        initializeOptions(locationComponentOptions);
    }

    LocationCameraController(MapboxMap mapboxMap, Transform transform, MoveGestureDetector moveGestureDetector, OnCameraTrackingChangedListener onCameraTrackingChangedListener, OnCameraMoveInvalidateListener onCameraMoveInvalidateListener, AndroidGesturesManager androidGesturesManager, AndroidGesturesManager androidGesturesManager2) {
        this.mapboxMap = mapboxMap;
        mapboxMap.addOnCameraMoveListener(this.onCameraMoveListener);
        this.transform = transform;
        this.moveGestureDetector = moveGestureDetector;
        this.internalCameraTrackingChangedListener = onCameraTrackingChangedListener;
        this.onCameraMoveInvalidateListener = onCameraMoveInvalidateListener;
        this.internalGesturesManager = androidGesturesManager2;
        this.initialGesturesManager = androidGesturesManager;
    }

    void initializeOptions(LocationComponentOptions locationComponentOptions) {
        this.options = locationComponentOptions;
        if (locationComponentOptions.trackingGesturesManagement()) {
            AndroidGesturesManager gesturesManager = this.mapboxMap.getGesturesManager();
            AndroidGesturesManager androidGesturesManager = this.internalGesturesManager;
            if (gesturesManager != androidGesturesManager) {
                this.mapboxMap.setGesturesManager(androidGesturesManager, true, true);
            }
            adjustGesturesThresholds();
            return;
        }
        AndroidGesturesManager gesturesManager2 = this.mapboxMap.getGesturesManager();
        AndroidGesturesManager androidGesturesManager2 = this.initialGesturesManager;
        if (gesturesManager2 != androidGesturesManager2) {
            this.mapboxMap.setGesturesManager(androidGesturesManager2, true, true);
        }
    }

    void setCameraMode(int i) {
        setCameraMode(i, null, 750L, null, null, null, null);
    }

    void setCameraMode(int i, Location location, long j, Double d, Double d2, Double d3, OnLocationCameraTransitionListener onLocationCameraTransitionListener) {
        if (this.cameraMode == i) {
            if (onLocationCameraTransitionListener != null) {
                onLocationCameraTransitionListener.onLocationCameraTransitionFinished(i);
                return;
            }
            return;
        }
        boolean isLocationTracking = isLocationTracking();
        this.cameraMode = i;
        this.mapboxMap.setUserAnimationInProgress(isLocationTracking());
        if (i != 8) {
            this.mapboxMap.cancelTransitions();
        }
        adjustGesturesThresholds();
        notifyCameraTrackingChangeListener(isLocationTracking);
        transitionToCurrentLocation(isLocationTracking, location, j, d, d2, d3, onLocationCameraTransitionListener);
    }

    private void transitionToCurrentLocation(boolean z, Location location, long j, Double d, Double d2, Double d3, final OnLocationCameraTransitionListener onLocationCameraTransitionListener) {
        if (z || !isLocationTracking() || location == null || !this.isEnabled) {
            if (onLocationCameraTransitionListener != null) {
                onLocationCameraTransitionListener.onLocationCameraTransitionFinished(this.cameraMode);
                return;
            }
            return;
        }
        this.isTransitioning = true;
        LatLng latLng = new LatLng(location);
        CameraPosition.Builder target = new CameraPosition.Builder().target(latLng);
        if (d != null) {
            target.zoom(d.doubleValue());
        }
        if (d3 != null) {
            target.tilt(d3.doubleValue());
        }
        if (d2 != null) {
            target.bearing(d2.doubleValue());
        } else if (isLocationBearingTracking()) {
            target.bearing(this.cameraMode == 36 ? 0.0d : location.getBearing());
        }
        CameraUpdate newCameraPosition = CameraUpdateFactory.newCameraPosition(target.build());
        MapboxMap.CancelableCallback cancelableCallback = new MapboxMap.CancelableCallback() { // from class: com.mapbox.mapboxsdk.location.LocationCameraController.1
            @Override // com.mapbox.mapboxsdk.maps.MapboxMap.CancelableCallback
            public void onCancel() {
                LocationCameraController.this.isTransitioning = false;
                OnLocationCameraTransitionListener onLocationCameraTransitionListener2 = onLocationCameraTransitionListener;
                if (onLocationCameraTransitionListener2 != null) {
                    onLocationCameraTransitionListener2.onLocationCameraTransitionCanceled(LocationCameraController.this.cameraMode);
                }
            }

            @Override // com.mapbox.mapboxsdk.maps.MapboxMap.CancelableCallback
            public void onFinish() {
                LocationCameraController.this.isTransitioning = false;
                OnLocationCameraTransitionListener onLocationCameraTransitionListener2 = onLocationCameraTransitionListener;
                if (onLocationCameraTransitionListener2 != null) {
                    onLocationCameraTransitionListener2.onLocationCameraTransitionFinished(LocationCameraController.this.cameraMode);
                }
            }
        };
        if (Utils.immediateAnimation(this.mapboxMap.getProjection(), this.mapboxMap.getCameraPosition().target, latLng)) {
            this.transform.moveCamera(this.mapboxMap, newCameraPosition, cancelableCallback);
        } else {
            this.transform.animateCamera(this.mapboxMap, newCameraPosition, (int) j, cancelableCallback);
        }
    }

    int getCameraMode() {
        return this.cameraMode;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setBearing(float f) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapboxMap, CameraUpdateFactory.bearingTo(f), null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setLatLng(LatLng latLng) {
        if (this.isTransitioning) {
            return;
        }
        this.lastLocation = latLng;
        this.transform.moveCamera(this.mapboxMap, CameraUpdateFactory.newLatLng(latLng), null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setZoom(float f) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapboxMap, CameraUpdateFactory.zoomTo(f), null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setPadding(double[] dArr) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapboxMap, CameraUpdateFactory.paddingTo(dArr), null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setTilt(float f) {
        if (this.isTransitioning) {
            return;
        }
        this.transform.moveCamera(this.mapboxMap, CameraUpdateFactory.tiltTo(f), null);
        this.onCameraMoveInvalidateListener.onInvalidateCameraMove();
    }

    Set<AnimatorListenerHolder> getAnimationListeners() {
        HashSet hashSet = new HashSet();
        if (isLocationTracking()) {
            hashSet.add(new AnimatorListenerHolder(1, this.latLngValueListener));
        }
        if (isLocationBearingTracking()) {
            hashSet.add(new AnimatorListenerHolder(4, this.gpsBearingValueListener));
        }
        if (isConsumingCompass()) {
            hashSet.add(new AnimatorListenerHolder(5, this.compassBearingValueListener));
        }
        hashSet.add(new AnimatorListenerHolder(7, this.zoomValueListener));
        hashSet.add(new AnimatorListenerHolder(8, this.tiltValueListener));
        hashSet.add(new AnimatorListenerHolder(10, this.paddingValueListener));
        return hashSet;
    }

    boolean isTransitioning() {
        return this.isTransitioning;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void adjustGesturesThresholds() {
        if (this.options.trackingGesturesManagement()) {
            if (isLocationTracking()) {
                this.moveGestureDetector.setMoveThreshold(this.options.trackingInitialMoveThreshold());
            } else {
                this.moveGestureDetector.setMoveThreshold(0.0f);
                this.moveGestureDetector.setMoveThresholdRect(null);
            }
        }
    }

    boolean isConsumingCompass() {
        int i = this.cameraMode;
        return i == 32 || i == 16;
    }

    void setEnabled(boolean z) {
        this.isEnabled = z;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isLocationTracking() {
        int i = this.cameraMode;
        return i == 24 || i == 32 || i == 34 || i == 36;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean isBearingTracking() {
        int i = this.cameraMode;
        return i == 16 || i == 32 || i == 22 || i == 34 || i == 36;
    }

    private boolean isLocationBearingTracking() {
        int i = this.cameraMode;
        return i == 34 || i == 36 || i == 22;
    }

    private void notifyCameraTrackingChangeListener(boolean z) {
        this.internalCameraTrackingChangedListener.onCameraTrackingChanged(this.cameraMode);
        if (!z || isLocationTracking()) {
            return;
        }
        this.mapboxMap.getUiSettings().setFocalPoint(null);
        this.internalCameraTrackingChangedListener.onCameraTrackingDismissed();
    }

    private class LocationGesturesManager extends AndroidGesturesManager {
        LocationGesturesManager(Context context) {
            super(context);
        }

        @Override // com.mapbox.android.gestures.AndroidGesturesManager
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (motionEvent != null && motionEvent.getActionMasked() == 1) {
                LocationCameraController.this.adjustGesturesThresholds();
            }
            return super.onTouchEvent(motionEvent);
        }
    }
}