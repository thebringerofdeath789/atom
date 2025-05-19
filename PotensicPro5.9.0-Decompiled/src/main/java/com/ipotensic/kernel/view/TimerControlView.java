package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.os.Vibrator;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.kernel.R;
import io.netty.handler.codec.rtsp.RtspHeaders;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.IntProgression;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* compiled from: TimerControlView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 N2\u00020\u0001:\u0002NOB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u00106\u001a\u00020#H\u0002J\u0018\u00107\u001a\u00020\f2\u0006\u00108\u001a\u00020\f2\u0006\u00109\u001a\u00020\fH\u0002J\u0018\u0010:\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010;\u001a\u00020\fH\u0002J\b\u0010<\u001a\u00020\u0007H\u0002J\u001a\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020?2\b\b\u0002\u0010@\u001a\u00020\u0007H\u0002J\u0010\u0010A\u001a\u00020#2\u0006\u0010B\u001a\u00020CH\u0014J\u0010\u0010D\u001a\u00020\u001c2\u0006\u0010E\u001a\u00020FH\u0016J\u000e\u0010G\u001a\u00020#2\u0006\u0010H\u001a\u00020\u0007J\u000e\u0010I\u001a\u00020#2\u0006\u0010E\u001a\u00020FJ\b\u0010J\u001a\u00020#H\u0002J\u000e\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020MR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010!\u001a\u0016\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020#\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u000e\u0010(\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010*\u001a\u0004\u0018\u00010+X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010/\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u00101\u001a\u0012\u0012\u0004\u0012\u00020\u000702j\b\u0012\u0004\u0012\u00020\u0007`3X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/ipotensic/kernel/view/TimerControlView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateItp", "", "angleCha", "", "bgBitmap", "Landroid/graphics/Bitmap;", "bitmapPaint", "Landroid/graphics/Paint;", "clickAngle", "curTime", "getCurTime", "()F", "setCurTime", "(F)V", "currentScalePaint", "currentScaleTextSize", "downX", "downY", "isNeedVibrate", "", "lastAngle", "longScaleLen", "mHandler", "Landroid/os/Handler;", "onTimeChangedListener", "Lkotlin/Function2;", "", "getOnTimeChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnTimeChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "pointerBitmap", "recentAngle", "rectF", "Landroid/graphics/RectF;", "scaleAngle", "scalePaint", "scaleTextPaint", "scaleTextSize", "shortScaleLen", "timeList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "vibrateValue", "viewRunning", "calZoom", "calcAngle", "targetX", "targetY", "dpToPx", "dpValue", "getTime", "keepDecimals", "v", "", RtspHeaders.SCALE, "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setTime", RtspHeaders.Values.TIME, "updateDownXY", "updateZoom", "vibrate", "milliseconds", "", "Companion", "MyThread", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class TimerControlView extends View {
    private static final String TAG = "TimerControlView";
    private HashMap _$_findViewCache;
    private final double[] accelerateItp;
    private float angleCha;
    private Bitmap bgBitmap;
    private final Paint bitmapPaint;
    private float clickAngle;
    private float curTime;
    private final Paint currentScalePaint;
    private final float currentScaleTextSize;
    private float downX;
    private float downY;
    private boolean isNeedVibrate;
    private float lastAngle;
    private final float longScaleLen;
    private final Handler mHandler;
    private Function2<? super Integer, ? super Integer, Unit> onTimeChangedListener;
    private Bitmap pointerBitmap;
    private float recentAngle;
    private RectF rectF;
    private float scaleAngle;
    private final Paint scalePaint;
    private final Paint scaleTextPaint;
    private final float scaleTextSize;
    private final float shortScaleLen;
    private final ArrayList<Integer> timeList;
    private float vibrateValue;
    private boolean viewRunning;

    public TimerControlView(Context context) {
        this(context, null, 0, 6, null);
    }

    public TimerControlView(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ TimerControlView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TimerControlView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkParameterIsNotNull(context, "context");
        Paint paint = new Paint();
        this.bitmapPaint = paint;
        Paint paint2 = new Paint();
        this.scalePaint = paint2;
        Paint paint3 = new Paint();
        this.scaleTextPaint = paint3;
        Paint paint4 = new Paint();
        this.currentScalePaint = paint4;
        this.shortScaleLen = dpToPx(context, 8.0f);
        this.longScaleLen = dpToPx(context, 10.0f);
        float dpToPx = dpToPx(context, 12.0f);
        this.scaleTextSize = dpToPx;
        float dpToPx2 = dpToPx(context, 18.0f);
        this.currentScaleTextSize = dpToPx2;
        this.scaleAngle = 12.7678f;
        this.isNeedVibrate = true;
        this.lastAngle = 1.0f;
        ArrayList<Integer> arrayList = new ArrayList<>();
        this.timeList = arrayList;
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.zoom_circle_bg);
        Intrinsics.checkExpressionValueIsNotNull(decodeResource, "BitmapFactory.decodeReso… R.mipmap.zoom_circle_bg)");
        this.bgBitmap = decodeResource;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.mipmap.zoom_pointer);
        Intrinsics.checkExpressionValueIsNotNull(decodeResource2, "BitmapFactory.decodeReso…s, R.mipmap.zoom_pointer)");
        this.pointerBitmap = decodeResource2;
        final Looper mainLooper = Looper.getMainLooper();
        this.mHandler = new Handler(mainLooper) { // from class: com.ipotensic.kernel.view.TimerControlView$mHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                if (msg.what == 0) {
                    TimerControlView.this.invalidate();
                } else if (msg.what == 1) {
                    TimerControlView.this.invalidate();
                }
            }
        };
        paint.setAntiAlias(true);
        paint4.setAntiAlias(true);
        paint4.setTextSize(dpToPx2);
        paint4.setColor(Color.parseColor("#21D525"));
        paint2.setAntiAlias(true);
        paint2.setColor(-1);
        paint2.setStrokeWidth(dpToPx(context, 1.0f));
        paint3.setAntiAlias(true);
        paint3.setTextSize(dpToPx);
        paint3.setColor(-1);
        arrayList.add(0);
        for (int i2 = 2; i2 <= 10; i2++) {
            this.timeList.add(Integer.valueOf(i2));
        }
        IntProgression step = RangesKt.step(new IntRange(15, 30), 5);
        int first = step.getFirst();
        int last = step.getLast();
        int step2 = step.getStep();
        if (step2 < 0 ? first >= last : first <= last) {
            while (true) {
                this.timeList.add(Integer.valueOf(first));
                if (first == last) {
                    break;
                } else {
                    first += step2;
                }
            }
        }
        this.accelerateItp = new double[]{1.0d, 0.9998d, 0.999d, 0.9978d, 0.9961d, 0.9938d, 0.9911d, 0.988d, 0.9843d, 0.9801d, 0.9755d, 0.9704d, 0.9649d, 0.9589d, 0.9524d, 0.9455d, 0.9382d, 0.9304d, 0.9222d, 0.9135d, 0.9045d, 0.8951d, 0.8853d, 0.8751d, 0.8645d, 0.8536d, 0.8423d, 0.8307d, 0.8187d, 0.8065d, 0.7939d, 0.781d, 0.7679d, 0.7545d, 0.7409d, 0.727d, 0.7129d, 0.6986d, 0.6841d, 0.6694d, 0.6545d, 0.6395d, 0.6243d, 0.6091d, 0.5937d, 0.5782d, 0.5627d, 0.5471d, 0.5314d, 0.5157d, 0.5d, 0.4843d, 0.4686d, 0.4529d, 0.4373d, 0.4218d, 0.4063d, 0.3909d, 0.3757d, 0.3605d, 0.3455d, 0.3306d, 0.3159d, 0.3014d, 0.2871d, 0.273d, 0.2591d, 0.2455d, 0.2321d, 0.219d, 0.2061d, 0.1935d, 0.1813d, 0.1693d, 0.1577d, 0.1464d, 0.1355d, 0.1249d, 0.1147d, 0.1049d, 0.0955d, 0.0865d, 0.0778d, 0.0696d, 0.0618d, 0.0545d, 0.0476d, 0.0411d, 0.0351d, 0.0296d, 0.0245d, 0.0199d, 0.0157d, 0.012d, 0.0089d, 0.0062d, 0.0039d, 0.0022d, 0.001d, 2.0E-4d};
    }

    public final float getCurTime() {
        return this.curTime;
    }

    public final void setCurTime(float f) {
        this.curTime = f;
    }

    public final Function2<Integer, Integer, Unit> getOnTimeChangedListener() {
        return this.onTimeChangedListener;
    }

    public final void setOnTimeChangedListener(Function2<? super Integer, ? super Integer, Unit> function2) {
        this.onTimeChangedListener = function2;
    }

    public final void vibrate(long milliseconds) {
        Object systemService = getContext().getSystemService("vibrator");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
        }
        ((Vibrator) systemService).vibrate(milliseconds);
    }

    private final float dpToPx(Context context, float dpValue) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (dpValue * resources.getDisplayMetrics().density) + 0.5f;
    }

    public final void setTime(int time) {
        int i = 0;
        Integer num = this.timeList.get(0);
        Intrinsics.checkExpressionValueIsNotNull(num, "timeList[0]");
        if (Intrinsics.compare(time, num.intValue()) >= 0) {
            Integer num2 = this.timeList.get(r0.size() - 1);
            Intrinsics.checkExpressionValueIsNotNull(num2, "timeList[timeList.size - 1]");
            if (Intrinsics.compare(time, num2.intValue()) <= 0) {
                this.curTime = time;
                Iterator<T> it = this.timeList.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    if (((Number) it.next()).intValue() == time) {
                        this.recentAngle = (-this.scaleAngle) * i;
                        break;
                    }
                    i++;
                }
                invalidate();
            }
        }
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        if (this.rectF == null) {
            this.rectF = new RectF(0.0f, 0.0f, (getHeight() * 113) / 221.0f, getHeight() * 1.0f);
        }
        Bitmap bitmap = this.bgBitmap;
        RectF rectF = this.rectF;
        if (rectF == null) {
            Intrinsics.throwNpe();
        }
        canvas.drawBitmap(bitmap, (Rect) null, rectF, this.bitmapPaint);
        canvas.save();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        float dpToPx = dpToPx(context, 5.0f);
        float height = getHeight() / 2.0f;
        Paint paint = this.scalePaint;
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        paint.setTextSize(dpToPx(context2, 12.0f));
        canvas.rotate(this.recentAngle, getHeight() / 2.0f, getHeight() / 2.0f);
        Iterator<T> it = this.timeList.iterator();
        int i = 0;
        while (it.hasNext()) {
            int intValue = ((Number) it.next()).intValue();
            float f = i;
            int abs = 255 - ((int) (Math.abs(this.recentAngle + (this.scaleAngle * f)) * 3.4d));
            if (abs < 0) {
                abs = 0;
            }
            this.scalePaint.setAlpha(abs);
            this.scaleTextPaint.setAlpha(abs);
            canvas.drawLine(dpToPx, height, dpToPx + this.shortScaleLen, height, this.scalePaint);
            float abs2 = Math.abs((this.recentAngle * (-1)) - (this.scaleAngle * f));
            if (abs2 > 12.0f) {
                abs2 = 12.0f;
            }
            Paint paint2 = this.scaleTextPaint;
            Context context3 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context3, "context");
            paint2.setTextSize(dpToPx(context3, abs2));
            String str = String.valueOf(intValue) + "s";
            float f2 = this.longScaleLen + dpToPx;
            Context context4 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context4, "context");
            canvas.drawText(str, f2 + dpToPx(context4, 8.0f), (this.scaleTextPaint.getTextSize() / 2) + height, this.scaleTextPaint);
            canvas.rotate(this.scaleAngle, getHeight() / 2.0f, getHeight() / 2.0f);
            i++;
        }
        canvas.restore();
        String str2 = String.valueOf((int) keepDecimals(this.curTime, 0)) + "s";
        float width = this.pointerBitmap.getWidth();
        Context context5 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context5, "context");
        canvas.drawText(str2, width + dpToPx(context5, 9.0f), (getHeight() / 2.0f) + (this.currentScalePaint.getTextSize() / 2), this.currentScalePaint);
        Bitmap bitmap2 = this.pointerBitmap;
        Context context6 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context6, "context");
        canvas.drawBitmap(bitmap2, dpToPx(context6, 3.0f), (getHeight() - this.pointerBitmap.getHeight()) / 2.0f, this.bitmapPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final int getTime() {
        return (int) keepDecimals(this.curTime, 0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateZoom() {
        float f = -1;
        float f2 = this.recentAngle * f;
        float f3 = this.scaleAngle;
        int i = (int) (f2 / f3);
        float f4 = i;
        if ((f2 - (f4 * f3)) * ((float) 2) > f3) {
            this.curTime = this.timeList.get(r3).intValue();
            this.recentAngle = this.scaleAngle * (i + 1) * f;
        } else {
            this.curTime = this.timeList.get(i).intValue();
            this.recentAngle = this.scaleAngle * f4 * f;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void calZoom() {
        this.curTime = this.timeList.get((int) keepDecimals(((-1) * this.recentAngle) / this.scaleAngle, 0)).intValue();
    }

    static /* synthetic */ float keepDecimals$default(TimerControlView timerControlView, double d, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return timerControlView.keepDecimals(d, i);
    }

    private final float keepDecimals(double v, int scale) {
        return new BigDecimal(v).setScale(scale, 4).floatValue();
    }

    public final void updateDownXY(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        this.downX = event.getX();
        this.downY = event.getY();
        this.angleCha = 0.0f;
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent event) {
        Intrinsics.checkParameterIsNotNull(event, "event");
        if ((getVisibility() == 8 || getVisibility() == 4) && event.getAction() != 1) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            DDLog.w(TAG, "onTouchEvent_DOWN recentAngle : " + this.recentAngle + " ,zoom=" + this.curTime);
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.downX = event.getX();
            this.downY = event.getY();
            this.angleCha = 0.0f;
            this.clickAngle = calcAngle(event.getX(), event.getY()) - 255;
            Function2<? super Integer, ? super Integer, Unit> function2 = this.onTimeChangedListener;
            if (function2 != null) {
                function2.invoke(Integer.valueOf(getTime()), 0);
            }
        } else if (action == 1) {
            updateZoom();
            DDLog.w(TAG, "onTouchEvent_UP recentAngle : " + this.recentAngle + " ,zoom=" + this.curTime);
            this.clickAngle = calcAngle(event.getX(), event.getY()) - 255;
            invalidate();
            if (Math.abs(this.angleCha) > 1) {
                new MyThread().start();
            } else {
                Function2<? super Integer, ? super Integer, Unit> function22 = this.onTimeChangedListener;
                if (function22 != null) {
                    function22.invoke(Integer.valueOf(getTime()), 1);
                }
            }
        } else if (action == 2) {
            this.angleCha = calcAngle(event.getX(), event.getY()) - calcAngle(this.downX, this.downY);
            this.downY = event.getY();
            this.downX = event.getX();
            float f = this.angleCha;
            if (f < -300) {
                this.angleCha = f + 360;
            } else if (f > 300) {
                this.angleCha = f - 360;
            }
            this.recentAngle += this.angleCha;
            float size = (this.timeList.size() - 1) * this.scaleAngle;
            float f2 = this.recentAngle;
            if (f2 > 0) {
                this.recentAngle = 0.0f;
            } else {
                float f3 = -size;
                if (f2 < f3) {
                    this.recentAngle = f3;
                }
            }
            calZoom();
            if (this.isNeedVibrate) {
                int size2 = this.timeList.size();
                for (int i = 0; i < size2; i++) {
                    float f4 = this.scaleAngle * i;
                    float f5 = this.recentAngle * (-1);
                    float f6 = this.lastAngle;
                    if ((f6 < f4 && f5 >= f4) || (f6 > f4 && f5 <= f4)) {
                        this.vibrateValue = f4;
                        this.isNeedVibrate = false;
                        vibrate(10L);
                        break;
                    }
                }
            }
            if (!this.isNeedVibrate && Math.abs((this.recentAngle * (-1)) - this.vibrateValue) > this.scaleAngle / 2) {
                this.isNeedVibrate = true;
            }
            this.lastAngle = this.recentAngle * (-1);
            Function2<? super Integer, ? super Integer, Unit> function23 = this.onTimeChangedListener;
            if (function23 != null) {
                function23.invoke(Integer.valueOf(getTime()), 2);
            }
            invalidate();
        }
        return true;
    }

    private final float calcAngle(float targetX, float targetY) {
        double d;
        float width = getWidth();
        Context context = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context, "context");
        float dpToPx = width + dpToPx(context, 3.0f);
        float f = targetX - dpToPx;
        float f2 = targetY - dpToPx;
        if (f != 0.0f) {
            float abs = Math.abs(f2 / f);
            float f3 = 0;
            if (f > f3) {
                if (f2 >= f3) {
                    d = Math.atan(abs);
                } else {
                    d = 6.283185307179586d - Math.atan(abs);
                }
            } else if (f2 >= f3) {
                d = 3.141592653589793d - Math.atan(abs);
            } else {
                d = Math.atan(abs) + 3.141592653589793d;
            }
        } else {
            d = f2 > ((float) 0) ? 1.5707963267948966d : -1.5707963267948966d;
        }
        return (float) ((d * 180) / 3.141592653589793d);
    }

    /* compiled from: TimerControlView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016¨\u0006\u0006"}, d2 = {"Lcom/ipotensic/kernel/view/TimerControlView$MyThread;", "Ljava/lang/Thread;", "(Lcom/ipotensic/kernel/view/TimerControlView;)V", TtmlNode.END, "", "run", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    private final class MyThread extends Thread {
        public MyThread() {
            TimerControlView.this.viewRunning = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            int i = 0;
            while (TimerControlView.this.viewRunning) {
                TimerControlView.this.recentAngle += (float) (TimerControlView.this.angleCha * TimerControlView.this.accelerateItp[i]);
                float size = (TimerControlView.this.timeList.size() - 1) * TimerControlView.this.scaleAngle;
                if (TimerControlView.this.recentAngle > 0) {
                    TimerControlView.this.recentAngle = 0.0f;
                    end();
                    return;
                }
                float f = -size;
                if (TimerControlView.this.recentAngle < f) {
                    TimerControlView.this.recentAngle = f;
                    end();
                    return;
                }
                TimerControlView.this.calZoom();
                Function2<Integer, Integer, Unit> onTimeChangedListener = TimerControlView.this.getOnTimeChangedListener();
                if (onTimeChangedListener != null) {
                    onTimeChangedListener.invoke(Integer.valueOf(TimerControlView.this.getTime()), 2);
                }
                i++;
                StringBuilder append = new StringBuilder().append("handleMessage : ").append(i).append(" viewRuning : ");
                Thread currentThread = Thread.currentThread();
                Intrinsics.checkExpressionValueIsNotNull(currentThread, "currentThread()");
                Log.w("myThread", append.append(currentThread.getName()).toString());
                if (TimerControlView.this.viewRunning) {
                    TimerControlView.this.mHandler.sendEmptyMessage(0);
                    SystemClock.sleep(10L);
                }
                if (i >= 100) {
                    end();
                }
            }
        }

        public final void end() {
            TimerControlView.this.viewRunning = false;
            TimerControlView.this.updateZoom();
            Function2<Integer, Integer, Unit> onTimeChangedListener = TimerControlView.this.getOnTimeChangedListener();
            if (onTimeChangedListener != null) {
                onTimeChangedListener.invoke(Integer.valueOf(TimerControlView.this.getTime()), 1);
            }
        }
    }
}
