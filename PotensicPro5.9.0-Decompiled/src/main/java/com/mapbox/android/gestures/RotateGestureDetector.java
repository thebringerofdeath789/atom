package com.mapbox.android.gestures;

import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class RotateGestureDetector extends ProgressiveGesture<OnRotateGestureListener> {
    private static final Set<Integer> handledTypes;
    private float angleThreshold;
    float deltaSinceLast;
    float deltaSinceStart;

    public interface OnRotateGestureListener {
        boolean onRotate(RotateGestureDetector rotateGestureDetector, float f, float f2);

        boolean onRotateBegin(RotateGestureDetector rotateGestureDetector);

        void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3);
    }

    public static class SimpleOnRotateGestureListener implements OnRotateGestureListener {
        @Override // com.mapbox.android.gestures.RotateGestureDetector.OnRotateGestureListener
        public boolean onRotate(RotateGestureDetector rotateGestureDetector, float f, float f2) {
            return true;
        }

        @Override // com.mapbox.android.gestures.RotateGestureDetector.OnRotateGestureListener
        public boolean onRotateBegin(RotateGestureDetector rotateGestureDetector) {
            return true;
        }

        @Override // com.mapbox.android.gestures.RotateGestureDetector.OnRotateGestureListener
        public void onRotateEnd(RotateGestureDetector rotateGestureDetector, float f, float f2, float f3) {
        }
    }

    static {
        HashSet hashSet = new HashSet();
        handledTypes = hashSet;
        hashSet.add(2);
    }

    public RotateGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture
    protected Set<Integer> provideHandledTypes() {
        return handledTypes;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected boolean analyzeMovement() {
        super.analyzeMovement();
        float rotationDegreesSinceLast = getRotationDegreesSinceLast();
        this.deltaSinceLast = rotationDegreesSinceLast;
        this.deltaSinceStart += rotationDegreesSinceLast;
        if (isInProgress() && this.deltaSinceLast != 0.0f) {
            return ((OnRotateGestureListener) this.listener).onRotate(this, this.deltaSinceLast, this.deltaSinceStart);
        }
        if (!canExecute(2) || !((OnRotateGestureListener) this.listener).onRotateBegin(this)) {
            return false;
        }
        gestureStarted();
        return true;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture, com.mapbox.android.gestures.BaseGesture
    protected boolean canExecute(int i) {
        return Math.abs(this.deltaSinceStart) >= this.angleThreshold && super.canExecute(i);
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture
    protected void gestureStopped() {
        super.gestureStopped();
        if (this.deltaSinceLast == 0.0f) {
            this.velocityX = 0.0f;
            this.velocityY = 0.0f;
        }
        ((OnRotateGestureListener) this.listener).onRotateEnd(this, this.velocityX, this.velocityY, calculateAngularVelocityVector(this.velocityX, this.velocityY));
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected void reset() {
        super.reset();
        this.deltaSinceStart = 0.0f;
    }

    float getRotationDegreesSinceLast() {
        MultiFingerDistancesObject multiFingerDistancesObject = this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(0), this.pointerIdList.get(1)));
        return (float) Math.toDegrees(Math.atan2(multiFingerDistancesObject.getPrevFingersDiffY(), multiFingerDistancesObject.getPrevFingersDiffX()) - Math.atan2(multiFingerDistancesObject.getCurrFingersDiffY(), multiFingerDistancesObject.getCurrFingersDiffX()));
    }

    float calculateAngularVelocityVector(float f, float f2) {
        float abs = Math.abs((float) (((getFocalPoint().x * f2) + (getFocalPoint().y * f)) / (Math.pow(getFocalPoint().x, 2.0d) + Math.pow(getFocalPoint().y, 2.0d))));
        return this.deltaSinceLast < 0.0f ? -abs : abs;
    }

    public float getDeltaSinceStart() {
        return this.deltaSinceStart;
    }

    public float getDeltaSinceLast() {
        return this.deltaSinceLast;
    }

    public float getAngleThreshold() {
        return this.angleThreshold;
    }

    public void setAngleThreshold(float f) {
        this.angleThreshold = f;
    }
}
