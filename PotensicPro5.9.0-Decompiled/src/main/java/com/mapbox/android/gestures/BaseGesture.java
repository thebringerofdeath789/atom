package com.mapbox.android.gestures;

import android.content.Context;
import android.view.MotionEvent;
import android.view.WindowManager;
import java.util.Iterator;
import java.util.Set;

/* loaded from: classes3.dex */
public abstract class BaseGesture<L> {
    protected final Context context;
    private MotionEvent currentEvent;
    private long gestureDuration;
    private final AndroidGesturesManager gesturesManager;
    private boolean isEnabled = true;
    protected L listener;
    private MotionEvent previousEvent;
    protected final WindowManager windowManager;

    protected abstract boolean analyzeEvent(MotionEvent motionEvent);

    public BaseGesture(Context context, AndroidGesturesManager androidGesturesManager) {
        this.context = context;
        this.windowManager = (WindowManager) context.getSystemService("window");
        this.gesturesManager = androidGesturesManager;
    }

    protected boolean onTouchEvent(MotionEvent motionEvent) {
        return analyze(motionEvent);
    }

    private boolean analyze(MotionEvent motionEvent) {
        if (motionEvent == null) {
            return false;
        }
        MotionEvent motionEvent2 = this.previousEvent;
        if (motionEvent2 != null) {
            motionEvent2.recycle();
            this.previousEvent = null;
        }
        MotionEvent motionEvent3 = this.currentEvent;
        if (motionEvent3 != null) {
            this.previousEvent = MotionEvent.obtain(motionEvent3);
            this.currentEvent.recycle();
            this.currentEvent = null;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        this.currentEvent = obtain;
        this.gestureDuration = obtain.getEventTime() - this.currentEvent.getDownTime();
        return analyzeEvent(motionEvent);
    }

    protected boolean canExecute(int i) {
        if (this.listener == null || !this.isEnabled) {
            return false;
        }
        for (Set<Integer> set : this.gesturesManager.getMutuallyExclusiveGestures()) {
            if (set.contains(Integer.valueOf(i))) {
                Iterator<Integer> it = set.iterator();
                while (it.hasNext()) {
                    int intValue = it.next().intValue();
                    for (BaseGesture baseGesture : this.gesturesManager.getDetectors()) {
                        if (baseGesture instanceof ProgressiveGesture) {
                            ProgressiveGesture progressiveGesture = (ProgressiveGesture) baseGesture;
                            if (progressiveGesture.getHandledTypes().contains(Integer.valueOf(intValue)) && progressiveGesture.isInProgress()) {
                                return false;
                            }
                        }
                    }
                }
            }
        }
        return true;
    }

    protected void setListener(L l) {
        this.listener = l;
    }

    protected void removeListener() {
        this.listener = null;
    }

    public long getGestureDuration() {
        return this.gestureDuration;
    }

    public MotionEvent getCurrentEvent() {
        return this.currentEvent;
    }

    public MotionEvent getPreviousEvent() {
        return this.previousEvent;
    }

    public boolean isEnabled() {
        return this.isEnabled;
    }

    public void setEnabled(boolean z) {
        this.isEnabled = z;
    }
}
