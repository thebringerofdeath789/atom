package com.mapbox.mapboxsdk.location;

import android.location.Location;
import android.os.SystemClock;
import android.util.SparseArray;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.mapbox.mapboxsdk.camera.CameraPosition;
import com.mapbox.mapboxsdk.geometry.LatLng;
import com.mapbox.mapboxsdk.location.MapboxAnimator;
import com.mapbox.mapboxsdk.log.Logger;
import com.mapbox.mapboxsdk.maps.MapboxMap;
import com.mapbox.mapboxsdk.maps.Projection;
import java.util.ArrayList;
import java.util.Set;

/* loaded from: classes3.dex */
final class LocationAnimatorCoordinator {
    private static final String TAG = "Mbgl-LocationAnimatorCoordinator";
    private boolean accuracyAnimationEnabled;
    private final MapboxAnimatorProvider animatorProvider;
    private final MapboxAnimatorSetProvider animatorSetProvider;
    private boolean compassAnimationEnabled;
    private float durationMultiplier;
    private Location previousLocation;
    private final Projection projection;
    final SparseArray<MapboxAnimator> animatorArray = new SparseArray<>();
    private float previousAccuracyRadius = -1.0f;
    private float previousCompassBearing = -1.0f;
    private long locationUpdateTimestamp = -1;
    int maxAnimationFps = Integer.MAX_VALUE;
    final SparseArray<MapboxAnimator.AnimationsValueChangeListener> listeners = new SparseArray<>();

    private float checkGpsNorth(boolean z, float f) {
        if (z) {
            return 0.0f;
        }
        return f;
    }

    LocationAnimatorCoordinator(Projection projection, MapboxAnimatorSetProvider mapboxAnimatorSetProvider, MapboxAnimatorProvider mapboxAnimatorProvider) {
        this.projection = projection;
        this.animatorProvider = mapboxAnimatorProvider;
        this.animatorSetProvider = mapboxAnimatorSetProvider;
    }

    void updateAnimatorListenerHolders(Set<AnimatorListenerHolder> set) {
        MapboxAnimator mapboxAnimator;
        this.listeners.clear();
        for (AnimatorListenerHolder animatorListenerHolder : set) {
            this.listeners.append(animatorListenerHolder.getAnimatorType(), animatorListenerHolder.getListener());
        }
        for (int i = 0; i < this.animatorArray.size(); i++) {
            int keyAt = this.animatorArray.keyAt(i);
            if (this.listeners.get(keyAt) == null && (mapboxAnimator = this.animatorArray.get(keyAt)) != null) {
                mapboxAnimator.makeInvalid();
            }
        }
    }

    void feedNewLocation(Location[] locationArr, CameraPosition cameraPosition, boolean z, Long l) {
        Long valueOf;
        boolean z2 = true;
        Location location = locationArr[locationArr.length - 1];
        if (this.previousLocation == null) {
            this.previousLocation = location;
            this.locationUpdateTimestamp = SystemClock.elapsedRealtime() - 750;
        }
        LatLng previousLayerLatLng = getPreviousLayerLatLng();
        float previousLayerGpsBearing = getPreviousLayerGpsBearing();
        LatLng latLng = cameraPosition.target;
        float normalize = Utils.normalize((float) cameraPosition.bearing);
        LatLng[] latLngValues = getLatLngValues(previousLayerLatLng, locationArr);
        updateLayerAnimators(latLngValues, getBearingValues(Float.valueOf(previousLayerGpsBearing), locationArr));
        latLngValues[0] = latLng;
        updateCameraAnimators(latLngValues, z ? new Float[]{Float.valueOf(normalize), Float.valueOf(Utils.shortestRotation(0.0f, normalize))} : getBearingValues(Float.valueOf(normalize), locationArr));
        LatLng latLng2 = new LatLng(location);
        if (!Utils.immediateAnimation(this.projection, latLng, latLng2) && !Utils.immediateAnimation(this.projection, previousLayerLatLng, latLng2)) {
            z2 = false;
        }
        long j = this.locationUpdateTimestamp;
        this.locationUpdateTimestamp = SystemClock.elapsedRealtime();
        if (l == null) {
            if (z2) {
                l = 0L;
            } else {
                if (j == 0) {
                    valueOf = 0L;
                } else {
                    valueOf = Long.valueOf((long) ((this.locationUpdateTimestamp - j) * this.durationMultiplier));
                }
                l = Long.valueOf(Math.min(valueOf.longValue(), SimpleExoPlayer.DEFAULT_DETACH_SURFACE_TIMEOUT_MS));
            }
        }
        playAnimators(l.longValue(), 0, 2, 1, 4);
        this.previousLocation = location;
    }

    void feedNewCompassBearing(float f, CameraPosition cameraPosition) {
        if (this.previousCompassBearing < 0.0f) {
            this.previousCompassBearing = f;
        }
        updateCompassAnimators(f, getPreviousLayerCompassBearing(), (float) cameraPosition.bearing);
        playAnimators(this.compassAnimationEnabled ? 500L : 0L, 3, 5);
        this.previousCompassBearing = f;
    }

    void feedNewAccuracyRadius(float f, boolean z) {
        if (this.previousAccuracyRadius < 0.0f) {
            this.previousAccuracyRadius = f;
        }
        updateAccuracyAnimators(f, getPreviousAccuracyRadius());
        playAnimators((z || !this.accuracyAnimationEnabled) ? 0L : 250L, 6);
        this.previousAccuracyRadius = f;
    }

    void startLocationComponentCirclePulsing(LocationComponentOptions locationComponentOptions) {
        cancelAnimator(9);
        MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(9);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(9, this.animatorProvider.pulsingCircleAnimator(animationsValueChangeListener, this.maxAnimationFps, locationComponentOptions.pulseSingleDuration(), locationComponentOptions.pulseMaxRadius(), locationComponentOptions.pulseInterpolator() == null ? new DecelerateInterpolator() : locationComponentOptions.pulseInterpolator()));
            playPulsingAnimator();
        }
    }

    void feedNewZoomLevel(double d, CameraPosition cameraPosition, long j, MapboxMap.CancelableCallback cancelableCallback) {
        updateZoomAnimator((float) d, (float) cameraPosition.zoom, cancelableCallback);
        playAnimators(j, 7);
    }

    void feedNewPadding(double[] dArr, CameraPosition cameraPosition, long j, MapboxMap.CancelableCallback cancelableCallback) {
        updatePaddingAnimator(dArr, cameraPosition.padding, cancelableCallback);
        playAnimators(j, 10);
    }

    void feedNewTilt(double d, CameraPosition cameraPosition, long j, MapboxMap.CancelableCallback cancelableCallback) {
        updateTiltAnimator((float) d, (float) cameraPosition.tilt, cancelableCallback);
        playAnimators(j, 8);
    }

    private LatLng getPreviousLayerLatLng() {
        MapboxAnimator mapboxAnimator = this.animatorArray.get(0);
        if (mapboxAnimator != null) {
            return (LatLng) mapboxAnimator.getAnimatedValue();
        }
        return new LatLng(this.previousLocation);
    }

    private float getPreviousLayerGpsBearing() {
        MapboxFloatAnimator mapboxFloatAnimator = (MapboxFloatAnimator) this.animatorArray.get(2);
        if (mapboxFloatAnimator != null) {
            return ((Float) mapboxFloatAnimator.getAnimatedValue()).floatValue();
        }
        return this.previousLocation.getBearing();
    }

    private float getPreviousLayerCompassBearing() {
        MapboxFloatAnimator mapboxFloatAnimator = (MapboxFloatAnimator) this.animatorArray.get(3);
        if (mapboxFloatAnimator != null) {
            return ((Float) mapboxFloatAnimator.getAnimatedValue()).floatValue();
        }
        return this.previousCompassBearing;
    }

    private float getPreviousAccuracyRadius() {
        MapboxAnimator mapboxAnimator = this.animatorArray.get(6);
        if (mapboxAnimator != null) {
            return ((Float) mapboxAnimator.getAnimatedValue()).floatValue();
        }
        return this.previousAccuracyRadius;
    }

    private LatLng[] getLatLngValues(LatLng latLng, Location[] locationArr) {
        int length = locationArr.length + 1;
        LatLng[] latLngArr = new LatLng[length];
        latLngArr[0] = latLng;
        for (int i = 1; i < length; i++) {
            latLngArr[i] = new LatLng(locationArr[i - 1]);
        }
        return latLngArr;
    }

    private Float[] getBearingValues(Float f, Location[] locationArr) {
        int length = locationArr.length + 1;
        Float[] fArr = new Float[length];
        fArr[0] = Float.valueOf(Utils.normalize(f.floatValue()));
        for (int i = 1; i < length; i++) {
            int i2 = i - 1;
            fArr[i] = Float.valueOf(Utils.shortestRotation(locationArr[i2].getBearing(), fArr[i2].floatValue()));
        }
        return fArr;
    }

    private void updateLayerAnimators(LatLng[] latLngArr, Float[] fArr) {
        createNewLatLngAnimator(0, latLngArr);
        createNewFloatAnimator(2, fArr);
    }

    private void updateCameraAnimators(LatLng[] latLngArr, Float[] fArr) {
        createNewLatLngAnimator(1, latLngArr);
        createNewFloatAnimator(4, fArr);
    }

    private void updateCompassAnimators(float f, float f2, float f3) {
        createNewFloatAnimator(3, f2, Utils.shortestRotation(f, f2));
        createNewFloatAnimator(5, f3, Utils.shortestRotation(f, f3));
    }

    private void updateAccuracyAnimators(float f, float f2) {
        createNewFloatAnimator(6, f2, f);
    }

    private void updateZoomAnimator(float f, float f2, MapboxMap.CancelableCallback cancelableCallback) {
        createNewCameraAdapterAnimator(7, new Float[]{Float.valueOf(f2), Float.valueOf(f)}, cancelableCallback);
    }

    private void updatePaddingAnimator(double[] dArr, double[] dArr2, MapboxMap.CancelableCallback cancelableCallback) {
        createNewPaddingAnimator(10, new double[][]{dArr2, dArr}, cancelableCallback);
    }

    private void updateTiltAnimator(float f, float f2, MapboxMap.CancelableCallback cancelableCallback) {
        createNewCameraAdapterAnimator(8, new Float[]{Float.valueOf(f2), Float.valueOf(f)}, cancelableCallback);
    }

    private void createNewLatLngAnimator(int i, LatLng latLng, LatLng latLng2) {
        createNewLatLngAnimator(i, new LatLng[]{latLng, latLng2});
    }

    private void createNewLatLngAnimator(int i, LatLng[] latLngArr) {
        cancelAnimator(i);
        MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.latLngAnimator(latLngArr, animationsValueChangeListener, this.maxAnimationFps));
        }
    }

    private void createNewFloatAnimator(int i, float f, float f2) {
        createNewFloatAnimator(i, new Float[]{Float.valueOf(f), Float.valueOf(f2)});
    }

    private void createNewFloatAnimator(int i, Float[] fArr) {
        cancelAnimator(i);
        MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.floatAnimator(fArr, animationsValueChangeListener, this.maxAnimationFps));
        }
    }

    private void createNewCameraAdapterAnimator(int i, Float[] fArr, MapboxMap.CancelableCallback cancelableCallback) {
        cancelAnimator(i);
        MapboxAnimator.AnimationsValueChangeListener animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.cameraAnimator(fArr, animationsValueChangeListener, cancelableCallback));
        }
    }

    private void createNewPaddingAnimator(int i, double[][] dArr, MapboxMap.CancelableCallback cancelableCallback) {
        cancelAnimator(i);
        MapboxAnimator.AnimationsValueChangeListener<double[]> animationsValueChangeListener = this.listeners.get(i);
        if (animationsValueChangeListener != null) {
            this.animatorArray.put(i, this.animatorProvider.paddingAnimator(dArr, animationsValueChangeListener, cancelableCallback));
        }
    }

    private void playAnimators(long j, int... iArr) {
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            MapboxAnimator mapboxAnimator = this.animatorArray.get(i);
            if (mapboxAnimator != null) {
                arrayList.add(mapboxAnimator);
            }
        }
        this.animatorSetProvider.startAnimation(arrayList, new LinearInterpolator(), j);
    }

    private void playPulsingAnimator() {
        MapboxAnimator mapboxAnimator = this.animatorArray.get(9);
        if (mapboxAnimator != null) {
            mapboxAnimator.start();
        }
    }

    void resetAllCameraAnimations(CameraPosition cameraPosition, boolean z) {
        resetCameraCompassAnimation(cameraPosition);
        playAnimators(resetCameraLocationAnimations(cameraPosition, z) ? 0L : 750L, 1, 4);
    }

    private boolean resetCameraLocationAnimations(CameraPosition cameraPosition, boolean z) {
        resetCameraGpsBearingAnimation(cameraPosition, z);
        return resetCameraLatLngAnimation(cameraPosition);
    }

    private boolean resetCameraLatLngAnimation(CameraPosition cameraPosition) {
        MapboxLatLngAnimator mapboxLatLngAnimator = (MapboxLatLngAnimator) this.animatorArray.get(1);
        if (mapboxLatLngAnimator == null) {
            return false;
        }
        LatLng target = mapboxLatLngAnimator.getTarget();
        LatLng latLng = cameraPosition.target;
        createNewLatLngAnimator(1, latLng, target);
        return Utils.immediateAnimation(this.projection, latLng, target);
    }

    private void resetCameraGpsBearingAnimation(CameraPosition cameraPosition, boolean z) {
        MapboxFloatAnimator mapboxFloatAnimator = (MapboxFloatAnimator) this.animatorArray.get(4);
        if (mapboxFloatAnimator == null) {
            return;
        }
        float checkGpsNorth = checkGpsNorth(z, mapboxFloatAnimator.getTarget().floatValue());
        float f = (float) cameraPosition.bearing;
        createNewFloatAnimator(4, f, Utils.shortestRotation(checkGpsNorth, f));
    }

    private void resetCameraCompassAnimation(CameraPosition cameraPosition) {
        MapboxFloatAnimator mapboxFloatAnimator = (MapboxFloatAnimator) this.animatorArray.get(5);
        if (mapboxFloatAnimator == null) {
            return;
        }
        float floatValue = mapboxFloatAnimator.getTarget().floatValue();
        float f = (float) cameraPosition.bearing;
        createNewFloatAnimator(5, f, Utils.shortestRotation(floatValue, f));
    }

    void resetAllLayerAnimations() {
        MapboxLatLngAnimator mapboxLatLngAnimator = (MapboxLatLngAnimator) this.animatorArray.get(0);
        MapboxFloatAnimator mapboxFloatAnimator = (MapboxFloatAnimator) this.animatorArray.get(2);
        MapboxFloatAnimator mapboxFloatAnimator2 = (MapboxFloatAnimator) this.animatorArray.get(3);
        MapboxFloatAnimator mapboxFloatAnimator3 = (MapboxFloatAnimator) this.animatorArray.get(6);
        if (mapboxLatLngAnimator != null && mapboxFloatAnimator != null) {
            createNewLatLngAnimator(0, (LatLng) mapboxLatLngAnimator.getAnimatedValue(), mapboxLatLngAnimator.getTarget());
            createNewFloatAnimator(2, ((Float) mapboxFloatAnimator.getAnimatedValue()).floatValue(), mapboxFloatAnimator.getTarget().floatValue());
            playAnimators(mapboxLatLngAnimator.getDuration() - mapboxLatLngAnimator.getCurrentPlayTime(), 0, 2);
        }
        if (mapboxFloatAnimator2 != null) {
            createNewFloatAnimator(3, getPreviousLayerCompassBearing(), mapboxFloatAnimator2.getTarget().floatValue());
            playAnimators(this.compassAnimationEnabled ? 500L : 0L, 3);
        }
        if (mapboxFloatAnimator3 != null) {
            feedNewAccuracyRadius(this.previousAccuracyRadius, false);
        }
    }

    void cancelZoomAnimation() {
        cancelAnimator(7);
    }

    void cancelPaddingAnimation() {
        cancelAnimator(10);
    }

    void cancelTiltAnimation() {
        cancelAnimator(8);
    }

    void cancelAndRemoveGpsBearingAnimation() {
        cancelAnimator(2);
        this.animatorArray.remove(2);
    }

    void stopPulsingCircleAnimation() {
        cancelAnimator(9);
    }

    void cancelAllAnimations() {
        for (int i = 0; i < this.animatorArray.size(); i++) {
            cancelAnimator(this.animatorArray.keyAt(i));
        }
    }

    private void cancelAnimator(int i) {
        MapboxAnimator mapboxAnimator = this.animatorArray.get(i);
        if (mapboxAnimator != null) {
            mapboxAnimator.cancel();
            mapboxAnimator.removeAllUpdateListeners();
            mapboxAnimator.removeAllListeners();
        }
    }

    void setTrackingAnimationDurationMultiplier(float f) {
        this.durationMultiplier = f;
    }

    void setCompassAnimationEnabled(boolean z) {
        this.compassAnimationEnabled = z;
    }

    void setAccuracyAnimationEnabled(boolean z) {
        this.accuracyAnimationEnabled = z;
    }

    void setMaxAnimationFps(int i) {
        if (i <= 0) {
            Logger.e(TAG, "Max animation FPS cannot be less or equal to 0.");
        } else {
            this.maxAnimationFps = i;
        }
    }
}
