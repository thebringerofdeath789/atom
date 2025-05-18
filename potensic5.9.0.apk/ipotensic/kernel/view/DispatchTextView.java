package com.ipotensic.kernel.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.core.app.NotificationCompat;
import com.ipotensic.baselib.DDLog;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: DispatchTextView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u0000 )2\u00020\u0001:\u0001)B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010(\u001a\u00020\u000f2\u0006\u0010%\u001a\u00020$H\u0016R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R7\u0010\u0015\u001a\u001f\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR7\u0010 \u001a\u001f\u0012\u0013\u0012\u00110\u0017\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\u001d\"\u0004\b\"\u0010\u001fR7\u0010#\u001a\u001f\u0012\u0013\u0012\u00110$\u00a2\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(%\u0012\u0004\u0012\u00020\u001b\u0018\u00010\u0016X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\u001d\"\u0004\b'\u0010\u001f\u00a8\u0006*"}, d2 = {"Lcom/ipotensic/kernel/view/DispatchTextView;", "Landroidx/appcompat/widget/AppCompatTextView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "downTime", "", "downX", "", "downY", "isLongClicked", "", "isMoved", "longPressRunnable", "Ljava/lang/Runnable;", "moveX", "moveY", "onClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "", "getOnClick", "()Lkotlin/jvm/functions/Function1;", "setOnClick", "(Lkotlin/jvm/functions/Function1;)V", "onLongClick", "getOnLongClick", "setOnLongClick", "onTouchAction", "Landroid/view/MotionEvent;", NotificationCompat.CATEGORY_EVENT, "getOnTouchAction", "setOnTouchAction", "onTouchEvent", "Companion", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class DispatchTextView extends AppCompatTextView {
    private static final long LONG_CLICK_DURATION = 500;
    private static final long MAX_CLICK_DURATION = 200;
    private static final String TAG = "DispatchView";
    private HashMap _$_findViewCache;
    private long downTime;
    private float downX;
    private float downY;
    private boolean isLongClicked;
    private boolean isMoved;
    private final Runnable longPressRunnable;
    private float moveX;
    private float moveY;
    private Function1<? super View, Unit> onClick;
    private Function1<? super View, Unit> onLongClick;
    private Function1<? super MotionEvent, Unit> onTouchAction;

    public DispatchTextView(Context context) {
        this(context, null, 0, 6, null);
    }

    public DispatchTextView(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ DispatchTextView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DispatchTextView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        this.longPressRunnable = new Runnable() { // from class: com.ipotensic.kernel.view.DispatchTextView$longPressRunnable$1
            @Override // java.lang.Runnable
            public final void run() {
                DDLog.d("DispatchView", "onTouchEvent onLongClick");
                DispatchTextView.this.isLongClicked = true;
                Function1<View, Unit> onLongClick = DispatchTextView.this.getOnLongClick();
                if (onLongClick != null) {
                    onLongClick.invoke(DispatchTextView.this);
                }
            }
        };
    }

    public final Function1<View, Unit> getOnClick() {
        return this.onClick;
    }

    public final void setOnClick(Function1<? super View, Unit> function1) {
        this.onClick = function1;
    }

    public final Function1<View, Unit> getOnLongClick() {
        return this.onLongClick;
    }

    public final void setOnLongClick(Function1<? super View, Unit> function1) {
        this.onLongClick = function1;
    }

    public final Function1<MotionEvent, Unit> getOnTouchAction() {
        return this.onTouchAction;
    }

    public final void setOnTouchAction(Function1<? super MotionEvent, Unit> function1) {
        this.onTouchAction = function1;
    }

    @Override // android.widget.TextView, android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (this.isLongClicked) {
            Function1<? super MotionEvent, Unit> function1 = this.onTouchAction;
            if (function1 != null) {
                function1.invoke(event);
            }
            if (event.getAction() == 1) {
                this.isLongClicked = false;
            }
        }
        int action = event.getAction();
        if (action == 0) {
            this.downTime = System.currentTimeMillis();
            this.downX = event.getX();
            this.downY = event.getY();
            postDelayed(this.longPressRunnable, 500L);
        } else if (action == 1) {
            removeCallbacks(this.longPressRunnable);
            if (System.currentTimeMillis() - this.downTime <= MAX_CLICK_DURATION && !this.isMoved) {
                DDLog.d(TAG, "onTouchEvent onClick");
                this.isMoved = false;
                Function1<? super View, Unit> function12 = this.onClick;
                if (function12 != null) {
                    function12.invoke(this);
                }
                return true;
            }
            this.isMoved = false;
        } else if (action == 2) {
            this.moveX = event.getX() - this.downX;
            this.moveY = event.getY() - this.downY;
            float f = 20;
            if (Math.abs(this.moveX) > f || Math.abs(this.moveY) > f) {
                removeCallbacks(this.longPressRunnable);
                this.isMoved = true;
            }
        }
        return true;
    }
}