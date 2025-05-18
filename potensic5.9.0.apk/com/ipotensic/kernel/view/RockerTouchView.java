package com.ipotensic.kernel.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import com.ipotensic.baselib.DDLog;
import com.ipotensic.baselib.utils.ScreenUtils;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class RockerTouchView extends View {
    boolean allDirectionMode;
    private int fullHeight;
    private int fullWidth;
    private float innerCenterX;
    private float innerCenterY;
    private RectF innerDst;
    private Rect innerSrc;
    private boolean isContinue;
    private boolean isLeft;
    boolean keepDeading;
    private Bitmap mDirectionBmp;
    private Paint mInnerPaint;
    private float mInnerRadius;
    private float mOutRadius;
    private Bitmap mOuterBgBitmap;
    private Paint mOuterBgPaint;
    private Paint mOuterPaint;
    private Bitmap mRockerPointBitmap;
    private Paint mRockerPointPaint;
    private RockerViewChangeListener mRockerViewChangeListener;
    private int outCenterX;
    private int outCenterY;
    private RectF outDst;
    private Rect outSrc;
    boolean rockTouchMode;
    private float touchDownX;
    private float touchDownY;
    private Rect validRect;
    private int xPercent;
    private int yPercent;

    public interface RockerViewChangeListener {
        void onPositionChanged(View view, int i, int i2);
    }

    private int getDirection(double d, boolean z) {
        double d2;
        double d3 = 45.0d;
        if (z) {
            if (d < 22.5d || d >= 337.5d) {
                return 8;
            }
            d2 = d + 22.5d;
        } else {
            if (d < 45.0d || d >= 315.0d) {
                return 4;
            }
            d2 = d + 45.0d;
            d3 = 90.0d;
        }
        return (int) (d2 / d3);
    }

    public RockerTouchView(Context context) {
        this(context, null);
    }

    public RockerTouchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.fullWidth = ScreenUtils.getScreenHeight(getContext());
        this.fullHeight = ScreenUtils.getScreenHeight(getContext());
        this.keepDeading = false;
        this.rockTouchMode = false;
        this.allDirectionMode = false;
        this.isContinue = true;
        this.isLeft = false;
        this.mRockerViewChangeListener = null;
        this.validRect = null;
        this.fullWidth = ScreenUtils.getScreenHeight(getContext());
        this.fullHeight = ScreenUtils.getScreenHeight(getContext());
        initPaint();
        initAttribute(context, attributeSet);
        initCircleParams();
    }

    private void initCircleParams() {
        float min = Math.min(Math.min((this.fullWidth / 4) - getPaddingLeft(), (this.fullWidth / 4) - getPaddingRight()), Math.min((this.fullHeight / 4) - getPaddingTop(), (this.fullHeight / 4) - getPaddingBottom()));
        this.mOutRadius = min;
        this.mInnerRadius = min * 0.4f;
        if (this.rockTouchMode) {
            Bitmap decodeResource = BitmapFactory.decodeResource(getResources(), C1965R.mipmap.icon_rocker_direction);
            int i = this.fullWidth;
            float f = this.mInnerRadius;
            this.mDirectionBmp = Bitmap.createScaledBitmap(decodeResource, (int) ((i / 2) + (f * 2.0f)), (int) ((i / 2) + (f * 2.0f)), true);
        }
        this.outSrc = new Rect(0, 0, this.mOuterBgBitmap.getWidth(), this.mOuterBgBitmap.getHeight());
        float f2 = this.touchDownX;
        float f3 = this.mOutRadius;
        float f4 = this.touchDownY;
        this.outDst = new RectF(f2 - f3, f4 - f3, f2 + f3, f4 + f3);
        this.innerSrc = new Rect(0, 0, this.mRockerPointBitmap.getWidth(), this.mRockerPointBitmap.getHeight());
        float f5 = this.innerCenterX;
        float f6 = this.mInnerRadius;
        float f7 = this.innerCenterY;
        this.innerDst = new RectF(f5 - f6, f7 - f6, f5 + f6, f7 + f6);
    }

    private void initPaint() {
        this.mOuterPaint = new Paint();
        this.mInnerPaint = new Paint();
        this.mOuterPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        this.mInnerPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        Paint paint = new Paint();
        this.mOuterBgPaint = paint;
        paint.setAntiAlias(true);
        this.mOuterBgPaint.setFilterBitmap(true);
        Paint paint2 = new Paint();
        this.mRockerPointPaint = paint2;
        paint2.setAntiAlias(true);
        this.mRockerPointPaint.setFilterBitmap(true);
    }

    private void initAttribute(Context context, AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C1965R.styleable.RockerTouchView);
        this.allDirectionMode = obtainStyledAttributes.getBoolean(C1965R.styleable.RockerTouchView_all_direction_mode, false);
        this.rockTouchMode = obtainStyledAttributes.getBoolean(C1965R.styleable.RockerTouchView_rock_touch_mode, false);
        Drawable drawable = obtainStyledAttributes.getDrawable(C1965R.styleable.RockerTouchView_out_circle_background);
        if (drawable != null && (drawable instanceof BitmapDrawable)) {
            this.mOuterBgBitmap = ((BitmapDrawable) drawable).getBitmap();
        }
        Drawable drawable2 = obtainStyledAttributes.getDrawable(C1965R.styleable.RockerTouchView_rocker_point_background);
        if (drawable2 != null && (drawable2 instanceof BitmapDrawable)) {
            this.mRockerPointBitmap = ((BitmapDrawable) drawable2).getBitmap();
        }
        obtainStyledAttributes.recycle();
    }

    public void setOuterBgBitmap(int i) {
        this.mOuterBgBitmap = BitmapFactory.decodeResource(getResources(), i);
        invalidate();
    }

    @Override // android.view.View
    protected void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        setMeasuredDimension(measureWidth(i), measureHeight(i2));
    }

    private int measureWidth(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size + getPaddingLeft() + getPaddingRight();
        }
        if (mode == 0) {
            return this.fullWidth;
        }
        return Math.min(this.fullWidth, size);
    }

    private int measureHeight(int i) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            return size + getPaddingTop() + getPaddingBottom();
        }
        if (mode == 0) {
            return this.fullHeight;
        }
        return Math.min(this.fullHeight, size);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.fullWidth = i;
        this.fullHeight = i2;
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if (this.keepDeading) {
            this.outSrc.set(0, 0, this.mOuterBgBitmap.getWidth(), this.mOuterBgBitmap.getHeight());
            RectF rectF = this.outDst;
            float f = this.touchDownX;
            float f2 = this.mOutRadius;
            float f3 = this.touchDownY;
            rectF.set(f - f2, f3 - f2, f + f2, f3 + f2);
            canvas.drawBitmap(this.mOuterBgBitmap, this.outSrc, this.outDst, this.mOuterBgPaint);
            this.innerSrc.set(0, 0, this.mRockerPointBitmap.getWidth(), this.mRockerPointBitmap.getHeight());
            RectF rectF2 = this.innerDst;
            float f4 = this.innerCenterX;
            float f5 = this.mInnerRadius;
            float f6 = this.innerCenterY;
            rectF2.set(f4 - f5, f6 - f5, f4 + f5, f6 + f5);
            canvas.drawBitmap(this.mRockerPointBitmap, this.innerSrc, this.innerDst, this.mRockerPointPaint);
            if (!this.rockTouchMode || this.mDirectionBmp == null) {
                return;
            }
            float pointsAngleDegree = (float) getPointsAngleDegree(this.touchDownX, this.touchDownY, this.innerCenterX, this.innerCenterY);
            Bitmap bitmap = this.mDirectionBmp;
            float f7 = 180.0f - pointsAngleDegree;
            float f8 = this.touchDownX;
            float f9 = this.mOutRadius;
            float f10 = this.mInnerRadius;
            drawRotateArrow(canvas, bitmap, f7, (f8 - f9) - f10, (this.touchDownY - f9) - f10);
        }
    }

    private void drawRotateArrow(Canvas canvas, Bitmap bitmap, float f, float f2, float f3) {
        Matrix matrix = new Matrix();
        int width = bitmap.getWidth() / 2;
        int height = bitmap.getHeight() / 2;
        matrix.postTranslate(-width, -height);
        matrix.postRotate(f);
        matrix.postTranslate(f2 + width, f3 + height);
        canvas.drawBitmap(bitmap, matrix, null);
    }

    public double getPointsAngleDegree(double d, double d2, double d3, double d4) {
        double asin = (Math.asin(Math.abs(d4 - d2) / getPointsDistant(d, d2, d3, d4)) * 180.0d) / 3.141592653589793d;
        if (d3 < d && d4 < d2) {
            asin = 180.0d - asin;
        } else if (d3 < d && d4 >= d2) {
            asin += 180.0d;
        } else if (d3 >= d && d4 >= d2) {
            asin = 360.0d - asin;
        }
        return asin + 90.0d;
    }

    public double getPointsDistant(double d, double d2, double d3, double d4) {
        return Math.sqrt(Math.pow(d3 - d, 2.0d) + Math.pow(d4 - d2, 2.0d));
    }

    public void setLeft(boolean z) {
        this.isLeft = z;
    }

    /* JADX WARN: Code restructure failed: missing block: B:7:0x000e, code lost:
    
        if (r0 != 3) goto L23;
     */
    @Override // android.view.View
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean dispatchTouchEvent(android.view.MotionEvent r5) {
        /*
            r4 = this;
            int r0 = r5.getAction()
            r1 = 0
            r2 = 1
            if (r0 == 0) goto L31
            if (r0 == r2) goto L1b
            r3 = 2
            if (r0 == r3) goto L11
            r5 = 3
            if (r0 == r5) goto L1b
            goto L75
        L11:
            r4.keepDeading = r2
            boolean r0 = r4.isContinue
            if (r0 == 0) goto L75
            r4.updateMoveStatus(r5)
            goto L75
        L1b:
            r4.keepDeading = r1
            r4.isContinue = r2
            r5 = 0
            r4.innerCenterX = r5
            r4.innerCenterY = r5
            r4.touchDownX = r5
            r4.touchDownY = r5
            r0 = 0
            r4.calPositionChanged(r0, r0)
            r4.invalidate()
            goto L75
        L31:
            r4.keepDeading = r2
            float r0 = r5.getX()
            r4.touchDownX = r0
            r4.innerCenterX = r0
            float r0 = r5.getY()
            r4.touchDownY = r0
            r4.innerCenterY = r0
            float r0 = r5.getX()
            int r0 = (int) r0
            r4.outCenterX = r0
            float r5 = r5.getY()
            int r5 = (int) r5
            r4.outCenterY = r5
            float r5 = r4.touchDownX
            float r0 = r4.touchDownY
            r4.checkTouchDownPoint(r5, r0)
            boolean r5 = r4.isLeft
            if (r5 == 0) goto L73
            android.graphics.Rect r5 = com.ipotensic.baselib.configs.PhoneConfig.smallViewRect
            if (r5 == 0) goto L73
            android.graphics.Rect r5 = com.ipotensic.baselib.configs.PhoneConfig.smallViewRect
            float r0 = r4.touchDownX
            int r0 = (int) r0
            float r3 = r4.touchDownY
            int r3 = (int) r3
            boolean r5 = r5.contains(r0, r3)
            if (r5 == 0) goto L73
            r4.isContinue = r1
            r4.keepDeading = r1
            return r1
        L73:
            r4.isContinue = r2
        L75:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.ipotensic.kernel.view.RockerTouchView.dispatchTouchEvent(android.view.MotionEvent):boolean");
    }

    private void updateMoveStatus(MotionEvent motionEvent) {
        double angle;
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float distance = getDistance(this.touchDownX, this.touchDownY, x, y);
        if (distance < this.mOutRadius - this.mInnerRadius) {
            this.innerCenterX = x;
            this.innerCenterY = y;
            angle = getAngle(x, y, distance, true);
        } else {
            angle = getAngle(x, y, distance, false);
        }
        calPositionChanged(x, y);
        getDirection(angle, this.allDirectionMode);
        invalidate();
    }

    private void calPositionChanged(double d, double d2) {
        int i = (int) (this.mOutRadius - this.mInnerRadius);
        float pointsAngleDegree = ((float) getPointsAngleDegree(this.touchDownX, this.touchDownY, this.innerCenterX, this.innerCenterY)) - 90.0f;
        int i2 = this.outCenterX;
        int i3 = this.outCenterY;
        Rect rect = new Rect(i2 - i, i3 - i, i2 + i, i3 + i);
        this.validRect = rect;
        int i4 = -100;
        if (90.0f < pointsAngleDegree && pointsAngleDegree <= 270.0f) {
            if (rect.contains((int) d, (int) d2)) {
                this.xPercent = (int) (((d - this.outCenterX) * 100.0d) / i);
            } else if (90.0f < pointsAngleDegree && pointsAngleDegree <= 135.0f) {
                double d3 = i;
                this.xPercent = ((int) (((Math.tan(((pointsAngleDegree - 90.0f) * 3.141592653589793d) / 180.0d) * d3) * 100.0d) / d3)) * (-1);
            } else if (225.0f < pointsAngleDegree && pointsAngleDegree <= 270.0f) {
                double d4 = i;
                this.xPercent = ((int) (((Math.tan(((270.0f - pointsAngleDegree) * 3.141592653589793d) / 180.0d) * d4) * 100.0d) / d4)) * (-1);
            } else {
                this.xPercent = -100;
            }
        } else if (rect.contains((int) d, (int) d2)) {
            this.xPercent = (int) (((d - this.outCenterX) * 100.0d) / i);
        } else if (45.0f < pointsAngleDegree && pointsAngleDegree <= 90.0f) {
            double d5 = i;
            this.xPercent = (int) (((Math.tan(((90.0f - pointsAngleDegree) * 3.141592653589793d) / 180.0d) * d5) * 100.0d) / d5);
        } else if (270.0f < pointsAngleDegree && pointsAngleDegree <= 315.0f) {
            double d6 = i;
            this.xPercent = (int) (((Math.tan(((pointsAngleDegree - 270.0f) * 3.141592653589793d) / 180.0d) * d6) * 100.0d) / d6);
        } else {
            this.xPercent = 100;
        }
        if (0.0f < pointsAngleDegree && pointsAngleDegree <= 180.0f) {
            if (this.validRect.contains((int) d, (int) d2)) {
                this.yPercent = ((int) (((d2 - this.outCenterY) * 100.0d) / i)) * (-1);
            } else if (0.0f < pointsAngleDegree && pointsAngleDegree <= 45.0f) {
                double d7 = i;
                this.yPercent = (int) (((Math.tan((pointsAngleDegree * 3.141592653589793d) / 180.0d) * d7) * 100.0d) / d7);
            } else if (135.0f < pointsAngleDegree && pointsAngleDegree <= 180.0f) {
                double d8 = i;
                this.yPercent = (int) (((Math.tan(((180.0f - pointsAngleDegree) * 3.141592653589793d) / 180.0d) * d8) * 100.0d) / d8);
            } else {
                this.yPercent = 100;
            }
        } else if (this.validRect.contains((int) d, (int) d2)) {
            this.yPercent = ((int) (((d2 - this.outCenterY) * 100.0d) / i)) * (-1);
            DDLog.m1684e("contain:" + this.outCenterY);
        } else if (180.0f < pointsAngleDegree && pointsAngleDegree <= 225.0f) {
            double d9 = i;
            this.yPercent = ((int) (((Math.tan(((pointsAngleDegree - 180.0f) * 3.141592653589793d) / 180.0d) * d9) * 100.0d) / d9)) * (-1);
        } else if (315.0f < pointsAngleDegree && pointsAngleDegree <= 360.0f) {
            double d10 = i;
            this.yPercent = ((int) (((Math.tan(((360.0f - pointsAngleDegree) * 3.141592653589793d) / 180.0d) * d10) * 100.0d) / d10)) * (-1);
        } else {
            this.yPercent = -100;
        }
        int i5 = this.xPercent;
        if (i5 > 100) {
            i5 = 100;
        } else if (i5 < -100) {
            i5 = -100;
        }
        this.xPercent = i5;
        int i6 = this.yPercent;
        if (i6 > 100) {
            i4 = 100;
        } else if (i6 >= -100) {
            i4 = i6;
        }
        this.yPercent = i4;
        if (d == 0.0d) {
            this.xPercent = 0;
        }
        if (d2 == 0.0d) {
            this.yPercent = 0;
        }
        RockerViewChangeListener rockerViewChangeListener = this.mRockerViewChangeListener;
        if (rockerViewChangeListener != null) {
            rockerViewChangeListener.onPositionChanged(this, this.xPercent, this.yPercent);
        }
        DDLog.m1684e("X move:" + d);
        DDLog.m1684e("Y move:" + d2);
        DDLog.m1684e("X :" + this.xPercent);
        DDLog.m1684e("Y :" + this.yPercent);
    }

    private double getAngle(float f, float f2, float f3, boolean z) {
        float abs = Math.abs(f - this.touchDownX);
        float abs2 = Math.abs(f2 - this.touchDownY) / f3;
        float f4 = abs / f3;
        float f5 = this.mOutRadius;
        float f6 = this.mInnerRadius;
        float f7 = (f5 - f6) * f4;
        float f8 = (f5 - f6) * abs2;
        double acos = (Math.acos(f4) / 3.141592653589793d) * 180.0d;
        float f9 = this.touchDownX;
        if (f >= f9) {
            float f10 = this.touchDownY;
            if (f2 >= f10) {
                if (!z) {
                    this.innerCenterX = f9 + f7;
                    this.innerCenterY = f10 + f8;
                }
                return (90.0d - acos) + 270.0d;
            }
        }
        if (f < f9) {
            float f11 = this.touchDownY;
            if (f2 >= f11) {
                if (!z) {
                    this.innerCenterX = f9 - f7;
                    this.innerCenterY = f11 + f8;
                }
                return acos + 180.0d;
            }
        }
        if (f >= f9) {
            float f12 = this.touchDownY;
            if (f2 < f12) {
                if (z) {
                    return acos;
                }
                this.innerCenterX = f9 + f7;
                this.innerCenterY = f12 - f8;
                return acos;
            }
        }
        if (!z) {
            this.innerCenterX = f9 - f7;
            this.innerCenterY = this.touchDownY - f8;
        }
        return (90.0d - acos) + 90.0d;
    }

    private void checkTouchDownPoint(float f, float f2) {
        int i = this.fullWidth;
        float f3 = i / 2;
        int i2 = this.fullHeight;
        float f4 = i2 / 2;
        if (f >= f3 && f2 <= f4) {
            float f5 = i - f;
            float f6 = this.mOutRadius;
            if (f5 < f6 || f2 - f6 < 0.0f) {
                return;
            }
            this.keepDeading = false;
            return;
        }
        if (f <= f3 && f2 <= f4) {
            float f7 = this.mOutRadius;
            if (f - f7 < 0.0f || f2 - f7 < 0.0f) {
                return;
            }
            this.keepDeading = false;
            return;
        }
        if (f < f3 && f2 > f4) {
            float f8 = this.mOutRadius;
            if (f - f8 < 0.0f || i2 - f2 < f8) {
                return;
            }
            this.keepDeading = false;
            return;
        }
        float f9 = i - f;
        float f10 = this.mOutRadius;
        if (f9 < f10 || i2 - f2 < f10) {
            return;
        }
        this.keepDeading = false;
    }

    private float getDistance(float f, float f2, float f3, float f4) {
        return (float) Math.sqrt(Math.pow(Math.abs(f3 - f), 2.0d) + Math.pow(Math.abs(f4 - f2), 2.0d));
    }

    public void setRockerViewChangeListener(RockerViewChangeListener rockerViewChangeListener) {
        this.mRockerViewChangeListener = rockerViewChangeListener;
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}