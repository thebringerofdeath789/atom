package com.mapbox.android.gestures;

import android.content.Context;
import android.graphics.PointF;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

/* loaded from: classes3.dex */
public abstract class MultiFingerGesture<L> extends BaseGesture<L> {
    private static final int DEFAULT_REQUIRED_FINGERS_COUNT = 2;
    private static final float PRESSURE_THRESHOLD = 0.67f;
    private DisplayMetrics displayMetrics;
    private final float edgeSlop;
    private PointF focalPoint;
    private final PermittedActionsGuard permittedActionsGuard;
    final List<Integer> pointerIdList;
    final HashMap<PointerDistancePair, MultiFingerDistancesObject> pointersDistanceMap;
    private float spanThreshold;

    protected boolean analyzeMovement() {
        return false;
    }

    protected int getRequiredPointersCount() {
        return 2;
    }

    protected void reset() {
    }

    public MultiFingerGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
        this.permittedActionsGuard = new PermittedActionsGuard();
        this.pointerIdList = new ArrayList();
        this.pointersDistanceMap = new HashMap<>();
        this.focalPoint = new PointF();
        this.edgeSlop = ViewConfiguration.get(context).getScaledEdgeSlop();
        queryDisplayMetrics();
    }

    @Override // com.mapbox.android.gestures.BaseGesture
    protected boolean analyzeEvent(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0) {
            queryDisplayMetrics();
        }
        boolean z = this.permittedActionsGuard.isMissingActions(actionMasked, motionEvent.getPointerCount(), this.pointerIdList.size()) || (actionMasked == 2 && isMissingPointers(motionEvent));
        if (z) {
            if (this instanceof ProgressiveGesture) {
                ProgressiveGesture progressiveGesture = (ProgressiveGesture) this;
                if (progressiveGesture.isInProgress()) {
                    progressiveGesture.gestureStopped();
                }
            }
            this.pointerIdList.clear();
            this.pointersDistanceMap.clear();
        }
        if (!z || actionMasked == 0) {
            updatePointerList(motionEvent);
        }
        this.focalPoint = Utils.determineFocalPoint(motionEvent);
        if (z) {
            Log.w("MultiFingerGesture", "Some MotionEvents were not passed to the library or events from different view trees are merged.");
            return false;
        }
        if (actionMasked == 2 && this.pointerIdList.size() >= getRequiredPointersCount() && checkPressure()) {
            calculateDistances();
            if (!isSloppyGesture()) {
                return analyzeMovement();
            }
        }
        return false;
    }

    private void queryDisplayMetrics() {
        if (this.windowManager != null) {
            this.displayMetrics = new DisplayMetrics();
            Display defaultDisplay = this.windowManager.getDefaultDisplay();
            if (Build.VERSION.SDK_INT >= 17) {
                defaultDisplay.getRealMetrics(this.displayMetrics);
                return;
            } else {
                defaultDisplay.getMetrics(this.displayMetrics);
                return;
            }
        }
        this.displayMetrics = this.context.getResources().getDisplayMetrics();
    }

    private void updatePointerList(MotionEvent motionEvent) {
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 0 || actionMasked == 5) {
            this.pointerIdList.add(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        } else if (actionMasked == 1 || actionMasked == 6) {
            this.pointerIdList.remove(Integer.valueOf(motionEvent.getPointerId(motionEvent.getActionIndex())));
        }
    }

    private boolean isMissingPointers(MotionEvent motionEvent) {
        boolean z;
        Iterator<Integer> it = this.pointerIdList.iterator();
        do {
            z = false;
            if (!it.hasNext()) {
                return false;
            }
            if (motionEvent.findPointerIndex(it.next().intValue()) != -1) {
                z = true;
            }
        } while (z);
        return true;
    }

    boolean checkPressure() {
        return getCurrentEvent().getPressure() / getPreviousEvent().getPressure() > PRESSURE_THRESHOLD;
    }

    private boolean checkSpanBelowThreshold() {
        Iterator<MultiFingerDistancesObject> it = this.pointersDistanceMap.values().iterator();
        while (it.hasNext()) {
            if (it.next().getCurrFingersDiffXY() < this.spanThreshold) {
                return true;
            }
        }
        return false;
    }

    protected boolean isSloppyGesture() {
        float f = this.displayMetrics.widthPixels - this.edgeSlop;
        float f2 = this.displayMetrics.heightPixels;
        float f3 = this.edgeSlop;
        float f4 = f2 - f3;
        Iterator<Integer> it = this.pointerIdList.iterator();
        while (it.hasNext()) {
            int findPointerIndex = getCurrentEvent().findPointerIndex(it.next().intValue());
            float rawX = Utils.getRawX(getCurrentEvent(), findPointerIndex);
            float rawY = Utils.getRawY(getCurrentEvent(), findPointerIndex);
            if (rawX < f3 || rawY < f3 || rawX > f || rawY > f4) {
                return true;
            }
        }
        return checkSpanBelowThreshold();
    }

    @Override // com.mapbox.android.gestures.BaseGesture
    protected boolean canExecute(int i) {
        return super.canExecute(i) && !isSloppyGesture();
    }

    private void calculateDistances() {
        this.pointersDistanceMap.clear();
        int i = 0;
        while (i < this.pointerIdList.size() - 1) {
            int i2 = i + 1;
            for (int i3 = i2; i3 < this.pointerIdList.size(); i3++) {
                int intValue = this.pointerIdList.get(i).intValue();
                int intValue2 = this.pointerIdList.get(i3).intValue();
                float x = getPreviousEvent().getX(getPreviousEvent().findPointerIndex(intValue));
                float y = getPreviousEvent().getY(getPreviousEvent().findPointerIndex(intValue));
                this.pointersDistanceMap.put(new PointerDistancePair(Integer.valueOf(intValue), Integer.valueOf(intValue2)), new MultiFingerDistancesObject(getPreviousEvent().getX(getPreviousEvent().findPointerIndex(intValue2)) - x, getPreviousEvent().getY(getPreviousEvent().findPointerIndex(intValue2)) - y, getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue2)) - getCurrentEvent().getX(getCurrentEvent().findPointerIndex(intValue)), getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue2)) - getCurrentEvent().getY(getCurrentEvent().findPointerIndex(intValue))));
            }
            i = i2;
        }
    }

    public float getCurrentSpan(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getCurrFingersDiffXY();
    }

    public float getPreviousSpan(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getPrevFingersDiffXY();
    }

    public float getCurrentSpanX(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getCurrFingersDiffX());
    }

    public float getCurrentSpanY(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getCurrFingersDiffY());
    }

    public float getPreviousSpanX(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getPrevFingersDiffX());
    }

    public float getPreviousSpanY(int i, int i2) {
        if (!verifyPointers(i, i2)) {
            throw new NoSuchElementException("There is no such pair of pointers!");
        }
        return Math.abs(this.pointersDistanceMap.get(new PointerDistancePair(this.pointerIdList.get(i), this.pointerIdList.get(i2))).getPrevFingersDiffY());
    }

    private boolean verifyPointers(int i, int i2) {
        return i != i2 && i >= 0 && i2 >= 0 && i < getPointersCount() && i2 < getPointersCount();
    }

    public int getPointersCount() {
        return this.pointerIdList.size();
    }

    public PointF getFocalPoint() {
        return this.focalPoint;
    }

    public float getSpanThreshold() {
        return this.spanThreshold;
    }

    public void setSpanThreshold(float f) {
        this.spanThreshold = f;
    }

    public void setSpanThresholdResource(int i) {
        setSpanThreshold(this.context.getResources().getDimension(i));
    }
}
