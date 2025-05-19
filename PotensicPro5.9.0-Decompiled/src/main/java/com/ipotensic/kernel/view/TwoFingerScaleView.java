package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import androidx.core.app.NotificationCompat;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: TwoFingerScaleView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0012\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\u000b\u001a\u0016\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u000e\u0018\u00010\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/ipotensic/kernel/view/TwoFingerScaleView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "gestureDetector", "Landroid/view/GestureDetector;", "onScaleChangedListener", "Lkotlin/Function2;", "", "", "getOnScaleChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnScaleChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "scaleGestureDetector", "Landroid/view/ScaleGestureDetector;", "onTouchEvent", "", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TwoFingerScaleView extends View {
    private static final String TAG = "TwoFingerScaleView";
    private HashMap _$_findViewCache;
    private final GestureDetector gestureDetector;
    private Function2<? super Float, ? super Integer, Unit> onScaleChangedListener;
    private final ScaleGestureDetector scaleGestureDetector;

    public TwoFingerScaleView(Context context) {
        this(context, null, 0, 6, null);
    }

    public TwoFingerScaleView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this._$_findViewCache;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this._$_findViewCache == null) {
            this._$_findViewCache = new HashMap();
        }
        View view = (View) this._$_findViewCache.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this._$_findViewCache.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    public /* synthetic */ TwoFingerScaleView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TwoFingerScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.scaleGestureDetector = new ScaleGestureDetector(context, new ScaleGestureDetector.OnScaleGestureListener() { // from class: com.ipotensic.kernel.view.TwoFingerScaleView$scaleGestureDetector$1
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
                Function2<Float, Integer, Unit> onScaleChangedListener = TwoFingerScaleView.this.getOnScaleChangedListener();
                if (onScaleChangedListener == null) {
                    return true;
                }
                onScaleChangedListener.invoke(Float.valueOf(1.0f), 0);
                return true;
            }

            @Override // android.view.ScaleGestureDetector.OnScaleGestureListener
            public void onScaleEnd(ScaleGestureDetector detector) {
                Function2<Float, Integer, Unit> onScaleChangedListener = TwoFingerScaleView.this.getOnScaleChangedListener();
                if (onScaleChangedListener != null) {
                    onScaleChangedListener.invoke(Float.valueOf(1.0f), 1);
                }
            }
        });
        this.gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() { // from class: com.ipotensic.kernel.view.TwoFingerScaleView$gestureDetector$1
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTap(MotionEvent e) {
                return true;
            }
        });
    }

    public final Function2<Float, Integer, Unit> getOnScaleChangedListener() {
        return this.onScaleChangedListener;
    }

    public final void setOnScaleChangedListener(Function2<? super Float, ? super Integer, Unit> function2) {
        this.onScaleChangedListener = function2;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        if (this.gestureDetector.onTouchEvent(event)) {
            return true;
        }
        return this.scaleGestureDetector.onTouchEvent(event);
    }
}
