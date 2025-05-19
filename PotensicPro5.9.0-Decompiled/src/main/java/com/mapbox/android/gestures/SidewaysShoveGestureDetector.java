package com.mapbox.android.gestures;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class SidewaysShoveGestureDetector extends ProgressiveGesture<OnSidewaysShoveGestureListener> {
    private static final Set<Integer> handledTypes;
    float deltaPixelSinceLast;
    float deltaPixelsSinceStart;
    private float maxShoveAngle;
    private float pixelDeltaThreshold;

    public interface OnSidewaysShoveGestureListener {
        boolean onSidewaysShove(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2);

        boolean onSidewaysShoveBegin(SidewaysShoveGestureDetector sidewaysShoveGestureDetector);

        void onSidewaysShoveEnd(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2);
    }

    public static class SimpleOnSidewaysShoveGestureListener implements OnSidewaysShoveGestureListener {
        @Override // com.mapbox.android.gestures.SidewaysShoveGestureDetector.OnSidewaysShoveGestureListener
        public boolean onSidewaysShove(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2) {
            return false;
        }

        @Override // com.mapbox.android.gestures.SidewaysShoveGestureDetector.OnSidewaysShoveGestureListener
        public boolean onSidewaysShoveBegin(SidewaysShoveGestureDetector sidewaysShoveGestureDetector) {
            return true;
        }

        @Override // com.mapbox.android.gestures.SidewaysShoveGestureDetector.OnSidewaysShoveGestureListener
        public void onSidewaysShoveEnd(SidewaysShoveGestureDetector sidewaysShoveGestureDetector, float f, float f2) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        handledTypes = hashSet;
        hashSet.add(14);
    }

    public SidewaysShoveGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
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
            return ((OnSidewaysShoveGestureListener) this.listener).onSidewaysShove(this, this.deltaPixelSinceLast, this.deltaPixelsSinceStart);
        }
        if (!canExecute(14) || !((OnSidewaysShoveGestureListener) this.listener).onSidewaysShoveBegin(this)) {
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
        ((OnSidewaysShoveGestureListener) this.listener).onSidewaysShoveEnd(this, this.velocityX, this.velocityY);
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected void reset() {
        super.reset();
        this.deltaPixelsSinceStart = 0.0f;
    }

    boolean isAngleAcceptable() {
        MultiFingerDistancesObject multiFingerDistancesObject = this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(0), this.pointerIdList.get(1)));
        return Math.abs(Math.toDegrees(Math.abs(Math.atan2((double) multiFingerDistancesObject.getCurrFingersDiffY(), (double) multiFingerDistancesObject.getCurrFingersDiffX()))) - 90.0d) <= ((double) this.maxShoveAngle);
    }

    float calculateDeltaPixelsSinceLast() {
        return ((getCurrentEvent().getX(getCurrentEvent().findPointerIndex(this.pointerIdList.get(0).intValue())) + getCurrentEvent().getX(getCurrentEvent().findPointerIndex(this.pointerIdList.get(1).intValue()))) / 2.0f) - ((getPreviousEvent().getX(getPreviousEvent().findPointerIndex(this.pointerIdList.get(0).intValue())) + getPreviousEvent().getX(getPreviousEvent().findPointerIndex(this.pointerIdList.get(1).intValue()))) / 2.0f);
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
