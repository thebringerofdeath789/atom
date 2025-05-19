package com.ipotensic.baselib.cropbitmap;

import android.R;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.TypedValue;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.ScaleGestureDetector;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import androidx.core.content.ContextCompat;
import java.io.FileDescriptor;
import java.io.InputStream;

/* loaded from: classes2.dex */
public class LikeQQCropView extends View {
    private int bgColor;
    private Paint bgPaint;
    private Path bigCirclePath;
    private RectF bigCircleRectF;
    private int borderColor;
    private boolean canMoveBitmap;
    private boolean canZoomCircle;
    private float centerX;
    private float centerY;
    private Paint circleBorderPaint;
    private Path circleBorderPath;
    private Path circlePath;
    private RectF circleRectF;
    private Matrix circleRectFMatrix;
    protected float doubleClickScale;
    protected float doubleClickX;
    protected float doubleClickY;
    private GestureDetector gestureDetector;
    private RectF initCircleRectF;
    private float initScale;
    private float initTranslateX;
    private float initTranslateY;
    private int maskColor;
    private float maxScale;
    private float minCircleScale;
    private Path outsidePath;
    private Paint paint;
    private float radius;
    private ScaleGestureDetector scaleGestureDetector;
    private Bitmap showBitmap;
    private Matrix showBitmapMatrix;
    private Paint showBitmapPaint;
    private RectF showBitmapRectF;
    private boolean sizeChanged;
    private int touchArea;
    private int touchLength;
    private Region touchRegion;
    private ValueAnimator valueAnimator;

    public float getRadius() {
        return this.radius;
    }

    public float getClipWidth() {
        return getRectLength(this.circleRectF);
    }

    public LikeQQCropView setRadius(float f) {
        this.radius = f;
        post(new Runnable() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.1
            @Override // java.lang.Runnable
            public void run() {
                LikeQQCropView.this.refreshPath();
                LikeQQCropView.this.invalidate();
            }
        });
        return this;
    }

    public int getMaskColor() {
        return this.maskColor;
    }

    public LikeQQCropView setMaskColor(int i) {
        this.maskColor = i;
        if (this.sizeChanged) {
            refreshPaint();
            invalidate();
        }
        return this;
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public LikeQQCropView setBgColor(int i) {
        this.bgColor = i;
        return this;
    }

    public int getBorderColor() {
        return this.borderColor;
    }

    public LikeQQCropView setBorderColor(int i) {
        this.borderColor = i;
        if (this.sizeChanged) {
            refreshPaint();
            invalidate();
        }
        return this;
    }

    public float getMaxScale() {
        return this.maxScale;
    }

    public LikeQQCropView setMaxScale(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        if (this.doubleClickScale > f) {
            this.doubleClickScale = f;
        }
        this.maxScale = f;
        return this;
    }

    public float getDoubleClickScale() {
        return this.doubleClickScale;
    }

    public LikeQQCropView setDoubleClickScale(float f) {
        if (f < 1.0f) {
            f = 1.0f;
        }
        float f2 = this.maxScale;
        if (f > f2) {
            f = f2;
        }
        this.doubleClickScale = f;
        return this;
    }

    public LikeQQCropView(Context context) {
        super(context);
        this.maxScale = 3.0f;
        this.doubleClickScale = 1.8f;
        this.minCircleScale = 1.0f;
        this.initScale = 1.0f;
        this.touchLength = 10;
        this.radius = -1.0f;
        this.bgColor = -1;
        initGesture();
        initAttr(null);
    }

    public LikeQQCropView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.maxScale = 3.0f;
        this.doubleClickScale = 1.8f;
        this.minCircleScale = 1.0f;
        this.initScale = 1.0f;
        this.touchLength = 10;
        this.radius = -1.0f;
        this.bgColor = -1;
        initGesture();
        initAttr(attributeSet);
    }

    public LikeQQCropView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.maxScale = 3.0f;
        this.doubleClickScale = 1.8f;
        this.minCircleScale = 1.0f;
        this.initScale = 1.0f;
        this.touchLength = 10;
        this.radius = -1.0f;
        this.bgColor = -1;
        initGesture();
        initAttr(attributeSet);
    }

    private void initAttr(AttributeSet attributeSet) {
        this.maskColor = Color.parseColor("#60000000");
        this.borderColor = ContextCompat.getColor(getContext(), R.color.white);
        if (attributeSet == null) {
            return;
        }
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, com.ipotensic.baselib.R.styleable.LikeQQCropView);
        this.maskColor = obtainStyledAttributes.getColor(com.ipotensic.baselib.R.styleable.LikeQQCropView_maskColor, Color.parseColor("#60000000"));
        this.bgColor = obtainStyledAttributes.getColor(com.ipotensic.baselib.R.styleable.LikeQQCropView_bgColor, -1);
        this.borderColor = obtainStyledAttributes.getColor(com.ipotensic.baselib.R.styleable.LikeQQCropView_borderColor, ContextCompat.getColor(getContext(), R.color.white));
        this.radius = obtainStyledAttributes.getDimension(com.ipotensic.baselib.R.styleable.LikeQQCropView_radius, -1.0f);
        this.maxScale = obtainStyledAttributes.getFloat(com.ipotensic.baselib.R.styleable.LikeQQCropView_maxScale, 3.0f);
        float f = obtainStyledAttributes.getFloat(com.ipotensic.baselib.R.styleable.LikeQQCropView_doubleClickScale, 1.8f);
        this.doubleClickScale = f;
        if (this.maxScale < 1.0f) {
            this.maxScale = 1.0f;
        }
        if (f < 1.0f) {
            this.doubleClickScale = 1.0f;
        }
        float f2 = this.doubleClickScale;
        float f3 = this.maxScale;
        if (f2 > f3) {
            this.doubleClickScale = f3;
        }
        obtainStyledAttributes.recycle();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        int size = View.MeasureSpec.getSize(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int screenWidth = getScreenWidth() / 2;
        int screenWidth2 = getScreenWidth() / 2;
        if (-2 == getLayoutParams().width && -2 == getLayoutParams().height) {
            setMeasuredDimension(screenWidth, screenWidth2);
            return;
        }
        if (-2 == getLayoutParams().width) {
            setMeasuredDimension(screenWidth, size2);
        } else if (-2 == getLayoutParams().height) {
            setMeasuredDimension(size, screenWidth2);
        } else {
            super.onMeasure(i, i2);
        }
    }

    private int getScreenWidth() {
        return getContext().getResources().getDisplayMetrics().widthPixels;
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.touchRegion = new Region();
        Paint paint = new Paint(1);
        this.paint = paint;
        paint.setStyle(Paint.Style.STROKE);
        this.paint.setStrokeWidth(2.0f);
        Paint paint2 = new Paint(1);
        this.circleBorderPaint = paint2;
        paint2.setColor(this.borderColor);
        this.circleBorderPaint.setStyle(Paint.Style.STROKE);
        this.circleBorderPaint.setStrokeWidth(dip2px(getContext(), 1.0f));
        Paint paint3 = new Paint(1);
        this.bgPaint = paint3;
        paint3.setColor(this.maskColor);
        Paint paint4 = new Paint(1);
        this.showBitmapPaint = paint4;
        paint4.setStyle(Paint.Style.STROKE);
        this.showBitmapPaint.setStrokeWidth(2.0f);
        init();
        this.sizeChanged = true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void init() {
        this.centerX = getWidth() / 2;
        this.centerY = getHeight() / 2;
        this.circleBorderPath = new Path();
        this.circlePath = new Path();
        this.outsidePath = new Path();
        this.bigCirclePath = new Path();
        Bitmap bitmap = this.showBitmap;
        if (bitmap == null) {
            return;
        }
        if (bitmap.getHeight() < getHeight() && this.showBitmap.getWidth() < getWidth()) {
            this.initScale = 1.0f;
            this.initTranslateX = (getWidth() - this.showBitmap.getWidth()) / 2;
            this.initTranslateY = (getHeight() - this.showBitmap.getHeight()) / 2;
        } else if ((this.showBitmap.getWidth() * 1.0f) / this.showBitmap.getHeight() > (getWidth() * 1.0f) / getHeight()) {
            this.initScale = (getWidth() * 1.0f) / this.showBitmap.getWidth();
            this.initTranslateX = 0.0f;
            this.initTranslateY = (getHeight() - (this.showBitmap.getHeight() * this.initScale)) / 2.0f;
        } else {
            this.initScale = (getHeight() * 1.0f) / this.showBitmap.getHeight();
            this.initTranslateX = (getWidth() - (this.showBitmap.getWidth() * this.initScale)) / 2.0f;
            this.initTranslateY = 0.0f;
        }
        this.circleRectFMatrix = new Matrix();
        this.showBitmapRectF = new RectF(0.0f, 0.0f, this.showBitmap.getWidth(), this.showBitmap.getHeight());
        Matrix matrix = new Matrix();
        this.showBitmapMatrix = matrix;
        float f = this.initScale;
        matrix.postScale(f, f);
        this.showBitmapMatrix.postTranslate(this.initTranslateX, this.initTranslateY);
        this.showBitmapMatrix.mapRect(this.showBitmapRectF);
        RectF circleRectFByBitmapRectF = getCircleRectFByBitmapRectF(this.showBitmapRectF);
        this.circleRectF = circleRectFByBitmapRectF;
        this.initCircleRectF = circleRectFByBitmapRectF;
        refreshPath();
    }

    private void refreshPaint() {
        this.circleBorderPaint.setColor(this.borderColor);
        this.bgPaint.setColor(this.maskColor);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void refreshPath() {
        if (!this.outsidePath.isEmpty()) {
            this.outsidePath.reset();
        }
        this.outsidePath.addRect(new RectF(0.0f, 0.0f, getWidth(), getHeight()), Path.Direction.CW);
        if (!this.circlePath.isEmpty()) {
            this.circlePath.reset();
        }
        if (this.radius > getRectLength(this.circleRectF) / 2.0f || this.radius < 0.0f) {
            this.radius = getRectLength(this.circleRectF) / 2.0f;
        }
        Path path = this.circlePath;
        RectF rectF = this.circleRectF;
        float f = this.radius;
        path.addRoundRect(rectF, f, f, Path.Direction.CW);
        if (!this.circleBorderPath.isEmpty()) {
            this.circleBorderPath.reset();
        }
        RectF rectF2 = new RectF(this.circleRectF.left + getPathInterval(), this.circleRectF.top + getPathInterval(), this.circleRectF.right - getPathInterval(), this.circleRectF.bottom - getPathInterval());
        this.circleBorderPath.addRoundRect(rectF2, (this.radius * getRectLength(rectF2)) / getRectLength(this.circleRectF), (this.radius * getRectLength(rectF2)) / getRectLength(this.circleRectF), Path.Direction.CW);
        this.outsidePath.op(this.circlePath, Path.Op.XOR);
        this.bigCircleRectF = getBigCircleRectF(this.circleRectF);
        if (!this.bigCirclePath.isEmpty()) {
            this.bigCirclePath.reset();
        }
        Path path2 = this.bigCirclePath;
        RectF rectF3 = this.bigCircleRectF;
        path2.addRoundRect(rectF3, (rectF3.right - this.bigCircleRectF.left) / 2.0f, (this.bigCircleRectF.right - this.bigCircleRectF.left) / 2.0f, Path.Direction.CW);
        this.bigCirclePath.op(this.circlePath, Path.Op.XOR);
    }

    public Bitmap clip() {
        if (!this.sizeChanged) {
            return null;
        }
        Paint paint = new Paint(1);
        Matrix matrix = new Matrix();
        this.showBitmapMatrix.invert(matrix);
        RectF rectF = new RectF();
        rectF.set(this.circleRectF);
        matrix.mapRect(rectF);
        Bitmap createBitmap = Bitmap.createBitmap(this.showBitmap, (int) rectF.left, (int) rectF.top, (int) (rectF.right - rectF.left), (int) (rectF.bottom - rectF.top));
        Bitmap createBitmap2 = Bitmap.createBitmap((int) getRectLength(this.circleRectF), (int) getRectLength(this.circleRectF), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap2);
        canvas.drawColor(this.bgColor);
        int saveLayer = canvas.saveLayer(null, null, 31);
        Path path = new Path();
        RectF rectF2 = new RectF(0.0f, 0.0f, getRectLength(this.circleRectF), getRectLength(this.circleRectF));
        float f = this.radius;
        path.addRoundRect(rectF2, f, f, Path.Direction.CW);
        path.moveTo(0.0f, 0.0f);
        path.moveTo(getRectLength(this.circleRectF), getRectLength(this.circleRectF));
        canvas.drawPath(path, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(createBitmap, new Rect(0, 0, createBitmap.getWidth(), createBitmap.getHeight()), new RectF(0.0f, 0.0f, getRectLength(this.circleRectF), getRectLength(this.circleRectF)), paint);
        paint.setXfermode(null);
        canvas.restoreToCount(saveLayer);
        float[] fArr = new float[9];
        this.showBitmapMatrix.getValues(fArr);
        if (fArr[0] < 0.0f && fArr[4] < 0.0f) {
            createBitmap2 = getFlipBitmap(createBitmap2, -1, -1);
        } else if (fArr[0] < 0.0f) {
            createBitmap2 = getFlipBitmap(createBitmap2, -1, 1);
        } else if (fArr[4] < 0.0f) {
            createBitmap2 = getFlipBitmap(createBitmap2, 1, -1);
        }
        createBitmap.recycle();
        return createBitmap2;
    }

    private Bitmap getFlipBitmap(Bitmap bitmap, int i, int i2) {
        Matrix matrix = new Matrix();
        matrix.postScale(i, i2, bitmap.getWidth() / 2, bitmap.getWidth() / 2);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }

    public void horizontalFlip() {
        post(new Runnable() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.2
            @Override // java.lang.Runnable
            public void run() {
                LikeQQCropView.this.showBitmapMatrix.postScale(-1.0f, 1.0f, LikeQQCropView.this.centerX, LikeQQCropView.this.centerY);
                LikeQQCropView.this.showBitmapRectF = new RectF(0.0f, 0.0f, LikeQQCropView.this.showBitmap.getWidth(), LikeQQCropView.this.showBitmap.getHeight());
                LikeQQCropView.this.showBitmapMatrix.mapRect(LikeQQCropView.this.showBitmapRectF);
                LikeQQCropView.this.invalidate();
            }
        });
    }

    public void verticalFlip() {
        post(new Runnable() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.3
            @Override // java.lang.Runnable
            public void run() {
                LikeQQCropView.this.showBitmapMatrix.postScale(1.0f, -1.0f, LikeQQCropView.this.centerX, LikeQQCropView.this.centerY);
                LikeQQCropView.this.showBitmapRectF = new RectF(0.0f, 0.0f, LikeQQCropView.this.showBitmap.getWidth(), LikeQQCropView.this.showBitmap.getHeight());
                LikeQQCropView.this.showBitmapMatrix.mapRect(LikeQQCropView.this.showBitmapRectF);
                LikeQQCropView.this.invalidate();
            }
        });
    }

    public void verticalAndHorizontalFlip() {
        post(new Runnable() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.4
            @Override // java.lang.Runnable
            public void run() {
                LikeQQCropView.this.showBitmapMatrix.postScale(-1.0f, -1.0f, LikeQQCropView.this.centerX, LikeQQCropView.this.centerY);
                LikeQQCropView.this.showBitmapRectF = new RectF(0.0f, 0.0f, LikeQQCropView.this.showBitmap.getWidth(), LikeQQCropView.this.showBitmap.getHeight());
                LikeQQCropView.this.showBitmapMatrix.mapRect(LikeQQCropView.this.showBitmapRectF);
                LikeQQCropView.this.invalidate();
            }
        });
    }

    public void reset() {
        if (this.sizeChanged) {
            init();
            invalidate();
        } else {
            post(new Runnable() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.5
                @Override // java.lang.Runnable
                public void run() {
                    LikeQQCropView.this.init();
                    LikeQQCropView.this.invalidate();
                }
            });
        }
    }

    private float getPathInterval() {
        return dip2px(getContext(), 0.5f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getCircleRectFByBitmapRectF(RectF rectF) {
        float f = rectF.right - rectF.left;
        float f2 = rectF.bottom - rectF.top;
        if (f > f2) {
            f = f2;
        }
        float f3 = f / 2.0f;
        float f4 = this.centerX - f3;
        float f5 = this.centerY - f3;
        return new RectF(f4, f5, f + f4, f + f5);
    }

    private float getRectLength(RectF rectF) {
        return Math.abs(rectF.right - rectF.left);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public RectF getBigCircleRectF(RectF rectF) {
        RectF rectF2 = new RectF();
        rectF2.set(rectF);
        rectF2.left -= getTouchAreaWidth();
        rectF2.top -= getTouchAreaWidth();
        rectF2.right += getTouchAreaWidth();
        rectF2.bottom += getTouchAreaWidth();
        return rectF2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap bitmap = this.showBitmap;
        if (bitmap == null) {
            return;
        }
        canvas.drawBitmap(bitmap, this.showBitmapMatrix, null);
        canvas.drawPath(this.outsidePath, this.bgPaint);
        canvas.drawPath(this.circleBorderPath, this.circleBorderPaint);
    }

    private int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }

    private int getTouchAreaWidth() {
        return dip2px(getContext(), 10.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public float getCurrentScale() {
        float[] fArr = new float[9];
        this.showBitmapMatrix.getValues(fArr);
        return Math.abs(fArr[0]);
    }

    private void initGesture() {
        this.gestureDetector = new GestureDetector(getContext(), new GestureDetector.SimpleOnGestureListener() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.6
            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnGestureListener
            public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
                if (LikeQQCropView.this.canZoomCircle) {
                    float f3 = Math.abs(f) > Math.abs(f2) ? f : f2;
                    float f4 = LikeQQCropView.this.circleRectF.bottom - LikeQQCropView.this.circleRectF.top;
                    float f5 = (((-f3) * 2.0f) + f4) / f4;
                    LikeQQCropView.this.showBitmapMatrix.postScale(f5, f5, LikeQQCropView.this.centerX, LikeQQCropView.this.centerY);
                    LikeQQCropView.this.showBitmapRectF = new RectF(0.0f, 0.0f, LikeQQCropView.this.showBitmap.getWidth(), LikeQQCropView.this.showBitmap.getHeight());
                    LikeQQCropView.this.showBitmapMatrix.mapRect(LikeQQCropView.this.showBitmapRectF);
                    LikeQQCropView.this.circleRectF = new RectF();
                    RectF rectF = LikeQQCropView.this.circleRectF;
                    LikeQQCropView likeQQCropView = LikeQQCropView.this;
                    rectF.set(likeQQCropView.getCircleRectFByBitmapRectF(likeQQCropView.showBitmapRectF));
                    LikeQQCropView likeQQCropView2 = LikeQQCropView.this;
                    likeQQCropView2.bigCircleRectF = likeQQCropView2.getBigCircleRectF(likeQQCropView2.circleRectF);
                    LikeQQCropView.this.refreshPath();
                    LikeQQCropView.this.invalidate();
                }
                if (!LikeQQCropView.this.canMoveBitmap || LikeQQCropView.this.canZoomCircle) {
                    return true;
                }
                if (f < 0.0f) {
                    float f6 = LikeQQCropView.this.circleRectF.left - LikeQQCropView.this.showBitmapRectF.left;
                    if (f6 < Math.abs(f)) {
                        f = -f6;
                    }
                }
                if (f > 0.0f) {
                    float f7 = LikeQQCropView.this.showBitmapRectF.right - LikeQQCropView.this.circleRectF.right;
                    if (f7 < Math.abs(f)) {
                        f = f7;
                    }
                }
                if (f2 < 0.0f) {
                    float f8 = LikeQQCropView.this.circleRectF.top - LikeQQCropView.this.showBitmapRectF.top;
                    if (f8 < Math.abs(f2)) {
                        f2 = -f8;
                    }
                }
                if (f2 > 0.0f) {
                    float f9 = LikeQQCropView.this.showBitmapRectF.bottom - LikeQQCropView.this.circleRectF.bottom;
                    if (f9 < Math.abs(f2)) {
                        f2 = f9;
                    }
                }
                LikeQQCropView.this.showBitmapRectF = new RectF(0.0f, 0.0f, LikeQQCropView.this.showBitmap.getWidth(), LikeQQCropView.this.showBitmap.getHeight());
                LikeQQCropView.this.showBitmapMatrix.postTranslate(-f, -f2);
                LikeQQCropView.this.showBitmapMatrix.mapRect(LikeQQCropView.this.showBitmapRectF);
                LikeQQCropView.this.invalidate();
                return true;
            }

            @Override // android.view.GestureDetector.SimpleOnGestureListener, android.view.GestureDetector.OnDoubleTapListener
            public boolean onDoubleTapEvent(MotionEvent motionEvent) {
                if (motionEvent.getAction() == 1 && LikeQQCropView.this.showBitmapRectF.contains(motionEvent.getX(), motionEvent.getY())) {
                    if (LikeQQCropView.this.getCurrentScale() > LikeQQCropView.this.initScale) {
                        final SparseArray sparseArray = new SparseArray();
                        sparseArray.put(0, Float.valueOf(-1.0f));
                        sparseArray.put(1, Float.valueOf(-1.0f));
                        LikeQQCropView likeQQCropView = LikeQQCropView.this;
                        likeQQCropView.valueAnimator = ValueAnimator.ofFloat(likeQQCropView.getCurrentScale(), LikeQQCropView.this.initScale);
                        LikeQQCropView.this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.6.1
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float floatValue;
                                float floatValue2;
                                float f;
                                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (((Float) sparseArray.get(0)).floatValue() == -1.0f && ((Float) sparseArray.get(1)).floatValue() == -1.0f) {
                                    sparseArray.put(0, Float.valueOf(floatValue3));
                                    f = 1.0f;
                                } else {
                                    if (((Float) sparseArray.get(1)).floatValue() == -1.0f) {
                                        sparseArray.put(1, Float.valueOf(floatValue3));
                                        floatValue = ((Float) sparseArray.get(1)).floatValue();
                                        floatValue2 = ((Float) sparseArray.get(0)).floatValue();
                                    } else {
                                        SparseArray sparseArray2 = sparseArray;
                                        sparseArray2.put(0, sparseArray2.get(1));
                                        sparseArray.put(1, Float.valueOf(floatValue3));
                                        floatValue = ((Float) sparseArray.get(1)).floatValue();
                                        floatValue2 = ((Float) sparseArray.get(0)).floatValue();
                                    }
                                    f = floatValue / floatValue2;
                                }
                                LikeQQCropView.this.zoomBitmap(f, LikeQQCropView.this.centerX, LikeQQCropView.this.centerX);
                                LikeQQCropView.this.invalidate();
                            }
                        });
                        LikeQQCropView.this.valueAnimator.setInterpolator(new DecelerateInterpolator());
                        LikeQQCropView.this.valueAnimator.setDuration(300L);
                        LikeQQCropView.this.valueAnimator.start();
                    } else {
                        LikeQQCropView.this.doubleClickX = motionEvent.getX();
                        LikeQQCropView.this.doubleClickY = motionEvent.getY();
                        final SparseArray sparseArray2 = new SparseArray();
                        sparseArray2.put(0, Float.valueOf(-1.0f));
                        sparseArray2.put(1, Float.valueOf(-1.0f));
                        LikeQQCropView likeQQCropView2 = LikeQQCropView.this;
                        likeQQCropView2.valueAnimator = ValueAnimator.ofFloat(likeQQCropView2.getCurrentScale(), LikeQQCropView.this.doubleClickScale);
                        LikeQQCropView.this.valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.6.2
                            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
                            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                                float floatValue;
                                float floatValue2;
                                float f;
                                float floatValue3 = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                                if (((Float) sparseArray2.get(0)).floatValue() == -1.0f && ((Float) sparseArray2.get(1)).floatValue() == -1.0f) {
                                    sparseArray2.put(0, Float.valueOf(floatValue3));
                                    f = 1.0f;
                                } else {
                                    if (((Float) sparseArray2.get(1)).floatValue() == -1.0f) {
                                        sparseArray2.put(1, Float.valueOf(floatValue3));
                                        floatValue = ((Float) sparseArray2.get(1)).floatValue();
                                        floatValue2 = ((Float) sparseArray2.get(0)).floatValue();
                                    } else {
                                        SparseArray sparseArray3 = sparseArray2;
                                        sparseArray3.put(0, sparseArray3.get(1));
                                        sparseArray2.put(1, Float.valueOf(floatValue3));
                                        floatValue = ((Float) sparseArray2.get(1)).floatValue();
                                        floatValue2 = ((Float) sparseArray2.get(0)).floatValue();
                                    }
                                    f = floatValue / floatValue2;
                                }
                                LikeQQCropView.this.showBitmapMatrix.postScale(f, f, LikeQQCropView.this.doubleClickX, LikeQQCropView.this.doubleClickY);
                                LikeQQCropView.this.showBitmapRectF = new RectF(0.0f, 0.0f, LikeQQCropView.this.showBitmap.getWidth(), LikeQQCropView.this.showBitmap.getHeight());
                                LikeQQCropView.this.showBitmapMatrix.mapRect(LikeQQCropView.this.showBitmapRectF);
                                LikeQQCropView.this.invalidate();
                            }
                        });
                        LikeQQCropView.this.valueAnimator.setInterpolator(new DecelerateInterpolator());
                        LikeQQCropView.this.valueAnimator.setDuration(300L);
                        LikeQQCropView.this.valueAnimator.start();
                    }
                }
                return super.onDoubleTapEvent(motionEvent);
            }
        });
        this.scaleGestureDetector = new ScaleGestureDetector(getContext(), new ScaleGestureDetector.SimpleOnScaleGestureListener() { // from class: com.ipotensic.baselib.cropbitmap.LikeQQCropView.7
            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScale(ScaleGestureDetector scaleGestureDetector) {
                float currentScale = LikeQQCropView.this.getCurrentScale();
                float scaleFactor = scaleGestureDetector.getScaleFactor();
                if (currentScale * scaleFactor < LikeQQCropView.this.initScale) {
                    scaleFactor = LikeQQCropView.this.initScale / currentScale;
                }
                LikeQQCropView.this.zoomBitmap(scaleFactor, scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
                LikeQQCropView.this.invalidate();
                return true;
            }

            @Override // android.view.ScaleGestureDetector.SimpleOnScaleGestureListener, android.view.ScaleGestureDetector.OnScaleGestureListener
            public boolean onScaleBegin(ScaleGestureDetector scaleGestureDetector) {
                return LikeQQCropView.this.showBitmapRectF.contains(scaleGestureDetector.getFocusX(), scaleGestureDetector.getFocusY());
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void zoomBitmap(float f, float f2, float f3) {
        if (f > 1.0f) {
            float currentScale = getCurrentScale() * f;
            float f4 = this.maxScale;
            if (currentScale > f4) {
                f = f4 / getCurrentScale();
            }
        }
        this.showBitmapMatrix.postScale(f, f, f2, f3);
        RectF rectF = new RectF(0.0f, 0.0f, this.showBitmap.getWidth(), this.showBitmap.getHeight());
        this.showBitmapRectF = rectF;
        this.showBitmapMatrix.mapRect(rectF);
        if (f < 1.0f) {
            float f5 = this.showBitmapRectF.left - this.circleRectF.left;
            if (f5 > 0.0f) {
                this.showBitmapMatrix.postTranslate(-f5, 0.0f);
            }
            float f6 = this.showBitmapRectF.top - this.circleRectF.top;
            if (f6 > 0.0f) {
                this.showBitmapMatrix.postTranslate(0.0f, -f6);
            }
            float f7 = this.circleRectF.right - this.showBitmapRectF.right;
            if (f7 > 0.0f) {
                this.showBitmapMatrix.postTranslate(f7, 0.0f);
            }
            float f8 = this.circleRectF.bottom - this.showBitmapRectF.bottom;
            if (f8 > 0.0f) {
                this.showBitmapMatrix.postTranslate(0.0f, f8);
            }
            RectF rectF2 = new RectF(0.0f, 0.0f, this.showBitmap.getWidth(), this.showBitmap.getHeight());
            this.showBitmapRectF = rectF2;
            this.showBitmapMatrix.mapRect(rectF2);
        }
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (this.showBitmapRectF != null) {
            this.scaleGestureDetector.onTouchEvent(motionEvent);
            this.gestureDetector.onTouchEvent(motionEvent);
            int action = motionEvent.getAction();
            if (action != 0) {
                if (action == 1) {
                    this.canMoveBitmap = false;
                    this.canZoomCircle = false;
                }
            } else if (this.showBitmapRectF.contains(motionEvent.getX(), motionEvent.getY())) {
                this.canMoveBitmap = true;
            }
        }
        return true;
    }

    private void resetBitmap() {
        reset();
    }

    public Bitmap getBitmap() {
        return this.showBitmap;
    }

    @Deprecated
    public LikeQQCropView setBitmap(Bitmap bitmap) {
        this.showBitmap = bitmap;
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmap(int i, int i2, int i3) {
        this.showBitmap = CropViewUtils.compressBitmap(getContext(), i, i2, i3);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmap(String str, int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmap(str, i, i2);
        resetBitmap();
        return this;
    }

    @Deprecated
    public LikeQQCropView setBitmapToRotate(String str, int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmap(str, i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmap(byte[] bArr, int i, int i2, int i3, int i4) {
        this.showBitmap = CropViewUtils.compressBitmap(bArr, i, i2, i3, i4);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmap(FileDescriptor fileDescriptor, Rect rect, int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmap(fileDescriptor, rect, i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmap(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmap(resources, typedValue, inputStream, rect, i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmap(InputStream inputStream, Rect rect, int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmap(inputStream, rect, i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForHeight(int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(getContext(), i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForHeight(String str, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(str, i);
        resetBitmap();
        return this;
    }

    @Deprecated
    public LikeQQCropView setBitmapForHeightToRotate(String str, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(str, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForHeight(byte[] bArr, int i, int i2, int i3) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(bArr, i, i2, i3);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForHeight(FileDescriptor fileDescriptor, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(fileDescriptor, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForHeight(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(resources, typedValue, inputStream, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForHeight(InputStream inputStream, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForHeight(inputStream, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForWidth(int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(getContext(), i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForWidth(String str, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(str, i);
        resetBitmap();
        return this;
    }

    @Deprecated
    public LikeQQCropView setBitmapForWidthToRotate(String str, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(str, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForWidth(byte[] bArr, int i, int i2, int i3) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(bArr, i, i2, i3);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForWidth(FileDescriptor fileDescriptor, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(fileDescriptor, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForWidth(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(resources, typedValue, inputStream, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForWidth(InputStream inputStream, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForWidth(inputStream, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForScale(int i, int i2) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(getContext(), i, i2);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForScale(String str, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(str, i);
        resetBitmap();
        return this;
    }

    @Deprecated
    public LikeQQCropView setBitmapForScaleToRotate(String str, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(str, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForScale(byte[] bArr, int i, int i2, int i3) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(bArr, i, i2, i3);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForScale(FileDescriptor fileDescriptor, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(fileDescriptor, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForScale(Resources resources, TypedValue typedValue, InputStream inputStream, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(resources, typedValue, inputStream, rect, i);
        resetBitmap();
        return this;
    }

    public LikeQQCropView setBitmapForScale(InputStream inputStream, Rect rect, int i) {
        this.showBitmap = CropViewUtils.compressBitmapForScale(inputStream, rect, i);
        resetBitmap();
        return this;
    }

    public Bitmap rotateBitmap(int i, Bitmap bitmap) {
        Matrix matrix = new Matrix();
        matrix.postRotate(i);
        return Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
    }
}
