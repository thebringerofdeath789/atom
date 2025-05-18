package com.ipotensic.baselib.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import com.ipotensic.baselib.R;

/* loaded from: classes2.dex */
public class CustomSeekBar extends View {
    private int bgColor;
    private Paint bgPaint;
    private int bitmapHeight;
    private int bitmapWidth;
    private float downX;
    private float downY;
    private boolean isCenter;
    private boolean isInit;
    private boolean isInitSetProgress;
    private boolean isTouch;
    private ISeekBarProgressClickListener listener;
    private int max;
    private float moveX;
    private int paddingSize;
    private int progress;
    private int progressColor;
    private Paint progressPaint;
    private int seekBarSize;
    private int size;
    private int thumbColor;
    private Paint thumbPaint;
    private int thumbSize;
    private int thumbTouchSize;
    private int touchSlop;
    private int viewWidth;

    public interface ISeekBarProgressClickListener {
        void onSeekBarChanged(CustomSeekBar customSeekBar, int i);

        void onSeekBarStart(CustomSeekBar customSeekBar, int i);

        void onSeekBarStop(CustomSeekBar customSeekBar, int i);
    }

    public void setSeekBarProgressClickListener(ISeekBarProgressClickListener iSeekBarProgressClickListener) {
        this.listener = iSeekBarProgressClickListener;
    }

    public CustomSeekBar(Context context) {
        this(context, null);
    }

    public CustomSeekBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CustomSeekBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.max = 100;
        this.progress = 0;
        this.seekBarSize = 10;
        this.paddingSize = 10;
        this.viewWidth = 0;
        this.isInitSetProgress = false;
        this.isInit = true;
        this.thumbColor = -1;
        this.thumbSize = 20;
        this.thumbTouchSize = 30;
        this.isTouch = false;
        this.size = 20;
        this.isCenter = false;
        setWillNotDraw(false);
        this.size = dip2px(context, 8.0f);
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, R.styleable.MyCustomSeekBarView, i, 0);
        this.progress = (int) obtainStyledAttributes.getDimension(R.styleable.MyCustomSeekBarView_MyCustomSeekBarThumbProgress, 0.0f);
        this.seekBarSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MyCustomSeekBarView_MyCustomSeekBarSize, 10);
        this.bgColor = obtainStyledAttributes.getColor(R.styleable.MyCustomSeekBarView_MyCustomSeekBarBgColor, context.getResources().getColor(R.color.color_50_black));
        this.progressColor = obtainStyledAttributes.getColor(R.styleable.MyCustomSeekBarView_MyCustomSeekBarProgressColor, -1);
        this.thumbSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MyCustomSeekBarView_MyCustomSeekBarThumbSize, this.size);
        this.thumbTouchSize = obtainStyledAttributes.getDimensionPixelSize(R.styleable.MyCustomSeekBarView_MyCustomSeekBarThumbTouchSize, this.size) + 3;
        this.thumbColor = obtainStyledAttributes.getColor(R.styleable.MyCustomSeekBarView_MyCustomSeekBarThumbColor, -1);
        obtainStyledAttributes.recycle();
        init(context);
    }

    private void init(Context context) {
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        Paint paint = new Paint();
        this.progressPaint = paint;
        paint.setColor(this.progressColor);
        this.progressPaint.setStyle(Paint.Style.STROKE);
        this.progressPaint.setStrokeCap(Paint.Cap.ROUND);
        this.progressPaint.setStrokeJoin(Paint.Join.ROUND);
        this.progressPaint.setStrokeWidth(this.seekBarSize);
        this.progressPaint.setAntiAlias(true);
        Paint paint2 = new Paint();
        this.bgPaint = paint2;
        paint2.setColor(this.bgColor);
        this.bgPaint.setStyle(Paint.Style.STROKE);
        this.bgPaint.setStrokeCap(Paint.Cap.ROUND);
        this.bgPaint.setStrokeJoin(Paint.Join.ROUND);
        this.bgPaint.setStrokeWidth(this.seekBarSize);
        this.bgPaint.setAntiAlias(true);
        Paint paint3 = new Paint();
        this.thumbPaint = paint3;
        paint3.setColor(this.thumbColor);
        this.thumbPaint.setStyle(Paint.Style.FILL);
        this.thumbPaint.setStrokeCap(Paint.Cap.ROUND);
        this.thumbPaint.setStrokeJoin(Paint.Join.ROUND);
        this.thumbPaint.setStrokeWidth(this.seekBarSize);
        this.thumbPaint.setAntiAlias(true);
    }

    @Override // android.view.View
    protected void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i2, i, i4, i3);
        this.viewWidth = i;
        if (this.isInit) {
            this.isInit = false;
            if (this.isCenter) {
                this.moveX = 0.0f;
            } else {
                this.moveX = i / 2;
            }
        }
        if (this.isInitSetProgress) {
            setProgress(this.progress);
        }
    }

    @Override // android.view.View
    protected synchronized void onMeasure(int i, int i2) {
        super.onMeasure(i2, i);
        setMeasuredDimension(resolveSize(dip2px(getContext(), 200.0f), i), dip2px(getContext(), 25.0f));
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        float height = getHeight() / 2;
        canvas.save();
        canvas.drawLine(getPaddingLeft() + 0 + this.paddingSize, height, (this.viewWidth - getPaddingRight()) - this.paddingSize, height, this.bgPaint);
        if (!this.isCenter) {
            float f = this.moveX;
            canvas.drawLine(getPaddingLeft() + this.paddingSize, height, f, height, this.progressPaint);
            if (this.isTouch) {
                canvas.drawCircle(f, height, this.thumbTouchSize, this.thumbPaint);
            } else {
                canvas.drawCircle(f, height, this.thumbSize, this.thumbPaint);
            }
        } else {
            canvas.drawLine(this.viewWidth / 2, height, this.moveX, height, this.progressPaint);
            if (this.isTouch) {
                canvas.drawCircle(this.moveX, height - (this.bitmapHeight / 2), this.thumbTouchSize, this.thumbPaint);
            } else {
                canvas.drawCircle(this.moveX, height - (this.bitmapHeight / 2), this.thumbSize, this.thumbPaint);
            }
        }
        canvas.restore();
    }

    @Override // android.view.View
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        try {
            getParent().requestDisallowInterceptTouchEvent(true);
        } catch (Exception unused) {
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    @Override // android.view.View
    public boolean onTouchEvent(MotionEvent motionEvent) {
        int action = motionEvent.getAction();
        if (action == 0) {
            getParent().requestDisallowInterceptTouchEvent(true);
            this.isTouch = true;
            this.downX = motionEvent.getX();
            this.downY = motionEvent.getY();
            this.moveX = motionEvent.getX();
            if (!this.isCenter) {
                calculationProgressLeft();
            } else {
                calculationProgress();
            }
            ISeekBarProgressClickListener iSeekBarProgressClickListener = this.listener;
            if (iSeekBarProgressClickListener != null) {
                iSeekBarProgressClickListener.onSeekBarStart(this, this.progress);
            }
        } else if (action == 1) {
            this.isTouch = false;
            this.moveX = motionEvent.getX();
            if (!this.isCenter) {
                calculationProgressLeft();
            } else {
                calculationProgress();
            }
            ISeekBarProgressClickListener iSeekBarProgressClickListener2 = this.listener;
            if (iSeekBarProgressClickListener2 != null) {
                iSeekBarProgressClickListener2.onSeekBarChanged(this, this.progress);
                this.listener.onSeekBarStop(this, this.progress);
            }
        } else if (action == 2) {
            this.isTouch = true;
            float x = motionEvent.getX() - this.downX;
            float y = motionEvent.getY() - this.downY;
            if (Math.abs(x) > this.touchSlop || Math.abs(y) > this.touchSlop) {
                this.moveX = motionEvent.getX();
                if (!this.isCenter) {
                    calculationProgressLeft();
                } else {
                    calculationProgress();
                }
                ISeekBarProgressClickListener iSeekBarProgressClickListener3 = this.listener;
                if (iSeekBarProgressClickListener3 != null) {
                    iSeekBarProgressClickListener3.onSeekBarChanged(this, this.progress);
                }
            }
        }
        invalidate();
        return true;
    }

    private void calculationProgress() {
        int width = getWidth() / 2;
        float width2 = (getWidth() - this.paddingSize) - getPaddingLeft();
        if (this.moveX > width2) {
            this.moveX = width2;
        }
        float f = this.moveX;
        int i = this.paddingSize;
        if (f < i) {
            this.moveX = i;
        }
        float f2 = this.moveX;
        float f3 = width;
        if (f2 >= f3) {
            this.progress = (int) (this.max * ((f2 - f3) / (r1 - width)));
        } else {
            float f4 = width - i;
            this.progress = (int) (this.max * (((f2 - i) - f4) / f4));
        }
        int i2 = this.progress;
        int i3 = this.max;
        if (i2 > i3) {
            this.progress = i3;
        }
        if (this.progress < (-i3)) {
            this.progress = -i3;
        }
    }

    private void calculationProgressLeft() {
        float width = (getWidth() - this.paddingSize) - getPaddingLeft();
        if (this.moveX >= width) {
            this.moveX = width;
        }
        float f = this.moveX;
        int i = this.paddingSize;
        if (f <= i) {
            this.moveX = i;
        }
        this.progress = (int) (((this.moveX - i) / (r0 - i)) * this.max);
    }

    public int getMax() {
        return this.max;
    }

    public void setMax(int i) {
        this.max = i;
        invalidate();
    }

    public float getProgress() {
        return this.progress;
    }

    public void setProgress(int i) {
        this.progress = i;
        int i2 = this.viewWidth;
        if (i2 != 0) {
            if (!this.isCenter) {
                int paddingLeft = (i2 - this.paddingSize) - getPaddingLeft();
                int i3 = this.paddingSize;
                this.moveX = ((i * (paddingLeft - i3)) / this.max) + i3;
            } else {
                int i4 = i2 / 2;
                int paddingLeft2 = (i2 - this.paddingSize) - getPaddingLeft();
                if (this.progress >= 0) {
                    this.moveX = ((i * (paddingLeft2 - i4)) / this.max) + i4;
                } else {
                    int i5 = this.paddingSize;
                    float f = i4 - i5;
                    this.moveX = (((i * 1.0f) / this.max) * f) + f + i5;
                }
            }
            this.isInitSetProgress = false;
        } else {
            this.isInitSetProgress = true;
        }
        invalidate();
    }

    public int getBgColor() {
        return this.bgColor;
    }

    public void setBgColor(int i) {
        this.bgColor = i;
        this.bgPaint.setColor(i);
        invalidate();
    }

    public int get() {
        return this.thumbColor;
    }

    public void setThumbColor(int i) {
        this.thumbColor = i;
        this.thumbPaint.setColor(i);
        invalidate();
    }

    public int getProgressColor() {
        return this.progressColor;
    }

    public void setProgressColor(int i) {
        this.progressColor = i;
        this.progressPaint.setColor(i);
        invalidate();
    }

    public int getSeekBarSize() {
        return this.seekBarSize;
    }

    public void setSeekBarSize(int i) {
        this.seekBarSize = i;
    }

    public boolean isCenter() {
        return this.isCenter;
    }

    public void setCenter(boolean z) {
        this.isCenter = z;
    }

    public int dip2px(Context context, float f) {
        return (int) ((f * context.getResources().getDisplayMetrics().density) + 0.5f);
    }
}