package com.mapbox.android.gestures;

import android.content.Context;
import android.view.MotionEvent;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: classes3.dex */
public class MultiFingerTapGestureDetector extends MultiFingerGesture<OnMultiFingerTapGestureListener> {
    private boolean invalidMovement;
    private int lastPointersDownCount;
    private float multiFingerTapMovementThreshold;
    private long multiFingerTapTimeThreshold;
    private boolean pointerLifted;

    public interface OnMultiFingerTapGestureListener {
        boolean onMultiFingerTap(MultiFingerTapGestureDetector multiFingerTapGestureDetector, int i);
    }

    public MultiFingerTapGestureDetector(Context context, AndroidGesturesManager androidGesturesManager) {
        super(context, androidGesturesManager);
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture, com.mapbox.android.gestures.BaseGesture
    protected boolean analyzeEvent(MotionEvent motionEvent) {
        super.analyzeEvent(motionEvent);
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 1) {
            boolean onMultiFingerTap = canExecute(4) ? ((OnMultiFingerTapGestureListener) this.listener).onMultiFingerTap(this, this.lastPointersDownCount) : false;
            reset();
            return onMultiFingerTap;
        }
        if (actionMasked != 2) {
            if (actionMasked == 5) {
                if (this.pointerLifted) {
                    this.invalidMovement = true;
                }
                this.lastPointersDownCount = this.pointerIdList.size();
            } else if (actionMasked == 6) {
                this.pointerLifted = true;
            }
        } else if (!this.invalidMovement) {
            this.invalidMovement = exceededMovementThreshold(this.pointersDistanceMap);
        }
        return false;
    }

    boolean exceededMovementThreshold(HashMap<PointerDistancePair, MultiFingerDistancesObject> hashMap) {
        boolean z;
        Iterator<MultiFingerDistancesObject> it = hashMap.values().iterator();
        do {
            if (!it.hasNext()) {
                return false;
            }
            MultiFingerDistancesObject next = it.next();
            float abs = Math.abs(next.getCurrFingersDiffX() - next.getPrevFingersDiffX());
            float abs2 = Math.abs(next.getCurrFingersDiffY() - next.getPrevFingersDiffY());
            float f = this.multiFingerTapMovementThreshold;
            z = abs > f || abs2 > f;
            this.invalidMovement = z;
        } while (!z);
        return true;
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture, com.mapbox.android.gestures.BaseGesture
    protected boolean canExecute(int i) {
        return this.lastPointersDownCount > 1 && !this.invalidMovement && getGestureDuration() < this.multiFingerTapTimeThreshold && super.canExecute(i);
    }

    @Override // com.mapbox.android.gestures.MultiFingerGesture
    protected void reset() {
        super.reset();
        this.lastPointersDownCount = 0;
        this.invalidMovement = false;
        this.pointerLifted = false;
    }

    public long getMultiFingerTapTimeThreshold() {
        return this.multiFingerTapTimeThreshold;
    }

    public void setMultiFingerTapTimeThreshold(long j) {
        this.multiFingerTapTimeThreshold = j;
    }

    public float getMultiFingerTapMovementThreshold() {
        return this.multiFingerTapMovementThreshold;
    }

    public void setMultiFingerTapMovementThreshold(float f) {
        this.multiFingerTapMovementThreshold = f;
    }

    public void setMultiFingerTapMovementThresholdResource(int i) {
        setMultiFingerTapMovementThreshold(this.context.getResources().getDimension(i));
    }
}