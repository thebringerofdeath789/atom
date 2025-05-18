package com.mapbox.android.gestures;

import android.content.Context;
import android.os.Build;
import android.view.MotionEvent;
import com.mapbox.android.gestures.MoveGestureDetector;
import com.mapbox.android.gestures.MultiFingerTapGestureDetector;
import com.mapbox.android.gestures.RotateGestureDetector;
import com.mapbox.android.gestures.ShoveGestureDetector;
import com.mapbox.android.gestures.SidewaysShoveGestureDetector;
import com.mapbox.android.gestures.StandardGestureDetector;
import com.mapbox.android.gestures.StandardScaleGestureDetector;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: classes3.dex */
public class AndroidGesturesManager {
    public static final int GESTURE_TYPE_DOUBLE_TAP = 10;
    public static final int GESTURE_TYPE_DOUBLE_TAP_EVENT = 11;
    public static final int GESTURE_TYPE_DOWN = 9;
    public static final int GESTURE_TYPE_FLING = 7;
    public static final int GESTURE_TYPE_LONG_PRESS = 6;
    public static final int GESTURE_TYPE_MOVE = 13;
    public static final int GESTURE_TYPE_MULTI_FINGER_TAP = 4;
    public static final int GESTURE_TYPE_QUICK_SCALE = 15;
    public static final int GESTURE_TYPE_ROTATE = 2;
    public static final int GESTURE_TYPE_SCALE = 1;
    public static final int GESTURE_TYPE_SCROLL = 0;
    public static final int GESTURE_TYPE_SHOVE = 3;
    public static final int GESTURE_TYPE_SHOW_PRESS = 8;
    public static final int GESTURE_TYPE_SIDEWAYS_SHOVE = 14;
    public static final int GESTURE_TYPE_SINGLE_TAP_CONFIRMED = 12;
    public static final int GESTURE_TYPE_SINGLE_TAP_UP = 5;
    private final List<BaseGesture> detectors;
    private final MoveGestureDetector moveGestureDetector;
    private final MultiFingerTapGestureDetector multiFingerTapGestureDetector;
    private final List<Set<Integer>> mutuallyExclusiveGestures;
    private final RotateGestureDetector rotateGestureDetector;
    private final ShoveGestureDetector shoveGestureDetector;
    private final SidewaysShoveGestureDetector sidewaysShoveGestureDetector;
    private final StandardGestureDetector standardGestureDetector;
    private final StandardScaleGestureDetector standardScaleGestureDetector;

    @Retention(RetentionPolicy.SOURCE)
    public @interface GestureType {
    }

    public AndroidGesturesManager(Context context) {
        this(context, true);
    }

    public AndroidGesturesManager(Context context, boolean z) {
        this(context, new ArrayList(), z);
    }

    @SafeVarargs
    public AndroidGesturesManager(Context context, Set<Integer>... setArr) {
        this(context, Arrays.asList(setArr), true);
    }

    public AndroidGesturesManager(Context context, List<Set<Integer>> list, boolean z) {
        ArrayList arrayList = new ArrayList();
        this.mutuallyExclusiveGestures = arrayList;
        ArrayList arrayList2 = new ArrayList();
        this.detectors = arrayList2;
        arrayList.addAll(list);
        RotateGestureDetector rotateGestureDetector = new RotateGestureDetector(context, this);
        this.rotateGestureDetector = rotateGestureDetector;
        StandardScaleGestureDetector standardScaleGestureDetector = new StandardScaleGestureDetector(context, this);
        this.standardScaleGestureDetector = standardScaleGestureDetector;
        ShoveGestureDetector shoveGestureDetector = new ShoveGestureDetector(context, this);
        this.shoveGestureDetector = shoveGestureDetector;
        SidewaysShoveGestureDetector sidewaysShoveGestureDetector = new SidewaysShoveGestureDetector(context, this);
        this.sidewaysShoveGestureDetector = sidewaysShoveGestureDetector;
        MultiFingerTapGestureDetector multiFingerTapGestureDetector = new MultiFingerTapGestureDetector(context, this);
        this.multiFingerTapGestureDetector = multiFingerTapGestureDetector;
        MoveGestureDetector moveGestureDetector = new MoveGestureDetector(context, this);
        this.moveGestureDetector = moveGestureDetector;
        StandardGestureDetector standardGestureDetector = new StandardGestureDetector(context, this);
        this.standardGestureDetector = standardGestureDetector;
        arrayList2.add(rotateGestureDetector);
        arrayList2.add(standardScaleGestureDetector);
        arrayList2.add(shoveGestureDetector);
        arrayList2.add(sidewaysShoveGestureDetector);
        arrayList2.add(multiFingerTapGestureDetector);
        arrayList2.add(moveGestureDetector);
        arrayList2.add(standardGestureDetector);
        if (z) {
            initDefaultThresholds();
        }
    }

    private void initDefaultThresholds() {
        for (BaseGesture baseGesture : this.detectors) {
            if (baseGesture instanceof MultiFingerGesture) {
                if (Build.VERSION.SDK_INT < 24) {
                    ((MultiFingerGesture) baseGesture).setSpanThresholdResource(C3063R.dimen.mapbox_internalMinSpan23);
                } else {
                    ((MultiFingerGesture) baseGesture).setSpanThresholdResource(C3063R.dimen.mapbox_internalMinSpan24);
                }
            }
            if (baseGesture instanceof StandardScaleGestureDetector) {
                ((StandardScaleGestureDetector) baseGesture).setSpanSinceStartThresholdResource(C3063R.dimen.mapbox_defaultScaleSpanSinceStartThreshold);
            }
            if (baseGesture instanceof ShoveGestureDetector) {
                ShoveGestureDetector shoveGestureDetector = (ShoveGestureDetector) baseGesture;
                shoveGestureDetector.setPixelDeltaThresholdResource(C3063R.dimen.mapbox_defaultShovePixelThreshold);
                shoveGestureDetector.setMaxShoveAngle(20.0f);
            }
            if (baseGesture instanceof SidewaysShoveGestureDetector) {
                SidewaysShoveGestureDetector sidewaysShoveGestureDetector = (SidewaysShoveGestureDetector) baseGesture;
                sidewaysShoveGestureDetector.setPixelDeltaThresholdResource(C3063R.dimen.mapbox_defaultShovePixelThreshold);
                sidewaysShoveGestureDetector.setMaxShoveAngle(20.0f);
            }
            if (baseGesture instanceof MultiFingerTapGestureDetector) {
                MultiFingerTapGestureDetector multiFingerTapGestureDetector = (MultiFingerTapGestureDetector) baseGesture;
                multiFingerTapGestureDetector.setMultiFingerTapMovementThresholdResource(C3063R.dimen.mapbox_defaultMultiTapMovementThreshold);
                multiFingerTapGestureDetector.setMultiFingerTapTimeThreshold(150L);
            }
            if (baseGesture instanceof RotateGestureDetector) {
                ((RotateGestureDetector) baseGesture).setAngleThreshold(15.3f);
            }
        }
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        Iterator<BaseGesture> it = this.detectors.iterator();
        boolean z = false;
        while (it.hasNext()) {
            if (it.next().onTouchEvent(motionEvent)) {
                z = true;
            }
        }
        return z;
    }

    public void setStandardGestureListener(StandardGestureDetector.StandardOnGestureListener standardOnGestureListener) {
        this.standardGestureDetector.setListener(standardOnGestureListener);
    }

    public void removeStandardGestureListener() {
        this.standardGestureDetector.removeListener();
    }

    public void setStandardScaleGestureListener(StandardScaleGestureDetector.StandardOnScaleGestureListener standardOnScaleGestureListener) {
        this.standardScaleGestureDetector.setListener(standardOnScaleGestureListener);
    }

    public void removeStandardScaleGestureListener() {
        this.standardScaleGestureDetector.removeListener();
    }

    public void setRotateGestureListener(RotateGestureDetector.OnRotateGestureListener onRotateGestureListener) {
        this.rotateGestureDetector.setListener(onRotateGestureListener);
    }

    public void removeRotateGestureListener() {
        this.rotateGestureDetector.removeListener();
    }

    public void setShoveGestureListener(ShoveGestureDetector.OnShoveGestureListener onShoveGestureListener) {
        this.shoveGestureDetector.setListener(onShoveGestureListener);
    }

    public void removeShoveGestureListener() {
        this.shoveGestureDetector.removeListener();
    }

    public void setMultiFingerTapGestureListener(MultiFingerTapGestureDetector.OnMultiFingerTapGestureListener onMultiFingerTapGestureListener) {
        this.multiFingerTapGestureDetector.setListener(onMultiFingerTapGestureListener);
    }

    public void removeMultiFingerTapGestureListener() {
        this.multiFingerTapGestureDetector.removeListener();
    }

    public void setMoveGestureListener(MoveGestureDetector.OnMoveGestureListener onMoveGestureListener) {
        this.moveGestureDetector.setListener(onMoveGestureListener);
    }

    public void removeMoveGestureListener() {
        this.moveGestureDetector.removeListener();
    }

    public void setSidewaysShoveGestureListener(SidewaysShoveGestureDetector.OnSidewaysShoveGestureListener onSidewaysShoveGestureListener) {
        this.sidewaysShoveGestureDetector.setListener(onSidewaysShoveGestureListener);
    }

    public void removeSidewaysShoveGestureListener() {
        this.sidewaysShoveGestureDetector.removeListener();
    }

    public List<BaseGesture> getDetectors() {
        return this.detectors;
    }

    public StandardGestureDetector getStandardGestureDetector() {
        return this.standardGestureDetector;
    }

    public StandardScaleGestureDetector getStandardScaleGestureDetector() {
        return this.standardScaleGestureDetector;
    }

    public RotateGestureDetector getRotateGestureDetector() {
        return this.rotateGestureDetector;
    }

    public ShoveGestureDetector getShoveGestureDetector() {
        return this.shoveGestureDetector;
    }

    public MultiFingerTapGestureDetector getMultiFingerTapGestureDetector() {
        return this.multiFingerTapGestureDetector;
    }

    public MoveGestureDetector getMoveGestureDetector() {
        return this.moveGestureDetector;
    }

    public SidewaysShoveGestureDetector getSidewaysShoveGestureDetector() {
        return this.sidewaysShoveGestureDetector;
    }

    @SafeVarargs
    public final void setMutuallyExclusiveGestures(Set<Integer>... setArr) {
        setMutuallyExclusiveGestures(Arrays.asList(setArr));
    }

    public void setMutuallyExclusiveGestures(List<Set<Integer>> list) {
        this.mutuallyExclusiveGestures.clear();
        this.mutuallyExclusiveGestures.addAll(list);
    }

    public List<Set<Integer>> getMutuallyExclusiveGestures() {
        return this.mutuallyExclusiveGestures;
    }
}