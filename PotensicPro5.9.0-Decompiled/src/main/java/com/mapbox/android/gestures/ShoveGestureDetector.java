package com.mapbox.android.gestures;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class ShoveGestureDetector extends ProgressiveGesture<OnShoveGestureListener> {
    private static final Set<Integer> handledTypes;
    float deltaPixelSinceLast;
    float deltaPixelsSinceStart;
    private float maxShoveAngle;
    private float pixelDeltaThreshold;

    public interface OnShoveGestureListener {
        boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2);

        boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector);

        void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2);
    }

    public static class SimpleOnShoveGestureListener implements OnShoveGestureListener {
        @Override // com.mapbox.android.gestures.ShoveGestureDetector.OnShoveGestureListener
        public boolean onShove(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
            return false;
        }

        @Override // com.mapbox.android.gestures.ShoveGestureDetector.OnShoveGestureListener
        public boolean onShoveBegin(ShoveGestureDetector shoveGestureDetector) {
            return true;
        }

        @Override // com.mapbox.android.gestures.ShoveGestureDetector.OnShoveGestureListener
        public void onShoveEnd(ShoveGestureDetector shoveGestureDetector, float f, float f2) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        handledTypes = hashSet;
        hashSet.add(3);
    }

    public ShoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture
    protected Set<Integer> provideHandledTypes() {
        return handledTypes;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected boolean analyzeMovement() {
        super.analyzeMovement();
        float calculateDeltaPixelsSinceLast = calculateDeltaPixelsSinceLast();
        this.deltaPixelSinceLast = calculateDeltaPixelsSinceLast;
        this.deltaPixelsSinceStart += calculateDeltaPixelsSinceLast;
        if (isInProgress() && this.deltaPixelSinceLast != 0.0f) {
            return ((OnShoveGestureListener) this.listener).onShove(this, this.deltaPixelSinceLast, this.deltaPixelsSinceStart);
        }
        if (!canExecute(3) || !((OnShoveGestureListener) this.listener).onShoveBegin(this)) {
            return false;
        }
        gestureStarted();
        return true;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture, com.mapbox.android.gestures.BaseGesture
    protected boolean canExecute(int i) {
        return Math.abs(this.deltaPixelsSinceStart) >= this.pixelDeltaThreshold && super.canExecute(i);
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected boolean isSloppyGesture() {
        return super.isSloppyGesture() || !isAngleAcceptable();
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture
    protected void gestureStopped() {
        super.gestureStopped();
        ((OnShoveGestureListener) this.listener).onShoveEnd(this, this.velocityX, this.velocityY);
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected void reset() {
        super.reset();
        this.deltaPixelsSinceStart = 0.0f;
    }

    boolean isAngleAcceptable() {
        MultiFingerDistancesObject multiFingerDistancesObject = this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(0), this.pointerIdList.get(1)));
        double degrees = Math.toDegrees(Math.abs(Math.atan2(multiFingerDistancesObject.getCurrFingersDiffY(), multiFingerDistancesObject.getCurrFingersDiffX())));
        float f = this.maxShoveAngle;
        return degrees <= ((double) f) || 180.0d - degrees <= ((double) f);
    }

    float calculateDeltaPixelsSinceLast() {
        return ((getCurrentEvent().getY(getCurrentEvent().findPointerIndex(this.pointerIdList.get(0).intValue())) + getCurrentEvent().getY(getCurrentEvent().findPointerIndex(this.pointerIdList.get(1).intValue()))) / 2.0f) - ((getPreviousEvent().getY(getPreviousEvent().findPointerIndex(this.pointerIdList.get(0).intValue())) + getPreviousEvent().getY(getPreviousEvent().findPointerIndex(this.pointerIdList.get(1).intValue()))) / 2.0f);
    }

    public float getDeltaPixelsSinceStart() {
        return this.deltaPixelsSinceStart;
    }

    public float getDeltaPixelSinceLast() {
        return this.deltaPixelSinceLast;
    }

    public float getPixelDeltaThreshold() {
        return this.pixelDeltaThreshold;
    }

    public void setPixelDeltaThreshold(float f) {
        this.pixelDeltaThreshold = f;
    }

    public void setPixelDeltaThresholdResource(int i) {
        setPixelDeltaThreshold(this.context.getResources().getDimension(i));
    }

    public float getMaxShoveAngle() {
        return this.maxShoveAngle;
    }

    public void setMaxShoveAngle(float f) {
        this.maxShoveAngle = f;
    }
}
