package com.ipotensic.kernel.view;

import android.view.ScaleGestureDetector;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoFingerScaleView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0006\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0004\u001a\u00020\u0005H\u0016\u00a8\u0006\t"}, d2 = {"com/ipotensic/kernel/view/TwoFingerScaleView$scaleGestureDetector$1", "Landroid/view/ScaleGestureDetector$OnScaleGestureListener;", "onScale", "", "detector", "Landroid/view/ScaleGestureDetector;", "onScaleBegin", "onScaleEnd", "", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TwoFingerScaleView$scaleGestureDetector$1 implements ScaleGestureDetector.OnScaleGestureListener {
    TwoFingerScaleView$scaleGestureDetector$1() {
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScale(ScaleGestureDetector detector) {
        Intrinsics.checkParameterIsNotNull(detector, "detector");
        float scaleFactor = detector.getScaleFactor();
        Function2<Float, Integer, Unit> onScaleChangedListener = TwoFingerScaleView.this.getOnScaleChangedListener();
        if (onScaleChangedListener == null) {
            return true;
        }
        onScaleChangedListener.invoke(Float.valueOf(scaleFactor), 2);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public boolean onScaleBegin(ScaleGestureDetector detector) {
        Intrinsics.checkParameterIsNotNull(detector, "detector");
        Function2<Float, Integer, Unit> onScaleChangedListener = TwoFingerScaleView.this.getOnScaleChangedListener();
        if (onScaleChangedListener == null) {
            return true;
        }
        onScaleChangedListener.invoke(Float.valueOf(1.0f), 0);
        return true;
    }

    @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
    public void onScaleEnd(ScaleGestureDetector detector) {
        Intrinsics.checkParameterIsNotNull(detector, "detector");
        Function2<Float, Integer, Unit> onScaleChangedListener = TwoFingerScaleView.this.getOnScaleChangedListener();
        if (onScaleChangedListener != null) {
            onScaleChangedListener.invoke(Float.valueOf(1.0f), 1);
        }
    }
}