package com.mapbox.android.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.view.GestureDetector;
import android.view.MotionEvent;
import androidx.core.view.GestureDetectorCompat;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes3.dex */
public class StandardScaleGestureDetector extends ProgressiveGesture<StandardOnScaleGestureListener> {
    private static final float QUICK_SCALE_MULTIPLIER = 0.5f;
    private static final Set<Integer> handledTypes;
    private float currentSpan;
    private float currentSpanX;
    private float currentSpanY;
    private final GestureDetectorCompat innerGestureDetector;
    private boolean isScalingOut;
    private float previousSpan;
    private float previousSpanX;
    private float previousSpanY;
    private boolean quickScale;
    private PointF quickScaleFocalPoint;
    private float scaleFactor;
    private float spanDeltaSinceStart;
    private float spanSinceStartThreshold;
    private float startSpan;
    private float startSpanX;
    private float startSpanY;

    public static class SimpleStandardOnScaleGestureListener implements StandardOnScaleGestureListener {
        @Override // com.mapbox.android.gestures.StandardScaleGestureDetector.StandardOnScaleGestureListener
        public boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector) {
            return false;
        }

        @Override // com.mapbox.android.gestures.StandardScaleGestureDetector.StandardOnScaleGestureListener
        public boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector) {
            return true;
        }

        @Override // com.mapbox.android.gestures.StandardScaleGestureDetector.StandardOnScaleGestureListener
        public void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2) {
        }
    }

    public interface StandardOnScaleGestureListener {
        boolean onScale(StandardScaleGestureDetector standardScaleGestureDetector);

        boolean onScaleBegin(StandardScaleGestureDetector standardScaleGestureDetector);

        void onScaleEnd(StandardScaleGestureDetector standardScaleGestureDetector, float f, float f2);
    }

    static {
        HashSet hashSet = new HashSet();
        handledTypes = hashSet;
        hashSet.add(1);
        hashSet.add(15);
    }

    public StandardScaleGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.innerGestureDetector = new GestureDetectorCompat(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.mapbox.android.gestures.StandardScaleGestureDetector.1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (motionEvent.getActionMasked() == 0) {
                    StandardScaleGestureDetector.this.quickScale = true;
                    StandardScaleGestureDetector.this.quickScaleFocalPoint = new PointF(motionEvent.getX(), motionEvent.getY());
                }
                return true;
            }
        });
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected boolean analyzeMovement() {
        super.analyzeMovement();
        boolean z = false;
        if (isInProgress() && this.quickScale && getPointersCount() > 1) {
            gestureStopped();
            return false;
        }
        PointF focalPoint = this.quickScale ? this.quickScaleFocalPoint : getFocalPoint();
        this.currentSpanX = 0.0f;
        this.currentSpanY = 0.0f;
        for (int i = 0; i < getPointersCount(); i++) {
            this.currentSpanX += Math.abs(getCurrentEvent().getX(i) - focalPoint.x);
            this.currentSpanY += Math.abs(getCurrentEvent().getY(i) - focalPoint.y);
        }
        float f = this.currentSpanX * 2.0f;
        this.currentSpanX = f;
        float f2 = this.currentSpanY * 2.0f;
        this.currentSpanY = f2;
        if (this.quickScale) {
            this.currentSpan = f2;
        } else {
            this.currentSpan = (float) Math.hypot(f, f2);
        }
        if (this.startSpan == 0.0f) {
            this.startSpan = this.currentSpan;
            this.startSpanX = this.currentSpanX;
            this.startSpanY = this.currentSpanY;
        }
        this.spanDeltaSinceStart = Math.abs(this.startSpan - this.currentSpan);
        float calculateScaleFactor = calculateScaleFactor();
        this.scaleFactor = calculateScaleFactor;
        this.isScalingOut = calculateScaleFactor < 1.0f;
        if (isInProgress() && this.currentSpan > 0.0f) {
            z = ((StandardOnScaleGestureListener) this.listener).onScale(this);
        } else if (canExecute(this.quickScale ? 15 : 1) && this.spanDeltaSinceStart >= this.spanSinceStartThreshold && (z = ((StandardOnScaleGestureListener) this.listener).onScaleBegin(this))) {
            gestureStarted();
        }
        this.previousSpan = this.currentSpan;
        this.previousSpanX = this.currentSpanX;
        this.previousSpanY = this.currentSpanY;
        return z;
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture
    protected void gestureStopped() {
        super.gestureStopped();
        ((StandardOnScaleGestureListener) this.listener).onScaleEnd(this, this.velocityX, this.velocityY);
        this.quickScale = false;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected void reset() {
        super.reset();
        this.startSpan = 0.0f;
        this.spanDeltaSinceStart = 0.0f;
        this.currentSpan = 0.0f;
        this.previousSpan = 0.0f;
        this.scaleFactor = 1.0f;
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture, com.mapbox.android.gestures.MultiFingerGesture, com.mapbox.android.gestures.BaseGesture
    protected boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (this.quickScale) {
            if (actionMasked == 5 || actionMasked == 3) {
                if (isInProgress()) {
                    interrupt();
                } else {
                    this.quickScale = false;
                }
            } else if (!isInProgress() && actionMasked == 1) {
                this.quickScale = false;
            }
        }
        return this.innerGestureDetector.onTouchEvent(motionEvent) | super.analyzeEvent(motionEvent);
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected int getRequiredPointersCount() {
        return (!isInProgress() || this.quickScale) ? 1 : 2;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected boolean isSloppyGesture() {
        return super.isSloppyGesture() || (!this.quickScale && getPointersCount() < 2);
    }

    @Override // com.mapbox.android.gestures.ProgressiveGesture
    protected Set<Integer> provideHandledTypes() {
        return handledTypes;
    }

    public boolean isScalingOut() {
        return this.isScalingOut;
    }

    public float getSpanSinceStartThreshold() {
        return this.spanSinceStartThreshold;
    }

    public void setSpanSinceStartThreshold(float f) {
        this.spanSinceStartThreshold = f;
    }

    public void setSpanSinceStartThresholdResource(int i) {
        setSpanSinceStartThreshold(this.context.getResources().getDimension(i));
    }

    public float getScaleFactor() {
        return this.scaleFactor;
    }

    public float getStartSpan() {
        return this.startSpan;
    }

    public float getStartSpanX() {
        return this.startSpanX;
    }

    public float getStartSpanY() {
        return this.startSpanY;
    }

    public float getCurrentSpan() {
        return this.currentSpan;
    }

    public float getCurrentSpanX() {
        return this.currentSpanX;
    }

    public float getCurrentSpanY() {
        return this.currentSpanY;
    }

    public float getPreviousSpan() {
        return this.previousSpan;
    }

    public float getPreviousSpanX() {
        return this.previousSpanX;
    }

    public float getPreviousSpanY() {
        return this.previousSpanY;
    }

    private float calculateScaleFactor() {
        if (this.quickScale) {
            boolean z = (getCurrentEvent().getY() < this.quickScaleFocalPoint.y && this.currentSpan < this.previousSpan) || (getCurrentEvent().getY() > this.quickScaleFocalPoint.y && this.currentSpan > this.previousSpan);
            float abs = Math.abs(1.0f - (this.currentSpan / this.previousSpan)) * 0.5f;
            if (this.previousSpan <= 0.0f) {
                return 1.0f;
            }
            return z ? 1.0f + abs : 1.0f - abs;
        }
        float f = this.previousSpan;
        if (f > 0.0f) {
            return this.currentSpan / f;
        }
        return 1.0f;
    }
}
