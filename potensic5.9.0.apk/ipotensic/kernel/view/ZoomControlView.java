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
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.app.NotificationCompat;
import com.google.android.exoplayer2.source.rtsp.RtspHeaders;
import com.google.android.exoplayer2.text.ttml.TtmlNode;
import com.ipotensic.kernel.R;
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

/* compiled from: ZoomControlView.kt */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0013\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0014\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\u0003\u0018\u0000 W2\u00020\u0001:\u0002WXB%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0018\u0010:\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000fH\u0002J\b\u0010;\u001a\u00020+H\u0002J\u0018\u0010<\u001a\u00020\f2\u0006\u0010=\u001a\u00020\f2\u0006\u0010>\u001a\u00020\fH\u0002J\u0018\u0010?\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010@\u001a\u00020\fH\u0002J\u0010\u0010A\u001a\u00020\f2\u0006\u0010B\u001a\u00020\fH\u0002J\b\u0010C\u001a\u00020\fH\u0002J\u0010\u0010D\u001a\u00020\f2\u0006\u0010E\u001a\u00020\fH\u0002J\u001a\u0010F\u001a\u00020\f2\u0006\u0010G\u001a\u00020H2\b\b\u0002\u0010I\u001a\u00020\u0007H\u0002J\u0010\u0010J\u001a\u00020+2\u0006\u0010K\u001a\u00020LH\u0014J\u0010\u0010M\u001a\u00020 2\u0006\u0010N\u001a\u00020OH\u0016J\u000e\u0010P\u001a\u00020+2\u0006\u0010'\u001a\u00020\u0007J\u000e\u0010Q\u001a\u00020+2\u0006\u0010B\u001a\u00020\fJ\u000e\u0010R\u001a\u00020+2\u0006\u0010N\u001a\u00020OJ\b\u0010S\u001a\u00020+H\u0002J\u000e\u0010T\u001a\u00020+2\u0006\u0010U\u001a\u00020VR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001e\u0010\r\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001e\u0010\u0010\u001a\u0012\u0012\u0004\u0012\u00020\f0\u000ej\b\u0012\u0004\u0012\u00020\f`\u000fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0018\"\u0004\b#\u0010\u001aR\u000e\u0010$\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0007X\u0082\u000e\u00a2\u0006\u0002\n\u0000R.\u0010)\u001a\u0016\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020+\u0018\u00010*X\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b,\u0010-\"\u0004\b.\u0010/R\u000e\u00100\u001a\u00020\u0012X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0010\u00102\u001a\u0004\u0018\u000103X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020\u0014X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020\fX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u00108\u001a\u00020\fX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u00109\u001a\u00020 X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006Y"}, d2 = {"Lcom/ipotensic/kernel/view/ZoomControlView;", "Landroid/view/View;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "def", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "accelerateItp", "", "angleCha", "", "angleList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "angleListOrigin", "bgBitmap", "Landroid/graphics/Bitmap;", "bitmapPaint", "Landroid/graphics/Paint;", "clickAngle", "curZoom", "getCurZoom", "()F", "setCurZoom", "(F)V", "currentScalePaint", "currentScaleTextSize", "downX", "downY", "isNeedVibrate", "", "lastZoom", "getLastZoom", "setLastZoom", "longScaleLen", "mHandler", "Landroid/os/Handler;", "maxZoom", "minZoom", "onZoomChangedListener", "Lkotlin/Function2;", "", "getOnZoomChangedListener", "()Lkotlin/jvm/functions/Function2;", "setOnZoomChangedListener", "(Lkotlin/jvm/functions/Function2;)V", "pointerBitmap", "recentAngle", "rectF", "Landroid/graphics/RectF;", "scalePaint", "scaleTextPaint", "scaleTextSize", "shortScaleLen", "vibrateValue", "viewRunning", "calAngel", "calZoom", "calcAngle", "targetX", "targetY", "dpToPx", "dpValue", "getLen", "zoom", "getMaxAngle", "getRealZoom", "len", "keepDecimals", "v", "", RtspHeaders.SCALE, "onDraw", "canvas", "Landroid/graphics/Canvas;", "onTouchEvent", NotificationCompat.CATEGORY_EVENT, "Landroid/view/MotionEvent;", "setMaxZoom", "setZoom", "updateDownXY", "updateZoom", "vibrate", "milliseconds", "", "Companion", "MyThread", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
/* loaded from: classes2.dex */
public final class ZoomControlView extends View {
    private static final String TAG = "ZoomControlView";
    private HashMap _$_findViewCache;
    private final double[] accelerateItp;
    private float angleCha;
    private final ArrayList<Float> angleList;
    private final ArrayList<Float> angleListOrigin;
    private Bitmap bgBitmap;
    private final Paint bitmapPaint;
    private float clickAngle;
    private float curZoom;
    private final Paint currentScalePaint;
    private final float currentScaleTextSize;
    private float downX;
    private float downY;
    private boolean isNeedVibrate;
    private float lastZoom;
    private final float longScaleLen;
    private final Handler mHandler;
    private int maxZoom;
    private int minZoom;
    private Function2<? super Float, ? super Integer, Unit> onZoomChangedListener;
    private Bitmap pointerBitmap;
    private float recentAngle;
    private RectF rectF;
    private final Paint scalePaint;
    private final Paint scaleTextPaint;
    private final float scaleTextSize;
    private final float shortScaleLen;
    private float vibrateValue;
    private boolean viewRunning;

    public ZoomControlView(Context context) {
        this(context, null, 0, 6, null);
    }

    public ZoomControlView(Context context, AttributeSet attributeSet) {
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

    public /* synthetic */ ZoomControlView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? (AttributeSet) null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ZoomControlView(Context context, AttributeSet attributeSet, int i) {
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
        this.shortScaleLen = dpToPx(context, 5.0f);
        this.longScaleLen = dpToPx(context, 10.0f);
        float dpToPx = dpToPx(context, 12.0f);
        this.scaleTextSize = dpToPx;
        float dpToPx2 = dpToPx(context, 18.0f);
        this.currentScaleTextSize = dpToPx2;
        this.maxZoom = 4;
        this.minZoom = 1;
        this.curZoom = 1.0f;
        this.lastZoom = 1.0f;
        this.isNeedVibrate = true;
        this.angleList = new ArrayList<>();
        this.angleListOrigin = new ArrayList<>();
        Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), R.mipmap.zoom_circle_bg);
        Intrinsics.checkExpressionValueIsNotNull(decodeResource, "BitmapFactory.decodeReso\u2026 R.mipmap.zoom_circle_bg)");
        this.bgBitmap = decodeResource;
        Bitmap decodeResource2 = BitmapFactory.decodeResource(getResources(), R.mipmap.zoom_pointer);
        Intrinsics.checkExpressionValueIsNotNull(decodeResource2, "BitmapFactory.decodeReso\u2026s, R.mipmap.zoom_pointer)");
        this.pointerBitmap = decodeResource2;
        final Looper mainLooper = Looper.getMainLooper();
        this.mHandler = new Handler(mainLooper) { // from class: com.ipotensic.kernel.view.ZoomControlView$mHandler$1
            @Override // android.os.Handler
            public void handleMessage(Message msg) {
                Intrinsics.checkParameterIsNotNull(msg, "msg");
                if (msg.what == 0) {
                    ZoomControlView.this.invalidate();
                } else if (msg.what == 1) {
                    ZoomControlView.this.invalidate();
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
        calAngel();
        this.accelerateItp = new double[]{1.0d, 0.9998d, 0.999d, 0.9978d, 0.9961d, 0.9938d, 0.9911d, 0.988d, 0.9843d, 0.9801d, 0.9755d, 0.9704d, 0.9649d, 0.9589d, 0.9524d, 0.9455d, 0.9382d, 0.9304d, 0.9222d, 0.9135d, 0.9045d, 0.8951d, 0.8853d, 0.8751d, 0.8645d, 0.8536d, 0.8423d, 0.8307d, 0.8187d, 0.8065d, 0.7939d, 0.781d, 0.7679d, 0.7545d, 0.7409d, 0.727d, 0.7129d, 0.6986d, 0.6841d, 0.6694d, 0.6545d, 0.6395d, 0.6243d, 0.6091d, 0.5937d, 0.5782d, 0.5627d, 0.5471d, 0.5314d, 0.5157d, 0.5d, 0.4843d, 0.4686d, 0.4529d, 0.4373d, 0.4218d, 0.4063d, 0.3909d, 0.3757d, 0.3605d, 0.3455d, 0.3306d, 0.3159d, 0.3014d, 0.2871d, 0.273d, 0.2591d, 0.2455d, 0.2321d, 0.219d, 0.2061d, 0.1935d, 0.1813d, 0.1693d, 0.1577d, 0.1464d, 0.1355d, 0.1249d, 0.1147d, 0.1049d, 0.0955d, 0.0865d, 0.0778d, 0.0696d, 0.0618d, 0.0545d, 0.0476d, 0.0411d, 0.0351d, 0.0296d, 0.0245d, 0.0199d, 0.0157d, 0.012d, 0.0089d, 0.0062d, 0.0039d, 0.0022d, 0.001d, 2.0E-4d};
    }

    public final float getCurZoom() {
        return this.curZoom;
    }

    public final void setCurZoom(float f) {
        this.curZoom = f;
    }

    public final float getLastZoom() {
        return this.lastZoom;
    }

    public final void setLastZoom(float f) {
        this.lastZoom = f;
    }

    public final Function2<Float, Integer, Unit> getOnZoomChangedListener() {
        return this.onZoomChangedListener;
    }

    public final void setOnZoomChangedListener(Function2<? super Float, ? super Integer, Unit> function2) {
        this.onZoomChangedListener = function2;
    }

    private final float dpToPx(Context context, float dpValue) {
        Resources resources = context.getResources();
        Intrinsics.checkExpressionValueIsNotNull(resources, "context.resources");
        return (dpValue * resources.getDisplayMetrics().density) + 0.5f;
    }

    public final void vibrate(long milliseconds) {
        Object systemService = getContext().getSystemService("vibrator");
        if (systemService == null) {
            throw new TypeCastException("null cannot be cast to non-null type android.os.Vibrator");
        }
        ((Vibrator) systemService).vibrate(milliseconds);
    }

    public final void setZoom(float zoom) {
        if (zoom < this.minZoom || zoom > this.maxZoom) {
            return;
        }
        this.curZoom = zoom;
        this.recentAngle = -this.angleList.get((int) keepDecimals((zoom - r0) * 10, 0)).floatValue();
        invalidate();
    }

    public final void setMaxZoom(int maxZoom) {
        if (maxZoom > 1) {
            this.maxZoom = maxZoom;
            calAngel();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0267  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0299  */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void onDraw(Canvas canvas) {
        String str;
        boolean z;
        char c;
        int i;
        Intrinsics.checkParameterIsNotNull(canvas, "canvas");
        super.onDraw(canvas);
        boolean z2 = false;
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
        float f = 2.0f;
        float height = getHeight() / 2.0f;
        Paint paint = this.scalePaint;
        Context context2 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context2, "context");
        paint.setTextSize(dpToPx(context2, 12.0f));
        canvas.rotate(this.recentAngle, getHeight() / 2.0f, getHeight() / 2.0f);
        Iterator<T> it = this.angleListOrigin.iterator();
        int i2 = 0;
        while (it.hasNext()) {
            canvas.rotate(((Number) it.next()).floatValue(), getHeight() / f, getHeight() / f);
            float f2 = this.recentAngle;
            Intrinsics.checkExpressionValueIsNotNull(this.angleList.get(i2), "angleList[index]");
            int abs = 255 - ((int) (Math.abs(f2 + r2.floatValue()) * 3.4d));
            if (abs < 0) {
                abs = 0;
            }
            this.scalePaint.setAlpha(abs);
            this.scaleTextPaint.setAlpha(abs);
            if (i2 % 10 == 0) {
                i = i2;
                canvas.drawLine(dpToPx, height, dpToPx + this.longScaleLen, height, this.scalePaint);
                int i3 = (i / 10) + 1;
                String str2 = "" + i3 + "x";
                String str3 = ((int) Math.ceil(i3 * 26.7d)) + "mm";
                float f3 = this.recentAngle * (-1);
                Float f4 = this.angleList.get(i);
                Intrinsics.checkExpressionValueIsNotNull(f4, "angleList[index]");
                float abs2 = Math.abs(f3 - f4.floatValue());
                if (abs2 > 12.0f) {
                    abs2 = 12.0f;
                }
                Paint paint2 = this.scaleTextPaint;
                Context context3 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context3, "context");
                paint2.setTextSize(dpToPx(context3, abs2));
                float f5 = this.longScaleLen + dpToPx;
                Context context4 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context4, "context");
                canvas.drawText(str2, f5 + dpToPx(context4, 8.0f), height, this.scaleTextPaint);
                float textSize = this.scaleTextPaint.getTextSize();
                Context context5 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context5, "context");
                if (textSize > dpToPx(context5, 2.0f)) {
                    Paint paint3 = this.scaleTextPaint;
                    float textSize2 = paint3.getTextSize();
                    Context context6 = getContext();
                    Intrinsics.checkExpressionValueIsNotNull(context6, "context");
                    paint3.setTextSize(textSize2 - dpToPx(context6, 2.0f));
                    z = false;
                } else {
                    z = false;
                    this.scaleTextPaint.setTextSize(0.0f);
                }
                float f6 = this.longScaleLen + dpToPx;
                Context context7 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context7, "context");
                c = 0;
                canvas.drawText(str3, f6 + dpToPx(context7, 1.0f), this.scaleTextPaint.getTextSize() + height, this.scaleTextPaint);
            } else {
                z = z2;
                c = 0;
                i = i2;
                canvas.drawLine(dpToPx, height, dpToPx + this.shortScaleLen, height, this.scalePaint);
            }
            i2 = i + 1;
            z2 = z;
            f = 2.0f;
        }
        canvas.restore();
        float keepDecimals = keepDecimals(this.curZoom, 1);
        String str4 = String.valueOf(keepDecimals) + "x";
        int i4 = this.minZoom;
        int i5 = this.maxZoom;
        if (i4 <= i5) {
            while (keepDecimals != i4) {
                if (i4 != i5) {
                    i4++;
                }
            }
            str4 = String.valueOf(i4) + "x";
            str = ((int) Math.ceil(i4 * 26.7d)) + "mm";
            Paint paint4 = this.currentScalePaint;
            Context context8 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context8, "context");
            paint4.setTextSize(dpToPx(context8, 18.0f));
            if (!TextUtils.isEmpty(str)) {
                float width = this.pointerBitmap.getWidth();
                Context context9 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context9, "context");
                Context context10 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context10, "context");
                canvas.drawText(str4, width + dpToPx(context9, 6.0f), (getHeight() / 2.0f) + (dpToPx(context10, 10.0f) / 2), this.currentScalePaint);
            } else {
                float width2 = this.pointerBitmap.getWidth();
                Context context11 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context11, "context");
                canvas.drawText(str4, width2 + dpToPx(context11, 9.0f), getHeight() / 2.0f, this.currentScalePaint);
                Paint paint5 = this.currentScalePaint;
                Context context12 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context12, "context");
                paint5.setTextSize(dpToPx(context12, 12.0f));
                float width3 = this.pointerBitmap.getWidth();
                Context context13 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context13, "context");
                Context context14 = getContext();
                Intrinsics.checkExpressionValueIsNotNull(context14, "context");
                canvas.drawText(str, width3 + dpToPx(context13, 3.0f), (getHeight() / 2.0f) + dpToPx(context14, 10.0f), this.currentScalePaint);
            }
            Bitmap bitmap2 = this.pointerBitmap;
            Context context15 = getContext();
            Intrinsics.checkExpressionValueIsNotNull(context15, "context");
            canvas.drawBitmap(bitmap2, dpToPx(context15, 3.0f), (getHeight() - this.pointerBitmap.getHeight()) / 2.0f, this.bitmapPaint);
        }
        str = "";
        Paint paint42 = this.currentScalePaint;
        Context context82 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context82, "context");
        paint42.setTextSize(dpToPx(context82, 18.0f));
        if (!TextUtils.isEmpty(str)) {
        }
        Bitmap bitmap22 = this.pointerBitmap;
        Context context152 = getContext();
        Intrinsics.checkExpressionValueIsNotNull(context152, "context");
        canvas.drawBitmap(bitmap22, dpToPx(context152, 3.0f), (getHeight() - this.pointerBitmap.getHeight()) / 2.0f, this.bitmapPaint);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateZoom() {
        Iterator<T> it = this.angleList.iterator();
        int i = 0;
        while (it.hasNext()) {
            float floatValue = ((Number) it.next()).floatValue();
            float f = -1;
            float f2 = this.recentAngle * f;
            if (f2 == floatValue) {
                this.curZoom = this.minZoom + (i * 0.1f);
                return;
            }
            if (f2 < floatValue) {
                int i2 = i - 1;
                Float f3 = this.angleList.get(i2);
                Intrinsics.checkExpressionValueIsNotNull(f3, "angleList[index - 1]");
                if (f3.floatValue() + floatValue > 2 * f2) {
                    this.curZoom = this.minZoom + (i2 * 0.1f);
                    this.recentAngle = this.angleList.get(i2).floatValue() * f;
                    return;
                } else {
                    this.curZoom = this.minZoom + (i * 0.1f);
                    this.recentAngle = floatValue * f;
                    return;
                }
            }
            i++;
        }
    }

    private final ArrayList<Float> calAngel() {
        this.angleList.clear();
        this.angleListOrigin.clear();
        float len = getLen(this.maxZoom) - getLen(this.minZoom);
        int i = (this.maxZoom - this.minZoom) * 10;
        if (i >= 0) {
            int i2 = 0;
            float f = 0.0f;
            while (true) {
                if (i2 == 0) {
                    this.angleList.add(Float.valueOf(0.0f));
                    this.angleListOrigin.add(Float.valueOf(0.0f));
                } else {
                    float len2 = (getLen(this.minZoom + (i2 * 0.1f)) - getLen(this.minZoom + ((i2 - 1) * 0.1f))) / len;
                    f += getMaxAngle() * len2;
                    this.angleList.add(Float.valueOf(f));
                    this.angleListOrigin.add(Float.valueOf(len2 * getMaxAngle()));
                }
                Log.d(TAG, "zoom=" + (this.minZoom + (i2 * 0.1f)) + ",angle=" + f);
                if (i2 == i) {
                    break;
                }
                i2++;
            }
        }
        return this.angleList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getMaxAngle() {
        return (getLen(this.minZoom) - getLen(this.maxZoom)) * 108.2677f;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void calZoom() {
        float len = getLen(this.minZoom);
        this.curZoom = getRealZoom(((((-1) * this.recentAngle) * (getLen(this.maxZoom) - len)) / getMaxAngle()) + len);
    }

    private final float getLen(float zoom) {
        return 2 * ((float) Math.atan(43.2666d / (zoom * 26.7d)));
    }

    private final float getRealZoom(float len) {
        return keepDecimals$default(this, (43.2666f / ((float) Math.tan(len / 2))) / 26.7d, 0, 2, null);
    }

    static /* synthetic */ float keepDecimals$default(ZoomControlView zoomControlView, double d, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 2;
        }
        return zoomControlView.keepDecimals(d, i);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float keepDecimals(double v, int scale) {
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
        int i;
        int i2;
        Intrinsics.checkParameterIsNotNull(event, "event");
        if (getVisibility() == 8 || getVisibility() == 4) {
            return false;
        }
        int action = event.getAction();
        if (action == 0) {
            this.mHandler.removeMessages(1);
            this.mHandler.removeMessages(0);
            this.downX = event.getX();
            this.downY = event.getY();
            this.angleCha = 0.0f;
            this.clickAngle = calcAngle(event.getX(), event.getY()) - 255;
            Function2<? super Float, ? super Integer, Unit> function2 = this.onZoomChangedListener;
            if (function2 != null) {
                function2.invoke(Float.valueOf(this.curZoom), 0);
            }
        } else if (action == 1) {
            this.isNeedVibrate = true;
            updateZoom();
            Log.w(TAG, "onTouchEvent_UP recentAngle : " + this.recentAngle + " ,zoom=" + this.curZoom);
            this.clickAngle = calcAngle(event.getX(), event.getY()) - 255;
            invalidate();
            if (Math.abs(this.angleCha) > 1) {
                new MyThread().start();
            } else {
                Function2<? super Float, ? super Integer, Unit> function22 = this.onZoomChangedListener;
                if (function22 != null) {
                    function22.invoke(Float.valueOf(keepDecimals(this.curZoom, 1)), 1);
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
            float maxAngle = getMaxAngle();
            float f2 = this.recentAngle;
            if (f2 > 0) {
                this.recentAngle = 0.0f;
            } else {
                float f3 = -maxAngle;
                if (f2 < f3) {
                    this.recentAngle = f3;
                }
            }
            calZoom();
            if (this.isNeedVibrate && (i = this.minZoom) <= (i2 = this.maxZoom)) {
                while (true) {
                    float f4 = this.lastZoom;
                    float f5 = i;
                    if ((f4 >= f5 || this.curZoom < f5) && (f4 <= f5 || this.curZoom > f5)) {
                        if (i == i2) {
                            break;
                        }
                        i++;
                    }
                }
                this.isNeedVibrate = false;
                this.vibrateValue = this.curZoom;
                vibrate(10L);
            }
            if (!this.isNeedVibrate && Math.abs(this.curZoom - this.vibrateValue) > 0.1d) {
                this.isNeedVibrate = true;
            }
            float f6 = this.curZoom;
            this.lastZoom = f6;
            Function2<? super Float, ? super Integer, Unit> function23 = this.onZoomChangedListener;
            if (function23 != null) {
                function23.invoke(Float.valueOf(f6), 2);
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

    /* compiled from: ZoomControlView.kt */
    @Metadata(bv = {1, 0, 3}, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\b\u0010\u0005\u001a\u00020\u0004H\u0016\u00a8\u0006\u0006"}, d2 = {"Lcom/ipotensic/kernel/view/ZoomControlView$MyThread;", "Ljava/lang/Thread;", "(Lcom/ipotensic/kernel/view/ZoomControlView;)V", TtmlNode.END, "", "run", "Kernel_mapboxRelease"}, k = 1, mv = {1, 1, 15})
    private final class MyThread extends Thread {
        public MyThread() {
            ZoomControlView.this.viewRunning = true;
        }

        @Override // java.lang.Thread, java.lang.Runnable
        public void run() {
            super.run();
            int i = 0;
            while (ZoomControlView.this.viewRunning) {
                ZoomControlView.this.recentAngle += (float) (ZoomControlView.this.angleCha * ZoomControlView.this.accelerateItp[i]);
                float maxAngle = ZoomControlView.this.getMaxAngle();
                if (ZoomControlView.this.recentAngle > 0) {
                    ZoomControlView.this.recentAngle = 0.0f;
                    end();
                    return;
                }
                float f = -maxAngle;
                if (ZoomControlView.this.recentAngle < f) {
                    ZoomControlView.this.recentAngle = f;
                    end();
                    return;
                }
                ZoomControlView.this.calZoom();
                Function2<Float, Integer, Unit> onZoomChangedListener = ZoomControlView.this.getOnZoomChangedListener();
                if (onZoomChangedListener != null) {
                    onZoomChangedListener.invoke(Float.valueOf(ZoomControlView.this.getCurZoom()), 2);
                }
                i++;
                if (ZoomControlView.this.viewRunning) {
                    ZoomControlView.this.mHandler.sendEmptyMessage(0);
                    SystemClock.sleep(10L);
                }
                if (i >= 100) {
                    end();
                }
            }
        }

        public final void end() {
            ZoomControlView.this.viewRunning = false;
            ZoomControlView.this.updateZoom();
            Function2<Float, Integer, Unit> onZoomChangedListener = ZoomControlView.this.getOnZoomChangedListener();
            if (onZoomChangedListener != null) {
                onZoomChangedListener.invoke(Float.valueOf(ZoomControlView.this.keepDecimals(r1.getCurZoom(), 1)), 1);
            }
        }
    }
}