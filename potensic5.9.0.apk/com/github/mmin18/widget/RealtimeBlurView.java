package com.github.mmin18.widget;

import android.app.Activity;
import android.content.Context;
import android.content.ContextWrapper;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import com.github.mmin18.realtimeblurview.C0849R;

/* loaded from: classes.dex */
public class RealtimeBlurView extends View {
    private static int BLUR_IMPL;
    private static int RENDERING_COUNT;
    private static StopException STOP_EXCEPTION = new StopException();
    private OnBlurFinishListener blurFinishListener;
    private boolean isBlurOnce;
    private boolean isBlurred;
    private Bitmap mBitmapToBlur;
    private final BlurImpl mBlurImpl;
    private float mBlurRadius;
    private Bitmap mBlurredBitmap;
    private Canvas mBlurringCanvas;
    private View mDecorView;
    private boolean mDifferentRoot;
    private boolean mDirty;
    private float mDownsampleFactor;
    private boolean mIsRendering;
    private int mOverlayColor;
    private Paint mPaint;
    private final Rect mRectDst;
    private final Rect mRectSrc;
    private final ViewTreeObserver.OnPreDrawListener preDrawListener;

    public interface OnBlurFinishListener {
        void onFinish(Bitmap bitmap);
    }

    static /* synthetic */ int access$808() {
        int i = RENDERING_COUNT;
        RENDERING_COUNT = i + 1;
        return i;
    }

    static /* synthetic */ int access$810() {
        int i = RENDERING_COUNT;
        RENDERING_COUNT = i - 1;
        return i;
    }

    public RealtimeBlurView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.mRectSrc = new Rect();
        this.mRectDst = new Rect();
        this.isBlurOnce = false;
        this.isBlurred = false;
        this.preDrawListener = new ViewTreeObserver.OnPreDrawListener() { // from class: com.github.mmin18.widget.RealtimeBlurView.1
            @Override // android.view.ViewTreeObserver.OnPreDrawListener
            public boolean onPreDraw() {
                if (RealtimeBlurView.this.isBlurOnce) {
                    if (RealtimeBlurView.this.isBlurred) {
                        return true;
                    }
                    RealtimeBlurView.this.isBlurred = true;
                }
                int[] iArr = new int[2];
                Bitmap bitmap = RealtimeBlurView.this.mBlurredBitmap;
                View view = RealtimeBlurView.this.mDecorView;
                if (view != null && RealtimeBlurView.this.isShown() && RealtimeBlurView.this.prepare()) {
                    boolean z = RealtimeBlurView.this.mBlurredBitmap != bitmap;
                    view.getLocationOnScreen(iArr);
                    int i = -iArr[0];
                    int i2 = -iArr[1];
                    RealtimeBlurView.this.getLocationOnScreen(iArr);
                    int i3 = i + iArr[0];
                    int i4 = i2 + iArr[1];
                    RealtimeBlurView.this.mBitmapToBlur.eraseColor(RealtimeBlurView.this.mOverlayColor & 16777215);
                    int save = RealtimeBlurView.this.mBlurringCanvas.save();
                    RealtimeBlurView.this.mIsRendering = true;
                    RealtimeBlurView.access$808();
                    try {
                        RealtimeBlurView.this.mBlurringCanvas.scale((RealtimeBlurView.this.mBitmapToBlur.getWidth() * 1.0f) / RealtimeBlurView.this.getWidth(), (RealtimeBlurView.this.mBitmapToBlur.getHeight() * 1.0f) / RealtimeBlurView.this.getHeight());
                        RealtimeBlurView.this.mBlurringCanvas.translate(-i3, -i4);
                        if (view.getBackground() != null) {
                            view.getBackground().draw(RealtimeBlurView.this.mBlurringCanvas);
                        }
                        view.draw(RealtimeBlurView.this.mBlurringCanvas);
                    } catch (StopException unused) {
                    } catch (Throwable th) {
                        RealtimeBlurView.this.mIsRendering = false;
                        RealtimeBlurView.access$810();
                        RealtimeBlurView.this.mBlurringCanvas.restoreToCount(save);
                        throw th;
                    }
                    RealtimeBlurView.this.mIsRendering = false;
                    RealtimeBlurView.access$810();
                    RealtimeBlurView.this.mBlurringCanvas.restoreToCount(save);
                    RealtimeBlurView realtimeBlurView = RealtimeBlurView.this;
                    realtimeBlurView.blur(realtimeBlurView.mBitmapToBlur, RealtimeBlurView.this.mBlurredBitmap);
                    if (z || RealtimeBlurView.this.mDifferentRoot) {
                        RealtimeBlurView.this.invalidate();
                    }
                }
                return true;
            }
        };
        this.mBlurImpl = getBlurImpl();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0849R.styleable.RealtimeBlurView);
        this.mBlurRadius = obtainStyledAttributes.getDimension(C0849R.styleable.RealtimeBlurView_realtimeBlurRadius, TypedValue.applyDimension(1, 10.0f, context.getResources().getDisplayMetrics()));
        this.mDownsampleFactor = obtainStyledAttributes.getFloat(C0849R.styleable.RealtimeBlurView_realtimeDownsampleFactor, 4.0f);
        this.mOverlayColor = obtainStyledAttributes.getColor(C0849R.styleable.RealtimeBlurView_realtimeOverlayColor, -1426063361);
        obtainStyledAttributes.recycle();
        this.mPaint = new Paint();
    }

    protected BlurImpl getBlurImpl() {
        if (BLUR_IMPL == 0 && Build.VERSION.SDK_INT >= 17) {
            try {
                AndroidStockBlurImpl androidStockBlurImpl = new AndroidStockBlurImpl();
                Bitmap createBitmap = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                androidStockBlurImpl.prepare(getContext(), createBitmap, 4.0f);
                androidStockBlurImpl.release();
                createBitmap.recycle();
                BLUR_IMPL = 3;
            } catch (Throwable unused) {
            }
        }
        if (BLUR_IMPL == 0) {
            try {
                getClass().getClassLoader().loadClass("androidx.renderscript.RenderScript");
                AndroidXBlurImpl androidXBlurImpl = new AndroidXBlurImpl();
                Bitmap createBitmap2 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                androidXBlurImpl.prepare(getContext(), createBitmap2, 4.0f);
                androidXBlurImpl.release();
                createBitmap2.recycle();
                BLUR_IMPL = 1;
            } catch (Throwable unused2) {
            }
        }
        if (BLUR_IMPL == 0) {
            try {
                getClass().getClassLoader().loadClass("android.support.v8.renderscript.RenderScript");
                SupportLibraryBlurImpl supportLibraryBlurImpl = new SupportLibraryBlurImpl();
                Bitmap createBitmap3 = Bitmap.createBitmap(4, 4, Bitmap.Config.ARGB_8888);
                supportLibraryBlurImpl.prepare(getContext(), createBitmap3, 4.0f);
                supportLibraryBlurImpl.release();
                createBitmap3.recycle();
                BLUR_IMPL = 2;
            } catch (Throwable unused3) {
            }
        }
        if (BLUR_IMPL == 0) {
            BLUR_IMPL = -1;
        }
        int i = BLUR_IMPL;
        if (i == 1) {
            return new AndroidXBlurImpl();
        }
        if (i == 2) {
            return new SupportLibraryBlurImpl();
        }
        if (i == 3) {
            return new AndroidStockBlurImpl();
        }
        return new EmptyBlurImpl();
    }

    public void setBlurRadius(float f) {
        if (this.mBlurRadius != f) {
            this.mBlurRadius = f;
            this.mDirty = true;
            invalidate();
        }
    }

    public void setDownsampleFactor(float f) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Downsample factor must be greater than 0.");
        }
        if (this.mDownsampleFactor != f) {
            this.mDownsampleFactor = f;
            this.mDirty = true;
            releaseBitmap();
            invalidate();
        }
    }

    public void setOverlayColor(int i) {
        if (this.mOverlayColor != i) {
            this.mOverlayColor = i;
            invalidate();
        }
    }

    private void releaseBitmap() {
        Bitmap bitmap = this.mBitmapToBlur;
        if (bitmap != null) {
            bitmap.recycle();
            this.mBitmapToBlur = null;
        }
        Bitmap bitmap2 = this.mBlurredBitmap;
        if (bitmap2 != null) {
            bitmap2.recycle();
            this.mBlurredBitmap = null;
        }
    }

    protected void release() {
        releaseBitmap();
        this.mBlurImpl.release();
    }

    protected boolean prepare() {
        Bitmap bitmap;
        float f = this.mBlurRadius;
        if (f == 0.0f) {
            release();
            return false;
        }
        float f2 = this.mDownsampleFactor;
        float f3 = f / f2;
        if (f3 > 25.0f) {
            f2 = (f2 * f3) / 25.0f;
            f3 = 25.0f;
        }
        int width = getWidth();
        int height = getHeight();
        int max = Math.max(1, (int) (width / f2));
        int max2 = Math.max(1, (int) (height / f2));
        boolean z = this.mDirty;
        if (this.mBlurringCanvas == null || (bitmap = this.mBlurredBitmap) == null || bitmap.getWidth() != max || this.mBlurredBitmap.getHeight() != max2) {
            releaseBitmap();
            try {
                Bitmap createBitmap = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                this.mBitmapToBlur = createBitmap;
                if (createBitmap != null) {
                    this.mBlurringCanvas = new Canvas(this.mBitmapToBlur);
                    Bitmap createBitmap2 = Bitmap.createBitmap(max, max2, Bitmap.Config.ARGB_8888);
                    this.mBlurredBitmap = createBitmap2;
                    if (createBitmap2 == null) {
                        release();
                        return false;
                    }
                    z = true;
                } else {
                    release();
                    return false;
                }
            } catch (OutOfMemoryError unused) {
                release();
                return false;
            } catch (Throwable unused2) {
                release();
                return false;
            }
        }
        if (z) {
            if (!this.mBlurImpl.prepare(getContext(), this.mBitmapToBlur, f3)) {
                return false;
            }
            this.mDirty = false;
        }
        return true;
    }

    protected void blur(Bitmap bitmap, Bitmap bitmap2) {
        this.mBlurImpl.blur(bitmap, bitmap2);
        OnBlurFinishListener onBlurFinishListener = this.blurFinishListener;
        if (onBlurFinishListener != null) {
            onBlurFinishListener.onFinish(bitmap2);
        }
    }

    public void setDrawOnce(boolean z) {
        this.isBlurOnce = z;
    }

    protected View getActivityDecorView() {
        Context context = getContext();
        for (int i = 0; i < 4 && context != null && !(context instanceof Activity) && (context instanceof ContextWrapper); i++) {
            context = ((ContextWrapper) context).getBaseContext();
        }
        if (context instanceof Activity) {
            return ((Activity) context).getWindow().getDecorView();
        }
        return null;
    }

    @Override // android.view.View
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        View activityDecorView = getActivityDecorView();
        this.mDecorView = activityDecorView;
        if (activityDecorView != null) {
            activityDecorView.getViewTreeObserver().addOnPreDrawListener(this.preDrawListener);
            boolean z = this.mDecorView.getRootView() != getRootView();
            this.mDifferentRoot = z;
            if (z) {
                this.mDecorView.postInvalidate();
                return;
            }
            return;
        }
        this.mDifferentRoot = false;
    }

    @Override // android.view.View
    protected void onDetachedFromWindow() {
        View view = this.mDecorView;
        if (view != null) {
            view.getViewTreeObserver().removeOnPreDrawListener(this.preDrawListener);
        }
        release();
        super.onDetachedFromWindow();
    }

    @Override // android.view.View
    public void draw(Canvas canvas) {
        if (this.mIsRendering) {
            throw STOP_EXCEPTION;
        }
        if (RENDERING_COUNT > 0) {
            return;
        }
        super.draw(canvas);
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawBlurredBitmap(canvas, this.mBlurredBitmap, this.mOverlayColor);
    }

    protected void drawBlurredBitmap(Canvas canvas, Bitmap bitmap, int i) {
        if (bitmap != null) {
            this.mRectSrc.right = bitmap.getWidth();
            this.mRectSrc.bottom = bitmap.getHeight();
            this.mRectDst.right = getWidth();
            this.mRectDst.bottom = getHeight();
            canvas.drawBitmap(bitmap, this.mRectSrc, this.mRectDst, (Paint) null);
        }
        this.mPaint.setColor(i);
        canvas.drawRect(this.mRectDst, this.mPaint);
    }

    private static class StopException extends RuntimeException {
        private StopException() {
        }
    }

    public void setBlurFinishListener(OnBlurFinishListener onBlurFinishListener) {
        this.blurFinishListener = onBlurFinishListener;
    }
}