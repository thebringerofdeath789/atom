package com.ipotensic.kernel.view;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import com.ipotensic.kernel.C1965R;

/* loaded from: classes2.dex */
public class GimbalScaleView extends View implements ValueAnimator.AnimatorUpdateListener {
    private static final int interval = 90;
    private int MAX_SCALE;
    private int MIN_SCALE;
    private ValueAnimator animator;
    private Bitmap bgBitmap;
    private int currentScale;
    private int height;
    private boolean isOutRange;
    private long lastUpdateTime;
    private int maxScaleWidth;
    private int midScaleWidth;
    private int minScaleWidth;
    private Paint paint;
    private Rect paintRect;
    private Bitmap scaleBitmap;
    private int scaleBottom;
    private int scaleHeight;
    private int scaleTop;
    private int textSize;
    private Bitmap tipsBitmap;
    private Rect txtBounds;
    private int width;

    public GimbalScaleView(Context context) {
        super(context);
        this.MAX_SCALE = 20;
        this.MIN_SCALE = -90;
        this.currentScale = 0;
        this.paintRect = new Rect();
        this.txtBounds = new Rect();
        this.textSize = -1;
        this.isOutRange = true;
        this.lastUpdateTime = 0L;
    }

    public GimbalScaleView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.MAX_SCALE = 20;
        this.MIN_SCALE = -90;
        this.currentScale = 0;
        this.paintRect = new Rect();
        this.txtBounds = new Rect();
        this.textSize = -1;
        this.isOutRange = true;
        this.lastUpdateTime = 0L;
    }

    public GimbalScaleView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.MAX_SCALE = 20;
        this.MIN_SCALE = -90;
        this.currentScale = 0;
        this.paintRect = new Rect();
        this.txtBounds = new Rect();
        this.textSize = -1;
        this.isOutRange = true;
        this.lastUpdateTime = 0L;
    }

    public GimbalScaleView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.MAX_SCALE = 20;
        this.MIN_SCALE = -90;
        this.currentScale = 0;
        this.paintRect = new Rect();
        this.txtBounds = new Rect();
        this.textSize = -1;
        this.isOutRange = true;
        this.lastUpdateTime = 0L;
    }

    private void init() {
        if (this.paint == null) {
            Paint paint = new Paint();
            this.paint = paint;
            paint.setStyle(Paint.Style.FILL);
            this.paint.setAntiAlias(true);
        }
        if (this.bgBitmap == null) {
            this.bgBitmap = BitmapFactory.decodeResource(getResources(), C1965R.mipmap.img_bg_gimbal_scale);
        }
        if (this.scaleBitmap == null) {
            this.scaleBitmap = BitmapFactory.decodeResource(getResources(), C1965R.mipmap.img_bg_gimbal_scale_current);
        }
        if (this.tipsBitmap == null) {
            this.tipsBitmap = BitmapFactory.decodeResource(getResources(), C1965R.mipmap.img_icon_gimbal_scale_tips);
        }
        this.width = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        this.height = measuredHeight;
        if (this.isOutRange) {
            this.scaleTop = measuredHeight / 6;
            this.scaleBottom = (measuredHeight * 5) / 6;
        } else {
            this.scaleTop = (measuredHeight * 2) / 11;
            this.scaleBottom = (measuredHeight * 9) / 11;
        }
        int i = this.width;
        this.maxScaleWidth = (i * 2) / 3;
        this.midScaleWidth = i / 3;
        this.minScaleWidth = i / 5;
        this.scaleHeight = (this.scaleBottom - this.scaleTop) / (this.MAX_SCALE - this.MIN_SCALE);
    }

    public void setOutRange(boolean z) {
        this.isOutRange = z;
        if (z) {
            this.MAX_SCALE = 20;
            this.MIN_SCALE = -90;
        } else {
            this.MAX_SCALE = 0;
            this.MIN_SCALE = -90;
        }
        postInvalidate();
    }

    public boolean isOutRange() {
        return this.isOutRange;
    }

    public void setCurrentScale(int i) {
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastUpdateTime > 90) {
            this.lastUpdateTime = currentTimeMillis;
            animateValue(i);
        }
    }

    private void animateValue(int i) {
        ValueAnimator ofInt = ValueAnimator.ofInt(this.currentScale, i);
        this.animator = ofInt;
        ofInt.setDuration(90L);
        this.animator.addUpdateListener(this);
        this.animator.start();
    }

    private void updateCurrentScale(int i) {
        if (this.currentScale != i) {
            this.currentScale = i;
            int i2 = this.MAX_SCALE;
            if (i > i2) {
                this.currentScale = i2;
            } else {
                int i3 = this.MIN_SCALE;
                if (i < i3) {
                    this.currentScale = i3;
                }
            }
            postInvalidate();
        }
    }

    @Override // android.animation.ValueAnimator.AnimatorUpdateListener
    public void onAnimationUpdate(ValueAnimator valueAnimator) {
        updateCurrentScale(((Integer) valueAnimator.getAnimatedValue()).intValue());
    }

    @Override // android.view.View
    protected void onVisibilityChanged(View view, int i) {
        ValueAnimator valueAnimator;
        super.onVisibilityChanged(view, i);
        if (i != 8 || (valueAnimator = this.animator) == null) {
            return;
        }
        valueAnimator.cancel();
    }

    @Override // android.view.View
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        init();
        drawBg(canvas);
        drawScale(canvas);
        drawCurrentScale(canvas);
    }

    private void drawBg(Canvas canvas) {
        canvas.drawBitmap(this.bgBitmap, new Rect(0, 0, this.bgBitmap.getWidth(), this.bgBitmap.getHeight()), new Rect(0, 0, this.width, this.height), this.paint);
    }

    private void drawScale(Canvas canvas) {
        this.paint.setColor(-1);
        this.paint.setTextSize(20.0f);
        int i = this.MIN_SCALE;
        while (true) {
            int i2 = this.MAX_SCALE;
            if (i > i2) {
                return;
            }
            if (i == this.MIN_SCALE) {
                this.paintRect.left = this.width - this.maxScaleWidth;
                this.paintRect.top = this.scaleBottom - this.scaleHeight;
                this.paintRect.right = this.width;
                this.paintRect.bottom = this.scaleBottom;
                if (this.currentScale != i) {
                    canvas.drawRect(this.paintRect, this.paint);
                }
                this.paint.getTextBounds("-90°", 0, 4, this.txtBounds);
                canvas.drawText("-90°", (this.width - this.txtBounds.width()) / 1.5f, this.paintRect.bottom + ((this.txtBounds.height() * 4) / 3.0f), this.paint);
            } else if (i == -45) {
                this.paintRect.left = this.width - this.midScaleWidth;
                this.paintRect.top -= this.scaleHeight;
                this.paintRect.right = this.width;
                this.paintRect.bottom -= this.scaleHeight;
                if (this.currentScale != i) {
                    canvas.drawRect(this.paintRect, this.paint);
                }
                this.paint.getTextBounds("-45°", 0, 4, this.txtBounds);
                canvas.drawText("-45°", this.paintRect.left - this.txtBounds.width(), this.paintRect.centerY() + (this.txtBounds.height() / 2.0f), this.paint);
            } else if (this.isOutRange && i == 0) {
                this.paintRect.left = this.width - this.midScaleWidth;
                this.paintRect.top -= this.scaleHeight;
                this.paintRect.right = this.width;
                this.paintRect.bottom -= this.scaleHeight;
                if (this.currentScale != i) {
                    canvas.drawRect(this.paintRect, this.paint);
                }
                this.paint.getTextBounds("0°", 0, 2, this.txtBounds);
                canvas.drawText("0°", this.paintRect.left - this.txtBounds.width(), this.paintRect.centerY() + (this.txtBounds.height() / 2.0f), this.paint);
            } else if (i == i2) {
                this.paintRect.left = this.width - this.maxScaleWidth;
                this.paintRect.top -= this.scaleHeight;
                this.paintRect.right = this.width;
                this.paintRect.bottom -= this.scaleHeight;
                if (this.currentScale != i) {
                    canvas.drawRect(this.paintRect, this.paint);
                }
                String str = this.MAX_SCALE + "°";
                this.paint.getTextBounds(str, 0, str.length(), this.txtBounds);
                canvas.drawText(str, (this.width - this.txtBounds.width()) / 1.5f, this.paintRect.top - ((this.txtBounds.height() * 1.0f) / 3.0f), this.paint);
                canvas.drawBitmap(this.tipsBitmap, this.width / 3.0f, (this.paintRect.top - this.txtBounds.height()) - this.tipsBitmap.getHeight(), this.paint);
            } else {
                this.paintRect.left = this.width - this.minScaleWidth;
                this.paintRect.top -= this.scaleHeight;
                this.paintRect.right = this.width;
                this.paintRect.bottom -= this.scaleHeight;
                if (i % 5 == 0 && this.currentScale != i) {
                    canvas.drawRect(this.paintRect, this.paint);
                }
            }
            i++;
        }
    }

    private void drawCurrentScale(Canvas canvas) {
        this.paint.setColor(-16711936);
        int i = this.scaleBottom;
        int i2 = this.currentScale - this.MIN_SCALE;
        int i3 = this.scaleHeight;
        int i4 = (i - (i2 * i3)) - (i3 / 2);
        canvas.drawBitmap(this.scaleBitmap, new Rect(0, 0, this.scaleBitmap.getWidth(), this.scaleBitmap.getHeight()), new Rect(0, i4 - 20, this.width, i4 + 20), this.paint);
        String str = this.currentScale + "°";
        setTextSize();
        this.paint.getTextBounds(str, 0, str.length(), this.txtBounds);
        canvas.drawText(str, (this.width - 20) - this.txtBounds.width(), i4 + (this.txtBounds.height() / 2), this.paint);
    }

    private void setTextSize() {
        int i = this.textSize;
        if (i == -1) {
            this.textSize = 26;
            this.paint.setTextSize(26);
            this.paint.getTextBounds("-50°", 0, 4, this.txtBounds);
            while (this.txtBounds.width() + 24 > this.width) {
                int i2 = this.textSize - 1;
                this.textSize = i2;
                this.paint.setTextSize(i2);
                this.paint.getTextBounds("-50°", 0, 4, this.txtBounds);
            }
            return;
        }
        this.paint.setTextSize(i);
    }

    public void deInit() {
        try {
            Bitmap bitmap = this.bgBitmap;
            if (bitmap != null && !bitmap.isRecycled()) {
                this.bgBitmap.recycle();
                this.bgBitmap = null;
            }
        } catch (Exception unused) {
        }
        try {
            Bitmap bitmap2 = this.scaleBitmap;
            if (bitmap2 != null && !bitmap2.isRecycled()) {
                this.scaleBitmap.recycle();
                this.scaleBitmap = null;
            }
        } catch (Exception unused2) {
        }
        try {
            Bitmap bitmap3 = this.tipsBitmap;
            if (bitmap3 == null || bitmap3.isRecycled()) {
                return;
            }
            this.tipsBitmap.recycle();
            this.tipsBitmap = null;
        } catch (Exception unused3) {
        }
    }
}